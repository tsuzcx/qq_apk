package com.tencent.hippy.qq.api;

import com.tencent.hippy.qq.app.OnMainBundleLoadListener;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import org.json.JSONObject;

@QAPI(process={"all"})
public abstract interface IPatchBundleDataHandler
  extends QRouteApi
{
  public abstract OnMainBundleLoadListener checkCreateHippyListener(String paramString);
  
  public abstract void checkDownloadConfigAsync(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract JSONObject checkWrapSSOData(JSONObject paramJSONObject, String paramString);
  
  public abstract void getSSOListData(HippyMap paramHippyMap, Promise paramPromise);
  
  public abstract boolean isRunPatch(HippyEngineContext paramHippyEngineContext);
  
  public abstract void loadPatchFromUrl(HippyEngineContext paramHippyEngineContext, String paramString, int paramInt, Promise paramPromise);
  
  public abstract void onAppAsyncStepStart();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.api.IPatchBundleDataHandler
 * JD-Core Version:    0.7.0.1
 */