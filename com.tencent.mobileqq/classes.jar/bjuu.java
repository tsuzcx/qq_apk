import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;

public class bjuu
  extends bjul<Void, Void, Bitmap>
{
  protected Bundle a;
  protected bjuv a;
  ThreadSafeClientConnManager a;
  protected String c;
  
  public bjuu(String paramString1, String paramString2, Bundle paramBundle, String paramString3, bjuv parambjuv)
  {
    super(paramString2, paramString3);
    this.jdField_a_of_type_OrgApacheHttpImplConnTsccmThreadSafeClientConnManager = null;
    this.c = paramString1;
    this.jdField_a_of_type_Bjuv = parambjuv;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    paramString1 = new SchemeRegistry();
    paramString1.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    for (;;)
    {
      try
      {
        if ((Build.VERSION.SDK_INT < 23) && (!beuf.c())) {
          continue;
        }
        paramString2 = SSLSocketFactory.getSocketFactory();
        paramString2.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        paramString1.register(new Scheme("https", paramString2, 443));
      }
      catch (Exception paramString2)
      {
        QLog.e("HttpImageDownloadAsyncTask", 1, "createHttpClient():Can't support https on this devices.", paramString2);
        continue;
      }
      this.jdField_a_of_type_OrgApacheHttpImplConnTsccmThreadSafeClientConnManager = new ThreadSafeClientConnManager(new BasicHttpParams(), paramString1);
      return;
      paramString1.register(new Scheme("https", new bexy(bjuu.class.getSimpleName()), 443));
    }
  }
  
  /* Error */
  protected Bitmap a(Void... paramVarArgs)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 4
    //   8: ldc 95
    //   10: iconst_1
    //   11: ldc 111
    //   13: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: new 117	org/apache/http/impl/client/DefaultHttpClient
    //   19: dup
    //   20: aload_0
    //   21: getfield 20	bjuu:jdField_a_of_type_OrgApacheHttpImplConnTsccmThreadSafeClientConnManager	Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;
    //   24: aconst_null
    //   25: invokespecial 120	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V
    //   28: astore 6
    //   30: aload 5
    //   32: astore_1
    //   33: new 122	org/apache/http/client/methods/HttpGet
    //   36: dup
    //   37: aload_0
    //   38: getfield 124	bjuu:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   41: invokespecial 125	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   44: astore 7
    //   46: aload 5
    //   48: astore_1
    //   49: aload_0
    //   50: getfield 26	bjuu:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   53: ifnull +124 -> 177
    //   56: aload 5
    //   58: astore_1
    //   59: aload_0
    //   60: getfield 26	bjuu:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   63: invokevirtual 131	android/os/Bundle:keySet	()Ljava/util/Set;
    //   66: invokeinterface 137 1 0
    //   71: astore 8
    //   73: aload 5
    //   75: astore_1
    //   76: aload 8
    //   78: invokeinterface 142 1 0
    //   83: ifeq +94 -> 177
    //   86: aload 5
    //   88: astore_1
    //   89: aload 8
    //   91: invokeinterface 146 1 0
    //   96: checkcast 148	java/lang/String
    //   99: astore 9
    //   101: aload 5
    //   103: astore_1
    //   104: aload_0
    //   105: getfield 26	bjuu:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   108: aload 9
    //   110: invokevirtual 152	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   113: astore 10
    //   115: aload 5
    //   117: astore_1
    //   118: aload 10
    //   120: instanceof 148
    //   123: ifeq -50 -> 73
    //   126: aload 5
    //   128: astore_1
    //   129: aload 7
    //   131: aload 9
    //   133: aload 10
    //   135: checkcast 148	java/lang/String
    //   138: invokevirtual 155	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: goto -68 -> 73
    //   144: astore 5
    //   146: aconst_null
    //   147: astore_3
    //   148: aload 4
    //   150: astore_1
    //   151: ldc 95
    //   153: iconst_1
    //   154: ldc 157
    //   156: aload 5
    //   158: invokestatic 103	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   161: aload_3
    //   162: astore_1
    //   163: aload 4
    //   165: ifnull +10 -> 175
    //   168: aload 4
    //   170: invokevirtual 162	java/io/InputStream:close	()V
    //   173: aload_3
    //   174: astore_1
    //   175: aload_1
    //   176: areturn
    //   177: aload 5
    //   179: astore_1
    //   180: aload 6
    //   182: aload 7
    //   184: invokeinterface 168 2 0
    //   189: invokeinterface 174 1 0
    //   194: astore 6
    //   196: aload 6
    //   198: ifnull +194 -> 392
    //   201: aload 5
    //   203: astore_1
    //   204: aload 6
    //   206: invokeinterface 180 1 0
    //   211: astore 5
    //   213: aload 5
    //   215: astore_1
    //   216: aload_0
    //   217: aload_1
    //   218: invokevirtual 183	bjuu:a	(Ljava/io/InputStream;)[B
    //   221: astore_3
    //   222: aload_3
    //   223: iconst_0
    //   224: aload_3
    //   225: arraylength
    //   226: invokestatic 189	com/tencent/image/SafeBitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   229: astore_3
    //   230: aload_3
    //   231: ifnonnull +47 -> 278
    //   234: iconst_1
    //   235: istore_2
    //   236: ldc 95
    //   238: iconst_1
    //   239: iconst_2
    //   240: anewarray 191	java/lang/Object
    //   243: dup
    //   244: iconst_0
    //   245: ldc 193
    //   247: aastore
    //   248: dup
    //   249: iconst_1
    //   250: iload_2
    //   251: invokestatic 199	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   254: aastore
    //   255: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   258: aload_1
    //   259: astore 4
    //   261: aload_3
    //   262: astore_1
    //   263: aload 4
    //   265: ifnull -90 -> 175
    //   268: aload 4
    //   270: invokevirtual 162	java/io/InputStream:close	()V
    //   273: aload_3
    //   274: areturn
    //   275: astore_1
    //   276: aload_3
    //   277: areturn
    //   278: iconst_0
    //   279: istore_2
    //   280: goto -44 -> 236
    //   283: astore 5
    //   285: aconst_null
    //   286: astore_1
    //   287: aload_3
    //   288: astore 4
    //   290: aload_1
    //   291: astore_3
    //   292: aload 4
    //   294: astore_1
    //   295: ldc 95
    //   297: iconst_1
    //   298: ldc 204
    //   300: aload 5
    //   302: invokestatic 103	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   305: aload_3
    //   306: astore_1
    //   307: aload 4
    //   309: ifnull -134 -> 175
    //   312: aload 4
    //   314: invokevirtual 162	java/io/InputStream:close	()V
    //   317: aload_3
    //   318: areturn
    //   319: astore_1
    //   320: aload_3
    //   321: areturn
    //   322: astore 4
    //   324: aload_1
    //   325: astore_3
    //   326: aload 4
    //   328: astore_1
    //   329: aload_3
    //   330: ifnull +7 -> 337
    //   333: aload_3
    //   334: invokevirtual 162	java/io/InputStream:close	()V
    //   337: aload_1
    //   338: athrow
    //   339: astore_1
    //   340: aload_3
    //   341: areturn
    //   342: astore_3
    //   343: goto -6 -> 337
    //   346: astore 4
    //   348: aload_1
    //   349: astore_3
    //   350: aload 4
    //   352: astore_1
    //   353: goto -24 -> 329
    //   356: astore 5
    //   358: aconst_null
    //   359: astore_3
    //   360: aload_1
    //   361: astore 4
    //   363: goto -71 -> 292
    //   366: astore 5
    //   368: aload_1
    //   369: astore 4
    //   371: goto -79 -> 292
    //   374: astore 5
    //   376: aconst_null
    //   377: astore_3
    //   378: aload_1
    //   379: astore 4
    //   381: goto -233 -> 148
    //   384: astore 5
    //   386: aload_1
    //   387: astore 4
    //   389: goto -241 -> 148
    //   392: aconst_null
    //   393: astore 4
    //   395: aconst_null
    //   396: astore_3
    //   397: goto -136 -> 261
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	400	0	this	bjuu
    //   0	400	1	paramVarArgs	Void[]
    //   235	45	2	bool	boolean
    //   1	340	3	localObject1	java.lang.Object
    //   342	1	3	localIOException	java.io.IOException
    //   349	48	3	arrayOfVoid1	Void[]
    //   6	307	4	localObject2	java.lang.Object
    //   322	5	4	localObject3	java.lang.Object
    //   346	5	4	localObject4	java.lang.Object
    //   361	33	4	arrayOfVoid2	Void[]
    //   3	124	5	localObject5	java.lang.Object
    //   144	58	5	localException1	Exception
    //   211	3	5	localInputStream	InputStream
    //   283	18	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   356	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   366	1	5	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   374	1	5	localException2	Exception
    //   384	1	5	localException3	Exception
    //   28	177	6	localObject6	java.lang.Object
    //   44	139	7	localHttpGet	org.apache.http.client.methods.HttpGet
    //   71	19	8	localIterator	java.util.Iterator
    //   99	33	9	str	String
    //   113	21	10	localObject7	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   33	46	144	java/lang/Exception
    //   49	56	144	java/lang/Exception
    //   59	73	144	java/lang/Exception
    //   76	86	144	java/lang/Exception
    //   89	101	144	java/lang/Exception
    //   104	115	144	java/lang/Exception
    //   118	126	144	java/lang/Exception
    //   129	141	144	java/lang/Exception
    //   180	196	144	java/lang/Exception
    //   204	213	144	java/lang/Exception
    //   268	273	275	java/io/IOException
    //   33	46	283	java/lang/OutOfMemoryError
    //   49	56	283	java/lang/OutOfMemoryError
    //   59	73	283	java/lang/OutOfMemoryError
    //   76	86	283	java/lang/OutOfMemoryError
    //   89	101	283	java/lang/OutOfMemoryError
    //   104	115	283	java/lang/OutOfMemoryError
    //   118	126	283	java/lang/OutOfMemoryError
    //   129	141	283	java/lang/OutOfMemoryError
    //   180	196	283	java/lang/OutOfMemoryError
    //   204	213	283	java/lang/OutOfMemoryError
    //   312	317	319	java/io/IOException
    //   33	46	322	finally
    //   49	56	322	finally
    //   59	73	322	finally
    //   76	86	322	finally
    //   89	101	322	finally
    //   104	115	322	finally
    //   118	126	322	finally
    //   129	141	322	finally
    //   151	161	322	finally
    //   180	196	322	finally
    //   204	213	322	finally
    //   295	305	322	finally
    //   168	173	339	java/io/IOException
    //   333	337	342	java/io/IOException
    //   216	230	346	finally
    //   236	258	346	finally
    //   216	230	356	java/lang/OutOfMemoryError
    //   236	258	366	java/lang/OutOfMemoryError
    //   216	230	374	java/lang/Exception
    //   236	258	384	java/lang/Exception
  }
  
  protected void a(Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_Bjuv != null) {
      this.jdField_a_of_type_Bjuv.a(this.c, paramBitmap);
    }
  }
  
  protected byte[] a(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte, 0, 1024);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
      localByteArrayOutputStream.flush();
    }
    return localByteArrayOutputStream.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjuu
 * JD-Core Version:    0.7.0.1
 */