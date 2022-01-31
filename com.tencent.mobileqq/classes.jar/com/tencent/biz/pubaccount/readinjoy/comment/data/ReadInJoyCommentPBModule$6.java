package com.tencent.biz.pubaccount.readinjoy.comment.data;

import com.tencent.qphone.base.util.QLog;
import java.util.List;
import olp;
import oof;
import oog;
import ooh;

public class ReadInJoyCommentPBModule$6
  implements Runnable
{
  public ReadInJoyCommentPBModule$6(oof paramoof, int paramInt, oog paramoog, ooh paramooh, CommentData paramCommentData) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("handleNewCommentList | retCode ").append(this.jdField_a_of_type_Int).append(" | hasNewNextPage ").append(this.jdField_a_of_type_Oog.jdField_a_of_type_Boolean).append(" | newPageCookie ").append(this.jdField_a_of_type_Oog.jdField_a_of_type_JavaLangString).append("| newCommentCnt ").append(this.jdField_a_of_type_Ooh.a).append(" | newCommentListSize ");
    if (this.jdField_a_of_type_Oog.jdField_a_of_type_JavaUtilList != null) {}
    for (int i = this.jdField_a_of_type_Oog.jdField_a_of_type_JavaUtilList.size();; i = 0)
    {
      QLog.d("ReadInJoyCommentPBModule", 1, i);
      if (oof.a(this.this$0) != null) {
        oof.a(this.this$0).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Oog, this.jdField_a_of_type_Ooh, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentData);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.6
 * JD-Core Version:    0.7.0.1
 */