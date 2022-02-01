package com.tencent.biz.qcircleshadow.lib;

import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;

final class HostStaticInvokeHelper$1
  implements ThreadPool.Job<Object>
{
  HostStaticInvokeHelper$1(HostStaticInvokeHelper.InvokeNormalCallBack paramInvokeNormalCallBack) {}
  
  public Object run(ThreadPool.JobContext paramJobContext)
  {
    this.val$callBack.onSuccess();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper.1
 * JD-Core Version:    0.7.0.1
 */