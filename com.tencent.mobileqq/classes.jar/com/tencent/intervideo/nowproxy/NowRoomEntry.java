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
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
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
    return null;
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
    try
    {
      IShadow localIShadow = this.shadowImpl;
      Context localContext = this.mGlobalContext;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(10000001L);
      ((StringBuilder)localObject).append(this.mInitData.mAppID);
      long l = Long.parseLong(((StringBuilder)localObject).toString());
      if (this.mLoginData == null) {
        localObject = "";
      } else {
        localObject = this.mLoginData.getUserId();
      }
      localIShadow.enter(localContext, l, (String)localObject, this.mInitData.mAppID, paramBundle, null);
      return;
    }
    catch (Exception paramBundle)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("加载PluginManager失败,e = ");
      ((StringBuilder)localObject).append(paramBundle.getMessage());
      XLog.e("NowPluginManager | NowRoomEntry", ((StringBuilder)localObject).toString());
      if (paramBoolean2) {
        showTips("加载直播组件失败，请检查网络");
      }
    }
  }
  
  private void exChangeTicket(int paramInt, LoginData paramLoginData, boolean paramBoolean)
  {
    AccountInfo localAccountInfo = new AccountInfo();
    localAccountInfo.login_appid = paramLoginData.getLoginAppid();
    LoginType localLoginType = paramLoginData.getLoginType();
    if (localLoginType == LoginType.CUSTOM) {
      localAccountInfo.login_type = 4;
    } else if (localLoginType == LoginType.WTLOGIN) {
      localAccountInfo.login_type = 0;
    } else if (localLoginType == LoginType.WXBind) {
      localAccountInfo.login_type = 9;
    } else if (localLoginType == LoginType.QQConnect) {
      localAccountInfo.login_type = 8;
    } else if (localLoginType == LoginType.TOURIST) {
      localAccountInfo.login_type = 2;
    }
    localAccountInfo.authappid = paramLoginData.getAuthAppId();
    localAccountInfo.skey = paramLoginData.getSkey();
    localAccountInfo.user_id = paramLoginData.getUserId();
    if (localLoginType == LoginType.WTLOGIN) {
      localAccountInfo.token = bytesToHexString(paramLoginData.getKey());
    } else {
      localAccountInfo.token = new String(paramLoginData.getKey());
    }
    UnifyAccountMgr.getInstance().exchageUnifyAccount(Integer.valueOf(this.mInitData.mAppID).intValue() * 16 + 2, localAccountInfo, new NowRoomEntry.1(this, localAccountInfo, paramInt, paramBoolean, paramLoginData));
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
    Object localObject = this.mLoginData;
    if ((localObject == null) || (((LoginData)localObject).getLoginType() == LoginType.TOURIST)) {
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
    try
    {
      IShadow localIShadow = this.shadowImpl;
      Context localContext = this.mGlobalContext;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(10000001L);
      ((StringBuilder)localObject).append(this.mInitData.mAppID);
      long l = Long.parseLong(((StringBuilder)localObject).toString());
      if (this.mLoginData == null) {
        localObject = "";
      } else {
        localObject = this.mLoginData.getUserId();
      }
      localIShadow.enter(localContext, l, (String)localObject, this.mInitData.mAppID, paramBundle, new NowRoomEntry.3(this, paramBundle));
      return;
    }
    catch (Exception paramBundle)
    {
      localBundle.putString("op_name", "enter_shadow_exp");
      localBundle.putString("d1", paramBundle.getMessage());
      this.sdkBaseAbility.reportData(localBundle);
      paramBundle.printStackTrace();
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
    if ((!this.isInitBeacon) && (!AppidConfig.isQQPlugin(this.mInitData.mAppID)) && (!this.mInitData.mAppID.equals("1005")))
    {
      XLog.i("NowPluginManager | NowRoomEntry", "nowsdk 灯塔初始化");
      Object localObject = this.mInitData;
      if (localObject == null) {
        localObject = "0";
      } else {
        localObject = ((InitData)localObject).mAppID;
      }
      BeaconAdapter.registerTunnel(new TunnelInfo("00000QCKA83QV1AA", "1.0.0", (String)localObject));
      this.isInitBeacon = true;
    }
    long l;
    if (!AppidConfig.isQQPlugin(this.mInitData.mAppID)) {
      l = SdkBizAbilityImpl.getInstance().putActionCallback(paramActionCallback);
    } else {
      l = 0L;
    }
    NowSchemeUtil.doActionByScheme(this.mGlobalContext, paramString, paramBundle, l);
  }
  
  public void enterPluginManager(int paramInt, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enterPluginManager， action：");
    localStringBuilder.append(paramInt);
    XLog.d("NowPluginManager | NowRoomEntry", localStringBuilder.toString());
    paramBundle.putInt("action", paramInt);
    paramBundle.putBoolean("has_assetsApk", false);
    paramBundle.putString("assetsApk_version", AssetsLocalConfig.version);
    this.currentAction = paramInt;
    if (paramInt == 1)
    {
      openRoom(paramBundle);
      return;
    }
    if ((paramInt != 2) && (paramInt != 8) && (paramInt != 10))
    {
      if (paramInt == 6)
      {
        enterPluginManager(paramBundle, true, true);
        return;
      }
      enterPluginManager(paramBundle, false, false);
      return;
    }
    enterPluginManager(paramBundle, true, false);
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
    try
    {
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("action", 9);
      IShadow localIShadow = this.shadowImpl;
      Context localContext = this.mGlobalContext;
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(10000001L);
      ((StringBuilder)localObject1).append(this.mInitData.mAppID);
      long l = Long.parseLong(((StringBuilder)localObject1).toString());
      if (this.mLoginData == null) {
        localObject1 = "";
      } else {
        localObject1 = this.mLoginData.getUserId();
      }
      localIShadow.enter(localContext, l, (String)localObject1, this.mInitData.mAppID, (Bundle)localObject2, null);
      return;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getLiveOverPluginState--加载PluginManager失败,e = ");
      ((StringBuilder)localObject2).append(localException.getMessage());
      XLog.e("NowPluginManager | NowRoomEntry", ((StringBuilder)localObject2).toString());
      ExtSdkBizAbilityImpl.getInstance().onLiveOverIsInstalled(false);
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
  
  public void init(Context paramContext, InitData paramInitData)
  {
    try
    {
      boolean bool = this.mIsInit;
      if (bool) {
        return;
      }
      Global.setApplicationContext(paramContext);
      this.mGlobalContext = paramContext;
      this.mInitData = paramInitData;
      Global.sAppid = paramInitData.mAppID;
      Global.sInitData = paramInitData;
      CustomInterfaceLogic.getsInstance().init(this.mInitData.mAppID);
      this.shadowImpl = SdkBaseAbilityImpl.getsInstance().getShadowImpl();
      Global.sShadowImpl = this.shadowImpl;
      if (paramInitData.mSetILoggerFactoryInside) {
        this.shadowImpl.setILoggerFactory();
      }
      if (!AppidConfig.isQQPlugin(this.mInitData.mAppID)) {
        this.mDataReport = DataReport.getInstance(paramInitData.mAppID, paramContext);
      }
      if (!TextUtils.isEmpty(paramInitData.mGuid)) {
        UnifyAccountMgr.getInstance().setGuid(paramInitData.mGuid);
      }
      this.mIsInit = true;
      return;
    }
    finally {}
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("openroom roomid = ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" firstJump =");
    ((StringBuilder)localObject).append(paramInt);
    XLog.i("NowPluginManager | NowRoomEntry", ((StringBuilder)localObject).toString());
    if (System.currentTimeMillis() - this.lastOpenTime < 1000L)
    {
      XLog.i("NowPluginManager | NowRoomEntry", "频率限制，点击太快了！");
      return false;
    }
    this.lastOpenTime = System.currentTimeMillis();
    DataReport localDataReport = this.mDataReport;
    String str1 = "";
    if (localDataReport != null)
    {
      Context localContext = this.mGlobalContext;
      String str2 = this.mInitData.mSourceVersion;
      localObject = this.mLoginData;
      if (localObject == null) {
        localObject = "";
      } else {
        localObject = ((LoginData)localObject).getUserId();
      }
      localDataReport.setReportCommonData(localContext, false, str2, (String)localObject, this.mInitData.mGuid);
    }
    localObject = this.mGlobalContext;
    if ((localObject != null) && (this.mInitData != null))
    {
      if (!NetworkUtil.isNetworkAvailable((Context)localObject))
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
        paramListNameData = this.mLoginData;
        if (paramListNameData == null) {
          paramListNameData = str1;
        } else {
          paramListNameData = paramListNameData.getUserId();
        }
        paramString1.uid = paramListNameData;
        paramString1.networktype = String.valueOf(NetworkUtil.getNetworkType(this.mGlobalContext));
        this.sdkBaseAbility.reportNowEntry(paramString1);
      }
      enterPluginManager(1, paramBundle);
      return true;
    }
    XLog.i("NowPluginManager | NowRoomEntry", "还没有初始化，不处理");
    return false;
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
    Object localObject = this.mLoginData;
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = ((LoginData)localObject).getUserId();
    }
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
    DataReport localDataReport = this.mDataReport;
    if (localDataReport != null)
    {
      Context localContext = this.mGlobalContext;
      String str = this.mInitData.mSourceVersion;
      localObject = this.mLoginData;
      if (localObject == null) {
        localObject = "";
      } else {
        localObject = ((LoginData)localObject).getUserId();
      }
      localDataReport.setReportCommonData(localContext, false, str, (String)localObject, this.mInitData.mGuid);
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putAll(RoomParam.getRoomInitParam(this.mInitData));
    ((Bundle)localObject).putAll(CustomInterfaceLogic.getsInstance().getCustomiseData());
    if (paramBundle != null) {
      ((Bundle)localObject).putBundle("userdata", paramBundle);
    }
    enterPluginManager(2, (Bundle)localObject);
    return true;
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preload--subaction = ");
      localStringBuilder.append(paramBundle);
      XLog.i("NowPluginManager | NowRoomEntry", localStringBuilder.toString());
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
    DataReport localDataReport = this.mDataReport;
    String str1 = "";
    if (localDataReport != null)
    {
      Context localContext = this.mGlobalContext;
      String str2 = this.mInitData.mSourceVersion;
      localObject = this.mLoginData;
      if (localObject == null) {
        localObject = "";
      } else {
        localObject = ((LoginData)localObject).getUserId();
      }
      localDataReport.setReportCommonData(localContext, false, str2, (String)localObject, this.mInitData.mGuid);
    }
    Object localObject = new NowEntryData();
    ((NowEntryData)localObject).roomid = String.valueOf(paramLong);
    ((NowEntryData)localObject).roomType = String.valueOf(paramBundle.getString("roomtype"));
    ((NowEntryData)localObject).pluginstatus = "0";
    ((NowEntryData)localObject).pluginversion = "0";
    ((NowEntryData)localObject).source = paramString;
    paramString = this.mLoginData;
    if (paramString == null) {
      paramString = str1;
    } else {
      paramString = paramString.getUserId();
    }
    ((NowEntryData)localObject).uid = paramString;
    ((NowEntryData)localObject).networktype = String.valueOf(NetworkUtil.getNetworkType(this.mGlobalContext));
    this.sdkBaseAbility.reportNowEntry((NowEntryData)localObject);
  }
  
  public void resetLoadingStatus()
  {
    this.mIsLoading = false;
  }
  
  void sendServerPushMessage(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendServerPushMessage， cmd：");
      localStringBuilder.append(paramBundle.get("ctrl_cmd"));
      XLog.d("NowPluginManager | NowRoomEntry", localStringBuilder.toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setLoginData,loginType = ");
    localStringBuilder.append(paramLoginData.getLoginType());
    localStringBuilder.append(" userid = ");
    localStringBuilder.append(paramLoginData.getUserId());
    localStringBuilder.append(" loginkey = ");
    localStringBuilder.append(paramLoginData.getKey());
    XLog.i("NowPluginManager | NowRoomEntry", localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.NowRoomEntry
 * JD-Core Version:    0.7.0.1
 */