package com.huawei.remoteLoader.client;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetManager;
import android.util.ArrayMap;
import android.util.Log;
import com.huawei.arengine.remoteLoader.IDynamicLoader;
import com.huawei.arengine.remoteLoader.ILoaderProducer;
import com.huawei.hiar.annotations.UsedByNative;
import dalvik.system.DexClassLoader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;

@TargetApi(19)
@UsedByNative("dynamite_client.cc")
public final class ARDynamiteClient
{
  private static final String LIB32_DIR_NAME = "lib";
  private static final String LIB64_DIR_NAME = "lib64";
  private static final String TAG = ARDynamiteClient.class.getSimpleName();
  private static DexClassLoader cl;
  private static String fileName = null;
  private static a info;
  private static IDynamicLoader loader;
  private static Context loaderContext = null;
  private static ILoaderProducer loaderProducer;
  private static ARRemoteLibraryLoader remoteLibLoader;
  protected static Object syncObject = new Object();
  private static final ArrayMap<a, ARRemoteLibraryLoader> targetLibraries = new ArrayMap();
  
  static
  {
    remoteLibLoader = null;
    info = null;
    loaderProducer = null;
    loader = null;
  }
  
  /* Error */
  public static boolean CheckUpdate(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: ldc 2
    //   5: monitorenter
    //   6: iload 5
    //   8: istore 4
    //   10: getstatic 56	com/huawei/remoteLoader/client/ARDynamiteClient:info	Lcom/huawei/remoteLoader/client/a;
    //   13: ifnonnull +75 -> 88
    //   16: new 78	com/huawei/remoteLoader/client/a
    //   19: dup
    //   20: aload_1
    //   21: aload_2
    //   22: invokespecial 81	com/huawei/remoteLoader/client/a:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: putstatic 56	com/huawei/remoteLoader/client/ARDynamiteClient:info	Lcom/huawei/remoteLoader/client/a;
    //   28: getstatic 56	com/huawei/remoteLoader/client/ARDynamiteClient:info	Lcom/huawei/remoteLoader/client/a;
    //   31: invokestatic 85	com/huawei/remoteLoader/client/ARDynamiteClient:getRemoteLibraryLoaderFromInfo	(Lcom/huawei/remoteLoader/client/a;)Lcom/huawei/remoteLoader/client/ARRemoteLibraryLoader;
    //   34: putstatic 54	com/huawei/remoteLoader/client/ARDynamiteClient:remoteLibLoader	Lcom/huawei/remoteLoader/client/ARRemoteLibraryLoader;
    //   37: getstatic 54	com/huawei/remoteLoader/client/ARDynamiteClient:remoteLibLoader	Lcom/huawei/remoteLoader/client/ARRemoteLibraryLoader;
    //   40: aload_0
    //   41: invokevirtual 91	com/huawei/remoteLoader/client/ARRemoteLibraryLoader:getRemoteCreator	(Landroid/content/Context;)Lcom/huawei/arengine/remoteLoader/ILoaderProducer;
    //   44: putstatic 58	com/huawei/remoteLoader/client/ARDynamiteClient:loaderProducer	Lcom/huawei/arengine/remoteLoader/ILoaderProducer;
    //   47: getstatic 54	com/huawei/remoteLoader/client/ARDynamiteClient:remoteLibLoader	Lcom/huawei/remoteLoader/client/ARRemoteLibraryLoader;
    //   50: aload_0
    //   51: invokevirtual 95	com/huawei/remoteLoader/client/ARRemoteLibraryLoader:getRemoteContext	(Landroid/content/Context;)Landroid/content/Context;
    //   54: astore_1
    //   55: getstatic 58	com/huawei/remoteLoader/client/ARDynamiteClient:loaderProducer	Lcom/huawei/arengine/remoteLoader/ILoaderProducer;
    //   58: aload_1
    //   59: invokestatic 101	com/huawei/remoteLoader/client/ARObjectWrapper:wrap	(Ljava/lang/Object;)Lcom/huawei/arengine/remoteLoader/IObjectWrapper;
    //   62: aload_0
    //   63: invokestatic 101	com/huawei/remoteLoader/client/ARObjectWrapper:wrap	(Ljava/lang/Object;)Lcom/huawei/arengine/remoteLoader/IObjectWrapper;
    //   66: invokeinterface 107 3 0
    //   71: putstatic 60	com/huawei/remoteLoader/client/ARDynamiteClient:loader	Lcom/huawei/arengine/remoteLoader/IDynamicLoader;
    //   74: getstatic 60	com/huawei/remoteLoader/client/ARDynamiteClient:loader	Lcom/huawei/arengine/remoteLoader/IDynamicLoader;
    //   77: ldc2_w 108
    //   80: iload_3
    //   81: invokeinterface 115 4 0
    //   86: istore 4
    //   88: ldc 2
    //   90: monitorexit
    //   91: iload 4
    //   93: ireturn
    //   94: astore_0
    //   95: aconst_null
    //   96: putstatic 60	com/huawei/remoteLoader/client/ARDynamiteClient:loader	Lcom/huawei/arengine/remoteLoader/IDynamicLoader;
    //   99: aconst_null
    //   100: putstatic 56	com/huawei/remoteLoader/client/ARDynamiteClient:info	Lcom/huawei/remoteLoader/client/a;
    //   103: aconst_null
    //   104: putstatic 54	com/huawei/remoteLoader/client/ARDynamiteClient:remoteLibLoader	Lcom/huawei/remoteLoader/client/ARRemoteLibraryLoader;
    //   107: aconst_null
    //   108: putstatic 58	com/huawei/remoteLoader/client/ARDynamiteClient:loaderProducer	Lcom/huawei/arengine/remoteLoader/ILoaderProducer;
    //   111: aload_0
    //   112: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   115: iload 5
    //   117: istore 4
    //   119: goto -31 -> 88
    //   122: astore_0
    //   123: ldc 2
    //   125: monitorexit
    //   126: aload_0
    //   127: athrow
    //   128: astore_0
    //   129: goto -34 -> 95
    //   132: astore_0
    //   133: goto -38 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramContext	Context
    //   0	136	1	paramString1	String
    //   0	136	2	paramString2	String
    //   0	136	3	paramBoolean	boolean
    //   8	110	4	bool1	boolean
    //   1	115	5	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   37	88	94	android/os/RemoteException
    //   10	37	122	finally
    //   37	88	122	finally
    //   95	115	122	finally
    //   37	88	128	java/lang/IllegalStateException
    //   37	88	132	com/huawei/remoteLoader/client/ARLoaderException
  }
  
  private static void copyFile(Context paramContext, String paramString1, String paramString2)
  {
    Log.i(TAG, "copyFile" + paramString1);
    try
    {
      paramContext = new BufferedInputStream(paramContext.getAssets().open(paramString1));
      paramString1 = new BufferedOutputStream(new FileOutputStream(paramString2 + File.separator + paramString1));
      paramString2 = new byte[1024];
      for (;;)
      {
        int i = paramContext.read(paramString2, 0, 1024);
        if (i <= 0) {
          break;
        }
        paramString1.write(paramString2, 0, i);
      }
      return;
    }
    catch (FileNotFoundException paramContext)
    {
      Log.e(TAG, paramContext.getMessage());
      return;
      paramString1.close();
      paramContext.close();
      return;
    }
    catch (IOException paramContext)
    {
      Log.e(TAG, paramContext.getMessage());
    }
  }
  
  private static void deleteCachedFile(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString2 + File.separator + paramString1);
    if (!paramString1.exists())
    {
      Log.i(TAG, "No cached jar file!");
      return;
    }
    if (paramString1.isFile())
    {
      if (paramString1.delete())
      {
        Log.w(TAG, "Cached jar file is deleted!");
        return;
      }
      Log.e(TAG, "Delete failed!");
      return;
    }
    Log.e(TAG, "Path is invalid!");
  }
  
  public static Class getLoadClass(String paramString)
  {
    if (paramString == null)
    {
      Log.e(TAG, "Input is null!");
      return null;
    }
    synchronized (syncObject)
    {
      if (cl != null) {
        break label97;
      }
      Log.i(TAG, "Need to init Loader");
      if (fileName == null)
      {
        Log.e(TAG, "FileName is null,failed to init loader!");
        return null;
      }
    }
    if (loaderContext == null)
    {
      Log.e(TAG, "LoaderContext is null,failed to init loader!");
      return null;
    }
    Log.i(TAG, "Start init Loader");
    initDexLoader(loaderContext, fileName);
    try
    {
      label97:
      paramString = cl.loadClass(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.w(TAG, paramString.getMessage());
    }
    return null;
  }
  
  @UsedByNative("dynamite_client.cpp")
  public static ClassLoader getRemoteClassLoader(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject = null;
    try
    {
      paramString1 = new a(paramString1, paramString2);
      ARRemoteLibraryLoader localARRemoteLibraryLoader = getRemoteLibraryLoaderFromInfo(paramString1);
      Log.d(TAG, "getRemoteClassLoader[" + paramString2 + "]");
      try
      {
        paramString2 = localARRemoteLibraryLoader.getRemoteContext(paramContext);
        paramContext = localObject;
        if (paramString2 != null) {
          paramContext = paramString2.getClassLoader();
        }
      }
      catch (ARLoaderException paramContext)
      {
        for (;;)
        {
          String.valueOf(paramString1);
          Log.e(TAG, "Failed to get remote Context" + paramString1 + " from remote package:\n  ", paramContext);
          paramContext = localObject;
        }
      }
      return paramContext;
    }
    finally {}
  }
  
  private static ARRemoteLibraryLoader getRemoteLibraryLoaderFromInfo(a parama)
  {
    try
    {
      ARRemoteLibraryLoader localARRemoteLibraryLoader2 = (ARRemoteLibraryLoader)targetLibraries.get(parama);
      ARRemoteLibraryLoader localARRemoteLibraryLoader1 = localARRemoteLibraryLoader2;
      if (localARRemoteLibraryLoader2 == null)
      {
        localARRemoteLibraryLoader1 = new ARRemoteLibraryLoader(parama);
        targetLibraries.put(parama, localARRemoteLibraryLoader1);
      }
      return localARRemoteLibraryLoader1;
    }
    finally {}
  }
  
  private static void initDexLoader(Context paramContext, String paramString)
  {
    cl = new DexClassLoader(paramContext.getFilesDir().getAbsolutePath() + File.separator + paramString, paramContext.getCacheDir().getAbsolutePath(), null, paramContext.getClassLoader());
    Log.i(TAG, "initDexLoader");
  }
  
  public static void jumpToAppMarket(Context paramContext)
  {
    Log.d(TAG, "jumpToAppMarket");
    Object localObject = getLoadClass("com.huawei.hiar.update.HuaweiArApkImpl");
    if (localObject == null)
    {
      Log.d(TAG, "DexLoader find no class");
      try
      {
        Class localClass = Class.forName("com.huawei.hiar.j");
        localObject = localClass;
        while (localObject != null) {}
        Log.w(TAG, "huaweiArApkImplClass find no class");
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        try
        {
          localObject = ((Class)localObject).getMethod("jumpToAppMarket", new Class[] { Context.class });
          ((Method)localObject).setAccessible(true);
          ((Method)localObject).invoke(null, new Object[] { paramContext });
          return;
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
          return;
        }
        localClassNotFoundException = localClassNotFoundException;
        localClassNotFoundException.printStackTrace();
      }
    }
  }
  
  /* Error */
  @UsedByNative("dynamite_client.cpp")
  public static long loadNativeRemoteLibrary(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_3
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 60	com/huawei/remoteLoader/client/ARDynamiteClient:loader	Lcom/huawei/arengine/remoteLoader/IDynamicLoader;
    //   8: ifnonnull +61 -> 69
    //   11: new 78	com/huawei/remoteLoader/client/a
    //   14: dup
    //   15: aload_1
    //   16: aload_2
    //   17: invokespecial 81	com/huawei/remoteLoader/client/a:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: putstatic 56	com/huawei/remoteLoader/client/ARDynamiteClient:info	Lcom/huawei/remoteLoader/client/a;
    //   23: getstatic 56	com/huawei/remoteLoader/client/ARDynamiteClient:info	Lcom/huawei/remoteLoader/client/a;
    //   26: invokestatic 85	com/huawei/remoteLoader/client/ARDynamiteClient:getRemoteLibraryLoaderFromInfo	(Lcom/huawei/remoteLoader/client/a;)Lcom/huawei/remoteLoader/client/ARRemoteLibraryLoader;
    //   29: putstatic 54	com/huawei/remoteLoader/client/ARDynamiteClient:remoteLibLoader	Lcom/huawei/remoteLoader/client/ARRemoteLibraryLoader;
    //   32: getstatic 54	com/huawei/remoteLoader/client/ARDynamiteClient:remoteLibLoader	Lcom/huawei/remoteLoader/client/ARRemoteLibraryLoader;
    //   35: aload_0
    //   36: invokevirtual 91	com/huawei/remoteLoader/client/ARRemoteLibraryLoader:getRemoteCreator	(Landroid/content/Context;)Lcom/huawei/arengine/remoteLoader/ILoaderProducer;
    //   39: putstatic 58	com/huawei/remoteLoader/client/ARDynamiteClient:loaderProducer	Lcom/huawei/arengine/remoteLoader/ILoaderProducer;
    //   42: getstatic 54	com/huawei/remoteLoader/client/ARDynamiteClient:remoteLibLoader	Lcom/huawei/remoteLoader/client/ARRemoteLibraryLoader;
    //   45: aload_0
    //   46: invokevirtual 95	com/huawei/remoteLoader/client/ARRemoteLibraryLoader:getRemoteContext	(Landroid/content/Context;)Landroid/content/Context;
    //   49: astore_1
    //   50: getstatic 58	com/huawei/remoteLoader/client/ARDynamiteClient:loaderProducer	Lcom/huawei/arengine/remoteLoader/ILoaderProducer;
    //   53: aload_1
    //   54: invokestatic 101	com/huawei/remoteLoader/client/ARObjectWrapper:wrap	(Ljava/lang/Object;)Lcom/huawei/arengine/remoteLoader/IObjectWrapper;
    //   57: aload_0
    //   58: invokestatic 101	com/huawei/remoteLoader/client/ARObjectWrapper:wrap	(Ljava/lang/Object;)Lcom/huawei/arengine/remoteLoader/IObjectWrapper;
    //   61: invokeinterface 107 3 0
    //   66: putstatic 60	com/huawei/remoteLoader/client/ARDynamiteClient:loader	Lcom/huawei/arengine/remoteLoader/IDynamicLoader;
    //   69: getstatic 60	com/huawei/remoteLoader/client/ARDynamiteClient:loader	Lcom/huawei/arengine/remoteLoader/IDynamicLoader;
    //   72: aload_2
    //   73: invokeinterface 340 2 0
    //   78: lstore 5
    //   80: lload 5
    //   82: lstore_3
    //   83: ldc 2
    //   85: monitorexit
    //   86: lload_3
    //   87: lreturn
    //   88: astore_0
    //   89: aload_0
    //   90: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   93: aconst_null
    //   94: putstatic 60	com/huawei/remoteLoader/client/ARDynamiteClient:loader	Lcom/huawei/arengine/remoteLoader/IDynamicLoader;
    //   97: aconst_null
    //   98: putstatic 56	com/huawei/remoteLoader/client/ARDynamiteClient:info	Lcom/huawei/remoteLoader/client/a;
    //   101: aconst_null
    //   102: putstatic 54	com/huawei/remoteLoader/client/ARDynamiteClient:remoteLibLoader	Lcom/huawei/remoteLoader/client/ARRemoteLibraryLoader;
    //   105: aconst_null
    //   106: putstatic 58	com/huawei/remoteLoader/client/ARDynamiteClient:loaderProducer	Lcom/huawei/arengine/remoteLoader/ILoaderProducer;
    //   109: goto -26 -> 83
    //   112: astore_0
    //   113: ldc 2
    //   115: monitorexit
    //   116: aload_0
    //   117: athrow
    //   118: astore_1
    //   119: getstatic 45	com/huawei/remoteLoader/client/ARDynamiteClient:TAG	Ljava/lang/String;
    //   122: ldc_w 342
    //   125: invokestatic 191	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   128: pop
    //   129: aload_0
    //   130: invokestatic 344	com/huawei/remoteLoader/client/ARDynamiteClient:jumpToAppMarket	(Landroid/content/Context;)V
    //   133: goto -50 -> 83
    //   136: astore_0
    //   137: getstatic 45	com/huawei/remoteLoader/client/ARDynamiteClient:TAG	Ljava/lang/String;
    //   140: ldc_w 346
    //   143: invokestatic 191	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   146: pop
    //   147: aload_0
    //   148: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   151: goto -68 -> 83
    //   154: astore_0
    //   155: goto -66 -> 89
    //   158: astore_0
    //   159: goto -70 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramContext	Context
    //   0	162	1	paramString1	String
    //   0	162	2	paramString2	String
    //   1	86	3	l1	long
    //   78	3	5	l2	long
    // Exception table:
    //   from	to	target	type
    //   32	69	88	android/os/RemoteException
    //   5	32	112	finally
    //   32	69	112	finally
    //   69	80	112	finally
    //   89	109	112	finally
    //   119	133	112	finally
    //   137	151	112	finally
    //   69	80	118	java/lang/UnsatisfiedLinkError
    //   69	80	136	java/lang/Exception
    //   32	69	154	java/lang/IllegalStateException
    //   32	69	158	com/huawei/remoteLoader/client/ARLoaderException
  }
  
  @UsedByNative("HuaweiArapk.cc")
  public static String unzipBaseApkGetDex(Context paramContext, String paramString)
  {
    Log.i(TAG, "SDK version name is :[1.7.0],version code is :[56]");
    String str = paramContext.getFilesDir().getAbsolutePath();
    deleteCachedFile(paramString, str);
    fileName = paramString;
    loaderContext = paramContext;
    return str;
  }
  
  /* Error */
  @UsedByNative("dynamite_client.cc")
  public static boolean updateResourceFromRemote(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 60	com/huawei/remoteLoader/client/ARDynamiteClient:loader	Lcom/huawei/arengine/remoteLoader/IDynamicLoader;
    //   8: ifnonnull +43 -> 51
    //   11: getstatic 45	com/huawei/remoteLoader/client/ARDynamiteClient:TAG	Ljava/lang/String;
    //   14: new 128	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   21: ldc_w 357
    //   24: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: getstatic 56	com/huawei/remoteLoader/client/ARDynamiteClient:info	Lcom/huawei/remoteLoader/client/a;
    //   30: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   33: ldc_w 359
    //   36: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 191	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   45: pop
    //   46: ldc 2
    //   48: monitorexit
    //   49: iload_2
    //   50: ireturn
    //   51: getstatic 60	com/huawei/remoteLoader/client/ARDynamiteClient:loader	Lcom/huawei/arengine/remoteLoader/IDynamicLoader;
    //   54: aload_0
    //   55: aload_1
    //   56: invokeinterface 361 3 0
    //   61: istore_3
    //   62: iload_3
    //   63: istore_2
    //   64: goto -18 -> 46
    //   67: astore_0
    //   68: getstatic 45	com/huawei/remoteLoader/client/ARDynamiteClient:TAG	Ljava/lang/String;
    //   71: ldc_w 363
    //   74: invokestatic 191	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   77: pop
    //   78: goto -32 -> 46
    //   81: astore_0
    //   82: ldc 2
    //   84: monitorexit
    //   85: aload_0
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	paramString1	String
    //   0	87	1	paramString2	String
    //   1	63	2	bool1	boolean
    //   61	2	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   51	62	67	java/lang/Exception
    //   5	46	81	finally
    //   51	62	81	finally
    //   68	78	81	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.remoteLoader.client.ARDynamiteClient
 * JD-Core Version:    0.7.0.1
 */