package com.tencent.ilive.audiencepages.room.bizmodule;

import com.tencent.falco.base.libapi.activitylife.AppStatusListener;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.datareport.ReportTask;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.notification.NotificationIdConstant;
import com.tencent.falco.base.libapi.notification.NotificationInterface;
import com.tencent.ilivesdk.avplayerservice_interface.AVPlayerServiceInterface;

class AudioFocusListenerModule$4
  implements AppStatusListener
{
  AudioFocusListenerModule$4(AudioFocusListenerModule paramAudioFocusListenerModule) {}
  
  public void onSwitchBackground()
  {
    if (!AudioFocusListenerModule.access$1300(this.this$0)) {}
    while (!AudioFocusListenerModule.access$800(this.this$0)) {
      return;
    }
    AudioFocusListenerModule.access$302(this.this$0, true);
    if ((AudioFocusListenerModule.access$400(this.this$0)) && (!AudioFocusListenerModule.access$1400(this.this$0).isLiteSdk()))
    {
      AudioFocusListenerModule.access$000(this.this$0).show(NotificationIdConstant.BACKGROUND_AUDIO.getValue(), AudioFocusListenerModule.access$1500(this.this$0));
      AudioFocusListenerModule.access$1102(System.currentTimeMillis());
      AudioFocusListenerModule.access$1200(this.this$0).newTask().setPage("room_page").setPageDesc("直播间").setModule("back_broadcast").setModuleDesc("后台播放").setActType("start").setActTypeDesc("后台开始播放").send();
    }
    this.this$0.getLog().i("AudioFocusListener", "onSwitchBackground: 后台 hashCode = " + this.this$0.hashCode() + "当前时间：" + AudioFocusListenerModule.access$1100(), new Object[0]);
  }
  
  public void onSwitchForeground()
  {
    if (!AudioFocusListenerModule.access$700(this.this$0)) {}
    while (!AudioFocusListenerModule.access$800(this.this$0)) {
      return;
    }
    AudioFocusListenerModule.access$302(this.this$0, false);
    if (!AudioFocusListenerModule.access$400(this.this$0))
    {
      AudioFocusListenerModule.access$900(this.this$0).pausePlay();
      return;
    }
    AudioFocusListenerModule.access$000(this.this$0).cancel(NotificationIdConstant.BACKGROUND_AUDIO.getValue());
    AudioFocusListenerModule.access$900(this.this$0).resumePlay();
    AudioFocusListenerModule.access$1002(System.currentTimeMillis());
    AudioFocusListenerModule.access$1200(this.this$0).newTask().setPage("room_page").setPageDesc("直播间").setModule("back_broadcast").setModuleDesc("后台播放").setActType("close").setActTypeDesc("后台播放结束时上报").addKeyValue("timelong", AudioFocusListenerModule.access$1000() - AudioFocusListenerModule.access$1100()).send();
    this.this$0.getLog().i("AudioFocusListener", "onSwitchForeground: 前台 hashCode = " + this.this$0.hashCode() + "当前时间：" + AudioFocusListenerModule.access$1000(), new Object[0]);
    this.this$0.getLog().i("AudioFocusListener", "onSwitchForeground: 共计用时: " + (AudioFocusListenerModule.access$1000() - AudioFocusListenerModule.access$1100()), new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.AudioFocusListenerModule.4
 * JD-Core Version:    0.7.0.1
 */