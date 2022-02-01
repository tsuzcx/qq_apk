package com.tencent.biz.pubaccount.readinjoy.proteus.listeners;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuBehaviour;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInjoyFeedsUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class OnBiuClickListener
  extends OnSocialOperationListener
{
  public OnBiuClickListener(ArticleInfo paramArticleInfo, Context paramContext)
  {
    super(paramArticleInfo, paramContext);
  }
  
  public static Intent a(Activity paramActivity, ArticleInfo paramArticleInfo)
  {
    paramActivity = new Intent(paramActivity, ReadInJoyDeliverBiuActivity.class);
    paramActivity.putExtra("arg_article_info", paramArticleInfo);
    paramActivity.putExtra("feedsType", paramArticleInfo.mFeedType);
    if (paramArticleInfo.mChannelID == 70L)
    {
      paramActivity.putExtra("biu_src", 9);
      paramActivity.putExtra("arg_from_type", 14);
    }
    for (;;)
    {
      if (RIJItemViewType.o(paramArticleInfo)) {
        paramActivity.putExtra("biu_src", 2);
      }
      if (ReadInjoyFeedsUtils.a(paramArticleInfo)) {
        paramActivity.putExtra("arg_type", 4);
      }
      return paramActivity;
      paramActivity.putExtra("biu_src", 1);
      paramActivity.putExtra("arg_from_type", 1);
    }
  }
  
  private void a()
  {
    boolean bool = true;
    Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
    Intent localIntent = a(localActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    if (BiuBehaviour.a() == 1) {}
    for (;;)
    {
      localIntent.putExtra("fast_biu_type", bool);
      localActivity.startActivity(localIntent);
      localActivity.overridePendingTransition(0, 0);
      return;
      bool = false;
    }
  }
  
  protected int a()
  {
    return 25;
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    if (ReadinjoyReportUtils.a(paramArticleInfo.mChannelID)) {}
    String str2;
    for (String str1 = "0X8009361";; str1 = "0X8007EE4")
    {
      str2 = RIJTransMergeKanDianReport.a(paramArticleInfo);
      if ((!RIJItemViewType.i(paramArticleInfo)) && (!RIJItemViewType.g(paramArticleInfo)) && (!RIJItemViewType.j(paramArticleInfo)) && (!RIJItemViewType.k(paramArticleInfo))) {
        break;
      }
      if (!RIJItemViewType.o(paramArticleInfo)) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long), str1, str1, 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), "0", "" + paramArticleInfo.mStrategyId, str2, false);
      }
      if ((!RIJFeedsType.l(paramArticleInfo)) && (!RIJFeedsType.m(paramArticleInfo))) {
        RIJFrameworkReportManager.b(paramArticleInfo, (int)paramArticleInfo.mChannelID);
      }
      return;
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, paramArticleInfo.mSubscribeID, str1, str1, 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, str2, false);
  }
  
  protected void a(ViewBase paramViewBase)
  {
    QLog.d("OnBiuClickListener", 1, "click biu");
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.b())) {
      QQToast.a(BaseApplicationImpl.sApplication, 0, 2131718323, 0).a();
    }
    while ((!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)) {
      return;
    }
    RIJUserLevelModule.a().a(this.jdField_a_of_type_AndroidContentContext, 2, new OnBiuClickListener.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnBiuClickListener
 * JD-Core Version:    0.7.0.1
 */