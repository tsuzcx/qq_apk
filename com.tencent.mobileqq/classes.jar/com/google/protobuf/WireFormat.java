package com.google.protobuf;

public final class WireFormat
{
  static final int a = a(1, 3);
  static final int b = a(1, 4);
  static final int c = a(2, 0);
  static final int d = a(3, 2);
  
  public static int a(int paramInt)
  {
    return paramInt & 0x7;
  }
  
  static int a(int paramInt1, int paramInt2)
  {
    return paramInt1 << 3 | paramInt2;
  }
  
  static Object a(CodedInputStream paramCodedInputStream, WireFormat.FieldType paramFieldType, WireFormat.Utf8Validation paramUtf8Validation)
  {
    switch (WireFormat.1.a[paramFieldType.ordinal()])
    {
    default: 
      throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    case 18: 
      throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
    case 17: 
      throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
    case 16: 
      throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
    case 15: 
      return paramUtf8Validation.readString(paramCodedInputStream);
    case 14: 
      return Long.valueOf(paramCodedInputStream.r());
    case 13: 
      return Integer.valueOf(paramCodedInputStream.q());
    case 12: 
      return Long.valueOf(paramCodedInputStream.p());
    case 11: 
      return Integer.valueOf(paramCodedInputStream.o());
    case 10: 
      return Integer.valueOf(paramCodedInputStream.m());
    case 9: 
      return paramCodedInputStream.l();
    case 8: 
      return Boolean.valueOf(paramCodedInputStream.i());
    case 7: 
      return Integer.valueOf(paramCodedInputStream.h());
    case 6: 
      return Long.valueOf(paramCodedInputStream.g());
    case 5: 
      return Integer.valueOf(paramCodedInputStream.f());
    case 4: 
      return Long.valueOf(paramCodedInputStream.d());
    case 3: 
      return Long.valueOf(paramCodedInputStream.e());
    case 2: 
      return Float.valueOf(paramCodedInputStream.c());
    }
    return Double.valueOf(paramCodedInputStream.b());
  }
  
  public static int b(int paramInt)
  {
    return paramInt >>> 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.WireFormat
 * JD-Core Version:    0.7.0.1
 */