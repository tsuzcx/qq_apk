package com.google.protobuf;

class Utf8$DecodeUtil
{
  private static char a(int paramInt)
  {
    return (char)((paramInt >>> 10) + 55232);
  }
  
  private static char b(int paramInt)
  {
    return (char)((paramInt & 0x3FF) + 56320);
  }
  
  private static void b(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, char[] paramArrayOfChar, int paramInt)
  {
    if ((!g(paramByte2)) && ((paramByte1 << 28) + (paramByte2 + 112) >> 30 == 0) && (!g(paramByte3)) && (!g(paramByte4)))
    {
      paramByte1 = (paramByte1 & 0x7) << 18 | h(paramByte2) << 12 | h(paramByte3) << 6 | h(paramByte4);
      paramArrayOfChar[paramInt] = a(paramByte1);
      paramArrayOfChar[(paramInt + 1)] = b(paramByte1);
      return;
    }
    throw InvalidProtocolBufferException.invalidUtf8();
  }
  
  private static void b(byte paramByte1, byte paramByte2, byte paramByte3, char[] paramArrayOfChar, int paramInt)
  {
    if ((!g(paramByte2)) && ((paramByte1 != -32) || (paramByte2 >= -96)) && ((paramByte1 != -19) || (paramByte2 < -96)) && (!g(paramByte3)))
    {
      paramArrayOfChar[paramInt] = ((char)((paramByte1 & 0xF) << 12 | h(paramByte2) << 6 | h(paramByte3)));
      return;
    }
    throw InvalidProtocolBufferException.invalidUtf8();
  }
  
  private static void b(byte paramByte1, byte paramByte2, char[] paramArrayOfChar, int paramInt)
  {
    if ((paramByte1 >= -62) && (!g(paramByte2)))
    {
      paramArrayOfChar[paramInt] = ((char)((paramByte1 & 0x1F) << 6 | h(paramByte2)));
      return;
    }
    throw InvalidProtocolBufferException.invalidUtf8();
  }
  
  private static void b(byte paramByte, char[] paramArrayOfChar, int paramInt)
  {
    paramArrayOfChar[paramInt] = ((char)paramByte);
  }
  
  private static boolean d(byte paramByte)
  {
    return paramByte >= 0;
  }
  
  private static boolean e(byte paramByte)
  {
    return paramByte < -32;
  }
  
  private static boolean f(byte paramByte)
  {
    return paramByte < -16;
  }
  
  private static boolean g(byte paramByte)
  {
    return paramByte > -65;
  }
  
  private static int h(byte paramByte)
  {
    return paramByte & 0x3F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Utf8.DecodeUtil
 * JD-Core Version:    0.7.0.1
 */