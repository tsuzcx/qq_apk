package com.tencent.aelight.camera.aebase;

import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

class AECameraPlugin$4
  implements INetEngineListener
{
  AECameraPlugin$4(AECameraPlugin paramAECameraPlugin, String paramString1, String paramString2) {}
  
  public void onResp(NetResp paramNetResp)
  {
    int i;
    if (paramNetResp.mErrCode == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (AECameraPlugin.a(this.c.mRuntime.d())) {
        FileUtils.a(BaseApplicationImpl.getApplication(), new File(this.a));
      }
      AECameraPlugin.b(this.c, this.b);
      AECameraPlugin.c(this.c, this.a);
      return;
    }
    paramNetResp = new JSONObject();
    try
    {
      paramNetResp.put("succeeded", false);
      paramNetResp.put("message", "download fail");
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.c.callJs(this.b, new String[] { paramNetResp.toString() });
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.AECameraPlugin.4
 * JD-Core Version:    0.7.0.1
 */