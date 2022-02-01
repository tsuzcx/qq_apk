package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView.ClickableSpanPressed;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.TimeUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class ComponentAccountSummary$ReadArticleSpan
  extends ClickableSpan
  implements ReadInJoyYAFolderTextView.ClickableSpanPressed
{
  public int a;
  Context jdField_a_of_type_AndroidContentContext;
  Resources jdField_a_of_type_AndroidContentResResources;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  CmpCtxt jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt;
  ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  boolean jdField_a_of_type_Boolean;
  private int b = -1;
  
  public ComponentAccountSummary$ReadArticleSpan(ArticleInfo paramArticleInfo, int paramInt, Context paramContext, Resources paramResources, CmpCtxt paramCmpCtxt)
  {
    this.jdField_a_of_type_Int = 16;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.b = paramInt;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidContentResResources = paramResources;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt = paramCmpCtxt;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      int j = -1;
      int i = j;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt != null)
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a != null) {
          i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e();
        }
      }
      RIJFrameworkReportManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, i);
      return;
    }
    QLog.d("Q.readinjoy.ui", 1, "ComponentAccountSummary report click read article data, articleInfo is null!");
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    TimeUtil.b("fast_web_show_light_house_1");
    ReadInJoyLogicEngine.a().a().a(paramArticleInfo.mArticleContentUrl, String.valueOf(paramArticleInfo.innerUniqueID), paramArticleInfo.mSubscribeID, 1, null);
    a(paramArticleInfo, null);
  }
  
  private void a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    RIJJumpUtils.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramArticleInfo);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_AndroidTextTextPaint != null) {
      updateDrawState(this.jdField_a_of_type_AndroidTextTextPaint);
    }
  }
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl))
    {
      if (!RIJFeedsType.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
        break label167;
      }
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    }
    for (;;)
    {
      a();
      if ((RIJFeedsType.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (RIJFeedsType.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, RIJFeedsType.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8008A62", "0X8008A62", 0, 0, Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId), Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), Integer.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), RIJTransMergeKanDianReport.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessId + "", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), false);
      }
      return;
      label167:
      ReadInJoyUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    this.jdField_a_of_type_AndroidTextTextPaint = paramTextPaint;
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-14132075);
    paramTextPaint = this.jdField_a_of_type_AndroidTextTextPaint;
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = this.b;; i = 16777215)
    {
      paramTextPaint.bgColor = i;
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(AIOUtils.a(2, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentResResources));
      this.jdField_a_of_type_AndroidTextTextPaint.setUnderlineText(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentAccountSummary.ReadArticleSpan
 * JD-Core Version:    0.7.0.1
 */