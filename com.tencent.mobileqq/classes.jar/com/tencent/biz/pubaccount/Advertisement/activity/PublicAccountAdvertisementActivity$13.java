package com.tencent.biz.pubaccount.Advertisement.activity;

import android.media.AudioManager;
import com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment;
import com.tencent.qphone.base.util.QLog;

class PublicAccountAdvertisementActivity$13
  implements Runnable
{
  PublicAccountAdvertisementActivity$13(PublicAccountAdvertisementActivity paramPublicAccountAdvertisementActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(",music system is thread ");
      localStringBuilder.append(PublicAccountAdvertisementActivity.l(this.this$0).e);
      QLog.d("volumeTrace", 2, localStringBuilder.toString());
    }
    PublicAccountAdvertisementActivity.y(this.this$0).setStreamVolume(3, PublicAccountAdvertisementActivity.l(this.this$0).e, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity.13
 * JD-Core Version:    0.7.0.1
 */