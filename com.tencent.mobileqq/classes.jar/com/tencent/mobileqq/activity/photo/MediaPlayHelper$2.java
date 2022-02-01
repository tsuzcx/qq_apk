package com.tencent.mobileqq.activity.photo;

import android.content.Context;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;

class MediaPlayHelper$2
  implements Runnable
{
  MediaPlayHelper$2(MediaPlayHelper paramMediaPlayHelper, Context paramContext) {}
  
  public void run()
  {
    TVK_SDKMgr.installPlugin(this.a, new MediaPlayHelper.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.MediaPlayHelper.2
 * JD-Core Version:    0.7.0.1
 */