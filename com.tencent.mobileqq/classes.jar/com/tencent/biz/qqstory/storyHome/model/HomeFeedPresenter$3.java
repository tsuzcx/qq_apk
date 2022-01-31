package com.tencent.biz.qqstory.storyHome.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import sqg;
import ujk;
import ujx;
import ukt;
import ukv;

public class HomeFeedPresenter$3
  implements Runnable
{
  public HomeFeedPresenter$3(ujx paramujx, ArrayList paramArrayList) {}
  
  public void run()
  {
    ujk localujk = (ujk)sqg.a(12);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ukt)localIterator.next();
      if ((localObject instanceof ukv))
      {
        localObject = (ukv)localObject;
        FeedVideoInfo localFeedVideoInfo = ((ukv)localObject).a().getVideoInfo();
        localFeedVideoInfo.mVideoItemList.addAll(((ukv)localObject).a());
        localujk.a(0, localFeedVideoInfo.feedId, localFeedVideoInfo.mVideoSeq, localFeedVideoInfo.mVideoItemList, localFeedVideoInfo.mVideoNextCookie, localFeedVideoInfo.mIsVideoEnd, localFeedVideoInfo.mVideoPullType, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.3
 * JD-Core Version:    0.7.0.1
 */