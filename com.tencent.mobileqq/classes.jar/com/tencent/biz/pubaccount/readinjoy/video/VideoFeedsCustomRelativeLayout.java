package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class VideoFeedsCustomRelativeLayout
  extends RelativeLayout
{
  private float jdField_a_of_type_Float;
  private VideoFeedsListView.ListViewEventListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView$ListViewEventListener;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  
  public VideoFeedsCustomRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public VideoFeedsCustomRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public VideoFeedsCustomRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      bool = super.onInterceptTouchEvent(paramMotionEvent);
    }
    do
    {
      return bool;
      if ((paramMotionEvent.getAction() != 2) || (this.jdField_a_of_type_Boolean) || (paramMotionEvent.getY() - this.jdField_a_of_type_Float <= 300.0F) || (this.b)) {
        break;
      }
      this.b = true;
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView$ListViewEventListener == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView$ListViewEventListener.b();
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setListViewEventListener(VideoFeedsListView.ListViewEventListener paramListViewEventListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView$ListViewEventListener = paramListViewEventListener;
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsCustomRelativeLayout
 * JD-Core Version:    0.7.0.1
 */