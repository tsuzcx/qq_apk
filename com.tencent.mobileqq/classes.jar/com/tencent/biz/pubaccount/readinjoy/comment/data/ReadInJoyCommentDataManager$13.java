package com.tencent.biz.pubaccount.readinjoy.comment.data;

import java.util.ArrayList;

class ReadInJoyCommentDataManager$13
  extends ReadInJoyCommentDataManager.CallbackActionJob
{
  ReadInJoyCommentDataManager$13(ReadInJoyCommentDataManager paramReadInJoyCommentDataManager, int paramInt)
  {
    super(paramReadInJoyCommentDataManager, null);
  }
  
  void a(ReadInJoyCommentDataManager.OnDataChangeListener paramOnDataChangeListener)
  {
    if (this.jdField_a_of_type_Int == 1) {
      paramOnDataChangeListener.onCommentListLoad(2, false, new ArrayList(), false, 4, 4);
    }
    while (this.jdField_a_of_type_Int != 2) {
      return;
    }
    paramOnDataChangeListener.onCommentLoadMore(2, false, new ArrayList(), false, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.13
 * JD-Core Version:    0.7.0.1
 */