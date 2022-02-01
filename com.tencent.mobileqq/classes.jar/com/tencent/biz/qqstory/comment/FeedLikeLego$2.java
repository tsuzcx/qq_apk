package com.tencent.biz.qqstory.comment;

import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.model.LikeManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;

class FeedLikeLego$2
  implements Runnable
{
  public void run()
  {
    QQUserUIItem localQQUserUIItem = this.jdField_a_of_type_ComTencentBizQqstoryModelUserManager.b(this.jdField_a_of_type_JavaLangString);
    if (localQQUserUIItem != null)
    {
      LikeEntry localLikeEntry = this.jdField_a_of_type_ComTencentBizQqstoryDatabaseLikeEntry;
      long l;
      if (localQQUserUIItem.isVip) {
        l = 2L;
      } else {
        l = 0L;
      }
      localLikeEntry.role = l;
    }
    this.this$0.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseLikeEntry);
    this.this$0.jdField_a_of_type_ComTencentBizQqstoryModelLikeManager.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseLikeEntry);
    this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager.a(this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    ThreadManager.getUIHandler().post(new FeedLikeLego.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedLikeLego.2
 * JD-Core Version:    0.7.0.1
 */