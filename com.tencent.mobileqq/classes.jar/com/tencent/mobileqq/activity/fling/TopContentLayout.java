package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.Scroller;

public class TopContentLayout
  extends RelativeLayout
{
  private static final int OUTING_DURATION = 350;
  private static final String TAG = "TopContentLayout";
  private boolean mCanMoveLayout;
  private ContentWrapView mContent;
  private TopContentLayout.OnOutScreenListener mOnOutScreenListener;
  private Scroller mScroller;
  private GestureDetector mTopLayoutGestureDetector;
  
  public TopContentLayout(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public TopContentLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TopContentLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mTopLayoutGestureDetector = new GestureDetector(paramContext, new TopContentLayout.TopLayoutGestureDetector(this, paramContext));
    this.mScroller = new Scroller(paramContext);
  }
  
  public void computeScroll()
  {
    if (this.mScroller.computeScrollOffset())
    {
      int i = this.mScroller.getCurrX();
      int j = this.mScroller.getCurrY();
      movingViewTrans(i, j);
      TopContentLayout.OnOutScreenListener localOnOutScreenListener = this.mOnOutScreenListener;
      if (localOnOutScreenListener != null) {
        localOnOutScreenListener.outing(i, j, this);
      }
      invalidate();
    }
  }
  
  public float getMovingViewTransX()
  {
    ContentWrapView localContentWrapView = this.mContent;
    if (localContentWrapView != null) {
      return localContentWrapView.getTransX();
    }
    return 0.0F;
  }
  
  public int getMovingViewWidth()
  {
    ContentWrapView localContentWrapView = this.mContent;
    if (localContentWrapView != null) {
      return localContentWrapView.getWidth();
    }
    return getWidth();
  }
  
  public TopContentLayout.OnOutScreenListener getOnOutScreenListener()
  {
    return this.mOnOutScreenListener;
  }
  
  public void movingViewTrans(float paramFloat1, float paramFloat2)
  {
    ContentWrapView localContentWrapView = this.mContent;
    if (localContentWrapView != null)
    {
      localContentWrapView.transX(paramFloat1);
      this.mContent.transY(paramFloat2);
    }
  }
  
  public void movingViewTransBy(float paramFloat1, float paramFloat2)
  {
    ContentWrapView localContentWrapView = this.mContent;
    if (localContentWrapView != null)
    {
      localContentWrapView.transXBy(paramFloat1);
      this.mContent.transYBy(paramFloat2);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = this.mTopLayoutGestureDetector.onTouchEvent(paramMotionEvent);
    if ((paramMotionEvent.getAction() == 1) && (this.mCanMoveLayout))
    {
      this.mCanMoveLayout = false;
      int i = getMovingViewWidth();
      int j = (int)Math.abs(getMovingViewTransX());
      if (j > i / 2) {
        i -= j;
      } else {
        i = -j;
      }
      this.mScroller.startScroll((int)getMovingViewTransX(), 0, i, 0, 350);
      invalidate();
    }
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    this.mTopLayoutGestureDetector.onTouchEvent(paramMotionEvent);
    if ((i == 1) && (this.mCanMoveLayout))
    {
      this.mCanMoveLayout = false;
      i = getMovingViewWidth();
      int j = (int)Math.abs(getMovingViewTransX());
      if (j > i / 2) {
        i -= j;
      } else {
        i = -j;
      }
      this.mScroller.startScroll((int)getMovingViewTransX(), 0, i, 0, 350);
      invalidate();
    }
    return true;
  }
  
  public void setContent(ContentWrapView paramContentWrapView)
  {
    ContentWrapView localContentWrapView = this.mContent;
    if (localContentWrapView != null) {
      removeView(localContentWrapView);
    }
    this.mContent = paramContentWrapView;
    addView(this.mContent);
  }
  
  public void setOnOutScreenListener(TopContentLayout.OnOutScreenListener paramOnOutScreenListener)
  {
    this.mOnOutScreenListener = paramOnOutScreenListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.TopContentLayout
 * JD-Core Version:    0.7.0.1
 */