package com.tencent.mobileqq.apollo.ipc;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/ipc/TypeToken;", "", "()V", "methods", "Ljava/util/HashMap;", "Ljava/lang/reflect/Method;", "Lcom/tencent/mobileqq/apollo/ipc/MethodToken;", "getMethods", "()Ljava/util/HashMap;", "setMethods", "(Ljava/util/HashMap;)V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "matchMethod", "description", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class TypeToken
{
  public static final TypeToken.Companion a;
  @Nullable
  private String jdField_a_of_type_JavaLangString;
  @NotNull
  private HashMap<Method, MethodToken> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqApolloIpcTypeToken$Companion = new TypeToken.Companion(null);
  }
  
  @Nullable
  public final MethodToken a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "description");
    MethodToken localMethodToken1 = (MethodToken)null;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      MethodToken localMethodToken2 = (MethodToken)((Map.Entry)localIterator.next()).getValue();
      if (localMethodToken2 != null)
      {
        if (localMethodToken2.a(paramString)) {
          return localMethodToken2;
        }
      }
      else {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.ipc.MethodToken");
      }
    }
    return localMethodToken1;
  }
  
  @Nullable
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  @NotNull
  public final HashMap<Method, MethodToken> a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public final void a(@Nullable String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.TypeToken
 * JD-Core Version:    0.7.0.1
 */