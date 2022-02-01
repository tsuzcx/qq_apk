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
      QQToast.a(BaseApplication.getContext(), 2, HardCodeUtil.a(2131714342), 0).a();
    } else {
      QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131714343), 0).a();
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryPlayerCommentDialog$2.a.a != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryPlayerCommentDialog$2.a.a.a(paramBoolean, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.videoplayer.StoryPlayerCommentDialog.2.1
 * JD-Core Version:    0.7.0.1
 */