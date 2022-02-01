package com.huawei.hms.update.b;

import android.content.Context;
import com.huawei.hms.support.log.HMSLog;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class b
  implements d
{
  private HttpURLConnection a;
  private volatile int b = -1;
  
  private void a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = new byte[4096];
    do
    {
      int i = paramInputStream.read(arrayOfByte);
      if (-1 == i) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    } while (this.b != 1);
    throw new a("HTTP(s) request was canceled.");
  }
  
  private void a(String paramString, Context paramContext)
  {
    if (this.b == 0) {
      HMSLog.e("HttpRequestHelper", "Not allowed to repeat open http(s) connection.");
    }
    this.a = ((HttpURLConnection)new URL(paramString).openConnection());
    if ((this.a instanceof HttpsURLConnection)) {
      c.a((HttpsURLConnection)this.a, paramContext);
    }
    this.a.setConnectTimeout(30000);
    this.a.setReadTimeout(30000);
    this.a.setDoInput(true);
    this.a.setDoOutput(true);
    this.a.setUseCaches(false);
    this.a.setInstanceFollowRedirects(true);
    this.b = 0;
  }
  
  /* Error */
  public int a(String paramString, OutputStream paramOutputStream, int paramInt1, int paramInt2, Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: aload_1
    //   5: aload 5
    //   7: invokespecial 89	com/huawei/hms/update/b/b:a	(Ljava/lang/String;Landroid/content/Context;)V
    //   10: aload_0
    //   11: getfield 59	com/huawei/hms/update/b/b:a	Ljava/net/HttpURLConnection;
    //   14: ldc 91
    //   16: invokevirtual 94	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   19: iload_3
    //   20: ifle +41 -> 61
    //   23: aload_0
    //   24: getfield 59	com/huawei/hms/update/b/b:a	Ljava/net/HttpURLConnection;
    //   27: ldc 96
    //   29: new 98	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   36: ldc 101
    //   38: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: iload_3
    //   42: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   45: ldc 110
    //   47: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: iload 4
    //   52: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   55: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokevirtual 117	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: aload_0
    //   62: getfield 59	com/huawei/hms/update/b/b:a	Ljava/net/HttpURLConnection;
    //   65: invokevirtual 121	java/net/HttpURLConnection:getResponseCode	()I
    //   68: istore 4
    //   70: iload_3
    //   71: ifle +69 -> 140
    //   74: iload 4
    //   76: sipush 206
    //   79: if_icmpeq +6 -> 85
    //   82: goto +58 -> 140
    //   85: aload_0
    //   86: getfield 59	com/huawei/hms/update/b/b:a	Ljava/net/HttpURLConnection;
    //   89: invokevirtual 125	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   92: astore_1
    //   93: aload_0
    //   94: new 127	java/io/BufferedInputStream
    //   97: dup
    //   98: aload_1
    //   99: sipush 4096
    //   102: invokespecial 130	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   105: aload_2
    //   106: invokespecial 132	com/huawei/hms/update/b/b:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   109: aload_2
    //   110: invokevirtual 135	java/io/OutputStream:flush	()V
    //   113: aload_1
    //   114: invokestatic 141	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   117: iload 4
    //   119: ireturn
    //   120: astore_1
    //   121: aconst_null
    //   122: astore 5
    //   124: aload_1
    //   125: astore_2
    //   126: aload 5
    //   128: invokestatic 141	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   131: aload_2
    //   132: athrow
    //   133: astore_2
    //   134: aload_1
    //   135: astore 5
    //   137: goto -11 -> 126
    //   140: aload 6
    //   142: astore_1
    //   143: iload_3
    //   144: ifgt -31 -> 113
    //   147: aload 6
    //   149: astore_1
    //   150: iload 4
    //   152: sipush 200
    //   155: if_icmpne -42 -> 113
    //   158: goto -73 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	this	b
    //   0	161	1	paramString	String
    //   0	161	2	paramOutputStream	OutputStream
    //   0	161	3	paramInt1	int
    //   0	161	4	paramInt2	int
    //   0	161	5	paramContext	Context
    //   1	147	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	19	120	finally
    //   23	61	120	finally
    //   61	70	120	finally
    //   85	93	120	finally
    //   93	113	133	finally
  }
  
  public void a()
  {
    this.b = -1;
    if (this.a != null) {
      this.a.disconnect();
    }
  }
  
  public void b()
  {
    this.b = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.update.b.b
 * JD-Core Version:    0.7.0.1
 */