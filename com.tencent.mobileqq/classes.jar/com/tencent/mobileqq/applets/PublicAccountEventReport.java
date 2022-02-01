package com.tencent.mobileqq.applets;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPAReportUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemServiceAccountFolderData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.qvip.QQVipMsgInfo;
import com.tencent.mobileqq.vas.qvip.util.QQVipHelper;
import com.tencent.mobileqq.vas.qvip.util.ReportAmsAdvHelper;
import com.tencent.mobileqq.vashealth.api.IQQHealthApi;
import com.tencent.mobileqq.vashealth.api.IQQHealthService;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.mobileqq.weather.api.IWeatherReportApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneRuntimeService;
import com.tencent.widget.AbsListView;
import com.tencent.widget.HeaderViewListAdapter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class PublicAccountEventReport
{
  private static ConcurrentHashMap<String, Integer> a = new ConcurrentHashMap();
  private static ConcurrentHashMap<String, Integer> b = new ConcurrentHashMap();
  
  public static Bundle a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      Bundle localBundle = b(new JSONObject(paramString).optString("oac_triggle"));
      return localBundle;
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parse input=");
      localStringBuilder.append(paramString);
      QLog.e("PublicAccountEventReport", 1, localStringBuilder.toString(), localJSONException);
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramString = b(new JSONObject(paramString).optString("oac_triggle")).getString("ad_id");
      return paramString;
    }
    catch (Exception paramString)
    {
      label31:
      break label31;
    }
    QLog.e("PublicAccountEventReport", 2, "parseException error ");
    return "";
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("red_cnt", paramString1);
    localHashMap.put("msg_seq", paramString2);
    localHashMap.put("msg_rand", paramString3);
    return new JSONObject(localHashMap).toString();
  }
  
  public static void a()
  {
    a.clear();
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    a(paramInt1, paramInt2, paramString1, paramString2, 1);
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3)
  {
    ThreadManagerV2.executeOnSubThread(new PublicAccountEventReport.13(paramString1, paramInt1, paramInt2, paramInt3, paramString2));
  }
  
  public static void a(int paramInt1, ChatMessage paramChatMessage, int paramInt2)
  {
    if (paramChatMessage == null) {
      return;
    }
    if (paramInt1 == 117)
    {
      a(paramChatMessage.frienduin, paramChatMessage.uniseq);
      if ((paramChatMessage instanceof MessageForArkApp)) {
        a(QQVipHelper.a(), 103, paramChatMessage);
      }
    }
    Object localObject = paramChatMessage.mExJsonObject;
    String str = "";
    if (localObject != null)
    {
      paramChatMessage = paramChatMessage.mExJsonObject.optString("report_key_bytes_oac_msg_extend");
      localObject = a(paramChatMessage);
    }
    else
    {
      localObject = "";
      paramChatMessage = str;
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    a(paramInt1, paramInt2, (String)localObject, paramChatMessage);
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    a(205, paramInt1, paramString1, paramString2, paramInt2);
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForArkApp))
    {
      if (paramAppInterface == null) {
        return;
      }
      paramAppInterface = (MessageForArkApp)paramMessageRecord;
      if (paramAppInterface.ark_app_message == null) {
        return;
      }
      paramMessageRecord = new QQVipMsgInfo();
      QQVipMsgInfo.parseArkAdvInfo(paramAppInterface, paramMessageRecord);
      if (!paramMessageRecord.mIsAmsAdv) {
        return;
      }
      switch (paramInt)
      {
      default: 
        paramAppInterface = "";
        break;
      case 103: 
        paramAppInterface = paramMessageRecord.mAmsMessageExposeUrl;
        break;
      case 102: 
        paramAppInterface = paramMessageRecord.mAmsRPClickUrl;
        break;
      case 101: 
        paramAppInterface = paramMessageRecord.mAmsRPExposeUrl;
      }
      ReportAmsAdvHelper.a(paramInt, paramAppInterface);
    }
  }
  
  public static void a(AppInterface paramAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramAppInterface != null)
    {
      if (paramMessageRecord == null) {
        return;
      }
      if ("1".equals(paramMessageRecord.getExtInfoFromExtStr("is_AdArrive_Msg")))
      {
        String str1 = paramMessageRecord.getExtInfoFromExtStr("gdt_msgImp");
        String str2 = paramMessageRecord.getExtInfoFromExtStr("pa_msgId");
        String str3 = paramMessageRecord.getExtInfoFromExtStr("gdt_view_id");
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(str2);
        ((IPAReportUtil)QRoute.api(IPAReportUtil.class)).reportAdMsgArriveReceipt(paramAppInterface, "", "", paramMessageRecord.senderuin, str1, str3, localArrayList);
      }
      else if ("2290230341".equals(paramMessageRecord.frienduin))
      {
        ReportController.b(paramAppInterface, "CliOper", "", "", "0X80090E1", "0X80090E1", 0, 0, "", "", "", "");
        ((IQzoneRuntimeService)paramAppInterface.getRuntimeService(IQzoneRuntimeService.class, "")).preloadContentBox();
      }
      a(paramAppInterface, 101, paramMessageRecord);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null)
    {
      String str;
      if (paramMessageRecord.mExJsonObject != null) {
        str = paramMessageRecord.mExJsonObject.optString("report_key_bytes_oac_msg_extend");
      } else {
        str = "";
      }
      a(paramQQAppInterface, paramMessageRecord.frienduin, paramInt1, paramInt2, paramMessageRecord.msgUid, str);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentBaseData paramRecentBaseData)
  {
    if (paramQQAppInterface != null)
    {
      if (paramRecentBaseData == null) {
        return;
      }
      int i = paramRecentBaseData.mUnreadNum;
      boolean bool = paramRecentBaseData instanceof RecentItemPublicAccountChatMsgData;
      Object localObject3 = "";
      Object localObject1;
      if (bool)
      {
        localObject2 = ((RecentItemPublicAccountChatMsgData)paramRecentBaseData).a();
        if (localObject2 != null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(((Message)localObject2).msgseq);
          ((StringBuilder)localObject1).append("");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        else
        {
          localObject1 = "";
        }
        if (localObject2 != null)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(((Message)localObject2).msgBackupMsgRandom);
          localStringBuilder.append("");
          localObject2 = localStringBuilder.toString();
        }
        else
        {
          localObject2 = "";
        }
      }
      else
      {
        localObject2 = "";
        localObject1 = localObject2;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append("");
      Object localObject2 = a(localStringBuilder.toString(), (String)localObject1, (String)localObject2);
      i = paramRecentBaseData.getRecentUserType();
      if (i != 1008) {
        if (i != 1038)
        {
          if ((i == 3001) || (i == 7120) || (i == 7200) || (i == 7210) || (i == 7220) || (i == 7230)) {}
        }
        else
        {
          localObject1 = paramRecentBaseData.getRecentUserUin();
          if (bool) {
            paramQQAppInterface = ((RecentItemPublicAccountChatMsgData)paramRecentBaseData).mReportKeyBytesOacMsgxtend;
          } else {
            paramQQAppInterface = "";
          }
          if ((paramRecentBaseData.mUnreadFlag == 0) && (paramRecentBaseData.mUnreadNum <= 0)) {
            bool = false;
          } else {
            bool = true;
          }
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(paramRecentBaseData.mPosition);
          ((StringBuilder)localObject3).append("");
          b((String)localObject1, 102, paramQQAppInterface, bool, (String)localObject2, ((StringBuilder)localObject3).toString());
          int k = paramRecentBaseData.getUnreadNum();
          j = paramRecentBaseData.mUnreadFlag;
          if (k == 0)
          {
            i = 0;
          }
          else
          {
            i = j;
            if (j != 2) {
              i = 1;
            }
          }
          ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportByQQ("message", "message_list", "click", String.valueOf(i), String.valueOf(k), "", "");
          return;
        }
      }
      if (bool)
      {
        localObject1 = ((RecentItemPublicAccountChatMsgData)paramRecentBaseData).mReportKeyBytesOacMsgxtend;
      }
      else
      {
        localObject1 = localObject3;
        if ((paramRecentBaseData instanceof RecentItemServiceAccountFolderData)) {
          localObject1 = ((RecentItemServiceAccountFolderData)paramRecentBaseData).mReportKeyBytesOacMsgxtend;
        }
      }
      localObject3 = paramRecentBaseData.getRecentUserUin();
      int j = paramRecentBaseData.getUnreadNum();
      i = paramRecentBaseData.mUnreadFlag;
      if (((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).isWeatherPA((String)localObject3)) {
        ((IWeatherReportApi)QRoute.api(IWeatherReportApi.class)).reportWeatherMessageClick(paramQQAppInterface);
      } else if (((IQQHealthApi)QRoute.api(IQQHealthApi.class)).isHealthUin((String)localObject3)) {
        ((IQQHealthService)paramQQAppInterface.getRuntimeService(IQQHealthService.class)).reportToBeaconIfNeed("qqsport_click_messagetab", null);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountEventReport", 2, new Object[] { "Report from reportItemClickEventOnConversation, UIN=", localObject3, " unReadFlag=", Integer.valueOf(i), " unreadSum=", Integer.valueOf(j), " message=", paramRecentBaseData.mLastMsg.toString() });
      }
      if (j == 0) {
        i = 0;
      } else if (i != 2) {
        i = 1;
      }
      ThreadManagerV2.executeOnSubThread(new PublicAccountEventReport.6((String)localObject3, (String)localObject1, i, j, (String)localObject2, paramRecentBaseData, paramQQAppInterface, paramRecentBaseData.mLastMsg.toString()));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, AbsListView paramAbsListView, int paramInt)
  {
    if ((paramQQAppInterface != null) && (paramAbsListView != null) && (paramAbsListView.getChildCount() != 0))
    {
      if (paramAbsListView.getAdapter() == null) {
        return;
      }
      if (paramInt != 0) {
        return;
      }
      if ((paramAbsListView.getAdapter() instanceof HeaderViewListAdapter))
      {
        Object localObject1 = (HeaderViewListAdapter)paramAbsListView.getAdapter();
        if ((((HeaderViewListAdapter)localObject1).getWrappedAdapter() instanceof RecentAdapter))
        {
          b.clear();
          RecentAdapter localRecentAdapter = (RecentAdapter)((HeaderViewListAdapter)localObject1).getWrappedAdapter();
          int i = paramAbsListView.getFirstVisiblePosition();
          paramInt = i;
          if (i > 0) {
            paramInt = i - 1;
          }
          int k = paramAbsListView.getLastVisiblePosition();
          i = paramInt;
          while (i < k - 1)
          {
            paramAbsListView = localRecentAdapter.getItem(i);
            if ((paramAbsListView instanceof RecentBaseData))
            {
              RecentBaseData localRecentBaseData = (RecentBaseData)paramAbsListView;
              int j = localRecentBaseData.getRecentUserType();
              String str = localRecentBaseData.getRecentUserUin();
              int m = localRecentBaseData.mUnreadNum;
              boolean bool = localRecentBaseData instanceof RecentItemPublicAccountChatMsgData;
              if (bool)
              {
                localObject1 = ((RecentItemPublicAccountChatMsgData)localRecentBaseData).a();
                if (localObject1 != null)
                {
                  paramAbsListView = new StringBuilder();
                  paramAbsListView.append(((Message)localObject1).msgseq);
                  paramAbsListView.append("");
                  paramAbsListView = paramAbsListView.toString();
                }
                else
                {
                  paramAbsListView = "";
                }
                if (localObject1 != null)
                {
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append(((Message)localObject1).msgBackupMsgRandom);
                  ((StringBuilder)localObject2).append("");
                  localObject1 = ((StringBuilder)localObject2).toString();
                }
                else
                {
                  localObject1 = "";
                }
              }
              else
              {
                localObject1 = "";
                paramAbsListView = (AbsListView)localObject1;
              }
              Object localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(m);
              ((StringBuilder)localObject2).append("");
              localObject2 = a(((StringBuilder)localObject2).toString(), paramAbsListView, (String)localObject1);
              if (!a.containsKey(str))
              {
                paramAbsListView = (IWeatherCommApi)QRoute.api(IWeatherCommApi.class);
                if (paramAbsListView.isWeatherPA(str)) {
                  ThreadManager.excute(new PublicAccountEventReport.1(paramQQAppInterface), 16, null, true);
                } else if ((localRecentBaseData instanceof RecentItemServiceAccountFolderData)) {
                  ThreadManager.excute(new PublicAccountEventReport.2(paramAbsListView, paramQQAppInterface), 16, null, true);
                } else if (((IQQHealthApi)QRoute.api(IQQHealthApi.class)).isHealthUin(str)) {
                  ((IQQHealthService)paramQQAppInterface.getRuntimeService(IQQHealthService.class)).reportToBeaconIfNeed("qqsport_exposure_messagetab", null);
                }
              }
              if ((j >= 1000) && (j != 5000) && (j != 7000) && (j != 9000) && (j != 9002))
              {
                paramInt = 0;
                if (j != 1008) {
                  if (j != 1038)
                  {
                    if ((j != 3001) && (j != 7120) && (j != 7200) && (j != 7210) && (j != 7220) && (j != 7230))
                    {
                      if (!QLog.isColorLevel()) {
                        break label946;
                      }
                      QLog.d("PublicAccountEventReport", 2, new Object[] { "uin=", str, " uinTYPE=", Integer.valueOf(j) });
                      break label946;
                    }
                  }
                  else
                  {
                    if (bool) {
                      paramAbsListView = ((RecentItemPublicAccountChatMsgData)localRecentBaseData).mReportKeyBytesOacMsgxtend;
                    } else {
                      paramAbsListView = "";
                    }
                    if ((localRecentBaseData.mUnreadFlag == 0) && (localRecentBaseData.mUnreadNum <= 0)) {
                      bool = false;
                    } else {
                      bool = true;
                    }
                    localObject1 = new StringBuilder();
                    ((StringBuilder)localObject1).append(localRecentBaseData.mPosition);
                    ((StringBuilder)localObject1).append("");
                    b(str, 101, paramAbsListView, bool, (String)localObject2, ((StringBuilder)localObject1).toString());
                    j = localRecentBaseData.mUnreadFlag;
                    if (localRecentBaseData.mUnreadNum == 0)
                    {
                      paramInt = 0;
                    }
                    else
                    {
                      paramInt = j;
                      if (j != 2) {
                        paramInt = 1;
                      }
                    }
                    ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportByQQ("message", "message_list", "expo", String.valueOf(paramInt), String.valueOf(m), "", "");
                    break label946;
                  }
                }
                if (bool) {
                  paramAbsListView = ((RecentItemPublicAccountChatMsgData)localRecentBaseData).mReportKeyBytesOacMsgxtend;
                } else {
                  paramAbsListView = "";
                }
                b.put(str, Integer.valueOf(j));
                if (!a.containsKey(str))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("PublicAccountEventReport", 2, new Object[] { "Report from TAB, UIN=", str, " unReadFlag=", Integer.valueOf(localRecentBaseData.mUnreadFlag), " unreadSum=", Integer.valueOf(localRecentBaseData.mUnreadNum), " message=", localRecentBaseData.mLastMsg });
                  }
                  j = localRecentBaseData.mUnreadFlag;
                  if (localRecentBaseData.mUnreadNum != 0) {
                    if (j != 2) {
                      paramInt = 1;
                    } else {
                      paramInt = j;
                    }
                  }
                  if (localRecentBaseData.mLastMsg != null) {
                    localObject1 = localRecentBaseData.mLastMsg.toString();
                  } else {
                    localObject1 = "";
                  }
                  ThreadManagerV2.executeOnSubThread(new PublicAccountEventReport.3(str, paramAbsListView, paramInt, m, (String)localObject2, localRecentBaseData, paramQQAppInterface, (String)localObject1));
                }
              }
            }
            label946:
            i += 1;
          }
          a.clear();
          a.putAll(b);
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountEventReport", 2, new Object[] { "report Menu Click On PublicAccount AIO, UIN=", paramString, " menuID=", Integer.valueOf(paramInt2) });
    }
    ThreadManagerV2.executeOnSubThread(new PublicAccountEventReport.8(paramQQAppInterface, paramString, paramInt1, paramInt2));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountEventReport", 2, new Object[] { "report report Stay Time In Page, UIN=", paramString, " from=", Integer.valueOf(paramInt1), " type=", Integer.valueOf(paramInt2), " time=", Long.valueOf(paramLong) });
    }
    ThreadManagerV2.executeOnSubThread(new PublicAccountEventReport.9(paramQQAppInterface, paramString, paramInt1, paramInt2, paramLong));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountEventReport", 2, new Object[] { "report report Msg item click in aio, UIN=", paramString1, " from=", Integer.valueOf(paramInt1), " type=", Integer.valueOf(paramInt2), " msgId=", Long.valueOf(paramLong) });
    }
    ThreadManagerV2.executeOnSubThread(new PublicAccountEventReport.10(paramQQAppInterface, paramString1, paramInt1, paramInt2, paramLong, paramString2));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountEventReport", 2, new Object[] { "Report from ACCOUNT_FOLDER, UIN=", paramString1, " unReadFlag=", Integer.valueOf(paramInt1), " unreadSum=", Integer.valueOf(paramInt2), " message=", paramString2 });
    }
    if (paramInt2 == 0) {
      paramInt1 = 0;
    } else if (paramInt1 != 2) {
      paramInt1 = 1;
    }
    ThreadManagerV2.executeOnSubThread(new PublicAccountEventReport.5(paramString1, paramString3, paramInt1, paramInt2, paramString4, paramString5, paramQQAppInterface, paramString2));
  }
  
  public static void a(String paramString, long paramLong)
  {
    ThreadManagerV2.executeOnSubThread(new PublicAccountEventReport.12(paramString, paramLong));
  }
  
  private static Bundle b(String paramString)
  {
    Bundle localBundle = new Bundle();
    paramString = paramString.split("&");
    if (paramString != null)
    {
      int i = 0;
      while (i < paramString.length)
      {
        String[] arrayOfString = paramString[i].split("=");
        if ((arrayOfString != null) && (arrayOfString.length == 2)) {
          try
          {
            localBundle.putString(arrayOfString[0], URLDecoder.decode(arrayOfString[1], "UTF-8"));
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            localUnsupportedEncodingException.printStackTrace();
          }
        }
        i += 1;
      }
    }
    return localBundle;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountEventReport", 2, new Object[] { "Report Click from ACCOUNT_FOLDER, UIN=", paramString1, " unReadFlag=", Integer.valueOf(paramInt1), " unreadSum=", Integer.valueOf(paramInt2), " message=", paramString2 });
    }
    if (paramInt2 == 0) {
      paramInt1 = 0;
    } else if (paramInt1 != 2) {
      paramInt1 = 1;
    }
    ThreadManagerV2.executeOnSubThread(new PublicAccountEventReport.7(paramString1, paramString3, paramInt1, paramInt2, paramString4, paramString5, paramQQAppInterface, paramString2));
  }
  
  private static void b(String paramString1, int paramInt, String paramString2, boolean paramBoolean, String paramString3, String paramString4)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    ThreadManagerV2.executeOnSubThread(new PublicAccountEventReport.4(paramString2, paramString1, paramInt, paramBoolean, paramString3, paramString4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport
 * JD-Core Version:    0.7.0.1
 */