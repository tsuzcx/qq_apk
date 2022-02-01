package com.tencent.hippy.qq.module.tkd;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import aogi;
import aogk;
import bhcu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyGlobalConfigs;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.qphone.base.util.QLog;

@HippyNativeModule(name="TKDWupModule")
public class TKDWupModule
  extends HippyNativeModuleBase
{
  private static final String TAG = "HippyQQWupModule";
  protected QQAppInterface app;
  protected BroadcastReceiver mAccountChangedReceiver = new TKDWupModule.2(this);
  protected aogk mUniteSearchObserver = new TKDWupModule.1(this);
  private Integer requestId;
  private TKDWupModule.HippyWupCallbackManager wupCallbackManager;
  
  public TKDWupModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  private void doSend(HippyMap paramHippyMap, Promise paramPromise, boolean paramBoolean)
  {
    String str1;
    String str2;
    String str3;
    String str4;
    try
    {
      str1 = paramHippyMap.getString("serviceName");
      str2 = paramHippyMap.getString("funcName");
      str3 = paramHippyMap.getString("reqName");
      String str5 = paramHippyMap.getString("rspClassName");
      str4 = paramHippyMap.getString("reqClassName");
      localObject = paramHippyMap.getString("base64data");
      paramHippyMap = paramHippyMap.getString("rspName");
      TKDWupModule.HippyWupCallbackManager localHippyWupCallbackManager = this.wupCallbackManager;
      Integer localInteger = Integer.valueOf(this.requestId.intValue() + 1);
      this.requestId = localInteger;
      localHippyWupCallbackManager.registerWupCallback(paramHippyMap, str5, paramPromise, localInteger);
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || ((!paramBoolean) && ((TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str4))))) {
        throw new IllegalArgumentException("Invalid Params when sending wup from Hippy!!!!!");
      }
    }
    catch (Throwable paramHippyMap)
    {
      QLog.e("WupModule", 1, "Error Sending Hippy WUP Requeset");
      paramPromise.reject("wup send error, cause: " + paramHippyMap.getMessage());
      return;
    }
    paramHippyMap = (HippyMap)localObject;
    if (localObject == null) {
      paramHippyMap = "";
    }
    paramHippyMap = bhcu.decode(paramHippyMap, 0);
    Object localObject = new TKDWupUniPacket();
    ((TKDWupUniPacket)localObject).setServantName(str1);
    ((TKDWupUniPacket)localObject).setFuncName(str2);
    ((TKDWupUniPacket)localObject).setEncodeName("UTF-8");
    ((TKDWupUniPacket)localObject).setRequestId(this.requestId.intValue());
    ((TKDWupUniPacket)localObject).putRawRequestData(str3, str4, paramHippyMap);
    new aogi((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(((TKDWupUniPacket)localObject).encode(), this.wupCallbackManager, this.requestId);
  }
  
  public void destroy()
  {
    super.destroy();
    this.app.removeObserver(this.mUniteSearchObserver);
    if ((this.mContext != null) && (this.mContext.getGlobalConfigs() != null) && (this.mContext.getGlobalConfigs().getContext() != null)) {
      this.mContext.getGlobalConfigs().getContext().unregisterReceiver(this.mAccountChangedReceiver);
    }
  }
  
  public void initialize()
  {
    this.wupCallbackManager = new TKDWupModule.HippyWupCallbackManager();
    this.requestId = Integer.valueOf(0);
    this.app = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.app.addObserver(this.mUniteSearchObserver);
    if ((this.mContext != null) && (this.mContext.getGlobalConfigs() != null) && (this.mContext.getGlobalConfigs().getContext() != null))
    {
      IntentFilter localIntentFilter = new IntentFilter("mqq.intent.action.ACCOUNT_CHANGED");
      this.mContext.getGlobalConfigs().getContext().registerReceiver(this.mAccountChangedReceiver, localIntentFilter);
    }
  }
  
  @HippyMethod(name="pbSend")
  public void pbsend(HippyMap paramHippyMap, Promise paramPromise)
  {
    doSend(paramHippyMap, paramPromise, true);
  }
  
  @HippyMethod(name="send")
  public void send(HippyMap paramHippyMap, Promise paramPromise)
  {
    doSend(paramHippyMap, paramPromise, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.module.tkd.TKDWupModule
 * JD-Core Version:    0.7.0.1
 */