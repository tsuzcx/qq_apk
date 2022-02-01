package com.tencent.biz.qqstory.settings;

import com.tencent.mobileqq.persistence.EntityManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import vla;
import xbt;

public class QQStoryShieldListActivity$1$1
  implements Runnable
{
  public QQStoryShieldListActivity$1$1(xbt paramxbt, List paramList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Xbt.a.jdField_a_of_type_Vla == null) {}
    for (;;)
    {
      return;
      Object localObject = this.jdField_a_of_type_Xbt.a.jdField_a_of_type_Vla;
      if (this.jdField_a_of_type_Xbt.a.jdField_a_of_type_Int == 2) {}
      QQStoryUserInfo localQQStoryUserInfo;
      for (boolean bool = true;; bool = false)
      {
        localObject = ((vla)localObject).b(bool).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localQQStoryUserInfo = (QQStoryUserInfo)((Iterator)localObject).next();
          if (this.jdField_a_of_type_Xbt.a.jdField_a_of_type_Vla.a != null) {
            this.jdField_a_of_type_Xbt.a.jdField_a_of_type_Vla.a.remove(localQQStoryUserInfo);
          }
        }
      }
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localQQStoryUserInfo = (QQStoryUserInfo)((Iterator)localObject).next();
        if (this.jdField_a_of_type_Xbt.a.jdField_a_of_type_Vla.a != null) {
          this.jdField_a_of_type_Xbt.a.jdField_a_of_type_Vla.a.persistOrReplace(localQQStoryUserInfo);
        }
        if (this.jdField_a_of_type_Xbt.a.jdField_a_of_type_Vla.b != null) {
          this.jdField_a_of_type_Xbt.a.jdField_a_of_type_Vla.b.put(localQQStoryUserInfo.uin, localQQStoryUserInfo);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryShieldListActivity.1.1
 * JD-Core Version:    0.7.0.1
 */