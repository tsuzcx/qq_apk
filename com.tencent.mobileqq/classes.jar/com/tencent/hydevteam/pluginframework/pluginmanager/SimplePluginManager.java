package com.tencent.hydevteam.pluginframework.pluginmanager;

import android.content.Context;
import com.tencent.hydevteam.common.annotation.API;
import com.tencent.hydevteam.common.progress.Progress;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import com.tencent.hydevteam.common.progress.ProgressFutureImpl;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.hydevteam.pluginframework.installedplugin.PluginRunningPath;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@API
public class SimplePluginManager
  implements PluginManager
{
  public static final Map<String, Object> a = new HashMap();
  private static final File i = new File("/data/local/tmp");
  private final File b;
  private final File c;
  private final Downloader d;
  private final VersionChecker e;
  private final TargetManager f;
  private final UnpackManager g;
  private final ExecutorService h = Executors.newSingleThreadExecutor();
  private File j;
  
  public SimplePluginManager(File paramFile, Downloader paramDownloader, VersionChecker paramVersionChecker, String paramString)
  {
    this.b = paramFile;
    this.c = new File(this.b, "PluginManager_" + paramString);
    this.f = new TargetManager(this.c);
    if ((this.c.exists()) && (!this.c.isDirectory())) {
      throw new IllegalArgumentException(this.c.getAbsolutePath() + "已存在且不是目录");
    }
    this.g = new UnpackManager(this.c);
    this.d = paramDownloader;
    this.e = paramVersionChecker;
  }
  
  private boolean a(String paramString)
  {
    this.j = new File(i, paramString + ".zip");
    return this.j.exists();
  }
  
  @API
  public List<InstalledPlugin> getCachedLatestPlugin(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (a(paramString)) {}
    for (paramString = new GetTestPluginTask(false);; paramString = new GetPluginTask(null, true))
    {
      paramString = this.h.submit(paramString);
      try
      {
        localArrayList.add((InstalledPlugin)paramString.get());
        return localArrayList;
      }
      catch (Exception paramString) {}
    }
    return null;
  }
  
  @API
  public VersionChecker getVersionChecker()
  {
    return this.e;
  }
  
  @API
  public ProgressFuture preloadApk(Context paramContext, InstalledPlugin paramInstalledPlugin, boolean paramBoolean)
  {
    paramContext = new PluginPreloadTask(paramContext, paramInstalledPlugin.pluginFile, paramInstalledPlugin.pluginPackageName, paramInstalledPlugin.pluginVersionForPluginLoaderManage, paramBoolean);
    return new ProgressFutureImpl(this.h.submit(paramContext), null);
  }
  
  @API
  public List<ProgressFuture<InstalledPlugin>> updatePlugin(String paramString1, TargetDownloadInfo paramTargetDownloadInfo, String paramString2)
  {
    paramString2 = new ArrayList();
    if (a(paramString1))
    {
      paramString1 = new GetTestPluginTask(true);
      paramString2.add(new ProgressFutureImpl(this.h.submit(paramString1), paramString1));
      return paramString2;
    }
    paramString1 = new GetPluginTask(paramTargetDownloadInfo, false);
    paramString2.add(new ProgressFutureImpl(this.h.submit(paramString1), paramString1));
    return paramString2;
  }
  
  private class GetPluginTask
    implements Progress, Callable<InstalledPlugin>
  {
    private TargetDownloadInfo a;
    private boolean b;
    private volatile ProgressFuture<File> c;
    private volatile int d = 0;
    
    GetPluginTask(TargetDownloadInfo paramTargetDownloadInfo, boolean paramBoolean)
    {
      this.b = paramBoolean;
      this.a = paramTargetDownloadInfo;
    }
    
    /* Error */
    private InstalledPlugin a()
      throws Exception
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 27	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:e	Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;
      //   4: invokestatic 47	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager:a	(Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;)Lcom/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager;
      //   7: invokevirtual 51	com/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager:a	()Lcom/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin;
      //   10: astore_3
      //   11: aload_0
      //   12: bipush 10
      //   14: invokespecial 54	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:a	(I)V
      //   17: new 56	java/util/ArrayList
      //   20: dup
      //   21: invokespecial 57	java/util/ArrayList:<init>	()V
      //   24: astore_2
      //   25: aload_3
      //   26: ifnonnull +17 -> 43
      //   29: aload_0
      //   30: getfield 27	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:e	Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;
      //   33: invokestatic 60	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager:b	(Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;)Lcom/tencent/hydevteam/pluginframework/pluginmanager/TargetManager;
      //   36: getfield 65	com/tencent/hydevteam/pluginframework/pluginmanager/TargetManager:a	Ljava/io/File;
      //   39: invokestatic 70	com/tencent/hydevteam/pluginframework/pluginmanager/MinFileUtils:b	(Ljava/io/File;)Ljava/util/List;
      //   42: astore_2
      //   43: aload_0
      //   44: bipush 10
      //   46: invokespecial 54	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:a	(I)V
      //   49: aload_3
      //   50: astore_1
      //   51: aload_3
      //   52: ifnonnull +86 -> 138
      //   55: aload_3
      //   56: astore_1
      //   57: aload_0
      //   58: getfield 36	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:a	Lcom/tencent/hydevteam/pluginframework/pluginmanager/TargetDownloadInfo;
      //   61: ifnull +77 -> 138
      //   64: aload_2
      //   65: invokeinterface 76 1 0
      //   70: astore 4
      //   72: aload_3
      //   73: astore_1
      //   74: aload 4
      //   76: invokeinterface 82 1 0
      //   81: ifeq +57 -> 138
      //   84: aload 4
      //   86: invokeinterface 86 1 0
      //   91: checkcast 88	java/io/File
      //   94: astore_1
      //   95: aload_0
      //   96: getfield 27	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:e	Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;
      //   99: invokestatic 47	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager:a	(Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;)Lcom/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager;
      //   102: aload_1
      //   103: invokevirtual 91	com/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager:b	(Ljava/io/File;)Z
      //   106: ifne -34 -> 72
      //   109: aload_1
      //   110: invokevirtual 95	java/io/File:getName	()Ljava/lang/String;
      //   113: aload_0
      //   114: getfield 36	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:a	Lcom/tencent/hydevteam/pluginframework/pluginmanager/TargetDownloadInfo;
      //   117: getfield 101	com/tencent/hydevteam/pluginframework/pluginmanager/TargetDownloadInfo:hash	Ljava/lang/String;
      //   120: invokevirtual 107	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   123: ifeq -51 -> 72
      //   126: aload_0
      //   127: getfield 27	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:e	Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;
      //   130: invokestatic 47	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager:a	(Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;)Lcom/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager;
      //   133: aload_1
      //   134: invokevirtual 110	com/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager:c	(Ljava/io/File;)Lcom/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin;
      //   137: astore_1
      //   138: aload_1
      //   139: astore_3
      //   140: aload_1
      //   141: ifnonnull +57 -> 198
      //   144: aload_2
      //   145: invokeinterface 76 1 0
      //   150: astore_2
      //   151: aload_1
      //   152: astore_3
      //   153: aload_2
      //   154: invokeinterface 82 1 0
      //   159: ifeq +39 -> 198
      //   162: aload_2
      //   163: invokeinterface 86 1 0
      //   168: checkcast 88	java/io/File
      //   171: astore_3
      //   172: aload_0
      //   173: getfield 27	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:e	Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;
      //   176: invokestatic 47	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager:a	(Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;)Lcom/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager;
      //   179: aload_3
      //   180: invokevirtual 91	com/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager:b	(Ljava/io/File;)Z
      //   183: ifne -32 -> 151
      //   186: aload_0
      //   187: getfield 27	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:e	Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;
      //   190: invokestatic 47	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager:a	(Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;)Lcom/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager;
      //   193: aload_3
      //   194: invokevirtual 110	com/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager:c	(Ljava/io/File;)Lcom/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin;
      //   197: astore_3
      //   198: aload_0
      //   199: bipush 100
      //   201: putfield 32	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:d	I
      //   204: aload_3
      //   205: ifnonnull +33 -> 238
      //   208: new 40	java/lang/Exception
      //   211: dup
      //   212: ldc 112
      //   214: invokespecial 115	java/lang/Exception:<init>	(Ljava/lang/String;)V
      //   217: athrow
      //   218: astore_1
      //   219: aload_0
      //   220: iconst_5
      //   221: invokespecial 54	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:a	(I)V
      //   224: aload_3
      //   225: astore_1
      //   226: goto -88 -> 138
      //   229: astore_3
      //   230: aload_0
      //   231: iconst_5
      //   232: invokespecial 54	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:a	(I)V
      //   235: goto -84 -> 151
      //   238: aload_3
      //   239: areturn
      //   240: astore_3
      //   241: goto -11 -> 230
      //   244: astore_1
      //   245: goto -26 -> 219
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	248	0	this	GetPluginTask
      //   50	102	1	localObject1	Object
      //   218	1	1	localJSONException1	org.json.JSONException
      //   225	1	1	localObject2	Object
      //   244	1	1	localIOException1	IOException
      //   24	139	2	localObject3	Object
      //   10	215	3	localObject4	Object
      //   229	10	3	localJSONException2	org.json.JSONException
      //   240	1	3	localIOException2	IOException
      //   70	15	4	localIterator	java.util.Iterator
      // Exception table:
      //   from	to	target	type
      //   126	138	218	org/json/JSONException
      //   186	198	229	org/json/JSONException
      //   186	198	240	java/io/IOException
      //   126	138	244	java/io/IOException
    }
    
    private void a(int paramInt)
    {
      this.d += paramInt;
    }
    
    /* Error */
    private InstalledPlugin b()
      throws java.util.concurrent.ExecutionException, java.lang.InterruptedException, IOException, org.json.JSONException
    {
      // Byte code:
      //   0: getstatic 123	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager:a	Ljava/util/Map;
      //   3: aload_0
      //   4: getfield 36	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:a	Lcom/tencent/hydevteam/pluginframework/pluginmanager/TargetDownloadInfo;
      //   7: getfield 101	com/tencent/hydevteam/pluginframework/pluginmanager/TargetDownloadInfo:hash	Ljava/lang/String;
      //   10: invokeinterface 129 2 0
      //   15: astore_2
      //   16: aload_2
      //   17: astore_1
      //   18: aload_2
      //   19: ifnonnull +28 -> 47
      //   22: new 5	java/lang/Object
      //   25: dup
      //   26: invokespecial 30	java/lang/Object:<init>	()V
      //   29: astore_1
      //   30: getstatic 123	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager:a	Ljava/util/Map;
      //   33: aload_0
      //   34: getfield 36	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:a	Lcom/tencent/hydevteam/pluginframework/pluginmanager/TargetDownloadInfo;
      //   37: getfield 101	com/tencent/hydevteam/pluginframework/pluginmanager/TargetDownloadInfo:hash	Ljava/lang/String;
      //   40: aload_1
      //   41: invokeinterface 133 3 0
      //   46: pop
      //   47: aload_1
      //   48: monitorenter
      //   49: aload_0
      //   50: getfield 27	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:e	Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;
      //   53: invokestatic 60	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager:b	(Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;)Lcom/tencent/hydevteam/pluginframework/pluginmanager/TargetManager;
      //   56: astore_2
      //   57: aload_0
      //   58: getfield 36	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:a	Lcom/tencent/hydevteam/pluginframework/pluginmanager/TargetDownloadInfo;
      //   61: getfield 101	com/tencent/hydevteam/pluginframework/pluginmanager/TargetDownloadInfo:hash	Ljava/lang/String;
      //   64: astore_3
      //   65: new 88	java/io/File
      //   68: dup
      //   69: aload_2
      //   70: getfield 65	com/tencent/hydevteam/pluginframework/pluginmanager/TargetManager:a	Ljava/io/File;
      //   73: aload_3
      //   74: invokespecial 136	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   77: astore_3
      //   78: aload_0
      //   79: getfield 27	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:e	Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;
      //   82: invokestatic 47	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager:a	(Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;)Lcom/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager;
      //   85: aload_3
      //   86: invokevirtual 110	com/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager:c	(Ljava/io/File;)Lcom/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin;
      //   89: astore_2
      //   90: aload_3
      //   91: invokevirtual 139	java/io/File:delete	()Z
      //   94: pop
      //   95: aload_0
      //   96: bipush 100
      //   98: putfield 32	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:d	I
      //   101: aload_1
      //   102: monitorexit
      //   103: aload_2
      //   104: areturn
      //   105: astore_2
      //   106: aload_3
      //   107: invokevirtual 142	java/io/File:exists	()Z
      //   110: ifeq +8 -> 118
      //   113: aload_3
      //   114: invokevirtual 139	java/io/File:delete	()Z
      //   117: pop
      //   118: aload_0
      //   119: getfield 27	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:e	Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;
      //   122: invokestatic 60	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager:b	(Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;)Lcom/tencent/hydevteam/pluginframework/pluginmanager/TargetManager;
      //   125: astore_2
      //   126: aload_0
      //   127: getfield 36	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:a	Lcom/tencent/hydevteam/pluginframework/pluginmanager/TargetDownloadInfo;
      //   130: getfield 101	com/tencent/hydevteam/pluginframework/pluginmanager/TargetDownloadInfo:hash	Ljava/lang/String;
      //   133: astore 4
      //   135: new 88	java/io/File
      //   138: dup
      //   139: aload_2
      //   140: getfield 144	com/tencent/hydevteam/pluginframework/pluginmanager/TargetManager:b	Ljava/io/File;
      //   143: new 146	java/lang/StringBuilder
      //   146: dup
      //   147: ldc 148
      //   149: invokespecial 149	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   152: aload 4
      //   154: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   157: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   160: invokespecial 136	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   163: astore_2
      //   164: aload_0
      //   165: getfield 27	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:e	Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;
      //   168: invokestatic 159	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager:c	(Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;)Lcom/tencent/hydevteam/pluginframework/pluginmanager/Downloader;
      //   171: aload_0
      //   172: getfield 36	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:a	Lcom/tencent/hydevteam/pluginframework/pluginmanager/TargetDownloadInfo;
      //   175: aload_3
      //   176: aload_2
      //   177: invokeinterface 165 4 0
      //   182: astore_2
      //   183: aload_0
      //   184: iconst_5
      //   185: invokespecial 54	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:a	(I)V
      //   188: aload_0
      //   189: aload_2
      //   190: putfield 167	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:c	Lcom/tencent/hydevteam/common/progress/ProgressFuture;
      //   193: aload_2
      //   194: invokeinterface 171 1 0
      //   199: checkcast 88	java/io/File
      //   202: astore_3
      //   203: aload_0
      //   204: iconst_5
      //   205: invokespecial 54	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:a	(I)V
      //   208: aload_0
      //   209: getfield 27	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:e	Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;
      //   212: invokestatic 47	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager:a	(Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;)Lcom/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager;
      //   215: aload_3
      //   216: invokevirtual 110	com/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager:c	(Ljava/io/File;)Lcom/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin;
      //   219: astore_2
      //   220: aload_3
      //   221: invokevirtual 139	java/io/File:delete	()Z
      //   224: pop
      //   225: aload_0
      //   226: iconst_5
      //   227: invokespecial 54	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:a	(I)V
      //   230: goto -140 -> 90
      //   233: astore_2
      //   234: aload_1
      //   235: monitorexit
      //   236: aload_2
      //   237: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	238	0	this	GetPluginTask
      //   17	218	1	localObject1	Object
      //   15	89	2	localObject2	Object
      //   105	1	2	localException	Exception
      //   125	95	2	localObject3	Object
      //   233	4	2	localObject4	Object
      //   64	157	3	localObject5	Object
      //   133	20	4	str	String
      // Exception table:
      //   from	to	target	type
      //   78	90	105	java/lang/Exception
      //   49	78	233	finally
      //   78	90	233	finally
      //   90	103	233	finally
      //   106	118	233	finally
      //   118	230	233	finally
      //   234	236	233	finally
    }
    
    public double getProgress()
    {
      if (this.c != null) {
        return (this.d + (100 - this.d) * this.c.getProgress()) / 100.0D;
      }
      return this.d / 100.0D;
    }
  }
  
  private class GetTestPluginTask
    implements Progress, Callable<InstalledPlugin>
  {
    private boolean a = false;
    
    GetTestPluginTask(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }
    
    public double getProgress()
    {
      return 1.0D;
    }
  }
  
  private class PluginPreloadTask
    implements Runnable
  {
    private File a;
    private String c;
    private String d;
    private boolean e;
    
    PluginPreloadTask(File paramFile, String paramString1, String paramString2, boolean paramBoolean)
    {
      this.a = paramFile;
      this.c = paramString1;
      this.d = paramString2;
      this.e = paramBoolean;
    }
    
    public void run()
    {
      Object localObject;
      if (!this.e)
      {
        localObject = PluginRunningPath.getPluginOptDexDir(SimplePluginManager.this, this.c, this.d);
        String str = PluginRunningPath.getPluginNewLibDir(SimplePluginManager.this, this.c, this.d);
        new DexClassLoader(this.a.getAbsolutePath(), (String)localObject, str, SimplePluginManager.this.getClassLoader());
        localObject = new File((String)localObject, this.a.getName() + ".preload");
      }
      try
      {
        ((File)localObject).createNewFile();
        return;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginmanager.SimplePluginManager
 * JD-Core Version:    0.7.0.1
 */