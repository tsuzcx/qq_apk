package com.tencent.biz.pubaccount.readinjoy.ugc.voice;

import android.media.AudioManager;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyVoicePlayController$3
  implements Runnable
{
  ReadInJoyVoicePlayController$3(ReadInJoyVoicePlayController paramReadInJoyVoicePlayController) {}
  
  public void run()
  {
    if (ReadInJoyVoicePlayController.a(this.this$0)) {
      if (ReadInJoyVoicePlayController.a(this.this$0) != null) {
        ReadInJoyVoicePlayController.a(this.this$0).requestAudioFocus(null, 3, 2);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(ReadInJoyVoicePlayController.a, 2, "mRequestOrAbandonAudioFocusCallBack isFocusAudio:" + ReadInJoyVoicePlayController.a(this.this$0));
      }
      return;
      if (ReadInJoyVoicePlayController.a(this.this$0) != null) {
        ReadInJoyVoicePlayController.a(this.this$0).abandonAudioFocus(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.voice.ReadInJoyVoicePlayController.3
 * JD-Core Version:    0.7.0.1
 */