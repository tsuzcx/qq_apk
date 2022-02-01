package com.tencent.ilive.audiencepages.room.bizmodule;

import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.datareport.ReportTask;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.notification.NotificationIdConstant;
import com.tencent.falco.base.libapi.notification.NotificationInterface;
import com.tencent.ilive.audiencepages.room.pagelogic.AudienceMultiRoomActivityLogic;
import com.tencent.ilivesdk.avplayerservice_interface.AVPlayerServiceInterface;

class AudioFocusListenerModule$5
  implements AudioManager.OnAudioFocusChangeListener
{
  AudioFocusListenerModule$5(AudioFocusListenerModule paramAudioFocusListenerModule) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if ((paramInt != -3) && (paramInt != -2) && (paramInt != -1))
    {
      if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3) && (paramInt != 4)) {
        return;
      }
      this.this$0.getLog().i("AudioFocusListener", "onAudioFocusChange: 成功获得音频焦点", new Object[0]);
      if ((AudioFocusListenerModule.access$900(this.this$0) != null) && ((!AudioFocusListenerModule.access$300(this.this$0)) || (AudioFocusListenerModule.access$200(this.this$0)) || (AudioFocusListenerModule.access$1400(this.this$0).isLiteSdk())) && (!AudienceMultiRoomActivityLogic.a().f()))
      {
        AudioFocusListenerModule.access$900(this.this$0).resumePlay();
        AudioFocusListenerModule.access$900(this.this$0).mutePlay(false);
        AudioFocusListenerModule.access$402(this.this$0, true);
        this.this$0.audioFocusGain();
        if (AudioFocusListenerModule.access$800(this.this$0)) {
          AudioFocusListenerModule.access$1200(this.this$0).newTask().setPage("room_page").setPageDesc("直播间").setModule("back_broadcast_voice").setModuleDesc("后台播放音频").setActType("start").setActTypeDesc("后台播放音频继续").send();
        }
      }
    }
    else
    {
      this.this$0.getLog().i("AudioFocusListener", "onAudioFocusChange: 丢失音频焦点", new Object[0]);
      if ((AudioFocusListenerModule.access$900(this.this$0) != null) && (AudioFocusListenerModule.access$900(this.this$0).isPlaying()))
      {
        AudioFocusListenerModule.access$900(this.this$0).pausePlay();
        if (AudioFocusListenerModule.access$800(this.this$0)) {
          AudioFocusListenerModule.access$1200(this.this$0).newTask().setPage("room_page").setPageDesc("直播间").setModule("back_broadcast_vv").setModuleDesc("后台播放音视频").setActType("close").setActTypeDesc("后台音视频播放中断").send();
        }
        AudioFocusListenerModule.access$000(this.this$0).cancel(NotificationIdConstant.BACKGROUND_AUDIO.getValue());
        AudioFocusListenerModule.access$402(this.this$0, false);
        this.this$0.audioFocusLoss();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.AudioFocusListenerModule.5
 * JD-Core Version:    0.7.0.1
 */