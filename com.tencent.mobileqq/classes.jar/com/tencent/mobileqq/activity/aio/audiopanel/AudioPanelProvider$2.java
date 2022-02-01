package com.tencent.mobileqq.activity.aio.audiopanel;

import android.os.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import mqq.os.MqqHandler;

class AudioPanelProvider$2
  implements Runnable
{
  AudioPanelProvider$2(AudioPanelProvider paramAudioPanelProvider, FriendsManager paramFriendsManager) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = this.a.d(AudioPanelProvider.a(this.this$0).ah.b, true);
    if ((localExtensionInfo != null) && (localExtensionInfo.audioPanelType != -1) && (this.this$0.a != null)) {
      AudioPanelProvider.a(this.this$0).j().obtainMessage(40, localExtensionInfo.audioPanelType, AudioPanelProvider.a(this.this$0).ah.a).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelProvider.2
 * JD-Core Version:    0.7.0.1
 */