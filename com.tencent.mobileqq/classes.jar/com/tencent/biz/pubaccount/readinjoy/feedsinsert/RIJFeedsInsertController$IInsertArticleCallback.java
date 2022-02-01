package com.tencent.biz.pubaccount.readinjoy.feedsinsert;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/feedsinsert/RIJFeedsInsertController$IInsertArticleCallback;", "", "insertArticle", "", "articleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface RIJFeedsInsertController$IInsertArticleCallback
{
  public abstract void a(@Nullable BaseArticleInfo paramBaseArticleInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.feedsinsert.RIJFeedsInsertController.IInsertArticleCallback
 * JD-Core Version:    0.7.0.1
 */