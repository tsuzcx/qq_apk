package com.tencent.biz.pubaccount.NativeAd.view;

import amtj;
import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInjoyHeaderAdDownloadView.SimpleRoundProgress;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import obg;
import org.json.JSONObject;
import tqr;
import tqs;
import ugs;

public class NativeAdDownloadView
  extends RelativeLayout
{
  private int jdField_a_of_type_Int = 1;
  private Context jdField_a_of_type_AndroidContentContext;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ReadInjoyHeaderAdDownloadView.SimpleRoundProgress jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private tqr jdField_a_of_type_Tqr;
  
  public NativeAdDownloadView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public NativeAdDownloadView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public NativeAdDownloadView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_OrgJsonJSONObject == null) {
      return;
    }
    if (this.jdField_a_of_type_Tqr == null) {
      this.jdField_a_of_type_Tqr = tqr.a(1, this.jdField_a_of_type_OrgJsonJSONObject);
    }
    setStyle(this.jdField_a_of_type_Tqr);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    inflate(getContext(), 2131560048, this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131372312));
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress = new ReadInjoyHeaderAdDownloadView.SimpleRoundProgress(getContext());
    }
    tqs.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.dp2px(25.0F, getContext().getResources()), AIOUtils.dp2px(25.0F, getContext().getResources()));
    localLayoutParams.rightMargin = AIOUtils.dp2px(10.0F, getContext().getResources());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress, localLayoutParams);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 4)
    {
      if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt2);
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131706186));
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.setPaused(true);
      }
      return;
    }
    setProgress(paramInt2);
  }
  
  public void setBtnText(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public void setProgress(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.setPauseWithoutInvalidate(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.setProgress(paramInt);
    }
    setText(paramInt);
  }
  
  public void setProgressStyle(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    if (paramJSONObject != null)
    {
      this.jdField_a_of_type_Int = obg.a(paramJSONObject.optString("style"), 1);
      setStyle(this.jdField_a_of_type_Int);
    }
  }
  
  public void setStyle(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      a();
      return;
    }
    b();
  }
  
  public void setStyle(tqr paramtqr)
  {
    float f1 = 2.0F;
    if (paramtqr == null) {}
    Object localObject1;
    Object localObject2;
    int j;
    int i;
    label477:
    do
    {
      return;
      if (paramtqr.jdField_a_of_type_Int != 1) {
        break label694;
      }
      if (this.jdField_a_of_type_AndroidWidgetProgressBar == null)
      {
        inflate(getContext(), 2131560055, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
        this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131372314));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379765));
      }
      this.jdField_a_of_type_Tqr = paramtqr;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramtqr = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetProgressBar.getLayoutParams();
      paramtqr.width = AIOUtils.dp2px(this.jdField_a_of_type_Tqr.jdField_c_of_type_Int, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramtqr.height = AIOUtils.dp2px(this.jdField_a_of_type_Tqr.jdField_e_of_type_Int, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramtqr.addRule(13);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setLayoutParams(paramtqr);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(100);
      localObject1 = new GradientDrawable();
      ((GradientDrawable)localObject1).setCornerRadius(AIOUtils.dp2px(this.jdField_a_of_type_Tqr.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((GradientDrawable)localObject1).setColor(obg.a(this.jdField_a_of_type_Tqr.jdField_b_of_type_JavaLangString, "#F2F2F2"));
      localObject1 = new ClipDrawable((Drawable)localObject1, 3, 1);
      ((ClipDrawable)localObject1).setLevel(10000);
      localObject2 = new GradientDrawable();
      ((GradientDrawable)localObject2).setCornerRadius(AIOUtils.dp2px(this.jdField_a_of_type_Tqr.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((GradientDrawable)localObject2).setColor(obg.a(this.jdField_a_of_type_Tqr.jdField_c_of_type_JavaLangString, "#F2F2F2"));
      localObject2 = new ClipDrawable((Drawable)localObject2, 3, 1);
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(AIOUtils.dp2px(this.jdField_a_of_type_Tqr.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localGradientDrawable.setColor(obg.a(this.jdField_a_of_type_Tqr.jdField_a_of_type_JavaLangString, "#12B7F5"));
      localObject1 = new LayerDrawable(new Drawable[] { localObject1, localObject2, new ClipDrawable(localGradientDrawable, 3, 1) });
      ((LayerDrawable)localObject1).setId(0, 16908288);
      ((LayerDrawable)localObject1).setId(1, 16908303);
      ((LayerDrawable)localObject1).setId(2, 16908301);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgressDrawable((Drawable)localObject1);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(obg.a(this.jdField_a_of_type_Tqr.d, "#ffffff"));
      j = this.jdField_a_of_type_Tqr.g;
      if (j >= this.jdField_a_of_type_Tqr.h) {
        break;
      }
      i = this.jdField_a_of_type_Tqr.h;
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, i);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
      localObject1 = this.jdField_a_of_type_Tqr.jdField_e_of_type_JavaLangString;
      localObject2 = String.valueOf(this.jdField_a_of_type_Tqr.jdField_b_of_type_Float);
    } while ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2)));
    float f2 = obg.a((String)localObject2, 0.0F);
    if (f2 > 2.0F) {}
    for (;;)
    {
      localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).width = (paramtqr.width + AIOUtils.dp2px(f1, this.jdField_a_of_type_AndroidContentContext.getResources()) * 2);
      ((RelativeLayout.LayoutParams)localObject2).height = (paramtqr.height + AIOUtils.dp2px(f1, this.jdField_a_of_type_AndroidContentContext.getResources()) * 2);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ugs.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, AIOUtils.dp2px(this.jdField_a_of_type_Tqr.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidContentContext.getResources()), obg.a((String)localObject1, "#12B7F5"), AIOUtils.dp2px(f1, this.jdField_a_of_type_AndroidContentContext.getResources()));
      return;
      i = j;
      if (j <= this.jdField_a_of_type_Tqr.i) {
        break label477;
      }
      i = this.jdField_a_of_type_Tqr.i;
      break label477;
      label694:
      if ((paramtqr.jdField_a_of_type_Int != 2) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress != null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress = new ReadInjoyHeaderAdDownloadView.SimpleRoundProgress(getContext());
      tqs.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress);
      paramtqr = new RelativeLayout.LayoutParams(AIOUtils.dp2px(25.0F, getContext().getResources()), AIOUtils.dp2px(25.0F, getContext().getResources()));
      paramtqr.rightMargin = AIOUtils.dp2px(10.0F, getContext().getResources());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress, paramtqr);
      return;
      f1 = f2;
    }
  }
  
  public void setText(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {}
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    }
    if ((this.jdField_a_of_type_Tqr == null) || (this.jdField_a_of_type_Tqr.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131706184) + paramInt + "%");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt + "%");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.view.NativeAdDownloadView
 * JD-Core Version:    0.7.0.1
 */