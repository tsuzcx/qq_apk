package com.qq.android.dexposed.utility;

import java.lang.reflect.Method;
import me.weishu.epic.art.method.ArtMethod;

public final class Debug
{
  public static final boolean DEBUG = false;
  private static final String RELASE_WRAN_STRING = "none in release mode.";
  private static final String TAG = "Dexposed";
  
  public static String addrHex(long paramLong)
  {
    return "none in release mode.";
  }
  
  public static String byteHex(byte paramByte)
  {
    return String.format("%02X", new Object[] { Byte.valueOf(paramByte) });
  }
  
  public static String dump(byte[] paramArrayOfByte, long paramLong)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte.length) {
        return localStringBuffer.toString();
      }
      if (i % 8 == 0) {
        localStringBuffer.append(addrHex(i + paramLong)).append(":");
      }
      localStringBuffer.append(byteHex(paramArrayOfByte[i])).append(" ");
      if (i % 8 == 7) {
        localStringBuffer.append("\n");
      }
      i += 1;
    }
  }
  
  /* Error */
  public static void dumpMaps()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_0
    //   2: aconst_null
    //   3: astore_2
    //   4: new 65	java/io/BufferedReader
    //   7: dup
    //   8: new 67	java/io/FileReader
    //   11: dup
    //   12: ldc 69
    //   14: invokespecial 72	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   17: invokespecial 75	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   20: astore_1
    //   21: aload_1
    //   22: invokevirtual 78	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   25: astore_0
    //   26: aload_0
    //   27: ifnonnull +12 -> 39
    //   30: aload_1
    //   31: ifnull +71 -> 102
    //   34: aload_1
    //   35: invokevirtual 81	java/io/BufferedReader:close	()V
    //   38: return
    //   39: ldc 14
    //   41: aload_0
    //   42: invokestatic 87	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   45: pop
    //   46: goto -25 -> 21
    //   49: astore_0
    //   50: aload_1
    //   51: astore_0
    //   52: ldc 14
    //   54: ldc 89
    //   56: invokestatic 92	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   59: pop
    //   60: aload_1
    //   61: ifnull -23 -> 38
    //   64: aload_1
    //   65: invokevirtual 81	java/io/BufferedReader:close	()V
    //   68: return
    //   69: astore_0
    //   70: return
    //   71: astore_1
    //   72: aload_0
    //   73: ifnull +7 -> 80
    //   76: aload_0
    //   77: invokevirtual 81	java/io/BufferedReader:close	()V
    //   80: aload_1
    //   81: athrow
    //   82: astore_0
    //   83: return
    //   84: astore_0
    //   85: goto -5 -> 80
    //   88: astore_2
    //   89: aload_1
    //   90: astore_0
    //   91: aload_2
    //   92: astore_1
    //   93: goto -21 -> 72
    //   96: astore_0
    //   97: aload_2
    //   98: astore_1
    //   99: goto -49 -> 50
    //   102: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	41	0	str	String
    //   49	1	0	localIOException1	java.io.IOException
    //   51	1	0	localObject1	Object
    //   69	8	0	localIOException2	java.io.IOException
    //   82	1	0	localIOException3	java.io.IOException
    //   84	1	0	localIOException4	java.io.IOException
    //   90	1	0	localObject2	Object
    //   96	1	0	localIOException5	java.io.IOException
    //   20	45	1	localBufferedReader	java.io.BufferedReader
    //   71	19	1	localObject3	Object
    //   92	7	1	localObject4	Object
    //   3	1	2	localObject5	Object
    //   88	10	2	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   21	26	49	java/io/IOException
    //   39	46	49	java/io/IOException
    //   64	68	69	java/io/IOException
    //   4	21	71	finally
    //   52	60	71	finally
    //   34	38	82	java/io/IOException
    //   76	80	84	java/io/IOException
    //   21	26	88	finally
    //   39	46	88	finally
    //   4	21	96	java/io/IOException
  }
  
  public static String hexdump(byte[] paramArrayOfByte, long paramLong)
  {
    return "none in release mode.";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.qq.android.dexposed.utility.Debug
 * JD-Core Version:    0.7.0.1
 */