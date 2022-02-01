package com.tencent.hydevteam.pluginframework.pluginmanager;

import android.content.Context;
import com.tencent.hydevteam.common.annotation.API;
import com.tencent.hydevteam.common.classloader.ApkClassLoader;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import java.io.File;
import java.io.IOException;
import java.util.List;

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
  private boolean j;
  
  public UpgradeablePluginManager(File paramFile, String paramString, boolean paramBoolean)
  {
    this.a = paramFile;
    this.i = paramString;
    this.b = new File(this.a, "PluginManager_" + paramString);
    this.f = new File(this.b, "pluginmanager1_4.apk");
    this.j = paramBoolean;
  }
  
  private String a(File arg1, File paramFile2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("使用").append(this.f.getAbsolutePath()).append(".");
    Object localObject = h;
    if ((paramFile2.exists()) && (!paramFile2.isDirectory())) {
      throw new IOException(paramFile2.getAbsolutePath() + "已存在且不是目录");
    }
    if (paramInt == 1)
    {
      paramFile2.mkdirs();
      MinFileUtils.c(paramFile2);
    }
    paramFile2 = new ApkClassLoader(???.getAbsolutePath(), paramFile2.getAbsolutePath(), null, UpgradeablePluginManager.class.getClassLoader(), (String[])localObject);
    localObject = (Downloader)paramFile2.a(Downloader.class, "com.tencent.hydevteam.pluginframework.pluginmanager.DownloaderImpl");
    VersionChecker localVersionChecker = (VersionChecker)paramFile2.a(VersionChecker.class, "com.tencent.hydevteam.pluginframework.pluginmanager.VersionCheckerImpl");
    synchronized (this.d)
    {
      File localFile = this.a;
      this.c = ((PluginManager)paramFile2.a(PluginManager.class, "com.tencent.hydevteam.pluginframework.pluginmanager.PluginManagerImpl", new Class[] { File.class, Downloader.class, VersionChecker.class }, new Object[] { localFile, localObject, localVersionChecker }));
      return localStringBuilder.toString();
    }
  }
  
  /* Error */
  @API
  public final List<InstalledPlugin> getCachedLatestPlugin(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 75	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:d	Ljava/lang/Object;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: iconst_0
    //   8: istore_2
    //   9: aload_0
    //   10: getfield 148	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:c	Lcom/tencent/hydevteam/pluginframework/pluginmanager/PluginManager;
    //   13: astore 4
    //   15: aload 4
    //   17: ifnonnull +9 -> 26
    //   20: iconst_1
    //   21: istore_2
    //   22: aload_0
    //   23: invokevirtual 155	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:initWithoutUpgrade	()V
    //   26: aload_0
    //   27: getfield 148	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:c	Lcom/tencent/hydevteam/pluginframework/pluginmanager/PluginManager;
    //   30: aload_1
    //   31: invokeinterface 157 2 0
    //   36: astore_1
    //   37: iload_2
    //   38: ifeq +8 -> 46
    //   41: aload_0
    //   42: aconst_null
    //   43: putfield 148	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:c	Lcom/tencent/hydevteam/pluginframework/pluginmanager/PluginManager;
    //   46: aload_3
    //   47: monitorexit
    //   48: aload_1
    //   49: areturn
    //   50: astore_1
    //   51: aload_3
    //   52: monitorexit
    //   53: aconst_null
    //   54: areturn
    //   55: astore_1
    //   56: aload_3
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	UpgradeablePluginManager
    //   0	60	1	paramString	String
    //   8	30	2	k	int
    //   4	53	3	localObject	Object
    //   13	3	4	localPluginManager	PluginManager
    // Exception table:
    //   from	to	target	type
    //   22	26	50	java/lang/Exception
    //   9	15	55	finally
    //   22	26	55	finally
    //   26	37	55	finally
    //   41	46	55	finally
    //   46	48	55	finally
    //   51	53	55	finally
    //   56	58	55	finally
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
    File localFile2 = new File(e, "pluginmanager1_4.apk");
    File localFile1;
    if (localFile2.exists()) {
      localFile1 = new File(this.b, "pluginmanager1_4_odex");
    }
    for (int k = 1;; k = -1)
    {
      a(localFile2, localFile1, k);
      return;
      localFile2 = this.f;
      localFile1 = new File(localFile2.getParentFile(), "pluginmanager1_4_odex");
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
  
  /* Error */
  @API
  public int upgradeIfNeededThenInit(long paramLong, java.util.concurrent.TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: new 37	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   7: astore 10
    //   9: aconst_null
    //   10: astore 9
    //   12: new 27	java/io/File
    //   15: dup
    //   16: getstatic 35	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:e	Ljava/io/File;
    //   19: ldc 89
    //   21: invokespecial 85	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   24: astore 8
    //   26: aload 8
    //   28: invokevirtual 105	java/io/File:exists	()Z
    //   31: istore 7
    //   33: iload 7
    //   35: ifeq +54 -> 89
    //   38: new 27	java/io/File
    //   41: dup
    //   42: aload_0
    //   43: getfield 87	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:b	Ljava/io/File;
    //   46: ldc 169
    //   48: invokespecial 85	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   51: astore_3
    //   52: aload 10
    //   54: aload 8
    //   56: invokevirtual 99	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   59: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc 188
    //   64: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: iconst_1
    //   69: istore 4
    //   71: aload 10
    //   73: aload_0
    //   74: aload 8
    //   76: aload_3
    //   77: iload 4
    //   79: invokespecial 171	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:a	(Ljava/io/File;Ljava/io/File;I)Ljava/lang/String;
    //   82: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: iload 4
    //   88: ireturn
    //   89: aload_0
    //   90: getfield 91	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:f	Ljava/io/File;
    //   93: invokevirtual 192	java/io/File:lastModified	()J
    //   96: lstore 5
    //   98: lload 5
    //   100: lconst_0
    //   101: lcmp
    //   102: ifeq +7 -> 109
    //   105: ldc2_w 193
    //   108: lstore_1
    //   109: aload_0
    //   110: getfield 93	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:j	Z
    //   113: ifeq +166 -> 279
    //   116: new 37	java/lang/StringBuilder
    //   119: dup
    //   120: ldc 196
    //   122: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   125: aload_0
    //   126: getfield 79	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:i	Ljava/lang/String;
    //   129: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc 198
    //   134: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: astore 8
    //   142: aload_0
    //   143: getfield 91	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:f	Ljava/io/File;
    //   146: astore 11
    //   148: new 27	java/io/File
    //   151: dup
    //   152: aload_0
    //   153: getfield 91	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:f	Ljava/io/File;
    //   156: invokevirtual 175	java/io/File:getParentFile	()Ljava/io/File;
    //   159: ldc 200
    //   161: invokespecial 85	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   164: astore 12
    //   166: new 202	com/tencent/hydevteam/pluginframework/pluginmanager/LengthHashURLConnectionDownloader
    //   169: dup
    //   170: invokespecial 203	com/tencent/hydevteam/pluginframework/pluginmanager/LengthHashURLConnectionDownloader:<init>	()V
    //   173: new 205	com/tencent/hydevteam/pluginframework/pluginmanager/TargetDownloadInfo
    //   176: dup
    //   177: aload 8
    //   179: ldc 207
    //   181: lconst_0
    //   182: invokespecial 210	com/tencent/hydevteam/pluginframework/pluginmanager/TargetDownloadInfo:<init>	(Ljava/lang/String;Ljava/lang/String;J)V
    //   185: aload 11
    //   187: aload 12
    //   189: invokeinterface 214 4 0
    //   194: astore 8
    //   196: aload 10
    //   198: ldc 216
    //   200: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: lload 5
    //   205: invokevirtual 219	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   208: ldc 221
    //   210: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload 8
    //   216: lload_1
    //   217: aload_3
    //   218: invokeinterface 227 4 0
    //   223: checkcast 27	java/io/File
    //   226: astore_3
    //   227: aload 10
    //   229: ldc 229
    //   231: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: iconst_1
    //   236: istore 4
    //   238: aload_3
    //   239: astore 8
    //   241: new 27	java/io/File
    //   244: dup
    //   245: aload 8
    //   247: invokevirtual 175	java/io/File:getParentFile	()Ljava/io/File;
    //   250: ldc 169
    //   252: invokespecial 85	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   255: astore_3
    //   256: goto -185 -> 71
    //   259: astore 9
    //   261: aconst_null
    //   262: astore_3
    //   263: aload 10
    //   265: aload 9
    //   267: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   270: ldc 101
    //   272: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: goto -205 -> 71
    //   279: new 37	java/lang/StringBuilder
    //   282: dup
    //   283: ldc 196
    //   285: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   288: aload_0
    //   289: getfield 79	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:i	Ljava/lang/String;
    //   292: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: astore 8
    //   300: goto -158 -> 142
    //   303: astore 8
    //   305: aload 9
    //   307: astore_3
    //   308: aload 10
    //   310: aload 8
    //   312: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   315: ldc 101
    //   317: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload_0
    //   322: getfield 91	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:f	Ljava/io/File;
    //   325: astore 8
    //   327: iconst_0
    //   328: istore 4
    //   330: goto -89 -> 241
    //   333: astore 9
    //   335: aconst_null
    //   336: astore 8
    //   338: aconst_null
    //   339: astore_3
    //   340: iconst_m1
    //   341: istore 4
    //   343: goto -80 -> 263
    //   346: astore 9
    //   348: aconst_null
    //   349: astore_3
    //   350: iconst_m1
    //   351: istore 4
    //   353: goto -90 -> 263
    //   356: astore 9
    //   358: iconst_m1
    //   359: istore 4
    //   361: goto -98 -> 263
    //   364: astore 9
    //   366: aload_3
    //   367: astore 8
    //   369: aconst_null
    //   370: astore_3
    //   371: iconst_m1
    //   372: istore 4
    //   374: goto -111 -> 263
    //   377: astore 9
    //   379: iconst_0
    //   380: istore 4
    //   382: aload_3
    //   383: astore 8
    //   385: aconst_null
    //   386: astore_3
    //   387: goto -124 -> 263
    //   390: astore 8
    //   392: goto -84 -> 308
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	395	0	this	UpgradeablePluginManager
    //   0	395	1	paramLong	long
    //   0	395	3	paramTimeUnit	java.util.concurrent.TimeUnit
    //   69	312	4	k	int
    //   96	108	5	l	long
    //   31	3	7	bool	boolean
    //   24	275	8	localObject1	Object
    //   303	8	8	localException1	java.lang.Exception
    //   325	59	8	localObject2	Object
    //   390	1	8	localException2	java.lang.Exception
    //   10	1	9	localObject3	Object
    //   259	47	9	localException3	java.lang.Exception
    //   333	1	9	localException4	java.lang.Exception
    //   346	1	9	localException5	java.lang.Exception
    //   356	1	9	localException6	java.lang.Exception
    //   364	1	9	localException7	java.lang.Exception
    //   377	1	9	localException8	java.lang.Exception
    //   7	302	10	localStringBuilder	StringBuilder
    //   146	40	11	localFile1	File
    //   164	24	12	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   241	256	259	java/lang/Exception
    //   214	227	303	java/lang/Exception
    //   12	33	333	java/lang/Exception
    //   89	98	333	java/lang/Exception
    //   109	142	333	java/lang/Exception
    //   142	214	333	java/lang/Exception
    //   279	300	333	java/lang/Exception
    //   38	52	346	java/lang/Exception
    //   52	68	356	java/lang/Exception
    //   308	321	364	java/lang/Exception
    //   321	327	377	java/lang/Exception
    //   227	235	390	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginmanager.UpgradeablePluginManager
 * JD-Core Version:    0.7.0.1
 */