package com.tencent.biz.pubaccount.readinjoy.comment.data;

import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ReadInJoyCommentPBModule$4
  implements Runnable
{
  ReadInJoyCommentPBModule$4(ReadInJoyCommentPBModule paramReadInJoyCommentPBModule, int paramInt, ReadInJoyCommentPBModule.ResponseCommentInfo paramResponseCommentInfo, ReadInJoyCommentPBModule.ResponseExtraInfo paramResponseExtraInfo, CommentData paramCommentData) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("handleFamilyCommentList | retCode ").append(this.jdField_a_of_type_Int).append(" | hasFamilyNextPage ").append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule$ResponseCommentInfo.jdField_a_of_type_Boolean).append(" | familyPageCookie ").append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule$ResponseCommentInfo.jdField_a_of_type_JavaLangString).append("| familyCommentCnt ").append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule$ResponseExtraInfo.a).append(" | familyCommentListSize ");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule$ResponseCommentInfo.jdField_a_of_type_JavaUtilList != null) {}
    for (int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule$ResponseCommentInfo.jdField_a_of_type_JavaUtilList.size();; i = 0)
    {
      QLog.d("ReadInJoyCommentPBModule", 1, i);
      if (ReadInJoyCommentPBModule.a(this.this$0) != null) {
        ReadInJoyCommentPBModule.a(this.this$0).c(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule$ResponseCommentInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule$ResponseExtraInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentData);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.4
 * JD-Core Version:    0.7.0.1
 */