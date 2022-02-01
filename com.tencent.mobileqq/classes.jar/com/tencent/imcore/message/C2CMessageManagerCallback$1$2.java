package com.tencent.imcore.message;

import com.tencent.mobileqq.msg.api.IMessageFacade;
import java.util.Map;

class C2CMessageManagerCallback$1$2
  implements Runnable
{
  C2CMessageManagerCallback$1$2(C2CMessageManagerCallback.1 param1) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getRefreshActionMap().containsKey(UinTypeUtil.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Int))) {
      this.a.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getRefreshActionMap().remove(UinTypeUtil.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Int));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.C2CMessageManagerCallback.1.2
 * JD-Core Version:    0.7.0.1
 */