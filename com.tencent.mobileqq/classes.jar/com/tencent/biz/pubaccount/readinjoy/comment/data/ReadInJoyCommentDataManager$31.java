package com.tencent.biz.pubaccount.readinjoy.comment.data;

class ReadInJoyCommentDataManager$31
  extends ReadInJoyCommentDataManager.CallbackActionJob
{
  ReadInJoyCommentDataManager$31(ReadInJoyCommentDataManager paramReadInJoyCommentDataManager, int paramInt1, CommentViewItem paramCommentViewItem, int paramInt2)
  {
    super(paramReadInJoyCommentDataManager, null);
  }
  
  void a(ReadInJoyCommentDataManager.OnDataChangeListener paramOnDataChangeListener)
  {
    paramOnDataChangeListener.onCommentDelete(this.jdField_a_of_type_Int, true, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.31
 * JD-Core Version:    0.7.0.1
 */