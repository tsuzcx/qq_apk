package com.tencent.mobileqq.apollo.ipc;

import com.tencent.mobileqq.apollo.ipc.annotation.RemoteCallBack;
import com.tencent.mobileqq.apollo.utils.reflect.Reflect;
import java.lang.annotation.Annotation;
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
    Object localObject1 = paramMethod.getReturnType();
    Annotation[][] arrayOfAnnotation = paramMethod.getParameterAnnotations();
    String str = "";
    if (arrayOfClass != null)
    {
      int m = arrayOfClass.length;
      str = "";
      int i = 0;
      int j = 0;
      while (i < m)
      {
        Class localClass = arrayOfClass[i];
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(';');
        Intrinsics.checkExpressionValueIsNotNull(localClass, "type");
        ((StringBuilder)localObject2).append(localClass.getName());
        str = ((StringBuilder)localObject2).toString();
        if (arrayOfAnnotation[j].length > 0)
        {
          localObject2 = arrayOfAnnotation[j];
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "annotations[id]");
          int n = localObject2.length;
          int k = 0;
          while (k < n)
          {
            if ((localObject2[k] instanceof RemoteCallBack))
            {
              localMethodToken.a(TypeToken.a.a(localClass));
              localMethodToken.a(j);
            }
            k += 1;
          }
        }
        j += 1;
        i += 1;
      }
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "retTypes");
    localMethodToken.a((Class)localObject1);
    if (!Intrinsics.areEqual(Reflect.a((Class)localObject1), Void.class)) {
      localMethodToken.a(true);
    }
    localObject1 = ((Class)localObject1).getName();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "retTypes.name");
    localMethodToken.c((String)localObject1);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramMethod.getName());
    ((StringBuilder)localObject1).append(';');
    ((StringBuilder)localObject1).append(localMethodToken.d());
    ((StringBuilder)localObject1).append(str);
    localMethodToken.b(((StringBuilder)localObject1).toString());
    paramMethod = paramMethod.getName();
    Intrinsics.checkExpressionValueIsNotNull(paramMethod, "method.name");
    localMethodToken.a(paramMethod);
    return localMethodToken;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.MethodToken.Companion
 * JD-Core Version:    0.7.0.1
 */