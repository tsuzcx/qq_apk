import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.manager.EngineVersion;
import com.tencent.qqmini.sdk.manager.InstalledEngine;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

public class bdoi
{
  private static File jdField_a_of_type_JavaIoFile;
  private static String jdField_a_of_type_JavaLangString = "x_mini_engine";
  private static volatile List<InstalledEngine> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private List<bdol> b = new ArrayList();
  
  public static SharedPreferences a()
  {
    return MiniAppEnv.g().getContext().getSharedPreferences(jdField_a_of_type_JavaLangString, 0);
  }
  
  private static File a()
  {
    if (jdField_a_of_type_JavaIoFile == null)
    {
      File localFile = new File(MiniAppEnv.g().getContext().getFilesDir().getPath() + "/xminilib/");
      if ((!localFile.exists()) && (!localFile.mkdirs())) {
        bdnw.d("EngineInstaller", "[MiniEng] dir mk failed " + localFile);
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
    //   3: new 49	java/io/File
    //   6: dup
    //   7: aload_0
    //   8: aload_1
    //   9: invokevirtual 96	com/tencent/qqmini/sdk/manager/EngineVersion:a	()Ljava/lang/String;
    //   12: invokespecial 99	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   15: astore_0
    //   16: ldc 80
    //   18: new 51	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   25: ldc 101
    //   27: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_0
    //   31: invokevirtual 104	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   34: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 106	bdnw:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_0
    //   44: invokevirtual 75	java/io/File:exists	()Z
    //   47: ifne +44 -> 91
    //   50: aload_0
    //   51: invokevirtual 78	java/io/File:mkdirs	()Z
    //   54: ifne +37 -> 91
    //   57: ldc 80
    //   59: new 51	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   66: ldc 108
    //   68: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_0
    //   72: invokevirtual 104	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   75: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 91	bdnw:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: aconst_null
    //   85: astore_0
    //   86: ldc 2
    //   88: monitorexit
    //   89: aload_0
    //   90: areturn
    //   91: aload_0
    //   92: invokevirtual 104	java/io/File:getAbsolutePath	()Ljava/lang/String;
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
    //   3: ldc 80
    //   5: ldc 144
    //   7: invokestatic 106	bdnw:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: invokestatic 150	java/lang/System:currentTimeMillis	()J
    //   13: lstore 5
    //   15: new 24	java/util/ArrayList
    //   18: dup
    //   19: invokespecial 25	java/util/ArrayList:<init>	()V
    //   22: astore 8
    //   24: invokestatic 152	bdoi:a	()Ljava/io/File;
    //   27: astore 9
    //   29: aload 9
    //   31: invokevirtual 75	java/io/File:exists	()Z
    //   34: ifeq +322 -> 356
    //   37: aload 9
    //   39: invokevirtual 155	java/io/File:isDirectory	()Z
    //   42: ifeq +314 -> 356
    //   45: aload 9
    //   47: invokevirtual 159	java/io/File:listFiles	()[Ljava/io/File;
    //   50: astore 9
    //   52: aload 9
    //   54: arraylength
    //   55: istore_2
    //   56: iconst_0
    //   57: istore_0
    //   58: iload_0
    //   59: iload_2
    //   60: if_icmpge +296 -> 356
    //   63: aload 9
    //   65: iload_0
    //   66: aaload
    //   67: astore 10
    //   69: aload 10
    //   71: invokevirtual 75	java/io/File:exists	()Z
    //   74: ifeq +275 -> 349
    //   77: aload 10
    //   79: invokevirtual 155	java/io/File:isDirectory	()Z
    //   82: istore 7
    //   84: iload 7
    //   86: ifeq +263 -> 349
    //   89: aload 10
    //   91: invokevirtual 162	java/io/File:getName	()Ljava/lang/String;
    //   94: invokestatic 168	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   97: istore_3
    //   98: aload 10
    //   100: invokevirtual 159	java/io/File:listFiles	()[Ljava/io/File;
    //   103: astore 10
    //   105: aload 10
    //   107: arraylength
    //   108: istore 4
    //   110: iconst_0
    //   111: istore_1
    //   112: iload_1
    //   113: iload 4
    //   115: if_icmpge +234 -> 349
    //   118: aload 10
    //   120: iload_1
    //   121: aaload
    //   122: astore 11
    //   124: new 130	com/tencent/qqmini/sdk/manager/InstalledEngine
    //   127: dup
    //   128: invokespecial 169	com/tencent/qqmini/sdk/manager/InstalledEngine:<init>	()V
    //   131: astore 12
    //   133: aload 12
    //   135: iload_3
    //   136: putfield 133	com/tencent/qqmini/sdk/manager/InstalledEngine:jdField_a_of_type_Int	I
    //   139: aload 12
    //   141: aload 11
    //   143: invokevirtual 162	java/io/File:getName	()Ljava/lang/String;
    //   146: invokestatic 172	com/tencent/qqmini/sdk/manager/EngineVersion:a	(Ljava/lang/String;)Lcom/tencent/qqmini/sdk/manager/EngineVersion;
    //   149: putfield 175	com/tencent/qqmini/sdk/manager/InstalledEngine:jdField_a_of_type_ComTencentQqminiSdkManagerEngineVersion	Lcom/tencent/qqmini/sdk/manager/EngineVersion;
    //   152: aload 12
    //   154: getfield 175	com/tencent/qqmini/sdk/manager/InstalledEngine:jdField_a_of_type_ComTencentQqminiSdkManagerEngineVersion	Lcom/tencent/qqmini/sdk/manager/EngineVersion;
    //   157: ifnonnull +88 -> 245
    //   160: new 177	java/lang/IllegalStateException
    //   163: dup
    //   164: new 51	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   171: ldc 179
    //   173: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload 11
    //   178: invokevirtual 162	java/io/File:getName	()Ljava/lang/String;
    //   181: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokespecial 180	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   190: athrow
    //   191: astore 12
    //   193: ldc 80
    //   195: new 51	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   202: ldc 182
    //   204: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload 11
    //   209: invokevirtual 104	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   212: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload 12
    //   217: invokestatic 187	bdyl:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   220: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 106	bdnw:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: aload 11
    //   231: invokevirtual 104	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   234: iconst_0
    //   235: invokestatic 192	bdgo:a	(Ljava/lang/String;Z)V
    //   238: iload_1
    //   239: iconst_1
    //   240: iadd
    //   241: istore_1
    //   242: goto -130 -> 112
    //   245: aload 12
    //   247: aload 11
    //   249: invokevirtual 104	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   252: putfield 194	com/tencent/qqmini/sdk/manager/InstalledEngine:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   255: aload 12
    //   257: aload 12
    //   259: invokestatic 197	bdoi:a	(Lcom/tencent/qqmini/sdk/manager/InstalledEngine;)Z
    //   262: putfield 199	com/tencent/qqmini/sdk/manager/InstalledEngine:jdField_a_of_type_Boolean	Z
    //   265: aload 12
    //   267: getfield 199	com/tencent/qqmini/sdk/manager/InstalledEngine:jdField_a_of_type_Boolean	Z
    //   270: ifne +21 -> 291
    //   273: new 177	java/lang/IllegalStateException
    //   276: dup
    //   277: ldc 201
    //   279: invokespecial 180	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   282: athrow
    //   283: astore 8
    //   285: ldc 2
    //   287: monitorexit
    //   288: aload 8
    //   290: athrow
    //   291: aload 12
    //   293: getfield 133	com/tencent/qqmini/sdk/manager/InstalledEngine:jdField_a_of_type_Int	I
    //   296: iconst_2
    //   297: if_icmpne +31 -> 328
    //   300: aload 12
    //   302: ldc 203
    //   304: putfield 204	com/tencent/qqmini/sdk/manager/InstalledEngine:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   307: aload 12
    //   309: aload 11
    //   311: invokestatic 207	bdoi:a	(Ljava/io/File;)Z
    //   314: putfield 209	com/tencent/qqmini/sdk/manager/InstalledEngine:jdField_b_of_type_Boolean	Z
    //   317: aload 8
    //   319: aload 12
    //   321: invokevirtual 137	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   324: pop
    //   325: goto -87 -> 238
    //   328: aload 12
    //   330: getfield 133	com/tencent/qqmini/sdk/manager/InstalledEngine:jdField_a_of_type_Int	I
    //   333: iconst_3
    //   334: if_icmpne -17 -> 317
    //   337: aload 12
    //   339: ldc 211
    //   341: putfield 204	com/tencent/qqmini/sdk/manager/InstalledEngine:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   344: goto -27 -> 317
    //   347: astore 10
    //   349: iload_0
    //   350: iconst_1
    //   351: iadd
    //   352: istore_0
    //   353: goto -295 -> 58
    //   356: aload 8
    //   358: invokestatic 217	java/util/Collections:reverseOrder	()Ljava/util/Comparator;
    //   361: invokestatic 221	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   364: ldc 80
    //   366: new 51	java/lang/StringBuilder
    //   369: dup
    //   370: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   373: ldc 223
    //   375: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: invokestatic 150	java/lang/System:currentTimeMillis	()J
    //   381: lload 5
    //   383: lsub
    //   384: invokevirtual 226	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   387: ldc 228
    //   389: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: aload 8
    //   394: invokevirtual 232	java/util/ArrayList:size	()I
    //   397: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   400: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: invokestatic 106	bdnw:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   406: ldc 2
    //   408: monitorexit
    //   409: aload 8
    //   411: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   57	296	0	i	int
    //   111	131	1	j	int
    //   55	6	2	k	int
    //   97	39	3	m	int
    //   108	8	4	n	int
    //   13	369	5	l	long
    //   82	3	7	bool	boolean
    //   22	1	8	localArrayList	ArrayList
    //   283	127	8	localList	List
    //   27	37	9	localObject	Object
    //   67	52	10	arrayOfFile	File[]
    //   347	1	10	localException1	Exception
    //   122	188	11	localFile	File
    //   131	22	12	localInstalledEngine	InstalledEngine
    //   191	147	12	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   124	191	191	java/lang/Exception
    //   245	283	191	java/lang/Exception
    //   291	317	191	java/lang/Exception
    //   317	325	191	java/lang/Exception
    //   328	344	191	java/lang/Exception
    //   3	56	283	finally
    //   69	84	283	finally
    //   89	98	283	finally
    //   98	110	283	finally
    //   124	191	283	finally
    //   193	238	283	finally
    //   245	283	283	finally
    //   291	317	283	finally
    //   317	325	283	finally
    //   328	344	283	finally
    //   356	406	283	finally
    //   89	98	347	java/lang/Exception
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
      bdol localbdol = (bdol)localIterator.next();
      if (localbdol != null) {
        localbdol.a(paramFloat, paramString);
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
        bdnw.d("EngineInstaller", "[MiniEng]removeOldEngine null");
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
        bdnw.b("EngineInstaller", "[MiniEng] removeOldEngine " + localObject2 + " isPersist, so not deleted");
      }
      else
      {
        if (paramInt == 0)
        {
          ((InstalledEngine)localObject2).a();
          jdField_a_of_type_JavaUtilList.remove(localObject2);
          break label226;
        }
        bdnw.b("EngineInstaller", "[MiniEng] removeOldEngine " + localObject2 + "  is latest, so kept");
        break label226;
      }
    }
    for (;;)
    {
      i += 1;
      break label98;
      break;
      label226:
      paramInt = 0;
    }
  }
  
  private void a(BaseLibInfo paramBaseLibInfo, String paramString, long paramLong, File paramFile, EngineVersion paramEngineVersion, boolean paramBoolean)
  {
    String str = MiniAppEnv.g().getContext().getCacheDir() + File.separator + UUID.randomUUID() + ".zip";
    ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(paramString, null, str, 60, new bdoj(this, paramString, paramBaseLibInfo, paramLong, paramFile, paramEngineVersion, paramBoolean));
    if (paramBaseLibInfo.baseLibType == 2) {
      bdsu.a(bddc.a(), 4, "1");
    }
  }
  
  private static boolean a(InstalledEngine paramInstalledEngine)
  {
    boolean bool = false;
    if (a() != null) {
      bool = a().getBoolean(paramInstalledEngine.jdField_b_of_type_JavaLangString, false);
    }
    bdnw.b("EngineInstaller", "[MiniEng]verifyEngine " + paramInstalledEngine.jdField_b_of_type_JavaLangString + " " + bool);
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
          paramFile = paramFile.listFiles(new bdok());
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
    //   10: invokestatic 344	bdoi:a	(Ljava/io/File;Lcom/tencent/qqmini/sdk/manager/EngineVersion;)Ljava/lang/String;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +26 -> 41
    //   18: aload_0
    //   19: invokespecial 265	bdoi:d	()V
    //   22: aload 4
    //   24: iconst_1
    //   25: invokestatic 192	bdgo:a	(Ljava/lang/String;Z)V
    //   28: aload_0
    //   29: invokespecial 265	bdoi:d	()V
    //   32: iload 9
    //   34: istore 7
    //   36: aload_0
    //   37: monitorexit
    //   38: iload 7
    //   40: ireturn
    //   41: new 49	java/io/File
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 71	java/io/File:<init>	(Ljava/lang/String;)V
    //   49: invokevirtual 75	java/io/File:exists	()Z
    //   52: ifeq +8 -> 60
    //   55: aload_1
    //   56: iconst_0
    //   57: invokestatic 192	bdgo:a	(Ljava/lang/String;Z)V
    //   60: aload_0
    //   61: fconst_1
    //   62: ldc_w 346
    //   65: invokespecial 267	bdoi:a	(FLjava/lang/String;)V
    //   68: aload 4
    //   70: aload_1
    //   71: invokestatic 351	bdhh:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   74: istore 6
    //   76: iload 6
    //   78: ifne +325 -> 403
    //   81: ldc2_w 352
    //   84: invokestatic 359	java/lang/Thread:sleep	(J)V
    //   87: aload_0
    //   88: fconst_1
    //   89: ldc_w 361
    //   92: invokespecial 267	bdoi:a	(FLjava/lang/String;)V
    //   95: ldc2_w 352
    //   98: invokestatic 359	java/lang/Thread:sleep	(J)V
    //   101: aload_0
    //   102: aload 4
    //   104: aload_1
    //   105: invokespecial 364	bdoi:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   108: istore 8
    //   110: iload 6
    //   112: ifne +101 -> 213
    //   115: iload 8
    //   117: ifeq +96 -> 213
    //   120: ldc 80
    //   122: new 51	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   129: ldc_w 366
    //   132: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_2
    //   136: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: ldc_w 368
    //   142: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_3
    //   146: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   149: ldc_w 370
    //   152: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload_1
    //   156: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 106	bdnw:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: invokestatic 111	bdoi:a	()V
    //   168: iconst_1
    //   169: istore 7
    //   171: aload 4
    //   173: iconst_1
    //   174: invokestatic 192	bdgo:a	(Ljava/lang/String;Z)V
    //   177: iload 7
    //   179: ifeq +22 -> 201
    //   182: iload 5
    //   184: ifeq +194 -> 378
    //   187: aload_0
    //   188: fconst_1
    //   189: ldc_w 372
    //   192: invokespecial 267	bdoi:a	(FLjava/lang/String;)V
    //   195: ldc2_w 352
    //   198: invokestatic 359	java/lang/Thread:sleep	(J)V
    //   201: aload_0
    //   202: invokespecial 265	bdoi:d	()V
    //   205: goto -169 -> 36
    //   208: astore_1
    //   209: aload_0
    //   210: monitorexit
    //   211: aload_1
    //   212: athrow
    //   213: ldc 80
    //   215: new 51	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   222: ldc_w 374
    //   225: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload_2
    //   229: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: ldc_w 368
    //   235: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload_3
    //   239: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   242: ldc_w 370
    //   245: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: aload_1
    //   249: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: invokestatic 106	bdnw:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   258: aload_1
    //   259: iconst_0
    //   260: invokestatic 192	bdgo:a	(Ljava/lang/String;Z)V
    //   263: iload 6
    //   265: ifeq +76 -> 341
    //   268: aload_0
    //   269: fconst_0
    //   270: ldc_w 376
    //   273: invokespecial 267	bdoi:a	(FLjava/lang/String;)V
    //   276: iload 10
    //   278: istore 7
    //   280: goto -109 -> 171
    //   283: astore_1
    //   284: ldc 80
    //   286: new 51	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   293: ldc_w 378
    //   296: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload_1
    //   300: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   303: aload_1
    //   304: invokestatic 187	bdyl:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   307: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokestatic 91	bdnw:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: aload_0
    //   317: fconst_0
    //   318: ldc_w 380
    //   321: invokespecial 267	bdoi:a	(FLjava/lang/String;)V
    //   324: aload 4
    //   326: iconst_1
    //   327: invokestatic 192	bdgo:a	(Ljava/lang/String;Z)V
    //   330: aload_0
    //   331: invokespecial 265	bdoi:d	()V
    //   334: iload 9
    //   336: istore 7
    //   338: goto -302 -> 36
    //   341: iload 10
    //   343: istore 7
    //   345: iload 8
    //   347: ifne -176 -> 171
    //   350: aload_0
    //   351: fconst_0
    //   352: ldc_w 382
    //   355: invokespecial 267	bdoi:a	(FLjava/lang/String;)V
    //   358: iload 10
    //   360: istore 7
    //   362: goto -191 -> 171
    //   365: astore_1
    //   366: aload 4
    //   368: iconst_1
    //   369: invokestatic 192	bdgo:a	(Ljava/lang/String;Z)V
    //   372: aload_0
    //   373: invokespecial 265	bdoi:d	()V
    //   376: aload_1
    //   377: athrow
    //   378: aload_0
    //   379: fconst_1
    //   380: ldc_w 384
    //   383: invokespecial 267	bdoi:a	(FLjava/lang/String;)V
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
    //   0	409	0	this	bdoi
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
    long l1 = bdhh.a(paramString1);
    if (l1 <= 0L)
    {
      bdnw.d("EngineInstaller", "[MiniEng] getUncompressedFileSize error " + paramString1 + ", sz=" + l1);
      return false;
    }
    long l2 = bdzf.a(paramString2);
    if (l2 <= 0L)
    {
      bdnw.d("EngineInstaller", "[MiniEng] getDirUsedSpace error " + paramString2 + ", sz2=" + l2);
      return false;
    }
    if (l1 == l2)
    {
      a().edit().putBoolean(paramString2, true).commit();
      return true;
    }
    bdnw.d("EngineInstaller", "[MiniEng] verifyBaselib failed sz1=" + l1 + ", sz2=" + l2);
    return false;
  }
  
  private void b()
  {
    try
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        bdol localbdol = (bdol)localIterator.next();
        if (localbdol != null) {
          localbdol.a();
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
          bdnw.d("EngineInstaller", "[MiniEng]removeOutDatedEngine null");
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
      for (EngineVersion localEngineVersion = bdou.a().jdField_a_of_type_ComTencentQqminiSdkManagerEngineVersion;; localEngineVersion = null)
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
            bdnw.b("EngineInstaller", "[MiniEng] removeOutDatedEngine " + localInstalledEngine + " localMinVer:" + localEngineVersion + ",engineType:" + paramInt);
            localInstalledEngine.a();
            jdField_a_of_type_JavaUtilList.remove(localInstalledEngine);
          }
          else if ((localInstalledEngine.jdField_b_of_type_Boolean) && (!b(new File(localInstalledEngine.jdField_b_of_type_JavaLangString))))
          {
            bdnw.b("EngineInstaller", "[MiniEng] removeOutDatedPersistEngine " + localInstalledEngine + " localMinVer:" + localEngineVersion + ",engineType:" + paramInt);
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
    return (localEngineVersion != null) && (localEngineVersion.equals(bdou.a().jdField_a_of_type_ComTencentQqminiSdkManagerEngineVersion)) && (a(paramFile));
  }
  
  private void c()
  {
    try
    {
      this.jdField_a_of_type_Boolean = true;
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        bdol localbdol = (bdol)localIterator.next();
        if (localbdol != null) {
          localbdol.b();
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
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        bdol localbdol = (bdol)localIterator.next();
        if (localbdol != null) {
          localbdol.c();
        }
      }
    }
    finally {}
  }
  
  public void a(bdol parambdol)
  {
    try
    {
      this.b.add(parambdol);
      return;
    }
    finally
    {
      parambdol = finally;
      throw parambdol;
    }
  }
  
  public void a(BaseLibInfo paramBaseLibInfo, bdol parambdol)
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
        if (parambdol != null) {
          a(parambdol);
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramBaseLibInfo.baseLibVersion)) && (paramBaseLibInfo.baseLibType > 0)) {
          continue;
        }
        bdnw.c("EngineInstaller", "[MiniEng] invalid BaseLibInfo " + paramBaseLibInfo);
        b();
      }
      finally
      {
        try
        {
          JSONObject localJSONObject = new JSONObject(paramBaseLibInfo.baseLibDesc);
          localEngineVersion = new EngineVersion(paramBaseLibInfo.baseLibVersion);
          l = localJSONObject.optLong("file_length");
          bdnw.c("EngineInstaller", "[MiniEng] installWithCallback " + paramBaseLibInfo);
          if (a() != null) {
            break label242;
          }
          bdnw.c("EngineInstaller", "[MiniEng] shared preference not supported");
          b();
        }
        catch (Exception parambdol)
        {
          bdnw.c("EngineInstaller", "[MiniEng] refuse installEngine " + paramBaseLibInfo.baseLibDesc + ":" + paramBaseLibInfo.baseLibVersion + paramBaseLibInfo.baseLibUrl + bdyl.a(parambdol));
          b();
        }
        paramBaseLibInfo = finally;
      }
      return;
      localFile = new File(a(), String.valueOf(paramBaseLibInfo.baseLibType));
      continue;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        bdnw.d("EngineInstaller", "[MiniEng] empty engine url");
        b();
      }
      else if (a())
      {
        bdnw.b("EngineInstaller", "[MiniEng] downloading already in progress");
        b();
      }
      else
      {
        bool1 = false;
        bdnw.b("EngineInstaller", "[MiniEng] installWithCallback callback=" + parambdol);
        if ((paramBaseLibInfo.baseLibType == 2) && (!bdou.a().a()) && (!paramBaseLibInfo.baseLibUrl.startsWith("assets://")))
        {
          parambdol = bdou.a().jdField_a_of_type_ComTencentQqminiSdkManagerEngineVersion;
          if (parambdol.a(localEngineVersion) >= 0)
          {
            bdnw.b("EngineInstaller", "[MiniEng] refuse install remote baselib:" + localEngineVersion + ",local:" + parambdol);
            b();
            continue;
          }
        }
        parambdol = a(paramBaseLibInfo.baseLibType);
        bdnw.b("EngineInstaller", "[MiniEng] engineForType " + paramBaseLibInfo.baseLibType + ", size=" + parambdol.size());
        if (parambdol.size() <= 0) {
          break;
        }
        parambdol = (InstalledEngine)parambdol.get(0);
        bdnw.b("EngineInstaller", "[MiniEng]latest engine for type " + paramBaseLibInfo.baseLibType + "," + parambdol);
        if (parambdol.jdField_a_of_type_ComTencentQqminiSdkManagerEngineVersion.a(localEngineVersion) < 0) {
          break label1100;
        }
        bdnw.b("EngineInstaller", "[MiniEng]engine type " + paramBaseLibInfo.baseLibType + " has no update, remote:" + localEngineVersion + ",latest:" + parambdol);
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
          bdnw.b("EngineInstaller", "[MiniEng] installEngine " + (String)localObject);
          if ((localFile.exists()) || (localFile.mkdirs())) {
            break label739;
          }
          bdnw.b("EngineInstaller", "[MiniEng] mkdir failed, is disk writable? " + localFile.getAbsolutePath());
          d();
          break;
          a(0.0F, "下载引擎(" + paramBaseLibInfo.baseLibVersion + ")");
        }
        label739:
        boolean bool2 = false;
        parambdol = null;
        if (paramBaseLibInfo.baseLibType == 2)
        {
          bool2 = paramBaseLibInfo.baseLibUrl.startsWith("assets://");
          paramBaseLibInfo.baseLibUrl.replace("assets://", "");
          parambdol = new long[1];
          parambdol[0] = 0L;
        }
        if (!bool2) {
          break label1083;
        }
        try
        {
          a(0.0F, "正在解压缩本地引擎");
          paramBaseLibInfo = a(localFile, localEngineVersion);
          bdnw.b("EngineInstaller", "[MiniEng] installLocalEngine start url=" + (String)localObject + ",installBasePath=" + paramBaseLibInfo);
          if (TextUtils.isEmpty(paramBaseLibInfo))
          {
            a(0.0F, "本地引擎安装失败, 目录为空");
            bdnw.d("EngineInstaller", "[MiniEng] installLocalEngine failed installBasePath=" + paramBaseLibInfo);
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
        bdnw.d("EngineInstaller", "[MiniEng] installLocalEngine failed targetPath=" + localObject);
        d();
        break;
      }
      bdoa.a().a();
      bdnw.b("EngineInstaller", "[MiniEng] installLocalEngine finish copied " + parambdol[0] + "<>" + l);
      if ((parambdol[0] == l) || (l < 0L))
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
  
  public void b(bdol parambdol)
  {
    try
    {
      this.b.remove(parambdol);
      return;
    }
    finally
    {
      parambdol = finally;
      throw parambdol;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdoi
 * JD-Core Version:    0.7.0.1
 */