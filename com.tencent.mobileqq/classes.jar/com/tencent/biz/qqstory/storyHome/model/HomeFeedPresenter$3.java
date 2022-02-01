package com.tencent.biz.qqstory.storyHome.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import wpm;
import yip;
import yjc;
import yjy;
import yka;

public class HomeFeedPresenter$3
  implements Runnable
{
  public HomeFeedPresenter$3(yjc paramyjc, ArrayList paramArrayList) {}
  
  public void run()
  {
    yip localyip = (yip)wpm.a(12);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (yjy)localIterator.next();
      if ((localObject instanceof yka))
      {
        localObject = (yka)localObject;
        FeedVideoInfo localFeedVideoInfo = ((yka)localObject).a().getVideoInfo();
        localFeedVideoInfo.mVideoItemList.addAll(((yka)localObject).a());
        localyip.a(0, localFeedVideoInfo.feedId, localFeedVideoInfo.mVideoSeq, localFeedVideoInfo.mVideoItemList, localFeedVideoInfo.mVideoNextCookie, localFeedVideoInfo.mIsVideoEnd, localFeedVideoInfo.mVideoPullType, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.3
 * JD-Core Version:    0.7.0.1
 */