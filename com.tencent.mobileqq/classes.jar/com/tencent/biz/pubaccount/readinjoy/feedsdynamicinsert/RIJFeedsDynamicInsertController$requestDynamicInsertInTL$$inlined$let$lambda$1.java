package com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert;

import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data.RIJFeedsInsertAction;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data.RIJFeedsInsertArticle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/RIJFeedsDynamicInsertController$requestDynamicInsertInTL$1$1", "Lcom/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/RIJFeedsDynamicInsertModule$Companion$IFeedsDynamicInsertCallback;", "insert", "", "feedsInsertArticle", "Lcom/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/data/RIJFeedsInsertArticle;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJFeedsDynamicInsertController$requestDynamicInsertInTL$$inlined$let$lambda$1
  implements RIJFeedsDynamicInsertModule.Companion.IFeedsDynamicInsertCallback
{
  RIJFeedsDynamicInsertController$requestDynamicInsertInTL$$inlined$let$lambda$1(String paramString, RIJFeedsDynamicInsertRecordAction.ActionType paramActionType, int paramInt1, int paramInt2, RIJFeedsInsertAction paramRIJFeedsInsertAction) {}
  
  public void a(@Nullable RIJFeedsInsertArticle paramRIJFeedsInsertArticle)
  {
    Object localObject2 = null;
    Object localObject3 = new StringBuilder().append("reqSource: 1, rowkey: ").append(this.jdField_a_of_type_JavaLangString).append(", articles from server: ");
    if (paramRIJFeedsInsertArticle != null)
    {
      localObject1 = paramRIJFeedsInsertArticle.b();
      QLog.d("RIJFeedsDynamicInsertController", 1, (String)localObject1);
      localObject3 = RIJFeedsDynamicInsertController.a;
      if (paramRIJFeedsInsertArticle == null) {
        break label156;
      }
      localObject1 = paramRIJFeedsInsertArticle.a();
      if (localObject1 == null) {
        break label156;
      }
    }
    label156:
    for (Object localObject1 = (ArrayList)((SortedMap)localObject1).get(new RIJFeedsInsertAction(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedsdynamicinsertRIJFeedsDynamicInsertRecordAction$ActionType, this.jdField_a_of_type_Int, 0, this.b));; localObject1 = null)
    {
      List localList = (List)localObject1;
      String str = this.jdField_a_of_type_JavaLangString;
      if (str == null) {
        Intrinsics.throwNpe();
      }
      RIJFeedsInsertAction localRIJFeedsInsertAction = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedsdynamicinsertDataRIJFeedsInsertAction;
      localObject1 = localObject2;
      if (paramRIJFeedsInsertArticle != null) {
        localObject1 = paramRIJFeedsInsertArticle.a();
      }
      ((RIJFeedsDynamicInsertController)localObject3).a(localList, 1, str, localRIJFeedsInsertAction, (String)localObject1);
      return;
      localObject1 = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertController.requestDynamicInsertInTL..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */