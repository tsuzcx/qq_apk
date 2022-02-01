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
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: ifnull +17 -> 24
    //   10: aload_1
    //   11: invokestatic 39	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifne +10 -> 24
    //   17: aload_2
    //   18: invokestatic 39	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifeq +5 -> 26
    //   24: iconst_0
    //   25: ireturn
    //   26: new 41	java/io/File
    //   29: dup
    //   30: aload_2
    //   31: invokespecial 44	java/io/File:<init>	(Ljava/lang/String;)V
    //   34: astore 6
    //   36: aload 6
    //   38: invokevirtual 48	java/io/File:delete	()Z
    //   41: pop
    //   42: aload 6
    //   44: invokevirtual 52	java/io/File:getParentFile	()Ljava/io/File;
    //   47: invokevirtual 55	java/io/File:mkdirs	()Z
    //   50: pop
    //   51: new 57	java/io/BufferedInputStream
    //   54: dup
    //   55: aload_0
    //   56: aload_1
    //   57: invokevirtual 63	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   60: invokespecial 66	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   63: astore_1
    //   64: new 68	java/io/FileOutputStream
    //   67: dup
    //   68: aload_2
    //   69: invokespecial 69	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   72: astore_0
    //   73: sipush 1024
    //   76: newarray byte
    //   78: astore_2
    //   79: aload_1
    //   80: aload_2
    //   81: invokevirtual 73	java/io/BufferedInputStream:read	([B)I
    //   84: istore_3
    //   85: iload_3
    //   86: iconst_m1
    //   87: if_icmpeq +35 -> 122
    //   90: aload_0
    //   91: aload_2
    //   92: iconst_0
    //   93: iload_3
    //   94: invokevirtual 77	java/io/FileOutputStream:write	([BII)V
    //   97: goto -18 -> 79
    //   100: astore_2
    //   101: aload_2
    //   102: invokevirtual 80	java/lang/Exception:printStackTrace	()V
    //   105: aload_1
    //   106: invokevirtual 83	java/io/BufferedInputStream:close	()V
    //   109: aload_0
    //   110: invokevirtual 84	java/io/FileOutputStream:close	()V
    //   113: iconst_0
    //   114: ireturn
    //   115: astore_0
    //   116: aload_0
    //   117: invokevirtual 80	java/lang/Exception:printStackTrace	()V
    //   120: iconst_0
    //   121: ireturn
    //   122: aload_0
    //   123: invokevirtual 87	java/io/FileOutputStream:flush	()V
    //   126: aload_0
    //   127: invokevirtual 84	java/io/FileOutputStream:close	()V
    //   130: aload_1
    //   131: invokevirtual 83	java/io/BufferedInputStream:close	()V
    //   134: aload_1
    //   135: invokevirtual 83	java/io/BufferedInputStream:close	()V
    //   138: aload_0
    //   139: invokevirtual 84	java/io/FileOutputStream:close	()V
    //   142: iconst_1
    //   143: ireturn
    //   144: astore_0
    //   145: aload_0
    //   146: invokevirtual 80	java/lang/Exception:printStackTrace	()V
    //   149: iconst_1
    //   150: ireturn
    //   151: astore_0
    //   152: aconst_null
    //   153: astore_1
    //   154: aload 4
    //   156: astore_2
    //   157: aload_1
    //   158: invokevirtual 83	java/io/BufferedInputStream:close	()V
    //   161: aload_2
    //   162: invokevirtual 84	java/io/FileOutputStream:close	()V
    //   165: aload_0
    //   166: athrow
    //   167: astore_1
    //   168: aload_1
    //   169: invokevirtual 80	java/lang/Exception:printStackTrace	()V
    //   172: goto -7 -> 165
    //   175: astore_0
    //   176: aload 4
    //   178: astore_2
    //   179: goto -22 -> 157
    //   182: astore 4
    //   184: aload_0
    //   185: astore_2
    //   186: aload 4
    //   188: astore_0
    //   189: goto -32 -> 157
    //   192: astore 4
    //   194: aload_0
    //   195: astore_2
    //   196: aload 4
    //   198: astore_0
    //   199: goto -42 -> 157
    //   202: astore_2
    //   203: aconst_null
    //   204: astore_0
    //   205: aload 5
    //   207: astore_1
    //   208: goto -107 -> 101
    //   211: astore_2
    //   212: aconst_null
    //   213: astore_0
    //   214: goto -113 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	paramAssetManager	AssetManager
    //   0	217	1	paramString1	String
    //   0	217	2	paramString2	String
    //   84	10	3	i	int
    //   1	176	4	localObject1	Object
    //   182	5	4	localObject2	Object
    //   192	5	4	localObject3	Object
    //   4	202	5	localObject4	Object
    //   34	9	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   73	79	100	java/lang/Exception
    //   79	85	100	java/lang/Exception
    //   90	97	100	java/lang/Exception
    //   122	134	100	java/lang/Exception
    //   105	113	115	java/lang/Exception
    //   134	142	144	java/lang/Exception
    //   26	64	151	finally
    //   157	165	167	java/lang/Exception
    //   64	73	175	finally
    //   73	79	182	finally
    //   79	85	182	finally
    //   90	97	182	finally
    //   122	134	182	finally
    //   101	105	192	finally
    //   26	64	202	java/lang/Exception
    //   64	73	211	java/lang/Exception
  }
  
  public static boolean copyAssetsDirectory(Context paramContext, String paramString1, String paramString2)
  {
    for (;;)
    {
      boolean bool1;
      int i;
      String str;
      try
      {
        AssetManager localAssetManager = paramContext.getAssets();
        String[] arrayOfString = paramContext.getAssets().list(paramString1);
        if (isExist(paramString2))
        {
          deleteFile(paramString2);
          bool1 = true;
          int j = arrayOfString.length;
          i = 0;
          bool2 = bool1;
          if (i < j)
          {
            str = arrayOfString[i];
            if (!str.contains(".")) {
              break label151;
            }
            bool1 &= copyAssetFile(localAssetManager, paramString1 + "/" + str, paramString2 + "/" + str);
            break label212;
          }
        }
        else
        {
          new File(paramString2).mkdirs();
          continue;
        }
        return bool2;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        bool2 = false;
      }
      label151:
      boolean bool2 = copyAssetsDirectory(paramContext, paramString1 + "/" + str, paramString2 + "/" + str);
      bool1 &= bool2;
      label212:
      i += 1;
    }
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
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = Build.CPU_ABI;
      }
      Log.d("dq getCpuArchType", "arch " + (String)localObject2);
      return localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        String str = "";
      }
    }
  }
  
  public static String getSoSourcePath()
  {
    Object localObject2 = getCpuArchType();
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = ((String)localObject2).toLowerCase();
    }
    localObject2 = Environment.getExternalStorageDirectory().getAbsolutePath();
    localObject1 = (String)localObject2 + "/libs/" + (String)localObject1 + "/";
    localObject2 = new File((String)localObject1);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    Log.d("dq", "soFrom=" + (String)localObject1);
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
      for (;;)
      {
        Log.d("dq getSystemProperty", "key = " + paramString1 + ", error = " + localException.getMessage());
      }
    }
    Log.d("dq getSystemProperty", paramString1 + " = " + paramString2);
    return paramString2;
  }
  
  private static boolean is64bitCPU()
  {
    String str = null;
    String[] arrayOfString;
    if (Build.VERSION.SDK_INT >= 21)
    {
      arrayOfString = Build.SUPPORTED_ABIS;
      if (arrayOfString.length <= 0) {}
    }
    for (str = arrayOfString[0]; (str != null) && (str.contains("arm64")); str = Build.CPU_ABI) {
      return true;
    }
    return false;
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
    }
    catch (Exception paramContext)
    {
      return is64bitCPU();
    }
    return false;
  }
  
  /* Error */
  private static boolean isCPUInfo64()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 41	java/io/File
    //   5: dup
    //   6: ldc 18
    //   8: invokespecial 44	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_1
    //   12: aload_1
    //   13: invokevirtual 133	java/io/File:exists	()Z
    //   16: ifeq +114 -> 130
    //   19: new 249	java/io/FileInputStream
    //   22: dup
    //   23: aload_1
    //   24: invokespecial 252	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   27: astore_1
    //   28: new 254	java/io/BufferedReader
    //   31: dup
    //   32: new 256	java/io/InputStreamReader
    //   35: dup
    //   36: aload_1
    //   37: invokespecial 257	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   40: sipush 512
    //   43: invokespecial 260	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   46: astore_3
    //   47: aload_3
    //   48: invokevirtual 263	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   51: astore_2
    //   52: aload_2
    //   53: ifnull +61 -> 114
    //   56: aload_2
    //   57: invokevirtual 267	java/lang/String:length	()I
    //   60: ifle +54 -> 114
    //   63: aload_2
    //   64: getstatic 273	java/util/Locale:US	Ljava/util/Locale;
    //   67: invokevirtual 276	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   70: ldc_w 278
    //   73: invokevirtual 113	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   76: istore_0
    //   77: iload_0
    //   78: ifeq +36 -> 114
    //   81: aload_3
    //   82: ifnull +7 -> 89
    //   85: aload_3
    //   86: invokevirtual 279	java/io/BufferedReader:close	()V
    //   89: aload_1
    //   90: ifnull +7 -> 97
    //   93: aload_1
    //   94: invokevirtual 282	java/io/InputStream:close	()V
    //   97: iconst_1
    //   98: ireturn
    //   99: astore_2
    //   100: aload_2
    //   101: invokevirtual 80	java/lang/Exception:printStackTrace	()V
    //   104: goto -15 -> 89
    //   107: astore_1
    //   108: aload_1
    //   109: invokevirtual 80	java/lang/Exception:printStackTrace	()V
    //   112: iconst_1
    //   113: ireturn
    //   114: aload_3
    //   115: ifnull +7 -> 122
    //   118: aload_3
    //   119: invokevirtual 279	java/io/BufferedReader:close	()V
    //   122: aload_1
    //   123: ifnull +7 -> 130
    //   126: aload_1
    //   127: invokevirtual 282	java/io/InputStream:close	()V
    //   130: iconst_0
    //   131: ireturn
    //   132: astore_2
    //   133: aload_2
    //   134: invokevirtual 80	java/lang/Exception:printStackTrace	()V
    //   137: goto -15 -> 122
    //   140: astore_1
    //   141: aload_1
    //   142: invokevirtual 80	java/lang/Exception:printStackTrace	()V
    //   145: goto -15 -> 130
    //   148: astore_1
    //   149: aconst_null
    //   150: astore_1
    //   151: aload_2
    //   152: ifnull +7 -> 159
    //   155: aload_2
    //   156: invokevirtual 279	java/io/BufferedReader:close	()V
    //   159: aload_1
    //   160: ifnull -30 -> 130
    //   163: aload_1
    //   164: invokevirtual 282	java/io/InputStream:close	()V
    //   167: goto -37 -> 130
    //   170: astore_1
    //   171: aload_1
    //   172: invokevirtual 80	java/lang/Exception:printStackTrace	()V
    //   175: goto -45 -> 130
    //   178: astore_2
    //   179: aload_2
    //   180: invokevirtual 80	java/lang/Exception:printStackTrace	()V
    //   183: goto -24 -> 159
    //   186: astore_2
    //   187: aconst_null
    //   188: astore_1
    //   189: aconst_null
    //   190: astore_3
    //   191: aload_3
    //   192: ifnull +7 -> 199
    //   195: aload_3
    //   196: invokevirtual 279	java/io/BufferedReader:close	()V
    //   199: aload_1
    //   200: ifnull +7 -> 207
    //   203: aload_1
    //   204: invokevirtual 282	java/io/InputStream:close	()V
    //   207: aload_2
    //   208: athrow
    //   209: astore_3
    //   210: aload_3
    //   211: invokevirtual 80	java/lang/Exception:printStackTrace	()V
    //   214: goto -15 -> 199
    //   217: astore_1
    //   218: aload_1
    //   219: invokevirtual 80	java/lang/Exception:printStackTrace	()V
    //   222: goto -15 -> 207
    //   225: astore_2
    //   226: aconst_null
    //   227: astore_3
    //   228: goto -37 -> 191
    //   231: astore_2
    //   232: goto -41 -> 191
    //   235: astore_3
    //   236: goto -85 -> 151
    //   239: astore_2
    //   240: aload_3
    //   241: astore_2
    //   242: goto -91 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   76	2	0	bool	boolean
    //   11	83	1	localObject1	Object
    //   107	20	1	localException1	Exception
    //   140	2	1	localException2	Exception
    //   148	1	1	localThrowable1	java.lang.Throwable
    //   150	14	1	localObject2	Object
    //   170	2	1	localException3	Exception
    //   188	16	1	localObject3	Object
    //   217	2	1	localException4	Exception
    //   1	63	2	str	String
    //   99	2	2	localException5	Exception
    //   132	24	2	localException6	Exception
    //   178	2	2	localException7	Exception
    //   186	22	2	localObject4	Object
    //   225	1	2	localObject5	Object
    //   231	1	2	localObject6	Object
    //   239	1	2	localThrowable2	java.lang.Throwable
    //   241	1	2	localObject7	Object
    //   46	150	3	localBufferedReader	java.io.BufferedReader
    //   209	2	3	localException8	Exception
    //   227	1	3	localObject8	Object
    //   235	6	3	localThrowable3	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   85	89	99	java/lang/Exception
    //   93	97	107	java/lang/Exception
    //   118	122	132	java/lang/Exception
    //   126	130	140	java/lang/Exception
    //   19	28	148	java/lang/Throwable
    //   163	167	170	java/lang/Exception
    //   155	159	178	java/lang/Exception
    //   19	28	186	finally
    //   195	199	209	java/lang/Exception
    //   203	207	217	java/lang/Exception
    //   28	47	225	finally
    //   47	52	231	finally
    //   56	77	231	finally
    //   28	47	235	java/lang/Throwable
    //   47	52	239	java/lang/Throwable
    //   56	77	239	java/lang/Throwable
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
    //   1: ifnull +68 -> 69
    //   4: aload_0
    //   5: invokevirtual 133	java/io/File:exists	()Z
    //   8: ifeq +61 -> 69
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
    //   41: if_icmpne +20 -> 61
    //   44: aload_2
    //   45: ifnull +7 -> 52
    //   48: aload_2
    //   49: invokevirtual 304	java/io/FileInputStream:close	()V
    //   52: aload_3
    //   53: areturn
    //   54: astore_0
    //   55: aload_0
    //   56: invokevirtual 80	java/lang/Exception:printStackTrace	()V
    //   59: aload_3
    //   60: areturn
    //   61: aload_2
    //   62: ifnull +7 -> 69
    //   65: aload_2
    //   66: invokevirtual 304	java/io/FileInputStream:close	()V
    //   69: aconst_null
    //   70: areturn
    //   71: astore_0
    //   72: aload_0
    //   73: invokevirtual 80	java/lang/Exception:printStackTrace	()V
    //   76: goto -7 -> 69
    //   79: astore_3
    //   80: aconst_null
    //   81: astore_2
    //   82: aload_2
    //   83: astore_0
    //   84: ldc_w 305
    //   87: new 115	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   94: ldc_w 307
    //   97: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload_3
    //   101: invokevirtual 308	java/lang/Throwable:toString	()Ljava/lang/String;
    //   104: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 311	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   113: pop
    //   114: aload_2
    //   115: ifnull -46 -> 69
    //   118: aload_2
    //   119: invokevirtual 304	java/io/FileInputStream:close	()V
    //   122: goto -53 -> 69
    //   125: astore_0
    //   126: aload_0
    //   127: invokevirtual 80	java/lang/Exception:printStackTrace	()V
    //   130: goto -61 -> 69
    //   133: astore_2
    //   134: aconst_null
    //   135: astore_0
    //   136: aload_0
    //   137: ifnull +7 -> 144
    //   140: aload_0
    //   141: invokevirtual 304	java/io/FileInputStream:close	()V
    //   144: aload_2
    //   145: athrow
    //   146: astore_0
    //   147: aload_0
    //   148: invokevirtual 80	java/lang/Exception:printStackTrace	()V
    //   151: goto -7 -> 144
    //   154: astore_2
    //   155: goto -19 -> 136
    //   158: astore_3
    //   159: goto -77 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramFile	File
    //   37	5	1	i	int
    //   19	100	2	localFileInputStream	java.io.FileInputStream
    //   133	12	2	localObject1	Object
    //   154	1	2	localObject2	Object
    //   26	34	3	arrayOfByte	byte[]
    //   79	22	3	localThrowable1	java.lang.Throwable
    //   158	1	3	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   48	52	54	java/lang/Exception
    //   65	69	71	java/lang/Exception
    //   11	20	79	java/lang/Throwable
    //   118	122	125	java/lang/Exception
    //   11	20	133	finally
    //   140	144	146	java/lang/Exception
    //   22	27	154	finally
    //   29	38	154	finally
    //   84	114	154	finally
    //   22	27	158	java/lang/Throwable
    //   29	38	158	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.util.soloader.SoUtils
 * JD-Core Version:    0.7.0.1
 */