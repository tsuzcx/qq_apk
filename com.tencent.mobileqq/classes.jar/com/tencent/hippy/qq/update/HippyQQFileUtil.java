package com.tencent.hippy.qq.update;

import android.content.Context;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

public class HippyQQFileUtil
{
  private static final String DIFF_DOWNLOAD_FILE_NAME = "diff.zip";
  private static final String HIPPY_JS_BUNDLE_DOWNLOAD_ROOT_DIR = "pkg";
  private static final String HIPPY_ROOT_DIR = "hippy";
  private static final String JS_BUNDLE_DOWNLOAD_FILE_NAME = "jsbundle.zip";
  private static final String TAG = "HippyQQFileUtil";
  private static final String UNZIP_TEMP_PATH_START = "_tmp_";
  
  public static void cleanHistoryPkg(String paramString, int paramInt)
  {
    paramString = getModuleDownloadRootDir(paramString);
    if (!paramString.exists()) {
      return;
    }
    paramString = paramString.listFiles();
    if (paramString == null) {
      return;
    }
    int i = 0;
    while (i < paramString.length)
    {
      Object localObject = paramString[i];
      if ((localObject != null) && (localObject.isDirectory()) && (localObject.getName() != null)) {
        try
        {
          if (Integer.parseInt(localObject.getName()) < paramInt)
          {
            com.tencent.mobileqq.utils.FileUtils.deleteDirectory(localObject.getAbsolutePath());
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("cleanHistoryPkg deleteDirectory:");
              localStringBuilder.append(localObject.getName());
              QLog.i("HippyQQFileUtil", 1, localStringBuilder.toString());
            }
          }
        }
        catch (Throwable localThrowable)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("cleanHistoryPkg failed ");
          localStringBuilder.append(localThrowable);
          QLog.e("HippyQQFileUtil", 1, localStringBuilder.toString());
        }
      }
      i += 1;
    }
  }
  
  public static void cleanHistoryVersion(String paramString, int paramInt)
  {
    for (;;)
    {
      int i;
      try
      {
        paramString = getModuleFile(paramString).listFiles();
        if (paramString != null) {
          break label176;
        }
        return;
      }
      catch (Throwable paramString)
      {
        StringBuilder localStringBuilder;
        String[] arrayOfString;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("cleanHistoryVersion failed ");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("HippyQQFileUtil", 1, ((StringBuilder)localObject).toString());
      }
      if (i < paramString.length)
      {
        localStringBuilder = paramString[i];
        if ((localStringBuilder != null) && (localStringBuilder.isDirectory()) && (localStringBuilder.getName() != null))
        {
          localObject = localStringBuilder.getName();
          arrayOfString = ((String)localObject).split("_");
          if ((arrayOfString != null) && (arrayOfString.length > 0) && (Integer.parseInt(arrayOfString[0]) < paramInt))
          {
            com.tencent.mobileqq.utils.FileUtils.deleteDirectory(localStringBuilder.getAbsolutePath());
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("cleanHistoryVersion deleteDirectory:");
              localStringBuilder.append((String)localObject);
              QLog.i("HippyQQFileUtil", 1, localStringBuilder.toString());
            }
          }
        }
        i += 1;
      }
      else
      {
        return;
        label176:
        i = 0;
      }
    }
  }
  
  /* Error */
  public static void downLoad(String paramString, File paramFile, HippyQQFileUtil.DownLoadCallBack paramDownLoadCallBack)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore_3
    //   5: aconst_null
    //   6: astore 6
    //   8: aconst_null
    //   9: astore 5
    //   11: new 121	java/net/URL
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 123	java/net/URL:<init>	(Ljava/lang/String;)V
    //   19: invokevirtual 127	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   22: checkcast 129	java/net/HttpURLConnection
    //   25: astore_0
    //   26: aload_0
    //   27: iconst_1
    //   28: invokevirtual 133	java/net/HttpURLConnection:setDoInput	(Z)V
    //   31: aload_0
    //   32: invokevirtual 137	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   35: astore_0
    //   36: new 139	java/io/FileOutputStream
    //   39: dup
    //   40: aload_1
    //   41: invokespecial 142	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   44: astore 7
    //   46: sipush 1024
    //   49: newarray byte
    //   51: astore 5
    //   53: aload_0
    //   54: aload 5
    //   56: invokevirtual 148	java/io/InputStream:read	([B)I
    //   59: istore 4
    //   61: iload 4
    //   63: iconst_m1
    //   64: if_icmpeq +16 -> 80
    //   67: aload 7
    //   69: aload 5
    //   71: iconst_0
    //   72: iload 4
    //   74: invokevirtual 152	java/io/FileOutputStream:write	([BII)V
    //   77: goto -24 -> 53
    //   80: aload_0
    //   81: invokevirtual 155	java/io/InputStream:close	()V
    //   84: aload 7
    //   86: invokevirtual 156	java/io/FileOutputStream:close	()V
    //   89: aload_2
    //   90: ifnull +11 -> 101
    //   93: aload_2
    //   94: iconst_0
    //   95: aload_1
    //   96: invokeinterface 162 3 0
    //   101: aload_0
    //   102: ifnull +15 -> 117
    //   105: aload_0
    //   106: invokevirtual 155	java/io/InputStream:close	()V
    //   109: goto +8 -> 117
    //   112: astore_0
    //   113: aload_0
    //   114: invokevirtual 165	java/io/IOException:printStackTrace	()V
    //   117: aload 7
    //   119: invokevirtual 156	java/io/FileOutputStream:close	()V
    //   122: return
    //   123: astore 5
    //   125: aload_0
    //   126: astore 6
    //   128: goto +113 -> 241
    //   131: astore 6
    //   133: aload 7
    //   135: astore 5
    //   137: goto +16 -> 153
    //   140: astore 5
    //   142: iload 4
    //   144: istore_3
    //   145: goto +103 -> 248
    //   148: astore 6
    //   150: aconst_null
    //   151: astore 5
    //   153: aload 6
    //   155: astore 7
    //   157: aload_0
    //   158: astore 6
    //   160: aload 5
    //   162: astore_0
    //   163: goto +21 -> 184
    //   166: astore 5
    //   168: aconst_null
    //   169: astore_0
    //   170: iload 4
    //   172: istore_3
    //   173: goto +75 -> 248
    //   176: astore 7
    //   178: aconst_null
    //   179: astore_0
    //   180: aload 5
    //   182: astore 6
    //   184: aload 7
    //   186: invokevirtual 166	java/lang/Exception:printStackTrace	()V
    //   189: aload_2
    //   190: ifnull +11 -> 201
    //   193: aload_2
    //   194: iconst_m1
    //   195: aload_1
    //   196: invokeinterface 162 3 0
    //   201: aload 6
    //   203: ifnull +16 -> 219
    //   206: aload 6
    //   208: invokevirtual 155	java/io/InputStream:close	()V
    //   211: goto +8 -> 219
    //   214: astore_1
    //   215: aload_1
    //   216: invokevirtual 165	java/io/IOException:printStackTrace	()V
    //   219: aload_0
    //   220: ifnull +13 -> 233
    //   223: aload_0
    //   224: invokevirtual 156	java/io/FileOutputStream:close	()V
    //   227: return
    //   228: astore_0
    //   229: aload_0
    //   230: invokevirtual 165	java/io/IOException:printStackTrace	()V
    //   233: return
    //   234: astore 5
    //   236: iconst_m1
    //   237: istore_3
    //   238: aload_0
    //   239: astore 7
    //   241: aload 6
    //   243: astore_0
    //   244: aload 7
    //   246: astore 6
    //   248: aload_2
    //   249: ifnull +11 -> 260
    //   252: aload_2
    //   253: iload_3
    //   254: aload_1
    //   255: invokeinterface 162 3 0
    //   260: aload_0
    //   261: ifnull +15 -> 276
    //   264: aload_0
    //   265: invokevirtual 155	java/io/InputStream:close	()V
    //   268: goto +8 -> 276
    //   271: astore_0
    //   272: aload_0
    //   273: invokevirtual 165	java/io/IOException:printStackTrace	()V
    //   276: aload 6
    //   278: ifnull +16 -> 294
    //   281: aload 6
    //   283: invokevirtual 156	java/io/FileOutputStream:close	()V
    //   286: goto +8 -> 294
    //   289: astore_0
    //   290: aload_0
    //   291: invokevirtual 165	java/io/IOException:printStackTrace	()V
    //   294: goto +6 -> 300
    //   297: aload 5
    //   299: athrow
    //   300: goto -3 -> 297
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	paramString	String
    //   0	303	1	paramFile	File
    //   0	303	2	paramDownLoadCallBack	HippyQQFileUtil.DownLoadCallBack
    //   4	250	3	i	int
    //   1	170	4	j	int
    //   9	61	5	arrayOfByte	byte[]
    //   123	1	5	localObject1	Object
    //   135	1	5	localObject2	Object
    //   140	1	5	localObject3	Object
    //   151	10	5	localObject4	Object
    //   166	15	5	localObject5	Object
    //   234	64	5	localObject6	Object
    //   6	121	6	str1	String
    //   131	1	6	localException1	java.lang.Exception
    //   148	6	6	localException2	java.lang.Exception
    //   158	124	6	localObject7	Object
    //   44	112	7	localObject8	Object
    //   176	9	7	localException3	java.lang.Exception
    //   239	6	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   105	109	112	java/io/IOException
    //   46	53	123	finally
    //   53	61	123	finally
    //   67	77	123	finally
    //   80	89	123	finally
    //   46	53	131	java/lang/Exception
    //   53	61	131	java/lang/Exception
    //   67	77	131	java/lang/Exception
    //   80	89	131	java/lang/Exception
    //   36	46	140	finally
    //   36	46	148	java/lang/Exception
    //   11	36	166	finally
    //   11	36	176	java/lang/Exception
    //   206	211	214	java/io/IOException
    //   117	122	228	java/io/IOException
    //   223	227	228	java/io/IOException
    //   184	189	234	finally
    //   264	268	271	java/io/IOException
    //   281	286	289	java/io/IOException
  }
  
  @Deprecated
  public static File getDiffFile(String paramString, int paramInt)
  {
    try
    {
      File localFile = getHippyFileByType("dif");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(paramInt);
      localStringBuilder.append(".dif");
      paramString = new File(localFile, localStringBuilder.toString());
      return paramString;
    }
    finally {}
  }
  
  public static File getDiffPkgFile(String paramString, int paramInt)
  {
    return new File(new File(getModuleDownloadRootDir(paramString), String.valueOf(paramInt)), "diff.zip");
  }
  
  public static File getHippyFile()
  {
    Object localObject = MobileQQ.sMobileQQ;
    localObject = MobileQQ.getContext();
    if (localObject != null)
    {
      localObject = new File(((Context)localObject).getFilesDir(), "hippy");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdir();
      }
      return localObject;
    }
    return null;
  }
  
  public static File getHippyFileByType(String paramString)
  {
    File localFile = getHippyFile();
    if (localFile == null) {
      return null;
    }
    paramString = new File(localFile, paramString);
    if (!paramString.exists()) {
      paramString.mkdir();
    }
    return paramString;
  }
  
  public static File getHippyRootDir()
  {
    return new File(BaseApplication.getContext().getFilesDir(), "hippy");
  }
  
  public static File getJsBundleZipFile(String paramString, int paramInt)
  {
    return new File(new File(getModuleDownloadRootDir(paramString), String.valueOf(paramInt)), "jsbundle.zip");
  }
  
  public static File getModuleDownloadRootDir(String paramString)
  {
    return new File(new File(getHippyRootDir(), "pkg"), paramString);
  }
  
  public static File getModuleFile(String paramString)
  {
    try
    {
      File localFile = getHippyFileByType("bundle");
      if (localFile == null) {
        return null;
      }
      paramString = new File(localFile, paramString);
      if (!paramString.exists()) {
        paramString.mkdir();
      }
      return paramString;
    }
    finally {}
  }
  
  public static File getModuleFile(String paramString, int paramInt)
  {
    try
    {
      paramString = getModuleFile(paramString);
      if (paramInt < 0) {
        return paramString;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("");
      paramString = new File(paramString, localStringBuilder.toString());
      if (!paramString.exists()) {
        paramString.mkdir();
      }
      return paramString;
    }
    finally {}
  }
  
  public static File getModuleIndex(String paramString, int paramInt)
  {
    return new File(getModuleFile(paramString, paramInt), "index.android.jsbundle");
  }
  
  @Deprecated
  public static File getZipFile(String paramString, int paramInt)
  {
    try
    {
      File localFile = getHippyFileByType("zip");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(paramInt);
      localStringBuilder.append(".zip");
      paramString = new File(localFile, localStringBuilder.toString());
      return paramString;
    }
    finally {}
  }
  
  public static boolean unzipModulePackage(File paramFile, String paramString, int paramInt)
  {
    try
    {
      String str = getModuleFile(paramString).getAbsolutePath();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("_tmp_");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(File.separator);
      localStringBuilder.append((String)localObject);
      localObject = localStringBuilder.toString();
      if (!cooperation.qzone.util.FileUtils.unzip(paramFile, new File((String)localObject)))
      {
        paramFile = new StringBuilder();
        paramFile.append("unzipModulePackage unzip failure:");
        paramFile.append(paramString);
        paramFile.append(" version:");
        paramFile.append(paramInt);
        QLog.e("HippyQQFileUtil", 1, paramFile.toString());
        return false;
      }
      paramFile = new File((String)localObject, "index.android.jsbundle");
      if ((paramFile.exists()) && (paramFile.length() > 0L))
      {
        paramFile = new File(str, String.valueOf(paramInt));
        if (paramFile.exists()) {
          com.tencent.mobileqq.utils.FileUtils.deleteDirectory(paramFile.getAbsolutePath());
        }
        if (new File((String)localObject).renameTo(paramFile)) {
          return UpdateSetting.getInstance().isModuleVersionFileExists(paramString, paramInt);
        }
        QLog.e("HippyQQFileUtil", 1, "unzipModulePackage renameTo failure");
        return false;
      }
      QLog.e("HippyQQFileUtil", 1, "unzipModulePackage main bundle no exists");
      return false;
    }
    catch (Throwable paramFile)
    {
      paramString = new StringBuilder();
      paramString.append("unzipModulePackage failed ");
      paramString.append(paramFile);
      QLog.e("HippyQQFileUtil", 1, paramString.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.HippyQQFileUtil
 * JD-Core Version:    0.7.0.1
 */