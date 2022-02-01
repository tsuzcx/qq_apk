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
  public static ConcurrentHashMap<String, Long> a;
  public FeedManager a;
  public List<String> a;
  private final boolean a;
  public List<String> b = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public GetFeedFeatureHandler(@NonNull List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager = ((FeedManager)SuperManager.a(11));
    this.jdField_a_of_type_Boolean = false;
  }
  
  public GetFeedFeatureHandler(@NonNull List<String> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager = ((FeedManager)SuperManager.a(11));
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static void a(@NonNull List<String> paramList)
  {
    int k = paramList.size();
    double d = k;
    Double.isNaN(d);
    int m = (int)Math.ceil(d / 5.0D);
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
        FeedItem localFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager.a(localFeedFeatureItem.a);
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
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager.a(localArrayList);
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
      paramBaseResponse.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      if ((paramErrorMessage.isSuccess()) && (!paramNetworkRequest.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "save feedFeature: first=", ((FeedFeatureItem)paramNetworkRequest.jdField_a_of_type_JavaUtilList.get(0)).a });
        }
        b(paramNetworkRequest.jdField_a_of_type_JavaUtilList);
        paramBaseResponse.jdField_a_of_type_JavaUtilList = paramNetworkRequest.jdField_a_of_type_JavaUtilList;
        StoryDispatcher.a().dispatch(paramBaseResponse);
        b();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.home.GetFeedFeatureHandler", 2, "save feedFeature failed.", paramErrorMessage);
      }
      StoryDispatcher.a().dispatch(paramBaseResponse);
      c();
      return;
    }
    if (((paramNetworkRequest instanceof BatchGetFriendStoryFeedInfoRequest)) && ((paramBaseResponse instanceof BatchGetFriendStoryFeedInfoRequest.GetFriendStoryFeedInfoResp)))
    {
      paramNetworkRequest = (BatchGetFriendStoryFeedInfoRequest.GetFriendStoryFeedInfoResp)paramBaseResponse;
      if (paramErrorMessage.isSuccess())
      {
        paramBaseResponse = new ArrayList(paramNetworkRequest.jdField_a_of_type_JavaUtilList.size());
        paramNetworkRequest = paramNetworkRequest.jdField_a_of_type_JavaUtilList.iterator();
        while (paramNetworkRequest.hasNext()) {
          paramBaseResponse.add(((StoryHomeFeed)paramNetworkRequest.next()).a());
        }
        if (!paramBaseResponse.isEmpty())
        {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager.a(paramBaseResponse);
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "save feedItem: first=", ((FeedItem)paramBaseResponse.get(0)).feedId, ". request FeedFeature." });
          }
          paramNetworkRequest = new GetFeedFeatureRequest();
          paramNetworkRequest.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
          CmdTaskManger.a().a(paramNetworkRequest, this);
          return;
        }
      }
      if (!this.b.isEmpty())
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "request local FeedFeature after FeedItem. first=", this.b.get(0) });
        }
        paramNetworkRequest = new GetFeedFeatureRequest();
        paramNetworkRequest.jdField_a_of_type_JavaUtilList = this.b;
        CmdTaskManger.a().a(paramNetworkRequest, this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetFeedFeatureHandler
 * JD-Core Version:    0.7.0.1
 */