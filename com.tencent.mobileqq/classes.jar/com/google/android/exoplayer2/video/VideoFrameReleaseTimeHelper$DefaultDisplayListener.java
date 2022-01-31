package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.hardware.display.DisplayManager;
import android.hardware.display.DisplayManager.DisplayListener;

@TargetApi(17)
final class VideoFrameReleaseTimeHelper$DefaultDisplayListener
  implements DisplayManager.DisplayListener
{
  private final DisplayManager displayManager;
  
  public VideoFrameReleaseTimeHelper$DefaultDisplayListener(VideoFrameReleaseTimeHelper paramVideoFrameReleaseTimeHelper, DisplayManager paramDisplayManager)
  {
    this.displayManager = paramDisplayManager;
  }
  
  public void onDisplayAdded(int paramInt) {}
  
  public void onDisplayChanged(int paramInt)
  {
    if (paramInt == 0) {
      VideoFrameReleaseTimeHelper.access$000(this.this$0);
    }
  }
  
  public void onDisplayRemoved(int paramInt) {}
  
  public void register()
  {
    this.displayManager.registerDisplayListener(this, null);
  }
  
  public void unregister()
  {
    this.displayManager.unregisterDisplayListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper.DefaultDisplayListener
 * JD-Core Version:    0.7.0.1
 */