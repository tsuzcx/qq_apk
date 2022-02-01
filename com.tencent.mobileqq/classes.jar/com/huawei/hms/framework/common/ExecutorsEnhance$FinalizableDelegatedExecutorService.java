package com.huawei.hms.framework.common;

import java.util.concurrent.ExecutorService;

class ExecutorsEnhance$FinalizableDelegatedExecutorService
  extends ExecutorsEnhance.DelegatedExecutorService
{
  ExecutorsEnhance$FinalizableDelegatedExecutorService(ExecutorService paramExecutorService)
  {
    super(paramExecutorService);
  }
  
  protected void finalize()
  {
    super.shutdown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.common.ExecutorsEnhance.FinalizableDelegatedExecutorService
 * JD-Core Version:    0.7.0.1
 */