package com.tencent.avgame.gameroom.video;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.base.MD5Utils;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerAudioInfo;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;

class AVGameMediaPlayerWrapper$4
  implements Runnable
{
  AVGameMediaPlayerWrapper$4(AVGameMediaPlayerWrapper paramAVGameMediaPlayerWrapper, long paramLong) {}
  
  public void run()
  {
    AVGameMediaPlayerWrapper.a(this.this$0, false);
    if (AVGameMediaPlayerWrapper.a(this.this$0) != null)
    {
      AVGameMediaPlayerWrapper.a(this.this$0).stop();
      AVGameMediaPlayerWrapper.a(this.this$0).reset();
      AVGameMediaPlayerWrapper.a(this.this$0);
    }
    if (AVGameMediaPlayerWrapper.a(this.this$0) == null) {
      AVGameMediaPlayerWrapper.a(this.this$0);
    }
    Object localObject = MD5Utils.toMD5(AVGameMediaPlayerWrapper.a(this.this$0));
    localObject = SuperPlayerFactory.createVideoInfoForUrl(AVGameMediaPlayerWrapper.a(this.this$0), 101, (String)localObject);
    SuperPlayerAudioInfo localSuperPlayerAudioInfo = new SuperPlayerAudioInfo();
    localSuperPlayerAudioInfo.setAudioSampleRateHZ(48000);
    localSuperPlayerAudioInfo.setAudioChannelLayout(4L);
    SuperPlayerOption localSuperPlayerOption = SuperPlayerOption.obtain();
    localSuperPlayerOption.enableCodecReuse = false;
    localSuperPlayerOption.isPrePlay = false;
    localSuperPlayerOption.enableAudioFrameOutput = true;
    localSuperPlayerOption.audioFrameOutputOption = localSuperPlayerAudioInfo;
    AVGameMediaPlayerWrapper.a(this.this$0).setOutputMute(AVGameMediaPlayerWrapper.a(this.this$0));
    AVGameMediaPlayerWrapper.a(this.this$0).openMediaPlayer(BaseApplicationImpl.getContext(), (SuperPlayerVideoInfo)localObject, this.a, localSuperPlayerOption);
    AVGameMediaPlayerWrapper.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameMediaPlayerWrapper.4
 * JD-Core Version:    0.7.0.1
 */