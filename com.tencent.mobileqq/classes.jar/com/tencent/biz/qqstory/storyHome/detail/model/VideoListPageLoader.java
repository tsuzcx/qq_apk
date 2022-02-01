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
  private int jdField_a_of_type_Int;
  private VideoListPageLoader.CallBack jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelVideoListPageLoader$CallBack;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int = 0;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  
  public VideoListPageLoader(int paramInt, FeedVideoInfo paramFeedVideoInfo)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_b_of_type_JavaLangString = paramFeedVideoInfo.feedId;
    this.jdField_a_of_type_Int = paramFeedVideoInfo.mVideoPullType;
    this.jdField_c_of_type_JavaLangString = paramFeedVideoInfo.mVideoNextCookie;
    this.jdField_b_of_type_Int = paramFeedVideoInfo.mVideoSeq;
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      SLog.e("Q.qqstory.home.data:VideoListPageLoader", "initial video page loader failed because feedId is null. from page %d.", new Object[] { Integer.valueOf(paramInt) });
      AssertUtils.a(false, "initial video page loader failed because feedId is null. from page " + paramInt);
    }
  }
  
  public VideoListPageLoader(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = paramInt3;
    this.jdField_d_of_type_Boolean = true;
    if (TextUtils.isEmpty(paramString))
    {
      SLog.e("Q.qqstory.home.data:VideoListPageLoader", "initial video page loader failed because feedId is null. from page %d.", new Object[] { Integer.valueOf(paramInt1) });
      AssertUtils.a(false, "initial video page loader failed because feedId is null. from page " + paramInt1);
    }
  }
  
  private void a(VideoListPageLoader.GetVideoListEvent paramGetVideoListEvent)
  {
    VideoListPageLoader.CallBack localCallBack = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelVideoListPageLoader$CallBack;
    if (localCallBack == null)
    {
      StoryDispatcher.a().dispatch(this.jdField_d_of_type_JavaLangString, paramGetVideoListEvent);
      return;
    }
    localCallBack.a(paramGetVideoListEvent);
  }
  
  private void e()
  {
    if (VideoListFeedItem.isFakeFeedId(this.jdField_b_of_type_JavaLangString))
    {
      localObject = new VideoListPageLoader.GetVideoListEvent(new ErrorMessage(), this.jdField_b_of_type_JavaLangString);
      ((VideoListPageLoader.GetVideoListEvent)localObject).jdField_a_of_type_Boolean = true;
      ((VideoListPageLoader.GetVideoListEvent)localObject).jdField_c_of_type_Boolean = true;
      StoryDispatcher.a().dispatch((Dispatcher.Dispatchable)localObject);
      return;
    }
    if ((this.jdField_d_of_type_Boolean) && (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)))
    {
      f();
      return;
    }
    Object localObject = new GetFeedVideoListRequest();
    ((GetFeedVideoListRequest)localObject).jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    ((GetFeedVideoListRequest)localObject).jdField_a_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    ((GetFeedVideoListRequest)localObject).jdField_c_of_type_Int = this.jdField_a_of_type_Int;
    CmdTaskManger.a().a((NetworkRequest)localObject, this);
    SLog.a("Q.qqstory.home.data:VideoListPageLoader", "send video list request. request=%s.", ((GetFeedVideoListRequest)localObject).toString());
  }
  
  private void f()
  {
    BatchGetFriendStoryFeedInfoRequest localBatchGetFriendStoryFeedInfoRequest = new BatchGetFriendStoryFeedInfoRequest();
    localBatchGetFriendStoryFeedInfoRequest.jdField_a_of_type_JavaUtilList = new ArrayList(1);
    localBatchGetFriendStoryFeedInfoRequest.jdField_a_of_type_JavaUtilList.add(new FeedIdListSeqInfo(this.jdField_b_of_type_JavaLangString, 0, "", "0"));
    CmdTaskManger.a().a(localBatchGetFriendStoryFeedInfoRequest, new VideoListPageLoader.2(this));
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_c_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void a(@NonNull GetFeedVideoListRequest paramGetFeedVideoListRequest, @Nullable GetFeedVideoListResponse paramGetFeedVideoListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    SLog.a("Q.qqstory.home.data:VideoListPageLoader", "get video list return:%s", paramErrorMessage.toString());
    if (this.jdField_c_of_type_Boolean)
    {
      SLog.c("Q.qqstory.home.data:VideoListPageLoader", "don't nothing after terminate");
      return;
    }
    VideoListPageLoader.GetVideoListEvent localGetVideoListEvent = new VideoListPageLoader.GetVideoListEvent(paramErrorMessage, this.jdField_b_of_type_JavaLangString);
    localGetVideoListEvent.jdField_d_of_type_Boolean = this.jdField_a_of_type_Boolean;
    if ((paramGetFeedVideoListResponse == null) || (paramErrorMessage.isFail()))
    {
      a(localGetVideoListEvent);
      return;
    }
    boolean bool = TextUtils.isEmpty(paramGetFeedVideoListRequest.jdField_a_of_type_JavaLangString);
    this.jdField_c_of_type_JavaLangString = paramGetFeedVideoListResponse.jdField_a_of_type_JavaLangString;
    localGetVideoListEvent.jdField_a_of_type_JavaUtilList = paramGetFeedVideoListResponse.jdField_a_of_type_JavaUtilArrayList;
    localGetVideoListEvent.jdField_c_of_type_Boolean = bool;
    localGetVideoListEvent.jdField_a_of_type_Boolean = paramGetFeedVideoListResponse.jdField_a_of_type_Boolean;
    if ((!localGetVideoListEvent.jdField_a_of_type_Boolean) && (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {
      localGetVideoListEvent.jdField_a_of_type_Boolean = true;
    }
    localGetVideoListEvent.jdField_b_of_type_JavaLangString = paramGetFeedVideoListResponse.jdField_c_of_type_JavaLangString;
    localGetVideoListEvent.jdField_a_of_type_JavaUtilList = ((FeedManager)SuperManager.a(11)).a(this.jdField_b_of_type_JavaLangString, localGetVideoListEvent.jdField_a_of_type_JavaUtilList, bool);
    localGetVideoListEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo = new FeedVideoInfo(paramGetFeedVideoListRequest.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString, localGetVideoListEvent.jdField_a_of_type_Boolean);
    paramGetFeedVideoListRequest = new ArrayList(localGetVideoListEvent.jdField_a_of_type_JavaUtilList.size());
    paramGetFeedVideoListResponse = localGetVideoListEvent.jdField_a_of_type_JavaUtilList.iterator();
    while (paramGetFeedVideoListResponse.hasNext()) {
      paramGetFeedVideoListRequest.add(((StoryVideoItem)paramGetFeedVideoListResponse.next()).mVid);
    }
    GetVidPollInfoHandler.a(paramGetFeedVideoListRequest);
    try
    {
      this.jdField_b_of_type_Boolean = true;
      a(localGetVideoListEvent);
      SLog.a("Q.qqstory.home.data:VideoListPageLoader", "dispatch video list return from network: %s", localGetVideoListEvent);
      return;
    }
    finally {}
  }
  
  public void a(VideoListPageLoader.CallBack paramCallBack)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelVideoListPageLoader$CallBack = paramCallBack;
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_JavaLangString = "";
    e();
  }
  
  public void b(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    e();
  }
  
  public void d()
  {
    this.jdField_c_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.VideoListPageLoader
 * JD-Core Version:    0.7.0.1
 */