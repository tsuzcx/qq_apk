package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.common.app.BaseApplicationImpl;
import rlb;

public class VideoVolumeControl$4
  implements Runnable
{
  public VideoVolumeControl$4(rlb paramrlb) {}
  
  public void run()
  {
    if (rlb.a(this.this$0) != null)
    {
      ((TelephonyManager)BaseApplicationImpl.getApplication().getBaseContext().getSystemService("phone")).listen(rlb.a(this.this$0), 0);
      rlb.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl.4
 * JD-Core Version:    0.7.0.1
 */