package com.tencent.biz.pubaccount.readinjoy.ugc.voice;

import android.media.AudioManager;
import com.tencent.qphone.base.util.QLog;
import rky;

public class ReadInJoyVoicePlayController$3
  implements Runnable
{
  public ReadInJoyVoicePlayController$3(rky paramrky) {}
  
  public void run()
  {
    if (rky.a(this.this$0)) {
      if (rky.a(this.this$0) != null) {
        rky.a(this.this$0).requestAudioFocus(null, 3, 2);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(rky.a, 2, "mRequestOrAbandonAudioFocusCallBack isFocusAudio:" + rky.a(this.this$0));
      }
      return;
      if (rky.a(this.this$0) != null) {
        rky.a(this.this$0).abandonAudioFocus(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.voice.ReadInJoyVoicePlayController.3
 * JD-Core Version:    0.7.0.1
 */