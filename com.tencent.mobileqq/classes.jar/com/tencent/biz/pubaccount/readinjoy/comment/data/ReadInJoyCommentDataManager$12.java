package com.tencent.biz.pubaccount.readinjoy.comment.data;

import java.util.ArrayList;

class ReadInJoyCommentDataManager$12
  extends ReadInJoyCommentDataManager.CallbackActionJob
{
  ReadInJoyCommentDataManager$12(ReadInJoyCommentDataManager paramReadInJoyCommentDataManager, int paramInt)
  {
    super(paramReadInJoyCommentDataManager, null);
  }
  
  void a(ReadInJoyCommentDataManager.OnDataChangeListener paramOnDataChangeListener)
  {
    if (this.jdField_a_of_type_Int == 1) {
      paramOnDataChangeListener.onCommentListLoad(1, false, new ArrayList(), false, 6, 6);
    }
    while (this.jdField_a_of_type_Int != 2) {
      return;
    }
    paramOnDataChangeListener.onCommentLoadMore(1, false, new ArrayList(), false, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.12
 * JD-Core Version:    0.7.0.1
 */