package com.tencent.biz.qqstory.storyHome.detail.view;

import android.os.Bundle;
import com.tencent.biz.qqstory.comment.FeedCommentEventHandler.PostCommentCallback;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.CommentManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspAddFeedComment;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.concurrent.atomic.AtomicBoolean;

class StoryDetailPresenter$2
  extends FeedCommentEventHandler.PostCommentCallback
{
  StoryDetailPresenter$2(StoryDetailPresenter paramStoryDetailPresenter) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle, CommentEntry paramCommentEntry)
  {
    SLog.a("Q.qqstory.detail.StoryDetailPresenter", "post comment result is %s.", Boolean.valueOf(paramBoolean));
    if (!StoryDetailPresenter.a(this.a).get()) {
      StoryDetailPresenter.a(this.a).c();
    }
  }
  
  public boolean a(CommentEntry paramCommentEntry, qqstory_service.RspAddFeedComment paramRspAddFeedComment)
  {
    CommentManager localCommentManager = (CommentManager)SuperManager.a(17);
    localCommentManager.a(paramCommentEntry.commentId);
    paramCommentEntry.commentId = paramRspAddFeedComment.comment_id.get();
    paramCommentEntry.status = 0;
    localCommentManager.a(paramCommentEntry);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailPresenter.2
 * JD-Core Version:    0.7.0.1
 */