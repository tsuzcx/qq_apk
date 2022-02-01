package com.tencent.biz.qqstory.playvideo.floatdialog;

import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.detail.model.cmment.DetailCommentHelper;
import com.tencent.widget.XEditTextEx;

class CommentFloatDialog$OnCommentListViewStateChangeListener
  implements StoryPlayerCommentListView.CommentListViewStateChangeListener
{
  private CommentFloatDialog$OnCommentListViewStateChangeListener(CommentFloatDialog paramCommentFloatDialog) {}
  
  public void a()
  {
    if (!CommentFloatDialog.b(this.a)) {
      this.a.a();
    }
  }
  
  public void a(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    if (CommentFloatDialog.a(this.a) != null) {
      CommentFloatDialog.a(this.a).a(paramCommentEntry, paramInt1, paramInt2);
    }
  }
  
  public void a(@NonNull DetailFeedItem paramDetailFeedItem, ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isSuccess())
    {
      CommentFloatDialog.a(this.a, paramDetailFeedItem);
      CommentFloatDialog.a(this.a).setVisibility(0);
      paramErrorMessage = this.a;
      CommentFloatDialog.a(paramErrorMessage, new DetailCommentHelper(paramErrorMessage.getContext(), CommentFloatDialog.b(this.a), paramDetailFeedItem, false, 4444, new CommentFloatDialog.OnCommentHelperCallback(this.a, null)));
      if (CommentFloatDialog.a(this.a).a != null) {
        CommentFloatDialog.a(this.a).a.setText(CommentFloatDialog.a(this.a).a);
      }
      if (CommentFloatDialog.a(this.a))
      {
        CommentFloatDialog.a(this.a, false);
        CommentFloatDialog.a(this.a).postDelayed(new CommentFloatDialog.OnCommentListViewStateChangeListener.1(this), 100);
      }
    }
    else
    {
      CommentFloatDialog.a(this.a).setVisibility(8);
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) && (CommentFloatDialog.a(this.a) != null) && (CommentFloatDialog.a(this.a).a()))
    {
      CommentFloatDialog.a(this.a).c();
      return true;
    }
    return false;
  }
  
  public void b(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    if (CommentFloatDialog.a(this.a) != null) {
      CommentFloatDialog.a(this.a).b(paramCommentEntry, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialog.OnCommentListViewStateChangeListener
 * JD-Core Version:    0.7.0.1
 */