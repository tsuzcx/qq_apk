package com.tencent.biz.pubaccount.readinjoy.video;

import android.telephony.PhoneStateListener;
import com.tencent.qphone.base.util.QLog;

class VideoVolumeControl$MyPhoneStateListener
  extends PhoneStateListener
{
  VideoVolumeControl$MyPhoneStateListener(VideoVolumeControl paramVideoVolumeControl) {}
  
  public void onCallStateChanged(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "onCallStateChanged:" + paramInt);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.a.c(true);
      return;
    case 2: 
      this.a.c(true);
      return;
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl.MyPhoneStateListener
 * JD-Core Version:    0.7.0.1
 */