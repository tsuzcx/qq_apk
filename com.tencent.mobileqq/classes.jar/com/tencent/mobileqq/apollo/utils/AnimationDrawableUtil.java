package com.tencent.mobileqq.apollo.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/utils/AnimationDrawableUtil;", "", "()V", "createAnimationDrawable", "Landroid/graphics/drawable/AnimationDrawable;", "context", "Landroid/content/Context;", "frameItems", "Ljava/util/LinkedHashMap;", "", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class AnimationDrawableUtil
{
  public static final AnimationDrawableUtil a = new AnimationDrawableUtil();
  
  @JvmStatic
  @NotNull
  public static final AnimationDrawable a(@NotNull Context paramContext, @NotNull LinkedHashMap<Integer, Integer> paramLinkedHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramLinkedHashMap, "frameItems");
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    paramLinkedHashMap = ((Map)paramLinkedHashMap).entrySet().iterator();
    while (paramLinkedHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramLinkedHashMap.next();
      int i = ((Number)localEntry.getKey()).intValue();
      int j = ((Number)localEntry.getValue()).intValue();
      localAnimationDrawable.addFrame(paramContext.getResources().getDrawable(i), j);
    }
    return localAnimationDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.AnimationDrawableUtil
 * JD-Core Version:    0.7.0.1
 */