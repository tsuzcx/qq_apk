package com.tencent.mobileqq.apollo.ipc;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/ipc/TypeToken$Companion;", "", "()V", "createTypeToken", "Lcom/tencent/mobileqq/apollo/ipc/TypeToken;", "T", "clazz", "Ljava/lang/Class;", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class TypeToken$Companion
{
  @NotNull
  public final <T> TypeToken a(@NotNull Class<T> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "clazz");
    TypeToken localTypeToken = new TypeToken();
    localTypeToken.a(paramClass.getName());
    paramClass = paramClass.getMethods();
    Intrinsics.checkExpressionValueIsNotNull(paramClass, "clazz.methods");
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramClass[i];
      Map localMap = (Map)localTypeToken.b();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "it");
      localMap.put(localObject, MethodToken.f.a(localObject));
      i += 1;
    }
    return localTypeToken;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.TypeToken.Companion
 * JD-Core Version:    0.7.0.1
 */