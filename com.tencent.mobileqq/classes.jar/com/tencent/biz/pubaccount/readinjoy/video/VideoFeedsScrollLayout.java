package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import mib;

public class VideoFeedsScrollLayout
  extends RelativeLayout
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private VideoFeedsScrollLayout.ContentLayoutListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsScrollLayout$ContentLayoutListener;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 300;
  private boolean jdField_b_of_type_Boolean;
  private int c = 300;
  
  public VideoFeedsScrollLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext);
  }
  
  public VideoFeedsScrollLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext);
  }
  
  public VideoFeedsScrollLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    paramMotionEvent = new AlphaAnimation(1.0F, 0.0F);
    paramMotionEvent.setFillAfter(true);
    paramMotionEvent.setDuration(this.c);
    startAnimation(paramMotionEvent);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsScrollLayout$ContentLayoutListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsScrollLayout$ContentLayoutListener.b();
    }
    postDelayed(new mib(this), this.jdField_b_of_type_Int);
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
      postInvalidate();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (paramMotionEvent.getAction() != 1) {
        break label59;
      }
      if (Math.abs(paramMotionEvent.getY() - this.jdField_a_of_type_Float) > 150.0F) {
        a(paramMotionEvent);
      }
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      label59:
      if ((paramMotionEvent.getAction() == 2) && (Math.abs(paramMotionEvent.getY() - this.jdField_a_of_type_Float) > 150.0F)) {
        a(paramMotionEvent);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = View.MeasureSpec.getSize(paramInt2);
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setListener(VideoFeedsScrollLayout.ContentLayoutListener paramContentLayoutListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsScrollLayout$ContentLayoutListener = paramContentLayoutListener;
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsScrollLayout
 * JD-Core Version:    0.7.0.1
 */