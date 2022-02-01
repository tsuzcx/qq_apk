package com.tencent.avgame.gameroom.video;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.base.MD5Utils;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerAudioInfo;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import nmi;

public class AVGameMediaPlayerWrapper$3
  implements Runnable
{
  public AVGameMediaPlayerWrapper$3(nmi paramnmi, long paramLong) {}
  
  public void run()
  {
    nmi.a(this.this$0, true);
    if (nmi.a(this.this$0) != null)
    {
      nmi.a(this.this$0).stop();
      nmi.a(this.this$0).reset();
      nmi.a(this.this$0);
    }
    if (nmi.a(this.this$0) == null) {
      nmi.a(this.this$0);
    }
    SuperPlayerAudioInfo localSuperPlayerAudioInfo = new SuperPlayerAudioInfo();
    localSuperPlayerAudioInfo.setAudioSampleRateHZ(48000);
    localSuperPlayerAudioInfo.setAudioChannelLayout(4L);
    Object localObject = MD5Utils.toMD5(nmi.a(this.this$0));
    localObject = SuperPlayerFactory.createVideoInfoForUrl(nmi.a(this.this$0), 107, (String)localObject);
    SuperPlayerOption localSuperPlayerOption = SuperPlayerOption.obtain();
    localSuperPlayerOption.enableCodecReuse = false;
    localSuperPlayerOption.isPrePlay = false;
    localSuperPlayerOption.enableAudioFrameOutput = true;
    localSuperPlayerOption.audioFrameOutputOption = localSuperPlayerAudioInfo;
    nmi.a(this.this$0).setOutputMute(nmi.a(this.this$0));
    nmi.a(this.this$0).openMediaPlayer(BaseApplicationImpl.getContext(), (SuperPlayerVideoInfo)localObject, this.a, localSuperPlayerOption);
    nmi.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameMediaPlayerWrapper.3
 * JD-Core Version:    0.7.0.1
 */