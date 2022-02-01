package com.tencent.biz.pubaccount.weishi_new.ui.videotransition;

import android.view.View;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/ui/videotransition/WSAnimConfig;", "", "valuePairMap", "Ljava/util/HashMap;", "", "Lkotlin/Pair;", "", "Lkotlin/collections/HashMap;", "rootView", "Landroid/view/View;", "ivCoverForAnim", "(Ljava/util/HashMap;Landroid/view/View;Landroid/view/View;)V", "getIvCoverForAnim", "()Landroid/view/View;", "getRootView", "getEndValue", "valueType", "getStartValue", "Builder", "Companion", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSAnimConfig
{
  public static final WSAnimConfig.Companion a = new WSAnimConfig.Companion(null);
  private final HashMap<Integer, Pair<Float, Float>> b;
  @NotNull
  private final View c;
  @Nullable
  private final View d;
  
  public WSAnimConfig(@NotNull HashMap<Integer, Pair<Float, Float>> paramHashMap, @NotNull View paramView1, @Nullable View paramView2)
  {
    this.b = paramHashMap;
    this.c = paramView1;
    this.d = paramView2;
  }
  
  public final float a(int paramInt)
  {
    Object localObject = this.b.get(Integer.valueOf(paramInt));
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    return ((Number)((Pair)localObject).getFirst()).floatValue();
  }
  
  @NotNull
  public final View a()
  {
    return this.c;
  }
  
  public final float b(int paramInt)
  {
    Object localObject = this.b.get(Integer.valueOf(paramInt));
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    return ((Number)((Pair)localObject).getSecond()).floatValue();
  }
  
  @Nullable
  public final View b()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.ui.videotransition.WSAnimConfig
 * JD-Core Version:    0.7.0.1
 */