package com.tencent.biz.qqstory.comment;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.comment.lego.LegoResponseCallBack;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.CommentManager;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspAddFeedComment;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

final class FeedCommentLego$2
  implements LegoResponseCallBack
{
  FeedCommentLego$2(FeedCommentEventHandler.PostCommentCallback paramPostCommentCallback, CommentEntry paramCommentEntry, CommentManager paramCommentManager, boolean paramBoolean1, CommentLikeFeedItem paramCommentLikeFeedItem, int paramInt, boolean paramBoolean2) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (this.d)
    {
      FeedCommentLego.a(this.e, this.b, this.f, this.a, false, this.g);
      if (this.b.isReply()) {
        paramInt = 2;
      } else {
        paramInt = 1;
      }
      int i = StoryReportor.a(this.e);
      if (this.e.getOwner().isMe()) {
        paramBundle = "1";
      } else {
        paramBundle = "2";
      }
      StoryReportor.a("home_page", "comment_auto", i, paramInt, new String[] { paramBundle, StoryReportor.b(this.f), "", this.e.feedId });
      return;
    }
    paramBundle = this.b;
    paramBundle.status = 2;
    this.c.c(paramBundle);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("ReqAddComment errorCode ");
      paramBundle.append(paramInt);
      QLog.e("FeedCommentLego", 2, paramBundle.toString());
    }
    QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.a(2131902417), 0).show();
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = this.b;
    ((CommentEntry)localObject).status = 2;
    this.c.c((CommentEntry)localObject);
    if (paramInt == 10407) {
      StoryReportor.a("play_video", "exp_limit", 0, 0, new String[] { "", "", "", "" });
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ReqAddComment fails: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("FeedCommentLego", 2, ((StringBuilder)localObject).toString());
    }
    localObject = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject = HardCodeUtil.a(2131902450);
    }
    QQToast.makeText(BaseApplication.getContext(), 1, (CharSequence)localObject, 0).show();
  }
  
  public void a(MessageMicro paramMessageMicro)
  {
    paramMessageMicro = (qqstory_service.RspAddFeedComment)paramMessageMicro;
    if (this.a.a(this.b, paramMessageMicro)) {
      return;
    }
    this.c.d(this.b);
    this.b.commentId = paramMessageMicro.comment_id.get();
    paramMessageMicro = this.b;
    paramMessageMicro.status = 0;
    this.c.b(paramMessageMicro);
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    StoryFailCommentCacher.a().b();
    if ((this.d) && (!paramBoolean))
    {
      StoryQQTextCacher.a().a(this.b);
      return;
    }
    FeedCommentLego.a(this.f, 1, this.b.feedId, this.b.commentId);
    boolean bool;
    if ((paramBoolean) && (this.b.status == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    this.a.a(bool, paramBundle, this.b);
    int i;
    if (this.b.isReply()) {
      i = 2;
    } else {
      i = 1;
    }
    if (paramBoolean) {
      paramBundle = "comment_suc";
    } else {
      paramBundle = "comment_fail";
    }
    String str2 = StoryReportor.a("home_page-comment_suc-d1");
    String str3 = StoryQQTextCacher.a().a;
    int j;
    if (this.g) {
      j = 12;
    } else {
      j = StoryReportor.a(this.e);
    }
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "0";
    }
    StoryReportor.a("home_page", paramBundle, j, i, new String[] { str1, StoryReportor.b(this.f), str3, this.e.feedId });
    StoryQQTextCacher.a().a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedCommentLego.2
 * JD-Core Version:    0.7.0.1
 */