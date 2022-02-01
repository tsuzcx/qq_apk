package com.tencent.hippy.qq.view.tkd.doublescrollview;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.mtt.hippy.utils.PixelUtil;

public class HippyTKDDoubleScrollView
  extends LinearLayout
  implements View.OnLayoutChangeListener, IDoubleScroll, HippyViewBase
{
  private static final int IS_CHILD_EVENT = 1;
  private static final int IS_PARENT_EVENT = 2;
  private static final int IS_UNKONW_EVENT = 0;
  private static final String TAG = "HippyQBDoubleScrollView";
  private int deadLine;
  private int dx = 0;
  private int dy = 0;
  private FlingController flingController;
  private int isChildViewEvent = 0;
  private boolean isHidden = false;
  private int lastX = 0;
  private int lastY = 0;
  private boolean mEnableDoubleScroll = true;
  private IDoubleScroll mNestDoubleScrollView;
  private HippyTKDDoubleScrollView.OnScrollEvent mOnScrollEvent;
  private boolean oldHiddenState;
  
  public HippyTKDDoubleScrollView(Context paramContext)
  {
    super(paramContext);
    setOrientation(1);
    setOverScrollMode(2);
    this.flingController = new FlingController();
    this.flingController.setFlingListener(this);
  }
  
  private void computeHidden(int paramInt1, int paramInt2)
  {
    int i = this.mNestDoubleScrollView.getNestViewScrollY();
    this.oldHiddenState = this.isHidden;
    if (paramInt1 + paramInt2 >= this.deadLine)
    {
      setHidden(true);
    }
    else if ((i + paramInt2 < 0) && (i >= 0))
    {
      setHidden(false);
      this.mNestDoubleScrollView.scrollNestViewTo(0, 0);
    }
    else if ((paramInt1 == this.deadLine) && (i > 0) && (paramInt2 < 0))
    {
      setHidden(true);
    }
    if (this.oldHiddenState != this.isHidden) {
      pageChanged();
    }
  }
  
  private HippyTKDDoubleScrollView.OnScrollEvent getOnScrollEvent()
  {
    if (this.mOnScrollEvent == null) {
      this.mOnScrollEvent = new HippyTKDDoubleScrollView.OnScrollEvent(this, "onScroll");
    }
    return this.mOnScrollEvent;
  }
  
  private void pageChanged()
  {
    this.dy = 0;
    if (this.isHidden)
    {
      scrollTo(0, this.deadLine);
      return;
    }
    this.mNestDoubleScrollView.scrollNestViewTo(0, 0);
  }
  
  private void scrollByAuto(int paramInt)
  {
    if (this.mNestDoubleScrollView == null) {
      return;
    }
    if (getDeadLine() == 0) {
      setDeadLine(getChildAt(0).getHeight() - getHeight());
    }
    computeHidden(getScrollY(), paramInt);
    if (this.mNestDoubleScrollView.getNestViewScrollY() + this.mNestDoubleScrollView.getLayoutHeight() - this.deadLine + getScrollY() + paramInt >= this.mNestDoubleScrollView.getRealHeight())
    {
      this.flingController.stop();
      if (this.mNestDoubleScrollView.getRealHeight() == 0) {
        return;
      }
      if (!isHidden())
      {
        i = this.mNestDoubleScrollView.getRealHeight() + getHeight() - this.mNestDoubleScrollView.getLayoutHeight() - getHeight();
        paramInt = i;
        if (i <= 0) {
          paramInt = this.deadLine;
        }
        scrollTo(0, paramInt);
        return;
      }
      int i = this.mNestDoubleScrollView.getRealHeight() - this.mNestDoubleScrollView.getLayoutHeight();
      paramInt = i;
      if (i < 0) {
        paramInt = this.deadLine;
      }
      this.mNestDoubleScrollView.scrollNestViewTo(0, paramInt);
      return;
    }
    if (this.isHidden)
    {
      if (this.mNestDoubleScrollView.getNestViewScrollY() + paramInt >= 0)
      {
        this.mNestDoubleScrollView.scrollNestViewBy(0, paramInt);
        return;
      }
      this.mNestDoubleScrollView.scrollNestViewTo(0, 0);
      return;
    }
    if (getScrollY() + paramInt >= 0)
    {
      scrollBy(0, paramInt);
      return;
    }
    scrollTo(0, 0);
    if (this.mNestDoubleScrollView.getNestViewScrollY() + paramInt >= 0)
    {
      this.mNestDoubleScrollView.scrollNestViewBy(0, paramInt);
      return;
    }
    this.mNestDoubleScrollView.scrollNestViewTo(0, 0);
  }
  
  public void computeScroll()
  {
    if (this.flingController.isFling)
    {
      scrollByAuto(-this.flingController.computeDistance());
      invalidate();
    }
  }
  
  public int getDeadLine()
  {
    return this.deadLine;
  }
  
  public NativeGestureDispatcher getGestureDispatcher()
  {
    return null;
  }
  
  public int getLayoutHeight()
  {
    return getHeight();
  }
  
  public int getNestViewScrollY()
  {
    return getScrollY();
  }
  
  public int getRealHeight()
  {
    return getHeight();
  }
  
  public boolean isDoubleScrollEnable()
  {
    return this.mEnableDoubleScroll;
  }
  
  public boolean isHidden()
  {
    return this.isHidden;
  }
  
  public void notifyNestViewToFling(int paramInt1, int paramInt2)
  {
    scrollByAuto(paramInt2);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mEnableDoubleScroll) {
      return false;
    }
    int i = paramMotionEvent.getActionMasked();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return i != 3;
        }
        if (paramMotionEvent.getPointerCount() > 1)
        {
          i = paramMotionEvent.getPointerId(0);
          this.dx = (this.lastX - (int)paramMotionEvent.getX(i));
          this.dy = (this.lastY - (int)paramMotionEvent.getY(i));
          this.lastX = ((int)paramMotionEvent.getX(i));
          this.lastY = ((int)paramMotionEvent.getY(i));
        }
        else
        {
          this.dx = (this.lastX - (int)paramMotionEvent.getX());
          this.dy = (this.lastY - (int)paramMotionEvent.getY());
          this.lastX = ((int)paramMotionEvent.getX());
          this.lastY = ((int)paramMotionEvent.getY());
        }
        i = this.isChildViewEvent;
        if (i == 0)
        {
          if ((Math.abs(this.dx) <= 2) && (Math.abs(this.dy) <= 2)) {
            return false;
          }
          if (Math.abs(this.dx) / 2 <= Math.abs(this.dy))
          {
            this.isChildViewEvent = 2;
            return true;
          }
          this.isChildViewEvent = 1;
          return false;
        }
        if ((i == 1) || (i == 0)) {
          return false;
        }
      }
      else
      {
        i = this.isChildViewEvent;
        if (i == 1) {
          break label245;
        }
        if (i == 0) {
          return false;
        }
      }
      return true;
      label245:
      return false;
    }
    this.isChildViewEvent = 0;
    this.flingController.stop();
    this.lastX = ((int)paramMotionEvent.getX());
    this.lastY = ((int)paramMotionEvent.getY());
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((paramView instanceof ViewGroup))
    {
      Object localObject = (ViewGroup)paramView;
      localObject = ((ViewGroup)localObject).getChildAt(((ViewGroup)localObject).getChildCount() - 1);
      if (localObject != null) {
        paramInt1 = ((View)localObject).getBottom();
      } else {
        paramInt1 = 0;
      }
      if (paramView.getHeight() < paramInt1)
      {
        paramView.measure(View.MeasureSpec.makeMeasureSpec(paramView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824));
        paramView.layout(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getTop() + paramInt1);
      }
    }
    setDeadLine(paramView.getHeight() - getHeight());
    if ((getScrollY() != getDeadLine()) && (this.mNestDoubleScrollView.getNestViewScrollY() > 0)) {
      scrollTo(0, getDeadLine());
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    HippyMap localHippyMap1 = new HippyMap();
    localHippyMap1.pushDouble("top", 0.0D);
    localHippyMap1.pushDouble("bottom", 0.0D);
    localHippyMap1.pushDouble("left", 0.0D);
    localHippyMap1.pushDouble("right", 0.0D);
    HippyMap localHippyMap2 = new HippyMap();
    localHippyMap2.pushDouble("x", PixelUtil.px2dp(getScrollX()));
    localHippyMap2.pushDouble("y", PixelUtil.px2dp(getScrollY()));
    HippyMap localHippyMap3 = new HippyMap();
    if (getChildCount() > 0) {
      paramInt1 = getChildAt(0).getWidth();
    } else {
      paramInt1 = getWidth();
    }
    localHippyMap3.pushDouble("width", PixelUtil.px2dp(paramInt1));
    if (getChildCount() > 0) {
      paramInt1 = getChildAt(0).getHeight();
    } else {
      paramInt1 = getHeight();
    }
    localHippyMap3.pushDouble("height", PixelUtil.px2dp(paramInt1));
    HippyMap localHippyMap4 = new HippyMap();
    localHippyMap4.pushDouble("width", PixelUtil.px2dp(getWidth()));
    localHippyMap4.pushDouble("height", PixelUtil.px2dp(getHeight()));
    HippyMap localHippyMap5 = new HippyMap();
    localHippyMap5.pushMap("contentInset", localHippyMap1);
    localHippyMap5.pushMap("contentOffset", localHippyMap2);
    localHippyMap5.pushMap("contentSize", localHippyMap3);
    localHippyMap5.pushMap("layoutMeasurement", localHippyMap4);
    getOnScrollEvent().send(this, localHippyMap5);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 5)
            {
              if (i != 6) {
                return true;
              }
            }
            else {
              return false;
            }
          }
          else
          {
            this.flingController.stop();
            return true;
          }
        }
        else
        {
          if (paramMotionEvent.getPointerCount() > 1)
          {
            i = paramMotionEvent.getPointerId(0);
            try
            {
              this.flingController.setY((int)paramMotionEvent.getY(i));
            }
            catch (IllegalArgumentException localIllegalArgumentException)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("onTouchEvent: motionEvent.getY(flag) ");
              localStringBuilder.append(localIllegalArgumentException.getMessage());
              Log.e("HippyQBDoubleScrollView", localStringBuilder.toString());
              i = 0;
            }
            this.flingController.setY((int)paramMotionEvent.getY(i));
            this.dx = (this.lastX - (int)paramMotionEvent.getX(i));
            this.dy = (this.lastY - (int)paramMotionEvent.getY(i));
            this.lastX = ((int)paramMotionEvent.getX(i));
            this.lastY = ((int)paramMotionEvent.getY(i));
          }
          else
          {
            this.flingController.setY((int)paramMotionEvent.getY());
            this.dx = (this.lastX - (int)paramMotionEvent.getX());
            this.dy = (this.lastY - (int)paramMotionEvent.getY());
            this.lastX = ((int)paramMotionEvent.getX());
            this.lastY = ((int)paramMotionEvent.getY());
          }
          if (this.isChildViewEvent == 0) {
            if (Math.abs(this.dx) / 2 <= Math.abs(this.dy)) {
              this.isChildViewEvent = 2;
            } else {
              this.isChildViewEvent = 1;
            }
          }
          if (this.isChildViewEvent != 2) {
            break label378;
          }
          scrollByAuto(this.dy);
          return true;
        }
      }
      if (this.isChildViewEvent != 1)
      {
        this.flingController.startFling();
        if ((this.mNestDoubleScrollView != null) && ((isHidden()) || (this.mNestDoubleScrollView.getNestViewScrollY() != 0))) {
          invalidate();
        }
      }
      return true;
    }
    else
    {
      this.isChildViewEvent = 0;
      this.flingController.stop();
      this.lastX = ((int)paramMotionEvent.getX());
      this.lastY = ((int)paramMotionEvent.getY());
    }
    label378:
    return true;
  }
  
  public void scrollNestViewBy(int paramInt1, int paramInt2)
  {
    scrollTo(paramInt1, paramInt2);
  }
  
  public void scrollNestViewTo(int paramInt1, int paramInt2)
  {
    scrollTo(paramInt1, paramInt2);
  }
  
  public void scrollToDeadLine()
  {
    scrollTo(0, this.deadLine);
    computeHidden(this.deadLine, 0);
  }
  
  public void setDeadLine(int paramInt)
  {
    this.deadLine = paramInt;
  }
  
  public void setDoubleScrollRespondView(IDoubleScroll paramIDoubleScroll, boolean paramBoolean)
  {
    if (paramIDoubleScroll != null) {
      if (paramBoolean)
      {
        this.mNestDoubleScrollView = paramIDoubleScroll;
        this.deadLine = 0;
        paramIDoubleScroll = getChildAt(0);
        if (paramIDoubleScroll != null) {
          paramIDoubleScroll.addOnLayoutChangeListener(this);
        }
      }
      else if (paramIDoubleScroll == this.mNestDoubleScrollView)
      {
        this.mNestDoubleScrollView = null;
        this.deadLine = 0;
        paramIDoubleScroll = getChildAt(0);
        if (paramIDoubleScroll != null) {
          paramIDoubleScroll.removeOnLayoutChangeListener(this);
        }
      }
    }
  }
  
  public void setEnableDoubleScroll(boolean paramBoolean)
  {
    this.mEnableDoubleScroll = paramBoolean;
  }
  
  public void setGestureDispatcher(NativeGestureDispatcher paramNativeGestureDispatcher) {}
  
  public void setHidden(boolean paramBoolean)
  {
    this.isHidden = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.doublescrollview.HippyTKDDoubleScrollView
 * JD-Core Version:    0.7.0.1
 */