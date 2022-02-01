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
import com.tencent.biz.pubaccount.NativeAd.util.ParseUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.CommonProgressStyle;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.ReadInJoyCommonSoftAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInjoyHeaderAdDownloadView.SimpleRoundProgress;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.image.PublicDrawableUtil;
import org.json.JSONObject;

public class NativeAdDownloadView
  extends RelativeLayout
{
  private int jdField_a_of_type_Int = 1;
  private Context jdField_a_of_type_AndroidContentContext;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CommonProgressStyle jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonProgressStyle;
  private ReadInjoyHeaderAdDownloadView.SimpleRoundProgress jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  
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
    JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
    if (localJSONObject == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonProgressStyle == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonProgressStyle = CommonProgressStyle.a(1, localJSONObject);
    }
    setStyle(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonProgressStyle);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    inflate(getContext(), 2131560058, this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131372391));
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress = new ReadInjoyHeaderAdDownloadView.SimpleRoundProgress(getContext());
    }
    ReadInJoyCommonSoftAdUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.b(25.0F, getContext().getResources()), AIOUtils.b(25.0F, getContext().getResources()));
    localLayoutParams.rightMargin = AIOUtils.b(10.0F, getContext().getResources());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress, localLayoutParams);
  }
  
  public void setBtnText(String paramString)
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
  
  public void setProgress(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetProgressBar;
    if (localObject != null) {
      ((ProgressBar)localObject).setProgress(paramInt);
    }
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress;
    if (localObject != null)
    {
      ((ReadInjoyHeaderAdDownloadView.SimpleRoundProgress)localObject).setPauseWithoutInvalidate(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.setProgress(paramInt);
    }
    setText(paramInt);
  }
  
  public void setProgressStyle(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    if (paramJSONObject != null)
    {
      this.jdField_a_of_type_Int = ParseUtil.a(paramJSONObject.optString("style"), 1);
      setStyle(this.jdField_a_of_type_Int);
    }
  }
  
  public void setStyle(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      b();
      return;
    }
    a();
  }
  
  public void setStyle(CommonProgressStyle paramCommonProgressStyle)
  {
    if (paramCommonProgressStyle == null) {
      return;
    }
    if (paramCommonProgressStyle.jdField_a_of_type_Int == 1)
    {
      if (this.jdField_a_of_type_AndroidWidgetProgressBar == null)
      {
        inflate(getContext(), 2131560068, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
        this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131372393));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379821));
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonProgressStyle = paramCommonProgressStyle;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramCommonProgressStyle = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetProgressBar.getLayoutParams();
      paramCommonProgressStyle.width = AIOUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonProgressStyle.jdField_c_of_type_Int, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramCommonProgressStyle.height = AIOUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonProgressStyle.jdField_e_of_type_Int, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramCommonProgressStyle.addRule(13);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setLayoutParams(paramCommonProgressStyle);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(100);
      Object localObject1 = new GradientDrawable();
      ((GradientDrawable)localObject1).setCornerRadius(AIOUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonProgressStyle.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((GradientDrawable)localObject1).setColor(ParseUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonProgressStyle.jdField_b_of_type_JavaLangString, "#F2F2F2"));
      localObject1 = new ClipDrawable((Drawable)localObject1, 3, 1);
      ((ClipDrawable)localObject1).setLevel(10000);
      Object localObject2 = new GradientDrawable();
      ((GradientDrawable)localObject2).setCornerRadius(AIOUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonProgressStyle.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((GradientDrawable)localObject2).setColor(ParseUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonProgressStyle.jdField_c_of_type_JavaLangString, "#F2F2F2"));
      localObject2 = new ClipDrawable((Drawable)localObject2, 3, 1);
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(AIOUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonProgressStyle.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localGradientDrawable.setColor(ParseUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonProgressStyle.jdField_a_of_type_JavaLangString, "#12B7F5"));
      localObject1 = new LayerDrawable(new Drawable[] { localObject1, localObject2, new ClipDrawable(localGradientDrawable, 3, 1) });
      ((LayerDrawable)localObject1).setId(0, 16908288);
      ((LayerDrawable)localObject1).setId(1, 16908303);
      ((LayerDrawable)localObject1).setId(2, 16908301);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgressDrawable((Drawable)localObject1);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(ParseUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonProgressStyle.d, "#ffffff"));
      int j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonProgressStyle.g;
      int i;
      if (j < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonProgressStyle.h)
      {
        i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonProgressStyle.h;
      }
      else
      {
        i = j;
        if (j > this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonProgressStyle.i) {
          i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonProgressStyle.i;
        }
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, i);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonProgressStyle.jdField_e_of_type_JavaLangString;
      localObject2 = String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonProgressStyle.jdField_b_of_type_Float);
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
      {
        float f2 = ParseUtil.a((String)localObject2, 0.0F);
        float f1 = f2;
        if (f2 > 2.0F) {
          f1 = 2.0F;
        }
        localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).width = (paramCommonProgressStyle.width + AIOUtils.b(f1, this.jdField_a_of_type_AndroidContentContext.getResources()) * 2);
        ((RelativeLayout.LayoutParams)localObject2).height = (paramCommonProgressStyle.height + AIOUtils.b(f1, this.jdField_a_of_type_AndroidContentContext.getResources()) * 2);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        PublicDrawableUtil.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, AIOUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonProgressStyle.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidContentContext.getResources()), ParseUtil.a((String)localObject1, "#12B7F5"), AIOUtils.b(f1, this.jdField_a_of_type_AndroidContentContext.getResources()));
      }
    }
    else if ((paramCommonProgressStyle.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress == null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress = new ReadInjoyHeaderAdDownloadView.SimpleRoundProgress(getContext());
      ReadInJoyCommonSoftAdUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress);
      paramCommonProgressStyle = new RelativeLayout.LayoutParams(AIOUtils.b(25.0F, getContext().getResources()), AIOUtils.b(25.0F, getContext().getResources()));
      paramCommonProgressStyle.rightMargin = AIOUtils.b(10.0F, getContext().getResources());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress, paramCommonProgressStyle);
    }
  }
  
  public void setText(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if (this.jdField_a_of_type_Int != 1) {
        return;
      }
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonProgressStyle;
      if ((localObject != null) && (!((CommonProgressStyle)localObject).jdField_a_of_type_Boolean))
      {
        localObject = this.jdField_a_of_type_AndroidWidgetTextView;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt);
        localStringBuilder.append("%");
        ((TextView)localObject).setText(localStringBuilder.toString());
        return;
      }
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131707099));
      localStringBuilder.append(paramInt);
      localStringBuilder.append("%");
      ((TextView)localObject).setText(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.view.NativeAdDownloadView
 * JD-Core Version:    0.7.0.1
 */