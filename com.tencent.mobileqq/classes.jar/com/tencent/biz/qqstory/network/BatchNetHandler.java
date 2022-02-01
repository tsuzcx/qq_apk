package com.tencent.biz.qqstory.network;

import com.tencent.biz.qqstory.support.logging.SLog;

public abstract class BatchNetHandler
{
  protected int a;
  protected BatchHandlerListPuller a;
  
  public BatchNetHandler()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public abstract void a();
  
  public void a(BatchHandlerListPuller paramBatchHandlerListPuller)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller = paramBatchHandlerListPuller;
  }
  
  public boolean a()
  {
    int i = this.jdField_a_of_type_Int;
    if (i < 1)
    {
      this.jdField_a_of_type_Int = (i + 1);
      SLog.d("Q.qqstory.net:BatchNetHandler", String.format("retry request , retry count = %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
      a();
      return true;
    }
    return false;
  }
  
  public void b()
  {
    BatchHandlerListPuller localBatchHandlerListPuller = this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller;
    if (localBatchHandlerListPuller != null) {
      localBatchHandlerListPuller.a(this);
    }
  }
  
  public void c()
  {
    BatchHandlerListPuller localBatchHandlerListPuller = this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller;
    if (localBatchHandlerListPuller != null) {
      localBatchHandlerListPuller.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.BatchNetHandler
 * JD-Core Version:    0.7.0.1
 */