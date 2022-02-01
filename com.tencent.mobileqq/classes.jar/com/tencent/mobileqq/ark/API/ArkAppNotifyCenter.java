package com.tencent.mobileqq.ark.API;

import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import aopv;
import aopx;
import aopy;
import aopz;
import com.tencent.ark.ark;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ArkAppNotifyCenter
{
  public static final String TAG = "ark.ArkAppNotifyCenter";
  public static ArkAppNotifyCenter.ArkClickListener arkClickListener;
  private static int callbackId;
  private static HashMap<String, aopx> notifyRegs = new HashMap();
  private static aopz receiver;
  
  static
  {
    callbackId = -1;
    Object localObject = new aopy();
    notifyRegs.put("com.tencent.troopapp", localObject);
    notifyRegs.put("com.tencent.test.troopapp", localObject);
    localObject = new aopv();
    notifyRegs.put("com.tencent.yundong", localObject);
    notifyRegs.put("com.tencent.gdt.gouwu", localObject);
    notifyRegs.put("com.tencent.gdt.label", localObject);
    notifyRegs.put("com.tencent.gdt.IllustratedView", localObject);
    notifyRegs.put("com.tencent.gdt.funPlayView", localObject);
    notifyRegs.put("com.tencent.mobileqq.reading", localObject);
    notifyRegs.put("com.tencent.tangram.card", localObject);
    notifyRegs.put("com.tencent.tangram.test", localObject);
    notifyRegs.put("com.tencent.weather", localObject);
    notifyRegs.put("com.tencent.pcg.qzone.qqcps", localObject);
    notifyRegs.put("com.tencent.qqcomic.care", localObject);
    notifyRegs.put("com.tencent.carecomic.normal", localObject);
    notifyRegs.put("com.tencent.carecomic.update", localObject);
    notifyRegs.put("com.tencent.cmshow.mp", localObject);
    notifyRegs.put("com.tencent.gwh.video", localObject);
    notifyRegs.put("com.tencent.gwh.graphic", localObject);
    notifyRegs.put("com.tencent.gwh.illustrated", localObject);
  }
  
  private static void callbackMuteStatus(String paramString)
  {
    try
    {
      if (((AudioManager)getAppInterface().getApplication().getApplicationContext().getSystemService("audio")).getRingerMode() != 2) {}
      for (boolean bool = true;; bool = false)
      {
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject1.put("is_muted", bool);
        if (QLog.isColorLevel()) {
          QLog.i("ark.ArkAppNotifyCenter", 2, "ad_query_mute: " + localJSONObject1.toString());
        }
        ark.arkNotify(paramString, "ad_query_mute_callback", localJSONObject1.toString(), "json");
        return;
      }
      JSONObject localJSONObject2;
      return;
    }
    catch (Throwable localThrowable)
    {
      try
      {
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("is_muted", false);
        ark.arkNotify(paramString, "ad_query_mute_callback", localJSONObject2.toString(), "json");
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private static ChatMessage getAdArkItemIndexInAIO(List<ChatMessage> paramList, String paramString)
  {
    ChatMessage localChatMessage;
    if ((paramList == null) || (paramList.isEmpty()) || (StringUtil.isEmpty(paramString)))
    {
      localChatMessage = null;
      return localChatMessage;
    }
    int i = 0;
    for (;;)
    {
      for (;;)
      {
        if (i < paramList.size())
        {
          localChatMessage = (ChatMessage)paramList.get(i);
          if (!(localChatMessage instanceof MessageForArkApp)) {
            break label187;
          }
          Object localObject = ((MessageForArkApp)localChatMessage).ark_app_message;
          if (localObject == null) {
            break label187;
          }
          localObject = ((ArkAppMessage)localObject).metaList;
          if (StringUtil.isEmpty((String)localObject)) {
            break label187;
          }
          try
          {
            localObject = new JSONObject((String)localObject).optJSONObject("gdt");
            String str = "";
            JSONObject localJSONObject;
            if (((JSONObject)localObject).optJSONObject("adInfo") != null)
            {
              localJSONObject = ((JSONObject)localObject).optJSONObject("adInfo").optJSONObject("report_info");
              localObject = str;
              if (localJSONObject != null)
              {
                localJSONObject = localJSONObject.optJSONObject("trace_info");
                localObject = str;
                if (localJSONObject == null) {}
              }
            }
            for (localObject = localJSONObject.optString("traceid"); !paramString.equals(localObject); localObject = ((JSONObject)localObject).optString("traceid")) {
              break label187;
            }
            return null;
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
        }
      }
      label187:
      i += 1;
    }
  }
  
  public static QQAppInterface getAppInterface()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public static boolean notify(String paramString1, String paramString2, String paramString3)
  {
    aopx localaopx = (aopx)notifyRegs.get(paramString1);
    if (localaopx != null)
    {
      ThreadManager.getSubThreadHandler().post(new ArkAppNotifyCenter.1(localaopx, paramString1, paramString2, paramString3));
      return true;
    }
    return false;
  }
  
  public static void registVolumnReceiver()
  {
    if (receiver == null) {
      receiver = new aopz(null);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
    localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
    localIntentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
    localIntentFilter.addAction("android.media.RINGER_MODE_CHANGED");
    BaseApplicationImpl.getApplication().getBaseContext().registerReceiver(receiver, localIntentFilter);
  }
  
  public static void setNotify(String paramString, WeakReference<aopx> paramWeakReference)
  {
    if ((paramWeakReference != null) && (paramWeakReference.get() != null))
    {
      notifyRegs.put(paramString, paramWeakReference.get());
      return;
    }
    notifyRegs.remove(paramString);
  }
  
  public static void unRegistVolumnReceiver()
  {
    if (receiver != null)
    {
      BaseApplicationImpl.getApplication().getBaseContext().unregisterReceiver(receiver);
      receiver = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppNotifyCenter
 * JD-Core Version:    0.7.0.1
 */