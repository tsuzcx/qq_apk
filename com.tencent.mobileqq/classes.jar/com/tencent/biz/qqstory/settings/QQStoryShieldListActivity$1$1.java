package com.tencent.biz.qqstory.settings;

import com.tencent.mobileqq.persistence.EntityManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import wjb;
import yai;

public class QQStoryShieldListActivity$1$1
  implements Runnable
{
  public QQStoryShieldListActivity$1$1(yai paramyai, List paramList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Yai.a.jdField_a_of_type_Wjb == null) {}
    for (;;)
    {
      return;
      Object localObject = this.jdField_a_of_type_Yai.a.jdField_a_of_type_Wjb;
      if (this.jdField_a_of_type_Yai.a.jdField_a_of_type_Int == 2) {}
      QQStoryUserInfo localQQStoryUserInfo;
      for (boolean bool = true;; bool = false)
      {
        localObject = ((wjb)localObject).b(bool).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localQQStoryUserInfo = (QQStoryUserInfo)((Iterator)localObject).next();
          if (this.jdField_a_of_type_Yai.a.jdField_a_of_type_Wjb.a != null) {
            this.jdField_a_of_type_Yai.a.jdField_a_of_type_Wjb.a.remove(localQQStoryUserInfo);
          }
        }
      }
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localQQStoryUserInfo = (QQStoryUserInfo)((Iterator)localObject).next();
        if (this.jdField_a_of_type_Yai.a.jdField_a_of_type_Wjb.a != null) {
          this.jdField_a_of_type_Yai.a.jdField_a_of_type_Wjb.a.persistOrReplace(localQQStoryUserInfo);
        }
        if (this.jdField_a_of_type_Yai.a.jdField_a_of_type_Wjb.b != null) {
          this.jdField_a_of_type_Yai.a.jdField_a_of_type_Wjb.b.put(localQQStoryUserInfo.uin, localQQStoryUserInfo);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryShieldListActivity.1.1
 * JD-Core Version:    0.7.0.1
 */