package com.tencent.biz.pubaccount.subscript;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mqpsdk.util.NetUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x439.oidb_cmd0x439.ArticleInfo;
import tencent.im.oidb.cmd0x439.oidb_cmd0x439.ReqBody;
import tencent.im.oidb.cmd0x439.oidb_cmd0x439.RspBody;
import tencent.im.oidb.cmd0x439.oidb_cmd0x439.SubscribeInfo;
import tencent.im.oidb.cmd0x472.Oidb_0x472.ArticleSummary;
import tencent.im.oidb.cmd0x472.Oidb_0x472.RspBody;
import tencent.im.oidb.cmd0x472.Oidb_0x472.RspChannelArticle;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class SubscriptHandler
  extends BusinessHandler
{
  public SubscriptHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public static ReadInJoyArticle a(Oidb_0x472.ArticleSummary paramArticleSummary, int paramInt)
  {
    Object localObject;
    if (paramArticleSummary == null) {
      localObject = null;
    }
    ReadInJoyArticle localReadInJoyArticle;
    do
    {
      do
      {
        return localObject;
        localReadInJoyArticle = new ReadInJoyArticle();
        localReadInJoyArticle.mChannelID = paramInt;
        if (paramArticleSummary.uint64_article_id.has()) {
          localReadInJoyArticle.mArticleID = paramArticleSummary.uint64_article_id.get();
        }
        if ((paramArticleSummary.bytes_article_title.has()) && (paramArticleSummary.bytes_article_title.get() != null)) {
          localReadInJoyArticle.mTitle = paramArticleSummary.bytes_article_title.get().toStringUtf8();
        }
        if ((paramArticleSummary.bytes_article_summary.has()) && (paramArticleSummary.bytes_article_summary.get() != null)) {
          localReadInJoyArticle.mSummary = paramArticleSummary.bytes_article_summary.get().toStringUtf8();
        }
        localObject = localReadInJoyArticle;
      } while (!paramArticleSummary.bytes_first_page_pic_url.has());
      localObject = localReadInJoyArticle;
    } while (paramArticleSummary.bytes_first_page_pic_url.get() == null);
    localReadInJoyArticle.mFirstPagePicUrl = paramArticleSummary.bytes_first_page_pic_url.get().toStringUtf8();
    return localReadInJoyArticle;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = false;
    boolean bool2 = true;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SubscriptHandler", 2, "handleGetRecommendList onReceive :" + bool1);
      }
      if (bool1) {
        break;
      }
      return;
    }
    paramFromServiceMsg = null;
    for (;;)
    {
      int i;
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        i = paramToServiceMsg.uint32_result.get();
        if (!ReadInJoyHelper.b()) {
          break label741;
        }
        QLog.i("SubscriptHandler", 2, "result: " + i);
      }
      catch (Exception paramToServiceMsg) {}
      if (!bool1) {
        break;
      }
      paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
      Object localObject1 = new oidb_cmd0x439.RspBody();
      ((oidb_cmd0x439.RspBody)localObject1).mergeFrom(paramToServiceMsg);
      paramObject = "";
      paramToServiceMsg = paramObject;
      if (((oidb_cmd0x439.RspBody)localObject1).bytes_subscribe_detail_url_pre.has())
      {
        paramToServiceMsg = paramObject;
        if (((oidb_cmd0x439.RspBody)localObject1).bytes_subscribe_detail_url_pre.get() != null) {
          paramToServiceMsg = ((oidb_cmd0x439.RspBody)localObject1).bytes_subscribe_detail_url_pre.get().toStringUtf8();
        }
      }
      if ((((oidb_cmd0x439.RspBody)localObject1).rpt_msg_subscribe_info.has()) && (((oidb_cmd0x439.RspBody)localObject1).rpt_msg_subscribe_info.get() != null))
      {
        paramObject = ((oidb_cmd0x439.RspBody)localObject1).rpt_msg_subscribe_info.get();
        paramFromServiceMsg = new ArrayList(paramObject.size());
        paramObject = paramObject.iterator();
        if (paramObject.hasNext())
        {
          Object localObject2 = (oidb_cmd0x439.SubscribeInfo)paramObject.next();
          localObject1 = new SubscriptRecommendAccountInfo();
          if (((oidb_cmd0x439.SubscribeInfo)localObject2).uint64_subscribe_id.has())
          {
            ((SubscriptRecommendAccountInfo)localObject1).jdField_a_of_type_Long = ((oidb_cmd0x439.SubscribeInfo)localObject2).uint64_subscribe_id.get();
            if ((((SubscriptRecommendAccountInfo)localObject1).jdField_a_of_type_Long > 0L) && (!TextUtils.isEmpty(paramToServiceMsg))) {
              ((SubscriptRecommendAccountInfo)localObject1).b = (paramToServiceMsg + ((SubscriptRecommendAccountInfo)localObject1).jdField_a_of_type_Long);
            }
          }
          if ((((oidb_cmd0x439.SubscribeInfo)localObject2).bytes_subscribe_name.has()) && (((oidb_cmd0x439.SubscribeInfo)localObject2).bytes_subscribe_name.get() != null)) {
            ((SubscriptRecommendAccountInfo)localObject1).jdField_a_of_type_JavaLangString = ((oidb_cmd0x439.SubscribeInfo)localObject2).bytes_subscribe_name.get().toStringUtf8();
          }
          if ((((oidb_cmd0x439.SubscribeInfo)localObject2).rpt_article_list.has()) && (((oidb_cmd0x439.SubscribeInfo)localObject2).rpt_article_list.get() != null))
          {
            Object localObject3 = ((oidb_cmd0x439.SubscribeInfo)localObject2).rpt_article_list.get();
            if (!((List)localObject3).isEmpty())
            {
              localObject2 = new ReadInJoyArticle();
              localObject3 = (oidb_cmd0x439.ArticleInfo)((List)localObject3).get(0);
              if (((oidb_cmd0x439.ArticleInfo)localObject3).uint64_article_id.has()) {
                ((ReadInJoyArticle)localObject2).mArticleID = ((oidb_cmd0x439.ArticleInfo)localObject3).uint64_article_id.get();
              }
              if ((((oidb_cmd0x439.ArticleInfo)localObject3).bytes_article_subject.has()) && (((oidb_cmd0x439.ArticleInfo)localObject3).bytes_article_subject.get() != null)) {
                ((ReadInJoyArticle)localObject2).mTitle = ((oidb_cmd0x439.ArticleInfo)localObject3).bytes_article_subject.get().toStringUtf8();
              }
              if ((((oidb_cmd0x439.ArticleInfo)localObject3).bytes_article_url.has()) && (((oidb_cmd0x439.ArticleInfo)localObject3).bytes_article_url.get() != null)) {
                ((ReadInJoyArticle)localObject2).mArticleUrl = ((oidb_cmd0x439.ArticleInfo)localObject3).bytes_article_url.get().toStringUtf8();
              }
              if ((((oidb_cmd0x439.ArticleInfo)localObject3).bytes_article_sum_pic.has()) && (((oidb_cmd0x439.ArticleInfo)localObject3).bytes_article_sum_pic.get() != null)) {
                ((ReadInJoyArticle)localObject2).mFirstPagePicUrl = ((oidb_cmd0x439.ArticleInfo)localObject3).bytes_article_sum_pic.get().toStringUtf8();
              }
              ((SubscriptRecommendAccountInfo)localObject1).jdField_a_of_type_ComTencentBizPubaccountSubscriptReadInJoyArticle = ((ReadInJoyArticle)localObject2);
            }
          }
          if (QLog.isColorLevel()) {
            QLog.i("SubscriptHandler", 2, "handleGetRecommendList create SubscriptRecommendAccountInfo id: " + ((SubscriptRecommendAccountInfo)localObject1).jdField_a_of_type_Long + " | name: " + ((SubscriptRecommendAccountInfo)localObject1).jdField_a_of_type_JavaLangString + " | article: " + ((SubscriptRecommendAccountInfo)localObject1).jdField_a_of_type_ComTencentBizPubaccountSubscriptReadInJoyArticle.mTitle);
          }
          paramFromServiceMsg.add(localObject1);
          continue;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("SubscriptHandler", 2, "handleGetRecommendList onReceive fail: ", paramToServiceMsg);
          return;
        }
        paramToServiceMsg = paramFromServiceMsg;
        bool1 = bool2;
      }
      for (;;)
      {
        if ((paramToServiceMsg != null) && (!paramToServiceMsg.isEmpty()))
        {
          super.notifyUI(1, bool1, paramToServiceMsg);
          return;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("SubscriptHandler", 2, "handleGetRecommendList onReceive fail, list is null");
        return;
        paramToServiceMsg = paramFromServiceMsg;
      }
      label741:
      bool1 = bool3;
      if (i == 0) {
        bool1 = true;
      }
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = true;
    boolean bool1;
    boolean bool2;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      paramFromServiceMsg = null;
      if (QLog.isColorLevel()) {
        QLog.d("SubscriptHandler", 2, "handleGetReadinjoyRecommentList onReceive :" + bool1);
      }
      bool2 = bool1;
      if (bool1) {
        bool2 = bool1;
      }
    }
    else
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        bool2 = bool1;
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        bool2 = bool1;
        int i = paramToServiceMsg.uint32_result.get();
        if (i == 0)
        {
          bool1 = true;
          label110:
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            bool2 = bool1;
            QLog.e("SubscriptHandler", 2, "result: " + i);
          }
          bool2 = bool1;
          if (!bool1) {
            break label413;
          }
          bool2 = bool1;
          paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
          bool2 = bool1;
          paramObject = new Oidb_0x472.RspBody();
          bool2 = bool1;
          paramObject.mergeFrom(paramToServiceMsg);
          bool2 = bool1;
          boolean bool4 = paramObject.rspChannelArticle.has();
          bool2 = bool1;
          if (!bool4) {
            break label413;
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        for (;;)
        {
          long l;
          label331:
          label346:
          bool1 = bool2;
        }
      }
      try
      {
        paramToServiceMsg = (Oidb_0x472.RspChannelArticle)paramObject.rspChannelArticle.get();
        if (paramToServiceMsg == null) {
          break label405;
        }
        l = paramToServiceMsg.uint64_channel_id.get();
        if (l != 0L) {
          break label405;
        }
        paramObject = paramToServiceMsg.rpt_article_list.get();
        if ((paramObject == null) || (paramObject.isEmpty())) {
          break label405;
        }
        paramToServiceMsg = new ArrayList(paramObject.size());
        try
        {
          paramFromServiceMsg = paramObject.iterator();
          while (paramFromServiceMsg.hasNext()) {
            paramToServiceMsg.add(a((Oidb_0x472.ArticleSummary)paramFromServiceMsg.next(), (int)l));
          }
          if (!QLog.isColorLevel()) {
            break label346;
          }
        }
        catch (Exception paramObject)
        {
          bool1 = false;
          paramFromServiceMsg = paramToServiceMsg;
          paramToServiceMsg = paramObject;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        bool1 = false;
        break label331;
        paramToServiceMsg = null;
        bool1 = false;
        break label348;
      }
      QLog.e("SubscriptHandler", 2, "handleGetRecommendList onReceive fail: ", paramToServiceMsg);
      paramToServiceMsg = paramFromServiceMsg;
    }
    for (;;)
    {
      label348:
      if (!bool1) {
        paramToServiceMsg = new ArrayList(0);
      }
      super.notifyUI(2, bool1, paramToServiceMsg);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label110;
      bool1 = bool3;
      continue;
      label405:
      label413:
      bool1 = bool2;
      paramToServiceMsg = null;
    }
  }
  
  public void a(String paramString)
  {
    int i = 1;
    if (QLog.isDevelopLevel()) {
      QLog.d("SubscriptHandler", 4, "getRecommendListAsync() start uinStr: " + paramString);
    }
    paramString = new oidb_cmd0x439.ReqBody();
    paramString.uint32_want_count.set(0);
    paramString.uint32_req_subscribe_info.set(1);
    paramString.uint32_req_article_info.set(1);
    paramString.uint32_version.set(1);
    paramString.uint32_comefrom.set(2);
    switch (NetUtil.a(null))
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      paramString.uint32_network_type.set(i);
      super.sendPbReq(super.makeOIDBPkg("OidbSvc.1081", 1081, 0, paramString.toByteArray()));
      return;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
    }
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return SubscriptObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("OidbSvc.1081".equalsIgnoreCase(str)) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    while (!"OidbSvc.0x472".equalsIgnoreCase(str)) {
      return;
    }
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptHandler
 * JD-Core Version:    0.7.0.1
 */