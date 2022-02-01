package com.tencent.hippy.qq.module.tkd;

import androidx.annotation.NonNull;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

@HippyNativeModule(name="TKDAccountModule")
public class TKDAccountModule
  extends HippyNativeModuleBase
{
  private static final int LOGIN_TYPE_QQ = 1;
  private static final String TAG = "AccountModule";
  
  public TKDAccountModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  public static HippyMap convertAccountInfo2HippyMap(@NonNull TKDAccountModule.AccountInfo paramAccountInfo)
  {
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushInt("type", 1);
    localHippyMap.pushString("qbid", paramAccountInfo.qqNum);
    localHippyMap.pushString("uin", paramAccountInfo.qqNum);
    localHippyMap.pushString("token", paramAccountInfo.qqNum);
    localHippyMap.pushString("nickname", paramAccountInfo.nickName);
    localHippyMap.pushString("head", paramAccountInfo.headUrl);
    localHippyMap.pushString("skey", paramAccountInfo.skey);
    localHippyMap.pushString("appid", paramAccountInfo.appid);
    return localHippyMap;
  }
  
  @NonNull
  public static TKDAccountModule.AccountInfo getCurAccountInfo()
  {
    long l = ReadInJoyUtils.a();
    TKDAccountModule.AccountInfo localAccountInfo = new TKDAccountModule.AccountInfo();
    Object localObject = ReadInJoyUserInfoModule.a(l, null);
    if (localObject != null)
    {
      localAccountInfo.qqNum = ((ReadInJoyUserInfo)localObject).uin;
      localAccountInfo.nickName = ((ReadInJoyUserInfo)localObject).nick;
      localAccountInfo.headUrl = ReadInJoyUserInfoModule.a((ReadInJoyUserInfo)localObject);
    }
    localObject = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
    if (localObject != null) {
      localAccountInfo.skey = ((TicketManager)localObject).getSkey(localAccountInfo.qqNum);
    }
    localAccountInfo.appid = (AppSetting.a() + "");
    QLog.d("AccountModule", 1, "getCurAccountInfo .accountInfo=" + localAccountInfo);
    return localAccountInfo;
  }
  
  @HippyMethod(name="getAccountInfo")
  public void getAccountInfo(Promise paramPromise)
  {
    paramPromise.resolve(convertAccountInfo2HippyMap(getCurAccountInfo()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.tkd.TKDAccountModule
 * JD-Core Version:    0.7.0.1
 */