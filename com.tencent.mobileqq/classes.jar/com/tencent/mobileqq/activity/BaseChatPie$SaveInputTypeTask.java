package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.NoC2CExtensionInfo;
import com.tencent.mobileqq.persistence.Entity;
import java.lang.ref.WeakReference;

public class BaseChatPie$SaveInputTypeTask
  implements Runnable
{
  private Entity jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
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
      localObject = (FriendsManager)((QQAppInterface)localObject).getManager(50);
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof ExtensionInfo))
      {
        ((FriendsManager)localObject).a((ExtensionInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntity);
        return;
      }
    } while (!(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof NoC2CExtensionInfo));
    ((FriendsManager)localObject).a((NoC2CExtensionInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntity, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.SaveInputTypeTask
 * JD-Core Version:    0.7.0.1
 */