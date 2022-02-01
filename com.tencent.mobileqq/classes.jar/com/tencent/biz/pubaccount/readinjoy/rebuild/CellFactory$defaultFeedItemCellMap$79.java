package com.tencent.biz.pubaccount.readinjoy.rebuild;

import android.content.Context;
import aoof;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qls;
import sel;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/biz/pubaccount/readinjoy/rebuild/FeedItemCellTypePolymericSmallVideo;", "context", "Landroid/content/Context;", "faceDecoder", "Lcom/tencent/mobileqq/app/face/FaceDecoder;", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;", "invoke"}, k=3, mv={1, 1, 16})
public final class CellFactory$defaultFeedItemCellMap$79
  extends Lambda
  implements Function3<Context, aoof, sel, qls>
{
  public static final 79 INSTANCE = new 79();
  
  CellFactory$defaultFeedItemCellMap$79()
  {
    super(3);
  }
  
  @NotNull
  public final qls invoke(@NotNull Context paramContext, @Nullable aoof paramaoof, @Nullable sel paramsel)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return new qls(paramContext, paramaoof, paramsel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.CellFactory.defaultFeedItemCellMap.79
 * JD-Core Version:    0.7.0.1
 */