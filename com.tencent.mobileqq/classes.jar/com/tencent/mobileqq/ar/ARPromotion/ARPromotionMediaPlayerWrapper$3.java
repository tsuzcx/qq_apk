package com.tencent.mobileqq.ar.ARPromotion;

import akxy;
import akxz;
import alli;
import android.text.TextUtils;
import bdik;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import java.util.HashMap;
import java.util.Map;

public class ARPromotionMediaPlayerWrapper$3
  implements Runnable
{
  public ARPromotionMediaPlayerWrapper$3(akxy paramakxy, TVK_IMediaPlayer paramTVK_IMediaPlayer) {}
  
  public void run()
  {
    if (akxy.b(this.this$0)) {
      akxy.c(this.this$0);
    }
    QLog.d("ARWorldCupMediaPlayerWrapper", 1, "onCompletion, mNeedAddPlayCount=" + akxy.b(this.this$0) + " mCurrentPlayTimes=" + akxy.d(this.this$0) + "|" + akxy.e(this.this$0));
    if ((akxy.d(this.this$0) < akxy.e(this.this$0)) && (akxy.a(this.this$0) != null) && (!akxy.a(this.this$0))) {}
    do
    {
      TVK_PlayerVideoInfo localTVK_PlayerVideoInfo;
      try
      {
        this.a.stop();
        localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
        if ((!TextUtils.isEmpty(akxy.a(this.this$0))) && (!akxy.a(this.this$0).startsWith("http")) && (!akxy.a(this.this$0).startsWith("https")))
        {
          localTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
          if (akxy.c(this.this$0))
          {
            String str = "true";
            localTVK_PlayerVideoInfo.setConfigMap("software_play", str);
            localTVK_PlayerVideoInfo.setPlayType(4);
            akxy.a(this.this$0).setOutputMute(akxy.d(this.this$0));
            akxy.a(this.this$0).openMediaPlayerByUrl(BaseApplicationImpl.getContext(), akxy.a(this.this$0), 0L, 0L, localTVK_PlayerVideoInfo);
            akxy.a(this.this$0, false);
            if ((akxy.e(this.this$0)) && (akxy.a(this.this$0) != null) && (akxy.a(this.this$0) != null)) {
              akxy.a(this.this$0).a(akxy.b(this.this$0), 1, akxy.e(this.this$0) - akxy.d(this.this$0));
            }
            QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer. restart remian times:" + (akxy.e(this.this$0) - akxy.d(this.this$0)) + "video resources:" + akxy.a(this.this$0));
            return;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            localException.printStackTrace();
          }
          QLog.d("ARWorldCupMediaPlayerWrapper", 1, "onCompletion, stop, exception=" + localException.getMessage());
          continue;
          localObject = "false";
        }
        localTVK_PlayerVideoInfo.setConfigMap("file_dir", alli.a(akxy.a(this.this$0)));
        if (!akxy.c(this.this$0)) {}
      }
      for (Object localObject = "true";; localObject = "false")
      {
        localTVK_PlayerVideoInfo.setConfigMap("software_play", (String)localObject);
        localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", "20161009");
        localTVK_PlayerVideoInfo.setPlayMode("cache_extend_video");
        localTVK_PlayerVideoInfo.setVid(bdik.d(akxy.a(this.this$0)));
        localObject = new HashMap();
        ((HashMap)localObject).put("shouq_bus_type", "shouq_ar_online_video");
        localTVK_PlayerVideoInfo.setReportInfoMap((Map)localObject);
        break;
      }
      akxy.a(this.this$0, 0);
      akxy.b(this.this$0, 1);
      akxy.a(this.this$0, true);
      QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer.onCompletion");
    } while ((akxy.a(this.this$0) == null) || (akxy.a(this.this$0) == null));
    akxy.a(this.this$0).a(akxy.b(this.this$0), 1, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper.3
 * JD-Core Version:    0.7.0.1
 */