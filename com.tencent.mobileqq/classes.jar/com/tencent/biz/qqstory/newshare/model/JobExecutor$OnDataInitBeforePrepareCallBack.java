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
    if (this.a != null) {
      this.a.a(true);
    }
  }
  
  public void b()
  {
    if (this.a != null) {
      this.a.a(false);
    }
  }
  
  public void c()
  {
    if (this.a != null) {
      this.a.e(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.model.JobExecutor.OnDataInitBeforePrepareCallBack
 * JD-Core Version:    0.7.0.1
 */