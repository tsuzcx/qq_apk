package com.tencent.biz.pubaccount.Advertisement.fragment;

import android.media.AudioManager;
import android.os.Handler;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.qphone.base.util.QLog;

class VideoCoverFragment$6
  implements Runnable
{
  VideoCoverFragment$6(VideoCoverFragment paramVideoCoverFragment, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (VideoCoverFragment.a(this.this$0) == null) {
      return;
    }
    if (VideoCoverFragment.b(this.this$0))
    {
      VideoCoverFragment.a(this.this$0).setStreamVolume(3, this.a, 0);
      if (QLog.isColorLevel()) {
        QLog.d("VideoCoverFragment", 2, "is broken by user click");
      }
      return;
    }
    if (PublicAccountAdvertisementActivity.a)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCoverFragment", 2, "is broken by user slip");
      }
      return;
    }
    int i = VideoCoverFragment.a(this.this$0).getStreamVolume(3);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("change volume is ");
      localStringBuilder.append(i);
      QLog.d("VideoCoverFragment", 2, localStringBuilder.toString());
    }
    if (i < this.a)
    {
      VideoCoverFragment.a(this.this$0).adjustStreamVolume(3, 1, 0);
      VideoCoverFragment.a(this.this$0).postDelayed(this, this.b);
      return;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("smoothAdjustVolume() mTargetMusicVolume = ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", SET mIsSmoothRaiseFinished = true, FINISHED");
      QLog.d("VideoCoverFragment", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment.6
 * JD-Core Version:    0.7.0.1
 */