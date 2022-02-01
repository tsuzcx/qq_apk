package com.tencent.mobileqq.activity.aio.item;

import java.lang.ref.WeakReference;

class ArkIPCSSODataRequest$1$1
  implements Runnable
{
  ArkIPCSSODataRequest$1$1(ArkIPCSSODataRequest.1 param1, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    ArkIPCSSODataRequest localArkIPCSSODataRequest = (ArkIPCSSODataRequest)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkIPCSSODataRequest$1.a.get();
    if (localArkIPCSSODataRequest == null) {
      return;
    }
    localArkIPCSSODataRequest.a(this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkIPCSSODataRequest.1.1
 * JD-Core Version:    0.7.0.1
 */