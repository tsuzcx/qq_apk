package com.tencent.imsdk.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.common.NetworkInfoCenter;
import com.tencent.imsdk.common.NetworkInfoCenter.INetworkChangeListener;
import com.tencent.imsdk.common.SystemUtil;
import com.tencent.imsdk.conversation.ConversationManager;
import com.tencent.imsdk.group.GroupManager;
import com.tencent.imsdk.message.MessageCenter;
import com.tencent.imsdk.relationship.RelationshipManager;
import com.tencent.imsdk.relationship.UserInfo;
import java.lang.ref.WeakReference;

public class BaseManager
  implements NetworkInfoCenter.INetworkChangeListener
{
  private static final String TAG = "BaseManager";
  private static boolean mLoadLibrarySuccess = false;
  private boolean isInit = false;
  private WeakReference<SDKListener> sdkListenerWeakReference;
  
  static
  {
    try
    {
      mLoadLibrarySuccess = SystemUtil.loadIMLibrary();
      return;
    }
    catch (Exception localException)
    {
      IMLog.e(TAG, localException.toString());
    }
  }
  
  public static BaseManager getInstance()
  {
    return BaseManager.BaseManagerHolder.access$000();
  }
  
  private String getUIPlatform()
  {
    if ((isTUIKit()) && (isFlutter())) {
      return "tuikit&flutter";
    }
    if (isTUIKit()) {
      return "tuikit";
    }
    if (isFlutter()) {
      return "flutter";
    }
    return "";
  }
  
  private boolean isFlutter()
  {
    try
    {
      Class localClass = Class.forName("com.qq.qcloud.tencent_im_sdk_plugin.tencent_im_sdk_plugin");
      if (localClass != null) {
        return true;
      }
    }
    catch (Exception localException)
    {
      label12:
      break label12;
    }
    return false;
  }
  
  private boolean isTUIKit()
  {
    try
    {
      if (Class.forName("com.tencent.qcloud.tim.uikit.TUIKit") != null) {
        return true;
      }
      StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
      int i = 0;
      while (i < arrayOfStackTraceElement.length)
      {
        boolean bool = arrayOfStackTraceElement[i].getClassName().contains("TUIKitImpl");
        if (bool) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public long getClockTickInHz()
  {
    return nativeGetClockTickInHz();
  }
  
  public int getLoginStatus()
  {
    return nativeGetLoginStatus();
  }
  
  public String getLoginUser()
  {
    return nativeGetLoginUser();
  }
  
  public long getServerTime()
  {
    return nativeGetServerTime();
  }
  
  public long getTimeTick()
  {
    return nativeGetTimeTick();
  }
  
  public String getVersion()
  {
    return nativeGetSDKVersion();
  }
  
  public void initLocalStorage(String paramString, IMCallback paramIMCallback)
  {
    if (!this.isInit)
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeInitLocalStorage(paramString, paramIMCallback);
  }
  
  public boolean initSDK(Context paramContext, SDKConfig paramSDKConfig, SDKListener paramSDKListener)
  {
    if (paramSDKConfig.sdkAppId <= 0L)
    {
      paramContext = TAG;
      paramSDKListener = new StringBuilder();
      paramSDKListener.append("invalid sdkAppID:");
      paramSDKListener.append(paramSDKConfig.sdkAppId);
      IMLog.e(paramContext, paramSDKListener.toString());
      return false;
    }
    if (!mLoadLibrarySuccess)
    {
      IMLog.e(TAG, "libimsdk.so is not loaded");
      return false;
    }
    if (paramContext == null)
    {
      IMLog.e(TAG, "null context");
      return false;
    }
    if (this.isInit)
    {
      IMLog.w(TAG, "Has initSDK");
      return true;
    }
    String str = nativeGetSDKVersion();
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("BuglySdkInfos", 0).edit();
    localEditor.putString("ebfa608d4d", str);
    localEditor.commit();
    IMContext.getInstance().init(paramContext.getApplicationContext());
    NetworkInfoCenter.getInstance().init(paramContext.getApplicationContext(), this);
    MessageCenter.getInstance().init();
    GroupManager.getInstance().init();
    ConversationManager.getInstance().init();
    RelationshipManager.getInstance().init();
    paramSDKConfig.sdkInitPath = SystemUtil.getSDKInitPath();
    paramSDKConfig.sdkInstanceType = SystemUtil.getInstanceType();
    paramSDKConfig.testEnvironment = false;
    paramSDKConfig.deviceInfo.deviceType = SystemUtil.getDeviceType();
    paramSDKConfig.deviceInfo.deviceId = SystemUtil.getDeviceID();
    paramSDKConfig.deviceInfo.deviceBrand = SystemUtil.getInstanceType();
    paramSDKConfig.deviceInfo.systemVersion = SystemUtil.getSystemVersion();
    paramSDKConfig.networkInfo.networkType = NetworkInfoCenter.getInstance().getNetworkType();
    paramSDKConfig.networkInfo.ipType = NetworkInfoCenter.getInstance().getIPType();
    paramSDKConfig.networkInfo.networkId = NetworkInfoCenter.getInstance().getNetworkID();
    paramSDKConfig.networkInfo.networkConnected = NetworkInfoCenter.getInstance().isNetworkConnected();
    paramSDKConfig.logSetting.enableConsoleLog = true;
    paramSDKConfig.logSetting.logFilePath = SystemUtil.getSDKLogPath();
    paramSDKConfig.uiPlatform = getUIPlatform();
    nativeInitSDK(paramSDKConfig, paramSDKListener);
    NetworkInfoCenter.getInstance().registerNetworkReceiver();
    this.sdkListenerWeakReference = new WeakReference(paramSDKListener);
    this.isInit = true;
    return true;
  }
  
  public boolean isInited()
  {
    return this.isInit;
  }
  
  public void login(String paramString1, String paramString2, IMCallback paramIMCallback)
  {
    if (!this.isInit)
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeLogin(paramString1, paramString2, paramIMCallback);
  }
  
  public void logout(IMCallback paramIMCallback)
  {
    if (!this.isInit)
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeLogout(paramIMCallback);
  }
  
  protected native long nativeGetClockTickInHz();
  
  protected native int nativeGetLoginStatus();
  
  protected native String nativeGetLoginUser();
  
  protected native String nativeGetSDKVersion();
  
  protected native long nativeGetServerTime();
  
  protected native long nativeGetTimeTick();
  
  protected native void nativeInitLocalStorage(String paramString, IMCallback paramIMCallback);
  
  protected native void nativeInitSDK(SDKConfig paramSDKConfig, SDKListener paramSDKListener);
  
  protected native void nativeLogin(String paramString1, String paramString2, IMCallback paramIMCallback);
  
  protected native void nativeLogout(IMCallback paramIMCallback);
  
  protected native void nativeNotifyNetworkChange(boolean paramBoolean, int paramInt1, int paramInt2, String paramString);
  
  protected native void nativeSetPrivatizationInfo(PrivatizationInfo paramPrivatizationInfo);
  
  protected native void nativeUninitSDK();
  
  public void notifySelfInfoUpdated(UserInfo paramUserInfo)
  {
    Object localObject = this.sdkListenerWeakReference;
    if (localObject != null)
    {
      localObject = (SDKListener)((WeakReference)localObject).get();
      if (localObject != null) {
        ((SDKListener)localObject).onSelfInfoUpdated(paramUserInfo);
      }
    }
  }
  
  public void onNetworkChange(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    nativeNotifyNetworkChange(paramBoolean, paramInt1, paramInt2, paramString);
  }
  
  public boolean setLibraryPath(String paramString)
  {
    mLoadLibrarySuccess = SystemUtil.loadIMLibrary(paramString);
    return mLoadLibrarySuccess;
  }
  
  public void setPrivatizationInfo(PrivatizationInfo paramPrivatizationInfo)
  {
    nativeSetPrivatizationInfo(paramPrivatizationInfo);
  }
  
  public void unInitSDK()
  {
    nativeUninitSDK();
    this.isInit = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.manager.BaseManager
 * JD-Core Version:    0.7.0.1
 */