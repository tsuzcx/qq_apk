package com.tencent.biz.qqstory.playvideo.model;

import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.RetryableSynchronizer;
import com.tencent.biz.qqstory.model.TroopVidToVideoInfoPuller;

public abstract class BaseTroopVidListPlayingListSync
  extends DefaultPlayerVideoListSynchronizer
  implements DefaultPlayerVideoListSynchronizer.RetryableSynchronizer
{
  protected TroopVidToVideoInfoPuller b;
  protected String c;
  
  protected abstract TroopVidToVideoInfoPuller a();
  
  protected void a(int paramInt)
  {
    if (this.b == null)
    {
      this.b = a();
      this.b.a(this.a);
    }
    this.b.a();
  }
  
  public boolean isValidate()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.model.BaseTroopVidListPlayingListSync
 * JD-Core Version:    0.7.0.1
 */