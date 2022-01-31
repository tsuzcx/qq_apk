package com.tencent.biz.pubaccount.readinjoy.engine;

import ajsd;
import ajya;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import axas;
import axva;
import bhvy;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo.DailyFloatingWindowData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import nuq;
import olj;
import onh;
import org.json.JSONException;
import org.json.JSONObject;
import oro;
import pbg;
import sgg;

public class KandianDailyManager
  implements Manager
{
  public static final String a;
  KandianDailyManager.DailySetTopInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianDailyManager$DailySetTopInfo;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  pbg jdField_a_of_type_Pbg = new oro(this);
  
  static
  {
    jdField_a_of_type_JavaLangString = ajya.a(2131705922);
  }
  
  public KandianDailyManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface = onh.a(paramQQAppInterface, "readinjoy_daily_settop_info_key", true);
    if ((paramQQAppInterface instanceof KandianDailyManager.DailySetTopInfo))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianDailyManager$DailySetTopInfo = ((KandianDailyManager.DailySetTopInfo)paramQQAppInterface);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianDailyManager$DailySetTopInfo = new KandianDailyManager.DailySetTopInfo();
  }
  
  private MessageRecord a(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4)
  {
    MessageForStructing localMessageForStructing = (MessageForStructing)axas.a(-2011);
    localMessageForStructing.msgtype = -2011;
    localMessageForStructing.structingMsg = axva.a();
    localMessageForStructing.structingMsg.mMsgServiceID = 142;
    localMessageForStructing.structingMsg.mMsgBrief = paramString2;
    localMessageForStructing.structingMsg.mOrangeWord = paramString1;
    try
    {
      paramString1 = new JSONObject();
      paramString1.put("puinName", paramString3);
      localMessageForStructing.structingMsg.mExtraData = paramString1.toString();
      localMessageForStructing.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
      localMessageForStructing.frienduin = ajsd.aR;
      localMessageForStructing.senderuin = ajsd.aR;
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
    MessageRecord localMessageRecord = ((QQAppInterface)onh.a()).a().b(ajsd.aR, 1008);
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
    Object localObject = (QQAppInterface)onh.a();
    onh.a(ajsd.aR, (QQAppInterface)onh.a());
    KandianRedDotInfo localKandianRedDotInfo = KandianRedDotInfo.createRedDotFromMessageRecord(((QQAppInterface)localObject).a().b(ajsd.aR, 1008), "kandian_daily_red_pnt");
    Bundle localBundle1 = paramBundle;
    if (localKandianRedDotInfo != null)
    {
      localBundle1 = paramBundle;
      if (localKandianRedDotInfo.hasArticleID())
      {
        localBundle1 = paramBundle;
        if (paramBundle == null) {
          localBundle1 = new Bundle();
        }
        localBundle1.putSerializable("kandian_feeds_red_pnt_info", localKandianRedDotInfo);
      }
    }
    olj.a((AppRuntime)localObject);
    olj.c();
    QLog.d("KandianDailyManager", 1, "launch daily feeds, redPnt : " + localKandianRedDotInfo);
    paramBundle = localBundle1;
    if (localKandianRedDotInfo != null)
    {
      paramBundle = localBundle1;
      if (localKandianRedDotInfo.floatingWinData != null)
      {
        paramBundle = localBundle1;
        if (localKandianRedDotInfo.floatingWinData.type != 0)
        {
          paramBundle = "";
          localObject = paramBundle;
          try
          {
            if (localKandianRedDotInfo.cookie != null)
            {
              JSONObject localJSONObject = new JSONObject(localKandianRedDotInfo.cookie);
              localObject = paramBundle;
              if (localJSONObject != null) {
                localObject = localJSONObject.optString("push_rowkey");
              }
            }
          }
          catch (JSONException localJSONException)
          {
            Bundle localBundle2;
            for (;;)
            {
              QLog.d("KandianDailyManager", 2, localJSONException.getMessage());
              localBundle2 = paramBundle;
            }
            int i = localKandianRedDotInfo.floatingWinData.type;
            paramBundle = localBundle1;
            if (localBundle1 != null) {
              break label262;
            }
            paramBundle = new Bundle();
            paramBundle.putString("floating_window_rowkey", localBundle2);
            paramBundle.putString("float_layer_article_url", localKandianRedDotInfo.floatingWinData.url);
            paramBundle.putString("float_layer_topic_id", localKandianRedDotInfo.floatingWinData.topicID);
            paramBundle.putInt("floating_window_scene", 1);
            paramBundle.putBoolean("open_floating_window", true);
            paramBundle.putInt("floating_window_business", i);
            localKandianRedDotInfo.floatingWinData.clear();
          }
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            QLog.d("KandianDailyManager", 1, "launchKandianDaily floating layer rowkey is null");
            return;
          }
        }
      }
    }
    label262:
    QLog.d("KandianDailyManager", 1, "launch daily feeds by default mode ; bundle " + paramBundle);
    nuq.a(paramContext, paramInt, paramBundle, paramBoolean);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianDailyManager$DailySetTopInfo != null) {
      ThreadManager.executeOnSubThread(new KandianDailyManager.1(this));
    }
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    String str = sgg.a(paramArticleInfo, this.jdField_a_of_type_Pbg);
    if (paramArticleInfo.msgBoxBriefPreFixType == 2) {}
    for (paramArticleInfo = paramArticleInfo.msgBoxBriefPreFix;; paramArticleInfo = null)
    {
      paramArticleInfo = a("", str, a(), NetConnInfoCenter.getServerTime(), paramArticleInfo);
      onh.a(ajsd.aR, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramArticleInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      return;
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
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
            bhvy.l((String)localObject1);
          }
          if (!TextUtils.isEmpty(str)) {
            bhvy.a("readinjoy_daily_mode_refresh_mode", str);
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            QLog.d("KandianDailyManager", 1, "channelId: " + (String)localObject2);
            bhvy.a("readinjoy_daily_mode_channel_id", Integer.valueOf((String)localObject2));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager
 * JD-Core Version:    0.7.0.1
 */