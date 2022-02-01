package com.android.dx.merge;

import com.android.dex.DexException;
import com.android.dex.EncodedValueCodec;
import com.android.dex.EncodedValueReader;
import com.android.dex.Leb128;
import com.android.dex.util.ByteOutput;

final class IndexMap$EncodedValueTransformer
{
  private final ByteOutput out;
  
  public IndexMap$EncodedValueTransformer(IndexMap paramIndexMap, ByteOutput paramByteOutput)
  {
    this.out = paramByteOutput;
  }
  
  private void transformAnnotation(EncodedValueReader paramEncodedValueReader)
  {
    int j = paramEncodedValueReader.readAnnotation();
    Leb128.writeUnsignedLeb128(this.out, this.this$0.adjustType(paramEncodedValueReader.getAnnotationType()));
    Leb128.writeUnsignedLeb128(this.out, j);
    int i = 0;
    while (i < j)
    {
      Leb128.writeUnsignedLeb128(this.out, this.this$0.adjustString(paramEncodedValueReader.readAnnotationName()));
      transform(paramEncodedValueReader);
      i += 1;
    }
  }
  
  private void transformArray(EncodedValueReader paramEncodedValueReader)
  {
    int j = paramEncodedValueReader.readArray();
    Leb128.writeUnsignedLeb128(this.out, j);
    int i = 0;
    while (i < j)
    {
      transform(paramEncodedValueReader);
      i += 1;
    }
  }
  
  private void writeTypeAndArg(int paramInt1, int paramInt2)
  {
    this.out.writeByte(paramInt2 << 5 | paramInt1);
  }
  
  public void transform(EncodedValueReader paramEncodedValueReader)
  {
    int i = 0;
    switch (paramEncodedValueReader.peek())
    {
    case 1: 
    case 5: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    default: 
      throw new DexException("Unexpected type: " + Integer.toHexString(paramEncodedValueReader.peek()));
    case 0: 
      EncodedValueCodec.writeSignedIntegralValue(this.out, 0, paramEncodedValueReader.readByte());
      return;
    case 2: 
      EncodedValueCodec.writeSignedIntegralValue(this.out, 2, paramEncodedValueReader.readShort());
      return;
    case 4: 
      EncodedValueCodec.writeSignedIntegralValue(this.out, 4, paramEncodedValueReader.readInt());
      return;
    case 6: 
      EncodedValueCodec.writeSignedIntegralValue(this.out, 6, paramEncodedValueReader.readLong());
      return;
    case 3: 
      EncodedValueCodec.writeUnsignedIntegralValue(this.out, 3, paramEncodedValueReader.readChar());
      return;
    case 16: 
      long l = Float.floatToIntBits(paramEncodedValueReader.readFloat());
      EncodedValueCodec.writeRightZeroExtendedValue(this.out, 16, l << 32);
      return;
    case 17: 
      EncodedValueCodec.writeRightZeroExtendedValue(this.out, 17, Double.doubleToLongBits(paramEncodedValueReader.readDouble()));
      return;
    case 23: 
      EncodedValueCodec.writeUnsignedIntegralValue(this.out, 23, this.this$0.adjustString(paramEncodedValueReader.readString()));
      return;
    case 24: 
      EncodedValueCodec.writeUnsignedIntegralValue(this.out, 24, this.this$0.adjustType(paramEncodedValueReader.readType()));
      return;
    case 25: 
      EncodedValueCodec.writeUnsignedIntegralValue(this.out, 25, this.this$0.adjustField(paramEncodedValueReader.readField()));
      return;
    case 27: 
      EncodedValueCodec.writeUnsignedIntegralValue(this.out, 27, this.this$0.adjustField(paramEncodedValueReader.readEnum()));
      return;
    case 26: 
      EncodedValueCodec.writeUnsignedIntegralValue(this.out, 26, this.this$0.adjustMethod(paramEncodedValueReader.readMethod()));
      return;
    case 28: 
      writeTypeAndArg(28, 0);
      transformArray(paramEncodedValueReader);
      return;
    case 29: 
      writeTypeAndArg(29, 0);
      transformAnnotation(paramEncodedValueReader);
      return;
    case 30: 
      paramEncodedValueReader.readNull();
      writeTypeAndArg(30, 0);
      return;
    }
    if (paramEncodedValueReader.readBoolean()) {
      i = 1;
    }
    writeTypeAndArg(31, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.merge.IndexMap.EncodedValueTransformer
 * JD-Core Version:    0.7.0.1
 */