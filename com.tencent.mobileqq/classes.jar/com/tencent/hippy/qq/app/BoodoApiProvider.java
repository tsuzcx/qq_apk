package com.tencent.hippy.qq.app;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.module.QQGdtModule;
import com.tencent.hippy.qq.module.boodo.BoodoModule;
import com.tencent.hippy.qq.view.boodo.QQHippyWebViewController;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.javascriptmodules.HippyJavaScriptModule;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.utils.BoodoHippyBirdge;
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
      BoodoHippyBirdge.a();
      QLog.i("BoodoApiProviderWrapper", 1, "checkInitBoodoPluginImpl mProviderImp:" + this.mProviderImp);
      initProviderImp();
    }
    Intent localIntent = new Intent("action_hippy_activity_launch");
    localIntent.setPackage(BaseApplicationImpl.getContext().getPackageName());
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
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
      this.mProviderImp = BoodoHippyBirdge.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.app.BoodoApiProvider
 * JD-Core Version:    0.7.0.1
 */