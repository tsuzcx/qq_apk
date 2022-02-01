package com.tencent.biz.pubaccount.readinjoy.comment.data;

import com.tencent.qphone.base.util.QLog;
import java.util.List;
import ozw;
import pcq;
import pcs;
import pct;

public class ReadInJoyCommentPBModule$4
  implements Runnable
{
  public ReadInJoyCommentPBModule$4(pcq parampcq, int paramInt, pcs parampcs, pct parampct, CommentData paramCommentData) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("handleFamilyCommentList | retCode ").append(this.jdField_a_of_type_Int).append(" | hasFamilyNextPage ").append(this.jdField_a_of_type_Pcs.jdField_a_of_type_Boolean).append(" | familyPageCookie ").append(this.jdField_a_of_type_Pcs.jdField_a_of_type_JavaLangString).append("| familyCommentCnt ").append(this.jdField_a_of_type_Pct.a).append(" | familyCommentListSize ");
    if (this.jdField_a_of_type_Pcs.jdField_a_of_type_JavaUtilList != null) {}
    for (int i = this.jdField_a_of_type_Pcs.jdField_a_of_type_JavaUtilList.size();; i = 0)
    {
      QLog.d("ReadInJoyCommentPBModule", 1, i);
      if (pcq.a(this.this$0) != null) {
        pcq.a(this.this$0).c(this.jdField_a_of_type_Int, this.jdField_a_of_type_Pcs, this.jdField_a_of_type_Pct, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentData);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.4
 * JD-Core Version:    0.7.0.1
 */