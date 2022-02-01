package com.tencent.biz.pubaccount.readinjoy.pts;

import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PTSEventDispatcher
{
  private static PTSEventDispatcher jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsPTSEventDispatcher;
  private final List<PTSEventDispatcher.PTSObserver> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public static PTSEventDispatcher a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsPTSEventDispatcher == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsPTSEventDispatcher == null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsPTSEventDispatcher = new PTSEventDispatcher();
      }
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsPTSEventDispatcher;
    }
    finally {}
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
  }
  
  public void a(int paramInt, List<Long> paramList, long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext()) {
        ((PTSEventDispatcher.PTSObserver)localIterator.next()).a(paramInt, paramList, paramLong);
      }
    }
  }
  
  public void a(int paramInt, List<Long> paramList, boolean paramBoolean1, boolean paramBoolean2, ToServiceMsg paramToServiceMsg)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext()) {
        ((PTSEventDispatcher.PTSObserver)localIterator.next()).a(paramInt, paramList, paramBoolean1, paramBoolean2, paramToServiceMsg);
      }
    }
  }
  
  public void a(PTSEventDispatcher.PTSObserver paramPTSObserver)
  {
    if (paramPTSObserver == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramPTSObserver)) {
        this.jdField_a_of_type_JavaUtilList.add(paramPTSObserver);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.PTSEventDispatcher
 * JD-Core Version:    0.7.0.1
 */