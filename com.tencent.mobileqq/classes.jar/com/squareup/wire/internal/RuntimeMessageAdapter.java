package com.squareup.wire.internal;

import TM;;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoAdapter.EnumConstantNotFoundException;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField.Label;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/squareup/wire/internal/RuntimeMessageAdapter;", "M", "Lcom/squareup/wire/Message;", "B", "Lcom/squareup/wire/Message$Builder;", "Lcom/squareup/wire/ProtoAdapter;", "messageType", "Ljava/lang/Class;", "builderType", "fieldBindings", "", "", "Lcom/squareup/wire/internal/FieldBinding;", "typeUrl", "", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/util/Map;Ljava/lang/String;)V", "getFieldBindings", "()Ljava/util/Map;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "(Lcom/squareup/wire/ProtoReader;)Lcom/squareup/wire/Message;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "(Lcom/squareup/wire/ProtoWriter;Lcom/squareup/wire/Message;)V", "encodedSize", "(Lcom/squareup/wire/Message;)I", "equals", "", "other", "", "hashCode", "newBuilder", "()Lcom/squareup/wire/Message$Builder;", "redact", "(Lcom/squareup/wire/Message;)Lcom/squareup/wire/Message;", "toString", "(Lcom/squareup/wire/Message;)Ljava/lang/String;", "Companion", "wire-runtime"}, k=1, mv={1, 1, 16})
public final class RuntimeMessageAdapter<M extends Message<M, B>, B extends Message.Builder<M, B>>
  extends ProtoAdapter<M>
{
  public static final RuntimeMessageAdapter.Companion Companion = new RuntimeMessageAdapter.Companion(null);
  private static final String REDACTED = "██";
  private final Class<B> builderType;
  @NotNull
  private final Map<Integer, FieldBinding<M, B>> fieldBindings;
  private final Class<M> messageType;
  
  public RuntimeMessageAdapter(@NotNull Class<M> paramClass, @NotNull Class<B> paramClass1, @NotNull Map<Integer, FieldBinding<M, B>> paramMap, @Nullable String paramString)
  {
    super(FieldEncoding.LENGTH_DELIMITED, JvmClassMappingKt.getKotlinClass(paramClass), paramString);
    this.messageType = paramClass;
    this.builderType = paramClass1;
    this.fieldBindings = paramMap;
  }
  
  @JvmStatic
  @NotNull
  public static final <M extends Message<M, B>, B extends Message.Builder<M, B>> RuntimeMessageAdapter<M, B> create(@NotNull Class<M> paramClass, @Nullable String paramString)
  {
    return Companion.create(paramClass, paramString);
  }
  
  @NotNull
  public M decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    Message.Builder localBuilder = newBuilder();
    long l = paramProtoReader.beginMessage();
    int i;
    for (;;)
    {
      i = paramProtoReader.nextTag();
      if (i == -1)
      {
        paramProtoReader.endMessageAndGetUnknownFields(l);
        return localBuilder.build();
      }
      FieldBinding localFieldBinding = (FieldBinding)this.fieldBindings.get(Integer.valueOf(i));
      if (localFieldBinding != null) {}
      try
      {
        if (localFieldBinding.isMap()) {
          localObject = localFieldBinding.adapter$wire_runtime();
        } else {
          localObject = localFieldBinding.singleAdapter();
        }
        localObject = ((ProtoAdapter)localObject).decode(paramProtoReader);
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        localFieldBinding.value$wire_runtime(localBuilder, localObject);
      }
      catch (ProtoAdapter.EnumConstantNotFoundException localEnumConstantNotFoundException)
      {
        Object localObject;
        localBuilder.addUnknownField(i, FieldEncoding.VARINT, Long.valueOf(localEnumConstantNotFoundException.value));
      }
      localObject = paramProtoReader.peekFieldEncoding();
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      localBuilder.addUnknownField(i, (FieldEncoding)localObject, ((FieldEncoding)localObject).rawProtoAdapter().decode(paramProtoReader));
    }
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull M paramM)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramM, "value");
    Iterator localIterator = this.fieldBindings.values().iterator();
    while (localIterator.hasNext())
    {
      FieldBinding localFieldBinding = (FieldBinding)localIterator.next();
      Object localObject = localFieldBinding.get(paramM);
      if (localObject != null) {
        localFieldBinding.adapter$wire_runtime().encodeWithTag(paramProtoWriter, localFieldBinding.getTag(), localObject);
      }
    }
    paramProtoWriter.writeBytes(paramM.unknownFields());
  }
  
  public int encodedSize(@NotNull M paramM)
  {
    Intrinsics.checkParameterIsNotNull(paramM, "value");
    int i = paramM.getCachedSerializedSize$wire_runtime();
    if (i != 0) {
      return i;
    }
    i = 0;
    Iterator localIterator = this.fieldBindings.values().iterator();
    while (localIterator.hasNext())
    {
      FieldBinding localFieldBinding = (FieldBinding)localIterator.next();
      Object localObject = localFieldBinding.get(paramM);
      if (localObject != null) {
        i += localFieldBinding.adapter$wire_runtime().encodedSizeWithTag(localFieldBinding.getTag(), localObject);
      }
    }
    i += paramM.unknownFields().size();
    paramM.setCachedSerializedSize$wire_runtime(i);
    return i;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof RuntimeMessageAdapter)) && (Intrinsics.areEqual(((RuntimeMessageAdapter)paramObject).messageType, this.messageType));
  }
  
  @NotNull
  public final Map<Integer, FieldBinding<M, B>> getFieldBindings()
  {
    return this.fieldBindings;
  }
  
  public int hashCode()
  {
    return this.messageType.hashCode();
  }
  
  @NotNull
  public final B newBuilder()
  {
    Object localObject = this.builderType.newInstance();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "builderType.newInstance()");
    return (Message.Builder)localObject;
  }
  
  @NotNull
  public M redact(@NotNull M paramM)
  {
    Intrinsics.checkParameterIsNotNull(paramM, "value");
    Object localObject3 = paramM.newBuilder();
    Iterator localIterator = this.fieldBindings.values().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (FieldBinding)localIterator.next();
      boolean bool = ((FieldBinding)localObject2).getRedacted();
      paramM = null;
      Object localObject1 = null;
      if ((bool) && (((FieldBinding)localObject2).getLabel() == WireField.Label.REQUIRED))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("Field '");
        ((StringBuilder)localObject3).append(((FieldBinding)localObject2).getName());
        ((StringBuilder)localObject3).append("' in ");
        localObject2 = getType();
        paramM = (TM)localObject1;
        if (localObject2 != null)
        {
          localObject2 = JvmClassMappingKt.getJavaObjectType((KClass)localObject2);
          paramM = (TM)localObject1;
          if (localObject2 != null) {
            paramM = ((Class)localObject2).getName();
          }
        }
        ((StringBuilder)localObject3).append(paramM);
        ((StringBuilder)localObject3).append(" is required and ");
        ((StringBuilder)localObject3).append("cannot be redacted.");
        throw ((Throwable)new UnsupportedOperationException(((StringBuilder)localObject3).toString()));
      }
      localObject1 = ((FieldBinding)localObject2).singleAdapter().getType();
      if (localObject1 != null) {
        paramM = JvmClassMappingKt.getJavaObjectType((KClass)localObject1);
      }
      bool = Message.class.isAssignableFrom(paramM);
      if ((!((FieldBinding)localObject2).getRedacted()) && ((!bool) || (((FieldBinding)localObject2).getLabel().isRepeated())))
      {
        if ((bool) && (((FieldBinding)localObject2).getLabel().isRepeated()))
        {
          paramM = ((FieldBinding)localObject2).getFromBuilder$wire_runtime((Message.Builder)localObject3);
          if (paramM != null)
          {
            paramM = (List)paramM;
            localObject1 = ((FieldBinding)localObject2).singleAdapter();
            if (localObject1 != null) {
              ((FieldBinding)localObject2).set((Message.Builder)localObject3, Internal.-redactElements(paramM, (ProtoAdapter)localObject1));
            } else {
              throw new TypeCastException("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
            }
          }
          else
          {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
          }
        }
      }
      else
      {
        paramM = ((FieldBinding)localObject2).getFromBuilder$wire_runtime((Message.Builder)localObject3);
        if (paramM != null) {
          ((FieldBinding)localObject2).set((Message.Builder)localObject3, ((FieldBinding)localObject2).adapter$wire_runtime().redact(paramM));
        }
      }
    }
    ((Message.Builder)localObject3).clearUnknownFields();
    return ((Message.Builder)localObject3).build();
  }
  
  @NotNull
  public String toString(@NotNull M paramM)
  {
    Intrinsics.checkParameterIsNotNull(paramM, "value");
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.fieldBindings.values().iterator();
    while (localIterator.hasNext())
    {
      FieldBinding localFieldBinding = (FieldBinding)localIterator.next();
      Object localObject = localFieldBinding.get(paramM);
      if (localObject != null)
      {
        localStringBuilder.append(", ");
        localStringBuilder.append(localFieldBinding.getName());
        localStringBuilder.append('=');
        if (localFieldBinding.getRedacted()) {
          localObject = "██";
        }
        localStringBuilder.append(localObject);
      }
    }
    paramM = new StringBuilder();
    paramM.append(this.messageType.getSimpleName());
    paramM.append('{');
    localStringBuilder.replace(0, 2, paramM.toString());
    paramM = localStringBuilder.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramM, "StringBuilder().apply(builderAction).toString()");
    return paramM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.internal.RuntimeMessageAdapter
 * JD-Core Version:    0.7.0.1
 */