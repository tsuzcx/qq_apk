package com.tencent.biz.pubaccount.util.monitor;

import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class StackSampler
{
  private StackSampler.SampleRunnable jdField_a_of_type_ComTencentBizPubaccountUtilMonitorStackSampler$SampleRunnable = new StackSampler.SampleRunnable(this, null);
  private Map<Long, String> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  private void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = Looper.getMainLooper().getThread().getStackTrace();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(localObject[i].toString());
      localStringBuilder.append("\n");
      i += 1;
    }
    if (this.jdField_a_of_type_JavaUtilMap.size() == 100)
    {
      localObject = (Long)this.jdField_a_of_type_JavaUtilMap.keySet().iterator().next();
      this.jdField_a_of_type_JavaUtilMap.remove(localObject);
    }
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(System.nanoTime()), localStringBuilder.toString());
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      long l = ((Long)localEntry.getKey()).longValue();
      if ((l > paramLong1) && (l < paramLong2))
      {
        localStringBuilder.append((String)localEntry.getValue());
        localStringBuilder.append("\n");
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("printStackTrace: ");
      ((StringBuilder)localObject).append(localStringBuilder.toString());
      QLog.d("FPSMonitor", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.monitor.StackSampler
 * JD-Core Version:    0.7.0.1
 */