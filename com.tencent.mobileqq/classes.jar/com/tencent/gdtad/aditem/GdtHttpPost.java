package com.tencent.gdtad.aditem;

import com.tencent.mobileqq.app.ThreadManager;
import java.lang.ref.WeakReference;
import qiw;

public class GdtHttpPost
{
  public static void a(GdtHttpPost.Params paramParams, WeakReference paramWeakReference)
  {
    if ((paramParams == null) || (!paramParams.a())) {
      return;
    }
    ThreadManager.post(new qiw(paramParams, paramWeakReference), 5, null, true);
  }
  
  /* Error */
  private static void b(GdtHttpPost.Params paramParams)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 16	com/tencent/gdtad/aditem/GdtHttpPost$Params:a	()Z
    //   8: ifne +4 -> 12
    //   11: return
    //   12: aconst_null
    //   13: astore_1
    //   14: aconst_null
    //   15: astore_3
    //   16: aload_0
    //   17: getfield 32	com/tencent/gdtad/aditem/GdtHttpPost$Params:jdField_a_of_type_JavaNetURL	Ljava/net/URL;
    //   20: invokevirtual 38	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   23: checkcast 40	java/net/HttpURLConnection
    //   26: astore_2
    //   27: aload_2
    //   28: iconst_1
    //   29: invokevirtual 44	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   32: aload_2
    //   33: ldc 46
    //   35: invokevirtual 50	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   38: aload_2
    //   39: iconst_0
    //   40: invokevirtual 53	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   43: aload_2
    //   44: iconst_1
    //   45: invokevirtual 56	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   48: aload_2
    //   49: ldc 58
    //   51: aload_0
    //   52: getfield 61	com/tencent/gdtad/aditem/GdtHttpPost$Params:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   55: invokevirtual 65	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: aload_2
    //   59: invokevirtual 69	java/net/HttpURLConnection:connect	()V
    //   62: new 71	java/io/DataOutputStream
    //   65: dup
    //   66: aload_2
    //   67: invokevirtual 75	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   70: invokespecial 78	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   73: astore_1
    //   74: aload_1
    //   75: aload_0
    //   76: getfield 81	com/tencent/gdtad/aditem/GdtHttpPost$Params:jdField_a_of_type_ArrayOfByte	[B
    //   79: iconst_0
    //   80: aload_0
    //   81: getfield 81	com/tencent/gdtad/aditem/GdtHttpPost$Params:jdField_a_of_type_ArrayOfByte	[B
    //   84: arraylength
    //   85: invokevirtual 85	java/io/DataOutputStream:write	([BII)V
    //   88: aload_1
    //   89: invokevirtual 88	java/io/DataOutputStream:flush	()V
    //   92: aload_1
    //   93: invokevirtual 91	java/io/DataOutputStream:close	()V
    //   96: new 93	java/io/DataInputStream
    //   99: dup
    //   100: aload_2
    //   101: invokevirtual 97	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   104: invokespecial 100	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   107: astore_1
    //   108: aload_0
    //   109: aload_1
    //   110: invokevirtual 104	java/io/DataInputStream:available	()I
    //   113: newarray byte
    //   115: putfield 106	com/tencent/gdtad/aditem/GdtHttpPost$Params:b	[B
    //   118: aload_1
    //   119: aload_0
    //   120: getfield 106	com/tencent/gdtad/aditem/GdtHttpPost$Params:b	[B
    //   123: invokevirtual 110	java/io/DataInputStream:readFully	([B)V
    //   126: aload_1
    //   127: invokevirtual 111	java/io/DataInputStream:close	()V
    //   130: aload_0
    //   131: aload_2
    //   132: invokevirtual 114	java/net/HttpURLConnection:getResponseCode	()I
    //   135: putfield 117	com/tencent/gdtad/aditem/GdtHttpPost$Params:jdField_a_of_type_Int	I
    //   138: aload_2
    //   139: ifnull -128 -> 11
    //   142: aload_2
    //   143: invokevirtual 120	java/net/HttpURLConnection:disconnect	()V
    //   146: return
    //   147: astore_2
    //   148: aload_3
    //   149: astore_0
    //   150: aload_0
    //   151: astore_1
    //   152: ldc 122
    //   154: ldc 123
    //   156: aload_2
    //   157: invokestatic 129	com/tencent/gdtad/log/GdtLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   160: aload_0
    //   161: ifnull -150 -> 11
    //   164: aload_0
    //   165: invokevirtual 120	java/net/HttpURLConnection:disconnect	()V
    //   168: return
    //   169: astore_0
    //   170: aload_1
    //   171: ifnull +7 -> 178
    //   174: aload_1
    //   175: invokevirtual 120	java/net/HttpURLConnection:disconnect	()V
    //   178: aload_0
    //   179: athrow
    //   180: astore_0
    //   181: aload_2
    //   182: astore_1
    //   183: goto -13 -> 170
    //   186: astore_1
    //   187: aload_2
    //   188: astore_0
    //   189: aload_1
    //   190: astore_2
    //   191: goto -41 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	paramParams	GdtHttpPost.Params
    //   13	170	1	localObject1	Object
    //   186	4	1	localIOException1	java.io.IOException
    //   26	117	2	localHttpURLConnection	java.net.HttpURLConnection
    //   147	41	2	localIOException2	java.io.IOException
    //   190	1	2	localIOException3	java.io.IOException
    //   15	134	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   16	27	147	java/io/IOException
    //   16	27	169	finally
    //   152	160	169	finally
    //   27	138	180	finally
    //   27	138	186	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtHttpPost
 * JD-Core Version:    0.7.0.1
 */