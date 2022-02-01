package com.tencent.biz.pubaccount.readinjoy.rebuild;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.app.face.FaceDecoder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import reg;
import szd;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/biz/pubaccount/readinjoy/rebuild/FeedItemCellTypeRecommendFollow;", "Landroid/view/View;", "context", "Landroid/content/Context;", "faceDecoder", "Lcom/tencent/mobileqq/app/face/FaceDecoder;", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;", "clazz", "Ljava/lang/Class;", "invoke"}, k=3, mv={1, 1, 16})
public final class CellFactory$recommendFollowFeedItemCellMap$2
  extends Lambda
  implements Function4<Context, FaceDecoder, szd, Class<? extends View>, reg<? extends View>>
{
  public static final 2 INSTANCE = new 2();
  
  CellFactory$recommendFollowFeedItemCellMap$2()
  {
    super(4);
  }
  
  @NotNull
  public final reg<? extends View> invoke(@NotNull Context paramContext, @Nullable FaceDecoder paramFaceDecoder, @Nullable szd paramszd, @NotNull Class<? extends View> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramClass, "clazz");
    return new reg(paramContext, paramFaceDecoder, paramszd, paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.CellFactory.recommendFollowFeedItemCellMap.2
 * JD-Core Version:    0.7.0.1
 */