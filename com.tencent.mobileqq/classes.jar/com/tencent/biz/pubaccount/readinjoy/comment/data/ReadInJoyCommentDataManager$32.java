package com.tencent.biz.pubaccount.readinjoy.comment.data;

class ReadInJoyCommentDataManager$32
  extends ReadInJoyCommentDataManager.CallbackActionJob
{
  ReadInJoyCommentDataManager$32(ReadInJoyCommentDataManager paramReadInJoyCommentDataManager, boolean paramBoolean, BaseCommentData paramBaseCommentData, int paramInt1, int paramInt2)
  {
    super(paramReadInJoyCommentDataManager, null);
  }
  
  void a(ReadInJoyCommentDataManager.OnDataChangeListener paramOnDataChangeListener)
  {
    paramOnDataChangeListener.onCommentLikeOrDislike(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData, this.jdField_a_of_type_Int, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.32
 * JD-Core Version:    0.7.0.1
 */