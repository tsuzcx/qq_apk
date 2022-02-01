package com.tencent.mobileqq.activity.aio.item;

import java.lang.ref.WeakReference;

class ArkSSODataRequest$1$1
  implements Runnable
{
  ArkSSODataRequest$1$1(ArkSSODataRequest.1 param1, int paramInt, String paramString) {}
  
  public void run()
  {
    ArkSSODataRequest localArkSSODataRequest = (ArkSSODataRequest)this.c.a.get();
    if (localArkSSODataRequest == null) {
      return;
    }
    localArkSSODataRequest.a(this.c.b, this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkSSODataRequest.1.1
 * JD-Core Version:    0.7.0.1
 */