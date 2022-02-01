package com.tencent.biz.qqstory.comment;

import android.os.Bundle;
import com.tencent.biz.qqstory.comment.lego.LegoResponseCallBack;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.CommentManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class FeedCommentLego$3
  implements LegoResponseCallBack
{
  FeedCommentLego$3(FeedCommentLego paramFeedCommentLego, int paramInt, CommentEntry paramCommentEntry) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    a(-1, HardCodeUtil.a(2131704511));
  }
  
  public void a(int paramInt, String paramString)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131704534));
    localStringBuilder.append(paramInt);
    QQToast.a(localBaseApplication, 1, localStringBuilder.toString(), 0).a();
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.status = 0;
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.e();
    if (QLog.isColorLevel()) {
      QLog.e("FeedCommentLego", 2, new Object[] { "ReqGetLikeList ErrorCode:", Integer.valueOf(paramInt), " | ErrorMsg: ", paramString });
    }
  }
  
  public void a(MessageMicro paramMessageMicro)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.e();
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_ComTencentBizQqstoryModelCommentManager.d(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
    StoryFailCommentCacher.a().a();
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.a(false, null);
    QQToast.a(BaseApplication.getContext(), 2, HardCodeUtil.a(2131704535), 0).a();
    FeedCommentLego.a(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_Int, 2, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.feedId, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.commentId);
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedCommentLego.3
 * JD-Core Version:    0.7.0.1
 */