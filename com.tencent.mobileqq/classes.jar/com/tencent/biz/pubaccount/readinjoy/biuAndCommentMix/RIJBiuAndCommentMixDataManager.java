package com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xe16.oidb_cmd0xe16.CardJumpInfo;
import tencent.im.oidb.cmd0xe16.oidb_cmd0xe16.KeyInfo;
import tencent.im.oidb.cmd0xe16.oidb_cmd0xe16.RspBody;

public class RIJBiuAndCommentMixDataManager
  implements RIJBiuAndCommentMixPBModule.BiuAndCommentPBObserver
{
  private RIJBiuAndCommentMixDataManager.BiuAndCommentListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixDataManager$BiuAndCommentListener;
  private RIJBiuAndCommentMixPBModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixPBModule;
  
  public RIJBiuAndCommentMixDataManager()
  {
    Object localObject = RIJQQAppInterfaceUtil.a();
    if (localObject != null)
    {
      localObject = (ReadInJoyLogicManager)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixPBModule = ((ReadInJoyLogicManager)localObject).a().a();
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixPBModule != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixPBModule.a(this);
        }
        QLog.d("RIJBiuAndCommentMixDataManager", 1, "RIJBiuAndCommentMixDataManager init");
      }
    }
  }
  
  private RIJBiuAndCommentRespData a(oidb_cmd0xe16.RspBody paramRspBody, int paramInt, ToServiceMsg paramToServiceMsg)
  {
    RIJBiuAndCommentRespData localRIJBiuAndCommentRespData = new RIJBiuAndCommentRespData();
    localRIJBiuAndCommentRespData.a(paramInt);
    if (paramRspBody.msg_key_info.has())
    {
      if (paramRspBody.msg_key_info.uint64_feeds_id.has()) {
        localRIJBiuAndCommentRespData.b(String.valueOf(paramRspBody.msg_key_info.uint64_feeds_id.get()));
      }
      if (paramRspBody.msg_key_info.uint32_feeds_type.has()) {
        localRIJBiuAndCommentRespData.b(paramRspBody.msg_key_info.uint32_feeds_type.get());
      }
      if ((!paramRspBody.msg_key_info.str_sub_comment_id.has()) || (TextUtils.isEmpty(paramRspBody.msg_key_info.str_sub_comment_id.get()))) {
        break label455;
      }
      localRIJBiuAndCommentRespData.a(paramRspBody.msg_key_info.str_sub_comment_id.get());
    }
    for (;;)
    {
      if (paramRspBody.msg_card_jump_info.has())
      {
        if ((paramRspBody.msg_card_jump_info.bytes_card_jump_url.has()) && (!TextUtils.isEmpty(paramRspBody.msg_card_jump_info.bytes_card_jump_url.get().toStringUtf8()))) {
          localRIJBiuAndCommentRespData.h(paramRspBody.msg_card_jump_info.bytes_card_jump_url.get().toStringUtf8());
        }
        if ((paramRspBody.msg_card_jump_info.bytes_comment_btn_url.has()) && (!TextUtils.isEmpty(paramRspBody.msg_card_jump_info.bytes_comment_btn_url.get().toStringUtf8()))) {
          localRIJBiuAndCommentRespData.i(paramRspBody.msg_card_jump_info.bytes_comment_btn_url.get().toStringUtf8());
        }
        if (paramRspBody.msg_card_jump_info.uint32_available.has()) {
          localRIJBiuAndCommentRespData.e(paramRspBody.msg_card_jump_info.uint32_available.get());
        }
        if (paramRspBody.msg_card_jump_info.bytes_share_url.has()) {
          localRIJBiuAndCommentRespData.c(paramRspBody.msg_card_jump_info.bytes_share_url.get().toStringUtf8());
        }
      }
      if ((paramToServiceMsg != null) && (paramToServiceMsg.getAttributes() != null))
      {
        paramRspBody = (RIJBiuAndCommentRequestData)paramToServiceMsg.getAttributes().get("request_data_entry");
        if (paramRspBody != null)
        {
          localRIJBiuAndCommentRespData.d(paramRspBody.getContentString());
          localRIJBiuAndCommentRespData.d(paramRspBody.getListShowType());
          localRIJBiuAndCommentRespData.c(paramRspBody.getCommentType());
          localRIJBiuAndCommentRespData.e(paramRspBody.getReplyCommentId());
          localRIJBiuAndCommentRespData.f(paramRspBody.getReplyParentCommentId());
          localRIJBiuAndCommentRespData.g(paramRspBody.getReplyUin());
          localRIJBiuAndCommentRespData.a(paramRspBody.isIsSecondReply());
          localRIJBiuAndCommentRespData.f(paramRspBody.getContentSrc());
        }
        paramRspBody = paramToServiceMsg.getAttributes().get("article_attributes");
        if ((paramRspBody instanceof ArticleInfo)) {
          localRIJBiuAndCommentRespData.a((ArticleInfo)paramRspBody);
        }
      }
      QLog.d("RIJBiuAndCommentMixDataManager", 1, "onBiuAndCommentMixSend RIJBiuAndCommentRespData info is" + localRIJBiuAndCommentRespData.toString());
      return localRIJBiuAndCommentRespData;
      label455:
      if ((paramRspBody.msg_key_info.str_comment_id.has()) && (!TextUtils.isEmpty(paramRspBody.msg_key_info.str_comment_id.get()))) {
        localRIJBiuAndCommentRespData.a(paramRspBody.msg_key_info.str_comment_id.get());
      }
    }
  }
  
  private void a(RIJBiuAndCommentRespData paramRIJBiuAndCommentRespData)
  {
    if ((paramRIJBiuAndCommentRespData == null) || (paramRIJBiuAndCommentRespData.a() == null))
    {
      QLog.d("RIJBiuAndCommentMixDataManager", 2, "reportMixCommentBiuResult | respData or mArticleInfo is null");
      return;
    }
    ArticleInfo localArticleInfo = paramRIJBiuAndCommentRespData.a();
    paramRIJBiuAndCommentRespData = "";
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("rowkey", localArticleInfo.innerUniqueID);
      ((JSONObject)localObject).put("article_id", localArticleInfo.mArticleID);
      ((JSONObject)localObject).put("content_type", 1);
      ((JSONObject)localObject).put("time", System.currentTimeMillis() / 1000L);
      localObject = ((JSONObject)localObject).toString();
      paramRIJBiuAndCommentRespData = (RIJBiuAndCommentRespData)localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.d("RIJBiuAndCommentMixDataManager", 2, localJSONException.getMessage());
      }
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyCommentUtils.a(localArticleInfo), "0X800AC6A", "0X800AC6A", 0, 0, String.valueOf(localArticleInfo.mArticleID), "", localArticleInfo.innerUniqueID, paramRIJBiuAndCommentRespData, false);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean, String paramString3, String paramString4, ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      QLog.d("RIJBiuAndCommentMixDataManager", 1, "createLocalComment article info is null");
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("comment", paramString1);
      localJSONObject.put("commentId", paramString3);
      localJSONObject.put("isSecondReply", paramBoolean);
      localJSONObject.put("replyUin", paramString4);
      paramString1 = ReadInJoyCommentDataManager.a(paramArticleInfo);
      if (paramString1 != null) {
        paramString1.a(paramString1.a(paramInt1, localJSONObject.toString()), paramString2, paramInt2);
      }
      return;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixPBModule.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixPBModule = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixDataManager$BiuAndCommentListener = null;
    QLog.d("RIJBiuAndCommentMixDataManager", 1, "onDestroy clear info");
  }
  
  public void a(RIJBiuAndCommentMixDataManager.BiuAndCommentListener paramBiuAndCommentListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixDataManager$BiuAndCommentListener = paramBiuAndCommentListener;
    QLog.d("RIJBiuAndCommentMixDataManager", 1, "setBiuAndCommentListener");
  }
  
  public void a(ArticleInfo paramArticleInfo, RIJBiuAndCommentRequestData paramRIJBiuAndCommentRequestData)
  {
    if ((paramArticleInfo == null) || (paramRIJBiuAndCommentRequestData == null)) {
      QLog.d("RIJBiuAndCommentMixDataManager", 1, "requestCreateBiuAndCommentMixComment someThing is null");
    }
    while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixPBModule == null) {
      return;
    }
    QLog.d("RIJBiuAndCommentMixDataManager", 1, "requestCreateBiuAndCommentMixComment goTo pbRequest");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixPBModule.a(paramArticleInfo, paramRIJBiuAndCommentRequestData);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xe16.RspBody localRspBody = new oidb_cmd0xe16.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, localRspBody);
    paramToServiceMsg = a(localRspBody, i, paramToServiceMsg);
    ThreadManager.getUIHandler().post(new RIJBiuAndCommentMixDataManager.1(this, paramToServiceMsg, i));
    if (i == 0) {
      a(paramToServiceMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix.RIJBiuAndCommentMixDataManager
 * JD-Core Version:    0.7.0.1
 */