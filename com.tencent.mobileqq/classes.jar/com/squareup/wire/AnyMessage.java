package com.squareup.wire;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/squareup/wire/AnyMessage;", "Lcom/squareup/wire/Message;", "", "typeUrl", "", "value", "Lokio/ByteString;", "(Ljava/lang/String;Lokio/ByteString;)V", "getTypeUrl", "()Ljava/lang/String;", "getValue", "()Lokio/ByteString;", "copy", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "unpack", "T", "adapter", "Lcom/squareup/wire/ProtoAdapter;", "(Lcom/squareup/wire/ProtoAdapter;)Ljava/lang/Object;", "unpackOrNull", "Companion", "wire-runtime"}, k=1, mv={1, 1, 16})
public final class AnyMessage
  extends Message
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<AnyMessage> ADAPTER = (ProtoAdapter)new AnyMessage.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AnyMessage.class), "type.googleapis.com/google.protobuf.Any");
  public static final AnyMessage.Companion Companion = new AnyMessage.Companion(null);
  @NotNull
  private final String typeUrl;
  @NotNull
  private final ByteString value;
  
  public AnyMessage(@NotNull String paramString, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, ByteString.EMPTY);
    this.typeUrl = paramString;
    this.value = paramByteString;
  }
  
  @NotNull
  public final AnyMessage copy(@NotNull String paramString, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "typeUrl");
    Intrinsics.checkParameterIsNotNull(paramByteString, "value");
    return new AnyMessage(paramString, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (AnyMessage)this) {
      return true;
    }
    if (!(paramObject instanceof AnyMessage)) {
      return false;
    }
    String str = this.typeUrl;
    paramObject = (AnyMessage)paramObject;
    return (Intrinsics.areEqual(str, paramObject.typeUrl)) && (Intrinsics.areEqual(this.value, paramObject.value));
  }
  
  @NotNull
  public final String getTypeUrl()
  {
    return this.typeUrl;
  }
  
  @NotNull
  public final ByteString getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      i = (j * 37 + this.typeUrl.hashCode()) * 37 + this.value.hashCode();
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Any{type_url=");
    localStringBuilder.append(this.typeUrl);
    localStringBuilder.append(", value=");
    localStringBuilder.append(this.value);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public final <T> T unpack(@NotNull ProtoAdapter<T> paramProtoAdapter)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoAdapter, "adapter");
    if (Intrinsics.areEqual(this.typeUrl, paramProtoAdapter.getTypeUrl())) {
      return paramProtoAdapter.decode(this.value);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("type mismatch: ");
    localStringBuilder.append(this.typeUrl);
    localStringBuilder.append(" != ");
    localStringBuilder.append(paramProtoAdapter.getTypeUrl());
    throw ((Throwable)new IllegalStateException(localStringBuilder.toString().toString()));
  }
  
  @Nullable
  public final <T> T unpackOrNull(@NotNull ProtoAdapter<T> paramProtoAdapter)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoAdapter, "adapter");
    if (Intrinsics.areEqual(this.typeUrl, paramProtoAdapter.getTypeUrl())) {
      return paramProtoAdapter.decode(this.value);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.AnyMessage
 * JD-Core Version:    0.7.0.1
 */