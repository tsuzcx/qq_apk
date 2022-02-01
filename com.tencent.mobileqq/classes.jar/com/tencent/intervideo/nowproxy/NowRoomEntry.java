package com.tencent.intervideo.nowproxy;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.intervideo.nowproxy.ability.ExtSdkBizAbilityImpl;
import com.tencent.intervideo.nowproxy.ability.SdkBaseAbilityImpl;
import com.tencent.intervideo.nowproxy.ability.SdkBizAbilityImpl;
import com.tencent.intervideo.nowproxy.baseability.report.BeaconAdapter;
import com.tencent.intervideo.nowproxy.baseability.report.DataReport;
import com.tencent.intervideo.nowproxy.baseability.ticket.UnifyAccountMgr;
import com.tencent.intervideo.nowproxy.common.AccountUtil;
import com.tencent.intervideo.nowproxy.common.ThreadManager;
import com.tencent.intervideo.nowproxy.common.log.XLog;
import com.tencent.intervideo.nowproxy.common.login.AccountInfo;
import com.tencent.intervideo.nowproxy.common.login.LoginData;
import com.tencent.intervideo.nowproxy.common.login.LoginObserver;
import com.tencent.intervideo.nowproxy.common.login.LoginType;
import com.tencent.intervideo.nowproxy.common.roomparam.RoomParam;
import com.tencent.intervideo.nowproxy.common.util.NetworkUtil;
import com.tencent.intervideo.nowproxy.common.util.ToastUtil;
import com.tencent.intervideo.nowproxy.customized_interface.ActionCallback;
import com.tencent.intervideo.nowproxy.customized_interface.IShadow;
import com.tencent.intervideo.nowproxy.proxyinner.util.NowSchemeUtil;
import com.tencent.intervideo.shadow_updater.Shadow;
import com.tencent.intervideo.shadow_updater.ShadowImpl;
import com.tencent.shadow.dynamic.host.DynamicRuntime;
import com.tencent.shadow.dynamic.host.PluginManager;
import com.tencent.shadow.dynamic.host.PluginProcessService;

public class NowRoomEntry
{
  public static final long DYNAMIC_ENTER_FROMID_PREFIX = 10000001L;
  protected static final String TAG = "NowPluginManager | NowRoomEntry";
  int currentAction = 0;
  private boolean isInitBeacon = false;
  long lastLoadingTime = System.currentTimeMillis();
  long lastOpenTime;
  DataReport mDataReport;
  Context mGlobalContext;
  InitData mInitData;
  boolean mIsInit;
  boolean mIsLoading = false;
  LoginData mLoginData;
  LoginObserver mLoginObserver;
  SdkBaseAbilityImpl sdkBaseAbility = SdkBaseAbilityImpl.getsInstance();
  SdkBizAbilityImpl sdkBizAbility = SdkBizAbilityImpl.getInstance();
  IShadow shadowImpl;
  
  public static String bytesToHexString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuilder.append(0);
      }
      localStringBuilder.append(str);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private boolean checkInitParam()
  {
    if (this.mInitData == null)
    {
      XLog.i("NowPluginManager | NowRoomEntry", " 还没有初始化，preInstall不处理");
      return false;
    }
    if (Build.VERSION.SDK_INT < 16)
    {
      XLog.i("NowPluginManager | NowRoomEntry", "API 16以下的系统，不支持预安装");
      return false;
    }
    return true;
  }
  
  private void enterPluginManager(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (!this.shadowImpl.hasPluginManager()))
    {
      XLog.e("NowPluginManager | NowRoomEntry", "pluginmanager未加载，无法处理该action");
      return;
    }
    for (;;)
    {
      try
      {
        IShadow localIShadow = this.shadowImpl;
        Context localContext = this.mGlobalContext;
        long l = Long.parseLong(10000001L + this.mInitData.mAppID);
        if (this.mLoginData != null) {
          break label142;
        }
        str = "";
        localIShadow.enter(localContext, l, str, this.mInitData.mAppID, paramBundle, null);
        return;
      }
      catch (Exception paramBundle)
      {
        XLog.e("NowPluginManager | NowRoomEntry", "加载PluginManager失败,e = " + paramBundle.getMessage());
      }
      if (!paramBoolean2) {
        break;
      }
      showTips("加载直播组件失败，请检查网络");
      return;
      label142:
      String str = this.mLoginData.getUserId();
    }
  }
  
  private void exChangeTicket(int paramInt, LoginData paramLoginData, boolean paramBoolean)
  {
    AccountInfo localAccountInfo = new AccountInfo();
    localAccountInfo.login_appid = paramLoginData.getLoginAppid();
    LoginType localLoginType = paramLoginData.getLoginType();
    if (localLoginType == LoginType.CUSTOM)
    {
      localAccountInfo.login_type = 4;
      localAccountInfo.authappid = paramLoginData.getAuthAppId();
      localAccountInfo.skey = paramLoginData.getSkey();
      localAccountInfo.user_id = paramLoginData.getUserId();
      if (localLoginType != LoginType.WTLOGIN) {
        break label195;
      }
    }
    label195:
    for (localAccountInfo.token = bytesToHexString(paramLoginData.getKey());; localAccountInfo.token = new String(paramLoginData.getKey()))
    {
      UnifyAccountMgr.getInstance().exchageUnifyAccount(Integer.valueOf(this.mInitData.mAppID).intValue() * 16 + 2, localAccountInfo, new NowRoomEntry.1(this, localAccountInfo, paramInt, paramBoolean, paramLoginData));
      return;
      if (localLoginType == LoginType.WTLOGIN)
      {
        localAccountInfo.login_type = 0;
        break;
      }
      if (localLoginType == LoginType.WXBind)
      {
        localAccountInfo.login_type = 9;
        break;
      }
      if (localLoginType == LoginType.QQConnect)
      {
        localAccountInfo.login_type = 8;
        break;
      }
      if (localLoginType != LoginType.TOURIST) {
        break;
      }
      localAccountInfo.login_type = 2;
      break;
    }
  }
  
  private PluginManager getPluginManager(String paramString)
  {
    try
    {
      paramString = this.shadowImpl.getPluginManager(this.mGlobalContext, paramString, this.mInitData.mAppID);
      return paramString;
    }
    catch (Exception paramString)
    {
      throw paramString;
    }
  }
  
  private void openRoom(Bundle paramBundle)
  {
    paramBundle.putAll(RoomParam.getRoomInitParam(this.mInitData));
    if ((this.mLoginData == null) || (this.mLoginData.getLoginType() == LoginType.TOURIST)) {
      paramBundle.putInt("platform", AccountUtil.getAccountType(LoginType.TOURIST));
    }
    paramBundle.putAll(RoomParam.getRoomLoginTicket(this.mLoginData));
    paramBundle.putAll(CustomInterfaceLogic.getsInstance().getCustomiseData());
    Bundle localBundle = new Bundle();
    if (System.currentTimeMillis() - this.lastLoadingTime > 3000L) {
      this.mIsLoading = false;
    }
    if (this.mIsLoading)
    {
      XLog.e("NowPluginManager | NowRoomEntry", "enterShadowSdk 正在加载，不能重复点击入口");
      ToastUtil.show(this.mGlobalContext, "网络状况不佳，请稍后重试", 0);
      localBundle.putString("op_name", "repeated_entry");
      this.sdkBaseAbility.reportData(localBundle);
      return;
    }
    this.mIsLoading = true;
    this.lastLoadingTime = System.currentTimeMillis();
    localBundle.putString("op_name", "begin_enter_shadow");
    this.sdkBaseAbility.reportData(localBundle);
    if (AppidConfig.isBrowserPlugin(this.mInitData.mAppID)) {
      ExtSdkBizAbilityImpl.getInstance().setQueryPhoneAuthStateCallback(new NowRoomEntry.2(this));
    }
    for (;;)
    {
      try
      {
        IShadow localIShadow = this.shadowImpl;
        Context localContext = this.mGlobalContext;
        long l = Long.parseLong(10000001L + this.mInitData.mAppID);
        if (this.mLoginData == null)
        {
          str = "";
          localIShadow.enter(localContext, l, str, this.mInitData.mAppID, paramBundle, new NowRoomEntry.3(this, paramBundle));
          return;
        }
      }
      catch (Exception paramBundle)
      {
        localBundle.putString("op_name", "enter_shadow_exp");
        localBundle.putString("d1", paramBundle.getMessage());
        this.sdkBaseAbility.reportData(localBundle);
        paramBundle.printStackTrace();
        return;
      }
      String str = this.mLoginData.getUserId();
    }
  }
  
  private void showTips(String paramString)
  {
    ThreadManager.getUIThreadHandler().post(new NowRoomEntry.4(this, paramString));
  }
  
  void closeRoom(Bundle paramBundle)
  {
    enterPluginManager(12, paramBundle);
  }
  
  public void doAction(String paramString, Bundle paramBundle)
  {
    NowSchemeUtil.doActionByScheme(this.mGlobalContext, paramString, paramBundle, 0L);
  }
  
  public void doAction(String paramString, Bundle paramBundle, ActionCallback paramActionCallback)
  {
    String str;
    if ((!this.isInitBeacon) && (!AppidConfig.isQQPlugin(this.mInitData.mAppID)) && (!this.mInitData.mAppID.equals("1005")))
    {
      XLog.i("NowPluginManager | NowRoomEntry", "nowsdk 灯塔初始化");
      if (this.mInitData == null)
      {
        str = "0";
        BeaconAdapter.registerTunnel(new TunnelInfo("00000QCKA83QV1AA", "1.0.0", str));
        this.isInitBeacon = true;
      }
    }
    else
    {
      if (AppidConfig.isQQPlugin(this.mInitData.mAppID)) {
        break label127;
      }
    }
    label127:
    for (long l = SdkBizAbilityImpl.getInstance().putActionCallback(paramActionCallback);; l = 0L)
    {
      NowSchemeUtil.doActionByScheme(this.mGlobalContext, paramString, paramBundle, l);
      return;
      str = this.mInitData.mAppID;
      break;
    }
  }
  
  public void enterPluginManager(int paramInt, Bundle paramBundle)
  {
    XLog.d("NowPluginManager | NowRoomEntry", "enterPluginManager， action：" + paramInt);
    paramBundle.putInt("action", paramInt);
    paramBundle.putBoolean("has_assetsApk", false);
    paramBundle.putString("assetsApk_version", AssetsLocalConfig.version);
    this.currentAction = paramInt;
    if (paramInt == 1)
    {
      openRoom(paramBundle);
      return;
    }
    if ((paramInt == 2) || (paramInt == 8) || (paramInt == 10))
    {
      enterPluginManager(paramBundle, true, false);
      return;
    }
    if (paramInt == 6)
    {
      enterPluginManager(paramBundle, true, true);
      return;
    }
    enterPluginManager(paramBundle, false, false);
  }
  
  public void exit()
  {
    XLog.i("NowPluginManager | NowRoomEntry", "exit");
    if (this.mInitData == null) {
      return;
    }
    CustomInterfaceLogic.sInstance.unInit();
  }
  
  public int getCurrentAction()
  {
    return this.currentAction;
  }
  
  public InitData getHostInfo()
  {
    return this.mInitData;
  }
  
  public void getLiveOverPluginState()
  {
    if (!this.shadowImpl.hasPluginManager())
    {
      XLog.i("NowPluginManager | NowRoomEntry", "getLiveOverPluginState--pluginmanager未加载--");
      ExtSdkBizAbilityImpl.getInstance().onLiveOverIsInstalled(false);
      return;
    }
    for (;;)
    {
      try
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("action", 9);
        IShadow localIShadow = this.shadowImpl;
        Context localContext = this.mGlobalContext;
        long l = Long.parseLong(10000001L + this.mInitData.mAppID);
        if (this.mLoginData == null)
        {
          String str1 = "";
          localIShadow.enter(localContext, l, str1, this.mInitData.mAppID, localBundle, null);
          return;
        }
      }
      catch (Exception localException)
      {
        XLog.e("NowPluginManager | NowRoomEntry", "getLiveOverPluginState--加载PluginManager失败,e = " + localException.getMessage());
        ExtSdkBizAbilityImpl.getInstance().onLiveOverIsInstalled(false);
        return;
      }
      String str2 = this.mLoginData.getUserId();
    }
  }
  
  public LoginData getLoginData()
  {
    return this.mLoginData;
  }
  
  public LoginObserver getLoginObserver()
  {
    return this.mLoginObserver;
  }
  
  /* Error */
  public void init(Context paramContext, InitData paramInitData)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 479	com/tencent/intervideo/nowproxy/NowRoomEntry:mIsInit	Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_1
    //   15: invokestatic 485	com/tencent/intervideo/nowproxy/Global:setApplicationContext	(Landroid/content/Context;)V
    //   18: aload_0
    //   19: aload_1
    //   20: putfield 140	com/tencent/intervideo/nowproxy/NowRoomEntry:mGlobalContext	Landroid/content/Context;
    //   23: aload_0
    //   24: aload_2
    //   25: putfield 107	com/tencent/intervideo/nowproxy/NowRoomEntry:mInitData	Lcom/tencent/intervideo/nowproxy/InitData;
    //   28: aload_2
    //   29: getfield 149	com/tencent/intervideo/nowproxy/InitData:mAppID	Ljava/lang/String;
    //   32: putstatic 488	com/tencent/intervideo/nowproxy/Global:sAppid	Ljava/lang/String;
    //   35: aload_2
    //   36: putstatic 491	com/tencent/intervideo/nowproxy/Global:sInitData	Lcom/tencent/intervideo/nowproxy/InitData;
    //   39: invokestatic 300	com/tencent/intervideo/nowproxy/CustomInterfaceLogic:getsInstance	()Lcom/tencent/intervideo/nowproxy/CustomInterfaceLogic;
    //   42: aload_0
    //   43: getfield 107	com/tencent/intervideo/nowproxy/NowRoomEntry:mInitData	Lcom/tencent/intervideo/nowproxy/InitData;
    //   46: getfield 149	com/tencent/intervideo/nowproxy/InitData:mAppID	Ljava/lang/String;
    //   49: invokevirtual 493	com/tencent/intervideo/nowproxy/CustomInterfaceLogic:init	(Ljava/lang/String;)V
    //   52: aload_0
    //   53: invokestatic 58	com/tencent/intervideo/nowproxy/ability/SdkBaseAbilityImpl:getsInstance	()Lcom/tencent/intervideo/nowproxy/ability/SdkBaseAbilityImpl;
    //   56: invokevirtual 497	com/tencent/intervideo/nowproxy/ability/SdkBaseAbilityImpl:getShadowImpl	()Lcom/tencent/intervideo/nowproxy/customized_interface/IShadow;
    //   59: putfield 128	com/tencent/intervideo/nowproxy/NowRoomEntry:shadowImpl	Lcom/tencent/intervideo/nowproxy/customized_interface/IShadow;
    //   62: aload_0
    //   63: getfield 128	com/tencent/intervideo/nowproxy/NowRoomEntry:shadowImpl	Lcom/tencent/intervideo/nowproxy/customized_interface/IShadow;
    //   66: putstatic 500	com/tencent/intervideo/nowproxy/Global:sShadowImpl	Lcom/tencent/intervideo/nowproxy/customized_interface/IShadow;
    //   69: aload_2
    //   70: getfield 503	com/tencent/intervideo/nowproxy/InitData:mSetILoggerFactoryInside	Z
    //   73: ifeq +12 -> 85
    //   76: aload_0
    //   77: getfield 128	com/tencent/intervideo/nowproxy/NowRoomEntry:shadowImpl	Lcom/tencent/intervideo/nowproxy/customized_interface/IShadow;
    //   80: invokeinterface 506 1 0
    //   85: aload_0
    //   86: getfield 107	com/tencent/intervideo/nowproxy/NowRoomEntry:mInitData	Lcom/tencent/intervideo/nowproxy/InitData;
    //   89: getfield 149	com/tencent/intervideo/nowproxy/InitData:mAppID	Ljava/lang/String;
    //   92: invokestatic 395	com/tencent/intervideo/nowproxy/AppidConfig:isQQPlugin	(Ljava/lang/String;)Z
    //   95: ifne +15 -> 110
    //   98: aload_0
    //   99: aload_2
    //   100: getfield 149	com/tencent/intervideo/nowproxy/InitData:mAppID	Ljava/lang/String;
    //   103: aload_1
    //   104: invokestatic 511	com/tencent/intervideo/nowproxy/baseability/report/DataReport:getInstance	(Ljava/lang/String;Landroid/content/Context;)Lcom/tencent/intervideo/nowproxy/baseability/report/DataReport;
    //   107: putfield 513	com/tencent/intervideo/nowproxy/NowRoomEntry:mDataReport	Lcom/tencent/intervideo/nowproxy/baseability/report/DataReport;
    //   110: aload_2
    //   111: getfield 516	com/tencent/intervideo/nowproxy/InitData:mGuid	Ljava/lang/String;
    //   114: invokestatic 522	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   117: ifne +13 -> 130
    //   120: invokestatic 233	com/tencent/intervideo/nowproxy/baseability/ticket/UnifyAccountMgr:getInstance	()Lcom/tencent/intervideo/nowproxy/baseability/ticket/UnifyAccountMgr;
    //   123: aload_2
    //   124: getfield 516	com/tencent/intervideo/nowproxy/InitData:mGuid	Ljava/lang/String;
    //   127: invokevirtual 525	com/tencent/intervideo/nowproxy/baseability/ticket/UnifyAccountMgr:setGuid	(Ljava/lang/String;)V
    //   130: aload_0
    //   131: iconst_1
    //   132: putfield 479	com/tencent/intervideo/nowproxy/NowRoomEntry:mIsInit	Z
    //   135: goto -124 -> 11
    //   138: astore_1
    //   139: aload_0
    //   140: monitorexit
    //   141: aload_1
    //   142: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	NowRoomEntry
    //   0	143	1	paramContext	Context
    //   0	143	2	paramInitData	InitData
    //   6	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	138	finally
    //   14	85	138	finally
    //   85	110	138	finally
    //   110	130	138	finally
    //   130	135	138	finally
  }
  
  public void initNowSubProcess(Context paramContext)
  {
    Global.sShadowImpl = new ShadowImpl();
    Shadow.setILoggerFactory();
    DynamicRuntime.recoveryRuntime(paramContext);
    if ((paramContext instanceof Application)) {
      ((Application)paramContext).registerActivityLifecycleCallbacks(PluginProcessService.getActivityHolder());
    }
  }
  
  public boolean isInitData()
  {
    return true;
  }
  
  public void killPluginProcess()
  {
    enterPluginManager(4, new Bundle());
  }
  
  public void logout()
  {
    this.mLoginData = null;
  }
  
  public void onJumpApp(int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("id", paramInt1);
    localBundle.putInt("jumpapp_action", paramInt2);
    localBundle.putString("doAction", "jumpApp");
    enterPluginManager(6, localBundle);
  }
  
  public void onQueryPhoneAuthState(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("phone_auth_state", paramInt);
    enterPluginManager(7, localBundle);
  }
  
  public boolean openroom(ListNameData paramListNameData, long paramLong, String paramString1, String paramString2, int paramInt, Bundle paramBundle)
  {
    XLog.i("NowPluginManager | NowRoomEntry", "openroom roomid = " + paramLong + " firstJump =" + paramInt);
    if (System.currentTimeMillis() - this.lastOpenTime < 1000L)
    {
      XLog.i("NowPluginManager | NowRoomEntry", "频率限制，点击太快了！");
      return false;
    }
    this.lastOpenTime = System.currentTimeMillis();
    DataReport localDataReport;
    Context localContext;
    String str2;
    if (this.mDataReport != null)
    {
      localDataReport = this.mDataReport;
      localContext = this.mGlobalContext;
      str2 = this.mInitData.mSourceVersion;
      if (this.mLoginData != null) {
        break label153;
      }
    }
    label153:
    for (String str1 = "";; str1 = this.mLoginData.getUserId())
    {
      localDataReport.setReportCommonData(localContext, false, str2, str1, this.mInitData.mGuid);
      if ((this.mGlobalContext != null) && (this.mInitData != null)) {
        break;
      }
      XLog.i("NowPluginManager | NowRoomEntry", "还没有初始化，不处理");
      return false;
    }
    if (!NetworkUtil.isNetworkAvailable(this.mGlobalContext))
    {
      ToastUtil.show(this.mGlobalContext, "当前网络不可用，请稍候再试", 0);
      return false;
    }
    if ((paramListNameData == null) && (paramLong == 0L) && (TextUtils.isEmpty(paramString1)))
    {
      XLog.i("NowPluginManager | NowRoomEntry", "既没有填roomid也没有填listNamesData，不处理");
      ToastUtil.show(this.mGlobalContext, "参数错误", 0);
      return false;
    }
    paramBundle.putLong("entryTime", this.lastOpenTime);
    if (!AppidConfig.isBrowserPlugin(this.mInitData.mAppID))
    {
      paramString1 = new NowEntryData();
      paramString1.roomid = String.valueOf(paramLong);
      paramString1.roomType = String.valueOf(paramBundle.getString("roomtype"));
      paramString1.pluginstatus = "0";
      paramString1.pluginversion = "0";
      paramString1.source = paramString2;
      if (this.mLoginData != null) {
        break label359;
      }
    }
    label359:
    for (paramListNameData = "";; paramListNameData = this.mLoginData.getUserId())
    {
      paramString1.uid = paramListNameData;
      paramString1.networktype = String.valueOf(NetworkUtil.getNetworkType(this.mGlobalContext));
      this.sdkBaseAbility.reportNowEntry(paramString1);
      enterPluginManager(1, paramBundle);
      return true;
    }
  }
  
  public boolean preLogin(Bundle paramBundle)
  {
    return true;
  }
  
  public boolean preinstall(Bundle paramBundle)
  {
    if (!checkInitParam()) {
      return false;
    }
    NowEntryData localNowEntryData = new NowEntryData();
    localNowEntryData.pluginstatus = "0";
    localNowEntryData.pluginversion = "0";
    if (this.mLoginData == null) {}
    for (Object localObject = "";; localObject = this.mLoginData.getUserId())
    {
      localNowEntryData.uid = ((String)localObject);
      localNowEntryData.networktype = String.valueOf(NetworkUtil.getNetworkType(this.mGlobalContext));
      this.sdkBaseAbility.reportNowEntry(localNowEntryData);
      localObject = new Bundle();
      ((Bundle)localObject).putAll(RoomParam.getRoomInitParam(this.mInitData));
      if (paramBundle != null) {
        ((Bundle)localObject).putBundle("userdata", paramBundle);
      }
      ((Bundle)localObject).putAll(CustomInterfaceLogic.getsInstance().getCustomiseData());
      enterPluginManager(8, (Bundle)localObject);
      return true;
    }
  }
  
  public boolean preload(Bundle paramBundle)
  {
    XLog.i("NowPluginManager | NowRoomEntry", "preload");
    if (this.mInitData == null)
    {
      XLog.i("NowPluginManager | NowRoomEntry", " 还没有初始化，preload不处理");
      return false;
    }
    if (Build.VERSION.SDK_INT < 16)
    {
      XLog.i("NowPluginManager | NowRoomEntry", "API 16以下的系统，不支持预加载");
      return false;
    }
    DataReport localDataReport;
    Context localContext;
    String str;
    if (this.mDataReport != null)
    {
      localDataReport = this.mDataReport;
      localContext = this.mGlobalContext;
      str = this.mInitData.mSourceVersion;
      if (this.mLoginData != null) {
        break label149;
      }
    }
    label149:
    for (Object localObject = "";; localObject = this.mLoginData.getUserId())
    {
      localDataReport.setReportCommonData(localContext, false, str, (String)localObject, this.mInitData.mGuid);
      localObject = new Bundle();
      ((Bundle)localObject).putAll(RoomParam.getRoomInitParam(this.mInitData));
      ((Bundle)localObject).putAll(CustomInterfaceLogic.getsInstance().getCustomiseData());
      if (paramBundle != null) {
        ((Bundle)localObject).putBundle("userdata", paramBundle);
      }
      enterPluginManager(2, (Bundle)localObject);
      return true;
    }
  }
  
  public boolean preloadParKey(Bundle paramBundle)
  {
    XLog.i("NowPluginManager | NowRoomEntry", "preloadParKey");
    if (!checkInitParam()) {
      return false;
    }
    Bundle localBundle = new Bundle();
    localBundle.putAll(RoomParam.getRoomInitParam(this.mInitData));
    localBundle.putAll(CustomInterfaceLogic.getsInstance().getCustomiseData());
    if (paramBundle != null) {
      localBundle.putBundle("userdata", paramBundle);
    }
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("preload_subaction", null);
      if (!TextUtils.isEmpty(paramBundle)) {
        localBundle.putString("doAction", paramBundle);
      }
      XLog.i("NowPluginManager | NowRoomEntry", "preload--subaction = " + paramBundle);
    }
    enterPluginManager(10, localBundle);
    return true;
  }
  
  public void pushMessage(Bundle paramBundle)
  {
    XLog.i("NowPluginManager | NowRoomEntry", "pushMessage");
  }
  
  public void registerCustomisedPay(CustomizedPayment paramCustomizedPayment) {}
  
  public void reportHostNowEntry()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("op_name", "host_now_entry");
    localBundle.putString("opername", "now_jiehe");
    this.sdkBaseAbility.reportData(localBundle);
  }
  
  public void reportNowEntry(long paramLong, String paramString, int paramInt, Bundle paramBundle)
  {
    Object localObject;
    if (this.mDataReport != null)
    {
      DataReport localDataReport = this.mDataReport;
      Context localContext = this.mGlobalContext;
      String str = this.mInitData.mSourceVersion;
      if (this.mLoginData == null)
      {
        localObject = "";
        localDataReport.setReportCommonData(localContext, false, str, (String)localObject, this.mInitData.mGuid);
      }
    }
    else
    {
      localObject = new NowEntryData();
      ((NowEntryData)localObject).roomid = String.valueOf(paramLong);
      ((NowEntryData)localObject).roomType = String.valueOf(paramBundle.getString("roomtype"));
      ((NowEntryData)localObject).pluginstatus = "0";
      ((NowEntryData)localObject).pluginversion = "0";
      ((NowEntryData)localObject).source = paramString;
      if (this.mLoginData != null) {
        break label167;
      }
    }
    label167:
    for (paramString = "";; paramString = this.mLoginData.getUserId())
    {
      ((NowEntryData)localObject).uid = paramString;
      ((NowEntryData)localObject).networktype = String.valueOf(NetworkUtil.getNetworkType(this.mGlobalContext));
      this.sdkBaseAbility.reportNowEntry((NowEntryData)localObject);
      return;
      localObject = this.mLoginData.getUserId();
      break;
    }
  }
  
  public void resetLoadingStatus()
  {
    this.mIsLoading = false;
  }
  
  void sendServerPushMessage(Bundle paramBundle)
  {
    if (paramBundle != null) {
      XLog.d("NowPluginManager | NowRoomEntry", "sendServerPushMessage， cmd：" + paramBundle.get("ctrl_cmd"));
    }
    enterPluginManager(11, paramBundle);
  }
  
  public void setLiveRoomLifeCycleObserver(LiveRoomLifeCycleObserver paramLiveRoomLifeCycleObserver) {}
  
  public void setLoginData(LoginData paramLoginData)
  {
    if (paramLoginData == null)
    {
      XLog.e("NowPluginManager | NowRoomEntry", "setLoginData but loginData is null!");
      return;
    }
    if (TextUtils.isEmpty(paramLoginData.getUserId()))
    {
      XLog.i("NowPluginManager | NowRoomEntry", "setLoginData but userid is null!");
      return;
    }
    XLog.i("NowPluginManager | NowRoomEntry", "setLoginData,loginType = " + paramLoginData.getLoginType() + " userid = " + paramLoginData.getUserId() + " loginkey = " + paramLoginData.getKey());
    this.mLoginData = paramLoginData;
    Global.sLoginData = paramLoginData;
  }
  
  public void setLoginData(LoginData paramLoginData, boolean paramBoolean)
  {
    setLoginData(paramLoginData);
    if (paramBoolean) {
      exChangeTicket(1, paramLoginData, true);
    }
  }
  
  public void setLoginObserver(LoginObserver paramLoginObserver)
  {
    this.mLoginObserver = paramLoginObserver;
  }
  
  public void updateFreeFlow(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("free_flow", paramBoolean);
    enterPluginManager(13, localBundle);
  }
  
  public void updateLoginData(LoginData paramLoginData, boolean paramBoolean)
  {
    this.mLoginData = paramLoginData;
    if (paramBoolean)
    {
      exChangeTicket(2, paramLoginData, true);
      return;
    }
    enterPluginManager(3, LoginData.getLoginBundle(paramLoginData));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.NowRoomEntry
 * JD-Core Version:    0.7.0.1
 */