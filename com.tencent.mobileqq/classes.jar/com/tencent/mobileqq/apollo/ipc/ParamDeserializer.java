package com.tencent.mobileqq.apollo.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.utils.reflect.Reflect;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/ipc/ParamDeserializer;", "", "()V", "deserialize", "", "method", "Lcom/tencent/mobileqq/apollo/ipc/MethodToken;", "bundleParam", "Landroid/os/Bundle;", "(Lcom/tencent/mobileqq/apollo/ipc/MethodToken;Landroid/os/Bundle;)[Ljava/lang/Object;", "deserializeData", "type", "Ljava/lang/Class;", "curIndex", "", "key", "", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class ParamDeserializer
{
  public static final ParamDeserializer a = new ParamDeserializer();
  
  @JvmStatic
  @NotNull
  public static final Object[] a(@NotNull MethodToken paramMethodToken, @NotNull Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramMethodToken, "method");
    Intrinsics.checkParameterIsNotNull(paramBundle, "bundleParam");
    paramMethodToken = paramMethodToken.f().getParameterTypes();
    Object[] arrayOfObject = new Object[paramMethodToken.length];
    Intrinsics.checkExpressionValueIsNotNull(paramMethodToken, "types");
    int k = paramMethodToken.length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      Class localClass = paramMethodToken[j];
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ipc_param_");
      ((StringBuilder)localObject).append(i);
      localObject = ((StringBuilder)localObject).toString();
      localClass = Reflect.a(localClass);
      ParamDeserializer localParamDeserializer = a;
      Intrinsics.checkExpressionValueIsNotNull(localClass, "type");
      arrayOfObject[i] = localParamDeserializer.a(localClass, i, paramBundle, (String)localObject);
      j += 1;
      i += 1;
    }
    return arrayOfObject;
  }
  
  @Nullable
  public final Object a(@NotNull Class<?> paramClass, int paramInt, @NotNull Bundle paramBundle, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "type");
    Intrinsics.checkParameterIsNotNull(paramBundle, "bundleParam");
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    if (Intrinsics.areEqual(paramClass, Boolean.class)) {
      return Boolean.valueOf(paramBundle.getBoolean(paramString, false));
    }
    if (Intrinsics.areEqual(paramClass, Integer.class)) {
      return Integer.valueOf(paramBundle.getInt(paramString, 0));
    }
    if (Intrinsics.areEqual(paramClass, Long.class)) {
      return Long.valueOf(paramBundle.getLong(paramString, 0L));
    }
    if (Intrinsics.areEqual(paramClass, Short.TYPE)) {
      return Short.valueOf(paramBundle.getShort(paramString, (short)0));
    }
    if (Intrinsics.areEqual(paramClass, Byte.TYPE)) {
      return paramBundle.getByte(paramString, (byte)0);
    }
    if (Intrinsics.areEqual(paramClass, Double.TYPE)) {
      return Double.valueOf(paramBundle.getDouble(paramString, 0.0D));
    }
    if (Intrinsics.areEqual(paramClass, Float.TYPE)) {
      return Float.valueOf(paramBundle.getFloat(paramString, 0.0F));
    }
    if (Intrinsics.areEqual(paramClass, Character.TYPE)) {
      return Character.valueOf(paramBundle.getChar(paramString));
    }
    if (Intrinsics.areEqual(paramClass, String.class)) {
      return paramBundle.getString(paramString);
    }
    if (Intrinsics.areEqual(paramClass, Bundle.class)) {
      return paramBundle.getBundle(paramString);
    }
    Intrinsics.areEqual(paramClass, Void.class);
    if (ParamSerializer.a.b(paramClass))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ipc_param__arr_type");
      localStringBuilder.append(paramInt);
      paramInt = paramBundle.getInt(localStringBuilder.toString());
      if (paramInt != -1) {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3)
            {
              if (paramInt == 4)
              {
                paramClass = paramBundle.getParcelableArrayList(paramString);
                Intrinsics.checkExpressionValueIsNotNull(paramClass, "bundleParam.getParcelableArrayList(key)");
                return paramClass;
              }
            }
            else {
              return paramBundle.getCharSequenceArrayList(paramString);
            }
          }
          else {
            return paramBundle.getStringArrayList(paramString);
          }
        }
        else {
          return paramBundle.getIntegerArrayList(paramString);
        }
      }
    }
    if (ParamSerializer.a.c(paramClass)) {
      return paramBundle.getParcelable(paramString);
    }
    if (ParamSerializer.a.d(paramClass)) {
      return paramBundle.getSerializable(paramString);
    }
    if (ParamSerializer.a.e(paramClass)) {
      return new JSONObject(paramBundle.getString(paramString));
    }
    if (ParamSerializer.a.f(paramClass)) {
      return new JSONArray(paramBundle.getString(paramString));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.ParamDeserializer
 * JD-Core Version:    0.7.0.1
 */