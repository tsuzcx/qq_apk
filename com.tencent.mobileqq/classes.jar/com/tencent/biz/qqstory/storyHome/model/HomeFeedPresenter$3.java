package com.tencent.biz.qqstory.storyHome.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tcz;
import uwd;
import uwq;
import uxm;
import uxo;

public class HomeFeedPresenter$3
  implements Runnable
{
  public HomeFeedPresenter$3(uwq paramuwq, ArrayList paramArrayList) {}
  
  public void run()
  {
    uwd localuwd = (uwd)tcz.a(12);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (uxm)localIterator.next();
      if ((localObject instanceof uxo))
      {
        localObject = (uxo)localObject;
        FeedVideoInfo localFeedVideoInfo = ((uxo)localObject).a().getVideoInfo();
        localFeedVideoInfo.mVideoItemList.addAll(((uxo)localObject).a());
        localuwd.a(0, localFeedVideoInfo.feedId, localFeedVideoInfo.mVideoSeq, localFeedVideoInfo.mVideoItemList, localFeedVideoInfo.mVideoNextCookie, localFeedVideoInfo.mIsVideoEnd, localFeedVideoInfo.mVideoPullType, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.3
 * JD-Core Version:    0.7.0.1
 */