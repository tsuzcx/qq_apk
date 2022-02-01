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
    if (VideoCoverFragment.a(this.this$0) == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!VideoCoverFragment.b(this.this$0)) {
            break;
          }
          VideoCoverFragment.a(this.this$0).setStreamVolume(3, this.a, 0);
        } while (!QLog.isColorLevel());
        QLog.d("VideoCoverFragment", 2, "is broken by user click");
        return;
        if (!PublicAccountAdvertisementActivity.a) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("VideoCoverFragment", 2, "is broken by user slip");
      return;
      int i = VideoCoverFragment.a(this.this$0).getStreamVolume(3);
      if (QLog.isColorLevel()) {
        QLog.d("VideoCoverFragment", 2, "change volume is " + i);
      }
      if (i < this.a)
      {
        VideoCoverFragment.a(this.this$0).adjustStreamVolume(3, 1, 0);
        VideoCoverFragment.a(this.this$0).postDelayed(this, this.b);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VideoCoverFragment", 2, "smoothAdjustVolume() mTargetMusicVolume = " + this.a + ", SET mIsSmoothRaiseFinished = true, FINISHED");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment.6
 * JD-Core Version:    0.7.0.1
 */