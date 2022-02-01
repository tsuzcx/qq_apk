package com.tencent.biz.common.util;

import android.text.TextUtils;
import com.tencent.commonsdk.zip.QZipFile;
import com.tencent.commonsdk.zip.QZipInputStream;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.RecycleableBufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;

public class ZipUtils
{
  protected static final int BUFF_SIZE = 1048576;
  private static final String TAG = "ZipUtils";
  
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
    long l2;
    if (TextUtils.isEmpty(paramString)) {
      l2 = -1L;
    }
    for (;;)
    {
      return l2;
      try
      {
        paramString = new QZipFile(paramString).entries();
        long l1 = 0L;
        l2 = l1;
        if (!paramString.hasMoreElements()) {
          continue;
        }
        ZipEntry localZipEntry = (ZipEntry)paramString.nextElement();
        if (!localZipEntry.isDirectory())
        {
          l2 = localZipEntry.getSize();
          l1 = l2 + l1;
        }
        for (;;)
        {
          break;
        }
      }
      catch (Exception paramString)
      {
        return -1L;
      }
    }
  }
  
  /* Error */
  public static void unZipFile(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 20	com/tencent/commonsdk/zip/QZipFile
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 23	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/io/File;)V
    //   10: astore 5
    //   12: aload 5
    //   14: invokevirtual 27	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   17: astore 6
    //   19: sipush 8192
    //   22: newarray byte
    //   24: astore 7
    //   26: aload 6
    //   28: invokeinterface 42 1 0
    //   33: ifeq +302 -> 335
    //   36: aload 6
    //   38: invokeinterface 48 1 0
    //   43: checkcast 50	java/util/zip/ZipEntry
    //   46: astore 4
    //   48: aload 4
    //   50: invokevirtual 78	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   53: ldc 106
    //   55: invokevirtual 109	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   58: ifne -32 -> 26
    //   61: aload 4
    //   63: invokevirtual 96	java/util/zip/ZipEntry:isDirectory	()Z
    //   66: ifeq +121 -> 187
    //   69: invokestatic 114	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   72: ifeq +32 -> 104
    //   75: ldc 116
    //   77: iconst_4
    //   78: new 118	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   85: ldc 121
    //   87: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload 4
    //   92: invokevirtual 78	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   95: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 132	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   104: new 44	java/lang/String
    //   107: dup
    //   108: new 118	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   115: aload_1
    //   116: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload 4
    //   121: invokevirtual 78	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   124: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: ldc 62
    //   132: invokevirtual 60	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   135: ldc 56
    //   137: invokespecial 65	java/lang/String:<init>	([BLjava/lang/String;)V
    //   140: astore_0
    //   141: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   144: ifeq +28 -> 172
    //   147: ldc 116
    //   149: iconst_2
    //   150: new 118	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   157: ldc 137
    //   159: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_0
    //   163: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 132	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: new 139	java/io/File
    //   175: dup
    //   176: aload_0
    //   177: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   180: invokevirtual 143	java/io/File:mkdir	()Z
    //   183: pop
    //   184: goto -158 -> 26
    //   187: new 139	java/io/File
    //   190: dup
    //   191: new 118	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   198: aload_1
    //   199: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload 4
    //   204: invokevirtual 78	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   207: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   216: astore_0
    //   217: aload_0
    //   218: invokevirtual 147	java/io/File:getParentFile	()Ljava/io/File;
    //   221: invokevirtual 150	java/io/File:mkdirs	()Z
    //   224: pop
    //   225: new 152	java/io/FileOutputStream
    //   228: dup
    //   229: aload_0
    //   230: invokespecial 153	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   233: invokestatic 159	cooperation/qzone/util/RecycleableBufferedOutputStream:obtain	(Ljava/io/OutputStream;)Lcooperation/qzone/util/RecycleableBufferedOutputStream;
    //   236: astore_0
    //   237: aload 5
    //   239: aload 4
    //   241: invokevirtual 163	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   244: astore 4
    //   246: aload 4
    //   248: aload 7
    //   250: iconst_0
    //   251: sipush 8192
    //   254: invokevirtual 169	java/io/InputStream:read	([BII)I
    //   257: istore_2
    //   258: iload_2
    //   259: iconst_m1
    //   260: if_icmpeq +46 -> 306
    //   263: aload_0
    //   264: aload 7
    //   266: iconst_0
    //   267: iload_2
    //   268: invokevirtual 175	java/io/OutputStream:write	([BII)V
    //   271: goto -25 -> 246
    //   274: astore 5
    //   276: aload_0
    //   277: astore_3
    //   278: aload 4
    //   280: astore_1
    //   281: aload 5
    //   283: astore_0
    //   284: aload_1
    //   285: ifnull +7 -> 292
    //   288: aload_1
    //   289: invokevirtual 178	java/io/InputStream:close	()V
    //   292: aload_3
    //   293: ifnull +11 -> 304
    //   296: aload_3
    //   297: invokevirtual 181	java/io/OutputStream:flush	()V
    //   300: aload_3
    //   301: invokevirtual 182	java/io/OutputStream:close	()V
    //   304: aload_0
    //   305: athrow
    //   306: aload 4
    //   308: ifnull +8 -> 316
    //   311: aload 4
    //   313: invokevirtual 178	java/io/InputStream:close	()V
    //   316: aload_0
    //   317: ifnull -291 -> 26
    //   320: aload_0
    //   321: invokevirtual 181	java/io/OutputStream:flush	()V
    //   324: aload_0
    //   325: invokevirtual 182	java/io/OutputStream:close	()V
    //   328: goto -302 -> 26
    //   331: astore_0
    //   332: goto -306 -> 26
    //   335: aload 5
    //   337: invokevirtual 183	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   340: return
    //   341: astore 4
    //   343: goto -27 -> 316
    //   346: astore_1
    //   347: goto -55 -> 292
    //   350: astore_1
    //   351: goto -47 -> 304
    //   354: astore_0
    //   355: aconst_null
    //   356: astore_1
    //   357: goto -73 -> 284
    //   360: astore 4
    //   362: aconst_null
    //   363: astore_1
    //   364: aload_0
    //   365: astore_3
    //   366: aload 4
    //   368: astore_0
    //   369: goto -85 -> 284
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	372	0	paramFile	File
    //   0	372	1	paramString	String
    //   257	11	2	i	int
    //   1	365	3	localFile	File
    //   46	266	4	localObject1	Object
    //   341	1	4	localIOException	IOException
    //   360	7	4	localObject2	Object
    //   10	228	5	localQZipFile	QZipFile
    //   274	62	5	localObject3	Object
    //   17	20	6	localEnumeration	Enumeration
    //   24	241	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   246	258	274	finally
    //   263	271	274	finally
    //   320	328	331	java/io/IOException
    //   311	316	341	java/io/IOException
    //   288	292	346	java/io/IOException
    //   296	304	350	java/io/IOException
    //   225	237	354	finally
    //   237	246	360	finally
  }
  
  public static int unZipFile2(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ZipUtils", 2, "unZipFile2 参数错误：zipFilePath:" + paramString1 + ",folderPath:" + paramString2);
      }
      return -1;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("ZipUtils", 4, "unZipFile2 new file:" + paramString1 + ", folderPath:" + paramString2);
    }
    paramString1 = new File(paramString1);
    if (!paramString1.exists())
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("ZipUtils", 4, "unZipFile2  zipFilePath doesn't exist");
      }
      return -2;
    }
    Object localObject1 = new File(paramString2);
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    int i;
    try
    {
      paramString1 = new QZipInputStream(new BufferedInputStream(new FileInputStream(paramString1)));
    }
    catch (Throwable paramString1)
    {
      try
      {
        localObject1 = new StringBuilder(512);
        for (;;)
        {
          localObject2 = paramString1.getNextEntry();
          if (localObject2 == null) {
            break label440;
          }
          ((StringBuilder)localObject1).delete(0, ((StringBuilder)localObject1).length());
          localObject3 = ((ZipEntry)localObject2).getName();
          if (QLog.isDevelopLevel()) {
            QLog.d("ZipUtils", 4, "unZipFile2 folderPath:" + paramString2 + ",ZipEntry name: " + (String)localObject3);
          }
          ((StringBuilder)localObject1).append(paramString2).append(File.separator).append((String)localObject3);
          if (!((ZipEntry)localObject2).isDirectory()) {
            break;
          }
          localObject2 = new File(((StringBuilder)localObject1).toString());
          if (!((File)localObject2).exists()) {
            ((File)localObject2).mkdirs();
          }
        }
      }
      catch (FileNotFoundException paramString2)
      {
        for (;;)
        {
          Object localObject3;
          i = -3;
          if (QLog.isColorLevel()) {
            QLog.e("ZipUtils", 2, "unZipFile2 解压错误", paramString2);
          }
          if (paramString1 == null) {
            break label530;
          }
          try
          {
            paramString1.close();
            return -3;
          }
          catch (IOException paramString1)
          {
            paramString1.printStackTrace();
            return -3;
          }
          paramString1 = paramString1;
          if (QLog.isColorLevel()) {
            QLog.e("ZipUtils", 2, " unZipFile2  解压错误：", paramString1);
          }
          paramString1 = null;
          continue;
          Object localObject2 = new File(((StringBuilder)localObject1).toString());
          if (!((File)localObject2).exists())
          {
            localObject3 = ((File)localObject2).getParentFile();
            if (!((File)localObject3).exists()) {
              ((File)localObject3).mkdirs();
            }
          }
          witeInto(paramString1, (File)localObject2);
        }
      }
      catch (IOException paramString2)
      {
        i = -4;
        if (QLog.isColorLevel()) {
          QLog.e("ZipUtils", 2, "unZipFile2 解压错误", paramString2);
        }
        if (paramString1 != null)
        {
          try
          {
            paramString1.close();
            return -4;
          }
          catch (IOException paramString1)
          {
            paramString1.printStackTrace();
            return -4;
          }
          if (paramString1 == null) {
            break label532;
          }
          try
          {
            paramString1.close();
            return 0;
          }
          catch (IOException paramString1)
          {
            paramString1.printStackTrace();
            return 0;
          }
        }
      }
      catch (Exception paramString2)
      {
        label440:
        i = -5;
        if (QLog.isColorLevel()) {
          QLog.e("ZipUtils", 2, "unZipFile2 解压错误", paramString2);
        }
        if (paramString1 != null) {
          try
          {
            paramString1.close();
            return -5;
          }
          catch (IOException paramString1)
          {
            paramString1.printStackTrace();
            return -5;
          }
        }
      }
      finally
      {
        if (paramString1 != null) {}
        try
        {
          paramString1.close();
          throw paramString2;
        }
        catch (IOException paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
          }
        }
      }
    }
    label530:
    return i;
    label532:
    return 0;
  }
  
  /* Error */
  public static int unZipFiles(File paramFile, String paramString, ZipUtils.ZipFilenameFilter paramZipFilenameFilter)
  {
    // Byte code:
    //   0: new 33	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 34	java/util/ArrayList:<init>	()V
    //   7: pop
    //   8: new 139	java/io/File
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: astore 7
    //   18: aload 7
    //   20: invokevirtual 203	java/io/File:exists	()Z
    //   23: ifne +9 -> 32
    //   26: aload 7
    //   28: invokevirtual 143	java/io/File:mkdir	()Z
    //   31: pop
    //   32: aconst_null
    //   33: astore 7
    //   35: new 20	com/tencent/commonsdk/zip/QZipFile
    //   38: dup
    //   39: aload_0
    //   40: invokespecial 23	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/io/File;)V
    //   43: astore 8
    //   45: aload 8
    //   47: invokevirtual 27	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   50: astore 12
    //   52: aload 12
    //   54: invokeinterface 42 1 0
    //   59: ifeq +523 -> 582
    //   62: aload 12
    //   64: invokeinterface 48 1 0
    //   69: checkcast 50	java/util/zip/ZipEntry
    //   72: astore 13
    //   74: aload 13
    //   76: invokevirtual 78	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   79: ldc 106
    //   81: invokevirtual 109	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   84: ifne -32 -> 52
    //   87: sipush 8192
    //   90: newarray byte
    //   92: astore 14
    //   94: aload_2
    //   95: ifnull -43 -> 52
    //   98: aload_2
    //   99: aload 13
    //   101: invokeinterface 261 2 0
    //   106: ifeq -54 -> 52
    //   109: new 139	java/io/File
    //   112: dup
    //   113: new 44	java/lang/String
    //   116: dup
    //   117: new 118	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   124: aload_1
    //   125: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: getstatic 238	java/io/File:separator	Ljava/lang/String;
    //   131: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload 13
    //   136: invokevirtual 78	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   139: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: ldc 62
    //   147: invokevirtual 60	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   150: ldc 56
    //   152: invokespecial 65	java/lang/String:<init>	([BLjava/lang/String;)V
    //   155: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   158: astore 15
    //   160: aload 13
    //   162: invokevirtual 96	java/util/zip/ZipEntry:isDirectory	()Z
    //   165: ifeq +82 -> 247
    //   168: aload 15
    //   170: invokevirtual 203	java/io/File:exists	()Z
    //   173: ifne -121 -> 52
    //   176: aload 15
    //   178: invokevirtual 143	java/io/File:mkdir	()Z
    //   181: pop
    //   182: goto -130 -> 52
    //   185: astore_2
    //   186: aload 8
    //   188: astore_1
    //   189: ldc 116
    //   191: iconst_1
    //   192: new 118	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   199: ldc_w 263
    //   202: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload_2
    //   206: invokevirtual 266	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   209: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: ldc_w 268
    //   215: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload_0
    //   219: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 196	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   228: iconst_m1
    //   229: istore 4
    //   231: iload 4
    //   233: istore_3
    //   234: aload_1
    //   235: ifnull +10 -> 245
    //   238: aload_1
    //   239: invokevirtual 183	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   242: iload 4
    //   244: istore_3
    //   245: iload_3
    //   246: ireturn
    //   247: aconst_null
    //   248: astore 7
    //   250: aconst_null
    //   251: astore 10
    //   253: aload 8
    //   255: aload 13
    //   257: invokevirtual 163	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   260: astore 9
    //   262: new 273	java/util/zip/CheckedInputStream
    //   265: dup
    //   266: aload 9
    //   268: new 275	java/util/zip/CRC32
    //   271: dup
    //   272: invokespecial 276	java/util/zip/CRC32:<init>	()V
    //   275: invokespecial 279	java/util/zip/CheckedInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Checksum;)V
    //   278: astore 11
    //   280: new 281	java/io/BufferedOutputStream
    //   283: dup
    //   284: new 152	java/io/FileOutputStream
    //   287: dup
    //   288: aload 15
    //   290: invokespecial 153	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   293: invokespecial 284	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   296: invokestatic 159	cooperation/qzone/util/RecycleableBufferedOutputStream:obtain	(Ljava/io/OutputStream;)Lcooperation/qzone/util/RecycleableBufferedOutputStream;
    //   299: astore 10
    //   301: aload 10
    //   303: astore 7
    //   305: aload 13
    //   307: invokevirtual 100	java/util/zip/ZipEntry:getSize	()J
    //   310: lstore 5
    //   312: lload 5
    //   314: lconst_0
    //   315: lcmp
    //   316: ifle +42 -> 358
    //   319: aload 10
    //   321: astore 7
    //   323: aload 11
    //   325: aload 14
    //   327: iconst_0
    //   328: sipush 8192
    //   331: invokevirtual 285	java/util/zip/CheckedInputStream:read	([BII)I
    //   334: istore_3
    //   335: aload 10
    //   337: astore 7
    //   339: aload 10
    //   341: aload 14
    //   343: iconst_0
    //   344: iload_3
    //   345: invokevirtual 175	java/io/OutputStream:write	([BII)V
    //   348: lload 5
    //   350: iload_3
    //   351: i2l
    //   352: lsub
    //   353: lstore 5
    //   355: goto -43 -> 312
    //   358: aload 10
    //   360: astore 7
    //   362: aload 13
    //   364: invokevirtual 288	java/util/zip/ZipEntry:getCrc	()J
    //   367: aload 11
    //   369: invokevirtual 292	java/util/zip/CheckedInputStream:getChecksum	()Ljava/util/zip/Checksum;
    //   372: invokeinterface 297 1 0
    //   377: lcmp
    //   378: ifeq +102 -> 480
    //   381: aload 10
    //   383: astore 7
    //   385: ldc 116
    //   387: iconst_1
    //   388: new 118	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   395: ldc_w 299
    //   398: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: aload 13
    //   403: invokevirtual 78	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   406: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: ldc_w 268
    //   412: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: aload_0
    //   416: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   419: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokestatic 196	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   425: bipush 252
    //   427: istore_3
    //   428: aload 11
    //   430: ifnull +8 -> 438
    //   433: aload 11
    //   435: invokevirtual 300	java/util/zip/CheckedInputStream:close	()V
    //   438: aload 9
    //   440: ifnull +8 -> 448
    //   443: aload 9
    //   445: invokevirtual 178	java/io/InputStream:close	()V
    //   448: aload 10
    //   450: ifnull +13 -> 463
    //   453: aload 10
    //   455: invokevirtual 181	java/io/OutputStream:flush	()V
    //   458: aload 10
    //   460: invokevirtual 182	java/io/OutputStream:close	()V
    //   463: aload 8
    //   465: ifnull -220 -> 245
    //   468: aload 8
    //   470: invokevirtual 183	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   473: bipush 252
    //   475: ireturn
    //   476: astore_0
    //   477: bipush 252
    //   479: ireturn
    //   480: aload 11
    //   482: ifnull +8 -> 490
    //   485: aload 11
    //   487: invokevirtual 300	java/util/zip/CheckedInputStream:close	()V
    //   490: aload 9
    //   492: ifnull +8 -> 500
    //   495: aload 9
    //   497: invokevirtual 178	java/io/InputStream:close	()V
    //   500: aload 10
    //   502: ifnull -450 -> 52
    //   505: aload 10
    //   507: invokevirtual 181	java/io/OutputStream:flush	()V
    //   510: aload 10
    //   512: invokevirtual 182	java/io/OutputStream:close	()V
    //   515: goto -463 -> 52
    //   518: astore 7
    //   520: goto -468 -> 52
    //   523: astore_1
    //   524: aconst_null
    //   525: astore 7
    //   527: aconst_null
    //   528: astore_2
    //   529: aload 10
    //   531: astore 9
    //   533: aload_2
    //   534: ifnull +7 -> 541
    //   537: aload_2
    //   538: invokevirtual 300	java/util/zip/CheckedInputStream:close	()V
    //   541: aload 7
    //   543: ifnull +8 -> 551
    //   546: aload 7
    //   548: invokevirtual 178	java/io/InputStream:close	()V
    //   551: aload 9
    //   553: ifnull +13 -> 566
    //   556: aload 9
    //   558: invokevirtual 181	java/io/OutputStream:flush	()V
    //   561: aload 9
    //   563: invokevirtual 182	java/io/OutputStream:close	()V
    //   566: aload_1
    //   567: athrow
    //   568: astore_0
    //   569: aload 8
    //   571: astore_1
    //   572: aload_1
    //   573: ifnull +7 -> 580
    //   576: aload_1
    //   577: invokevirtual 183	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   580: aload_0
    //   581: athrow
    //   582: aload 8
    //   584: ifnull +8 -> 592
    //   587: aload 8
    //   589: invokevirtual 183	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   592: iconst_0
    //   593: ireturn
    //   594: astore_1
    //   595: goto -157 -> 438
    //   598: astore_1
    //   599: goto -151 -> 448
    //   602: astore 7
    //   604: goto -114 -> 490
    //   607: astore 7
    //   609: goto -109 -> 500
    //   612: astore_2
    //   613: goto -72 -> 541
    //   616: astore_2
    //   617: goto -66 -> 551
    //   620: astore_0
    //   621: goto -29 -> 592
    //   624: astore_0
    //   625: iconst_m1
    //   626: ireturn
    //   627: astore_1
    //   628: goto -48 -> 580
    //   631: astore_0
    //   632: aconst_null
    //   633: astore_1
    //   634: goto -62 -> 572
    //   637: astore_0
    //   638: goto -66 -> 572
    //   641: astore_2
    //   642: aload 7
    //   644: astore_1
    //   645: goto -456 -> 189
    //   648: astore_2
    //   649: goto -83 -> 566
    //   652: astore_1
    //   653: aconst_null
    //   654: astore_2
    //   655: aload 9
    //   657: astore 7
    //   659: aload 10
    //   661: astore 9
    //   663: goto -130 -> 533
    //   666: astore_1
    //   667: aload 9
    //   669: astore 10
    //   671: aload 7
    //   673: astore 9
    //   675: aload 11
    //   677: astore_2
    //   678: aload 10
    //   680: astore 7
    //   682: goto -149 -> 533
    //   685: astore_0
    //   686: goto -223 -> 463
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	689	0	paramFile	File
    //   0	689	1	paramString	String
    //   0	689	2	paramZipFilenameFilter	ZipUtils.ZipFilenameFilter
    //   233	195	3	i	int
    //   229	14	4	j	int
    //   310	44	5	l	long
    //   16	368	7	localObject1	Object
    //   518	1	7	localIOException1	IOException
    //   525	22	7	localObject2	Object
    //   602	1	7	localIOException2	IOException
    //   607	36	7	localIOException3	IOException
    //   657	24	7	localObject3	Object
    //   43	545	8	localQZipFile	QZipFile
    //   260	414	9	localObject4	Object
    //   251	428	10	localObject5	Object
    //   278	398	11	localCheckedInputStream	java.util.zip.CheckedInputStream
    //   50	13	12	localEnumeration	Enumeration
    //   72	330	13	localZipEntry	ZipEntry
    //   92	250	14	arrayOfByte	byte[]
    //   158	131	15	localFile	File
    // Exception table:
    //   from	to	target	type
    //   45	52	185	java/lang/Throwable
    //   52	94	185	java/lang/Throwable
    //   98	182	185	java/lang/Throwable
    //   433	438	185	java/lang/Throwable
    //   443	448	185	java/lang/Throwable
    //   453	463	185	java/lang/Throwable
    //   485	490	185	java/lang/Throwable
    //   495	500	185	java/lang/Throwable
    //   505	515	185	java/lang/Throwable
    //   537	541	185	java/lang/Throwable
    //   546	551	185	java/lang/Throwable
    //   556	566	185	java/lang/Throwable
    //   566	568	185	java/lang/Throwable
    //   468	473	476	java/lang/Exception
    //   505	515	518	java/io/IOException
    //   253	262	523	finally
    //   45	52	568	finally
    //   52	94	568	finally
    //   98	182	568	finally
    //   433	438	568	finally
    //   443	448	568	finally
    //   453	463	568	finally
    //   485	490	568	finally
    //   495	500	568	finally
    //   505	515	568	finally
    //   537	541	568	finally
    //   546	551	568	finally
    //   556	566	568	finally
    //   566	568	568	finally
    //   433	438	594	java/io/IOException
    //   443	448	598	java/io/IOException
    //   485	490	602	java/io/IOException
    //   495	500	607	java/io/IOException
    //   537	541	612	java/io/IOException
    //   546	551	616	java/io/IOException
    //   587	592	620	java/lang/Exception
    //   238	242	624	java/lang/Exception
    //   576	580	627	java/lang/Exception
    //   35	45	631	finally
    //   189	228	637	finally
    //   35	45	641	java/lang/Throwable
    //   556	566	648	java/io/IOException
    //   262	280	652	finally
    //   280	301	666	finally
    //   305	312	666	finally
    //   323	335	666	finally
    //   339	348	666	finally
    //   362	381	666	finally
    //   385	425	666	finally
    //   453	463	685	java/io/IOException
  }
  
  /* Error */
  public static int unZipFolder(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +41 -> 45
    //   7: ldc 116
    //   9: iconst_4
    //   10: new 118	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 305
    //   20: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: invokevirtual 306	java/lang/String:toString	()Ljava/lang/String;
    //   27: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc_w 308
    //   33: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 196	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: bipush 9
    //   44: ireturn
    //   45: invokestatic 114	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   48: ifeq +42 -> 90
    //   51: ldc 116
    //   53: iconst_4
    //   54: new 118	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   61: ldc_w 305
    //   64: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_0
    //   68: invokevirtual 306	java/lang/String:toString	()Ljava/lang/String;
    //   71: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc_w 310
    //   77: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_1
    //   81: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 132	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: new 139	java/io/File
    //   93: dup
    //   94: aload_1
    //   95: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   98: astore 6
    //   100: aload 6
    //   102: invokevirtual 203	java/io/File:exists	()Z
    //   105: ifne +9 -> 114
    //   108: aload 6
    //   110: invokevirtual 150	java/io/File:mkdirs	()Z
    //   113: pop
    //   114: new 139	java/io/File
    //   117: dup
    //   118: aload_0
    //   119: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   122: astore_0
    //   123: new 20	com/tencent/commonsdk/zip/QZipFile
    //   126: dup
    //   127: aload_0
    //   128: invokespecial 23	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/io/File;)V
    //   131: astore 9
    //   133: iconst_0
    //   134: istore_3
    //   135: sipush 8192
    //   138: newarray byte
    //   140: astore 8
    //   142: new 118	java/lang/StringBuilder
    //   145: dup
    //   146: sipush 512
    //   149: invokespecial 219	java/lang/StringBuilder:<init>	(I)V
    //   152: astore 10
    //   154: aload 9
    //   156: invokevirtual 27	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   159: astore 11
    //   161: iload_3
    //   162: istore_2
    //   163: aload 11
    //   165: invokeinterface 42 1 0
    //   170: ifeq +611 -> 781
    //   173: aload 11
    //   175: invokeinterface 48 1 0
    //   180: checkcast 50	java/util/zip/ZipEntry
    //   183: astore 12
    //   185: aload 12
    //   187: invokevirtual 78	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   190: astore_0
    //   191: aload_0
    //   192: ldc 106
    //   194: invokevirtual 109	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   197: ifne -36 -> 161
    //   200: aload 10
    //   202: iconst_0
    //   203: aload 10
    //   205: invokevirtual 227	java/lang/StringBuilder:length	()I
    //   208: invokevirtual 231	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload 10
    //   214: aload_1
    //   215: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: getstatic 238	java/io/File:separator	Ljava/lang/String;
    //   221: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: aload_0
    //   225: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: aload 12
    //   231: invokevirtual 96	java/util/zip/ZipEntry:isDirectory	()Z
    //   234: ifeq +119 -> 353
    //   237: new 139	java/io/File
    //   240: dup
    //   241: aload 10
    //   243: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   249: astore_0
    //   250: aload_0
    //   251: invokevirtual 203	java/io/File:exists	()Z
    //   254: ifne -93 -> 161
    //   257: aload_0
    //   258: invokevirtual 150	java/io/File:mkdirs	()Z
    //   261: pop
    //   262: goto -101 -> 161
    //   265: astore_0
    //   266: aload_0
    //   267: invokevirtual 311	java/io/FileNotFoundException:printStackTrace	()V
    //   270: iconst_5
    //   271: istore_2
    //   272: aload 9
    //   274: invokevirtual 183	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   277: iload_2
    //   278: ireturn
    //   279: astore_0
    //   280: aload_0
    //   281: invokevirtual 253	java/io/IOException:printStackTrace	()V
    //   284: bipush 8
    //   286: ireturn
    //   287: astore_0
    //   288: aload_0
    //   289: invokevirtual 312	java/util/zip/ZipException:printStackTrace	()V
    //   292: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   295: ifeq +12 -> 307
    //   298: ldc 116
    //   300: iconst_2
    //   301: ldc_w 314
    //   304: invokestatic 132	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   307: iconst_1
    //   308: ireturn
    //   309: astore_0
    //   310: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   313: ifeq +12 -> 325
    //   316: ldc 116
    //   318: iconst_2
    //   319: ldc_w 316
    //   322: invokestatic 132	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   325: aload_0
    //   326: invokevirtual 253	java/io/IOException:printStackTrace	()V
    //   329: iconst_2
    //   330: ireturn
    //   331: astore_0
    //   332: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   335: ifeq +12 -> 347
    //   338: ldc 116
    //   340: iconst_2
    //   341: ldc_w 318
    //   344: invokestatic 132	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   347: aload_0
    //   348: invokevirtual 319	java/lang/Exception:printStackTrace	()V
    //   351: iconst_3
    //   352: ireturn
    //   353: aconst_null
    //   354: astore 7
    //   356: aload 9
    //   358: aload 12
    //   360: invokevirtual 163	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   363: astore_0
    //   364: new 273	java/util/zip/CheckedInputStream
    //   367: dup
    //   368: aload_0
    //   369: new 275	java/util/zip/CRC32
    //   372: dup
    //   373: invokespecial 276	java/util/zip/CRC32:<init>	()V
    //   376: invokespecial 279	java/util/zip/CheckedInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Checksum;)V
    //   379: astore 6
    //   381: new 139	java/io/File
    //   384: dup
    //   385: new 44	java/lang/String
    //   388: dup
    //   389: aload 10
    //   391: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   394: ldc 62
    //   396: invokevirtual 60	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   399: ldc 56
    //   401: invokespecial 65	java/lang/String:<init>	([BLjava/lang/String;)V
    //   404: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   407: astore 7
    //   409: aload 7
    //   411: invokevirtual 203	java/io/File:exists	()Z
    //   414: ifne +24 -> 438
    //   417: aload 7
    //   419: invokevirtual 147	java/io/File:getParentFile	()Ljava/io/File;
    //   422: astore 13
    //   424: aload 13
    //   426: invokevirtual 203	java/io/File:exists	()Z
    //   429: ifne +9 -> 438
    //   432: aload 13
    //   434: invokevirtual 150	java/io/File:mkdirs	()Z
    //   437: pop
    //   438: new 281	java/io/BufferedOutputStream
    //   441: dup
    //   442: new 152	java/io/FileOutputStream
    //   445: dup
    //   446: aload 7
    //   448: invokespecial 153	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   451: invokespecial 284	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   454: invokestatic 159	cooperation/qzone/util/RecycleableBufferedOutputStream:obtain	(Ljava/io/OutputStream;)Lcooperation/qzone/util/RecycleableBufferedOutputStream;
    //   457: astore 7
    //   459: aload 12
    //   461: invokevirtual 100	java/util/zip/ZipEntry:getSize	()J
    //   464: lstore 4
    //   466: lload 4
    //   468: lconst_0
    //   469: lcmp
    //   470: ifle +34 -> 504
    //   473: aload 6
    //   475: aload 8
    //   477: iconst_0
    //   478: sipush 8192
    //   481: invokevirtual 285	java/util/zip/CheckedInputStream:read	([BII)I
    //   484: istore_2
    //   485: aload 7
    //   487: aload 8
    //   489: iconst_0
    //   490: iload_2
    //   491: invokevirtual 175	java/io/OutputStream:write	([BII)V
    //   494: lload 4
    //   496: iload_2
    //   497: i2l
    //   498: lsub
    //   499: lstore 4
    //   501: goto -35 -> 466
    //   504: aload 12
    //   506: invokevirtual 288	java/util/zip/ZipEntry:getCrc	()J
    //   509: aload 6
    //   511: invokevirtual 292	java/util/zip/CheckedInputStream:getChecksum	()Ljava/util/zip/Checksum;
    //   514: invokeinterface 297 1 0
    //   519: lcmp
    //   520: ifeq +85 -> 605
    //   523: iconst_4
    //   524: istore_2
    //   525: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   528: ifeq +33 -> 561
    //   531: ldc 116
    //   533: iconst_2
    //   534: new 118	java/lang/StringBuilder
    //   537: dup
    //   538: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   541: ldc_w 321
    //   544: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: aload 12
    //   549: invokevirtual 288	java/util/zip/ZipEntry:getCrc	()J
    //   552: invokevirtual 324	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   555: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   558: invokestatic 132	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   561: aload 6
    //   563: ifnull +8 -> 571
    //   566: aload 6
    //   568: invokevirtual 300	java/util/zip/CheckedInputStream:close	()V
    //   571: aload_0
    //   572: ifnull +7 -> 579
    //   575: aload_0
    //   576: invokevirtual 178	java/io/InputStream:close	()V
    //   579: aload 7
    //   581: ifnull +200 -> 781
    //   584: aload 7
    //   586: invokevirtual 181	java/io/OutputStream:flush	()V
    //   589: aload 7
    //   591: invokevirtual 182	java/io/OutputStream:close	()V
    //   594: iconst_4
    //   595: istore_2
    //   596: goto -324 -> 272
    //   599: astore_0
    //   600: iconst_4
    //   601: istore_2
    //   602: goto -330 -> 272
    //   605: aload 6
    //   607: ifnull +8 -> 615
    //   610: aload 6
    //   612: invokevirtual 300	java/util/zip/CheckedInputStream:close	()V
    //   615: aload_0
    //   616: ifnull +7 -> 623
    //   619: aload_0
    //   620: invokevirtual 178	java/io/InputStream:close	()V
    //   623: aload 7
    //   625: ifnull -464 -> 161
    //   628: aload 7
    //   630: invokevirtual 181	java/io/OutputStream:flush	()V
    //   633: aload 7
    //   635: invokevirtual 182	java/io/OutputStream:close	()V
    //   638: goto -477 -> 161
    //   641: astore_0
    //   642: goto -481 -> 161
    //   645: astore_0
    //   646: aconst_null
    //   647: astore_1
    //   648: aconst_null
    //   649: astore 6
    //   651: aload 6
    //   653: ifnull +8 -> 661
    //   656: aload 6
    //   658: invokevirtual 300	java/util/zip/CheckedInputStream:close	()V
    //   661: aload 7
    //   663: ifnull +8 -> 671
    //   666: aload 7
    //   668: invokevirtual 178	java/io/InputStream:close	()V
    //   671: aload_1
    //   672: ifnull +11 -> 683
    //   675: aload_1
    //   676: invokevirtual 181	java/io/OutputStream:flush	()V
    //   679: aload_1
    //   680: invokevirtual 182	java/io/OutputStream:close	()V
    //   683: aload_0
    //   684: athrow
    //   685: astore_0
    //   686: aload_0
    //   687: invokevirtual 253	java/io/IOException:printStackTrace	()V
    //   690: bipush 6
    //   692: istore_2
    //   693: goto -421 -> 272
    //   696: astore_0
    //   697: aload_0
    //   698: invokevirtual 319	java/lang/Exception:printStackTrace	()V
    //   701: bipush 7
    //   703: istore_2
    //   704: goto -432 -> 272
    //   707: astore_1
    //   708: goto -137 -> 571
    //   711: astore_0
    //   712: goto -133 -> 579
    //   715: astore 6
    //   717: goto -102 -> 615
    //   720: astore_0
    //   721: goto -98 -> 623
    //   724: astore 6
    //   726: goto -65 -> 661
    //   729: astore 6
    //   731: goto -60 -> 671
    //   734: astore_1
    //   735: goto -52 -> 683
    //   738: astore 8
    //   740: aconst_null
    //   741: astore_1
    //   742: aload_0
    //   743: astore 7
    //   745: aconst_null
    //   746: astore 6
    //   748: aload 8
    //   750: astore_0
    //   751: goto -100 -> 651
    //   754: astore 8
    //   756: aconst_null
    //   757: astore_1
    //   758: aload_0
    //   759: astore 7
    //   761: aload 8
    //   763: astore_0
    //   764: goto -113 -> 651
    //   767: astore 8
    //   769: aload 7
    //   771: astore_1
    //   772: aload_0
    //   773: astore 7
    //   775: aload 8
    //   777: astore_0
    //   778: goto -127 -> 651
    //   781: goto -509 -> 272
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	784	0	paramString1	String
    //   0	784	1	paramString2	String
    //   162	542	2	i	int
    //   134	28	3	j	int
    //   464	36	4	l	long
    //   98	559	6	localObject1	Object
    //   715	1	6	localIOException1	IOException
    //   724	1	6	localIOException2	IOException
    //   729	1	6	localIOException3	IOException
    //   746	1	6	localObject2	Object
    //   354	420	7	localObject3	Object
    //   140	348	8	arrayOfByte	byte[]
    //   738	11	8	localObject4	Object
    //   754	8	8	localObject5	Object
    //   767	9	8	localObject6	Object
    //   131	226	9	localQZipFile	QZipFile
    //   152	238	10	localStringBuilder	StringBuilder
    //   159	15	11	localEnumeration	Enumeration
    //   183	365	12	localZipEntry	ZipEntry
    //   422	11	13	localFile	File
    // Exception table:
    //   from	to	target	type
    //   135	161	265	java/io/FileNotFoundException
    //   163	262	265	java/io/FileNotFoundException
    //   566	571	265	java/io/FileNotFoundException
    //   575	579	265	java/io/FileNotFoundException
    //   584	594	265	java/io/FileNotFoundException
    //   610	615	265	java/io/FileNotFoundException
    //   619	623	265	java/io/FileNotFoundException
    //   628	638	265	java/io/FileNotFoundException
    //   656	661	265	java/io/FileNotFoundException
    //   666	671	265	java/io/FileNotFoundException
    //   675	683	265	java/io/FileNotFoundException
    //   683	685	265	java/io/FileNotFoundException
    //   272	277	279	java/io/IOException
    //   123	133	287	java/util/zip/ZipException
    //   123	133	309	java/io/IOException
    //   123	133	331	java/lang/Exception
    //   584	594	599	java/io/IOException
    //   628	638	641	java/io/IOException
    //   356	364	645	finally
    //   135	161	685	java/io/IOException
    //   163	262	685	java/io/IOException
    //   683	685	685	java/io/IOException
    //   135	161	696	java/lang/Exception
    //   163	262	696	java/lang/Exception
    //   566	571	696	java/lang/Exception
    //   575	579	696	java/lang/Exception
    //   584	594	696	java/lang/Exception
    //   610	615	696	java/lang/Exception
    //   619	623	696	java/lang/Exception
    //   628	638	696	java/lang/Exception
    //   656	661	696	java/lang/Exception
    //   666	671	696	java/lang/Exception
    //   675	683	696	java/lang/Exception
    //   683	685	696	java/lang/Exception
    //   566	571	707	java/io/IOException
    //   575	579	711	java/io/IOException
    //   610	615	715	java/io/IOException
    //   619	623	720	java/io/IOException
    //   656	661	724	java/io/IOException
    //   666	671	729	java/io/IOException
    //   675	683	734	java/io/IOException
    //   364	381	738	finally
    //   381	438	754	finally
    //   438	459	754	finally
    //   459	466	767	finally
    //   473	494	767	finally
    //   504	523	767	finally
    //   525	561	767	finally
  }
  
  public static ArrayList<File> unZipSelectedFile(File paramFile, String paramString1, String paramString2)
  {
    Object localObject1 = null;
    ArrayList localArrayList = new ArrayList();
    Object localObject3 = new File(paramString1);
    if (!((File)localObject3).exists()) {
      ((File)localObject3).mkdir();
    }
    QZipFile localQZipFile = new QZipFile(paramFile);
    Enumeration localEnumeration = localQZipFile.entries();
    for (;;)
    {
      if (localEnumeration.hasMoreElements())
      {
        localObject3 = (ZipEntry)localEnumeration.nextElement();
        if ((((ZipEntry)localObject3).getName().contains("..")) || (!((ZipEntry)localObject3).getName().contains(paramString2))) {
          continue;
        }
        for (;;)
        {
          try
          {
            paramFile = localQZipFile.getInputStream((ZipEntry)localObject3);
          }
          finally
          {
            File localFile;
            label282:
            paramString1 = null;
            paramString2 = localObject2;
            continue;
          }
          try
          {
            localFile = new File(new String((paramString1 + File.separator + ((ZipEntry)localObject3).getName()).getBytes("8859_1"), "GB2312"));
            if (!localFile.exists())
            {
              localObject3 = localFile.getParentFile();
              if (!((File)localObject3).exists()) {
                ((File)localObject3).mkdirs();
              }
            }
            localObject3 = RecycleableBufferedOutputStream.obtain(new BufferedOutputStream(new FileOutputStream(localFile)));
            try
            {
              byte[] arrayOfByte = new byte[1048576];
              int i = paramFile.read(arrayOfByte);
              if (i > 0)
              {
                ((OutputStream)localObject3).write(arrayOfByte, 0, i);
                continue;
                if (paramString1 == null) {}
              }
            }
            finally
            {
              paramString2 = (String)localObject3;
              paramString1 = paramFile;
              paramFile = localObject2;
            }
          }
          finally
          {
            paramString1 = paramFile;
            paramFile = paramString2;
            paramString2 = localObject2;
            continue;
          }
          try
          {
            paramString1.close();
            if (paramString2 == null) {}
          }
          catch (IOException paramString1)
          {
            try
            {
              for (;;)
              {
                paramString2.close();
                throw paramFile;
                localArrayList.add(localFile);
                if (paramFile != null) {}
                try
                {
                  for (;;)
                  {
                    paramFile.close();
                    if (localObject3 == null) {
                      break;
                    }
                    try
                    {
                      ((OutputStream)localObject3).close();
                    }
                    catch (IOException paramFile) {}
                  }
                }
                catch (IOException paramFile)
                {
                  break label282;
                }
              }
              paramString1 = paramString1;
            }
            catch (IOException paramString1) {}
          }
        }
      }
    }
    return localArrayList;
  }
  
  private static void witeInto(QZipInputStream paramQZipInputStream, File paramFile)
  {
    localObject = null;
    File localFile = null;
    byte[] arrayOfByte = new byte[8192];
    try
    {
      paramFile = RecycleableBufferedOutputStream.obtain(new FileOutputStream(paramFile));
      for (;;)
      {
        localFile = paramFile;
        localObject = paramFile;
        int i = paramQZipInputStream.read(arrayOfByte, 0, arrayOfByte.length);
        if (i == -1) {
          break;
        }
        localFile = paramFile;
        localObject = paramFile;
        paramFile.write(arrayOfByte, 0, i);
      }
      try
      {
        ((OutputStream)localObject).close();
        throw paramQZipInputStream;
      }
      catch (IOException paramFile)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ZipUtils", 2, "unZipFile2 解压错误", paramFile);
          }
        }
      }
    }
    catch (Exception paramQZipInputStream)
    {
      localObject = localFile;
      if (QLog.isColorLevel())
      {
        localObject = localFile;
        QLog.e("ZipUtils", 2, "unZipFile2 解压错误", paramQZipInputStream);
      }
      if (localFile != null) {}
      try
      {
        localFile.close();
        do
        {
          do
          {
            return;
          } while (paramFile == null);
          try
          {
            paramFile.close();
            return;
          }
          catch (IOException paramQZipInputStream) {}
        } while (!QLog.isColorLevel());
        QLog.e("ZipUtils", 2, "unZipFile2 解压错误", paramQZipInputStream);
        return;
      }
      catch (IOException paramQZipInputStream)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("ZipUtils", 2, "unZipFile2 解压错误", paramQZipInputStream);
        return;
      }
    }
    finally
    {
      if (localObject == null) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.common.util.ZipUtils
 * JD-Core Version:    0.7.0.1
 */