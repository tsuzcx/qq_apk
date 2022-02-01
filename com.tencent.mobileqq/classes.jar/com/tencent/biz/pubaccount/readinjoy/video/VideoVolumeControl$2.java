package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.common.app.BaseApplicationImpl;
import rxg;
import rxh;

public class VideoVolumeControl$2
  implements Runnable
{
  public VideoVolumeControl$2(rxg paramrxg) {}
  
  public void run()
  {
    rxh localrxh = rxg.a(this.this$0);
    if (localrxh != null) {
      ((TelephonyManager)BaseApplicationImpl.getApplication().getBaseContext().getSystemService("phone")).listen(localrxh, 32);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl.2
 * JD-Core Version:    0.7.0.1
 */