package com.tencent.mobileqq.activity.pendant;

import akga;
import bcxs;
import bnkt;
import bnku;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;

public class AvatarPendantActivity$14$2
  implements Runnable
{
  public AvatarPendantActivity$14$2(akga paramakga) {}
  
  public void run()
  {
    if (!VideoEnvironment.checkAVCodecLoadIsOK(this.a.a.app))
    {
      bnku.a().a(bnkt.b, null, false);
      bcxs.a(this.a.a.app);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.14.2
 * JD-Core Version:    0.7.0.1
 */