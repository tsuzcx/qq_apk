package com.tencent.biz.pubaccount.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountMenuResponse;
import mqq.observer.BusinessObserver;

class PublicAccountManagerImpl$2$1
  implements Runnable
{
  PublicAccountManagerImpl$2$1(PublicAccountManagerImpl.2 param2, mobileqq_mp.GetPublicAccountMenuResponse paramGetPublicAccountMenuResponse, int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    this.e.f.savePublicAccountMenuSetting(this.e.b, this.e.c, this.a);
    if (this.e.e != null) {
      this.e.e.onReceive(this.b, this.c, this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountManagerImpl.2.1
 * JD-Core Version:    0.7.0.1
 */