package com.tencent.biz.qqstory.settings;

import awgf;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import ulu;
import wdc;

public class QQStoryShieldListActivity$1$1
  implements Runnable
{
  public QQStoryShieldListActivity$1$1(wdc paramwdc, List paramList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Wdc.a.jdField_a_of_type_Ulu == null) {}
    for (;;)
    {
      return;
      Object localObject = this.jdField_a_of_type_Wdc.a.jdField_a_of_type_Ulu;
      if (this.jdField_a_of_type_Wdc.a.jdField_a_of_type_Int == 2) {}
      QQStoryUserInfo localQQStoryUserInfo;
      for (boolean bool = true;; bool = false)
      {
        localObject = ((ulu)localObject).b(bool).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localQQStoryUserInfo = (QQStoryUserInfo)((Iterator)localObject).next();
          if (this.jdField_a_of_type_Wdc.a.jdField_a_of_type_Ulu.a != null) {
            this.jdField_a_of_type_Wdc.a.jdField_a_of_type_Ulu.a.b(localQQStoryUserInfo);
          }
        }
      }
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localQQStoryUserInfo = (QQStoryUserInfo)((Iterator)localObject).next();
        if (this.jdField_a_of_type_Wdc.a.jdField_a_of_type_Ulu.a != null) {
          this.jdField_a_of_type_Wdc.a.jdField_a_of_type_Ulu.a.b(localQQStoryUserInfo);
        }
        if (this.jdField_a_of_type_Wdc.a.jdField_a_of_type_Ulu.b != null) {
          this.jdField_a_of_type_Wdc.a.jdField_a_of_type_Ulu.b.put(localQQStoryUserInfo.uin, localQQStoryUserInfo);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryShieldListActivity.1.1
 * JD-Core Version:    0.7.0.1
 */