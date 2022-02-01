package com.tencent.biz.qqstory.settings;

import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class QQStoryShieldListActivity$1$1
  implements Runnable
{
  QQStoryShieldListActivity$1$1(QQStoryShieldListActivity.1 param1, List paramList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity$1.a.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager == null) {}
    for (;;)
    {
      return;
      Object localObject = this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity$1.a.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager;
      if (this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity$1.a.jdField_a_of_type_Int == 2) {}
      QQStoryUserInfo localQQStoryUserInfo;
      for (boolean bool = true;; bool = false)
      {
        localObject = ((QQStoryManager)localObject).b(bool).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localQQStoryUserInfo = (QQStoryUserInfo)((Iterator)localObject).next();
          if (this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity$1.a.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager.a != null) {
            this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity$1.a.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager.a.remove(localQQStoryUserInfo);
          }
        }
      }
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localQQStoryUserInfo = (QQStoryUserInfo)((Iterator)localObject).next();
        if (this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity$1.a.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager.a != null) {
          this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity$1.a.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager.a.persistOrReplace(localQQStoryUserInfo);
        }
        if (this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity$1.a.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager.b != null) {
          this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity$1.a.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager.b.put(localQQStoryUserInfo.uin, localQQStoryUserInfo);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryShieldListActivity.1.1
 * JD-Core Version:    0.7.0.1
 */