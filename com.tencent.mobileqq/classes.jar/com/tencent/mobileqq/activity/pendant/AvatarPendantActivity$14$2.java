package com.tencent.mobileqq.activity.pendant;

import com.tencent.mobileqq.shortvideo.ShortVideoResDownload;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.download.AEResManager;

class AvatarPendantActivity$14$2
  implements Runnable
{
  AvatarPendantActivity$14$2(AvatarPendantActivity.14 param14) {}
  
  public void run()
  {
    if (!VideoEnvironment.checkAndLoadAVCodec())
    {
      AEResManager.a().a(AEResInfo.b, null, false);
      ShortVideoResDownload.a(this.a.a.app);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.14.2
 * JD-Core Version:    0.7.0.1
 */