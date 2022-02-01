package com.tencent.mobileqq.activity.aio.item;

import java.lang.ref.WeakReference;

class ArkSSODataRequest$2
  implements Runnable
{
  ArkSSODataRequest$2(ArkSSODataRequest paramArkSSODataRequest, WeakReference paramWeakReference, ArkSSODataRequest.Request paramRequest) {}
  
  public void run()
  {
    ArkSSODataRequest localArkSSODataRequest = (ArkSSODataRequest)this.a.get();
    if (localArkSSODataRequest == null) {
      return;
    }
    localArkSSODataRequest.a(this.b, -1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkSSODataRequest.2
 * JD-Core Version:    0.7.0.1
 */