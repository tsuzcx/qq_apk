package com.tencent.mobileqq.activity.aio.item;

import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.open.delegate.IArkDelegateNetCallback;
import com.tencent.mobileqq.ark.ArkAppCenter;
import java.lang.ref.WeakReference;

class ArkIPCSSODataRequest$1
  extends IArkDelegateNetCallback
{
  ArkIPCSSODataRequest$1(ArkIPCSSODataRequest paramArkIPCSSODataRequest, WeakReference paramWeakReference) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = -1)
    {
      paramObject = (String)paramObject;
      ArkAppCenter.a().post(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkIPCSSODataRequest.c, new ArkIPCSSODataRequest.1.1(this, paramInt, i, paramObject));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkIPCSSODataRequest.1
 * JD-Core Version:    0.7.0.1
 */