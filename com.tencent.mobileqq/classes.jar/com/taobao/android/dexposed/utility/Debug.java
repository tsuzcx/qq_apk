package com.taobao.android.dexposed.utility;

import java.lang.reflect.Method;
import me.weishu.epic.art.method.ArtMethod;

public final class Debug
{
  public static final boolean DEBUG = true;
  private static final String RELASE_WRAN_STRING = "none in release mode.";
  private static final String TAG = "Dexposed";
  
  public static String addrHex(long paramLong)
  {
    if (Runtime.is64Bit()) {
      return longHex(paramLong);
    }
    return intHex((int)paramLong);
  }
  
  public static String byteHex(byte paramByte)
  {
    return String.format("%02X", new Object[] { Byte.valueOf(paramByte) });
  }
  
  public static String dump(byte[] paramArrayOfByte, long paramLong)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      if (i % 8 == 0) {
        localStringBuffer.append(addrHex(i + paramLong)).append(":");
      }
      localStringBuffer.append(byteHex(paramArrayOfByte[i])).append(" ");
      if (i % 8 == 7) {
        localStringBuffer.append("\n");
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  /* Error */
  public static void dumpMaps()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_0
    //   2: new 78	java/io/BufferedReader
    //   5: dup
    //   6: new 80	java/io/FileReader
    //   9: dup
    //   10: ldc 82
    //   12: invokespecial 85	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   15: invokespecial 88	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   18: astore_1
    //   19: aload_1
    //   20: astore_0
    //   21: aload_1
    //   22: invokevirtual 91	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   25: astore_2
    //   26: aload_2
    //   27: ifnull +35 -> 62
    //   30: aload_1
    //   31: astore_0
    //   32: ldc 14
    //   34: aload_2
    //   35: invokestatic 97	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   38: pop
    //   39: goto -20 -> 19
    //   42: astore_0
    //   43: aload_1
    //   44: astore_0
    //   45: ldc 14
    //   47: ldc 99
    //   49: invokestatic 102	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   52: pop
    //   53: aload_1
    //   54: ifnull +7 -> 61
    //   57: aload_1
    //   58: invokevirtual 105	java/io/BufferedReader:close	()V
    //   61: return
    //   62: aload_1
    //   63: ifnull -2 -> 61
    //   66: aload_1
    //   67: invokevirtual 105	java/io/BufferedReader:close	()V
    //   70: return
    //   71: astore_0
    //   72: return
    //   73: astore_2
    //   74: aload_0
    //   75: astore_1
    //   76: aload_2
    //   77: astore_0
    //   78: aload_1
    //   79: ifnull +7 -> 86
    //   82: aload_1
    //   83: invokevirtual 105	java/io/BufferedReader:close	()V
    //   86: aload_0
    //   87: athrow
    //   88: astore_0
    //   89: return
    //   90: astore_1
    //   91: goto -5 -> 86
    //   94: astore_2
    //   95: aload_0
    //   96: astore_1
    //   97: aload_2
    //   98: astore_0
    //   99: goto -21 -> 78
    //   102: astore_0
    //   103: aconst_null
    //   104: astore_1
    //   105: goto -62 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	31	0	localObject1	Object
    //   42	1	0	localIOException1	java.io.IOException
    //   44	1	0	localObject2	Object
    //   71	4	0	localIOException2	java.io.IOException
    //   77	10	0	localObject3	Object
    //   88	8	0	localIOException3	java.io.IOException
    //   98	1	0	localObject4	Object
    //   102	1	0	localIOException4	java.io.IOException
    //   18	65	1	localObject5	Object
    //   90	1	1	localIOException5	java.io.IOException
    //   96	9	1	localIOException6	java.io.IOException
    //   25	10	2	str	String
    //   73	4	2	localObject6	Object
    //   94	4	2	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   21	26	42	java/io/IOException
    //   32	39	42	java/io/IOException
    //   66	70	71	java/io/IOException
    //   2	19	73	finally
    //   57	61	88	java/io/IOException
    //   82	86	90	java/io/IOException
    //   21	26	94	finally
    //   32	39	94	finally
    //   45	53	94	finally
    //   2	19	102	java/io/IOException
  }
  
  public static String hexdump(byte[] paramArrayOfByte, long paramLong)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      if (i % 8 == 0) {
        localStringBuffer.append(addrHex(i + paramLong)).append(":");
      }
      localStringBuffer.append(byteHex(paramArrayOfByte[i])).append(" ");
      if (i % 8 == 7) {
        localStringBuffer.append("\n");
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String intHex(int paramInt)
  {
    return String.format("0x%08X", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static String longHex(long paramLong)
  {
    return String.format("0x%016X", new Object[] { Long.valueOf(paramLong) });
  }
  
  public static String methodDescription(Method paramMethod)
  {
    return paramMethod.getDeclaringClass().getName() + "->" + paramMethod.getName() + " @" + addrHex(ArtMethod.of(paramMethod).getEntryPointFromQuickCompiledCode()) + " +" + addrHex(ArtMethod.of(paramMethod).getAddress());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.taobao.android.dexposed.utility.Debug
 * JD-Core Version:    0.7.0.1
 */