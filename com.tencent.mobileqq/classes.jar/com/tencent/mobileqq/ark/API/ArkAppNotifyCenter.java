package com.tencent.mobileqq.ark.API;

import acka;
import albi;
import albk;
import albl;
import albm;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.media.AudioManager;
import android.view.View;
import baip;
import bejx;
import com.tencent.ark.ark;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
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
  private static HashMap<String, albk> notifyRegs = new HashMap();
  private static albm receiver;
  
  static
  {
    callbackId = -1;
    Object localObject = new albl();
    notifyRegs.put("com.tencent.troopapp", localObject);
    notifyRegs.put("com.tencent.test.troopapp", localObject);
    localObject = new albi();
    notifyRegs.put("com.tencent.yundong", localObject);
    notifyRegs.put("com.tencent.gdt.gouwu", localObject);
    notifyRegs.put("com.tencent.gdt.label", localObject);
    notifyRegs.put("com.tencent.gdt.IllustratedView", localObject);
    notifyRegs.put("com.tencent.gdt.funPlayView", localObject);
    notifyRegs.put("com.tencent.mobileqq.reading", localObject);
    notifyRegs.put("com.tencent.tangram.card", localObject);
    notifyRegs.put("com.tencent.tangram.test", localObject);
    notifyRegs.put("com.tencent.weather", localObject);
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
    if ((paramList == null) || (paramList.isEmpty()) || (baip.a(paramString)))
    {
      localChatMessage = null;
      return localChatMessage;
    }
    int i = 0;
    for (;;)
    {
      for (;;)
      {
        if (i >= paramList.size()) {
          break label133;
        }
        localChatMessage = (ChatMessage)paramList.get(i);
        Object localObject;
        if ((localChatMessage instanceof MessageForArkApp))
        {
          localObject = ((MessageForArkApp)localChatMessage).ark_app_message;
          if (localObject != null)
          {
            localObject = ((ArkAppMessage)localObject).metaList;
            if (baip.a((String)localObject)) {}
          }
        }
        try
        {
          boolean bool = paramString.equals(new JSONObject((String)localObject).optJSONObject("gdt").optString("traceid"));
          if (bool) {
            break;
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
      }
      i += 1;
    }
    label133:
    return null;
  }
  
  public static QQAppInterface getAppInterface()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private static View getViewByPosition(ChatMessage paramChatMessage, ChatXListView paramChatXListView)
  {
    int i = ((acka)((bejx)paramChatXListView.getAdapter()).getWrappedAdapter()).a(paramChatMessage) + paramChatXListView.getHeaderViewsCount();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "pos is:" + i);
    }
    if (i < 0) {
      return null;
    }
    return paramChatXListView.getChildAt(i - paramChatXListView.getFirstVisiblePosition());
  }
  
  private static Rect getVisibilityRect(View paramView)
  {
    Rect localRect = new Rect();
    paramView.getGlobalVisibleRect(localRect);
    return localRect;
  }
  
  public static boolean notify(String paramString1, String paramString2, String paramString3)
  {
    albk localalbk = (albk)notifyRegs.get(paramString1);
    if (localalbk != null)
    {
      ThreadManager.getSubThreadHandler().post(new ArkAppNotifyCenter.1(localalbk, paramString1, paramString2, paramString3));
      return true;
    }
    return false;
  }
  
  public static void registVolumnReceiver()
  {
    if (receiver == null) {
      receiver = new albm(null);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
    localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
    localIntentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
    localIntentFilter.addAction("android.media.RINGER_MODE_CHANGED");
    BaseApplicationImpl.getApplication().getBaseContext().registerReceiver(receiver, localIntentFilter);
  }
  
  public static void setNotify(String paramString, WeakReference<albk> paramWeakReference)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppNotifyCenter
 * JD-Core Version:    0.7.0.1
 */