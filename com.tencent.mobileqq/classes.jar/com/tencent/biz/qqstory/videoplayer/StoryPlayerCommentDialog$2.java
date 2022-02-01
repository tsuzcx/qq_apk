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
  public CommentEntry a(String paramString, CommentEntry paramCommentEntry)
  {
    if (paramString.length() <= 0) {
      return null;
    }
    CommentEntry localCommentEntry = new CommentEntry();
    if (TextUtils.hasSysEmotion(paramString)) {}
    for (localCommentEntry.content = EmotionCodecUtils.a(paramString);; localCommentEntry.content = paramString)
    {
      localCommentEntry.replyTime = System.currentTimeMillis();
      if (paramCommentEntry != null)
      {
        localCommentEntry.replierUnionId = paramCommentEntry.authorUnionId;
        localCommentEntry.replierName = paramCommentEntry.authorName;
        localCommentEntry.replierRole = paramCommentEntry.authorRole;
      }
      localCommentEntry.authorUin = QQStoryContext.a().getCurrentUin();
      localCommentEntry.authorUnionId = QQStoryContext.a().b();
      localCommentEntry.status = 1;
      localCommentEntry.feedId = this.a.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.a.feedId;
      localCommentEntry.pbType = this.a.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.a.getCommentLikeType();
      if (((Integer)((StoryConfigManager)SuperManager.a(10)).b("qqstory_i_am_vip", Integer.valueOf(-1))).intValue() == 1) {
        localCommentEntry.authorRole = 2;
      }
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.a.mDenyComment == 1) {
        localCommentEntry.status = 2;
      }
      return localCommentEntry;
    }
  }
  
  public void a(String paramString, CommentEntry paramCommentEntry)
  {
    this.a.dismiss();
    paramString = a(paramString, paramCommentEntry);
    if (paramString == null) {}
    do
    {
      return;
      paramString.pbType = this.a.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.a.getCommentLikeType();
      ((CommentManager)SuperManager.a(17)).b(paramString);
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.a.mDenyComment != 1) {
        break;
      }
      QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131714420), 0).a();
    } while (this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryPlayerCommentDialog$CommentDialogListener == null);
    this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryPlayerCommentDialog$CommentDialogListener.a(false, paramString);
    return;
    StoryQQTextCacher.a().a = "";
    FeedCommentLego.a(this.a.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.a, paramString, false, 1, new StoryPlayerCommentDialog.2.1(this, paramString));
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.videoplayer.StoryPlayerCommentDialog.2
 * JD-Core Version:    0.7.0.1
 */