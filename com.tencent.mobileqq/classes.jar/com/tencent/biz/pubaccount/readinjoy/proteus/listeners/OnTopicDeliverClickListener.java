package com.tencent.biz.pubaccount.readinjoy.proteus.listeners;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class OnTopicDeliverClickListener
  implements ViewBase.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private String jdField_a_of_type_JavaLangString;
  
  public OnTopicDeliverClickListener(ArticleInfo paramArticleInfo, Context paramContext, int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void a()
  {
    JumpAction localJumpAction = JumpParser.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
    if (localJumpAction != null) {
      localJumpAction.a();
    }
  }
  
  private void a(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("algorithm_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID + "");
      localJSONObject.put("folder_status", RIJKanDianFolderStatus.jdField_a_of_type_Int);
      localJSONObject.put("feeds_type", RIJFeedsType.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
      localJSONObject.put("channel_id", "" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
      localJSONObject.put("feeds_source", RIJFeedsType.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
      localJSONObject.put("imei", ReadInJoyUtils.b());
      localJSONObject.put("imsi", ReadInJoyUtils.c());
      localJSONObject.put("rowkey", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
      localJSONObject.put("comment", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaLangString);
      localJSONObject.put("topic_id", "" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessId);
      localJSONObject.put("kandian_mode", "" + RIJAppSetting.a());
      localJSONObject.put("mark_type", paramString);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, String.valueOf(RIJItemViewType.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Int)), "0X80097CB", "0X80097CB", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), localJSONObject.toString(), false);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("OnTopicDeliverClickListener", 2, "report error:" + paramString.toString());
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$WendaInfo != null) && ((this.jdField_a_of_type_Int == 72) || (this.jdField_a_of_type_Int == 73)))
      {
        a("4");
        return;
      }
    } while (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString));
    a();
    try
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.proteusItemsData)) {
        break label130;
      }
      paramViewBase = new JSONObject(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.proteusItemsData).optString("biz_type", "");
      boolean bool = TextUtils.isEmpty(paramViewBase);
      if (bool) {
        break label130;
      }
    }
    catch (Exception paramViewBase)
    {
      for (;;)
      {
        QLog.d("OnTopicDeliverClickListener", 2, "OnTopicDeliverClickListener", paramViewBase);
        paramViewBase = "1";
      }
    }
    a(paramViewBase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnTopicDeliverClickListener
 * JD-Core Version:    0.7.0.1
 */