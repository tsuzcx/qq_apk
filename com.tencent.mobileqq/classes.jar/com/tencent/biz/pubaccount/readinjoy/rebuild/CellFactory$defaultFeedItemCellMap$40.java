package com.tencent.biz.pubaccount.readinjoy.rebuild;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/biz/pubaccount/readinjoy/rebuild/FeedItemCellTypeRecommendBig;", "context", "Landroid/content/Context;", "faceDecoder", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;", "invoke"}, k=3, mv={1, 1, 16})
final class CellFactory$defaultFeedItemCellMap$40
  extends Lambda
  implements Function3<Context, IFaceDecoder, ReadInJoyBaseAdapter, FeedItemCellTypeRecommendBig>
{
  public static final 40 INSTANCE = new 40();
  
  CellFactory$defaultFeedItemCellMap$40()
  {
    super(3);
  }
  
  @NotNull
  public final FeedItemCellTypeRecommendBig invoke(@NotNull Context paramContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return new FeedItemCellTypeRecommendBig(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.CellFactory.defaultFeedItemCellMap.40
 * JD-Core Version:    0.7.0.1
 */