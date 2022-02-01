package com.tencent.biz.pubaccount.NativeAd.view;

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
import anvx;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInjoyHeaderAdDownloadView.SimpleRoundProgress;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import oix;
import org.json.JSONObject;
import uej;
import uek;
import uup;

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
  private uej jdField_a_of_type_Uej;
  
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
    if (this.jdField_a_of_type_Uej == null) {
      this.jdField_a_of_type_Uej = uej.a(1, this.jdField_a_of_type_OrgJsonJSONObject);
    }
    setStyle(this.jdField_a_of_type_Uej);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    inflate(getContext(), 2131560093, this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131372504));
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress = new ReadInjoyHeaderAdDownloadView.SimpleRoundProgress(getContext());
    }
    uek.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress);
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
        this.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131706538));
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
      this.jdField_a_of_type_Int = oix.a(paramJSONObject.optString("style"), 1);
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
  
  public void setStyle(uej paramuej)
  {
    float f1 = 2.0F;
    if (paramuej == null) {}
    Object localObject1;
    Object localObject2;
    int j;
    int i;
    label477:
    do
    {
      return;
      if (paramuej.jdField_a_of_type_Int != 1) {
        break label694;
      }
      if (this.jdField_a_of_type_AndroidWidgetProgressBar == null)
      {
        inflate(getContext(), 2131560102, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
        this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131372506));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380086));
      }
      this.jdField_a_of_type_Uej = paramuej;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramuej = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetProgressBar.getLayoutParams();
      paramuej.width = AIOUtils.dp2px(this.jdField_a_of_type_Uej.jdField_c_of_type_Int, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramuej.height = AIOUtils.dp2px(this.jdField_a_of_type_Uej.jdField_e_of_type_Int, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramuej.addRule(13);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setLayoutParams(paramuej);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(100);
      localObject1 = new GradientDrawable();
      ((GradientDrawable)localObject1).setCornerRadius(AIOUtils.dp2px(this.jdField_a_of_type_Uej.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((GradientDrawable)localObject1).setColor(oix.a(this.jdField_a_of_type_Uej.jdField_b_of_type_JavaLangString, "#F2F2F2"));
      localObject1 = new ClipDrawable((Drawable)localObject1, 3, 1);
      ((ClipDrawable)localObject1).setLevel(10000);
      localObject2 = new GradientDrawable();
      ((GradientDrawable)localObject2).setCornerRadius(AIOUtils.dp2px(this.jdField_a_of_type_Uej.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((GradientDrawable)localObject2).setColor(oix.a(this.jdField_a_of_type_Uej.jdField_c_of_type_JavaLangString, "#F2F2F2"));
      localObject2 = new ClipDrawable((Drawable)localObject2, 3, 1);
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(AIOUtils.dp2px(this.jdField_a_of_type_Uej.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localGradientDrawable.setColor(oix.a(this.jdField_a_of_type_Uej.jdField_a_of_type_JavaLangString, "#12B7F5"));
      localObject1 = new LayerDrawable(new Drawable[] { localObject1, localObject2, new ClipDrawable(localGradientDrawable, 3, 1) });
      ((LayerDrawable)localObject1).setId(0, 16908288);
      ((LayerDrawable)localObject1).setId(1, 16908303);
      ((LayerDrawable)localObject1).setId(2, 16908301);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgressDrawable((Drawable)localObject1);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(oix.a(this.jdField_a_of_type_Uej.d, "#ffffff"));
      j = this.jdField_a_of_type_Uej.g;
      if (j >= this.jdField_a_of_type_Uej.h) {
        break;
      }
      i = this.jdField_a_of_type_Uej.h;
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, i);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
      localObject1 = this.jdField_a_of_type_Uej.jdField_e_of_type_JavaLangString;
      localObject2 = String.valueOf(this.jdField_a_of_type_Uej.jdField_b_of_type_Float);
    } while ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2)));
    float f2 = oix.a((String)localObject2, 0.0F);
    if (f2 > 2.0F) {}
    for (;;)
    {
      localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).width = (paramuej.width + AIOUtils.dp2px(f1, this.jdField_a_of_type_AndroidContentContext.getResources()) * 2);
      ((RelativeLayout.LayoutParams)localObject2).height = (paramuej.height + AIOUtils.dp2px(f1, this.jdField_a_of_type_AndroidContentContext.getResources()) * 2);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      uup.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, AIOUtils.dp2px(this.jdField_a_of_type_Uej.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidContentContext.getResources()), oix.a((String)localObject1, "#12B7F5"), AIOUtils.dp2px(f1, this.jdField_a_of_type_AndroidContentContext.getResources()));
      return;
      i = j;
      if (j <= this.jdField_a_of_type_Uej.i) {
        break label477;
      }
      i = this.jdField_a_of_type_Uej.i;
      break label477;
      label694:
      if ((paramuej.jdField_a_of_type_Int != 2) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress != null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress = new ReadInjoyHeaderAdDownloadView.SimpleRoundProgress(getContext());
      uek.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress);
      paramuej = new RelativeLayout.LayoutParams(AIOUtils.dp2px(25.0F, getContext().getResources()), AIOUtils.dp2px(25.0F, getContext().getResources()));
      paramuej.rightMargin = AIOUtils.dp2px(10.0F, getContext().getResources());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress, paramuej);
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
    if ((this.jdField_a_of_type_Uej == null) || (this.jdField_a_of_type_Uej.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131706536) + paramInt + "%");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt + "%");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.view.NativeAdDownloadView
 * JD-Core Version:    0.7.0.1
 */