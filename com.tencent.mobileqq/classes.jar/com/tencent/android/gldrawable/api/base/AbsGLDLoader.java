package com.tencent.android.gldrawable.api.base;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.android.gldrawable.api.GLDrawableApi;
import com.tencent.android.gldrawable.api.IConfigStub;
import com.tencent.android.gldrawable.api.IGLDrawableLoader;
import com.tencent.android.gldrawable.api.ILoadUtils;
import com.tencent.android.gldrawable.api.ILoaderCallback;
import com.tencent.android.gldrawable.api.IReporter;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/android/gldrawable/api/base/AbsGLDLoader;", "Lcom/tencent/android/gldrawable/api/IGLDrawableLoader;", "()V", "classLoader", "Ldalvik/system/DexClassLoader;", "isLoaded", "", "()Z", "setLoaded", "(Z)V", "isLoading", "isStatic", "libRootDir", "Ljava/io/File;", "getLibRootDir", "()Ljava/io/File;", "libRootDir$delegate", "Lkotlin/Lazy;", "fakeLoadApk", "", "callback", "Lcom/tencent/android/gldrawable/api/ILoaderCallback;", "getClassLoader", "Ljava/lang/ClassLoader;", "getInstallRoot", "initClassLoader", "installRoot", "apkFile", "is64Bit", "isX86", "loadSync", "onLoadSucess", "syncDoLoadApk", "waitDownloadFinished", "context", "Landroid/content/Context;", "Companion", "api_release"}, k=1, mv={1, 1, 16})
public abstract class AbsGLDLoader
  implements IGLDrawableLoader
{
  private static final String APK_NAME = "gldrawable.apk";
  public static final AbsGLDLoader.Companion Companion = new AbsGLDLoader.Companion(null);
  private static final String OPT_DIT = "opt";
  private static final int WAIT_DOWNLOAD = 5000;
  private DexClassLoader classLoader;
  private boolean isLoaded;
  private boolean isLoading;
  private final boolean isStatic;
  private final Lazy libRootDir$delegate = LazyKt.lazy((Function0)new AbsGLDLoader.libRootDir.2(this));
  
  private final void fakeLoadApk(ILoaderCallback paramILoaderCallback)
  {
    if (isLoaded())
    {
      paramILoaderCallback.onLoadSucceed();
      return;
    }
    paramILoaderCallback.onLoadFailed();
  }
  
  private final File getInstallRoot()
  {
    if (!getLibRootDir().exists()) {
      getLibRootDir().mkdirs();
    }
    return getLibRootDir();
  }
  
  private final File getLibRootDir()
  {
    return (File)this.libRootDir$delegate.getValue();
  }
  
  private final DexClassLoader initClassLoader(File paramFile1, File paramFile2)
  {
    if (paramFile1.exists())
    {
      if (!paramFile2.exists()) {
        return null;
      }
      Object localObject1 = new File(paramFile1, "gldrawable.apk");
      if (!getLoaderUtils().checkCRC((File)localObject1, paramFile2))
      {
        getLoaderUtils().deleteFilesInDirectory(paramFile1);
        getLoaderUtils().copyFile(paramFile2, (File)localObject1);
        getLoaderUtils().unzipFile((File)localObject1, paramFile1);
      }
      if (!isX86())
      {
        if (!is64Bit()) {
          paramFile2 = new File(paramFile1, "/lib/armeabi-v7a");
        } else {
          paramFile2 = new File(paramFile1, "/lib/arm64-v8a");
        }
      }
      else if (!is64Bit()) {
        paramFile2 = new File(paramFile1, "/lib/x86");
      } else {
        paramFile2 = new File(paramFile1, "/lib/x86_64");
      }
      if (paramFile2.exists())
      {
        if (!paramFile2.isDirectory()) {
          return null;
        }
        Object localObject2 = new File(paramFile1, "opt");
        if (!((File)localObject2).exists()) {
          ((File)localObject2).mkdirs();
        }
        paramFile1 = ((File)localObject1).getAbsolutePath();
        Intrinsics.checkExpressionValueIsNotNull(paramFile1, "installFile.absolutePath");
        localObject1 = ((File)localObject2).getAbsolutePath();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "optimizedDirectory.absolutePath");
        paramFile2 = paramFile2.getAbsolutePath();
        localObject2 = AbsGLDLoader.class.getClassLoader();
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "AbsGLDLoader::class.java.classLoader!!");
        return (DexClassLoader)new GLDClassLoader(paramFile1, (String)localObject1, paramFile2, (ClassLoader)localObject2);
      }
    }
    return null;
  }
  
  private final boolean is64Bit()
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return Process.is64Bit();
    }
    try
    {
      if (Build.VERSION.SDK_INT < 21) {
        return false;
      }
      Object localObject1 = Class.forName("dalvik.system.VMRuntime");
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "Class.forName(\"dalvik.system.VMRuntime\")");
      Object localObject2 = ((Class)localObject1).getDeclaredMethod("getRuntime", new Class[0]).invoke(null, new Object[0]);
      localObject1 = ((Class)localObject1).getDeclaredMethod("is64Bit", new Class[0]).invoke(localObject2, new Object[0]);
      if ((localObject1 instanceof Boolean))
      {
        boolean bool = ((Boolean)localObject1).booleanValue();
        return bool;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
  
  private final boolean isX86()
  {
    try
    {
      Object localObject1 = Build.CPU_ABI;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "abi");
      int i = ((CharSequence)localObject1).length();
      if (i > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i != 0) && (StringsKt.equals("x86", (String)localObject1, true))) {
        return true;
      }
      if (Build.VERSION.SDK_INT >= 21)
      {
        localObject1 = Build.SUPPORTED_ABIS;
        int j = localObject1.length;
        i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            Intrinsics.checkExpressionValueIsNotNull(localObject2, "platform");
            if (localObject2 != null)
            {
              localObject2 = ((String)localObject2).toLowerCase();
              Intrinsics.checkExpressionValueIsNotNull(localObject2, "(this as java.lang.String).toLowerCase()");
              if (StringsKt.contains$default((CharSequence)localObject2, (CharSequence)"x86", false, 2, null)) {
                return true;
              }
            }
            else
            {
              throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
          }
          i += 1;
        }
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  /* Error */
  private final void syncDoLoadApk(ILoaderCallback paramILoaderCallback)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 128	com/tencent/android/gldrawable/api/base/AbsGLDLoader:getLoaderUtils	()Lcom/tencent/android/gldrawable/api/ILoadUtils;
    //   4: invokeinterface 287 1 0
    //   9: astore 4
    //   11: aload_0
    //   12: aload 4
    //   14: checkcast 289	android/content/Context
    //   17: invokespecial 292	com/tencent/android/gldrawable/api/base/AbsGLDLoader:waitDownloadFinished	(Landroid/content/Context;)Z
    //   20: ifne +50 -> 70
    //   23: getstatic 298	com/tencent/android/gldrawable/api/GLDrawableApi:INSTANCE	Lcom/tencent/android/gldrawable/api/GLDrawableApi;
    //   26: invokevirtual 302	com/tencent/android/gldrawable/api/GLDrawableApi:getLogger$api_release	()Lcom/tencent/android/gldrawable/api/IReporter;
    //   29: ldc_w 304
    //   32: ldc_w 306
    //   35: ldc_w 308
    //   38: lconst_0
    //   39: bipush 8
    //   41: aconst_null
    //   42: invokestatic 314	com/tencent/android/gldrawable/api/IReporter$DefaultImpls:report$default	(Lcom/tencent/android/gldrawable/api/IReporter;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JILjava/lang/Object;)V
    //   45: aload_0
    //   46: invokevirtual 96	com/tencent/android/gldrawable/api/base/AbsGLDLoader:isLoaded	()Z
    //   49: ifeq +14 -> 63
    //   52: aload_1
    //   53: invokeinterface 101 1 0
    //   58: aload_0
    //   59: invokevirtual 316	com/tencent/android/gldrawable/api/base/AbsGLDLoader:onLoadSucess	()V
    //   62: return
    //   63: aload_1
    //   64: invokeinterface 104 1 0
    //   69: return
    //   70: invokestatic 322	android/os/SystemClock:uptimeMillis	()J
    //   73: lstore_2
    //   74: aload_0
    //   75: aload_0
    //   76: invokespecial 324	com/tencent/android/gldrawable/api/base/AbsGLDLoader:getInstallRoot	()Ljava/io/File;
    //   79: aload_0
    //   80: invokevirtual 128	com/tencent/android/gldrawable/api/base/AbsGLDLoader:getLoaderUtils	()Lcom/tencent/android/gldrawable/api/ILoadUtils;
    //   83: aload 4
    //   85: checkcast 289	android/content/Context
    //   88: invokeinterface 328 2 0
    //   93: invokespecial 330	com/tencent/android/gldrawable/api/base/AbsGLDLoader:initClassLoader	(Ljava/io/File;Ljava/io/File;)Ldalvik/system/DexClassLoader;
    //   96: astore 4
    //   98: aload 4
    //   100: ifnull +42 -> 142
    //   103: aload_0
    //   104: aload 4
    //   106: putfield 332	com/tencent/android/gldrawable/api/base/AbsGLDLoader:classLoader	Ldalvik/system/DexClassLoader;
    //   109: aload_0
    //   110: iconst_1
    //   111: invokevirtual 334	com/tencent/android/gldrawable/api/base/AbsGLDLoader:setLoaded	(Z)V
    //   114: getstatic 298	com/tencent/android/gldrawable/api/GLDrawableApi:INSTANCE	Lcom/tencent/android/gldrawable/api/GLDrawableApi;
    //   117: invokevirtual 302	com/tencent/android/gldrawable/api/GLDrawableApi:getLogger$api_release	()Lcom/tencent/android/gldrawable/api/IReporter;
    //   120: ldc_w 304
    //   123: ldc_w 336
    //   126: ldc_w 337
    //   129: invokestatic 322	android/os/SystemClock:uptimeMillis	()J
    //   132: lload_2
    //   133: lsub
    //   134: invokeinterface 343 6 0
    //   139: goto +25 -> 164
    //   142: getstatic 298	com/tencent/android/gldrawable/api/GLDrawableApi:INSTANCE	Lcom/tencent/android/gldrawable/api/GLDrawableApi;
    //   145: invokevirtual 302	com/tencent/android/gldrawable/api/GLDrawableApi:getLogger$api_release	()Lcom/tencent/android/gldrawable/api/IReporter;
    //   148: ldc_w 304
    //   151: ldc_w 306
    //   154: ldc_w 345
    //   157: lconst_0
    //   158: bipush 8
    //   160: aconst_null
    //   161: invokestatic 314	com/tencent/android/gldrawable/api/IReporter$DefaultImpls:report$default	(Lcom/tencent/android/gldrawable/api/IReporter;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JILjava/lang/Object;)V
    //   164: aload_0
    //   165: invokevirtual 96	com/tencent/android/gldrawable/api/base/AbsGLDLoader:isLoaded	()Z
    //   168: ifeq +14 -> 182
    //   171: aload_1
    //   172: invokeinterface 101 1 0
    //   177: aload_0
    //   178: invokevirtual 316	com/tencent/android/gldrawable/api/base/AbsGLDLoader:onLoadSucess	()V
    //   181: return
    //   182: aload_1
    //   183: invokeinterface 104 1 0
    //   188: return
    //   189: astore 4
    //   191: goto +47 -> 238
    //   194: astore 4
    //   196: getstatic 298	com/tencent/android/gldrawable/api/GLDrawableApi:INSTANCE	Lcom/tencent/android/gldrawable/api/GLDrawableApi;
    //   199: invokevirtual 302	com/tencent/android/gldrawable/api/GLDrawableApi:getLogger$api_release	()Lcom/tencent/android/gldrawable/api/IReporter;
    //   202: ldc_w 304
    //   205: ldc_w 306
    //   208: aload 4
    //   210: invokevirtual 348	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   213: invokestatic 352	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   216: lconst_0
    //   217: bipush 8
    //   219: aconst_null
    //   220: invokestatic 314	com/tencent/android/gldrawable/api/IReporter$DefaultImpls:report$default	(Lcom/tencent/android/gldrawable/api/IReporter;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JILjava/lang/Object;)V
    //   223: aload 4
    //   225: invokevirtual 353	java/lang/Exception:printStackTrace	()V
    //   228: aload_0
    //   229: invokevirtual 96	com/tencent/android/gldrawable/api/base/AbsGLDLoader:isLoaded	()Z
    //   232: ifeq -50 -> 182
    //   235: goto -64 -> 171
    //   238: aload_0
    //   239: invokevirtual 96	com/tencent/android/gldrawable/api/base/AbsGLDLoader:isLoaded	()Z
    //   242: ifeq +16 -> 258
    //   245: aload_1
    //   246: invokeinterface 101 1 0
    //   251: aload_0
    //   252: invokevirtual 316	com/tencent/android/gldrawable/api/base/AbsGLDLoader:onLoadSucess	()V
    //   255: goto +9 -> 264
    //   258: aload_1
    //   259: invokeinterface 104 1 0
    //   264: goto +6 -> 270
    //   267: aload 4
    //   269: athrow
    //   270: goto -3 -> 267
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	this	AbsGLDLoader
    //   0	273	1	paramILoaderCallback	ILoaderCallback
    //   73	60	2	l	long
    //   9	96	4	localObject1	Object
    //   189	1	4	localObject2	Object
    //   194	74	4	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	45	189	finally
    //   70	98	189	finally
    //   103	139	189	finally
    //   142	164	189	finally
    //   196	228	189	finally
    //   0	45	194	java/lang/Exception
    //   70	98	194	java/lang/Exception
    //   103	139	194	java/lang/Exception
    //   142	164	194	java/lang/Exception
  }
  
  private final boolean waitDownloadFinished(Context paramContext)
  {
    paramContext = getLoaderUtils().getApkFile(paramContext);
    long l = SystemClock.uptimeMillis();
    IReporter localIReporter = GLDrawableApi.INSTANCE.getLogger$api_release();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("load apk: ");
    localStringBuilder.append(paramContext.getAbsoluteFile());
    localIReporter.logI(localStringBuilder.toString());
    do
    {
      if (paramContext.exists()) {
        return true;
      }
      SystemClock.sleep(100L);
    } while (SystemClock.uptimeMillis() - l < 5000);
    return false;
  }
  
  @Nullable
  public ClassLoader getClassLoader()
  {
    return (ClassLoader)this.classLoader;
  }
  
  public boolean isLoaded()
  {
    return this.isLoaded;
  }
  
  public boolean isStatic()
  {
    return this.isStatic;
  }
  
  /* Error */
  public void loadSync(@org.jetbrains.annotations.NotNull ILoaderCallback paramILoaderCallback)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 390
    //   4: invokestatic 393	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   7: aload_0
    //   8: iconst_1
    //   9: putfield 395	com/tencent/android/gldrawable/api/base/AbsGLDLoader:isLoading	Z
    //   12: aload_0
    //   13: invokevirtual 96	com/tencent/android/gldrawable/api/base/AbsGLDLoader:isLoaded	()Z
    //   16: ifeq +14 -> 30
    //   19: aload_0
    //   20: aload_1
    //   21: invokespecial 397	com/tencent/android/gldrawable/api/base/AbsGLDLoader:fakeLoadApk	(Lcom/tencent/android/gldrawable/api/ILoaderCallback;)V
    //   24: aload_0
    //   25: iconst_0
    //   26: putfield 395	com/tencent/android/gldrawable/api/base/AbsGLDLoader:isLoading	Z
    //   29: return
    //   30: ldc 2
    //   32: monitorenter
    //   33: aload_0
    //   34: invokevirtual 96	com/tencent/android/gldrawable/api/base/AbsGLDLoader:isLoaded	()Z
    //   37: ifeq +17 -> 54
    //   40: aload_0
    //   41: aload_1
    //   42: invokespecial 397	com/tencent/android/gldrawable/api/base/AbsGLDLoader:fakeLoadApk	(Lcom/tencent/android/gldrawable/api/ILoaderCallback;)V
    //   45: ldc 2
    //   47: monitorexit
    //   48: aload_0
    //   49: iconst_0
    //   50: putfield 395	com/tencent/android/gldrawable/api/base/AbsGLDLoader:isLoading	Z
    //   53: return
    //   54: aload_0
    //   55: aload_1
    //   56: invokespecial 399	com/tencent/android/gldrawable/api/base/AbsGLDLoader:syncDoLoadApk	(Lcom/tencent/android/gldrawable/api/ILoaderCallback;)V
    //   59: getstatic 404	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   62: astore_1
    //   63: ldc 2
    //   65: monitorexit
    //   66: aload_0
    //   67: iconst_0
    //   68: putfield 395	com/tencent/android/gldrawable/api/base/AbsGLDLoader:isLoading	Z
    //   71: return
    //   72: astore_1
    //   73: ldc 2
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    //   78: astore_1
    //   79: aload_0
    //   80: iconst_0
    //   81: putfield 395	com/tencent/android/gldrawable/api/base/AbsGLDLoader:isLoading	Z
    //   84: aload_1
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	AbsGLDLoader
    //   0	86	1	paramILoaderCallback	ILoaderCallback
    // Exception table:
    //   from	to	target	type
    //   33	45	72	finally
    //   54	63	72	finally
    //   12	24	78	finally
    //   30	33	78	finally
    //   45	48	78	finally
    //   63	66	78	finally
    //   73	78	78	finally
  }
  
  public void onLoadSucess()
  {
    GLDrawableApi.config().setLogger(GLDrawableApi.INSTANCE.getLogger$api_release());
  }
  
  public void setLoaded(boolean paramBoolean)
  {
    this.isLoaded = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.api.base.AbsGLDLoader
 * JD-Core Version:    0.7.0.1
 */