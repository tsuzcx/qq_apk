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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/biz/pubaccount/readinjoy/rebuild/FeedItemCellTypeGalleryPGC;", "context", "Landroid/content/Context;", "faceDecoder", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;", "invoke"}, k=3, mv={1, 1, 16})
final class CellFactory$defaultFeedItemCellMap$59
  extends Lambda
  implements Function3<Context, IFaceDecoder, ReadInJoyBaseAdapter, FeedItemCellTypeGalleryPGC>
{
  public static final 59 INSTANCE = new 59();
  
  CellFactory$defaultFeedItemCellMap$59()
  {
    super(3);
  }
  
  @NotNull
  public final FeedItemCellTypeGalleryPGC invoke(@NotNull Context paramContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return new FeedItemCellTypeGalleryPGC(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.CellFactory.defaultFeedItemCellMap.59
 * JD-Core Version:    0.7.0.1
 */