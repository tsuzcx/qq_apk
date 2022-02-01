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
  private static final String g;
  private static String[] h = { "com.tencent.hydevteam.common.annotation", "com.tencent.hydevteam.common.progress", "com.tencent.hydevteam.pluginframework.installedplugin", "com.tencent.hydevteam.pluginframework.pluginmanager", "com.tencent.qphone.base.util" };
  private File a;
  private File b;
  private PluginManager c;
  private final Object d = new Object();
  private final File f;
  private final String i;
  private boolean j;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(UpgradeablePluginManager.class.getSimpleName());
    localStringBuilder.append("没有初始化。请先用upgradeIfNeededThenInit方法。");
    g = localStringBuilder.toString();
  }
  
  public UpgradeablePluginManager(File paramFile, String paramString, boolean paramBoolean)
  {
    this.a = paramFile;
    this.i = paramString;
    paramFile = this.a;
    StringBuilder localStringBuilder = new StringBuilder("PluginManager_");
    localStringBuilder.append(paramString);
    this.b = new File(paramFile, localStringBuilder.toString());
    this.f = new File(this.b, "pluginmanager1_4.apk");
    this.j = paramBoolean;
  }
  
  private String a(File arg1, File paramFile2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("使用");
    localStringBuilder.append(this.f.getAbsolutePath());
    localStringBuilder.append(".");
    Object localObject = h;
    if ((paramFile2.exists()) && (!paramFile2.isDirectory()))
    {
      ??? = new StringBuilder();
      ???.append(paramFile2.getAbsolutePath());
      ???.append("已存在且不是目录");
      throw new IOException(???.toString());
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
  
  @API
  public final List<InstalledPlugin> getCachedLatestPlugin(String paramString)
  {
    localObject = this.d;
    int k = 0;
    label29:
    try
    {
      PluginManager localPluginManager = this.c;
      if (localPluginManager == null) {
        k = 1;
      }
    }
    finally {}
    try
    {
      initWithoutUpgrade();
    }
    catch (Exception paramString)
    {
      break label29;
    }
    return null;
    paramString = this.c.getCachedLatestPlugin(paramString);
    if (k != 0) {
      this.c = null;
    }
    return paramString;
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
    File localFile1 = new File(e, "pluginmanager1_4.apk");
    File localFile2;
    int k;
    if (localFile1.exists())
    {
      localFile2 = new File(this.b, "pluginmanager1_4_odex");
      k = 1;
    }
    else
    {
      localFile1 = this.f;
      localFile2 = new File(localFile1.getParentFile(), "pluginmanager1_4_odex");
      k = -1;
    }
    a(localFile1, localFile2, k);
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
    //   7: astore 12
    //   9: new 27	java/io/File
    //   12: dup
    //   13: getstatic 35	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:e	Ljava/io/File;
    //   16: ldc 89
    //   18: invokespecial 85	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   21: astore 8
    //   23: aload 8
    //   25: invokevirtual 105	java/io/File:exists	()Z
    //   28: istore 7
    //   30: iload 7
    //   32: ifeq +63 -> 95
    //   35: new 27	java/io/File
    //   38: dup
    //   39: aload_0
    //   40: getfield 87	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:b	Ljava/io/File;
    //   43: ldc 169
    //   45: invokespecial 85	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   48: astore 11
    //   50: aload 12
    //   52: aload 8
    //   54: invokevirtual 99	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   57: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload 12
    //   63: ldc 188
    //   65: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: iconst_1
    //   70: istore 4
    //   72: aload 8
    //   74: astore_3
    //   75: aload 11
    //   77: astore 8
    //   79: goto +343 -> 422
    //   82: astore 9
    //   84: aload 8
    //   86: astore 10
    //   88: goto +308 -> 396
    //   91: astore_3
    //   92: goto +294 -> 386
    //   95: aload_0
    //   96: getfield 91	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:f	Ljava/io/File;
    //   99: invokevirtual 192	java/io/File:lastModified	()J
    //   102: lstore 5
    //   104: lload 5
    //   106: lconst_0
    //   107: lcmp
    //   108: ifeq +332 -> 440
    //   111: ldc2_w 193
    //   114: lstore_1
    //   115: goto +3 -> 118
    //   118: aload_0
    //   119: getfield 93	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:j	Z
    //   122: istore 7
    //   124: iload 7
    //   126: ifeq +42 -> 168
    //   129: new 37	java/lang/StringBuilder
    //   132: dup
    //   133: ldc 196
    //   135: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   138: astore 8
    //   140: aload 8
    //   142: aload_0
    //   143: getfield 79	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:i	Ljava/lang/String;
    //   146: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload 8
    //   152: ldc 198
    //   154: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload 8
    //   160: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: astore 8
    //   165: goto +27 -> 192
    //   168: new 37	java/lang/StringBuilder
    //   171: dup
    //   172: ldc 196
    //   174: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   177: astore 8
    //   179: aload 8
    //   181: aload_0
    //   182: getfield 79	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:i	Ljava/lang/String;
    //   185: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: goto -31 -> 158
    //   192: aload_0
    //   193: getfield 91	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:f	Ljava/io/File;
    //   196: astore 9
    //   198: new 27	java/io/File
    //   201: dup
    //   202: aload_0
    //   203: getfield 91	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:f	Ljava/io/File;
    //   206: invokevirtual 173	java/io/File:getParentFile	()Ljava/io/File;
    //   209: ldc 200
    //   211: invokespecial 85	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   214: astore 10
    //   216: new 202	com/tencent/hydevteam/pluginframework/pluginmanager/LengthHashURLConnectionDownloader
    //   219: dup
    //   220: invokespecial 203	com/tencent/hydevteam/pluginframework/pluginmanager/LengthHashURLConnectionDownloader:<init>	()V
    //   223: new 205	com/tencent/hydevteam/pluginframework/pluginmanager/TargetDownloadInfo
    //   226: dup
    //   227: aload 8
    //   229: ldc 207
    //   231: lconst_0
    //   232: invokespecial 210	com/tencent/hydevteam/pluginframework/pluginmanager/TargetDownloadInfo:<init>	(Ljava/lang/String;Ljava/lang/String;J)V
    //   235: aload 9
    //   237: aload 10
    //   239: invokeinterface 214 4 0
    //   244: astore 8
    //   246: aload 12
    //   248: ldc 216
    //   250: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload 12
    //   256: lload 5
    //   258: invokevirtual 219	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload 12
    //   264: ldc 221
    //   266: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: pop
    //   270: aload 8
    //   272: lload_1
    //   273: aload_3
    //   274: invokeinterface 227 4 0
    //   279: checkcast 27	java/io/File
    //   282: astore_3
    //   283: aload 12
    //   285: ldc 229
    //   287: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: iconst_1
    //   292: istore 4
    //   294: goto +40 -> 334
    //   297: astore 8
    //   299: goto +7 -> 306
    //   302: astore 8
    //   304: aconst_null
    //   305: astore_3
    //   306: aload 12
    //   308: aload 8
    //   310: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload 12
    //   316: ldc 101
    //   318: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload_0
    //   323: getfield 91	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:f	Ljava/io/File;
    //   326: astore 8
    //   328: aload 8
    //   330: astore_3
    //   331: iconst_0
    //   332: istore 4
    //   334: new 27	java/io/File
    //   337: dup
    //   338: aload_3
    //   339: invokevirtual 173	java/io/File:getParentFile	()Ljava/io/File;
    //   342: ldc 169
    //   344: invokespecial 85	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   347: astore 8
    //   349: goto +73 -> 422
    //   352: astore 9
    //   354: aconst_null
    //   355: astore 8
    //   357: goto +49 -> 406
    //   360: astore 9
    //   362: aconst_null
    //   363: astore 8
    //   365: iconst_0
    //   366: istore 4
    //   368: goto +38 -> 406
    //   371: astore 9
    //   373: aload_3
    //   374: astore 8
    //   376: aload 9
    //   378: astore_3
    //   379: goto +7 -> 386
    //   382: astore_3
    //   383: aconst_null
    //   384: astore 8
    //   386: aconst_null
    //   387: astore 11
    //   389: aload 8
    //   391: astore 10
    //   393: aload_3
    //   394: astore 9
    //   396: iconst_m1
    //   397: istore 4
    //   399: aload 11
    //   401: astore 8
    //   403: aload 10
    //   405: astore_3
    //   406: aload 12
    //   408: aload 9
    //   410: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   413: pop
    //   414: aload 12
    //   416: ldc 101
    //   418: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: pop
    //   422: aload 12
    //   424: aload_0
    //   425: aload_3
    //   426: aload 8
    //   428: iload 4
    //   430: invokespecial 175	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:a	(Ljava/io/File;Ljava/io/File;I)Ljava/lang/String;
    //   433: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: pop
    //   437: iload 4
    //   439: ireturn
    //   440: goto -322 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	443	0	this	UpgradeablePluginManager
    //   0	443	1	paramLong	long
    //   0	443	3	paramTimeUnit	java.util.concurrent.TimeUnit
    //   70	368	4	k	int
    //   102	155	5	l	long
    //   28	97	7	bool	boolean
    //   21	250	8	localObject1	Object
    //   297	1	8	localException1	Exception
    //   302	7	8	localException2	Exception
    //   326	101	8	localObject2	Object
    //   82	1	9	localException3	Exception
    //   196	40	9	localFile1	File
    //   352	1	9	localException4	Exception
    //   360	1	9	localException5	Exception
    //   371	6	9	localException6	Exception
    //   394	15	9	localTimeUnit	java.util.concurrent.TimeUnit
    //   86	318	10	localObject3	Object
    //   48	352	11	localFile2	File
    //   7	416	12	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   50	69	82	java/lang/Exception
    //   35	50	91	java/lang/Exception
    //   283	291	297	java/lang/Exception
    //   270	283	302	java/lang/Exception
    //   334	349	352	java/lang/Exception
    //   322	328	360	java/lang/Exception
    //   306	322	371	java/lang/Exception
    //   9	30	382	java/lang/Exception
    //   95	104	382	java/lang/Exception
    //   118	124	382	java/lang/Exception
    //   129	158	382	java/lang/Exception
    //   158	165	382	java/lang/Exception
    //   168	189	382	java/lang/Exception
    //   192	270	382	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginmanager.UpgradeablePluginManager
 * JD-Core Version:    0.7.0.1
 */