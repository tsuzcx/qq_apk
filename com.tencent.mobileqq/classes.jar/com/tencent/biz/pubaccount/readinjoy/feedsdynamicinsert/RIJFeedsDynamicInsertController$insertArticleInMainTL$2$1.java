package com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert;

import com.tencent.biz.pubaccount.readinjoy.feedsinsert.RIJFeedsInsertController.IInsertArticleCallback;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/RIJFeedsDynamicInsertController$insertArticleInMainTL$2$1", "Lcom/tencent/biz/pubaccount/readinjoy/feedsinsert/RIJFeedsInsertController$IInsertArticleCallback;", "insertArticle", "", "articleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJFeedsDynamicInsertController$insertArticleInMainTL$2$1
  implements RIJFeedsInsertController.IInsertArticleCallback
{
  public void a(@Nullable BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo != null)
    {
      Object localObject = this.a.a;
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (Intrinsics.areEqual(((ArticleInfo)((Iterator)localObject).next()).innerUniqueID, paramBaseArticleInfo.innerUniqueID)) {
            RIJFeedsDynamicInsertController.a.a(paramBaseArticleInfo);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertController.insertArticleInMainTL.2.1
 * JD-Core Version:    0.7.0.1
 */