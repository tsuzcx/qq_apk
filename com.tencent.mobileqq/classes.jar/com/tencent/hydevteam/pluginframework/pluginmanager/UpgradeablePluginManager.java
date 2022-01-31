package com.tencent.hydevteam.pluginframework.pluginmanager;

import android.content.Context;
import com.tencent.hydevteam.common.annotation.API;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import java.io.File;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@API
public class UpgradeablePluginManager
  implements PluginManager
{
  private static final File e = new File("/data/local/tmp");
  private static final String g = UpgradeablePluginManager.class.getSimpleName() + "没有初始化。请先用upgradeIfNeededThenInit方法。";
  private static String[] h = { "com.tencent.hydevteam.common.annotation", "com.tencent.hydevteam.common.progress", "com.tencent.hydevteam.pluginframework.installedplugin", "com.tencent.hydevteam.pluginframework.pluginmanager", "com.tencent.qphone.base.util" };
  private File a;
  private File b;
  private PluginManager c;
  private final Object d = new Object();
  private final File f;
  private final String i;
  
  public UpgradeablePluginManager(File paramFile, String paramString)
  {
    this.a = paramFile;
    this.i = paramString;
    this.b = new File(this.a, "PluginManager_" + paramString);
    this.f = new File(this.b, "pluginmanager1_3.apk");
  }
  
  /* Error */
  private String a(File arg1, File paramFile2, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 35	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: ldc 93
    //   13: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_0
    //   17: getfield 88	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:f	Ljava/io/File;
    //   20: invokevirtual 96	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   23: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc 98
    //   28: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: getstatic 68	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:h	[Ljava/lang/String;
    //   35: astore 6
    //   37: aload_2
    //   38: invokevirtual 102	java/io/File:exists	()Z
    //   41: ifeq +101 -> 142
    //   44: aload_2
    //   45: invokevirtual 105	java/io/File:isDirectory	()Z
    //   48: ifne +94 -> 142
    //   51: new 107	java/io/IOException
    //   54: dup
    //   55: new 35	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   62: aload_2
    //   63: invokevirtual 96	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   66: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc 109
    //   71: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokespecial 110	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   80: athrow
    //   81: astore_1
    //   82: aload_0
    //   83: getfield 73	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:d	Ljava/lang/Object;
    //   86: astore_2
    //   87: aload_2
    //   88: monitorenter
    //   89: aload_0
    //   90: new 112	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager
    //   93: dup
    //   94: aload_0
    //   95: getfield 75	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:a	Ljava/io/File;
    //   98: new 114	com/tencent/hydevteam/pluginframework/pluginmanager/SimpleURLConnectionDownloader
    //   101: dup
    //   102: invokespecial 115	com/tencent/hydevteam/pluginframework/pluginmanager/SimpleURLConnectionDownloader:<init>	()V
    //   105: new 117	com/tencent/hydevteam/pluginframework/pluginmanager/SimpleVersionChecker
    //   108: dup
    //   109: invokespecial 118	com/tencent/hydevteam/pluginframework/pluginmanager/SimpleVersionChecker:<init>	()V
    //   112: aload_0
    //   113: getfield 77	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:i	Ljava/lang/String;
    //   116: invokespecial 121	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager:<init>	(Ljava/io/File;Lcom/tencent/hydevteam/pluginframework/pluginmanager/Downloader;Lcom/tencent/hydevteam/pluginframework/pluginmanager/VersionChecker;Ljava/lang/String;)V
    //   119: putfield 123	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:c	Lcom/tencent/hydevteam/pluginframework/pluginmanager/PluginManager;
    //   122: aload_2
    //   123: monitorexit
    //   124: aload 5
    //   126: aload_1
    //   127: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   130: ldc 98
    //   132: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload 5
    //   138: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: areturn
    //   142: iload 4
    //   144: ifne +8 -> 152
    //   147: iload_3
    //   148: iconst_1
    //   149: if_icmpne +12 -> 161
    //   152: aload_2
    //   153: invokevirtual 129	java/io/File:mkdirs	()Z
    //   156: pop
    //   157: aload_2
    //   158: invokestatic 134	com/tencent/hydevteam/pluginframework/pluginmanager/MinFileUtils:c	(Ljava/io/File;)V
    //   161: new 136	com/tencent/hydevteam/common/classloader/ApkClassLoader
    //   164: dup
    //   165: aload_1
    //   166: invokevirtual 96	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   169: aload_2
    //   170: invokevirtual 96	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   173: aconst_null
    //   174: ldc 2
    //   176: invokevirtual 140	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   179: aload 6
    //   181: invokespecial 143	com/tencent/hydevteam/common/classloader/ApkClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;[Ljava/lang/String;)V
    //   184: astore 6
    //   186: aload 6
    //   188: ldc 145
    //   190: ldc 147
    //   192: invokevirtual 150	com/tencent/hydevteam/common/classloader/ApkClassLoader:a	(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;
    //   195: checkcast 145	com/tencent/hydevteam/pluginframework/pluginmanager/Downloader
    //   198: astore_1
    //   199: aload 6
    //   201: ldc 152
    //   203: ldc 154
    //   205: invokevirtual 150	com/tencent/hydevteam/common/classloader/ApkClassLoader:a	(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;
    //   208: checkcast 152	com/tencent/hydevteam/pluginframework/pluginmanager/VersionChecker
    //   211: astore_2
    //   212: aload_0
    //   213: getfield 73	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:d	Ljava/lang/Object;
    //   216: astore 7
    //   218: aload 7
    //   220: monitorenter
    //   221: aload_0
    //   222: getfield 75	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:a	Ljava/io/File;
    //   225: astore 8
    //   227: aload_0
    //   228: aload 6
    //   230: ldc 6
    //   232: ldc 156
    //   234: iconst_3
    //   235: anewarray 39	java/lang/Class
    //   238: dup
    //   239: iconst_0
    //   240: ldc 25
    //   242: aastore
    //   243: dup
    //   244: iconst_1
    //   245: ldc 145
    //   247: aastore
    //   248: dup
    //   249: iconst_2
    //   250: ldc 152
    //   252: aastore
    //   253: iconst_3
    //   254: anewarray 4	java/lang/Object
    //   257: dup
    //   258: iconst_0
    //   259: aload 8
    //   261: aastore
    //   262: dup
    //   263: iconst_1
    //   264: aload_1
    //   265: aastore
    //   266: dup
    //   267: iconst_2
    //   268: aload_2
    //   269: aastore
    //   270: invokevirtual 159	com/tencent/hydevteam/common/classloader/ApkClassLoader:a	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   273: checkcast 6	com/tencent/hydevteam/pluginframework/pluginmanager/PluginManager
    //   276: putfield 123	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:c	Lcom/tencent/hydevteam/pluginframework/pluginmanager/PluginManager;
    //   279: aload 7
    //   281: monitorexit
    //   282: goto -146 -> 136
    //   285: astore 6
    //   287: aload 7
    //   289: monitorexit
    //   290: aload 6
    //   292: athrow
    //   293: astore 6
    //   295: aload 5
    //   297: aload 6
    //   299: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   302: ldc 98
    //   304: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload_0
    //   309: getfield 73	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:d	Ljava/lang/Object;
    //   312: astore 6
    //   314: aload 6
    //   316: monitorenter
    //   317: aload_0
    //   318: new 112	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager
    //   321: dup
    //   322: aload_0
    //   323: getfield 75	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:a	Ljava/io/File;
    //   326: aload_1
    //   327: aload_2
    //   328: aload_0
    //   329: getfield 77	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:i	Ljava/lang/String;
    //   332: invokespecial 121	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager:<init>	(Ljava/io/File;Lcom/tencent/hydevteam/pluginframework/pluginmanager/Downloader;Lcom/tencent/hydevteam/pluginframework/pluginmanager/VersionChecker;Ljava/lang/String;)V
    //   335: putfield 123	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:c	Lcom/tencent/hydevteam/pluginframework/pluginmanager/PluginManager;
    //   338: aload 6
    //   340: monitorexit
    //   341: goto -205 -> 136
    //   344: astore_1
    //   345: aload 6
    //   347: monitorexit
    //   348: aload_1
    //   349: athrow
    //   350: astore 7
    //   352: new 114	com/tencent/hydevteam/pluginframework/pluginmanager/SimpleURLConnectionDownloader
    //   355: dup
    //   356: invokespecial 115	com/tencent/hydevteam/pluginframework/pluginmanager/SimpleURLConnectionDownloader:<init>	()V
    //   359: astore_1
    //   360: new 117	com/tencent/hydevteam/pluginframework/pluginmanager/SimpleVersionChecker
    //   363: dup
    //   364: invokespecial 118	com/tencent/hydevteam/pluginframework/pluginmanager/SimpleVersionChecker:<init>	()V
    //   367: astore_2
    //   368: aload 5
    //   370: aload 7
    //   372: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   375: ldc 98
    //   377: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: pop
    //   381: goto -169 -> 212
    //   384: astore_1
    //   385: aload_2
    //   386: monitorexit
    //   387: aload_1
    //   388: athrow
    //   389: astore_1
    //   390: goto -5 -> 385
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	393	0	this	UpgradeablePluginManager
    //   0	393	2	paramFile2	File
    //   0	393	3	paramInt	int
    //   0	393	4	paramBoolean	boolean
    //   7	362	5	localStringBuilder	StringBuilder
    //   35	194	6	localObject1	Object
    //   285	6	6	localObject2	Object
    //   293	5	6	localException1	Exception
    //   312	34	6	localObject3	Object
    //   216	72	7	localObject4	Object
    //   350	21	7	localException2	Exception
    //   225	35	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   9	81	81	java/lang/Exception
    //   152	161	81	java/lang/Exception
    //   161	186	81	java/lang/Exception
    //   295	317	81	java/lang/Exception
    //   348	350	81	java/lang/Exception
    //   352	381	81	java/lang/Exception
    //   221	282	285	finally
    //   287	290	285	finally
    //   212	221	293	java/lang/Exception
    //   290	293	293	java/lang/Exception
    //   317	341	344	finally
    //   345	348	344	finally
    //   186	212	350	java/lang/Exception
    //   89	124	384	finally
    //   385	387	389	finally
  }
  
  @API
  public final List<InstalledPlugin> getCachedLatestPlugin(String paramString)
  {
    Object localObject = this.d;
    int j = 0;
    try
    {
      if (this.c == null)
      {
        j = 1;
        initWithoutUpgrade();
      }
      paramString = this.c.getCachedLatestPlugin(paramString);
      if (j != 0) {
        this.c = null;
      }
      return paramString;
    }
    finally {}
  }
  
  @API
  public final VersionChecker getVersionChecker()
  {
    synchronized (this.d)
    {
      if (this.c != null)
      {
        VersionChecker localVersionChecker = this.c.getVersionChecker();
        return localVersionChecker;
      }
      throw new IllegalStateException(g);
    }
  }
  
  @API
  public void initWithoutUpgrade()
  {
    File localFile2 = new File(e, "pluginmanager1_3.apk");
    boolean bool;
    if (localFile2.exists()) {
      bool = true;
    }
    for (File localFile1 = new File(this.b, "pluginmanager1_3_odex");; localFile1 = new File(localFile2.getParentFile(), "pluginmanager1_3_odex"))
    {
      a(localFile2, localFile1, -1, bool);
      return;
      bool = false;
      localFile2 = this.f;
    }
  }
  
  @API
  public final ProgressFuture preloadApk(Context paramContext, InstalledPlugin paramInstalledPlugin, boolean paramBoolean)
  {
    synchronized (this.d)
    {
      if (this.c != null)
      {
        paramContext = this.c.preloadApk(paramContext, paramInstalledPlugin, paramBoolean);
        return paramContext;
      }
      throw new IllegalStateException(g);
    }
  }
  
  @API
  public final List<ProgressFuture<InstalledPlugin>> updatePlugin(String paramString1, TargetDownloadInfo paramTargetDownloadInfo, String paramString2)
  {
    synchronized (this.d)
    {
      if (this.c != null)
      {
        paramString1 = this.c.updatePlugin(paramString1, paramTargetDownloadInfo, paramString2);
        return paramString1;
      }
      throw new IllegalStateException(g);
    }
  }
  
  @API
  public int upgradeIfNeededThenInit(long paramLong, TimeUnit paramTimeUnit)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject5 = null;
    Object localObject2 = null;
    localObject4 = null;
    int j = -1;
    Object localObject1 = localObject5;
    int k = j;
    for (;;)
    {
      try
      {
        localObject6 = new File(e, "pluginmanager1_3.apk");
        localObject1 = localObject5;
        k = j;
        if (((File)localObject6).exists())
        {
          bool = true;
          paramTimeUnit = (TimeUnit)localObject6;
          localObject1 = paramTimeUnit;
          k = j;
          localObject2 = new File(this.b, "pluginmanager1_3_odex");
        }
      }
      catch (Exception localException2)
      {
        Object localObject6;
        long l1;
        long l2;
        File localFile1;
        File localFile2;
        j = k;
        paramTimeUnit = localObject4;
      }
      try
      {
        localStringBuilder.append(((File)localObject6).getAbsolutePath()).append("存在.");
        localObject1 = paramTimeUnit;
        localStringBuilder.append(a((File)localObject1, (File)localObject2, j, bool));
        return j;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localObject4 = localObject3;
          Object localObject3 = localException1;
          TimeUnit localTimeUnit = paramTimeUnit;
          paramTimeUnit = localObject4;
        }
      }
      boolean bool = false;
      localObject1 = localObject5;
      k = j;
      l1 = this.f.lastModified();
      localObject1 = localObject5;
      k = j;
      l2 = System.currentTimeMillis();
      if ((l1 == 0L) || (l1 > l2) || (l2 - l1 > 86400000L))
      {
        localObject1 = localObject5;
        k = j;
        this.f.lastModified();
        localObject1 = localObject5;
        k = j;
        localObject6 = "http://dldir1.qq.com/huayang/Android/PluginManager1_3_" + this.i;
        localObject1 = localObject5;
        k = j;
        localFile1 = this.f;
        localObject1 = localObject5;
        k = j;
        localFile2 = new File(this.f.getParentFile(), "pluginmanager1_3.apk.downloading");
        localObject1 = localObject5;
        k = j;
        localObject6 = new SimpleURLConnectionDownloader().download(new TargetDownloadInfo((String)localObject6, "", 0L), localFile1, localFile2);
        localObject1 = localObject5;
        k = j;
        localStringBuilder.append("lastModified==").append(l1).append("开始下载.");
        try
        {
          paramTimeUnit = (File)((Future)localObject6).get(paramLong, paramTimeUnit);
          localObject2 = paramTimeUnit;
          localStringBuilder.append("下载完成.");
          j = 1;
        }
        catch (Exception paramTimeUnit)
        {
          localObject1 = localObject2;
          k = j;
          localStringBuilder.append(paramTimeUnit).append(".");
          j = 0;
          paramTimeUnit = (TimeUnit)localObject2;
          continue;
        }
        localObject1 = paramTimeUnit;
        k = j;
        localObject2 = new File(paramTimeUnit.getParentFile(), "pluginmanager1_3_odex");
        localObject1 = paramTimeUnit;
        continue;
      }
      localObject1 = localObject5;
      k = j;
      paramTimeUnit = this.f;
      continue;
      bool = false;
      localStringBuilder.append(localException2).append(".");
      localObject3 = paramTimeUnit;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginmanager.UpgradeablePluginManager
 * JD-Core Version:    0.7.0.1
 */