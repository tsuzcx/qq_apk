package com.tencent.biz.subscribe.videoplayer;

import android.content.Context;
import android.support.annotation.NonNull;

public class CleanVideoPlayerView
  extends VideoPlayerView
{
  public CleanVideoPlayerView(@NonNull Context paramContext)
  {
    super(paramContext);
    setOnClickListener(null);
    setCleanMode(true);
  }
  
  public void h()
  {
    super.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.CleanVideoPlayerView
 * JD-Core Version:    0.7.0.1
 */