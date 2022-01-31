package com.tencent.biz.pubaccount.readinjoy.ad.view;

import aepi;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;

public class ReadInjoyHeaderAdDownloadView
  extends FrameLayout
{
  private int jdField_a_of_type_Int;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ReadInjoyHeaderAdDownloadView.SimpleRoundProgress jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private int c;
  private int d;
  
  public ReadInjoyHeaderAdDownloadView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ReadInjoyHeaderAdDownloadView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ReadInjoyHeaderAdDownloadView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress = new ReadInjoyHeaderAdDownloadView.SimpleRoundProgress(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.jdField_a_of_type_Int = Color.parseColor("#D9FFFFFF");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.jdField_b_of_type_Int = Color.parseColor("#FF00CAFC");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.jdField_a_of_type_Float = aepi.a(1.5F, paramContext.getResources());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.jdField_b_of_type_Float = aepi.a(1.5F, paramContext.getResources());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.jdField_c_of_type_Float = aepi.a(7.0F, paramContext.getResources());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.jdField_c_of_type_Int = 100;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.e = 270;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.d = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.f = 65;
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_c_of_type_Int = 2130841449;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(this.jdField_c_of_type_Int);
    localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_b_of_type_Int = 2130841451;
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(this.jdField_b_of_type_Int);
    localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    addView(this.jdField_b_of_type_AndroidWidgetImageView, localLayoutParams);
    this.d = aepi.a(1.5F, paramContext.getResources());
    a(0, 0);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int != 1)
    {
      this.jdField_a_of_type_Int = 1;
      a(1, paramInt);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.setProgress(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.setVisibility(8);
    switch (this.jdField_a_of_type_Int)
    {
    case 3: 
    default: 
      return;
    case 0: 
      if (getPaddingTop() != this.d) {
        setPadding(this.d, this.d, this.d, this.d);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    case 4: 
      if (getPaddingTop() != 0) {
        setPadding(0, 0, 0, 0);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.setPaused(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.setProgress(paramInt2);
      return;
    case 1: 
      if (getPaddingTop() != 0) {
        setPadding(0, 0, 0, 0);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.setPaused(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.setProgress(paramInt2);
      return;
    }
    if (getPaddingTop() != this.d) {
      setPadding(this.d, this.d, this.d, this.d);
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyHeaderAdDownloadView
 * JD-Core Version:    0.7.0.1
 */