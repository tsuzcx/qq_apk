package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import agej;
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
  private ReadInjoyHeaderAdDownloadView.SimpleRoundProgress jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress;
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress = new ReadInjoyHeaderAdDownloadView.SimpleRoundProgress(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.jdField_a_of_type_Int = Color.parseColor("#99FFFFFF");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.jdField_b_of_type_Int = Color.parseColor("#FFFFFFFF");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.jdField_a_of_type_Float = agej.a(2.0F, paramContext.getResources());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.jdField_b_of_type_Float = agej.a(2.0F, paramContext.getResources());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.jdField_c_of_type_Float = agej.a(9.0F, paramContext.getResources());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.jdField_c_of_type_Int = 100;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.e = 270;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.d = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.f = 65;
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_c_of_type_Int = 2130841768;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(this.jdField_c_of_type_Int);
    localLayoutParams = new FrameLayout.LayoutParams(agej.a(13.0F, getResources()), agej.a(16.0F, getResources()));
    localLayoutParams.gravity = 17;
    addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_b_of_type_Int = 2130841770;
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(this.jdField_b_of_type_Int);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    addView(this.jdField_b_of_type_AndroidWidgetImageView, paramContext);
    this.d = 0;
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.setProgress(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.setVisibility(8);
    switch (this.jdField_a_of_type_Int)
    {
    case 3: 
    default: 
      return;
    case 0: 
      if (getPaddingTop() != this.d) {
        setPadding(this.d, this.d, this.d, this.d);
      }
      setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    case 4: 
      if (getPaddingTop() != 0) {
        setPadding(0, 0, 0, 0);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.setPaused(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.setProgress(paramInt2);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    case 1: 
      if (getPaddingTop() != 0) {
        setPadding(0, 0, 0, 0);
      }
      setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.setPaused(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.setProgress(paramInt2);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    if (getPaddingTop() != this.d) {
      setPadding(this.d, this.d, this.d, this.d);
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInjoyHeaderAdDownloadView
 * JD-Core Version:    0.7.0.1
 */