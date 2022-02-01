package com.tencent.biz.qqstory.playvideo.floatdialog;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;

class StoryPlayerCommentListView$ListViewOnDataChangeListener
  implements CommentFloatDialogController.OnDataChangeListener
{
  private StoryPlayerCommentListView$ListViewOnDataChangeListener(StoryPlayerCommentListView paramStoryPlayerCommentListView) {}
  
  public void a()
  {
    this.a.q();
  }
  
  public void a(@NonNull DetailFeedItem paramDetailFeedItem, ErrorMessage paramErrorMessage, boolean paramBoolean)
  {
    if (paramErrorMessage.isSuccess()) {
      localObject = "suc";
    } else {
      localObject = "fail";
    }
    SLog.a("Q.qqstory.player.StoryPlayerCommentListView", "on cache item back %s:%s ", localObject, paramDetailFeedItem);
    boolean bool = StoryPlayerCommentListView.a(this.a).e();
    Object localObject = (PlayerCommentSegment)this.a.b("PlayerCommentSegment");
    if (localObject != null) {
      ((PlayerCommentSegment)localObject).a(paramDetailFeedItem);
    }
    localObject = (PlayerDoubleTabSegment)this.a.b("PlayerDoubleTabSegment");
    if (localObject != null) {
      ((PlayerDoubleTabSegment)localObject).a(paramDetailFeedItem);
    }
    localObject = (PlayerCommentEmptySegment)this.a.b("PlayerCommentEmptySegment");
    if (localObject != null)
    {
      ((PlayerCommentEmptySegment)localObject).a(paramDetailFeedItem);
      if (paramBoolean) {
        ((PlayerCommentEmptySegment)localObject).a(true);
      } else {
        ((PlayerCommentEmptySegment)localObject).a(false);
      }
    }
    this.a.setLoadMoreComplete("CommentFloatDialog", true, paramDetailFeedItem.b(bool) ^ true);
    this.a.q();
    if (StoryPlayerCommentListView.b(this.a) != null) {
      StoryPlayerCommentListView.b(this.a).a(paramDetailFeedItem, paramErrorMessage);
    }
  }
  
  public void a(@NonNull DetailFeedItem paramDetailFeedItem, boolean paramBoolean)
  {
    if (paramBoolean) {
      localObject = "suc";
    } else {
      localObject = "fail";
    }
    SLog.a("Q.qqstory.player.StoryPlayerCommentListView", "on comment item back %s: %s", localObject, paramDetailFeedItem);
    boolean bool = StoryPlayerCommentListView.a(this.a).e();
    Object localObject = (PlayerCommentSegment)this.a.b("PlayerCommentSegment");
    if (localObject != null) {
      ((PlayerCommentSegment)localObject).a(paramDetailFeedItem);
    }
    localObject = (PlayerDoubleTabSegment)this.a.b("PlayerDoubleTabSegment");
    if (localObject != null) {
      ((PlayerDoubleTabSegment)localObject).a(paramDetailFeedItem);
    }
    localObject = (PlayerCommentEmptySegment)this.a.b("PlayerCommentEmptySegment");
    if (localObject != null)
    {
      ((PlayerCommentEmptySegment)localObject).a(paramDetailFeedItem);
      ((PlayerCommentEmptySegment)localObject).a(false);
    }
    if (paramBoolean) {
      this.a.setLoadMoreComplete("CommentFloatDialog", true, paramDetailFeedItem.b(bool) ^ true);
    } else {
      this.a.setLoadMoreComplete("CommentFloatDialog", false, false);
    }
    this.a.q();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView.ListViewOnDataChangeListener
 * JD-Core Version:    0.7.0.1
 */