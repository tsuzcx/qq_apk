package com.tencent.biz.qqstory.playvideo.model;

import com.tencent.biz.qqstory.model.VidToVideoInfoPuller;

public final class MemoryPlayingListSync
  extends BaseVidListPlayingListSync
{
  protected String d;
  protected String e;
  
  protected VidToVideoInfoPuller b()
  {
    return new VidToVideoInfoPuller(this.c, this.e, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.model.MemoryPlayingListSync
 * JD-Core Version:    0.7.0.1
 */