package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.jdField_a_of_type_Float = AIOUtils.b(2.0F, paramContext.getResources());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.jdField_b_of_type_Float = AIOUtils.b(2.0F, paramContext.getResources());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.jdField_c_of_type_Float = AIOUtils.b(9.0F, paramContext.getResources());
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress;
    ((ReadInjoyHeaderAdDownloadView.SimpleRoundProgress)localObject).jdField_c_of_type_Int = 100;
    ((ReadInjoyHeaderAdDownloadView.SimpleRoundProgress)localObject).e = 270;
    ((ReadInjoyHeaderAdDownloadView.SimpleRoundProgress)localObject).d = 0;
    ((ReadInjoyHeaderAdDownloadView.SimpleRoundProgress)localObject).f = 65;
    localObject = new FrameLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_c_of_type_Int = 2130841858;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(this.jdField_c_of_type_Int);
    localObject = new FrameLayout.LayoutParams(AIOUtils.b(13.0F, getResources()), AIOUtils.b(16.0F, getResources()));
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_b_of_type_Int = 2130841860;
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(this.jdField_b_of_type_Int);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    addView(this.jdField_b_of_type_AndroidWidgetImageView, paramContext);
    this.d = 0;
    a(0, 0);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.setVisibility(8);
    paramInt1 = this.jdField_a_of_type_Int;
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if (paramInt1 != 4) {
            return;
          }
          if (getPaddingTop() != 0) {
            setPadding(0, 0, 0, 0);
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.setVisibility(0);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.setPaused(true);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.setProgress(paramInt2);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          return;
        }
        paramInt1 = getPaddingTop();
        paramInt2 = this.d;
        if (paramInt1 != paramInt2) {
          setPadding(paramInt2, paramInt2, paramInt2, paramInt2);
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
      }
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
    paramInt1 = getPaddingTop();
    paramInt2 = this.d;
    if (paramInt1 != paramInt2) {
      setPadding(paramInt2, paramInt2, paramInt2, paramInt2);
    }
    setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInjoyHeaderAdDownloadView
 * JD-Core Version:    0.7.0.1
 */