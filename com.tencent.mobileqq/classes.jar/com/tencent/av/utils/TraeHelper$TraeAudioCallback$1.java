package com.tencent.av.utils;

import android.media.MediaPlayer.OnCompletionListener;

class TraeHelper$TraeAudioCallback$1
  implements Runnable
{
  TraeHelper$TraeAudioCallback$1(TraeHelper.TraeAudioCallback paramTraeAudioCallback, MediaPlayer.OnCompletionListener paramOnCompletionListener) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener != null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener.onCompletion(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.utils.TraeHelper.TraeAudioCallback.1
 * JD-Core Version:    0.7.0.1
 */