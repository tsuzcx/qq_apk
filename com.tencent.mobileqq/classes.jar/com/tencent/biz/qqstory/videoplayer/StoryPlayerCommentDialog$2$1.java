package com.tencent.biz.qqstory.videoplayer;

import android.os.Bundle;
import com.tencent.biz.qqstory.comment.FeedCommentEventHandler.PostCommentCallback;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class StoryPlayerCommentDialog$2$1
  extends FeedCommentEventHandler.PostCommentCallback
{
  StoryPlayerCommentDialog$2$1(StoryPlayerCommentDialog.2 param2, CommentEntry paramCommentEntry) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle, CommentEntry paramCommentEntry)
  {
    if (paramBoolean) {
      QQToast.makeText(BaseApplication.getContext(), 2, HardCodeUtil.a(2131911856), 0).show();
    } else {
      QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.a(2131911857), 0).show();
    }
    if (this.b.a.b != null) {
      this.b.a.b.a(paramBoolean, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.videoplayer.StoryPlayerCommentDialog.2.1
 * JD-Core Version:    0.7.0.1
 */