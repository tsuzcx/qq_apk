package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject == null) {
      return;
    }
    localObject = (QQAppInterface)((WeakReference)localObject).get();
    if (localObject != null)
    {
      localObject = (FriendsManager)((QQAppInterface)localObject).getManager(QQManagerFactory.FRIENDS_MANAGER);
      Entity localEntity = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
      if ((localEntity instanceof ExtensionInfo))
      {
        ((FriendsManager)localObject).a((ExtensionInfo)localEntity);
        return;
      }
      if ((localEntity instanceof NoC2CExtensionInfo)) {
        ((FriendsManager)localObject).a((NoC2CExtensionInfo)localEntity, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.SaveInputTypeTask
 * JD-Core Version:    0.7.0.1
 */