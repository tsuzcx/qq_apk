package com.tencent.mobileqq.activity.recent.bannerprocessor;

import com.tencent.mobileqq.banner.BannerManager;

class SetPwdBannerProcessor$2$1
  implements Runnable
{
  SetPwdBannerProcessor$2$1(SetPwdBannerProcessor.2 param2, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if (this.a)
    {
      BannerManager.a().a(SetPwdBannerProcessor.a, 2, null);
      return;
    }
    if (this.b) {
      BannerManager.a().a(SetPwdBannerProcessor.a, 0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.SetPwdBannerProcessor.2.1
 * JD-Core Version:    0.7.0.1
 */