package com.tencent.hippy.qq.api.impl;

import android.os.Bundle;
import com.tencent.hippy.qq.api.HippyConfig;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.hippy.qq.api.IUpdateListener;
import com.tencent.hippy.qq.api.TabFile;
import com.tencent.hippy.qq.update.HippyUpdateManager;
import com.tencent.hippy.qq.update.sso.HippyUnissoHandler;
import java.util.Map;
import org.json.JSONObject;

public class HippyUpdateImpl
  implements IHippyUpdate
{
  public void cancelDownloadTask(String paramString, int paramInt)
  {
    HippyUpdateManager.getInstance().cancelDownloadTask(paramString, paramInt);
  }
  
  public boolean checkUpdateJsBundleInterval(String paramString)
  {
    return HippyUpdateManager.getInstance().checkUpdateJsBundleInterval(paramString);
  }
  
  public HippyConfig getHippyConfig()
  {
    return HippyUpdateManager.getInstance().getHippyConfig();
  }
  
  public Map<String, TabFile> getTabFilesConfig()
  {
    return HippyUpdateManager.getInstance().getTabFilesConfig();
  }
  
  public void preDownloadHippyByController(int paramInt)
  {
    HippyUpdateManager.getInstance().preDownloadHippyByController(paramInt);
  }
  
  public void predownloadHippy(int paramInt)
  {
    HippyUpdateManager.getInstance().predownloadHippy(paramInt);
  }
  
  public void removeJsBundleUpdateListener(String paramString, IUpdateListener paramIUpdateListener)
  {
    HippyUpdateManager.getInstance().removeJsBundleUpdateListener(paramString, paramIUpdateListener);
  }
  
  public void reportHippy(JSONObject paramJSONObject)
  {
    HippyUnissoHandler localHippyUnissoHandler = HippyUnissoHandler.getInstance();
    if (localHippyUnissoHandler != null) {
      localHippyUnissoHandler.reportHippy(paramJSONObject);
    }
  }
  
  public void updateJsBundle(String paramString, boolean paramBoolean, int paramInt, Bundle paramBundle, IUpdateListener paramIUpdateListener)
  {
    HippyUpdateManager.getInstance().updateJsBundle(paramString, paramBoolean, paramInt, paramBundle, paramIUpdateListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.api.impl.HippyUpdateImpl
 * JD-Core Version:    0.7.0.1
 */