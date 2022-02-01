package com.tencent.imcore.message;

import android.os.Handler;
import java.lang.ref.WeakReference;

class BaseMessageManager$RefreshRunnable
  implements Runnable
{
  private final int jdField_a_of_type_Int;
  private final QQMessageFacade.RefreshMessageContext jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext;
  private final String jdField_a_of_type_JavaLangString;
  private final WeakReference<BaseMessageManager> jdField_a_of_type_JavaLangRefWeakReference;
  private final int jdField_b_of_type_Int;
  private final String jdField_b_of_type_JavaLangString;
  
  BaseMessageManager$RefreshRunnable(String paramString1, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, String paramString2, BaseMessageManager paramBaseMessageManager)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext = paramRefreshMessageContext;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseMessageManager);
  }
  
  public void run()
  {
    BaseMessageManager localBaseMessageManager = (BaseMessageManager)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localBaseMessageManager == null) {
      return;
    }
    localBaseMessageManager.a.a("refreshMessageListHead uin = " + this.jdField_a_of_type_JavaLangString + ", type = " + this.jdField_a_of_type_Int + ", count = " + this.jdField_b_of_type_Int + ", context = " + this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext, ", timestamp = " + System.currentTimeMillis());
    localBaseMessageManager.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext);
    localBaseMessageManager.a(this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext);
    localBaseMessageManager.a.a.post(new BaseMessageManager.RefreshRunnable.RemoveRefreshKeyRunnable(this, localBaseMessageManager));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManager.RefreshRunnable
 * JD-Core Version:    0.7.0.1
 */