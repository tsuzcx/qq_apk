package com.tencent.intervideo.nowproxy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.intervideo.nowproxy.CustomInterface.CustomizedPushSetting;
import com.tencent.intervideo.nowproxy.CustomInterface.ShareMenuList;
import com.tencent.intervideo.nowproxy.ability.ExtSdkBizAbilityImpl;
import com.tencent.intervideo.nowproxy.ability.OnHostLoginCallback;
import com.tencent.intervideo.nowproxy.ability.SdkBaseAbilityImpl;
import com.tencent.intervideo.nowproxy.ability.SdkBizAbilityImpl;
import com.tencent.intervideo.nowproxy.common.NowThreadPool;
import com.tencent.intervideo.nowproxy.common.NowThreadPool.ThreadPoolProvider;
import com.tencent.intervideo.nowproxy.common.PluginActivityLifecycleCallback;
import com.tencent.intervideo.nowproxy.common.login.LoginData;
import com.tencent.intervideo.nowproxy.common.login.LoginObserver;
import com.tencent.intervideo.nowproxy.common.login.NowLoginInfo;
import com.tencent.intervideo.nowproxy.common.roomparam.RoomParam;
import com.tencent.intervideo.nowproxy.customized_interface.ActionCallback;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedChannel;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedDns;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedDownloader;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedLoader;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedLoading;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedLog;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedRecord;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedReport;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedTicket;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedToast;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedWebView;
import com.tencent.intervideo.nowproxy.customized_interface.IShadow;
import com.tencent.intervideo.nowproxy.proxyinner.util.NowSchemeUtil;
import com.tencent.intervideo.nowproxy.qqshare.CustomizedShareForQQ;
import com.tencent.intervideo.nowproxy.whitelist.WelfareTaskCallback;
import java.net.URLEncoder;
import java.util.ArrayList;

public class NowLive
{
  static NowRoomEntry sEntry = new NowRoomEntry();
  
  public static void cancelRun()
  {
    SdkBizAbilityImpl.getInstance().notifyLoadingCancel();
    getNowRoomEntry().resetLoadingStatus();
  }
  
  public static void closeRoom(Bundle paramBundle, ActionCallback paramActionCallback)
  {
    if (paramBundle != null)
    {
      paramBundle.putLong("actionSeq", SdkBizAbilityImpl.getInstance().putActionCallback(paramActionCallback));
      sEntry.closeRoom(paramBundle);
    }
  }
  
  public static void doAction(String paramString)
  {
    sEntry.doAction(paramString, null, null);
  }
  
  public static void doAction(String paramString, ActionCallback paramActionCallback)
  {
    sEntry.doAction(paramString, null, paramActionCallback);
  }
  
  public static void doActionWithExtra(String paramString, Bundle paramBundle)
  {
    sEntry.doAction(paramString, paramBundle);
  }
  
  public static void doActionWithExtra(String paramString, Bundle paramBundle, ActionCallback paramActionCallback)
  {
    sEntry.doAction(paramString, paramBundle, paramActionCallback);
  }
  
  public static CustomizedPhoneAuth getCustomizedPhoneAuth()
  {
    return ExtSdkBizAbilityImpl.getInstance().getCustomizedPhoneAuth();
  }
  
  public static boolean getFreeFlow()
  {
    return CustomInterfaceLogic.getsInstance().getFreeFlow();
  }
  
  public static void getLiveOverPluginState(CustomizedPluginState paramCustomizedPluginState)
  {
    ExtSdkBizAbilityImpl.getInstance().setCustomizedPluginState(paramCustomizedPluginState);
    sEntry.getLiveOverPluginState();
  }
  
  public static LoginObserver getLoginObserver()
  {
    return SdkBizAbilityImpl.getInstance().getLoginObserver();
  }
  
  public static NowRoomEntry getNowRoomEntry()
  {
    return sEntry;
  }
  
  public static boolean isInitData()
  {
    return sEntry.isInitData();
  }
  
  public static void killPluginProcess()
  {
    sEntry.killPluginProcess();
  }
  
  public static void login(LoginData paramLoginData)
  {
    sEntry.setLoginData(paramLoginData, false);
  }
  
  public static void login(LoginData paramLoginData, boolean paramBoolean)
  {
    sEntry.setLoginData(paramLoginData, paramBoolean);
  }
  
  public static void logout()
  {
    sEntry.logout();
    killPluginProcess();
  }
  
  public static InitData makeInitData(String paramString1, String paramString2)
  {
    InitData localInitData = new InitData();
    localInitData.mAppID = paramString1;
    localInitData.mSourceVersion = paramString2;
    return localInitData;
  }
  
  public static void onGetNowTicket(int paramInt1, int paramInt2, NowLoginInfo paramNowLoginInfo)
  {
    OnHostLoginCallback localOnHostLoginCallback = ExtSdkBizAbilityImpl.getInstance().getOnHostLoginCallback();
    if (localOnHostLoginCallback != null)
    {
      if (paramInt2 == 0) {
        localOnHostLoginCallback.onNowLoginTicketChanged(paramNowLoginInfo);
      }
    }
    else {
      return;
    }
    localOnHostLoginCallback.onGetNowLoginTicketError(2, "");
  }
  
  public static void onJumpToApp(int paramInt1, int paramInt2)
  {
    sEntry.onJumpApp(paramInt1, paramInt2);
  }
  
  public static void onQueryPhoneAuthState(int paramInt)
  {
    sEntry.onQueryPhoneAuthState(paramInt);
  }
  
  public static boolean openRoom(long paramLong)
  {
    doAction(URLEncoder.encode("action=openroom&roomid=" + paramLong + "&fromid=1&first=2&enter_record_if_finish=0"), null);
    return true;
  }
  
  public static boolean openRoom(ListNameData paramListNameData, long paramLong, String paramString1, String paramString2, int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null) {
      paramBundle = new Bundle();
    }
    for (;;)
    {
      paramBundle.putAll(RoomParam.getEnterRoomParam(paramLong, paramString1, paramString2, paramInt));
      return sEntry.openroom(paramListNameData, paramLong, paramString1, paramString2, paramInt, paramBundle);
    }
  }
  
  public static boolean preLogin(Bundle paramBundle)
  {
    return sEntry.preLogin(paramBundle);
  }
  
  public static void preinstall(Bundle paramBundle)
  {
    sEntry.preinstall(paramBundle);
  }
  
  public static void preload(Bundle paramBundle)
  {
    sEntry.preload(paramBundle);
  }
  
  public static void preloadPartKey(Bundle paramBundle)
  {
    sEntry.preloadParKey(paramBundle);
  }
  
  public static void pushMessage(Bundle paramBundle)
  {
    sEntry.pushMessage(paramBundle);
  }
  
  public static void registerActivityLifecycleCallback(PluginActivityLifecycleCallback paramPluginActivityLifecycleCallback)
  {
    ExtSdkBizAbilityImpl.getInstance().setActivityLifecycleCallback(paramPluginActivityLifecycleCallback);
  }
  
  public static void reportHostNowEntry()
  {
    sEntry.reportHostNowEntry();
  }
  
  public static void reportNowEntry(String paramString)
  {
    Intent localIntent = NowSchemeUtil.parseSchemeUrl(paramString);
    if (localIntent == null) {
      return;
    }
    l1 = 0L;
    String str1 = "";
    localObject3 = "";
    int j = 2;
    localObject2 = str1;
    paramString = (String)localObject3;
    try
    {
      l2 = Long.parseLong(localIntent.getStringExtra("roomid"));
      localObject2 = str1;
      l1 = l2;
      paramString = (String)localObject3;
      str2 = localIntent.getStringExtra("listname");
      localObject2 = str1;
      l1 = l2;
      paramString = (String)localObject3;
      localObject3 = localIntent.getStringExtra("fromid");
      localObject2 = str1;
      l1 = l2;
      paramString = (String)localObject3;
      str1 = localIntent.getStringExtra("vid");
      localObject2 = str1;
      l1 = l2;
      paramString = (String)localObject3;
      str3 = localIntent.getStringExtra("first");
      i = j;
      if (str3 != null) {
        i = j;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str2;
        String str3;
        label145:
        int i = 2;
        localObject1 = localObject2;
      }
    }
    try
    {
      if (str3.length() > 0) {
        i = Integer.valueOf(str3).intValue();
      }
      try
      {
        if (!TextUtils.isEmpty(str2))
        {
          paramString = new ArrayList();
          paramString.add(str2);
          new ListNameData(paramString, 0);
        }
        paramString = (String)localObject3;
        l1 = l2;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Object localObject1;
          l1 = l2;
          paramString = (String)localObject3;
        }
      }
      localObject3 = localIntent.getExtras();
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = new Bundle();
      }
      ((Bundle)localObject2).putAll(RoomParam.getEnterRoomParam(l1, str1, paramString, i));
      sEntry.reportNowEntry(l1, paramString, i, (Bundle)localObject2);
      return;
    }
    catch (Exception paramString)
    {
      i = 2;
      break label145;
    }
  }
  
  public static void sendServerPushMessage(Bundle paramBundle)
  {
    sEntry.sendServerPushMessage(paramBundle);
  }
  
  public static void setCoreActionCallback(CoreActionCallback paramCoreActionCallback)
  {
    CustomInterfaceLogic.getsInstance().setCoreActionCallback(paramCoreActionCallback);
  }
  
  public static void setCustomChannel(CustomizedChannel paramCustomizedChannel)
  {
    SdkBaseAbilityImpl.getsInstance().setCustomizedChannel(paramCustomizedChannel);
  }
  
  public static void setCustomizeReport(CustomizedReport paramCustomizedReport)
  {
    CustomInterfaceLogic.getsInstance().setCustomizeReport(paramCustomizedReport);
  }
  
  public static void setCustomizedCoverImg(CustomizedCoverImg paramCustomizedCoverImg)
  {
    CustomInterfaceLogic.getsInstance().setCustomCoverImg(paramCustomizedCoverImg);
  }
  
  public static void setCustomizedDns(CustomizedDns paramCustomizedDns)
  {
    CustomInterfaceLogic.getsInstance().setCustomDns(paramCustomizedDns);
  }
  
  public static void setCustomizedDownloader(CustomizedDownloader paramCustomizedDownloader)
  {
    CustomInterfaceLogic.getsInstance().setCustomizedDownloader(paramCustomizedDownloader);
  }
  
  public static void setCustomizedLoader(CustomizedLoader paramCustomizedLoader)
  {
    SdkBaseAbilityImpl.getsInstance().setCustomizedLoader(paramCustomizedLoader);
  }
  
  public static void setCustomizedLoading(CustomizedLoading paramCustomizedLoading)
  {
    SdkBaseAbilityImpl.getsInstance().setCustomizedLoading(paramCustomizedLoading);
  }
  
  public static void setCustomizedLog(CustomizedLog paramCustomizedLog)
  {
    CustomInterfaceLogic.getsInstance().setCustomizedLog(paramCustomizedLog);
    HostLog.sInstance.setCustomizedLog(paramCustomizedLog);
  }
  
  public static void setCustomizedOpenLiveHall(CustomizedOpenLiveHall paramCustomizedOpenLiveHall)
  {
    ExtSdkBizAbilityImpl.getInstance().setCustomizedOpenLiveHall(paramCustomizedOpenLiveHall);
  }
  
  public static void setCustomizedOpenWxMiniProgram(CustomizedOpenWxMiniProgram paramCustomizedOpenWxMiniProgram)
  {
    CustomInterfaceLogic.getsInstance().setCustomizedOpenWxMiniProgram(paramCustomizedOpenWxMiniProgram);
  }
  
  public static void setCustomizedPay(CustomizedPayment paramCustomizedPayment)
  {
    CustomInterfaceLogic.getsInstance().setCustomizedPay(paramCustomizedPayment);
  }
  
  public static void setCustomizedPhoneAuth(CustomizedPhoneAuth paramCustomizedPhoneAuth)
  {
    ExtSdkBizAbilityImpl.getInstance().setCustomizedPhoneAuth(paramCustomizedPhoneAuth);
  }
  
  public static void setCustomizedPluginState(CustomizedPluginState paramCustomizedPluginState)
  {
    ExtSdkBizAbilityImpl.getInstance().setCustomizedPluginState(paramCustomizedPluginState);
  }
  
  public static void setCustomizedPushSetting(CustomizedPushSetting paramCustomizedPushSetting)
  {
    CustomInterfaceLogic.getsInstance().setCustomizedPushSetting(paramCustomizedPushSetting);
  }
  
  public static void setCustomizedRecord(CustomizedRecord paramCustomizedRecord)
  {
    SdkBizAbilityImpl.getInstance().setCustomRecord(paramCustomizedRecord);
  }
  
  public static void setCustomizedShare(ShareMenuList paramShareMenuList, CustomizedShare paramCustomizedShare)
  {
    CustomInterfaceLogic.getsInstance().setCustomizedShare(paramShareMenuList, paramCustomizedShare);
  }
  
  public static void setCustomizedShare(CustomizedShare paramCustomizedShare)
  {
    CustomInterfaceLogic.getsInstance().setCustomizedShare(paramCustomizedShare);
  }
  
  public static void setCustomizedShareForQQ(CustomizedShareForQQ paramCustomizedShareForQQ)
  {
    SdkBizAbilityImpl.getInstance().setCustomShareForQQ(paramCustomizedShareForQQ);
  }
  
  public static void setCustomizedSubscribe(CustomizedSubscribe paramCustomizedSubscribe) {}
  
  public static void setCustomizedTicket(CustomizedTicket paramCustomizedTicket)
  {
    SdkBaseAbilityImpl.getsInstance().setmCustomizedTiket(paramCustomizedTicket);
  }
  
  public static void setCustomizedToast(CustomizedToast paramCustomizedToast)
  {
    CustomInterfaceLogic.getsInstance().setCustomizedToast(paramCustomizedToast);
  }
  
  public static void setCustomizedWebView(CustomizedWebView paramCustomizedWebView)
  {
    CustomInterfaceLogic.getsInstance().setCustomisedWebview(paramCustomizedWebView);
  }
  
  public static void setFreeFlow(boolean paramBoolean)
  {
    CustomInterfaceLogic.getsInstance().setFreeFlow(paramBoolean);
  }
  
  public static void setLoginObserver(LoginObserver paramLoginObserver)
  {
    sEntry.setLoginObserver(paramLoginObserver);
    SdkBizAbilityImpl.getInstance().setLoginObserver(paramLoginObserver);
  }
  
  public static void setOnHostLoginCallback(OnHostLoginCallback paramOnHostLoginCallback)
  {
    ExtSdkBizAbilityImpl.getInstance().setOnHostLoginCallback(paramOnHostLoginCallback);
  }
  
  public static void setQQKandianInterface(QQKandianInterface paramQQKandianInterface)
  {
    SdkBizAbilityImpl.getInstance().setQQKandianInterface(paramQQKandianInterface);
  }
  
  public static void setShadowImp(IShadow paramIShadow)
  {
    SdkBaseAbilityImpl.getsInstance().setShadowImpl(paramIShadow);
  }
  
  public static void setThreadPoolProvider(NowThreadPool.ThreadPoolProvider paramThreadPoolProvider)
  {
    NowThreadPool.setThreadPoolProvider(paramThreadPoolProvider);
    SdkBizAbilityImpl.getInstance().setThreadPoolProvider(paramThreadPoolProvider);
  }
  
  public static void setWelfareTaskCallback(WelfareTaskCallback paramWelfareTaskCallback)
  {
    CustomInterfaceLogic.getsInstance().setWelfareTaskCallback(paramWelfareTaskCallback);
  }
  
  public static void start(Context paramContext, InitData paramInitData)
  {
    sEntry.init(paramContext, paramInitData);
  }
  
  public static void startNowSubProcess(Context paramContext)
  {
    sEntry.initNowSubProcess(paramContext);
  }
  
  public static void stop()
  {
    sEntry.exit();
    killPluginProcess();
  }
  
  public static void updateFreeFlow(boolean paramBoolean)
  {
    setFreeFlow(paramBoolean);
    sEntry.updateFreeFlow(paramBoolean);
  }
  
  public static void updateLoginData(LoginData paramLoginData)
  {
    sEntry.updateLoginData(paramLoginData, false);
  }
  
  public static void updateLoginData(LoginData paramLoginData, boolean paramBoolean)
  {
    sEntry.updateLoginData(paramLoginData, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.NowLive
 * JD-Core Version:    0.7.0.1
 */