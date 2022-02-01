package com.tencent.mobileqq.activity.photo;

import akqg;
import akqh;
import android.content.Context;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;

public class MediaPlayHelper$2
  implements Runnable
{
  public MediaPlayHelper$2(akqg paramakqg, Context paramContext) {}
  
  public void run()
  {
    TVK_SDKMgr.installPlugin(this.a, new akqh(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.MediaPlayHelper.2
 * JD-Core Version:    0.7.0.1
 */