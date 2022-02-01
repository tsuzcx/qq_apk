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
    this.a.p();
  }
  
  public void a(@NonNull DetailFeedItem paramDetailFeedItem, ErrorMessage paramErrorMessage, boolean paramBoolean)
  {
    Object localObject;
    if (paramErrorMessage.isSuccess())
    {
      localObject = "suc";
      SLog.a("Q.qqstory.player.StoryPlayerCommentListView", "on cache item back %s:%s ", localObject, paramDetailFeedItem);
      boolean bool = StoryPlayerCommentListView.a(this.a).a();
      localObject = (PlayerCommentSegment)this.a.a("PlayerCommentSegment");
      if (localObject != null) {
        ((PlayerCommentSegment)localObject).a(paramDetailFeedItem);
      }
      localObject = (PlayerDoubleTabSegment)this.a.a("PlayerDoubleTabSegment");
      if (localObject != null) {
        ((PlayerDoubleTabSegment)localObject).a(paramDetailFeedItem);
      }
      localObject = (PlayerCommentEmptySegment)this.a.a("PlayerCommentEmptySegment");
      if (localObject != null)
      {
        ((PlayerCommentEmptySegment)localObject).a(paramDetailFeedItem);
        if (!paramBoolean) {
          break label183;
        }
        ((PlayerCommentEmptySegment)localObject).a(true);
      }
      label118:
      localObject = this.a;
      if (paramDetailFeedItem.a(bool)) {
        break label192;
      }
    }
    label183:
    label192:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((StoryPlayerCommentListView)localObject).setLoadMoreComplete("CommentFloatDialog", true, paramBoolean);
      this.a.p();
      if (StoryPlayerCommentListView.a(this.a) != null) {
        StoryPlayerCommentListView.a(this.a).a(paramDetailFeedItem, paramErrorMessage);
      }
      return;
      localObject = "fail";
      break;
      ((PlayerCommentEmptySegment)localObject).a(false);
      break label118;
    }
  }
  
  public void a(@NonNull DetailFeedItem paramDetailFeedItem, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = "suc";
      SLog.a("Q.qqstory.player.StoryPlayerCommentListView", "on comment item back %s: %s", localObject, paramDetailFeedItem);
      boolean bool = StoryPlayerCommentListView.a(this.a).a();
      localObject = (PlayerCommentSegment)this.a.a("PlayerCommentSegment");
      if (localObject != null) {
        ((PlayerCommentSegment)localObject).a(paramDetailFeedItem);
      }
      localObject = (PlayerDoubleTabSegment)this.a.a("PlayerDoubleTabSegment");
      if (localObject != null) {
        ((PlayerDoubleTabSegment)localObject).a(paramDetailFeedItem);
      }
      localObject = (PlayerCommentEmptySegment)this.a.a("PlayerCommentEmptySegment");
      if (localObject != null)
      {
        ((PlayerCommentEmptySegment)localObject).a(paramDetailFeedItem);
        ((PlayerCommentEmptySegment)localObject).a(false);
      }
      if (!paramBoolean) {
        break label159;
      }
      localObject = this.a;
      if (paramDetailFeedItem.a(bool)) {
        break label154;
      }
      paramBoolean = true;
      label130:
      ((StoryPlayerCommentListView)localObject).setLoadMoreComplete("CommentFloatDialog", true, paramBoolean);
    }
    for (;;)
    {
      this.a.p();
      return;
      localObject = "fail";
      break;
      label154:
      paramBoolean = false;
      break label130;
      label159:
      this.a.setLoadMoreComplete("CommentFloatDialog", false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView.ListViewOnDataChangeListener
 * JD-Core Version:    0.7.0.1
 */