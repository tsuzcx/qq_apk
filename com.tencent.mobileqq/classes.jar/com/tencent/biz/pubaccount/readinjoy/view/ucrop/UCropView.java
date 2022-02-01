package com.tencent.biz.pubaccount.readinjoy.view.ucrop;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R.styleable;
import tog;
import toh;

public class UCropView
  extends FrameLayout
{
  private GestureCropImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewUcropGestureCropImageView;
  private final OverlayView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewUcropOverlayView;
  
  public UCropView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public UCropView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131560442, this, true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewUcropGestureCropImageView = ((GestureCropImageView)findViewById(2131368616));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewUcropOverlayView = ((OverlayView)findViewById(2131381148));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.UCropView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewUcropOverlayView.a(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewUcropGestureCropImageView.a(paramContext);
    paramContext.recycle();
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewUcropGestureCropImageView.setCropBoundsChangeListener(new tog(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewUcropOverlayView.setOverlayViewChangeListener(new toh(this));
  }
  
  @NonNull
  public GestureCropImageView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewUcropGestureCropImageView;
  }
  
  @NonNull
  public OverlayView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewUcropOverlayView;
  }
  
  public void a()
  {
    removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewUcropGestureCropImageView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewUcropGestureCropImageView = new GestureCropImageView(getContext());
    b();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewUcropGestureCropImageView.setCropRect(a().a());
    addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewUcropGestureCropImageView, 0);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ucrop.UCropView
 * JD-Core Version:    0.7.0.1
 */