package com.tencent.biz.qqstory.playvideo.model;

import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.RetryableSynchronizer;
import com.tencent.biz.qqstory.model.TroopVidToVideoInfoPuller;

public abstract class BaseTroopVidListPlayingListSync
  extends DefaultPlayerVideoListSynchronizer
  implements DefaultPlayerVideoListSynchronizer.RetryableSynchronizer
{
  protected TroopVidToVideoInfoPuller a;
  protected String a;
  
  protected abstract TroopVidToVideoInfoPuller a();
  
  protected void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelTroopVidToVideoInfoPuller == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryModelTroopVidToVideoInfoPuller = a();
      this.jdField_a_of_type_ComTencentBizQqstoryModelTroopVidToVideoInfoPuller.a(this.jdField_a_of_type_Boolean);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryModelTroopVidToVideoInfoPuller.a();
  }
  
  public boolean isValidate()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.model.BaseTroopVidListPlayingListSync
 * JD-Core Version:    0.7.0.1
 */