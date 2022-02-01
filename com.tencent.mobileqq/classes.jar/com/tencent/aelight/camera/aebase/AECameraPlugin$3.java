package com.tencent.aelight.camera.aebase;

import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import java.io.File;
import org.json.JSONObject;

class AECameraPlugin$3
  implements INetEngineListener
{
  AECameraPlugin$3(AECameraPlugin paramAECameraPlugin, String paramString1, String paramString2, String paramString3) {}
  
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
      AECameraPlugin.a(this.d, 2);
      paramNetResp = AECameraPlugin.a(this.d, this.a, "downloading succeeded");
      this.d.callJs(this.b, new String[] { paramNetResp.toString() });
      if (AECameraPlugin.a(this.d.mRuntime.d())) {
        FileUtils.a(BaseApplicationImpl.getApplication(), new File(this.c));
      }
    }
    else
    {
      AECameraPlugin.a(this.d, 3);
      paramNetResp = AECameraPlugin.b(this.d, this.a, "downloading failed");
      this.d.callJs(this.b, new String[] { paramNetResp.toString() });
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.AECameraPlugin.3
 * JD-Core Version:    0.7.0.1
 */