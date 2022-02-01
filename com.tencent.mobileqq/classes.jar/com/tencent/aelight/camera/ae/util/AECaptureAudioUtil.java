package com.tencent.aelight.camera.ae.util;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.common.app.BaseApplicationImpl;

public class AECaptureAudioUtil
{
  private AudioManager a;
  
  public void a()
  {
    this.a = ((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio"));
    this.a.requestAudioFocus(null, 3, 2);
  }
  
  public void b()
  {
    AudioManager localAudioManager = this.a;
    if (localAudioManager != null) {
      localAudioManager.abandonAudioFocus(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.util.AECaptureAudioUtil
 * JD-Core Version:    0.7.0.1
 */