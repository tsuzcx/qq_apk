package com.tencent.comic.hippy.api;

import android.app.Application;
import android.content.Intent;
import com.tencent.comic.hippy.BoodoHippyBirdge;
import com.tencent.comic.hippy.module.BoodoModule;
import com.tencent.comic.hippy.module.QQGdtModule;
import com.tencent.comic.hippy.view.QQHippyWebViewController;
import com.tencent.comic.utils.AppHelper;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.javascriptmodules.HippyJavaScriptModule;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoodoApiProvider
  extends HippyApiProviderWrapper
{
  private static final String TAG = "BoodoApiProviderWrapper";
  
  public BoodoApiProvider()
  {
    QLog.i("BoodoApiProviderWrapper", 1, "init");
    initProviderImp();
    if (this.mProviderImp == null)
    {
      BoodoHippyBirdge.checkInitBoodoPluginImpl();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkInitBoodoPluginImpl mProviderImp:");
      ((StringBuilder)localObject).append(this.mProviderImp);
      QLog.i("BoodoApiProviderWrapper", 1, ((StringBuilder)localObject).toString());
      initProviderImp();
    }
    Object localObject = new Intent("action_hippy_activity_launch");
    ((Intent)localObject).setPackage(AppHelper.a().getPackageName());
    AppHelper.a().sendBroadcast((Intent)localObject);
  }
  
  public List<Class<? extends HippyViewController>> getControllers()
  {
    List localList = super.getControllers();
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    ((List)localObject).add(QQHippyWebViewController.class);
    return localObject;
  }
  
  public List<Class<? extends HippyJavaScriptModule>> getJavaScriptModules()
  {
    return super.getJavaScriptModules();
  }
  
  public Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> getNativeModules(HippyEngineContext paramHippyEngineContext)
  {
    Map localMap = super.getNativeModules(paramHippyEngineContext);
    Object localObject = localMap;
    if (localMap == null) {
      localObject = new HashMap();
    }
    ((Map)localObject).put(BoodoModule.class, new BoodoApiProvider.1(this, paramHippyEngineContext));
    ((Map)localObject).put(QQGdtModule.class, new BoodoApiProvider.2(this, paramHippyEngineContext));
    return localObject;
  }
  
  protected void initProviderImp()
  {
    if (this.mProviderImp == null) {
      this.mProviderImp = BoodoHippyBirdge.createBoodoProvider();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.hippy.api.BoodoApiProvider
 * JD-Core Version:    0.7.0.1
 */