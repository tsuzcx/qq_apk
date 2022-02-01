package com.tencent.biz.qcircleshadow.lib;

import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;

final class HostStaticInvokeHelper$3
  implements ThreadPool.Job<Object>
{
  HostStaticInvokeHelper$3(HostStaticInvokeHelper.InvokeNormalCallBack paramInvokeNormalCallBack) {}
  
  public Object run(ThreadPool.JobContext paramJobContext)
  {
    this.val$callBack.onSuccess();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper.3
 * JD-Core Version:    0.7.0.1
 */