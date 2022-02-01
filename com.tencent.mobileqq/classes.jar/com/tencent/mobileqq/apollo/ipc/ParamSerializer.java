package com.tencent.mobileqq.apollo.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.ipc.reflect.Reflect;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/ipc/ParamSerializer;", "", "()V", "PREFIX_CALLBACK", "", "PREFIX_PARAM", "TAG", "serialize", "Landroid/os/Bundle;", "methodToken", "Lcom/tencent/mobileqq/apollo/ipc/MethodToken;", "args", "", "(Lcom/tencent/mobileqq/apollo/ipc/MethodToken;[Ljava/lang/Object;)Landroid/os/Bundle;", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class ParamSerializer
{
  public static final ParamSerializer a = new ParamSerializer();
  
  @NotNull
  public final Bundle a(@NotNull MethodToken paramMethodToken, @NotNull Object[] paramArrayOfObject)
  {
    Intrinsics.checkParameterIsNotNull(paramMethodToken, "methodToken");
    Intrinsics.checkParameterIsNotNull(paramArrayOfObject, "args");
    Bundle localBundle = new Bundle();
    Object localObject1 = paramMethodToken.a().getParameterTypes();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "types");
    int k = localObject1.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      Object localObject3 = localObject1[i];
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("ipc_param_");
      ((StringBuilder)localObject2).append(j);
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject3 = Reflect.a((Class)localObject3);
      if (paramArrayOfObject[j] == null) {}
      for (;;)
      {
        j += 1;
        break;
        if (Intrinsics.areEqual(localObject3, Boolean.class))
        {
          localObject3 = paramArrayOfObject[j];
          if (localObject3 != null) {
            localBundle.putBoolean((String)localObject2, ((Boolean)localObject3).booleanValue());
          } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
          }
        }
        else if (Intrinsics.areEqual(localObject3, Integer.class))
        {
          localObject3 = paramArrayOfObject[j];
          if (localObject3 != null) {
            localBundle.putInt((String)localObject2, ((Integer)localObject3).intValue());
          } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
          }
        }
        else if (Intrinsics.areEqual(localObject3, Long.TYPE))
        {
          localObject3 = paramArrayOfObject[j];
          if (localObject3 != null) {
            localBundle.putLong((String)localObject2, ((Long)localObject3).longValue());
          } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");
          }
        }
        else if (Intrinsics.areEqual(localObject3, Short.TYPE))
        {
          localObject3 = paramArrayOfObject[j];
          if (localObject3 != null) {
            localBundle.putShort((String)localObject2, ((Short)localObject3).shortValue());
          } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Short");
          }
        }
        else if (Intrinsics.areEqual(localObject3, Byte.TYPE))
        {
          localObject3 = paramArrayOfObject[j];
          if (localObject3 != null) {
            localBundle.putByte((String)localObject2, ((Byte)localObject3).byteValue());
          } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Byte");
          }
        }
        else if (Intrinsics.areEqual(localObject3, Double.TYPE))
        {
          localObject3 = paramArrayOfObject[j];
          if (localObject3 != null) {
            localBundle.putDouble((String)localObject2, ((Double)localObject3).doubleValue());
          } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Double");
          }
        }
        else if (Intrinsics.areEqual(localObject3, Float.TYPE))
        {
          localObject3 = paramArrayOfObject[j];
          if (localObject3 != null) {
            localBundle.putFloat((String)localObject2, ((Float)localObject3).floatValue());
          } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
          }
        }
        else if (Intrinsics.areEqual(localObject3, Character.TYPE))
        {
          localObject3 = paramArrayOfObject[j];
          if (localObject3 != null) {
            localBundle.putChar((String)localObject2, ((Character)localObject3).charValue());
          } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Char");
          }
        }
        else if (Intrinsics.areEqual(localObject3, String.class))
        {
          localObject3 = paramArrayOfObject[j];
          if (localObject3 != null) {
            localBundle.putString((String)localObject2, (String)localObject3);
          } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
          }
        }
        else
        {
          Intrinsics.areEqual(localObject3, Void.class);
        }
      }
      i += 1;
    }
    paramArrayOfObject = paramMethodToken.a();
    if (paramArrayOfObject != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ipc_param_");
      ((StringBuilder)localObject1).append(paramMethodToken.a());
      localBundle.putString(((StringBuilder)localObject1).toString(), paramArrayOfObject.a());
    }
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.ParamSerializer
 * JD-Core Version:    0.7.0.1
 */