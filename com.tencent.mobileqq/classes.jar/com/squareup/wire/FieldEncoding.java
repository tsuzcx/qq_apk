package com.squareup.wire;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/squareup/wire/FieldEncoding;", "", "value", "", "(Ljava/lang/String;II)V", "getValue$wire_runtime", "()I", "rawProtoAdapter", "Lcom/squareup/wire/ProtoAdapter;", "VARINT", "FIXED64", "LENGTH_DELIMITED", "FIXED32", "Companion", "wire-runtime"}, k=1, mv={1, 1, 16})
public enum FieldEncoding
{
  public static final FieldEncoding.Companion Companion = new FieldEncoding.Companion(null);
  private final int value;
  
  static
  {
    FieldEncoding localFieldEncoding1 = new FieldEncoding("VARINT", 0, 0);
    VARINT = localFieldEncoding1;
    FieldEncoding localFieldEncoding2 = new FieldEncoding("FIXED64", 1, 1);
    FIXED64 = localFieldEncoding2;
    FieldEncoding localFieldEncoding3 = new FieldEncoding("LENGTH_DELIMITED", 2, 2);
    LENGTH_DELIMITED = localFieldEncoding3;
    FieldEncoding localFieldEncoding4 = new FieldEncoding("FIXED32", 3, 5);
    FIXED32 = localFieldEncoding4;
    $VALUES = new FieldEncoding[] { localFieldEncoding1, localFieldEncoding2, localFieldEncoding3, localFieldEncoding4 };
  }
  
  private FieldEncoding(int paramInt)
  {
    this.value = paramInt;
  }
  
  @JvmStatic
  @NotNull
  public static final FieldEncoding get$wire_runtime(int paramInt)
  {
    return Companion.get$wire_runtime(paramInt);
  }
  
  public final int getValue$wire_runtime()
  {
    return this.value;
  }
  
  @NotNull
  public final ProtoAdapter<?> rawProtoAdapter()
  {
    int i = FieldEncoding.WhenMappings.$EnumSwitchMapping$0[ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 4) {
            return ProtoAdapter.BYTES;
          }
          throw new NoWhenBranchMatchedException();
        }
        return ProtoAdapter.FIXED64;
      }
      return ProtoAdapter.FIXED32;
    }
    return ProtoAdapter.UINT64;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.FieldEncoding
 * JD-Core Version:    0.7.0.1
 */