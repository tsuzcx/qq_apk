package com.tencent.biz.pubaccount.readinjoy.video;

import android.telephony.PhoneStateListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class VideoFeedsPlayActivity$PhoneCallStateListener
  extends PhoneStateListener
{
  WeakReference a;
  
  public VideoFeedsPlayActivity$PhoneCallStateListener(VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    this.a = new WeakReference(paramVideoFeedsPlayManager);
  }
  
  public void onCallStateChanged(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "onCallStateChanged:" + paramInt);
    }
    switch (paramInt)
    {
    }
    do
    {
      return;
      paramString = (VideoFeedsPlayManager)this.a.get();
    } while (paramString == null);
    paramString.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity.PhoneCallStateListener
 * JD-Core Version:    0.7.0.1
 */