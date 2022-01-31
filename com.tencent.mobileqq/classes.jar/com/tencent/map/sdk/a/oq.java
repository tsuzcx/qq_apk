package com.tencent.map.sdk.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.io.File;

public class oq
{
  private static boolean b;
  
  static
  {
    if (!oq.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      b = false;
      return;
    }
  }
  
  private static File a(Context paramContext)
  {
    return new File(paramContext.getApplicationInfo().nativeLibraryDir);
  }
  
  private static void a(File paramFile)
  {
    for (;;)
    {
      int i;
      try
      {
        File[] arrayOfFile = paramFile.listFiles();
        if (arrayOfFile != null)
        {
          int j = arrayOfFile.length;
          i = 0;
          if (i < j)
          {
            File localFile = arrayOfFile[i];
            localFile.getName();
            if (localFile.delete()) {
              break label102;
            }
            or.b("Failed to remove " + localFile.getAbsolutePath());
            break label102;
          }
        }
        if (!paramFile.delete()) {
          or.b("Failed to remove " + paramFile.getAbsolutePath());
        }
        return;
      }
      catch (Exception paramFile)
      {
        or.b("Failed to remove old libs, ", paramFile);
        return;
      }
      label102:
      i += 1;
    }
  }
  
  static boolean a(Context paramContext, String paramString)
  {
    if ((!a) && (paramContext == null)) {
      throw new AssertionError();
    }
    paramString = b(paramContext, paramString);
    boolean bool = paramString.exists();
    or.a("libary:" + paramString.getAbsolutePath() + " is exist:" + bool);
    if ((!bool) && (!b(paramContext))) {
      return false;
    }
    try
    {
      System.load(paramString.getAbsolutePath());
      return true;
    }
    catch (UnsatisfiedLinkError paramContext) {}
    return false;
  }
  
  private static File b(Context paramContext, String paramString)
  {
    paramString = System.mapLibraryName(paramString);
    return new File(a(paramContext), paramString);
  }
  
  /* Error */
  private static boolean b(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: getstatic 19	com/tencent/map/sdk/a/oq:b	Z
    //   6: ifeq +5 -> 11
    //   9: iconst_0
    //   10: ireturn
    //   11: iconst_1
    //   12: putstatic 19	com/tencent/map/sdk/a/oq:b	Z
    //   15: aload_0
    //   16: invokestatic 114	com/tencent/map/sdk/a/oq:a	(Landroid/content/Context;)Ljava/io/File;
    //   19: astore 7
    //   21: aload 7
    //   23: invokestatic 121	com/tencent/map/sdk/a/oq:a	(Ljava/io/File;)V
    //   26: new 123	java/util/zip/ZipFile
    //   29: dup
    //   30: new 26	java/io/File
    //   33: dup
    //   34: aload_0
    //   35: invokevirtual 32	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   38: getfield 126	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   41: invokespecial 41	java/io/File:<init>	(Ljava/lang/String;)V
    //   44: iconst_1
    //   45: invokespecial 129	java/util/zip/ZipFile:<init>	(Ljava/io/File;I)V
    //   48: astore 8
    //   50: getstatic 134	com/tencent/map/sdk/a/op:a	[Ljava/lang/String;
    //   53: astore 10
    //   55: aload 10
    //   57: arraylength
    //   58: istore_2
    //   59: iconst_0
    //   60: istore_1
    //   61: iload_1
    //   62: iload_2
    //   63: if_icmpge +392 -> 455
    //   66: aload 10
    //   68: iload_1
    //   69: aaload
    //   70: astore 6
    //   72: aload 8
    //   74: new 57	java/lang/StringBuilder
    //   77: dup
    //   78: ldc 136
    //   80: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   83: getstatic 141	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   86: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc 143
    //   91: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload 6
    //   96: invokestatic 112	java/lang/System:mapLibraryName	(Ljava/lang/String;)Ljava/lang/String;
    //   99: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokevirtual 147	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   108: astore 4
    //   110: aload 4
    //   112: ifnull +34 -> 146
    //   115: aload 4
    //   117: ifnonnull +70 -> 187
    //   120: aload 8
    //   122: invokevirtual 150	java/util/zip/ZipFile:close	()V
    //   125: aload 7
    //   127: invokestatic 121	com/tencent/map/sdk/a/oq:a	(Ljava/io/File;)V
    //   130: iconst_0
    //   131: ireturn
    //   132: astore_0
    //   133: ldc 152
    //   135: aload_0
    //   136: invokestatic 79	com/tencent/map/sdk/a/or:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   139: aload 7
    //   141: invokestatic 121	com/tencent/map/sdk/a/oq:a	(Ljava/io/File;)V
    //   144: iconst_0
    //   145: ireturn
    //   146: aload 8
    //   148: new 57	java/lang/StringBuilder
    //   151: dup
    //   152: ldc 136
    //   154: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   157: getstatic 155	android/os/Build:CPU_ABI2	Ljava/lang/String;
    //   160: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: ldc 143
    //   165: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload 6
    //   170: invokestatic 112	java/lang/System:mapLibraryName	(Ljava/lang/String;)Ljava/lang/String;
    //   173: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokevirtual 147	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   182: astore 4
    //   184: goto -69 -> 115
    //   187: aload_0
    //   188: aload 6
    //   190: invokestatic 88	com/tencent/map/sdk/a/oq:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   193: astore 9
    //   195: new 57	java/lang/StringBuilder
    //   198: dup
    //   199: ldc 157
    //   201: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   204: aload 9
    //   206: invokevirtual 63	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   209: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 100	com/tencent/map/sdk/a/or:a	(Ljava/lang/String;)V
    //   218: getstatic 17	com/tencent/map/sdk/a/oq:a	Z
    //   221: ifne +19 -> 240
    //   224: aload 9
    //   226: invokevirtual 91	java/io/File:exists	()Z
    //   229: ifeq +11 -> 240
    //   232: new 84	java/lang/AssertionError
    //   235: dup
    //   236: invokespecial 85	java/lang/AssertionError:<init>	()V
    //   239: athrow
    //   240: aload 9
    //   242: invokevirtual 160	java/io/File:createNewFile	()Z
    //   245: ifne +58 -> 303
    //   248: new 119	java/io/IOException
    //   251: dup
    //   252: invokespecial 161	java/io/IOException:<init>	()V
    //   255: athrow
    //   256: astore_0
    //   257: aload 9
    //   259: invokevirtual 91	java/io/File:exists	()Z
    //   262: ifeq +34 -> 296
    //   265: aload 9
    //   267: invokevirtual 55	java/io/File:delete	()Z
    //   270: ifne +26 -> 296
    //   273: new 57	java/lang/StringBuilder
    //   276: dup
    //   277: ldc 163
    //   279: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   282: aload 9
    //   284: invokevirtual 63	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   287: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokestatic 74	com/tencent/map/sdk/a/or:b	(Ljava/lang/String;)V
    //   296: aload 8
    //   298: invokevirtual 150	java/util/zip/ZipFile:close	()V
    //   301: aload_0
    //   302: athrow
    //   303: aload 8
    //   305: aload 4
    //   307: invokevirtual 167	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   310: astore 4
    //   312: new 169	java/io/FileOutputStream
    //   315: dup
    //   316: aload 9
    //   318: invokespecial 171	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   321: astore 6
    //   323: sipush 16384
    //   326: newarray byte
    //   328: astore 11
    //   330: aload 4
    //   332: aload 11
    //   334: invokevirtual 177	java/io/InputStream:read	([B)I
    //   337: istore_3
    //   338: iload_3
    //   339: ifle +46 -> 385
    //   342: aload 6
    //   344: aload 11
    //   346: iconst_0
    //   347: iload_3
    //   348: invokevirtual 181	java/io/FileOutputStream:write	([BII)V
    //   351: goto -21 -> 330
    //   354: astore_0
    //   355: aload 4
    //   357: astore 5
    //   359: aload 6
    //   361: astore 4
    //   363: aload 5
    //   365: ifnull +8 -> 373
    //   368: aload 5
    //   370: invokevirtual 182	java/io/InputStream:close	()V
    //   373: aload 4
    //   375: ifnull +8 -> 383
    //   378: aload 4
    //   380: invokevirtual 183	java/io/FileOutputStream:close	()V
    //   383: aload_0
    //   384: athrow
    //   385: aload 4
    //   387: ifnull +8 -> 395
    //   390: aload 4
    //   392: invokevirtual 182	java/io/InputStream:close	()V
    //   395: aload 6
    //   397: invokevirtual 183	java/io/FileOutputStream:close	()V
    //   400: getstatic 189	android/os/Build$VERSION:SDK_INT	I
    //   403: bipush 9
    //   405: if_icmplt +79 -> 484
    //   408: aload 9
    //   410: iconst_1
    //   411: iconst_0
    //   412: invokevirtual 193	java/io/File:setReadable	(ZZ)Z
    //   415: pop
    //   416: aload 9
    //   418: iconst_1
    //   419: iconst_0
    //   420: invokevirtual 196	java/io/File:setExecutable	(ZZ)Z
    //   423: pop
    //   424: aload 9
    //   426: iconst_1
    //   427: invokevirtual 200	java/io/File:setWritable	(Z)Z
    //   430: pop
    //   431: goto +53 -> 484
    //   434: astore_0
    //   435: aload 6
    //   437: invokevirtual 183	java/io/FileOutputStream:close	()V
    //   440: aload_0
    //   441: athrow
    //   442: astore_0
    //   443: aload 4
    //   445: ifnull +8 -> 453
    //   448: aload 4
    //   450: invokevirtual 183	java/io/FileOutputStream:close	()V
    //   453: aload_0
    //   454: athrow
    //   455: aload 8
    //   457: invokevirtual 150	java/util/zip/ZipFile:close	()V
    //   460: iconst_1
    //   461: ireturn
    //   462: astore_0
    //   463: aconst_null
    //   464: astore 4
    //   466: goto -103 -> 363
    //   469: astore_0
    //   470: aconst_null
    //   471: astore 6
    //   473: aload 4
    //   475: astore 5
    //   477: aload 6
    //   479: astore 4
    //   481: goto -118 -> 363
    //   484: iload_1
    //   485: iconst_1
    //   486: iadd
    //   487: istore_1
    //   488: goto -427 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	491	0	paramContext	Context
    //   60	428	1	i	int
    //   58	6	2	j	int
    //   337	11	3	k	int
    //   108	372	4	localObject1	Object
    //   1	475	5	localObject2	Object
    //   70	408	6	localObject3	Object
    //   19	121	7	localFile1	File
    //   48	408	8	localZipFile	java.util.zip.ZipFile
    //   193	232	9	localFile2	File
    //   53	14	10	arrayOfString	String[]
    //   328	17	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   26	59	132	java/io/IOException
    //   72	110	132	java/io/IOException
    //   120	130	132	java/io/IOException
    //   146	184	132	java/io/IOException
    //   187	240	132	java/io/IOException
    //   257	296	132	java/io/IOException
    //   296	303	132	java/io/IOException
    //   455	460	132	java/io/IOException
    //   240	256	256	java/io/IOException
    //   378	383	256	java/io/IOException
    //   383	385	256	java/io/IOException
    //   395	431	256	java/io/IOException
    //   435	442	256	java/io/IOException
    //   448	453	256	java/io/IOException
    //   453	455	256	java/io/IOException
    //   323	330	354	finally
    //   330	338	354	finally
    //   342	351	354	finally
    //   390	395	434	finally
    //   368	373	442	finally
    //   303	312	462	finally
    //   312	323	469	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.oq
 * JD-Core Version:    0.7.0.1
 */