package com.tencent.biz.pubaccount.readinjoy.ugc.voice;

import android.media.AudioManager;
import com.tencent.qphone.base.util.QLog;
import sen;

public class ReadInJoyVoicePlayController$3
  implements Runnable
{
  public ReadInJoyVoicePlayController$3(sen paramsen) {}
  
  public void run()
  {
    if (sen.a(this.this$0)) {
      if (sen.a(this.this$0) != null) {
        sen.a(this.this$0).requestAudioFocus(null, 3, 2);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(sen.a, 2, "mRequestOrAbandonAudioFocusCallBack isFocusAudio:" + sen.a(this.this$0));
      }
      return;
      if (sen.a(this.this$0) != null) {
        sen.a(this.this$0).abandonAudioFocus(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.voice.ReadInJoyVoicePlayController.3
 * JD-Core Version:    0.7.0.1
 */