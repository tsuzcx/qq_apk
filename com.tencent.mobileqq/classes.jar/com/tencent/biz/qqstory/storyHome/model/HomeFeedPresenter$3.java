package com.tencent.biz.qqstory.storyHome.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import uwa;
import wpe;
import wpr;
import wqn;
import wqp;

public class HomeFeedPresenter$3
  implements Runnable
{
  public HomeFeedPresenter$3(wpr paramwpr, ArrayList paramArrayList) {}
  
  public void run()
  {
    wpe localwpe = (wpe)uwa.a(12);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (wqn)localIterator.next();
      if ((localObject instanceof wqp))
      {
        localObject = (wqp)localObject;
        FeedVideoInfo localFeedVideoInfo = ((wqp)localObject).a().getVideoInfo();
        localFeedVideoInfo.mVideoItemList.addAll(((wqp)localObject).a());
        localwpe.a(0, localFeedVideoInfo.feedId, localFeedVideoInfo.mVideoSeq, localFeedVideoInfo.mVideoItemList, localFeedVideoInfo.mVideoNextCookie, localFeedVideoInfo.mIsVideoEnd, localFeedVideoInfo.mVideoPullType, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.3
 * JD-Core Version:    0.7.0.1
 */