package com.tencent.biz.pubaccount.readinjoy.comment.data;

import com.tencent.qphone.base.util.QLog;
import java.util.List;
import osl;
import ovh;
import ovk;
import ovl;

public class ReadInJoyCommentPBModule$4
  implements Runnable
{
  public ReadInJoyCommentPBModule$4(ovh paramovh, int paramInt, ovk paramovk, ovl paramovl, CommentData paramCommentData) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("handleFamilyCommentList | retCode ").append(this.jdField_a_of_type_Int).append(" | hasFamilyNextPage ").append(this.jdField_a_of_type_Ovk.jdField_a_of_type_Boolean).append(" | familyPageCookie ").append(this.jdField_a_of_type_Ovk.jdField_a_of_type_JavaLangString).append("| familyCommentCnt ").append(this.jdField_a_of_type_Ovl.a).append(" | familyCommentListSize ");
    if (this.jdField_a_of_type_Ovk.jdField_a_of_type_JavaUtilList != null) {}
    for (int i = this.jdField_a_of_type_Ovk.jdField_a_of_type_JavaUtilList.size();; i = 0)
    {
      QLog.d("ReadInJoyCommentPBModule", 1, i);
      if (ovh.a(this.this$0) != null) {
        ovh.a(this.this$0).c(this.jdField_a_of_type_Int, this.jdField_a_of_type_Ovk, this.jdField_a_of_type_Ovl, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentData);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.4
 * JD-Core Version:    0.7.0.1
 */