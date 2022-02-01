package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuBehaviour;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnBiuClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ColorUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.ButtonBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.ButtonBase.ClickStatus;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.mobileqq.qroute.QRoute;

public class ReadInJoyBiuButton
  extends ButtonBase
  implements View.OnLongClickListener
{
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ReadInJoyBiuButton.NativeBiuButton jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewReadInJoyBiuButton$NativeBiuButton;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  
  public ReadInJoyBiuButton(VafContext paramVafContext)
  {
    super(paramVafContext);
    a(paramVafContext);
  }
  
  private void a(VafContext paramVafContext)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramVafContext.getContext());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewReadInJoyBiuButton$NativeBiuButton = new ReadInJoyBiuButton.NativeBiuButton(paramVafContext.getContext());
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramVafContext.getContext());
    paramVafContext = new LinearLayout.LayoutParams(-2, -2);
    paramVafContext.gravity = 16;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewReadInJoyBiuButton$NativeBiuButton, paramVafContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, paramVafContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnLongClickListener(this);
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null)) {
      return;
    }
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    if (ReadinjoyReportUtils.a(paramArticleInfo.mChannelID)) {}
    String str2;
    for (String str1 = "0X8009361";; str1 = "0X8007EE4")
    {
      str2 = RIJTransMergeKanDianReport.a(paramArticleInfo, true);
      if ((!RIJItemViewType.i(paramArticleInfo)) && (!RIJItemViewType.g(paramArticleInfo)) && (!RIJItemViewType.j(paramArticleInfo)) && (!RIJItemViewType.k(paramArticleInfo))) {
        break label164;
      }
      if (!RIJItemViewType.o(paramArticleInfo)) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long), str1, str1, 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), "0", "" + paramArticleInfo.mStrategyId, str2, false);
      }
      if ((RIJFeedsType.l(paramArticleInfo)) || (RIJFeedsType.m(paramArticleInfo))) {
        break;
      }
      RIJFrameworkReportManager.b(paramArticleInfo, (int)paramArticleInfo.mChannelID);
      return;
    }
    label164:
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, paramArticleInfo.mSubscribeID, str1, str1, 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, str2, false);
  }
  
  public int getComMeasuredHeight()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.measure(paramInt1, paramInt2);
  }
  
  public boolean onLongClick(View paramView)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.b())) {
      return false;
    }
    paramView = paramView.getContext();
    Intent localIntent;
    if (((paramView instanceof Activity)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null))
    {
      paramView = (Activity)paramView;
      localIntent = OnBiuClickListener.a(paramView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      if (BiuBehaviour.b() != 1) {
        break label103;
      }
    }
    for (;;)
    {
      localIntent.putExtra("fast_biu_type", bool);
      paramView.startActivity(localIntent);
      paramView.overridePendingTransition(0, 0);
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      return false;
      label103:
      bool = false;
    }
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.mTextSize);
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding(this.mCompoundDrawablePadding, 0, 0, 0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.mText);
  }
  
  public void refresh()
  {
    super.refresh();
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return super.setAttribute(paramInt, paramObject);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)paramObject);
    }
  }
  
  public void setBackgroundColorForStates() {}
  
  public void setBackgroundForStates()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext();
    localObject = DrawableUtil.getSelector(DrawableUtil.getDrawable((Context)localObject, getStatus(0).background, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER), DrawableUtil.getDrawable((Context)localObject, getStatus(1).background, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER), DrawableUtil.getDrawable((Context)localObject, getStatus(4).background, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable((Drawable)localObject);
  }
  
  public void setCompoundDrawableForStates()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext();
    localObject = DrawableUtil.getSelector(DrawableUtil.getDrawable((Context)localObject, getStatus(0).img, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER), DrawableUtil.getDrawable((Context)localObject, getStatus(1).img, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER), DrawableUtil.getDrawable((Context)localObject, getStatus(4).img, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewReadInJoyBiuButton$NativeBiuButton.setImageDrawable((Drawable)localObject);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    if (!TextUtils.equals(paramCharSequence, this.mText))
    {
      this.mText = paramCharSequence;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    }
  }
  
  public void setTextColorForStates()
  {
    ColorStateList localColorStateList = ColorUtil.getColorStateList(getStatus(0).textColor, getStatus(1).textColor, getStatus(4).textColor);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(localColorStateList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyBiuButton
 * JD-Core Version:    0.7.0.1
 */