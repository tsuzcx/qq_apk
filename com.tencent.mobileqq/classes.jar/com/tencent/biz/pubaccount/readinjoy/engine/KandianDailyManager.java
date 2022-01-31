package com.tencent.biz.pubaccount.readinjoy.engine;

import ajed;
import ajjy;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import awbi;
import awuw;
import bgmq;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;
import nji;
import oab;
import obz;
import ogg;
import oqi;
import org.json.JSONException;
import org.json.JSONObject;
import rtr;

public class KandianDailyManager
  implements Manager
{
  public static final String a;
  KandianDailyManager.DailySetTopInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianDailyManager$DailySetTopInfo;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  oqi jdField_a_of_type_Oqi = new ogg(this);
  
  static
  {
    jdField_a_of_type_JavaLangString = ajjy.a(2131640126);
  }
  
  public KandianDailyManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface = obz.a(paramQQAppInterface, "readinjoy_daily_settop_info_key", true);
    if ((paramQQAppInterface instanceof KandianDailyManager.DailySetTopInfo))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianDailyManager$DailySetTopInfo = ((KandianDailyManager.DailySetTopInfo)paramQQAppInterface);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianDailyManager$DailySetTopInfo = new KandianDailyManager.DailySetTopInfo();
  }
  
  private MessageRecord a(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4)
  {
    MessageForStructing localMessageForStructing = (MessageForStructing)awbi.a(-2011);
    localMessageForStructing.msgtype = -2011;
    localMessageForStructing.structingMsg = awuw.a();
    localMessageForStructing.structingMsg.mMsgServiceID = 142;
    localMessageForStructing.structingMsg.mMsgBrief = paramString2;
    localMessageForStructing.structingMsg.mOrangeWord = paramString1;
    try
    {
      paramString1 = new JSONObject();
      paramString1.put("puinName", paramString3);
      localMessageForStructing.structingMsg.mExtraData = paramString1.toString();
      localMessageForStructing.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
      localMessageForStructing.frienduin = ajed.aQ;
      localMessageForStructing.senderuin = ajed.aQ;
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
    MessageRecord localMessageRecord = ((QQAppInterface)obz.a()).a().b(ajed.aQ, 1008);
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
    a(paramContext, false);
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)obz.a();
    obz.a(ajed.aQ, (QQAppInterface)obz.a());
    KandianRedDotInfo localKandianRedDotInfo = KandianRedDotInfo.createRedDotFromMessageRecord(localQQAppInterface.a().b(ajed.aQ, 1008), "kandian_daily_red_pnt");
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localKandianRedDotInfo != null)
    {
      localObject1 = localObject2;
      if (localKandianRedDotInfo.hasArticleID())
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putSerializable("kandian_feeds_red_pnt_info", localKandianRedDotInfo);
      }
    }
    oab.a(localQQAppInterface);
    oab.c();
    nji.a(paramContext, 5, (Bundle)localObject1, paramBoolean);
    QLog.d("KandianDailyManager", 1, "launch daily feeds, redPnt : " + localKandianRedDotInfo);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianDailyManager$DailySetTopInfo != null) {
      ThreadManager.executeOnSubThread(new KandianDailyManager.1(this));
    }
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    String str = rtr.a(paramArticleInfo, this.jdField_a_of_type_Oqi);
    if (paramArticleInfo.msgBoxBriefPreFixType == 2) {}
    for (paramArticleInfo = paramArticleInfo.msgBoxBriefPreFix;; paramArticleInfo = null)
    {
      paramArticleInfo = a("", str, a(), NetConnInfoCenter.getServerTime(), paramArticleInfo);
      obz.a(ajed.aQ, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
            bgmq.l((String)localObject1);
          }
          if (!TextUtils.isEmpty(str)) {
            bgmq.a("readinjoy_daily_mode_refresh_mode", str);
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            QLog.d("KandianDailyManager", 1, "channelId: " + (String)localObject2);
            bgmq.a("readinjoy_daily_mode_channel_id", Integer.valueOf((String)localObject2));
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