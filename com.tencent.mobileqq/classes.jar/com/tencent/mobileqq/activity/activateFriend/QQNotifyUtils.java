package com.tencent.mobileqq.activity.activateFriend;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.reminder.api.IQQReminderService;
import com.tencent.mobileqq.reminder.biz.entity.CalendarEntity;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.FakeUrl;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class QQNotifyUtils
{
  public static int a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return -1;
    }
    return paramBundle.getInt("callback_id", -1);
  }
  
  public static Bundle a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("callback_id", paramInt);
    return localBundle;
  }
  
  public static Bundle a(int paramInt, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("retcode", paramInt);
    localBundle.putString("retmsg", paramString);
    return localBundle;
  }
  
  public static Bundle a(int paramInt1, String paramString, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("retcode", paramInt1);
    localBundle.putString("retmsg", paramString);
    if (paramInt2 != -1) {
      localBundle.putInt("has_subscribe", paramInt2);
    }
    return localBundle;
  }
  
  public static Bundle a(String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("busiid", paramString3);
    localBundle.putString("msgid", paramString1);
    localBundle.putString("domain", paramString2);
    return localBundle;
  }
  
  public static String a(Bundle paramBundle)
  {
    int i = paramBundle.getInt("retcode", -1);
    String str = paramBundle.getString("retmsg", "");
    int j = paramBundle.getInt("has_subscribe", -1);
    paramBundle = new JSONObject();
    try
    {
      paramBundle.put("retcode", i);
      paramBundle.put("retmsg", str);
      if (i == 0) {
        paramBundle.put("has_subscribe", j);
      }
      paramBundle = paramBundle.toString();
      return paramBundle;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
    return "";
  }
  
  public static void a(Activity paramActivity, CalendarEntity paramCalendarEntity)
  {
    Object localObject1 = paramCalendarEntity.jump_url;
    if (localObject1 == null) {
      QLog.e("QQNotifyUtils", 1, "jumpUrl is null");
    }
    if (a((String)localObject1))
    {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramActivity, (String)localObject1, 2102, null);
      return;
    }
    paramCalendarEntity = (CalendarEntity)localObject1;
    if (StringUtil.a((String)localObject1)) {
      paramCalendarEntity = "https://act.qzone.qq.com/vip/meteor/blockly/p/4403xdf3cc";
    }
    Object localObject2 = Uri.parse(paramCalendarEntity);
    if (localObject2 != null)
    {
      localObject1 = new FakeUrl();
      ((FakeUrl)localObject1).init(paramActivity);
      localObject2 = ((Uri)localObject2).getScheme();
      if (!StringUtil.a((String)localObject2))
      {
        if ((((String)localObject2).startsWith("http")) || (((String)localObject2).startsWith("https"))) {
          ((FakeUrl)localObject1).gotoH5(paramActivity, paramCalendarEntity, true, true);
        }
        if (((String)localObject2).startsWith("mqqapi")) {
          ((FakeUrl)localObject1).gotoMqq(paramActivity, paramCalendarEntity);
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQNotifyUtils", 1, "newSubscribeNotify msgId is empty");
      }
      return;
    }
    QQRecurrentNotifySettingFragment.a(paramActivity, paramString1, paramString3, paramString2, paramInt);
  }
  
  public static void a(@NonNull String paramString1, String paramString2, String paramString3, @NonNull QQNotifyUtils.QQNotifyListener paramQQNotifyListener)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      paramQQNotifyListener.queryHasSetNotify(a(4, "params error"), null);
      if (QLog.isColorLevel()) {
        QLog.d("QQNotifyUtils", 1, "hasBusinessSetNotify msgId is empty");
      }
      return;
    }
    if (BaseApplicationImpl.sProcessId == 1)
    {
      paramString2 = (IQQReminderService)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IQQReminderService.class, "");
      if (paramString2 != null) {
        paramString2.queryNotifyIsSubscribed(paramString1, new QQNotifyIPCModule.QQNotifyObserver(paramQQNotifyListener, null));
      }
    }
    else
    {
      paramString1 = a(paramString1, paramString2, paramString3);
      QIPCClientHelper.getInstance().callServer("QQNotifyIPCModule", "query", paramString1, new QQNotifyIPCModule.QQNotifyObserver(paramQQNotifyListener, null));
    }
  }
  
  private static boolean a(String paramString)
  {
    return (!StringUtil.a(paramString)) && (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.QQNotifyUtils
 * JD-Core Version:    0.7.0.1
 */