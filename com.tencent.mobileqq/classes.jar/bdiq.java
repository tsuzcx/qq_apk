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

public class bdiq
  extends bdih<Void, Void, Bitmap>
{
  protected Bundle a;
  protected bdir a;
  ThreadSafeClientConnManager a;
  protected String c;
  
  public bdiq(String paramString1, String paramString2, Bundle paramBundle, String paramString3, bdir parambdir)
  {
    super(paramString2, paramString3);
    this.jdField_a_of_type_OrgApacheHttpImplConnTsccmThreadSafeClientConnManager = null;
    this.c = paramString1;
    this.jdField_a_of_type_Bdir = parambdir;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    paramString1 = new SchemeRegistry();
    paramString1.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    for (;;)
    {
      try
      {
        if ((Build.VERSION.SDK_INT < 23) && (!ayrn.c())) {
          continue;
        }
        paramString2 = SSLSocketFactory.getSocketFactory();
        paramString2.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        paramString1.register(new Scheme("https", paramString2, 443));
      }
      catch (Exception paramString2)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("URLDrawable_", 2, "createHttpClient():Can't support https on this devices.", paramString2);
        continue;
      }
      this.jdField_a_of_type_OrgApacheHttpImplConnTsccmThreadSafeClientConnManager = new ThreadSafeClientConnManager(new BasicHttpParams(), paramString1);
      return;
      paramString1.register(new Scheme("https", new ayvs(bdiq.class.getSimpleName()), 443));
    }
  }
  
  /* Error */
  protected Bitmap a(Void... paramVarArgs)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 114	org/apache/http/impl/client/DefaultHttpClient
    //   5: dup
    //   6: aload_0
    //   7: getfield 20	bdiq:jdField_a_of_type_OrgApacheHttpImplConnTsccmThreadSafeClientConnManager	Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;
    //   10: aconst_null
    //   11: invokespecial 117	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V
    //   14: astore_1
    //   15: new 119	org/apache/http/client/methods/HttpGet
    //   18: dup
    //   19: aload_0
    //   20: getfield 121	bdiq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   23: invokespecial 122	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   26: astore_3
    //   27: aload_0
    //   28: getfield 26	bdiq:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   31: ifnull +93 -> 124
    //   34: aload_0
    //   35: getfield 26	bdiq:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   38: invokevirtual 128	android/os/Bundle:keySet	()Ljava/util/Set;
    //   41: invokeinterface 134 1 0
    //   46: astore 4
    //   48: aload 4
    //   50: invokeinterface 139 1 0
    //   55: ifeq +69 -> 124
    //   58: aload 4
    //   60: invokeinterface 143 1 0
    //   65: checkcast 145	java/lang/String
    //   68: astore 5
    //   70: aload_0
    //   71: getfield 26	bdiq:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   74: aload 5
    //   76: invokevirtual 149	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   79: astore 6
    //   81: aload 6
    //   83: instanceof 145
    //   86: ifeq -38 -> 48
    //   89: aload_3
    //   90: aload 5
    //   92: aload 6
    //   94: checkcast 145	java/lang/String
    //   97: invokevirtual 152	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   100: goto -52 -> 48
    //   103: astore_3
    //   104: aconst_null
    //   105: astore_1
    //   106: aload_1
    //   107: astore_2
    //   108: aload_3
    //   109: invokevirtual 155	java/lang/Exception:printStackTrace	()V
    //   112: aload_1
    //   113: ifnull +124 -> 237
    //   116: aload_1
    //   117: invokevirtual 160	java/io/InputStream:close	()V
    //   120: aconst_null
    //   121: astore_3
    //   122: aload_3
    //   123: areturn
    //   124: aload_1
    //   125: aload_3
    //   126: invokeinterface 166 2 0
    //   131: invokeinterface 172 1 0
    //   136: astore_1
    //   137: aload_1
    //   138: ifnull +101 -> 239
    //   141: aload_1
    //   142: invokeinterface 178 1 0
    //   147: astore_1
    //   148: aload_1
    //   149: astore_2
    //   150: aload_0
    //   151: aload_1
    //   152: invokevirtual 181	bdiq:a	(Ljava/io/InputStream;)[B
    //   155: astore_3
    //   156: aload_1
    //   157: astore_2
    //   158: aload_3
    //   159: iconst_0
    //   160: aload_3
    //   161: arraylength
    //   162: invokestatic 187	com/tencent/image/SafeBitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   165: astore_3
    //   166: aload_1
    //   167: astore_2
    //   168: aload_3
    //   169: astore_1
    //   170: aload_1
    //   171: astore_3
    //   172: aload_2
    //   173: ifnull -51 -> 122
    //   176: aload_2
    //   177: invokevirtual 160	java/io/InputStream:close	()V
    //   180: aload_1
    //   181: areturn
    //   182: astore_2
    //   183: aload_1
    //   184: areturn
    //   185: astore_1
    //   186: aconst_null
    //   187: areturn
    //   188: astore_3
    //   189: aconst_null
    //   190: astore_1
    //   191: aload_1
    //   192: astore_2
    //   193: aload_3
    //   194: invokevirtual 188	java/lang/OutOfMemoryError:printStackTrace	()V
    //   197: aload_1
    //   198: ifnull +39 -> 237
    //   201: aload_1
    //   202: invokevirtual 160	java/io/InputStream:close	()V
    //   205: aconst_null
    //   206: areturn
    //   207: astore_1
    //   208: aconst_null
    //   209: areturn
    //   210: astore_1
    //   211: aload_2
    //   212: ifnull +7 -> 219
    //   215: aload_2
    //   216: invokevirtual 160	java/io/InputStream:close	()V
    //   219: aload_1
    //   220: athrow
    //   221: astore_2
    //   222: goto -3 -> 219
    //   225: astore_1
    //   226: goto -15 -> 211
    //   229: astore_3
    //   230: goto -39 -> 191
    //   233: astore_3
    //   234: goto -128 -> 106
    //   237: aconst_null
    //   238: areturn
    //   239: aconst_null
    //   240: astore_2
    //   241: aconst_null
    //   242: astore_1
    //   243: goto -73 -> 170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	this	bdiq
    //   0	246	1	paramVarArgs	Void[]
    //   1	176	2	arrayOfVoid1	Void[]
    //   182	1	2	localIOException1	java.io.IOException
    //   192	24	2	arrayOfVoid2	Void[]
    //   221	1	2	localIOException2	java.io.IOException
    //   240	1	2	localObject1	java.lang.Object
    //   26	64	3	localHttpGet	org.apache.http.client.methods.HttpGet
    //   103	6	3	localException1	Exception
    //   121	51	3	localObject2	java.lang.Object
    //   188	6	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   229	1	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   233	1	3	localException2	Exception
    //   46	13	4	localIterator	java.util.Iterator
    //   68	23	5	str	String
    //   79	14	6	localObject3	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   15	48	103	java/lang/Exception
    //   48	100	103	java/lang/Exception
    //   124	137	103	java/lang/Exception
    //   141	148	103	java/lang/Exception
    //   176	180	182	java/io/IOException
    //   116	120	185	java/io/IOException
    //   15	48	188	java/lang/OutOfMemoryError
    //   48	100	188	java/lang/OutOfMemoryError
    //   124	137	188	java/lang/OutOfMemoryError
    //   141	148	188	java/lang/OutOfMemoryError
    //   201	205	207	java/io/IOException
    //   15	48	210	finally
    //   48	100	210	finally
    //   124	137	210	finally
    //   141	148	210	finally
    //   215	219	221	java/io/IOException
    //   108	112	225	finally
    //   150	156	225	finally
    //   158	166	225	finally
    //   193	197	225	finally
    //   150	156	229	java/lang/OutOfMemoryError
    //   158	166	229	java/lang/OutOfMemoryError
    //   150	156	233	java/lang/Exception
    //   158	166	233	java/lang/Exception
  }
  
  protected void a(Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_Bdir != null) {
      this.jdField_a_of_type_Bdir.a(this.c, paramBitmap);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdiq
 * JD-Core Version:    0.7.0.1
 */