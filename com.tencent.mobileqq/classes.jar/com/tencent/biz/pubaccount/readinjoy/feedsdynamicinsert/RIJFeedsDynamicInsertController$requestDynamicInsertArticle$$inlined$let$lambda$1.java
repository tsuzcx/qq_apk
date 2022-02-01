package com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert;

import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data.RIJFeedsInsertAction;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data.RIJFeedsInsertArticle;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/RIJFeedsDynamicInsertController$requestDynamicInsertArticle$1$1", "Lcom/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/RIJFeedsDynamicInsertModule$Companion$IFeedsDynamicInsertCallback;", "insert", "", "feedsInsertArticle", "Lcom/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/data/RIJFeedsInsertArticle;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJFeedsDynamicInsertController$requestDynamicInsertArticle$$inlined$let$lambda$1
  implements RIJFeedsDynamicInsertModule.Companion.IFeedsDynamicInsertCallback
{
  RIJFeedsDynamicInsertController$requestDynamicInsertArticle$$inlined$let$lambda$1(int paramInt, String paramString, RIJFeedsInsertAction paramRIJFeedsInsertAction, RIJFeedsDynamicInsertController.IWatchInfoCallback paramIWatchInfoCallback) {}
  
  public void a(@Nullable RIJFeedsInsertArticle paramRIJFeedsInsertArticle)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("reqSource: ").append(this.jdField_a_of_type_Int).append(", rowkey: ").append(this.jdField_a_of_type_JavaLangString).append(", articles from server: ");
    if (paramRIJFeedsInsertArticle != null) {}
    for (String str = paramRIJFeedsInsertArticle.b();; str = null)
    {
      QLog.d("RIJFeedsDynamicInsertController", 1, str);
      if (RIJFeedsDynamicInsertController.a(RIJFeedsDynamicInsertController.a, paramRIJFeedsInsertArticle, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedsdynamicinsertDataRIJFeedsInsertAction))
      {
        QLog.d("RIJFeedsDynamicInsertController", 1, "requestDynamicInsertArticle needrecord");
        RIJFeedsDynamicInsertRecordAction.a.a().a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedsdynamicinsertDataRIJFeedsInsertAction.a());
      }
      RIJFeedsDynamicInsertController.a(RIJFeedsDynamicInsertController.a, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedsdynamicinsertRIJFeedsDynamicInsertController$IWatchInfoCallback, paramRIJFeedsInsertArticle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertController.requestDynamicInsertArticle..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */