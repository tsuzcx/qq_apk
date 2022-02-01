package com.tencent.mobileqq.ark.api.notify;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.ark.ark;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAdLoader.Listener;
import com.tencent.gdtad.api.feedback.GdtFeedbackListener;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.statistics.GdtC2SReporter;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.ark.module.IAppNotifyCallback;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class GdtNotify
  implements IAppNotifyCallback
{
  public static GdtNotify.ArkClickListener a;
  private static GdtNotify.VolumeReceiver d;
  GdtAdLoader.Listener b;
  private GdtFeedbackListener c;
  
  protected static QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private void a(String paramString1, String paramString2)
  {
    WeakReference localWeakReference = new WeakReference(Foreground.getTopActivity());
    Object localObject2 = null;
    int i;
    boolean bool;
    try
    {
      paramString2 = new JSONObject(paramString2);
      localObject1 = (qq_ad_get.QQAdGetRsp.AdInfo)GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramString2.getJSONObject("adInfo"));
      try
      {
        paramString2 = paramString2.optJSONObject("options");
        i = paramString2.getInt("orientation");
        try
        {
          bool = paramString2.optBoolean("isDarkMode");
          paramString2 = (String)localObject1;
        }
        catch (JSONException paramString2) {}
        String str = paramString2;
      }
      catch (JSONException paramString2)
      {
        i = 0;
      }
      paramString2 = (String)localObject1;
    }
    catch (JSONException localJSONException1)
    {
      i = 0;
      paramString2 = localObject2;
    }
    AdLog.e("GdtNotify", "error occurs while parsing input data", localJSONException1);
    Object localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("error_code", 4);
      label123:
      b(paramString1, localWeakReference, "ad_show_feedback_callback", (JSONObject)localObject1, false);
      bool = false;
      this.c = new GdtNotify.6(this, paramString1, localWeakReference);
      paramString1 = new GdtAd(paramString2);
      ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToMainThread(new GdtNotify.7(this, localWeakReference, paramString1, i, bool));
      return;
    }
    catch (JSONException localJSONException2)
    {
      break label123;
    }
  }
  
  private static ChatMessage b(List<ChatMessage> paramList, String paramString)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (StringUtil.isEmpty(paramString)) {
        return null;
      }
      int i = 0;
      while (i < paramList.size())
      {
        ChatMessage localChatMessage = (ChatMessage)paramList.get(i);
        if ((localChatMessage instanceof MessageForArkApp))
        {
          Object localObject = ((MessageForArkApp)localChatMessage).ark_app_message;
          if (localObject != null)
          {
            localObject = ((ArkAppMessage)localObject).metaList;
            if (!StringUtil.isEmpty((String)localObject)) {
              try
              {
                localObject = new JSONObject((String)localObject).optJSONObject("gdt");
                String str = "";
                JSONObject localJSONObject = ((JSONObject)localObject).optJSONObject("adInfo");
                if (localJSONObject != null)
                {
                  localJSONObject = ((JSONObject)localObject).optJSONObject("adInfo").optJSONObject("report_info");
                  localObject = str;
                  if (localJSONObject != null)
                  {
                    localJSONObject = localJSONObject.optJSONObject("trace_info");
                    localObject = str;
                    if (localJSONObject != null) {
                      localObject = localJSONObject.optString("traceid");
                    }
                  }
                }
                else
                {
                  localObject = ((JSONObject)localObject).optString("traceid");
                }
                boolean bool = paramString.equals(localObject);
                if (bool) {
                  return localChatMessage;
                }
              }
              catch (JSONException localJSONException)
              {
                localJSONException.printStackTrace();
              }
            }
          }
        }
        i += 1;
      }
    }
    return null;
  }
  
  public static void b()
  {
    if (d == null) {
      d = new GdtNotify.VolumeReceiver(null);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
    localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
    localIntentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
    localIntentFilter.addAction("android.media.RINGER_MODE_CHANGED");
    BaseApplicationImpl.getApplication().getBaseContext().registerReceiver(d, localIntentFilter);
  }
  
  private static void b(String paramString)
  {
    Object localObject = a();
    bool = true;
    if (localObject == null)
    {
      QLog.e("GdtNotify", 1, "ark callbackMuteStatus error: not instanceof QQAppInterface");
      return;
    }
    try
    {
      if (((AudioManager)((QQAppInterface)localObject).getApplication().getApplicationContext().getSystemService("audio")).getRingerMode() == 2) {
        break label161;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        continue;
        bool = false;
      }
    }
    localObject = new JSONObject();
    ((JSONObject)localObject).put("is_muted", bool);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ad_query_mute: ");
      localStringBuilder.append(((JSONObject)localObject).toString());
      QLog.i("GdtNotify", 2, localStringBuilder.toString());
    }
    ark.arkNotify(paramString, "ad_query_mute_callback", ((JSONObject)localObject).toString(), "json");
    return;
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("is_muted", false);
      ark.arkNotify(paramString, "ad_query_mute_callback", ((JSONObject)localObject).toString(), "json");
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return;
    }
  }
  
  private static void b(String paramString1, WeakReference<Activity> paramWeakReference, String paramString2, JSONObject paramJSONObject, boolean paramBoolean)
  {
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(paramString1, new GdtNotify.8(paramString1, paramString2, paramJSONObject, paramWeakReference, paramBoolean));
  }
  
  public static void c()
  {
    if (d != null)
    {
      BaseApplicationImpl.getApplication().getBaseContext().unregisterReceiver(d);
      d = null;
    }
  }
  
  public boolean notify(String paramString1, String paramString2, String paramString3)
  {
    if (paramString2.equals("ad_query_mute"))
    {
      b(paramString1);
      return true;
    }
    if (paramString3 == null) {
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("appname : ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("eventName : ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(" params : ");
    ((StringBuilder)localObject).append(paramString3);
    QLog.d("GdtNotify", 1, ((StringBuilder)localObject).toString(), null);
    localObject = a;
    if (localObject != null) {
      ((GdtNotify.ArkClickListener)localObject).a(paramString1, paramString2, paramString3);
    }
    if (paramString2.equals("ad_c2s_report")) {
      try
      {
        paramString1 = new JSONObject(paramString3);
        GdtC2SReporter.a(paramString1.getInt("op"), 0, (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramString1.getJSONObject("adInfo"))));
        QLog.d("GdtNotify", 1, "report c2s end", null);
        return true;
      }
      catch (JSONException paramString1)
      {
        QLog.d("GdtNotify", 1, paramString1, new Object[0]);
        return false;
      }
    }
    if (QBaseActivity.sTopActivity == null)
    {
      QLog.d("GdtNotify", 1, "top activity is null");
      return false;
    }
    localObject = new JSONObject();
    if (paramString2.equals("ad_query_cell_rect"))
    {
      ThreadManagerV2.getUIHandlerV2().post(new GdtNotify.1(this, (JSONObject)localObject, paramString3, paramString1));
      return true;
    }
    localObject = new WeakReference(QBaseActivity.sTopActivity);
    WeakReference localWeakReference = new WeakReference(QBaseActivity.sTopActivity);
    if (paramString2.equals("ad_click"))
    {
      AdAnalysisHelperForUtil.reportForARKReceiveNotification((Context)((WeakReference)localObject).get(), false, paramString2, paramString1, null);
      ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToMainThread(new GdtNotify.2(this, paramString3, (WeakReference)localObject, paramString1));
      ark.arkNotify(paramString1, "ad_click_callback", paramString3, "json");
      AdAnalysisHelperForUtil.reportForARKSendNotification((Context)((WeakReference)localObject).get(), false, "ad_click_callback", paramString1, null);
      return true;
    }
    if (paramString2.equals("ad_request"))
    {
      boolean bool = "com.tencent.yundong".equals(paramString1) ^ true;
      AdAnalysisHelperForUtil.reportForARKReceiveNotification((Context)((WeakReference)localObject).get(), bool, paramString2, paramString1, null);
      ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToMainThread(new GdtNotify.3(this, paramString1, (WeakReference)localObject, bool, paramString3, localWeakReference));
      return true;
    }
    if (paramString2.equals("get_device_info"))
    {
      QLog.d("GdtNotify", 1, "ark get_device_info", null);
      ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(paramString1, new GdtNotify.4(this, localWeakReference, paramString3, paramString1));
      return true;
    }
    if (paramString2.equals("ad_preload_after_ad_loaded"))
    {
      QLog.d("GdtNotify", 1, "ark ad_preload_after_ad_loaded", null);
      ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToMainThread(new GdtNotify.5(this, paramString3));
      return true;
    }
    if (paramString2.equals("gc_ark_msg_delete"))
    {
      ((IQQGameTempRelyApi)QRoute.api(IQQGameTempRelyApi.class)).handleGcArkDeleteMsg(paramString3);
      return true;
    }
    if (paramString2.equals("show_feedback_view")) {
      a(paramString1, paramString3);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.notify.GdtNotify
 * JD-Core Version:    0.7.0.1
 */