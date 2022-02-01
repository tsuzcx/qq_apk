package com.tencent.component.media.animwebp;

import android.text.TextUtils;
import com.tencent.component.media.ImageManagerEnv;

public class AnimWebPHelper
{
  private static boolean loadSoSucc = false;
  
  /* Error */
  public static byte[] bytesFromFile(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +41 -> 42
    //   4: new 20	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 23	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   12: astore_2
    //   13: aload_2
    //   14: astore_0
    //   15: aload_2
    //   16: invokevirtual 27	java/io/FileInputStream:available	()I
    //   19: newarray byte
    //   21: astore_3
    //   22: aload_2
    //   23: astore_0
    //   24: aload_2
    //   25: aload_3
    //   26: invokevirtual 31	java/io/FileInputStream:read	([B)I
    //   29: istore_1
    //   30: iload_1
    //   31: ifgt +20 -> 51
    //   34: aload_2
    //   35: ifnull +7 -> 42
    //   38: aload_2
    //   39: invokevirtual 34	java/io/FileInputStream:close	()V
    //   42: aconst_null
    //   43: areturn
    //   44: astore_0
    //   45: aload_0
    //   46: invokevirtual 37	java/io/IOException:printStackTrace	()V
    //   49: aconst_null
    //   50: areturn
    //   51: aload_2
    //   52: ifnull +7 -> 59
    //   55: aload_2
    //   56: invokevirtual 34	java/io/FileInputStream:close	()V
    //   59: aload_3
    //   60: areturn
    //   61: astore_0
    //   62: aload_0
    //   63: invokevirtual 37	java/io/IOException:printStackTrace	()V
    //   66: goto -7 -> 59
    //   69: astore_3
    //   70: aconst_null
    //   71: astore_2
    //   72: aload_2
    //   73: astore_0
    //   74: aload_3
    //   75: invokevirtual 37	java/io/IOException:printStackTrace	()V
    //   78: aload_2
    //   79: ifnull -37 -> 42
    //   82: aload_2
    //   83: invokevirtual 34	java/io/FileInputStream:close	()V
    //   86: aconst_null
    //   87: areturn
    //   88: astore_0
    //   89: aload_0
    //   90: invokevirtual 37	java/io/IOException:printStackTrace	()V
    //   93: aconst_null
    //   94: areturn
    //   95: astore_2
    //   96: aconst_null
    //   97: astore_0
    //   98: aload_0
    //   99: ifnull +7 -> 106
    //   102: aload_0
    //   103: invokevirtual 34	java/io/FileInputStream:close	()V
    //   106: aload_2
    //   107: athrow
    //   108: astore_0
    //   109: aload_0
    //   110: invokevirtual 37	java/io/IOException:printStackTrace	()V
    //   113: goto -7 -> 106
    //   116: astore_2
    //   117: goto -19 -> 98
    //   120: astore_3
    //   121: goto -49 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	paramString	String
    //   29	2	1	i	int
    //   12	71	2	localFileInputStream	java.io.FileInputStream
    //   95	12	2	localObject1	Object
    //   116	1	2	localObject2	Object
    //   21	39	3	arrayOfByte	byte[]
    //   69	6	3	localIOException1	java.io.IOException
    //   120	1	3	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   38	42	44	java/io/IOException
    //   55	59	61	java/io/IOException
    //   4	13	69	java/io/IOException
    //   82	86	88	java/io/IOException
    //   4	13	95	finally
    //   102	106	108	java/io/IOException
    //   15	22	116	finally
    //   24	30	116	finally
    //   74	78	116	finally
    //   15	22	120	java/io/IOException
    //   24	30	120	java/io/IOException
  }
  
  public static boolean isAnimWebP(String paramString)
  {
    return AnimWebPNative.isAnimWebP(bytesFromFile(paramString));
  }
  
  public static boolean isAnimWebP(byte[] paramArrayOfByte)
  {
    return AnimWebPNative.isAnimWebP(paramArrayOfByte);
  }
  
  public static boolean isAnimWebpUrl(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.contains("bizpf=webp"));
  }
  
  public static boolean isReady()
  {
    if (!loadSoSucc) {
      loadWebpSo();
    }
    return loadSoSucc;
  }
  
  public static void loadWebpSo()
  {
    loadSoSucc = ImageManagerEnv.g().loadLibrary("animatedWebp");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.media.animwebp.AnimWebPHelper
 * JD-Core Version:    0.7.0.1
 */