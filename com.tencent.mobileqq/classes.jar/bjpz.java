import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.plugin.PluginRecord;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class bjpz
{
  public static String a;
  public static final String[] a;
  public static final String b = a(jdField_a_of_type_ArrayOfJavaLangString[0]);
  public static final String c = a(jdField_a_of_type_ArrayOfJavaLangString[1]);
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "image_filter_common", "image_filter_gpu", "format_convert", "ParticleSystem", "pitu_tools", "YTCommon", "YTIllumination", "YTFaceTrackPro", "algo_youtu_jni" };
  }
  
  public static int a()
  {
    int i = QzoneConfig.getInstance().getConfig("LiveSetting", "useQQPluginManager", 1);
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "[useLocalLivePlugin] value=" + i);
    }
    return i;
  }
  
  /* Error */
  public static PluginRecord a(File paramFile)
  {
    // Byte code:
    //   0: new 93	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 96	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_2
    //   9: aload_2
    //   10: astore_1
    //   11: aload_0
    //   12: invokevirtual 102	java/io/File:length	()J
    //   15: l2i
    //   16: newarray byte
    //   18: astore_0
    //   19: aload_2
    //   20: astore_1
    //   21: aload_2
    //   22: aload_0
    //   23: invokevirtual 106	java/io/FileInputStream:read	([B)I
    //   26: pop
    //   27: aload_2
    //   28: astore_1
    //   29: new 13	java/lang/String
    //   32: dup
    //   33: aload_0
    //   34: iconst_0
    //   35: invokestatic 112	bdfr:decode	([BI)[B
    //   38: invokespecial 115	java/lang/String:<init>	([B)V
    //   41: astore_3
    //   42: aload_2
    //   43: astore_1
    //   44: new 117	cooperation/qzone/plugin/PluginRecord
    //   47: dup
    //   48: invokespecial 118	cooperation/qzone/plugin/PluginRecord:<init>	()V
    //   51: astore_0
    //   52: aload_2
    //   53: astore_1
    //   54: aload_0
    //   55: aload_3
    //   56: invokevirtual 122	cooperation/qzone/plugin/PluginRecord:fromJson	(Ljava/lang/String;)V
    //   59: aload_0
    //   60: astore_1
    //   61: aload_2
    //   62: ifnull +9 -> 71
    //   65: aload_2
    //   66: invokevirtual 125	java/io/FileInputStream:close	()V
    //   69: aload_0
    //   70: astore_1
    //   71: aload_1
    //   72: areturn
    //   73: astore_1
    //   74: aload_1
    //   75: invokevirtual 128	java/io/IOException:printStackTrace	()V
    //   78: aload_0
    //   79: areturn
    //   80: astore_3
    //   81: aconst_null
    //   82: astore_2
    //   83: aconst_null
    //   84: astore_0
    //   85: aload_2
    //   86: astore_1
    //   87: aload_3
    //   88: invokevirtual 129	java/io/FileNotFoundException:printStackTrace	()V
    //   91: aload_0
    //   92: astore_1
    //   93: aload_2
    //   94: ifnull -23 -> 71
    //   97: aload_2
    //   98: invokevirtual 125	java/io/FileInputStream:close	()V
    //   101: aload_0
    //   102: areturn
    //   103: astore_1
    //   104: aload_1
    //   105: invokevirtual 128	java/io/IOException:printStackTrace	()V
    //   108: aload_0
    //   109: areturn
    //   110: astore_3
    //   111: aconst_null
    //   112: astore_2
    //   113: aconst_null
    //   114: astore_0
    //   115: aload_2
    //   116: astore_1
    //   117: aload_3
    //   118: invokevirtual 128	java/io/IOException:printStackTrace	()V
    //   121: aload_0
    //   122: astore_1
    //   123: aload_2
    //   124: ifnull -53 -> 71
    //   127: aload_2
    //   128: invokevirtual 125	java/io/FileInputStream:close	()V
    //   131: aload_0
    //   132: areturn
    //   133: astore_1
    //   134: aload_1
    //   135: invokevirtual 128	java/io/IOException:printStackTrace	()V
    //   138: aload_0
    //   139: areturn
    //   140: astore_0
    //   141: aconst_null
    //   142: astore_1
    //   143: aload_1
    //   144: ifnull +7 -> 151
    //   147: aload_1
    //   148: invokevirtual 125	java/io/FileInputStream:close	()V
    //   151: aload_0
    //   152: athrow
    //   153: astore_1
    //   154: aload_1
    //   155: invokevirtual 128	java/io/IOException:printStackTrace	()V
    //   158: goto -7 -> 151
    //   161: astore_0
    //   162: goto -19 -> 143
    //   165: astore_3
    //   166: aconst_null
    //   167: astore_0
    //   168: goto -53 -> 115
    //   171: astore_3
    //   172: goto -57 -> 115
    //   175: astore_3
    //   176: aconst_null
    //   177: astore_0
    //   178: goto -93 -> 85
    //   181: astore_3
    //   182: goto -97 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	paramFile	File
    //   10	62	1	localObject1	Object
    //   73	2	1	localIOException1	java.io.IOException
    //   86	7	1	localObject2	Object
    //   103	2	1	localIOException2	java.io.IOException
    //   116	7	1	localObject3	Object
    //   133	2	1	localIOException3	java.io.IOException
    //   142	6	1	localObject4	Object
    //   153	2	1	localIOException4	java.io.IOException
    //   8	120	2	localFileInputStream	java.io.FileInputStream
    //   41	15	3	str	String
    //   80	8	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   110	8	3	localIOException5	java.io.IOException
    //   165	1	3	localIOException6	java.io.IOException
    //   171	1	3	localIOException7	java.io.IOException
    //   175	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   181	1	3	localFileNotFoundException3	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   65	69	73	java/io/IOException
    //   0	9	80	java/io/FileNotFoundException
    //   97	101	103	java/io/IOException
    //   0	9	110	java/io/IOException
    //   127	131	133	java/io/IOException
    //   0	9	140	finally
    //   147	151	153	java/io/IOException
    //   11	19	161	finally
    //   21	27	161	finally
    //   29	42	161	finally
    //   44	52	161	finally
    //   54	59	161	finally
    //   87	91	161	finally
    //   117	121	161	finally
    //   11	19	165	java/io/IOException
    //   21	27	165	java/io/IOException
    //   29	42	165	java/io/IOException
    //   44	52	165	java/io/IOException
    //   54	59	171	java/io/IOException
    //   11	19	175	java/io/FileNotFoundException
    //   21	27	175	java/io/FileNotFoundException
    //   29	42	175	java/io/FileNotFoundException
    //   44	52	175	java/io/FileNotFoundException
    //   54	59	181	java/io/FileNotFoundException
  }
  
  public static File a(Context paramContext)
  {
    return PluginUtils.getPluginInstallDir(paramContext);
  }
  
  public static File a(Context paramContext, String paramString)
  {
    return new File(a(paramContext), paramString);
  }
  
  public static String a()
  {
    int j = 0;
    int i = 0;
    Object localObject;
    if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      localObject = jdField_a_of_type_JavaLangString;
      return localObject;
    }
    String str = LocalMultiProcConfig.getString("qzone_live_pluginid", "qzone_live_video_plugin_hack.apk");
    int k = a();
    if ((k == 0) && (!"qzone_live_video_plugin_hack.apk".equals(str)))
    {
      localObject = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses();
      for (;;)
      {
        if (i >= ((List)localObject).size()) {
          break label138;
        }
        if ("com.tencent.mobileqq:qzonelive".equals(((ActivityManager.RunningAppProcessInfo)((List)localObject).get(i)).processName))
        {
          localObject = str;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("QZonePluginManger", 2, "切换时 qzonelive 进程存在 pluginid 保持不变，getLoadQZoneLivePluginId:" + str);
          return str;
        }
        i += 1;
      }
      label138:
      str = "qzone_live_video_plugin_hack.apk";
      LocalMultiProcConfig.putString("qzone_live_pluginid", "qzone_live_video_plugin_hack.apk");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZonePluginManger", 2, "getLoadQZoneLivePluginId:" + str);
      }
      jdField_a_of_type_JavaLangString = str;
      return str;
      if ((k == 1) && (!"qzone_live_video_plugin.apk".equals(str)))
      {
        localObject = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses();
        i = j;
        for (;;)
        {
          if (i >= ((List)localObject).size()) {
            break label293;
          }
          if ("com.tencent.mobileqq:qzonelive".equals(((ActivityManager.RunningAppProcessInfo)((List)localObject).get(i)).processName))
          {
            localObject = str;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("QZonePluginManger", 2, "切换时 qzonelive 进程存在 pluginid 保持不变，getLoadQZoneLivePluginId:" + str);
            return str;
          }
          i += 1;
        }
        label293:
        str = "qzone_live_video_plugin.apk";
        LocalMultiProcConfig.putString("qzone_live_pluginid", "qzone_live_video_plugin.apk");
      }
    }
  }
  
  public static String a(Context paramContext)
  {
    String str = "/app_lib/qzone_live_video_plugin_hack/";
    if ("qzone_live_video_plugin.apk".equals(a())) {
      str = "/app_lib/qzone_live_video_plugin/";
    }
    paramContext = paramContext.getFilesDir();
    if (paramContext != null) {
      return paramContext.getParent() + str + "/PTBase/";
    }
    return null;
  }
  
  private static String a(String paramString)
  {
    return "lib" + paramString + ".so";
  }
  
  public static void a(Context paramContext, Map<String, PluginRecord> paramMap)
  {
    int j = 0;
    int i = 0;
    Object localObject = paramContext.getDir("qzone_plugin_info", 0);
    boolean bool = birf.a((File)localObject);
    paramContext = a((File)localObject);
    if (paramContext != null)
    {
      if (!bool) {
        break label72;
      }
      j = paramContext.length;
      while (i < j)
      {
        paramMap = paramContext[i];
        if (paramMap.exists()) {
          paramMap.delete();
        }
        i += 1;
      }
      birf.a((File)localObject);
    }
    for (;;)
    {
      return;
      label72:
      int k = paramContext.length;
      i = j;
      while (i < k)
      {
        localObject = paramContext[i];
        if (((File)localObject).exists())
        {
          localObject = a((File)localObject);
          if (localObject != null) {
            paramMap.put(((PluginRecord)localObject).id, localObject);
          }
        }
        i += 1;
      }
    }
  }
  
  public static void a(Context paramContext, Map<String, PluginRecord> paramMap, bjpn parambjpn)
  {
    paramContext = a(paramContext.getDir("qzone_installed_plugin", 0));
    if (paramContext != null)
    {
      int j = paramContext.length;
      int i = 0;
      if (i < j)
      {
        File localFile = paramContext[i];
        if (localFile.exists())
        {
          PluginRecord localPluginRecord = a(localFile);
          if (localPluginRecord != null)
          {
            boolean bool = true;
            if (parambjpn != null) {
              bool = parambjpn.a(localPluginRecord, localFile);
            }
            if (!bool) {
              break label98;
            }
            paramMap.put(localPluginRecord.id, localPluginRecord);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label98:
          localFile.delete();
        }
      }
    }
  }
  
  public static void a(PluginRecord paramPluginRecord)
  {
    try
    {
      File localFile = c(BaseApplicationImpl.getContext(), paramPluginRecord.id);
      if ((localFile.isFile()) && (localFile.exists()))
      {
        localFile.delete();
        localFile.createNewFile();
      }
      a(localFile, paramPluginRecord);
      return;
    }
    catch (Exception paramPluginRecord)
    {
      QLog.e("QZonePluginManger", 1, "savePluginInfo", paramPluginRecord);
    }
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool2 = false;
    paramContext = a(paramContext);
    boolean bool3 = b(paramContext + b);
    boolean bool4 = b(paramContext + c);
    boolean bool5 = b(paramContext + "libformat_convert.so");
    boolean bool6 = b(paramContext + "libpitu_tools.so");
    int i = LocalMultiProcConfig.getInt("QzoneLiveSoVersion", 0);
    int j = QzoneConfig.getInstance().getConfig("LiveSetting", "LivePluginSOVersion", 5);
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (bool4)
      {
        bool1 = bool2;
        if (bool5)
        {
          bool1 = bool2;
          if (bool6)
          {
            bool1 = bool2;
            if (i == j) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  static boolean a(PluginRecord paramPluginRecord, Context paramContext)
  {
    if ((paramPluginRecord == null) || (paramContext == null)) {
      return false;
    }
    if (TextUtils.isEmpty(paramPluginRecord.mProcesses)) {
      return false;
    }
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (paramPluginRecord.mProcesses.equalsIgnoreCase(localRunningAppProcessInfo.processName)) {
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  private static boolean a(File paramFile, PluginRecord paramPluginRecord)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 4
    //   8: aload_1
    //   9: invokevirtual 343	cooperation/qzone/plugin/PluginRecord:toJson	()Ljava/lang/String;
    //   12: astore 6
    //   14: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +29 -> 46
    //   20: ldc 64
    //   22: iconst_2
    //   23: new 66	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   30: ldc_w 345
    //   33: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_1
    //   37: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: aload 6
    //   48: invokevirtual 352	java/lang/String:getBytes	()[B
    //   51: iconst_0
    //   52: invokestatic 355	bdfr:encode	([BI)[B
    //   55: astore_1
    //   56: new 357	java/io/FileOutputStream
    //   59: dup
    //   60: aload_0
    //   61: invokespecial 358	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   64: astore_0
    //   65: aload_0
    //   66: aload_1
    //   67: invokevirtual 361	java/io/FileOutputStream:write	([B)V
    //   70: iconst_1
    //   71: istore_3
    //   72: iload_3
    //   73: istore_2
    //   74: aload_0
    //   75: ifnull +9 -> 84
    //   78: aload_0
    //   79: invokevirtual 362	java/io/FileOutputStream:close	()V
    //   82: iload_3
    //   83: istore_2
    //   84: iload_2
    //   85: ireturn
    //   86: astore_0
    //   87: aload 4
    //   89: astore_0
    //   90: aload_0
    //   91: ifnull -7 -> 84
    //   94: aload_0
    //   95: invokevirtual 362	java/io/FileOutputStream:close	()V
    //   98: iconst_0
    //   99: ireturn
    //   100: astore_0
    //   101: iconst_0
    //   102: ireturn
    //   103: astore_0
    //   104: aload 5
    //   106: astore_1
    //   107: aload_1
    //   108: ifnull +7 -> 115
    //   111: aload_1
    //   112: invokevirtual 362	java/io/FileOutputStream:close	()V
    //   115: aload_0
    //   116: athrow
    //   117: astore_0
    //   118: iconst_1
    //   119: ireturn
    //   120: astore_1
    //   121: goto -6 -> 115
    //   124: astore 4
    //   126: aload_0
    //   127: astore_1
    //   128: aload 4
    //   130: astore_0
    //   131: goto -24 -> 107
    //   134: astore_1
    //   135: goto -45 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	paramFile	File
    //   0	138	1	paramPluginRecord	PluginRecord
    //   1	84	2	bool1	boolean
    //   71	12	3	bool2	boolean
    //   6	82	4	localObject1	Object
    //   124	5	4	localObject2	Object
    //   3	102	5	localObject3	Object
    //   12	35	6	str	String
    // Exception table:
    //   from	to	target	type
    //   8	46	86	java/lang/Exception
    //   46	65	86	java/lang/Exception
    //   94	98	100	java/io/IOException
    //   8	46	103	finally
    //   46	65	103	finally
    //   78	82	117	java/io/IOException
    //   111	115	120	java/io/IOException
    //   65	70	124	finally
    //   65	70	134	java/lang/Exception
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      Object localObject = (ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity");
      if (localObject != null)
      {
        localObject = ((ActivityManager)localObject).getRunningAppProcesses();
        if (localObject != null)
        {
          int i = 0;
          while (i < ((List)localObject).size())
          {
            if (paramString.equals(((ActivityManager.RunningAppProcessInfo)((List)localObject).get(i)).processName)) {
              return true;
            }
            i += 1;
          }
        }
      }
    }
  }
  
  public static File[] a(File paramFile)
  {
    return paramFile.listFiles(new bjqa());
  }
  
  public static File b(Context paramContext, String paramString)
  {
    return PluginUtils.getPluginLibPath(paramContext, paramString);
  }
  
  public static void b(PluginRecord paramPluginRecord)
  {
    try
    {
      File localFile = d(BaseApplicationImpl.getContext(), paramPluginRecord.id);
      if ((localFile.isFile()) && (localFile.exists()))
      {
        localFile.delete();
        localFile.createNewFile();
      }
      a(localFile, paramPluginRecord);
      return;
    }
    catch (Exception paramPluginRecord)
    {
      QLog.e("QZonePluginManger", 1, "saveInstalledPluginInfo", paramPluginRecord);
    }
  }
  
  public static boolean b(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((paramString == null) || (!paramString.exists()));
    return true;
  }
  
  public static File c(Context paramContext, String paramString)
  {
    return new File(paramContext.getDir("qzone_plugin_info", 0), paramString + ".cfg");
  }
  
  public static void c(PluginRecord paramPluginRecord)
  {
    try
    {
      paramPluginRecord = d(BaseApplicationImpl.getContext(), paramPluginRecord.id);
      if ((paramPluginRecord.isFile()) && (paramPluginRecord.exists())) {
        paramPluginRecord.delete();
      }
      return;
    }
    catch (Exception paramPluginRecord) {}
  }
  
  public static File d(Context paramContext, String paramString)
  {
    return new File(paramContext.getDir("qzone_installed_plugin", 0), paramString + ".cfg");
  }
  
  public static File e(Context paramContext, String paramString)
  {
    return new File(paramContext.getDir("qzone_downloaded_plugins", 0), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjpz
 * JD-Core Version:    0.7.0.1
 */