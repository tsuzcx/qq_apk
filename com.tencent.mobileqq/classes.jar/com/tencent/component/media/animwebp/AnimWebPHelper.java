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
    //   1: ifnull +114 -> 115
    //   4: new 19	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 22	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   12: astore_2
    //   13: aload_2
    //   14: astore_0
    //   15: aload_2
    //   16: invokevirtual 26	java/io/FileInputStream:available	()I
    //   19: newarray byte
    //   21: astore_3
    //   22: aload_2
    //   23: astore_0
    //   24: aload_2
    //   25: aload_3
    //   26: invokevirtual 30	java/io/FileInputStream:read	([B)I
    //   29: istore_1
    //   30: iload_1
    //   31: ifgt +16 -> 47
    //   34: aload_2
    //   35: invokevirtual 33	java/io/FileInputStream:close	()V
    //   38: aconst_null
    //   39: areturn
    //   40: astore_0
    //   41: aload_0
    //   42: invokevirtual 36	java/io/IOException:printStackTrace	()V
    //   45: aconst_null
    //   46: areturn
    //   47: aload_2
    //   48: invokevirtual 33	java/io/FileInputStream:close	()V
    //   51: aload_3
    //   52: areturn
    //   53: astore_0
    //   54: aload_0
    //   55: invokevirtual 36	java/io/IOException:printStackTrace	()V
    //   58: aload_3
    //   59: areturn
    //   60: astore_3
    //   61: goto +12 -> 73
    //   64: astore_2
    //   65: aconst_null
    //   66: astore_0
    //   67: goto +30 -> 97
    //   70: astore_3
    //   71: aconst_null
    //   72: astore_2
    //   73: aload_2
    //   74: astore_0
    //   75: aload_3
    //   76: invokevirtual 36	java/io/IOException:printStackTrace	()V
    //   79: aload_2
    //   80: ifnull +14 -> 94
    //   83: aload_2
    //   84: invokevirtual 33	java/io/FileInputStream:close	()V
    //   87: aconst_null
    //   88: areturn
    //   89: astore_0
    //   90: aload_0
    //   91: invokevirtual 36	java/io/IOException:printStackTrace	()V
    //   94: aconst_null
    //   95: areturn
    //   96: astore_2
    //   97: aload_0
    //   98: ifnull +15 -> 113
    //   101: aload_0
    //   102: invokevirtual 33	java/io/FileInputStream:close	()V
    //   105: goto +8 -> 113
    //   108: astore_0
    //   109: aload_0
    //   110: invokevirtual 36	java/io/IOException:printStackTrace	()V
    //   113: aload_2
    //   114: athrow
    //   115: aconst_null
    //   116: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	paramString	String
    //   29	2	1	i	int
    //   12	36	2	localFileInputStream	java.io.FileInputStream
    //   64	1	2	localObject1	Object
    //   72	12	2	localObject2	Object
    //   96	18	2	localObject3	Object
    //   21	38	3	arrayOfByte	byte[]
    //   60	1	3	localIOException1	java.io.IOException
    //   70	6	3	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   34	38	40	java/io/IOException
    //   47	51	53	java/io/IOException
    //   15	22	60	java/io/IOException
    //   24	30	60	java/io/IOException
    //   4	13	64	finally
    //   4	13	70	java/io/IOException
    //   83	87	89	java/io/IOException
    //   15	22	96	finally
    //   24	30	96	finally
    //   75	79	96	finally
    //   101	105	108	java/io/IOException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.animwebp.AnimWebPHelper
 * JD-Core Version:    0.7.0.1
 */