package com.tencent.biz.pubaccount.util;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"safeLet", "R", "T1", "", "T2", "p1", "p2", "block", "Lkotlin/Function2;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "T3", "p3", "Lkotlin/Function3;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "T4", "p4", "Lkotlin/Function4;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "T5", "p5", "Lkotlin/Function5;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
public final class KotlinUtilKt
{
  @Nullable
  public static final <T1, T2, T3, T4, R> R a(@Nullable T1 paramT1, @Nullable T2 paramT2, @Nullable T3 paramT3, @Nullable T4 paramT4, @NotNull Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> paramFunction4)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction4, "block");
    if ((paramT1 != null) && (paramT2 != null) && (paramT3 != null) && (paramT4 != null)) {
      return paramFunction4.invoke(paramT1, paramT2, paramT3, paramT4);
    }
    return null;
  }
  
  @Nullable
  public static final <T1, T2, T3, R> R a(@Nullable T1 paramT1, @Nullable T2 paramT2, @Nullable T3 paramT3, @NotNull Function3<? super T1, ? super T2, ? super T3, ? extends R> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction3, "block");
    if ((paramT1 != null) && (paramT2 != null) && (paramT3 != null)) {
      return paramFunction3.invoke(paramT1, paramT2, paramT3);
    }
    return null;
  }
  
  @Nullable
  public static final <T1, T2, R> R a(@Nullable T1 paramT1, @Nullable T2 paramT2, @NotNull Function2<? super T1, ? super T2, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "block");
    if ((paramT1 != null) && (paramT2 != null)) {
      return paramFunction2.invoke(paramT1, paramT2);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.KotlinUtilKt
 * JD-Core Version:    0.7.0.1
 */