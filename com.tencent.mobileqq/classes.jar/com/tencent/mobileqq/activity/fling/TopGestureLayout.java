package com.tencent.mobileqq.activity.fling;

import acxe;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.emoticonview.StickerGestureDetector;
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
  private boolean isInLayout;
  private int mGestureFlag;
  private boolean mInterceptScrollLR = true;
  private boolean mInterceptScrollRL;
  TopGestureLayout.InterceptTouchEventListener mInterceptTouchEventListener;
  private boolean mInterceptTouchFlag = true;
  private boolean mIsInterceptChildEventWhenScroll = true;
  public acxe mMyDispatchDrawListener;
  public TopGestureLayout.OnGestureListener mOnFlingGesture;
  public GestureDetector mTopGestureDetector;
  
  public TopGestureLayout(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public TopGestureLayout(Context paramContext, acxe paramacxe, TopGestureLayout.InterceptTouchEventListener paramInterceptTouchEventListener)
  {
    super(paramContext);
    init(paramContext);
    this.mMyDispatchDrawListener = paramacxe;
    this.mInterceptTouchEventListener = paramInterceptTouchEventListener;
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
    if (paramCanvas == null) {}
    for (;;)
    {
      return;
      try
      {
        super.dispatchDraw(paramCanvas);
        if (this.mMyDispatchDrawListener == null) {
          continue;
        }
        this.mMyDispatchDrawListener.a();
        return;
      }
      catch (Throwable paramCanvas)
      {
        for (;;)
        {
          paramCanvas.printStackTrace();
        }
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mInterceptTouchEventListener != null) {
      this.mInterceptTouchEventListener.OnDispatchTouchEvent(paramMotionEvent);
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
    this.mTopGestureDetector = new TopGestureLayout.StickerDismissGestureDetector(this, paramContext, this.gestureListener);
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
  
  public boolean isInTwoFingerMode()
  {
    if (this.mTopGestureDetector != null)
    {
      if ((this.mTopGestureDetector instanceof StickerGestureDetector)) {
        return ((StickerGestureDetector)this.mTopGestureDetector).isInTowFingerMode;
      }
      if ((this.mTopGestureDetector instanceof TopGestureLayout.StickerDismissGestureDetector)) {
        return ((TopGestureLayout.StickerDismissGestureDetector)this.mTopGestureDetector).isInTowFingerMode;
      }
    }
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mInterceptTouchFlag) {}
    while ((this.mInterceptTouchEventListener != null) && (!this.mInterceptTouchEventListener.OnInterceptTouchEvent(paramMotionEvent))) {
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
    if (this.defaultGestureDetector != null)
    {
      this.mTopGestureDetector = this.defaultGestureDetector;
      return;
    }
    this.mTopGestureDetector = new TopGestureLayout.StickerDismissGestureDetector(this, getContext(), this.gestureListener);
  }
  
  public void setGestureDetector(GestureDetector paramGestureDetector)
  {
    this.mTopGestureDetector = paramGestureDetector;
  }
  
  public void setGestureFlag(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == -1))
    {
      this.mGestureFlag = paramInt;
      return;
    }
    this.mGestureFlag = (this.mGestureFlag & (paramInt ^ 0xFFFFFFFF) | paramInt);
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
  
  public void setMyDispatchDrawListener(acxe paramacxe)
  {
    this.mMyDispatchDrawListener = paramacxe;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.TopGestureLayout
 * JD-Core Version:    0.7.0.1
 */