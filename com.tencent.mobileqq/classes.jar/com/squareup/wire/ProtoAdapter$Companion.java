package com.squareup.wire;

import com.squareup.wire.internal.RuntimeMessageAdapter;
import com.squareup.wire.internal.RuntimeMessageAdapter.Companion;
import java.lang.reflect.Field;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/squareup/wire/ProtoAdapter$Companion;", "", "()V", "BOOL", "Lcom/squareup/wire/ProtoAdapter;", "", "BYTES", "Lokio/ByteString;", "DOUBLE", "", "FIXED32", "", "FIXED64", "", "FLOAT", "", "INT32", "INT64", "SFIXED32", "SFIXED64", "SINT32", "SINT64", "STRING", "", "UINT32", "UINT64", "get", "M", "Lcom/squareup/wire/Message;", "message", "(Lcom/squareup/wire/Message;)Lcom/squareup/wire/ProtoAdapter;", "type", "Ljava/lang/Class;", "adapterString", "newEnumAdapter", "Lcom/squareup/wire/EnumAdapter;", "E", "Lcom/squareup/wire/WireEnum;", "newMapAdapter", "", "K", "V", "keyAdapter", "valueAdapter", "newMessageAdapter", "B", "Lcom/squareup/wire/Message$Builder;", "typeUrl", "wire-runtime"}, k=1, mv={1, 1, 16})
public final class ProtoAdapter$Companion
{
  @JvmStatic
  @NotNull
  public final <M extends Message<?, ?>> ProtoAdapter<M> get(@NotNull M paramM)
  {
    Intrinsics.checkParameterIsNotNull(paramM, "message");
    return ((Companion)this).get(paramM.getClass());
  }
  
  @JvmStatic
  @NotNull
  public final <M> ProtoAdapter<M> get(@NotNull Class<M> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "type");
    try
    {
      Object localObject = paramClass.getField("ADAPTER").get(null);
      if (localObject != null) {
        return (ProtoAdapter)localObject;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<M>");
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("failed to access ");
      localStringBuilder.append(paramClass.getName());
      localStringBuilder.append("#ADAPTER");
      throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString(), (Throwable)localNoSuchFieldException));
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("failed to access ");
      localStringBuilder.append(paramClass.getName());
      localStringBuilder.append("#ADAPTER");
      throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString(), (Throwable)localIllegalAccessException));
    }
  }
  
  @JvmStatic
  @NotNull
  public final ProtoAdapter<?> get(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "adapterString");
    try
    {
      int i = StringsKt.indexOf$default((CharSequence)paramString, '#', 0, false, 6, null);
      Object localObject1 = paramString.substring(0, i);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      localObject2 = paramString.substring(i + 1);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "(this as java.lang.String).substring(startIndex)");
      localObject1 = Class.forName((String)localObject1).getField((String)localObject2).get(null);
      if (localObject1 != null) {
        return (ProtoAdapter)localObject1;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("failed to access ");
      ((StringBuilder)localObject2).append(paramString);
      throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject2).toString(), (Throwable)localClassNotFoundException));
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("failed to access ");
      ((StringBuilder)localObject2).append(paramString);
      throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject2).toString(), (Throwable)localNoSuchFieldException));
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("failed to access ");
      ((StringBuilder)localObject2).append(paramString);
      throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject2).toString(), (Throwable)localIllegalAccessException));
    }
  }
  
  @JvmStatic
  @NotNull
  public final <E extends WireEnum> EnumAdapter<E> newEnumAdapter(@NotNull Class<E> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "type");
    return (EnumAdapter)new RuntimeEnumAdapter(paramClass);
  }
  
  @JvmStatic
  @NotNull
  public final <K, V> ProtoAdapter<Map<K, V>> newMapAdapter(@NotNull ProtoAdapter<K> paramProtoAdapter, @NotNull ProtoAdapter<V> paramProtoAdapter1)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoAdapter, "keyAdapter");
    Intrinsics.checkParameterIsNotNull(paramProtoAdapter1, "valueAdapter");
    return (ProtoAdapter)new MapProtoAdapter(paramProtoAdapter, paramProtoAdapter1);
  }
  
  @JvmStatic
  @NotNull
  public final <M extends Message<M, B>, B extends Message.Builder<M, B>> ProtoAdapter<M> newMessageAdapter(@NotNull Class<M> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "type");
    return (ProtoAdapter)RuntimeMessageAdapter.Companion.create(paramClass, null);
  }
  
  @JvmStatic
  @NotNull
  public final <M extends Message<M, B>, B extends Message.Builder<M, B>> ProtoAdapter<M> newMessageAdapter(@NotNull Class<M> paramClass, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "type");
    Intrinsics.checkParameterIsNotNull(paramString, "typeUrl");
    return (ProtoAdapter)RuntimeMessageAdapter.Companion.create(paramClass, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.ProtoAdapter.Companion
 * JD-Core Version:    0.7.0.1
 */