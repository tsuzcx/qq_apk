package com.tencent.mobileqq.activity.aio.photo;

import android.view.View;
import com.tencent.mobileqq.activity.photo.VideoPlayControllerForAIO;
import com.tencent.mobileqq.filemanager.util.IFileWifiCheckCallback;

class AIOFileVideoData$2
  implements IFileWifiCheckCallback
{
  AIOFileVideoData$2(AIOFileVideoData paramAIOFileVideoData, VideoPlayControllerForAIO paramVideoPlayControllerForAIO, View paramView) {}
  
  public void a()
  {
    if (AIOFileVideoData.a(this.c))
    {
      AIOFileVideoData.a(this.c, false);
      this.a.a(this.b, this.c.a(false));
    }
    this.a.c();
    this.a.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData.2
 * JD-Core Version:    0.7.0.1
 */