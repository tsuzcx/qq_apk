package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.FeedFeatureItem;
import com.tencent.biz.qqstory.network.BatchNetHandler;
import com.tencent.biz.qqstory.network.request.BatchGetFriendStoryFeedInfoRequest;
import com.tencent.biz.qqstory.network.request.BatchGetFriendStoryFeedInfoRequest.GetFriendStoryFeedInfoResp;
import com.tencent.biz.qqstory.network.request.GetFeedFeatureRequest;
import com.tencent.biz.qqstory.network.response.GetFeedFeatureResponse;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.StoryHomeFeed;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class GetFeedFeatureHandler
  extends BatchNetHandler
  implements CmdTaskManger.CommandCallback
{
  public static ConcurrentHashMap<String, Long> f = new ConcurrentHashMap();
  public List<String> c = new ArrayList();
  public List<String> d = new ArrayList();
  public FeedManager e;
  private final boolean g;
  
  public GetFeedFeatureHandler(@NonNull List<String> paramList)
  {
    this.c.addAll(paramList);
    this.e = ((FeedManager)SuperManager.a(11));
    this.g = false;
  }
  
  public GetFeedFeatureHandler(@NonNull List<String> paramList, boolean paramBoolean)
  {
    this.c.addAll(paramList);
    this.e = ((FeedManager)SuperManager.a(11));
    this.g = paramBoolean;
  }
  
  public static void a(@NonNull List<String> paramList)
  {
    int k = paramList.size();
    double d1 = k;
    Double.isNaN(d1);
    int m = (int)Math.ceil(d1 / 5.0D);
    int j;
    for (int i = 0; i < m; i = j)
    {
      j = i + 1;
      new GetFeedFeatureHandler(paramList.subList(i * 5, Math.min(j * 5, k))).a();
    }
  }
  
  private void b(List<FeedFeatureItem> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FeedFeatureItem localFeedFeatureItem = (FeedFeatureItem)paramList.next();
        FeedItem localFeedItem = this.e.b(localFeedFeatureItem.a);
        if (localFeedItem == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "null feedItem when saving feed feature...feedId=", localFeedFeatureItem.a });
          }
        }
        else
        {
          localFeedItem.convertFromFeedFeature(localFeedFeatureItem);
          localArrayList.add(localFeedItem);
        }
      }
      this.e.a(localArrayList);
    }
  }
  
  public void a()
  {
    ThreadManager.post(new GetFeedFeatureHandler.1(this), 8, null, true);
  }
  
  public void a(@NonNull NetworkRequest paramNetworkRequest, @Nullable BaseResponse paramBaseResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if (((paramNetworkRequest instanceof GetFeedFeatureRequest)) && ((paramBaseResponse instanceof GetFeedFeatureResponse)))
    {
      paramNetworkRequest = (GetFeedFeatureResponse)paramBaseResponse;
      paramBaseResponse = new GetFeedFeatureHandler.GetFeedFeatureEvent();
      paramBaseResponse.g = paramErrorMessage;
      if ((paramErrorMessage.isSuccess()) && (!paramNetworkRequest.a.isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "save feedFeature: first=", ((FeedFeatureItem)paramNetworkRequest.a.get(0)).a });
        }
        b(paramNetworkRequest.a);
        paramBaseResponse.a = paramNetworkRequest.a;
        StoryDispatcher.a().dispatch(paramBaseResponse);
        c();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.home.GetFeedFeatureHandler", 2, "save feedFeature failed.", paramErrorMessage);
      }
      StoryDispatcher.a().dispatch(paramBaseResponse);
      d();
      return;
    }
    if (((paramNetworkRequest instanceof BatchGetFriendStoryFeedInfoRequest)) && ((paramBaseResponse instanceof BatchGetFriendStoryFeedInfoRequest.GetFriendStoryFeedInfoResp)))
    {
      paramNetworkRequest = (BatchGetFriendStoryFeedInfoRequest.GetFriendStoryFeedInfoResp)paramBaseResponse;
      if (paramErrorMessage.isSuccess())
      {
        paramBaseResponse = new ArrayList(paramNetworkRequest.a.size());
        paramNetworkRequest = paramNetworkRequest.a.iterator();
        while (paramNetworkRequest.hasNext()) {
          paramBaseResponse.add(((StoryHomeFeed)paramNetworkRequest.next()).g());
        }
        if (!paramBaseResponse.isEmpty())
        {
          this.e.a(paramBaseResponse);
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "save feedItem: first=", ((FeedItem)paramBaseResponse.get(0)).feedId, ". request FeedFeature." });
          }
          paramNetworkRequest = new GetFeedFeatureRequest();
          paramNetworkRequest.f = this.c;
          CmdTaskManger.a().a(paramNetworkRequest, this);
          return;
        }
      }
      if (!this.d.isEmpty())
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "request local FeedFeature after FeedItem. first=", this.d.get(0) });
        }
        paramNetworkRequest = new GetFeedFeatureRequest();
        paramNetworkRequest.f = this.d;
        CmdTaskManger.a().a(paramNetworkRequest, this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetFeedFeatureHandler
 * JD-Core Version:    0.7.0.1
 */