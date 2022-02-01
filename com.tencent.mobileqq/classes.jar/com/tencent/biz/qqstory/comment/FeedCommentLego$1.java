package com.tencent.biz.qqstory.comment;

import android.os.Bundle;
import com.tencent.biz.qqstory.database.CommentEntry;

class FeedCommentLego$1
  extends FeedCommentEventHandler.PostCommentCallback
{
  FeedCommentLego$1(FeedCommentLego paramFeedCommentLego) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle, CommentEntry paramCommentEntry)
  {
    this.a.e();
    if (paramBoolean) {
      this.a.a(true, paramCommentEntry);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedCommentLego.1
 * JD-Core Version:    0.7.0.1
 */