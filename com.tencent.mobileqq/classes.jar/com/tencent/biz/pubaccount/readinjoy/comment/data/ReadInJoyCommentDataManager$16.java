package com.tencent.biz.pubaccount.readinjoy.comment.data;

import com.tencent.biz.pubaccount.readinjoy.comment.helper.CreateCommentResult;
import com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper;
import com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper.RIJCreateCommentObserver;
import com.tencent.util.LongSparseArray;
import com.tencent.util.Pair;
import org.jetbrains.annotations.NotNull;

class ReadInJoyCommentDataManager$16
  implements RIJCommentNetworkHelper.RIJCreateCommentObserver
{
  ReadInJoyCommentDataManager$16(ReadInJoyCommentDataManager paramReadInJoyCommentDataManager, String paramString, BaseCommentData paramBaseCommentData) {}
  
  public void a(@NotNull CreateCommentResult paramCreateCommentResult)
  {
    if (paramCreateCommentResult.jdField_a_of_type_Long != -1L) {
      ReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager).b(paramCreateCommentResult.jdField_a_of_type_Long, new Pair(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData));
    }
    if (paramCreateCommentResult.b) {
      ReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager, paramCreateCommentResult);
    }
    for (;;)
    {
      if (!paramCreateCommentResult.jdField_a_of_type_Boolean) {
        RIJCommentNetworkHelper.a(paramCreateCommentResult.jdField_a_of_type_Int);
      }
      return;
      ReadInJoyCommentDataManager.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager, paramCreateCommentResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.16
 * JD-Core Version:    0.7.0.1
 */