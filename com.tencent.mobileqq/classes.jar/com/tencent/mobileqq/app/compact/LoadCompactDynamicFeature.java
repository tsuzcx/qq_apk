package com.tencent.mobileqq.app.compact;

import android.content.res.AssetManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.SystemClassLoaderInjector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public class LoadCompactDynamicFeature
{
  private String a;
  
  public static LoadCompactDynamicFeature a()
  {
    return LoadCompactDynamicFeature.SingletonHolder.a();
  }
  
  private static String a()
  {
    String str;
    if (Build.VERSION.SDK_INT < 21) {
      str = Build.CPU_ABI;
    }
    while ((!TextUtils.isEmpty(str)) && (str.contains("armeabi-v7a")))
    {
      return "armeabi-v7a";
      if ((Build.SUPPORTED_ABIS == null) || (Build.SUPPORTED_ABIS.length <= 0)) {
        str = null;
      } else {
        str = Build.SUPPORTED_ABIS[0];
      }
    }
    return "armeabi";
  }
  
  private boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[DynamicFeature] LoadCompactDynamicFeature", 2, new Object[] { "[asset][so] injectFeatureApksSo: invoked. ", " soOutputDir: ", this.a });
    }
    if (TextUtils.isEmpty(this.a)) {
      return false;
    }
    File localFile = new File(this.a);
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
  
  /* Error */
  public static boolean a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 7
    //   9: aload_0
    //   10: ifnull +19 -> 29
    //   13: aload_0
    //   14: invokevirtual 104	java/io/File:length	()J
    //   17: lconst_1
    //   18: lcmp
    //   19: iflt +10 -> 29
    //   22: aload_0
    //   23: invokevirtual 107	java/io/File:canRead	()Z
    //   26: ifne +5 -> 31
    //   29: iconst_0
    //   30: ireturn
    //   31: invokestatic 109	com/tencent/mobileqq/app/compact/LoadCompactDynamicFeature:a	()Ljava/lang/String;
    //   34: astore 8
    //   36: aload_1
    //   37: invokevirtual 112	java/io/File:exists	()Z
    //   40: ifne +8 -> 48
    //   43: aload_1
    //   44: invokevirtual 115	java/io/File:mkdirs	()Z
    //   47: pop
    //   48: sipush 8192
    //   51: newarray byte
    //   53: astore 9
    //   55: new 117	com/tencent/commonsdk/zip/QZipInputStream
    //   58: dup
    //   59: new 119	java/io/BufferedInputStream
    //   62: dup
    //   63: new 121	java/io/FileInputStream
    //   66: dup
    //   67: aload_0
    //   68: invokespecial 124	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   71: invokespecial 127	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   74: invokespecial 128	com/tencent/commonsdk/zip/QZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   77: astore 4
    //   79: aload 7
    //   81: astore_0
    //   82: aload 4
    //   84: invokevirtual 132	com/tencent/commonsdk/zip/QZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   87: astore 5
    //   89: aload 5
    //   91: ifnull +232 -> 323
    //   94: aload 5
    //   96: invokevirtual 137	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   99: astore 6
    //   101: aload 6
    //   103: ldc 139
    //   105: invokevirtual 43	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   108: ifne -26 -> 82
    //   111: aload 5
    //   113: invokevirtual 142	java/util/zip/ZipEntry:isDirectory	()Z
    //   116: ifne +277 -> 393
    //   119: aload 6
    //   121: new 144	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   128: ldc 147
    //   130: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload 8
    //   135: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc 153
    //   140: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokevirtual 160	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   149: istore_3
    //   150: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   153: ifeq +63 -> 216
    //   156: ldc 59
    //   158: iconst_2
    //   159: bipush 9
    //   161: anewarray 4	java/lang/Object
    //   164: dup
    //   165: iconst_0
    //   166: ldc 162
    //   168: aastore
    //   169: dup
    //   170: iconst_1
    //   171: ldc 164
    //   173: aastore
    //   174: dup
    //   175: iconst_2
    //   176: aload 6
    //   178: aastore
    //   179: dup
    //   180: iconst_3
    //   181: ldc 166
    //   183: aastore
    //   184: dup
    //   185: iconst_4
    //   186: iload_3
    //   187: invokestatic 172	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   190: aastore
    //   191: dup
    //   192: iconst_5
    //   193: ldc 174
    //   195: aastore
    //   196: dup
    //   197: bipush 6
    //   199: aload 8
    //   201: aastore
    //   202: dup
    //   203: bipush 7
    //   205: ldc 176
    //   207: aastore
    //   208: dup
    //   209: bipush 8
    //   211: aload_1
    //   212: aastore
    //   213: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   216: iload_3
    //   217: ifeq +176 -> 393
    //   220: new 71	java/io/File
    //   223: dup
    //   224: aload_1
    //   225: aload 6
    //   227: invokespecial 179	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   230: astore 5
    //   232: aload 5
    //   234: invokevirtual 183	java/io/File:getParentFile	()Ljava/io/File;
    //   237: invokevirtual 115	java/io/File:mkdirs	()Z
    //   240: pop
    //   241: new 185	java/io/BufferedOutputStream
    //   244: dup
    //   245: new 187	java/io/FileOutputStream
    //   248: dup
    //   249: aload 5
    //   251: invokespecial 188	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   254: invokespecial 191	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   257: astore 5
    //   259: aload 4
    //   261: aload 9
    //   263: iconst_0
    //   264: aload 9
    //   266: arraylength
    //   267: invokevirtual 195	com/tencent/commonsdk/zip/QZipInputStream:read	([BII)I
    //   270: istore_2
    //   271: iconst_m1
    //   272: iload_2
    //   273: if_icmpeq +34 -> 307
    //   276: aload 5
    //   278: aload 9
    //   280: iconst_0
    //   281: iload_2
    //   282: invokevirtual 199	java/io/BufferedOutputStream:write	([BII)V
    //   285: goto -26 -> 259
    //   288: astore_0
    //   289: aload 5
    //   291: astore_0
    //   292: aload 4
    //   294: astore_1
    //   295: aload_0
    //   296: invokestatic 202	com/tencent/mobileqq/app/compact/LoadCompactDynamicFeature:a	(Ljava/lang/Object;)Z
    //   299: pop
    //   300: aload_1
    //   301: invokestatic 202	com/tencent/mobileqq/app/compact/LoadCompactDynamicFeature:a	(Ljava/lang/Object;)Z
    //   304: pop
    //   305: iconst_0
    //   306: ireturn
    //   307: aload 5
    //   309: invokevirtual 205	java/io/BufferedOutputStream:flush	()V
    //   312: aload 5
    //   314: invokevirtual 208	java/io/BufferedOutputStream:close	()V
    //   317: aload 5
    //   319: astore_0
    //   320: goto -238 -> 82
    //   323: aload 4
    //   325: invokevirtual 211	com/tencent/commonsdk/zip/QZipInputStream:closeEntry	()V
    //   328: aload 4
    //   330: invokevirtual 212	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   333: aload_0
    //   334: invokestatic 202	com/tencent/mobileqq/app/compact/LoadCompactDynamicFeature:a	(Ljava/lang/Object;)Z
    //   337: pop
    //   338: aload 4
    //   340: invokestatic 202	com/tencent/mobileqq/app/compact/LoadCompactDynamicFeature:a	(Ljava/lang/Object;)Z
    //   343: pop
    //   344: iconst_1
    //   345: ireturn
    //   346: astore_1
    //   347: aconst_null
    //   348: astore 4
    //   350: aload 6
    //   352: astore_0
    //   353: aload_0
    //   354: invokestatic 202	com/tencent/mobileqq/app/compact/LoadCompactDynamicFeature:a	(Ljava/lang/Object;)Z
    //   357: pop
    //   358: aload 4
    //   360: invokestatic 202	com/tencent/mobileqq/app/compact/LoadCompactDynamicFeature:a	(Ljava/lang/Object;)Z
    //   363: pop
    //   364: aload_1
    //   365: athrow
    //   366: astore_1
    //   367: aload 5
    //   369: astore_0
    //   370: goto -17 -> 353
    //   373: astore_1
    //   374: goto -21 -> 353
    //   377: astore_0
    //   378: aconst_null
    //   379: astore_1
    //   380: aload 5
    //   382: astore_0
    //   383: goto -88 -> 295
    //   386: astore_1
    //   387: aload 4
    //   389: astore_1
    //   390: goto -95 -> 295
    //   393: aload_0
    //   394: astore 5
    //   396: goto -79 -> 317
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	399	0	paramFile1	File
    //   0	399	1	paramFile2	File
    //   270	12	2	i	int
    //   149	68	3	bool	boolean
    //   77	311	4	localQZipInputStream	com.tencent.commonsdk.zip.QZipInputStream
    //   1	394	5	localObject1	Object
    //   4	347	6	str1	String
    //   7	73	7	localObject2	Object
    //   34	166	8	str2	String
    //   53	226	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   259	271	288	java/io/IOException
    //   276	285	288	java/io/IOException
    //   307	317	288	java/io/IOException
    //   55	79	346	finally
    //   259	271	366	finally
    //   276	285	366	finally
    //   307	317	366	finally
    //   82	89	373	finally
    //   94	216	373	finally
    //   220	259	373	finally
    //   323	333	373	finally
    //   55	79	377	java/io/IOException
    //   82	89	386	java/io/IOException
    //   94	216	386	java/io/IOException
    //   220	259	386	java/io/IOException
    //   323	333	386	java/io/IOException
  }
  
  public static boolean a(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      try
      {
        if ((paramObject instanceof InputStream)) {
          ((InputStream)paramObject).close();
        } else if ((paramObject instanceof OutputStream)) {
          ((OutputStream)paramObject).close();
        }
      }
      catch (IOException paramObject)
      {
        QLog.e("[DynamicFeature] LoadCompactDynamicFeature", 1, "closeDataObject: failed. ", paramObject);
        return false;
      }
      if ((paramObject instanceof Reader))
      {
        ((Reader)paramObject).close();
        break;
      }
      if ((paramObject instanceof Writer))
      {
        ((Writer)paramObject).close();
        break;
      }
    } while (!(paramObject instanceof RandomAccessFile));
    ((RandomAccessFile)paramObject).close();
    return true;
  }
  
  private boolean a(String paramString)
  {
    File localFile = new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/feature_apk_so");
    this.a = localFile.getAbsolutePath();
    return a(new File(paramString), localFile);
  }
  
  private void b()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    String str1 = localBaseApplicationImpl.getFilesDir().getAbsolutePath() + "/" + "dynamic_feature/";
    new File(str1).mkdirs();
    Object localObject1 = localBaseApplicationImpl.getAssets();
    for (;;)
    {
      int i;
      try
      {
        String str2 = "dynamic_feature/".substring(0, "dynamic_feature/".length() - 1);
        localObject1 = ((AssetManager)localObject1).list(str2);
        QLog.d("[DynamicFeature] LoadCompactDynamicFeature", 1, new Object[] { "[asset] loadInternal: invoked. ", " features: ", Arrays.asList((Object[])localObject1), " assetFeaturePath: ", str2 });
        if (localObject1 != null)
        {
          int j = localObject1.length;
          i = 0;
          if (i >= j) {
            break label397;
          }
          str2 = localObject1[i];
          Object localObject2 = new File(str1 + str2);
          if (!TextUtils.isEmpty(str2))
          {
            localObject2 = ((File)localObject2).getAbsolutePath();
            QLog.d("[DynamicFeature] LoadCompactDynamicFeature", 1, new Object[] { "[asset] loadInternal: invoked. ", " feat: ", str2, " outputAbsolutePath: ", localObject2 });
            FileUtils.a(localBaseApplicationImpl, "dynamic_feature/" + str2, (String)localObject2);
            QLog.d("[DynamicFeature] LoadCompactDynamicFeature", 1, new Object[] { "[asset] load: invoked. ", " output: ", localObject2, " clsRet: ", SystemClassLoaderInjector.a(localBaseApplicationImpl, (String)localObject2, "", true), " resRet: ", Boolean.valueOf(b((String)localObject2)), " soRet: ", Boolean.valueOf(a((String)localObject2)) });
          }
          else
          {
            QLog.d("[DynamicFeature] LoadCompactDynamicFeature", 1, new Object[] { "[asset] loadInternal: invoked. error file", " output: ", localObject2 });
          }
        }
      }
      catch (IOException localIOException)
      {
        QLog.e("[DynamicFeature] LoadCompactDynamicFeature", 1, "load: failed. ", localIOException);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("[DynamicFeature] LoadCompactDynamicFeature", 2, "[load] loadInternal: invoked. ");
        }
        return;
        label397:
        QLog.d("[DynamicFeature] LoadCompactDynamicFeature", 1, new Object[] { "[asset] load: invoked. ", " injectSo: ", Boolean.valueOf(a()) });
      }
      i += 1;
    }
  }
  
  private boolean b(String paramString)
  {
    try
    {
      AssetManager localAssetManager = (AssetManager)AssetManager.class.getConstructor(new Class[0]).newInstance(new Object[0]);
      Method localMethod = AssetManager.class.getDeclaredMethod("addAssetPath", new Class[] { String.class });
      localMethod.setAccessible(true);
      localMethod.invoke(localAssetManager, new Object[] { paramString });
      return true;
    }
    catch (Exception paramString)
    {
      QLog.d("[DynamicFeature] LoadCompactDynamicFeature", 1, paramString, new Object[0]);
    }
    return false;
  }
  
  public void a()
  {
    QLog.d("[DynamicFeature] LoadCompactDynamicFeature", 1, new Object[] { "[compact] load: invoked. ", " BuildConfig.IS_QRUN_COMPACT: ", Boolean.valueOf(false), " AppSetting.isQRunCompact(): ", Boolean.valueOf(AppSetting.d()) });
    if ((AppSetting.d()) || (AppSetting.c())) {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.compact.LoadCompactDynamicFeature
 * JD-Core Version:    0.7.0.1
 */