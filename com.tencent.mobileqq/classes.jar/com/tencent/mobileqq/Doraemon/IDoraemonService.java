package com.tencent.mobileqq.Doraemon;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.webview.nativeapi.INativeApiMangerInjector;

@QAPI(process={"all"})
public abstract interface IDoraemonService
  extends QRouteApi
{
  public abstract DoraemonAPIManager createAPIManager(@NonNull Activity paramActivity, int paramInt, String paramString);
  
  public abstract DoraemonAPIManager createAPIManager(@NonNull Activity paramActivity, int paramInt, String paramString, Bundle paramBundle);
  
  public abstract DoraemonAPIManager getDoraemonAPIModuleByUrl(INativeApiMangerInjector paramINativeApiMangerInjector, String paramString);
  
  public abstract void prepare();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.IDoraemonService
 * JD-Core Version:    0.7.0.1
 */