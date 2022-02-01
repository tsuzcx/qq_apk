package com.tencent.hippy.qq.module;

import android.app.Activity;
import android.support.v4.app.Fragment;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import java.util.HashMap;

public class QQBaseModule
  extends HippyNativeModuleBase
{
  volatile int mCallbackIdCounter = 0;
  HashMap<String, Promise> mapCallbacks = new HashMap();
  
  public QQBaseModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  public void destroy()
  {
    super.destroy();
    this.mapCallbacks.clear();
  }
  
  public Activity getActivity()
  {
    HippyQQEngine localHippyQQEngine = getHippyQQEngine();
    if (localHippyQQEngine == null) {
      return null;
    }
    return localHippyQQEngine.getActivity();
  }
  
  protected AppInterface getAppInterface()
  {
    return HippyReporter.getAppInterface();
  }
  
  protected BaseActivity getBaseActivity()
  {
    if ((getActivity() instanceof BaseActivity)) {
      return (BaseActivity)getActivity();
    }
    return null;
  }
  
  protected final Promise getCallback(String paramString)
  {
    return (Promise)this.mapCallbacks.get(paramString);
  }
  
  protected Fragment getFragment()
  {
    HippyQQEngine localHippyQQEngine = getHippyQQEngine();
    if (localHippyQQEngine == null) {
      return null;
    }
    return localHippyQQEngine.getFragment();
  }
  
  protected HippyQQEngine getHippyQQEngine()
  {
    return HippyQQEngine.getEngineInstance(this.mContext.getEngineId());
  }
  
  protected final int saveCallback(Promise paramPromise)
  {
    int i = this.mCallbackIdCounter + 1;
    this.mCallbackIdCounter = i;
    this.mapCallbacks.put(String.valueOf(i), paramPromise);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQBaseModule
 * JD-Core Version:    0.7.0.1
 */