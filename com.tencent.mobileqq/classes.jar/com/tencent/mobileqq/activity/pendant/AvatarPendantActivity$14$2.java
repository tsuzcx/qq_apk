package com.tencent.mobileqq.activity.pendant;

import ajkm;
import bbqy;
import blvn;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import dov.com.qq.im.ae.download.AEResInfo;

public class AvatarPendantActivity$14$2
  implements Runnable
{
  public AvatarPendantActivity$14$2(ajkm paramajkm) {}
  
  public void run()
  {
    if (!VideoEnvironment.checkAVCodecLoadIsOK(this.a.a.app))
    {
      blvn.a().a(AEResInfo.AE_RES_BASE_PACKAGE, null, false);
      bbqy.a(this.a.a.app);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.14.2
 * JD-Core Version:    0.7.0.1
 */