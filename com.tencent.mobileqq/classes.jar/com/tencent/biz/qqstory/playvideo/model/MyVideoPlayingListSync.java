package com.tencent.biz.qqstory.playvideo.model;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.VidToVideoInfoPuller;

public class MyVideoPlayingListSync
  extends BaseVidListPlayingListSync
{
  protected VidToVideoInfoPuller b()
  {
    return new VidToVideoInfoPuller(this.c, QQStoryContext.a().i(), 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.model.MyVideoPlayingListSync
 * JD-Core Version:    0.7.0.1
 */