package com.squareup.okhttp.internal.framed;

final class Http2$FrameLogger
{
  private static final String[] BINARY;
  private static final String[] FLAGS;
  private static final String[] TYPES;
  
  static
  {
    int k = 0;
    TYPES = new String[] { "DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION" };
    FLAGS = new String[64];
    BINARY = new String[256];
    int i = 0;
    while (i < BINARY.length)
    {
      BINARY[i] = String.format("%8s", new Object[] { Integer.toBinaryString(i) }).replace(' ', '0');
      i += 1;
    }
    FLAGS[0] = "";
    FLAGS[1] = "END_STREAM";
    int[] arrayOfInt1 = new int[1];
    arrayOfInt1[0] = 1;
    FLAGS[8] = "PADDED";
    int j = arrayOfInt1.length;
    i = 0;
    while (i < j)
    {
      m = arrayOfInt1[i];
      FLAGS[(m | 0x8)] = (FLAGS[m] + "|PADDED");
      i += 1;
    }
    FLAGS[4] = "END_HEADERS";
    FLAGS[32] = "PRIORITY";
    FLAGS[36] = "END_HEADERS|PRIORITY";
    int[] arrayOfInt2 = new int[3];
    int[] tmp242_240 = arrayOfInt2;
    tmp242_240[0] = 4;
    int[] tmp246_242 = tmp242_240;
    tmp246_242[1] = 32;
    int[] tmp251_246 = tmp246_242;
    tmp251_246[2] = 36;
    tmp251_246;
    int m = arrayOfInt2.length;
    i = 0;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      int n = arrayOfInt2[i];
      int i1 = arrayOfInt1.length;
      j = 0;
      while (j < i1)
      {
        int i2 = arrayOfInt1[j];
        FLAGS[(i2 | n)] = (FLAGS[i2] + '|' + FLAGS[n]);
        FLAGS[(i2 | n | 0x8)] = (FLAGS[i2] + '|' + FLAGS[n] + "|PADDED");
        j += 1;
      }
      i += 1;
    }
    while (j < FLAGS.length)
    {
      if (FLAGS[j] == null) {
        FLAGS[j] = BINARY[j];
      }
      j += 1;
    }
  }
  
  static String formatFlags(byte paramByte1, byte paramByte2)
  {
    Object localObject;
    if (paramByte2 == 0) {
      localObject = "";
    }
    String str;
    do
    {
      do
      {
        return localObject;
        switch (paramByte1)
        {
        case 5: 
        default: 
          if (paramByte2 >= FLAGS.length) {
            break;
          }
        }
        for (str = FLAGS[paramByte2]; (paramByte1 == 5) && ((paramByte2 & 0x4) != 0); str = BINARY[paramByte2])
        {
          return str.replace("HEADERS", "PUSH_PROMISE");
          if (paramByte2 == 1) {
            return "ACK";
          }
          return BINARY[paramByte2];
          return BINARY[paramByte2];
        }
        localObject = str;
      } while (paramByte1 != 0);
      localObject = str;
    } while ((paramByte2 & 0x20) == 0);
    return str.replace("PRIORITY", "COMPRESSED");
  }
  
  static String formatHeader(boolean paramBoolean, int paramInt1, int paramInt2, byte paramByte1, byte paramByte2)
  {
    String str1;
    String str3;
    if (paramByte1 < TYPES.length)
    {
      str1 = TYPES[paramByte1];
      str3 = formatFlags(paramByte1, paramByte2);
      if (!paramBoolean) {
        break label91;
      }
    }
    label91:
    for (String str2 = "<<";; str2 = ">>")
    {
      return String.format("%s 0x%08x %5d %-13s %s", new Object[] { str2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str1, str3 });
      str1 = String.format("0x%02x", new Object[] { Byte.valueOf(paramByte1) });
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.framed.Http2.FrameLogger
 * JD-Core Version:    0.7.0.1
 */