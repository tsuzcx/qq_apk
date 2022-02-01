package com.tencent.mobileqq.apollo.ipc;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/ipc/MethodToken;", "", "()V", "callback", "Lcom/tencent/mobileqq/apollo/ipc/TypeToken;", "getCallback", "()Lcom/tencent/mobileqq/apollo/ipc/TypeToken;", "setCallback", "(Lcom/tencent/mobileqq/apollo/ipc/TypeToken;)V", "callbackIndex", "", "getCallbackIndex", "()I", "setCallbackIndex", "(I)V", "description", "", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "isSync", "", "()Z", "setSync", "(Z)V", "method", "Ljava/lang/reflect/Method;", "getMethod", "()Ljava/lang/reflect/Method;", "setMethod", "(Ljava/lang/reflect/Method;)V", "name", "getName", "setName", "returnDescription", "getReturnDescription", "setReturnDescription", "returnType", "Ljava/lang/Class;", "getReturnType", "()Ljava/lang/Class;", "setReturnType", "(Ljava/lang/Class;)V", "match", "methodDescriptor", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class MethodToken
{
  public static final MethodToken.Companion f = new MethodToken.Companion(null);
  @NotNull
  public String a;
  @NotNull
  public String b;
  @NotNull
  public String c;
  @NotNull
  public Class<?> d;
  @NotNull
  public Method e;
  private boolean g;
  @Nullable
  private TypeToken h;
  private int i = -1;
  
  public final void a(int paramInt)
  {
    this.i = paramInt;
  }
  
  public final void a(@Nullable TypeToken paramTypeToken)
  {
    this.h = paramTypeToken;
  }
  
  public final void a(@NotNull Class<?> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "<set-?>");
    this.d = paramClass;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.a = paramString;
  }
  
  public final void a(@NotNull Method paramMethod)
  {
    Intrinsics.checkParameterIsNotNull(paramMethod, "<set-?>");
    this.e = paramMethod;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public final boolean a()
  {
    return this.g;
  }
  
  @NotNull
  public final String b()
  {
    String str = this.a;
    if (str == null) {
      Intrinsics.throwUninitializedPropertyAccessException("name");
    }
    return str;
  }
  
  public final void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.b = paramString;
  }
  
  @NotNull
  public final String c()
  {
    String str = this.b;
    if (str == null) {
      Intrinsics.throwUninitializedPropertyAccessException("description");
    }
    return str;
  }
  
  public final void c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.c = paramString;
  }
  
  @NotNull
  public final String d()
  {
    String str = this.c;
    if (str == null) {
      Intrinsics.throwUninitializedPropertyAccessException("returnDescription");
    }
    return str;
  }
  
  public final boolean d(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "methodDescriptor");
    String str = this.b;
    if (str == null) {
      Intrinsics.throwUninitializedPropertyAccessException("description");
    }
    return Intrinsics.areEqual(str, paramString);
  }
  
  @NotNull
  public final Class<?> e()
  {
    Class localClass = this.d;
    if (localClass == null) {
      Intrinsics.throwUninitializedPropertyAccessException("returnType");
    }
    return localClass;
  }
  
  @NotNull
  public final Method f()
  {
    Method localMethod = this.e;
    if (localMethod == null) {
      Intrinsics.throwUninitializedPropertyAccessException("method");
    }
    return localMethod;
  }
  
  @Nullable
  public final TypeToken g()
  {
    return this.h;
  }
  
  public final int h()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.MethodToken
 * JD-Core Version:    0.7.0.1
 */