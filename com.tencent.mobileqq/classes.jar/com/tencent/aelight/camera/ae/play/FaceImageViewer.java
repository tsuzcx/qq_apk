package com.tencent.aelight.camera.ae.play;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.util.api.IPicChooseJumpUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.ttpic.videoshelf.ImagePositonManager;
import com.tencent.ttpic.videoshelf.model.edit.NodeItem;
import java.lang.reflect.Field;

public class FaceImageViewer
  extends ImageView
  implements View.OnClickListener, View.OnTouchListener
{
  private static final float ADD_ICON_WIDTH = 68.0F;
  private static final float CENTER_VIEW_WIDTH = 720.0F;
  private static final String TAG = "FaceImageViewer";
  private final int COMBINED_ACTION_PROTECT_DURATION = 300;
  private final int DRAG = 1;
  private final int MAX_SINGLE_CLICK_DURATION = 100;
  private final int MIN_MOVE_EVENT_COUNT_IN_COMBINED_ACTION = 5;
  private final int NONE = 0;
  private final int ZOOM = 2;
  private long actionDownTime;
  private long combinedActionProtectExpireAt;
  private float currentX;
  private float currentY;
  private Matrix initMatrix = new Matrix();
  private boolean isAnimationPlaying = false;
  private boolean isCombinedAction = false;
  private boolean isFirstDraw = true;
  private boolean isImageSelected = false;
  private FaceImageViewer.OnSaveScrollInfoListener listener;
  private Activity mActivity;
  private LayerDrawable mAnimationDrawable;
  private Drawable mAnimationSolidDrawable;
  private float mBaseDistance = 0.0F;
  private int mCenterViewWidth = 0;
  private Matrix mCurrentMatrix = new Matrix();
  private boolean mIsSelecting = false;
  private float mLastRotation = 0.0F;
  private boolean mMovable = false;
  private NodeItem mNodeItem = new NodeItem();
  private boolean mSigleDown = true;
  private ValueAnimator mValueAnimator;
  private int mode = 0;
  private int moveEventCount = 0;
  private int prePointerCount;
  private float preX;
  private float preY;
  private float touchDownX;
  private float touchDownY;
  private float touchUpX;
  private float touchUpY;
  private float[] values = new float[9];
  
  public FaceImageViewer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FaceImageViewer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setScaleType(ImageView.ScaleType.MATRIX);
    this.mActivity = ((Activity)paramContext);
    setOnClickListener(this);
    clearSeclected();
    this.mAnimationDrawable = ((LayerDrawable)getResources().getDrawable(2063925336));
    this.mAnimationSolidDrawable = this.mAnimationDrawable.findDrawableByLayerId(2063991136);
  }
  
  private float calcRotation(MotionEvent paramMotionEvent)
  {
    double d = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
    return (float)Math.toDegrees(Math.atan2(paramMotionEvent.getY(0) - paramMotionEvent.getY(1), d));
  }
  
  private void drawAnimationIfNeed(Canvas paramCanvas)
  {
    if (!this.isAnimationPlaying) {
      return;
    }
    this.mAnimationDrawable.setBounds(0, 0, getWidth(), getHeight());
    this.mAnimationDrawable.draw(paramCanvas);
  }
  
  private float getScale()
  {
    this.mCurrentMatrix.getValues(this.values);
    float[] arrayOfFloat = this.values;
    return Math.min(arrayOfFloat[0], arrayOfFloat[4]);
  }
  
  private void onTouchScaleAndRotate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.mCurrentMatrix.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
    ImagePositonManager.setShowPosition(getDrawable(), this.mCurrentMatrix, getWidth(), getHeight());
    this.mCurrentMatrix.postRotate(paramFloat4, getWidth() / 2, getHeight() / 2);
    setImageMatrix(this.mCurrentMatrix);
    updateCurrentMatrix();
  }
  
  private void operateMoveEvent(MotionEvent paramMotionEvent)
  {
    int i = this.mode;
    float f1;
    float f2;
    float f3;
    float f4;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      f1 = (paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2.0F;
      f2 = (paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F;
      f3 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
      f4 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
      f4 = (float)Math.sqrt(f3 * f3 + f4 * f4);
      f3 = this.mBaseDistance;
      if (f3 == 0.0F)
      {
        this.mBaseDistance = f4;
        return;
      }
      if (Math.abs(f4 - f3) >= 1.0F)
      {
        f3 = f4 / this.mBaseDistance;
        this.mBaseDistance = f4;
        f4 = calcRotation(paramMotionEvent);
        float f5 = this.mLastRotation;
        this.mLastRotation = calcRotation(paramMotionEvent);
        onTouchScaleAndRotate(f3, f1, f2, f4 - f5);
      }
    }
    else
    {
      f1 = this.currentX;
      f2 = this.preX;
      f3 = this.currentY;
      f4 = this.preY;
      ImagePositonManager.setMovePosition(getDrawable(), this.mCurrentMatrix, f1 - f2, f3 - f4, getWidth(), getHeight());
      setImageMatrix(this.mCurrentMatrix);
      updateCurrentMatrix();
      this.preX = this.currentX;
      this.preY = this.currentY;
    }
  }
  
  private void updateCurrentMatrix()
  {
    NodeItem localNodeItem = this.mNodeItem;
    if ((localNodeItem != null) && (localNodeItem.matrix != null)) {
      this.mNodeItem.matrix.set(this.mCurrentMatrix);
    }
  }
  
  public void activeSelected()
  {
    this.mIsSelecting = true;
  }
  
  public void clearBitmaps()
  {
    if ((this.mNodeItem.bitmap != null) && (!this.mNodeItem.bitmap.isRecycled())) {
      this.mNodeItem.bitmap.recycle();
    }
    if ((this.mNodeItem.cropBitmap != null) && (!this.mNodeItem.cropBitmap.isRecycled())) {
      this.mNodeItem.cropBitmap.recycle();
    }
    setImageBitmap(null);
  }
  
  public void clearSeclected()
  {
    this.mIsSelecting = false;
  }
  
  public NodeItem getNode()
  {
    return this.mNodeItem;
  }
  
  public int getNodeGroupID()
  {
    return this.mNodeItem.nodeGroupID;
  }
  
  public int getNodeID()
  {
    return this.mNodeItem.nodeID;
  }
  
  public boolean isImageSelected()
  {
    return this.isImageSelected;
  }
  
  public void onClick(View paramView)
  {
    if (this.mIsSelecting) {
      return;
    }
    activeSelected();
    AEBaseDataReporter.a().p();
    ((IPicChooseJumpUtil)QRoute.api(IPicChooseJumpUtil.class)).jumpWithSinglePicResult(this.mActivity, this.mNodeItem.nodeID);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.mNodeItem.once)
    {
      updateMatrix(getWidth(), getHeight());
    }
    else
    {
      this.mCurrentMatrix.set(this.mNodeItem.matrix);
      setImageMatrix(this.mCurrentMatrix);
    }
    try
    {
      super.onDraw(paramCanvas);
      drawAnimationIfNeed(paramCanvas);
      return;
    }
    catch (Throwable paramCanvas) {}
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.currentX = 0.0F;
    this.currentY = 0.0F;
    int j = paramMotionEvent.getPointerCount();
    int i = 0;
    while (i < j)
    {
      this.currentX += paramMotionEvent.getX();
      this.currentY += paramMotionEvent.getY();
      i += 1;
    }
    float f1 = this.currentX;
    float f2 = j;
    this.currentX = (f1 / f2);
    this.currentY /= f2;
    if (j != this.prePointerCount)
    {
      this.preX = this.currentX;
      this.preY = this.currentY;
      this.prePointerCount = j;
    }
    i = paramMotionEvent.getAction() & 0xFF;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 5)
          {
            if (i != 6) {
              return true;
            }
            this.mode = 0;
            return true;
          }
          this.mSigleDown = false;
          this.mLastRotation = calcRotation(paramMotionEvent);
          this.isCombinedAction = true;
          this.mode = 2;
          return true;
        }
        operateMoveEvent(paramMotionEvent);
        this.moveEventCount += 1;
        return true;
      }
      long l1 = System.currentTimeMillis();
      long l2 = this.actionDownTime;
      if (this.moveEventCount > 5) {
        this.isCombinedAction = true;
      }
      if (this.isCombinedAction) {
        this.combinedActionProtectExpireAt = (l1 + 300L);
      } else if (l1 <= this.combinedActionProtectExpireAt) {
        this.mSigleDown = false;
      }
      this.touchUpX = paramMotionEvent.getRawX();
      this.touchUpY = paramMotionEvent.getRawY();
      this.prePointerCount = 0;
      if ((Math.abs(this.touchUpX - this.touchDownX) <= 10.0F) && (Math.abs(this.touchDownY - this.touchUpY) <= 10.0F))
      {
        if ((this.mSigleDown) && (l1 - l2 < 100L)) {
          try
          {
            paramMotionEvent = View.class.getDeclaredField("mListenerInfo");
            paramMotionEvent.setAccessible(true);
            paramMotionEvent = paramMotionEvent.get(paramView);
            Field localField = paramMotionEvent.getClass().getDeclaredField("mOnClickListener");
            localField.setAccessible(true);
            paramMotionEvent = localField.get(paramMotionEvent);
            if ((paramMotionEvent == null) || (!(paramMotionEvent instanceof View.OnClickListener))) {
              break label498;
            }
            ((View.OnClickListener)paramMotionEvent).onClick(paramView);
            return true;
          }
          catch (Exception paramView)
          {
            paramView.printStackTrace();
            return true;
          }
        }
      }
      else
      {
        paramView = this.listener;
        if (paramView != null)
        {
          paramView.onSaveScrollInfo(this.mNodeItem);
          return true;
        }
      }
    }
    else
    {
      this.actionDownTime = System.currentTimeMillis();
      this.touchDownX = paramMotionEvent.getRawX();
      this.touchDownY = paramMotionEvent.getRawY();
      this.mSigleDown = true;
      this.isCombinedAction = false;
      this.moveEventCount = 0;
      this.mBaseDistance = 0.0F;
      this.mode = 1;
    }
    label498:
    return true;
  }
  
  public void setImageSelected(boolean paramBoolean)
  {
    this.isImageSelected = paramBoolean;
  }
  
  public void setMovable(boolean paramBoolean)
  {
    this.mMovable = paramBoolean;
    if (this.mMovable)
    {
      setOnTouchListener(this);
      return;
    }
    setOnTouchListener(null);
  }
  
  public void setNodeBitmap(Bitmap paramBitmap)
  {
    NodeItem localNodeItem = this.mNodeItem;
    localNodeItem.bitmap = paramBitmap;
    localNodeItem.once = true;
    paramBitmap = this.listener;
    if (paramBitmap != null) {
      paramBitmap.onSaveScrollInfo(localNodeItem);
    }
  }
  
  public void setNodeInfo(NodeItem paramNodeItem)
  {
    this.mNodeItem.nodeID = paramNodeItem.nodeID;
    this.mNodeItem.nodeGroupID = paramNodeItem.nodeGroupID;
    this.mNodeItem.once = paramNodeItem.once;
    this.mNodeItem.matrix.set(paramNodeItem.matrix);
    this.mNodeItem.bitmap = paramNodeItem.bitmap;
    this.mNodeItem.maskRect = paramNodeItem.maskRect;
    this.mNodeItem.zIndex = paramNodeItem.zIndex;
  }
  
  public void setOnSaveScrollInfoListener(FaceImageViewer.OnSaveScrollInfoListener paramOnSaveScrollInfoListener)
  {
    this.listener = paramOnSaveScrollInfoListener;
  }
  
  public void startAnimaterIfNeed()
  {
    if (this.mValueAnimator == null)
    {
      this.mValueAnimator = ValueAnimator.ofInt(new int[] { 150, 0 });
      this.mValueAnimator.setDuration(700L);
      this.mValueAnimator.setRepeatCount(4);
      this.mValueAnimator.setInterpolator(new DecelerateInterpolator());
      this.mValueAnimator.setRepeatMode(2);
      this.mValueAnimator.addUpdateListener(new FaceImageViewer.1(this));
      this.mValueAnimator.addListener(new FaceImageViewer.2(this));
    }
    if (this.mValueAnimator.isRunning()) {
      this.mValueAnimator.cancel();
    }
    this.mValueAnimator.start();
  }
  
  public void transformCurrentMatrix(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.initMatrix.reset();
    this.mCurrentMatrix.set(this.initMatrix);
    this.mCurrentMatrix.postTranslate(paramFloat3, paramFloat4);
    this.mCurrentMatrix.postScale(paramFloat1, paramFloat1, getWidth() / 2, getHeight() / 2);
    this.mCurrentMatrix.postRotate(paramFloat2, getWidth() / 2, getHeight() / 2);
    setImageMatrix(this.mCurrentMatrix);
    updateCurrentMatrix();
    this.mNodeItem.once = false;
  }
  
  public void updateCropBitmap()
  {
    Object localObject = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
    draw(new Canvas((Bitmap)localObject));
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      this.mNodeItem.cropBitmap = Bitmap.createBitmap((Bitmap)localObject, 0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      ((Bitmap)localObject).recycle();
    }
    localObject = this.listener;
    if (localObject != null) {
      ((FaceImageViewer.OnSaveScrollInfoListener)localObject).onSaveScrollInfo(this.mNodeItem);
    }
  }
  
  public void updateMatrix(int paramInt1, int paramInt2)
  {
    this.initMatrix.reset();
    this.mCurrentMatrix.set(this.initMatrix);
    Object localObject = this.mNodeItem;
    if (localObject != null) {
      ((NodeItem)localObject).once = false;
    }
    int k = 720;
    int m = 1280;
    localObject = getDrawable();
    int j;
    int i;
    if (localObject != null)
    {
      j = ((Drawable)localObject).getIntrinsicWidth();
      i = ((Drawable)localObject).getIntrinsicHeight();
    }
    else
    {
      localObject = this.mNodeItem;
      j = k;
      i = m;
      if (localObject != null)
      {
        j = k;
        i = m;
        if (((NodeItem)localObject).bitmap != null)
        {
          j = this.mNodeItem.bitmap.getWidth();
          i = this.mNodeItem.bitmap.getHeight();
        }
      }
    }
    float f1 = Math.max(paramInt1 * 1.0F / j, paramInt2 * 1.0F / i);
    localObject = this.mCurrentMatrix;
    paramInt1 /= 2;
    float f2 = paramInt1 - j / 2;
    paramInt2 /= 2;
    ((Matrix)localObject).postTranslate(f2, paramInt2 - i / 2);
    this.mCurrentMatrix.postScale(f1, f1, paramInt1, paramInt2);
    setImageMatrix(this.mCurrentMatrix);
    updateCurrentMatrix();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.FaceImageViewer
 * JD-Core Version:    0.7.0.1
 */