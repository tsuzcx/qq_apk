package com.tencent.biz.qqstory.storyHome.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import urr;
import wkv;
import wli;
import wme;
import wmg;

public class HomeFeedPresenter$3
  implements Runnable
{
  public HomeFeedPresenter$3(wli paramwli, ArrayList paramArrayList) {}
  
  public void run()
  {
    wkv localwkv = (wkv)urr.a(12);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (wme)localIterator.next();
      if ((localObject instanceof wmg))
      {
        localObject = (wmg)localObject;
        FeedVideoInfo localFeedVideoInfo = ((wmg)localObject).a().getVideoInfo();
        localFeedVideoInfo.mVideoItemList.addAll(((wmg)localObject).a());
        localwkv.a(0, localFeedVideoInfo.feedId, localFeedVideoInfo.mVideoSeq, localFeedVideoInfo.mVideoItemList, localFeedVideoInfo.mVideoNextCookie, localFeedVideoInfo.mIsVideoEnd, localFeedVideoInfo.mVideoPullType, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.3
 * JD-Core Version:    0.7.0.1
 */