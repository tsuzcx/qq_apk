package com.tencent.TMG.logger;

import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Random;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class IMFunc
{
  private static final char[] digits = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static String appSignature(int paramInt, String paramString1, String paramString2, long paramLong, String paramString3, String paramString4)
    throws Exception
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null) || (paramString4 == null)) {
      return "-1";
    }
    long l = System.currentTimeMillis() / 1000L;
    int i = Math.abs(new Random().nextInt());
    paramString1 = "a=" + paramInt + "&k=" + paramString1 + "&e=" + (l + paramLong) + "&t=" + l + "&r=" + i + "&f=" + paramString3 + "&b=" + paramString4;
    paramString2 = getHmacSHA1(paramString1.getBytes(), paramString2);
    paramString3 = new byte[paramString2.length + paramString1.getBytes().length];
    System.arraycopy(paramString2, 0, paramString3, 0, paramString2.length);
    System.arraycopy(paramString1.getBytes(), 0, paramString3, paramString2.length, paramString1.getBytes().length);
    return base64Encode(paramString3);
  }
  
  public static String base64Encode(byte[] paramArrayOfByte)
  {
    return Base64.encodeToString(paramArrayOfByte, 2);
  }
  
  public static String getExceptionInfo(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      paramThrowable = "";
    }
    String str;
    StackTraceElement[] arrayOfStackTraceElement;
    do
    {
      return paramThrowable;
      str = paramThrowable.toString();
      arrayOfStackTraceElement = paramThrowable.getStackTrace();
      paramThrowable = str;
    } while (arrayOfStackTraceElement == null);
    int j = arrayOfStackTraceElement.length;
    int i = 0;
    for (;;)
    {
      paramThrowable = str;
      if (i >= j) {
        break;
      }
      paramThrowable = arrayOfStackTraceElement[i];
      str = str + "\n\tat " + paramThrowable.toString();
      i += 1;
    }
  }
  
  public static byte[] getHmacSHA1(byte[] paramArrayOfByte, String paramString)
    throws Exception
  {
    Mac localMac = Mac.getInstance("HmacSHA1");
    localMac.init(new SecretKeySpec(paramString.getBytes(), "HmacSHA1"));
    try
    {
      paramArrayOfByte = localMac.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (IllegalStateException paramArrayOfByte) {}
    return null;
  }
  
  public static byte[] getParamBytes(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return ("--" + paramString1 + "\r\n" + "Content-Disposition: form-data; name=\"" + paramString2 + "\"; filename=\"" + paramString3 + "\"\r\n" + "\r\n" + paramString4 + "\r\n").getBytes();
  }
  
  public static byte[] getParamBytes(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    paramString1 = ("--" + paramString1 + "\r\n" + "Content-Disposition: form-data; name=\"" + paramString2 + "\"; filename=\"" + paramString3 + "\"\r\n" + "\r\n").getBytes();
    paramString2 = new byte[paramString1.length + paramArrayOfByte.length + 2];
    System.arraycopy(paramString1, 0, paramString2, 0, paramString1.length);
    System.arraycopy(paramArrayOfByte, 0, paramString2, paramString1.length, paramArrayOfByte.length);
    System.arraycopy("\r\n".getBytes(), 0, paramString2, paramString1.length + paramArrayOfByte.length, 2);
    return paramString2;
  }
  
  public static byte[] gzCompress(String paramString)
    throws IOException
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
    localGZIPOutputStream.write(paramString.getBytes());
    localGZIPOutputStream.close();
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static boolean httpPostReq(String paramString, final byte[] paramArrayOfByte, final Map<String, String> paramMap, final RequestListener paramRequestListener)
  {
    try
    {
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      new Thread(new Runnable()
      {
        /* Error */
        public void run()
        {
          // Byte code:
          //   0: aload_0
          //   1: getfield 23	com/tencent/TMG/logger/IMFunc$1:val$http	Ljava/net/HttpURLConnection;
          //   4: ldc 38
          //   6: invokevirtual 44	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
          //   9: aload_0
          //   10: getfield 23	com/tencent/TMG/logger/IMFunc$1:val$http	Ljava/net/HttpURLConnection;
          //   13: iconst_1
          //   14: invokevirtual 48	java/net/HttpURLConnection:setDoOutput	(Z)V
          //   17: aload_0
          //   18: getfield 23	com/tencent/TMG/logger/IMFunc$1:val$http	Ljava/net/HttpURLConnection;
          //   21: ldc 50
          //   23: ldc 52
          //   25: invokevirtual 56	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
          //   28: aload_0
          //   29: getfield 23	com/tencent/TMG/logger/IMFunc$1:val$http	Ljava/net/HttpURLConnection;
          //   32: ldc 58
          //   34: aload_0
          //   35: getfield 25	com/tencent/TMG/logger/IMFunc$1:val$req	[B
          //   38: arraylength
          //   39: invokestatic 64	java/lang/String:valueOf	(I)Ljava/lang/String;
          //   42: invokevirtual 56	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
          //   45: aload_0
          //   46: getfield 27	com/tencent/TMG/logger/IMFunc$1:val$proMaps	Ljava/util/Map;
          //   49: invokeinterface 70 1 0
          //   54: invokeinterface 76 1 0
          //   59: astore_2
          //   60: aload_2
          //   61: invokeinterface 82 1 0
          //   66: ifeq +76 -> 142
          //   69: aload_2
          //   70: invokeinterface 86 1 0
          //   75: checkcast 88	java/util/Map$Entry
          //   78: astore_3
          //   79: aload_0
          //   80: getfield 23	com/tencent/TMG/logger/IMFunc$1:val$http	Ljava/net/HttpURLConnection;
          //   83: aload_3
          //   84: invokeinterface 91 1 0
          //   89: checkcast 60	java/lang/String
          //   92: aload_3
          //   93: invokeinterface 94 1 0
          //   98: checkcast 60	java/lang/String
          //   101: invokevirtual 56	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
          //   104: goto -44 -> 60
          //   107: astore_2
          //   108: aload_2
          //   109: invokevirtual 97	java/lang/Throwable:printStackTrace	()V
          //   112: aload_2
          //   113: invokevirtual 101	java/lang/Throwable:toString	()Ljava/lang/String;
          //   116: astore_2
          //   117: aload_0
          //   118: getfield 29	com/tencent/TMG/logger/IMFunc$1:val$listener	Lcom/tencent/TMG/logger/IMFunc$RequestListener;
          //   121: ifnull +13 -> 134
          //   124: aload_0
          //   125: getfield 29	com/tencent/TMG/logger/IMFunc$1:val$listener	Lcom/tencent/TMG/logger/IMFunc$RequestListener;
          //   128: aload_2
          //   129: invokeinterface 106 2 0
          //   134: aload_0
          //   135: getfield 23	com/tencent/TMG/logger/IMFunc$1:val$http	Ljava/net/HttpURLConnection;
          //   138: invokevirtual 109	java/net/HttpURLConnection:disconnect	()V
          //   141: return
          //   142: aload_0
          //   143: getfield 23	com/tencent/TMG/logger/IMFunc$1:val$http	Ljava/net/HttpURLConnection;
          //   146: invokevirtual 113	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
          //   149: aload_0
          //   150: getfield 25	com/tencent/TMG/logger/IMFunc$1:val$req	[B
          //   153: invokevirtual 119	java/io/OutputStream:write	([B)V
          //   156: new 121	java/io/BufferedInputStream
          //   159: dup
          //   160: aload_0
          //   161: getfield 23	com/tencent/TMG/logger/IMFunc$1:val$http	Ljava/net/HttpURLConnection;
          //   164: invokevirtual 125	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
          //   167: invokespecial 128	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
          //   170: astore_2
          //   171: new 130	java/io/ByteArrayOutputStream
          //   174: dup
          //   175: sipush 10240
          //   178: invokespecial 133	java/io/ByteArrayOutputStream:<init>	(I)V
          //   181: astore_3
          //   182: sipush 10240
          //   185: newarray byte
          //   187: astore 4
          //   189: aload_2
          //   190: aload 4
          //   192: invokevirtual 139	java/io/InputStream:read	([B)I
          //   195: istore_1
          //   196: iload_1
          //   197: ifge +33 -> 230
          //   200: aload_3
          //   201: invokevirtual 143	java/io/ByteArrayOutputStream:toByteArray	()[B
          //   204: astore_2
          //   205: aload_0
          //   206: getfield 29	com/tencent/TMG/logger/IMFunc$1:val$listener	Lcom/tencent/TMG/logger/IMFunc$RequestListener;
          //   209: ifnull +13 -> 222
          //   212: aload_0
          //   213: getfield 29	com/tencent/TMG/logger/IMFunc$1:val$listener	Lcom/tencent/TMG/logger/IMFunc$RequestListener;
          //   216: aload_2
          //   217: invokeinterface 146 2 0
          //   222: aload_0
          //   223: getfield 23	com/tencent/TMG/logger/IMFunc$1:val$http	Ljava/net/HttpURLConnection;
          //   226: invokevirtual 109	java/net/HttpURLConnection:disconnect	()V
          //   229: return
          //   230: aload_3
          //   231: aload 4
          //   233: iconst_0
          //   234: iload_1
          //   235: invokevirtual 149	java/io/ByteArrayOutputStream:write	([BII)V
          //   238: goto -49 -> 189
          //   241: astore_2
          //   242: aload_0
          //   243: getfield 23	com/tencent/TMG/logger/IMFunc$1:val$http	Ljava/net/HttpURLConnection;
          //   246: invokevirtual 109	java/net/HttpURLConnection:disconnect	()V
          //   249: aload_2
          //   250: athrow
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	251	0	this	1
          //   195	40	1	i	int
          //   59	11	2	localIterator	java.util.Iterator
          //   107	6	2	localThrowable	Throwable
          //   116	101	2	localObject1	Object
          //   241	9	2	localObject2	Object
          //   78	153	3	localObject3	Object
          //   187	45	4	arrayOfByte	byte[]
          // Exception table:
          //   from	to	target	type
          //   0	60	107	java/lang/Throwable
          //   60	104	107	java/lang/Throwable
          //   142	189	107	java/lang/Throwable
          //   189	196	107	java/lang/Throwable
          //   200	222	107	java/lang/Throwable
          //   230	238	107	java/lang/Throwable
          //   0	60	241	finally
          //   60	104	241	finally
          //   108	134	241	finally
          //   142	189	241	finally
          //   189	196	241	finally
          //   200	222	241	finally
          //   230	238	241	finally
        }
      }).start();
      return true;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      if (paramRequestListener != null) {
        paramRequestListener.onFail(getExceptionInfo(paramString));
      }
    }
    return false;
  }
  
  public static abstract interface RequestListener
  {
    public abstract void onFail(String paramString);
    
    public abstract void onSuccess(byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.TMG.logger.IMFunc
 * JD-Core Version:    0.7.0.1
 */