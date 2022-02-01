package com.tencent.biz.qqstory.storyHome.detail.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
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
import java.util.List;

public class CommentListPageLoader
  extends INetPageLoader
  implements CmdTaskManger.CommandCallback<GetFeedCommentRequest, GetFeedCommentRequest.GetFeedCommentResponse>
{
  private boolean g;
  private final CommentListPageLoader.CommentListener h;
  private final String i;
  private final FeedCommentSync j;
  
  public CommentListPageLoader(FeedCommentSync paramFeedCommentSync, @NonNull CommentListPageLoader.CommentListener paramCommentListener)
  {
    this.j = paramFeedCommentSync;
    this.h = paramCommentListener;
    this.i = null;
  }
  
  public CommentListPageLoader(FeedCommentSync paramFeedCommentSync, @NonNull String paramString)
  {
    this.j = paramFeedCommentSync;
    this.h = null;
    this.i = paramString;
  }
  
  private void a(CommentListPageLoader.GetFeedCommentEvent paramGetFeedCommentEvent)
  {
    CommentListPageLoader.CommentListener localCommentListener = this.h;
    if (localCommentListener == null)
    {
      StoryDispatcher.a().dispatch(this.i, paramGetFeedCommentEvent);
      return;
    }
    localCommentListener.a(paramGetFeedCommentEvent);
  }
  
  private void e()
  {
    GetFeedCommentRequest localGetFeedCommentRequest = new GetFeedCommentRequest();
    localGetFeedCommentRequest.f = this.j;
    CmdTaskManger.a().a(localGetFeedCommentRequest, this);
  }
  
  public void a(@NonNull GetFeedCommentRequest paramGetFeedCommentRequest, @Nullable GetFeedCommentRequest.GetFeedCommentResponse paramGetFeedCommentResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    SLog.a("Q.qqstory.detail:CommentListPageLoader", "get comment list return:%s", paramErrorMessage.toString());
    if (this.g)
    {
      SLog.c("Q.qqstory.detail:CommentListPageLoader", "don't nothing after terminate");
      return;
    }
    CommentListPageLoader.GetFeedCommentEvent localGetFeedCommentEvent = new CommentListPageLoader.GetFeedCommentEvent(paramErrorMessage, this.j.a, this.j.c);
    localGetFeedCommentEvent.d = this.a;
    localGetFeedCommentEvent.f = this.j.d;
    if ((paramGetFeedCommentResponse != null) && (!paramErrorMessage.isFail()))
    {
      SLog.a("Q.qqstory.detail:CommentListPageLoader", "comment respond from cookie:%s to %s", paramGetFeedCommentRequest.f.b, paramGetFeedCommentResponse.b);
      boolean bool = TextUtils.isEmpty(paramGetFeedCommentRequest.f.b);
      this.j.b = paramGetFeedCommentResponse.b;
      localGetFeedCommentEvent.k = paramGetFeedCommentResponse.e;
      localGetFeedCommentEvent.i = paramGetFeedCommentResponse.f;
      localGetFeedCommentEvent.c = bool;
      localGetFeedCommentEvent.a = paramGetFeedCommentResponse.a;
      localGetFeedCommentEvent.h = paramGetFeedCommentResponse.b;
      if ((!paramGetFeedCommentResponse.a) && (paramGetFeedCommentResponse.e.size() == 0))
      {
        localGetFeedCommentEvent.a = true;
        SLog.d("Q.qqstory.detail:CommentListPageLoader", "comment pull should be end!!!!!!!!!!!!");
      }
      try
      {
        this.e = true;
        a(localGetFeedCommentEvent);
        SLog.a("Q.qqstory.detail:CommentListPageLoader", "dispatch comment list return from network: %s", localGetFeedCommentEvent);
        paramGetFeedCommentRequest = new CommentListPageLoader.2(this, "Q.qqstory.detail:CommentListPageLoader", localGetFeedCommentEvent, bool);
        Bosses.get().postJob(paramGetFeedCommentRequest);
        return;
      }
      finally {}
    }
    a(localGetFeedCommentEvent);
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    if (this.g) {
      return;
    }
    this.j.b = "";
    e();
  }
  
  public void b(String paramString)
  {
    this.j.b = paramString;
  }
  
  public void c()
  {
    super.c();
    if (this.g)
    {
      AssertUtils.fail("don't call this method after terminate", new Object[0]);
      return;
    }
    e();
  }
  
  public void d()
  {
    this.g = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader
 * JD-Core Version:    0.7.0.1
 */