package com.tencent.luggage.wxa.gk;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/utils/Alias;", "R", "T", "", "receiver", "backingProperty", "Lkotlin/reflect/KMutableProperty1;", "(Ljava/lang/Object;Lkotlin/reflect/KMutableProperty1;)V", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/reflect/KMutableProperty1;)V", "receiver_field", "receiver_getter", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/reflect/KMutableProperty1;)V", "getReceiver", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setReceiver", "", "(Ljava/lang/Object;)V", "setValue", "value", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 13})
public class a<R, T>
{
  private R a;
  private Function0<? extends R> b;
  private final KMutableProperty1<R, T> c;
  
  public a(@Nullable R paramR, @Nullable Function0<? extends R> paramFunction0, @NotNull KMutableProperty1<R, T> paramKMutableProperty1)
  {
    this.a = paramR;
    this.b = paramFunction0;
    this.c = paramKMutableProperty1;
  }
  
  public a(@NotNull Function0<? extends R> paramFunction0, @NotNull KMutableProperty1<R, T> paramKMutableProperty1)
  {
    this(null, paramFunction0, paramKMutableProperty1);
  }
  
  public final R a()
  {
    Object localObject = this.a;
    if (localObject != null) {
      return localObject;
    }
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    return ((Function0)localObject).invoke();
  }
  
  public final T a(@Nullable Object paramObject, @NotNull KProperty<?> paramKProperty)
  {
    Intrinsics.checkParameterIsNotNull(paramKProperty, "property");
    return this.c.get(a());
  }
  
  public final void a(@Nullable Object paramObject, @NotNull KProperty<?> paramKProperty, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramKProperty, "property");
    this.c.set(a(), paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gk.a
 * JD-Core Version:    0.7.0.1
 */