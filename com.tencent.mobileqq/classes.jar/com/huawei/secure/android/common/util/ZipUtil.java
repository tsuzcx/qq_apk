package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipInputStream;

public class ZipUtil
{
  private static final String A = "..\\";
  private static final String TAG = "ZipUtil";
  private static final int w = 104857600;
  private static final int x = 100;
  private static final int y = 4096;
  private static final String z = "../";
  
  private static void a(File paramFile)
  {
    if (paramFile == null) {}
    do
    {
      return;
      if (paramFile.isFile())
      {
        b(paramFile);
        return;
      }
    } while (!paramFile.isDirectory());
    File[] arrayOfFile = paramFile.listFiles();
    if ((arrayOfFile == null) || (arrayOfFile.length == 0))
    {
      b(paramFile);
      return;
    }
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      a(arrayOfFile[i]);
      i += 1;
    }
    b(paramFile);
  }
  
  private static void a(FileInputStream paramFileInputStream, BufferedOutputStream paramBufferedOutputStream, ZipInputStream paramZipInputStream, FileOutputStream paramFileOutputStream)
  {
    IOUtil.closeSecure(paramFileInputStream);
    IOUtil.closeSecure(paramBufferedOutputStream);
    IOUtil.closeSecure(paramZipInputStream);
    IOUtil.closeSecure(paramFileOutputStream);
  }
  
  /* Error */
  private static boolean a(String paramString, long paramLong, int paramInt)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 5
    //   3: new 61	java/util/zip/ZipFile
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 64	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   11: astore 8
    //   13: aload 8
    //   15: astore_0
    //   16: aload 8
    //   18: invokevirtual 68	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   21: astore 9
    //   23: iconst_0
    //   24: istore 4
    //   26: aload 8
    //   28: astore_0
    //   29: aload 9
    //   31: invokeinterface 73 1 0
    //   36: ifeq +212 -> 248
    //   39: aload 8
    //   41: astore_0
    //   42: aload 9
    //   44: invokeinterface 77 1 0
    //   49: checkcast 79	java/util/zip/ZipEntry
    //   52: astore 10
    //   54: aload 8
    //   56: astore_0
    //   57: lload 5
    //   59: aload 10
    //   61: invokevirtual 83	java/util/zip/ZipEntry:getSize	()J
    //   64: ladd
    //   65: lstore 5
    //   67: iload 4
    //   69: iconst_1
    //   70: iadd
    //   71: istore 4
    //   73: aload 8
    //   75: astore_0
    //   76: aload 10
    //   78: invokevirtual 87	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   81: invokestatic 91	com/huawei/secure/android/common/util/ZipUtil:d	(Ljava/lang/String;)Z
    //   84: ifne +31 -> 115
    //   87: iload 4
    //   89: iload_3
    //   90: if_icmpge +25 -> 115
    //   93: lload 5
    //   95: lload_1
    //   96: lcmp
    //   97: ifgt +18 -> 115
    //   100: aload 8
    //   102: astore_0
    //   103: aload 10
    //   105: invokevirtual 83	java/util/zip/ZipEntry:getSize	()J
    //   108: ldc2_w 92
    //   111: lcmp
    //   112: ifne -86 -> 26
    //   115: aload 8
    //   117: astore_0
    //   118: ldc 11
    //   120: ldc 95
    //   122: invokestatic 101	com/huawei/secure/android/common/util/LogsUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: iconst_0
    //   126: istore 7
    //   128: aload 8
    //   130: ifnull +8 -> 138
    //   133: aload 8
    //   135: invokevirtual 104	java/util/zip/ZipFile:close	()V
    //   138: iload 7
    //   140: ireturn
    //   141: astore_0
    //   142: ldc 11
    //   144: ldc 106
    //   146: invokestatic 101	com/huawei/secure/android/common/util/LogsUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: iload 7
    //   151: ireturn
    //   152: astore 9
    //   154: aconst_null
    //   155: astore 8
    //   157: aload 8
    //   159: astore_0
    //   160: ldc 11
    //   162: new 108	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   169: ldc 111
    //   171: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload 9
    //   176: invokevirtual 118	java/io/IOException:getMessage	()Ljava/lang/String;
    //   179: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 101	com/huawei/secure/android/common/util/LogsUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: aload 8
    //   190: ifnull +56 -> 246
    //   193: aload 8
    //   195: invokevirtual 104	java/util/zip/ZipFile:close	()V
    //   198: iconst_0
    //   199: ireturn
    //   200: astore_0
    //   201: ldc 11
    //   203: ldc 106
    //   205: invokestatic 101	com/huawei/secure/android/common/util/LogsUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: iconst_0
    //   209: ireturn
    //   210: astore 8
    //   212: aconst_null
    //   213: astore_0
    //   214: aload_0
    //   215: ifnull +7 -> 222
    //   218: aload_0
    //   219: invokevirtual 104	java/util/zip/ZipFile:close	()V
    //   222: aload 8
    //   224: athrow
    //   225: astore_0
    //   226: ldc 11
    //   228: ldc 106
    //   230: invokestatic 101	com/huawei/secure/android/common/util/LogsUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   233: goto -11 -> 222
    //   236: astore 8
    //   238: goto -24 -> 214
    //   241: astore 9
    //   243: goto -86 -> 157
    //   246: iconst_0
    //   247: ireturn
    //   248: iconst_1
    //   249: istore 7
    //   251: goto -123 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	paramString	String
    //   0	254	1	paramLong	long
    //   0	254	3	paramInt	int
    //   24	67	4	i	int
    //   1	93	5	l	long
    //   126	124	7	bool	boolean
    //   11	183	8	localZipFile	java.util.zip.ZipFile
    //   210	13	8	localObject1	Object
    //   236	1	8	localObject2	Object
    //   21	22	9	localEnumeration	java.util.Enumeration
    //   152	23	9	localIOException1	java.io.IOException
    //   241	1	9	localIOException2	java.io.IOException
    //   52	52	10	localZipEntry	java.util.zip.ZipEntry
    // Exception table:
    //   from	to	target	type
    //   133	138	141	java/io/IOException
    //   3	13	152	java/io/IOException
    //   193	198	200	java/io/IOException
    //   3	13	210	finally
    //   218	222	225	java/io/IOException
    //   16	23	236	finally
    //   29	39	236	finally
    //   42	54	236	finally
    //   57	67	236	finally
    //   76	87	236	finally
    //   103	115	236	finally
    //   118	125	236	finally
    //   160	188	236	finally
    //   16	23	241	java/io/IOException
    //   29	39	241	java/io/IOException
    //   42	54	241	java/io/IOException
    //   57	67	241	java/io/IOException
    //   76	87	241	java/io/IOException
    //   103	115	241	java/io/IOException
    //   118	125	241	java/io/IOException
  }
  
  private static boolean a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString1)) || (d(paramString1)))
    {
      LogsUtil.e("ZipUtil", "zip file is not valid");
      return false;
    }
    if ((TextUtils.isEmpty(paramString2)) || (d(paramString2)))
    {
      LogsUtil.e("ZipUtil", "target directory is not valid");
      return false;
    }
    if (!a(paramString1, paramLong, paramInt))
    {
      LogsUtil.e("ZipUtil", "zip file contains valid chars or too many files");
      throw new SecurityCommonException("unsecure zipfile!");
    }
    return true;
  }
  
  private static boolean a(List<File> paramList)
  {
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((File)paramList.next());
      }
      return true;
    }
    catch (Exception paramList)
    {
      LogsUtil.e("ZipUtil", "unzip fail delete file failed" + paramList.getMessage());
      return false;
    }
  }
  
  private static void b(File paramFile)
  {
    if (paramFile == null) {}
    while (paramFile.delete()) {
      return;
    }
    LogsUtil.e("ZipUtil", "delete file error");
  }
  
  private static void c(File paramFile)
  {
    if ((paramFile == null) || (paramFile.exists())) {}
    while (paramFile.mkdirs()) {
      return;
    }
    LogsUtil.e("ZipUtil", "mkdirs error , files exists or IOException.");
  }
  
  private static boolean d(String paramString)
  {
    return (paramString.contains("../")) || (paramString.contains("..\\")) || (paramString.contains("..")) || (paramString.contains("./")) || (paramString.contains(".\\.\\")) || (paramString.contains("%00"));
  }
  
  /* Error */
  public static boolean unZip(String paramString1, String paramString2, long paramLong, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: lload_2
    //   3: iload 4
    //   5: invokestatic 194	com/huawei/secure/android/common/util/ZipUtil:a	(Ljava/lang/String;Ljava/lang/String;JI)Z
    //   8: ifne +9 -> 17
    //   11: iconst_0
    //   12: istore 7
    //   14: iload 7
    //   16: ireturn
    //   17: aload_1
    //   18: astore 12
    //   20: aload_1
    //   21: getstatic 197	java/io/File:separator	Ljava/lang/String;
    //   24: invokevirtual 200	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   27: ifeq +37 -> 64
    //   30: aload_1
    //   31: astore 12
    //   33: aload_1
    //   34: invokevirtual 204	java/lang/String:length	()I
    //   37: getstatic 197	java/io/File:separator	Ljava/lang/String;
    //   40: invokevirtual 204	java/lang/String:length	()I
    //   43: if_icmple +21 -> 64
    //   46: aload_1
    //   47: iconst_0
    //   48: aload_1
    //   49: invokevirtual 204	java/lang/String:length	()I
    //   52: getstatic 197	java/io/File:separator	Ljava/lang/String;
    //   55: invokevirtual 204	java/lang/String:length	()I
    //   58: isub
    //   59: invokevirtual 208	java/lang/String:substring	(II)Ljava/lang/String;
    //   62: astore 12
    //   64: iconst_1
    //   65: istore 7
    //   67: sipush 4096
    //   70: newarray byte
    //   72: astore 17
    //   74: aconst_null
    //   75: astore 8
    //   77: aconst_null
    //   78: astore 15
    //   80: aconst_null
    //   81: astore 10
    //   83: aconst_null
    //   84: astore 11
    //   86: aconst_null
    //   87: astore 13
    //   89: aconst_null
    //   90: astore 9
    //   92: aconst_null
    //   93: astore 14
    //   95: new 210	java/util/ArrayList
    //   98: dup
    //   99: invokespecial 211	java/util/ArrayList:<init>	()V
    //   102: astore 16
    //   104: new 213	java/io/FileInputStream
    //   107: dup
    //   108: aload_0
    //   109: invokespecial 214	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   112: astore_1
    //   113: new 216	java/util/zip/ZipInputStream
    //   116: dup
    //   117: new 218	java/io/BufferedInputStream
    //   120: dup
    //   121: aload_1
    //   122: invokespecial 220	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   125: invokespecial 221	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   128: astore 10
    //   130: aload 15
    //   132: astore 8
    //   134: aload 14
    //   136: astore 11
    //   138: aload 10
    //   140: invokevirtual 225	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   143: astore_0
    //   144: aload_0
    //   145: ifnull +208 -> 353
    //   148: new 30	java/io/File
    //   151: dup
    //   152: aload 12
    //   154: aload_0
    //   155: invokevirtual 87	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   158: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: astore 13
    //   163: iload 5
    //   165: ifeq +16 -> 181
    //   168: aload 13
    //   170: invokevirtual 172	java/io/File:exists	()Z
    //   173: ifeq +8 -> 181
    //   176: aload 13
    //   178: invokestatic 46	com/huawei/secure/android/common/util/ZipUtil:a	(Ljava/io/File;)V
    //   181: aload_0
    //   182: invokevirtual 228	java/util/zip/ZipEntry:isDirectory	()Z
    //   185: ifeq +40 -> 225
    //   188: aload 13
    //   190: invokestatic 230	com/huawei/secure/android/common/util/ZipUtil:c	(Ljava/io/File;)V
    //   193: aload 16
    //   195: aload 13
    //   197: invokeinterface 234 2 0
    //   202: pop
    //   203: aload 8
    //   205: astore_0
    //   206: aload 11
    //   208: astore 8
    //   210: aload 10
    //   212: invokevirtual 237	java/util/zip/ZipInputStream:closeEntry	()V
    //   215: aload 8
    //   217: astore 11
    //   219: aload_0
    //   220: astore 8
    //   222: goto -84 -> 138
    //   225: aload 13
    //   227: invokevirtual 241	java/io/File:getParentFile	()Ljava/io/File;
    //   230: astore_0
    //   231: aload_0
    //   232: ifnull +14 -> 246
    //   235: aload_0
    //   236: invokevirtual 172	java/io/File:exists	()Z
    //   239: ifne +7 -> 246
    //   242: aload_0
    //   243: invokestatic 230	com/huawei/secure/android/common/util/ZipUtil:c	(Ljava/io/File;)V
    //   246: new 243	java/io/FileOutputStream
    //   249: dup
    //   250: aload 13
    //   252: invokespecial 245	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   255: astore_0
    //   256: new 247	java/io/BufferedOutputStream
    //   259: dup
    //   260: aload_0
    //   261: invokespecial 249	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   264: astore 9
    //   266: iconst_0
    //   267: istore 4
    //   269: iload 4
    //   271: sipush 4096
    //   274: iadd
    //   275: i2l
    //   276: lload_2
    //   277: lcmp
    //   278: ifgt +42 -> 320
    //   281: aload 10
    //   283: aload 17
    //   285: iconst_0
    //   286: sipush 4096
    //   289: invokevirtual 253	java/util/zip/ZipInputStream:read	([BII)I
    //   292: istore 6
    //   294: iload 6
    //   296: iconst_m1
    //   297: if_icmpeq +23 -> 320
    //   300: aload 9
    //   302: aload 17
    //   304: iconst_0
    //   305: iload 6
    //   307: invokevirtual 257	java/io/BufferedOutputStream:write	([BII)V
    //   310: iload 4
    //   312: iload 6
    //   314: iadd
    //   315: istore 4
    //   317: goto -48 -> 269
    //   320: aload 16
    //   322: aload 13
    //   324: invokeinterface 234 2 0
    //   329: pop
    //   330: aload 9
    //   332: invokevirtual 260	java/io/BufferedOutputStream:flush	()V
    //   335: aload 9
    //   337: invokestatic 56	com/huawei/secure/android/common/util/IOUtil:closeSecure	(Ljava/io/OutputStream;)V
    //   340: aload_0
    //   341: invokestatic 56	com/huawei/secure/android/common/util/IOUtil:closeSecure	(Ljava/io/OutputStream;)V
    //   344: aload_0
    //   345: astore 8
    //   347: aload 9
    //   349: astore_0
    //   350: goto -140 -> 210
    //   353: aload 10
    //   355: invokestatic 53	com/huawei/secure/android/common/util/IOUtil:closeSecure	(Ljava/io/InputStream;)V
    //   358: aload_1
    //   359: invokestatic 53	com/huawei/secure/android/common/util/IOUtil:closeSecure	(Ljava/io/InputStream;)V
    //   362: aload_1
    //   363: aload 8
    //   365: aload 10
    //   367: aload 11
    //   369: invokestatic 262	com/huawei/secure/android/common/util/ZipUtil:a	(Ljava/io/FileInputStream;Ljava/io/BufferedOutputStream;Ljava/util/zip/ZipInputStream;Ljava/io/FileOutputStream;)V
    //   372: iload 7
    //   374: istore 5
    //   376: iload 5
    //   378: istore 7
    //   380: iload 5
    //   382: ifne -368 -> 14
    //   385: aload 16
    //   387: invokestatic 264	com/huawei/secure/android/common/util/ZipUtil:a	(Ljava/util/List;)Z
    //   390: pop
    //   391: iload 5
    //   393: ireturn
    //   394: astore 9
    //   396: aconst_null
    //   397: astore_1
    //   398: aload 10
    //   400: astore_0
    //   401: aload 11
    //   403: astore 10
    //   405: aload 13
    //   407: astore 8
    //   409: ldc 11
    //   411: new 108	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   418: ldc_w 266
    //   421: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: aload 9
    //   426: invokevirtual 118	java/io/IOException:getMessage	()Ljava/lang/String;
    //   429: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokestatic 101	com/huawei/secure/android/common/util/LogsUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   438: aload_0
    //   439: aload_1
    //   440: aload 10
    //   442: aload 8
    //   444: invokestatic 262	com/huawei/secure/android/common/util/ZipUtil:a	(Ljava/io/FileInputStream;Ljava/io/BufferedOutputStream;Ljava/util/zip/ZipInputStream;Ljava/io/FileOutputStream;)V
    //   447: iconst_0
    //   448: istore 5
    //   450: goto -74 -> 376
    //   453: astore_0
    //   454: aconst_null
    //   455: astore_1
    //   456: aconst_null
    //   457: astore 10
    //   459: aload_1
    //   460: aload 8
    //   462: aload 10
    //   464: aload 9
    //   466: invokestatic 262	com/huawei/secure/android/common/util/ZipUtil:a	(Ljava/io/FileInputStream;Ljava/io/BufferedOutputStream;Ljava/util/zip/ZipInputStream;Ljava/io/FileOutputStream;)V
    //   469: aload_0
    //   470: athrow
    //   471: astore_0
    //   472: aconst_null
    //   473: astore 10
    //   475: goto -16 -> 459
    //   478: astore 11
    //   480: aload 9
    //   482: astore 8
    //   484: aload_0
    //   485: astore 9
    //   487: aload 11
    //   489: astore_0
    //   490: goto -31 -> 459
    //   493: astore 9
    //   495: aload_0
    //   496: astore 11
    //   498: aload 9
    //   500: astore_0
    //   501: aload 8
    //   503: astore 9
    //   505: aload 11
    //   507: astore 8
    //   509: goto -50 -> 459
    //   512: astore_0
    //   513: aload 11
    //   515: astore 9
    //   517: goto -58 -> 459
    //   520: astore 11
    //   522: aload_0
    //   523: astore 9
    //   525: aload 11
    //   527: astore_0
    //   528: goto -69 -> 459
    //   531: astore 9
    //   533: aload_1
    //   534: astore 11
    //   536: aload_0
    //   537: astore_1
    //   538: aload 9
    //   540: astore_0
    //   541: aload 8
    //   543: astore 9
    //   545: aload 11
    //   547: astore 8
    //   549: goto -90 -> 459
    //   552: astore 9
    //   554: aload_1
    //   555: astore_0
    //   556: aconst_null
    //   557: astore_1
    //   558: aload 13
    //   560: astore 8
    //   562: aload 11
    //   564: astore 10
    //   566: goto -157 -> 409
    //   569: astore 8
    //   571: aload 9
    //   573: astore 11
    //   575: aload 8
    //   577: astore 9
    //   579: aload_0
    //   580: astore 8
    //   582: aload_1
    //   583: astore_0
    //   584: aload 11
    //   586: astore_1
    //   587: goto -178 -> 409
    //   590: astore 9
    //   592: aload_0
    //   593: astore 11
    //   595: aload_1
    //   596: astore_0
    //   597: aload 11
    //   599: astore_1
    //   600: goto -191 -> 409
    //   603: astore 9
    //   605: aload_1
    //   606: astore_0
    //   607: aload 8
    //   609: astore_1
    //   610: aload 11
    //   612: astore 8
    //   614: goto -205 -> 409
    //   617: astore 9
    //   619: aload 8
    //   621: astore 11
    //   623: aload_0
    //   624: astore 8
    //   626: aload_1
    //   627: astore_0
    //   628: aload 11
    //   630: astore_1
    //   631: goto -222 -> 409
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	634	0	paramString1	String
    //   0	634	1	paramString2	String
    //   0	634	2	paramLong	long
    //   0	634	4	paramInt	int
    //   0	634	5	paramBoolean	boolean
    //   292	23	6	i	int
    //   12	367	7	bool	boolean
    //   75	486	8	localObject1	Object
    //   569	7	8	localIOException1	java.io.IOException
    //   580	45	8	localObject2	Object
    //   90	258	9	localBufferedOutputStream	BufferedOutputStream
    //   394	87	9	localIOException2	java.io.IOException
    //   485	1	9	str1	String
    //   493	6	9	localObject3	Object
    //   503	21	9	localObject4	Object
    //   531	8	9	localObject5	Object
    //   543	1	9	localObject6	Object
    //   552	20	9	localIOException3	java.io.IOException
    //   577	1	9	localIOException4	java.io.IOException
    //   590	1	9	localIOException5	java.io.IOException
    //   603	1	9	localIOException6	java.io.IOException
    //   617	1	9	localIOException7	java.io.IOException
    //   81	484	10	localObject7	Object
    //   84	318	11	localObject8	Object
    //   478	10	11	localObject9	Object
    //   496	18	11	str2	String
    //   520	6	11	localObject10	Object
    //   534	95	11	localObject11	Object
    //   18	135	12	str3	String
    //   87	472	13	localFile	File
    //   93	42	14	localObject12	Object
    //   78	53	15	localObject13	Object
    //   102	284	16	localArrayList	java.util.ArrayList
    //   72	231	17	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   104	113	394	java/io/IOException
    //   104	113	453	finally
    //   113	130	471	finally
    //   281	294	478	finally
    //   300	310	478	finally
    //   320	344	478	finally
    //   210	215	493	finally
    //   138	144	512	finally
    //   148	163	512	finally
    //   168	181	512	finally
    //   181	203	512	finally
    //   225	231	512	finally
    //   235	246	512	finally
    //   246	256	512	finally
    //   353	362	512	finally
    //   256	266	520	finally
    //   409	438	531	finally
    //   113	130	552	java/io/IOException
    //   281	294	569	java/io/IOException
    //   300	310	569	java/io/IOException
    //   320	344	569	java/io/IOException
    //   210	215	590	java/io/IOException
    //   138	144	603	java/io/IOException
    //   148	163	603	java/io/IOException
    //   168	181	603	java/io/IOException
    //   181	203	603	java/io/IOException
    //   225	231	603	java/io/IOException
    //   235	246	603	java/io/IOException
    //   246	256	603	java/io/IOException
    //   353	362	603	java/io/IOException
    //   256	266	617	java/io/IOException
  }
  
  public static boolean unZip(String paramString1, String paramString2, boolean paramBoolean)
  {
    return unZip(paramString1, paramString2, 104857600L, 100, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.util.ZipUtil
 * JD-Core Version:    0.7.0.1
 */