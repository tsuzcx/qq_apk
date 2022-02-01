package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.HotChatItemData;
import com.tencent.mobileqq.persistence.EntityManager;

class HotChatCenterManager$2
  implements Runnable
{
  HotChatCenterManager$2(HotChatCenterManager paramHotChatCenterManager, EntityManager paramEntityManager, HotChatItemData paramHotChatItemData) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(this.jdField_a_of_type_ComTencentMobileqqDataHotChatItemData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatCenterManager.2
 * JD-Core Version:    0.7.0.1
 */