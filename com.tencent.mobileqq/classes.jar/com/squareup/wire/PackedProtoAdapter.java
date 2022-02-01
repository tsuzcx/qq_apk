package com.squareup.wire;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/squareup/wire/PackedProtoAdapter;", "E", "Lcom/squareup/wire/ProtoAdapter;", "", "originalAdapter", "(Lcom/squareup/wire/ProtoAdapter;)V", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodeWithTag", "tag", "", "encodedSize", "encodedSizeWithTag", "redact", "wire-runtime"}, k=1, mv={1, 1, 16})
public final class PackedProtoAdapter<E>
  extends ProtoAdapter<List<? extends E>>
{
  private final ProtoAdapter<E> originalAdapter;
  
  public PackedProtoAdapter(@NotNull ProtoAdapter<E> paramProtoAdapter)
  {
    super(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(List.class), null);
    this.originalAdapter = paramProtoAdapter;
  }
  
  @NotNull
  public List<E> decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    return CollectionsKt.listOf(this.originalAdapter.decode(paramProtoReader));
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull List<? extends E> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramList, "value");
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      this.originalAdapter.encode(paramProtoWriter, paramList.get(i));
      i += 1;
    }
  }
  
  public void encodeWithTag(@NotNull ProtoWriter paramProtoWriter, int paramInt, @Nullable List<? extends E> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    if ((paramList != null) && ((((Collection)paramList).isEmpty() ^ true))) {
      super.encodeWithTag(paramProtoWriter, paramInt, paramList);
    }
  }
  
  public int encodedSize(@NotNull List<? extends E> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "value");
    int k = paramList.size();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += this.originalAdapter.encodedSize(paramList.get(i));
      i += 1;
    }
    return j;
  }
  
  public int encodedSizeWithTag(int paramInt, @Nullable List<? extends E> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      return super.encodedSizeWithTag(paramInt, paramList);
    }
    return 0;
  }
  
  @NotNull
  public List<E> redact(@NotNull List<? extends E> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "value");
    return CollectionsKt.emptyList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.PackedProtoAdapter
 * JD-Core Version:    0.7.0.1
 */