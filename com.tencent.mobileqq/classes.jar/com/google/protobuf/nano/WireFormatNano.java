package com.google.protobuf.nano;

public final class WireFormatNano
{
  public static final boolean[] EMPTY_BOOLEAN_ARRAY;
  public static final byte[] EMPTY_BYTES = new byte[0];
  public static final byte[][] EMPTY_BYTES_ARRAY;
  public static final double[] EMPTY_DOUBLE_ARRAY;
  public static final float[] EMPTY_FLOAT_ARRAY;
  public static final int[] EMPTY_INT_ARRAY = new int[0];
  public static final long[] EMPTY_LONG_ARRAY = new long[0];
  public static final String[] EMPTY_STRING_ARRAY;
  static final int TAG_TYPE_BITS = 3;
  static final int TAG_TYPE_MASK = 7;
  static final int WIRETYPE_END_GROUP = 4;
  static final int WIRETYPE_FIXED32 = 5;
  static final int WIRETYPE_FIXED64 = 1;
  static final int WIRETYPE_LENGTH_DELIMITED = 2;
  static final int WIRETYPE_START_GROUP = 3;
  static final int WIRETYPE_VARINT = 0;
  
  static
  {
    EMPTY_FLOAT_ARRAY = new float[0];
    EMPTY_DOUBLE_ARRAY = new double[0];
    EMPTY_BOOLEAN_ARRAY = new boolean[0];
    EMPTY_STRING_ARRAY = new String[0];
    EMPTY_BYTES_ARRAY = new byte[0][];
  }
  
  public static final int getRepeatedFieldArrayLength(CodedInputByteBufferNano paramCodedInputByteBufferNano, int paramInt)
  {
    int j = paramCodedInputByteBufferNano.getPosition();
    paramCodedInputByteBufferNano.skipField(paramInt);
    int i = 1;
    while (paramCodedInputByteBufferNano.readTag() == paramInt)
    {
      paramCodedInputByteBufferNano.skipField(paramInt);
      i += 1;
    }
    paramCodedInputByteBufferNano.rewindToPosition(j);
    return i;
  }
  
  public static int getTagFieldNumber(int paramInt)
  {
    return paramInt >>> 3;
  }
  
  static int getTagWireType(int paramInt)
  {
    return paramInt & 0x7;
  }
  
  static int makeTag(int paramInt1, int paramInt2)
  {
    return paramInt1 << 3 | paramInt2;
  }
  
  public static boolean parseUnknownField(CodedInputByteBufferNano paramCodedInputByteBufferNano, int paramInt)
  {
    return paramCodedInputByteBufferNano.skipField(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.protobuf.nano.WireFormatNano
 * JD-Core Version:    0.7.0.1
 */