package com.facebook.soloader;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.text.TextUtils;
import android.util.Log;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

public class SoLoader
{
  static final boolean DEBUG = false;
  public static final int SOLOADER_ALLOW_ASYNC_INIT = 2;
  public static final int SOLOADER_ENABLE_EXOPACKAGE = 1;
  public static final int SOLOADER_LOOK_IN_ZIP = 4;
  private static String SO_STORE_NAME_MAIN = "lib-main";
  static final boolean SYSTRACE_LIBRARY_LOADING;
  static final String TAG = "SoLoader";
  private static int sFlags;
  private static final Set<String> sLoadedLibraries;
  @Nullable
  private static StrictMode.ThreadPolicy sOldPolicy;
  static SoFileLoader sSoFileLoader;
  @Nullable
  private static SoSource[] sSoSources = null;
  @Nullable
  private static SystemLoadLibraryWrapper sSystemLoadLibraryWrapper;
  
  static
  {
    sLoadedLibraries = new HashSet();
    sOldPolicy = null;
    sSystemLoadLibraryWrapper = null;
    for (boolean bool = false;; bool = false)
    {
      try
      {
        int i = Build.VERSION.SDK_INT;
        if (i < 18) {
          continue;
        }
        bool = true;
      }
      catch (NoClassDefFoundError localNoClassDefFoundError)
      {
        break label41;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        label41:
        break label41;
      }
      SYSTRACE_LIBRARY_LOADING = bool;
      return;
    }
  }
  
  public static boolean areSoSourcesAbisSupported()
  {
    SoSource[] arrayOfSoSource = sSoSources;
    if (arrayOfSoSource == null) {
      return false;
    }
    String[] arrayOfString1 = SysUtil.getSupportedAbis();
    int i = 0;
    for (;;)
    {
      if (i >= arrayOfSoSource.length) {
        break label96;
      }
      String[] arrayOfString2 = arrayOfSoSource[i].getSoSourceAbis();
      int j = 0;
      for (;;)
      {
        if (j >= arrayOfString2.length) {
          break label89;
        }
        boolean bool = false;
        int k = 0;
        while ((k < arrayOfString1.length) && (!bool))
        {
          bool = arrayOfString2[j].equals(arrayOfString1[k]);
          k += 1;
        }
        if (!bool) {
          break;
        }
        j += 1;
      }
      label89:
      i += 1;
    }
    label96:
    return true;
  }
  
  private static void assertInitialized()
  {
    if (sSoSources == null) {
      throw new RuntimeException("SoLoader.init() not yet called");
    }
  }
  
  public static void deinitForTest()
  {
    sSoSources = null;
  }
  
  public static Set<String> getLoadedLibrariesNames()
  {
    return sLoadedLibraries;
  }
  
  private static Method getNativeLoadRuntimeMethod()
  {
    if (Build.VERSION.SDK_INT < 23) {
      return null;
    }
    try
    {
      Method localMethod = Runtime.class.getDeclaredMethod("nativeLoad", new Class[] { String.class, ClassLoader.class, String.class });
      localMethod.setAccessible(true);
      return localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Log.w("SoLoader", "Cannot get nativeLoad method", localNoSuchMethodException);
      return null;
    }
    catch (SecurityException localSecurityException)
    {
      label45:
      break label45;
    }
  }
  
  public static void init(Context paramContext, int paramInt)
    throws IOException
  {
    init(paramContext, paramInt, null);
  }
  
  public static void init(Context paramContext, int paramInt, @Nullable SoFileLoader paramSoFileLoader)
    throws IOException
  {
    StrictMode.ThreadPolicy localThreadPolicy = StrictMode.allowThreadDiskWrites();
    try
    {
      initImpl(paramContext, paramInt, paramSoFileLoader);
      return;
    }
    finally
    {
      StrictMode.setThreadPolicy(localThreadPolicy);
    }
  }
  
  public static void init(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      try
      {
        init(paramContext, i);
        return;
      }
      catch (IOException paramContext)
      {
        throw new RuntimeException(paramContext);
      }
    }
  }
  
  private static void initImpl(Context paramContext, int paramInt, @Nullable SoFileLoader paramSoFileLoader)
    throws IOException
  {
    for (;;)
    {
      ArrayList localArrayList;
      int i;
      try
      {
        if (sSoSources != null) {
          break label275;
        }
        sFlags = paramInt;
        initSoLoader(paramSoFileLoader);
        localArrayList = new ArrayList();
        String str = System.getenv("LD_LIBRARY_PATH");
        paramSoFileLoader = str;
        if (str == null) {
          paramSoFileLoader = "/vendor/lib:/system/lib";
        }
        paramSoFileLoader = paramSoFileLoader.split(":");
        i = 0;
        if (i < paramSoFileLoader.length)
        {
          localArrayList.add(new DirectorySoSource(new File(paramSoFileLoader[i]), 2));
          i += 1;
          continue;
        }
        if (paramContext != null)
        {
          if ((paramInt & 0x1) != 0) {
            localArrayList.add(0, new ExoSoSource(paramContext, SO_STORE_NAME_MAIN));
          }
        }
        else
        {
          paramContext = (SoSource[])localArrayList.toArray(new SoSource[localArrayList.size()]);
          int j = makePrepareFlags();
          paramInt = paramContext.length;
          i = paramInt - 1;
          if (paramInt <= 0) {
            break label271;
          }
          paramContext[i].prepare(j);
          paramInt = i;
          continue;
        }
        paramSoFileLoader = paramContext.getApplicationInfo();
        if (((paramSoFileLoader.flags & 0x1) == 0) || ((paramSoFileLoader.flags & 0x80) != 0)) {
          break label220;
        }
        paramInt = 1;
      }
      finally {}
      localArrayList.add(0, new ApkSoSource(paramContext, SO_STORE_NAME_MAIN, paramInt));
      continue;
      label220:
      paramInt = 0;
      label271:
      label275:
      while (paramInt == 0)
      {
        i = 1;
        paramInt = 0;
        if (Build.VERSION.SDK_INT <= 17) {
          paramInt = 0x0 | 0x1;
        }
        localArrayList.add(0, new DirectorySoSource(new File(paramSoFileLoader.nativeLibraryDir), paramInt));
        paramInt = i;
        break;
        sSoSources = paramContext;
        return;
      }
      paramInt = 0;
    }
  }
  
  private static void initSoLoader(@Nullable final SoFileLoader paramSoFileLoader)
  {
    if (paramSoFileLoader != null) {}
    try
    {
      sSoFileLoader = paramSoFileLoader;
      return;
    }
    finally {}
    final Runtime localRuntime = Runtime.getRuntime();
    final Method localMethod = getNativeLoadRuntimeMethod();
    boolean bool;
    if (localMethod != null)
    {
      bool = true;
      label29:
      if (!bool) {
        break label69;
      }
    }
    label69:
    for (paramSoFileLoader = Api14Utils.getClassLoaderLdLoadLibrary();; paramSoFileLoader = null)
    {
      sSoFileLoader = new SoFileLoader()
      {
        /* Error */
        public void load(String paramAnonymousString, int paramAnonymousInt)
        {
          // Byte code:
          //   0: iconst_1
          //   1: istore_3
          //   2: aload_0
          //   3: getfield 24	com/facebook/soloader/SoLoader$1:val$hasNativeLoadMethod	Z
          //   6: ifeq +130 -> 136
          //   9: iload_2
          //   10: iconst_4
          //   11: iand
          //   12: iconst_4
          //   13: if_icmpne +61 -> 74
          //   16: iload_3
          //   17: istore_2
          //   18: iload_2
          //   19: ifeq +60 -> 79
          //   22: aload_0
          //   23: getfield 26	com/facebook/soloader/SoLoader$1:val$localLdLibraryPath	Ljava/lang/String;
          //   26: astore 4
          //   28: aload_0
          //   29: getfield 30	com/facebook/soloader/SoLoader$1:val$runtime	Ljava/lang/Runtime;
          //   32: astore 5
          //   34: aload 5
          //   36: monitorenter
          //   37: aload_0
          //   38: getfield 32	com/facebook/soloader/SoLoader$1:val$nativeLoadRuntimeMethod	Ljava/lang/reflect/Method;
          //   41: aload_0
          //   42: getfield 30	com/facebook/soloader/SoLoader$1:val$runtime	Ljava/lang/Runtime;
          //   45: iconst_3
          //   46: anewarray 4	java/lang/Object
          //   49: dup
          //   50: iconst_0
          //   51: aload_1
          //   52: aastore
          //   53: dup
          //   54: iconst_1
          //   55: ldc 8
          //   57: invokevirtual 50	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
          //   60: aastore
          //   61: dup
          //   62: iconst_2
          //   63: aload 4
          //   65: aastore
          //   66: invokevirtual 56	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
          //   69: pop
          //   70: aload 5
          //   72: monitorexit
          //   73: return
          //   74: iconst_0
          //   75: istore_2
          //   76: goto -58 -> 18
          //   79: aload_0
          //   80: getfield 28	com/facebook/soloader/SoLoader$1:val$localLdLibraryPathNoZips	Ljava/lang/String;
          //   83: astore 4
          //   85: goto -57 -> 28
          //   88: astore 4
          //   90: aload 5
          //   92: monitorexit
          //   93: aload 4
          //   95: athrow
          //   96: astore 4
          //   98: new 58	java/lang/StringBuilder
          //   101: dup
          //   102: invokespecial 59	java/lang/StringBuilder:<init>	()V
          //   105: ldc 61
          //   107: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   110: aload_1
          //   111: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   114: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   117: astore_1
          //   118: ldc 71
          //   120: aload_1
          //   121: invokestatic 77	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
          //   124: pop
          //   125: new 79	java/lang/RuntimeException
          //   128: dup
          //   129: aload_1
          //   130: aload 4
          //   132: invokespecial 82	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
          //   135: athrow
          //   136: aload_1
          //   137: invokestatic 87	java/lang/System:load	(Ljava/lang/String;)V
          //   140: return
          //   141: astore 4
          //   143: goto -45 -> 98
          //   146: astore 4
          //   148: goto -50 -> 98
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	151	0	this	1
          //   0	151	1	paramAnonymousString	String
          //   0	151	2	paramAnonymousInt	int
          //   1	16	3	i	int
          //   26	58	4	str	String
          //   88	6	4	localObject	Object
          //   96	35	4	localIllegalAccessException	java.lang.IllegalAccessException
          //   141	1	4	localIllegalArgumentException	java.lang.IllegalArgumentException
          //   146	1	4	localInvocationTargetException	java.lang.reflect.InvocationTargetException
          // Exception table:
          //   from	to	target	type
          //   37	73	88	finally
          //   90	93	88	finally
          //   28	37	96	java/lang/IllegalAccessException
          //   93	96	96	java/lang/IllegalAccessException
          //   28	37	141	java/lang/IllegalArgumentException
          //   93	96	141	java/lang/IllegalArgumentException
          //   28	37	146	java/lang/reflect/InvocationTargetException
          //   93	96	146	java/lang/reflect/InvocationTargetException
        }
      };
      break;
      bool = false;
      break label29;
    }
  }
  
  public static void loadLibrary(String paramString)
  {
    loadLibrary(paramString, 0);
  }
  
  public static void loadLibrary(String paramString, int paramInt)
    throws UnsatisfiedLinkError
  {
    for (;;)
    {
      String str2;
      String str1;
      try
      {
        if (sSoSources == null)
        {
          if ("http://www.android.com/".equals(System.getProperty("java.vendor.url"))) {
            assertInitialized();
          }
        }
        else
        {
          str2 = MergedSoMapping.mapLibName(paramString);
          if (str2 == null) {
            break label130;
          }
          str1 = str2;
        }
      }
      finally {}
      try
      {
        loadLibraryBySoName(System.mapLibraryName(str1), paramInt);
        if (str2 != null) {
          MergedSoMapping.invokeJniOnload(paramString);
        }
        return;
      }
      catch (IOException paramString)
      {
        throw new RuntimeException(paramString);
      }
      catch (UnsatisfiedLinkError paramString)
      {
        str1 = paramString.getMessage();
        if ((str1 == null) || (!str1.contains("unexpected e_machine:"))) {
          break label128;
        }
        throw new WrongAbiError(paramString);
        label128:
        throw paramString;
      }
      if (sSystemLoadLibraryWrapper != null)
      {
        sSystemLoadLibraryWrapper.loadLibrary(paramString);
      }
      else
      {
        System.loadLibrary(paramString);
        continue;
        label130:
        str1 = paramString;
      }
    }
  }
  
  public static void loadLibraryBySoName(String paramString, int paramInt)
    throws IOException
  {
    try
    {
      if (!sLoadedLibraries.contains(paramString)) {
        break label112;
      }
      i = 1;
    }
    finally
    {
      try
      {
        int i;
        while (k < sSoSources.length)
        {
          i = sSoSources[k].loadLibrary(paramString, paramInt);
          k += 1;
          continue;
          label112:
          i = 0;
        }
        if (SYSTRACE_LIBRARY_LOADING) {
          Api18TraceUtils.endSection();
        }
        k = i;
        if (j != 0)
        {
          StrictMode.setThreadPolicy(sOldPolicy);
          sOldPolicy = null;
          k = i;
        }
        if (k != 0) {
          break label211;
        }
        throw new UnsatisfiedLinkError("couldn't find DSO to load: " + paramString);
      }
      finally
      {
        int j;
        if (!SYSTRACE_LIBRARY_LOADING) {
          break label195;
        }
        Api18TraceUtils.endSection();
        if (j == 0) {
          break label209;
        }
        StrictMode.setThreadPolicy(sOldPolicy);
        sOldPolicy = null;
      }
      paramString = finally;
    }
    int k = i;
    if (i == 0)
    {
      j = 0;
      if (sOldPolicy == null)
      {
        sOldPolicy = StrictMode.allowThreadDiskReads();
        j = 1;
      }
      if (SYSTRACE_LIBRARY_LOADING) {
        Api18TraceUtils.beginTraceSection("SoLoader.loadLibrary[" + paramString + "]");
      }
      k = 0;
      if (i != 0) {}
    }
    label195:
    label209:
    label211:
    if (k == 1) {
      sLoadedLibraries.add(paramString);
    }
  }
  
  public static String makeLdLibraryPath()
  {
    try
    {
      assertInitialized();
      Object localObject1 = new ArrayList();
      SoSource[] arrayOfSoSource = sSoSources;
      int i = 0;
      while (i < arrayOfSoSource.length)
      {
        arrayOfSoSource[i].addToLdLibraryPath((Collection)localObject1);
        i += 1;
      }
      localObject1 = TextUtils.join(":", (Iterable)localObject1);
      return localObject1;
    }
    finally {}
  }
  
  public static String makeNonZipPath(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = paramString.split(":");
    ArrayList localArrayList = new ArrayList(paramString.length);
    int j = paramString.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = paramString[i];
      if (localObject.contains("!")) {}
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(localObject);
      }
    }
    return TextUtils.join(":", localArrayList);
  }
  
  private static int makePrepareFlags()
  {
    int i = 0;
    if ((sFlags & 0x2) != 0) {
      i = 0x0 | 0x1;
    }
    return i;
  }
  
  public static void prependSoSource(SoSource paramSoSource)
    throws IOException
  {
    try
    {
      assertInitialized();
      paramSoSource.prepare(makePrepareFlags());
      SoSource[] arrayOfSoSource = new SoSource[sSoSources.length + 1];
      arrayOfSoSource[0] = paramSoSource;
      System.arraycopy(sSoSources, 0, arrayOfSoSource, 1, sSoSources.length);
      sSoSources = arrayOfSoSource;
      return;
    }
    finally {}
  }
  
  public static void setInTestMode()
  {
    sSoSources = new SoSource[] { new NoopSoSource() };
  }
  
  public static void setSystemLoadLibraryWrapper(SystemLoadLibraryWrapper paramSystemLoadLibraryWrapper)
  {
    sSystemLoadLibraryWrapper = paramSystemLoadLibraryWrapper;
  }
  
  public static File unpackLibraryAndDependencies(String paramString)
    throws UnsatisfiedLinkError
  {
    
    try
    {
      paramString = unpackLibraryBySoName(System.mapLibraryName(paramString));
      return paramString;
    }
    catch (IOException paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  static File unpackLibraryBySoName(String paramString)
    throws IOException
  {
    int i = 0;
    while (i < sSoSources.length)
    {
      File localFile = sSoSources[i].unpackLibrary(paramString);
      if (localFile != null) {
        return localFile;
      }
      i += 1;
    }
    throw new FileNotFoundException(paramString);
  }
  
  @TargetApi(14)
  @DoNotOptimize
  private static class Api14Utils
  {
    public static String getClassLoaderLdLoadLibrary()
    {
      Object localObject = SoLoader.class.getClassLoader();
      if (!(localObject instanceof BaseDexClassLoader)) {
        throw new IllegalStateException("ClassLoader " + localObject.getClass().getName() + " should be of type BaseDexClassLoader");
      }
      try
      {
        localObject = (BaseDexClassLoader)localObject;
        localObject = (String)BaseDexClassLoader.class.getMethod("getLdLibraryPath", new Class[0]).invoke(localObject, new Object[0]);
        return localObject;
      }
      catch (Exception localException)
      {
        throw new RuntimeException("Cannot call getLdLibraryPath", localException);
      }
    }
  }
  
  public static final class WrongAbiError
    extends UnsatisfiedLinkError
  {
    WrongAbiError(Throwable paramThrowable)
    {
      super();
      initCause(paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.facebook.soloader.SoLoader
 * JD-Core Version:    0.7.0.1
 */