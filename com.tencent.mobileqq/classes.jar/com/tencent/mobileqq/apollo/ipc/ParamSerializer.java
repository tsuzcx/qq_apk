package com.tencent.mobileqq.apollo.ipc;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mobileqq.apollo.utils.reflect.Reflect;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/ipc/ParamSerializer;", "", "()V", "ARRAYLIST_TYPE_CHAR", "", "ARRAYLIST_TYPE_ILLEGAL", "ARRAYLIST_TYPE_INT", "ARRAYLIST_TYPE_PARCELABLE", "ARRAYLIST_TYPE_STRING", "PREFIX_CALLBACK", "", "PREFIX_PARAM", "PREFIX_PARAM_ARR_KEY", "PREFIX_RETURN_VAL", "RETURN_INDEX", "TAG", "getArrayListType", "arg", "isArrayList", "", "type", "isInterfaceType", "T", "isJSONArray", "isJSONObject", "isParcelable", "isSerializable", "serialize", "Landroid/os/Bundle;", "methodToken", "Lcom/tencent/mobileqq/apollo/ipc/MethodToken;", "args", "", "(Lcom/tencent/mobileqq/apollo/ipc/MethodToken;[Ljava/lang/Object;)Landroid/os/Bundle;", "serializeArrayData", "Ljava/lang/Class;", "value", "param", "curIndex", "key", "serializeData", "", "serializeJsonData", "serializePrimitiveData", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class ParamSerializer
{
  public static final ParamSerializer a = new ParamSerializer();
  
  @JvmStatic
  public static final int a(@NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "arg");
    if (!a.b(paramObject.getClass())) {
      return -1;
    }
    paramObject = (ArrayList)paramObject;
    if (paramObject.size() == 0) {
      return 1;
    }
    paramObject = paramObject.get(0).getClass();
    if (Intrinsics.areEqual(paramObject, Integer.class)) {
      return 1;
    }
    if (Intrinsics.areEqual(paramObject, String.class)) {
      return 2;
    }
    if (Intrinsics.areEqual(paramObject, CharSequence.class)) {
      return 3;
    }
    if (Intrinsics.areEqual(paramObject, Parcelable.class)) {
      return 4;
    }
    return -1;
  }
  
  private final void a(Class<?> paramClass, Bundle paramBundle, String paramString, Object paramObject)
  {
    if (e(paramClass))
    {
      if (paramObject != null)
      {
        paramBundle.putString(paramString, ((JSONObject)paramObject).toString());
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
    }
    if (f(paramClass))
    {
      if (paramObject != null)
      {
        paramBundle.putString(paramString, ((JSONArray)paramObject).toString());
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type org.json.JSONArray");
    }
  }
  
  private final boolean a(Class<?> paramClass, Object paramObject, Bundle paramBundle, int paramInt, String paramString)
  {
    if (b(paramClass))
    {
      int i = a(paramObject);
      paramClass = new StringBuilder();
      paramClass.append("ipc_param__arr_type");
      paramClass.append(paramInt);
      paramBundle.putInt(paramClass.toString(), i);
      if (i != -1) {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i == 4)
              {
                paramBundle.putParcelableArrayList(paramString, (ArrayList)paramObject);
                return true;
              }
            }
            else
            {
              paramBundle.putCharSequenceArrayList(paramString, (ArrayList)paramObject);
              return true;
            }
          }
          else
          {
            paramBundle.putStringArrayList(paramString, (ArrayList)paramObject);
            return true;
          }
        }
        else
        {
          paramBundle.putIntegerArrayList(paramString, (ArrayList)paramObject);
          return true;
        }
      }
    }
    return false;
  }
  
  private final boolean b(Class<?> paramClass, Bundle paramBundle, String paramString, Object paramObject)
  {
    if (Intrinsics.areEqual(paramClass, Boolean.class))
    {
      if (paramObject != null)
      {
        paramBundle.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
        return true;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
    }
    if (Intrinsics.areEqual(paramClass, Integer.class))
    {
      if (paramObject != null)
      {
        paramBundle.putInt(paramString, ((Integer)paramObject).intValue());
        return true;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    }
    if (Intrinsics.areEqual(paramClass, Long.class))
    {
      if (paramObject != null)
      {
        paramBundle.putLong(paramString, ((Long)paramObject).longValue());
        return true;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");
    }
    if (Intrinsics.areEqual(paramClass, Short.TYPE))
    {
      if (paramObject != null)
      {
        paramBundle.putShort(paramString, ((Short)paramObject).shortValue());
        return true;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Short");
    }
    if (Intrinsics.areEqual(paramClass, Byte.TYPE))
    {
      if (paramObject != null)
      {
        paramBundle.putByte(paramString, ((Byte)paramObject).byteValue());
        return true;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Byte");
    }
    if (Intrinsics.areEqual(paramClass, Double.TYPE))
    {
      if (paramObject != null)
      {
        paramBundle.putDouble(paramString, ((Double)paramObject).doubleValue());
        return true;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Double");
    }
    if (Intrinsics.areEqual(paramClass, Float.TYPE))
    {
      if (paramObject != null)
      {
        paramBundle.putFloat(paramString, ((Float)paramObject).floatValue());
        return true;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
    }
    if (Intrinsics.areEqual(paramClass, Character.TYPE))
    {
      if (paramObject != null)
      {
        paramBundle.putChar(paramString, ((Character)paramObject).charValue());
        return true;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Char");
    }
    if (Intrinsics.areEqual(paramClass, String.class))
    {
      if (paramObject != null)
      {
        paramBundle.putString(paramString, (String)paramObject);
        return true;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    }
    if (Intrinsics.areEqual(paramClass, Bundle.class))
    {
      if (paramObject != null)
      {
        paramBundle.putBundle(paramString, (Bundle)paramObject);
        return true;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.os.Bundle");
    }
    Intrinsics.areEqual(paramClass, Void.class);
    return false;
  }
  
  @NotNull
  public final Bundle a(@NotNull MethodToken paramMethodToken, @NotNull Object[] paramArrayOfObject)
  {
    Intrinsics.checkParameterIsNotNull(paramMethodToken, "methodToken");
    Intrinsics.checkParameterIsNotNull(paramArrayOfObject, "args");
    Bundle localBundle = new Bundle();
    Object localObject1 = paramMethodToken.f().getParameterTypes();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "types");
    int k = localObject1.length;
    int i = 0;
    int j = 0;
    while (j < k)
    {
      Class localClass = localObject1[j];
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("ipc_param_");
      ((StringBuilder)localObject2).append(i);
      localObject2 = ((StringBuilder)localObject2).toString();
      localClass = Reflect.a(localClass);
      Object localObject3 = paramArrayOfObject[i];
      if (localObject3 != null)
      {
        ParamSerializer localParamSerializer = a;
        Intrinsics.checkExpressionValueIsNotNull(localClass, "type");
        localParamSerializer.a(localClass, localBundle, (String)localObject2, localObject3, i);
      }
      j += 1;
      i += 1;
    }
    paramArrayOfObject = paramMethodToken.g();
    if (paramArrayOfObject != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ipc_param_");
      ((StringBuilder)localObject1).append(paramMethodToken.h());
      localBundle.putString(((StringBuilder)localObject1).toString(), paramArrayOfObject.a());
    }
    return localBundle;
  }
  
  public final void a(@NotNull Class<?> paramClass, @NotNull Bundle paramBundle, @NotNull String paramString, @NotNull Object paramObject, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "type");
    Intrinsics.checkParameterIsNotNull(paramBundle, "param");
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    Intrinsics.checkParameterIsNotNull(paramObject, "value");
    if (b(paramClass, paramBundle, paramString, paramObject)) {
      return;
    }
    if (a(paramClass, paramObject, paramBundle, paramInt, paramString)) {
      return;
    }
    if (c(paramClass))
    {
      paramBundle.putParcelable(paramString, (Parcelable)paramObject);
      return;
    }
    if (d(paramClass))
    {
      paramBundle.putSerializable(paramString, (Serializable)paramObject);
      return;
    }
    a(paramClass, paramBundle, paramString, paramObject);
  }
  
  public final boolean b(@NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "type");
    return Intrinsics.areEqual(paramObject, ArrayList.class);
  }
  
  public final boolean c(@NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "type");
    for (;;)
    {
      if (Intrinsics.areEqual(paramObject, Parcelable.class)) {
        return true;
      }
      if (paramObject == null) {
        break label97;
      }
      paramObject = (Class)paramObject;
      Class[] arrayOfClass = paramObject.getInterfaces();
      Intrinsics.checkExpressionValueIsNotNull(arrayOfClass, "interfaces");
      int j = arrayOfClass.length;
      int i = 0;
      while (i < j)
      {
        if (Intrinsics.areEqual(arrayOfClass[i], Parcelable.class)) {
          return true;
        }
        i += 1;
      }
      if (paramObject.getSuperclass() == null) {
        break;
      }
      paramObject = paramObject.getSuperclass();
      Intrinsics.checkExpressionValueIsNotNull(paramObject, "checkType.superclass");
    }
    return false;
    label97:
    paramObject = new TypeCastException("null cannot be cast to non-null type java.lang.Class<*>");
    for (;;)
    {
      throw paramObject;
    }
  }
  
  public final boolean d(@NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "type");
    for (;;)
    {
      if (Intrinsics.areEqual(paramObject, Serializable.class)) {
        return true;
      }
      if (paramObject == null) {
        break label99;
      }
      paramObject = (Class)paramObject;
      Class[] arrayOfClass = paramObject.getInterfaces();
      Intrinsics.checkExpressionValueIsNotNull(arrayOfClass, "interfaces");
      int j = arrayOfClass.length;
      int i = 0;
      while (i < j)
      {
        if (Intrinsics.areEqual(arrayOfClass[i], Serializable.class)) {
          return true;
        }
        i += 1;
      }
      if (paramObject.getSuperclass() == null) {
        break;
      }
      paramObject = paramObject.getSuperclass();
      Intrinsics.checkExpressionValueIsNotNull(paramObject, "checkType.superclass");
    }
    return false;
    label99:
    paramObject = new TypeCastException("null cannot be cast to non-null type java.lang.Class<*>");
    for (;;)
    {
      throw paramObject;
    }
  }
  
  public final boolean e(@NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "type");
    return Intrinsics.areEqual(paramObject, JSONObject.class);
  }
  
  public final boolean f(@NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "type");
    return Intrinsics.areEqual(paramObject, JSONArray.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.ParamSerializer
 * JD-Core Version:    0.7.0.1
 */