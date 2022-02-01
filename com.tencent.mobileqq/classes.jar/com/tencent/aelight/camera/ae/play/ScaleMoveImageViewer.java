package com.tencent.aelight.camera.ae.play;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
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

public class ScaleMoveImageViewer
  extends ImageView
  implements View.OnClickListener, View.OnTouchListener
{
  private static final float MAX_SCALE = 4.0F;
  private static final float MIN_SCALE = 0.2F;
  private static final String TAG = "ScaleMoveImageViewer";
  private float SOURCE_SCALE;
  private float currentX;
  private float currentY;
  private Matrix initMatrix = new Matrix();
  private boolean isAnimationPlaying = false;
  private boolean isImageSelected = false;
  private ScaleMoveImageViewer.OnSaveScrollInfoListener listener;
  private Activity mActivity;
  private LayerDrawable mAnimationDrawable;
  private Drawable mAnimationSolidDrawable;
  private float mBaseDistance = 0.0F;
  private Matrix mCurrentMatrix = new Matrix();
  private boolean mIsSelecting = false;
  private Matrix mLastGestureMatrix = new Matrix();
  private Drawable mMaskCoverImage;
  private boolean mMovable = false;
  private NodeItem mNodeItem = new NodeItem();
  private boolean mSigleDown = true;
  private ValueAnimator mValueAnimator;
  private int prePointerCount;
  private float preX;
  private float preY;
  private float touchDownX;
  private float touchDownY;
  private float touchUpX;
  private float touchUpY;
  private float[] values = new float[9];
  
  public ScaleMoveImageViewer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ScaleMoveImageViewer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setScaleType(ImageView.ScaleType.MATRIX);
    this.mActivity = ((Activity)paramContext);
    setOnClickListener(this);
    clearSeclected();
    this.mAnimationDrawable = ((LayerDrawable)getResources().getDrawable(2064056377));
    this.mAnimationSolidDrawable = this.mAnimationDrawable.findDrawableByLayerId(2064122261);
    this.mMaskCoverImage = getResources().getDrawable(2064056385);
  }
  
  private void drawAnimationIfNeed(Canvas paramCanvas)
  {
    if (!this.isAnimationPlaying) {
      return;
    }
    this.mAnimationDrawable.setBounds(0, 0, getWidth(), getHeight());
    this.mAnimationDrawable.draw(paramCanvas);
  }
  
  private void drawCoverImage(Canvas paramCanvas)
  {
    Drawable localDrawable = this.mMaskCoverImage;
    if (localDrawable != null)
    {
      localDrawable.setBounds(0, getHeight() / 2, getWidth(), getHeight());
      this.mMaskCoverImage.draw(paramCanvas);
    }
  }
  
  private float getScale()
  {
    this.mCurrentMatrix.getValues(this.values);
    float[] arrayOfFloat = this.values;
    return Math.min(arrayOfFloat[0], arrayOfFloat[4]);
  }
  
  private void onTouchScale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f = getScale();
    if (((f > 4.0F) && (paramFloat1 < 1.0F)) || ((f < 0.2F) && (paramFloat1 > 1.0F)) || ((paramFloat1 < 4.0F) && (paramFloat1 > 0.2F))) {
      this.mCurrentMatrix.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
    }
    if (getScale() < this.SOURCE_SCALE) {
      this.mCurrentMatrix.set(this.mLastGestureMatrix);
    }
    ImagePositonManager.setShowPosition(getDrawable(), this.mCurrentMatrix, getWidth(), getHeight());
    setImageMatrix(this.mCurrentMatrix);
    updateCurrentMatrix();
    this.mLastGestureMatrix.set(this.mCurrentMatrix);
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
    AEBaseDataReporter.a().o();
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
      drawCoverImage(paramCanvas);
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
    i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 5) {
            return true;
          }
          this.mSigleDown = false;
          return true;
        }
        f1 = this.currentX;
        f2 = this.preX;
        float f3 = this.currentY;
        float f4 = this.preY;
        ImagePositonManager.setMovePosition(getDrawable(), this.mCurrentMatrix, f1 - f2, f3 - f4, getWidth(), getHeight());
        setImageMatrix(this.mCurrentMatrix);
        updateCurrentMatrix();
        this.preX = this.currentX;
        this.preY = this.currentY;
        if (paramMotionEvent.getPointerCount() == 2)
        {
          f1 = (paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2.0F;
          f2 = (paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F;
          f3 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
          f4 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
          f3 = (float)Math.sqrt(f3 * f3 + f4 * f4);
          f4 = this.mBaseDistance;
          if (f4 == 0.0F)
          {
            this.mBaseDistance = f3;
            return true;
          }
          if (Math.abs(f3 - f4) >= 10.0F)
          {
            f4 = f3 / this.mBaseDistance;
            this.mBaseDistance = f3;
            onTouchScale(f4, f1, f2);
            return true;
          }
        }
      }
      else
      {
        this.touchUpX = paramMotionEvent.getRawX();
        this.touchUpY = paramMotionEvent.getRawY();
        this.prePointerCount = 0;
        if ((Math.abs(this.touchUpX - this.touchDownX) <= 10.0F) && (Math.abs(this.touchDownY - this.touchUpY) <= 10.0F))
        {
          if (this.mSigleDown) {
            try
            {
              paramMotionEvent = View.class.getDeclaredField("mListenerInfo");
              paramMotionEvent.setAccessible(true);
              paramMotionEvent = paramMotionEvent.get(paramView);
              Field localField = paramMotionEvent.getClass().getDeclaredField("mOnClickListener");
              localField.setAccessible(true);
              paramMotionEvent = localField.get(paramMotionEvent);
              if ((paramMotionEvent == null) || (!(paramMotionEvent instanceof View.OnClickListener))) {
                break label573;
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
    }
    else
    {
      this.touchDownX = paramMotionEvent.getRawX();
      this.touchDownY = paramMotionEvent.getRawY();
      this.mSigleDown = true;
      this.mBaseDistance = 0.0F;
    }
    label573:
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
    this.mNodeItem.type = paramNodeItem.type;
  }
  
  public void setOnSaveScrollInfoListener(ScaleMoveImageViewer.OnSaveScrollInfoListener paramOnSaveScrollInfoListener)
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
      this.mValueAnimator.addUpdateListener(new ScaleMoveImageViewer.1(this));
      this.mValueAnimator.addListener(new ScaleMoveImageViewer.2(this));
    }
    if (this.mValueAnimator.isRunning()) {
      this.mValueAnimator.cancel();
    }
    this.mValueAnimator.start();
  }
  
  public void updateCropBitmap()
  {
    this.mNodeItem.matrix.getValues(this.values);
    float f = 0;
    Object localObject = this.values;
    int i = (int)((int)(f - localObject[2]) / localObject[0]);
    int j = (int)((int)(f - localObject[5]) / localObject[4]);
    int k = (int)(getWidth() / this.values[0]);
    int m = (int)(getHeight() / this.values[4]);
    if ((k > 0) && (m > 0) && (i >= 0) && (j >= 0))
    {
      if ((this.mNodeItem.cropBitmap != null) && (!this.mNodeItem.cropBitmap.isRecycled()) && (this.mNodeItem.bitmap != this.mNodeItem.cropBitmap)) {
        this.mNodeItem.cropBitmap.recycle();
      }
      if ((this.mNodeItem.bitmap == null) || (this.mNodeItem.bitmap.isRecycled())) {}
    }
    try
    {
      this.mNodeItem.cropBitmap = Bitmap.createBitmap(this.mNodeItem.bitmap, i, j, k, m);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label222;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label203:
      break label203;
    }
    localObject = this.mNodeItem;
    ((NodeItem)localObject).cropBitmap = ((NodeItem)localObject).bitmap;
    break label238;
    label222:
    localObject = this.mNodeItem;
    ((NodeItem)localObject).cropBitmap = ((NodeItem)localObject).bitmap;
    label238:
    localObject = this.listener;
    if (localObject != null) {
      ((ScaleMoveImageViewer.OnSaveScrollInfoListener)localObject).onSaveScrollInfo(this.mNodeItem);
    }
    return;
    if ((this.mNodeItem.cropBitmap != null) && (!this.mNodeItem.cropBitmap.isRecycled())) {
      this.mNodeItem.cropBitmap.recycle();
    }
    if (this.mNodeItem.bitmap != null)
    {
      localObject = this.mNodeItem;
      ((NodeItem)localObject).cropBitmap = Bitmap.createBitmap(((NodeItem)localObject).bitmap, 0, 0, this.mNodeItem.bitmap.getWidth() - 1, this.mNodeItem.bitmap.getHeight() - 1);
    }
    localObject = this.listener;
    if (localObject != null) {
      ((ScaleMoveImageViewer.OnSaveScrollInfoListener)localObject).onSaveScrollInfo(this.mNodeItem);
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
    this.SOURCE_SCALE = f1;
    localObject = this.mCurrentMatrix;
    paramInt1 /= 2;
    float f2 = paramInt1 - j / 2;
    paramInt2 /= 2;
    ((Matrix)localObject).postTranslate(f2, paramInt2 - i / 2);
    this.mCurrentMatrix.postScale(f1, f1, paramInt1, paramInt2);
    setImageMatrix(this.mCurrentMatrix);
    this.mLastGestureMatrix.set(this.mCurrentMatrix);
    updateCurrentMatrix();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.ScaleMoveImageViewer
 * JD-Core Version:    0.7.0.1
 */