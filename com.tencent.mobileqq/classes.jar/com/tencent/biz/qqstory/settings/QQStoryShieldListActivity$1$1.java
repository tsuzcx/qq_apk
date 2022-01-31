package com.tencent.biz.qqstory.settings;

import awbw;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import uhl;
import vyt;

public class QQStoryShieldListActivity$1$1
  implements Runnable
{
  public QQStoryShieldListActivity$1$1(vyt paramvyt, List paramList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Vyt.a.jdField_a_of_type_Uhl == null) {}
    for (;;)
    {
      return;
      Object localObject = this.jdField_a_of_type_Vyt.a.jdField_a_of_type_Uhl;
      if (this.jdField_a_of_type_Vyt.a.jdField_a_of_type_Int == 2) {}
      QQStoryUserInfo localQQStoryUserInfo;
      for (boolean bool = true;; bool = false)
      {
        localObject = ((uhl)localObject).b(bool).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localQQStoryUserInfo = (QQStoryUserInfo)((Iterator)localObject).next();
          if (this.jdField_a_of_type_Vyt.a.jdField_a_of_type_Uhl.a != null) {
            this.jdField_a_of_type_Vyt.a.jdField_a_of_type_Uhl.a.b(localQQStoryUserInfo);
          }
        }
      }
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localQQStoryUserInfo = (QQStoryUserInfo)((Iterator)localObject).next();
        if (this.jdField_a_of_type_Vyt.a.jdField_a_of_type_Uhl.a != null) {
          this.jdField_a_of_type_Vyt.a.jdField_a_of_type_Uhl.a.b(localQQStoryUserInfo);
        }
        if (this.jdField_a_of_type_Vyt.a.jdField_a_of_type_Uhl.b != null) {
          this.jdField_a_of_type_Vyt.a.jdField_a_of_type_Uhl.b.put(localQQStoryUserInfo.uin, localQQStoryUserInfo);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryShieldListActivity.1.1
 * JD-Core Version:    0.7.0.1
 */