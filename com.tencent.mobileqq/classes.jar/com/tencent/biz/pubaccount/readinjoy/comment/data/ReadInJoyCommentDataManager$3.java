package com.tencent.biz.pubaccount.readinjoy.comment.data;

class ReadInJoyCommentDataManager$3
  extends ReadInJoyCommentDataManager.CallbackActionJob
{
  ReadInJoyCommentDataManager$3(ReadInJoyCommentDataManager paramReadInJoyCommentDataManager)
  {
    super(paramReadInJoyCommentDataManager, null);
  }
  
  void a(ReadInJoyCommentDataManager.OnDataChangeListener paramOnDataChangeListener)
  {
    paramOnDataChangeListener.onCommentListLoad(1, true, this.a.c(), ReadInJoyCommentDataManager.c(this.a), 6, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.3
 * JD-Core Version:    0.7.0.1
 */