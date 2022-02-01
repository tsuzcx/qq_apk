package com.tencent.imcore.message;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.applets.AppletsHandler;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.dating.MsgBoxUtil;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class C2CMessageManagerCallback
  implements C2CMessageManager.Callback
{
  private void a(MessageRecord paramMessageRecord, BaseMessageManager.AddMessageContext paramAddMessageContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ecshop new msg puin: ");
      ((StringBuilder)localObject).append(paramMessageRecord.senderuin);
      ((StringBuilder)localObject).append(", inter_num: ");
      ((StringBuilder)localObject).append(paramMessageRecord.getExtInfoFromExtStr("inter_num"));
      QLog.d("EcShopAssistantManager", 2, ((StringBuilder)localObject).toString());
    }
    paramString = UinTypeUtil.a(paramString, paramInt);
    if (paramAddMessageContext.g.containsKey(paramString))
    {
      ((List)paramAddMessageContext.g.get(paramString)).add(paramMessageRecord);
      return;
    }
    Object localObject = new ArrayList();
    ((List)localObject).add(paramMessageRecord);
    paramAddMessageContext.g.put(paramString, localObject);
  }
  
  public int a(AppRuntime paramAppRuntime)
  {
    return ((QQAppInterface)paramAppRuntime).getC2CRoamingSetting();
  }
  
  public void a(C2CMessageManager paramC2CMessageManager, MessageRecord paramMessageRecord)
  {
    if ((!paramMessageRecord.isSend()) && (paramMessageRecord.istroop == 0) && (Utils.c(paramMessageRecord.frienduin)) && (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("guide_msg_cookie"))))
    {
      boolean bool = QQUtils.a(paramC2CMessageManager.a.getApp());
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("now in the aio, isScreenLocked = ");
        localStringBuilder.append(bool);
        QLog.i("BabyQReportCookie", 2, localStringBuilder.toString());
      }
      if ((paramC2CMessageManager.c().containsKey(UinTypeUtil.a(paramMessageRecord.frienduin, paramMessageRecord.istroop))) && (!bool))
      {
        paramC2CMessageManager.b.sendSpecialMessage(paramMessageRecord.getExtInfoFromExtStr("guide_msg_cookie"));
        if (QLog.isColorLevel()) {
          QLog.i("BabyQReportCookie", 2, "now in the aio!!!");
        }
      }
    }
  }
  
  public void a(C2CMessageManager paramC2CMessageManager, IMessageFacade paramIMessageFacade, String paramString, int paramInt, RefreshMessageContext paramRefreshMessageContext, C2CMessageManager.C2CReplyContext paramC2CReplyContext, Context paramContext)
  {
    ThreadManager.executeOnNetWorkThread(new C2CMessageManagerCallback.1(this, paramC2CMessageManager, paramRefreshMessageContext, paramInt, paramString, paramC2CReplyContext, paramIMessageFacade, paramContext));
  }
  
  public void a(AppRuntime paramAppRuntime, int paramInt)
  {
    if (paramInt == 1038)
    {
      paramAppRuntime = (AppletsHandler)((QQAppInterface)paramAppRuntime).getBusinessHandler(BusinessHandlerFactory.APPLET_PUSH_HANDLER);
      if (paramAppRuntime != null) {
        paramAppRuntime.b();
      }
    }
  }
  
  public void a(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord)
  {
    ((ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class)).tryAddTDFileMessageRecord((AppInterface)paramAppRuntime, paramMessageRecord);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    return MessageForQQWalletMsg.isRedPacketMsg(paramMessageRecord);
  }
  
  public boolean a(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord, int paramInt)
  {
    Object localObject1 = (IWeatherCommApi)QRoute.api(IWeatherCommApi.class);
    if ((paramInt == 1008) && (((IWeatherCommApi)localObject1).isWeatherPA(paramMessageRecord.frienduin)))
    {
      localObject1 = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0).edit();
      if ((paramMessageRecord instanceof MessageForPubAccount)) {
        return true;
      }
      if ((paramMessageRecord instanceof MessageForText))
      {
        ReportController.b(paramAppRuntime, "P_CliOper", "weather_public_account", "", "weather_public_account", "brief_weather_push", 0, 0, "", "", "", "");
        paramMessageRecord = new StringBuilder();
        paramMessageRecord.append("pa_list_send_time");
        paramMessageRecord.append(paramAppRuntime.getAccount());
        ((SharedPreferences.Editor)localObject1).putLong(paramMessageRecord.toString(), System.currentTimeMillis());
      }
      else if ((paramMessageRecord instanceof MessageForArkApp))
      {
        paramMessageRecord = (MessageForArkApp)paramMessageRecord;
        ((SharedPreferences.Editor)localObject1).putBoolean("show_flag", true);
        try
        {
          Object localObject3 = new JSONObject(paramMessageRecord.ark_app_message.metaList).optJSONObject("weather");
          if ((localObject3 != null) && (((JSONObject)localObject3).has("info")))
          {
            paramMessageRecord = ((JSONObject)localObject3).optJSONObject("info");
            Object localObject2 = paramMessageRecord.optJSONObject("it1");
            if (localObject2 != null)
            {
              String str1 = ((JSONObject)localObject2).optString("city");
              String str2 = ((JSONObject)localObject2).optString("temp");
              localObject2 = ((JSONObject)localObject2).optString("type");
              if (!TextUtils.isEmpty(str1)) {
                ((SharedPreferences.Editor)localObject1).putString("cur_city", str1.split("-")[0]);
              }
              if (!TextUtils.isEmpty(str2)) {
                ((SharedPreferences.Editor)localObject1).putString("cur_temp", str2);
              }
              if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                ((SharedPreferences.Editor)localObject1).putString("cur_code", (String)localObject2);
              }
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("pa_send_time");
              localStringBuilder.append(paramAppRuntime.getAccount());
              ((SharedPreferences.Editor)localObject1).putLong(localStringBuilder.toString(), System.currentTimeMillis());
              if (0L != ((JSONObject)localObject3).optLong("ts"))
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("pa_time_stamp");
                ((StringBuilder)localObject3).append(paramAppRuntime.getAccount());
                ((SharedPreferences.Editor)localObject1).putLong(((StringBuilder)localObject3).toString(), paramMessageRecord.optLong("ts"));
              }
              if (QLog.isColorLevel())
              {
                paramAppRuntime = new StringBuilder();
                paramAppRuntime.append("parse ark msg city: ");
                paramAppRuntime.append(str1);
                paramAppRuntime.append(", temp: ");
                paramAppRuntime.append(str2);
                paramAppRuntime.append(", code: ");
                paramAppRuntime.append((String)localObject2);
                paramAppRuntime.append(", ts: ");
                paramAppRuntime.append(paramMessageRecord.optLong("ts"));
                QLog.d("Q.msg.BaseMessageManager", 2, paramAppRuntime.toString());
              }
            }
          }
        }
        catch (Exception paramAppRuntime)
        {
          paramAppRuntime.printStackTrace();
          paramMessageRecord = new StringBuilder();
          paramMessageRecord.append("addMessageForPAWeather get a Throwable: ");
          paramMessageRecord.append(paramAppRuntime.getStackTrace());
          QLog.e("Q.msg.BaseMessageManager", 1, paramMessageRecord.toString());
        }
      }
      ((SharedPreferences.Editor)localObject1).commit();
    }
    return false;
  }
  
  public boolean a(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord, String paramString, int paramInt)
  {
    return (paramInt == 1008) && (!PublicAccountAdUtil.a(paramMessageRecord)) && ((TroopBarAssistantManager.a().a((QQAppInterface)paramAppRuntime, paramString, paramInt)) || ("1".equals(paramMessageRecord.getExtInfoFromExtStr("inter_num"))));
  }
  
  public boolean a(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord, String paramString, int paramInt, BaseMessageManager.AddMessageContext paramAddMessageContext)
  {
    if ((paramInt == 1008) && (!PublicAccountAdUtil.a(paramMessageRecord)) && (("2".equals(paramMessageRecord.getExtInfoFromExtStr("inter_num"))) || (ServiceAccountFolderManager.c((QQAppInterface)paramAppRuntime, paramString))))
    {
      a(paramMessageRecord, paramAddMessageContext, paramString, paramInt);
      return true;
    }
    return false;
  }
  
  public boolean a(AppRuntime paramAppRuntime, String paramString)
  {
    try
    {
      paramAppRuntime = (PublicAccountInfo)((IPublicAccountDataManager)paramAppRuntime.getRuntimeService(IPublicAccountDataManager.class, "all")).findPublicAccountInfo(paramString);
      if (paramAppRuntime != null)
      {
        boolean bool = paramAppRuntime.isVisible();
        return bool;
      }
      return true;
    }
    catch (Throwable paramAppRuntime)
    {
      paramString = new StringBuilder();
      paramString.append("needShowPublicAccount get a Throwable: ");
      paramString.append(paramAppRuntime.getStackTrace());
      QLog.e("Q.msg.BaseMessageManager", 1, paramString.toString());
    }
    return true;
  }
  
  public void b(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord)
  {
    ((MessageRoamManager)paramAppRuntime.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER)).b(paramMessageRecord);
  }
  
  public boolean b(MessageRecord paramMessageRecord)
  {
    return ConfessMsgUtil.c(paramMessageRecord);
  }
  
  public boolean b(AppRuntime paramAppRuntime, String paramString)
  {
    return RecentUtil.a((QQAppInterface)paramAppRuntime, paramString);
  }
  
  public boolean c(MessageRecord paramMessageRecord)
  {
    return MsgBoxUtil.b(paramMessageRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.C2CMessageManagerCallback
 * JD-Core Version:    0.7.0.1
 */