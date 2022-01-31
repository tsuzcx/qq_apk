package com.tencent.mobileqq.ar.ARRenderModel;

import amrs;
import amsa;
import anby;
import bfhi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import java.util.HashMap;
import java.util.Map;

public class OnlineVideoARRenderable$4
  implements Runnable
{
  public OnlineVideoARRenderable$4(amrs paramamrs, TVK_IMediaPlayer paramTVK_IMediaPlayer) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        this.a.stop();
        try
        {
          amrs.a(this.this$0, true);
          localTVK_UserInfo = new TVK_UserInfo();
          localTVK_UserInfo.setUin("");
          localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
          localTVK_PlayerVideoInfo.setConfigMap("file_dir", anby.a(amrs.a(this.this$0)));
          if (ScanTorchActivity.h) {
            break label282;
          }
          if (!amrs.b(this.this$0)) {
            break label276;
          }
        }
        catch (Exception localException2)
        {
          TVK_UserInfo localTVK_UserInfo;
          TVK_PlayerVideoInfo localTVK_PlayerVideoInfo;
          Object localObject;
          if (!QLog.isColorLevel()) {
            break label247;
          }
          localException2.printStackTrace();
          QLog.d("AREngine_OnlineVideoARRenderable", 1, "onCompletion, exception=" + localException2.getMessage());
          return;
        }
        if (amsa.a()) {
          localObject = "true";
        }
        localTVK_PlayerVideoInfo.setConfigMap("software_play", (String)localObject);
        localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", "20161009");
        localTVK_PlayerVideoInfo.setConfigMap("filesize", String.valueOf(amrs.a(this.this$0)));
        localTVK_PlayerVideoInfo.setPlayMode("cache_extend_video");
        localTVK_PlayerVideoInfo.setVid(bfhi.d(amrs.a(this.this$0)));
        localObject = new HashMap();
        ((Map)localObject).put("shouq_bus_type", "shouq_ar_online_video");
        localTVK_PlayerVideoInfo.setReportInfoMap((Map)localObject);
        amrs.a(this.this$0).openMediaPlayerByUrl(BaseApplicationImpl.getContext(), amrs.a(this.this$0), 0L, 0L, localTVK_UserInfo, localTVK_PlayerVideoInfo);
        amrs.e(this.this$0);
        return;
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel()) {
          localException1.printStackTrace();
        }
        QLog.d("AREngine_OnlineVideoARRenderable", 1, "onCompletion, stop, exception=" + localException1.getMessage());
        continue;
      }
      label247:
      String str = "false";
      label276:
      continue;
      label282:
      str = "true";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.OnlineVideoARRenderable.4
 * JD-Core Version:    0.7.0.1
 */