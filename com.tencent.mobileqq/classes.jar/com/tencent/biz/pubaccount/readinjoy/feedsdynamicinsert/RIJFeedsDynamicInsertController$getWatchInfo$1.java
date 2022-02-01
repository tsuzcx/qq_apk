package com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert;

import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data.RIJFeedsInsertAction;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "callback", "Lcom/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/RIJFeedsDynamicInsertController$IWatchInfoCallback;", "actionArticleMap", "Ljava/util/SortedMap;", "Lcom/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/data/RIJFeedsInsertAction;", "Ljava/util/ArrayList;", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "Lkotlin/collections/ArrayList;", "invoke"}, k=3, mv={1, 1, 16})
final class RIJFeedsDynamicInsertController$getWatchInfo$1
  extends Lambda
  implements Function2<RIJFeedsDynamicInsertController.IWatchInfoCallback, SortedMap<RIJFeedsInsertAction, ArrayList<ArticleInfo>>, Unit>
{
  RIJFeedsDynamicInsertController$getWatchInfo$1(String paramString)
  {
    super(2);
  }
  
  public final void invoke(@NotNull RIJFeedsDynamicInsertController.IWatchInfoCallback paramIWatchInfoCallback, @NotNull SortedMap<RIJFeedsInsertAction, ArrayList<ArticleInfo>> paramSortedMap)
  {
    Intrinsics.checkParameterIsNotNull(paramIWatchInfoCallback, "callback");
    Intrinsics.checkParameterIsNotNull(paramSortedMap, "actionArticleMap");
    Object localObject = paramSortedMap.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramSortedMap = (RIJFeedsInsertAction)((Iterator)localObject).next();
      if (((paramSortedMap.a().getActionType() & RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_VIDEO_PLAY_PROGRESS.getActionType()) > 0) || ((paramSortedMap.a().getActionType() & RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_ARTICLE_READ_PROGRESS.getActionType()) > 0))
      {
        QLog.d("RIJFeedsDynamicInsertController", 1, "getWatchInfo: " + paramSortedMap);
        localObject = this.$rowKey;
        Intrinsics.checkExpressionValueIsNotNull(paramSortedMap, "actionKey");
        paramIWatchInfoCallback.a((String)localObject, paramSortedMap);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertController.getWatchInfo.1
 * JD-Core Version:    0.7.0.1
 */