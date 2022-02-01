package com.tencent.biz.qqstory.storyHome.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import wjs;
import ycq;
import ydd;
import ydz;
import yeb;

public class HomeFeedPresenter$3
  implements Runnable
{
  public HomeFeedPresenter$3(ydd paramydd, ArrayList paramArrayList) {}
  
  public void run()
  {
    ycq localycq = (ycq)wjs.a(12);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ydz)localIterator.next();
      if ((localObject instanceof yeb))
      {
        localObject = (yeb)localObject;
        FeedVideoInfo localFeedVideoInfo = ((yeb)localObject).a().getVideoInfo();
        localFeedVideoInfo.mVideoItemList.addAll(((yeb)localObject).a());
        localycq.a(0, localFeedVideoInfo.feedId, localFeedVideoInfo.mVideoSeq, localFeedVideoInfo.mVideoItemList, localFeedVideoInfo.mVideoNextCookie, localFeedVideoInfo.mIsVideoEnd, localFeedVideoInfo.mVideoPullType, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.3
 * JD-Core Version:    0.7.0.1
 */