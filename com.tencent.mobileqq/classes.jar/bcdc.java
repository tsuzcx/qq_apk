import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.CrashUtils.1;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class bcdc
{
  static List<File> a(Context paramContext)
  {
    int i = 0;
    Object localObject1 = new File(paramContext.getDir("tombs", 0).getAbsolutePath());
    paramContext = new ArrayList();
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      int j = localObject1.length;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        long l = localObject2.length();
        if ((l > 0L) && (l < 16000L)) {
          paramContext.add(localObject2);
        }
        i += 1;
      }
    }
    return paramContext;
  }
  
  public static void a()
  {
    Object localObject = BaseApplicationImpl.context;
    SharedPreferences localSharedPreferences = ((BaseApplication)localObject).getSharedPreferences("StatisticCollector", 4);
    if (localSharedPreferences.getBoolean("KEY_IS_NATIVE_CRASH_HAPPENED", false))
    {
      localObject = new CrashUtils.1((BaseApplication)localObject);
      ThreadManager.getSubThreadHandler().postDelayed((Runnable)localObject, 10000L);
    }
    localSharedPreferences.edit().putBoolean("KEY_IS_NATIVE_CRASH_HAPPENED", false).commit();
  }
  
  public static void a(Context paramContext)
  {
    paramContext = a(paramContext).iterator();
    while (paramContext.hasNext()) {
      a((File)paramContext.next());
    }
  }
  
  /* Error */
  static void a(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 20	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   4: astore_1
    //   5: new 131	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   12: astore_3
    //   13: aload_3
    //   14: new 131	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   21: aload_1
    //   22: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc 138
    //   27: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: new 143	java/io/BufferedReader
    //   40: dup
    //   41: new 145	java/io/FileReader
    //   44: dup
    //   45: aload_0
    //   46: invokespecial 147	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   49: invokespecial 150	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   52: astore_1
    //   53: aload_1
    //   54: astore_0
    //   55: aload_1
    //   56: invokevirtual 153	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   59: astore_2
    //   60: aload_2
    //   61: ifnull +63 -> 124
    //   64: aload_1
    //   65: astore_0
    //   66: aload_3
    //   67: aload_2
    //   68: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload_1
    //   73: astore_0
    //   74: aload_3
    //   75: ldc 138
    //   77: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: goto -28 -> 53
    //   84: astore_2
    //   85: aload_1
    //   86: astore_0
    //   87: aload_2
    //   88: invokevirtual 156	java/io/FileNotFoundException:printStackTrace	()V
    //   91: aload_1
    //   92: invokestatic 161	bdvb:a	(Ljava/io/Closeable;)V
    //   95: ldc 163
    //   97: iconst_1
    //   98: new 131	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   105: ldc 165
    //   107: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_3
    //   111: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 171	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: return
    //   124: aload_1
    //   125: invokestatic 161	bdvb:a	(Ljava/io/Closeable;)V
    //   128: goto -33 -> 95
    //   131: astore_2
    //   132: aconst_null
    //   133: astore_1
    //   134: aload_1
    //   135: astore_0
    //   136: aload_2
    //   137: invokevirtual 172	java/lang/Exception:printStackTrace	()V
    //   140: aload_1
    //   141: invokestatic 161	bdvb:a	(Ljava/io/Closeable;)V
    //   144: goto -49 -> 95
    //   147: astore_1
    //   148: aconst_null
    //   149: astore_0
    //   150: aload_0
    //   151: invokestatic 161	bdvb:a	(Ljava/io/Closeable;)V
    //   154: aload_1
    //   155: athrow
    //   156: astore_1
    //   157: goto -7 -> 150
    //   160: astore_2
    //   161: goto -27 -> 134
    //   164: astore_2
    //   165: aconst_null
    //   166: astore_1
    //   167: goto -82 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	paramFile	File
    //   4	137	1	localObject1	Object
    //   147	8	1	localObject2	Object
    //   156	1	1	localObject3	Object
    //   166	1	1	localObject4	Object
    //   59	9	2	str	java.lang.String
    //   84	4	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   131	6	2	localException1	java.lang.Exception
    //   160	1	2	localException2	java.lang.Exception
    //   164	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   12	99	3	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   55	60	84	java/io/FileNotFoundException
    //   66	72	84	java/io/FileNotFoundException
    //   74	81	84	java/io/FileNotFoundException
    //   37	53	131	java/lang/Exception
    //   37	53	147	finally
    //   55	60	156	finally
    //   66	72	156	finally
    //   74	81	156	finally
    //   87	91	156	finally
    //   136	140	156	finally
    //   55	60	160	java/lang/Exception
    //   66	72	160	java/lang/Exception
    //   74	81	160	java/lang/Exception
    //   37	53	164	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcdc
 * JD-Core Version:    0.7.0.1
 */