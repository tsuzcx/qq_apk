package com.tencent.hippy.qq.module.tkd;

import androidx.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import tzq;

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
  
  private HippyMap convertAccountInfo2HippyMap(@NonNull TKDAccountModule.AccountInfo paramAccountInfo)
  {
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushInt("type", 1);
    localHippyMap.pushString("qbid", paramAccountInfo.qqNum);
    localHippyMap.pushString("uin", paramAccountInfo.qqNum);
    localHippyMap.pushString("token", paramAccountInfo.qqNum);
    localHippyMap.pushString("nickname", paramAccountInfo.nickName);
    return localHippyMap;
  }
  
  @NonNull
  public static TKDAccountModule.AccountInfo getCurAccountInfo()
  {
    Object localObject3 = "";
    String str = "";
    Object localObject2 = str;
    Object localObject1 = localObject3;
    if (BaseApplicationImpl.getApplication() != null)
    {
      localObject2 = str;
      localObject1 = localObject3;
      if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
      {
        localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        localObject1 = ((QQAppInterface)localObject2).c();
        localObject2 = tzq.a((QQAppInterface)localObject2, (String)localObject1);
      }
    }
    localObject3 = new TKDAccountModule.AccountInfo();
    ((TKDAccountModule.AccountInfo)localObject3).qqNum = ((String)localObject1);
    ((TKDAccountModule.AccountInfo)localObject3).nickName = ((String)localObject2);
    return localObject3;
  }
  
  @HippyMethod(name="getAccountInfo")
  public void getAccountInfo(Promise paramPromise)
  {
    paramPromise.resolve(convertAccountInfo2HippyMap(getCurAccountInfo()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.module.tkd.TKDAccountModule
 * JD-Core Version:    0.7.0.1
 */