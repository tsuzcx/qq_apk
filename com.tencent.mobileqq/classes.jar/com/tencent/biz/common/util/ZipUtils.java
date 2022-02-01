package com.tencent.biz.common.util;

import android.text.TextUtils;
import com.tencent.commonsdk.zip.QZipFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;

public class ZipUtils
{
  protected static final int BUFF_SIZE = 1048576;
  private static final String TAG = "ZipUtils";
  private static ZipUtils.UnzipCallback sUnzipCallback;
  
  public static Enumeration<?> getEntriesEnumeration(File paramFile)
  {
    return new QZipFile(paramFile).entries();
  }
  
  public static ArrayList<String> getEntriesNames(File paramFile)
  {
    ArrayList localArrayList = new ArrayList();
    paramFile = getEntriesEnumeration(paramFile);
    while (paramFile.hasMoreElements()) {
      localArrayList.add(new String(getEntryName((ZipEntry)paramFile.nextElement()).getBytes("GB2312"), "8859_1"));
    }
    return localArrayList;
  }
  
  public static String getEntryComment(ZipEntry paramZipEntry)
  {
    return new String(paramZipEntry.getComment().getBytes("GB2312"), "8859_1");
  }
  
  public static String getEntryName(ZipEntry paramZipEntry)
  {
    return new String(paramZipEntry.getName().getBytes("GB2312"), "8859_1");
  }
  
  public static long getUncompressedFileSize(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1L;
    }
    try
    {
      paramString = new QZipFile(paramString).entries();
      long l1 = 0L;
      while (paramString.hasMoreElements())
      {
        ZipEntry localZipEntry = (ZipEntry)paramString.nextElement();
        if (!localZipEntry.isDirectory())
        {
          long l2 = localZipEntry.getSize();
          l1 += l2;
        }
      }
      return l1;
    }
    catch (Exception paramString) {}
    return -1L;
  }
  
  public static ZipUtils.UnzipCallback getUnzipCallback()
  {
    return sUnzipCallback;
  }
  
  public static File newFile(File paramFile, ZipEntry paramZipEntry)
  {
    try
    {
      File localFile = new File(paramFile, paramZipEntry.getName());
      try
      {
        paramFile = paramFile.getCanonicalPath();
        String str = localFile.getCanonicalPath();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramFile);
        localStringBuilder.append(File.separator);
        if (str.startsWith(localStringBuilder.toString())) {
          return localFile;
        }
        paramFile = new StringBuilder();
        paramFile.append("Entry is outside of the target dir: ");
        paramFile.append(paramZipEntry.getName());
        throw new IOException(paramFile.toString());
      }
      catch (Throwable paramZipEntry)
      {
        paramFile = localFile;
      }
      paramZipEntry.printStackTrace();
    }
    catch (Throwable paramZipEntry)
    {
      paramFile = null;
    }
    return paramFile;
  }
  
  public static void setUnzipCallback(ZipUtils.UnzipCallback paramUnzipCallback)
  {
    sUnzipCallback = paramUnzipCallback;
  }
  
  /* Error */
  public static void unZipFile(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokestatic 149	com/tencent/biz/common/util/ZipUtils:unzipStartNotice	(Ljava/io/File;Ljava/lang/String;)V
    //   5: new 22	com/tencent/commonsdk/zip/QZipFile
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 25	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/io/File;)V
    //   13: astore 5
    //   15: aload 5
    //   17: invokevirtual 29	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   20: astore 6
    //   22: sipush 8192
    //   25: newarray byte
    //   27: astore 7
    //   29: aload 6
    //   31: invokeinterface 44 1 0
    //   36: ifeq +353 -> 389
    //   39: aload 6
    //   41: invokeinterface 50 1 0
    //   46: checkcast 52	java/util/zip/ZipEntry
    //   49: astore 8
    //   51: aload 8
    //   53: invokevirtual 80	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   56: ldc 151
    //   58: invokevirtual 154	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   61: ifeq +6 -> 67
    //   64: goto -35 -> 29
    //   67: aload 8
    //   69: invokevirtual 98	java/util/zip/ZipEntry:isDirectory	()Z
    //   72: ifeq +139 -> 211
    //   75: invokestatic 159	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   78: ifeq +38 -> 116
    //   81: new 120	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   88: astore_0
    //   89: aload_0
    //   90: ldc 161
    //   92: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload_0
    //   97: aload 8
    //   99: invokevirtual 80	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   102: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: ldc 163
    //   108: iconst_4
    //   109: aload_0
    //   110: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   116: new 120	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   123: astore_0
    //   124: aload_0
    //   125: aload_1
    //   126: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload_0
    //   131: aload 8
    //   133: invokevirtual 80	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   136: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: new 46	java/lang/String
    //   143: dup
    //   144: aload_0
    //   145: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: ldc 64
    //   150: invokevirtual 62	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   153: ldc 58
    //   155: invokespecial 67	java/lang/String:<init>	([BLjava/lang/String;)V
    //   158: astore_0
    //   159: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   162: ifeq +34 -> 196
    //   165: new 120	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   172: astore_3
    //   173: aload_3
    //   174: ldc 172
    //   176: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload_3
    //   181: aload_0
    //   182: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: ldc 163
    //   188: iconst_2
    //   189: aload_3
    //   190: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: new 112	java/io/File
    //   199: dup
    //   200: aload_0
    //   201: invokespecial 173	java/io/File:<init>	(Ljava/lang/String;)V
    //   204: invokevirtual 176	java/io/File:mkdir	()Z
    //   207: pop
    //   208: goto -179 -> 29
    //   211: new 120	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   218: astore_0
    //   219: aload_0
    //   220: aload_1
    //   221: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload_0
    //   226: aload 8
    //   228: invokevirtual 80	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   231: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: new 112	java/io/File
    //   238: dup
    //   239: aload_0
    //   240: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokespecial 173	java/io/File:<init>	(Ljava/lang/String;)V
    //   246: astore_3
    //   247: aload_3
    //   248: invokevirtual 180	java/io/File:getParentFile	()Ljava/io/File;
    //   251: invokevirtual 183	java/io/File:mkdirs	()Z
    //   254: pop
    //   255: aconst_null
    //   256: astore 4
    //   258: aconst_null
    //   259: astore_0
    //   260: new 185	java/io/FileOutputStream
    //   263: dup
    //   264: aload_3
    //   265: invokespecial 186	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   268: invokestatic 192	cooperation/qzone/util/RecycleableBufferedOutputStream:obtain	(Ljava/io/OutputStream;)Lcooperation/qzone/util/RecycleableBufferedOutputStream;
    //   271: astore_3
    //   272: aload 5
    //   274: aload 8
    //   276: invokevirtual 196	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   279: astore 4
    //   281: aload 4
    //   283: astore_0
    //   284: aload 4
    //   286: aload 7
    //   288: iconst_0
    //   289: sipush 8192
    //   292: invokevirtual 202	java/io/InputStream:read	([BII)I
    //   295: istore_2
    //   296: iload_2
    //   297: iconst_m1
    //   298: if_icmpeq +17 -> 315
    //   301: aload 4
    //   303: astore_0
    //   304: aload_3
    //   305: aload 7
    //   307: iconst_0
    //   308: iload_2
    //   309: invokevirtual 208	java/io/OutputStream:write	([BII)V
    //   312: goto -31 -> 281
    //   315: aload 4
    //   317: ifnull +11 -> 328
    //   320: aload 4
    //   322: invokevirtual 211	java/io/InputStream:close	()V
    //   325: goto +3 -> 328
    //   328: aload_3
    //   329: ifnull -300 -> 29
    //   332: aload_3
    //   333: invokevirtual 214	java/io/OutputStream:flush	()V
    //   336: aload_3
    //   337: invokevirtual 215	java/io/OutputStream:close	()V
    //   340: goto -311 -> 29
    //   343: goto -314 -> 29
    //   346: astore 4
    //   348: aload_3
    //   349: astore_1
    //   350: aload_0
    //   351: astore_3
    //   352: aload 4
    //   354: astore_0
    //   355: goto +9 -> 364
    //   358: astore_0
    //   359: aconst_null
    //   360: astore_1
    //   361: aload 4
    //   363: astore_3
    //   364: aload_3
    //   365: ifnull +10 -> 375
    //   368: aload_3
    //   369: invokevirtual 211	java/io/InputStream:close	()V
    //   372: goto +3 -> 375
    //   375: aload_1
    //   376: ifnull +11 -> 387
    //   379: aload_1
    //   380: invokevirtual 214	java/io/OutputStream:flush	()V
    //   383: aload_1
    //   384: invokevirtual 215	java/io/OutputStream:close	()V
    //   387: aload_0
    //   388: athrow
    //   389: aload 5
    //   391: invokevirtual 216	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   394: return
    //   395: astore_0
    //   396: goto -68 -> 328
    //   399: astore_0
    //   400: goto -57 -> 343
    //   403: astore_3
    //   404: goto -29 -> 375
    //   407: astore_1
    //   408: goto -21 -> 387
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	411	0	paramFile	File
    //   0	411	1	paramString	String
    //   295	14	2	i	int
    //   172	197	3	localObject1	Object
    //   403	1	3	localIOException	IOException
    //   256	65	4	localInputStream	java.io.InputStream
    //   346	16	4	localObject2	Object
    //   13	377	5	localQZipFile	QZipFile
    //   20	20	6	localEnumeration	Enumeration
    //   27	279	7	arrayOfByte	byte[]
    //   49	226	8	localZipEntry	ZipEntry
    // Exception table:
    //   from	to	target	type
    //   272	281	346	finally
    //   284	296	346	finally
    //   304	312	346	finally
    //   260	272	358	finally
    //   320	325	395	java/io/IOException
    //   332	340	399	java/io/IOException
    //   368	372	403	java/io/IOException
    //   379	387	407	java/io/IOException
  }
  
  /* Error */
  public static int unZipFile2(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +551 -> 555
    //   7: aload_1
    //   8: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +6 -> 17
    //   14: goto +541 -> 555
    //   17: invokestatic 159	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   20: ifeq +53 -> 73
    //   23: new 120	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   30: astore 4
    //   32: aload 4
    //   34: ldc 222
    //   36: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 4
    //   42: aload_0
    //   43: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 4
    //   49: ldc 224
    //   51: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload 4
    //   57: aload_1
    //   58: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: ldc 11
    //   64: iconst_4
    //   65: aload 4
    //   67: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   73: new 112	java/io/File
    //   76: dup
    //   77: aload_0
    //   78: invokespecial 173	java/io/File:<init>	(Ljava/lang/String;)V
    //   81: astore_0
    //   82: aload_0
    //   83: aload_1
    //   84: invokestatic 149	com/tencent/biz/common/util/ZipUtils:unzipStartNotice	(Ljava/io/File;Ljava/lang/String;)V
    //   87: aload_0
    //   88: invokevirtual 227	java/io/File:exists	()Z
    //   91: ifne +20 -> 111
    //   94: invokestatic 159	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   97: ifeq +11 -> 108
    //   100: ldc 11
    //   102: iconst_4
    //   103: ldc 229
    //   105: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   108: bipush 254
    //   110: ireturn
    //   111: new 112	java/io/File
    //   114: dup
    //   115: aload_1
    //   116: invokespecial 173	java/io/File:<init>	(Ljava/lang/String;)V
    //   119: astore 4
    //   121: aload 4
    //   123: invokevirtual 227	java/io/File:exists	()Z
    //   126: ifne +9 -> 135
    //   129: aload 4
    //   131: invokevirtual 183	java/io/File:mkdirs	()Z
    //   134: pop
    //   135: aconst_null
    //   136: astore 4
    //   138: new 231	com/tencent/commonsdk/zip/QZipInputStream
    //   141: dup
    //   142: new 233	java/io/BufferedInputStream
    //   145: dup
    //   146: new 235	java/io/FileInputStream
    //   149: dup
    //   150: aload_0
    //   151: invokespecial 236	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   154: invokespecial 239	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   157: invokespecial 240	com/tencent/commonsdk/zip/QZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   160: astore_0
    //   161: goto +27 -> 188
    //   164: astore 5
    //   166: aload 4
    //   168: astore_0
    //   169: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   172: ifeq +16 -> 188
    //   175: ldc 11
    //   177: iconst_2
    //   178: ldc 242
    //   180: aload 5
    //   182: invokestatic 246	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   185: aload 4
    //   187: astore_0
    //   188: iconst_0
    //   189: istore_2
    //   190: iconst_0
    //   191: istore_3
    //   192: new 120	java/lang/StringBuilder
    //   195: dup
    //   196: sipush 512
    //   199: invokespecial 249	java/lang/StringBuilder:<init>	(I)V
    //   202: astore 4
    //   204: aload_0
    //   205: invokevirtual 253	com/tencent/commonsdk/zip/QZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   208: astore 5
    //   210: aload 5
    //   212: ifnull +196 -> 408
    //   215: aload 4
    //   217: iconst_0
    //   218: aload 4
    //   220: invokevirtual 257	java/lang/StringBuilder:length	()I
    //   223: invokevirtual 261	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload 5
    //   229: invokevirtual 80	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   232: astore 6
    //   234: invokestatic 159	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   237: ifeq +56 -> 293
    //   240: new 120	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   247: astore 7
    //   249: aload 7
    //   251: ldc_w 263
    //   254: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload 7
    //   260: aload_1
    //   261: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload 7
    //   267: ldc_w 265
    //   270: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload 7
    //   276: aload 6
    //   278: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: ldc 11
    //   284: iconst_4
    //   285: aload 7
    //   287: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   293: aload 4
    //   295: aload_1
    //   296: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload 4
    //   302: getstatic 128	java/io/File:separator	Ljava/lang/String;
    //   305: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: aload 4
    //   311: aload 6
    //   313: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload 5
    //   319: invokevirtual 98	java/util/zip/ZipEntry:isDirectory	()Z
    //   322: ifeq +34 -> 356
    //   325: new 112	java/io/File
    //   328: dup
    //   329: aload 4
    //   331: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokespecial 173	java/io/File:<init>	(Ljava/lang/String;)V
    //   337: astore 5
    //   339: aload 5
    //   341: invokevirtual 227	java/io/File:exists	()Z
    //   344: ifne -140 -> 204
    //   347: aload 5
    //   349: invokevirtual 183	java/io/File:mkdirs	()Z
    //   352: pop
    //   353: goto -149 -> 204
    //   356: new 112	java/io/File
    //   359: dup
    //   360: aload 4
    //   362: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokespecial 173	java/io/File:<init>	(Ljava/lang/String;)V
    //   368: astore 5
    //   370: aload 5
    //   372: invokevirtual 227	java/io/File:exists	()Z
    //   375: ifne +24 -> 399
    //   378: aload 5
    //   380: invokevirtual 180	java/io/File:getParentFile	()Ljava/io/File;
    //   383: astore 6
    //   385: aload 6
    //   387: invokevirtual 227	java/io/File:exists	()Z
    //   390: ifne +9 -> 399
    //   393: aload 6
    //   395: invokevirtual 183	java/io/File:mkdirs	()Z
    //   398: pop
    //   399: aload_0
    //   400: aload 5
    //   402: invokestatic 269	com/tencent/biz/common/util/ZipUtils:witeInto	(Lcom/tencent/commonsdk/zip/QZipInputStream;Ljava/io/File;)V
    //   405: goto -201 -> 204
    //   408: aload_0
    //   409: ifnull +126 -> 535
    //   412: iload_3
    //   413: istore_2
    //   414: aload_0
    //   415: invokevirtual 270	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   418: iconst_0
    //   419: ireturn
    //   420: astore_0
    //   421: aload_0
    //   422: invokevirtual 271	java/io/IOException:printStackTrace	()V
    //   425: iload_2
    //   426: ireturn
    //   427: astore_1
    //   428: goto +109 -> 537
    //   431: astore_1
    //   432: bipush 251
    //   434: istore_3
    //   435: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   438: ifeq +13 -> 451
    //   441: ldc 11
    //   443: iconst_2
    //   444: ldc_w 273
    //   447: aload_1
    //   448: invokestatic 246	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   451: iload_3
    //   452: istore_2
    //   453: aload_0
    //   454: ifnull +81 -> 535
    //   457: iload_3
    //   458: istore_2
    //   459: aload_0
    //   460: invokevirtual 270	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   463: bipush 251
    //   465: ireturn
    //   466: astore_1
    //   467: bipush 252
    //   469: istore_3
    //   470: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   473: ifeq +13 -> 486
    //   476: ldc 11
    //   478: iconst_2
    //   479: ldc_w 273
    //   482: aload_1
    //   483: invokestatic 246	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   486: iload_3
    //   487: istore_2
    //   488: aload_0
    //   489: ifnull +46 -> 535
    //   492: iload_3
    //   493: istore_2
    //   494: aload_0
    //   495: invokevirtual 270	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   498: bipush 252
    //   500: ireturn
    //   501: astore_1
    //   502: bipush 253
    //   504: istore_3
    //   505: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   508: ifeq +13 -> 521
    //   511: ldc 11
    //   513: iconst_2
    //   514: ldc_w 273
    //   517: aload_1
    //   518: invokestatic 246	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   521: iload_3
    //   522: istore_2
    //   523: aload_0
    //   524: ifnull +11 -> 535
    //   527: iload_3
    //   528: istore_2
    //   529: aload_0
    //   530: invokevirtual 270	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   533: iload_3
    //   534: istore_2
    //   535: iload_2
    //   536: ireturn
    //   537: aload_0
    //   538: ifnull +15 -> 553
    //   541: aload_0
    //   542: invokevirtual 270	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   545: goto +8 -> 553
    //   548: astore_0
    //   549: aload_0
    //   550: invokevirtual 271	java/io/IOException:printStackTrace	()V
    //   553: aload_1
    //   554: athrow
    //   555: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   558: ifeq +55 -> 613
    //   561: new 120	java/lang/StringBuilder
    //   564: dup
    //   565: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   568: astore 4
    //   570: aload 4
    //   572: ldc_w 275
    //   575: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: pop
    //   579: aload 4
    //   581: aload_0
    //   582: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: pop
    //   586: aload 4
    //   588: ldc_w 277
    //   591: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: pop
    //   595: aload 4
    //   597: aload_1
    //   598: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: pop
    //   602: ldc 11
    //   604: iconst_2
    //   605: aload 4
    //   607: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   610: invokestatic 279	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   613: iconst_m1
    //   614: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	615	0	paramString1	String
    //   0	615	1	paramString2	String
    //   189	347	2	i	int
    //   191	343	3	j	int
    //   30	576	4	localObject1	Object
    //   164	17	5	localThrowable	Throwable
    //   208	193	5	localObject2	Object
    //   232	162	6	localObject3	Object
    //   247	39	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   138	161	164	java/lang/Throwable
    //   414	418	420	java/io/IOException
    //   459	463	420	java/io/IOException
    //   494	498	420	java/io/IOException
    //   529	533	420	java/io/IOException
    //   192	204	427	finally
    //   204	210	427	finally
    //   215	293	427	finally
    //   293	353	427	finally
    //   356	399	427	finally
    //   399	405	427	finally
    //   435	451	427	finally
    //   470	486	427	finally
    //   505	521	427	finally
    //   192	204	431	java/lang/Exception
    //   204	210	431	java/lang/Exception
    //   215	293	431	java/lang/Exception
    //   293	353	431	java/lang/Exception
    //   356	399	431	java/lang/Exception
    //   399	405	431	java/lang/Exception
    //   192	204	466	java/io/IOException
    //   204	210	466	java/io/IOException
    //   215	293	466	java/io/IOException
    //   293	353	466	java/io/IOException
    //   356	399	466	java/io/IOException
    //   399	405	466	java/io/IOException
    //   192	204	501	java/io/FileNotFoundException
    //   204	210	501	java/io/FileNotFoundException
    //   215	293	501	java/io/FileNotFoundException
    //   293	353	501	java/io/FileNotFoundException
    //   356	399	501	java/io/FileNotFoundException
    //   399	405	501	java/io/FileNotFoundException
    //   541	545	548	java/io/IOException
  }
  
  public static int unZipFile3(String paramString1, String paramString2)
  {
    try
    {
      int i = unzipFix(paramString1, new File(paramString2));
      return i;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
    return -1;
  }
  
  /* Error */
  public static int unZipFiles(File paramFile, String paramString, ZipUtils.ZipFilenameFilter paramZipFilenameFilter)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokestatic 149	com/tencent/biz/common/util/ZipUtils:unzipStartNotice	(Ljava/io/File;Ljava/lang/String;)V
    //   5: new 35	java/util/ArrayList
    //   8: dup
    //   9: invokespecial 36	java/util/ArrayList:<init>	()V
    //   12: pop
    //   13: new 112	java/io/File
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 173	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore 6
    //   23: aload 6
    //   25: invokevirtual 227	java/io/File:exists	()Z
    //   28: ifne +9 -> 37
    //   31: aload 6
    //   33: invokevirtual 176	java/io/File:mkdir	()Z
    //   36: pop
    //   37: new 22	com/tencent/commonsdk/zip/QZipFile
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 25	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/io/File;)V
    //   45: astore 6
    //   47: aload 6
    //   49: invokevirtual 29	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   52: astore 11
    //   54: aload 11
    //   56: invokeinterface 44 1 0
    //   61: ifeq +464 -> 525
    //   64: aload 11
    //   66: invokeinterface 50 1 0
    //   71: checkcast 52	java/util/zip/ZipEntry
    //   74: astore 12
    //   76: aload 12
    //   78: invokevirtual 80	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   81: ldc 151
    //   83: invokevirtual 154	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   86: ifeq +6 -> 92
    //   89: goto -35 -> 54
    //   92: sipush 8192
    //   95: newarray byte
    //   97: astore 8
    //   99: aload_2
    //   100: ifnull -46 -> 54
    //   103: aload_2
    //   104: aload 12
    //   106: invokeinterface 292 2 0
    //   111: ifeq -57 -> 54
    //   114: new 120	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   121: astore 7
    //   123: aload 7
    //   125: aload_1
    //   126: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload 7
    //   132: getstatic 128	java/io/File:separator	Ljava/lang/String;
    //   135: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload 7
    //   141: aload 12
    //   143: invokevirtual 80	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   146: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: new 112	java/io/File
    //   153: dup
    //   154: new 46	java/lang/String
    //   157: dup
    //   158: aload 7
    //   160: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: ldc 64
    //   165: invokevirtual 62	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   168: ldc 58
    //   170: invokespecial 67	java/lang/String:<init>	([BLjava/lang/String;)V
    //   173: invokespecial 173	java/io/File:<init>	(Ljava/lang/String;)V
    //   176: astore 10
    //   178: aload 12
    //   180: invokevirtual 98	java/util/zip/ZipEntry:isDirectory	()Z
    //   183: ifeq +20 -> 203
    //   186: aload 10
    //   188: invokevirtual 227	java/io/File:exists	()Z
    //   191: ifne -137 -> 54
    //   194: aload 10
    //   196: invokevirtual 176	java/io/File:mkdir	()Z
    //   199: pop
    //   200: goto -146 -> 54
    //   203: aload 6
    //   205: aload 12
    //   207: invokevirtual 196	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   210: astore 7
    //   212: new 294	java/util/zip/CheckedInputStream
    //   215: dup
    //   216: aload 7
    //   218: new 296	java/util/zip/CRC32
    //   221: dup
    //   222: invokespecial 297	java/util/zip/CRC32:<init>	()V
    //   225: invokespecial 300	java/util/zip/CheckedInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Checksum;)V
    //   228: astore 9
    //   230: new 302	java/io/BufferedOutputStream
    //   233: dup
    //   234: new 185	java/io/FileOutputStream
    //   237: dup
    //   238: aload 10
    //   240: invokespecial 186	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   243: invokespecial 305	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   246: invokestatic 192	cooperation/qzone/util/RecycleableBufferedOutputStream:obtain	(Ljava/io/OutputStream;)Lcooperation/qzone/util/RecycleableBufferedOutputStream;
    //   249: astore 10
    //   251: aload 12
    //   253: invokevirtual 102	java/util/zip/ZipEntry:getSize	()J
    //   256: lstore 4
    //   258: lload 4
    //   260: lconst_0
    //   261: lcmp
    //   262: ifle +34 -> 296
    //   265: aload 9
    //   267: aload 8
    //   269: iconst_0
    //   270: sipush 8192
    //   273: invokevirtual 306	java/util/zip/CheckedInputStream:read	([BII)I
    //   276: istore_3
    //   277: aload 10
    //   279: aload 8
    //   281: iconst_0
    //   282: iload_3
    //   283: invokevirtual 208	java/io/OutputStream:write	([BII)V
    //   286: lload 4
    //   288: iload_3
    //   289: i2l
    //   290: lsub
    //   291: lstore 4
    //   293: goto -35 -> 258
    //   296: aload 12
    //   298: invokevirtual 309	java/util/zip/ZipEntry:getCrc	()J
    //   301: aload 9
    //   303: invokevirtual 313	java/util/zip/CheckedInputStream:getChecksum	()Ljava/util/zip/Checksum;
    //   306: invokeinterface 318 1 0
    //   311: lcmp
    //   312: ifeq +94 -> 406
    //   315: new 120	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   322: astore_1
    //   323: aload_1
    //   324: ldc_w 320
    //   327: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload_1
    //   332: aload 12
    //   334: invokevirtual 80	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   337: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload_1
    //   342: ldc_w 322
    //   345: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: pop
    //   349: aload_1
    //   350: aload_0
    //   351: invokevirtual 325	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   354: pop
    //   355: ldc 163
    //   357: iconst_1
    //   358: aload_1
    //   359: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokestatic 279	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   365: aload 9
    //   367: invokevirtual 326	java/util/zip/CheckedInputStream:close	()V
    //   370: aload 7
    //   372: ifnull +11 -> 383
    //   375: aload 7
    //   377: invokevirtual 211	java/io/InputStream:close	()V
    //   380: goto +3 -> 383
    //   383: aload 10
    //   385: ifnull +13 -> 398
    //   388: aload 10
    //   390: invokevirtual 214	java/io/OutputStream:flush	()V
    //   393: aload 10
    //   395: invokevirtual 215	java/io/OutputStream:close	()V
    //   398: aload 6
    //   400: invokevirtual 216	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   403: bipush 252
    //   405: ireturn
    //   406: aload 9
    //   408: invokevirtual 326	java/util/zip/CheckedInputStream:close	()V
    //   411: aload 7
    //   413: ifnull +11 -> 424
    //   416: aload 7
    //   418: invokevirtual 211	java/io/InputStream:close	()V
    //   421: goto +3 -> 424
    //   424: aload 10
    //   426: ifnull -372 -> 54
    //   429: aload 10
    //   431: invokevirtual 214	java/io/OutputStream:flush	()V
    //   434: aload 10
    //   436: invokevirtual 215	java/io/OutputStream:close	()V
    //   439: goto -385 -> 54
    //   442: astore_1
    //   443: aload 10
    //   445: astore_2
    //   446: aload 9
    //   448: astore 8
    //   450: goto +35 -> 485
    //   453: astore_1
    //   454: aconst_null
    //   455: astore_2
    //   456: aload 9
    //   458: astore 8
    //   460: goto +25 -> 485
    //   463: astore_1
    //   464: aload 7
    //   466: astore_2
    //   467: goto +6 -> 473
    //   470: astore_1
    //   471: aconst_null
    //   472: astore_2
    //   473: aconst_null
    //   474: astore 9
    //   476: aconst_null
    //   477: astore 8
    //   479: aload_2
    //   480: astore 7
    //   482: aload 9
    //   484: astore_2
    //   485: aload 8
    //   487: ifnull +11 -> 498
    //   490: aload 8
    //   492: invokevirtual 326	java/util/zip/CheckedInputStream:close	()V
    //   495: goto +3 -> 498
    //   498: aload 7
    //   500: ifnull +11 -> 511
    //   503: aload 7
    //   505: invokevirtual 211	java/io/InputStream:close	()V
    //   508: goto +3 -> 511
    //   511: aload_2
    //   512: ifnull +11 -> 523
    //   515: aload_2
    //   516: invokevirtual 214	java/io/OutputStream:flush	()V
    //   519: aload_2
    //   520: invokevirtual 215	java/io/OutputStream:close	()V
    //   523: aload_1
    //   524: athrow
    //   525: aload 6
    //   527: invokevirtual 216	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   530: iconst_0
    //   531: ireturn
    //   532: astore_0
    //   533: aload 6
    //   535: astore_1
    //   536: goto +85 -> 621
    //   539: astore_2
    //   540: aload 6
    //   542: astore_1
    //   543: goto +12 -> 555
    //   546: astore_0
    //   547: aconst_null
    //   548: astore_1
    //   549: goto +72 -> 621
    //   552: astore_2
    //   553: aconst_null
    //   554: astore_1
    //   555: new 120	java/lang/StringBuilder
    //   558: dup
    //   559: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   562: astore 6
    //   564: aload 6
    //   566: ldc_w 328
    //   569: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: pop
    //   573: aload 6
    //   575: aload_2
    //   576: invokevirtual 331	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   579: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: pop
    //   583: aload 6
    //   585: ldc_w 322
    //   588: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: pop
    //   592: aload 6
    //   594: aload_0
    //   595: invokevirtual 325	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   598: pop
    //   599: ldc 163
    //   601: iconst_1
    //   602: aload 6
    //   604: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   607: invokestatic 279	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   610: aload_1
    //   611: ifnull +7 -> 618
    //   614: aload_1
    //   615: invokevirtual 216	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   618: iconst_m1
    //   619: ireturn
    //   620: astore_0
    //   621: aload_1
    //   622: ifnull +7 -> 629
    //   625: aload_1
    //   626: invokevirtual 216	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   629: goto +5 -> 634
    //   632: aload_0
    //   633: athrow
    //   634: goto -2 -> 632
    //   637: astore_1
    //   638: goto -268 -> 370
    //   641: astore_1
    //   642: goto -259 -> 383
    //   645: astore_0
    //   646: goto -248 -> 398
    //   649: astore_0
    //   650: bipush 252
    //   652: ireturn
    //   653: astore 8
    //   655: goto -244 -> 411
    //   658: astore 7
    //   660: goto -236 -> 424
    //   663: astore 7
    //   665: goto -611 -> 54
    //   668: astore 8
    //   670: goto -172 -> 498
    //   673: astore 7
    //   675: goto -164 -> 511
    //   678: astore_2
    //   679: goto -156 -> 523
    //   682: astore_0
    //   683: iconst_0
    //   684: ireturn
    //   685: astore_0
    //   686: iconst_m1
    //   687: ireturn
    //   688: astore_1
    //   689: goto -60 -> 629
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	692	0	paramFile	File
    //   0	692	1	paramString	String
    //   0	692	2	paramZipFilenameFilter	ZipUtils.ZipFilenameFilter
    //   276	13	3	i	int
    //   256	36	4	l	long
    //   21	582	6	localObject1	Object
    //   121	383	7	localObject2	Object
    //   658	1	7	localIOException1	IOException
    //   663	1	7	localIOException2	IOException
    //   673	1	7	localIOException3	IOException
    //   97	394	8	localObject3	Object
    //   653	1	8	localIOException4	IOException
    //   668	1	8	localIOException5	IOException
    //   228	255	9	localCheckedInputStream	java.util.zip.CheckedInputStream
    //   176	268	10	localObject4	Object
    //   52	13	11	localEnumeration	Enumeration
    //   74	259	12	localZipEntry	ZipEntry
    // Exception table:
    //   from	to	target	type
    //   251	258	442	finally
    //   265	286	442	finally
    //   296	365	442	finally
    //   230	251	453	finally
    //   212	230	463	finally
    //   203	212	470	finally
    //   47	54	532	finally
    //   54	89	532	finally
    //   92	99	532	finally
    //   103	200	532	finally
    //   365	370	532	finally
    //   375	380	532	finally
    //   388	398	532	finally
    //   406	411	532	finally
    //   416	421	532	finally
    //   429	439	532	finally
    //   490	495	532	finally
    //   503	508	532	finally
    //   515	523	532	finally
    //   523	525	532	finally
    //   47	54	539	java/lang/Throwable
    //   54	89	539	java/lang/Throwable
    //   92	99	539	java/lang/Throwable
    //   103	200	539	java/lang/Throwable
    //   365	370	539	java/lang/Throwable
    //   375	380	539	java/lang/Throwable
    //   388	398	539	java/lang/Throwable
    //   406	411	539	java/lang/Throwable
    //   416	421	539	java/lang/Throwable
    //   429	439	539	java/lang/Throwable
    //   490	495	539	java/lang/Throwable
    //   503	508	539	java/lang/Throwable
    //   515	523	539	java/lang/Throwable
    //   523	525	539	java/lang/Throwable
    //   37	47	546	finally
    //   37	47	552	java/lang/Throwable
    //   555	610	620	finally
    //   365	370	637	java/io/IOException
    //   375	380	641	java/io/IOException
    //   388	398	645	java/io/IOException
    //   398	403	649	java/lang/Exception
    //   406	411	653	java/io/IOException
    //   416	421	658	java/io/IOException
    //   429	439	663	java/io/IOException
    //   490	495	668	java/io/IOException
    //   503	508	673	java/io/IOException
    //   515	523	678	java/io/IOException
    //   525	530	682	java/lang/Exception
    //   614	618	685	java/lang/Exception
    //   625	629	688	java/lang/Exception
  }
  
  /* Error */
  public static int unZipFolder(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +49 -> 53
    //   7: new 120	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   14: astore_1
    //   15: aload_1
    //   16: ldc_w 336
    //   19: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload_1
    //   24: aload_0
    //   25: invokevirtual 337	java/lang/String:toString	()Ljava/lang/String;
    //   28: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload_1
    //   33: ldc_w 339
    //   36: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: ldc 163
    //   42: iconst_4
    //   43: aload_1
    //   44: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 279	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: bipush 9
    //   52: ireturn
    //   53: invokestatic 159	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   56: ifeq +58 -> 114
    //   59: new 120	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   66: astore 5
    //   68: aload 5
    //   70: ldc_w 336
    //   73: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload 5
    //   79: aload_0
    //   80: invokevirtual 337	java/lang/String:toString	()Ljava/lang/String;
    //   83: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 5
    //   89: ldc_w 341
    //   92: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload 5
    //   98: aload_1
    //   99: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: ldc 163
    //   105: iconst_4
    //   106: aload 5
    //   108: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: new 112	java/io/File
    //   117: dup
    //   118: aload_1
    //   119: invokespecial 173	java/io/File:<init>	(Ljava/lang/String;)V
    //   122: astore 5
    //   124: aload 5
    //   126: invokevirtual 227	java/io/File:exists	()Z
    //   129: ifne +9 -> 138
    //   132: aload 5
    //   134: invokevirtual 183	java/io/File:mkdirs	()Z
    //   137: pop
    //   138: new 112	java/io/File
    //   141: dup
    //   142: aload_0
    //   143: invokespecial 173	java/io/File:<init>	(Ljava/lang/String;)V
    //   146: astore_0
    //   147: aload_0
    //   148: aload_1
    //   149: invokestatic 149	com/tencent/biz/common/util/ZipUtils:unzipStartNotice	(Ljava/io/File;Ljava/lang/String;)V
    //   152: new 22	com/tencent/commonsdk/zip/QZipFile
    //   155: dup
    //   156: aload_0
    //   157: invokespecial 25	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/io/File;)V
    //   160: astore 8
    //   162: sipush 8192
    //   165: newarray byte
    //   167: astore 9
    //   169: new 120	java/lang/StringBuilder
    //   172: dup
    //   173: sipush 512
    //   176: invokespecial 249	java/lang/StringBuilder:<init>	(I)V
    //   179: astore 10
    //   181: aload 8
    //   183: invokevirtual 29	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   186: astore 11
    //   188: aload 11
    //   190: invokeinterface 44 1 0
    //   195: ifeq +465 -> 660
    //   198: aload 11
    //   200: invokeinterface 50 1 0
    //   205: checkcast 52	java/util/zip/ZipEntry
    //   208: astore 12
    //   210: aload 12
    //   212: invokevirtual 80	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   215: astore_0
    //   216: aload_0
    //   217: ldc 151
    //   219: invokevirtual 154	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   222: ifeq +6 -> 228
    //   225: goto -37 -> 188
    //   228: aload 10
    //   230: iconst_0
    //   231: aload 10
    //   233: invokevirtual 257	java/lang/StringBuilder:length	()I
    //   236: invokevirtual 261	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload 10
    //   242: aload_1
    //   243: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload 10
    //   249: getstatic 128	java/io/File:separator	Ljava/lang/String;
    //   252: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: aload 10
    //   258: aload_0
    //   259: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload 12
    //   265: invokevirtual 98	java/util/zip/ZipEntry:isDirectory	()Z
    //   268: ifeq +31 -> 299
    //   271: new 112	java/io/File
    //   274: dup
    //   275: aload 10
    //   277: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokespecial 173	java/io/File:<init>	(Ljava/lang/String;)V
    //   283: astore_0
    //   284: aload_0
    //   285: invokevirtual 227	java/io/File:exists	()Z
    //   288: ifne +289 -> 577
    //   291: aload_0
    //   292: invokevirtual 183	java/io/File:mkdirs	()Z
    //   295: pop
    //   296: goto +281 -> 577
    //   299: aconst_null
    //   300: astore 5
    //   302: aload 8
    //   304: aload 12
    //   306: invokevirtual 196	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   309: astore 6
    //   311: new 294	java/util/zip/CheckedInputStream
    //   314: dup
    //   315: aload 6
    //   317: new 296	java/util/zip/CRC32
    //   320: dup
    //   321: invokespecial 297	java/util/zip/CRC32:<init>	()V
    //   324: invokespecial 300	java/util/zip/CheckedInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Checksum;)V
    //   327: astore 7
    //   329: new 112	java/io/File
    //   332: dup
    //   333: new 46	java/lang/String
    //   336: dup
    //   337: aload 10
    //   339: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: ldc 64
    //   344: invokevirtual 62	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   347: ldc 58
    //   349: invokespecial 67	java/lang/String:<init>	([BLjava/lang/String;)V
    //   352: invokespecial 173	java/io/File:<init>	(Ljava/lang/String;)V
    //   355: astore_0
    //   356: aload_0
    //   357: invokevirtual 227	java/io/File:exists	()Z
    //   360: ifne +23 -> 383
    //   363: aload_0
    //   364: invokevirtual 180	java/io/File:getParentFile	()Ljava/io/File;
    //   367: astore 13
    //   369: aload 13
    //   371: invokevirtual 227	java/io/File:exists	()Z
    //   374: ifne +9 -> 383
    //   377: aload 13
    //   379: invokevirtual 183	java/io/File:mkdirs	()Z
    //   382: pop
    //   383: new 302	java/io/BufferedOutputStream
    //   386: dup
    //   387: new 185	java/io/FileOutputStream
    //   390: dup
    //   391: aload_0
    //   392: invokespecial 186	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   395: invokespecial 305	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   398: invokestatic 192	cooperation/qzone/util/RecycleableBufferedOutputStream:obtain	(Ljava/io/OutputStream;)Lcooperation/qzone/util/RecycleableBufferedOutputStream;
    //   401: astore_0
    //   402: aload_0
    //   403: astore 5
    //   405: aload 12
    //   407: invokevirtual 102	java/util/zip/ZipEntry:getSize	()J
    //   410: lstore_3
    //   411: lload_3
    //   412: lconst_0
    //   413: lcmp
    //   414: ifle +37 -> 451
    //   417: aload_0
    //   418: astore 5
    //   420: aload 7
    //   422: aload 9
    //   424: iconst_0
    //   425: sipush 8192
    //   428: invokevirtual 306	java/util/zip/CheckedInputStream:read	([BII)I
    //   431: istore_2
    //   432: aload_0
    //   433: astore 5
    //   435: aload_0
    //   436: aload 9
    //   438: iconst_0
    //   439: iload_2
    //   440: invokevirtual 208	java/io/OutputStream:write	([BII)V
    //   443: lload_3
    //   444: iload_2
    //   445: i2l
    //   446: lsub
    //   447: lstore_3
    //   448: goto -37 -> 411
    //   451: aload 12
    //   453: invokevirtual 309	java/util/zip/ZipEntry:getCrc	()J
    //   456: aload 7
    //   458: invokevirtual 313	java/util/zip/CheckedInputStream:getChecksum	()Ljava/util/zip/Checksum;
    //   461: invokeinterface 318 1 0
    //   466: lcmp
    //   467: ifeq +80 -> 547
    //   470: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   473: ifeq +39 -> 512
    //   476: new 120	java/lang/StringBuilder
    //   479: dup
    //   480: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   483: astore_1
    //   484: aload_1
    //   485: ldc_w 343
    //   488: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: pop
    //   492: aload_1
    //   493: aload 12
    //   495: invokevirtual 309	java/util/zip/ZipEntry:getCrc	()J
    //   498: invokevirtual 346	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   501: pop
    //   502: ldc 163
    //   504: iconst_2
    //   505: aload_1
    //   506: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   512: aload 7
    //   514: invokevirtual 326	java/util/zip/CheckedInputStream:close	()V
    //   517: aload 6
    //   519: ifnull +11 -> 530
    //   522: aload 6
    //   524: invokevirtual 211	java/io/InputStream:close	()V
    //   527: goto +3 -> 530
    //   530: aload_0
    //   531: ifnull +11 -> 542
    //   534: aload_0
    //   535: invokevirtual 214	java/io/OutputStream:flush	()V
    //   538: aload_0
    //   539: invokevirtual 215	java/io/OutputStream:close	()V
    //   542: iconst_4
    //   543: istore_2
    //   544: goto +150 -> 694
    //   547: aload 7
    //   549: invokevirtual 326	java/util/zip/CheckedInputStream:close	()V
    //   552: aload 6
    //   554: ifnull +11 -> 565
    //   557: aload 6
    //   559: invokevirtual 211	java/io/InputStream:close	()V
    //   562: goto +3 -> 565
    //   565: aload_0
    //   566: ifnull +11 -> 577
    //   569: aload_0
    //   570: invokevirtual 214	java/io/OutputStream:flush	()V
    //   573: aload_0
    //   574: invokevirtual 215	java/io/OutputStream:close	()V
    //   577: goto -389 -> 188
    //   580: astore_1
    //   581: aload_0
    //   582: astore 5
    //   584: aload_1
    //   585: astore_0
    //   586: aload 7
    //   588: astore_1
    //   589: goto +30 -> 619
    //   592: astore_0
    //   593: aload 7
    //   595: astore_1
    //   596: goto +23 -> 619
    //   599: astore_0
    //   600: aload 7
    //   602: astore_1
    //   603: goto +16 -> 619
    //   606: astore_0
    //   607: aconst_null
    //   608: astore_1
    //   609: goto +10 -> 619
    //   612: astore_0
    //   613: aconst_null
    //   614: astore 6
    //   616: aload 6
    //   618: astore_1
    //   619: aload_1
    //   620: ifnull +10 -> 630
    //   623: aload_1
    //   624: invokevirtual 326	java/util/zip/CheckedInputStream:close	()V
    //   627: goto +3 -> 630
    //   630: aload 6
    //   632: ifnull +11 -> 643
    //   635: aload 6
    //   637: invokevirtual 211	java/io/InputStream:close	()V
    //   640: goto +3 -> 643
    //   643: aload 5
    //   645: ifnull +13 -> 658
    //   648: aload 5
    //   650: invokevirtual 214	java/io/OutputStream:flush	()V
    //   653: aload 5
    //   655: invokevirtual 215	java/io/OutputStream:close	()V
    //   658: aload_0
    //   659: athrow
    //   660: iconst_0
    //   661: istore_2
    //   662: goto +32 -> 694
    //   665: astore_0
    //   666: aload_0
    //   667: invokevirtual 347	java/lang/Exception:printStackTrace	()V
    //   670: bipush 7
    //   672: istore_2
    //   673: goto +21 -> 694
    //   676: astore_0
    //   677: aload_0
    //   678: invokevirtual 271	java/io/IOException:printStackTrace	()V
    //   681: bipush 6
    //   683: istore_2
    //   684: goto +10 -> 694
    //   687: astore_0
    //   688: aload_0
    //   689: invokevirtual 348	java/io/FileNotFoundException:printStackTrace	()V
    //   692: iconst_5
    //   693: istore_2
    //   694: aload 8
    //   696: invokevirtual 216	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   699: iload_2
    //   700: ireturn
    //   701: astore_0
    //   702: aload_0
    //   703: invokevirtual 271	java/io/IOException:printStackTrace	()V
    //   706: bipush 8
    //   708: ireturn
    //   709: astore_0
    //   710: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   713: ifeq +12 -> 725
    //   716: ldc 163
    //   718: iconst_2
    //   719: ldc_w 350
    //   722: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   725: aload_0
    //   726: invokevirtual 347	java/lang/Exception:printStackTrace	()V
    //   729: iconst_3
    //   730: ireturn
    //   731: astore_0
    //   732: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   735: ifeq +12 -> 747
    //   738: ldc 163
    //   740: iconst_2
    //   741: ldc_w 352
    //   744: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   747: aload_0
    //   748: invokevirtual 271	java/io/IOException:printStackTrace	()V
    //   751: iconst_2
    //   752: ireturn
    //   753: astore_0
    //   754: aload_0
    //   755: invokevirtual 353	java/util/zip/ZipException:printStackTrace	()V
    //   758: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   761: ifeq +12 -> 773
    //   764: ldc 163
    //   766: iconst_2
    //   767: ldc_w 355
    //   770: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   773: iconst_1
    //   774: ireturn
    //   775: astore_1
    //   776: goto -259 -> 517
    //   779: astore_1
    //   780: goto -250 -> 530
    //   783: astore_0
    //   784: goto -242 -> 542
    //   787: astore 5
    //   789: goto -237 -> 552
    //   792: astore 5
    //   794: goto -229 -> 565
    //   797: astore_0
    //   798: goto -221 -> 577
    //   801: astore_1
    //   802: goto -172 -> 630
    //   805: astore_1
    //   806: goto -163 -> 643
    //   809: astore_1
    //   810: goto -152 -> 658
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	813	0	paramString1	String
    //   0	813	1	paramString2	String
    //   431	269	2	i	int
    //   410	38	3	l	long
    //   66	588	5	localObject	Object
    //   787	1	5	localIOException1	IOException
    //   792	1	5	localIOException2	IOException
    //   309	327	6	localInputStream	java.io.InputStream
    //   327	274	7	localCheckedInputStream	java.util.zip.CheckedInputStream
    //   160	535	8	localQZipFile	QZipFile
    //   167	270	9	arrayOfByte	byte[]
    //   179	159	10	localStringBuilder	StringBuilder
    //   186	13	11	localEnumeration	Enumeration
    //   208	286	12	localZipEntry	ZipEntry
    //   367	11	13	localFile	File
    // Exception table:
    //   from	to	target	type
    //   451	512	580	finally
    //   405	411	592	finally
    //   420	432	592	finally
    //   435	443	592	finally
    //   329	383	599	finally
    //   383	402	599	finally
    //   311	329	606	finally
    //   302	311	612	finally
    //   162	188	665	java/lang/Exception
    //   188	225	665	java/lang/Exception
    //   228	296	665	java/lang/Exception
    //   512	517	665	java/lang/Exception
    //   522	527	665	java/lang/Exception
    //   534	542	665	java/lang/Exception
    //   547	552	665	java/lang/Exception
    //   557	562	665	java/lang/Exception
    //   569	577	665	java/lang/Exception
    //   623	627	665	java/lang/Exception
    //   635	640	665	java/lang/Exception
    //   648	658	665	java/lang/Exception
    //   658	660	665	java/lang/Exception
    //   162	188	676	java/io/IOException
    //   188	225	676	java/io/IOException
    //   228	296	676	java/io/IOException
    //   658	660	676	java/io/IOException
    //   162	188	687	java/io/FileNotFoundException
    //   188	225	687	java/io/FileNotFoundException
    //   228	296	687	java/io/FileNotFoundException
    //   512	517	687	java/io/FileNotFoundException
    //   522	527	687	java/io/FileNotFoundException
    //   534	542	687	java/io/FileNotFoundException
    //   547	552	687	java/io/FileNotFoundException
    //   557	562	687	java/io/FileNotFoundException
    //   569	577	687	java/io/FileNotFoundException
    //   623	627	687	java/io/FileNotFoundException
    //   635	640	687	java/io/FileNotFoundException
    //   648	658	687	java/io/FileNotFoundException
    //   658	660	687	java/io/FileNotFoundException
    //   694	699	701	java/io/IOException
    //   152	162	709	java/lang/Exception
    //   152	162	731	java/io/IOException
    //   152	162	753	java/util/zip/ZipException
    //   512	517	775	java/io/IOException
    //   522	527	779	java/io/IOException
    //   534	542	783	java/io/IOException
    //   547	552	787	java/io/IOException
    //   557	562	792	java/io/IOException
    //   569	577	797	java/io/IOException
    //   623	627	801	java/io/IOException
    //   635	640	805	java/io/IOException
    //   648	658	809	java/io/IOException
  }
  
  /* Error */
  public static ArrayList<File> unZipSelectedFile(File paramFile, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokestatic 149	com/tencent/biz/common/util/ZipUtils:unzipStartNotice	(Ljava/io/File;Ljava/lang/String;)V
    //   5: new 35	java/util/ArrayList
    //   8: dup
    //   9: invokespecial 36	java/util/ArrayList:<init>	()V
    //   12: astore 7
    //   14: new 112	java/io/File
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 173	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: astore 4
    //   24: aload 4
    //   26: invokevirtual 227	java/io/File:exists	()Z
    //   29: ifne +9 -> 38
    //   32: aload 4
    //   34: invokevirtual 176	java/io/File:mkdir	()Z
    //   37: pop
    //   38: new 22	com/tencent/commonsdk/zip/QZipFile
    //   41: dup
    //   42: aload_0
    //   43: invokespecial 25	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/io/File;)V
    //   46: astore 8
    //   48: aload 8
    //   50: invokevirtual 29	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   53: astore 9
    //   55: aload 9
    //   57: invokeinterface 44 1 0
    //   62: ifeq +315 -> 377
    //   65: aload 9
    //   67: invokeinterface 50 1 0
    //   72: checkcast 52	java/util/zip/ZipEntry
    //   75: astore 10
    //   77: aload 10
    //   79: invokevirtual 80	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   82: ldc 151
    //   84: invokevirtual 154	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   87: ifne -32 -> 55
    //   90: aload 10
    //   92: invokevirtual 80	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   95: aload_2
    //   96: invokevirtual 154	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   99: ifeq -44 -> 55
    //   102: aconst_null
    //   103: astore 6
    //   105: aconst_null
    //   106: astore 5
    //   108: aload 8
    //   110: aload 10
    //   112: invokevirtual 196	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   115: astore 4
    //   117: aload 5
    //   119: astore_0
    //   120: new 120	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   127: astore 6
    //   129: aload 5
    //   131: astore_0
    //   132: aload 6
    //   134: aload_1
    //   135: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload 5
    //   141: astore_0
    //   142: aload 6
    //   144: getstatic 128	java/io/File:separator	Ljava/lang/String;
    //   147: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload 5
    //   153: astore_0
    //   154: aload 6
    //   156: aload 10
    //   158: invokevirtual 80	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   161: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 5
    //   167: astore_0
    //   168: new 112	java/io/File
    //   171: dup
    //   172: new 46	java/lang/String
    //   175: dup
    //   176: aload 6
    //   178: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: ldc 64
    //   183: invokevirtual 62	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   186: ldc 58
    //   188: invokespecial 67	java/lang/String:<init>	([BLjava/lang/String;)V
    //   191: invokespecial 173	java/io/File:<init>	(Ljava/lang/String;)V
    //   194: astore 6
    //   196: aload 5
    //   198: astore_0
    //   199: aload 6
    //   201: invokevirtual 227	java/io/File:exists	()Z
    //   204: ifne +33 -> 237
    //   207: aload 5
    //   209: astore_0
    //   210: aload 6
    //   212: invokevirtual 180	java/io/File:getParentFile	()Ljava/io/File;
    //   215: astore 10
    //   217: aload 5
    //   219: astore_0
    //   220: aload 10
    //   222: invokevirtual 227	java/io/File:exists	()Z
    //   225: ifne +12 -> 237
    //   228: aload 5
    //   230: astore_0
    //   231: aload 10
    //   233: invokevirtual 183	java/io/File:mkdirs	()Z
    //   236: pop
    //   237: aload 5
    //   239: astore_0
    //   240: new 302	java/io/BufferedOutputStream
    //   243: dup
    //   244: new 185	java/io/FileOutputStream
    //   247: dup
    //   248: aload 6
    //   250: invokespecial 186	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   253: invokespecial 305	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   256: invokestatic 192	cooperation/qzone/util/RecycleableBufferedOutputStream:obtain	(Ljava/io/OutputStream;)Lcooperation/qzone/util/RecycleableBufferedOutputStream;
    //   259: astore 5
    //   261: aload 5
    //   263: astore_0
    //   264: ldc 7
    //   266: newarray byte
    //   268: astore 10
    //   270: aload 5
    //   272: astore_0
    //   273: aload 4
    //   275: aload 10
    //   277: invokevirtual 360	java/io/InputStream:read	([B)I
    //   280: istore_3
    //   281: iload_3
    //   282: ifle +18 -> 300
    //   285: aload 5
    //   287: astore_0
    //   288: aload 5
    //   290: aload 10
    //   292: iconst_0
    //   293: iload_3
    //   294: invokevirtual 208	java/io/OutputStream:write	([BII)V
    //   297: goto -27 -> 270
    //   300: aload 5
    //   302: astore_0
    //   303: aload 7
    //   305: aload 6
    //   307: invokevirtual 71	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   310: pop
    //   311: aload 4
    //   313: ifnull +11 -> 324
    //   316: aload 4
    //   318: invokevirtual 211	java/io/InputStream:close	()V
    //   321: goto +3 -> 324
    //   324: aload 5
    //   326: ifnull -271 -> 55
    //   329: aload 5
    //   331: invokevirtual 215	java/io/OutputStream:close	()V
    //   334: goto -279 -> 55
    //   337: astore 5
    //   339: aload_0
    //   340: astore_1
    //   341: aload 4
    //   343: astore_2
    //   344: aload 5
    //   346: astore_0
    //   347: goto +9 -> 356
    //   350: astore_0
    //   351: aconst_null
    //   352: astore_2
    //   353: aload 6
    //   355: astore_1
    //   356: aload_2
    //   357: ifnull +10 -> 367
    //   360: aload_2
    //   361: invokevirtual 211	java/io/InputStream:close	()V
    //   364: goto +3 -> 367
    //   367: aload_1
    //   368: ifnull +7 -> 375
    //   371: aload_1
    //   372: invokevirtual 215	java/io/OutputStream:close	()V
    //   375: aload_0
    //   376: athrow
    //   377: aload 7
    //   379: areturn
    //   380: astore_0
    //   381: goto -57 -> 324
    //   384: astore_0
    //   385: goto -330 -> 55
    //   388: astore_2
    //   389: goto -22 -> 367
    //   392: astore_1
    //   393: goto -18 -> 375
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	396	0	paramFile	File
    //   0	396	1	paramString1	String
    //   0	396	2	paramString2	String
    //   280	14	3	i	int
    //   22	320	4	localObject1	Object
    //   106	224	5	localRecycleableBufferedOutputStream	cooperation.qzone.util.RecycleableBufferedOutputStream
    //   337	8	5	localObject2	Object
    //   103	251	6	localObject3	Object
    //   12	366	7	localArrayList	ArrayList
    //   46	63	8	localQZipFile	QZipFile
    //   53	13	9	localEnumeration	Enumeration
    //   75	216	10	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   120	129	337	finally
    //   132	139	337	finally
    //   142	151	337	finally
    //   154	165	337	finally
    //   168	196	337	finally
    //   199	207	337	finally
    //   210	217	337	finally
    //   220	228	337	finally
    //   231	237	337	finally
    //   240	261	337	finally
    //   264	270	337	finally
    //   273	281	337	finally
    //   288	297	337	finally
    //   303	311	337	finally
    //   108	117	350	finally
    //   316	321	380	java/io/IOException
    //   329	334	384	java/io/IOException
    //   360	364	388	java/io/IOException
    //   371	375	392	java/io/IOException
  }
  
  /* Error */
  public static int unzipFix(String paramString, File paramFile)
  {
    // Byte code:
    //   0: sipush 1024
    //   3: newarray byte
    //   5: astore 6
    //   7: aconst_null
    //   8: astore 5
    //   10: aconst_null
    //   11: astore 4
    //   13: new 363	java/util/zip/ZipInputStream
    //   16: dup
    //   17: new 235	java/io/FileInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 364	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   25: invokespecial 365	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   28: astore_0
    //   29: aload_0
    //   30: invokevirtual 366	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   33: astore 4
    //   35: aload 4
    //   37: ifnull +210 -> 247
    //   40: aload 4
    //   42: invokevirtual 80	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   45: astore 5
    //   47: aload 5
    //   49: ifnull -14 -> 35
    //   52: aload 5
    //   54: ldc_w 368
    //   57: invokevirtual 154	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   60: ifeq +6 -> 66
    //   63: goto -28 -> 35
    //   66: aload_1
    //   67: aload 4
    //   69: invokestatic 370	com/tencent/biz/common/util/ZipUtils:newFile	(Ljava/io/File;Ljava/util/zip/ZipEntry;)Ljava/io/File;
    //   72: astore 5
    //   74: aload 4
    //   76: invokevirtual 98	java/util/zip/ZipEntry:isDirectory	()Z
    //   79: istore_3
    //   80: iload_3
    //   81: ifeq +57 -> 138
    //   84: aload 5
    //   86: invokevirtual 371	java/io/File:isDirectory	()Z
    //   89: ifne +149 -> 238
    //   92: aload 5
    //   94: invokevirtual 183	java/io/File:mkdirs	()Z
    //   97: ifeq +6 -> 103
    //   100: goto +138 -> 238
    //   103: new 120	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   110: astore_1
    //   111: aload_1
    //   112: ldc_w 373
    //   115: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload_1
    //   120: aload 5
    //   122: invokevirtual 325	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: new 139	java/io/IOException
    //   129: dup
    //   130: aload_1
    //   131: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokespecial 140	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   137: athrow
    //   138: aload 5
    //   140: invokevirtual 180	java/io/File:getParentFile	()Ljava/io/File;
    //   143: astore 4
    //   145: aload 4
    //   147: invokevirtual 371	java/io/File:isDirectory	()Z
    //   150: ifne +49 -> 199
    //   153: aload 4
    //   155: invokevirtual 183	java/io/File:mkdirs	()Z
    //   158: ifeq +6 -> 164
    //   161: goto +38 -> 199
    //   164: new 120	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   171: astore_1
    //   172: aload_1
    //   173: ldc_w 373
    //   176: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload_1
    //   181: aload 4
    //   183: invokevirtual 325	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: new 139	java/io/IOException
    //   190: dup
    //   191: aload_1
    //   192: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokespecial 140	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   198: athrow
    //   199: new 185	java/io/FileOutputStream
    //   202: dup
    //   203: aload 5
    //   205: invokespecial 186	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   208: astore 4
    //   210: aload_0
    //   211: aload 6
    //   213: invokevirtual 374	java/util/zip/ZipInputStream:read	([B)I
    //   216: istore_2
    //   217: iload_2
    //   218: ifle +15 -> 233
    //   221: aload 4
    //   223: aload 6
    //   225: iconst_0
    //   226: iload_2
    //   227: invokevirtual 375	java/io/FileOutputStream:write	([BII)V
    //   230: goto -20 -> 210
    //   233: aload 4
    //   235: invokevirtual 376	java/io/FileOutputStream:close	()V
    //   238: aload_0
    //   239: invokevirtual 366	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   242: astore 4
    //   244: goto -209 -> 35
    //   247: aload_0
    //   248: invokevirtual 379	java/util/zip/ZipInputStream:closeEntry	()V
    //   251: aload_0
    //   252: invokevirtual 380	java/util/zip/ZipInputStream:close	()V
    //   255: aload_0
    //   256: invokevirtual 380	java/util/zip/ZipInputStream:close	()V
    //   259: iconst_0
    //   260: ireturn
    //   261: astore_1
    //   262: goto +42 -> 304
    //   265: astore_1
    //   266: goto +14 -> 280
    //   269: astore_1
    //   270: aload 4
    //   272: astore_0
    //   273: goto +31 -> 304
    //   276: astore_1
    //   277: aload 5
    //   279: astore_0
    //   280: aload_0
    //   281: astore 4
    //   283: aload_1
    //   284: invokevirtual 143	java/lang/Throwable:printStackTrace	()V
    //   287: aload_0
    //   288: ifnull +14 -> 302
    //   291: aload_0
    //   292: invokevirtual 380	java/util/zip/ZipInputStream:close	()V
    //   295: iconst_m1
    //   296: ireturn
    //   297: astore_0
    //   298: aload_0
    //   299: invokevirtual 271	java/io/IOException:printStackTrace	()V
    //   302: iconst_m1
    //   303: ireturn
    //   304: aload_0
    //   305: ifnull +15 -> 320
    //   308: aload_0
    //   309: invokevirtual 380	java/util/zip/ZipInputStream:close	()V
    //   312: goto +8 -> 320
    //   315: astore_0
    //   316: aload_0
    //   317: invokevirtual 271	java/io/IOException:printStackTrace	()V
    //   320: goto +5 -> 325
    //   323: aload_1
    //   324: athrow
    //   325: goto -2 -> 323
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	328	0	paramString	String
    //   0	328	1	paramFile	File
    //   216	11	2	i	int
    //   79	2	3	bool	boolean
    //   11	271	4	localObject1	Object
    //   8	270	5	localObject2	Object
    //   5	219	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   29	35	261	finally
    //   40	47	261	finally
    //   52	63	261	finally
    //   66	80	261	finally
    //   84	100	261	finally
    //   103	138	261	finally
    //   138	161	261	finally
    //   164	199	261	finally
    //   199	210	261	finally
    //   210	217	261	finally
    //   221	230	261	finally
    //   233	238	261	finally
    //   238	244	261	finally
    //   247	255	261	finally
    //   29	35	265	java/lang/Throwable
    //   40	47	265	java/lang/Throwable
    //   52	63	265	java/lang/Throwable
    //   66	80	265	java/lang/Throwable
    //   84	100	265	java/lang/Throwable
    //   103	138	265	java/lang/Throwable
    //   138	161	265	java/lang/Throwable
    //   164	199	265	java/lang/Throwable
    //   199	210	265	java/lang/Throwable
    //   210	217	265	java/lang/Throwable
    //   221	230	265	java/lang/Throwable
    //   233	238	265	java/lang/Throwable
    //   238	244	265	java/lang/Throwable
    //   247	255	265	java/lang/Throwable
    //   13	29	269	finally
    //   283	287	269	finally
    //   13	29	276	java/lang/Throwable
    //   255	259	297	java/io/IOException
    //   291	295	297	java/io/IOException
    //   308	312	315	java/io/IOException
  }
  
  private static void unzipStartNotice(File paramFile, String paramString)
  {
    ZipUtils.UnzipCallback localUnzipCallback = sUnzipCallback;
    if (localUnzipCallback != null) {
      localUnzipCallback.onFileUnzip(paramFile, paramString);
    }
  }
  
  /* Error */
  private static void witeInto(com.tencent.commonsdk.zip.QZipInputStream paramQZipInputStream, File paramFile)
  {
    // Byte code:
    //   0: sipush 8192
    //   3: newarray byte
    //   5: astore 5
    //   7: aconst_null
    //   8: astore 4
    //   10: aconst_null
    //   11: astore_3
    //   12: new 185	java/io/FileOutputStream
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 186	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   20: invokestatic 192	cooperation/qzone/util/RecycleableBufferedOutputStream:obtain	(Ljava/io/OutputStream;)Lcooperation/qzone/util/RecycleableBufferedOutputStream;
    //   23: astore_1
    //   24: aload_1
    //   25: astore_3
    //   26: aload_1
    //   27: astore 4
    //   29: aload_0
    //   30: aload 5
    //   32: iconst_0
    //   33: aload 5
    //   35: arraylength
    //   36: invokevirtual 386	com/tencent/commonsdk/zip/QZipInputStream:read	([BII)I
    //   39: istore_2
    //   40: iload_2
    //   41: iconst_m1
    //   42: if_icmpeq +19 -> 61
    //   45: aload_1
    //   46: astore_3
    //   47: aload_1
    //   48: astore 4
    //   50: aload_1
    //   51: aload 5
    //   53: iconst_0
    //   54: iload_2
    //   55: invokevirtual 208	java/io/OutputStream:write	([BII)V
    //   58: goto -34 -> 24
    //   61: aload_1
    //   62: ifnull +74 -> 136
    //   65: aload_1
    //   66: invokevirtual 215	java/io/OutputStream:close	()V
    //   69: return
    //   70: astore_0
    //   71: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   74: ifeq +62 -> 136
    //   77: ldc 11
    //   79: iconst_2
    //   80: ldc_w 273
    //   83: aload_0
    //   84: invokestatic 246	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   87: return
    //   88: astore_0
    //   89: goto +48 -> 137
    //   92: astore_0
    //   93: aload 4
    //   95: astore_3
    //   96: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq +16 -> 115
    //   102: aload 4
    //   104: astore_3
    //   105: ldc 11
    //   107: iconst_2
    //   108: ldc_w 273
    //   111: aload_0
    //   112: invokestatic 246	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   115: aload 4
    //   117: ifnull +19 -> 136
    //   120: aload 4
    //   122: invokevirtual 215	java/io/OutputStream:close	()V
    //   125: return
    //   126: astore_0
    //   127: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   130: ifeq +6 -> 136
    //   133: goto -56 -> 77
    //   136: return
    //   137: aload_3
    //   138: ifnull +27 -> 165
    //   141: aload_3
    //   142: invokevirtual 215	java/io/OutputStream:close	()V
    //   145: goto +20 -> 165
    //   148: astore_1
    //   149: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   152: ifeq +13 -> 165
    //   155: ldc 11
    //   157: iconst_2
    //   158: ldc_w 273
    //   161: aload_1
    //   162: invokestatic 246	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   165: goto +5 -> 170
    //   168: aload_0
    //   169: athrow
    //   170: goto -2 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	paramQZipInputStream	com.tencent.commonsdk.zip.QZipInputStream
    //   0	173	1	paramFile	File
    //   39	16	2	i	int
    //   11	131	3	localFile1	File
    //   8	113	4	localFile2	File
    //   5	47	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   65	69	70	java/io/IOException
    //   12	24	88	finally
    //   29	40	88	finally
    //   50	58	88	finally
    //   96	102	88	finally
    //   105	115	88	finally
    //   12	24	92	java/lang/Exception
    //   29	40	92	java/lang/Exception
    //   50	58	92	java/lang/Exception
    //   120	125	126	java/io/IOException
    //   141	145	148	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.common.util.ZipUtils
 * JD-Core Version:    0.7.0.1
 */