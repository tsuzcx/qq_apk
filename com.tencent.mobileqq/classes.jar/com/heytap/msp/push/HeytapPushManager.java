package com.heytap.msp.push;

import android.content.Context;
import com.heytap.mcssdk.d;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.heytap.msp.push.mode.MessageStat;
import java.util.List;
import org.json.JSONObject;

public class HeytapPushManager
{
  public static final String EVENT_ID_APP_BLACK_LIST = "app_black_list";
  public static final String EVENT_ID_PUSH_ADD_MESSAGE_NO_DISTURBING = "add_message_no_disturbing";
  public static final String EVENT_ID_PUSH_ADD_MESSAGE_TOP = "add_message_top";
  public static final String EVENT_ID_PUSH_CLICK = "push_click";
  public static final String EVENT_ID_PUSH_DELETE = "push_delete";
  public static final String EVENT_ID_PUSH_EXCEPTION = "push_exception";
  public static final String EVENT_ID_PUSH_MESSAGE_REPEAT = "message_repeat";
  public static final String EVENT_ID_PUSH_NO_IMSI = "imsi_not_exist";
  public static final String EVENT_ID_PUSH_NO_SHOW = "push_no_show";
  public static final String EVENT_ID_PUSH_REVOKE = "push_revoke";
  public static final String EVENT_ID_PUSH_REVOKE_DELETE = "push_revoke_delete";
  public static final String EVENT_ID_PUSH_SHOW = "push_show";
  public static final String EVENT_ID_READ_MESSAGE = "push_read_message";
  
  public static void clearNotificationType()
  {
    clearNotificationType(null);
  }
  
  public static void clearNotificationType(JSONObject paramJSONObject)
  {
    d.a().f(paramJSONObject);
  }
  
  public static void clearNotifications()
  {
    clearNotifications(null);
  }
  
  public static void clearNotifications(JSONObject paramJSONObject)
  {
    d.a().f(paramJSONObject);
  }
  
  public static String getMcsPackageName()
  {
    return d.a().b();
  }
  
  public static void getNotificationStatus()
  {
    getNotificationStatus(null);
  }
  
  public static void getNotificationStatus(JSONObject paramJSONObject)
  {
    d.a().e(paramJSONObject);
  }
  
  public static ICallBackResultService getPushCallback()
  {
    return d.a().h();
  }
  
  public static void getPushStatus()
  {
    d.a().i();
  }
  
  public static int getPushVersionCode()
  {
    return d.a().l();
  }
  
  public static String getPushVersionName()
  {
    return d.a().k();
  }
  
  public static String getReceiveSdkAction()
  {
    return d.a().c();
  }
  
  public static void getRegister()
  {
    getRegister(null);
  }
  
  public static void getRegister(JSONObject paramJSONObject)
  {
    d.a().b(paramJSONObject);
  }
  
  public static String getRegisterID()
  {
    return d.a().g();
  }
  
  public static String getSDKVersion()
  {
    return d.j();
  }
  
  public static void init(Context paramContext, boolean paramBoolean)
  {
    d.a().a(paramContext, paramBoolean);
  }
  
  public static boolean isSupportPush()
  {
    return d.a().d();
  }
  
  public static void openNotificationSettings()
  {
    openNotificationSettings(null);
  }
  
  public static void openNotificationSettings(JSONObject paramJSONObject)
  {
    d.a().g(paramJSONObject);
  }
  
  public static void pausePush()
  {
    pausePush(null);
  }
  
  public static void pausePush(JSONObject paramJSONObject)
  {
    d.a().c(paramJSONObject);
  }
  
  public static void register(Context paramContext, String paramString1, String paramString2, ICallBackResultService paramICallBackResultService)
  {
    register(paramContext, paramString1, paramString2, null, paramICallBackResultService);
  }
  
  public static void register(Context paramContext, String paramString1, String paramString2, JSONObject paramJSONObject, ICallBackResultService paramICallBackResultService)
  {
    d.a().a(paramContext, paramString1, paramString2, paramJSONObject, paramICallBackResultService);
  }
  
  public static void requestNotificationPermission()
  {
    d.a().m();
  }
  
  public static void resumePush()
  {
    resumePush(null);
  }
  
  public static void resumePush(JSONObject paramJSONObject)
  {
    d.a().d(paramJSONObject);
  }
  
  public static void setAppKeySecret(String paramString1, String paramString2)
  {
    d.a().a(paramString1, paramString2);
  }
  
  public static void setNotificationType(int paramInt)
  {
    setNotificationType(paramInt, null);
  }
  
  public static void setNotificationType(int paramInt, JSONObject paramJSONObject)
  {
    d.a().a(paramInt, paramJSONObject);
  }
  
  public static void setPushCallback(ICallBackResultService paramICallBackResultService)
  {
    d.a().a(paramICallBackResultService);
  }
  
  public static void setPushTime(List<Integer> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    setPushTime(paramList, paramInt1, paramInt2, paramInt3, paramInt4, null);
  }
  
  public static void setPushTime(List<Integer> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, JSONObject paramJSONObject)
  {
    d.a().a(paramList, paramInt1, paramInt2, paramInt3, paramInt4, paramJSONObject);
  }
  
  public static void setRegisterID(String paramString)
  {
    d.a().a(paramString);
  }
  
  public static void statisticMessage(Context paramContext, MessageStat paramMessageStat)
  {
    d.a(paramContext, paramMessageStat);
  }
  
  public static void statisticMessage(Context paramContext, List<MessageStat> paramList)
  {
    d.a(paramContext, paramList);
  }
  
  public static void unRegister()
  {
    unRegister(null);
  }
  
  public static void unRegister(Context paramContext, String paramString1, String paramString2, JSONObject paramJSONObject, ICallBackResultService paramICallBackResultService)
  {
    d.a().b(paramContext, paramString1, paramString2, paramJSONObject, paramICallBackResultService);
  }
  
  public static void unRegister(JSONObject paramJSONObject)
  {
    d.a().a(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.heytap.msp.push.HeytapPushManager
 * JD-Core Version:    0.7.0.1
 */