package com.squareup.wire;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/squareup/wire/MapProtoAdapter;", "K", "V", "Lcom/squareup/wire/ProtoAdapter;", "", "keyAdapter", "valueAdapter", "(Lcom/squareup/wire/ProtoAdapter;Lcom/squareup/wire/ProtoAdapter;)V", "entryAdapter", "Lcom/squareup/wire/MapEntryProtoAdapter;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodeWithTag", "tag", "", "encodedSize", "encodedSizeWithTag", "redact", "wire-runtime"}, k=1, mv={1, 1, 16})
public final class MapProtoAdapter<K, V>
  extends ProtoAdapter<Map<K, ? extends V>>
{
  private final MapEntryProtoAdapter<K, V> entryAdapter;
  
  public MapProtoAdapter(@NotNull ProtoAdapter<K> paramProtoAdapter, @NotNull ProtoAdapter<V> paramProtoAdapter1)
  {
    super(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Map.class), null);
    this.entryAdapter = new MapEntryProtoAdapter(paramProtoAdapter, paramProtoAdapter1);
  }
  
  @NotNull
  public Map<K, V> decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    long l = paramProtoReader.beginMessage();
    Object localObject2 = null;
    Object localObject1 = null;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1)
      {
        paramProtoReader.endMessageAndGetUnknownFields(l);
        int j = 0;
        if (localObject2 != null) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          i = j;
          if (localObject1 != null) {
            i = 1;
          }
          if (i != 0) {
            return MapsKt.mapOf(TuplesKt.to(localObject2, localObject1));
          }
          throw ((Throwable)new IllegalStateException("Map entry with null value".toString()));
        }
        throw ((Throwable)new IllegalStateException("Map entry with null key".toString()));
      }
      if (i != 1)
      {
        if (i == 2) {
          localObject1 = this.entryAdapter.getValueAdapter$wire_runtime().decode(paramProtoReader);
        }
      }
      else {
        localObject2 = this.entryAdapter.getKeyAdapter$wire_runtime().decode(paramProtoReader);
      }
    }
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull Map<K, ? extends V> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramMap, "value");
    throw ((Throwable)new UnsupportedOperationException("Repeated values can only be encoded with a tag."));
  }
  
  public void encodeWithTag(@NotNull ProtoWriter paramProtoWriter, int paramInt, @Nullable Map<K, ? extends V> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    if (paramMap == null) {
      return;
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      this.entryAdapter.encodeWithTag(paramProtoWriter, paramInt, localEntry);
    }
  }
  
  public int encodedSize(@NotNull Map<K, ? extends V> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "value");
    throw ((Throwable)new UnsupportedOperationException("Repeated values can only be sized with a tag."));
  }
  
  public int encodedSizeWithTag(int paramInt, @Nullable Map<K, ? extends V> paramMap)
  {
    int i = 0;
    if (paramMap == null) {
      return 0;
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      i += this.entryAdapter.encodedSizeWithTag(paramInt, localEntry);
    }
    return i;
  }
  
  @NotNull
  public Map<K, V> redact(@NotNull Map<K, ? extends V> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "value");
    return MapsKt.emptyMap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.MapProtoAdapter
 * JD-Core Version:    0.7.0.1
 */