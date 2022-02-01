import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mqp.app.bps.c;
import com.tencent.mqp.app.bps.d.1;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class biyr
{
  private static int jdField_a_of_type_Int;
  private static Handler jdField_a_of_type_AndroidOsHandler;
  public static Runnable a;
  private static String jdField_a_of_type_JavaLangString = "";
  private static boolean jdField_a_of_type_Boolean;
  private static String jdField_b_of_type_JavaLangString = "";
  private static boolean jdField_b_of_type_Boolean;
  private static String c = "";
  private static String d = "";
  private static String e;
  private static String f;
  private static String g;
  private static String h;
  private static String i;
  private static String j;
  private static String k;
  private static String l;
  private static String m;
  private static String n;
  private static String o;
  
  static
  {
    jdField_a_of_type_JavaLangString = biyo.a(biyo.a);
    jdField_b_of_type_JavaLangString = biyo.a(biyo.a);
    c = biyo.a(biyo.a);
    d = biyo.a(biyo.a);
    e = "";
    e = biyo.a(biyo.b);
    f = "";
    f = biyo.a(biyo.c);
    g = "";
    g = biyo.a(biyo.d);
    h = "";
    h = biyo.a(biyo.e);
    i = "";
    j = "";
    k = "";
    l = "";
    m = "";
    n = "";
    i = biyo.a(biyo.f);
    j = biyo.a(biyo.g);
    k = biyo.a(biyo.h);
    l = biyo.a(biyo.i);
    m = biyo.a(biyo.j);
    n = biyo.a(biyo.k);
    o = "";
    o = biyo.a(biyo.l);
    jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper());
    jdField_a_of_type_JavaLangRunnable = new d.1();
  }
  
  /* Error */
  private static String a(com.tencent.commonsdk.zip.QZipFile paramQZipFile, java.util.zip.ZipEntry paramZipEntry)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: aload_1
    //   5: invokevirtual 118	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   8: astore_1
    //   9: aload_1
    //   10: astore_0
    //   11: getstatic 120	biyo:m	[B
    //   14: invokestatic 44	biyo:a	([B)Ljava/lang/String;
    //   17: invokestatic 126	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   20: astore_3
    //   21: aload_1
    //   22: astore_0
    //   23: sipush 8192
    //   26: newarray byte
    //   28: astore 5
    //   30: aload_1
    //   31: astore_0
    //   32: aload_1
    //   33: aload 5
    //   35: invokevirtual 132	java/io/InputStream:read	([B)I
    //   38: istore_2
    //   39: iload_2
    //   40: iconst_m1
    //   41: if_icmpeq +39 -> 80
    //   44: aload_1
    //   45: astore_0
    //   46: aload_3
    //   47: aload 5
    //   49: iconst_0
    //   50: iload_2
    //   51: invokevirtual 136	java/security/MessageDigest:update	([BII)V
    //   54: goto -24 -> 30
    //   57: astore_3
    //   58: aload_1
    //   59: astore_0
    //   60: aload_3
    //   61: invokevirtual 139	java/lang/Exception:printStackTrace	()V
    //   64: aload 4
    //   66: astore_0
    //   67: aload_1
    //   68: ifnull +10 -> 78
    //   71: aload_1
    //   72: invokevirtual 142	java/io/InputStream:close	()V
    //   75: aload 4
    //   77: astore_0
    //   78: aload_0
    //   79: areturn
    //   80: aload_1
    //   81: astore_0
    //   82: aload_3
    //   83: invokevirtual 146	java/security/MessageDigest:digest	()[B
    //   86: invokestatic 149	biyp:a	([B)Ljava/lang/String;
    //   89: astore_3
    //   90: aload_3
    //   91: astore_0
    //   92: aload_1
    //   93: ifnull -15 -> 78
    //   96: aload_1
    //   97: invokevirtual 142	java/io/InputStream:close	()V
    //   100: aload_3
    //   101: areturn
    //   102: astore_0
    //   103: aload_0
    //   104: invokevirtual 139	java/lang/Exception:printStackTrace	()V
    //   107: aload_3
    //   108: areturn
    //   109: astore_0
    //   110: aload_0
    //   111: invokevirtual 139	java/lang/Exception:printStackTrace	()V
    //   114: aconst_null
    //   115: areturn
    //   116: astore_1
    //   117: aconst_null
    //   118: astore_0
    //   119: aload_0
    //   120: ifnull +7 -> 127
    //   123: aload_0
    //   124: invokevirtual 142	java/io/InputStream:close	()V
    //   127: aload_1
    //   128: athrow
    //   129: astore_0
    //   130: aload_0
    //   131: invokevirtual 139	java/lang/Exception:printStackTrace	()V
    //   134: goto -7 -> 127
    //   137: astore_1
    //   138: goto -19 -> 119
    //   141: astore_3
    //   142: aconst_null
    //   143: astore_1
    //   144: goto -86 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	paramQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   0	147	1	paramZipEntry	java.util.zip.ZipEntry
    //   38	13	2	i1	int
    //   20	27	3	localMessageDigest	java.security.MessageDigest
    //   57	26	3	localException1	Exception
    //   89	19	3	str	String
    //   141	1	3	localException2	Exception
    //   1	75	4	localObject	Object
    //   28	20	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   11	21	57	java/lang/Exception
    //   23	30	57	java/lang/Exception
    //   32	39	57	java/lang/Exception
    //   46	54	57	java/lang/Exception
    //   82	90	57	java/lang/Exception
    //   96	100	102	java/lang/Exception
    //   71	75	109	java/lang/Exception
    //   3	9	116	finally
    //   123	127	129	java/lang/Exception
    //   11	21	137	finally
    //   23	30	137	finally
    //   32	39	137	finally
    //   46	54	137	finally
    //   60	64	137	finally
    //   82	90	137	finally
    //   3	9	141	java/lang/Exception
  }
  
  /* Error */
  private static String a(String paramString)
  {
    // Byte code:
    //   0: new 114	com/tencent/commonsdk/zip/QZipFile
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 157	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: astore_0
    //   11: aload_1
    //   12: invokevirtual 161	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   15: astore_2
    //   16: aload_1
    //   17: astore_0
    //   18: aload_2
    //   19: invokeinterface 167 1 0
    //   24: ifeq +115 -> 139
    //   27: aload_1
    //   28: astore_0
    //   29: aload_2
    //   30: invokeinterface 171 1 0
    //   35: checkcast 173	java/util/zip/ZipEntry
    //   38: astore_3
    //   39: aload_1
    //   40: astore_0
    //   41: aload_3
    //   42: invokevirtual 176	java/util/zip/ZipEntry:isDirectory	()Z
    //   45: ifne -29 -> 16
    //   48: aload_1
    //   49: astore_0
    //   50: aload_3
    //   51: invokevirtual 180	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   54: astore 4
    //   56: aload_1
    //   57: astore_0
    //   58: aload 4
    //   60: ldc 182
    //   62: invokevirtual 188	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   65: ifne -49 -> 16
    //   68: aload_1
    //   69: astore_0
    //   70: aload 4
    //   72: getstatic 190	biyo:n	[B
    //   75: invokestatic 44	biyo:a	([B)Ljava/lang/String;
    //   78: invokevirtual 194	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   81: ifeq -65 -> 16
    //   84: aload_1
    //   85: astore_0
    //   86: aload 4
    //   88: getstatic 196	biyo:o	[B
    //   91: invokestatic 44	biyo:a	([B)Ljava/lang/String;
    //   94: invokevirtual 199	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   97: ifeq -81 -> 16
    //   100: aload_1
    //   101: astore_0
    //   102: aload 4
    //   104: bipush 47
    //   106: invokevirtual 203	java/lang/String:lastIndexOf	(I)I
    //   109: bipush 8
    //   111: if_icmpne -95 -> 16
    //   114: aload_1
    //   115: astore_0
    //   116: aload_1
    //   117: aload_3
    //   118: invokestatic 205	biyr:a	(Lcom/tencent/commonsdk/zip/QZipFile;Ljava/util/zip/ZipEntry;)Ljava/lang/String;
    //   121: astore_2
    //   122: aload_1
    //   123: ifnull +7 -> 130
    //   126: aload_1
    //   127: invokevirtual 206	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   130: aload_2
    //   131: areturn
    //   132: astore_0
    //   133: aload_0
    //   134: invokevirtual 207	java/io/IOException:printStackTrace	()V
    //   137: aload_2
    //   138: areturn
    //   139: aload_1
    //   140: ifnull +7 -> 147
    //   143: aload_1
    //   144: invokevirtual 206	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   147: aconst_null
    //   148: areturn
    //   149: astore_0
    //   150: aload_0
    //   151: invokevirtual 207	java/io/IOException:printStackTrace	()V
    //   154: goto -7 -> 147
    //   157: astore_2
    //   158: aconst_null
    //   159: astore_1
    //   160: aload_1
    //   161: astore_0
    //   162: aload_2
    //   163: invokevirtual 139	java/lang/Exception:printStackTrace	()V
    //   166: aload_1
    //   167: ifnull -20 -> 147
    //   170: aload_1
    //   171: invokevirtual 206	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   174: goto -27 -> 147
    //   177: astore_0
    //   178: aload_0
    //   179: invokevirtual 207	java/io/IOException:printStackTrace	()V
    //   182: goto -35 -> 147
    //   185: astore_2
    //   186: aconst_null
    //   187: astore_1
    //   188: aload_1
    //   189: astore_0
    //   190: aload_2
    //   191: invokevirtual 208	java/lang/OutOfMemoryError:printStackTrace	()V
    //   194: aload_1
    //   195: ifnull -48 -> 147
    //   198: aload_1
    //   199: invokevirtual 206	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   202: goto -55 -> 147
    //   205: astore_0
    //   206: aload_0
    //   207: invokevirtual 207	java/io/IOException:printStackTrace	()V
    //   210: goto -63 -> 147
    //   213: astore_1
    //   214: aconst_null
    //   215: astore_0
    //   216: aload_0
    //   217: ifnull +7 -> 224
    //   220: aload_0
    //   221: invokevirtual 206	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   224: aload_1
    //   225: athrow
    //   226: astore_0
    //   227: aload_0
    //   228: invokevirtual 207	java/io/IOException:printStackTrace	()V
    //   231: goto -7 -> 224
    //   234: astore_1
    //   235: goto -19 -> 216
    //   238: astore_2
    //   239: goto -51 -> 188
    //   242: astore_2
    //   243: goto -83 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	paramString	String
    //   8	191	1	localQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   213	12	1	localObject1	Object
    //   234	1	1	localObject2	Object
    //   15	123	2	localObject3	Object
    //   157	6	2	localException1	Exception
    //   185	6	2	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   238	1	2	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   242	1	2	localException2	Exception
    //   38	80	3	localZipEntry	java.util.zip.ZipEntry
    //   54	49	4	str	String
    // Exception table:
    //   from	to	target	type
    //   126	130	132	java/io/IOException
    //   143	147	149	java/io/IOException
    //   0	9	157	java/lang/Exception
    //   170	174	177	java/io/IOException
    //   0	9	185	java/lang/OutOfMemoryError
    //   198	202	205	java/io/IOException
    //   0	9	213	finally
    //   220	224	226	java/io/IOException
    //   11	16	234	finally
    //   18	27	234	finally
    //   29	39	234	finally
    //   41	48	234	finally
    //   50	56	234	finally
    //   58	68	234	finally
    //   70	84	234	finally
    //   86	100	234	finally
    //   102	114	234	finally
    //   116	122	234	finally
    //   162	166	234	finally
    //   190	194	234	finally
    //   11	16	238	java/lang/OutOfMemoryError
    //   18	27	238	java/lang/OutOfMemoryError
    //   29	39	238	java/lang/OutOfMemoryError
    //   41	48	238	java/lang/OutOfMemoryError
    //   50	56	238	java/lang/OutOfMemoryError
    //   58	68	238	java/lang/OutOfMemoryError
    //   70	84	238	java/lang/OutOfMemoryError
    //   86	100	238	java/lang/OutOfMemoryError
    //   102	114	238	java/lang/OutOfMemoryError
    //   116	122	238	java/lang/OutOfMemoryError
    //   11	16	242	java/lang/Exception
    //   18	27	242	java/lang/Exception
    //   29	39	242	java/lang/Exception
    //   41	48	242	java/lang/Exception
    //   50	56	242	java/lang/Exception
    //   58	68	242	java/lang/Exception
    //   70	84	242	java/lang/Exception
    //   86	100	242	java/lang/Exception
    //   102	114	242	java/lang/Exception
    //   116	122	242	java/lang/Exception
  }
  
  public static void a()
  {
    jdField_a_of_type_AndroidOsHandler.removeCallbacks(jdField_a_of_type_JavaLangRunnable);
    jdField_a_of_type_AndroidOsHandler.postDelayed(jdField_a_of_type_JavaLangRunnable, 210000L);
  }
  
  private static void a(long paramLong)
  {
    jdField_a_of_type_AndroidOsHandler.removeCallbacks(jdField_a_of_type_JavaLangRunnable);
    jdField_a_of_type_AndroidOsHandler.postDelayed(jdField_a_of_type_JavaLangRunnable, paramLong);
  }
  
  private static boolean a()
  {
    try
    {
      long l1 = BaseApplication.getContext().getSharedPreferences(f, 0).getLong(i, 0L);
      long l2 = System.currentTimeMillis();
      return l2 - l1 >= 86400000L;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return true;
  }
  
  public static void b()
  {
    if (a() == true) {
      c();
    }
    a(86400000L);
  }
  
  private static void c()
  {
    try
    {
      long l1 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(o, 2, "start");
      }
      if (!jdField_a_of_type_Boolean)
      {
        Object localObject = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (localObject == null) {
          return;
        }
        localObject = ((QQAppInterface)localObject).getApplication().getApplicationInfo().sourceDir;
        if (localObject != null)
        {
          jdField_a_of_type_Int = biyq.a((String)localObject, g);
          jdField_a_of_type_Boolean = true;
        }
      }
      else
      {
        long l2 = System.currentTimeMillis();
        d();
        long l3 = System.currentTimeMillis();
        e();
        long l4 = System.currentTimeMillis();
        QLog.d(o, 1, "cost(" + (l2 - l1) + ":" + (l3 - l2) + ":" + (l4 - l3) + ")");
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private static void d()
  {
    for (;;)
    {
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (localQQAppInterface == null) {
          return;
        }
        c localc = new c();
        localc.uint32_cmd.set(3);
        localc.uint32_result.set(jdField_a_of_type_Int);
        localc.uint32_appid.set(AppSetting.a());
        Object localObject1 = localQQAppInterface.getApplication().getApplicationInfo().sourceDir;
        if (localObject1 == null) {
          break;
        }
        if (!jdField_b_of_type_Boolean)
        {
          Object localObject3 = BaseApplication.getContext().getSharedPreferences(f, 0);
          localObject2 = ((SharedPreferences)localObject3).getString(j, null);
          String str1 = ((SharedPreferences)localObject3).getString(k, null);
          String str2 = ((SharedPreferences)localObject3).getString(l, null);
          String str3 = ((SharedPreferences)localObject3).getString(m, null);
          localObject3 = ((SharedPreferences)localObject3).getString(n, null);
          String str4 = a((String)localObject1);
          if (str4 != null) {
            jdField_b_of_type_JavaLangString = str4;
          }
          if ((str2 == null) || (!str2.equalsIgnoreCase(jdField_b_of_type_JavaLangString)) || (localObject3 == null) || (!((String)localObject3).equalsIgnoreCase("8.4.10.4875"))) {
            break label426;
          }
          if (localObject2 != null) {
            d = (String)localObject2;
          }
          if (str3 != null) {
            jdField_a_of_type_JavaLangString = str3;
          }
          if (str1 != null) {
            c = str1;
          }
        }
        localc.str_signature.set(d);
        localc.str_apkmd5.set(jdField_a_of_type_JavaLangString);
        localc.str_rsamd5.set(jdField_b_of_type_JavaLangString);
        localc.str_txsfcfgkmd5.set(c);
        localc.str_apkversion.set("8.4.10.4875");
        localc.str_channelid.set(AppSetting.c());
        localc.str_uin.set(localQQAppInterface.getCurrentAccountUin());
        localc.bytes_guid.set(ByteStringMicro.copyFrom(NetConnInfoCenter.GUID));
        localc.str_sysversion.set(Build.VERSION.RELEASE);
        localc.str_brand.set(Build.BRAND);
        localc.str_model.set(Build.MODEL);
        localObject2 = localQQAppInterface.getApplication().getPackageName();
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = "com.tencent.mobileqq";
        }
        localc.package_name.set((String)localObject1);
        localObject1 = new ToServiceMsg("mobileqq.service", localQQAppInterface.getCurrentAccountUin(), e);
        if (localObject1 == null) {
          break;
        }
        ((ToServiceMsg)localObject1).putWupBuffer(localc.toByteArray());
        ((ToServiceMsg)localObject1).extraData.putBoolean("req_pb_protocol_flag", true);
        ((ToServiceMsg)localObject1).setNeedCallback(false);
        localQQAppInterface.sendToService((ToServiceMsg)localObject1);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      label426:
      d = bkxn.a(BaseApplication.getContext());
      jdField_a_of_type_JavaLangString = bkxn.a(localException);
      Object localObject2 = new byte[16];
      if (localObject2 != null)
      {
        biyp.a(localException, g, (byte[])localObject2);
        c = bkxn.a((byte[])localObject2);
      }
      jdField_b_of_type_Boolean = true;
    }
  }
  
  private static void e()
  {
    try
    {
      SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences(f, 0).edit();
      localEditor.putLong(i, System.currentTimeMillis());
      localEditor.putString(j, d);
      localEditor.putString(k, c);
      localEditor.putString(l, jdField_b_of_type_JavaLangString);
      localEditor.putString(m, jdField_a_of_type_JavaLangString);
      localEditor.putString(n, "8.4.10.4875");
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biyr
 * JD-Core Version:    0.7.0.1
 */