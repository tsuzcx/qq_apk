import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.utils.HeavyTaskExecutor;
import com.tencent.mobileqq.listentogether.player.QQMusicPlayService;
import com.tencent.mobileqq.log.ReportLog.3;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.CrashHandler;
import mqq.app.MobileQQ;

public class arzw
  extends CrashHandler
{
  static ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static bbmi jdField_a_of_type_Bbmi;
  public static String a;
  private static Thread.UncaughtExceptionHandler jdField_a_of_type_JavaLangThread$UncaughtExceptionHandler;
  public static boolean a;
  private static final byte[] jdField_a_of_type_ArrayOfByte = "9u23fh$jkf^%43hj".getBytes();
  public static String b;
  private static boolean jdField_b_of_type_Boolean;
  private static byte[] jdField_b_of_type_ArrayOfByte;
  private static String c = "0";
  
  static
  {
    jdField_a_of_type_JavaLangString = "/Tencent/MobileQQ/log/";
    jdField_a_of_type_AndroidOsHandler = new arzx(Looper.getMainLooper());
    jdField_a_of_type_Bbmi = new arzy();
    jdField_b_of_type_JavaLangString = "http://bugtrace.3g.qq.com/upload/1/0";
  }
  
  public arzw()
  {
    if (jdField_a_of_type_JavaLangThread$UncaughtExceptionHandler == null) {
      jdField_a_of_type_JavaLangThread$UncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    if (jdField_b_of_type_Boolean == paramBoolean) {}
    do
    {
      return;
      jdField_b_of_type_Boolean = paramBoolean;
    } while (!paramBoolean);
    try
    {
      jdField_a_of_type_JavaLangString = arzz.a(paramContext, "/Tencent/MobileQQ/log/") + "/";
      arzz.jdField_a_of_type_JavaLangString = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      arzz.jdField_b_of_type_JavaLangString = Build.MODEL;
      arzz.c = Build.VERSION.RELEASE;
      return;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
  }
  
  /* Error */
  public static void a(com.tencent.mobileqq.utils.httputils.HttpCommunicator paramHttpCommunicator, Context paramContext, ProgressDialog paramProgressDialog, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: invokestatic 135	com/tencent/common/config/AppSetting:a	()I
    //   6: ldc 137
    //   8: ldc 139
    //   10: aload_3
    //   11: aload 4
    //   13: invokestatic 145	com/tencent/qphone/base/util/QLog:doReportLogSelf	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   16: aload_0
    //   17: ifnonnull +4 -> 21
    //   20: return
    //   21: aload_2
    //   22: putstatic 147	arzw:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   25: new 76	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   32: aload_1
    //   33: ldc 32
    //   35: invokestatic 82	arzz:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   38: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc 88
    //   43: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: putstatic 34	arzw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   52: new 149	java/io/File
    //   55: dup
    //   56: new 76	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   63: getstatic 34	arzw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   66: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc 151
    //   71: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokespecial 154	java/io/File:<init>	(Ljava/lang/String;)V
    //   80: astore 9
    //   82: aload 9
    //   84: invokevirtual 158	java/io/File:exists	()Z
    //   87: ifeq -67 -> 20
    //   90: aconst_null
    //   91: ldc 160
    //   93: iconst_1
    //   94: invokestatic 163	arzw:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   97: iconst_1
    //   98: putstatic 165	arzw:jdField_a_of_type_Boolean	Z
    //   101: aload 9
    //   103: invokevirtual 169	java/io/File:length	()J
    //   106: lstore 6
    //   108: lload 6
    //   110: l2i
    //   111: newarray byte
    //   113: astore 4
    //   115: new 171	java/io/BufferedInputStream
    //   118: dup
    //   119: new 173	java/io/FileInputStream
    //   122: dup
    //   123: aload 9
    //   125: invokespecial 176	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   128: invokespecial 179	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   131: astore_2
    //   132: lload 6
    //   134: l2i
    //   135: istore 5
    //   137: aload_2
    //   138: astore_1
    //   139: aload_2
    //   140: aload 4
    //   142: iconst_0
    //   143: iload 5
    //   145: invokevirtual 183	java/io/BufferedInputStream:read	([BII)I
    //   148: i2l
    //   149: lload 6
    //   151: lcmp
    //   152: ifeq +41 -> 193
    //   155: aload_2
    //   156: astore_1
    //   157: new 128	java/lang/Exception
    //   160: dup
    //   161: ldc 185
    //   163: invokespecial 186	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   166: athrow
    //   167: astore_1
    //   168: aload_2
    //   169: astore_0
    //   170: aload_1
    //   171: astore_2
    //   172: aload_0
    //   173: astore_1
    //   174: aload_2
    //   175: invokevirtual 189	java/lang/Exception:printStackTrace	()V
    //   178: aload_0
    //   179: ifnull -159 -> 20
    //   182: aload_0
    //   183: invokevirtual 192	java/io/BufferedInputStream:close	()V
    //   186: return
    //   187: astore_0
    //   188: aload_0
    //   189: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   192: return
    //   193: aload_2
    //   194: astore_1
    //   195: aload_2
    //   196: invokevirtual 192	java/io/BufferedInputStream:close	()V
    //   199: aload 9
    //   201: invokevirtual 196	java/io/File:delete	()Z
    //   204: pop
    //   205: getstatic 198	arzw:jdField_b_of_type_ArrayOfByte	[B
    //   208: ifnonnull +178 -> 386
    //   211: ldc 200
    //   213: invokevirtual 24	java/lang/String:getBytes	()[B
    //   216: putstatic 198	arzw:jdField_b_of_type_ArrayOfByte	[B
    //   219: goto +167 -> 386
    //   222: new 202	KQQ/UploadInfo
    //   225: dup
    //   226: invokespecial 203	KQQ/UploadInfo:<init>	()V
    //   229: astore_2
    //   230: aload_2
    //   231: invokestatic 135	com/tencent/common/config/AppSetting:a	()I
    //   234: i2l
    //   235: putfield 207	KQQ/UploadInfo:lAppID	J
    //   238: aload_2
    //   239: aload_1
    //   240: invokestatic 213	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   243: putfield 216	KQQ/UploadInfo:lFromMID	J
    //   246: aload_2
    //   247: lconst_0
    //   248: putfield 219	KQQ/UploadInfo:lToMID	J
    //   251: aload_2
    //   252: iconst_1
    //   253: putfield 223	KQQ/UploadInfo:shType	S
    //   256: aload_2
    //   257: getstatic 198	arzw:jdField_b_of_type_ArrayOfByte	[B
    //   260: putfield 226	KQQ/UploadInfo:vSignature	[B
    //   263: aload_2
    //   264: invokevirtual 229	KQQ/UploadInfo:toByteArray	()[B
    //   267: astore_1
    //   268: new 231	com/tencent/qphone/base/util/Cryptor
    //   271: dup
    //   272: invokespecial 232	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   275: aload_1
    //   276: getstatic 26	arzw:jdField_a_of_type_ArrayOfByte	[B
    //   279: invokevirtual 236	com/tencent/qphone/base/util/Cryptor:encrypt	([B[B)[B
    //   282: astore_1
    //   283: new 238	KQQ/HttpUploadReq
    //   286: dup
    //   287: invokespecial 239	KQQ/HttpUploadReq:<init>	()V
    //   290: astore_2
    //   291: aload_2
    //   292: aload_1
    //   293: putfield 242	KQQ/HttpUploadReq:vEncryptUploadInfo	[B
    //   296: aload_2
    //   297: aload 4
    //   299: putfield 245	KQQ/HttpUploadReq:vFileData	[B
    //   302: new 247	bbmg
    //   305: dup
    //   306: getstatic 58	arzw:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   309: aload_2
    //   310: invokevirtual 248	KQQ/HttpUploadReq:toByteArray	()[B
    //   313: getstatic 54	arzw:jdField_a_of_type_Bbmi	Lbbmi;
    //   316: invokespecial 251	bbmg:<init>	(Ljava/lang/String;[BLbbmi;)V
    //   319: astore_1
    //   320: aload_1
    //   321: ldc 253
    //   323: invokevirtual 255	bbmg:b	(Ljava/lang/String;)V
    //   326: aload_0
    //   327: aload_1
    //   328: invokevirtual 260	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmg;)I
    //   331: pop
    //   332: iconst_0
    //   333: putstatic 165	arzw:jdField_a_of_type_Boolean	Z
    //   336: iconst_0
    //   337: ifeq -317 -> 20
    //   340: new 262	java/lang/NullPointerException
    //   343: dup
    //   344: invokespecial 263	java/lang/NullPointerException:<init>	()V
    //   347: athrow
    //   348: astore_0
    //   349: aload_0
    //   350: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   353: return
    //   354: astore_0
    //   355: aload 8
    //   357: astore_1
    //   358: aload_1
    //   359: ifnull +7 -> 366
    //   362: aload_1
    //   363: invokevirtual 192	java/io/BufferedInputStream:close	()V
    //   366: aload_0
    //   367: athrow
    //   368: astore_1
    //   369: aload_1
    //   370: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   373: goto -7 -> 366
    //   376: astore_0
    //   377: goto -19 -> 358
    //   380: astore_2
    //   381: aconst_null
    //   382: astore_0
    //   383: goto -211 -> 172
    //   386: aload_3
    //   387: astore_1
    //   388: aload_3
    //   389: ifnonnull -167 -> 222
    //   392: ldc 28
    //   394: astore_1
    //   395: goto -173 -> 222
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	398	0	paramHttpCommunicator	com.tencent.mobileqq.utils.httputils.HttpCommunicator
    //   0	398	1	paramContext	Context
    //   0	398	2	paramProgressDialog	ProgressDialog
    //   0	398	3	paramString1	String
    //   0	398	4	paramString2	String
    //   135	9	5	i	int
    //   106	44	6	l	long
    //   1	355	8	localObject	Object
    //   80	120	9	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   139	155	167	java/lang/Exception
    //   157	167	167	java/lang/Exception
    //   195	199	167	java/lang/Exception
    //   182	186	187	java/io/IOException
    //   340	348	348	java/io/IOException
    //   97	132	354	finally
    //   199	219	354	finally
    //   222	336	354	finally
    //   362	366	368	java/io/IOException
    //   139	155	376	finally
    //   157	167	376	finally
    //   174	178	376	finally
    //   195	199	376	finally
    //   97	132	380	java/lang/Exception
    //   199	219	380	java/lang/Exception
    //   222	336	380	java/lang/Exception
  }
  
  public static void a(String paramString)
  {
    c = paramString;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (!jdField_b_of_type_Boolean) {}
    while (jdField_a_of_type_Boolean) {
      return;
    }
    a(paramString1, paramString2, true);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    arzz.a(paramString1, paramString2, paramBoolean);
  }
  
  private boolean a(Throwable paramThrowable)
  {
    boolean bool = true;
    if ((paramThrowable == null) || (1 != BaseApplicationImpl.sProcessId) || (System.currentTimeMillis() - axrl.jdField_b_of_type_Long > 600000L)) {}
    Object localObject2;
    do
    {
      return false;
      localObject2 = BaseApplicationImpl.getContext().getSharedPreferences("pref_safemode_not_exit", 4);
    } while (!((SharedPreferences)localObject2).getBoolean("key_not_exit_enable", false));
    Object localObject1 = paramThrowable.toString();
    int k;
    int j;
    int i;
    label180:
    int i1;
    label212:
    int m;
    try
    {
      localObject3 = ((SharedPreferences)localObject2).getString("key_not_exit_crash_type", null);
      localObject2 = ((SharedPreferences)localObject2).getString("key_not_exit_crash_stack", null);
      if ((localObject3 == null) || (TextUtils.isEmpty((CharSequence)localObject1))) {
        break label353;
      }
      localObject3 = ((String)localObject3).split("\\|");
      k = localObject3.length;
      j = 0;
      i = 0;
      if (j >= k) {
        break label365;
      }
      CharSequence localCharSequence = localObject3[j];
      if (!((String)localObject1).contains(localCharSequence)) {
        break label358;
      }
      QLog.d("ReportLog", 1, new Object[] { "exMsg = ", localObject1, ",crash = ", localCharSequence });
      i = 1;
    }
    catch (Throwable paramThrowable)
    {
      Object localObject3;
      int i2;
      int n;
      QLog.e("ReportLog", 1, "isNotExitSafeMode has some error", paramThrowable);
      return false;
    }
    if (localObject2 != null)
    {
      localObject1 = ((String)localObject2).split("\\|");
      paramThrowable = paramThrowable.getStackTrace();
      i1 = paramThrowable.length;
      k = 0;
      i = 0;
      break label370;
      localObject2 = ((StackTraceElement)localObject2).toString();
      i2 = localObject1.length;
      n = 0;
      for (;;)
      {
        m = i;
        if (n < i2)
        {
          localObject3 = localObject1[n];
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject2).contains((CharSequence)localObject3)))
          {
            QLog.d("ReportLog", 1, new Object[] { "stackElemStr = ", localObject2, ",crash = ", localObject3 });
            m = 1;
          }
        }
        else
        {
          k += 1;
          i = m;
          break;
        }
        n += 1;
      }
    }
    label353:
    label358:
    label365:
    label370:
    do
    {
      bool = false;
      break label402;
      m = 0;
      continue;
      j = 0;
      break label180;
      j += 1;
      break;
      j = i;
      break label180;
      m = i;
      if (k < i1)
      {
        localObject2 = paramThrowable[k];
        if (i == 0) {
          break label212;
        }
        m = i;
      }
    } while ((m == 0) || (j == 0));
    label402:
    return bool;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    QLog.d("ReportLog", 1, "uncaughtException java crash=" + paramThrowable);
    if (paramThrowable != null)
    {
      String str = paramThrowable.toString();
      if ((!TextUtils.isEmpty(str)) && (str.contains("java.util.concurrent.TimeoutException")) && (str.contains(".finalize() timed out after"))) {
        return;
      }
    }
    if (a(paramThrowable))
    {
      xos.a(ajyc.a(2131713412));
      axrl.jdField_b_of_type_Boolean = true;
      axps.a(new Throwable(paramThrowable), "notExitOnSafeMode");
      if (Looper.myLooper() != null) {
        for (;;)
        {
          try
          {
            Looper.loop();
            continue;
            if (a(paramThread)) {
              continue;
            }
          }
          catch (Throwable paramThread)
          {
            QLog.d("ReportLog", 1, "uncaughtException loop throwable=", paramThread);
          }
          if (Looper.getMainLooper() != Looper.myLooper()) {
            break;
          }
          System.exit(0);
        }
      }
      try
      {
        paramThread.run();
        return;
      }
      catch (Throwable paramThrowable)
      {
        QLog.d("ReportLog", 1, "uncaughtException run throwable=", paramThrowable);
        try
        {
          paramThread.interrupt();
          return;
        }
        catch (Throwable paramThread)
        {
          QLog.d("ReportLog", 1, "uncaughtException interrupt throwable=", paramThread);
          return;
        }
      }
    }
    super.uncaughtException(paramThread, paramThrowable);
    long l = System.currentTimeMillis();
    QLog.d("ReportLog", 1, "uncaughtException trySave cost=" + (System.currentTimeMillis() - l));
    HeavyTaskExecutor.a();
    QLog.d("ReportLog", 1, "uncaughtException HeavyTask cost=" + (System.currentTimeMillis() - l));
    paramThread = MobileQQ.sMobileQQ;
    try
    {
      arzz.jdField_a_of_type_JavaLangString = paramThread.getPackageManager().getPackageInfo(paramThread.getPackageName(), 0).versionName;
      arzz.jdField_b_of_type_JavaLangString = Build.MODEL;
      arzz.c = Build.VERSION.RELEASE;
      label295:
      paramThread.crashed();
      paramThread.sendBroadcast(new Intent("qqplayer_exit_action"));
      QQMusicPlayService.b("ReportLog");
      paramThread = new ReportLog.3(this, paramThread);
      if (Thread.currentThread() != Looper.getMainLooper().getThread())
      {
        new Handler(Looper.getMainLooper()).postAtFrontOfQueue(paramThread);
        return;
      }
      paramThread.run();
      return;
    }
    catch (Exception paramThrowable)
    {
      break label295;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arzw
 * JD-Core Version:    0.7.0.1
 */