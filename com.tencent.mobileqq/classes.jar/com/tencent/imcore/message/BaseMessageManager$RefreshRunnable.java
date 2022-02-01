package com.tencent.imcore.message;

import android.os.Handler;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import java.lang.ref.WeakReference;

class BaseMessageManager$RefreshRunnable
  implements Runnable
{
  private final int jdField_a_of_type_Int;
  private final RefreshMessageContext jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext;
  private final String jdField_a_of_type_JavaLangString;
  private final WeakReference<BaseMessageManager> jdField_a_of_type_JavaLangRefWeakReference;
  private final int jdField_b_of_type_Int;
  private final String jdField_b_of_type_JavaLangString;
  
  BaseMessageManager$RefreshRunnable(String paramString1, int paramInt1, int paramInt2, RefreshMessageContext paramRefreshMessageContext, String paramString2, BaseMessageManager paramBaseMessageManager)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext = paramRefreshMessageContext;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseMessageManager);
  }
  
  public void run()
  {
    BaseMessageManager localBaseMessageManager = (BaseMessageManager)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localBaseMessageManager == null) {
      return;
    }
    IMessageFacade localIMessageFacade = localBaseMessageManager.a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("refreshMessageListHead uin = ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append(", type = ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append(", count = ");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
    ((StringBuilder)localObject).append(", context = ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(", timestamp = ");
    localStringBuilder.append(System.currentTimeMillis());
    localIMessageFacade.qLogColor((String)localObject, localStringBuilder.toString());
    localBaseMessageManager.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext);
    localBaseMessageManager.a(this.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext);
    localBaseMessageManager.a.getFacadeHandler().post(new BaseMessageManager.RefreshRunnable.RemoveRefreshKeyRunnable(this, localBaseMessageManager));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManager.RefreshRunnable
 * JD-Core Version:    0.7.0.1
 */