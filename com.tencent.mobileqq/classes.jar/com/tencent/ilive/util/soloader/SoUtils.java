package com.tencent.ilive.util.soloader;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.lang.reflect.Method;

public class SoUtils
{
  private static final String CPU_ARCHITECTURE_KEY_64 = "ro.product.cpu.abilist64";
  private static final int EI_CLASS = 4;
  private static final int ELFCLASS32 = 1;
  private static final int ELFCLASS64 = 2;
  private static final String PROC_CPU_INFO_PATH = "/proc/cpuinfo";
  private static final String SYSTEM_LIB_C_PATH = "/system/lib/libc.so";
  private static final String SYSTEM_LIB_C_PATH_64 = "/system/lib64/libc.so";
  
  /* Error */
  public static boolean copyAssetFile(AssetManager paramAssetManager, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +221 -> 222
    //   4: aload_1
    //   5: invokestatic 39	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifne +214 -> 222
    //   11: aload_2
    //   12: invokestatic 39	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifeq +5 -> 20
    //   18: iconst_0
    //   19: ireturn
    //   20: aconst_null
    //   21: astore 6
    //   23: aconst_null
    //   24: astore 5
    //   26: new 41	java/io/File
    //   29: dup
    //   30: aload_2
    //   31: invokespecial 44	java/io/File:<init>	(Ljava/lang/String;)V
    //   34: astore 4
    //   36: aload 4
    //   38: invokevirtual 48	java/io/File:delete	()Z
    //   41: pop
    //   42: aload 4
    //   44: invokevirtual 52	java/io/File:getParentFile	()Ljava/io/File;
    //   47: invokevirtual 55	java/io/File:mkdirs	()Z
    //   50: pop
    //   51: new 57	java/io/BufferedInputStream
    //   54: dup
    //   55: aload_0
    //   56: aload_1
    //   57: invokevirtual 63	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   60: invokespecial 66	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   63: astore 4
    //   65: new 68	java/io/FileOutputStream
    //   68: dup
    //   69: aload_2
    //   70: invokespecial 69	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   73: astore_2
    //   74: sipush 1024
    //   77: newarray byte
    //   79: astore_0
    //   80: aload 4
    //   82: aload_0
    //   83: invokevirtual 73	java/io/BufferedInputStream:read	([B)I
    //   86: istore_3
    //   87: iload_3
    //   88: iconst_m1
    //   89: if_icmpeq +13 -> 102
    //   92: aload_2
    //   93: aload_0
    //   94: iconst_0
    //   95: iload_3
    //   96: invokevirtual 77	java/io/FileOutputStream:write	([BII)V
    //   99: goto -19 -> 80
    //   102: aload_2
    //   103: invokevirtual 80	java/io/FileOutputStream:flush	()V
    //   106: aload_2
    //   107: invokevirtual 83	java/io/FileOutputStream:close	()V
    //   110: aload 4
    //   112: invokevirtual 84	java/io/BufferedInputStream:close	()V
    //   115: aload 4
    //   117: invokevirtual 84	java/io/BufferedInputStream:close	()V
    //   120: aload_2
    //   121: invokevirtual 83	java/io/FileOutputStream:close	()V
    //   124: iconst_1
    //   125: ireturn
    //   126: astore_0
    //   127: aload_0
    //   128: invokevirtual 87	java/lang/Exception:printStackTrace	()V
    //   131: iconst_1
    //   132: ireturn
    //   133: astore_0
    //   134: goto +10 -> 144
    //   137: astore_1
    //   138: goto +18 -> 156
    //   141: astore_0
    //   142: aconst_null
    //   143: astore_2
    //   144: aload 4
    //   146: astore_1
    //   147: aload_0
    //   148: astore 4
    //   150: goto +53 -> 203
    //   153: astore_1
    //   154: aconst_null
    //   155: astore_2
    //   156: aload 4
    //   158: astore_0
    //   159: goto +19 -> 178
    //   162: astore 4
    //   164: aconst_null
    //   165: astore_2
    //   166: aload 6
    //   168: astore_1
    //   169: goto +34 -> 203
    //   172: astore_1
    //   173: aconst_null
    //   174: astore_2
    //   175: aload 5
    //   177: astore_0
    //   178: aload_1
    //   179: invokevirtual 87	java/lang/Exception:printStackTrace	()V
    //   182: aload_0
    //   183: invokevirtual 84	java/io/BufferedInputStream:close	()V
    //   186: aload_2
    //   187: invokevirtual 83	java/io/FileOutputStream:close	()V
    //   190: iconst_0
    //   191: ireturn
    //   192: astore_0
    //   193: aload_0
    //   194: invokevirtual 87	java/lang/Exception:printStackTrace	()V
    //   197: iconst_0
    //   198: ireturn
    //   199: astore 4
    //   201: aload_0
    //   202: astore_1
    //   203: aload_1
    //   204: invokevirtual 84	java/io/BufferedInputStream:close	()V
    //   207: aload_2
    //   208: invokevirtual 83	java/io/FileOutputStream:close	()V
    //   211: goto +8 -> 219
    //   214: astore_0
    //   215: aload_0
    //   216: invokevirtual 87	java/lang/Exception:printStackTrace	()V
    //   219: aload 4
    //   221: athrow
    //   222: iconst_0
    //   223: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	paramAssetManager	AssetManager
    //   0	224	1	paramString1	String
    //   0	224	2	paramString2	String
    //   86	10	3	i	int
    //   34	123	4	localObject1	Object
    //   162	1	4	localObject2	Object
    //   199	21	4	localObject3	Object
    //   24	152	5	localObject4	Object
    //   21	146	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   115	124	126	java/lang/Exception
    //   74	80	133	finally
    //   80	87	133	finally
    //   92	99	133	finally
    //   102	115	133	finally
    //   74	80	137	java/lang/Exception
    //   80	87	137	java/lang/Exception
    //   92	99	137	java/lang/Exception
    //   102	115	137	java/lang/Exception
    //   65	74	141	finally
    //   65	74	153	java/lang/Exception
    //   26	65	162	finally
    //   26	65	172	java/lang/Exception
    //   182	190	192	java/lang/Exception
    //   178	182	199	finally
    //   203	211	214	java/lang/Exception
  }
  
  public static boolean copyAssetsDirectory(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      AssetManager localAssetManager = paramContext.getAssets();
      String[] arrayOfString = paramContext.getAssets().list(paramString1);
      if (isExist(paramString2)) {
        deleteFile(paramString2);
      } else {
        new File(paramString2).mkdirs();
      }
      int j = arrayOfString.length;
      int i = 0;
      boolean bool1 = true;
      while (i < j)
      {
        String str = arrayOfString[i];
        boolean bool2 = str.contains(".");
        Object localObject;
        StringBuilder localStringBuilder;
        if (bool2)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString1);
          ((StringBuilder)localObject).append("/");
          ((StringBuilder)localObject).append(str);
          localObject = ((StringBuilder)localObject).toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString2);
          localStringBuilder.append("/");
          localStringBuilder.append(str);
          bool2 = copyAssetFile(localAssetManager, (String)localObject, localStringBuilder.toString());
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString1);
          ((StringBuilder)localObject).append("/");
          ((StringBuilder)localObject).append(str);
          localObject = ((StringBuilder)localObject).toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString2);
          localStringBuilder.append("/");
          localStringBuilder.append(str);
          bool2 = copyAssetsDirectory(paramContext, (String)localObject, localStringBuilder.toString());
        }
        bool1 &= bool2;
        i += 1;
      }
      return bool1;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean deleteFile(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      paramString = new File(paramString);
      if ((paramString.exists()) && (paramString.isDirectory()))
      {
        File[] arrayOfFile = paramString.listFiles();
        if ((arrayOfFile != null) && (arrayOfFile.length > 0))
        {
          int i = 0;
          while (i < arrayOfFile.length)
          {
            deleteFile(arrayOfFile[i].getAbsolutePath());
            i += 1;
          }
        }
      }
      paramString.delete();
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static String getCpuArchType()
  {
    try
    {
      Object localObject1 = Class.forName("android.os.SystemProperties");
      localObject1 = (String)((Class)localObject1).getDeclaredMethod("get", new Class[] { String.class }).invoke(localObject1, new Object[] { "ro.product.cpu.abi" });
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject2 = "";
    }
    Object localObject3 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject3 = Build.CPU_ABI;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("arch ");
    ((StringBuilder)localObject2).append((String)localObject3);
    Log.d("dq getCpuArchType", ((StringBuilder)localObject2).toString());
    return localObject3;
  }
  
  public static String getSoSourcePath()
  {
    Object localObject2 = getCpuArchType();
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = ((String)localObject2).toLowerCase();
    }
    localObject2 = Environment.getExternalStorageDirectory().getAbsolutePath();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append("/libs/");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("/");
    localObject1 = localStringBuilder.toString();
    localObject2 = new File((String)localObject1);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("soFrom=");
    ((StringBuilder)localObject2).append((String)localObject1);
    Log.d("dq", ((StringBuilder)localObject2).toString());
    return localObject1;
  }
  
  private static String getSystemProperty(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = Class.forName("android.os.SystemProperties");
      localObject = (String)((Class)localObject).getMethod("get", new Class[] { String.class, String.class }).invoke(localObject, new Object[] { paramString1, "" });
      paramString2 = (String)localObject;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("key = ");
      localStringBuilder2.append(paramString1);
      localStringBuilder2.append(", error = ");
      localStringBuilder2.append(localException.getMessage());
      Log.d("dq getSystemProperty", localStringBuilder2.toString());
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(paramString1);
    localStringBuilder1.append(" = ");
    localStringBuilder1.append(paramString2);
    Log.d("dq getSystemProperty", localStringBuilder1.toString());
    return paramString2;
  }
  
  private static boolean is64bitCPU()
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool2 = false;
    Object localObject;
    if (i >= 21)
    {
      localObject = Build.SUPPORTED_ABIS;
      if (localObject.length > 0) {
        localObject = localObject[0];
      } else {
        localObject = null;
      }
    }
    else
    {
      localObject = Build.CPU_ABI;
    }
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((String)localObject).contains("arm64")) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static boolean isART64(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getClassLoader();
      paramContext = ClassLoader.class.getDeclaredMethod("findLibrary", new Class[] { String.class }).invoke(paramContext, new Object[] { "art" });
      if (paramContext != null)
      {
        boolean bool = ((String)paramContext).contains("lib64");
        return bool;
      }
      return false;
    }
    catch (Exception paramContext)
    {
      label53:
      break label53;
    }
    return is64bitCPU();
  }
  
  /* Error */
  private static boolean isCPUInfo64()
  {
    // Byte code:
    //   0: new 41	java/io/File
    //   3: dup
    //   4: ldc 18
    //   6: invokespecial 44	java/io/File:<init>	(Ljava/lang/String;)V
    //   9: astore_1
    //   10: aload_1
    //   11: invokevirtual 133	java/io/File:exists	()Z
    //   14: ifeq +203 -> 217
    //   17: aconst_null
    //   18: astore_3
    //   19: new 249	java/io/FileInputStream
    //   22: dup
    //   23: aload_1
    //   24: invokespecial 252	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   27: astore_2
    //   28: new 254	java/io/BufferedReader
    //   31: dup
    //   32: new 256	java/io/InputStreamReader
    //   35: dup
    //   36: aload_2
    //   37: invokespecial 257	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   40: sipush 512
    //   43: invokespecial 260	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   46: astore_1
    //   47: aload_1
    //   48: invokevirtual 263	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   51: astore_3
    //   52: aload_3
    //   53: ifnull +53 -> 106
    //   56: aload_3
    //   57: invokevirtual 267	java/lang/String:length	()I
    //   60: ifle +46 -> 106
    //   63: aload_3
    //   64: getstatic 273	java/util/Locale:US	Ljava/util/Locale;
    //   67: invokevirtual 276	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   70: ldc_w 278
    //   73: invokevirtual 113	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   76: istore_0
    //   77: iload_0
    //   78: ifeq +28 -> 106
    //   81: aload_1
    //   82: invokevirtual 279	java/io/BufferedReader:close	()V
    //   85: goto +8 -> 93
    //   88: astore_1
    //   89: aload_1
    //   90: invokevirtual 87	java/lang/Exception:printStackTrace	()V
    //   93: aload_2
    //   94: invokevirtual 282	java/io/InputStream:close	()V
    //   97: iconst_1
    //   98: ireturn
    //   99: astore_1
    //   100: aload_1
    //   101: invokevirtual 87	java/lang/Exception:printStackTrace	()V
    //   104: iconst_1
    //   105: ireturn
    //   106: aload_1
    //   107: invokevirtual 279	java/io/BufferedReader:close	()V
    //   110: goto +8 -> 118
    //   113: astore_1
    //   114: aload_1
    //   115: invokevirtual 87	java/lang/Exception:printStackTrace	()V
    //   118: aload_2
    //   119: invokevirtual 282	java/io/InputStream:close	()V
    //   122: goto +95 -> 217
    //   125: astore 4
    //   127: aload_1
    //   128: astore_3
    //   129: aload 4
    //   131: astore_1
    //   132: goto +15 -> 147
    //   135: astore_1
    //   136: goto +11 -> 147
    //   139: aconst_null
    //   140: astore_1
    //   141: goto +44 -> 185
    //   144: astore_1
    //   145: aconst_null
    //   146: astore_2
    //   147: aload_3
    //   148: ifnull +15 -> 163
    //   151: aload_3
    //   152: invokevirtual 279	java/io/BufferedReader:close	()V
    //   155: goto +8 -> 163
    //   158: astore_3
    //   159: aload_3
    //   160: invokevirtual 87	java/lang/Exception:printStackTrace	()V
    //   163: aload_2
    //   164: ifnull +15 -> 179
    //   167: aload_2
    //   168: invokevirtual 282	java/io/InputStream:close	()V
    //   171: goto +8 -> 179
    //   174: astore_2
    //   175: aload_2
    //   176: invokevirtual 87	java/lang/Exception:printStackTrace	()V
    //   179: aload_1
    //   180: athrow
    //   181: aconst_null
    //   182: astore_1
    //   183: aload_1
    //   184: astore_2
    //   185: aload_1
    //   186: ifnull +15 -> 201
    //   189: aload_1
    //   190: invokevirtual 279	java/io/BufferedReader:close	()V
    //   193: goto +8 -> 201
    //   196: astore_1
    //   197: aload_1
    //   198: invokevirtual 87	java/lang/Exception:printStackTrace	()V
    //   201: aload_2
    //   202: ifnull +15 -> 217
    //   205: aload_2
    //   206: invokevirtual 282	java/io/InputStream:close	()V
    //   209: goto +8 -> 217
    //   212: astore_1
    //   213: aload_1
    //   214: invokevirtual 87	java/lang/Exception:printStackTrace	()V
    //   217: iconst_0
    //   218: ireturn
    //   219: astore_1
    //   220: goto -39 -> 181
    //   223: astore_1
    //   224: goto -85 -> 139
    //   227: astore_3
    //   228: goto -43 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   76	2	0	bool	boolean
    //   9	73	1	localObject1	Object
    //   88	2	1	localException1	Exception
    //   99	8	1	localException2	Exception
    //   113	15	1	localException3	Exception
    //   131	1	1	localObject2	Object
    //   135	1	1	localObject3	Object
    //   140	1	1	localObject4	Object
    //   144	36	1	localObject5	Object
    //   182	8	1	localObject6	Object
    //   196	2	1	localException4	Exception
    //   212	2	1	localException5	Exception
    //   219	1	1	localThrowable1	java.lang.Throwable
    //   223	1	1	localThrowable2	java.lang.Throwable
    //   27	141	2	localFileInputStream	java.io.FileInputStream
    //   174	2	2	localException6	Exception
    //   184	22	2	localObject7	Object
    //   18	134	3	localObject8	Object
    //   158	2	3	localException7	Exception
    //   227	1	3	localThrowable3	java.lang.Throwable
    //   125	5	4	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   81	85	88	java/lang/Exception
    //   93	97	99	java/lang/Exception
    //   106	110	113	java/lang/Exception
    //   47	52	125	finally
    //   56	77	125	finally
    //   28	47	135	finally
    //   19	28	144	finally
    //   151	155	158	java/lang/Exception
    //   167	171	174	java/lang/Exception
    //   189	193	196	java/lang/Exception
    //   118	122	212	java/lang/Exception
    //   205	209	212	java/lang/Exception
    //   19	28	219	java/lang/Throwable
    //   28	47	223	java/lang/Throwable
    //   47	52	227	java/lang/Throwable
    //   56	77	227	java/lang/Throwable
  }
  
  public static boolean isExist(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      boolean bool = new File(paramString).exists();
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  private static boolean isLibc64()
  {
    Object localObject = new File("/system/lib/libc.so");
    if (((File)localObject).exists())
    {
      localObject = readELFHeadrIndentArray((File)localObject);
      if ((localObject != null) && (localObject[4] == 2))
      {
        Log.d("dq isLibc64()", "/system/lib/libc.so is 64bit");
        return true;
      }
    }
    localObject = new File("/system/lib64/libc.so");
    if (((File)localObject).exists())
    {
      localObject = readELFHeadrIndentArray((File)localObject);
      if ((localObject != null) && (localObject[4] == 2))
      {
        Log.d("dq isLibc64()", "/system/lib64/libc.so is 64bit");
        return true;
      }
    }
    return false;
  }
  
  public static boolean isX86Phone()
  {
    String str = getCpuArchType();
    return (!TextUtils.isEmpty(str)) && ("x86".equals(str.toLowerCase()));
  }
  
  /* Error */
  private static byte[] readELFHeadrIndentArray(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +159 -> 160
    //   4: aload_0
    //   5: invokevirtual 133	java/io/File:exists	()Z
    //   8: ifeq +152 -> 160
    //   11: new 249	java/io/FileInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 252	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   19: astore_2
    //   20: aload_2
    //   21: astore_0
    //   22: bipush 16
    //   24: newarray byte
    //   26: astore_3
    //   27: aload_2
    //   28: astore_0
    //   29: aload_2
    //   30: aload_3
    //   31: iconst_0
    //   32: bipush 16
    //   34: invokevirtual 303	java/io/FileInputStream:read	([BII)I
    //   37: istore_1
    //   38: iload_1
    //   39: bipush 16
    //   41: if_icmpne +16 -> 57
    //   44: aload_2
    //   45: invokevirtual 304	java/io/FileInputStream:close	()V
    //   48: aload_3
    //   49: areturn
    //   50: astore_0
    //   51: aload_0
    //   52: invokevirtual 87	java/lang/Exception:printStackTrace	()V
    //   55: aload_3
    //   56: areturn
    //   57: aload_2
    //   58: invokevirtual 304	java/io/FileInputStream:close	()V
    //   61: aconst_null
    //   62: areturn
    //   63: astore_0
    //   64: aload_0
    //   65: invokevirtual 87	java/lang/Exception:printStackTrace	()V
    //   68: aconst_null
    //   69: areturn
    //   70: astore_3
    //   71: goto +12 -> 83
    //   74: astore_2
    //   75: aconst_null
    //   76: astore_0
    //   77: goto +65 -> 142
    //   80: astore_3
    //   81: aconst_null
    //   82: astore_2
    //   83: aload_2
    //   84: astore_0
    //   85: new 115	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   92: astore 4
    //   94: aload_2
    //   95: astore_0
    //   96: aload 4
    //   98: ldc_w 306
    //   101: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload_2
    //   106: astore_0
    //   107: aload 4
    //   109: aload_3
    //   110: invokevirtual 307	java/lang/Throwable:toString	()Ljava/lang/String;
    //   113: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload_2
    //   118: astore_0
    //   119: ldc_w 308
    //   122: aload 4
    //   124: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 311	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   130: pop
    //   131: aload_2
    //   132: ifnull +28 -> 160
    //   135: aload_2
    //   136: invokevirtual 304	java/io/FileInputStream:close	()V
    //   139: aconst_null
    //   140: areturn
    //   141: astore_2
    //   142: aload_0
    //   143: ifnull +15 -> 158
    //   146: aload_0
    //   147: invokevirtual 304	java/io/FileInputStream:close	()V
    //   150: goto +8 -> 158
    //   153: astore_0
    //   154: aload_0
    //   155: invokevirtual 87	java/lang/Exception:printStackTrace	()V
    //   158: aload_2
    //   159: athrow
    //   160: aconst_null
    //   161: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramFile	File
    //   37	5	1	i	int
    //   19	39	2	localFileInputStream	java.io.FileInputStream
    //   74	1	2	localObject1	Object
    //   82	54	2	localObject2	Object
    //   141	18	2	localObject3	Object
    //   26	30	3	arrayOfByte	byte[]
    //   70	1	3	localThrowable1	java.lang.Throwable
    //   80	30	3	localThrowable2	java.lang.Throwable
    //   92	31	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   44	48	50	java/lang/Exception
    //   57	61	63	java/lang/Exception
    //   135	139	63	java/lang/Exception
    //   22	27	70	java/lang/Throwable
    //   29	38	70	java/lang/Throwable
    //   11	20	74	finally
    //   11	20	80	java/lang/Throwable
    //   22	27	141	finally
    //   29	38	141	finally
    //   85	94	141	finally
    //   96	105	141	finally
    //   107	117	141	finally
    //   119	131	141	finally
    //   146	150	153	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.util.soloader.SoUtils
 * JD-Core Version:    0.7.0.1
 */