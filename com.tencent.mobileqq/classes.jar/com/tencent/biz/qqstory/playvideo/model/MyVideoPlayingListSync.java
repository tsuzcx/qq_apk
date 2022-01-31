package com.tencent.biz.qqstory.playvideo.model;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.VidToVideoInfoPuller;

public class MyVideoPlayingListSync
  extends BaseVidListPlayingListSync
{
  protected int a()
  {
    return 21;
  }
  
  protected VidToVideoInfoPuller a()
  {
    return new VidToVideoInfoPuller(this.a, QQStoryContext.a().b(), 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.model.MyVideoPlayingListSync
 * JD-Core Version:    0.7.0.1
 */