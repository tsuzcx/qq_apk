package com.tencent.luggage.wxa.ef;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/sdk/wxa_ktx/ActivityUtils;", "", "()V", "REQUEST_CODE_LOW_BITS_MAGIC_NUM", "", "TAG", "", "obtainSystemTaskOpenAnimation", "Lkotlin/Pair;", "context", "Landroid/content/Context;", "applySystemTaskOpenAnimation", "", "Landroid/app/Activity;", "hashCodeAsRequestCode", "safeRequestWindowFeature", "", "feature", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public final class a
{
  public static final a a = new a();
  
  @JvmStatic
  public static final int a(@NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "$this$hashCodeAsRequestCode");
    return paramObject.hashCode() & 0xFFFF;
  }
  
  @SuppressLint({"ResourceType"})
  private final Pair<Integer, Integer> a(Context paramContext)
  {
    paramContext = paramContext.obtainStyledAttributes(16973825, new int[] { 16842940, 16842941 });
    Pair localPair = new Pair(Integer.valueOf(paramContext.getResourceId(0, 0)), Integer.valueOf(paramContext.getResourceId(1, 0)));
    paramContext.recycle();
    return localPair;
  }
  
  @JvmStatic
  public static final void a(@NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "$this$applySystemTaskOpenAnimation");
    Pair localPair = a.a((Context)paramActivity);
    paramActivity.overridePendingTransition(((Number)localPair.component1()).intValue(), ((Number)localPair.component2()).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ef.a
 * JD-Core Version:    0.7.0.1
 */