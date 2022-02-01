package com.tencent.mobileqq.app.compact;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
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
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.Writer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class LoadCompactDynamicFeature
{
  private Application.ActivityLifecycleCallbacks jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks;
  private LoadCompactDynamicFeature.BackgroundCallback jdField_a_of_type_ComTencentMobileqqAppCompactLoadCompactDynamicFeature$BackgroundCallback = null;
  private String jdField_a_of_type_JavaLangString;
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private ConcurrentHashMap<String, Object> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public static LoadCompactDynamicFeature a()
  {
    return LoadCompactDynamicFeature.SingletonHolder.a();
  }
  
  private File a(String paramString)
  {
    File localFile = new File(PluginUtils.getPluginInstallDir(BaseApplicationImpl.sApplication), "01328a87_oDexed");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_oDexed");
    return new File(localFile, localStringBuilder.toString());
  }
  
  private String a()
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
  
  private void a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = ApkFileParser.getPackageInfoWithException(paramContext, paramString, 129);
      if (paramContext.activities != null)
      {
        paramContext = paramContext.activities;
        int j = paramContext.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = paramContext[i];
          this.jdField_a_of_type_JavaUtilMap.put(localObject.name, paramString);
          i += 1;
        }
      }
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
  
  private boolean a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(BaseApplication.getContext().getFilesDir().getAbsolutePath());
    ((StringBuilder)localObject).append("/feature_apk_so");
    localObject = new File(((StringBuilder)localObject).toString());
    this.jdField_a_of_type_JavaLangString = ((File)localObject).getAbsolutePath();
    return a(new File(paramString), (File)localObject);
  }
  
  private void b()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    if (this.jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks == null)
    {
      this.jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks = new LoadCompactDynamicFeature.ActivityLifeCycleCallback(this, null);
      localBaseApplicationImpl.registerActivityLifecycleCallbacks(this.jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks);
    }
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
              Object localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("dynamic_feature/");
              ((StringBuilder)localObject4).append(str);
              FileUtils.copyAssetToFile(localBaseApplicationImpl, ((StringBuilder)localObject4).toString(), (String)localObject3);
              long l = System.currentTimeMillis();
              localObject4 = SystemClassLoaderInjector.a(localBaseApplicationImpl, (String)localObject3, "", true);
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("loadInternal ");
              localStringBuilder.append(str);
              localStringBuilder.append(" cost: ");
              localStringBuilder.append(System.currentTimeMillis() - l);
              Log.i("[DynamicFeature] LoadCompactDynamicFeature", localStringBuilder.toString());
              if (ResInjector.a(localBaseApplicationImpl, Arrays.asList(new String[] { localObject3 })) == null) {
                break label584;
              }
              bool = true;
              QLog.d("[DynamicFeature] LoadCompactDynamicFeature", 1, new Object[] { "[asset] load: invoked. ", " output: ", localObject3, " clsRet: ", localObject4, " resRet: ", Boolean.valueOf(bool), " soRet: ", Boolean.valueOf(a((String)localObject3)) });
              break label589;
            }
            QLog.d("[DynamicFeature] LoadCompactDynamicFeature", 1, new Object[] { "[asset] loadInternal: invoked. error file", " output: ", localObject3 });
            break label589;
          }
          QLog.d("[DynamicFeature] LoadCompactDynamicFeature", 1, new Object[] { "[asset] load: invoked. ", " injectSo: ", Boolean.valueOf(b()) });
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
      label584:
      boolean bool = false;
      continue;
      label589:
      j += 1;
    }
  }
  
  private boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[DynamicFeature] LoadCompactDynamicFeature", 2, new Object[] { "[asset][so] injectFeatureApksSo: invoked. ", " soOutputDir: ", this.jdField_a_of_type_JavaLangString });
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    File localFile = new File(this.jdField_a_of_type_JavaLangString);
    try
    {
      ReflectLoadLibrary.a(BaseApplicationImpl.context.getClassLoader(), localFile);
      return true;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[DynamicFeature] LoadCompactDynamicFeature", 1, "injectFeatureApksSo: failed. ", localThrowable);
    }
    return false;
  }
  
  public Resources a(Context paramContext, List<String> paramList)
  {
    try
    {
      long l = System.currentTimeMillis();
      paramContext = ResInjector.a(paramContext, paramList);
      paramList = new StringBuilder();
      paramList.append("inject plugin resources cost: ");
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
  
  public void a()
  {
    QLog.d("[DynamicFeature] LoadCompactDynamicFeature", 1, new Object[] { "[compact] load: invoked. ", " BuildConfig.IS_QRUN_COMPACT: ", Boolean.valueOf(false), " AppSetting.isQRunCompact(): ", Boolean.valueOf(AppSetting.d()) });
    if (AppSetting.c()) {
      b();
    }
  }
  
  public void a(String paramString)
  {
    Object localObject3 = BaseApplicationImpl.sApplication;
    File localFile1 = new File(PluginUtils.getPluginInstallDir((Context)localObject3), paramString);
    File localFile2 = a(paramString);
    Object localObject1 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localFile1.getAbsolutePath());
    paramString = (String)localObject1;
    if (localObject1 == null)
    {
      paramString = new Object();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localFile1.getAbsolutePath(), paramString);
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
      new DexClassLoader(localFile1.getAbsolutePath(), ((BaseApplicationImpl)localObject3).getDir("dex", 0).getAbsolutePath(), null, ((BaseApplicationImpl)localObject3).getClassLoader());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("oat ");
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
  
  public boolean a()
  {
    Iterator localIterator = BuildConfig.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      if (!a((String)localIterator.next()).exists()) {
        return false;
      }
    }
    return true;
  }
  
  /* Error */
  public boolean a(Application paramApplication, String paramString, File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aload_3
    //   1: ifnull +670 -> 671
    //   4: aload_3
    //   5: invokevirtual 414	java/io/File:length	()J
    //   8: lconst_1
    //   9: lcmp
    //   10: iflt +661 -> 671
    //   13: aload_3
    //   14: invokevirtual 417	java/io/File:canRead	()Z
    //   17: ifne +5 -> 22
    //   20: iconst_0
    //   21: ireturn
    //   22: aload_0
    //   23: invokespecial 419	com/tencent/mobileqq/app/compact/LoadCompactDynamicFeature:a	()Ljava/lang/String;
    //   26: astore 13
    //   28: aload 4
    //   30: invokevirtual 363	java/io/File:exists	()Z
    //   33: ifne +9 -> 42
    //   36: aload 4
    //   38: invokevirtual 190	java/io/File:mkdirs	()Z
    //   41: pop
    //   42: sipush 8192
    //   45: newarray byte
    //   47: astore 14
    //   49: aconst_null
    //   50: astore 9
    //   52: aconst_null
    //   53: astore 11
    //   55: aconst_null
    //   56: astore 12
    //   58: ldc_w 330
    //   61: iconst_1
    //   62: ldc_w 421
    //   65: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: new 423	com/tencent/commonsdk/zip/QZipInputStream
    //   71: dup
    //   72: new 425	java/io/BufferedInputStream
    //   75: dup
    //   76: new 427	java/io/FileInputStream
    //   79: dup
    //   80: aload_3
    //   81: invokespecial 430	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   84: invokespecial 433	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   87: invokespecial 434	com/tencent/commonsdk/zip/QZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   90: astore 10
    //   92: iconst_1
    //   93: istore 6
    //   95: aload 12
    //   97: astore_3
    //   98: aload 10
    //   100: invokevirtual 438	com/tencent/commonsdk/zip/QZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   103: astore 11
    //   105: aload 11
    //   107: ifnull +485 -> 592
    //   110: aload 11
    //   112: invokevirtual 441	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   115: astore 9
    //   117: aload 9
    //   119: ldc_w 443
    //   122: invokevirtual 104	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   125: ifeq +6 -> 131
    //   128: goto -30 -> 98
    //   131: aload 11
    //   133: invokevirtual 446	java/util/zip/ZipEntry:isDirectory	()Z
    //   136: ifne +549 -> 685
    //   139: new 65	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   146: astore 11
    //   148: aload 11
    //   150: ldc_w 448
    //   153: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload 11
    //   159: aload 13
    //   161: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 11
    //   167: ldc 184
    //   169: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload 9
    //   175: aload 11
    //   177: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokevirtual 451	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   183: istore 7
    //   185: aload 9
    //   187: ldc_w 453
    //   190: invokevirtual 456	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   193: istore 8
    //   195: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   198: ifeq +87 -> 285
    //   201: ldc_w 330
    //   204: iconst_2
    //   205: bipush 11
    //   207: anewarray 4	java/lang/Object
    //   210: dup
    //   211: iconst_0
    //   212: ldc_w 458
    //   215: aastore
    //   216: dup
    //   217: iconst_1
    //   218: ldc_w 460
    //   221: aastore
    //   222: dup
    //   223: iconst_2
    //   224: aload 9
    //   226: aastore
    //   227: dup
    //   228: iconst_3
    //   229: ldc_w 462
    //   232: aastore
    //   233: dup
    //   234: iconst_4
    //   235: iload 7
    //   237: invokestatic 281	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   240: aastore
    //   241: dup
    //   242: iconst_5
    //   243: ldc_w 464
    //   246: aastore
    //   247: dup
    //   248: bipush 6
    //   250: iload 7
    //   252: invokestatic 281	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   255: aastore
    //   256: dup
    //   257: bipush 7
    //   259: ldc_w 466
    //   262: aastore
    //   263: dup
    //   264: bipush 8
    //   266: aload 13
    //   268: aastore
    //   269: dup
    //   270: bipush 9
    //   272: ldc_w 468
    //   275: aastore
    //   276: dup
    //   277: bipush 10
    //   279: aload 4
    //   281: aastore
    //   282: invokestatic 224	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   285: iload 7
    //   287: ifeq +104 -> 391
    //   290: new 46	java/io/File
    //   293: dup
    //   294: aload 4
    //   296: aload 9
    //   298: invokespecial 63	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   301: astore 9
    //   303: aload 9
    //   305: invokevirtual 366	java/io/File:getParentFile	()Ljava/io/File;
    //   308: invokevirtual 190	java/io/File:mkdirs	()Z
    //   311: pop
    //   312: new 470	java/io/BufferedOutputStream
    //   315: dup
    //   316: new 472	java/io/FileOutputStream
    //   319: dup
    //   320: aload 9
    //   322: invokespecial 473	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   325: invokespecial 476	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   328: astore 9
    //   330: aload 10
    //   332: aload 14
    //   334: iconst_0
    //   335: aload 14
    //   337: arraylength
    //   338: invokevirtual 480	com/tencent/commonsdk/zip/QZipInputStream:read	([BII)I
    //   341: istore 5
    //   343: iconst_m1
    //   344: iload 5
    //   346: if_icmpeq +16 -> 362
    //   349: aload 9
    //   351: aload 14
    //   353: iconst_0
    //   354: iload 5
    //   356: invokevirtual 484	java/io/BufferedOutputStream:write	([BII)V
    //   359: goto -29 -> 330
    //   362: aload 9
    //   364: invokevirtual 487	java/io/BufferedOutputStream:flush	()V
    //   367: aload 9
    //   369: invokevirtual 490	java/io/BufferedOutputStream:close	()V
    //   372: aload 9
    //   374: astore_3
    //   375: goto -277 -> 98
    //   378: astore_1
    //   379: aload 9
    //   381: astore_3
    //   382: goto +259 -> 641
    //   385: aload 9
    //   387: astore_3
    //   388: goto +268 -> 656
    //   391: iload 8
    //   393: ifeq +292 -> 685
    //   396: ldc_w 330
    //   399: iconst_1
    //   400: ldc_w 492
    //   403: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   406: getstatic 82	android/os/Build$VERSION:SDK_INT	I
    //   409: bipush 26
    //   411: if_icmplt +139 -> 550
    //   414: new 494	java/io/ByteArrayOutputStream
    //   417: dup
    //   418: invokespecial 495	java/io/ByteArrayOutputStream:<init>	()V
    //   421: astore 9
    //   423: aload 10
    //   425: aload 14
    //   427: iconst_0
    //   428: aload 14
    //   430: arraylength
    //   431: invokevirtual 480	com/tencent/commonsdk/zip/QZipInputStream:read	([BII)I
    //   434: istore 5
    //   436: iconst_m1
    //   437: iload 5
    //   439: if_icmpeq +16 -> 455
    //   442: aload 9
    //   444: aload 14
    //   446: iconst_0
    //   447: iload 5
    //   449: invokevirtual 496	java/io/ByteArrayOutputStream:write	([BII)V
    //   452: goto -29 -> 423
    //   455: aload 9
    //   457: invokevirtual 500	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   460: invokestatic 506	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   463: astore 9
    //   465: ldc_w 330
    //   468: iconst_1
    //   469: ldc_w 508
    //   472: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   475: aload_1
    //   476: aload 9
    //   478: aload_2
    //   479: iconst_1
    //   480: invokestatic 511	com/tencent/mobileqq/app/SystemClassLoaderInjector:a	(Landroid/app/Application;Ljava/nio/ByteBuffer;Ljava/lang/String;Z)Ljava/lang/String;
    //   483: astore 9
    //   485: new 65	java/lang/StringBuilder
    //   488: dup
    //   489: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   492: astore 11
    //   494: aload 11
    //   496: ldc_w 513
    //   499: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: pop
    //   503: aload 11
    //   505: aload 9
    //   507: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: pop
    //   511: ldc_w 330
    //   514: iconst_1
    //   515: aload 11
    //   517: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   520: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   523: ldc_w 515
    //   526: aload 9
    //   528: invokevirtual 519	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   531: ifne -433 -> 98
    //   534: ldc_w 330
    //   537: iconst_1
    //   538: ldc_w 521
    //   541: invokestatic 523	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   544: iconst_0
    //   545: istore 6
    //   547: goto -449 -> 98
    //   550: new 65	java/lang/StringBuilder
    //   553: dup
    //   554: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   557: astore 9
    //   559: aload 9
    //   561: ldc_w 525
    //   564: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: pop
    //   568: aload 9
    //   570: getstatic 82	android/os/Build$VERSION:SDK_INT	I
    //   573: invokevirtual 528	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   576: pop
    //   577: ldc_w 330
    //   580: iconst_1
    //   581: aload 9
    //   583: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   586: invokestatic 523	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   589: goto -491 -> 98
    //   592: aload 10
    //   594: invokevirtual 531	com/tencent/commonsdk/zip/QZipInputStream:closeEntry	()V
    //   597: aload 10
    //   599: invokevirtual 532	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   602: aload_0
    //   603: aload_3
    //   604: invokevirtual 534	com/tencent/mobileqq/app/compact/LoadCompactDynamicFeature:a	(Ljava/lang/Object;)Z
    //   607: pop
    //   608: aload_0
    //   609: aload 10
    //   611: invokevirtual 534	com/tencent/mobileqq/app/compact/LoadCompactDynamicFeature:a	(Ljava/lang/Object;)Z
    //   614: pop
    //   615: iload 6
    //   617: ireturn
    //   618: astore_1
    //   619: goto +22 -> 641
    //   622: astore_1
    //   623: aconst_null
    //   624: astore 10
    //   626: aload 9
    //   628: astore_3
    //   629: goto +12 -> 641
    //   632: aconst_null
    //   633: astore 10
    //   635: aload 11
    //   637: astore_3
    //   638: goto +18 -> 656
    //   641: aload_0
    //   642: aload_3
    //   643: invokevirtual 534	com/tencent/mobileqq/app/compact/LoadCompactDynamicFeature:a	(Ljava/lang/Object;)Z
    //   646: pop
    //   647: aload_0
    //   648: aload 10
    //   650: invokevirtual 534	com/tencent/mobileqq/app/compact/LoadCompactDynamicFeature:a	(Ljava/lang/Object;)Z
    //   653: pop
    //   654: aload_1
    //   655: athrow
    //   656: aload_0
    //   657: aload_3
    //   658: invokevirtual 534	com/tencent/mobileqq/app/compact/LoadCompactDynamicFeature:a	(Ljava/lang/Object;)Z
    //   661: pop
    //   662: aload_0
    //   663: aload 10
    //   665: invokevirtual 534	com/tencent/mobileqq/app/compact/LoadCompactDynamicFeature:a	(Ljava/lang/Object;)Z
    //   668: pop
    //   669: iconst_0
    //   670: ireturn
    //   671: iconst_0
    //   672: ireturn
    //   673: astore_1
    //   674: goto -42 -> 632
    //   677: astore_1
    //   678: goto -22 -> 656
    //   681: astore_1
    //   682: goto -297 -> 385
    //   685: goto -587 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	688	0	this	LoadCompactDynamicFeature
    //   0	688	1	paramApplication	Application
    //   0	688	2	paramString	String
    //   0	688	3	paramFile1	File
    //   0	688	4	paramFile2	File
    //   341	107	5	i	int
    //   93	523	6	bool1	boolean
    //   183	103	7	bool2	boolean
    //   193	199	8	bool3	boolean
    //   50	577	9	localObject1	Object
    //   90	574	10	localQZipInputStream	com.tencent.commonsdk.zip.QZipInputStream
    //   53	583	11	localObject2	Object
    //   56	40	12	localObject3	Object
    //   26	241	13	str	String
    //   47	398	14	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   330	343	378	finally
    //   349	359	378	finally
    //   362	372	378	finally
    //   98	105	618	finally
    //   110	128	618	finally
    //   131	285	618	finally
    //   290	330	618	finally
    //   396	423	618	finally
    //   423	436	618	finally
    //   442	452	618	finally
    //   455	544	618	finally
    //   550	589	618	finally
    //   592	602	618	finally
    //   58	92	622	finally
    //   58	92	673	java/io/IOException
    //   98	105	677	java/io/IOException
    //   110	128	677	java/io/IOException
    //   131	285	677	java/io/IOException
    //   290	330	677	java/io/IOException
    //   396	423	677	java/io/IOException
    //   423	436	677	java/io/IOException
    //   442	452	677	java/io/IOException
    //   455	544	677	java/io/IOException
    //   550	589	677	java/io/IOException
    //   592	602	677	java/io/IOException
    //   330	343	681	java/io/IOException
    //   349	359	681	java/io/IOException
    //   362	372	681	java/io/IOException
  }
  
  public boolean a(Application paramApplication, String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramApplication.getFilesDir().getAbsolutePath());
    ((StringBuilder)localObject).append("/feature_apk_so");
    localObject = new File(((StringBuilder)localObject).toString());
    this.jdField_a_of_type_JavaLangString = ((File)localObject).getAbsolutePath();
    return a(paramApplication, paramString1, new File(paramString2), (File)localObject);
  }
  
  /* Error */
  public boolean a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +413 -> 414
    //   4: aload_1
    //   5: invokevirtual 414	java/io/File:length	()J
    //   8: lconst_1
    //   9: lcmp
    //   10: iflt +404 -> 414
    //   13: aload_1
    //   14: invokevirtual 417	java/io/File:canRead	()Z
    //   17: ifne +5 -> 22
    //   20: iconst_0
    //   21: ireturn
    //   22: aload_0
    //   23: invokespecial 419	com/tencent/mobileqq/app/compact/LoadCompactDynamicFeature:a	()Ljava/lang/String;
    //   26: astore 9
    //   28: aload_2
    //   29: invokevirtual 363	java/io/File:exists	()Z
    //   32: ifne +8 -> 40
    //   35: aload_2
    //   36: invokevirtual 190	java/io/File:mkdirs	()Z
    //   39: pop
    //   40: sipush 8192
    //   43: newarray byte
    //   45: astore 10
    //   47: aconst_null
    //   48: astore 5
    //   50: aconst_null
    //   51: astore 7
    //   53: aconst_null
    //   54: astore 8
    //   56: new 423	com/tencent/commonsdk/zip/QZipInputStream
    //   59: dup
    //   60: new 425	java/io/BufferedInputStream
    //   63: dup
    //   64: new 427	java/io/FileInputStream
    //   67: dup
    //   68: aload_1
    //   69: invokespecial 430	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   72: invokespecial 433	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   75: invokespecial 434	com/tencent/commonsdk/zip/QZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   78: astore 6
    //   80: aload 8
    //   82: astore_1
    //   83: aload 6
    //   85: invokevirtual 438	com/tencent/commonsdk/zip/QZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   88: astore 7
    //   90: aload 7
    //   92: ifnull +252 -> 344
    //   95: aload 7
    //   97: invokevirtual 441	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   100: astore 5
    //   102: aload 5
    //   104: ldc_w 443
    //   107: invokevirtual 104	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   110: ifeq +6 -> 116
    //   113: goto -30 -> 83
    //   116: aload 7
    //   118: invokevirtual 446	java/util/zip/ZipEntry:isDirectory	()Z
    //   121: ifne -38 -> 83
    //   124: new 65	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   131: astore 7
    //   133: aload 7
    //   135: ldc_w 448
    //   138: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload 7
    //   144: aload 9
    //   146: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload 7
    //   152: ldc 184
    //   154: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload 5
    //   160: aload 7
    //   162: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokevirtual 451	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   168: istore 4
    //   170: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   173: ifeq +69 -> 242
    //   176: ldc 206
    //   178: iconst_2
    //   179: bipush 9
    //   181: anewarray 4	java/lang/Object
    //   184: dup
    //   185: iconst_0
    //   186: ldc_w 542
    //   189: aastore
    //   190: dup
    //   191: iconst_1
    //   192: ldc_w 460
    //   195: aastore
    //   196: dup
    //   197: iconst_2
    //   198: aload 5
    //   200: aastore
    //   201: dup
    //   202: iconst_3
    //   203: ldc_w 462
    //   206: aastore
    //   207: dup
    //   208: iconst_4
    //   209: iload 4
    //   211: invokestatic 281	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   214: aastore
    //   215: dup
    //   216: iconst_5
    //   217: ldc_w 466
    //   220: aastore
    //   221: dup
    //   222: bipush 6
    //   224: aload 9
    //   226: aastore
    //   227: dup
    //   228: bipush 7
    //   230: ldc_w 544
    //   233: aastore
    //   234: dup
    //   235: bipush 8
    //   237: aload_2
    //   238: aastore
    //   239: invokestatic 224	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   242: iload 4
    //   244: ifeq -161 -> 83
    //   247: new 46	java/io/File
    //   250: dup
    //   251: aload_2
    //   252: aload 5
    //   254: invokespecial 63	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   257: astore 5
    //   259: aload 5
    //   261: invokevirtual 366	java/io/File:getParentFile	()Ljava/io/File;
    //   264: invokevirtual 190	java/io/File:mkdirs	()Z
    //   267: pop
    //   268: new 470	java/io/BufferedOutputStream
    //   271: dup
    //   272: new 472	java/io/FileOutputStream
    //   275: dup
    //   276: aload 5
    //   278: invokespecial 473	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   281: invokespecial 476	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   284: astore 5
    //   286: aload 6
    //   288: aload 10
    //   290: iconst_0
    //   291: aload 10
    //   293: arraylength
    //   294: invokevirtual 480	com/tencent/commonsdk/zip/QZipInputStream:read	([BII)I
    //   297: istore_3
    //   298: iconst_m1
    //   299: iload_3
    //   300: if_icmpeq +15 -> 315
    //   303: aload 5
    //   305: aload 10
    //   307: iconst_0
    //   308: iload_3
    //   309: invokevirtual 484	java/io/BufferedOutputStream:write	([BII)V
    //   312: goto -26 -> 286
    //   315: aload 5
    //   317: invokevirtual 487	java/io/BufferedOutputStream:flush	()V
    //   320: aload 5
    //   322: invokevirtual 490	java/io/BufferedOutputStream:close	()V
    //   325: aload 5
    //   327: astore_1
    //   328: goto -245 -> 83
    //   331: astore_2
    //   332: aload 5
    //   334: astore_1
    //   335: goto +45 -> 380
    //   338: aload 5
    //   340: astore_1
    //   341: goto +60 -> 401
    //   344: aload 6
    //   346: invokevirtual 531	com/tencent/commonsdk/zip/QZipInputStream:closeEntry	()V
    //   349: aload 6
    //   351: invokevirtual 532	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   354: aload_0
    //   355: aload_1
    //   356: invokevirtual 534	com/tencent/mobileqq/app/compact/LoadCompactDynamicFeature:a	(Ljava/lang/Object;)Z
    //   359: pop
    //   360: aload_0
    //   361: aload 6
    //   363: invokevirtual 534	com/tencent/mobileqq/app/compact/LoadCompactDynamicFeature:a	(Ljava/lang/Object;)Z
    //   366: pop
    //   367: iconst_1
    //   368: ireturn
    //   369: astore_2
    //   370: goto +10 -> 380
    //   373: astore_2
    //   374: aconst_null
    //   375: astore 6
    //   377: aload 5
    //   379: astore_1
    //   380: aload_0
    //   381: aload_1
    //   382: invokevirtual 534	com/tencent/mobileqq/app/compact/LoadCompactDynamicFeature:a	(Ljava/lang/Object;)Z
    //   385: pop
    //   386: aload_0
    //   387: aload 6
    //   389: invokevirtual 534	com/tencent/mobileqq/app/compact/LoadCompactDynamicFeature:a	(Ljava/lang/Object;)Z
    //   392: pop
    //   393: aload_2
    //   394: athrow
    //   395: aconst_null
    //   396: astore 6
    //   398: aload 7
    //   400: astore_1
    //   401: aload_0
    //   402: aload_1
    //   403: invokevirtual 534	com/tencent/mobileqq/app/compact/LoadCompactDynamicFeature:a	(Ljava/lang/Object;)Z
    //   406: pop
    //   407: aload_0
    //   408: aload 6
    //   410: invokevirtual 534	com/tencent/mobileqq/app/compact/LoadCompactDynamicFeature:a	(Ljava/lang/Object;)Z
    //   413: pop
    //   414: iconst_0
    //   415: ireturn
    //   416: astore_1
    //   417: goto -22 -> 395
    //   420: astore_2
    //   421: goto -20 -> 401
    //   424: astore_1
    //   425: goto -87 -> 338
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	428	0	this	LoadCompactDynamicFeature
    //   0	428	1	paramFile1	File
    //   0	428	2	paramFile2	File
    //   297	12	3	i	int
    //   168	75	4	bool	boolean
    //   48	330	5	localObject1	Object
    //   78	331	6	localQZipInputStream	com.tencent.commonsdk.zip.QZipInputStream
    //   51	348	7	localObject2	Object
    //   54	27	8	localObject3	Object
    //   26	199	9	str	String
    //   45	261	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   286	298	331	finally
    //   303	312	331	finally
    //   315	325	331	finally
    //   83	90	369	finally
    //   95	113	369	finally
    //   116	242	369	finally
    //   247	286	369	finally
    //   344	354	369	finally
    //   56	80	373	finally
    //   56	80	416	java/io/IOException
    //   83	90	420	java/io/IOException
    //   95	113	420	java/io/IOException
    //   116	242	420	java/io/IOException
    //   247	286	420	java/io/IOException
    //   344	354	420	java/io/IOException
    //   286	298	424	java/io/IOException
    //   303	312	424	java/io/IOException
    //   315	325	424	java/io/IOException
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
  
  public boolean a(String paramString, Application paramApplication)
  {
    if (this.jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks == null)
    {
      this.jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks = new LoadCompactDynamicFeature.ActivityLifeCycleCallback(this, null);
      paramApplication.registerActivityLifecycleCallbacks(this.jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks);
    }
    if (this.jdField_a_of_type_JavaUtilSet.contains(paramString)) {
      return true;
    }
    File localFile = new File(PluginUtils.getPluginInstallDir(paramApplication), paramString);
    for (;;)
    {
      try
      {
        String str2 = localFile.getAbsolutePath();
        QLog.d("plugin_tag", 1, new Object[] { "install dynamic feature plugin: ", str2 });
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
          i = 1;
        } else {
          i = 0;
        }
        if (i == 0)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppCompactLoadCompactDynamicFeature$BackgroundCallback == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppCompactLoadCompactDynamicFeature$BackgroundCallback = new LoadCompactDynamicFeature.BackgroundCallback(this, null);
            GuardManager.a.a(this.jdField_a_of_type_ComTencentMobileqqAppCompactLoadCompactDynamicFeature$BackgroundCallback);
          }
          long l = System.currentTimeMillis();
          bool1 = a(paramString).exists();
          str1 = SystemClassLoaderInjector.a(paramApplication, str2, "", true, bool1);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("inject df plugin dex ");
          localStringBuilder.append(localFile.getName());
          localStringBuilder.append(" cost: ");
          localStringBuilder.append(System.currentTimeMillis() - l);
          localStringBuilder.append(" , is oat mode: ");
          localStringBuilder.append(bool1);
          QLog.i("plugin_tag", 1, localStringBuilder.toString());
          if (a(paramApplication, Collections.singletonList(str2)) == null) {
            break label476;
          }
          bool1 = true;
          QLog.i("plugin_tag", 1, "inject df plugin resource!");
          boolean bool2;
          if (i != 0)
          {
            bool2 = a(paramApplication, "", str2);
            if (!bool2) {
              break label482;
            }
            str1 = "Success";
          }
          else
          {
            bool2 = a(str2);
          }
          boolean bool3 = b();
          QLog.d("plugin_tag", 1, new Object[] { "install df plugin success", " output: ", str2, " clsRet: ", str1, " resRet: ", Boolean.valueOf(bool1), " soRet: ", Boolean.valueOf(bool2), " inject so: ", Boolean.valueOf(bool3) });
          if ((!"Success".equals(str1)) || (!bool1) || (!bool2) || (!bool3)) {
            break label489;
          }
          bool1 = true;
          if (bool1) {
            this.jdField_a_of_type_JavaUtilSet.add(paramString);
          }
          return bool1;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("plugin_tag", 1, "install df plugin error. ", paramString);
        return false;
      }
      String str1 = "";
      continue;
      label476:
      boolean bool1 = false;
      continue;
      label482:
      str1 = "";
      continue;
      label489:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.compact.LoadCompactDynamicFeature
 * JD-Core Version:    0.7.0.1
 */