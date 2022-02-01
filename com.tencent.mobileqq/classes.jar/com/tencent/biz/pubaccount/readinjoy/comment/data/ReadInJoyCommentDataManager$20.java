package com.tencent.biz.pubaccount.readinjoy.comment.data;

import java.util.List;

class ReadInJoyCommentDataManager$20
  extends ReadInJoyCommentDataManager.CallbackActionJob
{
  ReadInJoyCommentDataManager$20(ReadInJoyCommentDataManager paramReadInJoyCommentDataManager, boolean paramBoolean1, List paramList, boolean paramBoolean2, int paramInt)
  {
    super(paramReadInJoyCommentDataManager, null);
  }
  
  void a(ReadInJoyCommentDataManager.OnDataChangeListener paramOnDataChangeListener)
  {
    paramOnDataChangeListener.onCommentListLoad(1, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaUtilList, this.b, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.20
 * JD-Core Version:    0.7.0.1
 */