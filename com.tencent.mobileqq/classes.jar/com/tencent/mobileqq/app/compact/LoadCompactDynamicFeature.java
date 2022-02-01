package com.tencent.mobileqq.app.compact;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.classload.DexClassLoaderUtil;
import com.tencent.mobileqq.BuildConfig;
import com.tencent.mobileqq.app.SystemClassLoaderInjector;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.pluginsdk.ApkFileParser;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.InjectFailException;
import cooperation.plugin.ResInjector;
import dalvik.system.InMemoryDexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class LoadCompactDynamicFeature
{
  private Set<String> a = new HashSet();
  private ConcurrentHashMap<String, Object> b = new ConcurrentHashMap();
  private LoadCompactDynamicFeature.BackgroundCallback c = null;
  private String d;
  private Application.ActivityLifecycleCallbacks e;
  
  public static LoadCompactDynamicFeature a()
  {
    return LoadCompactDynamicFeature.SingletonHolder.a();
  }
  
  private BufferedInputStream a(File paramFile)
  {
    return new BufferedInputStream(new FileInputStream(paramFile));
  }
  
  @RequiresApi(api=26)
  private String a(Application paramApplication, ByteBuffer paramByteBuffer, String paramString, boolean paramBoolean)
  {
    PathClassLoader localPathClassLoader = (PathClassLoader)paramApplication.getClassLoader();
    try
    {
      paramApplication = new InMemoryDexClassLoader(paramByteBuffer, paramApplication.getClassLoader());
      QLog.d("[DynamicFeature] LoadCompactDynamicFeature", 1, "InMemoryDexClassLoader load done");
      if (!TextUtils.isEmpty(paramString))
      {
        QLog.e("[DynamicFeature] LoadCompactDynamicFeature", 1, "InMemoryDexClassLoader start test");
        paramApplication.loadClass(paramString);
        QLog.d("[DynamicFeature] LoadCompactDynamicFeature", 1, "InMemoryDexClassLoader test suc!");
      }
      paramApplication = SystemClassLoaderInjector.a(SystemClassLoaderInjector.b(SystemClassLoaderInjector.a(localPathClassLoader)), SystemClassLoaderInjector.b(SystemClassLoaderInjector.a(paramApplication)), paramBoolean);
      paramByteBuffer = SystemClassLoaderInjector.a(localPathClassLoader);
      SystemClassLoaderInjector.a(paramByteBuffer, paramByteBuffer.getClass(), "dexElements", paramApplication);
      QLog.d("[DynamicFeature] LoadCompactDynamicFeature", 1, "InMemoryDexClassLoader combine pathList done!");
      paramApplication = new StringBuilder();
      paramApplication.append("[注入完成调用] injectByInMemoryDexClassLoader classLoader:");
      paramApplication.append(localPathClassLoader);
      QLog.e("[DynamicFeature] LoadCompactDynamicFeature", 1, paramApplication.toString());
      return "Success";
    }
    catch (Throwable paramApplication)
    {
      QLog.e("[DynamicFeature] LoadCompactDynamicFeature", 1, "err", paramApplication);
      paramByteBuffer = new StringBuilder();
      paramByteBuffer.append("injectByInMemoryDexClassLoader error: ");
      paramByteBuffer.append(Log.getStackTraceString(paramApplication));
    }
    return paramByteBuffer.toString();
  }
  
  private void a(Context paramContext, String paramString)
  {
    try
    {
      Object localObject = ApkFileParser.getPackageInfoWithException(paramContext, paramString, 129);
      int i = 0;
      paramContext = paramContext.getSharedPreferences("df_plugin_aty_info", 0).edit();
      if (((PackageInfo)localObject).activities != null)
      {
        localObject = ((PackageInfo)localObject).activities;
        int j = localObject.length;
        while (i < j)
        {
          paramContext.putString(localObject[i].name, paramString);
          i += 1;
        }
      }
      paramContext.apply();
      return;
    }
    catch (Throwable paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("getPackageInfoWithException ");
      paramString.append(paramContext.getMessage());
      paramContext = new RuntimeException(paramString.toString(), paramContext);
    }
    for (;;)
    {
      throw paramContext;
    }
  }
  
  private File b(File paramFile)
  {
    Object localObject = paramFile.getName();
    int i = ((String)localObject).lastIndexOf(".");
    paramFile = (File)localObject;
    if (i >= 0) {
      paramFile = ((String)localObject).substring(0, i);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(BaseApplication.getContext().getFilesDir().getAbsolutePath());
    ((StringBuilder)localObject).append("/feature_apk_dex/");
    ((StringBuilder)localObject).append(paramFile);
    paramFile = new File(((StringBuilder)localObject).toString());
    if (!paramFile.exists()) {
      paramFile.mkdirs();
    }
    return paramFile;
  }
  
  private String b(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("df_plugin_aty_info", 0).getString(paramString, "");
  }
  
  private File c(String paramString)
  {
    File localFile = new File(PluginUtils.getPluginInstallDir(BaseApplicationImpl.sApplication), "846a9bfd_oDexed");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_oDexed");
    return new File(localFile, localStringBuilder.toString());
  }
  
  private void d()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(localBaseApplicationImpl.getFilesDir().getAbsolutePath());
    ((StringBuilder)localObject1).append("/");
    ((StringBuilder)localObject1).append("dynamic_feature/");
    localObject1 = ((StringBuilder)localObject1).toString();
    new File((String)localObject1).mkdirs();
    Object localObject2 = localBaseApplicationImpl.getAssets();
    for (;;)
    {
      int j;
      try
      {
        String str = "dynamic_feature/".substring(0, 15);
        localObject2 = ((AssetManager)localObject2).list(str);
        QLog.d("[DynamicFeature] LoadCompactDynamicFeature", 1, new Object[] { "[asset] loadInternal: invoked. ", " features: ", Arrays.asList((Object[])localObject2), " assetFeaturePath: ", str });
        if (localObject2 != null)
        {
          int i = localObject2.length;
          j = 0;
          if (j < i)
          {
            str = localObject2[j];
            Object localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append(str);
            localObject3 = new File(((StringBuilder)localObject3).toString());
            bool = TextUtils.isEmpty(str);
            if (!bool)
            {
              localObject3 = ((File)localObject3).getAbsolutePath();
              a(localBaseApplicationImpl, (String)localObject3);
              QLog.d("[DynamicFeature] LoadCompactDynamicFeature", 1, new Object[] { "[asset] loadInternal: invoked. ", " feat: ", str, " outputAbsolutePath: ", localObject3 });
              if (1 == BaseApplicationImpl.sProcessId)
              {
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("dynamic_feature/");
                ((StringBuilder)localObject4).append(str);
                FileUtils.copyAssetToFile(localBaseApplicationImpl, ((StringBuilder)localObject4).toString(), (String)localObject3);
              }
              long l = System.currentTimeMillis();
              Object localObject4 = SystemClassLoaderInjector.a(localBaseApplicationImpl, (String)localObject3, "", true);
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("loadInternal ");
              localStringBuilder.append(str);
              localStringBuilder.append(" cost: ");
              localStringBuilder.append(System.currentTimeMillis() - l);
              Log.i("[DynamicFeature] LoadCompactDynamicFeature", localStringBuilder.toString());
              if (ResInjector.a(localBaseApplicationImpl, Arrays.asList(new String[] { localObject3 })) == null) {
                break label574;
              }
              bool = true;
              QLog.d("[DynamicFeature] LoadCompactDynamicFeature", 1, new Object[] { "[asset] load: invoked. ", " output: ", localObject3, " clsRet: ", localObject4, " resRet: ", Boolean.valueOf(bool), " soRet: ", Boolean.valueOf(d((String)localObject3)) });
              break label579;
            }
            QLog.d("[DynamicFeature] LoadCompactDynamicFeature", 1, new Object[] { "[asset] loadInternal: invoked. error file", " output: ", localObject3 });
            break label579;
          }
          QLog.d("[DynamicFeature] LoadCompactDynamicFeature", 1, new Object[] { "[asset] load: invoked. ", " injectSo: ", Boolean.valueOf(f()) });
        }
      }
      catch (Exception localException)
      {
        QLog.e("[DynamicFeature] LoadCompactDynamicFeature", 1, "load: failed. ", localException);
      }
      if (QLog.isColorLevel()) {
        QLog.d("[DynamicFeature] LoadCompactDynamicFeature", 2, "[load] loadInternal: invoked. ");
      }
      return;
      label574:
      boolean bool = false;
      continue;
      label579:
      j += 1;
    }
  }
  
  private boolean d(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(BaseApplication.getContext().getFilesDir().getAbsolutePath());
    ((StringBuilder)localObject).append("/feature_apk_so");
    localObject = new File(((StringBuilder)localObject).toString());
    long l = System.currentTimeMillis();
    this.d = ((File)localObject).getAbsolutePath();
    boolean bool = a(new File(paramString), (File)localObject);
    paramString = new StringBuilder();
    paramString.append("[extractFeatureApkSo] inject df plugin time cost: ");
    paramString.append(System.currentTimeMillis() - l);
    QLog.i("plugin_tag", 1, paramString.toString());
    return bool;
  }
  
  private boolean e()
  {
    return Build.VERSION.SDK_INT >= 26;
  }
  
  private boolean f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[DynamicFeature] LoadCompactDynamicFeature", 2, new Object[] { "[asset][so] injectFeatureApksSo: invoked. ", " soOutputDir: ", this.d });
    }
    if (TextUtils.isEmpty(this.d)) {
      return false;
    }
    Object localObject = new File(this.d);
    try
    {
      long l = System.currentTimeMillis();
      ReflectLoadLibrary.a(BaseApplicationImpl.context.getClassLoader(), (File)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[so] inject df plugin time cost: ");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
      QLog.i("plugin_tag", 1, ((StringBuilder)localObject).toString());
      return true;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[DynamicFeature] LoadCompactDynamicFeature", 1, "injectFeatureApksSo: failed. ", localThrowable);
    }
    return false;
  }
  
  private String g()
  {
    String str;
    if (Build.VERSION.SDK_INT < 21) {
      str = Build.CPU_ABI;
    } else if ((Build.SUPPORTED_ABIS != null) && (Build.SUPPORTED_ABIS.length > 0)) {
      str = Build.SUPPORTED_ABIS[0];
    } else {
      str = null;
    }
    if ((!TextUtils.isEmpty(str)) && (str.contains("armeabi-v7a"))) {
      return "armeabi-v7a";
    }
    return "armeabi";
  }
  
  public Resources a(Context paramContext, List<String> paramList)
  {
    try
    {
      long l = System.currentTimeMillis();
      paramContext = ResInjector.a(paramContext, paramList);
      paramList = new StringBuilder();
      paramList.append("[resources] inject df plugin time cost: ");
      paramList.append(System.currentTimeMillis() - l);
      QLog.i("plugin_tag", 1, paramList.toString());
      return paramContext;
    }
    catch (InjectFailException paramContext)
    {
      QLog.e("plugin_tag", 1, "inject plugin resource error: ", paramContext);
    }
    return null;
  }
  
  public boolean a(Application paramApplication, String paramString, File paramFile)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  /* Error */
  public boolean a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +778 -> 779
    //   4: aload_1
    //   5: invokevirtual 450	java/io/File:length	()J
    //   8: lconst_1
    //   9: lcmp
    //   10: iflt +769 -> 779
    //   13: aload_1
    //   14: invokevirtual 453	java/io/File:canRead	()Z
    //   17: ifne +5 -> 22
    //   20: iconst_0
    //   21: ireturn
    //   22: aload_0
    //   23: invokespecial 455	com/tencent/mobileqq/app/compact/LoadCompactDynamicFeature:g	()Ljava/lang/String;
    //   26: astore 11
    //   28: aload_2
    //   29: invokevirtual 243	java/io/File:exists	()Z
    //   32: ifne +8 -> 40
    //   35: aload_2
    //   36: invokevirtual 246	java/io/File:mkdirs	()Z
    //   39: pop
    //   40: sipush 8192
    //   43: newarray byte
    //   45: astore 12
    //   47: aconst_null
    //   48: astore 6
    //   50: aconst_null
    //   51: astore 8
    //   53: aconst_null
    //   54: astore 9
    //   56: new 457	com/tencent/commonsdk/zip/QZipInputStream
    //   59: dup
    //   60: new 43	java/io/BufferedInputStream
    //   63: dup
    //   64: new 45	java/io/FileInputStream
    //   67: dup
    //   68: aload_1
    //   69: invokespecial 48	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   72: invokespecial 51	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   75: invokespecial 458	com/tencent/commonsdk/zip/QZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   78: astore 7
    //   80: aload 9
    //   82: astore 6
    //   84: aload 6
    //   86: astore 8
    //   88: aload 7
    //   90: astore 9
    //   92: aload 7
    //   94: invokevirtual 462	com/tencent/commonsdk/zip/QZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   97: astore 13
    //   99: aload 13
    //   101: ifnull +572 -> 673
    //   104: aload 6
    //   106: astore 8
    //   108: aload 7
    //   110: astore 9
    //   112: aload 13
    //   114: invokevirtual 465	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   117: astore 10
    //   119: aload 6
    //   121: astore 8
    //   123: aload 7
    //   125: astore 9
    //   127: aload 10
    //   129: ldc_w 467
    //   132: invokevirtual 429	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   135: ifeq +6 -> 141
    //   138: goto -54 -> 84
    //   141: aload 6
    //   143: astore 8
    //   145: aload 7
    //   147: astore 9
    //   149: aload 13
    //   151: invokevirtual 470	java/util/zip/ZipEntry:isDirectory	()Z
    //   154: ifne -70 -> 84
    //   157: aload 6
    //   159: astore 8
    //   161: aload 7
    //   163: astore 9
    //   165: new 118	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   172: astore 13
    //   174: aload 6
    //   176: astore 8
    //   178: aload 7
    //   180: astore 9
    //   182: aload 13
    //   184: ldc_w 472
    //   187: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload 6
    //   193: astore 8
    //   195: aload 7
    //   197: astore 9
    //   199: aload 13
    //   201: aload 11
    //   203: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload 6
    //   209: astore 8
    //   211: aload 7
    //   213: astore 9
    //   215: aload 13
    //   217: ldc_w 277
    //   220: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 6
    //   226: astore 8
    //   228: aload 7
    //   230: astore 9
    //   232: aload 10
    //   234: aload 13
    //   236: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokevirtual 475	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   242: istore 4
    //   244: aload 6
    //   246: astore 8
    //   248: aload 7
    //   250: astore 9
    //   252: aload 10
    //   254: ldc_w 477
    //   257: invokevirtual 480	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   260: istore 5
    //   262: aload 6
    //   264: astore 8
    //   266: aload 7
    //   268: astore 9
    //   270: invokestatic 376	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   273: ifeq +77 -> 350
    //   276: aload 6
    //   278: astore 8
    //   280: aload 7
    //   282: astore 9
    //   284: ldc 72
    //   286: iconst_2
    //   287: bipush 9
    //   289: anewarray 4	java/lang/Object
    //   292: dup
    //   293: iconst_0
    //   294: ldc_w 482
    //   297: aastore
    //   298: dup
    //   299: iconst_1
    //   300: ldc_w 484
    //   303: aastore
    //   304: dup
    //   305: iconst_2
    //   306: aload 10
    //   308: aastore
    //   309: dup
    //   310: iconst_3
    //   311: ldc_w 486
    //   314: aastore
    //   315: dup
    //   316: iconst_4
    //   317: iload 4
    //   319: invokestatic 359	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   322: aastore
    //   323: dup
    //   324: iconst_5
    //   325: ldc_w 488
    //   328: aastore
    //   329: dup
    //   330: bipush 6
    //   332: aload 11
    //   334: aastore
    //   335: dup
    //   336: bipush 7
    //   338: ldc_w 490
    //   341: aastore
    //   342: dup
    //   343: bipush 8
    //   345: aload_2
    //   346: aastore
    //   347: invokestatic 304	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   350: iload 4
    //   352: ifeq +160 -> 512
    //   355: aload 6
    //   357: astore 8
    //   359: aload 7
    //   361: astore 9
    //   363: new 206	java/io/File
    //   366: dup
    //   367: aload_2
    //   368: aload 10
    //   370: invokespecial 270	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   373: astore 10
    //   375: aload 6
    //   377: astore 8
    //   379: aload 7
    //   381: astore 9
    //   383: aload 10
    //   385: invokevirtual 493	java/io/File:getParentFile	()Ljava/io/File;
    //   388: invokevirtual 246	java/io/File:mkdirs	()Z
    //   391: pop
    //   392: aload 6
    //   394: astore 8
    //   396: aload 7
    //   398: astore 9
    //   400: new 495	java/io/BufferedOutputStream
    //   403: dup
    //   404: new 497	java/io/FileOutputStream
    //   407: dup
    //   408: aload 10
    //   410: invokespecial 498	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   413: invokespecial 501	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   416: astore 10
    //   418: aload 10
    //   420: astore 6
    //   422: aload 10
    //   424: astore 8
    //   426: aload 7
    //   428: aload 12
    //   430: iconst_0
    //   431: aload 12
    //   433: arraylength
    //   434: invokevirtual 505	com/tencent/commonsdk/zip/QZipInputStream:read	([BII)I
    //   437: istore_3
    //   438: iconst_m1
    //   439: iload_3
    //   440: if_icmpeq +23 -> 463
    //   443: aload 10
    //   445: astore 6
    //   447: aload 10
    //   449: astore 8
    //   451: aload 10
    //   453: aload 12
    //   455: iconst_0
    //   456: iload_3
    //   457: invokevirtual 509	java/io/BufferedOutputStream:write	([BII)V
    //   460: goto -42 -> 418
    //   463: aload 10
    //   465: astore 6
    //   467: aload 10
    //   469: astore 8
    //   471: aload 10
    //   473: invokevirtual 512	java/io/BufferedOutputStream:flush	()V
    //   476: aload 10
    //   478: astore 6
    //   480: aload 10
    //   482: astore 8
    //   484: aload 10
    //   486: invokevirtual 515	java/io/BufferedOutputStream:close	()V
    //   489: aload 10
    //   491: astore 6
    //   493: goto -409 -> 84
    //   496: astore_1
    //   497: aload 6
    //   499: astore 8
    //   501: goto +262 -> 763
    //   504: astore_1
    //   505: aload 8
    //   507: astore 6
    //   509: goto +221 -> 730
    //   512: iload 5
    //   514: ifeq -430 -> 84
    //   517: aload 6
    //   519: astore 8
    //   521: aload 7
    //   523: astore 9
    //   525: aload_0
    //   526: invokespecial 517	com/tencent/mobileqq/app/compact/LoadCompactDynamicFeature:e	()Z
    //   529: ifeq -445 -> 84
    //   532: aload 6
    //   534: astore 8
    //   536: aload 7
    //   538: astore 9
    //   540: new 206	java/io/File
    //   543: dup
    //   544: aload_0
    //   545: aload_1
    //   546: invokespecial 519	com/tencent/mobileqq/app/compact/LoadCompactDynamicFeature:b	(Ljava/io/File;)Ljava/io/File;
    //   549: aload 10
    //   551: invokespecial 270	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   554: astore 10
    //   556: aload 6
    //   558: astore 8
    //   560: aload 7
    //   562: astore 9
    //   564: aload 10
    //   566: invokevirtual 493	java/io/File:getParentFile	()Ljava/io/File;
    //   569: invokevirtual 246	java/io/File:mkdirs	()Z
    //   572: pop
    //   573: aload 6
    //   575: astore 8
    //   577: aload 7
    //   579: astore 9
    //   581: new 495	java/io/BufferedOutputStream
    //   584: dup
    //   585: new 497	java/io/FileOutputStream
    //   588: dup
    //   589: aload 10
    //   591: invokespecial 498	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   594: invokespecial 501	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   597: astore 10
    //   599: aload 10
    //   601: astore 6
    //   603: aload 10
    //   605: astore 8
    //   607: aload 7
    //   609: aload 12
    //   611: iconst_0
    //   612: aload 12
    //   614: arraylength
    //   615: invokevirtual 505	com/tencent/commonsdk/zip/QZipInputStream:read	([BII)I
    //   618: istore_3
    //   619: iconst_m1
    //   620: iload_3
    //   621: if_icmpeq +23 -> 644
    //   624: aload 10
    //   626: astore 6
    //   628: aload 10
    //   630: astore 8
    //   632: aload 10
    //   634: aload 12
    //   636: iconst_0
    //   637: iload_3
    //   638: invokevirtual 509	java/io/BufferedOutputStream:write	([BII)V
    //   641: goto -42 -> 599
    //   644: aload 10
    //   646: astore 6
    //   648: aload 10
    //   650: astore 8
    //   652: aload 10
    //   654: invokevirtual 512	java/io/BufferedOutputStream:flush	()V
    //   657: aload 10
    //   659: astore 6
    //   661: aload 10
    //   663: astore 8
    //   665: aload 10
    //   667: invokevirtual 515	java/io/BufferedOutputStream:close	()V
    //   670: goto -181 -> 489
    //   673: aload 6
    //   675: astore 8
    //   677: aload 7
    //   679: astore 9
    //   681: aload 7
    //   683: invokevirtual 522	com/tencent/commonsdk/zip/QZipInputStream:closeEntry	()V
    //   686: aload 6
    //   688: astore 8
    //   690: aload 7
    //   692: astore 9
    //   694: aload 7
    //   696: invokevirtual 523	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   699: aload_0
    //   700: aload 6
    //   702: invokevirtual 526	com/tencent/mobileqq/app/compact/LoadCompactDynamicFeature:a	(Ljava/lang/Object;)Z
    //   705: pop
    //   706: aload_0
    //   707: aload 7
    //   709: invokevirtual 526	com/tencent/mobileqq/app/compact/LoadCompactDynamicFeature:a	(Ljava/lang/Object;)Z
    //   712: pop
    //   713: iconst_1
    //   714: ireturn
    //   715: astore_1
    //   716: goto +14 -> 730
    //   719: astore_1
    //   720: aconst_null
    //   721: astore 7
    //   723: goto +40 -> 763
    //   726: astore_1
    //   727: aconst_null
    //   728: astore 7
    //   730: aload 6
    //   732: astore 8
    //   734: aload 7
    //   736: astore 9
    //   738: aload_1
    //   739: invokevirtual 529	java/io/IOException:printStackTrace	()V
    //   742: aload_0
    //   743: aload 6
    //   745: invokevirtual 526	com/tencent/mobileqq/app/compact/LoadCompactDynamicFeature:a	(Ljava/lang/Object;)Z
    //   748: pop
    //   749: aload_0
    //   750: aload 7
    //   752: invokevirtual 526	com/tencent/mobileqq/app/compact/LoadCompactDynamicFeature:a	(Ljava/lang/Object;)Z
    //   755: pop
    //   756: iconst_0
    //   757: ireturn
    //   758: astore_1
    //   759: aload 9
    //   761: astore 7
    //   763: aload_0
    //   764: aload 8
    //   766: invokevirtual 526	com/tencent/mobileqq/app/compact/LoadCompactDynamicFeature:a	(Ljava/lang/Object;)Z
    //   769: pop
    //   770: aload_0
    //   771: aload 7
    //   773: invokevirtual 526	com/tencent/mobileqq/app/compact/LoadCompactDynamicFeature:a	(Ljava/lang/Object;)Z
    //   776: pop
    //   777: aload_1
    //   778: athrow
    //   779: iconst_0
    //   780: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	781	0	this	LoadCompactDynamicFeature
    //   0	781	1	paramFile1	File
    //   0	781	2	paramFile2	File
    //   437	201	3	i	int
    //   242	109	4	bool1	boolean
    //   260	253	5	bool2	boolean
    //   48	696	6	localObject1	Object
    //   78	694	7	localObject2	Object
    //   51	714	8	localObject3	Object
    //   54	706	9	localObject4	Object
    //   117	549	10	localObject5	Object
    //   26	307	11	str	String
    //   45	590	12	arrayOfByte	byte[]
    //   97	138	13	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   426	438	496	finally
    //   451	460	496	finally
    //   471	476	496	finally
    //   484	489	496	finally
    //   607	619	496	finally
    //   632	641	496	finally
    //   652	657	496	finally
    //   665	670	496	finally
    //   426	438	504	java/io/IOException
    //   451	460	504	java/io/IOException
    //   471	476	504	java/io/IOException
    //   484	489	504	java/io/IOException
    //   607	619	504	java/io/IOException
    //   632	641	504	java/io/IOException
    //   652	657	504	java/io/IOException
    //   665	670	504	java/io/IOException
    //   92	99	715	java/io/IOException
    //   112	119	715	java/io/IOException
    //   127	138	715	java/io/IOException
    //   149	157	715	java/io/IOException
    //   165	174	715	java/io/IOException
    //   182	191	715	java/io/IOException
    //   199	207	715	java/io/IOException
    //   215	224	715	java/io/IOException
    //   232	244	715	java/io/IOException
    //   252	262	715	java/io/IOException
    //   270	276	715	java/io/IOException
    //   284	350	715	java/io/IOException
    //   363	375	715	java/io/IOException
    //   383	392	715	java/io/IOException
    //   400	418	715	java/io/IOException
    //   525	532	715	java/io/IOException
    //   540	556	715	java/io/IOException
    //   564	573	715	java/io/IOException
    //   581	599	715	java/io/IOException
    //   681	686	715	java/io/IOException
    //   694	699	715	java/io/IOException
    //   56	80	719	finally
    //   56	80	726	java/io/IOException
    //   92	99	758	finally
    //   112	119	758	finally
    //   127	138	758	finally
    //   149	157	758	finally
    //   165	174	758	finally
    //   182	191	758	finally
    //   199	207	758	finally
    //   215	224	758	finally
    //   232	244	758	finally
    //   252	262	758	finally
    //   270	276	758	finally
    //   284	350	758	finally
    //   363	375	758	finally
    //   383	392	758	finally
    //   400	418	758	finally
    //   525	532	758	finally
    //   540	556	758	finally
    //   564	573	758	finally
    //   581	599	758	finally
    //   681	686	758	finally
    //   694	699	758	finally
    //   738	742	758	finally
  }
  
  public boolean a(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    try
    {
      if ((paramObject instanceof InputStream))
      {
        ((InputStream)paramObject).close();
        return true;
      }
      if ((paramObject instanceof OutputStream))
      {
        ((OutputStream)paramObject).close();
        return true;
      }
      if ((paramObject instanceof Reader))
      {
        ((Reader)paramObject).close();
        return true;
      }
      if ((paramObject instanceof Writer))
      {
        ((Writer)paramObject).close();
        return true;
      }
      if ((paramObject instanceof RandomAccessFile))
      {
        ((RandomAccessFile)paramObject).close();
        return true;
      }
      return false;
    }
    catch (IOException paramObject)
    {
      QLog.e("[DynamicFeature] LoadCompactDynamicFeature", 1, "closeDataObject: failed. ", paramObject);
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    return this.a.contains(paramString);
  }
  
  public boolean a(String paramString, Application paramApplication)
  {
    File localFile = new File(PluginUtils.getPluginInstallDir(paramApplication), paramString);
    try
    {
      String str = localFile.getAbsolutePath();
      a(paramApplication, str);
      long l = System.currentTimeMillis();
      boolean bool = d(str);
      paramString = c(paramString);
      if (paramString.exists()) {
        paramString.delete();
      }
      paramString = new StringBuilder();
      paramString.append("install df plugin extractFeatureApkSo ");
      paramString.append(localFile.getName());
      paramString.append(" cost: ");
      paramString.append(System.currentTimeMillis() - l);
      QLog.i("plugin_tag", 1, paramString.toString());
      return bool;
    }
    catch (Exception paramString)
    {
      QLog.e("plugin_tag", 1, "install df plugin error. ", paramString);
    }
    return false;
  }
  
  public void b()
  {
    QLog.d("[DynamicFeature] LoadCompactDynamicFeature", 1, new Object[] { "[compact] load: invoked. ", " BuildConfig.IS_QRUN_COMPACT: ", Boolean.valueOf(false), " AppSetting.isQRunCompact(): ", Boolean.valueOf(AppSetting.l()) });
    if (this.e == null)
    {
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
      this.e = new LoadCompactDynamicFeature.ActivityLifeCycleCallback(this, null);
      localBaseApplicationImpl.registerActivityLifecycleCallbacks(this.e);
    }
    if (AppSetting.k()) {
      d();
    }
  }
  
  public void b(String paramString)
  {
    Object localObject3 = BaseApplicationImpl.sApplication;
    File localFile1 = new File(PluginUtils.getPluginInstallDir((Context)localObject3), paramString);
    File localFile2 = c(paramString);
    Object localObject1 = this.b.get(localFile1.getAbsolutePath());
    paramString = (String)localObject1;
    if (localObject1 == null)
    {
      paramString = new Object();
      this.b.put(localFile1.getAbsolutePath(), paramString);
    }
    try
    {
      if (localFile2.exists()) {
        return;
      }
      if (!localFile2.getParentFile().exists()) {
        localFile2.getParentFile().mkdirs();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("start oat ");
      ((StringBuilder)localObject1).append(localFile1.getName());
      QLog.i("plugin_tag", 1, ((StringBuilder)localObject1).toString());
      long l = System.currentTimeMillis();
      DexClassLoaderUtil.createDexClassLoader(localFile1.getAbsolutePath(), ((BaseApplicationImpl)localObject3).getDir("dex", 0).getAbsolutePath(), localFile1.getAbsolutePath(), ((BaseApplicationImpl)localObject3).getClassLoader());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[oat] inject df plugin time ");
      ((StringBuilder)localObject1).append(localFile1.getName());
      ((StringBuilder)localObject1).append(" cost: ");
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - l);
      QLog.i("plugin_tag", 1, ((StringBuilder)localObject1).toString());
      try
      {
        localFile2.createNewFile();
      }
      catch (IOException localIOException)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("oat ");
        ((StringBuilder)localObject3).append(localFile1.getName());
        ((StringBuilder)localObject3).append(" success, but create ");
        ((StringBuilder)localObject3).append(localFile2.getName());
        ((StringBuilder)localObject3).append(" failed!");
        QLog.e("plugin_tag", 1, ((StringBuilder)localObject3).toString(), localIOException);
      }
      return;
    }
    finally {}
  }
  
  public boolean b(String paramString, Application paramApplication)
  {
    if (this.a.contains(paramString)) {
      return true;
    }
    File localFile = new File(PluginUtils.getPluginInstallDir(paramApplication), paramString);
    for (;;)
    {
      try
      {
        String str2 = localFile.getAbsolutePath();
        QLog.d("plugin_tag", 1, new Object[] { "load dynamic feature plugin: ", str2 });
        if (this.c == null)
        {
          this.c = new LoadCompactDynamicFeature.BackgroundCallback(this, null);
          GuardManager.sInstance.registerCallBack(this.c);
        }
        bool1 = c(paramString).exists();
        long l = System.currentTimeMillis();
        boolean bool2 = e();
        String str1 = "";
        StringBuilder localStringBuilder;
        if ((bool2) && (!bool1))
        {
          bool1 = a(paramApplication, "", new File(str2));
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[loadDexInMemory] inject df plugin time ");
          localStringBuilder.append(localFile.getName());
          localStringBuilder.append(" cost: ");
          localStringBuilder.append(System.currentTimeMillis() - l);
          QLog.i("plugin_tag", 1, localStringBuilder.toString());
          if (bool1) {
            str1 = "Success";
          }
        }
        else
        {
          str1 = SystemClassLoaderInjector.a(paramApplication, str2, "", true, bool1);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[dex] inject df plugin time ");
          localStringBuilder.append(localFile.getName());
          localStringBuilder.append(" cost: ");
          localStringBuilder.append(System.currentTimeMillis() - l);
          localStringBuilder.append(" , is oat mode: ");
          localStringBuilder.append(bool1);
          QLog.i("plugin_tag", 1, localStringBuilder.toString());
        }
        if (a(paramApplication, Collections.singletonList(str2)) != null)
        {
          bool1 = true;
          bool2 = f();
          QLog.d("plugin_tag", 1, new Object[] { "install df plugin success", " output: ", str2, " clsRet: ", str1, " resRet: ", Boolean.valueOf(bool1), " inject so: ", Boolean.valueOf(bool2) });
          if ((!"Success".equals(str1)) || (!bool1) || (!bool2)) {
            break label458;
          }
          bool1 = true;
          if (bool1) {
            this.a.add(paramString);
          }
          return bool1;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("plugin_tag", 1, "install df plugin error. ", paramString);
        return false;
      }
      boolean bool1 = false;
      continue;
      label458:
      bool1 = false;
    }
  }
  
  public boolean c()
  {
    Iterator localIterator = BuildConfig.a.iterator();
    while (localIterator.hasNext()) {
      if (!c((String)localIterator.next()).exists()) {
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.compact.LoadCompactDynamicFeature
 * JD-Core Version:    0.7.0.1
 */