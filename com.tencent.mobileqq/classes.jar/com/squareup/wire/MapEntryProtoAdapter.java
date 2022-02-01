package com.squareup.wire;

import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/squareup/wire/MapEntryProtoAdapter;", "K", "V", "Lcom/squareup/wire/ProtoAdapter;", "", "keyAdapter", "valueAdapter", "(Lcom/squareup/wire/ProtoAdapter;Lcom/squareup/wire/ProtoAdapter;)V", "getKeyAdapter$wire_runtime", "()Lcom/squareup/wire/ProtoAdapter;", "getValueAdapter$wire_runtime", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "wire-runtime"}, k=1, mv={1, 1, 16})
final class MapEntryProtoAdapter<K, V>
  extends ProtoAdapter<Map.Entry<? extends K, ? extends V>>
{
  @NotNull
  private final ProtoAdapter<K> keyAdapter;
  @NotNull
  private final ProtoAdapter<V> valueAdapter;
  
  public MapEntryProtoAdapter(@NotNull ProtoAdapter<K> paramProtoAdapter, @NotNull ProtoAdapter<V> paramProtoAdapter1)
  {
    super(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Map.Entry.class), null);
    this.keyAdapter = paramProtoAdapter;
    this.valueAdapter = paramProtoAdapter1;
  }
  
  @NotNull
  public Map.Entry<K, V> decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    throw ((Throwable)new UnsupportedOperationException());
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull Map.Entry<? extends K, ? extends V> paramEntry)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramEntry, "value");
    this.keyAdapter.encodeWithTag(paramProtoWriter, 1, paramEntry.getKey());
    this.valueAdapter.encodeWithTag(paramProtoWriter, 2, paramEntry.getValue());
  }
  
  public int encodedSize(@NotNull Map.Entry<? extends K, ? extends V> paramEntry)
  {
    Intrinsics.checkParameterIsNotNull(paramEntry, "value");
    return this.keyAdapter.encodedSizeWithTag(1, paramEntry.getKey()) + this.valueAdapter.encodedSizeWithTag(2, paramEntry.getValue());
  }
  
  @NotNull
  public final ProtoAdapter<K> getKeyAdapter$wire_runtime()
  {
    return this.keyAdapter;
  }
  
  @NotNull
  public final ProtoAdapter<V> getValueAdapter$wire_runtime()
  {
    return this.valueAdapter;
  }
  
  @NotNull
  public Map.Entry<K, V> redact(@NotNull Map.Entry<? extends K, ? extends V> paramEntry)
  {
    Intrinsics.checkParameterIsNotNull(paramEntry, "value");
    throw ((Throwable)new UnsupportedOperationException());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.MapEntryProtoAdapter
 * JD-Core Version:    0.7.0.1
 */