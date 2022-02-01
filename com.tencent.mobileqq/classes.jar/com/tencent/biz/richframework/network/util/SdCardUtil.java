package com.tencent.biz.richframework.network.util;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SdCardUtil
{
  private static String[] SPECIAL_MODEL = { "MI 2", "MI 3", "X9007" };
  private static final String TAG = "SdCardUtil";
  
  public static long getAvailableExternalMemorySize(Context paramContext)
  {
    paramContext = getExternalStorages(paramContext).iterator();
    long l1 = 0L;
    while (paramContext.hasNext())
    {
      Object localObject = (String)paramContext.next();
      try
      {
        localObject = new StatFs((String)localObject);
        long l2 = ((StatFs)localObject).getBlockSize();
        int i = ((StatFs)localObject).getAvailableBlocks();
        l1 += i * l2;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
      }
    }
    return l1;
  }
  
  public static long getAvailableInternalMemorySize()
  {
    long l1 = 0L;
    try
    {
      StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      long l2 = localStatFs.getBlockSize();
      int i = localStatFs.getAvailableBlocks();
      l2 = i * l2;
      try
      {
        long l3 = ((Long)Class.forName("android.os.SystemProperties").getMethod("getLong", new Class[] { String.class, Long.TYPE }).invoke(null, new Object[] { "sys.memory.threshold.low", Long.valueOf(0L) })).longValue();
        l1 = l3;
      }
      catch (IllegalArgumentException localIllegalArgumentException1)
      {
        l1 = l2;
        break label122;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      l1 = Math.min(l2, l1);
      return l2 - l1;
    }
    catch (IllegalArgumentException localIllegalArgumentException2)
    {
      l1 = 0L;
      label122:
      localIllegalArgumentException2.printStackTrace();
    }
    return l1;
  }
  
  private static List<String> getExternalStorages(Context paramContext)
  {
    int i = 1;
    paramContext = getStoragePathList(paramContext, true);
    if ((isExternalStorageEmulated()) && (!isSpecialModel()))
    {
      Iterator localIterator = paramContext.iterator();
      while (localIterator.hasNext()) {
        if (((String)localIterator.next()).toLowerCase().contains("emulated"))
        {
          localIterator.remove();
          break label67;
        }
      }
      i = 0;
      label67:
      if (i == 0) {
        paramContext.remove(Environment.getExternalStorageDirectory().getAbsolutePath());
      }
    }
    return paramContext;
  }
  
  public static String getSdCardDirectory()
  {
    if (sdCardExists()) {
      return Environment.getExternalStorageDirectory().getAbsolutePath();
    }
    return null;
  }
  
  /* Error */
  public static ArrayList<String> getStorageDirectories()
  {
    // Byte code:
    //   0: new 166	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 167	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: invokestatic 170	com/tencent/biz/richframework/network/util/SdCardUtil:hasStorageCard	()Z
    //   11: ifeq +20 -> 31
    //   14: invokestatic 148	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   17: invokevirtual 151	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   20: astore_0
    //   21: aload_0
    //   22: ifnull +9 -> 31
    //   25: aload_3
    //   26: aload_0
    //   27: invokevirtual 173	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   30: pop
    //   31: new 175	java/io/BufferedReader
    //   34: dup
    //   35: new 177	java/io/FileReader
    //   38: dup
    //   39: ldc 179
    //   41: invokespecial 180	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   44: invokespecial 183	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   47: astore_1
    //   48: aload_1
    //   49: astore_0
    //   50: aload_1
    //   51: invokevirtual 186	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   54: astore_2
    //   55: aload_2
    //   56: ifnull +195 -> 251
    //   59: aload_1
    //   60: astore_0
    //   61: aload_2
    //   62: ldc 188
    //   64: invokevirtual 142	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   67: ifne +36 -> 103
    //   70: aload_1
    //   71: astore_0
    //   72: aload_2
    //   73: ldc 190
    //   75: invokevirtual 142	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   78: ifne +25 -> 103
    //   81: aload_1
    //   82: astore_0
    //   83: aload_2
    //   84: ldc 192
    //   86: invokevirtual 142	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   89: ifne +14 -> 103
    //   92: aload_1
    //   93: astore_0
    //   94: aload_2
    //   95: ldc 194
    //   97: invokevirtual 142	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   100: ifeq -52 -> 48
    //   103: aload_1
    //   104: astore_0
    //   105: aload_2
    //   106: ldc 196
    //   108: invokevirtual 200	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   111: astore 4
    //   113: aload_1
    //   114: astore_0
    //   115: aload 4
    //   117: iconst_1
    //   118: aaload
    //   119: invokestatic 148	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   122: invokevirtual 81	java/io/File:getPath	()Ljava/lang/String;
    //   125: invokevirtual 203	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   128: ifeq +30 -> 158
    //   131: aload_1
    //   132: astore_0
    //   133: aload_3
    //   134: aload 4
    //   136: iconst_1
    //   137: aaload
    //   138: invokestatic 207	com/tencent/biz/richframework/network/util/SdCardUtil:includedInList	(Ljava/util/ArrayList;Ljava/lang/String;)Z
    //   141: ifne -93 -> 48
    //   144: aload_1
    //   145: astore_0
    //   146: aload_3
    //   147: aload 4
    //   149: iconst_1
    //   150: aaload
    //   151: invokevirtual 173	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   154: pop
    //   155: goto -107 -> 48
    //   158: aload_1
    //   159: astore_0
    //   160: aload_2
    //   161: ldc 209
    //   163: invokevirtual 142	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   166: ifeq -118 -> 48
    //   169: aload_1
    //   170: astore_0
    //   171: aload_2
    //   172: ldc 211
    //   174: invokevirtual 142	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   177: ifne -129 -> 48
    //   180: aload_1
    //   181: astore_0
    //   182: aload_2
    //   183: ldc 213
    //   185: invokevirtual 142	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   188: ifne -140 -> 48
    //   191: aload_1
    //   192: astore_0
    //   193: aload_2
    //   194: ldc 215
    //   196: invokevirtual 142	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   199: ifne -151 -> 48
    //   202: aload_1
    //   203: astore_0
    //   204: aload_2
    //   205: ldc 217
    //   207: invokevirtual 142	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   210: ifne -162 -> 48
    //   213: aload_1
    //   214: astore_0
    //   215: aload_2
    //   216: ldc 219
    //   218: invokevirtual 142	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   221: ifne -173 -> 48
    //   224: aload_1
    //   225: astore_0
    //   226: aload_3
    //   227: aload 4
    //   229: iconst_1
    //   230: aaload
    //   231: invokestatic 207	com/tencent/biz/richframework/network/util/SdCardUtil:includedInList	(Ljava/util/ArrayList;Ljava/lang/String;)Z
    //   234: ifne -186 -> 48
    //   237: aload_1
    //   238: astore_0
    //   239: aload_3
    //   240: aload 4
    //   242: iconst_1
    //   243: aaload
    //   244: invokevirtual 173	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   247: pop
    //   248: goto -200 -> 48
    //   251: aload_1
    //   252: astore_0
    //   253: aload_3
    //   254: invokestatic 223	com/tencent/biz/richframework/network/util/SdCardUtil:trimLastSlash	(Ljava/util/ArrayList;)V
    //   257: aload_1
    //   258: invokevirtual 226	java/io/BufferedReader:close	()V
    //   261: aload_3
    //   262: areturn
    //   263: astore_0
    //   264: aload_0
    //   265: invokevirtual 227	java/io/IOException:printStackTrace	()V
    //   268: aload_3
    //   269: areturn
    //   270: astore_2
    //   271: goto +12 -> 283
    //   274: astore_0
    //   275: aconst_null
    //   276: astore_1
    //   277: goto +34 -> 311
    //   280: astore_2
    //   281: aconst_null
    //   282: astore_1
    //   283: aload_1
    //   284: astore_0
    //   285: aload_2
    //   286: invokevirtual 117	java/lang/Exception:printStackTrace	()V
    //   289: aload_1
    //   290: ifnull +14 -> 304
    //   293: aload_1
    //   294: invokevirtual 226	java/io/BufferedReader:close	()V
    //   297: aload_3
    //   298: areturn
    //   299: astore_0
    //   300: aload_0
    //   301: invokevirtual 227	java/io/IOException:printStackTrace	()V
    //   304: aload_3
    //   305: areturn
    //   306: astore_2
    //   307: aload_0
    //   308: astore_1
    //   309: aload_2
    //   310: astore_0
    //   311: aload_1
    //   312: ifnull +15 -> 327
    //   315: aload_1
    //   316: invokevirtual 226	java/io/BufferedReader:close	()V
    //   319: goto +8 -> 327
    //   322: astore_1
    //   323: aload_1
    //   324: invokevirtual 227	java/io/IOException:printStackTrace	()V
    //   327: goto +5 -> 332
    //   330: aload_0
    //   331: athrow
    //   332: goto -2 -> 330
    // Local variable table:
    //   start	length	slot	name	signature
    //   20	233	0	localObject1	Object
    //   263	2	0	localIOException1	IOException
    //   274	1	0	localObject2	Object
    //   284	1	0	localObject3	Object
    //   299	9	0	localIOException2	IOException
    //   310	21	0	localObject4	Object
    //   47	269	1	localObject5	Object
    //   322	2	1	localIOException3	IOException
    //   54	162	2	str	String
    //   270	1	2	localException1	Exception
    //   280	6	2	localException2	Exception
    //   306	4	2	localObject6	Object
    //   7	298	3	localArrayList	ArrayList
    //   111	130	4	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   257	261	263	java/io/IOException
    //   50	55	270	java/lang/Exception
    //   61	70	270	java/lang/Exception
    //   72	81	270	java/lang/Exception
    //   83	92	270	java/lang/Exception
    //   94	103	270	java/lang/Exception
    //   105	113	270	java/lang/Exception
    //   115	131	270	java/lang/Exception
    //   133	144	270	java/lang/Exception
    //   146	155	270	java/lang/Exception
    //   160	169	270	java/lang/Exception
    //   171	180	270	java/lang/Exception
    //   182	191	270	java/lang/Exception
    //   193	202	270	java/lang/Exception
    //   204	213	270	java/lang/Exception
    //   215	224	270	java/lang/Exception
    //   226	237	270	java/lang/Exception
    //   239	248	270	java/lang/Exception
    //   253	257	270	java/lang/Exception
    //   8	21	274	finally
    //   25	31	274	finally
    //   31	48	274	finally
    //   8	21	280	java/lang/Exception
    //   25	31	280	java/lang/Exception
    //   31	48	280	java/lang/Exception
    //   293	297	299	java/io/IOException
    //   50	55	306	finally
    //   61	70	306	finally
    //   72	81	306	finally
    //   83	92	306	finally
    //   94	103	306	finally
    //   105	113	306	finally
    //   115	131	306	finally
    //   133	144	306	finally
    //   146	155	306	finally
    //   160	169	306	finally
    //   171	180	306	finally
    //   182	191	306	finally
    //   193	202	306	finally
    //   204	213	306	finally
    //   215	224	306	finally
    //   226	237	306	finally
    //   239	248	306	finally
    //   253	257	306	finally
    //   285	289	306	finally
    //   315	319	322	java/io/IOException
  }
  
  public static List<String> getStoragePathList(Context paramContext, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 9) {
      return getStorageDirectories();
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramContext = (StorageManager)paramContext.getSystemService("storage");
      Object[] arrayOfObject = (Object[])paramContext.getClass().getMethod("getVolumeList", new Class[0]).invoke(paramContext, new Object[0]);
      if ((arrayOfObject != null) && (arrayOfObject.length > 0))
      {
        Method localMethod1 = arrayOfObject[0].getClass().getDeclaredMethod("getPath", new Class[0]);
        Method localMethod2 = paramContext.getClass().getMethod("getVolumeState", new Class[] { String.class });
        int j = arrayOfObject.length;
        int i = 0;
        while (i < j)
        {
          String str1 = (String)localMethod1.invoke(arrayOfObject[i], new Object[0]);
          if (str1 != null)
          {
            String str2 = (String)localMethod2.invoke(paramContext, new Object[] { str1 });
            if ((paramBoolean) && ("mounted".equals(str2))) {
              localArrayList.add(str1);
            } else if ((!paramBoolean) && (!"mounted".equals(str2)) && (str1.contains("sd"))) {
              localArrayList.add(str1);
            }
          }
          i += 1;
        }
      }
      return localArrayList;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return getStorageDirectories();
  }
  
  public static long getTotalExternalMemorySize(Context paramContext)
  {
    paramContext = getExternalStorages(paramContext).iterator();
    long l1 = 0L;
    while (paramContext.hasNext())
    {
      Object localObject = (String)paramContext.next();
      try
      {
        localObject = new StatFs((String)localObject);
        long l2 = ((StatFs)localObject).getBlockSize();
        int i = ((StatFs)localObject).getBlockCount();
        l1 += i * l2;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
      }
    }
    return l1;
  }
  
  public static long getTotalInternalMemorySize()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      long l = localStatFs.getBlockSize();
      int i = localStatFs.getBlockCount();
      return i * l;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localIllegalArgumentException.printStackTrace();
    }
    return 0L;
  }
  
  public static boolean hasStorageCard()
  {
    try
    {
      boolean bool = Environment.getExternalStorageState().equals("mounted");
      return bool;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
  
  static boolean includedInList(ArrayList<String> paramArrayList, String paramString)
  {
    paramArrayList = paramArrayList.iterator();
    boolean bool1;
    do
    {
      boolean bool3 = paramArrayList.hasNext();
      bool1 = false;
      boolean bool2 = false;
      if (!bool3) {
        break;
      }
      String str1 = (String)paramArrayList.next();
      if (paramString.equals(str1)) {
        return true;
      }
      try
      {
        str1 = new File(str1).getCanonicalPath();
        String str2 = new File(paramString).getCanonicalPath();
        bool1 = bool2;
        if (str1 != null)
        {
          bool1 = bool2;
          if (str2 != null) {
            bool1 = str1.equals(str2);
          }
        }
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        bool1 = bool2;
      }
    } while (!bool1);
    return bool1;
  }
  
  public static boolean isExternalStorageEmulated()
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
  
  private static boolean isSpecialModel()
  {
    String str = Build.MODEL;
    int i = 0;
    for (;;)
    {
      String[] arrayOfString = SPECIAL_MODEL;
      if (i >= arrayOfString.length) {
        break;
      }
      if ((str != null) && (str.contains(arrayOfString[i]))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean sdCardExists()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  static void trimLastSlash(ArrayList<String> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() <= 0) {
        return;
      }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.network.util.SdCardUtil
 * JD-Core Version:    0.7.0.1
 */