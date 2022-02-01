package com.tencent.hippy.qq.api;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;
import org.json.JSONObject;

@QAPI(process={"all"})
public abstract interface IHippyUpdate
  extends QRouteApi
{
  public abstract void cancelDownloadTask(String paramString, int paramInt);
  
  public abstract boolean checkUpdateJsBundleInterval(String paramString);
  
  public abstract HippyConfig getHippyConfig();
  
  public abstract Map<String, TabFile> getTabFilesConfig();
  
  public abstract void preDownloadHippyByController(int paramInt);
  
  public abstract void predownloadHippy(int paramInt);
  
  public abstract void removeJsBundleUpdateListener(String paramString, IUpdateListener paramIUpdateListener);
  
  public abstract void reportHippy(JSONObject paramJSONObject);
  
  public abstract void updateJsBundle(String paramString, boolean paramBoolean, int paramInt, Bundle paramBundle, IUpdateListener paramIUpdateListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.api.IHippyUpdate
 * JD-Core Version:    0.7.0.1
 */