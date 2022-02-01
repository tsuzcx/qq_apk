package com.tencent.biz.pubaccount.readinjoy.rebuild;

import android.content.Context;
import com.tencent.mobileqq.app.face.FaceDecoder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rej;
import szd;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/biz/pubaccount/readinjoy/rebuild/FeedItemCellTypeSmallSocial;", "context", "Landroid/content/Context;", "faceDecoder", "Lcom/tencent/mobileqq/app/face/FaceDecoder;", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;", "invoke"}, k=3, mv={1, 1, 16})
public final class CellFactory$defaultFeedItemCellMap$19
  extends Lambda
  implements Function3<Context, FaceDecoder, szd, rej>
{
  public static final 19 INSTANCE = new 19();
  
  CellFactory$defaultFeedItemCellMap$19()
  {
    super(3);
  }
  
  @NotNull
  public final rej invoke(@NotNull Context paramContext, @Nullable FaceDecoder paramFaceDecoder, @Nullable szd paramszd)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return new rej(paramContext, paramFaceDecoder, paramszd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.CellFactory.defaultFeedItemCellMap.19
 * JD-Core Version:    0.7.0.1
 */