package com.tencent.biz.qqstory.comment;

import android.os.Bundle;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspAddFeedComment;

public abstract class FeedCommentEventHandler$PostCommentCallback
{
  public abstract void a(boolean paramBoolean, Bundle paramBundle, CommentEntry paramCommentEntry);
  
  public boolean a(CommentEntry paramCommentEntry, qqstory_service.RspAddFeedComment paramRspAddFeedComment)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedCommentEventHandler.PostCommentCallback
 * JD-Core Version:    0.7.0.1
 */