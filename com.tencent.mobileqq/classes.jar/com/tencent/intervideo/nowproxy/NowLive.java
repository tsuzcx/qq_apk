package com.tencent.intervideo.nowproxy;

import android.content.Context;
import android.os.Bundle;
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
import com.tencent.intervideo.nowproxy.qqshare.CustomizedShareForQQ;
import com.tencent.intervideo.nowproxy.whitelist.WelfareTaskCallback;
import java.net.URLEncoder;

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
      if (paramInt2 == 0)
      {
        localOnHostLoginCallback.onNowLoginTicketChanged(paramNowLoginInfo);
        return;
      }
      localOnHostLoginCallback.onGetNowLoginTicketError(2, "");
    }
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("action=openroom&roomid=");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("&fromid=1&first=2&enter_record_if_finish=0");
    doAction(URLEncoder.encode(localStringBuilder.toString()), null);
    return true;
  }
  
  public static boolean openRoom(ListNameData paramListNameData, long paramLong, String paramString1, String paramString2, int paramInt, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putAll(RoomParam.getEnterRoomParam(paramLong, paramString1, paramString2, paramInt));
    return sEntry.openroom(paramListNameData, paramLong, paramString1, paramString2, paramInt, localBundle);
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
  
  /* Error */
  public static void reportNowEntry(String paramString)
  {
    // Byte code:
    //   0: ldc 133
    //   2: astore 8
    //   4: aload_0
    //   5: invokestatic 222	com/tencent/intervideo/nowproxy/proxyinner/util/NowSchemeUtil:parseSchemeUrl	(Ljava/lang/String;)Landroid/content/Intent;
    //   8: astore 12
    //   10: aload 12
    //   12: ifnonnull +4 -> 16
    //   15: return
    //   16: lconst_0
    //   17: lstore 4
    //   19: iconst_2
    //   20: istore_2
    //   21: aload 12
    //   23: ldc 224
    //   25: invokevirtual 229	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   28: invokestatic 235	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   31: lstore 6
    //   33: lload 6
    //   35: lstore 4
    //   37: aload 12
    //   39: ldc 237
    //   41: invokevirtual 229	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   44: astore 13
    //   46: lload 6
    //   48: lstore 4
    //   50: aload 12
    //   52: ldc 239
    //   54: invokevirtual 229	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   57: astore 11
    //   59: iload_2
    //   60: istore_3
    //   61: aload 12
    //   63: ldc 241
    //   65: invokevirtual 229	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   68: astore 10
    //   70: aload 10
    //   72: astore 8
    //   74: iload_2
    //   75: istore_3
    //   76: aload 12
    //   78: ldc 243
    //   80: invokevirtual 229	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   83: astore_0
    //   84: iload_2
    //   85: istore_1
    //   86: aload_0
    //   87: ifnull +20 -> 107
    //   90: iload_2
    //   91: istore_1
    //   92: aload_0
    //   93: invokevirtual 249	java/lang/String:length	()I
    //   96: ifle +11 -> 107
    //   99: aload_0
    //   100: invokestatic 255	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   103: invokevirtual 258	java/lang/Integer:intValue	()I
    //   106: istore_1
    //   107: aload 10
    //   109: astore_0
    //   110: lload 6
    //   112: lstore 4
    //   114: iload_1
    //   115: istore_2
    //   116: aload 11
    //   118: astore 9
    //   120: aload 10
    //   122: astore 8
    //   124: iload_1
    //   125: istore_3
    //   126: aload 13
    //   128: invokestatic 264	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   131: ifne +69 -> 200
    //   134: aload 10
    //   136: astore 8
    //   138: iload_1
    //   139: istore_3
    //   140: new 266	java/util/ArrayList
    //   143: dup
    //   144: invokespecial 267	java/util/ArrayList:<init>	()V
    //   147: astore_0
    //   148: aload 10
    //   150: astore 8
    //   152: iload_1
    //   153: istore_3
    //   154: aload_0
    //   155: aload 13
    //   157: invokevirtual 271	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   160: pop
    //   161: aload 10
    //   163: astore 8
    //   165: iload_1
    //   166: istore_3
    //   167: new 273	com/tencent/intervideo/nowproxy/ListNameData
    //   170: dup
    //   171: aload_0
    //   172: iconst_0
    //   173: invokespecial 276	com/tencent/intervideo/nowproxy/ListNameData:<init>	(Ljava/util/ArrayList;I)V
    //   176: pop
    //   177: aload 10
    //   179: astore_0
    //   180: lload 6
    //   182: lstore 4
    //   184: iload_1
    //   185: istore_2
    //   186: aload 11
    //   188: astore 9
    //   190: goto +10 -> 200
    //   193: ldc 133
    //   195: astore 9
    //   197: aload 8
    //   199: astore_0
    //   200: aload 12
    //   202: invokevirtual 280	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   205: astore 10
    //   207: aload 10
    //   209: astore 8
    //   211: aload 10
    //   213: ifnonnull +12 -> 225
    //   216: new 44	android/os/Bundle
    //   219: dup
    //   220: invokespecial 176	android/os/Bundle:<init>	()V
    //   223: astore 8
    //   225: aload 8
    //   227: lload 4
    //   229: aload_0
    //   230: aload 9
    //   232: iload_2
    //   233: invokestatic 182	com/tencent/intervideo/nowproxy/common/roomparam/RoomParam:getEnterRoomParam	(JLjava/lang/String;Ljava/lang/String;I)Landroid/os/Bundle;
    //   236: invokevirtual 185	android/os/Bundle:putAll	(Landroid/os/Bundle;)V
    //   239: getstatic 15	com/tencent/intervideo/nowproxy/NowLive:sEntry	Lcom/tencent/intervideo/nowproxy/NowRoomEntry;
    //   242: lload 4
    //   244: aload 9
    //   246: iload_2
    //   247: aload 8
    //   249: invokevirtual 283	com/tencent/intervideo/nowproxy/NowRoomEntry:reportNowEntry	(JLjava/lang/String;ILandroid/os/Bundle;)V
    //   252: return
    //   253: astore_0
    //   254: goto -61 -> 193
    //   257: astore_0
    //   258: aload 8
    //   260: astore_0
    //   261: lload 6
    //   263: lstore 4
    //   265: iload_3
    //   266: istore_2
    //   267: aload 11
    //   269: astore 9
    //   271: goto -71 -> 200
    //   274: astore_0
    //   275: iload_2
    //   276: istore_1
    //   277: goto -170 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	paramString	String
    //   85	192	1	i	int
    //   20	256	2	j	int
    //   60	206	3	k	int
    //   17	247	4	l1	long
    //   31	231	6	l2	long
    //   2	257	8	localObject1	Object
    //   118	152	9	str1	String
    //   68	144	10	localObject2	Object
    //   57	211	11	str2	String
    //   8	193	12	localIntent	android.content.Intent
    //   44	112	13	str3	String
    // Exception table:
    //   from	to	target	type
    //   21	33	253	java/lang/Exception
    //   37	46	253	java/lang/Exception
    //   50	59	253	java/lang/Exception
    //   61	70	257	java/lang/Exception
    //   76	84	257	java/lang/Exception
    //   126	134	257	java/lang/Exception
    //   140	148	257	java/lang/Exception
    //   154	161	257	java/lang/Exception
    //   167	177	257	java/lang/Exception
    //   92	107	274	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.NowLive
 * JD-Core Version:    0.7.0.1
 */