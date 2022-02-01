package com.tencent.biz.qqstory.playvideo.model;

import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.RetryableSynchronizer;
import com.tencent.biz.qqstory.model.IVidToVideoInfoPuller;

public abstract class BaseVidListPlayingListSync
  extends DefaultPlayerVideoListSynchronizer
  implements DefaultPlayerVideoListSynchronizer.RetryableSynchronizer
{
  protected IVidToVideoInfoPuller b;
  protected String c;
  
  protected abstract IVidToVideoInfoPuller a();
  
  protected void a(int paramInt)
  {
    if (this.b == null)
    {
      this.b = a();
      localIVidToVideoInfoPuller = this.b;
      if (localIVidToVideoInfoPuller != null) {
        localIVidToVideoInfoPuller.a(this.a);
      }
    }
    IVidToVideoInfoPuller localIVidToVideoInfoPuller = this.b;
    if (localIVidToVideoInfoPuller != null) {
      localIVidToVideoInfoPuller.a();
    }
  }
  
  public boolean isValidate()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.model.BaseVidListPlayingListSync
 * JD-Core Version:    0.7.0.1
 */