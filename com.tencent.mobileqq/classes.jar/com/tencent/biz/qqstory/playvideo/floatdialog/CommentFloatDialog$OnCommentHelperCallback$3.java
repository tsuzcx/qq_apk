package com.tencent.biz.qqstory.playvideo.floatdialog;

import android.os.Bundle;
import com.tencent.biz.qqstory.comment.FeedCommentEventHandler.PostCommentCallback;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.CommentManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspAddFeedComment;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.PBUInt32Field;

class CommentFloatDialog$OnCommentHelperCallback$3
  extends FeedCommentEventHandler.PostCommentCallback
{
  CommentFloatDialog$OnCommentHelperCallback$3(CommentFloatDialog.OnCommentHelperCallback paramOnCommentHelperCallback) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle, CommentEntry paramCommentEntry)
  {
    SLog.a("Q.qqstory.player.CommentFloatDialog", "post comment result is %s.", Boolean.valueOf(paramBoolean));
    if (!CommentFloatDialog.j(this.a.a)) {
      CommentFloatDialog.i(this.a.a).q();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialog.OnCommentHelperCallback.3
 * JD-Core Version:    0.7.0.1
 */