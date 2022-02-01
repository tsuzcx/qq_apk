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
  
  protected void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller = a();
      localIVidToVideoInfoPuller = this.jdField_a_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller;
      if (localIVidToVideoInfoPuller != null) {
        localIVidToVideoInfoPuller.a(this.jdField_a_of_type_Boolean);
      }
    }
    IVidToVideoInfoPuller localIVidToVideoInfoPuller = this.jdField_a_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller;
    if (localIVidToVideoInfoPuller != null) {
      localIVidToVideoInfoPuller.a();
    }
  }
  
  public boolean isValidate()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.model.BaseVidListPlayingListSync
 * JD-Core Version:    0.7.0.1
 */