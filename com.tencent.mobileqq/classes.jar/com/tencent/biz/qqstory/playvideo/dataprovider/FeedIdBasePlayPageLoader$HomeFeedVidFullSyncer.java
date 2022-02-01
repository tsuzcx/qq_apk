package com.tencent.biz.qqstory.playvideo.dataprovider;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.FeedBasePlayInfo;
import com.tencent.biz.qqstory.storyHome.detail.model.VideoListPageLoader;
import com.tencent.biz.qqstory.storyHome.detail.model.VideoListPageLoader.GetVideoListEvent;
import com.tencent.biz.qqstory.storyHome.model.FeedIdListSeqInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoManager;
import com.tencent.biz.qqstory.storyHome.model.VideoListHomeFeed.StoryVideoListComp;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class FeedIdBasePlayPageLoader$HomeFeedVidFullSyncer
  implements IGroupPageLoader.IVidFullSyncer
{
  protected final FeedVideoManager a;
  private final FeedBasePlayInfo b;
  private final FeedIdBasePlayPageLoader.FeedBaseGroupId c;
  private VideoListPageLoader d;
  private IGroupPageLoader.IVidFullSyncer.CallBack e;
  private int f;
  
  public FeedIdBasePlayPageLoader$HomeFeedVidFullSyncer(FeedIdBasePlayPageLoader.FeedBaseGroupId paramFeedBaseGroupId, FeedBasePlayInfo paramFeedBasePlayInfo)
  {
    this.b = paramFeedBasePlayInfo;
    this.c = paramFeedBaseGroupId;
    this.a = ((FeedVideoManager)SuperManager.a(12));
  }
  
  private void a(ErrorMessage paramErrorMessage, IDataProvider.GroupId paramGroupId)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramGroupId);
    this.e.a(paramErrorMessage, localArrayList);
  }
  
  private void a(List<StoryVideoItem> paramList, VideoListPageLoader.GetVideoListEvent paramGetVideoListEvent)
  {
    if (!paramGetVideoListEvent.g.isSuccess())
    {
      b(paramList, paramGetVideoListEvent);
      return;
    }
    if (paramGetVideoListEvent.c) {
      paramList.clear();
    }
    paramList.addAll(paramGetVideoListEvent.h);
    SLog.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "add video size:%d", Integer.valueOf(paramGetVideoListEvent.h.size()));
    if (!paramGetVideoListEvent.a)
    {
      int i = this.f;
      if (i < 20)
      {
        this.f = (i + 1);
        SLog.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "request from net, count:%d", Integer.valueOf(this.f));
        this.d.c();
        return;
      }
    }
    b(paramList, paramGetVideoListEvent);
  }
  
  private void a(List<StoryVideoItem> paramList, FeedVideoInfo paramFeedVideoInfo)
  {
    if (this.c.a == null)
    {
      a(new ErrorMessage(940001, "group info is null"), this.c);
      return;
    }
    if (paramFeedVideoInfo == null)
    {
      this.d = new VideoListPageLoader(1, this.c.a.a, 0, -1);
    }
    else
    {
      paramList.addAll(paramFeedVideoInfo.mVideoItemList);
      this.d = new VideoListPageLoader(1, paramFeedVideoInfo);
    }
    this.d.a(new FeedIdBasePlayPageLoader.HomeFeedVidFullSyncer.1(this, paramList));
    this.d.c();
    SLog.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "request from net, count:%d, %s", Integer.valueOf(this.f), this.c);
  }
  
  private void a(List<StoryVideoItem> paramList, String paramString)
  {
    paramList = FeedIdBasePlayPageLoader.a(paramList, paramString, this.c);
    paramString = new ArrayList();
    paramString.add(paramList);
    this.e.a(paramString, true);
  }
  
  private void b(List<StoryVideoItem> paramList, VideoListPageLoader.GetVideoListEvent paramGetVideoListEvent)
  {
    if (this.c.a == null)
    {
      a(new ErrorMessage(940001, "group info is null"), this.c);
      return;
    }
    if (paramGetVideoListEvent.i == null)
    {
      a(paramList, paramGetVideoListEvent.e);
      return;
    }
    StoryVideoItem localStoryVideoItem;
    if (QQStoryContext.a().b(this.c.a.c))
    {
      localObject = FeedIdBasePlayPageLoader.d();
      boolean bool = true;
      if (localObject == null) {
        FeedIdBasePlayPageLoader.c(((StoryManager)SuperManager.a(5)).a(true));
      }
      if (FeedIdBasePlayPageLoader.d().size() != 0)
      {
        localObject = FeedIdBasePlayPageLoader.d().iterator();
        while (((Iterator)localObject).hasNext())
        {
          localStoryVideoItem = (StoryVideoItem)((Iterator)localObject).next();
          if (localStoryVideoItem.mPublishDate.equals(this.c.a.d))
          {
            SLog.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "add fail video %s", localStoryVideoItem);
            paramList.add(localStoryVideoItem);
          }
        }
        if (paramGetVideoListEvent.i.mVideoPullType != 1) {
          bool = false;
        }
        Collections.sort(paramList, new VideoListHomeFeed.StoryVideoListComp(bool));
      }
    }
    Object localObject = paramList.iterator();
    paramList = new ArrayList(paramList.size());
    while (((Iterator)localObject).hasNext())
    {
      localStoryVideoItem = (StoryVideoItem)((Iterator)localObject).next();
      if (!paramList.contains(localStoryVideoItem)) {
        paramList.add(localStoryVideoItem);
      }
    }
    paramGetVideoListEvent.i = ((FeedVideoManager)SuperManager.a(12)).a(1, paramGetVideoListEvent.i.feedId, paramGetVideoListEvent.i.mVideoSeq, paramList, paramGetVideoListEvent.i.mVideoNextCookie, paramGetVideoListEvent.a, paramGetVideoListEvent.i.mVideoPullType, true);
    a(paramList, paramGetVideoListEvent.e);
  }
  
  public void a(IGroupPageLoader.IVidFullSyncer.CallBack paramCallBack)
  {
    if (this.c.a == null)
    {
      a(new ErrorMessage(940001, "group info is null"), this.c);
      return;
    }
    this.e = paramCallBack;
    int i = FeedIdBasePlayPageLoader.a(this.c, this.b);
    Object localObject = new ArrayList();
    paramCallBack = this.a.a(this.c.a.a, i);
    if ((paramCallBack != null) && (paramCallBack.mIsVideoEnd) && (!this.b.mForceNotUseVidCache))
    {
      localObject = paramCallBack.mVideoItemList;
      paramCallBack = paramCallBack.feedId;
      SLog.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "return from cache %s", paramCallBack);
      a((List)localObject, paramCallBack);
      return;
    }
    a((List)localObject, paramCallBack);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.FeedIdBasePlayPageLoader.HomeFeedVidFullSyncer
 * JD-Core Version:    0.7.0.1
 */