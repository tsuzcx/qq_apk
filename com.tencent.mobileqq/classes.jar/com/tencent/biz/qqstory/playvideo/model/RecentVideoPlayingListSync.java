package com.tencent.biz.qqstory.playvideo.model;

import com.tencent.biz.qqstory.model.VidToVideoInfoPuller;

public class RecentVideoPlayingListSync
  extends BaseVidListPlayingListSync
{
  protected String d;
  
  protected VidToVideoInfoPuller b()
  {
    return new VidToVideoInfoPuller(this.c, this.d, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.model.RecentVideoPlayingListSync
 * JD-Core Version:    0.7.0.1
 */