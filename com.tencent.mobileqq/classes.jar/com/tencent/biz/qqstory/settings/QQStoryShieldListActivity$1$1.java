package com.tencent.biz.qqstory.settings;

import com.tencent.mobileqq.persistence.EntityManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import vzv;
import xqo;

public class QQStoryShieldListActivity$1$1
  implements Runnable
{
  public QQStoryShieldListActivity$1$1(xqo paramxqo, List paramList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Xqo.a.jdField_a_of_type_Vzv == null) {}
    for (;;)
    {
      return;
      Object localObject = this.jdField_a_of_type_Xqo.a.jdField_a_of_type_Vzv;
      if (this.jdField_a_of_type_Xqo.a.jdField_a_of_type_Int == 2) {}
      QQStoryUserInfo localQQStoryUserInfo;
      for (boolean bool = true;; bool = false)
      {
        localObject = ((vzv)localObject).b(bool).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localQQStoryUserInfo = (QQStoryUserInfo)((Iterator)localObject).next();
          if (this.jdField_a_of_type_Xqo.a.jdField_a_of_type_Vzv.a != null) {
            this.jdField_a_of_type_Xqo.a.jdField_a_of_type_Vzv.a.remove(localQQStoryUserInfo);
          }
        }
      }
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localQQStoryUserInfo = (QQStoryUserInfo)((Iterator)localObject).next();
        if (this.jdField_a_of_type_Xqo.a.jdField_a_of_type_Vzv.a != null) {
          this.jdField_a_of_type_Xqo.a.jdField_a_of_type_Vzv.a.persistOrReplace(localQQStoryUserInfo);
        }
        if (this.jdField_a_of_type_Xqo.a.jdField_a_of_type_Vzv.b != null) {
          this.jdField_a_of_type_Xqo.a.jdField_a_of_type_Vzv.b.put(localQQStoryUserInfo.uin, localQQStoryUserInfo);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryShieldListActivity.1.1
 * JD-Core Version:    0.7.0.1
 */