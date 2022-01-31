package com.tencent.biz.pubaccount.readinjoy.comment.data;

import com.tencent.qphone.base.util.QLog;
import java.util.List;
import nvt;
import nyj;
import nyk;
import nyl;

public class ReadInJoyCommentPBModule$8
  implements Runnable
{
  public ReadInJoyCommentPBModule$8(nyj paramnyj, int paramInt, nyk paramnyk, nyl paramnyl, CommentData paramCommentData) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("handleHotCommentList | retCode ").append(this.jdField_a_of_type_Int).append(" | hasHotNextPage ").append(this.jdField_a_of_type_Nyk.jdField_a_of_type_Boolean).append(" | hotPageCookie ").append(this.jdField_a_of_type_Nyk.jdField_a_of_type_JavaLangString).append("| HotCommentCnt ");
    if (this.jdField_a_of_type_Nyk.jdField_a_of_type_JavaUtilList != null) {}
    for (int i = this.jdField_a_of_type_Nyk.jdField_a_of_type_JavaUtilList.size();; i = 0)
    {
      QLog.d("ReadInJoyCommentPBModule", 1, i);
      if (nyj.a(this.this$0) != null) {
        nyj.a(this.this$0).b(this.jdField_a_of_type_Int, this.jdField_a_of_type_Nyk, this.jdField_a_of_type_Nyl, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentData);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.8
 * JD-Core Version:    0.7.0.1
 */