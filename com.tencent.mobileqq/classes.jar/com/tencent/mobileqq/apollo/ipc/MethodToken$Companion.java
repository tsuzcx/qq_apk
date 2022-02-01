package com.tencent.mobileqq.apollo.ipc;

import com.tencent.mobileqq.apollo.ipc.reflect.Reflect;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/ipc/MethodToken$Companion;", "", "()V", "createMethodToken", "Lcom/tencent/mobileqq/apollo/ipc/MethodToken;", "method", "Ljava/lang/reflect/Method;", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class MethodToken$Companion
{
  @NotNull
  public final MethodToken a(@NotNull Method paramMethod)
  {
    Intrinsics.checkParameterIsNotNull(paramMethod, "method");
    MethodToken localMethodToken = new MethodToken();
    localMethodToken.a(paramMethod);
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    Class localClass = paramMethod.getReturnType();
    Object localObject1 = "";
    Object localObject2 = localObject1;
    if (arrayOfClass != null)
    {
      int k = arrayOfClass.length;
      int i = 0;
      int j = 0;
      for (;;)
      {
        localObject2 = localObject1;
        if (i >= k) {
          break;
        }
        localObject2 = arrayOfClass[i];
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(';');
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "type");
        localStringBuilder.append(((Class)localObject2).getName());
        localObject1 = localStringBuilder.toString();
        if (((Class)localObject2).isInterface())
        {
          localMethodToken.a(TypeToken.a.a((Class)localObject2));
          localMethodToken.a(j);
        }
        j += 1;
        i += 1;
      }
    }
    if (!Intrinsics.areEqual(Reflect.a(localClass), Void.class)) {
      localMethodToken.a(true);
    }
    Intrinsics.checkExpressionValueIsNotNull(localClass, "retTypes");
    localObject1 = localClass.getName();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "retTypes.name");
    localMethodToken.c((String)localObject1);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramMethod.getName());
    ((StringBuilder)localObject1).append(';');
    ((StringBuilder)localObject1).append(localMethodToken.c());
    ((StringBuilder)localObject1).append((String)localObject2);
    localMethodToken.b(((StringBuilder)localObject1).toString());
    paramMethod = paramMethod.getName();
    Intrinsics.checkExpressionValueIsNotNull(paramMethod, "method.name");
    localMethodToken.a(paramMethod);
    return localMethodToken;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.MethodToken.Companion
 * JD-Core Version:    0.7.0.1
 */