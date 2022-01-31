package com.tencent.mobileqq.app;

import akft;
import aukp;
import bbjl;
import com.tencent.commonsdk.cache.QQHashMap;
import com.tencent.mobileqq.data.RoamSetting;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;

public class RoamSettingManager$1
  implements Runnable
{
  public RoamSettingManager$1(akft paramakft) {}
  
  public void run()
  {
    int i = 0;
    ArrayList localArrayList = (ArrayList)this.this$0.jdField_a_of_type_Aukp.a(RoamSetting.class, false, null, null, null, null, null, null);
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      this.this$0.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    }
    for (;;)
    {
      try
      {
        if (i < localArrayList.size())
        {
          RoamSetting localRoamSetting = (RoamSetting)localArrayList.get(i);
          if (bbjl.a(localRoamSetting.path) == 1) {
            this.this$0.b.put(localRoamSetting.path, localRoamSetting);
          } else {
            this.this$0.jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap.put(localRoamSetting.path, localRoamSetting);
          }
        }
      }
      finally
      {
        this.this$0.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      this.this$0.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      this.this$0.jdField_a_of_type_Boolean = true;
      return;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.RoamSettingManager.1
 * JD-Core Version:    0.7.0.1
 */