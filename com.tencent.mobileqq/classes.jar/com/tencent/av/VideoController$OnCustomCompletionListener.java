package com.tencent.av;

import android.media.MediaPlayer.OnCompletionListener;

public abstract class VideoController$OnCustomCompletionListener
  implements MediaPlayer.OnCompletionListener
{
  public long a = 0L;
  
  public VideoController$OnCustomCompletionListener(VideoController paramVideoController) {}
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Custom.");
    localStringBuilder.append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.OnCustomCompletionListener
 * JD-Core Version:    0.7.0.1
 */