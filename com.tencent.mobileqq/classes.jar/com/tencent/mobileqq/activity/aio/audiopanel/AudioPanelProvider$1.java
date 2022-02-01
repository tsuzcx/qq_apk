package com.tencent.mobileqq.activity.aio.audiopanel;

import android.os.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.data.NoC2CExtensionInfo;
import mqq.os.MqqHandler;

class AudioPanelProvider$1
  implements Runnable
{
  AudioPanelProvider$1(AudioPanelProvider paramAudioPanelProvider, FriendsManager paramFriendsManager) {}
  
  public void run()
  {
    NoC2CExtensionInfo localNoC2CExtensionInfo = this.a.a(AudioPanelProvider.a(this.this$0).a.jdField_a_of_type_JavaLangString, AudioPanelProvider.a(this.this$0).a.jdField_a_of_type_Int, true);
    if ((localNoC2CExtensionInfo != null) && (localNoC2CExtensionInfo.audioPanelType != -1) && (this.this$0.a != null)) {
      AudioPanelProvider.a(this.this$0).a().obtainMessage(40, localNoC2CExtensionInfo.audioPanelType, AudioPanelProvider.a(this.this$0).a.jdField_a_of_type_Int).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelProvider.1
 * JD-Core Version:    0.7.0.1
 */