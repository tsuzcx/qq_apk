package com.tencent.mobileqq.apollo.process.video;

import com.tencent.TMG.utils.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import java.util.HashMap;
import java.util.Map;

class CmGameTxVideoPlayer$3
  implements Runnable
{
  CmGameTxVideoPlayer$3(CmGameTxVideoPlayer paramCmGameTxVideoPlayer, String paramString, int paramInt) {}
  
  public void run()
  {
    if ((CmGameTxVideoPlayer.a(this.this$0) == null) || (CmGameTxVideoPlayer.a(this.this$0) == null))
    {
      QLog.w("cmgame_process.CmGameTxVideoPlayer", 1, "player NOT init.");
      return;
    }
    CmGameTxVideoPlayer.a(this.this$0).setVid(this.jdField_a_of_type_JavaLangString);
    CmGameTxVideoPlayer.a(this.this$0).setPlayType(2);
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
    HashMap localHashMap = new HashMap();
    localHashMap.put("shouq_bus_type", "bus_type_apollo");
    localTVK_PlayerVideoInfo.setReportInfoMap(localHashMap);
    CmGameTxVideoPlayer.a(this.this$0).openMediaPlayerByUrl(CmGameTxVideoPlayer.a(this.this$0), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 0L, localTVK_PlayerVideoInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.video.CmGameTxVideoPlayer.3
 * JD-Core Version:    0.7.0.1
 */