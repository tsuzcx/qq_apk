package com.tencent.luggage.wxa.ef;

import com.tencent.luggage.wxa.qu.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.w;
import java.util.Collection;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/sdk/wxa_ktx/WxaMmkvProperty;", "T", "", "defaultValue", "mmkvName", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "Ljava/lang/Object;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "propertyType", "Ljava/lang/Class;", "thisRef", "getValue", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "value", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class h<T>
{
  @Deprecated
  public static final h.a a = new h.a(null);
  private final Class<? extends T> b;
  private Object c;
  private final Lazy d;
  private final T e;
  private final String f;
  
  public h(@NotNull T paramT, @Nullable String paramString)
  {
    this.e = paramT;
    this.f = paramString;
    this.b = this.e.getClass();
    this.d = LazyKt.lazy((Function0)new h.b(this));
  }
  
  private final w a()
  {
    return (w)this.d.getValue();
  }
  
  @NotNull
  public final T a(@NotNull Object paramObject, @NotNull KProperty<?> paramKProperty)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "thisRef");
    Intrinsics.checkParameterIsNotNull(paramKProperty, "property");
    this.c = paramObject;
    paramObject = this.b;
    Object localObject;
    if ((Intrinsics.areEqual(paramObject, Float.TYPE)) || (Intrinsics.areEqual(paramObject, Float.class)))
    {
      paramObject = a();
      paramKProperty = paramKProperty.getName();
      localObject = this.e;
      if (localObject != null) {
        return (Object)Float.valueOf(paramObject.getFloat(paramKProperty, ((Float)localObject).floatValue()));
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
    }
    if ((Intrinsics.areEqual(paramObject, Integer.TYPE)) || (Intrinsics.areEqual(paramObject, Integer.class)))
    {
      paramObject = a();
      paramKProperty = paramKProperty.getName();
      localObject = this.e;
      if (localObject != null) {
        return (Object)Integer.valueOf(paramObject.getInt(paramKProperty, ((Integer)localObject).intValue()));
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    }
    if (Intrinsics.areEqual(paramObject, String.class))
    {
      paramObject = a();
      paramKProperty = paramKProperty.getName();
      localObject = this.e;
      if (localObject != null)
      {
        paramObject = paramObject.getString(paramKProperty, (String)localObject);
        if (paramObject != null) {
          return (Object)paramObject;
        }
        throw new TypeCastException("null cannot be cast to non-null type T");
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    }
    if ((Intrinsics.areEqual(paramObject, Long.TYPE)) || (Intrinsics.areEqual(paramObject, Long.class)))
    {
      paramObject = a();
      paramKProperty = paramKProperty.getName();
      localObject = this.e;
      if (localObject != null) {
        return (Object)Long.valueOf(paramObject.getLong(paramKProperty, ((Long)localObject).longValue()));
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");
    }
    if ((Intrinsics.areEqual(paramObject, Boolean.TYPE)) || (Intrinsics.areEqual(paramObject, Boolean.class)))
    {
      paramObject = a();
      paramKProperty = paramKProperty.getName();
      localObject = this.e;
      if (localObject != null) {
        return (Object)Boolean.valueOf(paramObject.getBoolean(paramKProperty, ((Boolean)localObject).booleanValue()));
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
    }
    if (Intrinsics.areEqual(paramObject, [B.class))
    {
      paramObject = a().d(paramKProperty.getName());
      if (paramObject == null) {
        paramObject = this.e;
      }
      if (paramObject != null) {
        return paramObject;
      }
      throw new TypeCastException("null cannot be cast to non-null type T");
    }
    if (h.a.a(a, this.b).contains(a.class))
    {
      paramObject = a().d(paramKProperty.getName());
      if (paramObject == null) {
        return this.e;
      }
    }
    try
    {
      paramKProperty = this.b.newInstance();
      if (paramKProperty != null)
      {
        paramKProperty = (a)paramKProperty;
        paramKProperty.a(paramObject);
        if (paramKProperty != null) {
          return (Object)paramKProperty;
        }
        throw new TypeCastException("null cannot be cast to non-null type T");
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mm.protobuf.BaseProtoBuf");
    }
    catch (Exception paramObject)
    {
      label525:
      break label525;
    }
    paramObject = new StringBuilder();
    paramObject.append("parse pb failed, class:");
    paramObject.append(this.b.getCanonicalName());
    o.b("Luggage.WxaMmkvProperty", paramObject.toString());
    return this.e;
    paramObject = new StringBuilder();
    paramObject.append("unsupported type:");
    paramObject.append(this.b);
    throw ((Throwable)new IllegalAccessError(paramObject.toString()));
  }
  
  public final void a(@NotNull Object paramObject, @NotNull KProperty<?> paramKProperty, @Nullable T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "thisRef");
    Intrinsics.checkParameterIsNotNull(paramKProperty, "property");
    this.c = paramObject;
    if (paramT == null)
    {
      a().f(paramKProperty.getName());
      return;
    }
    paramObject = this.b;
    if ((Intrinsics.areEqual(paramObject, Float.TYPE)) || (Intrinsics.areEqual(paramObject, Float.class)))
    {
      a().putFloat(paramKProperty.getName(), ((Float)paramT).floatValue());
      return;
    }
    if ((Intrinsics.areEqual(paramObject, Integer.TYPE)) || (Intrinsics.areEqual(paramObject, Integer.class)))
    {
      a().putInt(paramKProperty.getName(), ((Integer)paramT).intValue());
      return;
    }
    if (Intrinsics.areEqual(paramObject, String.class))
    {
      a().putString(paramKProperty.getName(), (String)paramT);
      return;
    }
    if ((Intrinsics.areEqual(paramObject, Long.TYPE)) || (Intrinsics.areEqual(paramObject, Long.class)))
    {
      a().putLong(paramKProperty.getName(), ((Long)paramT).longValue());
      return;
    }
    if ((Intrinsics.areEqual(paramObject, Boolean.TYPE)) || (Intrinsics.areEqual(paramObject, Boolean.class)))
    {
      a().putBoolean(paramKProperty.getName(), ((Boolean)paramT).booleanValue());
      return;
    }
    if (Intrinsics.areEqual(paramObject, [B.class))
    {
      a().a(paramKProperty.getName(), (byte[])paramT);
      return;
    }
    if (h.a.a(a, this.b).contains(a.class))
    {
      paramObject = ((a)paramT).b();
      a().a(paramKProperty.getName(), paramObject);
      return;
    }
    paramObject = new StringBuilder();
    paramObject.append("unsupported type:");
    paramObject.append(this.b);
    throw ((Throwable)new IllegalAccessError(paramObject.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ef.h
 * JD-Core Version:    0.7.0.1
 */