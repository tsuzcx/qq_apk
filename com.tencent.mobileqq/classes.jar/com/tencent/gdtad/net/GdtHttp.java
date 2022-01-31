package com.tencent.gdtad.net;

import com.tencent.mobileqq.app.ThreadManager;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import qpr;

public class GdtHttp
{
  /* Error */
  public static void a(GdtHttp.Params paramParams)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 18	com/tencent/gdtad/net/GdtHttp$Params:a	()Z
    //   8: ifne +4 -> 12
    //   11: return
    //   12: aconst_null
    //   13: astore_1
    //   14: aconst_null
    //   15: astore_3
    //   16: aload_0
    //   17: invokestatic 21	com/tencent/gdtad/net/GdtHttp$Params:a	(Lcom/tencent/gdtad/net/GdtHttp$Params;)Ljava/net/URL;
    //   20: invokevirtual 27	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   23: checkcast 29	java/net/HttpURLConnection
    //   26: astore_2
    //   27: aload_2
    //   28: aload_0
    //   29: getfield 32	com/tencent/gdtad/net/GdtHttp$Params:jdField_a_of_type_Int	I
    //   32: invokevirtual 36	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   35: aload_2
    //   36: aload_0
    //   37: getfield 39	com/tencent/gdtad/net/GdtHttp$Params:jdField_b_of_type_Int	I
    //   40: invokevirtual 42	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   43: aload_2
    //   44: iconst_1
    //   45: invokevirtual 46	java/net/HttpURLConnection:setDoInput	(Z)V
    //   48: aload_0
    //   49: getfield 49	com/tencent/gdtad/net/GdtHttp$Params:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   52: ldc 51
    //   54: invokestatic 57	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   57: ifeq +159 -> 216
    //   60: aload_2
    //   61: iconst_0
    //   62: invokevirtual 60	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   65: aload_2
    //   66: aload_0
    //   67: getfield 49	com/tencent/gdtad/net/GdtHttp$Params:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   70: invokevirtual 64	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   73: aload_2
    //   74: iconst_0
    //   75: invokevirtual 67	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   78: aload_2
    //   79: iconst_1
    //   80: invokevirtual 70	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   83: aload_2
    //   84: ldc 72
    //   86: aload_0
    //   87: getfield 74	com/tencent/gdtad/net/GdtHttp$Params:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   90: invokevirtual 78	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: aload_0
    //   94: getfield 81	com/tencent/gdtad/net/GdtHttp$Params:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   97: invokestatic 85	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   100: ifne +13 -> 113
    //   103: aload_2
    //   104: ldc 87
    //   106: aload_0
    //   107: getfield 81	com/tencent/gdtad/net/GdtHttp$Params:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   110: invokevirtual 78	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   113: aload_2
    //   114: invokevirtual 90	java/net/HttpURLConnection:getDoOutput	()Z
    //   117: ifeq +44 -> 161
    //   120: aload_0
    //   121: getfield 93	com/tencent/gdtad/net/GdtHttp$Params:jdField_a_of_type_ArrayOfByte	[B
    //   124: ifnull +37 -> 161
    //   127: new 95	java/io/DataOutputStream
    //   130: dup
    //   131: aload_2
    //   132: invokevirtual 99	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   135: invokespecial 102	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   138: astore_1
    //   139: aload_1
    //   140: aload_0
    //   141: getfield 93	com/tencent/gdtad/net/GdtHttp$Params:jdField_a_of_type_ArrayOfByte	[B
    //   144: iconst_0
    //   145: aload_0
    //   146: getfield 93	com/tencent/gdtad/net/GdtHttp$Params:jdField_a_of_type_ArrayOfByte	[B
    //   149: arraylength
    //   150: invokevirtual 106	java/io/DataOutputStream:write	([BII)V
    //   153: aload_1
    //   154: invokevirtual 109	java/io/DataOutputStream:flush	()V
    //   157: aload_1
    //   158: invokevirtual 112	java/io/DataOutputStream:close	()V
    //   161: aload_2
    //   162: invokevirtual 115	java/net/HttpURLConnection:connect	()V
    //   165: aload_0
    //   166: aload_2
    //   167: invokevirtual 119	java/net/HttpURLConnection:getResponseCode	()I
    //   170: putfield 121	com/tencent/gdtad/net/GdtHttp$Params:jdField_c_of_type_Int	I
    //   173: aload_0
    //   174: getfield 121	com/tencent/gdtad/net/GdtHttp$Params:jdField_c_of_type_Int	I
    //   177: sipush 200
    //   180: if_icmpne +27 -> 207
    //   183: aload_2
    //   184: invokevirtual 124	java/net/HttpURLConnection:getDoInput	()Z
    //   187: ifeq +20 -> 207
    //   190: aload_2
    //   191: invokevirtual 128	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   194: astore_1
    //   195: aload_0
    //   196: aload_1
    //   197: invokestatic 131	com/tencent/gdtad/net/GdtHttp:a	(Ljava/io/InputStream;)[B
    //   200: putfield 133	com/tencent/gdtad/net/GdtHttp$Params:jdField_b_of_type_ArrayOfByte	[B
    //   203: aload_1
    //   204: invokevirtual 136	java/io/InputStream:close	()V
    //   207: aload_2
    //   208: ifnull -197 -> 11
    //   211: aload_2
    //   212: invokevirtual 139	java/net/HttpURLConnection:disconnect	()V
    //   215: return
    //   216: aload_0
    //   217: getfield 49	com/tencent/gdtad/net/GdtHttp$Params:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   220: ldc 141
    //   222: invokestatic 57	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   225: ifeq -160 -> 65
    //   228: aload_2
    //   229: iconst_1
    //   230: invokevirtual 60	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   233: goto -168 -> 65
    //   236: astore_1
    //   237: aload_2
    //   238: astore_0
    //   239: aload_1
    //   240: astore_2
    //   241: aload_0
    //   242: astore_1
    //   243: ldc 143
    //   245: ldc 145
    //   247: aload_2
    //   248: invokestatic 151	com/tencent/gdtad/log/GdtLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   251: aload_0
    //   252: ifnull -241 -> 11
    //   255: aload_0
    //   256: invokevirtual 139	java/net/HttpURLConnection:disconnect	()V
    //   259: return
    //   260: astore_0
    //   261: aload_1
    //   262: ifnull +7 -> 269
    //   265: aload_1
    //   266: invokevirtual 139	java/net/HttpURLConnection:disconnect	()V
    //   269: aload_0
    //   270: athrow
    //   271: astore_0
    //   272: aload_2
    //   273: astore_1
    //   274: goto -13 -> 261
    //   277: astore_2
    //   278: aload_3
    //   279: astore_0
    //   280: goto -39 -> 241
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	paramParams	GdtHttp.Params
    //   13	191	1	localObject1	Object
    //   236	4	1	localIOException1	java.io.IOException
    //   242	32	1	localObject2	Object
    //   26	247	2	localObject3	Object
    //   277	1	2	localIOException2	java.io.IOException
    //   15	264	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   27	65	236	java/io/IOException
    //   65	113	236	java/io/IOException
    //   113	161	236	java/io/IOException
    //   161	207	236	java/io/IOException
    //   216	233	236	java/io/IOException
    //   16	27	260	finally
    //   243	251	260	finally
    //   27	65	271	finally
    //   65	113	271	finally
    //   113	161	271	finally
    //   161	207	271	finally
    //   216	233	271	finally
    //   16	27	277	java/io/IOException
  }
  
  public static void a(GdtHttp.Params paramParams, WeakReference paramWeakReference)
  {
    if ((paramParams == null) || (!paramParams.a())) {
      return;
    }
    ThreadManager.post(new qpr(paramParams, paramWeakReference), 5, null, true);
  }
  
  private static byte[] a(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    for (;;)
    {
      byte[] arrayOfByte = new byte[1024];
      int i = paramInputStream.read(arrayOfByte);
      if (i < 0)
      {
        localByteArrayOutputStream.close();
        return localByteArrayOutputStream.toByteArray();
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.gdtad.net.GdtHttp
 * JD-Core Version:    0.7.0.1
 */