package com.tencent.avgame.gameroom.video;

import bjtz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerAudioInfo;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import nej;

public class AVGameMediaPlayerWrapper$4
  implements Runnable
{
  public AVGameMediaPlayerWrapper$4(nej paramnej, long paramLong) {}
  
  public void run()
  {
    nej.a(this.this$0, false);
    if (nej.a(this.this$0) != null)
    {
      nej.a(this.this$0).stop();
      nej.a(this.this$0).reset();
      nej.a(this.this$0);
    }
    if (nej.a(this.this$0) == null) {
      nej.a(this.this$0);
    }
    Object localObject = bjtz.d(nej.a(this.this$0));
    localObject = SuperPlayerFactory.createVideoInfoForUrl(nej.a(this.this$0), 101, (String)localObject);
    SuperPlayerAudioInfo localSuperPlayerAudioInfo = new SuperPlayerAudioInfo();
    localSuperPlayerAudioInfo.setAudioSampleRateHZ(48000);
    localSuperPlayerAudioInfo.setAudioChannelLayout(4L);
    SuperPlayerOption localSuperPlayerOption = SuperPlayerOption.obtain();
    localSuperPlayerOption.enableCodecReuse = false;
    localSuperPlayerOption.isPrePlay = false;
    localSuperPlayerOption.enableAudioFrameOutput = true;
    localSuperPlayerOption.audioFrameOutputOption = localSuperPlayerAudioInfo;
    nej.a(this.this$0).setOutputMute(nej.a(this.this$0));
    nej.a(this.this$0).openMediaPlayer(BaseApplicationImpl.getContext(), (SuperPlayerVideoInfo)localObject, this.a, localSuperPlayerOption);
    nej.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameMediaPlayerWrapper.4
 * JD-Core Version:    0.7.0.1
 */