package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mzb;

final class TaskOfflineUtils$1
  implements Runnable
{
  TaskOfflineUtils$1(String paramString, int paramInt, TaskOfflineUtils.OfflineCallBack paramOfflineCallBack) {}
  
  public void run()
  {
    try
    {
      mzb.a(this.val$bid, BaseApplicationImpl.getApplication().getRuntime(), new TaskOfflineUtils.TaskAsyncBack(this.val$bid, this.val$supportVersion, this.val$offlineCallBack), true, 5, true);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(TaskOfflineUtils.access$000(), 1, "checkUpByBusinessId ", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskOfflineUtils.1
 * JD-Core Version:    0.7.0.1
 */