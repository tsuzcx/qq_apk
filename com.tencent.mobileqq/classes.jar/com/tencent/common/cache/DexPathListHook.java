package com.tencent.common.cache;

import android.os.Build.VERSION;
import android.os.Environment;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Field;
import java.util.zip.ZipFile;

public class DexPathListHook
{
  private static final String a = Environment.getExternalStorageDirectory().getPath() + "/tencent/MobileQQ/" + "com.tencent.mobileqq".replace(".", File.separator) + File.separator;
  private static final String b = a + File.separator + "info.txt";
  private static final String c = a + File.separator + "myZip.zip";
  
  public static int a(ClassLoader paramClassLoader)
  {
    k = 0;
    if (Build.VERSION.SDK_INT >= 24) {
      i = 0;
    }
    do
    {
      return i;
      try
      {
        localObject1 = DexClassLoader.class.getSuperclass().getDeclaredField("pathList");
        ((Field)localObject1).setAccessible(true);
        localObject2 = ((Field)localObject1).get(paramClassLoader);
        paramClassLoader = localObject2.getClass().getDeclaredField("dexElements");
        paramClassLoader.setAccessible(true);
        localObject3 = (Object[])paramClassLoader.get(localObject2);
        a();
        localObject1 = new File(c);
        if (!((File)localObject1).exists())
        {
          if (!QLog.isColorLevel()) {
            break label545;
          }
          QLog.e("DexPathListHook", 2, "ClearDexPathListZipFile zipFile generate false");
          break label545;
        }
        m = localObject3.length;
        j = 0;
        i = 0;
      }
      catch (Exception paramClassLoader)
      {
        for (;;)
        {
          Object localObject1;
          Object localObject2;
          Object localObject3;
          int m;
          int j;
          Object localObject4;
          i = 0;
          continue;
          break label547;
          return 0;
          j += 1;
          continue;
          k += 1;
        }
      }
      if (j < m) {
        localObject4 = localObject3[j];
      }
      try
      {
        Object localObject5 = localObject4.getClass().getDeclaredField("zipFile");
        ((Field)localObject5).setAccessible(true);
        ZipFile localZipFile = (ZipFile)((Field)localObject5).get(localObject4);
        if (localZipFile == null) {
          break;
        }
        if ((localZipFile instanceof HookDexZipFile))
        {
          if (!((HookDexZipFile)localZipFile).a()) {
            break;
          }
          i += 1;
          break;
        }
        paramClassLoader = localZipFile.getName();
        if (!paramClassLoader.contains("com.tencent.mobileqq")) {
          break;
        }
        boolean bool = paramClassLoader.contains("base.apk");
        if (!bool) {
          break;
        }
        try
        {
          paramClassLoader = localObject4.getClass().getDeclaredField("zip");
          paramClassLoader.setAccessible(true);
          paramClassLoader = (File)paramClassLoader.get(localObject4);
          if (paramClassLoader == null) {
            break;
          }
          paramClassLoader = new HookDexZipFile((File)localObject1, paramClassLoader, localZipFile);
          ((Field)localObject5).set(localObject4, paramClassLoader);
          paramClassLoader.a();
          i += 1;
        }
        catch (NoSuchFieldException paramClassLoader)
        {
          for (;;)
          {
            paramClassLoader = localObject4.getClass().getDeclaredField("file");
          }
        }
        j = i;
        if (Build.VERSION.SDK_INT == 23)
        {
          paramClassLoader = localObject2.getClass().getDeclaredField("nativeLibraryPathElements");
          paramClassLoader.setAccessible(true);
          paramClassLoader = (Object[])paramClassLoader.get(localObject2);
          m = paramClassLoader.length;
          j = i;
          if (k < m)
          {
            localObject2 = paramClassLoader[k];
            localObject3 = localObject2.getClass().getDeclaredField("zipFile");
            ((Field)localObject3).setAccessible(true);
            localObject4 = (ZipFile)((Field)localObject3).get(localObject2);
            if ((localObject4 == null) || ((localObject4 instanceof HookDexZipFile))) {
              break label554;
            }
            localObject5 = ((ZipFile)localObject4).getName();
            if ((!((String)localObject5).contains("com.tencent.mobileqq")) || (!((String)localObject5).contains("base.apk"))) {
              break label554;
            }
            localObject5 = localObject2.getClass().getDeclaredField("zip");
            ((Field)localObject5).setAccessible(true);
            localObject5 = (File)((Field)localObject5).get(localObject2);
            if (localObject5 == null) {
              break label554;
            }
            localObject4 = new HookDexZipFile((File)localObject1, (File)localObject5, (ZipFile)localObject4);
            ((Field)localObject3).set(localObject2, localObject4);
            ((HookDexZipFile)localObject4).a();
          }
        }
      }
      catch (Exception paramClassLoader)
      {
        paramClassLoader.printStackTrace();
        j = i;
        i = j;
      }
    } while (!QLog.isColorLevel());
    QLog.d("DexPathListHook", 2, "ClearDexPathListZipFile clearCount " + j);
    return j;
  }
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: new 23	java/io/File
    //   3: dup
    //   4: getstatic 59	com/tencent/common/cache/DexPathListHook:c	Ljava/lang/String;
    //   7: invokespecial 108	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_0
    //   11: aload_0
    //   12: invokevirtual 112	java/io/File:exists	()Z
    //   15: ifeq +25 -> 40
    //   18: aload_0
    //   19: invokevirtual 170	java/io/File:isFile	()Z
    //   22: ifeq +18 -> 40
    //   25: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +11 -> 39
    //   31: ldc 119
    //   33: iconst_2
    //   34: ldc 172
    //   36: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   39: return
    //   40: new 174	java/util/ArrayList
    //   43: dup
    //   44: iconst_1
    //   45: invokespecial 177	java/util/ArrayList:<init>	(I)V
    //   48: astore_3
    //   49: new 23	java/io/File
    //   52: dup
    //   53: getstatic 55	com/tencent/common/cache/DexPathListHook:b	Ljava/lang/String;
    //   56: invokespecial 108	java/io/File:<init>	(Ljava/lang/String;)V
    //   59: astore_0
    //   60: aload_0
    //   61: invokevirtual 112	java/io/File:exists	()Z
    //   64: ifeq +38 -> 102
    //   67: aload_0
    //   68: invokevirtual 170	java/io/File:isFile	()Z
    //   71: ifeq +31 -> 102
    //   74: aload_0
    //   75: invokevirtual 181	java/io/File:length	()J
    //   78: lconst_0
    //   79: lcmp
    //   80: ifle +22 -> 102
    //   83: aload_3
    //   84: aload_0
    //   85: invokevirtual 184	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   88: invokeinterface 190 2 0
    //   93: pop
    //   94: aload_3
    //   95: getstatic 59	com/tencent/common/cache/DexPathListHook:c	Ljava/lang/String;
    //   98: invokestatic 193	com/tencent/common/cache/DexPathListHook:a	(Ljava/util/List;Ljava/lang/String;)V
    //   101: return
    //   102: aload_0
    //   103: invokevirtual 196	java/io/File:getParentFile	()Ljava/io/File;
    //   106: invokevirtual 112	java/io/File:exists	()Z
    //   109: ifne +11 -> 120
    //   112: aload_0
    //   113: invokevirtual 196	java/io/File:getParentFile	()Ljava/io/File;
    //   116: invokevirtual 199	java/io/File:mkdirs	()Z
    //   119: pop
    //   120: aload_3
    //   121: aload_0
    //   122: invokevirtual 184	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   125: invokeinterface 190 2 0
    //   130: pop
    //   131: aload_0
    //   132: invokevirtual 202	java/io/File:createNewFile	()Z
    //   135: pop
    //   136: new 204	java/io/BufferedOutputStream
    //   139: dup
    //   140: new 206	java/io/FileOutputStream
    //   143: dup
    //   144: aload_0
    //   145: invokespecial 209	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   148: invokespecial 212	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   151: astore_1
    //   152: aload_1
    //   153: astore_0
    //   154: aload_1
    //   155: ldc 214
    //   157: invokevirtual 218	java/lang/String:getBytes	()[B
    //   160: invokevirtual 222	java/io/BufferedOutputStream:write	([B)V
    //   163: aload_1
    //   164: astore_0
    //   165: aload_1
    //   166: invokevirtual 225	java/io/BufferedOutputStream:flush	()V
    //   169: aload_1
    //   170: ifnull +7 -> 177
    //   173: aload_1
    //   174: invokevirtual 228	java/io/BufferedOutputStream:close	()V
    //   177: aload_3
    //   178: getstatic 59	com/tencent/common/cache/DexPathListHook:c	Ljava/lang/String;
    //   181: invokestatic 193	com/tencent/common/cache/DexPathListHook:a	(Ljava/util/List;Ljava/lang/String;)V
    //   184: return
    //   185: astore_2
    //   186: aconst_null
    //   187: astore_1
    //   188: aload_1
    //   189: astore_0
    //   190: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +14 -> 207
    //   196: aload_1
    //   197: astore_0
    //   198: ldc 119
    //   200: iconst_2
    //   201: ldc 230
    //   203: aload_2
    //   204: invokestatic 233	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   207: aload_1
    //   208: ifnull -31 -> 177
    //   211: aload_1
    //   212: invokevirtual 228	java/io/BufferedOutputStream:close	()V
    //   215: goto -38 -> 177
    //   218: astore_0
    //   219: goto -42 -> 177
    //   222: astore_1
    //   223: aconst_null
    //   224: astore_0
    //   225: aload_0
    //   226: ifnull +7 -> 233
    //   229: aload_0
    //   230: invokevirtual 228	java/io/BufferedOutputStream:close	()V
    //   233: aload_1
    //   234: athrow
    //   235: astore_0
    //   236: goto -59 -> 177
    //   239: astore_0
    //   240: goto -7 -> 233
    //   243: astore_1
    //   244: goto -19 -> 225
    //   247: astore_2
    //   248: goto -60 -> 188
    // Local variable table:
    //   start	length	slot	name	signature
    //   10	188	0	localObject1	Object
    //   218	1	0	localException1	Exception
    //   224	6	0	localObject2	Object
    //   235	1	0	localException2	Exception
    //   239	1	0	localException3	Exception
    //   151	61	1	localBufferedOutputStream	java.io.BufferedOutputStream
    //   222	12	1	localObject3	Object
    //   243	1	1	localObject4	Object
    //   185	19	2	localException4	Exception
    //   247	1	2	localException5	Exception
    //   48	130	3	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   131	152	185	java/lang/Exception
    //   211	215	218	java/lang/Exception
    //   131	152	222	finally
    //   173	177	235	java/lang/Exception
    //   229	233	239	java/lang/Exception
    //   154	163	243	finally
    //   165	169	243	finally
    //   190	196	243	finally
    //   198	207	243	finally
    //   154	163	247	java/lang/Exception
    //   165	169	247	java/lang/Exception
  }
  
  /* Error */
  public static void a(java.util.List paramList, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 206	java/io/FileOutputStream
    //   6: dup
    //   7: new 23	java/io/File
    //   10: dup
    //   11: aload_1
    //   12: invokespecial 108	java/io/File:<init>	(Ljava/lang/String;)V
    //   15: invokespecial 209	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   18: astore_3
    //   19: new 204	java/io/BufferedOutputStream
    //   22: dup
    //   23: aload_3
    //   24: invokespecial 212	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   27: astore 4
    //   29: new 237	java/util/zip/ZipOutputStream
    //   32: dup
    //   33: aload 4
    //   35: invokespecial 238	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   38: astore_1
    //   39: aload_0
    //   40: invokeinterface 242 1 0
    //   45: astore_0
    //   46: aload_0
    //   47: invokeinterface 247 1 0
    //   52: ifeq +243 -> 295
    //   55: new 23	java/io/File
    //   58: dup
    //   59: aload_0
    //   60: invokeinterface 251 1 0
    //   65: checkcast 42	java/lang/String
    //   68: invokespecial 108	java/io/File:<init>	(Ljava/lang/String;)V
    //   71: astore 5
    //   73: aload 5
    //   75: ifnull -29 -> 46
    //   78: aload 5
    //   80: invokevirtual 112	java/io/File:exists	()Z
    //   83: ifeq -37 -> 46
    //   86: aload_1
    //   87: new 253	java/util/zip/ZipEntry
    //   90: dup
    //   91: aload 5
    //   93: invokevirtual 254	java/io/File:getName	()Ljava/lang/String;
    //   96: invokespecial 255	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   99: invokevirtual 259	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   102: aload_1
    //   103: bipush 9
    //   105: invokevirtual 262	java/util/zip/ZipOutputStream:setLevel	(I)V
    //   108: new 264	java/io/FileInputStream
    //   111: dup
    //   112: aload 5
    //   114: invokespecial 265	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   117: astore 5
    //   119: sipush 20480
    //   122: newarray byte
    //   124: astore 6
    //   126: aload 5
    //   128: aload 6
    //   130: iconst_0
    //   131: sipush 20480
    //   134: invokevirtual 269	java/io/FileInputStream:read	([BII)I
    //   137: istore_2
    //   138: iload_2
    //   139: iconst_m1
    //   140: if_icmpeq +101 -> 241
    //   143: aload_1
    //   144: aload 6
    //   146: iconst_0
    //   147: iload_2
    //   148: invokevirtual 272	java/util/zip/ZipOutputStream:write	([BII)V
    //   151: goto -25 -> 126
    //   154: astore_0
    //   155: aload 5
    //   157: ifnull +8 -> 165
    //   160: aload 5
    //   162: invokevirtual 273	java/io/FileInputStream:close	()V
    //   165: aload_1
    //   166: ifnull +11 -> 177
    //   169: aload_1
    //   170: invokevirtual 274	java/util/zip/ZipOutputStream:flush	()V
    //   173: aload_1
    //   174: invokevirtual 277	java/util/zip/ZipOutputStream:closeEntry	()V
    //   177: aload_0
    //   178: athrow
    //   179: astore 6
    //   181: aload_1
    //   182: astore_0
    //   183: aload 4
    //   185: astore 5
    //   187: aload_3
    //   188: astore_1
    //   189: aload_0
    //   190: astore 4
    //   192: aload 5
    //   194: astore_0
    //   195: aload 6
    //   197: astore_3
    //   198: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   201: ifeq +13 -> 214
    //   204: ldc 119
    //   206: iconst_2
    //   207: ldc_w 279
    //   210: aload_3
    //   211: invokestatic 281	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   214: aload 4
    //   216: ifnull +8 -> 224
    //   219: aload 4
    //   221: invokevirtual 282	java/util/zip/ZipOutputStream:close	()V
    //   224: aload_0
    //   225: ifnull +7 -> 232
    //   228: aload_0
    //   229: invokevirtual 228	java/io/BufferedOutputStream:close	()V
    //   232: aload_1
    //   233: ifnull +7 -> 240
    //   236: aload_1
    //   237: invokevirtual 283	java/io/FileOutputStream:close	()V
    //   240: return
    //   241: aload 5
    //   243: ifnull +8 -> 251
    //   246: aload 5
    //   248: invokevirtual 273	java/io/FileInputStream:close	()V
    //   251: aload_1
    //   252: ifnull -206 -> 46
    //   255: aload_1
    //   256: invokevirtual 274	java/util/zip/ZipOutputStream:flush	()V
    //   259: aload_1
    //   260: invokevirtual 277	java/util/zip/ZipOutputStream:closeEntry	()V
    //   263: goto -217 -> 46
    //   266: astore_0
    //   267: aload_1
    //   268: ifnull +7 -> 275
    //   271: aload_1
    //   272: invokevirtual 282	java/util/zip/ZipOutputStream:close	()V
    //   275: aload 4
    //   277: ifnull +8 -> 285
    //   280: aload 4
    //   282: invokevirtual 228	java/io/BufferedOutputStream:close	()V
    //   285: aload_3
    //   286: ifnull +7 -> 293
    //   289: aload_3
    //   290: invokevirtual 283	java/io/FileOutputStream:close	()V
    //   293: aload_0
    //   294: athrow
    //   295: aload_1
    //   296: ifnull +7 -> 303
    //   299: aload_1
    //   300: invokevirtual 282	java/util/zip/ZipOutputStream:close	()V
    //   303: aload 4
    //   305: ifnull +8 -> 313
    //   308: aload 4
    //   310: invokevirtual 228	java/io/BufferedOutputStream:close	()V
    //   313: aload_3
    //   314: ifnull -74 -> 240
    //   317: aload_3
    //   318: invokevirtual 283	java/io/FileOutputStream:close	()V
    //   321: return
    //   322: astore_0
    //   323: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   326: ifeq -86 -> 240
    //   329: ldc 119
    //   331: iconst_2
    //   332: ldc_w 285
    //   335: aload_0
    //   336: invokestatic 281	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   339: return
    //   340: astore_0
    //   341: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   344: ifeq -41 -> 303
    //   347: ldc 119
    //   349: iconst_2
    //   350: ldc_w 285
    //   353: aload_0
    //   354: invokestatic 281	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   357: goto -54 -> 303
    //   360: astore_0
    //   361: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   364: ifeq -51 -> 313
    //   367: ldc 119
    //   369: iconst_2
    //   370: ldc_w 285
    //   373: aload_0
    //   374: invokestatic 281	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   377: goto -64 -> 313
    //   380: astore_3
    //   381: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   384: ifeq -160 -> 224
    //   387: ldc 119
    //   389: iconst_2
    //   390: ldc_w 285
    //   393: aload_3
    //   394: invokestatic 281	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   397: goto -173 -> 224
    //   400: astore_0
    //   401: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   404: ifeq -172 -> 232
    //   407: ldc 119
    //   409: iconst_2
    //   410: ldc_w 285
    //   413: aload_0
    //   414: invokestatic 281	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   417: goto -185 -> 232
    //   420: astore_0
    //   421: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   424: ifeq -184 -> 240
    //   427: ldc 119
    //   429: iconst_2
    //   430: ldc_w 285
    //   433: aload_0
    //   434: invokestatic 281	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   437: return
    //   438: astore_1
    //   439: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   442: ifeq -167 -> 275
    //   445: ldc 119
    //   447: iconst_2
    //   448: ldc_w 285
    //   451: aload_1
    //   452: invokestatic 281	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   455: goto -180 -> 275
    //   458: astore_1
    //   459: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   462: ifeq -177 -> 285
    //   465: ldc 119
    //   467: iconst_2
    //   468: ldc_w 285
    //   471: aload_1
    //   472: invokestatic 281	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   475: goto -190 -> 285
    //   478: astore_1
    //   479: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   482: ifeq -189 -> 293
    //   485: ldc 119
    //   487: iconst_2
    //   488: ldc_w 285
    //   491: aload_1
    //   492: invokestatic 281	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   495: goto -202 -> 293
    //   498: astore_0
    //   499: aconst_null
    //   500: astore_1
    //   501: aconst_null
    //   502: astore 4
    //   504: aconst_null
    //   505: astore_3
    //   506: goto -239 -> 267
    //   509: astore_0
    //   510: aconst_null
    //   511: astore_1
    //   512: aconst_null
    //   513: astore 4
    //   515: goto -248 -> 267
    //   518: astore_0
    //   519: aconst_null
    //   520: astore_1
    //   521: goto -254 -> 267
    //   524: astore 6
    //   526: aload_0
    //   527: astore_3
    //   528: aload_1
    //   529: astore 5
    //   531: aload 4
    //   533: astore_1
    //   534: aload 6
    //   536: astore_0
    //   537: aload_3
    //   538: astore 4
    //   540: aload 5
    //   542: astore_3
    //   543: goto -276 -> 267
    //   546: astore_3
    //   547: aconst_null
    //   548: astore_0
    //   549: aconst_null
    //   550: astore_1
    //   551: aload 5
    //   553: astore 4
    //   555: goto -357 -> 198
    //   558: astore 4
    //   560: aconst_null
    //   561: astore_0
    //   562: aload_3
    //   563: astore_1
    //   564: aload 4
    //   566: astore_3
    //   567: aload 5
    //   569: astore 4
    //   571: goto -373 -> 198
    //   574: astore 6
    //   576: aload 4
    //   578: astore_0
    //   579: aload_3
    //   580: astore_1
    //   581: aload 6
    //   583: astore_3
    //   584: aload 5
    //   586: astore 4
    //   588: goto -390 -> 198
    //   591: astore_0
    //   592: aconst_null
    //   593: astore 5
    //   595: goto -440 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	598	0	paramList	java.util.List
    //   0	598	1	paramString	String
    //   137	11	2	i	int
    //   18	300	3	localObject1	Object
    //   380	14	3	localIOException	java.io.IOException
    //   505	38	3	localObject2	Object
    //   546	17	3	localException1	Exception
    //   566	18	3	localObject3	Object
    //   27	527	4	localObject4	Object
    //   558	7	4	localException2	Exception
    //   569	18	4	localObject5	Object
    //   1	593	5	localObject6	Object
    //   124	21	6	arrayOfByte	byte[]
    //   179	17	6	localException3	Exception
    //   524	11	6	localObject7	Object
    //   574	8	6	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   119	126	154	finally
    //   126	138	154	finally
    //   143	151	154	finally
    //   39	46	179	java/lang/Exception
    //   46	73	179	java/lang/Exception
    //   78	108	179	java/lang/Exception
    //   160	165	179	java/lang/Exception
    //   169	177	179	java/lang/Exception
    //   177	179	179	java/lang/Exception
    //   246	251	179	java/lang/Exception
    //   255	263	179	java/lang/Exception
    //   39	46	266	finally
    //   46	73	266	finally
    //   78	108	266	finally
    //   160	165	266	finally
    //   169	177	266	finally
    //   177	179	266	finally
    //   246	251	266	finally
    //   255	263	266	finally
    //   317	321	322	java/io/IOException
    //   299	303	340	java/io/IOException
    //   308	313	360	java/io/IOException
    //   219	224	380	java/io/IOException
    //   228	232	400	java/io/IOException
    //   236	240	420	java/io/IOException
    //   271	275	438	java/io/IOException
    //   280	285	458	java/io/IOException
    //   289	293	478	java/io/IOException
    //   3	19	498	finally
    //   19	29	509	finally
    //   29	39	518	finally
    //   198	214	524	finally
    //   3	19	546	java/lang/Exception
    //   19	29	558	java/lang/Exception
    //   29	39	574	java/lang/Exception
    //   108	119	591	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.cache.DexPathListHook
 * JD-Core Version:    0.7.0.1
 */