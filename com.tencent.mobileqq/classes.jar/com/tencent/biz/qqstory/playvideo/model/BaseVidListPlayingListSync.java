package com.tencent.biz.qqstory.playvideo.model;

import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.RetryableSynchronizer;
import com.tencent.biz.qqstory.model.IVidToVideoInfoPuller;

public abstract class BaseVidListPlayingListSync
  extends DefaultPlayerVideoListSynchronizer
  implements DefaultPlayerVideoListSynchronizer.RetryableSynchronizer
{
  protected IVidToVideoInfoPuller a;
  protected String a;
  
  protected abstract IVidToVideoInfoPuller a();
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller = a();
      if (this.jdField_a_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller.a(this.jdField_a_of_type_Boolean);
      }
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller.a();
    }
  }
  
  public boolean isValidate()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.model.BaseVidListPlayingListSync
 * JD-Core Version:    0.7.0.1
 */