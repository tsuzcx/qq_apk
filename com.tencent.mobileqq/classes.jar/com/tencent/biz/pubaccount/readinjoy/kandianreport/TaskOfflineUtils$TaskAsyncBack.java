package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import mzb;

class TaskOfflineUtils$TaskAsyncBack
  implements mzb
{
  private final String bid;
  private final TaskOfflineUtils.OfflineCallBack callBack;
  private final int supportVersion;
  
  public TaskOfflineUtils$TaskAsyncBack(String paramString, int paramInt, TaskOfflineUtils.OfflineCallBack paramOfflineCallBack)
  {
    this.bid = paramString;
    this.callBack = paramOfflineCallBack;
    this.supportVersion = paramInt;
  }
  
  public void loaded(String paramString, int paramInt)
  {
    ThreadManager.getFileThreadHandler().post(new TaskOfflineUtils.TaskAsyncBack.1(this, paramString, paramInt));
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskOfflineUtils.TaskAsyncBack
 * JD-Core Version:    0.7.0.1
 */