package com.tencent.mm.opensdk.utils;

import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class b
{
  public static Context a;
  private static final int b;
  private static final int c;
  private static final int d;
  public static ThreadPoolExecutor e = new ThreadPoolExecutor(c, d, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque());
  
  static
  {
    int i = Runtime.getRuntime().availableProcessors();
    b = i;
    c = i + 1;
    d = i * 2 + 1;
  }
  
  /* Error */
  public static int a(android.content.ContentResolver paramContentResolver, Uri paramUri)
  {
    // Byte code:
    //   0: ldc 56
    //   2: ldc 58
    //   4: invokestatic 64	com/tencent/mm/opensdk/utils/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: aload_0
    //   8: ifnull +123 -> 131
    //   11: aload_1
    //   12: ifnonnull +6 -> 18
    //   15: goto +116 -> 131
    //   18: aconst_null
    //   19: astore 4
    //   21: aconst_null
    //   22: astore_3
    //   23: aload_0
    //   24: aload_1
    //   25: invokevirtual 70	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   28: astore_0
    //   29: aload_0
    //   30: ifnonnull +13 -> 43
    //   33: aload_0
    //   34: ifnull +7 -> 41
    //   37: aload_0
    //   38: invokevirtual 75	java/io/InputStream:close	()V
    //   41: iconst_0
    //   42: ireturn
    //   43: aload_0
    //   44: astore_3
    //   45: aload_0
    //   46: astore 4
    //   48: aload_0
    //   49: invokevirtual 78	java/io/InputStream:available	()I
    //   52: istore_2
    //   53: aload_0
    //   54: invokevirtual 75	java/io/InputStream:close	()V
    //   57: iload_2
    //   58: ireturn
    //   59: astore_0
    //   60: goto +61 -> 121
    //   63: astore_0
    //   64: aload 4
    //   66: astore_3
    //   67: new 80	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   74: astore_1
    //   75: aload 4
    //   77: astore_3
    //   78: aload_1
    //   79: ldc 83
    //   81: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload 4
    //   87: astore_3
    //   88: aload_1
    //   89: aload_0
    //   90: invokevirtual 91	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   93: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload 4
    //   99: astore_3
    //   100: ldc 56
    //   102: aload_1
    //   103: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 97	com/tencent/mm/opensdk/utils/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: aload 4
    //   111: ifnull +8 -> 119
    //   114: aload 4
    //   116: invokevirtual 75	java/io/InputStream:close	()V
    //   119: iconst_0
    //   120: ireturn
    //   121: aload_3
    //   122: ifnull +7 -> 129
    //   125: aload_3
    //   126: invokevirtual 75	java/io/InputStream:close	()V
    //   129: aload_0
    //   130: athrow
    //   131: ldc 56
    //   133: ldc 99
    //   135: invokestatic 97	com/tencent/mm/opensdk/utils/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: iconst_0
    //   139: ireturn
    //   140: astore_0
    //   141: iconst_0
    //   142: ireturn
    //   143: astore_0
    //   144: iload_2
    //   145: ireturn
    //   146: astore_0
    //   147: iconst_0
    //   148: ireturn
    //   149: astore_1
    //   150: goto -21 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramContentResolver	android.content.ContentResolver
    //   0	153	1	paramUri	Uri
    //   52	93	2	i	int
    //   22	104	3	localContentResolver1	android.content.ContentResolver
    //   19	96	4	localContentResolver2	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   23	29	59	finally
    //   48	53	59	finally
    //   67	75	59	finally
    //   78	85	59	finally
    //   88	97	59	finally
    //   100	109	59	finally
    //   23	29	63	java/lang/Exception
    //   48	53	63	java/lang/Exception
    //   37	41	140	java/io/IOException
    //   53	57	143	java/io/IOException
    //   114	119	146	java/io/IOException
    //   125	129	149	java/io/IOException
  }
  
  public static int a(String paramString)
  {
    File localFile;
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return 0;
      }
      localFile = new File(paramString);
      if ((!localFile.exists()) && ((a == null) || (!paramString.startsWith("content")))) {}
    }
    try
    {
      int i = a(a.getContentResolver(), Uri.parse(paramString));
      return i;
    }
    catch (Exception paramString) {}
    return 0;
    return (int)localFile.length();
    return 0;
    return 0;
  }
  
  public static int a(String paramString, int paramInt)
  {
    int i = paramInt;
    if (paramString != null) {}
    try
    {
      if (paramString.length() <= 0) {
        return paramInt;
      }
      i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString) {}
    return paramInt;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 36) || (paramInt == 46);
  }
  
  public static boolean b(String paramString)
  {
    return (paramString == null) || (paramString.length() <= 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.utils.b
 * JD-Core Version:    0.7.0.1
 */