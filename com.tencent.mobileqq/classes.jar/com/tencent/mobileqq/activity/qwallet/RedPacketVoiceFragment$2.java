package com.tencent.mobileqq.activity.qwallet;

import ajfh;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

class RedPacketVoiceFragment$2
  implements Runnable
{
  RedPacketVoiceFragment$2(RedPacketVoiceFragment paramRedPacketVoiceFragment, WeakReference paramWeakReference) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    if (localQQAppInterface != null) {
      ajfh.a().a(localQQAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketVoiceFragment.2
 * JD-Core Version:    0.7.0.1
 */