package com.tencent.mobileqq.apollo.process.video;

import anfg;
import com.tencent.TMG.utils.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import java.util.HashMap;
import java.util.Map;

public class CmGameTxVideoPlayer$3
  implements Runnable
{
  public CmGameTxVideoPlayer$3(anfg paramanfg, String paramString, int paramInt) {}
  
  public void run()
  {
    if ((anfg.a(this.this$0) == null) || (anfg.a(this.this$0) == null))
    {
      QLog.w("cmgame_process.CmGameTxVideoPlayer", 1, "player NOT init.");
      return;
    }
    anfg.a(this.this$0).setVid(this.jdField_a_of_type_JavaLangString);
    anfg.a(this.this$0).setPlayType(2);
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
    HashMap localHashMap = new HashMap();
    localHashMap.put("shouq_bus_type", "bus_type_apollo");
    localTVK_PlayerVideoInfo.setReportInfoMap(localHashMap);
    anfg.a(this.this$0).openMediaPlayerByUrl(anfg.a(this.this$0), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 0L, localTVK_PlayerVideoInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.video.CmGameTxVideoPlayer.3
 * JD-Core Version:    0.7.0.1
 */