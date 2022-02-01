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
      int j = i % 8;
      if (j == 0)
      {
        localStringBuffer.append(addrHex(i + paramLong));
        localStringBuffer.append(":");
      }
      localStringBuffer.append(byteHex(paramArrayOfByte[i]));
      localStringBuffer.append(" ");
      if (j == 7) {
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
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_0
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
    //   27: ifnonnull +8 -> 35
    //   30: aload_1
    //   31: invokevirtual 81	java/io/BufferedReader:close	()V
    //   34: return
    //   35: ldc 14
    //   37: aload_0
    //   38: invokestatic 87	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   41: pop
    //   42: goto -21 -> 21
    //   45: astore_2
    //   46: aload_1
    //   47: astore_0
    //   48: aload_2
    //   49: astore_1
    //   50: goto +29 -> 79
    //   53: goto +7 -> 60
    //   56: astore_1
    //   57: goto +22 -> 79
    //   60: aload_1
    //   61: astore_0
    //   62: ldc 14
    //   64: ldc 89
    //   66: invokestatic 92	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   69: pop
    //   70: aload_1
    //   71: ifnull +7 -> 78
    //   74: aload_1
    //   75: invokevirtual 81	java/io/BufferedReader:close	()V
    //   78: return
    //   79: aload_0
    //   80: ifnull +7 -> 87
    //   83: aload_0
    //   84: invokevirtual 81	java/io/BufferedReader:close	()V
    //   87: goto +5 -> 92
    //   90: aload_1
    //   91: athrow
    //   92: goto -2 -> 90
    //   95: astore_0
    //   96: aload_2
    //   97: astore_1
    //   98: goto -38 -> 60
    //   101: astore_0
    //   102: goto -49 -> 53
    //   105: astore_0
    //   106: return
    //   107: astore_0
    //   108: goto -21 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	81	0	localObject1	Object
    //   95	1	0	localIOException1	java.io.IOException
    //   101	1	0	localIOException2	java.io.IOException
    //   105	1	0	localIOException3	java.io.IOException
    //   107	1	0	localIOException4	java.io.IOException
    //   20	30	1	localObject2	Object
    //   56	35	1	localObject3	Object
    //   97	1	1	localObject4	Object
    //   1	1	2	localObject5	Object
    //   45	52	2	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   21	26	45	finally
    //   35	42	45	finally
    //   4	21	56	finally
    //   62	70	56	finally
    //   4	21	95	java/io/IOException
    //   21	26	101	java/io/IOException
    //   35	42	101	java/io/IOException
    //   30	34	105	java/io/IOException
    //   74	78	105	java/io/IOException
    //   83	87	107	java/io/IOException
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
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramMethod.getDeclaringClass().getName()));
    localStringBuilder.append("->");
    localStringBuilder.append(paramMethod.getName());
    localStringBuilder.append(" @");
    localStringBuilder.append(addrHex(ArtMethod.of(paramMethod).getEntryPointFromQuickCompiledCode()));
    localStringBuilder.append(" +");
    localStringBuilder.append(addrHex(ArtMethod.of(paramMethod).getAddress()));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.android.dexposed.utility.Debug
 * JD-Core Version:    0.7.0.1
 */