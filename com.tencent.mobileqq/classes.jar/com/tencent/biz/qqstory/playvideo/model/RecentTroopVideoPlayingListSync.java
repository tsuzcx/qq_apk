package com.tencent.biz.qqstory.playvideo.model;

import com.tencent.biz.qqstory.model.TroopVidToVideoInfoPuller;

public class RecentTroopVideoPlayingListSync
  extends BaseTroopVidListPlayingListSync
{
  String b;
  
  protected TroopVidToVideoInfoPuller a()
  {
    return new TroopVidToVideoInfoPuller(this.a, this.b, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.model.RecentTroopVideoPlayingListSync
 * JD-Core Version:    0.7.0.1
 */