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
    //   2: new 65	java/io/BufferedReader
    //   5: dup
    //   6: new 67	java/io/FileReader
    //   9: dup
    //   10: ldc 69
    //   12: invokespecial 72	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   15: invokespecial 75	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   18: astore_1
    //   19: aload_1
    //   20: astore_0
    //   21: aload_1
    //   22: invokevirtual 78	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   25: astore_2
    //   26: aload_2
    //   27: ifnonnull +12 -> 39
    //   30: aload_1
    //   31: ifnull +7 -> 38
    //   34: aload_1
    //   35: invokevirtual 81	java/io/BufferedReader:close	()V
    //   38: return
    //   39: aload_1
    //   40: astore_0
    //   41: ldc 14
    //   43: aload_2
    //   44: invokestatic 87	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   47: pop
    //   48: goto -29 -> 19
    //   51: astore_0
    //   52: aload_1
    //   53: astore_0
    //   54: ldc 14
    //   56: ldc 89
    //   58: invokestatic 92	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   61: pop
    //   62: aload_1
    //   63: ifnull -25 -> 38
    //   66: aload_1
    //   67: invokevirtual 81	java/io/BufferedReader:close	()V
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
    //   83: invokevirtual 81	java/io/BufferedReader:close	()V
    //   86: aload_0
    //   87: athrow
    //   88: astore_1
    //   89: goto -3 -> 86
    //   92: astore_0
    //   93: return
    //   94: astore_2
    //   95: aload_0
    //   96: astore_1
    //   97: aload_2
    //   98: astore_0
    //   99: goto -21 -> 78
    //   102: astore_0
    //   103: aconst_null
    //   104: astore_1
    //   105: goto -53 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	40	0	localObject1	Object
    //   51	1	0	localIOException1	java.io.IOException
    //   53	1	0	localObject2	Object
    //   71	4	0	localIOException2	java.io.IOException
    //   77	10	0	localObject3	Object
    //   92	4	0	localIOException3	java.io.IOException
    //   98	1	0	localObject4	Object
    //   102	1	0	localIOException4	java.io.IOException
    //   18	65	1	localObject5	Object
    //   88	1	1	localIOException5	java.io.IOException
    //   96	9	1	localIOException6	java.io.IOException
    //   25	19	2	str	String
    //   73	4	2	localObject6	Object
    //   94	4	2	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   21	26	51	java/io/IOException
    //   41	48	51	java/io/IOException
    //   66	70	71	java/io/IOException
    //   2	19	73	finally
    //   82	86	88	java/io/IOException
    //   34	38	92	java/io/IOException
    //   21	26	94	finally
    //   41	48	94	finally
    //   54	62	94	finally
    //   2	19	102	java/io/IOException
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