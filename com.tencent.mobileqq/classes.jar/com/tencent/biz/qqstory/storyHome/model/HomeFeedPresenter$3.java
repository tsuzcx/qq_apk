package com.tencent.biz.qqstory.storyHome.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import wth;
import ymk;
import ymx;
import ynt;
import ynv;

public class HomeFeedPresenter$3
  implements Runnable
{
  public HomeFeedPresenter$3(ymx paramymx, ArrayList paramArrayList) {}
  
  public void run()
  {
    ymk localymk = (ymk)wth.a(12);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ynt)localIterator.next();
      if ((localObject instanceof ynv))
      {
        localObject = (ynv)localObject;
        FeedVideoInfo localFeedVideoInfo = ((ynv)localObject).a().getVideoInfo();
        localFeedVideoInfo.mVideoItemList.addAll(((ynv)localObject).a());
        localymk.a(0, localFeedVideoInfo.feedId, localFeedVideoInfo.mVideoSeq, localFeedVideoInfo.mVideoItemList, localFeedVideoInfo.mVideoNextCookie, localFeedVideoInfo.mIsVideoEnd, localFeedVideoInfo.mVideoPullType, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.3
 * JD-Core Version:    0.7.0.1
 */