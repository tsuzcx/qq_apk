package com.squareup.wire.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"and", "", "", "other", "shl", "wire-runtime"}, k=2, mv={1, 1, 16})
@JvmName(name="RuntimeUtils")
public final class RuntimeUtils
{
  public static final int and(byte paramByte, int paramInt)
  {
    return paramByte & paramInt;
  }
  
  public static final int shl(byte paramByte, int paramInt)
  {
    return paramByte << paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.internal.RuntimeUtils
 * JD-Core Version:    0.7.0.1
 */