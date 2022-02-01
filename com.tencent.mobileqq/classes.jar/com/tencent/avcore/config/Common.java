package com.tencent.avcore.config;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

public class Common
{
  public static final String AV_ENGINE_VERSION = "V2.9.0304.001";
  public static final String AV_SHARP_VERSION = "6.0.0";
  public static final String CONFIG_INFO = "ConfigInfo";
  public static final int EM_DEVICE_ANDROID = 201;
  public static final String FILE_NAME = "VideoConfigInfo";
  public static final String SHARP_CONFIG_PAYLOAD_FILE_NAME;
  public static final String SHARP_CONFIG_TYPE_CLEAR = "0";
  public static final String SHARP_CONFIG_TYPE_PAYLOAD = "1";
  public static final String SHARP_CONFIG_TYPE_URL = "2";
  private static final String TAG = "Common";
  public static final ConcurrentHashMap<String, byte[]> mBuffer = new ConcurrentHashMap();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SharpConfigPayload_");
    localStringBuilder.append(Build.MODEL);
    SHARP_CONFIG_PAYLOAD_FILE_NAME = localStringBuilder.toString();
  }
  
  public static void deleteFile(Context paramContext, String paramString)
  {
    try
    {
      mBuffer.remove(paramString);
      paramContext.deleteFile(paramString);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static String getVersion(Context paramContext)
  {
    if (paramContext == null) {
      return "6.0.0";
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      if ((paramContext != null) && (!TextUtils.isEmpty(paramContext.versionName.trim())))
      {
        paramContext = paramContext.versionName.trim();
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "6.0.0";
  }
  
  public static int intPow(int paramInt1, int paramInt2)
  {
    if (paramInt2 < 0) {
      return 0;
    }
    int i = 1;
    while (paramInt2 > 0)
    {
      i *= paramInt1;
      paramInt2 -= 1;
    }
    return i;
  }
  
  /* Error */
  public static byte[] readFile(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: getstatic 65	com/tencent/avcore/config/Common:mBuffer	Ljava/util/concurrent/ConcurrentHashMap;
    //   3: aload_1
    //   4: invokevirtual 123	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   7: checkcast 125	[B
    //   10: astore_3
    //   11: aload_3
    //   12: astore 4
    //   14: aload_3
    //   15: ifnonnull +417 -> 432
    //   18: aload_0
    //   19: aload_1
    //   20: invokevirtual 129	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   23: astore 6
    //   25: aload 6
    //   27: astore 4
    //   29: aload_3
    //   30: astore 5
    //   32: aload 6
    //   34: invokevirtual 135	java/io/FileInputStream:available	()I
    //   37: istore_2
    //   38: iload_2
    //   39: ifgt +74 -> 113
    //   42: aload 6
    //   44: astore 4
    //   46: aload_3
    //   47: astore 5
    //   49: aload 6
    //   51: invokevirtual 138	java/io/FileInputStream:close	()V
    //   54: aload 6
    //   56: ifnull +55 -> 111
    //   59: aload 6
    //   61: invokevirtual 138	java/io/FileInputStream:close	()V
    //   64: aconst_null
    //   65: areturn
    //   66: astore_0
    //   67: invokestatic 144	com/tencent/avcore/util/AVCoreLog:isDevelopLevel	()Z
    //   70: ifeq +41 -> 111
    //   73: new 40	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   80: astore_3
    //   81: aload_3
    //   82: ldc 146
    //   84: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload_3
    //   89: aload_1
    //   90: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload_3
    //   95: ldc 148
    //   97: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: ldc 33
    //   103: aload_3
    //   104: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: aload_0
    //   108: invokestatic 152	com/tencent/avcore/util/AVCoreLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   111: aconst_null
    //   112: areturn
    //   113: aload 6
    //   115: astore 4
    //   117: aload_3
    //   118: astore 5
    //   120: iload_2
    //   121: newarray byte
    //   123: astore_0
    //   124: aload 6
    //   126: astore 4
    //   128: aload_0
    //   129: astore 5
    //   131: aload 6
    //   133: aload_0
    //   134: invokevirtual 156	java/io/FileInputStream:read	([B)I
    //   137: pop
    //   138: aload 6
    //   140: astore 4
    //   142: aload_0
    //   143: astore 5
    //   145: getstatic 65	com/tencent/avcore/config/Common:mBuffer	Ljava/util/concurrent/ConcurrentHashMap;
    //   148: aload_1
    //   149: aload_0
    //   150: invokevirtual 160	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   153: pop
    //   154: aload_0
    //   155: astore 4
    //   157: aload 6
    //   159: ifnull +273 -> 432
    //   162: aload 6
    //   164: invokevirtual 138	java/io/FileInputStream:close	()V
    //   167: aload_0
    //   168: areturn
    //   169: astore_3
    //   170: aload_0
    //   171: astore 4
    //   173: invokestatic 144	com/tencent/avcore/util/AVCoreLog:isDevelopLevel	()Z
    //   176: ifeq +256 -> 432
    //   179: new 40	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   186: astore 5
    //   188: aload_3
    //   189: astore 4
    //   191: aload 5
    //   193: astore_3
    //   194: aload_3
    //   195: ldc 146
    //   197: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload_3
    //   202: aload_1
    //   203: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload_3
    //   208: ldc 148
    //   210: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: ldc 33
    //   216: aload_3
    //   217: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: aload 4
    //   222: invokestatic 152	com/tencent/avcore/util/AVCoreLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   225: aload_0
    //   226: areturn
    //   227: astore_0
    //   228: goto +139 -> 367
    //   231: astore 7
    //   233: aload 5
    //   235: astore_0
    //   236: aload 6
    //   238: astore 5
    //   240: goto +17 -> 257
    //   243: astore_0
    //   244: aconst_null
    //   245: astore 4
    //   247: goto +120 -> 367
    //   250: astore 7
    //   252: aconst_null
    //   253: astore 5
    //   255: aload_3
    //   256: astore_0
    //   257: aload 5
    //   259: astore 4
    //   261: invokestatic 163	com/tencent/avcore/util/AVCoreLog:isColorLevel	()Z
    //   264: ifeq +62 -> 326
    //   267: aload 5
    //   269: astore 4
    //   271: new 40	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   278: astore_3
    //   279: aload 5
    //   281: astore 4
    //   283: aload_3
    //   284: ldc 165
    //   286: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload 5
    //   292: astore 4
    //   294: aload_3
    //   295: aload_1
    //   296: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload 5
    //   302: astore 4
    //   304: aload_3
    //   305: ldc 148
    //   307: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload 5
    //   313: astore 4
    //   315: ldc 33
    //   317: aload_3
    //   318: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: aload 7
    //   323: invokestatic 152	com/tencent/avcore/util/AVCoreLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   326: aload_0
    //   327: astore 4
    //   329: aload 5
    //   331: ifnull +101 -> 432
    //   334: aload 5
    //   336: invokevirtual 138	java/io/FileInputStream:close	()V
    //   339: aload_0
    //   340: areturn
    //   341: astore 5
    //   343: aload_0
    //   344: astore 4
    //   346: invokestatic 144	com/tencent/avcore/util/AVCoreLog:isDevelopLevel	()Z
    //   349: ifeq +83 -> 432
    //   352: new 40	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   359: astore_3
    //   360: aload 5
    //   362: astore 4
    //   364: goto -170 -> 194
    //   367: aload 4
    //   369: ifnull +61 -> 430
    //   372: aload 4
    //   374: invokevirtual 138	java/io/FileInputStream:close	()V
    //   377: goto +53 -> 430
    //   380: astore_3
    //   381: invokestatic 144	com/tencent/avcore/util/AVCoreLog:isDevelopLevel	()Z
    //   384: ifeq +46 -> 430
    //   387: new 40	java/lang/StringBuilder
    //   390: dup
    //   391: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   394: astore 4
    //   396: aload 4
    //   398: ldc 146
    //   400: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: pop
    //   404: aload 4
    //   406: aload_1
    //   407: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: aload 4
    //   413: ldc 148
    //   415: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: ldc 33
    //   421: aload 4
    //   423: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: aload_3
    //   427: invokestatic 152	com/tencent/avcore/util/AVCoreLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   430: aload_0
    //   431: athrow
    //   432: aload 4
    //   434: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	435	0	paramContext	Context
    //   0	435	1	paramString	String
    //   37	84	2	i	int
    //   10	108	3	localObject1	Object
    //   169	20	3	localIOException1	java.io.IOException
    //   193	167	3	localObject2	Object
    //   380	47	3	localIOException2	java.io.IOException
    //   12	421	4	localObject3	Object
    //   30	305	5	localObject4	Object
    //   341	20	5	localIOException3	java.io.IOException
    //   23	214	6	localFileInputStream	java.io.FileInputStream
    //   231	1	7	localException1	Exception
    //   250	72	7	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   59	64	66	java/io/IOException
    //   162	167	169	java/io/IOException
    //   32	38	227	finally
    //   49	54	227	finally
    //   120	124	227	finally
    //   131	138	227	finally
    //   145	154	227	finally
    //   261	267	227	finally
    //   271	279	227	finally
    //   283	290	227	finally
    //   294	300	227	finally
    //   304	311	227	finally
    //   315	326	227	finally
    //   32	38	231	java/lang/Exception
    //   49	54	231	java/lang/Exception
    //   120	124	231	java/lang/Exception
    //   131	138	231	java/lang/Exception
    //   145	154	231	java/lang/Exception
    //   18	25	243	finally
    //   18	25	250	java/lang/Exception
    //   334	339	341	java/io/IOException
    //   372	377	380	java/io/IOException
  }
  
  /* Error */
  public static void writeFile(Context paramContext, String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: iconst_1
    //   4: istore 4
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 8
    //   12: aload 8
    //   14: astore 6
    //   16: aload 9
    //   18: astore 7
    //   20: getstatic 65	com/tencent/avcore/config/Common:mBuffer	Ljava/util/concurrent/ConcurrentHashMap;
    //   23: aload_1
    //   24: aload_2
    //   25: invokevirtual 160	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   28: pop
    //   29: aload 8
    //   31: astore 6
    //   33: aload 9
    //   35: astore 7
    //   37: aload_0
    //   38: aload_1
    //   39: iconst_0
    //   40: invokevirtual 171	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   43: astore_0
    //   44: aload_0
    //   45: astore 6
    //   47: aload_0
    //   48: astore 7
    //   50: aload_0
    //   51: aload_2
    //   52: invokevirtual 177	java/io/FileOutputStream:write	([B)V
    //   55: aload_0
    //   56: ifnull +269 -> 325
    //   59: aload_0
    //   60: invokevirtual 178	java/io/FileOutputStream:close	()V
    //   63: return
    //   64: astore 6
    //   66: invokestatic 144	com/tencent/avcore/util/AVCoreLog:isDevelopLevel	()Z
    //   69: ifeq +256 -> 325
    //   72: new 40	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   79: astore 7
    //   81: aload 7
    //   83: ldc 180
    //   85: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload 7
    //   91: aload_1
    //   92: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload 7
    //   98: ldc 182
    //   100: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload 7
    //   106: astore_0
    //   107: aload 6
    //   109: astore_1
    //   110: aload_2
    //   111: ifnull +15 -> 126
    //   114: iload 4
    //   116: istore_3
    //   117: aload 7
    //   119: astore_0
    //   120: aload 6
    //   122: astore_1
    //   123: goto +5 -> 128
    //   126: iconst_0
    //   127: istore_3
    //   128: aload_0
    //   129: iload_3
    //   130: invokevirtual 185	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload_0
    //   135: ldc 148
    //   137: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: ldc 33
    //   143: aload_0
    //   144: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: aload_1
    //   148: invokestatic 152	com/tencent/avcore/util/AVCoreLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   151: return
    //   152: astore_0
    //   153: goto +173 -> 326
    //   156: astore_0
    //   157: aload 7
    //   159: astore 6
    //   161: new 40	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   168: astore 8
    //   170: aload 7
    //   172: astore 6
    //   174: aload 8
    //   176: ldc 187
    //   178: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload 7
    //   184: astore 6
    //   186: aload 8
    //   188: aload_1
    //   189: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload 7
    //   195: astore 6
    //   197: aload 8
    //   199: ldc 182
    //   201: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload_2
    //   206: ifnull +220 -> 426
    //   209: iconst_1
    //   210: istore_3
    //   211: goto +3 -> 214
    //   214: aload 7
    //   216: astore 6
    //   218: aload 8
    //   220: iload_3
    //   221: invokevirtual 185	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload 7
    //   227: astore 6
    //   229: aload 8
    //   231: ldc 148
    //   233: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: aload 7
    //   239: astore 6
    //   241: ldc 33
    //   243: aload 8
    //   245: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: aload_0
    //   249: invokestatic 152	com/tencent/avcore/util/AVCoreLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   252: aload 7
    //   254: ifnull +71 -> 325
    //   257: aload 7
    //   259: invokevirtual 178	java/io/FileOutputStream:close	()V
    //   262: return
    //   263: astore 6
    //   265: invokestatic 144	com/tencent/avcore/util/AVCoreLog:isDevelopLevel	()Z
    //   268: ifeq +57 -> 325
    //   271: new 40	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   278: astore 7
    //   280: aload 7
    //   282: ldc 180
    //   284: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload 7
    //   290: aload_1
    //   291: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: aload 7
    //   297: ldc 182
    //   299: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: aload 7
    //   305: astore_0
    //   306: aload 6
    //   308: astore_1
    //   309: aload_2
    //   310: ifnull -184 -> 126
    //   313: iload 4
    //   315: istore_3
    //   316: aload 7
    //   318: astore_0
    //   319: aload 6
    //   321: astore_1
    //   322: goto -194 -> 128
    //   325: return
    //   326: aload 6
    //   328: ifnull +90 -> 418
    //   331: aload 6
    //   333: invokevirtual 178	java/io/FileOutputStream:close	()V
    //   336: goto +82 -> 418
    //   339: astore 6
    //   341: invokestatic 144	com/tencent/avcore/util/AVCoreLog:isDevelopLevel	()Z
    //   344: ifeq +74 -> 418
    //   347: new 40	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   354: astore 7
    //   356: aload 7
    //   358: ldc 180
    //   360: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: pop
    //   364: aload 7
    //   366: aload_1
    //   367: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: pop
    //   371: aload 7
    //   373: ldc 182
    //   375: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: aload_2
    //   380: ifnull +9 -> 389
    //   383: iload 5
    //   385: istore_3
    //   386: goto +5 -> 391
    //   389: iconst_0
    //   390: istore_3
    //   391: aload 7
    //   393: iload_3
    //   394: invokevirtual 185	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: aload 7
    //   400: ldc 148
    //   402: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: ldc 33
    //   408: aload 7
    //   410: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   413: aload 6
    //   415: invokestatic 152	com/tencent/avcore/util/AVCoreLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   418: goto +5 -> 423
    //   421: aload_0
    //   422: athrow
    //   423: goto -2 -> 421
    //   426: iconst_0
    //   427: istore_3
    //   428: goto -214 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	431	0	paramContext	Context
    //   0	431	1	paramString	String
    //   0	431	2	paramArrayOfByte	byte[]
    //   116	312	3	bool1	boolean
    //   4	310	4	bool2	boolean
    //   1	383	5	bool3	boolean
    //   14	32	6	localObject1	Object
    //   64	57	6	localIOException1	java.io.IOException
    //   159	81	6	localObject2	Object
    //   263	69	6	localIOException2	java.io.IOException
    //   339	75	6	localIOException3	java.io.IOException
    //   18	391	7	localObject3	Object
    //   10	234	8	localStringBuilder	StringBuilder
    //   7	27	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   59	63	64	java/io/IOException
    //   20	29	152	finally
    //   37	44	152	finally
    //   50	55	152	finally
    //   161	170	152	finally
    //   174	182	152	finally
    //   186	193	152	finally
    //   197	205	152	finally
    //   218	225	152	finally
    //   229	237	152	finally
    //   241	252	152	finally
    //   20	29	156	java/lang/Exception
    //   37	44	156	java/lang/Exception
    //   50	55	156	java/lang/Exception
    //   257	262	263	java/io/IOException
    //   331	336	339	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.config.Common
 * JD-Core Version:    0.7.0.1
 */