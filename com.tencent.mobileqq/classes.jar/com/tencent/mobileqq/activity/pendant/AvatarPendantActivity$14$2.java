package com.tencent.mobileqq.activity.pendant;

import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResDownload;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoResDownload;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;

class AvatarPendantActivity$14$2
  implements Runnable
{
  AvatarPendantActivity$14$2(AvatarPendantActivity.14 param14) {}
  
  public void run()
  {
    if (!VideoEnvironment.checkAndLoadAVCodec())
    {
      ((IAEResDownload)QRoute.api(IAEResDownload.class)).requestDownload(AEResInfo.AE_RES_BASE_PACKAGE, null, false);
      ShortVideoResDownload.a(this.a.a.app);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.14.2
 * JD-Core Version:    0.7.0.1
 */