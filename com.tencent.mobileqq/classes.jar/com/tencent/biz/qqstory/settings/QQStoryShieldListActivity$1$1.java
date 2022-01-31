package com.tencent.biz.qqstory.settings;

import aukp;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import sst;
import ukb;

public class QQStoryShieldListActivity$1$1
  implements Runnable
{
  public QQStoryShieldListActivity$1$1(ukb paramukb, List paramList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Ukb.a.jdField_a_of_type_Sst == null) {}
    for (;;)
    {
      return;
      Object localObject = this.jdField_a_of_type_Ukb.a.jdField_a_of_type_Sst;
      if (this.jdField_a_of_type_Ukb.a.jdField_a_of_type_Int == 2) {}
      QQStoryUserInfo localQQStoryUserInfo;
      for (boolean bool = true;; bool = false)
      {
        localObject = ((sst)localObject).b(bool).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localQQStoryUserInfo = (QQStoryUserInfo)((Iterator)localObject).next();
          if (this.jdField_a_of_type_Ukb.a.jdField_a_of_type_Sst.a != null) {
            this.jdField_a_of_type_Ukb.a.jdField_a_of_type_Sst.a.b(localQQStoryUserInfo);
          }
        }
      }
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localQQStoryUserInfo = (QQStoryUserInfo)((Iterator)localObject).next();
        if (this.jdField_a_of_type_Ukb.a.jdField_a_of_type_Sst.a != null) {
          this.jdField_a_of_type_Ukb.a.jdField_a_of_type_Sst.a.b(localQQStoryUserInfo);
        }
        if (this.jdField_a_of_type_Ukb.a.jdField_a_of_type_Sst.b != null) {
          this.jdField_a_of_type_Ukb.a.jdField_a_of_type_Sst.b.put(localQQStoryUserInfo.uin, localQQStoryUserInfo);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryShieldListActivity.1.1
 * JD-Core Version:    0.7.0.1
 */