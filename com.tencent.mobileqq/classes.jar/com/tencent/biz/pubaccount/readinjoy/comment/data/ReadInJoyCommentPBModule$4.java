package com.tencent.biz.pubaccount.readinjoy.comment.data;

import com.tencent.qphone.base.util.QLog;
import java.util.List;
import nvt;
import nyj;
import nyk;
import nyl;

public class ReadInJoyCommentPBModule$4
  implements Runnable
{
  public ReadInJoyCommentPBModule$4(nyj paramnyj, int paramInt, nyk paramnyk, nyl paramnyl, CommentData paramCommentData) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("handleFamilyCommentList | retCode ").append(this.jdField_a_of_type_Int).append(" | hasFamilyNextPage ").append(this.jdField_a_of_type_Nyk.jdField_a_of_type_Boolean).append(" | familyPageCookie ").append(this.jdField_a_of_type_Nyk.jdField_a_of_type_JavaLangString).append("| familyCommentCnt ").append(this.jdField_a_of_type_Nyl.a).append(" | familyCommentListSize ");
    if (this.jdField_a_of_type_Nyk.jdField_a_of_type_JavaUtilList != null) {}
    for (int i = this.jdField_a_of_type_Nyk.jdField_a_of_type_JavaUtilList.size();; i = 0)
    {
      QLog.d("ReadInJoyCommentPBModule", 1, i);
      if (nyj.a(this.this$0) != null) {
        nyj.a(this.this$0).c(this.jdField_a_of_type_Int, this.jdField_a_of_type_Nyk, this.jdField_a_of_type_Nyl, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentData);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.4
 * JD-Core Version:    0.7.0.1
 */