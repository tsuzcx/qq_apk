package com.tencent.mfsdk.reporter;

import abvs;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.collector.ResultObject;

class ReporterMachine$InsertRunnable
  implements Runnable
{
  private ResultObject a;
  
  public ReporterMachine$InsertRunnable(ResultObject paramResultObject)
  {
    this.a = paramResultObject;
  }
  
  public void run()
  {
    if (MagnifierSDK.a != null) {
      MagnifierSDK.a.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mfsdk.reporter.ReporterMachine.InsertRunnable
 * JD-Core Version:    0.7.0.1
 */