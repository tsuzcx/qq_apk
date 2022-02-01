package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.common.app.BaseApplicationImpl;

class VideoVolumeControl$4
  implements Runnable
{
  VideoVolumeControl$4(VideoVolumeControl paramVideoVolumeControl) {}
  
  public void run()
  {
    if (VideoVolumeControl.a(this.this$0) != null)
    {
      ((TelephonyManager)BaseApplicationImpl.getApplication().getBaseContext().getSystemService("phone")).listen(VideoVolumeControl.a(this.this$0), 0);
      VideoVolumeControl.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl.4
 * JD-Core Version:    0.7.0.1
 */