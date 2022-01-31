package com.tencent.mobileqq.ar.ARPromotion;

import akxz;
import akya;
import allj;
import android.text.TextUtils;
import bdhv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import java.util.HashMap;
import java.util.Map;

public class ARPromotionMediaPlayerWrapper$3
  implements Runnable
{
  public ARPromotionMediaPlayerWrapper$3(akxz paramakxz, TVK_IMediaPlayer paramTVK_IMediaPlayer) {}
  
  public void run()
  {
    if (akxz.b(this.this$0)) {
      akxz.c(this.this$0);
    }
    QLog.d("ARWorldCupMediaPlayerWrapper", 1, "onCompletion, mNeedAddPlayCount=" + akxz.b(this.this$0) + " mCurrentPlayTimes=" + akxz.d(this.this$0) + "|" + akxz.e(this.this$0));
    if ((akxz.d(this.this$0) < akxz.e(this.this$0)) && (akxz.a(this.this$0) != null) && (!akxz.a(this.this$0))) {}
    do
    {
      TVK_PlayerVideoInfo localTVK_PlayerVideoInfo;
      try
      {
        this.a.stop();
        localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
        if ((!TextUtils.isEmpty(akxz.a(this.this$0))) && (!akxz.a(this.this$0).startsWith("http")) && (!akxz.a(this.this$0).startsWith("https")))
        {
          localTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
          if (akxz.c(this.this$0))
          {
            String str = "true";
            localTVK_PlayerVideoInfo.setConfigMap("software_play", str);
            localTVK_PlayerVideoInfo.setPlayType(4);
            akxz.a(this.this$0).setOutputMute(akxz.d(this.this$0));
            akxz.a(this.this$0).openMediaPlayerByUrl(BaseApplicationImpl.getContext(), akxz.a(this.this$0), 0L, 0L, localTVK_PlayerVideoInfo);
            akxz.a(this.this$0, false);
            if ((akxz.e(this.this$0)) && (akxz.a(this.this$0) != null) && (akxz.a(this.this$0) != null)) {
              akxz.a(this.this$0).a(akxz.b(this.this$0), 1, akxz.e(this.this$0) - akxz.d(this.this$0));
            }
            QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer. restart remian times:" + (akxz.e(this.this$0) - akxz.d(this.this$0)) + "video resources:" + akxz.a(this.this$0));
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
        localTVK_PlayerVideoInfo.setConfigMap("file_dir", allj.a(akxz.a(this.this$0)));
        if (!akxz.c(this.this$0)) {}
      }
      for (Object localObject = "true";; localObject = "false")
      {
        localTVK_PlayerVideoInfo.setConfigMap("software_play", (String)localObject);
        localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", "20161009");
        localTVK_PlayerVideoInfo.setPlayMode("cache_extend_video");
        localTVK_PlayerVideoInfo.setVid(bdhv.d(akxz.a(this.this$0)));
        localObject = new HashMap();
        ((HashMap)localObject).put("shouq_bus_type", "shouq_ar_online_video");
        localTVK_PlayerVideoInfo.setReportInfoMap((Map)localObject);
        break;
      }
      akxz.a(this.this$0, 0);
      akxz.b(this.this$0, 1);
      akxz.a(this.this$0, true);
      QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer.onCompletion");
    } while ((akxz.a(this.this$0) == null) || (akxz.a(this.this$0) == null));
    akxz.a(this.this$0).a(akxz.b(this.this$0), 1, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper.3
 * JD-Core Version:    0.7.0.1
 */