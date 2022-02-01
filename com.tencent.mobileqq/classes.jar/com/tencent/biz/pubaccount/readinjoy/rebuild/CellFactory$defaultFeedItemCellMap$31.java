package com.tencent.biz.pubaccount.readinjoy.rebuild;

import android.content.Context;
import com.tencent.mobileqq.app.face.FaceDecoder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rfl;
import szd;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/biz/pubaccount/readinjoy/rebuild/FeedItemCellTypeUgcImage;", "context", "Landroid/content/Context;", "faceDecoder", "Lcom/tencent/mobileqq/app/face/FaceDecoder;", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;", "invoke"}, k=3, mv={1, 1, 16})
public final class CellFactory$defaultFeedItemCellMap$31
  extends Lambda
  implements Function3<Context, FaceDecoder, szd, rfl>
{
  public static final 31 INSTANCE = new 31();
  
  CellFactory$defaultFeedItemCellMap$31()
  {
    super(3);
  }
  
  @NotNull
  public final rfl invoke(@NotNull Context paramContext, @Nullable FaceDecoder paramFaceDecoder, @Nullable szd paramszd)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return new rfl(paramContext, paramFaceDecoder, paramszd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.CellFactory.defaultFeedItemCellMap.31
 * JD-Core Version:    0.7.0.1
 */