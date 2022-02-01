package com.tencent.biz.pubaccount.readinjoy.proteus.listeners;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.qphone.base.util.QLog;

public class OnTopicCapsuleClickListener
  implements ViewBase.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  
  public OnTopicCapsuleClickListener(ArticleInfo paramArticleInfo, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {}
    String str;
    do
    {
      return;
      str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessUrl;
      if (QLog.isColorLevel()) {
        QLog.d("OnTopicCapsuleClickListener", 2, "business url is " + str);
      }
    } while ((TextUtils.isEmpty(str)) || (this.jdField_a_of_type_AndroidContentContext == null));
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.jdField_a_of_type_AndroidContentContext, "/pubaccount/browser");
    localActivityURIRequest.extra().putString("url", str);
    QRoute.startUri(localActivityURIRequest, null);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportLabelsClick(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    RIJFrameworkReportManager.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnTopicCapsuleClickListener
 * JD-Core Version:    0.7.0.1
 */