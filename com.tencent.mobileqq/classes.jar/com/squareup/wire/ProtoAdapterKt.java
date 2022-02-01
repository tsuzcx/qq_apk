package com.squareup.wire;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"FIXED_32_SIZE", "", "FIXED_64_SIZE", "FIXED_BOOL_SIZE", "commonBool", "Lcom/squareup/wire/ProtoAdapter;", "", "commonBytes", "Lokio/ByteString;", "commonDouble", "", "commonFixed32", "commonFixed64", "", "commonFloat", "", "commonInt32", "commonInt64", "commonNewMapAdapter", "", "K", "V", "keyAdapter", "valueAdapter", "commonSfixed32", "commonSfixed64", "commonSint32", "commonSint64", "commonString", "", "commonToString", "E", "value", "(Ljava/lang/Object;)Ljava/lang/String;", "commonUint32", "commonUint64", "commonCreatePacked", "", "commonCreateRepeated", "commonDecode", "bytes", "", "(Lcom/squareup/wire/ProtoAdapter;[B)Ljava/lang/Object;", "source", "Lokio/BufferedSource;", "(Lcom/squareup/wire/ProtoAdapter;Lokio/BufferedSource;)Ljava/lang/Object;", "(Lcom/squareup/wire/ProtoAdapter;Lokio/ByteString;)Ljava/lang/Object;", "commonEncode", "(Lcom/squareup/wire/ProtoAdapter;Ljava/lang/Object;)[B", "", "sink", "Lokio/BufferedSink;", "(Lcom/squareup/wire/ProtoAdapter;Lokio/BufferedSink;Ljava/lang/Object;)V", "commonEncodeByteString", "(Lcom/squareup/wire/ProtoAdapter;Ljava/lang/Object;)Lokio/ByteString;", "commonEncodeWithTag", "writer", "Lcom/squareup/wire/ProtoWriter;", "tag", "(Lcom/squareup/wire/ProtoAdapter;Lcom/squareup/wire/ProtoWriter;ILjava/lang/Object;)V", "commonEncodedSizeWithTag", "(Lcom/squareup/wire/ProtoAdapter;ILjava/lang/Object;)I", "commonWithLabel", "label", "Lcom/squareup/wire/WireField$Label;", "wire-runtime"}, k=2, mv={1, 1, 16})
public final class ProtoAdapterKt
{
  private static final int FIXED_32_SIZE = 4;
  private static final int FIXED_64_SIZE = 8;
  private static final int FIXED_BOOL_SIZE = 1;
  
  @NotNull
  public static final ProtoAdapter<Boolean> commonBool()
  {
    return (ProtoAdapter)new ProtoAdapterKt.commonBool.1(FieldEncoding.VARINT, Reflection.getOrCreateKotlinClass(Boolean.TYPE), null);
  }
  
  @NotNull
  public static final ProtoAdapter<ByteString> commonBytes()
  {
    return (ProtoAdapter)new ProtoAdapterKt.commonBytes.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ByteString.class), null);
  }
  
  @NotNull
  public static final <E> ProtoAdapter<List<E>> commonCreatePacked(@NotNull ProtoAdapter<E> paramProtoAdapter)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoAdapter, "$this$commonCreatePacked");
    int i;
    if (paramProtoAdapter.getFieldEncoding$wire_runtime() != FieldEncoding.LENGTH_DELIMITED) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return (ProtoAdapter)new PackedProtoAdapter(paramProtoAdapter);
    }
    throw ((Throwable)new IllegalArgumentException("Unable to pack a length-delimited type.".toString()));
  }
  
  @NotNull
  public static final <E> ProtoAdapter<List<E>> commonCreateRepeated(@NotNull ProtoAdapter<E> paramProtoAdapter)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoAdapter, "$this$commonCreateRepeated");
    return (ProtoAdapter)new RepeatedProtoAdapter(paramProtoAdapter);
  }
  
  public static final <E> E commonDecode(@NotNull ProtoAdapter<E> paramProtoAdapter, @NotNull BufferedSource paramBufferedSource)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoAdapter, "$this$commonDecode");
    Intrinsics.checkParameterIsNotNull(paramBufferedSource, "source");
    return paramProtoAdapter.decode(new ProtoReader(paramBufferedSource));
  }
  
  public static final <E> E commonDecode(@NotNull ProtoAdapter<E> paramProtoAdapter, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoAdapter, "$this$commonDecode");
    Intrinsics.checkParameterIsNotNull(paramByteString, "bytes");
    return paramProtoAdapter.decode((BufferedSource)new Buffer().write(paramByteString));
  }
  
  public static final <E> E commonDecode(@NotNull ProtoAdapter<E> paramProtoAdapter, @NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoAdapter, "$this$commonDecode");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "bytes");
    return paramProtoAdapter.decode((BufferedSource)new Buffer().write(paramArrayOfByte));
  }
  
  @NotNull
  public static final ProtoAdapter<Double> commonDouble()
  {
    return (ProtoAdapter)new ProtoAdapterKt.commonDouble.1(FieldEncoding.FIXED64, Reflection.getOrCreateKotlinClass(Double.TYPE), null);
  }
  
  public static final <E> void commonEncode(@NotNull ProtoAdapter<E> paramProtoAdapter, @NotNull BufferedSink paramBufferedSink, E paramE)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoAdapter, "$this$commonEncode");
    Intrinsics.checkParameterIsNotNull(paramBufferedSink, "sink");
    paramProtoAdapter.encode(new ProtoWriter(paramBufferedSink), paramE);
  }
  
  @NotNull
  public static final <E> byte[] commonEncode(@NotNull ProtoAdapter<E> paramProtoAdapter, E paramE)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoAdapter, "$this$commonEncode");
    Buffer localBuffer = new Buffer();
    paramProtoAdapter.encode((BufferedSink)localBuffer, paramE);
    return localBuffer.readByteArray();
  }
  
  @NotNull
  public static final <E> ByteString commonEncodeByteString(@NotNull ProtoAdapter<E> paramProtoAdapter, E paramE)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoAdapter, "$this$commonEncodeByteString");
    Buffer localBuffer = new Buffer();
    paramProtoAdapter.encode((BufferedSink)localBuffer, paramE);
    return localBuffer.readByteString();
  }
  
  public static final <E> void commonEncodeWithTag(@NotNull ProtoAdapter<E> paramProtoAdapter, @NotNull ProtoWriter paramProtoWriter, int paramInt, @Nullable E paramE)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoAdapter, "$this$commonEncodeWithTag");
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    if (paramE == null) {
      return;
    }
    paramProtoWriter.writeTag(paramInt, paramProtoAdapter.getFieldEncoding$wire_runtime());
    if (paramProtoAdapter.getFieldEncoding$wire_runtime() == FieldEncoding.LENGTH_DELIMITED) {
      paramProtoWriter.writeVarint32(paramProtoAdapter.encodedSize(paramE));
    }
    paramProtoAdapter.encode(paramProtoWriter, paramE);
  }
  
  public static final <E> int commonEncodedSizeWithTag(@NotNull ProtoAdapter<E> paramProtoAdapter, int paramInt, @Nullable E paramE)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoAdapter, "$this$commonEncodedSizeWithTag");
    if (paramE == null) {
      return 0;
    }
    int j = paramProtoAdapter.encodedSize(paramE);
    int i = j;
    if (paramProtoAdapter.getFieldEncoding$wire_runtime() == FieldEncoding.LENGTH_DELIMITED) {
      i = j + ProtoWriter.Companion.varint32Size$wire_runtime(j);
    }
    return i + ProtoWriter.Companion.tagSize$wire_runtime(paramInt);
  }
  
  @NotNull
  public static final ProtoAdapter<Integer> commonFixed32()
  {
    return (ProtoAdapter)new ProtoAdapterKt.commonFixed32.1(FieldEncoding.FIXED32, Reflection.getOrCreateKotlinClass(Integer.TYPE), null);
  }
  
  @NotNull
  public static final ProtoAdapter<Long> commonFixed64()
  {
    return (ProtoAdapter)new ProtoAdapterKt.commonFixed64.1(FieldEncoding.FIXED64, Reflection.getOrCreateKotlinClass(Long.TYPE), null);
  }
  
  @NotNull
  public static final ProtoAdapter<Float> commonFloat()
  {
    return (ProtoAdapter)new ProtoAdapterKt.commonFloat.1(FieldEncoding.FIXED32, Reflection.getOrCreateKotlinClass(Float.TYPE), null);
  }
  
  @NotNull
  public static final ProtoAdapter<Integer> commonInt32()
  {
    return (ProtoAdapter)new ProtoAdapterKt.commonInt32.1(FieldEncoding.VARINT, Reflection.getOrCreateKotlinClass(Integer.TYPE), null);
  }
  
  @NotNull
  public static final ProtoAdapter<Long> commonInt64()
  {
    return (ProtoAdapter)new ProtoAdapterKt.commonInt64.1(FieldEncoding.VARINT, Reflection.getOrCreateKotlinClass(Long.TYPE), null);
  }
  
  @NotNull
  public static final <K, V> ProtoAdapter<Map<K, V>> commonNewMapAdapter(@NotNull ProtoAdapter<K> paramProtoAdapter, @NotNull ProtoAdapter<V> paramProtoAdapter1)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoAdapter, "keyAdapter");
    Intrinsics.checkParameterIsNotNull(paramProtoAdapter1, "valueAdapter");
    return (ProtoAdapter)new MapProtoAdapter(paramProtoAdapter, paramProtoAdapter1);
  }
  
  @NotNull
  public static final ProtoAdapter<Integer> commonSfixed32()
  {
    return commonFixed32();
  }
  
  @NotNull
  public static final ProtoAdapter<Long> commonSfixed64()
  {
    return commonFixed64();
  }
  
  @NotNull
  public static final ProtoAdapter<Integer> commonSint32()
  {
    return (ProtoAdapter)new ProtoAdapterKt.commonSint32.1(FieldEncoding.VARINT, Reflection.getOrCreateKotlinClass(Integer.TYPE), null);
  }
  
  @NotNull
  public static final ProtoAdapter<Long> commonSint64()
  {
    return (ProtoAdapter)new ProtoAdapterKt.commonSint64.1(FieldEncoding.VARINT, Reflection.getOrCreateKotlinClass(Long.TYPE), null);
  }
  
  @NotNull
  public static final ProtoAdapter<String> commonString()
  {
    return (ProtoAdapter)new ProtoAdapterKt.commonString.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(String.class), null);
  }
  
  @NotNull
  public static final <E> String commonToString(E paramE)
  {
    return String.valueOf(paramE);
  }
  
  @NotNull
  public static final ProtoAdapter<Integer> commonUint32()
  {
    return (ProtoAdapter)new ProtoAdapterKt.commonUint32.1(FieldEncoding.VARINT, Reflection.getOrCreateKotlinClass(Integer.TYPE), null);
  }
  
  @NotNull
  public static final ProtoAdapter<Long> commonUint64()
  {
    return (ProtoAdapter)new ProtoAdapterKt.commonUint64.1(FieldEncoding.VARINT, Reflection.getOrCreateKotlinClass(Long.TYPE), null);
  }
  
  @NotNull
  public static final <E> ProtoAdapter<?> commonWithLabel(@NotNull ProtoAdapter<E> paramProtoAdapter, @NotNull WireField.Label paramLabel)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoAdapter, "$this$commonWithLabel");
    Intrinsics.checkParameterIsNotNull(paramLabel, "label");
    Object localObject = paramProtoAdapter;
    if (paramLabel.isRepeated())
    {
      if (paramLabel.isPacked()) {
        return paramProtoAdapter.asPacked();
      }
      localObject = paramProtoAdapter.asRepeated();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.ProtoAdapterKt
 * JD-Core Version:    0.7.0.1
 */