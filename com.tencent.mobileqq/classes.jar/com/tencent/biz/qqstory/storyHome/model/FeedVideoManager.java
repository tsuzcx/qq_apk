package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.OneObjectCacheList;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.IManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.detail.model.VideoListPageLoader;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.List;

public class FeedVideoManager
  implements IManager
{
  private OneObjectCacheList<String, FeedVideoInfo> a = new OneObjectCacheList(300);
  
  private String a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(":");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public FeedVideoInfo a(int paramInt, FeedVideoInfo paramFeedVideoInfo, boolean paramBoolean)
  {
    try
    {
      paramFeedVideoInfo = a(paramInt, paramFeedVideoInfo.feedId, paramFeedVideoInfo.mVideoSeq, paramFeedVideoInfo.mVideoItemList, paramFeedVideoInfo.mVideoNextCookie, paramFeedVideoInfo.mIsVideoEnd, paramFeedVideoInfo.mVideoPullType, paramBoolean);
      return paramFeedVideoInfo;
    }
    finally
    {
      paramFeedVideoInfo = finally;
      throw paramFeedVideoInfo;
    }
  }
  
  public FeedVideoInfo a(int paramInt1, String paramString1, int paramInt2, List<StoryVideoItem> paramList, String paramString2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2)
  {
    int i = 1;
    if ((paramInt3 != 0) && (paramInt3 != 1)) {
      return null;
    }
    try
    {
      localFeedVideoInfo = (FeedVideoInfo)this.a.a(a(paramString1, paramInt3));
      if (SLog.a())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("**before** update feed video list:");
        localStringBuilder.append(localFeedVideoInfo);
        SLog.b("Q.qqstory.home.data.FeedVideoManager", localStringBuilder.toString());
      }
      if (localFeedVideoInfo == null)
      {
        localFeedVideoInfo = new FeedVideoInfo();
        localFeedVideoInfo.feedId = paramString1;
        localFeedVideoInfo.mVideoSeq = paramInt2;
        localFeedVideoInfo.mVideoItemList.addAll(paramList);
        paramList = localFeedVideoInfo;
      }
      else if (localFeedVideoInfo.mVideoSeq == paramInt2)
      {
        if (paramBoolean2) {
          localFeedVideoInfo.mVideoItemList.clear();
        }
        localFeedVideoInfo.mVideoItemList.addAll(paramList);
        paramList = localFeedVideoInfo;
      }
      else
      {
        localFeedVideoInfo.mVideoSeq = paramInt2;
        localFeedVideoInfo.mVideoItemList.clear();
        localFeedVideoInfo.mVideoItemList.addAll(paramList);
        paramList = localFeedVideoInfo;
      }
      paramList.feedId = paramString1;
      paramList.mVideoNextCookie = paramString2;
      paramList.mIsVideoEnd = paramBoolean1;
      paramList.mVideoPullType = paramInt3;
      this.a.a(a(paramString1, paramInt3), paramList);
      if (!paramBoolean1) {
        break label401;
      }
      if (paramInt3 != 0) {
        break label451;
      }
      paramInt2 = i;
    }
    finally
    {
      for (;;)
      {
        FeedVideoInfo localFeedVideoInfo;
        for (;;)
        {
          throw paramString1;
        }
        paramInt2 = 0;
      }
    }
    localFeedVideoInfo = (FeedVideoInfo)this.a.a(a(paramString1, paramInt2));
    paramString2 = localFeedVideoInfo;
    if (localFeedVideoInfo == null) {
      paramString2 = new FeedVideoInfo();
    }
    paramString2.copy(paramList);
    paramString2.mVideoPullType = paramInt2;
    paramString2.mVideoItemList = new ArrayList(paramList.mVideoItemList.size());
    paramInt3 = paramList.mVideoItemList.size();
    while (paramInt3 > 0)
    {
      paramString2.mVideoItemList.add(paramList.mVideoItemList.get(paramInt3 - 1));
      paramInt3 -= 1;
    }
    this.a.a(a(paramString1, paramInt2), paramString2);
    label401:
    paramString1 = new FeedVideoManager.FeedVideoInfoUpdate(paramString1, paramInt1);
    StoryDispatcher.a().dispatch(paramString1);
    if (SLog.a()) {
      SLog.a("Q.qqstory.home.data.FeedVideoManager", "**after** update feed video list:%s", paramList);
    }
    return paramList;
  }
  
  @Nullable
  public FeedVideoInfo a(String paramString, int paramInt)
  {
    try
    {
      paramString = (FeedVideoInfo)this.a.a(a(paramString, paramInt));
      if (paramString == null) {
        return paramString;
      }
      FeedVideoInfo localFeedVideoInfo = new FeedVideoInfo();
      localFeedVideoInfo.copy(paramString);
      localFeedVideoInfo.mVideoItemList = new ArrayList(paramString.mVideoItemList);
      if (SLog.a())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("**get** update feed video list:");
        localStringBuilder.append(paramString);
        SLog.b("Q.qqstory.home.data.FeedVideoManager", localStringBuilder.toString());
      }
      return localFeedVideoInfo;
    }
    finally {}
  }
  
  public void a() {}
  
  public void a(FeedVideoInfo paramFeedVideoInfo)
  {
    if (paramFeedVideoInfo == null) {
      return;
    }
    if ((!paramFeedVideoInfo.mIsVideoEnd) && (!VideoListFeedItem.isFakeFeedId(paramFeedVideoInfo.feedId)) && (paramFeedVideoInfo.mVideoItemList.size() < 5))
    {
      new VideoListPageLoader(4, paramFeedVideoInfo).c();
      SLog.d("Q.qqstory.home.data.FeedVideoManager", "triggerSyncVideoList for %s", new Object[] { paramFeedVideoInfo });
    }
  }
  
  public void a(String paramString, int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramStoryVideoItem == null) {
        return;
      }
      paramString = (FeedVideoInfo)this.a.a(a(paramString, paramInt));
      if ((paramString != null) && (paramString.mVideoItemList != null)) {
        paramString.mVideoItemList.remove(paramStoryVideoItem);
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedVideoManager
 * JD-Core Version:    0.7.0.1
 */