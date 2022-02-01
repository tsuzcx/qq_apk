package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import java.lang.ref.WeakReference;

class ArkSSODataRequest$1
  implements BusinessObserver
{
  ArkSSODataRequest$1(ArkSSODataRequest paramArkSSODataRequest, WeakReference paramWeakReference, ArkSSODataRequest.Request paramRequest) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      paramInt = 0;
    } else {
      paramInt = -1;
    }
    paramObject = (String)paramObject;
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(this.c.f, new ArkSSODataRequest.1.1(this, paramInt, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkSSODataRequest.1
 * JD-Core Version:    0.7.0.1
 */