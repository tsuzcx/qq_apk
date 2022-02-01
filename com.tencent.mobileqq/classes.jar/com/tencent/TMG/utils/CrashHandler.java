package com.tencent.TMG.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CrashHandler
  implements Thread.UncaughtExceptionHandler
{
  private static final String ENCRYPT_KET = "strKey";
  private static final String FILE_NAME = "crash";
  private static final String LOG_FILE_NAME_SUFFIX = ".trace";
  private static final String PATH;
  public static final String REPORT_URL = "https://avlab.qq.com:8080/crashreport?action=crashreport";
  private static final String SO_LIBRARY_NAME = "crash_catcher";
  private static final String TAG;
  private static CrashHandler sInstance;
  private Context mContext;
  private Thread.UncaughtExceptionHandler mDefaultCrashHandler;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(CrashHandler.class.getSimpleName());
    localStringBuilder.append("runhw");
    TAG = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
    localStringBuilder.append("/test/log/");
    PATH = localStringBuilder.toString();
    sInstance = new CrashHandler();
    System.loadLibrary("crash_catcher");
  }
  
  public static void dumpExceptionToSDCard(String paramString)
  {
    NetUtil.debugInfo(TAG, "dumpExceptionToSDCard(String): ");
    sInstance.dumpExceptionToSDCard(new Exception(paramString));
    Process.killProcess(Process.myPid());
  }
  
  private String dumpPhoneInfo()
  {
    Object localObject2 = this.mContext.getPackageManager();
    Object localObject1 = null;
    try
    {
      Object localObject3 = ((PackageManager)localObject2).getPackageInfo(this.mContext.getPackageName(), 1);
      localObject2 = "App Version: ";
      localObject1 = localObject2;
      StringBuilder localStringBuilder = new StringBuilder();
      localObject1 = localObject2;
      localStringBuilder.append("App Version: ");
      localObject1 = localObject2;
      localStringBuilder.append(((PackageInfo)localObject3).versionName);
      localObject1 = localObject2;
      localObject2 = localStringBuilder.toString();
      localObject1 = localObject2;
      localStringBuilder = new StringBuilder();
      localObject1 = localObject2;
      localStringBuilder.append((String)localObject2);
      localObject1 = localObject2;
      localStringBuilder.append('_');
      localObject1 = localObject2;
      localObject2 = localStringBuilder.toString();
      localObject1 = localObject2;
      localStringBuilder = new StringBuilder();
      localObject1 = localObject2;
      localStringBuilder.append((String)localObject2);
      localObject1 = localObject2;
      localStringBuilder.append(((PackageInfo)localObject3).versionCode);
      localObject1 = localObject2;
      localObject2 = localStringBuilder.toString();
      localObject1 = localObject2;
      localObject3 = new StringBuilder();
      localObject1 = localObject2;
      ((StringBuilder)localObject3).append((String)localObject2);
      localObject1 = localObject2;
      ((StringBuilder)localObject3).append("\nOS Version: ");
      localObject1 = localObject2;
      localObject2 = ((StringBuilder)localObject3).toString();
      localObject1 = localObject2;
      localObject3 = new StringBuilder();
      localObject1 = localObject2;
      ((StringBuilder)localObject3).append((String)localObject2);
      localObject1 = localObject2;
      ((StringBuilder)localObject3).append(Build.VERSION.RELEASE);
      localObject1 = localObject2;
      localObject2 = ((StringBuilder)localObject3).toString();
      localObject1 = localObject2;
      localObject3 = new StringBuilder();
      localObject1 = localObject2;
      ((StringBuilder)localObject3).append((String)localObject2);
      localObject1 = localObject2;
      ((StringBuilder)localObject3).append("_");
      localObject1 = localObject2;
      localObject2 = ((StringBuilder)localObject3).toString();
      localObject1 = localObject2;
      localObject3 = new StringBuilder();
      localObject1 = localObject2;
      ((StringBuilder)localObject3).append((String)localObject2);
      localObject1 = localObject2;
      ((StringBuilder)localObject3).append(Build.VERSION.SDK_INT);
      localObject1 = localObject2;
      localObject2 = ((StringBuilder)localObject3).toString();
      localObject1 = localObject2;
      localObject3 = new StringBuilder();
      localObject1 = localObject2;
      ((StringBuilder)localObject3).append((String)localObject2);
      localObject1 = localObject2;
      ((StringBuilder)localObject3).append("\nVendor: ");
      localObject1 = localObject2;
      localObject2 = ((StringBuilder)localObject3).toString();
      localObject1 = localObject2;
      localObject3 = new StringBuilder();
      localObject1 = localObject2;
      ((StringBuilder)localObject3).append((String)localObject2);
      localObject1 = localObject2;
      ((StringBuilder)localObject3).append(Build.MANUFACTURER);
      localObject1 = localObject2;
      localObject2 = ((StringBuilder)localObject3).toString();
      localObject1 = localObject2;
      localObject3 = new StringBuilder();
      localObject1 = localObject2;
      ((StringBuilder)localObject3).append((String)localObject2);
      localObject1 = localObject2;
      ((StringBuilder)localObject3).append("\nModel: ");
      localObject1 = localObject2;
      localObject2 = ((StringBuilder)localObject3).toString();
      localObject1 = localObject2;
      localObject3 = new StringBuilder();
      localObject1 = localObject2;
      ((StringBuilder)localObject3).append((String)localObject2);
      localObject1 = localObject2;
      ((StringBuilder)localObject3).append(Build.MODEL);
      localObject1 = localObject2;
      localObject2 = ((StringBuilder)localObject3).toString();
      localObject1 = localObject2;
      localObject3 = new StringBuilder();
      localObject1 = localObject2;
      ((StringBuilder)localObject3).append((String)localObject2);
      localObject1 = localObject2;
      ((StringBuilder)localObject3).append("\nCPU ABI: ");
      localObject1 = localObject2;
      localObject2 = ((StringBuilder)localObject3).toString();
      localObject1 = localObject2;
      localObject3 = new StringBuilder();
      localObject1 = localObject2;
      ((StringBuilder)localObject3).append((String)localObject2);
      localObject1 = localObject2;
      ((StringBuilder)localObject3).append(Build.CPU_ABI);
      localObject1 = localObject2;
      localObject2 = ((StringBuilder)localObject3).toString();
      return localObject2;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
    return localObject1;
  }
  
  public static CrashHandler getInstance()
  {
    return sInstance;
  }
  
  private native void registerSigaction();
  
  public void dumpExceptionToSDCard(Throwable paramThrowable)
  {
    NetUtil.debugInfo(TAG, "dumpExceptionToSDCard(Throwable): ");
    Object localObject1 = TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("dumpExceptionToSDCard: msg = ");
    ((StringBuilder)localObject2).append(paramThrowable.getMessage());
    ((StringBuilder)localObject2).append("\n");
    NetUtil.debugInfo((String)localObject1, ((StringBuilder)localObject2).toString());
    if (!Environment.getExternalStorageState().equals("mounted"))
    {
      NetUtil.debugInfo(TAG, "sdcard unmounted,skip dump exception");
      return;
    }
    localObject1 = new File(PATH);
    if ((!((File)localObject1).exists()) && (!((File)localObject1).mkdirs()))
    {
      NetUtil.debugInfo(TAG, "dumpExceptionToSDCard: dir not exist");
      return;
    }
    long l = System.currentTimeMillis();
    localObject1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(l));
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(PATH);
    ((StringBuilder)localObject2).append("crash");
    ((StringBuilder)localObject2).append(".trace");
    localObject2 = new File(((StringBuilder)localObject2).toString());
    try
    {
      if ((!((File)localObject2).exists()) && (!((File)localObject2).createNewFile()))
      {
        NetUtil.debugInfo(TAG, "dumpExceptionToSDCard: file not exist");
        return;
      }
      localObject2 = new PrintWriter(new BufferedWriter(new FileWriter((File)localObject2, true)));
      ((PrintWriter)localObject2).println((String)localObject1);
      ((PrintWriter)localObject2).println();
      paramThrowable.printStackTrace((PrintWriter)localObject2);
      ((PrintWriter)localObject2).close();
      return;
    }
    catch (Exception paramThrowable)
    {
      paramThrowable.printStackTrace();
      NetUtil.debugInfo(TAG, "dump crash info failed");
    }
  }
  
  public String encrypt(String paramString1, String paramString2)
  {
    byte[] arrayOfByte = paramString1.getBytes();
    paramString2 = paramString2.getBytes();
    int m = 0;
    int j = 0;
    int i = 0;
    int k;
    for (;;)
    {
      k = m;
      if (j >= paramString1.length()) {
        break;
      }
      arrayOfByte[j] = ((byte)(arrayOfByte[j] ^ paramString2[i]));
      k = i + 1;
      i = k;
      if (k == paramString2.length) {
        i = 0;
      }
      j += 1;
    }
    while (k < 10)
    {
      System.out.println(arrayOfByte[k]);
      k += 1;
    }
    return new String(arrayOfByte);
  }
  
  public void init(Context paramContext) {}
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    dumpExceptionToSDCard(paramThrowable);
    paramThrowable.printStackTrace();
    Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = this.mDefaultCrashHandler;
    if (localUncaughtExceptionHandler != null)
    {
      localUncaughtExceptionHandler.uncaughtException(paramThread, paramThrowable);
      return;
    }
    Process.killProcess(Process.myPid());
  }
  
  public native void unregisterSigaction();
  
  /* Error */
  public void uploadCrashInfoToServer()
  {
    // Byte code:
    //   0: getstatic 54	com/tencent/TMG/utils/CrashHandler:TAG	Ljava/lang/String;
    //   3: ldc_w 297
    //   6: invokestatic 89	com/tencent/TMG/utils/NetUtil:debugInfo	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aconst_null
    //   10: astore_3
    //   11: new 34	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   18: astore_2
    //   19: aload_2
    //   20: getstatic 69	com/tencent/TMG/utils/CrashHandler:PATH	Ljava/lang/String;
    //   23: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload_2
    //   28: ldc 13
    //   30: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload_2
    //   35: ldc 16
    //   37: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: new 62	java/io/File
    //   44: dup
    //   45: aload_2
    //   46: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokespecial 203	java/io/File:<init>	(Ljava/lang/String;)V
    //   52: astore 5
    //   54: aload 5
    //   56: invokevirtual 207	java/io/File:exists	()Z
    //   59: ifeq +316 -> 375
    //   62: new 299	java/io/BufferedReader
    //   65: dup
    //   66: new 301	java/io/FileReader
    //   69: dup
    //   70: aload 5
    //   72: invokespecial 304	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   75: invokespecial 307	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   78: astore_3
    //   79: aload_3
    //   80: astore_2
    //   81: new 34	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   88: astore 6
    //   90: aload_3
    //   91: astore_2
    //   92: aload_3
    //   93: invokevirtual 310	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   96: astore 4
    //   98: aload 4
    //   100: ifnull +35 -> 135
    //   103: aload_3
    //   104: astore_2
    //   105: aload 6
    //   107: aload 4
    //   109: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload_3
    //   114: astore_2
    //   115: aload 6
    //   117: getstatic 313	java/io/File:separator	Ljava/lang/String;
    //   120: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload_3
    //   125: astore_2
    //   126: aload_3
    //   127: invokevirtual 310	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   130: astore 4
    //   132: goto -34 -> 98
    //   135: aload_3
    //   136: astore_2
    //   137: new 34	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   144: astore 4
    //   146: aload_3
    //   147: astore_2
    //   148: aload 4
    //   150: aload_0
    //   151: invokespecial 315	com/tencent/TMG/utils/CrashHandler:dumpPhoneInfo	()Ljava/lang/String;
    //   154: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload_3
    //   159: astore_2
    //   160: aload 4
    //   162: aload 6
    //   164: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload_3
    //   172: astore_2
    //   173: aload_0
    //   174: aload 4
    //   176: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: ldc 10
    //   181: invokevirtual 317	com/tencent/TMG/utils/CrashHandler:encrypt	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   184: astore 4
    //   186: aload_3
    //   187: astore_2
    //   188: getstatic 54	com/tencent/TMG/utils/CrashHandler:TAG	Ljava/lang/String;
    //   191: astore 6
    //   193: aload_3
    //   194: astore_2
    //   195: new 34	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   202: astore 7
    //   204: aload_3
    //   205: astore_2
    //   206: aload 7
    //   208: ldc_w 319
    //   211: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload_3
    //   216: astore_2
    //   217: aload 7
    //   219: aload 4
    //   221: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload_3
    //   226: astore_2
    //   227: aload 7
    //   229: ldc_w 321
    //   232: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload_3
    //   237: astore_2
    //   238: aload 7
    //   240: aload 4
    //   242: invokevirtual 271	java/lang/String:length	()I
    //   245: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload_3
    //   250: astore_2
    //   251: aload 6
    //   253: aload 7
    //   255: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 89	com/tencent/TMG/utils/NetUtil:debugInfo	(Ljava/lang/String;Ljava/lang/String;)V
    //   261: aload_3
    //   262: astore_2
    //   263: aload 4
    //   265: invokevirtual 268	java/lang/String:getBytes	()[B
    //   268: astore 6
    //   270: iconst_0
    //   271: istore_1
    //   272: iload_1
    //   273: bipush 10
    //   275: if_icmpge +22 -> 297
    //   278: aload_3
    //   279: astore_2
    //   280: getstatic 275	java/lang/System:out	Ljava/io/PrintStream;
    //   283: aload 6
    //   285: iload_1
    //   286: baload
    //   287: invokevirtual 279	java/io/PrintStream:println	(I)V
    //   290: iload_1
    //   291: iconst_1
    //   292: iadd
    //   293: istore_1
    //   294: goto -22 -> 272
    //   297: aload_3
    //   298: astore_2
    //   299: ldc 20
    //   301: aload 4
    //   303: invokestatic 324	com/tencent/TMG/utils/NetUtil:post	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   306: astore 4
    //   308: aload_3
    //   309: astore_2
    //   310: getstatic 54	com/tencent/TMG/utils/CrashHandler:TAG	Ljava/lang/String;
    //   313: astore 6
    //   315: aload_3
    //   316: astore_2
    //   317: new 34	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   324: astore 7
    //   326: aload_3
    //   327: astore_2
    //   328: aload 7
    //   330: ldc_w 326
    //   333: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: pop
    //   337: aload_3
    //   338: astore_2
    //   339: aload 7
    //   341: aload 4
    //   343: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload_3
    //   348: astore_2
    //   349: aload 6
    //   351: aload 7
    //   353: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: invokestatic 89	com/tencent/TMG/utils/NetUtil:debugInfo	(Ljava/lang/String;Ljava/lang/String;)V
    //   359: aload_3
    //   360: astore_2
    //   361: aload 5
    //   363: invokevirtual 329	java/io/File:delete	()Z
    //   366: pop
    //   367: goto +17 -> 384
    //   370: astore 4
    //   372: goto +31 -> 403
    //   375: getstatic 54	com/tencent/TMG/utils/CrashHandler:TAG	Ljava/lang/String;
    //   378: ldc_w 331
    //   381: invokestatic 89	com/tencent/TMG/utils/NetUtil:debugInfo	(Ljava/lang/String;Ljava/lang/String;)V
    //   384: aload_3
    //   385: ifnull +39 -> 424
    //   388: aload_3
    //   389: invokevirtual 332	java/io/BufferedReader:close	()V
    //   392: return
    //   393: astore_2
    //   394: aconst_null
    //   395: astore_3
    //   396: goto +36 -> 432
    //   399: astore 4
    //   401: aconst_null
    //   402: astore_3
    //   403: aload_3
    //   404: astore_2
    //   405: aload 4
    //   407: invokevirtual 260	java/lang/Exception:printStackTrace	()V
    //   410: aload_3
    //   411: ifnull +13 -> 424
    //   414: aload_3
    //   415: invokevirtual 332	java/io/BufferedReader:close	()V
    //   418: return
    //   419: astore_2
    //   420: aload_2
    //   421: invokevirtual 333	java/io/IOException:printStackTrace	()V
    //   424: return
    //   425: astore 4
    //   427: aload_2
    //   428: astore_3
    //   429: aload 4
    //   431: astore_2
    //   432: aload_3
    //   433: ifnull +15 -> 448
    //   436: aload_3
    //   437: invokevirtual 332	java/io/BufferedReader:close	()V
    //   440: goto +8 -> 448
    //   443: astore_3
    //   444: aload_3
    //   445: invokevirtual 333	java/io/IOException:printStackTrace	()V
    //   448: goto +5 -> 453
    //   451: aload_2
    //   452: athrow
    //   453: goto -2 -> 451
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	456	0	this	CrashHandler
    //   271	23	1	i	int
    //   18	343	2	localObject1	Object
    //   393	1	2	localObject2	Object
    //   404	1	2	localObject3	Object
    //   419	9	2	localIOException1	java.io.IOException
    //   431	21	2	localObject4	Object
    //   10	427	3	localObject5	Object
    //   443	2	3	localIOException2	java.io.IOException
    //   96	246	4	localObject6	Object
    //   370	1	4	localException1	Exception
    //   399	7	4	localException2	Exception
    //   425	5	4	localObject7	Object
    //   52	310	5	localFile	File
    //   88	262	6	localObject8	Object
    //   202	150	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   81	90	370	java/lang/Exception
    //   92	98	370	java/lang/Exception
    //   105	113	370	java/lang/Exception
    //   115	124	370	java/lang/Exception
    //   126	132	370	java/lang/Exception
    //   137	146	370	java/lang/Exception
    //   148	158	370	java/lang/Exception
    //   160	171	370	java/lang/Exception
    //   173	186	370	java/lang/Exception
    //   188	193	370	java/lang/Exception
    //   195	204	370	java/lang/Exception
    //   206	215	370	java/lang/Exception
    //   217	225	370	java/lang/Exception
    //   227	236	370	java/lang/Exception
    //   238	249	370	java/lang/Exception
    //   251	261	370	java/lang/Exception
    //   263	270	370	java/lang/Exception
    //   280	290	370	java/lang/Exception
    //   299	308	370	java/lang/Exception
    //   310	315	370	java/lang/Exception
    //   317	326	370	java/lang/Exception
    //   328	337	370	java/lang/Exception
    //   339	347	370	java/lang/Exception
    //   349	359	370	java/lang/Exception
    //   361	367	370	java/lang/Exception
    //   11	79	393	finally
    //   375	384	393	finally
    //   11	79	399	java/lang/Exception
    //   375	384	399	java/lang/Exception
    //   388	392	419	java/io/IOException
    //   414	418	419	java/io/IOException
    //   81	90	425	finally
    //   92	98	425	finally
    //   105	113	425	finally
    //   115	124	425	finally
    //   126	132	425	finally
    //   137	146	425	finally
    //   148	158	425	finally
    //   160	171	425	finally
    //   173	186	425	finally
    //   188	193	425	finally
    //   195	204	425	finally
    //   206	215	425	finally
    //   217	225	425	finally
    //   227	236	425	finally
    //   238	249	425	finally
    //   251	261	425	finally
    //   263	270	425	finally
    //   280	290	425	finally
    //   299	308	425	finally
    //   310	315	425	finally
    //   317	326	425	finally
    //   328	337	425	finally
    //   339	347	425	finally
    //   349	359	425	finally
    //   361	367	425	finally
    //   405	410	425	finally
    //   436	440	443	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.utils.CrashHandler
 * JD-Core Version:    0.7.0.1
 */