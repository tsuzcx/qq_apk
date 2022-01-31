package com.tencent.biz.pubaccount.readinjoy.comment.data;

import com.tencent.qphone.base.util.QLog;
import java.util.List;
import ohb;
import ojr;
import ojs;
import ojt;

public class ReadInJoyCommentPBModule$6
  implements Runnable
{
  public ReadInJoyCommentPBModule$6(ojr paramojr, int paramInt, ojs paramojs, ojt paramojt, CommentData paramCommentData) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("handleNewCommentList | retCode ").append(this.jdField_a_of_type_Int).append(" | hasNewNextPage ").append(this.jdField_a_of_type_Ojs.jdField_a_of_type_Boolean).append(" | newPageCookie ").append(this.jdField_a_of_type_Ojs.jdField_a_of_type_JavaLangString).append("| newCommentCnt ").append(this.jdField_a_of_type_Ojt.a).append(" | newCommentListSize ");
    if (this.jdField_a_of_type_Ojs.jdField_a_of_type_JavaUtilList != null) {}
    for (int i = this.jdField_a_of_type_Ojs.jdField_a_of_type_JavaUtilList.size();; i = 0)
    {
      QLog.d("ReadInJoyCommentPBModule", 1, i);
      if (ojr.a(this.this$0) != null) {
        ojr.a(this.this$0).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Ojs, this.jdField_a_of_type_Ojt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentData);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.6
 * JD-Core Version:    0.7.0.1
 */