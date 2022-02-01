package com.tencent.biz.pubaccount.readinjoy.comment.data;

import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ReadInJoyCommentPBModule$11
  implements Runnable
{
  ReadInJoyCommentPBModule$11(ReadInJoyCommentPBModule paramReadInJoyCommentPBModule, int paramInt, ReadInJoyCommentPBModule.ResponseCommentInfo paramResponseCommentInfo, String paramString, ReadInJoyCommentPBModule.ResponseExtraInfo paramResponseExtraInfo) {}
  
  public void run()
  {
    if ("handleSubCommentList | retCode " + this.jdField_a_of_type_Int + " | hasNextPage " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule$ResponseCommentInfo.jdField_a_of_type_Boolean + " | pageCookie " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule$ResponseCommentInfo.jdField_a_of_type_JavaLangString + "| subCommentListSize " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule$ResponseCommentInfo.b != null) {}
    for (int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule$ResponseCommentInfo.b.size();; i = 0)
    {
      QLog.d("ReadInJoyCommentPBModule", 2, new Object[] { Integer.valueOf(i) });
      if (ReadInJoyCommentPBModule.a(this.this$0) != null) {
        ReadInJoyCommentPBModule.a(this.this$0).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule$ResponseCommentInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule$ResponseExtraInfo);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.11
 * JD-Core Version:    0.7.0.1
 */