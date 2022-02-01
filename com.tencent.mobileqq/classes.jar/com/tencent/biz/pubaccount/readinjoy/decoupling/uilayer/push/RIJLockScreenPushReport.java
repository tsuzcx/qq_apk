package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJKanDianTabReport;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class RIJLockScreenPushReport
{
  public static int a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return 1;
    }
    String str;
    if (((paramMessageRecord instanceof MessageForStructing)) && (((MessageForStructing)paramMessageRecord).structingMsg != null)) {
      str = ((MessageForStructing)paramMessageRecord).structingMsg.mExtraData;
    }
    for (;;)
    {
      try
      {
        i = new JSONObject(str).optInt("sceneType", 1);
        if (QLog.isColorLevel()) {
          QLog.d("RIJLockScreenPushReport", 2, "isDailyLockScreen, ret=" + i + ", mr=" + paramMessageRecord);
        }
        return i;
      }
      catch (JSONException localJSONException)
      {
        i = 1;
        continue;
      }
      int i = 1;
    }
  }
  
  private static String a(String paramString, MessageForStructing paramMessageForStructing)
  {
    if (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mMsgActionData)) {
      paramString = new JSONObject(paramMessageForStructing.structingMsg.mMsgActionData).optString("push_rowkey");
    }
    return paramString;
  }
  
  public static void a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)RIJQQAppInterfaceUtil.a();
    if (localQQAppInterface == null) {
      return;
    }
    a(((KandianMergeManager)localQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a());
  }
  
  private static void a(Intent paramIntent, MessageForStructing paramMessageForStructing)
  {
    if (paramMessageForStructing.structingMsg.mExtraData != null) {
      paramIntent.putExtra("arg_channel_cover_id", Integer.parseInt(new JSONObject(paramMessageForStructing.structingMsg.mExtraData).optString("channel_id", "0")));
    }
  }
  
  public static void a(KandianRedDotInfo paramKandianRedDotInfo)
  {
    if (paramKandianRedDotInfo != null) {}
    try
    {
      if (paramKandianRedDotInfo.hasArticleID())
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("algorithm_id", paramKandianRedDotInfo.algorithmID);
        MessageForStructing localMessageForStructing = (MessageForStructing)paramKandianRedDotInfo.getMessageRecord();
        if ((localMessageForStructing != null) && (localMessageForStructing.structingMsg != null))
        {
          ((JSONObject)localObject).put("rowkey", paramKandianRedDotInfo.getRowkey());
          ((JSONObject)localObject).put("load_mode", RIJKanDianTabReport.a(localMessageForStructing.structingMsg.mExtraData));
          ((JSONObject)localObject).put("push_type", RIJKanDianTabReport.b(localMessageForStructing.structingMsg.mExtraData));
          ((JSONObject)localObject).put("landing_type", a(paramKandianRedDotInfo.getMessageRecord()));
        }
        ((JSONObject)localObject).put("folder_status", paramKandianRedDotInfo.forderStatus);
        ((JSONObject)localObject).put("report_time", NetConnInfoCenter.getServerTimeMillis());
        ((JSONObject)localObject).put("articleID", paramKandianRedDotInfo.articleIDList.get(0));
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80081DB", "0X80081DB", 0, 0, "", paramKandianRedDotInfo.articleIDList.get(0) + "", paramKandianRedDotInfo.strategyID + "", ((JSONObject)localObject).toString(), false);
        ReadinjoySPEventReport.a(41, Integer.parseInt(paramKandianRedDotInfo.forderStatus), (int)paramKandianRedDotInfo.algorithmID, (int)paramKandianRedDotInfo.strategyID);
        localObject = new ReportInfo();
        ((ReportInfo)localObject).mUin = RIJQQAppInterfaceUtil.a();
        ((ReportInfo)localObject).mSourceArticleId = ((Long)paramKandianRedDotInfo.articleIDList.get(0)).longValue();
        ((ReportInfo)localObject).mAlgorithmId = ((int)paramKandianRedDotInfo.algorithmID);
        ((ReportInfo)localObject).mStrategyId = ((int)paramKandianRedDotInfo.strategyID);
        ((ReportInfo)localObject).mOperation = 55;
        ((ReportInfo)localObject).mFolderStatus = Integer.parseInt(paramKandianRedDotInfo.forderStatus);
        paramKandianRedDotInfo = new ArrayList();
        paramKandianRedDotInfo.add(localObject);
        ReadInJoyLogicEngine.a().a(paramKandianRedDotInfo);
      }
      return;
    }
    catch (Exception paramKandianRedDotInfo)
    {
      QLog.e("RIJLockScreenPushReport", 1, paramKandianRedDotInfo, new Object[0]);
    }
  }
  
  private static void a(QQMessageFacade paramQQMessageFacade, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null) {
      if (TextUtils.isEmpty(paramMessageRecord.extStr)) {
        break label69;
      }
    }
    label69:
    for (JSONObject localJSONObject = new JSONObject(paramMessageRecord.extStr);; localJSONObject = new JSONObject())
    {
      localJSONObject.put("sp_last_locksc_kadnian_red_pnt_exposure_time_key", NetConnInfoCenter.getServerTime());
      paramMessageRecord.extStr = localJSONObject.toString();
      paramQQMessageFacade.a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, "extStr", paramMessageRecord.extStr);
      return;
    }
  }
  
  public static void a(QQMessageFacade paramQQMessageFacade, MessageRecord paramMessageRecord, Intent paramIntent)
  {
    Object localObject1 = "";
    String str2 = "0";
    for (;;)
    {
      Object localObject2;
      try
      {
        a(paramQQMessageFacade, paramMessageRecord);
        MessageForStructing localMessageForStructing = new MessageForStructing(paramMessageRecord);
        if (localMessageForStructing.structingMsg == null) {
          localMessageForStructing.parse();
        }
        if (localMessageForStructing.extInt == 1)
        {
          localObject2 = d("", localMessageForStructing);
          str2 = c("0", localMessageForStructing);
          str1 = b("", localMessageForStructing);
          a(paramIntent, localMessageForStructing);
          paramQQMessageFacade = a("", localMessageForStructing);
          localObject1 = localMessageForStructing.structingMsg.reportEventFolderStatusValue;
          paramIntent = (Intent)localObject2;
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("algorithm_id", str1);
          ((JSONObject)localObject2).put("rowkey", paramQQMessageFacade);
          ((JSONObject)localObject2).put("folder_status", localObject1);
          ((JSONObject)localObject2).put("report_time", NetConnInfoCenter.getServerTimeMillis());
          a(paramMessageRecord, localMessageForStructing, (JSONObject)localObject2);
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", paramMessageRecord.senderuin, "0X80081DC", "0X80081DC", 0, 0, "", paramIntent, str2, ((JSONObject)localObject2).toString(), false);
          ReadinjoySPEventReport.a(40, Integer.parseInt((String)localObject1), Integer.parseInt(str1), Integer.parseInt(str2));
          paramQQMessageFacade = new ReportInfo();
          paramQQMessageFacade.mUin = RIJQQAppInterfaceUtil.a();
          paramQQMessageFacade.mSourceArticleId = new BigInteger(paramIntent).longValue();
          paramQQMessageFacade.mAlgorithmId = Integer.parseInt(str1);
          paramQQMessageFacade.mStrategyId = Integer.parseInt(str2);
          paramQQMessageFacade.mOperation = 54;
          paramQQMessageFacade.mFolderStatus = Integer.parseInt((String)localObject1);
          paramMessageRecord = new ArrayList();
          paramMessageRecord.add(paramQQMessageFacade);
          ReadInJoyLogicEngine.a().a(paramMessageRecord);
          return;
        }
        if (paramMessageRecord.extInt == 5)
        {
          paramIntent = "0";
          localObject1 = "";
          str1 = "";
          paramQQMessageFacade = "";
          continue;
        }
        localObject2 = "";
      }
      catch (JSONException paramQQMessageFacade)
      {
        QLog.d("RIJLockScreenPushReport", 1, "reportForLockScreenExposure parse json error");
        return;
      }
      catch (NumberFormatException paramQQMessageFacade)
      {
        QLog.d("RIJLockScreenPushReport", 1, "reportForLockScreenExposure number format error");
        return;
      }
      String str1 = "";
      paramQQMessageFacade = "";
      paramIntent = (Intent)localObject1;
      localObject1 = localObject2;
    }
  }
  
  private static void a(MessageRecord paramMessageRecord, MessageForStructing paramMessageForStructing, JSONObject paramJSONObject)
  {
    if (!paramMessageRecord.isread)
    {
      String str = paramMessageRecord.senderuin;
      JSONObject localJSONObject = new JSONObject(paramMessageRecord.extStr);
      paramMessageRecord = str;
      if (localJSONObject.has("kdUin")) {
        paramMessageRecord = localJSONObject.getString("kdUin");
      }
      paramJSONObject.put("feeds_source", paramMessageRecord);
      if (paramMessageForStructing.structingMsg != null)
      {
        paramJSONObject.put("load_mode", RIJKanDianTabReport.a(paramMessageForStructing.structingMsg.mExtraData));
        paramJSONObject.put("push_type", RIJKanDianTabReport.b(paramMessageForStructing.structingMsg.mExtraData));
        paramJSONObject.put("landing_type", a(paramMessageForStructing));
      }
    }
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return a(paramMessageRecord) == 1;
  }
  
  private static String b(String paramString, MessageForStructing paramMessageForStructing)
  {
    if (paramMessageForStructing.structingMsg.mAlgorithmIds != null) {
      paramString = paramMessageForStructing.structingMsg.mAlgorithmIds.split("\\|")[0];
    }
    return paramString;
  }
  
  private static String c(String paramString, MessageForStructing paramMessageForStructing)
  {
    if (paramMessageForStructing.structingMsg.mStrategyIds != null) {
      paramString = paramMessageForStructing.structingMsg.mStrategyIds.split("\\|")[0];
    }
    return paramString;
  }
  
  private static String d(String paramString, MessageForStructing paramMessageForStructing)
  {
    if (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mArticleIds)) {
      paramString = paramMessageForStructing.structingMsg.mArticleIds.split("\\|")[0];
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJLockScreenPushReport
 * JD-Core Version:    0.7.0.1
 */