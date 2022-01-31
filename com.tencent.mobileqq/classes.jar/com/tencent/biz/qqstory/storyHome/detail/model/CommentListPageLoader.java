package com.tencent.biz.qqstory.storyHome.detail.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.INetPageLoader;
import com.tencent.biz.qqstory.network.request.GetFeedCommentRequest;
import com.tencent.biz.qqstory.network.request.GetFeedCommentRequest.GetFeedCommentResponse;
import com.tencent.biz.qqstory.storyHome.model.FeedCommentSync;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.List;
import nyu;

public class CommentListPageLoader
  extends INetPageLoader
  implements CmdTaskManger.CommandCallback
{
  private final CommentListPageLoader.CommentListener jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader$CommentListener;
  private final FeedCommentSync jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedCommentSync;
  private final String jdField_a_of_type_JavaLangString;
  private boolean c;
  
  public CommentListPageLoader(FeedCommentSync paramFeedCommentSync, @NonNull CommentListPageLoader.CommentListener paramCommentListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedCommentSync = paramFeedCommentSync;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader$CommentListener = paramCommentListener;
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  public CommentListPageLoader(FeedCommentSync paramFeedCommentSync, @NonNull String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedCommentSync = paramFeedCommentSync;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader$CommentListener = null;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void a(CommentListPageLoader.GetFeedCommentEvent paramGetFeedCommentEvent)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader$CommentListener == null)
    {
      Dispatchers.get().dispatch(this.jdField_a_of_type_JavaLangString, paramGetFeedCommentEvent);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader$CommentListener.a(paramGetFeedCommentEvent);
  }
  
  private void e()
  {
    GetFeedCommentRequest localGetFeedCommentRequest = new GetFeedCommentRequest();
    localGetFeedCommentRequest.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedCommentSync = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedCommentSync;
    CmdTaskManger.a().a(localGetFeedCommentRequest, this);
  }
  
  public void a(@NonNull GetFeedCommentRequest paramGetFeedCommentRequest, @Nullable GetFeedCommentRequest.GetFeedCommentResponse paramGetFeedCommentResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    SLog.a("Q.qqstory.detail:CommentListPageLoader", "get comment list return:%s", paramErrorMessage.toString());
    if (this.c)
    {
      SLog.c("Q.qqstory.detail:CommentListPageLoader", "don't nothing after terminate");
      return;
    }
    CommentListPageLoader.GetFeedCommentEvent localGetFeedCommentEvent = new CommentListPageLoader.GetFeedCommentEvent(paramErrorMessage, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedCommentSync.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedCommentSync.jdField_a_of_type_Int);
    localGetFeedCommentEvent.d = this.jdField_a_of_type_Boolean;
    localGetFeedCommentEvent.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedCommentSync.jdField_b_of_type_Int;
    if ((paramGetFeedCommentResponse == null) || (paramErrorMessage.isFail()))
    {
      a(localGetFeedCommentEvent);
      return;
    }
    SLog.a("Q.qqstory.detail:CommentListPageLoader", "comment respond from cookie:%s to %s", paramGetFeedCommentRequest.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedCommentSync.jdField_b_of_type_JavaLangString, paramGetFeedCommentResponse.jdField_a_of_type_JavaLangString);
    boolean bool = TextUtils.isEmpty(paramGetFeedCommentRequest.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedCommentSync.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedCommentSync.jdField_b_of_type_JavaLangString = paramGetFeedCommentResponse.jdField_a_of_type_JavaLangString;
    localGetFeedCommentEvent.jdField_a_of_type_JavaUtilList = paramGetFeedCommentResponse.jdField_a_of_type_JavaUtilList;
    localGetFeedCommentEvent.jdField_b_of_type_Int = paramGetFeedCommentResponse.jdField_b_of_type_Int;
    localGetFeedCommentEvent.c = bool;
    localGetFeedCommentEvent.jdField_a_of_type_Boolean = paramGetFeedCommentResponse.jdField_a_of_type_Boolean;
    localGetFeedCommentEvent.jdField_b_of_type_JavaLangString = paramGetFeedCommentResponse.jdField_a_of_type_JavaLangString;
    if ((!paramGetFeedCommentResponse.jdField_a_of_type_Boolean) && (paramGetFeedCommentResponse.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      localGetFeedCommentEvent.jdField_a_of_type_Boolean = true;
      SLog.d("Q.qqstory.detail:CommentListPageLoader", "comment pull should be end!!!!!!!!!!!!");
    }
    try
    {
      this.b = true;
      a(localGetFeedCommentEvent);
      SLog.a("Q.qqstory.detail:CommentListPageLoader", "dispatch comment list return from network: %s", localGetFeedCommentEvent);
      paramGetFeedCommentRequest = new nyu(this, localGetFeedCommentEvent, bool);
      Bosses.get().postJob(paramGetFeedCommentRequest);
      return;
    }
    finally {}
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    if (this.c) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedCommentSync.jdField_b_of_type_JavaLangString = "";
    e();
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedCommentSync.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void c()
  {
    super.c();
    if (this.c)
    {
      AssertUtils.a("don't call this method after terminate", new Object[0]);
      return;
    }
    e();
  }
  
  public void d()
  {
    this.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader
 * JD-Core Version:    0.7.0.1
 */