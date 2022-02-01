package com.tencent.biz.qqstory.playvideo.model;

import com.tencent.biz.qqstory.model.TroopVidToVideoInfoPuller;

public class RecentTroopVideoPlayingListSync
  extends BaseTroopVidListPlayingListSync
{
  String d;
  
  protected TroopVidToVideoInfoPuller a()
  {
    return new TroopVidToVideoInfoPuller(this.c, this.d, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.model.RecentTroopVideoPlayingListSync
 * JD-Core Version:    0.7.0.1
 */