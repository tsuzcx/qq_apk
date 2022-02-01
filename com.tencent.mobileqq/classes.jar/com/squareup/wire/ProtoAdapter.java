package com.squareup.wire;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/squareup/wire/ProtoAdapter;", "E", "", "fieldEncoding", "Lcom/squareup/wire/FieldEncoding;", "type", "Ljava/lang/Class;", "(Lcom/squareup/wire/FieldEncoding;Ljava/lang/Class;)V", "Lkotlin/reflect/KClass;", "(Lcom/squareup/wire/FieldEncoding;Lkotlin/reflect/KClass;)V", "typeUrl", "", "(Lcom/squareup/wire/FieldEncoding;Ljava/lang/Class;Ljava/lang/String;)V", "(Lcom/squareup/wire/FieldEncoding;Lkotlin/reflect/KClass;Ljava/lang/String;)V", "getFieldEncoding$wire_runtime", "()Lcom/squareup/wire/FieldEncoding;", "packedAdapter", "", "getPackedAdapter$wire_runtime", "()Lcom/squareup/wire/ProtoAdapter;", "repeatedAdapter", "getRepeatedAdapter$wire_runtime", "getType", "()Lkotlin/reflect/KClass;", "getTypeUrl", "()Ljava/lang/String;", "asPacked", "asRepeated", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "(Lcom/squareup/wire/ProtoReader;)Ljava/lang/Object;", "stream", "Ljava/io/InputStream;", "(Ljava/io/InputStream;)Ljava/lang/Object;", "bytes", "", "([B)Ljava/lang/Object;", "source", "Lokio/BufferedSource;", "(Lokio/BufferedSource;)Ljava/lang/Object;", "Lokio/ByteString;", "(Lokio/ByteString;)Ljava/lang/Object;", "encode", "value", "(Ljava/lang/Object;)[B", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "(Lcom/squareup/wire/ProtoWriter;Ljava/lang/Object;)V", "Ljava/io/OutputStream;", "(Ljava/io/OutputStream;Ljava/lang/Object;)V", "sink", "Lokio/BufferedSink;", "(Lokio/BufferedSink;Ljava/lang/Object;)V", "encodeByteString", "(Ljava/lang/Object;)Lokio/ByteString;", "encodeWithTag", "tag", "", "(Lcom/squareup/wire/ProtoWriter;ILjava/lang/Object;)V", "encodedSize", "(Ljava/lang/Object;)I", "encodedSizeWithTag", "(ILjava/lang/Object;)I", "redact", "(Ljava/lang/Object;)Ljava/lang/Object;", "toString", "(Ljava/lang/Object;)Ljava/lang/String;", "withLabel", "label", "Lcom/squareup/wire/WireField$Label;", "withLabel$wire_runtime", "Companion", "EnumConstantNotFoundException", "wire-runtime"}, k=1, mv={1, 1, 16})
public abstract class ProtoAdapter<E>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<Boolean> BOOL;
  @JvmField
  @NotNull
  public static final ProtoAdapter<ByteString> BYTES = ProtoAdapterKt.commonBytes();
  public static final ProtoAdapter.Companion Companion = new ProtoAdapter.Companion(null);
  @JvmField
  @NotNull
  public static final ProtoAdapter<Double> DOUBLE;
  @JvmField
  @NotNull
  public static final ProtoAdapter<Integer> FIXED32;
  @JvmField
  @NotNull
  public static final ProtoAdapter<Long> FIXED64;
  @JvmField
  @NotNull
  public static final ProtoAdapter<Float> FLOAT;
  @JvmField
  @NotNull
  public static final ProtoAdapter<Integer> INT32;
  @JvmField
  @NotNull
  public static final ProtoAdapter<Long> INT64;
  @JvmField
  @NotNull
  public static final ProtoAdapter<Integer> SFIXED32;
  @JvmField
  @NotNull
  public static final ProtoAdapter<Long> SFIXED64;
  @JvmField
  @NotNull
  public static final ProtoAdapter<Integer> SINT32;
  @JvmField
  @NotNull
  public static final ProtoAdapter<Long> SINT64;
  @JvmField
  @NotNull
  public static final ProtoAdapter<String> STRING = ProtoAdapterKt.commonString();
  @JvmField
  @NotNull
  public static final ProtoAdapter<Integer> UINT32;
  @JvmField
  @NotNull
  public static final ProtoAdapter<Long> UINT64;
  @NotNull
  private final FieldEncoding fieldEncoding;
  @Nullable
  private final ProtoAdapter<List<E>> packedAdapter;
  @Nullable
  private final ProtoAdapter<List<E>> repeatedAdapter;
  @Nullable
  private final KClass<?> type;
  @Nullable
  private final String typeUrl;
  
  static
  {
    BOOL = ProtoAdapterKt.commonBool();
    INT32 = ProtoAdapterKt.commonInt32();
    UINT32 = ProtoAdapterKt.commonUint32();
    SINT32 = ProtoAdapterKt.commonSint32();
    FIXED32 = ProtoAdapterKt.commonFixed32();
    SFIXED32 = ProtoAdapterKt.commonSfixed32();
    INT64 = ProtoAdapterKt.commonInt64();
    UINT64 = ProtoAdapterKt.commonUint64();
    SINT64 = ProtoAdapterKt.commonSint64();
    FIXED64 = ProtoAdapterKt.commonFixed64();
    SFIXED64 = ProtoAdapterKt.commonSfixed64();
    FLOAT = ProtoAdapterKt.commonFloat();
    DOUBLE = ProtoAdapterKt.commonDouble();
  }
  
  public ProtoAdapter(@NotNull FieldEncoding paramFieldEncoding, @NotNull Class<?> paramClass)
  {
    this(paramFieldEncoding, JvmClassMappingKt.getKotlinClass(paramClass));
  }
  
  public ProtoAdapter(@NotNull FieldEncoding paramFieldEncoding, @NotNull Class<?> paramClass, @Nullable String paramString)
  {
    this(paramFieldEncoding, JvmClassMappingKt.getKotlinClass(paramClass), paramString);
  }
  
  public ProtoAdapter(@NotNull FieldEncoding paramFieldEncoding, @Nullable KClass<?> paramKClass)
  {
    this(paramFieldEncoding, paramKClass, null);
  }
  
  public ProtoAdapter(@NotNull FieldEncoding paramFieldEncoding, @Nullable KClass<?> paramKClass, @Nullable String paramString)
  {
    this.fieldEncoding = paramFieldEncoding;
    this.type = paramKClass;
    this.typeUrl = paramString;
    boolean bool = this instanceof PackedProtoAdapter;
    paramKClass = null;
    if ((!bool) && (!(this instanceof RepeatedProtoAdapter)) && (this.fieldEncoding != FieldEncoding.LENGTH_DELIMITED))
    {
      int i;
      if (getFieldEncoding$wire_runtime() != FieldEncoding.LENGTH_DELIMITED) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        paramFieldEncoding = (ProtoAdapter)new PackedProtoAdapter(this);
      } else {
        throw ((Throwable)new IllegalArgumentException("Unable to pack a length-delimited type.".toString()));
      }
    }
    else
    {
      paramFieldEncoding = null;
    }
    this.packedAdapter = paramFieldEncoding;
    paramFieldEncoding = paramKClass;
    if (!(this instanceof RepeatedProtoAdapter)) {
      if (bool) {
        paramFieldEncoding = paramKClass;
      } else {
        paramFieldEncoding = (ProtoAdapter)new RepeatedProtoAdapter(this);
      }
    }
    this.repeatedAdapter = paramFieldEncoding;
  }
  
  @JvmStatic
  @NotNull
  public static final <M extends Message<?, ?>> ProtoAdapter<M> get(@NotNull M paramM)
  {
    return Companion.get(paramM);
  }
  
  @JvmStatic
  @NotNull
  public static final <M> ProtoAdapter<M> get(@NotNull Class<M> paramClass)
  {
    return Companion.get(paramClass);
  }
  
  @JvmStatic
  @NotNull
  public static final ProtoAdapter<?> get(@NotNull String paramString)
  {
    return Companion.get(paramString);
  }
  
  @JvmStatic
  @NotNull
  public static final <E extends WireEnum> EnumAdapter<E> newEnumAdapter(@NotNull Class<E> paramClass)
  {
    return Companion.newEnumAdapter(paramClass);
  }
  
  @JvmStatic
  @NotNull
  public static final <K, V> ProtoAdapter<Map<K, V>> newMapAdapter(@NotNull ProtoAdapter<K> paramProtoAdapter, @NotNull ProtoAdapter<V> paramProtoAdapter1)
  {
    return Companion.newMapAdapter(paramProtoAdapter, paramProtoAdapter1);
  }
  
  @JvmStatic
  @NotNull
  public static final <M extends Message<M, B>, B extends Message.Builder<M, B>> ProtoAdapter<M> newMessageAdapter(@NotNull Class<M> paramClass)
  {
    return Companion.newMessageAdapter(paramClass);
  }
  
  @JvmStatic
  @NotNull
  public static final <M extends Message<M, B>, B extends Message.Builder<M, B>> ProtoAdapter<M> newMessageAdapter(@NotNull Class<M> paramClass, @NotNull String paramString)
  {
    return Companion.newMessageAdapter(paramClass, paramString);
  }
  
  @NotNull
  public final ProtoAdapter<List<E>> asPacked()
  {
    int i;
    if (this.fieldEncoding != FieldEncoding.LENGTH_DELIMITED) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      ProtoAdapter localProtoAdapter = this.packedAdapter;
      if (localProtoAdapter != null) {
        return localProtoAdapter;
      }
      throw ((Throwable)new UnsupportedOperationException("Can't create a packed adapter from a packed or repeated adapter."));
    }
    throw ((Throwable)new IllegalArgumentException("Unable to pack a length-delimited type.".toString()));
  }
  
  @NotNull
  public final ProtoAdapter<List<E>> asRepeated()
  {
    ProtoAdapter localProtoAdapter = this.repeatedAdapter;
    if (localProtoAdapter != null) {
      return localProtoAdapter;
    }
    throw ((Throwable)new UnsupportedOperationException("Can't create a repeated adapter from a repeated or packed adapter."));
  }
  
  public abstract E decode(@NotNull ProtoReader paramProtoReader);
  
  public final E decode(@NotNull InputStream paramInputStream)
  {
    Intrinsics.checkParameterIsNotNull(paramInputStream, "stream");
    return decode(Okio.buffer(Okio.source(paramInputStream)));
  }
  
  public final E decode(@NotNull BufferedSource paramBufferedSource)
  {
    Intrinsics.checkParameterIsNotNull(paramBufferedSource, "source");
    return decode(new ProtoReader(paramBufferedSource));
  }
  
  public final E decode(@NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "bytes");
    return decode((BufferedSource)new Buffer().write(paramByteString));
  }
  
  public final E decode(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "bytes");
    return decode((BufferedSource)new Buffer().write(paramArrayOfByte));
  }
  
  public abstract void encode(@NotNull ProtoWriter paramProtoWriter, E paramE);
  
  public final void encode(@NotNull OutputStream paramOutputStream, E paramE)
  {
    Intrinsics.checkParameterIsNotNull(paramOutputStream, "stream");
    paramOutputStream = Okio.buffer(Okio.sink(paramOutputStream));
    encode(paramOutputStream, paramE);
    paramOutputStream.emit();
  }
  
  public final void encode(@NotNull BufferedSink paramBufferedSink, E paramE)
  {
    Intrinsics.checkParameterIsNotNull(paramBufferedSink, "sink");
    encode(new ProtoWriter(paramBufferedSink), paramE);
  }
  
  @NotNull
  public final byte[] encode(E paramE)
  {
    Buffer localBuffer = new Buffer();
    encode((BufferedSink)localBuffer, paramE);
    return localBuffer.readByteArray();
  }
  
  @NotNull
  public final ByteString encodeByteString(E paramE)
  {
    Buffer localBuffer = new Buffer();
    encode((BufferedSink)localBuffer, paramE);
    return localBuffer.readByteString();
  }
  
  public void encodeWithTag(@NotNull ProtoWriter paramProtoWriter, int paramInt, @Nullable E paramE)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    if (paramE == null) {
      return;
    }
    paramProtoWriter.writeTag(paramInt, getFieldEncoding$wire_runtime());
    if (getFieldEncoding$wire_runtime() == FieldEncoding.LENGTH_DELIMITED) {
      paramProtoWriter.writeVarint32(encodedSize(paramE));
    }
    encode(paramProtoWriter, paramE);
  }
  
  public abstract int encodedSize(E paramE);
  
  public int encodedSizeWithTag(int paramInt, @Nullable E paramE)
  {
    if (paramE == null) {
      return 0;
    }
    int j = encodedSize(paramE);
    int i = j;
    if (getFieldEncoding$wire_runtime() == FieldEncoding.LENGTH_DELIMITED) {
      i = j + ProtoWriter.Companion.varint32Size$wire_runtime(j);
    }
    return ProtoWriter.Companion.tagSize$wire_runtime(paramInt) + i;
  }
  
  @NotNull
  public final FieldEncoding getFieldEncoding$wire_runtime()
  {
    return this.fieldEncoding;
  }
  
  @Nullable
  public final ProtoAdapter<List<E>> getPackedAdapter$wire_runtime()
  {
    return this.packedAdapter;
  }
  
  @Nullable
  public final ProtoAdapter<List<E>> getRepeatedAdapter$wire_runtime()
  {
    return this.repeatedAdapter;
  }
  
  @Nullable
  public final KClass<?> getType()
  {
    return this.type;
  }
  
  @Nullable
  public final String getTypeUrl()
  {
    return this.typeUrl;
  }
  
  public abstract E redact(E paramE);
  
  @NotNull
  public String toString(E paramE)
  {
    return String.valueOf(paramE);
  }
  
  @NotNull
  public final ProtoAdapter<?> withLabel$wire_runtime(@NotNull WireField.Label paramLabel)
  {
    Intrinsics.checkParameterIsNotNull(paramLabel, "label");
    if (paramLabel.isRepeated())
    {
      if (paramLabel.isPacked()) {
        return asPacked();
      }
      return asRepeated();
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.ProtoAdapter
 * JD-Core Version:    0.7.0.1
 */