package com.tencent.avgame.gameroom.video;

import bita;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import nct;

public class AVGameMediaPlayerWrapper$3
  implements Runnable
{
  public AVGameMediaPlayerWrapper$3(nct paramnct, long paramLong) {}
  
  public void run()
  {
    nct.a(this.this$0, true);
    if (nct.a(this.this$0) != null)
    {
      nct.a(this.this$0).stop();
      nct.a(this.this$0).reset();
      nct.a(this.this$0);
    }
    if (nct.a(this.this$0) == null) {
      nct.a(this.this$0);
    }
    Object localObject = bita.d(nct.a(this.this$0));
    localObject = SuperPlayerFactory.createVideoInfoForUrl(nct.a(this.this$0), 107, (String)localObject);
    SuperPlayerOption localSuperPlayerOption = SuperPlayerOption.obtain();
    localSuperPlayerOption.enableCodecReuse = false;
    localSuperPlayerOption.isPrePlay = false;
    nct.a(this.this$0).setOutputMute(nct.a(this.this$0));
    nct.a(this.this$0).openMediaPlayer(BaseApplicationImpl.getContext(), (SuperPlayerVideoInfo)localObject, this.a, localSuperPlayerOption);
    nct.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameMediaPlayerWrapper.3
 * JD-Core Version:    0.7.0.1
 */