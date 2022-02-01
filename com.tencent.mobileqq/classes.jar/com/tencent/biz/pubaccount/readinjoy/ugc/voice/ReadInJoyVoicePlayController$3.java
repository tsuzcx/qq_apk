package com.tencent.biz.pubaccount.readinjoy.ugc.voice;

import android.media.AudioManager;
import com.tencent.qphone.base.util.QLog;
import ruc;

public class ReadInJoyVoicePlayController$3
  implements Runnable
{
  public ReadInJoyVoicePlayController$3(ruc paramruc) {}
  
  public void run()
  {
    if (ruc.a(this.this$0)) {
      if (ruc.a(this.this$0) != null) {
        ruc.a(this.this$0).requestAudioFocus(null, 3, 2);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(ruc.a, 2, "mRequestOrAbandonAudioFocusCallBack isFocusAudio:" + ruc.a(this.this$0));
      }
      return;
      if (ruc.a(this.this$0) != null) {
        ruc.a(this.this$0).abandonAudioFocus(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.voice.ReadInJoyVoicePlayController.3
 * JD-Core Version:    0.7.0.1
 */