package com.tencent.biz.qqstory.comment;

import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;
import utl;
import uvm;
import uwm;
import woy;

public class FeedLikeLego$2
  implements Runnable
{
  public FeedLikeLego$2(utl paramutl, uwm paramuwm, String paramString, LikeEntry paramLikeEntry) {}
  
  public void run()
  {
    QQUserUIItem localQQUserUIItem = this.jdField_a_of_type_Uwm.b(this.jdField_a_of_type_JavaLangString);
    LikeEntry localLikeEntry;
    if (localQQUserUIItem != null)
    {
      localLikeEntry = this.jdField_a_of_type_ComTencentBizQqstoryDatabaseLikeEntry;
      if (!localQQUserUIItem.isVip) {
        break label104;
      }
    }
    label104:
    for (long l = 2L;; l = 0L)
    {
      localLikeEntry.role = l;
      this.this$0.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseLikeEntry);
      this.this$0.jdField_a_of_type_Uvm.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseLikeEntry);
      this.this$0.jdField_a_of_type_Woy.a(this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      ThreadManager.getUIHandler().post(new FeedLikeLego.2.1(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedLikeLego.2
 * JD-Core Version:    0.7.0.1
 */