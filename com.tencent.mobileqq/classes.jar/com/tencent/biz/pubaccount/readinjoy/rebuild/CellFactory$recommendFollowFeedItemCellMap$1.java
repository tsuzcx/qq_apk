package com.tencent.biz.pubaccount.readinjoy.rebuild;

import android.content.Context;
import android.view.View;
import aoof;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qly;
import sel;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/biz/pubaccount/readinjoy/rebuild/FeedItemCellTypeRecommendFollow;", "Landroid/view/View;", "context", "Landroid/content/Context;", "faceDecoder", "Lcom/tencent/mobileqq/app/face/FaceDecoder;", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;", "clazz", "Ljava/lang/Class;", "invoke"}, k=3, mv={1, 1, 16})
public final class CellFactory$recommendFollowFeedItemCellMap$1
  extends Lambda
  implements Function4<Context, aoof, sel, Class<? extends View>, qly<? extends View>>
{
  public static final 1 INSTANCE = new 1();
  
  CellFactory$recommendFollowFeedItemCellMap$1()
  {
    super(4);
  }
  
  @NotNull
  public final qly<? extends View> invoke(@NotNull Context paramContext, @Nullable aoof paramaoof, @Nullable sel paramsel, @NotNull Class<? extends View> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramClass, "clazz");
    return new qly(paramContext, paramaoof, paramsel, paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.CellFactory.recommendFollowFeedItemCellMap.1
 * JD-Core Version:    0.7.0.1
 */