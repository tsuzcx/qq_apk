package com.tencent.biz.pubaccount.readinjoy.comment.data;

import com.tencent.biz.pubaccount.readinjoy.model.RIJCommentReportModule.CommentReportInfo;

class ReadInJoyCommentDataManager$18
  extends ReadInJoyCommentDataManager.CallbackActionJob
{
  ReadInJoyCommentDataManager$18(ReadInJoyCommentDataManager paramReadInJoyCommentDataManager, int paramInt, boolean paramBoolean, RIJCommentReportModule.CommentReportInfo paramCommentReportInfo)
  {
    super(paramReadInJoyCommentDataManager, null);
  }
  
  void a(ReadInJoyCommentDataManager.OnDataChangeListener paramOnDataChangeListener)
  {
    paramOnDataChangeListener.onCommentReport(this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJCommentReportModule$CommentReportInfo.b(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJCommentReportModule$CommentReportInfo.c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.18
 * JD-Core Version:    0.7.0.1
 */