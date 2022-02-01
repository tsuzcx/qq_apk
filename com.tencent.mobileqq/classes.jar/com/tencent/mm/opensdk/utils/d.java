package com.tencent.mm.opensdk.utils;

import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class d
{
  public static Context D;
  public static ThreadPoolExecutor E = new ThreadPoolExecutor(0, 8, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque());
  
  /* Error */
  private static int a(android.content.ContentResolver paramContentResolver, Uri paramUri)
  {
    // Byte code:
    //   0: ldc 37
    //   2: ldc 39
    //   4: invokestatic 45	com/tencent/mm/opensdk/utils/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: aload_0
    //   8: ifnull +119 -> 127
    //   11: aload_1
    //   12: ifnonnull +6 -> 18
    //   15: goto +112 -> 127
    //   18: aconst_null
    //   19: astore 4
    //   21: aconst_null
    //   22: astore_3
    //   23: aload_0
    //   24: aload_1
    //   25: invokevirtual 51	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   28: astore_0
    //   29: aload_0
    //   30: ifnonnull +13 -> 43
    //   33: aload_0
    //   34: ifnull +7 -> 41
    //   37: aload_0
    //   38: invokevirtual 56	java/io/InputStream:close	()V
    //   41: iconst_0
    //   42: ireturn
    //   43: aload_0
    //   44: astore_3
    //   45: aload_0
    //   46: astore 4
    //   48: aload_0
    //   49: invokevirtual 60	java/io/InputStream:available	()I
    //   52: istore_2
    //   53: aload_0
    //   54: ifnull +7 -> 61
    //   57: aload_0
    //   58: invokevirtual 56	java/io/InputStream:close	()V
    //   61: iload_2
    //   62: ireturn
    //   63: astore_0
    //   64: goto +53 -> 117
    //   67: astore_0
    //   68: aload 4
    //   70: astore_3
    //   71: new 62	java/lang/StringBuilder
    //   74: dup
    //   75: ldc 64
    //   77: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   80: astore_1
    //   81: aload 4
    //   83: astore_3
    //   84: aload_1
    //   85: aload_0
    //   86: invokevirtual 71	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   89: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload 4
    //   95: astore_3
    //   96: ldc 37
    //   98: aload_1
    //   99: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 81	com/tencent/mm/opensdk/utils/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: aload 4
    //   107: ifnull +8 -> 115
    //   110: aload 4
    //   112: invokevirtual 56	java/io/InputStream:close	()V
    //   115: iconst_0
    //   116: ireturn
    //   117: aload_3
    //   118: ifnull +7 -> 125
    //   121: aload_3
    //   122: invokevirtual 56	java/io/InputStream:close	()V
    //   125: aload_0
    //   126: athrow
    //   127: ldc 37
    //   129: ldc 83
    //   131: invokestatic 81	com/tencent/mm/opensdk/utils/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: iconst_0
    //   135: ireturn
    //   136: astore_0
    //   137: iconst_0
    //   138: ireturn
    //   139: astore_0
    //   140: iload_2
    //   141: ireturn
    //   142: astore_0
    //   143: iconst_0
    //   144: ireturn
    //   145: astore_1
    //   146: goto -21 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	paramContentResolver	android.content.ContentResolver
    //   0	149	1	paramUri	Uri
    //   52	89	2	i	int
    //   22	100	3	localContentResolver1	android.content.ContentResolver
    //   19	92	4	localContentResolver2	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   23	29	63	finally
    //   48	53	63	finally
    //   71	81	63	finally
    //   84	93	63	finally
    //   96	105	63	finally
    //   23	29	67	java/lang/Exception
    //   48	53	67	java/lang/Exception
    //   37	41	136	java/io/IOException
    //   57	61	139	java/io/IOException
    //   110	115	142	java/io/IOException
    //   121	125	145	java/io/IOException
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 36) || (paramInt == 46);
  }
  
  public static boolean b(String paramString)
  {
    return (paramString == null) || (paramString.length() <= 0);
  }
  
  public static int c(String paramString)
  {
    if (paramString != null) {}
    try
    {
      if (paramString.length() <= 0) {
        return 0;
      }
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString) {}
    return 0;
    return 0;
  }
  
  public static int getFileSize(String paramString)
  {
    File localFile;
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return 0;
      }
      localFile = new File(paramString);
      if ((!localFile.exists()) && ((D == null) || (!paramString.startsWith("content")))) {}
    }
    try
    {
      int i = a(D.getContentResolver(), Uri.parse(paramString));
      return i;
    }
    catch (Exception paramString) {}
    return 0;
    return (int)localFile.length();
    return 0;
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.opensdk.utils.d
 * JD-Core Version:    0.7.0.1
 */