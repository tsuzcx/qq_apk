package com.tencent.mobileqq.Doraemon.impl;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.DoraemonOpenAPI;
import com.tencent.mobileqq.Doraemon.IDoraemonService;
import com.tencent.mobileqq.Doraemon.NativeApiManagerImpl;
import com.tencent.mobileqq.webview.nativeapi.INativeApiMangerInjector;

public class DoraemonServiceImpl
  implements IDoraemonService
{
  public DoraemonAPIManager createAPIManager(Activity paramActivity, int paramInt, String paramString)
  {
    return createAPIManager(paramActivity, paramInt, paramString, null);
  }
  
  public DoraemonAPIManager createAPIManager(Activity paramActivity, int paramInt, String paramString, Bundle paramBundle)
  {
    return DoraemonOpenAPI.a(paramActivity, paramInt, paramString, paramBundle);
  }
  
  public DoraemonAPIManager getDoraemonAPIModuleByUrl(INativeApiMangerInjector paramINativeApiMangerInjector, String paramString)
  {
    if ((paramINativeApiMangerInjector instanceof NativeApiManagerImpl)) {
      return ((NativeApiManagerImpl)paramINativeApiMangerInjector).a(paramString);
    }
    return null;
  }
  
  public void prepare() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.DoraemonServiceImpl
 * JD-Core Version:    0.7.0.1
 */