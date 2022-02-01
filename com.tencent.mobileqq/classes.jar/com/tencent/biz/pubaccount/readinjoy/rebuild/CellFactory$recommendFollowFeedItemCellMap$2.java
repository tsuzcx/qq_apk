package com.tencent.biz.pubaccount.readinjoy.rebuild;

import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/biz/pubaccount/readinjoy/rebuild/FeedItemCellTypeRecommendFollow;", "Landroid/view/View;", "context", "Landroid/content/Context;", "faceDecoder", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;", "clazz", "Ljava/lang/Class;", "invoke"}, k=3, mv={1, 1, 16})
final class CellFactory$recommendFollowFeedItemCellMap$2
  extends Lambda
  implements Function4<Context, IFaceDecoder, ReadInJoyBaseAdapter, Class<? extends View>, FeedItemCellTypeRecommendFollow<? extends View>>
{
  public static final 2 INSTANCE = new 2();
  
  CellFactory$recommendFollowFeedItemCellMap$2()
  {
    super(4);
  }
  
  @NotNull
  public final FeedItemCellTypeRecommendFollow<? extends View> invoke(@NotNull Context paramContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @NotNull Class<? extends View> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramClass, "clazz");
    return new FeedItemCellTypeRecommendFollow(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter, paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.CellFactory.recommendFollowFeedItemCellMap.2
 * JD-Core Version:    0.7.0.1
 */