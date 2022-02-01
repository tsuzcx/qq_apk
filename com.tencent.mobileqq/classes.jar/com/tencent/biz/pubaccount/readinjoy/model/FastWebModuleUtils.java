package com.tencent.biz.pubaccount.readinjoy.model;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ArticleTopicData.TopicInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebPTSDataConverter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.ArticleBusiness;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.RspBiuCount;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.RspBody;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.RspTopic;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.SentimentEntityData;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.StyleCard;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.Topic;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.UnionNlpInfo;

public class FastWebModuleUtils
{
  static void a(oidb_cmd0xb54.RspBody paramRspBody, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (paramRspBody.bytes_proteus_json_data.has())
    {
      paramRspBody = paramRspBody.bytes_proteus_json_data.get().toStringUtf8();
      if (!TextUtils.isEmpty(paramRspBody))
      {
        paramFastWebArticleInfo.jdField_a_of_type_AndroidUtilSparseArray.clear();
        FastWebPTSDataConverter.a(paramRspBody, paramFastWebArticleInfo.jdField_a_of_type_AndroidUtilSparseArray);
      }
    }
  }
  
  static void a(oidb_cmd0xb54.RspBody paramRspBody, FastWebArticleInfo paramFastWebArticleInfo, FastWebModule.FastWebArticleRichReqCallback paramFastWebArticleRichReqCallback)
  {
    if (paramRspBody.rpt_msg_style_card.has())
    {
      paramRspBody = paramRspBody.rpt_msg_style_card.get().iterator();
      while (paramRspBody.hasNext())
      {
        Object localObject = (oidb_cmd0xb54.StyleCard)paramRspBody.next();
        try
        {
          if ((((oidb_cmd0xb54.StyleCard)localObject).bytes_sourceid.has()) && (((oidb_cmd0xb54.StyleCard)localObject).bytes_style.has()))
          {
            String str = ((oidb_cmd0xb54.StyleCard)localObject).bytes_sourceid.get().toStringUtf8();
            localObject = ((oidb_cmd0xb54.StyleCard)localObject).bytes_style.get().toStringUtf8();
            QLog.d("FastWebModuleUtils", 2, "0xb54 resp bytes_sourceid : " + str + " json " + (String)localObject);
            paramFastWebArticleInfo.a(str, new JSONObject((String)localObject));
          }
        }
        catch (JSONException localJSONException)
        {
          QLog.d("FastWebModuleUtils", 1, localJSONException, new Object[] { "0xb54 rpt_msg_style_card " });
        }
      }
      if (paramFastWebArticleRichReqCallback != null) {
        paramFastWebArticleRichReqCallback.a(paramFastWebArticleInfo.j);
      }
    }
  }
  
  static void a(oidb_cmd0xb54.RspBody paramRspBody, FastWebArticleInfo paramFastWebArticleInfo, FastWebModule.FastWebArticleRichReqCallback paramFastWebArticleRichReqCallback, String paramString)
  {
    if (paramRspBody.msg_rsp_biu_count.has())
    {
      paramFastWebArticleInfo.c = ((oidb_cmd0xb54.RspBiuCount)paramRspBody.msg_rsp_biu_count.get()).uint64_biu_count.get();
      QLog.d("FastWebModuleUtils", 2, "0xb54 resp biu count is : " + paramFastWebArticleInfo.c);
      if (paramFastWebArticleRichReqCallback != null) {
        paramFastWebArticleRichReqCallback.a(paramFastWebArticleInfo.c, paramString);
      }
    }
  }
  
  static void b(oidb_cmd0xb54.RspBody paramRspBody, FastWebArticleInfo paramFastWebArticleInfo, FastWebModule.FastWebArticleRichReqCallback paramFastWebArticleRichReqCallback)
  {
    Object localObject;
    int i;
    if ((paramRspBody.msg_article_business.has()) && (paramRspBody.msg_article_business.get() != null))
    {
      localObject = (oidb_cmd0xb54.ArticleBusiness)paramRspBody.msg_article_business.get();
      i = ((oidb_cmd0xb54.ArticleBusiness)localObject).uint32_business_cash_flag.get();
      if ((!((oidb_cmd0xb54.ArticleBusiness)localObject).bytes_business_cash_info.has()) || (((oidb_cmd0xb54.ArticleBusiness)localObject).bytes_business_cash_info.get() == null)) {
        break label252;
      }
    }
    label252:
    for (paramRspBody = ((oidb_cmd0xb54.ArticleBusiness)localObject).bytes_business_cash_info.get().toStringUtf8();; paramRspBody = "")
    {
      if ((((oidb_cmd0xb54.ArticleBusiness)localObject).msg_sentiment_entity_data.has()) && (((oidb_cmd0xb54.ArticleBusiness)localObject).msg_sentiment_entity_data.get() != null))
      {
        oidb_cmd0xb54.SentimentEntityData localSentimentEntityData = (oidb_cmd0xb54.SentimentEntityData)((oidb_cmd0xb54.ArticleBusiness)localObject).msg_sentiment_entity_data.get();
        if ((localSentimentEntityData.bytes_data.has()) && (localSentimentEntityData.bytes_data.get() != null)) {
          paramFastWebArticleInfo.m = localSentimentEntityData.bytes_data.get().toStringUtf8();
        }
      }
      if ((((oidb_cmd0xb54.ArticleBusiness)localObject).msg_union_nlp_info.has()) && (((oidb_cmd0xb54.ArticleBusiness)localObject).msg_union_nlp_info.get() != null))
      {
        localObject = (oidb_cmd0xb54.UnionNlpInfo)((oidb_cmd0xb54.ArticleBusiness)localObject).msg_union_nlp_info.get();
        if ((((oidb_cmd0xb54.UnionNlpInfo)localObject).bytes_union_chann.has()) && (((oidb_cmd0xb54.UnionNlpInfo)localObject).bytes_union_chann.get() != null)) {
          paramFastWebArticleInfo.n = ((oidb_cmd0xb54.UnionNlpInfo)localObject).bytes_union_chann.get().toStringUtf8();
        }
      }
      if (paramFastWebArticleRichReqCallback != null) {
        paramFastWebArticleRichReqCallback.a(paramFastWebArticleInfo, i, paramRspBody);
      }
      return;
      if (paramFastWebArticleRichReqCallback != null) {
        paramFastWebArticleRichReqCallback.a(paramFastWebArticleInfo, 0, "");
      }
      QLog.d("FastWebModuleUtils", 1, "0xb54 article business is null");
      return;
    }
  }
  
  static void b(oidb_cmd0xb54.RspBody paramRspBody, FastWebArticleInfo paramFastWebArticleInfo, FastWebModule.FastWebArticleRichReqCallback paramFastWebArticleRichReqCallback, String paramString)
  {
    if (paramRspBody.uint32_like_count.has())
    {
      paramFastWebArticleInfo.jdField_a_of_type_Int = paramRspBody.uint32_like_count.get();
      if (paramFastWebArticleRichReqCallback != null) {
        paramFastWebArticleRichReqCallback.a(paramFastWebArticleInfo.jdField_a_of_type_Int, paramString);
      }
      QLog.d("FastWebModuleUtils", 2, "0xb54 resp like count is : " + paramFastWebArticleInfo.jdField_a_of_type_Int);
    }
  }
  
  static void c(oidb_cmd0xb54.RspBody paramRspBody, FastWebArticleInfo paramFastWebArticleInfo, FastWebModule.FastWebArticleRichReqCallback paramFastWebArticleRichReqCallback, String paramString)
  {
    boolean bool = true;
    if (paramRspBody.uint32_is_like.has()) {
      if (paramRspBody.uint32_is_like.get() != 1) {
        break label75;
      }
    }
    for (;;)
    {
      paramFastWebArticleInfo.jdField_a_of_type_Boolean = bool;
      if (paramFastWebArticleRichReqCallback != null) {
        paramFastWebArticleRichReqCallback.a(paramFastWebArticleInfo.jdField_a_of_type_Boolean, paramString);
      }
      QLog.d("FastWebModuleUtils", 2, "0xb54 resp isLiked : " + paramRspBody.uint32_is_like.get());
      return;
      label75:
      bool = false;
    }
  }
  
  static void d(oidb_cmd0xb54.RspBody paramRspBody, FastWebArticleInfo paramFastWebArticleInfo, FastWebModule.FastWebArticleRichReqCallback paramFastWebArticleRichReqCallback, String paramString)
  {
    paramRspBody = paramRspBody.msg_rsp_topic;
    if ((paramRspBody.has()) && (paramRspBody.get() != null))
    {
      int j = paramRspBody.rpt_msg_topic.size();
      if (j > 0)
      {
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < j)
        {
          oidb_cmd0xb54.Topic localTopic = (oidb_cmd0xb54.Topic)paramRspBody.rpt_msg_topic.get(i);
          ArticleTopicData.TopicInfo localTopicInfo = new ArticleTopicData.TopicInfo();
          localTopicInfo.c = localTopic.str_rowkey.get();
          localTopicInfo.a = localTopic.bytes_title.get().toStringUtf8();
          localTopicInfo.b = localTopic.bytes_url.get().toStringUtf8();
          localArrayList.add(localTopicInfo);
          QLog.i("FastWebModuleUtils", 1, "[handleTopicTag] topic[" + i + "], rowKey = " + localTopicInfo.c + ", title = " + localTopicInfo.a + ", jumpUrl = " + localTopicInfo.b);
          i += 1;
        }
        paramFastWebArticleInfo.b = localArrayList;
        if (paramFastWebArticleRichReqCallback != null) {
          paramFastWebArticleRichReqCallback.a(paramFastWebArticleInfo, paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.FastWebModuleUtils
 * JD-Core Version:    0.7.0.1
 */