package com.tencent.mobileqq.activity.aio.audiopanel;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import mqq.os.MqqHandler;

class AudioPanelProvider$4
  implements Runnable
{
  AudioPanelProvider$4(AudioPanelProvider paramAudioPanelProvider) {}
  
  public void run()
  {
    ((FriendsManager)AudioPanelProvider.a(this.this$0).getManager(QQManagerFactory.FRIENDS_MANAGER)).b();
    AudioPanelProvider.a(this.this$0).a().sendMessage(AudioPanelProvider.a(this.this$0).a().obtainMessage(64));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelProvider.4
 * JD-Core Version:    0.7.0.1
 */