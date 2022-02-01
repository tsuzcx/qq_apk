package com.tencent.mobileqq.activity.pendant;

import akbb;
import bcew;
import bnpt;
import bnpu;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;

public class AvatarPendantActivity$13$2
  implements Runnable
{
  public AvatarPendantActivity$13$2(akbb paramakbb) {}
  
  public void run()
  {
    if (!VideoEnvironment.e(this.a.a.app))
    {
      bnpu.a().a(bnpt.b, null, false);
      bcew.a(this.a.a.app);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.13.2
 * JD-Core Version:    0.7.0.1
 */