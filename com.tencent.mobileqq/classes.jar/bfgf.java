import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import java.io.File;

public class bfgf
{
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    for (;;)
    {
      return false;
      try
      {
        AssetManager localAssetManager = paramContext.getAssets();
        String[] arrayOfString = localAssetManager.list(paramString1);
        if ((arrayOfString != null) && (arrayOfString.length != 0))
        {
          localObject = new File(paramString2);
          if (!((File)localObject).exists()) {
            ((File)localObject).mkdir();
          }
          int j = arrayOfString.length;
          i = 0;
          if (i < j)
          {
            str = arrayOfString[i];
            if (!TextUtils.isEmpty(str))
            {
              localObject = new File(paramString2, str);
              if (!((File)localObject).exists()) {
                ((File)localObject).getParentFile().mkdirs();
              }
              str = paramString1 + File.separator + str;
              localObject = ((File)localObject).getAbsolutePath();
              if (localAssetManager.list(str).length == 0)
              {
                if (a(localAssetManager, str, (String)localObject)) {
                  break label261;
                }
                betc.d("[mini] AssetsUtil", String.format("copyAssetToFile from=%s, to=%s fail", new Object[] { str, localObject }));
                return false;
              }
            }
          }
        }
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          Object localObject;
          int i;
          String str;
          for (;;)
          {
            betc.d("[mini] AssetsUtil", String.format("copyFileOrDir assetsPath=%s, destPath=%s, exception", new Object[] { paramString1, paramString2 }), paramContext);
            try
            {
              if (!new File(paramString2).exists()) {
                break;
              }
              belh.a(paramString2, false);
              return false;
            }
            catch (Throwable paramContext)
            {
              return false;
            }
          }
          a(paramContext, str, (String)localObject);
          label261:
          i += 1;
        }
      }
    }
    return true;
  }
  
  /* Error */
  private static boolean a(AssetManager paramAssetManager, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 7
    //   9: new 104	java/io/FileOutputStream
    //   12: dup
    //   13: aload_2
    //   14: invokespecial 105	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   17: astore 4
    //   19: aload 4
    //   21: astore 6
    //   23: aload 8
    //   25: astore 5
    //   27: new 107	java/io/BufferedInputStream
    //   30: dup
    //   31: aload_0
    //   32: aload_1
    //   33: invokevirtual 111	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   36: invokespecial 114	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   39: astore_0
    //   40: sipush 8192
    //   43: newarray byte
    //   45: astore 5
    //   47: aload_0
    //   48: aload 5
    //   50: invokevirtual 118	java/io/BufferedInputStream:read	([B)I
    //   53: istore_3
    //   54: iload_3
    //   55: iconst_m1
    //   56: if_icmpeq +109 -> 165
    //   59: aload 4
    //   61: aload 5
    //   63: iconst_0
    //   64: iload_3
    //   65: invokevirtual 124	java/io/OutputStream:write	([BII)V
    //   68: goto -21 -> 47
    //   71: astore 5
    //   73: aload_0
    //   74: astore 7
    //   76: aload 5
    //   78: astore_0
    //   79: aload 4
    //   81: astore 6
    //   83: aload 7
    //   85: astore 5
    //   87: ldc 126
    //   89: new 51	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   96: ldc 128
    //   98: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload_1
    //   102: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: ldc 130
    //   107: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_2
    //   111: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: ldc 132
    //   116: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_0
    //   120: invokevirtual 135	java/io/IOException:getMessage	()Ljava/lang/String;
    //   123: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 87	betc:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: aload 7
    //   134: ifnull +8 -> 142
    //   137: aload 7
    //   139: invokevirtual 138	java/io/BufferedInputStream:close	()V
    //   142: aload 4
    //   144: ifnull +19 -> 163
    //   147: aload 4
    //   149: checkcast 104	java/io/FileOutputStream
    //   152: invokevirtual 142	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   155: invokevirtual 147	java/io/FileDescriptor:sync	()V
    //   158: aload 4
    //   160: invokevirtual 148	java/io/OutputStream:close	()V
    //   163: iconst_0
    //   164: ireturn
    //   165: aload_0
    //   166: ifnull +7 -> 173
    //   169: aload_0
    //   170: invokevirtual 138	java/io/BufferedInputStream:close	()V
    //   173: aload 4
    //   175: ifnull +19 -> 194
    //   178: aload 4
    //   180: checkcast 104	java/io/FileOutputStream
    //   183: invokevirtual 142	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   186: invokevirtual 147	java/io/FileDescriptor:sync	()V
    //   189: aload 4
    //   191: invokevirtual 148	java/io/OutputStream:close	()V
    //   194: iconst_1
    //   195: ireturn
    //   196: astore_0
    //   197: ldc 126
    //   199: new 51	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   206: ldc 128
    //   208: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload_1
    //   212: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: ldc 130
    //   217: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload_2
    //   221: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: ldc 132
    //   226: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload_0
    //   230: invokevirtual 135	java/io/IOException:getMessage	()Ljava/lang/String;
    //   233: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 87	betc:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   242: goto -69 -> 173
    //   245: astore_0
    //   246: ldc 126
    //   248: new 51	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   255: ldc 128
    //   257: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload_1
    //   261: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: ldc 130
    //   266: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload_2
    //   270: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: ldc 132
    //   275: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload_0
    //   279: invokevirtual 135	java/io/IOException:getMessage	()Ljava/lang/String;
    //   282: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokestatic 87	betc:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   291: goto -97 -> 194
    //   294: astore_0
    //   295: ldc 126
    //   297: new 51	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   304: ldc 128
    //   306: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: aload_1
    //   310: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: ldc 130
    //   315: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: aload_2
    //   319: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: ldc 132
    //   324: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: aload_0
    //   328: invokevirtual 135	java/io/IOException:getMessage	()Ljava/lang/String;
    //   331: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   337: invokestatic 87	betc:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   340: aload 4
    //   342: invokevirtual 148	java/io/OutputStream:close	()V
    //   345: goto -151 -> 194
    //   348: astore_0
    //   349: ldc 126
    //   351: new 51	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   358: ldc 128
    //   360: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: aload_1
    //   364: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: ldc 130
    //   369: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: aload_2
    //   373: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: ldc 132
    //   378: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: aload_0
    //   382: invokevirtual 135	java/io/IOException:getMessage	()Ljava/lang/String;
    //   385: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokestatic 87	betc:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   394: goto -200 -> 194
    //   397: astore_0
    //   398: aload 4
    //   400: invokevirtual 148	java/io/OutputStream:close	()V
    //   403: aload_0
    //   404: athrow
    //   405: astore 4
    //   407: ldc 126
    //   409: new 51	java/lang/StringBuilder
    //   412: dup
    //   413: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   416: ldc 128
    //   418: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: aload_1
    //   422: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: ldc 130
    //   427: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: aload_2
    //   431: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: ldc 132
    //   436: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: aload 4
    //   441: invokevirtual 135	java/io/IOException:getMessage	()Ljava/lang/String;
    //   444: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: invokestatic 87	betc:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   453: goto -50 -> 403
    //   456: astore_0
    //   457: ldc 126
    //   459: new 51	java/lang/StringBuilder
    //   462: dup
    //   463: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   466: ldc 128
    //   468: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: aload_1
    //   472: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: ldc 130
    //   477: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: aload_2
    //   481: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: ldc 132
    //   486: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: aload_0
    //   490: invokevirtual 135	java/io/IOException:getMessage	()Ljava/lang/String;
    //   493: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   499: invokestatic 87	betc:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   502: goto -360 -> 142
    //   505: astore_0
    //   506: ldc 126
    //   508: new 51	java/lang/StringBuilder
    //   511: dup
    //   512: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   515: ldc 128
    //   517: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: aload_1
    //   521: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: ldc 130
    //   526: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: aload_2
    //   530: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: ldc 132
    //   535: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: aload_0
    //   539: invokevirtual 135	java/io/IOException:getMessage	()Ljava/lang/String;
    //   542: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   548: invokestatic 87	betc:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   551: goto -388 -> 163
    //   554: astore_0
    //   555: ldc 126
    //   557: new 51	java/lang/StringBuilder
    //   560: dup
    //   561: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   564: ldc 128
    //   566: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: aload_1
    //   570: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: ldc 130
    //   575: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: aload_2
    //   579: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: ldc 132
    //   584: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: aload_0
    //   588: invokevirtual 135	java/io/IOException:getMessage	()Ljava/lang/String;
    //   591: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   597: invokestatic 87	betc:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   600: aload 4
    //   602: invokevirtual 148	java/io/OutputStream:close	()V
    //   605: goto -442 -> 163
    //   608: astore_0
    //   609: ldc 126
    //   611: new 51	java/lang/StringBuilder
    //   614: dup
    //   615: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   618: ldc 128
    //   620: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: aload_1
    //   624: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: ldc 130
    //   629: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: aload_2
    //   633: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: ldc 132
    //   638: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: aload_0
    //   642: invokevirtual 135	java/io/IOException:getMessage	()Ljava/lang/String;
    //   645: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   651: invokestatic 87	betc:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   654: goto -491 -> 163
    //   657: astore_0
    //   658: aload 4
    //   660: invokevirtual 148	java/io/OutputStream:close	()V
    //   663: aload_0
    //   664: athrow
    //   665: astore 4
    //   667: ldc 126
    //   669: new 51	java/lang/StringBuilder
    //   672: dup
    //   673: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   676: ldc 128
    //   678: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: aload_1
    //   682: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: ldc 130
    //   687: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: aload_2
    //   691: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   694: ldc 132
    //   696: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: aload 4
    //   701: invokevirtual 135	java/io/IOException:getMessage	()Ljava/lang/String;
    //   704: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   710: invokestatic 87	betc:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   713: goto -50 -> 663
    //   716: astore_0
    //   717: aconst_null
    //   718: astore 4
    //   720: aload 5
    //   722: ifnull +8 -> 730
    //   725: aload 5
    //   727: invokevirtual 138	java/io/BufferedInputStream:close	()V
    //   730: aload 4
    //   732: ifnull +19 -> 751
    //   735: aload 4
    //   737: checkcast 104	java/io/FileOutputStream
    //   740: invokevirtual 142	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   743: invokevirtual 147	java/io/FileDescriptor:sync	()V
    //   746: aload 4
    //   748: invokevirtual 148	java/io/OutputStream:close	()V
    //   751: aload_0
    //   752: athrow
    //   753: astore 5
    //   755: ldc 126
    //   757: new 51	java/lang/StringBuilder
    //   760: dup
    //   761: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   764: ldc 128
    //   766: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: aload_1
    //   770: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   773: ldc 130
    //   775: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   778: aload_2
    //   779: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   782: ldc 132
    //   784: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: aload 5
    //   789: invokevirtual 135	java/io/IOException:getMessage	()Ljava/lang/String;
    //   792: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   798: invokestatic 87	betc:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   801: goto -71 -> 730
    //   804: astore 4
    //   806: ldc 126
    //   808: new 51	java/lang/StringBuilder
    //   811: dup
    //   812: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   815: ldc 128
    //   817: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: aload_1
    //   821: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: ldc 130
    //   826: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   829: aload_2
    //   830: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   833: ldc 132
    //   835: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: aload 4
    //   840: invokevirtual 135	java/io/IOException:getMessage	()Ljava/lang/String;
    //   843: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   846: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   849: invokestatic 87	betc:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   852: goto -101 -> 751
    //   855: astore 5
    //   857: ldc 126
    //   859: new 51	java/lang/StringBuilder
    //   862: dup
    //   863: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   866: ldc 128
    //   868: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: aload_1
    //   872: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   875: ldc 130
    //   877: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   880: aload_2
    //   881: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   884: ldc 132
    //   886: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   889: aload 5
    //   891: invokevirtual 135	java/io/IOException:getMessage	()Ljava/lang/String;
    //   894: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   897: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   900: invokestatic 87	betc:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   903: aload 4
    //   905: invokevirtual 148	java/io/OutputStream:close	()V
    //   908: goto -157 -> 751
    //   911: astore 4
    //   913: ldc 126
    //   915: new 51	java/lang/StringBuilder
    //   918: dup
    //   919: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   922: ldc 128
    //   924: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   927: aload_1
    //   928: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   931: ldc 130
    //   933: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   936: aload_2
    //   937: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   940: ldc 132
    //   942: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   945: aload 4
    //   947: invokevirtual 135	java/io/IOException:getMessage	()Ljava/lang/String;
    //   950: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   953: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   956: invokestatic 87	betc:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   959: goto -208 -> 751
    //   962: astore_0
    //   963: aload 4
    //   965: invokevirtual 148	java/io/OutputStream:close	()V
    //   968: aload_0
    //   969: athrow
    //   970: astore 4
    //   972: ldc 126
    //   974: new 51	java/lang/StringBuilder
    //   977: dup
    //   978: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   981: ldc 128
    //   983: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   986: aload_1
    //   987: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   990: ldc 130
    //   992: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   995: aload_2
    //   996: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   999: ldc 132
    //   1001: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1004: aload 4
    //   1006: invokevirtual 135	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1009: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1012: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1015: invokestatic 87	betc:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1018: goto -50 -> 968
    //   1021: astore_0
    //   1022: aload 6
    //   1024: astore 4
    //   1026: goto -306 -> 720
    //   1029: astore 5
    //   1031: aload_0
    //   1032: astore 6
    //   1034: aload 5
    //   1036: astore_0
    //   1037: aload 6
    //   1039: astore 5
    //   1041: goto -321 -> 720
    //   1044: astore_0
    //   1045: aconst_null
    //   1046: astore 4
    //   1048: goto -969 -> 79
    //   1051: astore_0
    //   1052: goto -973 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1055	0	paramAssetManager	AssetManager
    //   0	1055	1	paramString1	String
    //   0	1055	2	paramString2	String
    //   53	12	3	i	int
    //   17	382	4	localFileOutputStream	java.io.FileOutputStream
    //   405	254	4	localIOException1	java.io.IOException
    //   665	35	4	localIOException2	java.io.IOException
    //   718	29	4	localObject1	Object
    //   804	100	4	localIOException3	java.io.IOException
    //   911	53	4	localIOException4	java.io.IOException
    //   970	35	4	localIOException5	java.io.IOException
    //   1024	23	4	localObject2	Object
    //   1	61	5	localObject3	Object
    //   71	6	5	localIOException6	java.io.IOException
    //   85	641	5	localObject4	Object
    //   753	35	5	localIOException7	java.io.IOException
    //   855	35	5	localIOException8	java.io.IOException
    //   1029	6	5	localObject5	Object
    //   1039	1	5	localObject6	Object
    //   21	1017	6	localObject7	Object
    //   7	131	7	localAssetManager	AssetManager
    //   4	20	8	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   40	47	71	java/io/IOException
    //   47	54	71	java/io/IOException
    //   59	68	71	java/io/IOException
    //   169	173	196	java/io/IOException
    //   189	194	245	java/io/IOException
    //   178	189	294	java/io/IOException
    //   340	345	348	java/io/IOException
    //   178	189	397	finally
    //   295	340	397	finally
    //   398	403	405	java/io/IOException
    //   137	142	456	java/io/IOException
    //   158	163	505	java/io/IOException
    //   147	158	554	java/io/IOException
    //   600	605	608	java/io/IOException
    //   147	158	657	finally
    //   555	600	657	finally
    //   658	663	665	java/io/IOException
    //   9	19	716	finally
    //   725	730	753	java/io/IOException
    //   746	751	804	java/io/IOException
    //   735	746	855	java/io/IOException
    //   903	908	911	java/io/IOException
    //   735	746	962	finally
    //   857	903	962	finally
    //   963	968	970	java/io/IOException
    //   27	40	1021	finally
    //   87	132	1021	finally
    //   40	47	1029	finally
    //   47	54	1029	finally
    //   59	68	1029	finally
    //   9	19	1044	java/io/IOException
    //   27	40	1051	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfgf
 * JD-Core Version:    0.7.0.1
 */