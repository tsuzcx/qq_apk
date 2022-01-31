import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bbiz
{
  private static String[] a = { "MI 2", "MI 3", "X9007" };
  
  public static long a()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      long l = localStatFs.getBlockSize();
      int i = localStatFs.getBlockCount();
      return i * l;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
    return 0L;
  }
  
  public static long a(Context paramContext)
  {
    paramContext = a(paramContext).iterator();
    long l1 = 0L;
    while (paramContext.hasNext())
    {
      Object localObject = (String)paramContext.next();
      try
      {
        localObject = new StatFs((String)localObject);
        long l2 = ((StatFs)localObject).getBlockSize();
        int i = ((StatFs)localObject).getBlockCount();
        l1 = i * l2 + l1;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
      }
    }
    return l1;
  }
  
  public static String a()
  {
    if (c()) {
      return Environment.getExternalStorageDirectory().getAbsolutePath();
    }
    return null;
  }
  
  /* Error */
  public static ArrayList<String> a()
  {
    // Byte code:
    //   0: new 86	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 88	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: aconst_null
    //   9: astore_0
    //   10: invokestatic 91	bbiz:b	()Z
    //   13: ifeq +20 -> 33
    //   16: invokestatic 76	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   19: invokevirtual 79	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   22: astore_1
    //   23: aload_1
    //   24: ifnull +9 -> 33
    //   27: aload_3
    //   28: aload_1
    //   29: invokevirtual 95	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   32: pop
    //   33: new 97	java/io/BufferedReader
    //   36: dup
    //   37: new 99	java/io/FileReader
    //   40: dup
    //   41: ldc 101
    //   43: invokespecial 102	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   46: invokespecial 105	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   49: astore_1
    //   50: aload_1
    //   51: invokevirtual 108	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   54: astore_0
    //   55: aload_0
    //   56: ifnull +187 -> 243
    //   59: aload_0
    //   60: ldc 110
    //   62: invokevirtual 114	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   65: ifne +30 -> 95
    //   68: aload_0
    //   69: ldc 116
    //   71: invokevirtual 114	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   74: ifne +21 -> 95
    //   77: aload_0
    //   78: ldc 118
    //   80: invokevirtual 114	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   83: ifne +12 -> 95
    //   86: aload_0
    //   87: ldc 120
    //   89: invokevirtual 114	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   92: ifeq -42 -> 50
    //   95: aload_0
    //   96: ldc 122
    //   98: invokevirtual 126	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   101: astore_2
    //   102: aload_2
    //   103: iconst_1
    //   104: aaload
    //   105: invokestatic 76	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   108: invokevirtual 36	java/io/File:getPath	()Ljava/lang/String;
    //   111: invokevirtual 129	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   114: ifeq +43 -> 157
    //   117: aload_3
    //   118: aload_2
    //   119: iconst_1
    //   120: aaload
    //   121: invokestatic 132	bbiz:a	(Ljava/util/ArrayList;Ljava/lang/String;)Z
    //   124: ifne -74 -> 50
    //   127: aload_3
    //   128: aload_2
    //   129: iconst_1
    //   130: aaload
    //   131: invokevirtual 95	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   134: pop
    //   135: goto -85 -> 50
    //   138: astore_2
    //   139: aload_1
    //   140: astore_0
    //   141: aload_2
    //   142: astore_1
    //   143: aload_1
    //   144: invokevirtual 133	java/lang/Exception:printStackTrace	()V
    //   147: aload_0
    //   148: ifnull +7 -> 155
    //   151: aload_0
    //   152: invokevirtual 136	java/io/BufferedReader:close	()V
    //   155: aload_3
    //   156: areturn
    //   157: aload_0
    //   158: ldc 138
    //   160: invokevirtual 114	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   163: ifeq -113 -> 50
    //   166: aload_0
    //   167: ldc 140
    //   169: invokevirtual 114	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   172: ifne -122 -> 50
    //   175: aload_0
    //   176: ldc 142
    //   178: invokevirtual 114	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   181: ifne -131 -> 50
    //   184: aload_0
    //   185: ldc 144
    //   187: invokevirtual 114	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   190: ifne -140 -> 50
    //   193: aload_0
    //   194: ldc 146
    //   196: invokevirtual 114	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   199: ifne -149 -> 50
    //   202: aload_0
    //   203: ldc 148
    //   205: invokevirtual 114	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   208: ifne -158 -> 50
    //   211: aload_3
    //   212: aload_2
    //   213: iconst_1
    //   214: aaload
    //   215: invokestatic 132	bbiz:a	(Ljava/util/ArrayList;Ljava/lang/String;)Z
    //   218: ifne -168 -> 50
    //   221: aload_3
    //   222: aload_2
    //   223: iconst_1
    //   224: aaload
    //   225: invokevirtual 95	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   228: pop
    //   229: goto -179 -> 50
    //   232: astore_0
    //   233: aload_1
    //   234: ifnull +7 -> 241
    //   237: aload_1
    //   238: invokevirtual 136	java/io/BufferedReader:close	()V
    //   241: aload_0
    //   242: athrow
    //   243: aload_3
    //   244: invokestatic 151	bbiz:a	(Ljava/util/ArrayList;)V
    //   247: aload_1
    //   248: ifnull -93 -> 155
    //   251: aload_1
    //   252: invokevirtual 136	java/io/BufferedReader:close	()V
    //   255: aload_3
    //   256: areturn
    //   257: astore_0
    //   258: aload_0
    //   259: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   262: aload_3
    //   263: areturn
    //   264: astore_0
    //   265: aload_0
    //   266: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   269: aload_3
    //   270: areturn
    //   271: astore_1
    //   272: aload_1
    //   273: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   276: goto -35 -> 241
    //   279: astore_0
    //   280: aconst_null
    //   281: astore_1
    //   282: goto -49 -> 233
    //   285: astore_2
    //   286: aload_0
    //   287: astore_1
    //   288: aload_2
    //   289: astore_0
    //   290: goto -57 -> 233
    //   293: astore_1
    //   294: goto -151 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   9	194	0	localObject1	Object
    //   232	10	0	localObject2	Object
    //   257	2	0	localIOException1	IOException
    //   264	2	0	localIOException2	IOException
    //   279	8	0	localObject3	Object
    //   289	1	0	localObject4	Object
    //   22	230	1	localObject5	Object
    //   271	2	1	localIOException3	IOException
    //   281	7	1	localObject6	Object
    //   293	1	1	localException1	Exception
    //   101	28	2	arrayOfString	String[]
    //   138	85	2	localException2	Exception
    //   285	4	2	localObject7	Object
    //   7	263	3	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   50	55	138	java/lang/Exception
    //   59	95	138	java/lang/Exception
    //   95	135	138	java/lang/Exception
    //   157	229	138	java/lang/Exception
    //   243	247	138	java/lang/Exception
    //   50	55	232	finally
    //   59	95	232	finally
    //   95	135	232	finally
    //   157	229	232	finally
    //   243	247	232	finally
    //   251	255	257	java/io/IOException
    //   151	155	264	java/io/IOException
    //   237	241	271	java/io/IOException
    //   10	23	279	finally
    //   27	33	279	finally
    //   33	50	279	finally
    //   143	147	285	finally
    //   10	23	293	java/lang/Exception
    //   27	33	293	java/lang/Exception
    //   33	50	293	java/lang/Exception
  }
  
  private static List<String> a(Context paramContext)
  {
    paramContext = a(paramContext, true);
    if ((a()) && (!d()))
    {
      Iterator localIterator = paramContext.iterator();
      while (localIterator.hasNext()) {
        if (((String)localIterator.next()).toLowerCase().contains("emulated")) {
          localIterator.remove();
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        paramContext.remove(Environment.getExternalStorageDirectory().getAbsolutePath());
      }
      return paramContext;
    }
  }
  
  public static List<String> a(Context paramContext, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 9) {
      return a();
    }
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int i;
      try
      {
        paramContext = (StorageManager)paramContext.getSystemService("storage");
        Object[] arrayOfObject = (Object[])paramContext.getClass().getMethod("getVolumeList", new Class[0]).invoke(paramContext, new Object[0]);
        if ((arrayOfObject != null) && (arrayOfObject.length > 0))
        {
          Method localMethod1 = arrayOfObject[0].getClass().getDeclaredMethod("getPath", new Class[0]);
          Method localMethod2 = paramContext.getClass().getMethod("getVolumeState", new Class[] { String.class });
          int j = arrayOfObject.length;
          i = 0;
          if (i < j)
          {
            String str1 = (String)localMethod1.invoke(arrayOfObject[i], new Object[0]);
            if (str1 == null) {
              break label239;
            }
            String str2 = (String)localMethod2.invoke(paramContext, new Object[] { str1 });
            if ((paramBoolean) && ("mounted".equals(str2))) {
              localArrayList.add(str1);
            } else if ((!paramBoolean) && (!"mounted".equals(str2)) && (str1.contains("sd"))) {
              localArrayList.add(str1);
            }
          }
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        return a();
      }
      return localArrayList;
      label239:
      i += 1;
    }
  }
  
  static void a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramArrayList.size())
      {
        while (((String)paramArrayList.get(i)).endsWith("/")) {
          paramArrayList.set(i, ((String)paramArrayList.get(i)).substring(0, ((String)paramArrayList.get(i)).length() - 1));
        }
        i += 1;
      }
    }
  }
  
  public static boolean a()
  {
    if (Build.VERSION.SDK_INT >= 14) {
      try
      {
        boolean bool = ((Boolean)Environment.class.getMethod("isExternalStorageEmulated", new Class[0]).invoke(null, new Object[0])).booleanValue();
        return bool;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return false;
  }
  
  static boolean a(ArrayList<String> paramArrayList, String paramString)
  {
    boolean bool2 = false;
    paramArrayList = paramArrayList.iterator();
    do
    {
      boolean bool1 = bool2;
      String str1;
      if (paramArrayList.hasNext())
      {
        str1 = (String)paramArrayList.next();
        if (paramString.equals(str1)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      try
      {
        str1 = new File(str1).getCanonicalPath();
        String str2 = new File(paramString).getCanonicalPath();
        if ((str1 == null) || (str2 == null)) {
          break;
        }
        bool1 = str1.equals(str2);
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
          bool1 = false;
        }
      }
    } while (!bool1);
    return bool1;
  }
  
  public static long b()
  {
    l1 = 0L;
    try
    {
      StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      l2 = localStatFs.getBlockSize();
      int i = localStatFs.getAvailableBlocks();
      l2 *= i;
    }
    catch (IllegalArgumentException localIllegalArgumentException1)
    {
      long l3;
      label121:
      l1 = 0L;
      localIllegalArgumentException1.printStackTrace();
      return l1;
    }
    try
    {
      QLog.d("SdCardUtil", 1, "SpaceInfo ava: " + l2);
    }
    catch (IllegalArgumentException localIllegalArgumentException2)
    {
      l1 = l2;
      break label135;
    }
    try
    {
      l3 = ((Long)Class.forName("android.os.SystemProperties").getMethod("getLong", new Class[] { String.class, Long.TYPE }).invoke(null, new Object[] { "sys.memory.threshold.low", Long.valueOf(0L) })).longValue();
      l1 = l3;
    }
    catch (Exception localException)
    {
      break label121;
    }
    l1 = Math.min(l2, l1);
    return l2 - l1;
  }
  
  public static long b(Context paramContext)
  {
    paramContext = a(paramContext).iterator();
    long l1 = 0L;
    while (paramContext.hasNext())
    {
      Object localObject = (String)paramContext.next();
      try
      {
        localObject = new StatFs((String)localObject);
        long l2 = ((StatFs)localObject).getBlockSize();
        int i = ((StatFs)localObject).getAvailableBlocks();
        l1 = i * l2 + l1;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
      }
    }
    return l1;
  }
  
  public static boolean b()
  {
    try
    {
      boolean bool = Environment.getExternalStorageState().equals("mounted");
      return bool;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public static boolean c()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  private static boolean d()
  {
    boolean bool2 = false;
    String str = Build.MODEL;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < a.length)
      {
        if ((str != null) && (str.contains(a[i]))) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbiz
 * JD-Core Version:    0.7.0.1
 */