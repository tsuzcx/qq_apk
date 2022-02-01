package com.tencent.av.redpacket.ui;

import com.tencent.qphone.base.util.QLog;

class RedPacketGameEmojiAnimation$1
  implements RedPacketGameParticleEmoji.OnShowListener
{
  RedPacketGameEmojiAnimation$1(RedPacketGameEmojiAnimation paramRedPacketGameEmojiAnimation) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketGameEmojiAnimation", 2, "onShow called, needDetectFace set true");
    }
    if (this.a.a != null) {
      this.a.a.c = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketGameEmojiAnimation.1
 * JD-Core Version:    0.7.0.1
 */