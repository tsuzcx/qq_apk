package com.tencent.mobileqq.activity.aio.audiopanel;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.SimpleUIAIOHelper;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.widget.XPanelContainer;
import mqq.app.QQPermissionCallback;

class AudioPanelProvider$3
  implements QQPermissionCallback
{
  AudioPanelProvider$3(AudioPanelProvider paramAudioPanelProvider, XPanelContainer paramXPanelContainer) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(AudioPanelProvider.a(this.b).aX());
    ((SimpleUIAIOHelper)AudioPanelProvider.a(this.b).q(29)).f(2);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AudioTransitionAnimManager.a().a(AudioPanelProvider.a(this.b).e);
    this.a.a(2);
    AIOPanelUtiles.a(AudioPanelProvider.b(this.b), "0X8005CAC", AudioPanelProvider.a(this.b).ah.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelProvider.3
 * JD-Core Version:    0.7.0.1
 */