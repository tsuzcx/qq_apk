package com.tencent.biz.qqstory.newshare.model;

import com.tencent.biz.qqstory.newshare.mode.base.ShareModeBase;

public class JobExecutor$OnJobExecuteResultCallback
  implements JobExecutor.IOnJobExecuteResultCallback
{
  private ShareModeBase jdField_a_of_type_ComTencentBizQqstoryNewshareModeBaseShareModeBase;
  private ShareData jdField_a_of_type_ComTencentBizQqstoryNewshareModelShareData;
  
  public JobExecutor$OnJobExecuteResultCallback(ShareModeBase paramShareModeBase, ShareData paramShareData)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareModeBaseShareModeBase = paramShareModeBase;
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelShareData = paramShareData;
  }
  
  public void a()
  {
    ShareModeBase localShareModeBase = this.jdField_a_of_type_ComTencentBizQqstoryNewshareModeBaseShareModeBase;
    if (localShareModeBase != null) {
      localShareModeBase.c(this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelShareData);
    }
  }
  
  public void b()
  {
    ShareModeBase localShareModeBase = this.jdField_a_of_type_ComTencentBizQqstoryNewshareModeBaseShareModeBase;
    if (localShareModeBase != null) {
      localShareModeBase.d(this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelShareData);
    }
  }
  
  public void c()
  {
    ShareModeBase localShareModeBase = this.jdField_a_of_type_ComTencentBizQqstoryNewshareModeBaseShareModeBase;
    if (localShareModeBase != null) {
      localShareModeBase.e(this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelShareData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.model.JobExecutor.OnJobExecuteResultCallback
 * JD-Core Version:    0.7.0.1
 */