package com.tencent.mobileqq.apollo.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.ipc.reflect.Reflect;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/ipc/ParamDeserializer;", "", "()V", "deserialize", "", "method", "Lcom/tencent/mobileqq/apollo/ipc/MethodToken;", "bundleParam", "Landroid/os/Bundle;", "(Lcom/tencent/mobileqq/apollo/ipc/MethodToken;Landroid/os/Bundle;)[Ljava/lang/Object;", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class ParamDeserializer
{
  public static final ParamDeserializer a = new ParamDeserializer();
  
  @JvmStatic
  @NotNull
  public static final Object[] a(@NotNull MethodToken paramMethodToken, @NotNull Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramMethodToken, "method");
    Intrinsics.checkParameterIsNotNull(paramBundle, "bundleParam");
    paramMethodToken = paramMethodToken.a().getParameterTypes();
    Object[] arrayOfObject = new Object[paramMethodToken.length];
    Intrinsics.checkExpressionValueIsNotNull(paramMethodToken, "types");
    int k = paramMethodToken.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      Class localClass = paramMethodToken[i];
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ipc_param_");
      ((StringBuilder)localObject).append(j);
      localObject = ((StringBuilder)localObject).toString();
      localClass = Reflect.a(localClass);
      if (Intrinsics.areEqual(localClass, Boolean.class)) {
        arrayOfObject[j] = Boolean.valueOf(paramBundle.getBoolean((String)localObject, false));
      } else if (Intrinsics.areEqual(localClass, Integer.class)) {
        arrayOfObject[j] = Integer.valueOf(paramBundle.getInt((String)localObject, 0));
      } else if (Intrinsics.areEqual(localClass, Long.TYPE)) {
        arrayOfObject[j] = Long.valueOf(paramBundle.getLong((String)localObject, 0L));
      } else if (Intrinsics.areEqual(localClass, Short.TYPE)) {
        arrayOfObject[j] = Short.valueOf(paramBundle.getShort((String)localObject, 0));
      } else if (Intrinsics.areEqual(localClass, Byte.TYPE)) {
        arrayOfObject[j] = paramBundle.getByte((String)localObject, 0);
      } else if (Intrinsics.areEqual(localClass, Double.TYPE)) {
        arrayOfObject[j] = Double.valueOf(paramBundle.getDouble((String)localObject, 0.0D));
      } else if (Intrinsics.areEqual(localClass, Float.TYPE)) {
        arrayOfObject[j] = Float.valueOf(paramBundle.getFloat((String)localObject, 0.0F));
      } else if (Intrinsics.areEqual(localClass, Character.TYPE)) {
        arrayOfObject[j] = Character.valueOf(paramBundle.getChar((String)localObject));
      } else if (Intrinsics.areEqual(localClass, String.class)) {
        arrayOfObject[j] = paramBundle.getString((String)localObject);
      } else {
        Intrinsics.areEqual(localClass, Void.class);
      }
      j += 1;
      i += 1;
    }
    return arrayOfObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.ParamDeserializer
 * JD-Core Version:    0.7.0.1
 */