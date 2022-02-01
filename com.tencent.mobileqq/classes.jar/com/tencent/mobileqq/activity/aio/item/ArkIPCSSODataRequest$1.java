package com.tencent.mobileqq.activity.aio.item;

import com.tencent.ark.open.delegate.IArkDelegateSSOCallback;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import java.lang.ref.WeakReference;

class ArkIPCSSODataRequest$1
  implements IArkDelegateSSOCallback
{
  ArkIPCSSODataRequest$1(ArkIPCSSODataRequest paramArkIPCSSODataRequest, WeakReference paramWeakReference, ArkSSODataRequest.Request paramRequest) {}
  
  public void onComplete(boolean paramBoolean, Object paramObject)
  {
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = -1;
    }
    paramObject = (String)paramObject;
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkIPCSSODataRequest.c, new ArkIPCSSODataRequest.1.1(this, i, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkIPCSSODataRequest.1
 * JD-Core Version:    0.7.0.1
 */