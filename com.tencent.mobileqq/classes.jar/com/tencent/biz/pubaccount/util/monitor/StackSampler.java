package com.tencent.biz.pubaccount.util.monitor;

import android.os.Looper;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class StackSampler
{
  private StackSampler.SampleRunnable jdField_a_of_type_ComTencentBizPubaccountUtilMonitorStackSampler$SampleRunnable;
  private Map<Long, String> jdField_a_of_type_JavaUtilMap;
  private volatile boolean jdField_a_of_type_Boolean;
  
  private void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = Looper.getMainLooper().getThread().getStackTrace();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(localObject[i].toString()).append("\n");
      i += 1;
    }
    if (this.jdField_a_of_type_JavaUtilMap.size() == 100)
    {
      localObject = (Long)this.jdField_a_of_type_JavaUtilMap.keySet().iterator().next();
      this.jdField_a_of_type_JavaUtilMap.remove(localObject);
    }
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(System.nanoTime()), localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.monitor.StackSampler
 * JD-Core Version:    0.7.0.1
 */