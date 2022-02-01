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
    if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareModeBaseShareModeBase != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareModeBaseShareModeBase.c(this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelShareData);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareModeBaseShareModeBase != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareModeBaseShareModeBase.d(this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelShareData);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareModeBaseShareModeBase != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareModeBaseShareModeBase.e(this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelShareData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.model.JobExecutor.OnJobExecuteResultCallback
 * JD-Core Version:    0.7.0.1
 */