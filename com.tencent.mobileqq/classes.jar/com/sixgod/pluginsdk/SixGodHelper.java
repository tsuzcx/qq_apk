package com.sixgod.pluginsdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.sixgod.pluginsdk.component.ContainerActivity;
import com.sixgod.pluginsdk.component.ContainerService;
import com.sixgod.pluginsdk.component.SixGodPreLoadActivity;
import com.sixgod.pluginsdk.exception.SixGodException;
import com.sixgod.pluginsdk.log.SGLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SixGodHelper
{
  public static final String ACTION_UNLOAD_PLUGIN = "com.sixgod.pluginsdk.unload_plugin.ACTION";
  public static final String EXTRA_IS_KILL_PROCESS = "is_kill_process";
  public static final String EXTRA_PKG_NAME = "plugin_pkg_name";
  public static final String PKG_NAME_ALL = "com.sixgod.pluginsdk.unload_all_plugin";
  protected static HashMap a = new HashMap();
  static boolean b = false;
  static List c = new ArrayList();
  
  private static void a(Context paramContext)
  {
    if (!b)
    {
      paramContext = paramContext.getApplicationContext();
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.sixgod.pluginsdk.callback.ACTION");
      localIntentFilter.addCategory("android.intent.category.DEFAULT");
      paramContext.registerReceiver(new c(), localIntentFilter);
      b = true;
    }
  }
  
  public static void bindPluginService() {}
  
  public static void clearAllPluginLoaderInfo(Context paramContext)
  {
    try
    {
      if (a.size() > 0)
      {
        paramContext = a.keySet().iterator();
        while (paramContext.hasNext())
        {
          String str = (String)paramContext.next();
          ((e)a.get(str)).d(str);
        }
        a.clear();
      }
    }
    finally {}
  }
  
  public static void clearPluginLoaderInfo(Context paramContext, String paramString)
  {
    try
    {
      if (a.containsKey(paramString))
      {
        ((e)a.get(paramString)).d(paramString);
        a.remove(paramString);
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static Activity createPluginActivity(ContainerActivity paramContainerActivity, String paramString1, String paramString2, Intent paramIntent, Bundle paramBundle)
  {
    e locale = getPluginLoader(paramString1);
    if (locale == null)
    {
      SGLog.a("create pluginActivity failed, loader null!");
      return null;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("packageName", paramString1);
    localIntent.putExtra("className", paramString2);
    localIntent.putExtra("plugin_intent", paramIntent);
    try
    {
      paramContainerActivity = locale.a(paramContainerActivity, localIntent, paramBundle);
      return paramContainerActivity;
    }
    catch (Exception paramContainerActivity)
    {
      throw new SixGodException("createPluginActivity failed! msg = " + paramContainerActivity.getMessage());
    }
  }
  
  public static e getPluginLoader(String paramString)
  {
    if (a.containsKey(paramString)) {
      return (e)a.get(paramString);
    }
    try
    {
      paramString = (e)a.get(paramString);
      return paramString;
    }
    finally {}
  }
  
  public static boolean isPluginLoaded(String paramString)
  {
    try
    {
      boolean bool = a.containsKey(paramString);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public static boolean loadPlugin(Context paramContext, PluginLoadParams paramPluginLoadParams)
  {
    // Byte code:
    //   0: new 156	java/lang/StringBuilder
    //   3: dup
    //   4: ldc 177
    //   6: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   9: aload_1
    //   10: getfield 182	com/sixgod/pluginsdk/PluginLoadParams:apkPath	Ljava/lang/String;
    //   13: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   19: invokestatic 133	com/sixgod/pluginsdk/log/SGLog:a	(Ljava/lang/String;)V
    //   22: ldc 2
    //   24: monitorenter
    //   25: aload_1
    //   26: getfield 186	com/sixgod/pluginsdk/PluginLoadParams:pluginLoadCallBack	Lcom/sixgod/pluginsdk/PluginCallback;
    //   29: ifnull +96 -> 125
    //   32: new 188	com/sixgod/pluginsdk/d
    //   35: dup
    //   36: invokespecial 189	com/sixgod/pluginsdk/d:<init>	()V
    //   39: astore 5
    //   41: aload 5
    //   43: aload_1
    //   44: getfield 186	com/sixgod/pluginsdk/PluginLoadParams:pluginLoadCallBack	Lcom/sixgod/pluginsdk/PluginCallback;
    //   47: putfield 191	com/sixgod/pluginsdk/d:a	Lcom/sixgod/pluginsdk/PluginCallback;
    //   50: aload 5
    //   52: aload_1
    //   53: getfield 194	com/sixgod/pluginsdk/PluginLoadParams:pluginName	Ljava/lang/String;
    //   56: putfield 196	com/sixgod/pluginsdk/d:b	Ljava/lang/String;
    //   59: getstatic 39	com/sixgod/pluginsdk/SixGodHelper:c	Ljava/util/List;
    //   62: invokeinterface 199 1 0
    //   67: iconst_1
    //   68: isub
    //   69: istore_2
    //   70: iload_2
    //   71: iflt +43 -> 114
    //   74: getstatic 39	com/sixgod/pluginsdk/SixGodHelper:c	Ljava/util/List;
    //   77: iload_2
    //   78: invokeinterface 202 2 0
    //   83: checkcast 188	com/sixgod/pluginsdk/d
    //   86: astore 6
    //   88: aload 5
    //   90: getfield 196	com/sixgod/pluginsdk/d:b	Ljava/lang/String;
    //   93: aload 6
    //   95: getfield 196	com/sixgod/pluginsdk/d:b	Ljava/lang/String;
    //   98: invokestatic 208	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   101: ifeq +59 -> 160
    //   104: getstatic 39	com/sixgod/pluginsdk/SixGodHelper:c	Ljava/util/List;
    //   107: iload_2
    //   108: invokeinterface 210 2 0
    //   113: pop
    //   114: getstatic 39	com/sixgod/pluginsdk/SixGodHelper:c	Ljava/util/List;
    //   117: aload 5
    //   119: invokeinterface 213 2 0
    //   124: pop
    //   125: aload_0
    //   126: invokestatic 215	com/sixgod/pluginsdk/SixGodHelper:a	(Landroid/content/Context;)V
    //   129: ldc 2
    //   131: monitorexit
    //   132: ldc 2
    //   134: monitorenter
    //   135: getstatic 32	com/sixgod/pluginsdk/SixGodHelper:a	Ljava/util/HashMap;
    //   138: aload_1
    //   139: getfield 218	com/sixgod/pluginsdk/PluginLoadParams:pkgName	Ljava/lang/String;
    //   142: invokevirtual 116	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   145: ifeq +28 -> 173
    //   148: ldc 220
    //   150: invokestatic 133	com/sixgod/pluginsdk/log/SGLog:a	(Ljava/lang/String;)V
    //   153: iconst_1
    //   154: istore_3
    //   155: ldc 2
    //   157: monitorexit
    //   158: iload_3
    //   159: ireturn
    //   160: iload_2
    //   161: iconst_1
    //   162: isub
    //   163: istore_2
    //   164: goto -94 -> 70
    //   167: astore_0
    //   168: ldc 2
    //   170: monitorexit
    //   171: aload_0
    //   172: athrow
    //   173: ldc 2
    //   175: monitorexit
    //   176: new 103	com/sixgod/pluginsdk/e
    //   179: dup
    //   180: invokespecial 221	com/sixgod/pluginsdk/e:<init>	()V
    //   183: astore 5
    //   185: aload 5
    //   187: aload_0
    //   188: aload_1
    //   189: invokevirtual 223	com/sixgod/pluginsdk/e:a	(Landroid/content/Context;Lcom/sixgod/pluginsdk/PluginLoadParams;)Z
    //   192: istore 4
    //   194: iload 4
    //   196: istore_3
    //   197: iload 4
    //   199: ifeq -41 -> 158
    //   202: ldc 2
    //   204: monitorenter
    //   205: getstatic 32	com/sixgod/pluginsdk/SixGodHelper:a	Ljava/util/HashMap;
    //   208: aload_1
    //   209: getfield 218	com/sixgod/pluginsdk/PluginLoadParams:pkgName	Ljava/lang/String;
    //   212: aload 5
    //   214: invokevirtual 227	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   217: pop
    //   218: ldc 2
    //   220: monitorexit
    //   221: aload 5
    //   223: invokevirtual 229	com/sixgod/pluginsdk/e:a	()V
    //   226: ldc 231
    //   228: invokestatic 133	com/sixgod/pluginsdk/log/SGLog:a	(Ljava/lang/String;)V
    //   231: iload 4
    //   233: ireturn
    //   234: astore_0
    //   235: ldc 2
    //   237: monitorexit
    //   238: aload_0
    //   239: athrow
    //   240: astore_0
    //   241: ldc 2
    //   243: monitorexit
    //   244: aload_0
    //   245: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	paramContext	Context
    //   0	246	1	paramPluginLoadParams	PluginLoadParams
    //   69	95	2	i	int
    //   154	43	3	bool1	boolean
    //   192	40	4	bool2	boolean
    //   39	183	5	localObject	Object
    //   86	8	6	locald	d
    // Exception table:
    //   from	to	target	type
    //   25	70	167	finally
    //   74	114	167	finally
    //   114	125	167	finally
    //   125	132	167	finally
    //   168	171	167	finally
    //   135	153	234	finally
    //   155	158	234	finally
    //   173	176	234	finally
    //   235	238	234	finally
    //   205	221	240	finally
    //   241	244	240	finally
  }
  
  public static boolean moveDexFiles(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = com.sixgod.pluginsdk.common.a.b(paramContext, paramString2, paramString3);
    paramString2 = new File(paramContext);
    if (!paramString2.exists()) {
      paramString2.mkdirs();
    }
    com.sixgod.pluginsdk.b.a.a(paramString1, paramContext, "classes", ".dex");
    com.sixgod.pluginsdk.b.a.b(paramContext + File.separator + "classes.dex");
    return false;
  }
  
  public static boolean moveSoFile(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    String str2 = com.sixgod.pluginsdk.common.a.d(paramContext, paramString2, paramString3);
    String str1 = "tmp";
    if (!TextUtils.isEmpty(paramString3)) {
      str1 = "tmp" + "_" + paramString3;
    }
    paramContext = com.sixgod.pluginsdk.common.a.a(paramContext, paramString2) + str1 + File.separator;
    paramString2 = new File(paramContext);
    if (!paramString2.exists()) {
      paramString2.mkdirs();
    }
    paramString2 = new File(paramContext);
    if (paramString2.exists())
    {
      com.sixgod.pluginsdk.b.a.a(paramContext);
      paramString2.mkdirs();
      paramString2 = new File(str2);
      if (!paramString2.exists()) {
        break label313;
      }
      com.sixgod.pluginsdk.b.a.a(str2);
      paramString2.mkdirs();
    }
    for (;;)
    {
      com.sixgod.pluginsdk.b.a.a(paramString1, paramContext, "lib", "so");
      paramString1 = new File(paramContext + File.separator + "lib" + File.separator + Build.CPU_ABI);
      paramString2 = new File(paramContext + File.separator + "lib" + File.separator + "armeabi");
      boolean bool = false;
      if (paramString2.exists()) {
        bool = com.sixgod.pluginsdk.b.a.a(paramString2.getAbsolutePath(), str2, true);
      }
      if (paramString1.exists()) {
        bool = com.sixgod.pluginsdk.b.a.a(paramString1.getAbsolutePath(), str2, true);
      }
      com.sixgod.pluginsdk.b.a.a(paramContext);
      return bool;
      paramString2.mkdirs();
      break;
      label313:
      paramString2.mkdirs();
    }
  }
  
  public static void preloadPlugin(Context paramContext, PluginLoadParams paramPluginLoadParams, Class paramClass)
  {
    SGLog.a("preLoad name = " + paramPluginLoadParams.pluginName);
    try
    {
      int i;
      if (paramPluginLoadParams.pluginLoadCallBack != null)
      {
        localObject = new d();
        ((d)localObject).a = paramPluginLoadParams.pluginLoadCallBack;
        ((d)localObject).b = paramPluginLoadParams.pluginName;
        i = c.size() - 1;
      }
      for (;;)
      {
        if (i >= 0)
        {
          d locald = (d)c.get(i);
          SGLog.a("equals  name = " + locald.b);
          if (TextUtils.equals(((d)localObject).b, locald.b))
          {
            SGLog.a("equals " + ((d)localObject).b + " = " + locald.b);
            c.remove(i);
          }
        }
        else
        {
          c.add(localObject);
          a(paramContext);
          if (!SixGodPreLoadActivity.class.isAssignableFrom(paramClass)) {
            break;
          }
          localObject = new Intent();
          ((Intent)localObject).setClass(paramContext, paramClass);
          ((Intent)localObject).putExtra("plugin_load_params", paramPluginLoadParams.toJsonString());
          ((Intent)localObject).addFlags(268435456);
          paramContext.startActivity((Intent)localObject);
          return;
        }
        i -= 1;
      }
      if (!ContainerService.class.isAssignableFrom(paramClass)) {
        break label324;
      }
    }
    finally {}
    Object localObject = new Intent();
    ((Intent)localObject).setClass(paramContext, paramClass);
    ((Intent)localObject).putExtra("plugin_load_params", paramPluginLoadParams.toJsonString());
    ((Intent)localObject).putExtra("packageName", paramPluginLoadParams.pkgName);
    paramContext.startService((Intent)localObject);
    return;
    label324:
    SGLog.b("preloadPlugin error, clazz must extends from SixGodPreLoadActivity or ContainerService:" + paramClass);
  }
  
  public static boolean startPluginActivity(Context paramContext, String paramString, PluginLoadParams paramPluginLoadParams, Bundle paramBundle)
  {
    return startPluginActivity(paramContext, paramString, paramPluginLoadParams, paramBundle, null);
  }
  
  public static boolean startPluginActivity(Context paramContext, String paramString, PluginLoadParams paramPluginLoadParams, Bundle paramBundle, Uri paramUri)
  {
    SGLog.a("startPluginActivity,apkPath = " + paramPluginLoadParams.apkPath);
    for (;;)
    {
      try
      {
        if (paramPluginLoadParams.pluginLoadCallBack != null)
        {
          localObject1 = new d();
          ((d)localObject1).a = paramPluginLoadParams.pluginLoadCallBack;
          ((d)localObject1).b = paramPluginLoadParams.pluginName;
          localObject2 = c.iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label353;
          }
          if (((d)((Iterator)localObject2).next()).a != paramPluginLoadParams.pluginLoadCallBack) {
            continue;
          }
          i = 1;
          if (i == 0) {
            c.add(localObject1);
          }
        }
        a(paramContext);
        if (paramPluginLoadParams.componentMap.containsKey(paramString))
        {
          localObject1 = (String)paramPluginLoadParams.componentMap.get(paramString);
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break label179;
          }
          return false;
        }
      }
      finally {}
      Object localObject1 = paramPluginLoadParams.defaultActivityContainer;
      continue;
      label179:
      Object localObject2 = new Intent();
      if (paramBundle != null) {
        ((Intent)localObject2).putExtras(paramBundle);
      }
      if (paramUri != null) {
        ((Intent)localObject2).setData(paramUri);
      }
      ((Intent)localObject2).putExtra("packageName", paramPluginLoadParams.pkgName);
      paramBundle = new Intent();
      if (!(paramContext instanceof Activity)) {
        paramBundle.setFlags(268435456);
      }
      paramBundle.setClassName(paramContext, (String)localObject1);
      paramBundle.putExtra("className", paramString);
      paramBundle.putExtra("plugin_intent", (Parcelable)localObject2);
      paramBundle.putExtra("plugin_load_params", paramPluginLoadParams.toJsonString());
      paramBundle.putExtra("packageName", paramPluginLoadParams.pkgName);
      paramBundle.putExtra("plugin_id", paramPluginLoadParams.pluginName);
      paramBundle.putExtra("is_launcher_activity", true);
      paramBundle.putExtra("is_main", true);
      SGLog.a("startPluginActivity  name = " + (String)localObject1);
      paramContext.startActivity(paramBundle);
      return true;
      label353:
      int i = 0;
    }
  }
  
  public static boolean startPluginLauncherActivity(Context paramContext, PluginLoadParams paramPluginLoadParams, Bundle paramBundle)
  {
    try
    {
      startPluginActivity(paramContext, "", paramPluginLoadParams, paramBundle);
      return false;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static boolean startPluginLauncherActivity(Context paramContext, PluginLoadParams paramPluginLoadParams, Bundle paramBundle, Uri paramUri)
  {
    try
    {
      startPluginActivity(paramContext, "", paramPluginLoadParams, paramBundle, paramUri);
      return false;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void startPluginService() {}
  
  public static void stopPluginService() {}
  
  public static boolean unLoadAllPlugin(Context paramContext, boolean paramBoolean)
  {
    try
    {
      clearAllPluginLoaderInfo(paramContext);
      Intent localIntent = new Intent("com.sixgod.pluginsdk.unload_plugin.ACTION");
      localIntent.putExtra("plugin_pkg_name", "com.sixgod.pluginsdk.unload_all_plugin");
      localIntent.putExtra("is_kill_process", paramBoolean);
      paramContext.sendBroadcast(localIntent);
      return true;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static boolean unLoadPlugin(Context paramContext, String paramString)
  {
    try
    {
      boolean bool = unLoadPlugin(paramContext, paramString, false);
      return bool;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static boolean unLoadPlugin(Context paramContext, String paramString, boolean paramBoolean)
  {
    try
    {
      clearPluginLoaderInfo(paramContext, paramString);
      Intent localIntent = new Intent("com.sixgod.pluginsdk.unload_plugin.ACTION");
      localIntent.putExtra("plugin_pkg_name", paramString);
      localIntent.putExtra("is_kill_process", paramBoolean);
      paramContext.sendBroadcast(localIntent);
      return true;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.sixgod.pluginsdk.SixGodHelper
 * JD-Core Version:    0.7.0.1
 */