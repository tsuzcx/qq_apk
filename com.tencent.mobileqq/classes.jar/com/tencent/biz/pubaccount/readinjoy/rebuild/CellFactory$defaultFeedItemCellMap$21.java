package com.tencent.biz.pubaccount.readinjoy.rebuild;

import android.content.Context;
import aobu;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qtn;
import snh;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/biz/pubaccount/readinjoy/rebuild/FeedItemCellTypeSmallSocial;", "context", "Landroid/content/Context;", "faceDecoder", "Lcom/tencent/mobileqq/app/face/FaceDecoder;", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;", "invoke"}, k=3, mv={1, 1, 16})
public final class CellFactory$defaultFeedItemCellMap$21
  extends Lambda
  implements Function3<Context, aobu, snh, qtn>
{
  public static final 21 INSTANCE = new 21();
  
  CellFactory$defaultFeedItemCellMap$21()
  {
    super(3);
  }
  
  @NotNull
  public final qtn invoke(@NotNull Context paramContext, @Nullable aobu paramaobu, @Nullable snh paramsnh)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return new qtn(paramContext, paramaobu, paramsnh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.CellFactory.defaultFeedItemCellMap.21
 * JD-Core Version:    0.7.0.1
 */