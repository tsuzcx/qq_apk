package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.common.app.BaseApplicationImpl;

class VideoVolumeControl$2
  implements Runnable
{
  VideoVolumeControl$2(VideoVolumeControl paramVideoVolumeControl) {}
  
  public void run()
  {
    VideoVolumeControl.MyPhoneStateListener localMyPhoneStateListener = VideoVolumeControl.a(this.this$0);
    if (localMyPhoneStateListener != null) {
      ((TelephonyManager)BaseApplicationImpl.getApplication().getBaseContext().getSystemService("phone")).listen(localMyPhoneStateListener, 32);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl.2
 * JD-Core Version:    0.7.0.1
 */