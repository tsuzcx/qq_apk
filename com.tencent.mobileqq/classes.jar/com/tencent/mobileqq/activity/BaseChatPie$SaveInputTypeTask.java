package com.tencent.mobileqq.activity;

import aloz;
import awbv;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.NoC2CExtensionInfo;
import java.lang.ref.WeakReference;

public class BaseChatPie$SaveInputTypeTask
  implements Runnable
{
  private awbv jdField_a_of_type_Awbv;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  
  public BaseChatPie$SaveInputTypeTask(awbv paramawbv, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Awbv = paramawbv;
    if (paramQQAppInterface != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    }
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      } while (localObject == null);
      localObject = (aloz)((QQAppInterface)localObject).getManager(51);
      if ((this.jdField_a_of_type_Awbv instanceof ExtensionInfo))
      {
        ((aloz)localObject).a((ExtensionInfo)this.jdField_a_of_type_Awbv);
        return;
      }
    } while (!(this.jdField_a_of_type_Awbv instanceof NoC2CExtensionInfo));
    ((aloz)localObject).a((NoC2CExtensionInfo)this.jdField_a_of_type_Awbv, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.SaveInputTypeTask
 * JD-Core Version:    0.7.0.1
 */