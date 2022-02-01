package com.tencent.av.utils;

import android.media.MediaPlayer.OnCompletionListener;

class TraeHelper$TraeAudioCallback$1
  implements Runnable
{
  TraeHelper$TraeAudioCallback$1(TraeHelper.TraeAudioCallback paramTraeAudioCallback, MediaPlayer.OnCompletionListener paramOnCompletionListener) {}
  
  public void run()
  {
    MediaPlayer.OnCompletionListener localOnCompletionListener = this.a;
    if (localOnCompletionListener != null) {
      localOnCompletionListener.onCompletion(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.TraeHelper.TraeAudioCallback.1
 * JD-Core Version:    0.7.0.1
 */