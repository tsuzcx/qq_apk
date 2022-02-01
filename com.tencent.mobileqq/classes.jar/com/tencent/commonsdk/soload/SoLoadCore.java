package com.tencent.commonsdk.soload;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.BaseDexClassLoader;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class SoLoadCore
{
  public static final int API_BELOW_14 = 128;
  public static final int API_EUQAL_AND_ABOVE_14 = 256;
  public static final String APP_ROOT = "/data/data/com.tencent.mobileqq/files";
  private static final String CONFIGPATH = "soconfig.cfg";
  public static final int CONFIG_SO_PATH_IN_LIB = 32768;
  public static final int CONFIG_SO_PATH_IN_TXLIB = 16384;
  public static final int IF_CONFIG_SO_CRCCHECK_SUCCESS = 8192;
  public static final int IF_GENERATE_CACHE_SUCCESS = 2097152;
  public static final int IF_GET_AVAILIABLE_CRCVALUE = 1048576;
  public static final int IF_READ_CONFIGFILE_SUCCESS = 65536;
  public static final int IF_RELEASE_BY_CLASSLOADER_SUCCESS = 64;
  public static final int IF_RELEASE_BY_ZIP_CHECK_SUCCESS = 8;
  public static final int IF_RELEASE_SOFILE_CHECK_SUCCESS = 32;
  public static final int IF_SOFILE_EXIST_IN_LIBPATH = 2048;
  public static final int IF_SOFILE_IN_LIB_CHECK_SUCCESS = 1024;
  public static final int IF_SO_CONFIG_EXIST = 131072;
  public static final int IF_TRY_LOADSO_INLIBPATH_SUCCESS = 512;
  public static final int IF_TRY_LOAD_CONFIG_SO_SUCCESS = 4096;
  public static final int IF_TRY_LOAD_LIBRARY_SUCCESS = 524288;
  public static final int IF_TRY_LOAD_RELEASESO_SUCCESS = 16;
  public static final int IF_TRY_LOAD_SO_BY_ZIP_SUCCESS = 4;
  public static boolean IS_CPU_64_BIT = false;
  public static final int LOAD_SO_SUCCESS_SAVE_AND_RETURN = 2;
  private static final String PACKAGE_NAME = "com.tencent.mobileqq";
  public static final String PATH_LIB = "/lib/";
  public static final String PATH_TX_LIB = "/txlib/";
  private static final String TAG = "SoLoadCore";
  public static final int TRY_LOAD_LIBRARY_SUCCESS = 262144;
  private static HashMap<String, Long> assestCrcConfigs;
  
  public static boolean contentEquals(InputStream paramInputStream1, InputStream paramInputStream2)
  {
    Object localObject = paramInputStream1;
    if (!(paramInputStream1 instanceof BufferedInputStream)) {
      localObject = new BufferedInputStream(paramInputStream1);
    }
    paramInputStream1 = paramInputStream2;
    if (!(paramInputStream2 instanceof BufferedInputStream)) {
      paramInputStream1 = new BufferedInputStream(paramInputStream2);
    }
    boolean bool;
    for (int i = ((InputStream)localObject).read();; i = ((InputStream)localObject).read())
    {
      bool = false;
      if (-1 == i) {
        break;
      }
      if (i != paramInputStream1.read()) {
        return false;
      }
    }
    if (paramInputStream1.read() == -1) {
      bool = true;
    }
    return bool;
  }
  
  /* Error */
  private static void copyZipEntry2File(ZipEntry paramZipEntry, ZipFile paramZipFile, File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +261 -> 262
    //   4: aload_1
    //   5: ifnonnull +6 -> 11
    //   8: goto +254 -> 262
    //   11: aconst_null
    //   12: astore 5
    //   14: aconst_null
    //   15: astore 6
    //   17: aload_1
    //   18: aload_0
    //   19: invokevirtual 101	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   22: astore 4
    //   24: new 82	java/io/BufferedInputStream
    //   27: dup
    //   28: aload 4
    //   30: invokespecial 85	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   33: astore_0
    //   34: sipush 8192
    //   37: newarray byte
    //   39: astore 6
    //   41: new 103	java/io/BufferedOutputStream
    //   44: dup
    //   45: new 105	java/io/FileOutputStream
    //   48: dup
    //   49: aload_2
    //   50: invokespecial 108	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   53: invokespecial 111	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   56: astore_2
    //   57: aload_0
    //   58: aload 6
    //   60: invokevirtual 114	java/io/BufferedInputStream:read	([B)I
    //   63: istore_3
    //   64: iload_3
    //   65: iconst_m1
    //   66: if_icmpeq +14 -> 80
    //   69: aload_2
    //   70: aload 6
    //   72: iconst_0
    //   73: iload_3
    //   74: invokevirtual 118	java/io/BufferedOutputStream:write	([BII)V
    //   77: goto -20 -> 57
    //   80: aload_2
    //   81: invokevirtual 121	java/io/BufferedOutputStream:close	()V
    //   84: aload_0
    //   85: invokevirtual 122	java/io/BufferedInputStream:close	()V
    //   88: aload_2
    //   89: astore_0
    //   90: aload 4
    //   92: ifnull +10 -> 102
    //   95: aload 4
    //   97: invokevirtual 123	java/io/InputStream:close	()V
    //   100: aload_2
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual 121	java/io/BufferedOutputStream:close	()V
    //   106: aload_1
    //   107: invokevirtual 124	java/util/zip/ZipFile:close	()V
    //   110: return
    //   111: astore 6
    //   113: aload_2
    //   114: astore 5
    //   116: aload 6
    //   118: astore_2
    //   119: goto +109 -> 228
    //   122: astore 5
    //   124: aload_2
    //   125: astore 6
    //   127: goto +12 -> 139
    //   130: astore_2
    //   131: goto +97 -> 228
    //   134: astore 5
    //   136: aconst_null
    //   137: astore 6
    //   139: aload_0
    //   140: astore_2
    //   141: aload 6
    //   143: astore_0
    //   144: goto +40 -> 184
    //   147: astore_2
    //   148: aconst_null
    //   149: astore_0
    //   150: goto +78 -> 228
    //   153: astore 5
    //   155: aconst_null
    //   156: astore_0
    //   157: aload 6
    //   159: astore_2
    //   160: goto +24 -> 184
    //   163: astore_2
    //   164: aconst_null
    //   165: astore 4
    //   167: aload 4
    //   169: astore_0
    //   170: goto +58 -> 228
    //   173: astore 5
    //   175: aconst_null
    //   176: astore 4
    //   178: aload 4
    //   180: astore_0
    //   181: aload 6
    //   183: astore_2
    //   184: aload 5
    //   186: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   189: aload_2
    //   190: ifnull +7 -> 197
    //   193: aload_2
    //   194: invokevirtual 122	java/io/BufferedInputStream:close	()V
    //   197: aload 4
    //   199: ifnull +8 -> 207
    //   202: aload 4
    //   204: invokevirtual 123	java/io/InputStream:close	()V
    //   207: aload_0
    //   208: ifnull -102 -> 106
    //   211: goto -109 -> 102
    //   214: astore 5
    //   216: aload_2
    //   217: astore 6
    //   219: aload 5
    //   221: astore_2
    //   222: aload_0
    //   223: astore 5
    //   225: aload 6
    //   227: astore_0
    //   228: aload_0
    //   229: ifnull +7 -> 236
    //   232: aload_0
    //   233: invokevirtual 122	java/io/BufferedInputStream:close	()V
    //   236: aload 4
    //   238: ifnull +8 -> 246
    //   241: aload 4
    //   243: invokevirtual 123	java/io/InputStream:close	()V
    //   246: aload 5
    //   248: ifnull +8 -> 256
    //   251: aload 5
    //   253: invokevirtual 121	java/io/BufferedOutputStream:close	()V
    //   256: aload_1
    //   257: invokevirtual 124	java/util/zip/ZipFile:close	()V
    //   260: aload_2
    //   261: athrow
    //   262: aload_1
    //   263: invokevirtual 124	java/util/zip/ZipFile:close	()V
    //   266: return
    //   267: astore_0
    //   268: goto -162 -> 106
    //   271: astore_0
    //   272: return
    //   273: astore_0
    //   274: goto -18 -> 256
    //   277: astore_0
    //   278: goto -18 -> 260
    //   281: astore_0
    //   282: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	paramZipEntry	ZipEntry
    //   0	283	1	paramZipFile	ZipFile
    //   0	283	2	paramFile	File
    //   63	11	3	i	int
    //   22	220	4	localInputStream	InputStream
    //   12	103	5	localFile1	File
    //   122	1	5	localIOException1	IOException
    //   134	1	5	localIOException2	IOException
    //   153	1	5	localIOException3	IOException
    //   173	12	5	localIOException4	IOException
    //   214	6	5	localObject1	Object
    //   223	29	5	localZipEntry	ZipEntry
    //   15	56	6	arrayOfByte	byte[]
    //   111	6	6	localObject2	Object
    //   125	101	6	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   57	64	111	finally
    //   69	77	111	finally
    //   80	84	111	finally
    //   57	64	122	java/io/IOException
    //   69	77	122	java/io/IOException
    //   80	84	122	java/io/IOException
    //   34	57	130	finally
    //   34	57	134	java/io/IOException
    //   24	34	147	finally
    //   24	34	153	java/io/IOException
    //   17	24	163	finally
    //   17	24	173	java/io/IOException
    //   184	189	214	finally
    //   84	88	267	java/io/IOException
    //   95	100	267	java/io/IOException
    //   102	106	267	java/io/IOException
    //   193	197	267	java/io/IOException
    //   202	207	267	java/io/IOException
    //   106	110	271	java/io/IOException
    //   232	236	273	java/io/IOException
    //   241	246	273	java/io/IOException
    //   251	256	273	java/io/IOException
    //   256	260	277	java/io/IOException
    //   262	266	281	java/io/IOException
  }
  
  public static String getApkPath(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    paramContext = paramContext.getPackageName();
    try
    {
      paramContext = localPackageManager.getApplicationInfo(paramContext, 8192);
      if (paramContext != null)
      {
        paramContext = paramContext.sourceDir;
        return paramContext;
      }
      return null;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static File getAppWorkFile(Context paramContext)
  {
    try
    {
      localObject = paramContext.getFilesDir().getParentFile();
      return localObject;
    }
    catch (Exception localException)
    {
      Object localObject;
      label10:
      label81:
      break label10;
    }
    try
    {
      if ((paramContext instanceof ContextWrapper))
      {
        paramContext = ((ContextWrapper)paramContext).getBaseContext();
      }
      else
      {
        localObject = ContextWrapper.class.getDeclaredField("mBase");
        ((Field)localObject).setAccessible(true);
        paramContext = ((Field)localObject).get(paramContext);
      }
      localObject = paramContext.getClass().getDeclaredMethod("getDataDirFile", new Class[0]);
      ((Method)localObject).setAccessible(true);
      paramContext = (File)((Method)localObject).invoke(paramContext, new Object[0]);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      break label81;
    }
    return null;
  }
  
  public static String getAppWorkPath(Context paramContext)
  {
    try
    {
      localObject = paramContext.getFilesDir().getParent();
      return localObject;
    }
    catch (Exception localException)
    {
      Object localObject;
      label10:
      label84:
      break label10;
    }
    try
    {
      if ((paramContext instanceof ContextWrapper))
      {
        paramContext = ((ContextWrapper)paramContext).getBaseContext();
      }
      else
      {
        localObject = ContextWrapper.class.getDeclaredField("mBase");
        ((Field)localObject).setAccessible(true);
        paramContext = ((Field)localObject).get(paramContext);
      }
      localObject = paramContext.getClass().getDeclaredMethod("getDataDirFile", new Class[0]);
      ((Method)localObject).setAccessible(true);
      paramContext = ((File)((Method)localObject).invoke(paramContext, new Object[0])).getAbsolutePath();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      break label84;
    }
    return null;
  }
  
  /* Error */
  public static long getCRC32Value(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +116 -> 117
    //   4: aload_0
    //   5: invokevirtual 222	java/io/File:exists	()Z
    //   8: ifne +7 -> 15
    //   11: ldc2_w 223
    //   14: lreturn
    //   15: aconst_null
    //   16: astore 5
    //   18: aconst_null
    //   19: astore_3
    //   20: new 226	java/io/FileInputStream
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 227	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   28: astore_0
    //   29: aload_0
    //   30: invokestatic 230	com/tencent/commonsdk/soload/SoLoadCore:getCRC32Value	(Ljava/io/InputStream;)J
    //   33: lstore_1
    //   34: aload_0
    //   35: invokevirtual 231	java/io/FileInputStream:close	()V
    //   38: lload_1
    //   39: lreturn
    //   40: astore_0
    //   41: aload_0
    //   42: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   45: lload_1
    //   46: lreturn
    //   47: astore 4
    //   49: aload_0
    //   50: astore_3
    //   51: aload 4
    //   53: astore_0
    //   54: goto +45 -> 99
    //   57: astore 4
    //   59: goto +12 -> 71
    //   62: astore_0
    //   63: goto +36 -> 99
    //   66: astore 4
    //   68: aload 5
    //   70: astore_0
    //   71: aload_0
    //   72: astore_3
    //   73: aload 4
    //   75: invokevirtual 232	java/lang/Exception:printStackTrace	()V
    //   78: aload_0
    //   79: ifnull +16 -> 95
    //   82: aload_0
    //   83: invokevirtual 231	java/io/FileInputStream:close	()V
    //   86: ldc2_w 223
    //   89: lreturn
    //   90: astore_0
    //   91: aload_0
    //   92: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   95: ldc2_w 223
    //   98: lreturn
    //   99: aload_3
    //   100: ifnull +15 -> 115
    //   103: aload_3
    //   104: invokevirtual 231	java/io/FileInputStream:close	()V
    //   107: goto +8 -> 115
    //   110: astore_3
    //   111: aload_3
    //   112: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   115: aload_0
    //   116: athrow
    //   117: ldc2_w 223
    //   120: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	paramFile	File
    //   33	13	1	l	long
    //   19	85	3	localFile	File
    //   110	2	3	localIOException	IOException
    //   47	5	4	localObject1	Object
    //   57	1	4	localException1	Exception
    //   66	8	4	localException2	Exception
    //   16	53	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   34	38	40	java/io/IOException
    //   29	34	47	finally
    //   29	34	57	java/lang/Exception
    //   20	29	62	finally
    //   73	78	62	finally
    //   20	29	66	java/lang/Exception
    //   82	86	90	java/io/IOException
    //   103	107	110	java/io/IOException
  }
  
  public static long getCRC32Value(InputStream paramInputStream)
  {
    byte[] arrayOfByte = new byte[8192];
    CRC32 localCRC32 = new CRC32();
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localCRC32.update(arrayOfByte, 0, i);
    }
    return localCRC32.getValue();
  }
  
  private static String getCurProcessName(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getApplicationContext().getSystemService("activity")).getRunningAppProcesses();
    if (paramContext != null)
    {
      int i = Process.myPid();
      Object localObject = paramContext.iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramContext = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if ((paramContext.processName.startsWith("com.tencent.mobileqq")) && (paramContext.pid == i))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramContext.processName);
          ((StringBuilder)localObject).append("_");
          ((StringBuilder)localObject).append(i);
          return ((StringBuilder)localObject).toString();
        }
      }
    }
    return null;
  }
  
  private static String getDefaultPlatformString()
  {
    try
    {
      String str = Build.CPU_ABI;
      if ((str != null) && (str.contains("64"))) {
        return "arm64-v8a";
      }
      return "armeabi";
    }
    finally {}
  }
  
  @SuppressLint({"SdCardPath"})
  public static File getExistFile(Context paramContext, String paramString)
  {
    File localFile = new File(paramContext.getFilesDir(), paramString);
    Object localObject = localFile;
    if (!localFile.exists())
    {
      paramContext = new File(paramContext.getFilesDir(), paramString);
      localObject = paramContext;
      if (!paramContext.exists())
      {
        paramContext = new File("/data/data/com.tencent.mobileqq/files", paramString);
        localObject = paramContext;
        if (!paramContext.exists()) {
          localObject = null;
        }
      }
    }
    return localObject;
  }
  
  public static String getLibActualName(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lib");
    localStringBuilder.append(paramString);
    localStringBuilder.append(".so");
    return localStringBuilder.toString();
  }
  
  public static String getOsClassLoader()
  {
    try
    {
      Class.forName("dalvik.system.LexClassLoader");
      return "lex";
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      label11:
      int i;
      label23:
      break label11;
    }
    i = 1;
    try
    {
      Class.forName("dalvik.system.BaseDexClassLoader");
    }
    catch (ClassNotFoundException localClassNotFoundException2)
    {
      break label23;
    }
    i = 0;
    if (i == 0) {
      return "below14";
    }
    return "equalAndAbove14";
  }
  
  private static String getPlatform32String()
  {
    try
    {
      String str = Build.CPU_ABI;
      if ((str != null) && (str.contains("x86"))) {
        return "x86";
      }
      if ((str != null) && (str.contains("mip"))) {
        return "mips";
      }
      return "armeabi";
    }
    finally {}
  }
  
  private static String getPlatform64String()
  {
    try
    {
      String str = Build.CPU_ABI;
      if ((str != null) && (str.contains("x86_64"))) {
        return "x86_64";
      }
      if ((str != null) && (str.contains("mips64"))) {
        return "mips64";
      }
      return "arm64-v8a";
    }
    finally {}
  }
  
  private static String getPlatformString()
  {
    try
    {
      if (IS_CPU_64_BIT)
      {
        str = getPlatform64String();
        return str;
      }
      String str = getPlatform32String();
      return str;
    }
    finally {}
  }
  
  public static String getReleasedSoFilePath(Context paramContext, String paramString)
  {
    paramString = getLibActualName(paramString);
    initAssestCrcConfigs(paramContext);
    Object localObject = assestCrcConfigs;
    if ((localObject != null) && (!((HashMap)localObject).isEmpty()))
    {
      localObject = assestCrcConfigs;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getDefaultPlatformString());
      localStringBuilder.append("/");
      localStringBuilder.append(paramString);
      localObject = (Long)((HashMap)localObject).get(localStringBuilder.toString());
      if (localObject != null)
      {
        long l = ((Long)localObject).longValue();
        if (l > 0L)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramContext.getFilesDir());
          ((StringBuilder)localObject).append("/soconfigs");
          paramContext = ((StringBuilder)localObject).toString();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramContext);
          ((StringBuilder)localObject).append("/");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(".cfg");
          paramContext = new File(((StringBuilder)localObject).toString());
          if ((paramContext.exists()) && (paramContext.isFile()))
          {
            paramContext = readConfig(paramContext);
            if ((paramContext != null) && (paramContext.mCrcvalue == l)) {
              return paramContext.mSopath;
            }
          }
        }
      }
    }
    return null;
  }
  
  private static File getSoOrDexByBaseDexClassLoader(Context paramContext, String paramString1, String paramString2)
  {
    File localFile = new File(paramString2);
    if (localFile.exists()) {
      localFile.delete();
    }
    paramString2 = paramContext.getClassLoader();
    paramContext = (BaseDexClassLoader)paramContext.getClassLoader();
    paramString2 = paramString2.getClass().getSuperclass();
    for (;;)
    {
      int i;
      try
      {
        localFile.createNewFile();
        Object localObject1 = paramString2.getDeclaredField("pathList");
        ((Field)localObject1).setAccessible(true);
        paramString2 = ((Field)localObject1).get(paramContext);
        paramContext = ((Field)localObject1).get(paramContext).getClass().getDeclaredField("dexElements");
        paramContext.setAccessible(true);
        Object localObject3 = paramContext.get(paramString2);
        if (localObject3.getClass().isArray())
        {
          int j = Array.getLength(localObject3);
          if (j > 0)
          {
            i = 0;
            paramString2 = null;
            paramContext = paramString2;
            Object localObject2 = paramString2;
            localObject1 = paramContext;
            if (i < j)
            {
              localObject1 = Array.get(localObject3, i);
              localObject2 = localObject1.getClass().getDeclaredField("zipFile");
              ((Field)localObject2).setAccessible(true);
              localObject1 = ((Field)localObject2).get(localObject1);
              if (localObject1 == null) {
                break label241;
              }
              localObject1 = (ZipFile)localObject1;
              localObject2 = ((ZipFile)localObject1).getEntry(paramString1);
              paramString2 = (String)localObject2;
              paramContext = (Context)localObject1;
              if (localObject2 == null) {
                break label241;
              }
            }
            if ((localObject2 == null) || (localObject1 == null)) {
              break label239;
            }
            copyZipEntry2File((ZipEntry)localObject2, (ZipFile)localObject1, localFile);
          }
        }
        return localFile;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
      label239:
      return null;
      label241:
      i += 1;
    }
  }
  
  public static File getSoOrDexByPathClassLoader(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString2);
    ((StringBuilder)localObject1).append(paramString1);
    localObject1 = new File(((StringBuilder)localObject1).toString());
    paramContext = paramContext.getClassLoader();
    paramString2 = paramContext.getClass();
    for (;;)
    {
      int i;
      try
      {
        paramString2 = paramString2.getDeclaredField("mZips");
        paramString2.setAccessible(true);
        Object localObject2 = paramString2.get(paramContext);
        if (localObject2.getClass().isArray())
        {
          int j = Array.getLength(localObject2);
          i = 0;
          paramString2 = null;
          paramContext = paramString2;
          if (i < j)
          {
            paramContext = (ZipFile)Array.get(localObject2, i);
            paramString2 = paramContext.getEntry(paramString1);
            if (paramString2 == null) {
              break label145;
            }
          }
          if ((paramString2 != null) && (paramContext != null)) {
            copyZipEntry2File(paramString2, paramContext, (File)localObject1);
          }
        }
        else
        {
          return localObject1;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
      return null;
      label145:
      i += 1;
    }
  }
  
  private static boolean hasBaseDexClassloader()
  {
    try
    {
      Class.forName("dalvik.system.BaseDexClassLoader");
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label9:
      break label9;
    }
    return false;
  }
  
  private static void initAssestCrcConfigs(Context paramContext)
  {
    for (;;)
    {
      try
      {
        localObject1 = assestCrcConfigs;
        if (localObject1 != null) {
          return;
        }
        str1 = null;
        localBufferedReader = null;
        localObject1 = localBufferedReader;
        localObject2 = str1;
      }
      finally
      {
        Object localObject1;
        String str1;
        BufferedReader localBufferedReader;
        Object localObject2;
        continue;
        throw paramContext;
        continue;
      }
      try
      {
        try
        {
          assestCrcConfigs = new HashMap();
          localObject1 = localBufferedReader;
          localObject2 = str1;
          paramContext = paramContext.getResources().getAssets().open("soconfig.cfg");
          localObject1 = paramContext;
          localObject2 = paramContext;
          localBufferedReader = new BufferedReader(new InputStreamReader(paramContext));
          localObject1 = paramContext;
          localObject2 = paramContext;
          str1 = localBufferedReader.readLine();
          if (str1 != null)
          {
            localObject1 = paramContext;
            localObject2 = paramContext;
            int i = str1.indexOf(":");
            localObject1 = paramContext;
            localObject2 = paramContext;
            String str2 = str1.substring(0, i);
            localObject1 = paramContext;
            localObject2 = paramContext;
            long l = Long.parseLong(str1.substring(i + 1));
            if (l < 1L) {
              continue;
            }
            localObject1 = paramContext;
            localObject2 = paramContext;
            assestCrcConfigs.put(str2, Long.valueOf(l));
            continue;
          }
          if (paramContext == null) {
            continue;
          }
          try
          {
            paramContext.close();
          }
          catch (IOException paramContext) {}
          paramContext.printStackTrace();
        }
        finally
        {
          continue;
        }
      }
      catch (Exception paramContext)
      {
        continue;
      }
      localObject1 = localObject2;
      QLog.e("SoLoadCore", 1, "initAssestCrcConfigs failed");
      if (localObject2 == null) {
        continue;
      }
      try
      {
        ((InputStream)localObject2).close();
      }
      catch (IOException paramContext) {}
    }
    return;
    if (localObject1 != null) {
      try
      {
        ((InputStream)localObject1).close();
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
    throw paramContext;
  }
  
  /* Error */
  public static boolean isLibExtracted(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokestatic 539	com/tencent/commonsdk/soload/SoLoadCore:getExistFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   5: ifnonnull +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: aload_0
    //   11: aload_2
    //   12: invokestatic 539	com/tencent/commonsdk/soload/SoLoadCore:getExistFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   15: astore 5
    //   17: aload 5
    //   19: ifnonnull +5 -> 24
    //   22: iconst_0
    //   23: ireturn
    //   24: aconst_null
    //   25: astore_1
    //   26: aconst_null
    //   27: astore 4
    //   29: aload_0
    //   30: invokevirtual 540	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   33: aload_2
    //   34: invokevirtual 491	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   37: astore_0
    //   38: new 226	java/io/FileInputStream
    //   41: dup
    //   42: aload 5
    //   44: invokespecial 227	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   47: astore 4
    //   49: aload_0
    //   50: aload 4
    //   52: invokestatic 542	com/tencent/commonsdk/soload/SoLoadCore:contentEquals	(Ljava/io/InputStream;Ljava/io/InputStream;)Z
    //   55: istore_3
    //   56: aload_0
    //   57: ifnull +7 -> 64
    //   60: aload_0
    //   61: invokevirtual 123	java/io/InputStream:close	()V
    //   64: aload 4
    //   66: invokevirtual 123	java/io/InputStream:close	()V
    //   69: iload_3
    //   70: ireturn
    //   71: astore_1
    //   72: aload 4
    //   74: astore_2
    //   75: goto +79 -> 154
    //   78: astore_2
    //   79: aload 4
    //   81: astore_1
    //   82: goto +16 -> 98
    //   85: astore 4
    //   87: aload_1
    //   88: astore_2
    //   89: aload 4
    //   91: astore_1
    //   92: goto +62 -> 154
    //   95: astore_2
    //   96: aconst_null
    //   97: astore_1
    //   98: aload_0
    //   99: astore 4
    //   101: aload_1
    //   102: astore_0
    //   103: goto +18 -> 121
    //   106: astore 4
    //   108: aconst_null
    //   109: astore_0
    //   110: aload_1
    //   111: astore_2
    //   112: aload 4
    //   114: astore_1
    //   115: goto +39 -> 154
    //   118: astore_2
    //   119: aconst_null
    //   120: astore_0
    //   121: aload_2
    //   122: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   125: aload 4
    //   127: ifnull +11 -> 138
    //   130: aload 4
    //   132: invokevirtual 123	java/io/InputStream:close	()V
    //   135: goto +3 -> 138
    //   138: aload_0
    //   139: ifnull +7 -> 146
    //   142: aload_0
    //   143: invokevirtual 123	java/io/InputStream:close	()V
    //   146: iconst_0
    //   147: ireturn
    //   148: astore_1
    //   149: aload_0
    //   150: astore_2
    //   151: aload 4
    //   153: astore_0
    //   154: aload_0
    //   155: ifnull +10 -> 165
    //   158: aload_0
    //   159: invokevirtual 123	java/io/InputStream:close	()V
    //   162: goto +3 -> 165
    //   165: aload_2
    //   166: ifnull +7 -> 173
    //   169: aload_2
    //   170: invokevirtual 123	java/io/InputStream:close	()V
    //   173: aload_1
    //   174: athrow
    //   175: astore_0
    //   176: goto -112 -> 64
    //   179: astore_0
    //   180: iload_3
    //   181: ireturn
    //   182: astore_1
    //   183: goto -45 -> 138
    //   186: astore_0
    //   187: iconst_0
    //   188: ireturn
    //   189: astore_0
    //   190: goto -25 -> 165
    //   193: astore_0
    //   194: goto -21 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	paramContext	Context
    //   0	197	1	paramString1	String
    //   0	197	2	paramString2	String
    //   55	126	3	bool	boolean
    //   27	53	4	localFileInputStream	java.io.FileInputStream
    //   85	5	4	localObject1	Object
    //   99	1	4	localContext	Context
    //   106	46	4	localObject2	Object
    //   15	28	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   49	56	71	finally
    //   49	56	78	java/io/IOException
    //   38	49	85	finally
    //   38	49	95	java/io/IOException
    //   29	38	106	finally
    //   29	38	118	java/io/IOException
    //   121	125	148	finally
    //   60	64	175	java/io/IOException
    //   64	69	179	java/io/IOException
    //   130	135	182	java/io/IOException
    //   142	146	186	java/io/IOException
    //   158	162	189	java/io/IOException
    //   169	173	193	java/io/IOException
  }
  
  private static boolean loadAndSave(File paramFile1, String paramString, long paramLong, File paramFile2)
  {
    boolean bool2 = true;
    boolean bool1;
    try
    {
      System.load(paramFile1.getAbsolutePath());
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("System.load path = ");
        localStringBuilder.append(paramFile1.getAbsolutePath());
        localStringBuilder.append(" suc");
        QLog.d("SoLoadCore", 2, localStringBuilder.toString());
        bool1 = bool2;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      reportThrowable(localUnsatisfiedLinkError, paramString);
      paramString = new StringBuilder();
      paramString.append("System.load path = ");
      paramString.append(paramFile1.getAbsolutePath());
      paramString.append(" failed");
      QLog.e("SoLoadCore", 1, paramString.toString(), localUnsatisfiedLinkError);
      bool1 = false;
    }
    if (bool1) {
      writeConfig(new ConfigStruct(paramLong, paramFile1.getAbsolutePath()), paramFile2);
    }
    return bool1;
  }
  
  public static int loadSo(Context paramContext, String paramString)
  {
    String str = getLibActualName(paramString);
    initAssestCrcConfigs(paramContext);
    Object localObject1 = assestCrcConfigs;
    long l2 = -1L;
    long l1;
    if ((localObject1 != null) && (!((HashMap)localObject1).isEmpty()))
    {
      j = 3145728;
      localObject1 = assestCrcConfigs;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(getPlatformString());
      ((StringBuilder)localObject2).append("/");
      ((StringBuilder)localObject2).append(str);
      localObject1 = (Long)((HashMap)localObject1).get(((StringBuilder)localObject2).toString());
      if ((localObject1 != null) && (((Long)localObject1).longValue() > 1L))
      {
        l1 = ((Long)localObject1).longValue();
        i = j;
      }
      else
      {
        localObject1 = assestCrcConfigs;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(getDefaultPlatformString());
        ((StringBuilder)localObject2).append("/");
        ((StringBuilder)localObject2).append(str);
        localObject1 = (Long)((HashMap)localObject1).get(((StringBuilder)localObject2).toString());
        i = j;
        l1 = l2;
        if (localObject1 != null)
        {
          i = j;
          l1 = l2;
          if (((Long)localObject1).longValue() > 1L)
          {
            l1 = ((Long)localObject1).longValue();
            i = j;
          }
        }
      }
    }
    else
    {
      i = 2097152;
      l1 = l2;
    }
    if (l1 < 0L)
    {
      j = 0x80000 | i;
      i = j;
      int k;
      try
      {
        System.loadLibrary(paramString);
        j |= 0x40000;
        i = j;
        k = j;
        if (QLog.isColorLevel())
        {
          i = j;
          paramContext = new StringBuilder();
          i = j;
          paramContext.append("System.loadLibrary, lib = ");
          i = j;
          paramContext.append(paramString);
          i = j;
          paramContext.append(" suc");
          i = j;
          QLog.d("SoLoadCore", 2, paramContext.toString());
          return j;
        }
      }
      catch (UnsatisfiedLinkError paramContext)
      {
        reportThrowable(paramContext, paramString);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("try System.loadLibrary, lib = ");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(" failed");
        QLog.e("SoLoadCore", 1, ((StringBuilder)localObject1).toString(), paramContext);
        k = i;
      }
      return k;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramContext.getFilesDir());
    ((StringBuilder)localObject1).append("/soconfigs");
    localObject1 = ((StringBuilder)localObject1).toString();
    new File((String)localObject1).mkdirs();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("/");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(".cfg");
    localObject1 = ((StringBuilder)localObject2).toString();
    int j = i | 0x20000;
    localObject2 = new File((String)localObject1);
    int i = j;
    if (((File)localObject2).exists())
    {
      localObject3 = readConfig((File)localObject2);
      j |= 0x10000;
      i = j;
      if (localObject3 != null)
      {
        if (((ConfigStruct)localObject3).mSopath.contains("/txlib/")) {
          i = j | 0x4000;
        } else {
          i = j | 0x8000;
        }
        localObject1 = new File(((ConfigStruct)localObject3).mSopath);
        j = i | 0x2000;
        i = j;
        if (((ConfigStruct)localObject3).mCrcvalue == l1)
        {
          i = j;
          if (((File)localObject1).exists())
          {
            j |= 0x1000;
            i = j;
          }
        }
      }
    }
    try
    {
      System.load(((File)localObject1).getAbsolutePath());
      j |= 0x2;
      i = j;
      if (QLog.isColorLevel())
      {
        i = j;
        localObject3 = new StringBuilder();
        i = j;
        ((StringBuilder)localObject3).append("System.load path = ");
        i = j;
        ((StringBuilder)localObject3).append(((File)localObject1).getAbsolutePath());
        i = j;
        ((StringBuilder)localObject3).append(" suc");
        i = j;
        QLog.d("SoLoadCore", 2, ((StringBuilder)localObject3).toString());
      }
      return j;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label668:
      Object localObject4;
      break label668;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(getAppWorkPath(paramContext));
    ((StringBuilder)localObject1).append("/txlib/");
    Object localObject3 = ((StringBuilder)localObject1).toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(getAppWorkPath(paramContext));
    ((StringBuilder)localObject1).append("/lib/");
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append((String)localObject1);
    ((StringBuilder)localObject4).append(str);
    localObject1 = new File(((StringBuilder)localObject4).toString());
    j = i | 0x800;
    i = j;
    if (((File)localObject1).exists())
    {
      j |= 0x400;
      l2 = getCRC32Value((File)localObject1);
      i = j;
      if (l2 == l1)
      {
        j |= 0x200;
        i = j;
        if (loadAndSave((File)localObject1, paramString, l2, (File)localObject2)) {
          return j | 0x2;
        }
      }
    }
    localObject4 = getOsClassLoader();
    localObject1 = null;
    if (((String)localObject4).equals("equalAndAbove14"))
    {
      j = i | 0x100;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("lib/");
      ((StringBuilder)localObject1).append(getPlatformString());
      ((StringBuilder)localObject1).append("/");
      ((StringBuilder)localObject1).append(str);
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append((String)localObject3);
      ((StringBuilder)localObject4).append(str);
      localObject1 = getSoOrDexByBaseDexClassLoader(paramContext, (String)localObject1, ((StringBuilder)localObject4).toString());
    }
    else
    {
      j = i;
      if (((String)localObject4).equals("below14"))
      {
        j = i | 0x80;
        localObject1 = getSoOrDexByPathClassLoader(paramContext, str, (String)localObject3);
      }
    }
    j |= 0x40;
    i = j;
    if (localObject1 != null)
    {
      l2 = getCRC32Value((File)localObject1);
      j |= 0x20;
      if (l2 == l1)
      {
        j |= 0x10;
        i = j;
        if (loadAndSave((File)localObject1, paramString, l2, (File)localObject2)) {
          return j | 0x2;
        }
      }
      else
      {
        i = j;
        if (((File)localObject1).exists())
        {
          ((File)localObject1).delete();
          i = j;
        }
      }
    }
    paramContext = releaseFromApk(getApkPath(paramContext), str, (String)localObject3);
    l2 = getCRC32Value(paramContext);
    j = i | 0x8;
    i = j;
    if (l2 == l1)
    {
      j |= 0x4;
      i = j;
      if (loadAndSave(paramContext, paramString, l2, (File)localObject2)) {
        i = j | 0x2;
      }
    }
    return i;
  }
  
  /* Error */
  private static ConfigStruct readConfig(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: new 493	java/io/BufferedReader
    //   9: dup
    //   10: new 495	java/io/InputStreamReader
    //   13: dup
    //   14: new 226	java/io/FileInputStream
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 227	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   22: invokespecial 496	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   25: invokespecial 499	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   28: astore_3
    //   29: aload_3
    //   30: invokevirtual 502	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   33: astore_0
    //   34: aload_0
    //   35: ifnull +117 -> 152
    //   38: aload_0
    //   39: ldc_w 620
    //   42: invokevirtual 320	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   45: ifeq +107 -> 152
    //   48: aload_0
    //   49: aload_0
    //   50: ldc_w 622
    //   53: invokevirtual 508	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   56: iconst_1
    //   57: iadd
    //   58: invokevirtual 515	java/lang/String:substring	(I)Ljava/lang/String;
    //   61: invokestatic 519	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   64: lstore_1
    //   65: aload_3
    //   66: invokevirtual 502	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   69: astore_0
    //   70: aload_0
    //   71: ifnull +152 -> 223
    //   74: aload_0
    //   75: ldc_w 624
    //   78: invokevirtual 320	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   81: ifeq +142 -> 223
    //   84: aload_0
    //   85: aload_0
    //   86: ldc_w 622
    //   89: invokevirtual 508	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   92: iconst_1
    //   93: iadd
    //   94: invokevirtual 515	java/lang/String:substring	(I)Ljava/lang/String;
    //   97: astore 4
    //   99: goto +3 -> 102
    //   102: aload 6
    //   104: astore_0
    //   105: lload_1
    //   106: ldc2_w 580
    //   109: lcmp
    //   110: ifeq +25 -> 135
    //   113: aload 6
    //   115: astore_0
    //   116: aload 4
    //   118: ldc_w 626
    //   121: if_acmpeq +14 -> 135
    //   124: new 422	com/tencent/commonsdk/soload/ConfigStruct
    //   127: dup
    //   128: lload_1
    //   129: aload 4
    //   131: invokespecial 573	com/tencent/commonsdk/soload/ConfigStruct:<init>	(JLjava/lang/String;)V
    //   134: astore_0
    //   135: aload_0
    //   136: astore 4
    //   138: aload_3
    //   139: invokevirtual 627	java/io/BufferedReader:close	()V
    //   142: aload_0
    //   143: areturn
    //   144: astore_0
    //   145: aload_0
    //   146: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   149: aload 4
    //   151: areturn
    //   152: aload_3
    //   153: invokevirtual 627	java/io/BufferedReader:close	()V
    //   156: aconst_null
    //   157: areturn
    //   158: astore_0
    //   159: aload_0
    //   160: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   163: aconst_null
    //   164: areturn
    //   165: astore_0
    //   166: goto +17 -> 183
    //   169: goto +32 -> 201
    //   172: astore_0
    //   173: aconst_null
    //   174: astore_3
    //   175: goto +8 -> 183
    //   178: aconst_null
    //   179: astore_3
    //   180: goto +21 -> 201
    //   183: aload_3
    //   184: ifnull +15 -> 199
    //   187: aload_3
    //   188: invokevirtual 627	java/io/BufferedReader:close	()V
    //   191: goto +8 -> 199
    //   194: astore_3
    //   195: aload_3
    //   196: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   199: aload_0
    //   200: athrow
    //   201: aload_3
    //   202: ifnull +11 -> 213
    //   205: aload 5
    //   207: astore 4
    //   209: aload_3
    //   210: invokevirtual 627	java/io/BufferedReader:close	()V
    //   213: aconst_null
    //   214: areturn
    //   215: astore_0
    //   216: goto -38 -> 178
    //   219: astore_0
    //   220: goto -51 -> 169
    //   223: ldc_w 626
    //   226: astore 4
    //   228: goto -126 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	paramFile	File
    //   64	65	1	l	long
    //   28	160	3	localBufferedReader	BufferedReader
    //   194	16	3	localIOException	IOException
    //   97	130	4	localObject1	Object
    //   1	205	5	localObject2	Object
    //   4	110	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   138	142	144	java/io/IOException
    //   209	213	144	java/io/IOException
    //   152	156	158	java/io/IOException
    //   29	34	165	finally
    //   38	70	165	finally
    //   74	99	165	finally
    //   124	135	165	finally
    //   6	29	172	finally
    //   187	191	194	java/io/IOException
    //   6	29	215	java/lang/Exception
    //   29	34	219	java/lang/Exception
    //   38	70	219	java/lang/Exception
    //   74	99	219	java/lang/Exception
    //   124	135	219	java/lang/Exception
  }
  
  public static boolean releaseDexFromApk(Context paramContext, String paramString)
  {
    Object localObject1 = paramContext.getFilesDir();
    if (localObject1 != null) {
      localObject1 = ((File)localObject1).getAbsolutePath();
    } else {
      localObject1 = "/data/data/com.tencent.mobileqq/files";
    }
    Object localObject2 = localObject1;
    if (!((String)localObject1).endsWith(File.separator))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(File.separator);
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    new File((String)localObject2).mkdirs();
    DexReleasor localDexReleasor = DexReleasor.getInstance(getApkPath(paramContext), (String)localObject2);
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      int j = DexReleasor.sExtraDexes.length;
      localObject1 = null;
      if (i >= j) {
        break;
      }
      if (TextUtils.equals(paramString, DexReleasor.sExtraDexes[i]))
      {
        localObject1 = DexReleasor.sExtraJarDexes[i];
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(DexReleasor.sExtraDexes[i]);
        ((StringBuilder)localObject3).append(".MD5");
        localObject3 = ((StringBuilder)localObject3).toString();
        break label183;
      }
      i += 1;
    }
    Object localObject3 = null;
    label183:
    String str = getCurProcessName(paramContext);
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    paramString = localDexReleasor.releaseDex(str, paramString);
    if (isLibExtracted(paramContext, (String)localObject1, (String)localObject3))
    {
      if ((paramString != null) && (paramString.exists())) {
        paramString.delete();
      }
    }
    else
    {
      paramContext = new StringBuilder();
      paramContext.append((String)localObject2);
      paramContext.append((String)localObject1);
      paramContext = new File(paramContext.toString());
      if (paramContext.exists()) {
        paramContext.delete();
      }
      bool1 = bool2;
      if (paramString == null) {
        break label312;
      }
      bool1 = bool2;
      if (!paramString.exists()) {
        break label312;
      }
      paramString.renameTo(paramContext);
    }
    boolean bool1 = true;
    label312:
    return bool1;
  }
  
  public static File releaseFromApk(String paramString1, String paramString2, String paramString3)
  {
    FileOutputStream localFileOutputStream = null;
    if (paramString1 == null) {
      return null;
    }
    Object localObject1 = paramString3;
    if (!paramString3.endsWith(File.separator))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString3);
      ((StringBuilder)localObject1).append(File.separator);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    new File((String)localObject1).mkdirs();
    paramString3 = new StringBuilder();
    paramString3.append("lib/");
    paramString3.append(getPlatformString());
    paramString3.append("/");
    paramString3 = paramString3.toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("lib/");
    ((StringBuilder)localObject2).append(getPlatformString());
    ((StringBuilder)localObject2).append("/");
    ((StringBuilder)localObject2).append(paramString2);
    paramString2 = ((StringBuilder)localObject2).toString();
    try
    {
      paramString1 = new MyZipFile(new File(paramString1), paramString2);
    }
    catch (IOException paramString1)
    {
      QLog.e("SoLoadCore", 1, "releaseFromApk failed", paramString1);
      paramString1 = null;
    }
    if (paramString1 == null) {
      return null;
    }
    localObject2 = paramString1.getDesEntry();
    paramString2 = localFileOutputStream;
    if (localObject2 != null)
    {
      paramString2 = localFileOutputStream;
      if (((MyZipEntry)localObject2).getName().contains(paramString3))
      {
        paramString2 = localFileOutputStream;
        if (((MyZipEntry)localObject2).getName().endsWith(".so"))
        {
          paramString3 = ((MyZipEntry)localObject2).getName();
          int i = paramString3.lastIndexOf('/');
          paramString2 = paramString3;
          if (i != -1) {
            paramString2 = paramString3.substring(i + 1);
          }
          paramString3 = new StringBuilder();
          paramString3.append((String)localObject1);
          paramString3.append(paramString2);
          paramString3 = new File(paramString3.toString());
          if (paramString3.exists()) {
            paramString3.delete();
          }
          localObject1 = new byte[4096];
          try
          {
            paramString1 = paramString1.getInputStream((MyZipEntry)localObject2);
            localFileOutputStream = new FileOutputStream(paramString3);
            for (;;)
            {
              i = paramString1.read((byte[])localObject1);
              paramString2 = paramString3;
              if (i <= 0) {
                break;
              }
              localFileOutputStream.write((byte[])localObject1, 0, i);
            }
            return paramString2;
          }
          catch (IOException paramString1)
          {
            QLog.e("SoLoadCore", 1, "releaseFromApk failed", paramString1);
            paramString2 = paramString3;
          }
        }
      }
    }
  }
  
  public static String releaseSo(Context paramContext, String paramString)
  {
    String str1 = getLibActualName(paramString);
    initAssestCrcConfigs(paramContext);
    paramString = assestCrcConfigs;
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      paramString = assestCrcConfigs;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(getDefaultPlatformString());
      ((StringBuilder)localObject1).append("/");
      ((StringBuilder)localObject1).append(str1);
      paramString = (Long)paramString.get(((StringBuilder)localObject1).toString());
      if (paramString != null)
      {
        l = paramString.longValue();
        break label93;
      }
    }
    long l = -1L;
    label93:
    paramString = new StringBuilder();
    paramString.append(paramContext.getFilesDir());
    paramString.append("/soconfigs");
    paramString = paramString.toString();
    new File(paramString).mkdirs();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("/");
    ((StringBuilder)localObject1).append(str1);
    ((StringBuilder)localObject1).append(".cfg");
    File localFile = new File(((StringBuilder)localObject1).toString());
    boolean bool = localFile.exists();
    Object localObject2 = null;
    if ((bool) && (localFile.isFile()))
    {
      paramString = readConfig(localFile);
      if (paramString != null)
      {
        localObject1 = new File(paramString.mSopath);
        if ((paramString.mCrcvalue == l) && (((File)localObject1).exists())) {
          return ((File)localObject1).getAbsolutePath();
        }
      }
      localFile.delete();
    }
    paramString = new StringBuilder();
    paramString.append(getAppWorkPath(paramContext));
    paramString.append("/txlib/");
    String str2 = paramString.toString();
    paramString = new StringBuilder();
    paramString.append(getAppWorkPath(paramContext));
    paramString.append("/lib/");
    paramString = paramString.toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(str1);
    paramString = new File(((StringBuilder)localObject1).toString());
    if ((paramString.exists()) && (paramString.isFile()) && (getCRC32Value(paramString) == l))
    {
      paramContext = paramString.getAbsolutePath();
      writeConfig(new ConfigStruct(l, paramString.getAbsolutePath()), localFile);
      return paramContext;
    }
    paramString = getOsClassLoader();
    if (paramString.equals("equalAndAbove14"))
    {
      paramString = new StringBuilder();
      paramString.append("lib/");
      paramString.append(getPlatformString());
      paramString.append("/");
      paramString.append(str1);
      paramString = paramString.toString();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str2);
      ((StringBuilder)localObject1).append(str1);
      paramString = getSoOrDexByBaseDexClassLoader(paramContext, paramString, ((StringBuilder)localObject1).toString());
    }
    else if (paramString.equals("below14"))
    {
      paramString = getSoOrDexByPathClassLoader(paramContext, str1, str2);
    }
    else
    {
      paramString = null;
    }
    localObject1 = paramString;
    if (paramString == null) {
      localObject1 = releaseFromApk(getApkPath(paramContext), str1, str2);
    }
    paramContext = localObject2;
    if (localObject1 != null)
    {
      paramContext = localObject2;
      if (((File)localObject1).exists())
      {
        paramContext = ((File)localObject1).getAbsolutePath();
        writeConfig(new ConfigStruct(l, ((File)localObject1).getAbsolutePath()), localFile);
      }
    }
    return paramContext;
  }
  
  public static File releaseSoAnyway(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject1;
    if (hasBaseDexClassloader())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("lib/");
      ((StringBuilder)localObject1).append(getPlatformString());
      ((StringBuilder)localObject1).append("/");
      ((StringBuilder)localObject1).append(paramString1);
      localObject2 = ((StringBuilder)localObject1).toString();
      localObject1 = paramString2;
      if (!paramString2.endsWith(File.separator))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString2);
        ((StringBuilder)localObject1).append(File.separator);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      paramString2 = new StringBuilder();
      paramString2.append((String)localObject1);
      paramString2.append(paramString1);
      paramString2 = getSoOrDexByBaseDexClassLoader(paramContext, (String)localObject2, paramString2.toString());
    }
    else
    {
      localObject2 = getSoOrDexByPathClassLoader(paramContext, paramString1, paramString2);
      localObject1 = paramString2;
      paramString2 = (String)localObject2;
    }
    Object localObject2 = paramString2;
    if (paramString2 == null) {
      localObject2 = releaseFromApk(getApkPath(paramContext), paramString1, (String)localObject1);
    }
    return localObject2;
  }
  
  private static void reportThrowable(Throwable paramThrowable, String paramString)
  {
    SoLoadReport localSoLoadReport = SoLoadUtilNew.sReport;
    if (localSoLoadReport != null) {
      localSoLoadReport.reportThrowable(paramThrowable, paramString);
    }
  }
  
  public static void setIsCpu64Bit(boolean paramBoolean)
  {
    IS_CPU_64_BIT = paramBoolean;
  }
  
  /* Error */
  private static boolean writeConfig(ConfigStruct paramConfigStruct, File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 222	java/io/File:exists	()Z
    //   4: ifeq +8 -> 12
    //   7: aload_1
    //   8: invokevirtual 434	java/io/File:delete	()Z
    //   11: pop
    //   12: aload_1
    //   13: invokevirtual 446	java/io/File:createNewFile	()Z
    //   16: pop
    //   17: new 707	java/io/BufferedWriter
    //   20: dup
    //   21: new 709	java/io/OutputStreamWriter
    //   24: dup
    //   25: new 105	java/io/FileOutputStream
    //   28: dup
    //   29: aload_1
    //   30: invokespecial 108	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   33: invokespecial 710	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   36: invokespecial 713	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   39: astore_1
    //   40: new 295	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 296	java/lang/StringBuilder:<init>	()V
    //   47: astore_2
    //   48: aload_2
    //   49: ldc_w 715
    //   52: invokevirtual 300	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload_2
    //   57: aload_0
    //   58: getfield 426	com/tencent/commonsdk/soload/ConfigStruct:mCrcvalue	J
    //   61: invokevirtual 718	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload_1
    //   66: aload_2
    //   67: invokevirtual 308	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokevirtual 720	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   73: aload_1
    //   74: invokevirtual 723	java/io/BufferedWriter:newLine	()V
    //   77: new 295	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 296	java/lang/StringBuilder:<init>	()V
    //   84: astore_2
    //   85: aload_2
    //   86: ldc_w 725
    //   89: invokevirtual 300	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload_2
    //   94: aload_0
    //   95: getfield 429	com/tencent/commonsdk/soload/ConfigStruct:mSopath	Ljava/lang/String;
    //   98: invokevirtual 300	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload_1
    //   103: aload_2
    //   104: invokevirtual 308	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokevirtual 720	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   110: aload_1
    //   111: invokevirtual 726	java/io/BufferedWriter:close	()V
    //   114: iconst_1
    //   115: ireturn
    //   116: astore_0
    //   117: aload_0
    //   118: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   121: iconst_1
    //   122: ireturn
    //   123: astore_0
    //   124: goto +9 -> 133
    //   127: goto +26 -> 153
    //   130: astore_0
    //   131: aconst_null
    //   132: astore_1
    //   133: aload_1
    //   134: ifnull +15 -> 149
    //   137: aload_1
    //   138: invokevirtual 726	java/io/BufferedWriter:close	()V
    //   141: goto +8 -> 149
    //   144: astore_1
    //   145: aload_1
    //   146: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   149: aload_0
    //   150: athrow
    //   151: aconst_null
    //   152: astore_1
    //   153: aload_1
    //   154: ifnull +15 -> 169
    //   157: aload_1
    //   158: invokevirtual 726	java/io/BufferedWriter:close	()V
    //   161: goto +8 -> 169
    //   164: astore_0
    //   165: aload_0
    //   166: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   169: iconst_0
    //   170: ireturn
    //   171: astore_0
    //   172: goto -21 -> 151
    //   175: astore_0
    //   176: goto -49 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	paramConfigStruct	ConfigStruct
    //   0	179	1	paramFile	File
    //   47	57	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   110	114	116	java/io/IOException
    //   40	110	123	finally
    //   0	12	130	finally
    //   12	40	130	finally
    //   137	141	144	java/io/IOException
    //   157	161	164	java/io/IOException
    //   0	12	171	java/lang/Exception
    //   12	40	171	java/lang/Exception
    //   40	110	175	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.commonsdk.soload.SoLoadCore
 * JD-Core Version:    0.7.0.1
 */