package com.tencent.biz.pubaccount.readinjoy.comment.data;

import com.tencent.biz.pubaccount.readinjoy.comment.helper.CreateCommentResult;
import com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper;
import com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper.RIJCreateCommentObserver;
import org.jetbrains.annotations.NotNull;

class ReadInJoyCommentDataManager$17
  implements RIJCommentNetworkHelper.RIJCreateCommentObserver
{
  ReadInJoyCommentDataManager$17(ReadInJoyCommentDataManager paramReadInJoyCommentDataManager) {}
  
  public void a(@NotNull CreateCommentResult paramCreateCommentResult)
  {
    if (paramCreateCommentResult.b) {
      ReadInJoyCommentDataManager.a(this.a, paramCreateCommentResult);
    }
    for (;;)
    {
      if (!paramCreateCommentResult.jdField_a_of_type_Boolean) {
        RIJCommentNetworkHelper.a(paramCreateCommentResult.jdField_a_of_type_Int);
      }
      return;
      ReadInJoyCommentDataManager.b(this.a, paramCreateCommentResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.17
 * JD-Core Version:    0.7.0.1
 */