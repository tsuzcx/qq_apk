package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.common.app.BaseApplicationImpl;
import rlb;
import rlc;

public class VideoVolumeControl$2
  implements Runnable
{
  public VideoVolumeControl$2(rlb paramrlb) {}
  
  public void run()
  {
    rlc localrlc = rlb.a(this.this$0);
    if (localrlc != null) {
      ((TelephonyManager)BaseApplicationImpl.getApplication().getBaseContext().getSystemService("phone")).listen(localrlc, 32);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl.2
 * JD-Core Version:    0.7.0.1
 */