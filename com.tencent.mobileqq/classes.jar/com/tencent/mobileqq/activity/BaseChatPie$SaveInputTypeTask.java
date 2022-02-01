package com.tencent.mobileqq.activity;

import anyw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.NoC2CExtensionInfo;
import com.tencent.mobileqq.persistence.Entity;
import java.lang.ref.WeakReference;

public class BaseChatPie$SaveInputTypeTask
  implements Runnable
{
  private Entity jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  
  public BaseChatPie$SaveInputTypeTask(Entity paramEntity, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntity = paramEntity;
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
      localObject = (anyw)((QQAppInterface)localObject).getManager(51);
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof ExtensionInfo))
      {
        ((anyw)localObject).a((ExtensionInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntity);
        return;
      }
    } while (!(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof NoC2CExtensionInfo));
    ((anyw)localObject).a((NoC2CExtensionInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntity, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.SaveInputTypeTask
 * JD-Core Version:    0.7.0.1
 */