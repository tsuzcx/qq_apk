package com.tencent.hippy.qq.api.impl;

import android.os.Bundle;
import com.tencent.hippy.qq.api.HippyConfig;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.hippy.qq.api.IUpdateListener;
import com.tencent.hippy.qq.api.TabFile;
import com.tencent.hippy.qq.update.HippyPredownloadManager;
import com.tencent.hippy.qq.update.HippyUpdateManager;
import com.tencent.hippy.qq.update.sso.HippyUnissoHandler;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Map;
import org.json.JSONObject;

public class HippyUpdateImpl
  implements IHippyUpdate
{
  public void cancelDownloadTask(String paramString, int paramInt)
  {
    HippyPredownloadManager.getInstance().cancelDownloadTask(paramString, paramInt);
  }
  
  public boolean checkUpdateJsBundleInterval(String paramString)
  {
    return HippyUpdateManager.getInstance().checkUpdateJsBundleInterval(paramString);
  }
  
  public void commonUpdateJsBundle(String paramString1, String paramString2, IUpdateListener paramIUpdateListener)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("reportFrom", paramString2);
    HippyUpdateManager.getInstance().updateJsBundle(paramString1, ((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).isUpdateHippyJsBundleByHttp(), 4, localBundle, paramIUpdateListener);
  }
  
  public HippyConfig getHippyConfig()
  {
    return HippyPredownloadManager.getInstance().getHippyConfig();
  }
  
  public Map<String, TabFile> getTabFilesConfig()
  {
    return HippyPredownloadManager.getInstance().getTabFilesConfig();
  }
  
  public void preDownloadHippyByController(int paramInt1, int paramInt2)
  {
    HippyPredownloadManager.getInstance().preDownloadHippyByController(paramInt1, paramInt2);
  }
  
  public void predownloadHippy(int paramInt)
  {
    HippyPredownloadManager.getInstance().predownloadHippy(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.api.impl.HippyUpdateImpl
 * JD-Core Version:    0.7.0.1
 */