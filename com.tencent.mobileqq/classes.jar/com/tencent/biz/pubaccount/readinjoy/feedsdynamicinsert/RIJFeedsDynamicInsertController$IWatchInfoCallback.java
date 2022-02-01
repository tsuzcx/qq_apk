package com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert;

import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data.RIJFeedsInsertAction;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/RIJFeedsDynamicInsertController$IWatchInfoCallback;", "", "getWatchInfo", "", "rowKey", "", "action", "Lcom/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/data/RIJFeedsInsertAction;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface RIJFeedsDynamicInsertController$IWatchInfoCallback
{
  public abstract void a(@Nullable String paramString, @NotNull RIJFeedsInsertAction paramRIJFeedsInsertAction);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertController.IWatchInfoCallback
 * JD-Core Version:    0.7.0.1
 */