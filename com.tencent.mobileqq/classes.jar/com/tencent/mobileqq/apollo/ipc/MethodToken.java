package com.tencent.mobileqq.apollo.ipc;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/ipc/MethodToken;", "", "()V", "callback", "Lcom/tencent/mobileqq/apollo/ipc/TypeToken;", "getCallback", "()Lcom/tencent/mobileqq/apollo/ipc/TypeToken;", "setCallback", "(Lcom/tencent/mobileqq/apollo/ipc/TypeToken;)V", "callbackIndex", "", "getCallbackIndex", "()I", "setCallbackIndex", "(I)V", "description", "", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "isSync", "", "()Z", "setSync", "(Z)V", "method", "Ljava/lang/reflect/Method;", "getMethod", "()Ljava/lang/reflect/Method;", "setMethod", "(Ljava/lang/reflect/Method;)V", "name", "getName", "setName", "returnType", "getReturnType", "setReturnType", "match", "methodDescriptor", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class MethodToken
{
  public static final MethodToken.Companion a;
  private int jdField_a_of_type_Int = -1;
  @Nullable
  private TypeToken jdField_a_of_type_ComTencentMobileqqApolloIpcTypeToken;
  @NotNull
  public String a;
  @NotNull
  public Method a;
  private boolean jdField_a_of_type_Boolean;
  @NotNull
  public String b;
  @NotNull
  public String c;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqApolloIpcMethodToken$Companion = new MethodToken.Companion(null);
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @Nullable
  public final TypeToken a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloIpcTypeToken;
  }
  
  @NotNull
  public final String a()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if (str == null) {
      Intrinsics.throwUninitializedPropertyAccessException("name");
    }
    return str;
  }
  
  @NotNull
  public final Method a()
  {
    Method localMethod = this.jdField_a_of_type_JavaLangReflectMethod;
    if (localMethod == null) {
      Intrinsics.throwUninitializedPropertyAccessException("method");
    }
    return localMethod;
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final void a(@Nullable TypeToken paramTypeToken)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloIpcTypeToken = paramTypeToken;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public final void a(@NotNull Method paramMethod)
  {
    Intrinsics.checkParameterIsNotNull(paramMethod, "<set-?>");
    this.jdField_a_of_type_JavaLangReflectMethod = paramMethod;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public final boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "methodDescriptor");
    String str = this.b;
    if (str == null) {
      Intrinsics.throwUninitializedPropertyAccessException("description");
    }
    return Intrinsics.areEqual(str, paramString);
  }
  
  @NotNull
  public final String b()
  {
    String str = this.b;
    if (str == null) {
      Intrinsics.throwUninitializedPropertyAccessException("description");
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
    String str = this.c;
    if (str == null) {
      Intrinsics.throwUninitializedPropertyAccessException("returnType");
    }
    return str;
  }
  
  public final void c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.c = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.MethodToken
 * JD-Core Version:    0.7.0.1
 */