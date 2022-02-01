package com.tencent.biz.qqstory.storyHome.detail.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.INetPageLoader;
import com.tencent.biz.qqstory.network.handler.GetVidPollInfoHandler;
import com.tencent.biz.qqstory.network.request.BatchGetFriendStoryFeedInfoRequest;
import com.tencent.biz.qqstory.network.request.GetFeedVideoListRequest;
import com.tencent.biz.qqstory.network.response.GetFeedVideoListResponse;
import com.tencent.biz.qqstory.storyHome.model.FeedIdListSeqInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VideoListPageLoader
  extends INetPageLoader
  implements CmdTaskManger.CommandCallback<GetFeedVideoListRequest, GetFeedVideoListResponse>
{
  private int g;
  private String h;
  private String i;
  private int j;
  private boolean k;
  private String l;
  private int m = 0;
  private VideoListPageLoader.CallBack n;
  private boolean o;
  
  public VideoListPageLoader(int paramInt, FeedVideoInfo paramFeedVideoInfo)
  {
    this.m = paramInt;
    this.h = paramFeedVideoInfo.feedId;
    this.g = paramFeedVideoInfo.mVideoPullType;
    this.i = paramFeedVideoInfo.mVideoNextCookie;
    this.j = paramFeedVideoInfo.mVideoSeq;
    if (TextUtils.isEmpty(this.h))
    {
      SLog.e("Q.qqstory.home.data:VideoListPageLoader", "initial video page loader failed because feedId is null. from page %d.", new Object[] { Integer.valueOf(paramInt) });
      paramFeedVideoInfo = new StringBuilder();
      paramFeedVideoInfo.append("initial video page loader failed because feedId is null. from page ");
      paramFeedVideoInfo.append(paramInt);
      AssertUtils.assertTrue(false, paramFeedVideoInfo.toString());
    }
  }
  
  public VideoListPageLoader(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    this.m = paramInt1;
    this.h = paramString;
    this.g = paramInt2;
    this.i = "";
    this.j = paramInt3;
    this.o = true;
    if (TextUtils.isEmpty(paramString))
    {
      SLog.e("Q.qqstory.home.data:VideoListPageLoader", "initial video page loader failed because feedId is null. from page %d.", new Object[] { Integer.valueOf(paramInt1) });
      paramString = new StringBuilder();
      paramString.append("initial video page loader failed because feedId is null. from page ");
      paramString.append(paramInt1);
      AssertUtils.assertTrue(false, paramString.toString());
    }
  }
  
  private void a(VideoListPageLoader.GetVideoListEvent paramGetVideoListEvent)
  {
    VideoListPageLoader.CallBack localCallBack = this.n;
    if (localCallBack == null)
    {
      StoryDispatcher.a().dispatch(this.l, paramGetVideoListEvent);
      return;
    }
    localCallBack.a(paramGetVideoListEvent);
  }
  
  private void e()
  {
    if (VideoListFeedItem.isFakeFeedId(this.h))
    {
      localObject = new VideoListPageLoader.GetVideoListEvent(new ErrorMessage(), this.h);
      ((VideoListPageLoader.GetVideoListEvent)localObject).a = true;
      ((VideoListPageLoader.GetVideoListEvent)localObject).c = true;
      StoryDispatcher.a().dispatch((Dispatcher.Dispatchable)localObject);
      return;
    }
    if ((this.o) && (TextUtils.isEmpty(this.i)))
    {
      f();
      return;
    }
    Object localObject = new GetFeedVideoListRequest();
    ((GetFeedVideoListRequest)localObject).f = this.h;
    ((GetFeedVideoListRequest)localObject).e = this.i;
    ((GetFeedVideoListRequest)localObject).g = this.g;
    CmdTaskManger.a().a((NetworkRequest)localObject, this);
    SLog.a("Q.qqstory.home.data:VideoListPageLoader", "send video list request. request=%s.", ((GetFeedVideoListRequest)localObject).toString());
  }
  
  private void f()
  {
    BatchGetFriendStoryFeedInfoRequest localBatchGetFriendStoryFeedInfoRequest = new BatchGetFriendStoryFeedInfoRequest();
    localBatchGetFriendStoryFeedInfoRequest.f = new ArrayList(1);
    localBatchGetFriendStoryFeedInfoRequest.f.add(new FeedIdListSeqInfo(this.h, 0, "", "0"));
    CmdTaskManger.a().a(localBatchGetFriendStoryFeedInfoRequest, new VideoListPageLoader.2(this));
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    this.g = paramInt1;
    this.i = paramString;
    this.j = paramInt2;
  }
  
  public void a(@NonNull GetFeedVideoListRequest paramGetFeedVideoListRequest, @Nullable GetFeedVideoListResponse paramGetFeedVideoListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    SLog.a("Q.qqstory.home.data:VideoListPageLoader", "get video list return:%s", paramErrorMessage.toString());
    if (this.k)
    {
      SLog.c("Q.qqstory.home.data:VideoListPageLoader", "don't nothing after terminate");
      return;
    }
    VideoListPageLoader.GetVideoListEvent localGetVideoListEvent = new VideoListPageLoader.GetVideoListEvent(paramErrorMessage, this.h);
    localGetVideoListEvent.d = this.a;
    if ((paramGetFeedVideoListResponse != null) && (!paramErrorMessage.isFail()))
    {
      boolean bool = TextUtils.isEmpty(paramGetFeedVideoListRequest.e);
      this.i = paramGetFeedVideoListResponse.a;
      localGetVideoListEvent.h = paramGetFeedVideoListResponse.e;
      localGetVideoListEvent.c = bool;
      localGetVideoListEvent.a = paramGetFeedVideoListResponse.b;
      if ((!localGetVideoListEvent.a) && (TextUtils.isEmpty(this.i))) {
        localGetVideoListEvent.a = true;
      }
      localGetVideoListEvent.f = paramGetFeedVideoListResponse.f;
      localGetVideoListEvent.h = ((FeedManager)SuperManager.a(11)).a(this.h, localGetVideoListEvent.h, bool);
      localGetVideoListEvent.i = new FeedVideoInfo(paramGetFeedVideoListRequest.f, this.j, this.g, this.i, localGetVideoListEvent.a);
      paramGetFeedVideoListRequest = new ArrayList(localGetVideoListEvent.h.size());
      paramGetFeedVideoListResponse = localGetVideoListEvent.h.iterator();
      while (paramGetFeedVideoListResponse.hasNext()) {
        paramGetFeedVideoListRequest.add(((StoryVideoItem)paramGetFeedVideoListResponse.next()).mVid);
      }
      GetVidPollInfoHandler.a(paramGetFeedVideoListRequest);
      try
      {
        this.e = true;
        a(localGetVideoListEvent);
        SLog.a("Q.qqstory.home.data:VideoListPageLoader", "dispatch video list return from network: %s", localGetVideoListEvent);
        return;
      }
      finally {}
    }
    a(localGetVideoListEvent);
  }
  
  public void a(VideoListPageLoader.CallBack paramCallBack)
  {
    this.n = paramCallBack;
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    if (this.k) {
      return;
    }
    this.i = "";
    e();
  }
  
  public void b(String paramString)
  {
    this.l = paramString;
  }
  
  public void c()
  {
    super.c();
    if (this.k) {
      return;
    }
    e();
  }
  
  public void d()
  {
    this.k = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.VideoListPageLoader
 * JD-Core Version:    0.7.0.1
 */