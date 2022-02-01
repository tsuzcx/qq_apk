package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class TopGestureLayout
  extends RelativeLayout
{
  public static final int FLAG_GESTURE_END = -1;
  public static final int FLAG_GESTURE_FLINE_RL = 2;
  public static final int FLAG_GESTURE_FLING_LR = 1;
  public static final int FLAG_GESTURE_IDLE = 0;
  public static final String TAG = "TopGestureLayout";
  public GestureDetector defaultGestureDetector;
  protected GestureDetector.SimpleOnGestureListener gestureListener;
  private boolean isInLayout = false;
  private int mGestureFlag;
  private boolean mInterceptScrollLR = true;
  private boolean mInterceptScrollRL = false;
  TopGestureLayout.InterceptTouchEventListener mInterceptTouchEventListener;
  private boolean mInterceptTouchFlag = true;
  private boolean mIsInterceptChildEventWhenScroll = true;
  public TopGestureLayout.OnGestureListener mOnFlingGesture;
  public GestureDetector mTopGestureDetector;
  
  public TopGestureLayout(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public TopGestureLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TopGestureLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  public TopGestureLayout(Context paramContext, TopGestureLayout.InterceptTouchEventListener paramInterceptTouchEventListener)
  {
    super(paramContext);
    init(paramContext);
    this.mInterceptTouchEventListener = paramInterceptTouchEventListener;
  }
  
  private void reportTGRemoveException()
  {
    if (this.isInLayout) {
      QLog.e("TopGestureLayout", 1, "TGRemoveCatchedException ", new RuntimeException("TGRemoveCatchedException"));
    }
  }
  
  protected void detachViewFromParent(int paramInt)
  {
    reportTGRemoveException();
    super.detachViewFromParent(paramInt);
  }
  
  protected void detachViewFromParent(View paramView)
  {
    reportTGRemoveException();
    super.detachViewFromParent(paramView);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (paramCanvas == null) {
      return;
    }
    try
    {
      super.dispatchDraw(paramCanvas);
      return;
    }
    catch (Throwable paramCanvas)
    {
      paramCanvas.printStackTrace();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    TopGestureLayout.InterceptTouchEventListener localInterceptTouchEventListener = this.mInterceptTouchEventListener;
    if (localInterceptTouchEventListener != null) {
      localInterceptTouchEventListener.OnDispatchTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public GestureDetector getGestureDetector()
  {
    return this.mTopGestureDetector;
  }
  
  public GestureDetector.SimpleOnGestureListener getGestureListener()
  {
    return this.gestureListener;
  }
  
  public int getPaddingTop()
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return ImmersiveUtils.getStatusBarHeight(getContext());
    }
    return super.getPaddingTop();
  }
  
  public boolean hasGestureFlag(int paramInt)
  {
    return (!isGestureEnd()) && ((this.mGestureFlag & paramInt) == paramInt);
  }
  
  protected void init(Context paramContext)
  {
    this.gestureListener = new TopGestureLayout.TopGestureDetector(this, paramContext);
    this.mTopGestureDetector = FlingHelperUtils.utils.newStickerDismissGestureDetectorInstance(this, paramContext, this.gestureListener);
    this.defaultGestureDetector = this.mTopGestureDetector;
  }
  
  public boolean isGestureEnd()
  {
    return this.mGestureFlag == -1;
  }
  
  public boolean isGestureIdle()
  {
    return this.mGestureFlag == 0;
  }
  
  protected boolean isInTwoFingerMode()
  {
    if (this.mTopGestureDetector != null) {
      return FlingHelperUtils.utils.isInTwoFingerMode(this.mTopGestureDetector);
    }
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mInterceptTouchFlag) {
      return false;
    }
    TopGestureLayout.InterceptTouchEventListener localInterceptTouchEventListener = this.mInterceptTouchEventListener;
    if ((localInterceptTouchEventListener != null) && (!localInterceptTouchEventListener.OnInterceptTouchEvent(paramMotionEvent))) {
      return false;
    }
    return this.mTopGestureDetector.onTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.isInLayout = true;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.isInLayout = false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.mTopGestureDetector.onTouchEvent(paramMotionEvent);
  }
  
  public void removeView(View paramView)
  {
    reportTGRemoveException();
    super.removeView(paramView);
  }
  
  public void removeViewInLayout(View paramView)
  {
    reportTGRemoveException();
    super.removeViewInLayout(paramView);
  }
  
  public void restoreGestureDetector()
  {
    GestureDetector localGestureDetector = this.defaultGestureDetector;
    if (localGestureDetector != null)
    {
      this.mTopGestureDetector = localGestureDetector;
      return;
    }
    this.mTopGestureDetector = FlingHelperUtils.utils.newStickerDismissGestureDetectorInstance(this, getContext(), this.gestureListener);
  }
  
  public void setGestureDetector(GestureDetector paramGestureDetector)
  {
    this.mTopGestureDetector = paramGestureDetector;
  }
  
  public void setGestureFlag(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != -1))
    {
      this.mGestureFlag = (paramInt | this.mGestureFlag & (paramInt ^ 0xFFFFFFFF));
      return;
    }
    this.mGestureFlag = paramInt;
  }
  
  public void setInterceptScrollLRFlag(boolean paramBoolean)
  {
    this.mInterceptScrollLR = paramBoolean;
  }
  
  public void setInterceptScrollRLFlag(boolean paramBoolean)
  {
    this.mInterceptScrollRL = paramBoolean;
  }
  
  public void setInterceptTouchEventListener(TopGestureLayout.InterceptTouchEventListener paramInterceptTouchEventListener)
  {
    this.mInterceptTouchEventListener = paramInterceptTouchEventListener;
  }
  
  public void setInterceptTouchFlag(boolean paramBoolean)
  {
    this.mInterceptTouchFlag = paramBoolean;
  }
  
  public void setIsInterceptChildEventWhenScroll(boolean paramBoolean)
  {
    this.mIsInterceptChildEventWhenScroll = paramBoolean;
  }
  
  public void setOnFlingGesture(TopGestureLayout.OnGestureListener paramOnGestureListener)
  {
    this.mOnFlingGesture = paramOnGestureListener;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      super.setPadding(paramInt1, ImmersiveUtils.getStatusBarHeight(getContext()), paramInt3, paramInt4);
      return;
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setPadding2(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.TopGestureLayout
 * JD-Core Version:    0.7.0.1
 */