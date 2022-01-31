package com.tencent.biz.pubaccount.readinjoy.ugc.voice;

import android.media.AudioManager;
import com.tencent.qphone.base.util.QLog;
import qyd;

public class ReadInJoyVoicePlayController$3
  implements Runnable
{
  public ReadInJoyVoicePlayController$3(qyd paramqyd) {}
  
  public void run()
  {
    if (qyd.a(this.this$0)) {
      if (qyd.a(this.this$0) != null) {
        qyd.a(this.this$0).requestAudioFocus(null, 3, 2);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(qyd.a, 2, "mRequestOrAbandonAudioFocusCallBack isFocusAudio:" + qyd.a(this.this$0));
      }
      return;
      if (qyd.a(this.this$0) != null) {
        qyd.a(this.this$0).abandonAudioFocus(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.voice.ReadInJoyVoicePlayController.3
 * JD-Core Version:    0.7.0.1
 */