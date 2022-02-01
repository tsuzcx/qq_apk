package com.tencent.biz.qqstory.videoplayer;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.comment.FeedCommentLego;
import com.tencent.biz.qqstory.comment.StoryInputBarView;
import com.tencent.biz.qqstory.comment.StoryQQTextCacher;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.CommentManager;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.InputViewHideListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class StoryPlayerCommentDialog$2
  implements FeedSegment.InputViewHideListener
{
  public void a(String paramString, CommentEntry paramCommentEntry)
  {
    this.a.dismiss();
    paramString = b(paramString, paramCommentEntry);
    if (paramString == null) {
      return;
    }
    paramString.pbType = this.a.a.b.getCommentLikeType();
    ((CommentManager)SuperManager.a(17)).b(paramString);
    if (this.a.a.b.mDenyComment == 1)
    {
      QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.a(2131911855), 0).show();
      if (this.a.b != null) {
        this.a.b.a(false, paramString);
      }
    }
    else
    {
      StoryQQTextCacher.a().a = "";
      FeedCommentLego.a(this.a.a.b, paramString, false, 1, new StoryPlayerCommentDialog.2.1(this, paramString));
    }
  }
  
  public CommentEntry b(String paramString, CommentEntry paramCommentEntry)
  {
    if (paramString.length() <= 0) {
      return null;
    }
    CommentEntry localCommentEntry = new CommentEntry();
    if (TextUtils.hasSysEmotion(paramString)) {
      localCommentEntry.content = EmotionCodecUtils.a(paramString);
    } else {
      localCommentEntry.content = paramString;
    }
    localCommentEntry.replyTime = System.currentTimeMillis();
    if (paramCommentEntry != null)
    {
      localCommentEntry.replierUnionId = paramCommentEntry.authorUnionId;
      localCommentEntry.replierName = paramCommentEntry.authorName;
      localCommentEntry.replierRole = paramCommentEntry.authorRole;
    }
    localCommentEntry.authorUin = QQStoryContext.j().getCurrentUin();
    localCommentEntry.authorUnionId = QQStoryContext.a().i();
    localCommentEntry.status = 1;
    localCommentEntry.feedId = this.a.a.b.feedId;
    localCommentEntry.pbType = this.a.a.b.getCommentLikeType();
    if (((Integer)((StoryConfigManager)SuperManager.a(10)).c("qqstory_i_am_vip", Integer.valueOf(-1))).intValue() == 1) {
      localCommentEntry.authorRole = 2;
    }
    if (this.a.a.b.mDenyComment == 1) {
      localCommentEntry.status = 2;
    }
    return localCommentEntry;
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.videoplayer.StoryPlayerCommentDialog.2
 * JD-Core Version:    0.7.0.1
 */