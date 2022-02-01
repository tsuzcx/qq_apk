package com.tencent.biz.qqstory.storyHome.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import vux;
import xnv;
import xoi;
import xpe;
import xpg;

public class HomeFeedPresenter$3
  implements Runnable
{
  public HomeFeedPresenter$3(xoi paramxoi, ArrayList paramArrayList) {}
  
  public void run()
  {
    xnv localxnv = (xnv)vux.a(12);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (xpe)localIterator.next();
      if ((localObject instanceof xpg))
      {
        localObject = (xpg)localObject;
        FeedVideoInfo localFeedVideoInfo = ((xpg)localObject).a().getVideoInfo();
        localFeedVideoInfo.mVideoItemList.addAll(((xpg)localObject).a());
        localxnv.a(0, localFeedVideoInfo.feedId, localFeedVideoInfo.mVideoSeq, localFeedVideoInfo.mVideoItemList, localFeedVideoInfo.mVideoNextCookie, localFeedVideoInfo.mIsVideoEnd, localFeedVideoInfo.mVideoPullType, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.3
 * JD-Core Version:    0.7.0.1
 */