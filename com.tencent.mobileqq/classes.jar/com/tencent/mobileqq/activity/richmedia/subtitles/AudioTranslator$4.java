package com.tencent.mobileqq.activity.richmedia.subtitles;

import almq;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import java.lang.ref.WeakReference;

public class AudioTranslator$4
  implements Runnable
{
  public void run()
  {
    synchronized (this.this$0)
    {
      if (almq.a(this.this$0) != null)
      {
        AudioCapture localAudioCapture = (AudioCapture)almq.a(this.this$0).get();
        if (localAudioCapture != null)
        {
          localAudioCapture.b(false);
          localAudioCapture.d();
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.subtitles.AudioTranslator.4
 * JD-Core Version:    0.7.0.1
 */