package com.tencent.biz.pubaccount.readinjoy.proteus.listeners;

import android.content.Context;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class OnTopicRecommendHeaderFollowClickListener
  implements ViewBase.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private TopicRecommendFeedsInfo.TopicRecommendInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendInfo;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  
  public OnTopicRecommendHeaderFollowClickListener(ArticleInfo paramArticleInfo, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramArticleInfo);
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.a != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.a.size() > 0)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendInfo = ((TopicRecommendFeedsInfo.TopicRecommendInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.a.get(0));
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = ReadInJoyUtils.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendInfo != null)
    {
      localObject = ((AppRuntime)localObject).getAccount();
      if (QLog.isColorLevel()) {
        QLog.d("OnTopicRecommendHeaderFollowClickListener", 2, "before request0x978 articleInfo articleID = ，isfollow = " + paramBoolean + " businessId = " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendInfo.a);
      }
      if (paramBoolean) {
        ReadInJoyLogicEngine.a().a().a((String)localObject, Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendInfo.a), true, "", new OnTopicRecommendHeaderFollowClickListener.3(this, paramBoolean), 3);
      }
    }
    else
    {
      return;
    }
    ReadInJoyLogicEngine.a().a().a((String)localObject, Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendInfo.a), false, "", new OnTopicRecommendHeaderFollowClickListener.4(this, paramBoolean), 3);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendInfo == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendInfo.c != 1) {
        break;
      }
    } while (RIJFeedsType.u(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    a();
    return;
    a(true);
    if (!RIJFeedsType.u(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
    {
      str1 = RIJFeedsType.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      String str2 = RIJTransMergeKanDianReport.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID, RIJFeedsType.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID, NetworkUtil.h(this.jdField_a_of_type_AndroidContentContext), str1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessId + "");
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, str1, "0X8008A61", "0X8008A61", 0, 0, Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId), Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID), str2, false);
      RIJFrameworkReportManager.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
      return;
    }
    if (ReadinjoyReportUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID)) {}
    for (String str1 = "0X800941D";; str1 = "0X80080EC")
    {
      RIJFrameworkReportManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, str1, str1, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
      ReadInJoyLogicEngine.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      break;
    }
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131695268, 3);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690800);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new OnTopicRecommendHeaderFollowClickListener.1(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new OnTopicRecommendHeaderFollowClickListener.2(this));
    if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnTopicRecommendHeaderFollowClickListener
 * JD-Core Version:    0.7.0.1
 */