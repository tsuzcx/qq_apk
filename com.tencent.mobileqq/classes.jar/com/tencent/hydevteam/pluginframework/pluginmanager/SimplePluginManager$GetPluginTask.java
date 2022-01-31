package com.tencent.hydevteam.pluginframework.pluginmanager;

import com.tencent.hydevteam.common.progress.Progress;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import java.io.File;
import java.util.Map;
import java.util.concurrent.Callable;

class SimplePluginManager$GetPluginTask
  implements Progress, Callable<InstalledPlugin>
{
  private TargetDownloadInfo a;
  private boolean b;
  private volatile ProgressFuture<File> c;
  private volatile int d = 0;
  
  SimplePluginManager$GetPluginTask(SimplePluginManager paramSimplePluginManager, TargetDownloadInfo paramTargetDownloadInfo, boolean paramBoolean)
  {
    this.b = paramBoolean;
    this.a = paramTargetDownloadInfo;
  }
  
  /* Error */
  private InstalledPlugin a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 24	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:e	Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;
    //   4: invokestatic 44	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager:a	(Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;)Lcom/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager;
    //   7: invokevirtual 48	com/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager:a	()Lcom/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin;
    //   10: astore_3
    //   11: aload_0
    //   12: bipush 10
    //   14: invokespecial 51	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:a	(I)V
    //   17: new 53	java/util/ArrayList
    //   20: dup
    //   21: invokespecial 54	java/util/ArrayList:<init>	()V
    //   24: astore_2
    //   25: aload_3
    //   26: ifnonnull +223 -> 249
    //   29: aload_0
    //   30: getfield 24	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:e	Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;
    //   33: invokestatic 57	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager:b	(Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;)Lcom/tencent/hydevteam/pluginframework/pluginmanager/TargetManager;
    //   36: getfield 62	com/tencent/hydevteam/pluginframework/pluginmanager/TargetManager:a	Ljava/io/File;
    //   39: invokestatic 67	com/tencent/hydevteam/pluginframework/pluginmanager/MinFileUtils:b	(Ljava/io/File;)Ljava/util/List;
    //   42: astore_2
    //   43: aload_0
    //   44: bipush 10
    //   46: invokespecial 51	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:a	(I)V
    //   49: aload_3
    //   50: astore_1
    //   51: aload_3
    //   52: ifnonnull +86 -> 138
    //   55: aload_3
    //   56: astore_1
    //   57: aload_0
    //   58: getfield 33	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:a	Lcom/tencent/hydevteam/pluginframework/pluginmanager/TargetDownloadInfo;
    //   61: ifnull +77 -> 138
    //   64: aload_2
    //   65: invokeinterface 73 1 0
    //   70: astore 4
    //   72: aload_3
    //   73: astore_1
    //   74: aload 4
    //   76: invokeinterface 79 1 0
    //   81: ifeq +57 -> 138
    //   84: aload 4
    //   86: invokeinterface 83 1 0
    //   91: checkcast 85	java/io/File
    //   94: astore_1
    //   95: aload_0
    //   96: getfield 24	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:e	Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;
    //   99: invokestatic 44	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager:a	(Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;)Lcom/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager;
    //   102: aload_1
    //   103: invokevirtual 88	com/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager:b	(Ljava/io/File;)Z
    //   106: ifne -34 -> 72
    //   109: aload_1
    //   110: invokevirtual 92	java/io/File:getName	()Ljava/lang/String;
    //   113: aload_0
    //   114: getfield 33	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:a	Lcom/tencent/hydevteam/pluginframework/pluginmanager/TargetDownloadInfo;
    //   117: getfield 98	com/tencent/hydevteam/pluginframework/pluginmanager/TargetDownloadInfo:hash	Ljava/lang/String;
    //   120: invokevirtual 104	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   123: ifeq -51 -> 72
    //   126: aload_0
    //   127: getfield 24	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:e	Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;
    //   130: invokestatic 44	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager:a	(Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;)Lcom/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager;
    //   133: aload_1
    //   134: invokevirtual 107	com/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager:c	(Ljava/io/File;)Lcom/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin;
    //   137: astore_1
    //   138: aload_1
    //   139: ifnonnull +107 -> 246
    //   142: aload_2
    //   143: invokeinterface 73 1 0
    //   148: astore_3
    //   149: aload_3
    //   150: invokeinterface 79 1 0
    //   155: ifeq +91 -> 246
    //   158: aload_3
    //   159: invokeinterface 83 1 0
    //   164: checkcast 85	java/io/File
    //   167: astore_2
    //   168: aload_0
    //   169: getfield 24	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:e	Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;
    //   172: invokestatic 44	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager:a	(Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;)Lcom/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager;
    //   175: aload_2
    //   176: invokevirtual 88	com/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager:b	(Ljava/io/File;)Z
    //   179: ifne -30 -> 149
    //   182: aload_0
    //   183: getfield 24	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:e	Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;
    //   186: invokestatic 44	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager:a	(Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;)Lcom/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager;
    //   189: aload_2
    //   190: invokevirtual 107	com/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager:c	(Ljava/io/File;)Lcom/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin;
    //   193: astore_2
    //   194: aload_2
    //   195: astore_1
    //   196: aload_0
    //   197: bipush 100
    //   199: putfield 29	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:d	I
    //   202: aload_1
    //   203: ifnonnull +33 -> 236
    //   206: new 109	java/lang/Exception
    //   209: dup
    //   210: ldc 111
    //   212: invokespecial 114	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   215: athrow
    //   216: astore_1
    //   217: aload_0
    //   218: iconst_5
    //   219: invokespecial 51	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:a	(I)V
    //   222: aload_3
    //   223: astore_1
    //   224: goto -86 -> 138
    //   227: astore_2
    //   228: aload_0
    //   229: iconst_5
    //   230: invokespecial 51	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:a	(I)V
    //   233: goto -84 -> 149
    //   236: aload_1
    //   237: areturn
    //   238: astore_2
    //   239: goto -11 -> 228
    //   242: astore_1
    //   243: goto -26 -> 217
    //   246: goto -50 -> 196
    //   249: goto -206 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	this	GetPluginTask
    //   50	153	1	localObject1	Object
    //   216	1	1	localJSONException1	org.json.JSONException
    //   223	14	1	localObject2	Object
    //   242	1	1	localIOException1	java.io.IOException
    //   24	171	2	localObject3	Object
    //   227	1	2	localJSONException2	org.json.JSONException
    //   238	1	2	localIOException2	java.io.IOException
    //   10	213	3	localObject4	Object
    //   70	15	4	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   126	138	216	org/json/JSONException
    //   182	194	227	org/json/JSONException
    //   182	194	238	java/io/IOException
    //   126	138	242	java/io/IOException
  }
  
  private void a(int paramInt)
  {
    this.d += paramInt;
  }
  
  private InstalledPlugin b()
  {
    Object localObject1 = SimplePluginManager.a.get(this.a.hash);
    if (localObject1 == null)
    {
      localObject1 = new Object();
      SimplePluginManager.a.put(this.a.hash, localObject1);
    }
    for (;;)
    {
      Object localObject5;
      Object localObject6;
      try
      {
        Object localObject2 = SimplePluginManager.b(this.e);
        localObject5 = this.a.hash;
        localObject6 = new File(((TargetManager)localObject2).a, (String)localObject5);
        try
        {
          localObject2 = SimplePluginManager.a(this.e).c((File)localObject6);
          localObject5 = localObject2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (((File)localObject6).exists()) {
              ((File)localObject6).delete();
            }
            Object localObject3 = SimplePluginManager.b(this.e);
            localObject5 = this.a.hash;
            localObject3 = new File(((TargetManager)localObject3).b, "downloading." + (String)localObject5);
            localObject3 = SimplePluginManager.c(this.e).download(this.a, (File)localObject6, (File)localObject3);
            a(5);
            this.c = ((ProgressFuture)localObject3);
            localObject3 = (File)((ProgressFuture)localObject3).get();
            a(5);
            localObject5 = SimplePluginManager.a(this.e).c((File)localObject3);
            ((File)localObject3).delete();
            a(5);
            localObject6 = localObject3;
          }
        }
        ((File)localObject6).delete();
        this.d = 100;
        return localObject5;
      }
      finally {}
    }
  }
  
  public double getProgress()
  {
    if (this.c != null) {
      return (this.d + (100 - this.d) * this.c.getProgress()) / 100.0D;
    }
    return this.d / 100.0D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginmanager.SimplePluginManager.GetPluginTask
 * JD-Core Version:    0.7.0.1
 */