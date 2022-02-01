package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class FeedSegment$10
  implements INetInfoHandler
{
  FeedSegment$10(FeedSegment paramFeedSegment) {}
  
  public void onNetMobile2None()
  {
    FeedSegment.b(this.a, FeedSegment.a(3));
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    FeedSegment.b(this.a, FeedSegment.a(1));
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    FeedSegment.b(this.a, FeedSegment.a(2));
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    FeedSegment.b(this.a, FeedSegment.a(1));
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    FeedSegment.b(this.a, FeedSegment.a(2));
  }
  
  public void onNetWifi2None()
  {
    FeedSegment.b(this.a, FeedSegment.a(3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.10
 * JD-Core Version:    0.7.0.1
 */