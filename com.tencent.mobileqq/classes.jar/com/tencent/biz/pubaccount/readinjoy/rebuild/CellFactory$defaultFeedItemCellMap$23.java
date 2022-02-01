package com.tencent.biz.pubaccount.readinjoy.rebuild;

import android.content.Context;
import com.tencent.mobileqq.app.face.FaceDecoder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rcb;
import szd;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/biz/pubaccount/readinjoy/rebuild/FeedItemCellTypeBigSocial;", "context", "Landroid/content/Context;", "faceDecoder", "Lcom/tencent/mobileqq/app/face/FaceDecoder;", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;", "invoke"}, k=3, mv={1, 1, 16})
public final class CellFactory$defaultFeedItemCellMap$23
  extends Lambda
  implements Function3<Context, FaceDecoder, szd, rcb>
{
  public static final 23 INSTANCE = new 23();
  
  CellFactory$defaultFeedItemCellMap$23()
  {
    super(3);
  }
  
  @NotNull
  public final rcb invoke(@NotNull Context paramContext, @Nullable FaceDecoder paramFaceDecoder, @Nullable szd paramszd)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return new rcb(paramContext, paramFaceDecoder, paramszd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.CellFactory.defaultFeedItemCellMap.23
 * JD-Core Version:    0.7.0.1
 */