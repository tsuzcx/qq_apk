package com.squareup.wire.internal;

import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import com.squareup.wire.WireField;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/squareup/wire/internal/RuntimeMessageAdapter$Companion;", "", "()V", "REDACTED", "", "create", "Lcom/squareup/wire/internal/RuntimeMessageAdapter;", "M", "B", "Lcom/squareup/wire/Message;", "Lcom/squareup/wire/Message$Builder;", "messageType", "Ljava/lang/Class;", "typeUrl", "getBuilderType", "wire-runtime"}, k=1, mv={1, 1, 16})
public final class RuntimeMessageAdapter$Companion
{
  private final <M extends Message<M, B>, B extends Message.Builder<M, B>> Class<B> getBuilderType(Class<M> paramClass)
  {
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramClass.getName());
      ((StringBuilder)localObject).append("$Builder");
      localObject = Class.forName(((StringBuilder)localObject).toString());
      if (localObject != null) {
        return localObject;
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<B>");
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Object localObject;
      label48:
      break label48;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("No builder class found for message type ");
    ((StringBuilder)localObject).append(paramClass.getName());
    throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString()));
  }
  
  @JvmStatic
  @NotNull
  public final <M extends Message<M, B>, B extends Message.Builder<M, B>> RuntimeMessageAdapter<M, B> create(@NotNull Class<M> paramClass, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "messageType");
    Class localClass = ((Companion)this).getBuilderType(paramClass);
    Object localObject = new LinkedHashMap();
    Field[] arrayOfField = paramClass.getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    while (i < j)
    {
      Field localField = arrayOfField[i];
      WireField localWireField = (WireField)localField.getAnnotation(WireField.class);
      if (localWireField != null)
      {
        Map localMap = (Map)localObject;
        int k = localWireField.tag();
        Intrinsics.checkExpressionValueIsNotNull(localField, "messageField");
        localMap.put(Integer.valueOf(k), new FieldBinding(localWireField, localField, localClass));
      }
      i += 1;
    }
    localObject = Collections.unmodifiableMap((Map)localObject);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Collections.unmodifiableMap(fieldBindings)");
    return new RuntimeMessageAdapter(paramClass, localClass, (Map)localObject, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.internal.RuntimeMessageAdapter.Companion
 * JD-Core Version:    0.7.0.1
 */