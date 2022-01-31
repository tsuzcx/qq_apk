package com.tencent.biz.qqstory.settings;

import aukn;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import ssw;
import uke;

public class QQStoryShieldListActivity$1$1
  implements Runnable
{
  public QQStoryShieldListActivity$1$1(uke paramuke, List paramList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Uke.a.jdField_a_of_type_Ssw == null) {}
    for (;;)
    {
      return;
      Object localObject = this.jdField_a_of_type_Uke.a.jdField_a_of_type_Ssw;
      if (this.jdField_a_of_type_Uke.a.jdField_a_of_type_Int == 2) {}
      QQStoryUserInfo localQQStoryUserInfo;
      for (boolean bool = true;; bool = false)
      {
        localObject = ((ssw)localObject).b(bool).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localQQStoryUserInfo = (QQStoryUserInfo)((Iterator)localObject).next();
          if (this.jdField_a_of_type_Uke.a.jdField_a_of_type_Ssw.a != null) {
            this.jdField_a_of_type_Uke.a.jdField_a_of_type_Ssw.a.b(localQQStoryUserInfo);
          }
        }
      }
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localQQStoryUserInfo = (QQStoryUserInfo)((Iterator)localObject).next();
        if (this.jdField_a_of_type_Uke.a.jdField_a_of_type_Ssw.a != null) {
          this.jdField_a_of_type_Uke.a.jdField_a_of_type_Ssw.a.b(localQQStoryUserInfo);
        }
        if (this.jdField_a_of_type_Uke.a.jdField_a_of_type_Ssw.b != null) {
          this.jdField_a_of_type_Uke.a.jdField_a_of_type_Ssw.b.put(localQQStoryUserInfo.uin, localQQStoryUserInfo);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryShieldListActivity.1.1
 * JD-Core Version:    0.7.0.1
 */