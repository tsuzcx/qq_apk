package com.tencent.biz.pubaccount.readinjoy.rebuild;

import android.content.Context;
import com.tencent.mobileqq.app.face.FaceDecoder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qth;
import slt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/biz/pubaccount/readinjoy/rebuild/FeedItemCellTypeUgcImageSocial;", "context", "Landroid/content/Context;", "faceDecoder", "Lcom/tencent/mobileqq/app/face/FaceDecoder;", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;", "invoke"}, k=3, mv={1, 1, 16})
public final class CellFactory$defaultFeedItemCellMap$70
  extends Lambda
  implements Function3<Context, FaceDecoder, slt, qth>
{
  public static final 70 INSTANCE = new 70();
  
  CellFactory$defaultFeedItemCellMap$70()
  {
    super(3);
  }
  
  @NotNull
  public final qth invoke(@NotNull Context paramContext, @Nullable FaceDecoder paramFaceDecoder, @Nullable slt paramslt)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return new qth(paramContext, paramFaceDecoder, paramslt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.CellFactory.defaultFeedItemCellMap.70
 * JD-Core Version:    0.7.0.1
 */