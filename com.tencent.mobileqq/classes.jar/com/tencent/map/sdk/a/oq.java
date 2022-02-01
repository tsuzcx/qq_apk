package com.tencent.map.sdk.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.io.File;

public class oq
{
  private static boolean b = false;
  
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
        Object localObject1 = paramFile.listFiles();
        if (localObject1 != null)
        {
          int j = localObject1.length;
          i = 0;
          if (i < j)
          {
            Object localObject2 = localObject1[i];
            localObject2.getName();
            if (localObject2.delete()) {
              break label113;
            }
            StringBuilder localStringBuilder = new StringBuilder("Failed to remove ");
            localStringBuilder.append(localObject2.getAbsolutePath());
            or.b(localStringBuilder.toString());
            break label113;
          }
        }
        if (!paramFile.delete())
        {
          localObject1 = new StringBuilder("Failed to remove ");
          ((StringBuilder)localObject1).append(paramFile.getAbsolutePath());
          or.b(((StringBuilder)localObject1).toString());
        }
        return;
      }
      catch (Exception paramFile)
      {
        or.b("Failed to remove old libs, ", paramFile);
        return;
      }
      label113:
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
    StringBuilder localStringBuilder = new StringBuilder("libary:");
    localStringBuilder.append(paramString.getAbsolutePath());
    localStringBuilder.append(" is exist:");
    localStringBuilder.append(bool);
    or.a(localStringBuilder.toString());
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
    //   0: getstatic 19	com/tencent/map/sdk/a/oq:b	Z
    //   3: ifeq +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: iconst_1
    //   9: putstatic 19	com/tencent/map/sdk/a/oq:b	Z
    //   12: aload_0
    //   13: invokestatic 114	com/tencent/map/sdk/a/oq:a	(Landroid/content/Context;)Ljava/io/File;
    //   16: astore 8
    //   18: aload 8
    //   20: invokestatic 121	com/tencent/map/sdk/a/oq:a	(Ljava/io/File;)V
    //   23: new 123	java/util/zip/ZipFile
    //   26: dup
    //   27: new 26	java/io/File
    //   30: dup
    //   31: aload_0
    //   32: invokevirtual 32	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   35: getfield 126	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   38: invokespecial 41	java/io/File:<init>	(Ljava/lang/String;)V
    //   41: iconst_1
    //   42: invokespecial 129	java/util/zip/ZipFile:<init>	(Ljava/io/File;I)V
    //   45: astore 9
    //   47: getstatic 134	com/tencent/map/sdk/a/op:a	[Ljava/lang/String;
    //   50: astore 11
    //   52: aload 11
    //   54: arraylength
    //   55: istore_2
    //   56: iconst_0
    //   57: istore_1
    //   58: iload_1
    //   59: iload_2
    //   60: if_icmpge +445 -> 505
    //   63: aload 11
    //   65: iload_1
    //   66: aaload
    //   67: astore 6
    //   69: new 57	java/lang/StringBuilder
    //   72: dup
    //   73: ldc 136
    //   75: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   78: astore 5
    //   80: aload 5
    //   82: getstatic 141	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   85: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload 5
    //   91: ldc 143
    //   93: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload 5
    //   99: aload 6
    //   101: invokestatic 112	java/lang/System:mapLibraryName	(Ljava/lang/String;)Ljava/lang/String;
    //   104: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 9
    //   110: aload 5
    //   112: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokevirtual 147	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   118: astore 5
    //   120: aload 5
    //   122: ifnull +6 -> 128
    //   125: goto +54 -> 179
    //   128: new 57	java/lang/StringBuilder
    //   131: dup
    //   132: ldc 136
    //   134: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   137: astore 5
    //   139: aload 5
    //   141: getstatic 150	android/os/Build:CPU_ABI2	Ljava/lang/String;
    //   144: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload 5
    //   150: ldc 143
    //   152: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload 5
    //   158: aload 6
    //   160: invokestatic 112	java/lang/System:mapLibraryName	(Ljava/lang/String;)Ljava/lang/String;
    //   163: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload 9
    //   169: aload 5
    //   171: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokevirtual 147	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   177: astore 5
    //   179: aload 5
    //   181: ifnonnull +15 -> 196
    //   184: aload 9
    //   186: invokevirtual 153	java/util/zip/ZipFile:close	()V
    //   189: aload 8
    //   191: invokestatic 121	com/tencent/map/sdk/a/oq:a	(Ljava/io/File;)V
    //   194: iconst_0
    //   195: ireturn
    //   196: aload_0
    //   197: aload 6
    //   199: invokestatic 88	com/tencent/map/sdk/a/oq:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   202: astore 10
    //   204: new 57	java/lang/StringBuilder
    //   207: dup
    //   208: ldc 155
    //   210: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   213: astore 6
    //   215: aload 6
    //   217: aload 10
    //   219: invokevirtual 63	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   222: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload 6
    //   228: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 100	com/tencent/map/sdk/a/or:a	(Ljava/lang/String;)V
    //   234: getstatic 17	com/tencent/map/sdk/a/oq:a	Z
    //   237: ifne +22 -> 259
    //   240: aload 10
    //   242: invokevirtual 91	java/io/File:exists	()Z
    //   245: ifne +6 -> 251
    //   248: goto +11 -> 259
    //   251: new 84	java/lang/AssertionError
    //   254: dup
    //   255: invokespecial 85	java/lang/AssertionError:<init>	()V
    //   258: athrow
    //   259: aload 10
    //   261: invokevirtual 158	java/io/File:createNewFile	()Z
    //   264: istore 4
    //   266: iload 4
    //   268: ifeq +175 -> 443
    //   271: aconst_null
    //   272: astore 6
    //   274: aload 9
    //   276: aload 5
    //   278: invokevirtual 162	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   281: astore 5
    //   283: new 164	java/io/FileOutputStream
    //   286: dup
    //   287: aload 10
    //   289: invokespecial 166	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   292: astore 7
    //   294: sipush 16384
    //   297: newarray byte
    //   299: astore 6
    //   301: aload 5
    //   303: aload 6
    //   305: invokevirtual 172	java/io/InputStream:read	([B)I
    //   308: istore_3
    //   309: iload_3
    //   310: ifle +15 -> 325
    //   313: aload 7
    //   315: aload 6
    //   317: iconst_0
    //   318: iload_3
    //   319: invokevirtual 176	java/io/FileOutputStream:write	([BII)V
    //   322: goto -21 -> 301
    //   325: aload 5
    //   327: ifnull +19 -> 346
    //   330: aload 5
    //   332: invokevirtual 177	java/io/InputStream:close	()V
    //   335: goto +11 -> 346
    //   338: astore_0
    //   339: aload 7
    //   341: invokevirtual 178	java/io/FileOutputStream:close	()V
    //   344: aload_0
    //   345: athrow
    //   346: aload 7
    //   348: invokevirtual 178	java/io/FileOutputStream:close	()V
    //   351: getstatic 184	android/os/Build$VERSION:SDK_INT	I
    //   354: bipush 9
    //   356: if_icmplt +26 -> 382
    //   359: aload 10
    //   361: iconst_1
    //   362: iconst_0
    //   363: invokevirtual 188	java/io/File:setReadable	(ZZ)Z
    //   366: pop
    //   367: aload 10
    //   369: iconst_1
    //   370: iconst_0
    //   371: invokevirtual 191	java/io/File:setExecutable	(ZZ)Z
    //   374: pop
    //   375: aload 10
    //   377: iconst_1
    //   378: invokevirtual 195	java/io/File:setWritable	(Z)Z
    //   381: pop
    //   382: iload_1
    //   383: iconst_1
    //   384: iadd
    //   385: istore_1
    //   386: goto -328 -> 58
    //   389: astore_0
    //   390: aload 7
    //   392: astore 6
    //   394: goto +11 -> 405
    //   397: astore_0
    //   398: goto +7 -> 405
    //   401: astore_0
    //   402: aconst_null
    //   403: astore 5
    //   405: aload 5
    //   407: ifnull +24 -> 431
    //   410: aload 5
    //   412: invokevirtual 177	java/io/InputStream:close	()V
    //   415: goto +16 -> 431
    //   418: astore_0
    //   419: aload 6
    //   421: ifnull +8 -> 429
    //   424: aload 6
    //   426: invokevirtual 178	java/io/FileOutputStream:close	()V
    //   429: aload_0
    //   430: athrow
    //   431: aload 6
    //   433: ifnull +8 -> 441
    //   436: aload 6
    //   438: invokevirtual 178	java/io/FileOutputStream:close	()V
    //   441: aload_0
    //   442: athrow
    //   443: new 119	java/io/IOException
    //   446: dup
    //   447: invokespecial 196	java/io/IOException:<init>	()V
    //   450: athrow
    //   451: astore_0
    //   452: aload 10
    //   454: invokevirtual 91	java/io/File:exists	()Z
    //   457: ifeq +41 -> 498
    //   460: aload 10
    //   462: invokevirtual 55	java/io/File:delete	()Z
    //   465: ifne +33 -> 498
    //   468: new 57	java/lang/StringBuilder
    //   471: dup
    //   472: ldc 198
    //   474: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   477: astore 5
    //   479: aload 5
    //   481: aload 10
    //   483: invokevirtual 63	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   486: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: pop
    //   490: aload 5
    //   492: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   495: invokestatic 74	com/tencent/map/sdk/a/or:b	(Ljava/lang/String;)V
    //   498: aload 9
    //   500: invokevirtual 153	java/util/zip/ZipFile:close	()V
    //   503: aload_0
    //   504: athrow
    //   505: aload 9
    //   507: invokevirtual 153	java/util/zip/ZipFile:close	()V
    //   510: iconst_1
    //   511: ireturn
    //   512: astore_0
    //   513: ldc 200
    //   515: aload_0
    //   516: invokestatic 79	com/tencent/map/sdk/a/or:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   519: aload 8
    //   521: invokestatic 121	com/tencent/map/sdk/a/oq:a	(Ljava/io/File;)V
    //   524: iconst_0
    //   525: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	526	0	paramContext	Context
    //   57	329	1	i	int
    //   55	6	2	j	int
    //   308	11	3	k	int
    //   264	3	4	bool	boolean
    //   78	413	5	localObject1	Object
    //   67	370	6	localObject2	Object
    //   292	99	7	localFileOutputStream	java.io.FileOutputStream
    //   16	504	8	localFile1	File
    //   45	461	9	localZipFile	java.util.zip.ZipFile
    //   202	280	10	localFile2	File
    //   50	14	11	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   330	335	338	finally
    //   294	301	389	finally
    //   301	309	389	finally
    //   313	322	389	finally
    //   283	294	397	finally
    //   274	283	401	finally
    //   410	415	418	finally
    //   259	266	451	java/io/IOException
    //   339	346	451	java/io/IOException
    //   346	382	451	java/io/IOException
    //   424	429	451	java/io/IOException
    //   429	431	451	java/io/IOException
    //   436	441	451	java/io/IOException
    //   441	443	451	java/io/IOException
    //   443	451	451	java/io/IOException
    //   23	56	512	java/io/IOException
    //   69	120	512	java/io/IOException
    //   128	179	512	java/io/IOException
    //   184	194	512	java/io/IOException
    //   196	248	512	java/io/IOException
    //   251	259	512	java/io/IOException
    //   452	498	512	java/io/IOException
    //   498	505	512	java/io/IOException
    //   505	510	512	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.oq
 * JD-Core Version:    0.7.0.1
 */