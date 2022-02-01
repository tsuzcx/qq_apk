package com.tencent.hippy.qq.module;

import android.text.TextUtils;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;

@HippyNativeModule(name="QQHippyBundleModule")
public class QQHippyBundleModule
  extends QQBaseModule
{
  static final String CLASS_NAME = "QQHippyBundleModule";
  public static final int UPDATE_RESULT_CODE_ERROR = -1;
  public static final int UPDATE_RESULT_CODE_NO_NEW_VERSION = 0;
  public static final int UPDATE_RESULT_CODE_OK = 1;
  
  public QQHippyBundleModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  protected void onJsUpdateCompleted(String paramString1, int paramInt, String paramString2, Promise paramPromise)
  {
    if (paramPromise == null) {
      return;
    }
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushInt("retCode", paramInt);
    if (paramInt == 1) {
      localHippyMap.pushInt("newVersion", ((IHippySetting)QRoute.api(IHippySetting.class)).getModuleVersion(paramString1));
    } else if (paramInt == -1) {
      localHippyMap.pushString("errMsg", paramString2);
    }
    paramPromise.resolve(localHippyMap);
  }
  
  @HippyMethod(name="updateJsBundle")
  public void updateJsBundle(String paramString, Promise paramPromise)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((IHippyUpdate)QRoute.api(IHippyUpdate.class)).commonUpdateJsBundle(paramString, "updateApiHippy", new QQHippyBundleModule.1(this, paramPromise));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQHippyBundleModule
 * JD-Core Version:    0.7.0.1
 */