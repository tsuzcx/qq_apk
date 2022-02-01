package com.tencent.biz.pubaccount.readinjoy.comment.data;

import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ReadInJoyCommentPBModule$8
  implements Runnable
{
  ReadInJoyCommentPBModule$8(ReadInJoyCommentPBModule paramReadInJoyCommentPBModule, int paramInt, ReadInJoyCommentPBModule.ResponseCommentInfo paramResponseCommentInfo, ReadInJoyCommentPBModule.ResponseExtraInfo paramResponseExtraInfo, CommentData paramCommentData) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("handleHotCommentList | retCode ").append(this.jdField_a_of_type_Int).append(" | hasHotNextPage ").append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule$ResponseCommentInfo.jdField_a_of_type_Boolean).append(" | hotPageCookie ").append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule$ResponseCommentInfo.jdField_a_of_type_JavaLangString).append("| HotCommentCnt ");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule$ResponseCommentInfo.jdField_a_of_type_JavaUtilList != null) {}
    for (int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule$ResponseCommentInfo.jdField_a_of_type_JavaUtilList.size();; i = 0)
    {
      QLog.d("ReadInJoyCommentPBModule", 1, i);
      if (ReadInJoyCommentPBModule.a(this.this$0) != null) {
        ReadInJoyCommentPBModule.a(this.this$0).b(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule$ResponseCommentInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule$ResponseExtraInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentData);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.8
 * JD-Core Version:    0.7.0.1
 */