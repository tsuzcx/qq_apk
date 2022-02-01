package com.tencent.biz.pubaccount.readinjoy.rebuild;

import android.content.Context;
import com.tencent.mobileqq.app.face.FaceDecoder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qrs;
import slt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/biz/pubaccount/readinjoy/rebuild/FeedItemCellTypePolymeric;", "context", "Landroid/content/Context;", "faceDecoder", "Lcom/tencent/mobileqq/app/face/FaceDecoder;", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;", "invoke"}, k=3, mv={1, 1, 16})
public final class CellFactory$defaultFeedItemCellMap$72
  extends Lambda
  implements Function3<Context, FaceDecoder, slt, qrs>
{
  public static final 72 INSTANCE = new 72();
  
  CellFactory$defaultFeedItemCellMap$72()
  {
    super(3);
  }
  
  @NotNull
  public final qrs invoke(@NotNull Context paramContext, @Nullable FaceDecoder paramFaceDecoder, @Nullable slt paramslt)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return new qrs(paramContext, paramFaceDecoder, paramslt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.CellFactory.defaultFeedItemCellMap.72
 * JD-Core Version:    0.7.0.1
 */