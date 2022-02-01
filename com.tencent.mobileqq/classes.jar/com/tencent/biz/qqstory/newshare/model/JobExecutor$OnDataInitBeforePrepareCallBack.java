package com.tencent.biz.qqstory.newshare.model;

import com.tencent.biz.qqstory.newshare.mode.base.ShareModeBase;

public class JobExecutor$OnDataInitBeforePrepareCallBack
  implements JobExecutor.IOnJobExecuteResultCallback
{
  private ShareModeBase a;
  
  public JobExecutor$OnDataInitBeforePrepareCallBack(ShareModeBase paramShareModeBase)
  {
    this.a = paramShareModeBase;
  }
  
  public void a()
  {
    ShareModeBase localShareModeBase = this.a;
    if (localShareModeBase != null) {
      localShareModeBase.a(true);
    }
  }
  
  public void b()
  {
    ShareModeBase localShareModeBase = this.a;
    if (localShareModeBase != null) {
      localShareModeBase.a(false);
    }
  }
  
  public void c()
  {
    ShareModeBase localShareModeBase = this.a;
    if (localShareModeBase != null) {
      localShareModeBase.e(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.model.JobExecutor.OnDataInitBeforePrepareCallBack
 * JD-Core Version:    0.7.0.1
 */