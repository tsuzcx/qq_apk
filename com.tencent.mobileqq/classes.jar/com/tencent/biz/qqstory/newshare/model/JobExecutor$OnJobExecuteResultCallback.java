package com.tencent.biz.qqstory.newshare.model;

import com.tencent.biz.qqstory.newshare.mode.base.ShareModeBase;

public class JobExecutor$OnJobExecuteResultCallback
  implements JobExecutor.IOnJobExecuteResultCallback
{
  private ShareModeBase a;
  private ShareData b;
  
  public JobExecutor$OnJobExecuteResultCallback(ShareModeBase paramShareModeBase, ShareData paramShareData)
  {
    this.a = paramShareModeBase;
    this.b = paramShareData;
  }
  
  public void a()
  {
    ShareModeBase localShareModeBase = this.a;
    if (localShareModeBase != null) {
      localShareModeBase.c(this.b);
    }
  }
  
  public void b()
  {
    ShareModeBase localShareModeBase = this.a;
    if (localShareModeBase != null) {
      localShareModeBase.d(this.b);
    }
  }
  
  public void c()
  {
    ShareModeBase localShareModeBase = this.a;
    if (localShareModeBase != null) {
      localShareModeBase.e(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.model.JobExecutor.OnJobExecuteResultCallback
 * JD-Core Version:    0.7.0.1
 */