package com.tencent.biz.pubaccount.weishi_new.ui.videotransition;

import android.view.View;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/ui/videotransition/WSAnimConfig$Builder;", "", "()V", "ivCoverForAnim", "Landroid/view/View;", "rootView", "valuePairMap", "Ljava/util/HashMap;", "", "Lkotlin/Pair;", "", "Lkotlin/collections/HashMap;", "build", "Lcom/tencent/biz/pubaccount/weishi_new/ui/videotransition/WSAnimConfig;", "setCoverViewForAnim", "setRootView", "setValue", "valueType", "start", "end", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSAnimConfig$Builder
{
  private View a;
  private View b;
  private final HashMap<Integer, Pair<Float, Float>> c = new HashMap();
  
  @NotNull
  public final Builder a(int paramInt, float paramFloat1, float paramFloat2)
  {
    ((Map)this.c).put(Integer.valueOf(paramInt), new Pair(Float.valueOf(paramFloat1), Float.valueOf(paramFloat2)));
    return this;
  }
  
  @NotNull
  public final Builder a(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "rootView");
    this.a = paramView;
    return this;
  }
  
  @NotNull
  public final WSAnimConfig a()
  {
    HashMap localHashMap = this.c;
    View localView = this.a;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    return new WSAnimConfig(localHashMap, localView, this.b);
  }
  
  @NotNull
  public final Builder b(@Nullable View paramView)
  {
    this.b = paramView;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.ui.videotransition.WSAnimConfig.Builder
 * JD-Core Version:    0.7.0.1
 */