package com.tencent.biz.pubaccount.readinjoy.comment.data;

import com.tencent.biz.pubaccount.readinjoy.comment.helper.CreateCommentResult;

class ReadInJoyCommentDataManager$33
  extends ReadInJoyCommentDataManager.CallbackActionJob
{
  ReadInJoyCommentDataManager$33(ReadInJoyCommentDataManager paramReadInJoyCommentDataManager, CreateCommentResult paramCreateCommentResult)
  {
    super(paramReadInJoyCommentDataManager, null);
  }
  
  void a(ReadInJoyCommentDataManager.OnDataChangeListener paramOnDataChangeListener)
  {
    paramOnDataChangeListener.onCommentCreate(false, null, null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHelperCreateCommentResult.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.33
 * JD-Core Version:    0.7.0.1
 */