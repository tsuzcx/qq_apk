package com.huawei.hms.opendevice;

import com.huawei.hms.support.log.HMSLog;
import com.huawei.secure.android.common.util.IOUtil;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public abstract class s
{
  public static String a(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    for (int i = paramInputStream.read(); -1 != i; i = paramInputStream.read()) {
      localByteArrayOutputStream.write(i);
    }
    String str = localByteArrayOutputStream.toString("UTF-8");
    a(paramInputStream);
    IOUtil.closeSecure(localByteArrayOutputStream);
    return str;
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: new 44	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 47	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: new 49	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   16: astore 6
    //   18: aconst_null
    //   19: astore 5
    //   21: aconst_null
    //   22: astore_2
    //   23: aconst_null
    //   24: astore_1
    //   25: aconst_null
    //   26: astore 4
    //   28: new 52	java/io/FileInputStream
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 55	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   36: astore_0
    //   37: new 57	java/io/InputStreamReader
    //   40: dup
    //   41: aload_0
    //   42: ldc 24
    //   44: invokespecial 60	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   47: astore_0
    //   48: aload_2
    //   49: astore_1
    //   50: aload_0
    //   51: astore_2
    //   52: new 62	java/io/BufferedReader
    //   55: dup
    //   56: aload_0
    //   57: invokespecial 65	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   60: astore_3
    //   61: aload_3
    //   62: invokevirtual 69	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   65: astore_1
    //   66: aload_1
    //   67: ifnull +13 -> 80
    //   70: aload 6
    //   72: aload_1
    //   73: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: goto -16 -> 61
    //   80: aload_0
    //   81: invokestatic 78	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   84: aload_3
    //   85: invokestatic 78	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   88: goto +66 -> 154
    //   91: astore_2
    //   92: aload_3
    //   93: astore_1
    //   94: aload_2
    //   95: astore_3
    //   96: goto +67 -> 163
    //   99: goto +17 -> 116
    //   102: goto +33 -> 135
    //   105: astore_3
    //   106: aconst_null
    //   107: astore_0
    //   108: goto +55 -> 163
    //   111: aconst_null
    //   112: astore_0
    //   113: aload 4
    //   115: astore_3
    //   116: aload_3
    //   117: astore_1
    //   118: aload_0
    //   119: astore_2
    //   120: ldc 80
    //   122: ldc 82
    //   124: invokestatic 88	com/huawei/hms/support/log/HMSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: goto +19 -> 146
    //   130: aconst_null
    //   131: astore_0
    //   132: aload 5
    //   134: astore_3
    //   135: aload_3
    //   136: astore_1
    //   137: aload_0
    //   138: astore_2
    //   139: ldc 80
    //   141: ldc 90
    //   143: invokestatic 88	com/huawei/hms/support/log/HMSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: aload_0
    //   147: invokestatic 78	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   150: aload_3
    //   151: invokestatic 78	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   154: aload 6
    //   156: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: areturn
    //   160: astore_3
    //   161: aload_2
    //   162: astore_0
    //   163: aload_0
    //   164: invokestatic 78	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   167: aload_1
    //   168: invokestatic 78	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   171: goto +5 -> 176
    //   174: aload_3
    //   175: athrow
    //   176: goto -2 -> 174
    //   179: astore_0
    //   180: goto -50 -> 130
    //   183: astore_0
    //   184: goto -73 -> 111
    //   187: astore_1
    //   188: aload 5
    //   190: astore_3
    //   191: goto -56 -> 135
    //   194: astore_1
    //   195: aload 4
    //   197: astore_3
    //   198: goto -82 -> 116
    //   201: astore_1
    //   202: goto -100 -> 102
    //   205: astore_1
    //   206: goto -107 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	paramString	String
    //   24	144	1	localObject1	Object
    //   187	1	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   194	1	1	localIOException1	IOException
    //   201	1	1	localFileNotFoundException2	java.io.FileNotFoundException
    //   205	1	1	localIOException2	IOException
    //   22	30	2	str1	String
    //   91	4	2	localObject2	Object
    //   119	43	2	str2	String
    //   60	36	3	localObject3	Object
    //   105	1	3	localObject4	Object
    //   115	36	3	localObject5	Object
    //   160	15	3	localObject6	Object
    //   190	8	3	localObject7	Object
    //   26	170	4	localObject8	Object
    //   19	170	5	localObject9	Object
    //   16	139	6	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   61	66	91	finally
    //   70	77	91	finally
    //   28	37	105	finally
    //   37	48	105	finally
    //   52	61	160	finally
    //   120	127	160	finally
    //   139	146	160	finally
    //   28	37	179	java/io/FileNotFoundException
    //   37	48	179	java/io/FileNotFoundException
    //   28	37	183	java/io/IOException
    //   37	48	183	java/io/IOException
    //   52	61	187	java/io/FileNotFoundException
    //   52	61	194	java/io/IOException
    //   61	66	201	java/io/FileNotFoundException
    //   70	77	201	java/io/FileNotFoundException
    //   61	66	205	java/io/IOException
    //   70	77	205	java/io/IOException
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      label11:
      break label11;
    }
    HMSLog.w("StreamUtil", "close IOException");
  }
  
  public static void a(File paramFile)
  {
    if (paramFile.exists()) {
      return;
    }
    if (paramFile.getParentFile() != null)
    {
      if ((!paramFile.getParentFile().exists()) && (!paramFile.getParentFile().mkdirs()))
      {
        HMSLog.e("StreamUtil", "make parent dirs failed.");
        throw new IOException("make parent dirs failed");
      }
      if (paramFile.createNewFile()) {
        return;
      }
      HMSLog.e("StreamUtil", "create file failed.");
      throw new IOException("create file failed");
    }
    HMSLog.e("StreamUtil", "parent file is null.");
    throw new IOException("parent file is null");
  }
  
  public static void a(HttpURLConnection paramHttpURLConnection)
  {
    if (paramHttpURLConnection != null) {}
    try
    {
      paramHttpURLConnection.disconnect();
      return;
    }
    catch (Throwable paramHttpURLConnection)
    {
      label9:
      break label9;
    }
    HMSLog.w("StreamUtil", "close HttpURLConnection Exception");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.opendevice.s
 * JD-Core Version:    0.7.0.1
 */