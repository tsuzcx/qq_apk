package com.tencent.biz.pubaccount.readinjoy.magic.utils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import lru;

public class Debouncer
{
  private final int jdField_a_of_type_Int;
  private final DebounceCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyMagicUtilsDebounceCallback;
  private final ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private final ScheduledExecutorService jdField_a_of_type_JavaUtilConcurrentScheduledExecutorService = Executors.newScheduledThreadPool(1);
  
  public Debouncer(DebounceCallback paramDebounceCallback, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMagicUtilsDebounceCallback = paramDebounceCallback;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentScheduledExecutorService.shutdownNow();
  }
  
  public void a(Object paramObject)
  {
    lru locallru1 = new lru(this, paramObject);
    lru locallru2;
    do
    {
      locallru2 = (lru)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(paramObject, locallru1);
      if ((locallru2 == null) && (!this.jdField_a_of_type_JavaUtilConcurrentScheduledExecutorService.isShutdown())) {
        this.jdField_a_of_type_JavaUtilConcurrentScheduledExecutorService.schedule(locallru1, this.jdField_a_of_type_Int, TimeUnit.MILLISECONDS);
      }
    } while ((locallru2 != null) && (!locallru2.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.magic.utils.Debouncer
 * JD-Core Version:    0.7.0.1
 */