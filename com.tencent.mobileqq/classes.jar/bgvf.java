import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.SharedPreferencesUtil;
import java.io.File;

public class bgvf
{
  private static volatile bgvf jdField_a_of_type_Bgvf;
  private static volatile byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  protected Context a;
  private ClassLoader jdField_a_of_type_JavaLangClassLoader;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  
  public static bgvf a()
  {
    if (jdField_a_of_type_Bgvf == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Bgvf == null) {
        jdField_a_of_type_Bgvf = new bgvf();
      }
      return jdField_a_of_type_Bgvf;
    }
  }
  
  private String a()
  {
    String str1 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "sdk.jar";
    if (new File(str1).exists()) {
      return str1;
    }
    str1 = SharedPreferencesUtil.getPreference().getString("downloadUrl", "");
    String str2 = SharedPreferencesUtil.getPreference().getString("version", "1.14.0.00225");
    String str3 = MiniSDKConst.getAppBaseLibDir(str1, str2);
    if ((!TextUtils.isEmpty(str3)) && (new File(str3).exists())) {
      return str3 + "sdk.jar";
    }
    str1 = MiniSDKConst.getQQAppBaseLibDir(str1, str2);
    if (!TextUtils.isEmpty(str1)) {
      return str1 + "sdk.jar";
    }
    return null;
  }
  
  /* Error */
  public java.lang.Class a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 101	bgvf:jdField_a_of_type_JavaLangClassLoader	Ljava/lang/ClassLoader;
    //   4: ifnonnull +7 -> 11
    //   7: aload_0
    //   8: invokevirtual 103	bgvf:a	()V
    //   11: ldc 105
    //   13: new 28	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   20: ldc 107
    //   22: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 113	com/tencent/qqmini/sdk/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload_0
    //   36: getfield 101	bgvf:jdField_a_of_type_JavaLangClassLoader	Ljava/lang/ClassLoader;
    //   39: ifnull +47 -> 86
    //   42: aload_0
    //   43: getfield 101	bgvf:jdField_a_of_type_JavaLangClassLoader	Ljava/lang/ClassLoader;
    //   46: aload_1
    //   47: invokevirtual 118	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   50: astore_2
    //   51: ldc 105
    //   53: new 28	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   60: ldc 107
    //   62: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload_1
    //   66: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc 120
    //   71: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_2
    //   75: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 113	com/tencent/qqmini/sdk/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: aload_2
    //   85: areturn
    //   86: aload_0
    //   87: invokevirtual 127	java/lang/Object:getClass	()Ljava/lang/Class;
    //   90: invokevirtual 133	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   93: aload_1
    //   94: invokevirtual 118	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   97: astore_2
    //   98: aload_2
    //   99: areturn
    //   100: astore_3
    //   101: aconst_null
    //   102: astore_2
    //   103: ldc 105
    //   105: new 28	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   112: ldc 107
    //   114: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload_1
    //   118: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: ldc 135
    //   123: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_3
    //   127: invokevirtual 138	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   130: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 141	com/tencent/qqmini/sdk/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: aload_0
    //   140: invokevirtual 127	java/lang/Object:getClass	()Ljava/lang/Class;
    //   143: invokevirtual 133	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   146: aload_1
    //   147: invokevirtual 118	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   150: astore 4
    //   152: aload 4
    //   154: areturn
    //   155: astore 4
    //   157: ldc 105
    //   159: new 28	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   166: ldc 107
    //   168: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_1
    //   172: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: ldc 135
    //   177: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: aload_3
    //   184: invokestatic 144	com/tencent/qqmini/sdk/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   187: aload_2
    //   188: areturn
    //   189: astore_3
    //   190: goto -87 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	bgvf
    //   0	193	1	paramString	String
    //   50	138	2	localClass1	java.lang.Class
    //   100	84	3	localException1	java.lang.Exception
    //   189	1	3	localException2	java.lang.Exception
    //   150	3	4	localClass2	java.lang.Class
    //   155	1	4	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   0	11	100	java/lang/Exception
    //   11	51	100	java/lang/Exception
    //   86	98	100	java/lang/Exception
    //   139	152	155	java/lang/Throwable
    //   51	84	189	java/lang/Exception
  }
  
  /* Error */
  public Object a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 101	bgvf:jdField_a_of_type_JavaLangClassLoader	Ljava/lang/ClassLoader;
    //   4: ifnonnull +7 -> 11
    //   7: aload_0
    //   8: invokevirtual 103	bgvf:a	()V
    //   11: ldc 105
    //   13: new 28	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   20: ldc 147
    //   22: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 113	com/tencent/qqmini/sdk/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload_0
    //   36: getfield 101	bgvf:jdField_a_of_type_JavaLangClassLoader	Ljava/lang/ClassLoader;
    //   39: ifnull +53 -> 92
    //   42: aload_1
    //   43: aload_0
    //   44: getfield 101	bgvf:jdField_a_of_type_JavaLangClassLoader	Ljava/lang/ClassLoader;
    //   47: invokestatic 152	bgvg:a	(Ljava/lang/String;Ljava/lang/ClassLoader;)Lbgvg;
    //   50: invokevirtual 155	bgvg:a	()Lbgvg;
    //   53: invokevirtual 158	bgvg:a	()Ljava/lang/Object;
    //   56: astore_2
    //   57: ldc 105
    //   59: new 28	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   66: ldc 147
    //   68: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_1
    //   72: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: ldc 160
    //   77: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_2
    //   81: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 113	com/tencent/qqmini/sdk/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_2
    //   91: areturn
    //   92: aload_1
    //   93: aload_0
    //   94: invokevirtual 127	java/lang/Object:getClass	()Ljava/lang/Class;
    //   97: invokevirtual 133	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   100: invokestatic 152	bgvg:a	(Ljava/lang/String;Ljava/lang/ClassLoader;)Lbgvg;
    //   103: invokevirtual 155	bgvg:a	()Lbgvg;
    //   106: invokevirtual 158	bgvg:a	()Ljava/lang/Object;
    //   109: astore_2
    //   110: aload_2
    //   111: areturn
    //   112: astore_3
    //   113: aconst_null
    //   114: astore_2
    //   115: ldc 105
    //   117: new 28	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   124: ldc 162
    //   126: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload_1
    //   130: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: ldc 135
    //   135: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_3
    //   139: invokevirtual 138	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   142: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 141	com/tencent/qqmini/sdk/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: aload_1
    //   152: aload_0
    //   153: invokevirtual 127	java/lang/Object:getClass	()Ljava/lang/Class;
    //   156: invokevirtual 133	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   159: invokestatic 152	bgvg:a	(Ljava/lang/String;Ljava/lang/ClassLoader;)Lbgvg;
    //   162: invokevirtual 155	bgvg:a	()Lbgvg;
    //   165: invokevirtual 158	bgvg:a	()Ljava/lang/Object;
    //   168: astore 4
    //   170: aload 4
    //   172: areturn
    //   173: astore 4
    //   175: ldc 105
    //   177: new 28	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   184: ldc 162
    //   186: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload_1
    //   190: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: ldc 135
    //   195: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: aload_3
    //   202: invokestatic 144	com/tencent/qqmini/sdk/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   205: aload_2
    //   206: areturn
    //   207: astore_3
    //   208: goto -93 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	this	bgvf
    //   0	211	1	paramString	String
    //   56	150	2	localObject1	Object
    //   112	90	3	localException1	java.lang.Exception
    //   207	1	3	localException2	java.lang.Exception
    //   168	3	4	localObject2	Object
    //   173	1	4	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   0	11	112	java/lang/Exception
    //   11	57	112	java/lang/Exception
    //   92	110	112	java/lang/Exception
    //   151	170	173	java/lang/Throwable
    //   57	90	207	java/lang/Exception
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 21	bgvf:jdField_a_of_type_Boolean	Z
    //   6: ifeq +19 -> 25
    //   9: aload_0
    //   10: getfield 164	bgvf:b	Z
    //   13: ifne +12 -> 25
    //   16: aload_0
    //   17: getfield 166	bgvf:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   20: astore_1
    //   21: aload_1
    //   22: ifnonnull +6 -> 28
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: aload_0
    //   29: invokevirtual 127	java/lang/Object:getClass	()Ljava/lang/Class;
    //   32: invokevirtual 133	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   35: pop
    //   36: aload_0
    //   37: invokevirtual 168	bgvf:a	()Z
    //   40: ifeq +42 -> 82
    //   43: aload_0
    //   44: getfield 101	bgvf:jdField_a_of_type_JavaLangClassLoader	Ljava/lang/ClassLoader;
    //   47: ifnonnull +35 -> 82
    //   50: aload_0
    //   51: new 170	bgve
    //   54: dup
    //   55: aload_0
    //   56: invokespecial 172	bgvf:a	()Ljava/lang/String;
    //   59: aload_0
    //   60: getfield 166	bgvf:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   63: invokevirtual 178	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   66: getfield 183	android/content/pm/ApplicationInfo:nativeLibraryDir	Ljava/lang/String;
    //   69: aload_0
    //   70: invokevirtual 127	java/lang/Object:getClass	()Ljava/lang/Class;
    //   73: invokevirtual 133	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   76: invokespecial 186	bgve:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   79: putfield 101	bgvf:jdField_a_of_type_JavaLangClassLoader	Ljava/lang/ClassLoader;
    //   82: aload_0
    //   83: iconst_1
    //   84: putfield 164	bgvf:b	Z
    //   87: goto -62 -> 25
    //   90: astore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	bgvf
    //   20	2	1	localContext	Context
    //   90	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	90	finally
    //   28	82	90	finally
    //   82	87	90	finally
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Boolean = paramBoolean;
    QMLog.w("minisdk-MiniAppDexLoader", "enableDex: " + paramBoolean);
  }
  
  public boolean a()
  {
    String str = a();
    if (TextUtils.isEmpty(str)) {}
    while (!new File(str).exists()) {
      return false;
    }
    QMLog.i("minisdk-MiniAppDexLoader", "load dexPath : " + str);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgvf
 * JD-Core Version:    0.7.0.1
 */