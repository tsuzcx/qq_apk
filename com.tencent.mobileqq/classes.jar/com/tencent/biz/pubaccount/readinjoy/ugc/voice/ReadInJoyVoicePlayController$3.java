package com.tencent.biz.pubaccount.readinjoy.ugc.voice;

import android.media.AudioManager;
import com.tencent.qphone.base.util.QLog;
import qiz;

public class ReadInJoyVoicePlayController$3
  implements Runnable
{
  public ReadInJoyVoicePlayController$3(qiz paramqiz) {}
  
  public void run()
  {
    if (qiz.a(this.this$0)) {
      if (qiz.a(this.this$0) != null) {
        qiz.a(this.this$0).requestAudioFocus(null, 3, 2);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(qiz.a, 2, "mRequestOrAbandonAudioFocusCallBack isFocusAudio:" + qiz.a(this.this$0));
      }
      return;
      if (qiz.a(this.this$0) != null) {
        qiz.a(this.this$0).abandonAudioFocus(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.voice.ReadInJoyVoicePlayController.3
 * JD-Core Version:    0.7.0.1
 */