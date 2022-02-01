package com.tencent.av.utils;

import android.media.MediaPlayer.OnCompletionListener;
import muz;

public class TraeHelper$TraeAudioCallback$1
  implements Runnable
{
  public TraeHelper$TraeAudioCallback$1(muz parammuz, MediaPlayer.OnCompletionListener paramOnCompletionListener) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener != null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener.onCompletion(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.utils.TraeHelper.TraeAudioCallback.1
 * JD-Core Version:    0.7.0.1
 */