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
    if (this.jdField_a_of_type_Boolean)
    {
      FeedCommentLego.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler$PostCommentCallback, false, this.b);
      if (this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.isReply()) {
        paramInt = 2;
      } else {
        paramInt = 1;
      }
      int i = StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {
        paramBundle = "1";
      } else {
        paramBundle = "2";
      }
      StoryReportor.a("home_page", "comment_auto", i, paramInt, new String[] { paramBundle, StoryReportor.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
    }
    paramBundle = this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry;
    paramBundle.status = 2;
    this.jdField_a_of_type_ComTencentBizQqstoryModelCommentManager.c(paramBundle);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("ReqAddComment errorCode ");
      paramBundle.append(paramInt);
      QLog.e("FeedCommentLego", 2, paramBundle.toString());
    }
    QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131704505), 0).a();
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry;
    ((CommentEntry)localObject).status = 2;
    this.jdField_a_of_type_ComTencentBizQqstoryModelCommentManager.c((CommentEntry)localObject);
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
      localObject = HardCodeUtil.a(2131704540);
    }
    QQToast.a(BaseApplication.getContext(), 1, (CharSequence)localObject, 0).a();
  }
  
  public void a(MessageMicro paramMessageMicro)
  {
    paramMessageMicro = (qqstory_service.RspAddFeedComment)paramMessageMicro;
    if (this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler$PostCommentCallback.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry, paramMessageMicro)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryModelCommentManager.d(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.commentId = paramMessageMicro.comment_id.get();
    paramMessageMicro = this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry;
    paramMessageMicro.status = 0;
    this.jdField_a_of_type_ComTencentBizQqstoryModelCommentManager.b(paramMessageMicro);
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    StoryFailCommentCacher.a().a();
    if ((this.jdField_a_of_type_Boolean) && (!paramBoolean))
    {
      StoryQQTextCacher.a().a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      return;
    }
    FeedCommentLego.a(this.jdField_a_of_type_Int, 1, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.feedId, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.commentId);
    boolean bool;
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.status == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler$PostCommentCallback.a(bool, paramBundle, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
    int i;
    if (this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.isReply()) {
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
    if (this.b) {
      j = 12;
    } else {
      j = StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    }
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "0";
    }
    StoryReportor.a("home_page", paramBundle, j, i, new String[] { str1, StoryReportor.a(this.jdField_a_of_type_Int), str3, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
    StoryQQTextCacher.a().a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedCommentLego.2
 * JD-Core Version:    0.7.0.1
 */