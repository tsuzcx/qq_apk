import java.io.InputStream;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;

public class bhhn
{
  public static String a(int paramInt)
  {
    if (paramInt == 1) {
      return "classes.dex";
    }
    return "classes" + paramInt + ".dex";
  }
  
  private static void a(JarOutputStream paramJarOutputStream, ZipEntry paramZipEntry, InputStream paramInputStream)
  {
    try
    {
      paramJarOutputStream.putNextEntry(paramZipEntry);
      paramZipEntry = new byte[1024];
      for (;;)
      {
        int i = paramInputStream.read(paramZipEntry);
        if (i == -1)
        {
          paramJarOutputStream.closeEntry();
          return;
        }
        paramJarOutputStream.write(paramZipEntry, 0, i);
      }
      return;
    }
    catch (Exception paramJarOutputStream) {}
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 35	java/util/jar/JarOutputStream
    //   6: dup
    //   7: new 55	java/io/FileOutputStream
    //   10: dup
    //   11: aload_2
    //   12: invokespecial 58	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   15: invokespecial 61	java/util/jar/JarOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore_2
    //   19: new 63	java/util/jar/JarFile
    //   22: dup
    //   23: new 65	java/io/File
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   31: invokespecial 69	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   34: astore 4
    //   36: new 63	java/util/jar/JarFile
    //   39: dup
    //   40: new 65	java/io/File
    //   43: dup
    //   44: aload_1
    //   45: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   48: invokespecial 69	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   51: astore_1
    //   52: new 71	java/util/HashSet
    //   55: dup
    //   56: invokespecial 72	java/util/HashSet:<init>	()V
    //   59: astore_0
    //   60: aload_1
    //   61: invokevirtual 76	java/util/jar/JarFile:entries	()Ljava/util/Enumeration;
    //   64: astore 5
    //   66: iconst_1
    //   67: istore_3
    //   68: aload 5
    //   70: invokeinterface 82 1 0
    //   75: ifeq +150 -> 225
    //   78: aload 5
    //   80: invokeinterface 86 1 0
    //   85: checkcast 88	java/util/jar/JarEntry
    //   88: astore 6
    //   90: aload 6
    //   92: invokevirtual 91	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   95: ldc 16
    //   97: invokevirtual 97	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   100: ifeq +67 -> 167
    //   103: aload 6
    //   105: invokevirtual 91	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   108: ldc 25
    //   110: invokevirtual 100	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   113: ifeq +54 -> 167
    //   116: new 102	java/util/zip/ZipEntry
    //   119: dup
    //   120: iload_3
    //   121: invokestatic 104	bhhn:a	(I)Ljava/lang/String;
    //   124: invokespecial 105	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   127: astore 7
    //   129: aload_1
    //   130: new 102	java/util/zip/ZipEntry
    //   133: dup
    //   134: aload 6
    //   136: invokevirtual 91	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   139: invokespecial 105	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   142: invokevirtual 109	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   145: astore 6
    //   147: aload_2
    //   148: aload 7
    //   150: aload 6
    //   152: invokestatic 111	bhhn:a	(Ljava/util/jar/JarOutputStream;Ljava/util/zip/ZipEntry;Ljava/io/InputStream;)V
    //   155: aload 6
    //   157: invokevirtual 114	java/io/InputStream:close	()V
    //   160: iload_3
    //   161: iconst_1
    //   162: iadd
    //   163: istore_3
    //   164: goto +496 -> 660
    //   167: aload_0
    //   168: aload 6
    //   170: invokevirtual 91	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   173: invokevirtual 118	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   176: pop
    //   177: new 102	java/util/zip/ZipEntry
    //   180: dup
    //   181: aload 6
    //   183: invokevirtual 91	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   186: invokespecial 105	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   189: astore 7
    //   191: aload_1
    //   192: new 102	java/util/zip/ZipEntry
    //   195: dup
    //   196: aload 6
    //   198: invokevirtual 91	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   201: invokespecial 105	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   204: invokevirtual 109	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   207: astore 6
    //   209: aload_2
    //   210: aload 7
    //   212: aload 6
    //   214: invokestatic 111	bhhn:a	(Ljava/util/jar/JarOutputStream;Ljava/util/zip/ZipEntry;Ljava/io/InputStream;)V
    //   217: aload 6
    //   219: invokevirtual 114	java/io/InputStream:close	()V
    //   222: goto +438 -> 660
    //   225: aload 4
    //   227: invokevirtual 76	java/util/jar/JarFile:entries	()Ljava/util/Enumeration;
    //   230: astore 5
    //   232: aload 5
    //   234: invokeinterface 82 1 0
    //   239: ifeq +186 -> 425
    //   242: aload 5
    //   244: invokeinterface 86 1 0
    //   249: checkcast 88	java/util/jar/JarEntry
    //   252: astore 6
    //   254: aload 6
    //   256: invokevirtual 91	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   259: ldc 16
    //   261: invokevirtual 97	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   264: ifeq +68 -> 332
    //   267: aload 6
    //   269: invokevirtual 91	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   272: ldc 25
    //   274: invokevirtual 100	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   277: ifeq +55 -> 332
    //   280: new 102	java/util/zip/ZipEntry
    //   283: dup
    //   284: iload_3
    //   285: invokestatic 104	bhhn:a	(I)Ljava/lang/String;
    //   288: invokespecial 105	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   291: astore 7
    //   293: aload 4
    //   295: new 102	java/util/zip/ZipEntry
    //   298: dup
    //   299: aload 6
    //   301: invokevirtual 91	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   304: invokespecial 105	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   307: invokevirtual 109	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   310: astore 6
    //   312: aload_2
    //   313: aload 7
    //   315: aload 6
    //   317: invokestatic 111	bhhn:a	(Ljava/util/jar/JarOutputStream;Ljava/util/zip/ZipEntry;Ljava/io/InputStream;)V
    //   320: aload 6
    //   322: invokevirtual 114	java/io/InputStream:close	()V
    //   325: iload_3
    //   326: iconst_1
    //   327: iadd
    //   328: istore_3
    //   329: goto +334 -> 663
    //   332: aload_0
    //   333: aload 6
    //   335: invokevirtual 91	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   338: invokevirtual 121	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   341: ifne +52 -> 393
    //   344: new 102	java/util/zip/ZipEntry
    //   347: dup
    //   348: aload 6
    //   350: invokevirtual 91	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   353: invokespecial 105	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   356: astore 7
    //   358: aload 4
    //   360: new 102	java/util/zip/ZipEntry
    //   363: dup
    //   364: aload 6
    //   366: invokevirtual 91	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   369: invokespecial 105	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   372: invokevirtual 109	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   375: astore 6
    //   377: aload_2
    //   378: aload 7
    //   380: aload 6
    //   382: invokestatic 111	bhhn:a	(Ljava/util/jar/JarOutputStream;Ljava/util/zip/ZipEntry;Ljava/io/InputStream;)V
    //   385: aload 6
    //   387: invokevirtual 114	java/io/InputStream:close	()V
    //   390: goto +273 -> 663
    //   393: getstatic 127	java/lang/System:out	Ljava/io/PrintStream;
    //   396: new 10	java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   403: ldc 129
    //   405: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: aload 6
    //   410: invokevirtual 91	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   413: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: invokevirtual 29	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: invokevirtual 134	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   422: goto +241 -> 663
    //   425: aload_2
    //   426: ifnull +7 -> 433
    //   429: aload_2
    //   430: invokevirtual 135	java/util/jar/JarOutputStream:close	()V
    //   433: aload 4
    //   435: ifnull +8 -> 443
    //   438: aload 4
    //   440: invokevirtual 136	java/util/jar/JarFile:close	()V
    //   443: aload_1
    //   444: ifnull +7 -> 451
    //   447: aload_1
    //   448: invokevirtual 136	java/util/jar/JarFile:close	()V
    //   451: iconst_1
    //   452: ireturn
    //   453: astore_2
    //   454: aconst_null
    //   455: astore_0
    //   456: aconst_null
    //   457: astore_1
    //   458: aload 5
    //   460: astore 4
    //   462: aload_2
    //   463: invokevirtual 139	java/lang/Exception:printStackTrace	()V
    //   466: aload_1
    //   467: ifnull +7 -> 474
    //   470: aload_1
    //   471: invokevirtual 135	java/util/jar/JarOutputStream:close	()V
    //   474: aload_0
    //   475: ifnull +7 -> 482
    //   478: aload_0
    //   479: invokevirtual 136	java/util/jar/JarFile:close	()V
    //   482: aload 4
    //   484: ifnull +8 -> 492
    //   487: aload 4
    //   489: invokevirtual 136	java/util/jar/JarFile:close	()V
    //   492: iconst_0
    //   493: ireturn
    //   494: astore_0
    //   495: aconst_null
    //   496: astore_1
    //   497: aconst_null
    //   498: astore 4
    //   500: aconst_null
    //   501: astore_2
    //   502: aload_2
    //   503: ifnull +7 -> 510
    //   506: aload_2
    //   507: invokevirtual 135	java/util/jar/JarOutputStream:close	()V
    //   510: aload 4
    //   512: ifnull +8 -> 520
    //   515: aload 4
    //   517: invokevirtual 136	java/util/jar/JarFile:close	()V
    //   520: aload_1
    //   521: ifnull +7 -> 528
    //   524: aload_1
    //   525: invokevirtual 136	java/util/jar/JarFile:close	()V
    //   528: aload_0
    //   529: athrow
    //   530: astore_0
    //   531: goto -98 -> 433
    //   534: astore_0
    //   535: goto -92 -> 443
    //   538: astore_0
    //   539: goto -88 -> 451
    //   542: astore_1
    //   543: goto -69 -> 474
    //   546: astore_0
    //   547: goto -65 -> 482
    //   550: astore_0
    //   551: goto -59 -> 492
    //   554: astore_2
    //   555: goto -45 -> 510
    //   558: astore_2
    //   559: goto -39 -> 520
    //   562: astore_1
    //   563: goto -35 -> 528
    //   566: astore_0
    //   567: aconst_null
    //   568: astore_1
    //   569: aconst_null
    //   570: astore 4
    //   572: goto -70 -> 502
    //   575: astore_0
    //   576: aconst_null
    //   577: astore_1
    //   578: goto -76 -> 502
    //   581: astore_0
    //   582: goto -80 -> 502
    //   585: astore 6
    //   587: aload_0
    //   588: astore_2
    //   589: aload_1
    //   590: astore 5
    //   592: aload 4
    //   594: astore_1
    //   595: aload 6
    //   597: astore_0
    //   598: aload_2
    //   599: astore 4
    //   601: aload 5
    //   603: astore_2
    //   604: goto -102 -> 502
    //   607: astore 4
    //   609: aconst_null
    //   610: astore_0
    //   611: aload_2
    //   612: astore_1
    //   613: aload 4
    //   615: astore_2
    //   616: aload 5
    //   618: astore 4
    //   620: goto -158 -> 462
    //   623: astore 6
    //   625: aload 4
    //   627: astore_0
    //   628: aload_2
    //   629: astore_1
    //   630: aload 6
    //   632: astore_2
    //   633: aload 5
    //   635: astore 4
    //   637: goto -175 -> 462
    //   640: astore 6
    //   642: aload 4
    //   644: astore_0
    //   645: aload_2
    //   646: astore 5
    //   648: aload 6
    //   650: astore_2
    //   651: aload_1
    //   652: astore 4
    //   654: aload 5
    //   656: astore_1
    //   657: goto -195 -> 462
    //   660: goto -592 -> 68
    //   663: goto -431 -> 232
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	666	0	paramString1	String
    //   0	666	1	paramString2	String
    //   0	666	2	paramString3	String
    //   67	262	3	i	int
    //   34	566	4	localObject1	Object
    //   607	7	4	localException1	Exception
    //   618	35	4	localObject2	Object
    //   1	654	5	localObject3	Object
    //   88	321	6	localObject4	Object
    //   585	11	6	localObject5	Object
    //   623	8	6	localException2	Exception
    //   640	9	6	localException3	Exception
    //   127	252	7	localZipEntry	ZipEntry
    // Exception table:
    //   from	to	target	type
    //   3	19	453	java/lang/Exception
    //   3	19	494	finally
    //   429	433	530	java/lang/Exception
    //   438	443	534	java/lang/Exception
    //   447	451	538	java/lang/Exception
    //   470	474	542	java/lang/Exception
    //   478	482	546	java/lang/Exception
    //   487	492	550	java/lang/Exception
    //   506	510	554	java/lang/Exception
    //   515	520	558	java/lang/Exception
    //   524	528	562	java/lang/Exception
    //   19	36	566	finally
    //   36	52	575	finally
    //   52	66	581	finally
    //   68	160	581	finally
    //   167	222	581	finally
    //   225	232	581	finally
    //   232	325	581	finally
    //   332	390	581	finally
    //   393	422	581	finally
    //   462	466	585	finally
    //   19	36	607	java/lang/Exception
    //   36	52	623	java/lang/Exception
    //   52	66	640	java/lang/Exception
    //   68	160	640	java/lang/Exception
    //   167	222	640	java/lang/Exception
    //   225	232	640	java/lang/Exception
    //   232	325	640	java/lang/Exception
    //   332	390	640	java/lang/Exception
    //   393	422	640	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhhn
 * JD-Core Version:    0.7.0.1
 */