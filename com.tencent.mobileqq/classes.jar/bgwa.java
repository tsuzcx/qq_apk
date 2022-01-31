import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.manager.EngineVersion;
import com.tencent.qqmini.sdk.manager.InstalledEngine;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import com.tencent.qqmini.sdk.utils.StorageUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

public class bgwa
{
  private static File jdField_a_of_type_JavaIoFile;
  private static String jdField_a_of_type_JavaLangString = "x_mini_engine";
  private static volatile List<InstalledEngine> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private List<bgwd> b = new ArrayList();
  
  public static SharedPreferences a()
  {
    return AppLoaderFactory.g().getMiniAppEnv().getContext().getSharedPreferences(jdField_a_of_type_JavaLangString, 0);
  }
  
  private static File a()
  {
    if (jdField_a_of_type_JavaIoFile == null)
    {
      File localFile = new File(AppLoaderFactory.g().getMiniAppEnv().getContext().getFilesDir().getPath() + "/xminilib/");
      if ((!localFile.exists()) && (!localFile.mkdirs())) {
        QMLog.e("EngineInstaller", "[MiniEng] dir mk failed " + localFile);
      }
      jdField_a_of_type_JavaIoFile = localFile;
    }
    return jdField_a_of_type_JavaIoFile;
  }
  
  /* Error */
  private static String a(File paramFile, EngineVersion paramEngineVersion)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 55	java/io/File
    //   6: dup
    //   7: aload_0
    //   8: aload_1
    //   9: invokevirtual 102	com/tencent/qqmini/sdk/manager/EngineVersion:a	()Ljava/lang/String;
    //   12: invokespecial 105	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   15: astore_0
    //   16: ldc 86
    //   18: new 57	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   25: ldc 107
    //   27: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_0
    //   31: invokevirtual 110	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   34: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 113	com/tencent/qqmini/sdk/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_0
    //   44: invokevirtual 81	java/io/File:exists	()Z
    //   47: ifne +44 -> 91
    //   50: aload_0
    //   51: invokevirtual 84	java/io/File:mkdirs	()Z
    //   54: ifne +37 -> 91
    //   57: ldc 86
    //   59: new 57	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   66: ldc 115
    //   68: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_0
    //   72: invokevirtual 110	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   75: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 97	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: aconst_null
    //   85: astore_0
    //   86: ldc 2
    //   88: monitorexit
    //   89: aload_0
    //   90: areturn
    //   91: aload_0
    //   92: invokevirtual 110	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   95: astore_0
    //   96: goto -10 -> 86
    //   99: astore_0
    //   100: ldc 2
    //   102: monitorexit
    //   103: aload_0
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	paramFile	File
    //   0	105	1	paramEngineVersion	EngineVersion
    // Exception table:
    //   from	to	target	type
    //   3	84	99	finally
    //   91	96	99	finally
  }
  
  public static ArrayList<InstalledEngine> a(int paramInt)
  {
    try
    {
      a();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        InstalledEngine localInstalledEngine = (InstalledEngine)localIterator.next();
        if (localInstalledEngine.jdField_a_of_type_Int == paramInt) {
          localArrayList.add(localInstalledEngine);
        }
      }
    }
    finally {}
    return localArrayList1;
  }
  
  /* Error */
  private static List<InstalledEngine> a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 86
    //   5: ldc 151
    //   7: invokestatic 113	com/tencent/qqmini/sdk/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: invokestatic 157	java/lang/System:currentTimeMillis	()J
    //   13: lstore 5
    //   15: new 24	java/util/ArrayList
    //   18: dup
    //   19: invokespecial 25	java/util/ArrayList:<init>	()V
    //   22: astore 7
    //   24: invokestatic 159	bgwa:a	()Ljava/io/File;
    //   27: astore 8
    //   29: aload 8
    //   31: invokevirtual 81	java/io/File:exists	()Z
    //   34: ifeq +338 -> 372
    //   37: aload 8
    //   39: invokevirtual 162	java/io/File:isDirectory	()Z
    //   42: ifeq +330 -> 372
    //   45: aload 8
    //   47: invokevirtual 166	java/io/File:listFiles	()[Ljava/io/File;
    //   50: ifnull +322 -> 372
    //   53: aload 8
    //   55: invokevirtual 166	java/io/File:listFiles	()[Ljava/io/File;
    //   58: astore 8
    //   60: aload 8
    //   62: arraylength
    //   63: istore_2
    //   64: iconst_0
    //   65: istore_0
    //   66: iload_0
    //   67: iload_2
    //   68: if_icmpge +304 -> 372
    //   71: aload 8
    //   73: iload_0
    //   74: aaload
    //   75: astore 9
    //   77: aload 9
    //   79: invokevirtual 81	java/io/File:exists	()Z
    //   82: ifeq +283 -> 365
    //   85: aload 9
    //   87: invokevirtual 162	java/io/File:isDirectory	()Z
    //   90: ifeq +275 -> 365
    //   93: aload 9
    //   95: invokevirtual 166	java/io/File:listFiles	()[Ljava/io/File;
    //   98: astore 10
    //   100: aload 10
    //   102: ifnull +263 -> 365
    //   105: aload 9
    //   107: invokevirtual 169	java/io/File:getName	()Ljava/lang/String;
    //   110: invokestatic 175	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   113: istore_3
    //   114: aload 9
    //   116: invokevirtual 166	java/io/File:listFiles	()[Ljava/io/File;
    //   119: astore 9
    //   121: aload 9
    //   123: arraylength
    //   124: istore 4
    //   126: iconst_0
    //   127: istore_1
    //   128: iload_1
    //   129: iload 4
    //   131: if_icmpge +234 -> 365
    //   134: aload 9
    //   136: iload_1
    //   137: aaload
    //   138: astore 10
    //   140: new 137	com/tencent/qqmini/sdk/manager/InstalledEngine
    //   143: dup
    //   144: invokespecial 176	com/tencent/qqmini/sdk/manager/InstalledEngine:<init>	()V
    //   147: astore 11
    //   149: aload 11
    //   151: iload_3
    //   152: putfield 140	com/tencent/qqmini/sdk/manager/InstalledEngine:jdField_a_of_type_Int	I
    //   155: aload 11
    //   157: aload 10
    //   159: invokevirtual 169	java/io/File:getName	()Ljava/lang/String;
    //   162: invokestatic 179	com/tencent/qqmini/sdk/manager/EngineVersion:a	(Ljava/lang/String;)Lcom/tencent/qqmini/sdk/manager/EngineVersion;
    //   165: putfield 182	com/tencent/qqmini/sdk/manager/InstalledEngine:jdField_a_of_type_ComTencentQqminiSdkManagerEngineVersion	Lcom/tencent/qqmini/sdk/manager/EngineVersion;
    //   168: aload 11
    //   170: getfield 182	com/tencent/qqmini/sdk/manager/InstalledEngine:jdField_a_of_type_ComTencentQqminiSdkManagerEngineVersion	Lcom/tencent/qqmini/sdk/manager/EngineVersion;
    //   173: ifnonnull +88 -> 261
    //   176: new 184	java/lang/IllegalStateException
    //   179: dup
    //   180: new 57	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   187: ldc 186
    //   189: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload 10
    //   194: invokevirtual 169	java/io/File:getName	()Ljava/lang/String;
    //   197: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokespecial 187	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   206: athrow
    //   207: astore 11
    //   209: ldc 86
    //   211: new 57	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   218: ldc 189
    //   220: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: aload 10
    //   225: invokevirtual 110	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   228: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload 11
    //   233: invokestatic 195	com/tencent/qqmini/sdk/utils/DebugUtil:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   236: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 113	com/tencent/qqmini/sdk/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   245: aload 10
    //   247: invokevirtual 110	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   250: iconst_0
    //   251: invokestatic 200	bgpc:a	(Ljava/lang/String;Z)V
    //   254: iload_1
    //   255: iconst_1
    //   256: iadd
    //   257: istore_1
    //   258: goto -130 -> 128
    //   261: aload 11
    //   263: aload 10
    //   265: invokevirtual 110	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   268: putfield 202	com/tencent/qqmini/sdk/manager/InstalledEngine:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   271: aload 11
    //   273: aload 11
    //   275: invokestatic 205	bgwa:a	(Lcom/tencent/qqmini/sdk/manager/InstalledEngine;)Z
    //   278: putfield 207	com/tencent/qqmini/sdk/manager/InstalledEngine:jdField_a_of_type_Boolean	Z
    //   281: aload 11
    //   283: getfield 207	com/tencent/qqmini/sdk/manager/InstalledEngine:jdField_a_of_type_Boolean	Z
    //   286: ifne +21 -> 307
    //   289: new 184	java/lang/IllegalStateException
    //   292: dup
    //   293: ldc 209
    //   295: invokespecial 187	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   298: athrow
    //   299: astore 7
    //   301: ldc 2
    //   303: monitorexit
    //   304: aload 7
    //   306: athrow
    //   307: aload 11
    //   309: getfield 140	com/tencent/qqmini/sdk/manager/InstalledEngine:jdField_a_of_type_Int	I
    //   312: iconst_2
    //   313: if_icmpne +31 -> 344
    //   316: aload 11
    //   318: ldc 211
    //   320: putfield 212	com/tencent/qqmini/sdk/manager/InstalledEngine:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   323: aload 11
    //   325: aload 10
    //   327: invokestatic 215	bgwa:a	(Ljava/io/File;)Z
    //   330: putfield 217	com/tencent/qqmini/sdk/manager/InstalledEngine:jdField_b_of_type_Boolean	Z
    //   333: aload 7
    //   335: aload 11
    //   337: invokevirtual 144	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   340: pop
    //   341: goto -87 -> 254
    //   344: aload 11
    //   346: getfield 140	com/tencent/qqmini/sdk/manager/InstalledEngine:jdField_a_of_type_Int	I
    //   349: iconst_3
    //   350: if_icmpne -17 -> 333
    //   353: aload 11
    //   355: ldc 219
    //   357: putfield 212	com/tencent/qqmini/sdk/manager/InstalledEngine:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   360: goto -27 -> 333
    //   363: astore 9
    //   365: iload_0
    //   366: iconst_1
    //   367: iadd
    //   368: istore_0
    //   369: goto -303 -> 66
    //   372: aload 7
    //   374: invokestatic 225	java/util/Collections:reverseOrder	()Ljava/util/Comparator;
    //   377: invokestatic 229	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   380: ldc 86
    //   382: new 57	java/lang/StringBuilder
    //   385: dup
    //   386: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   389: ldc 231
    //   391: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: invokestatic 157	java/lang/System:currentTimeMillis	()J
    //   397: lload 5
    //   399: lsub
    //   400: invokevirtual 234	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   403: ldc 236
    //   405: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: aload 7
    //   410: invokevirtual 240	java/util/ArrayList:size	()I
    //   413: invokevirtual 243	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   416: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: invokestatic 113	com/tencent/qqmini/sdk/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   422: ldc 2
    //   424: monitorexit
    //   425: aload 7
    //   427: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   65	304	0	i	int
    //   127	131	1	j	int
    //   63	6	2	k	int
    //   113	39	3	m	int
    //   124	8	4	n	int
    //   13	385	5	l	long
    //   22	1	7	localArrayList	ArrayList
    //   299	127	7	localList	List
    //   27	45	8	localObject1	Object
    //   75	60	9	arrayOfFile	File[]
    //   363	1	9	localException1	Exception
    //   98	228	10	localObject2	Object
    //   147	22	11	localInstalledEngine	InstalledEngine
    //   207	147	11	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   140	207	207	java/lang/Exception
    //   261	299	207	java/lang/Exception
    //   307	333	207	java/lang/Exception
    //   333	341	207	java/lang/Exception
    //   344	360	207	java/lang/Exception
    //   3	64	299	finally
    //   77	100	299	finally
    //   105	114	299	finally
    //   114	126	299	finally
    //   140	207	299	finally
    //   209	254	299	finally
    //   261	299	299	finally
    //   307	333	299	finally
    //   333	341	299	finally
    //   344	360	299	finally
    //   372	422	299	finally
    //   105	114	363	java/lang/Exception
  }
  
  public static void a()
  {
    try
    {
      jdField_a_of_type_JavaUtilList = a();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void a(float paramFloat, String paramString)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      bgwd localbgwd = (bgwd)localIterator.next();
      if (localbgwd != null) {
        localbgwd.a(paramFloat, paramString);
      }
    }
  }
  
  public static void a(int paramInt)
  {
    Object localObject2;
    try
    {
      if (jdField_a_of_type_JavaUtilList == null)
      {
        QMLog.e("EngineInstaller", "[MiniEng]removeOldEngine null");
        return;
      }
      ArrayList localArrayList = new ArrayList();
      localObject2 = jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        InstalledEngine localInstalledEngine = (InstalledEngine)((Iterator)localObject2).next();
        if (localInstalledEngine.jdField_a_of_type_Int == paramInt) {
          localArrayList.add(localInstalledEngine);
        }
      }
      j = localObject1.size();
    }
    finally {}
    int j;
    int i = 0;
    paramInt = 1;
    label98:
    if ((j > 1) && (i < j))
    {
      localObject2 = (InstalledEngine)localObject1.get(i);
      if (((InstalledEngine)localObject2).jdField_b_of_type_Boolean)
      {
        QMLog.i("EngineInstaller", "[MiniEng] removeOldEngine " + localObject2 + " isPersist, so not deleted");
      }
      else
      {
        if (paramInt == 0)
        {
          ((InstalledEngine)localObject2).a();
          jdField_a_of_type_JavaUtilList.remove(localObject2);
          break label228;
        }
        QMLog.i("EngineInstaller", "[MiniEng] removeOldEngine " + localObject2 + "  is latest, so kept");
        break label228;
      }
    }
    for (;;)
    {
      i += 1;
      break label98;
      break;
      label228:
      paramInt = 0;
    }
  }
  
  private void a(BaseLibInfo paramBaseLibInfo, String paramString, long paramLong, File paramFile, EngineVersion paramEngineVersion, boolean paramBoolean)
  {
    String str = AppLoaderFactory.g().getMiniAppEnv().getContext().getCacheDir() + File.separator + UUID.randomUUID() + ".zip";
    ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(paramString, null, str, 60, new bgwb(this, paramString, paramBaseLibInfo, paramLong, paramFile, paramEngineVersion, paramBoolean));
    if (paramBaseLibInfo.baseLibType == 2) {
      bhck.a(bgmb.a(), 4, "1");
    }
  }
  
  public static void a(InstalledEngine paramInstalledEngine)
  {
    if (paramInstalledEngine == null) {}
    for (;;)
    {
      return;
      try
      {
        QMLog.i("EngineInstaller", "[MiniEng] removeEngine " + paramInstalledEngine);
        paramInstalledEngine.a();
        jdField_a_of_type_JavaUtilList.remove(paramInstalledEngine);
      }
      finally {}
    }
  }
  
  private static boolean a(InstalledEngine paramInstalledEngine)
  {
    boolean bool = false;
    if (a() != null) {
      bool = a().getBoolean(paramInstalledEngine.jdField_b_of_type_JavaLangString, false);
    }
    QMLog.i("EngineInstaller", "[MiniEng]verifyEngine " + paramInstalledEngine.jdField_b_of_type_JavaLangString + " " + bool);
    return bool;
  }
  
  private static boolean a(File paramFile)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramFile != null)
    {
      bool1 = bool2;
      if (paramFile.exists())
      {
        bool1 = bool2;
        if (paramFile.isDirectory())
        {
          bool1 = bool2;
          if (paramFile.listFiles() != null)
          {
            paramFile = paramFile.listFiles(new bgwc());
            if (paramFile != null)
            {
              bool1 = bool2;
              if (paramFile.length > 0) {}
            }
            else
            {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  /* Error */
  private boolean a(File paramFile, String paramString1, EngineVersion paramEngineVersion, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: iconst_0
    //   4: istore 9
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_1
    //   9: aload_3
    //   10: invokestatic 356	bgwa:a	(Ljava/io/File;Lcom/tencent/qqmini/sdk/manager/EngineVersion;)Ljava/lang/String;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +26 -> 41
    //   18: aload_0
    //   19: invokespecial 274	bgwa:d	()V
    //   22: aload 4
    //   24: iconst_1
    //   25: invokestatic 200	bgpc:a	(Ljava/lang/String;Z)V
    //   28: aload_0
    //   29: invokespecial 274	bgwa:d	()V
    //   32: iload 9
    //   34: istore 7
    //   36: aload_0
    //   37: monitorexit
    //   38: iload 7
    //   40: ireturn
    //   41: new 55	java/io/File
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 77	java/io/File:<init>	(Ljava/lang/String;)V
    //   49: invokevirtual 81	java/io/File:exists	()Z
    //   52: ifeq +8 -> 60
    //   55: aload_1
    //   56: iconst_0
    //   57: invokestatic 200	bgpc:a	(Ljava/lang/String;Z)V
    //   60: aload_0
    //   61: fconst_1
    //   62: ldc_w 358
    //   65: invokespecial 276	bgwa:a	(FLjava/lang/String;)V
    //   68: aload 4
    //   70: aload_1
    //   71: invokestatic 363	bgpy:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   74: istore 6
    //   76: iload 6
    //   78: ifne +325 -> 403
    //   81: ldc2_w 364
    //   84: invokestatic 371	java/lang/Thread:sleep	(J)V
    //   87: aload_0
    //   88: fconst_1
    //   89: ldc_w 373
    //   92: invokespecial 276	bgwa:a	(FLjava/lang/String;)V
    //   95: ldc2_w 364
    //   98: invokestatic 371	java/lang/Thread:sleep	(J)V
    //   101: aload_0
    //   102: aload 4
    //   104: aload_1
    //   105: invokespecial 376	bgwa:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   108: istore 8
    //   110: iload 6
    //   112: ifne +101 -> 213
    //   115: iload 8
    //   117: ifeq +96 -> 213
    //   120: ldc 86
    //   122: new 57	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   129: ldc_w 378
    //   132: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_2
    //   136: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: ldc_w 380
    //   142: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_3
    //   146: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   149: ldc_w 382
    //   152: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload_1
    //   156: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 113	com/tencent/qqmini/sdk/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: invokestatic 118	bgwa:a	()V
    //   168: iconst_1
    //   169: istore 7
    //   171: aload 4
    //   173: iconst_1
    //   174: invokestatic 200	bgpc:a	(Ljava/lang/String;Z)V
    //   177: iload 7
    //   179: ifeq +22 -> 201
    //   182: iload 5
    //   184: ifeq +194 -> 378
    //   187: aload_0
    //   188: fconst_1
    //   189: ldc_w 384
    //   192: invokespecial 276	bgwa:a	(FLjava/lang/String;)V
    //   195: ldc2_w 364
    //   198: invokestatic 371	java/lang/Thread:sleep	(J)V
    //   201: aload_0
    //   202: invokespecial 274	bgwa:d	()V
    //   205: goto -169 -> 36
    //   208: astore_1
    //   209: aload_0
    //   210: monitorexit
    //   211: aload_1
    //   212: athrow
    //   213: ldc 86
    //   215: new 57	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   222: ldc_w 386
    //   225: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload_2
    //   229: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: ldc_w 380
    //   235: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload_3
    //   239: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   242: ldc_w 382
    //   245: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: aload_1
    //   249: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: invokestatic 113	com/tencent/qqmini/sdk/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   258: aload_1
    //   259: iconst_0
    //   260: invokestatic 200	bgpc:a	(Ljava/lang/String;Z)V
    //   263: iload 6
    //   265: ifeq +76 -> 341
    //   268: aload_0
    //   269: fconst_0
    //   270: ldc_w 388
    //   273: invokespecial 276	bgwa:a	(FLjava/lang/String;)V
    //   276: iload 10
    //   278: istore 7
    //   280: goto -109 -> 171
    //   283: astore_1
    //   284: ldc 86
    //   286: new 57	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   293: ldc_w 390
    //   296: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload_1
    //   300: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   303: aload_1
    //   304: invokestatic 195	com/tencent/qqmini/sdk/utils/DebugUtil:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   307: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokestatic 97	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: aload_0
    //   317: fconst_0
    //   318: ldc_w 392
    //   321: invokespecial 276	bgwa:a	(FLjava/lang/String;)V
    //   324: aload 4
    //   326: iconst_1
    //   327: invokestatic 200	bgpc:a	(Ljava/lang/String;Z)V
    //   330: aload_0
    //   331: invokespecial 274	bgwa:d	()V
    //   334: iload 9
    //   336: istore 7
    //   338: goto -302 -> 36
    //   341: iload 10
    //   343: istore 7
    //   345: iload 8
    //   347: ifne -176 -> 171
    //   350: aload_0
    //   351: fconst_0
    //   352: ldc_w 394
    //   355: invokespecial 276	bgwa:a	(FLjava/lang/String;)V
    //   358: iload 10
    //   360: istore 7
    //   362: goto -191 -> 171
    //   365: astore_1
    //   366: aload 4
    //   368: iconst_1
    //   369: invokestatic 200	bgpc:a	(Ljava/lang/String;Z)V
    //   372: aload_0
    //   373: invokespecial 274	bgwa:d	()V
    //   376: aload_1
    //   377: athrow
    //   378: aload_0
    //   379: fconst_1
    //   380: ldc_w 396
    //   383: invokespecial 276	bgwa:a	(FLjava/lang/String;)V
    //   386: goto -191 -> 195
    //   389: astore 11
    //   391: goto -304 -> 87
    //   394: astore 11
    //   396: goto -295 -> 101
    //   399: astore_1
    //   400: goto -199 -> 201
    //   403: iconst_1
    //   404: istore 8
    //   406: goto -296 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	409	0	this	bgwa
    //   0	409	1	paramFile	File
    //   0	409	2	paramString1	String
    //   0	409	3	paramEngineVersion	EngineVersion
    //   0	409	4	paramString2	String
    //   0	409	5	paramBoolean	boolean
    //   74	190	6	i	int
    //   34	327	7	bool1	boolean
    //   108	297	8	bool2	boolean
    //   4	331	9	bool3	boolean
    //   1	358	10	bool4	boolean
    //   389	1	11	localInterruptedException1	java.lang.InterruptedException
    //   394	1	11	localInterruptedException2	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   22	32	208	finally
    //   171	177	208	finally
    //   187	195	208	finally
    //   195	201	208	finally
    //   201	205	208	finally
    //   324	334	208	finally
    //   366	378	208	finally
    //   378	386	208	finally
    //   8	14	283	java/lang/Exception
    //   18	22	283	java/lang/Exception
    //   41	60	283	java/lang/Exception
    //   60	76	283	java/lang/Exception
    //   81	87	283	java/lang/Exception
    //   87	95	283	java/lang/Exception
    //   95	101	283	java/lang/Exception
    //   101	110	283	java/lang/Exception
    //   120	168	283	java/lang/Exception
    //   213	263	283	java/lang/Exception
    //   268	276	283	java/lang/Exception
    //   350	358	283	java/lang/Exception
    //   8	14	365	finally
    //   18	22	365	finally
    //   41	60	365	finally
    //   60	76	365	finally
    //   81	87	365	finally
    //   87	95	365	finally
    //   95	101	365	finally
    //   101	110	365	finally
    //   120	168	365	finally
    //   213	263	365	finally
    //   268	276	365	finally
    //   284	324	365	finally
    //   350	358	365	finally
    //   81	87	389	java/lang/InterruptedException
    //   95	101	394	java/lang/InterruptedException
    //   195	201	399	java/lang/InterruptedException
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    long l1 = bgpy.a(paramString1);
    if (l1 <= 0L)
    {
      QMLog.e("EngineInstaller", "[MiniEng] getUncompressedFileSize error " + paramString1 + ", sz=" + l1);
      return false;
    }
    long l2 = StorageUtil.getDirUsedSpace(paramString2);
    if (l2 <= 0L)
    {
      QMLog.e("EngineInstaller", "[MiniEng] getDirUsedSpace error " + paramString2 + ", sz2=" + l2);
      return false;
    }
    if (l1 == l2)
    {
      a().edit().putBoolean(paramString2, true).commit();
      return true;
    }
    QMLog.e("EngineInstaller", "[MiniEng] verifyBaselib failed sz1=" + l1 + ", sz2=" + l2);
    return false;
  }
  
  private void b()
  {
    try
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        bgwd localbgwd = (bgwd)localIterator.next();
        if (localbgwd != null) {
          localbgwd.a();
        }
      }
    }
    finally {}
  }
  
  public static void b(int paramInt)
  {
    label286:
    for (;;)
    {
      Object localObject2;
      InstalledEngine localInstalledEngine;
      try
      {
        if (jdField_a_of_type_JavaUtilList == null)
        {
          QMLog.e("EngineInstaller", "[MiniEng]removeOutDatedEngine null");
          return;
        }
        localObject2 = new ArrayList();
        Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          localInstalledEngine = (InstalledEngine)localIterator.next();
          if (localInstalledEngine.jdField_a_of_type_Int != paramInt) {
            continue;
          }
          ((List)localObject2).add(localInstalledEngine);
          continue;
        }
        if (paramInt != 2) {}
      }
      finally {}
      for (EngineVersion localEngineVersion = bgxk.a().jdField_a_of_type_ComTencentQqminiSdkManagerEngineVersion;; localEngineVersion = null)
      {
        if (localEngineVersion == null) {
          break label286;
        }
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localInstalledEngine = (InstalledEngine)((Iterator)localObject2).next();
          if (localInstalledEngine.jdField_a_of_type_ComTencentQqminiSdkManagerEngineVersion.a(localEngineVersion) < 0)
          {
            QMLog.i("EngineInstaller", "[MiniEng] removeOutDatedEngine " + localInstalledEngine + " localMinVer:" + localEngineVersion + ",engineType:" + paramInt);
            localInstalledEngine.a();
            jdField_a_of_type_JavaUtilList.remove(localInstalledEngine);
          }
          else if ((localInstalledEngine.jdField_b_of_type_Boolean) && (!b(new File(localInstalledEngine.jdField_b_of_type_JavaLangString))))
          {
            QMLog.i("EngineInstaller", "[MiniEng] removeOutDatedPersistEngine " + localInstalledEngine + " localMinVer:" + localEngineVersion + ",engineType:" + paramInt);
            localInstalledEngine.a();
            jdField_a_of_type_JavaUtilList.remove(localInstalledEngine);
          }
        }
        break;
      }
    }
  }
  
  private static boolean b(File paramFile)
  {
    EngineVersion localEngineVersion = EngineVersion.a(paramFile.getName());
    return (localEngineVersion != null) && (localEngineVersion.equals(bgxk.a().jdField_a_of_type_ComTencentQqminiSdkManagerEngineVersion)) && (a(paramFile));
  }
  
  private void c()
  {
    try
    {
      this.jdField_a_of_type_Boolean = true;
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        bgwd localbgwd = (bgwd)localIterator.next();
        if (localbgwd != null) {
          localbgwd.b();
        }
      }
    }
    finally {}
  }
  
  private void d()
  {
    try
    {
      this.jdField_a_of_type_Boolean = false;
      Iterator localIterator = new ArrayList(this.b).iterator();
      while (localIterator.hasNext())
      {
        bgwd localbgwd = (bgwd)localIterator.next();
        if (localbgwd != null) {
          localbgwd.c();
        }
      }
    }
    finally {}
  }
  
  public void a(bgwd parambgwd)
  {
    try
    {
      this.b.add(parambgwd);
      return;
    }
    finally
    {
      parambgwd = finally;
      throw parambgwd;
    }
  }
  
  public void a(BaseLibInfo paramBaseLibInfo, bgwd parambgwd)
  {
    Object localObject;
    File localFile;
    EngineVersion localEngineVersion;
    long l;
    label242:
    boolean bool1;
    for (;;)
    {
      try
      {
        localObject = paramBaseLibInfo.baseLibUrl;
        if (parambgwd != null) {
          a(parambgwd);
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramBaseLibInfo.baseLibVersion)) && (paramBaseLibInfo.baseLibType > 0)) {
          continue;
        }
        QMLog.w("EngineInstaller", "[MiniEng] invalid BaseLibInfo " + paramBaseLibInfo);
        b();
      }
      finally
      {
        try
        {
          JSONObject localJSONObject = new JSONObject(paramBaseLibInfo.baseLibDesc);
          localEngineVersion = new EngineVersion(paramBaseLibInfo.baseLibVersion);
          l = localJSONObject.optLong("file_length");
          QMLog.w("EngineInstaller", "[MiniEng] installWithCallback " + paramBaseLibInfo);
          if (a() != null) {
            break label242;
          }
          QMLog.w("EngineInstaller", "[MiniEng] shared preference not supported");
          b();
        }
        catch (Exception parambgwd)
        {
          QMLog.w("EngineInstaller", "[MiniEng] refuse installEngine " + paramBaseLibInfo.baseLibDesc + ":" + paramBaseLibInfo.baseLibVersion + paramBaseLibInfo.baseLibUrl + DebugUtil.getPrintableStackTrace(parambgwd));
          b();
        }
        paramBaseLibInfo = finally;
      }
      return;
      localFile = new File(a(), String.valueOf(paramBaseLibInfo.baseLibType));
      continue;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        QMLog.e("EngineInstaller", "[MiniEng] empty engine url");
        b();
      }
      else if (a())
      {
        QMLog.i("EngineInstaller", "[MiniEng] downloading already in progress");
        b();
      }
      else
      {
        bool1 = false;
        QMLog.i("EngineInstaller", "[MiniEng] installWithCallback callback=" + parambgwd);
        if ((paramBaseLibInfo.baseLibType == 2) && (!bgxk.a().a()) && (!paramBaseLibInfo.baseLibUrl.startsWith("assets://")))
        {
          parambgwd = bgxk.a().jdField_a_of_type_ComTencentQqminiSdkManagerEngineVersion;
          if (parambgwd.a(localEngineVersion) >= 0)
          {
            QMLog.i("EngineInstaller", "[MiniEng] refuse install remote baselib:" + localEngineVersion + ",local:" + parambgwd);
            b();
            continue;
          }
        }
        parambgwd = a(paramBaseLibInfo.baseLibType);
        QMLog.i("EngineInstaller", "[MiniEng] engineForType " + paramBaseLibInfo.baseLibType + ", size=" + parambgwd.size());
        if (parambgwd.size() <= 0) {
          break;
        }
        parambgwd = (InstalledEngine)parambgwd.get(0);
        QMLog.i("EngineInstaller", "[MiniEng]latest engine for type " + paramBaseLibInfo.baseLibType + "," + parambgwd);
        if (parambgwd.jdField_a_of_type_ComTencentQqminiSdkManagerEngineVersion.a(localEngineVersion) < 0) {
          break label1100;
        }
        QMLog.i("EngineInstaller", "[MiniEng]engine type " + paramBaseLibInfo.baseLibType + " has no update, remote:" + localEngineVersion + ",latest:" + parambgwd);
        b();
      }
    }
    for (;;)
    {
      for (;;)
      {
        c();
        if (bool1) {
          a(0.0F, "更新引擎(" + paramBaseLibInfo.baseLibVersion + ")");
        }
        for (;;)
        {
          QMLog.i("EngineInstaller", "[MiniEng] installEngine " + (String)localObject);
          if ((localFile.exists()) || (localFile.mkdirs())) {
            break label739;
          }
          QMLog.i("EngineInstaller", "[MiniEng] mkdir failed, is disk writable? " + localFile.getAbsolutePath());
          d();
          break;
          a(0.0F, "下载引擎(" + paramBaseLibInfo.baseLibVersion + ")");
        }
        label739:
        boolean bool2 = false;
        parambgwd = null;
        if (paramBaseLibInfo.baseLibType == 2)
        {
          bool2 = paramBaseLibInfo.baseLibUrl.startsWith("assets://");
          paramBaseLibInfo.baseLibUrl.replace("assets://", "");
          parambgwd = new long[1];
          parambgwd[0] = 0L;
        }
        if (!bool2) {
          break label1083;
        }
        try
        {
          a(0.0F, "正在解压缩本地引擎");
          paramBaseLibInfo = a(localFile, localEngineVersion);
          QMLog.i("EngineInstaller", "[MiniEng] installLocalEngine start url=" + (String)localObject + ",installBasePath=" + paramBaseLibInfo);
          if (TextUtils.isEmpty(paramBaseLibInfo))
          {
            a(0.0F, "本地引擎安装失败, 目录为空");
            QMLog.e("EngineInstaller", "[MiniEng] installLocalEngine failed installBasePath=" + paramBaseLibInfo);
            d();
            break;
          }
        }
        finally {}
      }
      localObject = new File(paramBaseLibInfo);
      if ((!((File)localObject).exists()) && (!((File)localObject).mkdir()))
      {
        a(0.0F, "本地引擎安装失败, 创建目录失败");
        QMLog.e("EngineInstaller", "[MiniEng] installLocalEngine failed targetPath=" + localObject);
        d();
        break;
      }
      bgvs.a().a();
      QMLog.i("EngineInstaller", "[MiniEng] installLocalEngine finish copied " + parambgwd[0] + "<>" + l);
      if ((parambgwd[0] == l) || (l < 0L))
      {
        a().edit().putBoolean(paramBaseLibInfo, true).commit();
        a();
        a(1.0F, "本地引擎安装完成");
      }
      for (;;)
      {
        d();
        break;
        a(0.0F, "本地引擎安装失败");
      }
      label1083:
      a(paramBaseLibInfo, (String)localObject, l, localFile, localEngineVersion, bool1);
      break;
      label1100:
      bool1 = true;
    }
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b(bgwd parambgwd)
  {
    try
    {
      this.b.remove(parambgwd);
      return;
    }
    finally
    {
      parambgwd = finally;
      throw parambgwd;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgwa
 * JD-Core Version:    0.7.0.1
 */