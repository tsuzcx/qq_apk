package com.tencent.biz.pubaccount.readinjoy.engine;

import aljq;
import alpo;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import ayvw;
import azqu;
import bjxj;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo.DailyFloatingWindowData;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;
import nxu;
import org.json.JSONException;
import org.json.JSONObject;
import ors;
import owg;
import pgr;
import syb;

public class KandianDailyManager
  implements Manager
{
  public static final String a;
  KandianDailyManager.DailySetTopInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianDailyManager$DailySetTopInfo;
  KandianRedDotInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  pgr jdField_a_of_type_Pgr = new owg(this);
  
  static
  {
    jdField_a_of_type_JavaLangString = alpo.a(2131706294);
  }
  
  public KandianDailyManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface = ors.a(paramQQAppInterface, "readinjoy_daily_settop_info_key", true);
    if ((paramQQAppInterface instanceof KandianDailyManager.DailySetTopInfo))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianDailyManager$DailySetTopInfo = ((KandianDailyManager.DailySetTopInfo)paramQQAppInterface);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianDailyManager$DailySetTopInfo = new KandianDailyManager.DailySetTopInfo();
  }
  
  private MessageRecord a(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4)
  {
    MessageForStructing localMessageForStructing = (MessageForStructing)ayvw.a(-2011);
    localMessageForStructing.msgtype = -2011;
    localMessageForStructing.structingMsg = azqu.a();
    localMessageForStructing.structingMsg.mMsgServiceID = 142;
    localMessageForStructing.structingMsg.mMsgBrief = paramString2;
    localMessageForStructing.structingMsg.mOrangeWord = paramString1;
    try
    {
      paramString1 = new JSONObject();
      paramString1.put("puinName", paramString3);
      localMessageForStructing.structingMsg.mExtraData = paramString1.toString();
      localMessageForStructing.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
      localMessageForStructing.frienduin = aljq.aS;
      localMessageForStructing.senderuin = aljq.aS;
      localMessageForStructing.istroop = 1008;
      localMessageForStructing.issend = 0;
      localMessageForStructing.isread = true;
      localMessageForStructing.extLong = 0;
      localMessageForStructing.time = paramLong;
      localMessageForStructing.createMessageUniseq();
      localMessageForStructing.saveExtInfoToExtStr("puin", paramString4);
      localMessageForStructing.doPrewrite();
      return localMessageForStructing;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public static String a()
  {
    MessageRecord localMessageRecord = ((QQAppInterface)ors.a()).a().b(aljq.aS, 1008);
    if ((localMessageRecord instanceof MessageForStructing)) {
      return a((MessageForStructing)localMessageRecord);
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  public static String a(QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.msgtype != -2011)) {
      return jdField_a_of_type_JavaLangString;
    }
    MessageForStructing localMessageForStructing2 = (MessageForStructing)paramMessage.lastMsg;
    MessageForStructing localMessageForStructing1 = localMessageForStructing2;
    if (localMessageForStructing2 == null)
    {
      localMessageForStructing1 = localMessageForStructing2;
      if (paramMessage.msgData != null)
      {
        localMessageForStructing1 = localMessageForStructing2;
        if (paramMessage.msgData.length > 0)
        {
          localMessageForStructing1 = new MessageForStructing();
          localMessageForStructing1.msgData = paramMessage.msgData;
        }
      }
    }
    return a(localMessageForStructing1);
  }
  
  public static String a(MessageForStructing paramMessageForStructing)
  {
    if (paramMessageForStructing == null) {
      return jdField_a_of_type_JavaLangString;
    }
    if (!paramMessageForStructing.mIsParsed) {
      paramMessageForStructing.parse();
    }
    if ((paramMessageForStructing.structingMsg == null) || (TextUtils.isEmpty(paramMessageForStructing.structingMsg.mExtraData))) {
      return jdField_a_of_type_JavaLangString;
    }
    try
    {
      paramMessageForStructing = new JSONObject(paramMessageForStructing.structingMsg.mExtraData).optString("puinName", jdField_a_of_type_JavaLangString);
      return paramMessageForStructing;
    }
    catch (JSONException paramMessageForStructing)
    {
      paramMessageForStructing.printStackTrace();
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  public static void a(Context paramContext)
  {
    a(paramContext, false, null, 5);
  }
  
  public static void a(Context paramContext, boolean paramBoolean, Bundle paramBundle, int paramInt)
  {
    Object localObject1 = (QQAppInterface)ors.a();
    ors.a(aljq.aS, (QQAppInterface)ors.a());
    KandianRedDotInfo localKandianRedDotInfo = KandianRedDotInfo.createRedDotFromMessageRecord(((QQAppInterface)localObject1).a().b(aljq.aS, 1008), "kandian_daily_red_pnt");
    localObject1 = paramBundle;
    if (localKandianRedDotInfo != null)
    {
      localObject1 = paramBundle;
      if (localKandianRedDotInfo.hasArticleID())
      {
        localObject1 = paramBundle;
        if (paramBundle == null) {
          localObject1 = new Bundle();
        }
        ((Bundle)localObject1).putSerializable("kandian_feeds_red_pnt_info", localKandianRedDotInfo);
      }
    }
    QLog.d("KandianDailyManager", 1, "launch daily feeds, redPnt : " + localKandianRedDotInfo);
    paramBundle = (Bundle)localObject1;
    if (localKandianRedDotInfo != null)
    {
      paramBundle = (Bundle)localObject1;
      if (localKandianRedDotInfo.floatingWinData != null)
      {
        paramBundle = (Bundle)localObject1;
        if (localKandianRedDotInfo.floatingWinData.type != 0)
        {
          paramBundle = "";
          Object localObject2 = paramBundle;
          try
          {
            if (localKandianRedDotInfo.cookie != null)
            {
              JSONObject localJSONObject = new JSONObject(localKandianRedDotInfo.cookie);
              localObject2 = paramBundle;
              if (localJSONObject != null) {
                localObject2 = localJSONObject.optString("push_rowkey");
              }
            }
          }
          catch (JSONException localJSONException)
          {
            Bundle localBundle;
            for (;;)
            {
              QLog.d("KandianDailyManager", 2, localJSONException.getMessage());
              localBundle = paramBundle;
            }
            int i = localKandianRedDotInfo.floatingWinData.type;
            paramBundle = (Bundle)localObject1;
            if (localObject1 != null) {
              break label254;
            }
            paramBundle = new Bundle();
            paramBundle.putString("floating_window_rowkey", localBundle);
            paramBundle.putString("float_layer_article_url", localKandianRedDotInfo.floatingWinData.url);
            paramBundle.putString("float_layer_topic_id", localKandianRedDotInfo.floatingWinData.topicID);
            paramBundle.putInt("floating_window_scene", 1);
            paramBundle.putBoolean("open_floating_window", true);
            paramBundle.putInt("floating_window_business", i);
            localKandianRedDotInfo.floatingWinData.clear();
          }
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            QLog.d("KandianDailyManager", 1, "launchKandianDaily floating layer rowkey is null");
            return;
          }
        }
      }
    }
    label254:
    QLog.d("KandianDailyManager", 1, "launch daily feeds by default mode ; bundle " + paramBundle);
    nxu.a(paramContext, paramInt, paramBundle, paramBoolean);
  }
  
  public KandianRedDotInfo a()
  {
    return KandianRedDotInfo.createRedDotFromMessageRecord(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(aljq.aS, 1008), "kandian_daily_red_pnt");
  }
  
  public MessageRecord a()
  {
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(aljq.aS, 1008);
    if (ors.a(localMessageRecord)) {
      return localMessageRecord;
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianDailyManager$DailySetTopInfo != null) {
      ThreadManager.executeOnSubThread(new KandianDailyManager.1(this));
    }
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    String str = syb.a(paramArticleInfo, this.jdField_a_of_type_Pgr);
    if (paramArticleInfo.msgBoxBriefPreFixType == 2) {}
    for (paramArticleInfo = paramArticleInfo.msgBoxBriefPreFix;; paramArticleInfo = null)
    {
      paramArticleInfo = a("", str, a(), NetConnInfoCenter.getServerTime(), paramArticleInfo);
      ors.a(aljq.aS, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramArticleInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      return;
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    paramMessageRecord.frienduin = aljq.aS;
    b(paramMessageRecord);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo = KandianRedDotInfo.createRedDotFromMessageRecord(paramMessageRecord, "kandian_daily_red_pnt");
    QLog.d("KandianDailyManager", 1, "receive lock screen msg : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo);
    ThreadManager.post(new KandianDailyManager.3(this), 8, null, false);
  }
  
  public KandianRedDotInfo b()
  {
    KandianRedDotInfo localKandianRedDotInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo = null;
    return localKandianRedDotInfo;
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    if (!(paramMessageRecord instanceof MessageForStructing)) {
      QLog.e("KandianDailyManager", 1, new Object[] { "receive new msg but not struct msg. type : ", paramMessageRecord.msgtype + ", msg : " + paramMessageRecord });
    }
    label205:
    do
    {
      return;
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      if (!paramMessageRecord.mIsParsed) {
        paramMessageRecord.parse();
      }
      if (paramMessageRecord != null) {}
      try
      {
        if (paramMessageRecord.structingMsg != null)
        {
          Object localObject2 = new JSONObject(paramMessageRecord.structingMsg.mExtraData);
          localObject1 = ((JSONObject)localObject2).optString("cmd", "");
          String str = ((JSONObject)localObject2).optString("refreshMode", "");
          localObject2 = ((JSONObject)localObject2).optString("channelID", "");
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            bjxj.l((String)localObject1);
          }
          if (!TextUtils.isEmpty(str)) {
            bjxj.a("readinjoy_daily_mode_refresh_mode", str);
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            QLog.d("KandianDailyManager", 1, "channelId: " + (String)localObject2);
            bjxj.a("readinjoy_daily_mode_channel_id", Integer.valueOf((String)localObject2));
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        break label205;
      }
    } while (paramMessageRecord.structingMsg == null);
    localObject1 = new StringBuilder("receive new msg : ");
    ((StringBuilder)localObject1).append("orange : ").append(paramMessageRecord.structingMsg.mOrangeWord).append(", ");
    ((StringBuilder)localObject1).append("brief  : ").append(paramMessageRecord.structingMsg.mMsgBrief).append(", ");
    ((StringBuilder)localObject1).append("actionData : ").append(paramMessageRecord.structingMsg.mMsgActionData).append(", ");
    ((StringBuilder)localObject1).append("extraData : ").append(paramMessageRecord.structingMsg.mExtraData);
    QLog.d("KandianDailyManager", 1, ((StringBuilder)localObject1).toString());
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager
 * JD-Core Version:    0.7.0.1
 */