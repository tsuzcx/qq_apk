package com.tencent.biz.qqstory.storyHome.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tdc;
import uwg;
import uwt;
import uxp;
import uxr;

public class HomeFeedPresenter$3
  implements Runnable
{
  public HomeFeedPresenter$3(uwt paramuwt, ArrayList paramArrayList) {}
  
  public void run()
  {
    uwg localuwg = (uwg)tdc.a(12);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (uxp)localIterator.next();
      if ((localObject instanceof uxr))
      {
        localObject = (uxr)localObject;
        FeedVideoInfo localFeedVideoInfo = ((uxr)localObject).a().getVideoInfo();
        localFeedVideoInfo.mVideoItemList.addAll(((uxr)localObject).a());
        localuwg.a(0, localFeedVideoInfo.feedId, localFeedVideoInfo.mVideoSeq, localFeedVideoInfo.mVideoItemList, localFeedVideoInfo.mVideoNextCookie, localFeedVideoInfo.mIsVideoEnd, localFeedVideoInfo.mVideoPullType, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.3
 * JD-Core Version:    0.7.0.1
 */