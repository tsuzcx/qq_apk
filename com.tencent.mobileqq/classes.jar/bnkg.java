import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.testassister.ShareAppLogHelper.LogFile;
import com.tencent.qphone.base.util.QLog;
import common.qzone.component.util.SecurityUtil;
import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class bnkg
{
  public static final String a = "anr" + File.separator + "traces.txt";
  public static final String b = "tencent" + File.separator + "zip";
  
  /* Error */
  private static int a(String paramString, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 22	java/io/File
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 46	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_0
    //   12: new 48	java/util/zip/ZipOutputStream
    //   15: dup
    //   16: new 50	java/io/FileOutputStream
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 53	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   24: invokespecial 56	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   27: astore_3
    //   28: aload_3
    //   29: ifnonnull +14 -> 43
    //   32: aload_3
    //   33: ifnull +7 -> 40
    //   36: aload_3
    //   37: invokevirtual 59	java/util/zip/ZipOutputStream:close	()V
    //   40: bipush 253
    //   42: ireturn
    //   43: sipush 1024
    //   46: newarray byte
    //   48: astore 4
    //   50: new 61	java/util/zip/ZipEntry
    //   53: dup
    //   54: aload_1
    //   55: invokevirtual 64	java/io/File:getName	()Ljava/lang/String;
    //   58: invokespecial 65	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   61: astore 5
    //   63: aload 5
    //   65: aload_1
    //   66: invokevirtual 69	java/io/File:length	()J
    //   69: invokevirtual 73	java/util/zip/ZipEntry:setSize	(J)V
    //   72: aload 5
    //   74: aload_1
    //   75: invokevirtual 76	java/io/File:lastModified	()J
    //   78: invokevirtual 79	java/util/zip/ZipEntry:setTime	(J)V
    //   81: aload_3
    //   82: aload 5
    //   84: invokevirtual 83	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   87: new 85	java/io/BufferedInputStream
    //   90: dup
    //   91: new 87	java/io/FileInputStream
    //   94: dup
    //   95: aload_1
    //   96: invokespecial 88	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   99: invokespecial 91	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   102: astore_1
    //   103: aload_1
    //   104: aload 4
    //   106: iconst_0
    //   107: sipush 1024
    //   110: invokevirtual 97	java/io/InputStream:read	([BII)I
    //   113: istore_2
    //   114: iload_2
    //   115: iconst_m1
    //   116: if_icmpeq +60 -> 176
    //   119: aload_3
    //   120: aload 4
    //   122: iconst_0
    //   123: iload_2
    //   124: invokevirtual 101	java/util/zip/ZipOutputStream:write	([BII)V
    //   127: goto -24 -> 103
    //   130: astore_0
    //   131: aload_1
    //   132: ifnull +7 -> 139
    //   135: aload_1
    //   136: invokevirtual 102	java/io/InputStream:close	()V
    //   139: aload_0
    //   140: athrow
    //   141: astore_0
    //   142: aload_3
    //   143: astore_1
    //   144: aload_1
    //   145: ifnull +7 -> 152
    //   148: aload_1
    //   149: invokevirtual 59	java/util/zip/ZipOutputStream:close	()V
    //   152: aload_0
    //   153: athrow
    //   154: astore_0
    //   155: aload_0
    //   156: invokevirtual 105	java/lang/Exception:printStackTrace	()V
    //   159: invokestatic 111	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   162: ifeq -122 -> 40
    //   165: ldc 113
    //   167: iconst_4
    //   168: ldc 115
    //   170: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   173: bipush 253
    //   175: ireturn
    //   176: aload_1
    //   177: ifnull +7 -> 184
    //   180: aload_1
    //   181: invokevirtual 102	java/io/InputStream:close	()V
    //   184: aload_3
    //   185: invokevirtual 59	java/util/zip/ZipOutputStream:close	()V
    //   188: aload_0
    //   189: invokevirtual 69	java/io/File:length	()J
    //   192: ldc2_w 120
    //   195: lcmp
    //   196: iflt +27 -> 223
    //   199: invokestatic 111	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   202: ifeq +11 -> 213
    //   205: ldc 113
    //   207: iconst_4
    //   208: ldc 123
    //   210: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: aload_3
    //   214: ifnull +7 -> 221
    //   217: aload_3
    //   218: invokevirtual 59	java/util/zip/ZipOutputStream:close	()V
    //   221: iconst_1
    //   222: ireturn
    //   223: invokestatic 111	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   226: ifeq +11 -> 237
    //   229: ldc 113
    //   231: iconst_4
    //   232: ldc 125
    //   234: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   237: aload_3
    //   238: ifnull +7 -> 245
    //   241: aload_3
    //   242: invokevirtual 59	java/util/zip/ZipOutputStream:close	()V
    //   245: iconst_0
    //   246: ireturn
    //   247: astore_0
    //   248: aload 4
    //   250: astore_1
    //   251: goto -107 -> 144
    //   254: astore_0
    //   255: aconst_null
    //   256: astore_1
    //   257: goto -126 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	260	0	paramString	String
    //   0	260	1	paramFile	File
    //   113	11	2	i	int
    //   27	215	3	localZipOutputStream	java.util.zip.ZipOutputStream
    //   1	248	4	arrayOfByte	byte[]
    //   61	22	5	localZipEntry	java.util.zip.ZipEntry
    // Exception table:
    //   from	to	target	type
    //   103	114	130	finally
    //   119	127	130	finally
    //   43	87	141	finally
    //   135	139	141	finally
    //   139	141	141	finally
    //   180	184	141	finally
    //   184	213	141	finally
    //   223	237	141	finally
    //   3	12	154	java/lang/Exception
    //   36	40	154	java/lang/Exception
    //   148	152	154	java/lang/Exception
    //   152	154	154	java/lang/Exception
    //   217	221	154	java/lang/Exception
    //   241	245	154	java/lang/Exception
    //   12	28	247	finally
    //   87	103	254	finally
  }
  
  /* Error */
  private static int a(String paramString, ArrayList<File> paramArrayList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 22	java/io/File
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 46	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_0
    //   12: new 48	java/util/zip/ZipOutputStream
    //   15: dup
    //   16: new 50	java/io/FileOutputStream
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 53	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   24: invokespecial 56	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   27: astore 5
    //   29: aload 5
    //   31: ifnonnull +18 -> 49
    //   34: aload 5
    //   36: ifnull +8 -> 44
    //   39: aload 5
    //   41: invokevirtual 59	java/util/zip/ZipOutputStream:close	()V
    //   44: bipush 253
    //   46: istore_2
    //   47: iload_2
    //   48: ireturn
    //   49: sipush 1024
    //   52: newarray byte
    //   54: astore 6
    //   56: aload_1
    //   57: invokevirtual 132	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   60: astore 7
    //   62: aload 7
    //   64: invokeinterface 137 1 0
    //   69: ifeq +154 -> 223
    //   72: aload 7
    //   74: invokeinterface 141 1 0
    //   79: checkcast 22	java/io/File
    //   82: astore_1
    //   83: new 61	java/util/zip/ZipEntry
    //   86: dup
    //   87: aload_1
    //   88: invokevirtual 64	java/io/File:getName	()Ljava/lang/String;
    //   91: invokespecial 65	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   94: astore 8
    //   96: aload 8
    //   98: aload_1
    //   99: invokevirtual 69	java/io/File:length	()J
    //   102: invokevirtual 73	java/util/zip/ZipEntry:setSize	(J)V
    //   105: aload 8
    //   107: aload_1
    //   108: invokevirtual 76	java/io/File:lastModified	()J
    //   111: invokevirtual 79	java/util/zip/ZipEntry:setTime	(J)V
    //   114: aload 5
    //   116: aload 8
    //   118: invokevirtual 83	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   121: new 85	java/io/BufferedInputStream
    //   124: dup
    //   125: new 87	java/io/FileInputStream
    //   128: dup
    //   129: aload_1
    //   130: invokespecial 88	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   133: invokespecial 91	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   136: astore_1
    //   137: aload_1
    //   138: aload 6
    //   140: iconst_0
    //   141: sipush 1024
    //   144: invokevirtual 97	java/io/InputStream:read	([BII)I
    //   147: istore_2
    //   148: iload_2
    //   149: iconst_m1
    //   150: if_icmpeq +62 -> 212
    //   153: aload 5
    //   155: aload 6
    //   157: iconst_0
    //   158: iload_2
    //   159: invokevirtual 101	java/util/zip/ZipOutputStream:write	([BII)V
    //   162: goto -25 -> 137
    //   165: astore_0
    //   166: aload_1
    //   167: ifnull +7 -> 174
    //   170: aload_1
    //   171: invokevirtual 102	java/io/InputStream:close	()V
    //   174: aload_0
    //   175: athrow
    //   176: astore_0
    //   177: aload 5
    //   179: astore_1
    //   180: aload_1
    //   181: ifnull +7 -> 188
    //   184: aload_1
    //   185: invokevirtual 59	java/util/zip/ZipOutputStream:close	()V
    //   188: aload_0
    //   189: athrow
    //   190: astore_0
    //   191: aload_0
    //   192: invokevirtual 105	java/lang/Exception:printStackTrace	()V
    //   195: invokestatic 111	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   198: ifeq +11 -> 209
    //   201: ldc 113
    //   203: iconst_4
    //   204: ldc 143
    //   206: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   209: bipush 253
    //   211: ireturn
    //   212: aload_1
    //   213: ifnull -151 -> 62
    //   216: aload_1
    //   217: invokevirtual 102	java/io/InputStream:close	()V
    //   220: goto -158 -> 62
    //   223: aload 5
    //   225: invokevirtual 59	java/util/zip/ZipOutputStream:close	()V
    //   228: aload_0
    //   229: invokevirtual 69	java/io/File:length	()J
    //   232: lstore_3
    //   233: lload_3
    //   234: ldc2_w 120
    //   237: lcmp
    //   238: iflt +17 -> 255
    //   241: iconst_1
    //   242: istore_2
    //   243: aload 5
    //   245: ifnull -198 -> 47
    //   248: aload 5
    //   250: invokevirtual 59	java/util/zip/ZipOutputStream:close	()V
    //   253: iconst_1
    //   254: ireturn
    //   255: aload 5
    //   257: ifnull +8 -> 265
    //   260: aload 5
    //   262: invokevirtual 59	java/util/zip/ZipOutputStream:close	()V
    //   265: iconst_0
    //   266: ireturn
    //   267: astore_0
    //   268: aload 6
    //   270: astore_1
    //   271: goto -91 -> 180
    //   274: astore_0
    //   275: aconst_null
    //   276: astore_1
    //   277: goto -111 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	paramString	String
    //   0	280	1	paramArrayList	ArrayList<File>
    //   46	197	2	i	int
    //   232	2	3	l	long
    //   27	234	5	localZipOutputStream	java.util.zip.ZipOutputStream
    //   1	268	6	arrayOfByte	byte[]
    //   60	13	7	localIterator	java.util.Iterator
    //   94	23	8	localZipEntry	java.util.zip.ZipEntry
    // Exception table:
    //   from	to	target	type
    //   137	148	165	finally
    //   153	162	165	finally
    //   49	62	176	finally
    //   62	121	176	finally
    //   170	174	176	finally
    //   174	176	176	finally
    //   216	220	176	finally
    //   223	233	176	finally
    //   3	12	190	java/lang/Exception
    //   39	44	190	java/lang/Exception
    //   184	188	190	java/lang/Exception
    //   188	190	190	java/lang/Exception
    //   248	253	190	java/lang/Exception
    //   260	265	190	java/lang/Exception
    //   12	29	267	finally
    //   121	137	274	finally
  }
  
  public static long a(String paramString)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return -1L;
      if (paramString.length() == 10) {
        try
        {
          Date localDate = new SimpleDateFormat("yyyyMMddHH").parse(paramString.trim());
          if (localDate != null)
          {
            long l = localDate.getTime();
            return l;
          }
        }
        catch (Exception localException)
        {
          localException = localException;
          QLog.e("QZoneAppCtrlUploadFileLogic", 1, "error time = " + paramString);
          localException.printStackTrace();
          return -1L;
        }
        finally {}
      }
    }
    return -1L;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramContext = new File(bigv.a(Environment.getDataDirectory().getAbsolutePath() + File.separator + "anr"));
    } while ((!paramContext.isDirectory()) || (paramContext.listFiles() == null));
    Object localObject = bigv.a(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + b + File.separator + "ANR");
    String str = (String)localObject + File.separator + "upload.log.zip";
    localObject = new File((String)localObject);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    a(paramContext, str, paramString);
  }
  
  public static void a(Context paramContext, String paramString, long paramLong1, long paramLong2)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return;
      } while ((paramLong1 <= 0L) || (paramLong2 <= paramLong1));
      localObject1 = new File(bigv.a(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "tencent" + File.separator + "MobileQQ" + File.separator + "trace")).listFiles(new bnkh(paramLong1, paramLong2));
      localObject2 = new bnki();
      paramContext = new ArrayList();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("QZoneAppCtrlUploadFileLogic", 4, "logFiles length" + localObject1.length);
        }
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          paramContext.add(new ShareAppLogHelper.LogFile(localObject1[i].getPath()));
          Collections.sort(paramContext, (Comparator)localObject2);
          i += 1;
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("QZoneAppCtrlUploadFileLogic", 4, "find file: " + paramContext.size());
      }
    } while (paramContext.size() == 0);
    Object localObject2 = bigv.a(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + b + File.separator + "TRACE");
    Object localObject1 = (String)localObject2 + File.separator + "upload.log.zip";
    localObject2 = new File((String)localObject2);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    a((File)paramContext.get(paramContext.size() - 1), (String)localObject1, paramString);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    Object localObject = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      localObject = SecurityUtil.a(paramString1);
    }
    paramContext = paramContext.getFilesDir().getParent() + File.separator + "databases" + File.separator + (String)localObject;
    paramString2 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + b + File.separator + "DB";
    localObject = new File(bigv.a(paramString2));
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    paramString2 = bigv.a(paramString2 + File.separator + "upload.log.zip");
    a(new File(paramContext), paramString2, paramString1);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)) || (paramContext == null)) {}
    label251:
    for (;;)
    {
      return;
      String str = null;
      if (paramBoolean) {
        if (paramContext.getFilesDir() == null) {}
      }
      for (str = paramContext.getFilesDir().getParent();; str = bigv.a(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "tencent"))
      {
        if (TextUtils.isEmpty(str)) {
          break label251;
        }
        paramContext = bigv.a(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + b + File.separator + "custom");
        File localFile = new File(paramContext);
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
        paramContext = paramContext + File.separator + "upload.log.zip";
        paramString1 = new File(str, paramString1);
        if ((!paramString1.isFile()) || (paramString1.length() >= paramLong)) {
          break;
        }
        a(paramString1, paramContext, paramString2);
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.d("QZoneAppCtrlUploadFileLogic", 4, "uploadByCustom filename: " + paramContext);
        return;
      }
    }
  }
  
  public static boolean a(File paramFile, FilenameFilter paramFilenameFilter, String paramString1, String paramString2)
  {
    if ((paramFile == null) || (!paramFile.exists())) {
      return false;
    }
    if (paramFile.exists())
    {
      int j = -3;
      int i = j;
      if (paramFile.getName().contains("avsdk"))
      {
        i = j;
        if (paramFile.isDirectory())
        {
          ArrayList localArrayList = new ArrayList();
          paramFilenameFilter = paramFile.listFiles(paramFilenameFilter);
          if ((paramFilenameFilter == null) || (paramFilenameFilter.length == 0))
          {
            QLog.w("QZoneAppCtrlUploadFileLogic", 2, "files is empty");
            return false;
          }
          j = paramFilenameFilter.length;
          i = 0;
          while (i < j)
          {
            localArrayList.add(paramFilenameFilter[i]);
            i += 1;
          }
          i = a(paramString1, localArrayList);
        }
      }
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.w("QZoneAppCtrlUploadFileLogic", 2, "uploadFile zip file error code" + i);
        }
        bhmi.d(paramString1);
        return false;
      }
    }
    return b(paramFile, paramString1, paramString2);
  }
  
  public static boolean a(File paramFile, String paramString1, String paramString2)
  {
    if ((paramFile == null) || (!paramFile.exists())) {
      return false;
    }
    if (paramFile.exists())
    {
      ArrayList localArrayList;
      if ((paramFile.getName().contains("anr")) && (paramFile.isDirectory()))
      {
        localArrayList = new ArrayList();
        File[] arrayOfFile = paramFile.listFiles();
        int j = arrayOfFile.length;
        i = 0;
        while (i < j)
        {
          localArrayList.add(arrayOfFile[i]);
          i += 1;
        }
      }
      for (int i = a(paramString1, localArrayList);; i = a(paramString1, paramFile))
      {
        if (i == 0) {
          break label150;
        }
        if (QLog.isColorLevel()) {
          QLog.w("QZoneAppCtrlUploadFileLogic", 2, "uploadFile zip file error code" + i);
        }
        bhmi.d(paramString1);
        return false;
        if (!paramFile.isFile()) {
          break;
        }
      }
    }
    label150:
    return b(paramFile, paramString1, paramString2);
  }
  
  public static void b(Context paramContext, String paramString)
  {
    paramContext = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramContext = bigv.a(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "tencent");
    }
    for (;;)
    {
      int i;
      try
      {
        paramContext = new File(paramContext);
        if (paramContext.isDirectory())
        {
          QLog.e("QZoneAppCtrlUploadFileLogic", 1, "showDirFileList dirPath:" + paramContext.getAbsolutePath());
          paramContext = paramContext.listFiles();
          if (paramContext != null)
          {
            i = 0;
            if (i < paramContext.length)
            {
              if (paramContext[i].isDirectory()) {
                QLog.e("QZoneAppCtrlUploadFileLogic", 1, "dir:" + paramContext[i].getAbsolutePath());
              }
              if (!paramContext[i].isFile()) {
                break label246;
              }
              QLog.e("QZoneAppCtrlUploadFileLogic", 1, "file:" + paramContext[i].getAbsolutePath() + ",size:" + paramContext[i].length());
              break label246;
            }
          }
        }
        else if (paramContext.isFile())
        {
          QLog.e("QZoneAppCtrlUploadFileLogic", 1, "showDirFileList filePath:" + paramContext.getAbsolutePath());
        }
        return;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
      label246:
      i += 1;
    }
  }
  
  public static void b(Context paramContext, String paramString, long paramLong1, long paramLong2)
  {
    if (TextUtils.isEmpty(paramString)) {}
    bnkj localbnkj;
    do
    {
      return;
      paramContext = new File(bigv.a(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "tencent" + File.separator + "mobileqq" + File.separator + "log" + File.separator + "avsdk"));
      localbnkj = new bnkj(paramLong1, paramLong2);
    } while ((!paramContext.isDirectory()) || (paramContext.listFiles() == null));
    Object localObject = bigv.a(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + b + File.separator + "avsdk");
    String str = (String)localObject + File.separator + "upload.log.zip";
    localObject = new File((String)localObject);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    a(paramContext, localbnkj, str, paramString);
  }
  
  /* Error */
  public static boolean b(File paramFile, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 22	java/io/File
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 46	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore 7
    //   13: aload 7
    //   15: invokevirtual 213	java/io/File:exists	()Z
    //   18: ifne +5 -> 23
    //   21: iconst_0
    //   22: ireturn
    //   23: invokestatic 111	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   26: ifeq +58 -> 84
    //   29: ldc 113
    //   31: iconst_4
    //   32: new 11	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   39: ldc_w 350
    //   42: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_1
    //   46: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: ldc 113
    //   57: iconst_4
    //   58: new 11	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   65: ldc_w 352
    //   68: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_0
    //   72: invokevirtual 191	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   75: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   84: invokestatic 358	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   87: invokevirtual 359	java/util/UUID:toString	()Ljava/lang/String;
    //   90: astore_0
    //   91: new 361	java/net/URL
    //   94: dup
    //   95: ldc_w 363
    //   98: invokespecial 364	java/net/URL:<init>	(Ljava/lang/String;)V
    //   101: invokevirtual 368	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   104: checkcast 370	java/net/HttpURLConnection
    //   107: astore 6
    //   109: aload 6
    //   111: ldc_w 371
    //   114: invokevirtual 375	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   117: aload 6
    //   119: ldc_w 371
    //   122: invokevirtual 378	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   125: aload 6
    //   127: iconst_1
    //   128: invokevirtual 382	java/net/HttpURLConnection:setDoInput	(Z)V
    //   131: aload 6
    //   133: iconst_1
    //   134: invokevirtual 385	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   137: aload 6
    //   139: iconst_0
    //   140: invokevirtual 388	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   143: aload 6
    //   145: ldc_w 390
    //   148: invokevirtual 393	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   151: aload 6
    //   153: ldc_w 395
    //   156: ldc_w 397
    //   159: invokevirtual 400	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: aload 6
    //   164: ldc_w 402
    //   167: ldc_w 404
    //   170: invokevirtual 400	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: aload 6
    //   175: ldc_w 406
    //   178: new 11	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   185: ldc_w 408
    //   188: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload_0
    //   192: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokevirtual 400	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: aload 7
    //   203: ifnull +189 -> 392
    //   206: aload 6
    //   208: invokevirtual 412	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   211: astore_1
    //   212: new 414	java/io/DataOutputStream
    //   215: dup
    //   216: aload_1
    //   217: invokespecial 415	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   220: astore 4
    //   222: new 417	java/lang/StringBuffer
    //   225: dup
    //   226: invokespecial 418	java/lang/StringBuffer:<init>	()V
    //   229: astore_1
    //   230: aload_1
    //   231: ldc_w 420
    //   234: invokevirtual 423	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   237: pop
    //   238: aload_1
    //   239: aload_0
    //   240: invokevirtual 423	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   243: pop
    //   244: aload_1
    //   245: ldc_w 425
    //   248: invokevirtual 423	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   251: pop
    //   252: aload_1
    //   253: new 11	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   260: ldc_w 427
    //   263: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload 7
    //   268: invokevirtual 64	java/io/File:getName	()Ljava/lang/String;
    //   271: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: ldc_w 429
    //   277: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: ldc_w 425
    //   283: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokevirtual 423	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   292: pop
    //   293: aload_1
    //   294: ldc_w 431
    //   297: invokevirtual 423	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   300: pop
    //   301: aload_1
    //   302: ldc_w 425
    //   305: invokevirtual 423	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   308: pop
    //   309: aload 4
    //   311: aload_1
    //   312: invokevirtual 432	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   315: invokevirtual 436	java/lang/String:getBytes	()[B
    //   318: invokevirtual 439	java/io/DataOutputStream:write	([B)V
    //   321: new 87	java/io/FileInputStream
    //   324: dup
    //   325: aload 7
    //   327: invokespecial 88	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   330: astore_1
    //   331: sipush 1024
    //   334: newarray byte
    //   336: astore 5
    //   338: aload_1
    //   339: aload 5
    //   341: invokevirtual 442	java/io/InputStream:read	([B)I
    //   344: istore_3
    //   345: iload_3
    //   346: iconst_m1
    //   347: if_icmpeq +47 -> 394
    //   350: aload 4
    //   352: aload 5
    //   354: iconst_0
    //   355: iload_3
    //   356: invokevirtual 443	java/io/DataOutputStream:write	([BII)V
    //   359: goto -21 -> 338
    //   362: astore_0
    //   363: aload_1
    //   364: ifnull +7 -> 371
    //   367: aload_1
    //   368: invokevirtual 102	java/io/InputStream:close	()V
    //   371: aload_0
    //   372: athrow
    //   373: astore_0
    //   374: aload 4
    //   376: astore_1
    //   377: aload_1
    //   378: ifnull +7 -> 385
    //   381: aload_1
    //   382: invokevirtual 444	java/io/DataOutputStream:close	()V
    //   385: aload_0
    //   386: athrow
    //   387: astore_0
    //   388: aload_0
    //   389: invokevirtual 445	java/net/MalformedURLException:printStackTrace	()V
    //   392: iconst_0
    //   393: ireturn
    //   394: aload_1
    //   395: ifnull +7 -> 402
    //   398: aload_1
    //   399: invokevirtual 102	java/io/InputStream:close	()V
    //   402: aload 4
    //   404: ldc_w 425
    //   407: invokevirtual 436	java/lang/String:getBytes	()[B
    //   410: invokevirtual 439	java/io/DataOutputStream:write	([B)V
    //   413: aload 4
    //   415: new 11	java/lang/StringBuilder
    //   418: dup
    //   419: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   422: ldc_w 420
    //   425: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: aload_0
    //   429: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: ldc_w 425
    //   435: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   441: invokevirtual 436	java/lang/String:getBytes	()[B
    //   444: invokevirtual 439	java/io/DataOutputStream:write	([B)V
    //   447: new 11	java/lang/StringBuilder
    //   450: dup
    //   451: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   454: astore_1
    //   455: aload_1
    //   456: ldc_w 447
    //   459: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: pop
    //   463: aload_1
    //   464: ldc_w 425
    //   467: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: pop
    //   471: aload_1
    //   472: new 11	java/lang/StringBuilder
    //   475: dup
    //   476: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   479: aload_2
    //   480: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: ldc_w 425
    //   486: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   492: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: pop
    //   496: aload_1
    //   497: new 11	java/lang/StringBuilder
    //   500: dup
    //   501: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   504: ldc_w 420
    //   507: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: aload_0
    //   511: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: ldc_w 425
    //   517: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   523: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: pop
    //   527: aload_1
    //   528: ldc_w 449
    //   531: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: pop
    //   535: aload_1
    //   536: ldc_w 425
    //   539: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: pop
    //   543: aload_1
    //   544: ldc_w 451
    //   547: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: pop
    //   551: aload_1
    //   552: new 11	java/lang/StringBuilder
    //   555: dup
    //   556: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   559: ldc_w 420
    //   562: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: aload_0
    //   566: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: ldc_w 425
    //   572: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   578: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: pop
    //   582: aload 4
    //   584: aload_1
    //   585: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   588: invokevirtual 436	java/lang/String:getBytes	()[B
    //   591: invokevirtual 439	java/io/DataOutputStream:write	([B)V
    //   594: aload 4
    //   596: invokevirtual 454	java/io/DataOutputStream:flush	()V
    //   599: aload 4
    //   601: ifnull +8 -> 609
    //   604: aload 4
    //   606: invokevirtual 444	java/io/DataOutputStream:close	()V
    //   609: aload 6
    //   611: invokevirtual 457	java/net/HttpURLConnection:getResponseCode	()I
    //   614: istore_3
    //   615: new 459	java/io/BufferedReader
    //   618: dup
    //   619: new 461	java/io/InputStreamReader
    //   622: dup
    //   623: aload 6
    //   625: invokevirtual 465	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   628: ldc_w 467
    //   631: invokespecial 470	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   634: invokespecial 473	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   637: astore_0
    //   638: aload_0
    //   639: invokevirtual 476	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   642: astore_1
    //   643: aload_1
    //   644: ifnull +27 -> 671
    //   647: invokestatic 111	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   650: ifeq -12 -> 638
    //   653: ldc 113
    //   655: iconst_4
    //   656: aload_1
    //   657: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   660: goto -22 -> 638
    //   663: astore_0
    //   664: aload_0
    //   665: invokevirtual 477	java/io/IOException:printStackTrace	()V
    //   668: goto -276 -> 392
    //   671: iload_3
    //   672: sipush 200
    //   675: if_icmpne -283 -> 392
    //   678: invokestatic 111	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   681: ifeq +12 -> 693
    //   684: ldc 113
    //   686: iconst_4
    //   687: ldc_w 479
    //   690: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   693: iconst_1
    //   694: ireturn
    //   695: astore_0
    //   696: aload 5
    //   698: astore_1
    //   699: goto -322 -> 377
    //   702: astore_0
    //   703: aconst_null
    //   704: astore_1
    //   705: goto -342 -> 363
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	708	0	paramFile	File
    //   0	708	1	paramString1	String
    //   0	708	2	paramString2	String
    //   344	332	3	i	int
    //   220	385	4	localDataOutputStream	java.io.DataOutputStream
    //   1	696	5	arrayOfByte	byte[]
    //   107	517	6	localHttpURLConnection	java.net.HttpURLConnection
    //   11	315	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   331	338	362	finally
    //   338	345	362	finally
    //   350	359	362	finally
    //   222	321	373	finally
    //   367	371	373	finally
    //   371	373	373	finally
    //   398	402	373	finally
    //   402	599	373	finally
    //   91	201	387	java/net/MalformedURLException
    //   206	212	387	java/net/MalformedURLException
    //   381	385	387	java/net/MalformedURLException
    //   385	387	387	java/net/MalformedURLException
    //   604	609	387	java/net/MalformedURLException
    //   609	638	387	java/net/MalformedURLException
    //   638	643	387	java/net/MalformedURLException
    //   647	660	387	java/net/MalformedURLException
    //   678	693	387	java/net/MalformedURLException
    //   91	201	663	java/io/IOException
    //   206	212	663	java/io/IOException
    //   381	385	663	java/io/IOException
    //   385	387	663	java/io/IOException
    //   604	609	663	java/io/IOException
    //   609	638	663	java/io/IOException
    //   638	643	663	java/io/IOException
    //   647	660	663	java/io/IOException
    //   678	693	663	java/io/IOException
    //   212	222	695	finally
    //   321	331	702	finally
  }
  
  /* Error */
  public static void c(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: invokestatic 486	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   3: ldc_w 488
    //   6: invokevirtual 492	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   9: invokevirtual 495	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   12: astore 9
    //   14: invokestatic 498	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   17: ldc_w 500
    //   20: invokevirtual 503	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   23: ifeq +481 -> 504
    //   26: new 22	java/io/File
    //   29: dup
    //   30: new 11	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   37: invokestatic 206	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   40: invokevirtual 191	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   43: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: getstatic 25	java/io/File:separator	Ljava/lang/String;
    //   49: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: getstatic 39	bnkg:b	Ljava/lang/String;
    //   55: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: getstatic 25	java/io/File:separator	Ljava/lang/String;
    //   61: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: ldc_w 505
    //   67: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 196	bigv:a	(Ljava/lang/String;)Ljava/lang/String;
    //   76: invokespecial 46	java/io/File:<init>	(Ljava/lang/String;)V
    //   79: astore 8
    //   81: aload 8
    //   83: invokevirtual 213	java/io/File:exists	()Z
    //   86: ifne +45 -> 131
    //   89: invokestatic 111	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   92: ifeq +33 -> 125
    //   95: ldc 113
    //   97: iconst_4
    //   98: new 11	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   105: ldc_w 507
    //   108: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload 8
    //   113: invokevirtual 191	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   116: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   125: aload 8
    //   127: invokevirtual 216	java/io/File:mkdirs	()Z
    //   130: pop
    //   131: new 22	java/io/File
    //   134: dup
    //   135: new 11	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   142: invokestatic 206	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   145: invokevirtual 191	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   148: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: getstatic 25	java/io/File:separator	Ljava/lang/String;
    //   154: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: getstatic 39	bnkg:b	Ljava/lang/String;
    //   160: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: getstatic 25	java/io/File:separator	Ljava/lang/String;
    //   166: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: ldc_w 505
    //   172: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: getstatic 25	java/io/File:separator	Ljava/lang/String;
    //   178: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload_1
    //   182: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: ldc_w 509
    //   188: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 196	bigv:a	(Ljava/lang/String;)Ljava/lang/String;
    //   197: invokespecial 46	java/io/File:<init>	(Ljava/lang/String;)V
    //   200: astore 8
    //   202: aload 8
    //   204: invokevirtual 213	java/io/File:exists	()Z
    //   207: ifne +303 -> 510
    //   210: invokestatic 111	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   213: ifeq +33 -> 246
    //   216: ldc 113
    //   218: iconst_4
    //   219: new 11	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   226: ldc_w 511
    //   229: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload 8
    //   234: invokevirtual 191	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   237: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   246: aload 8
    //   248: invokevirtual 514	java/io/File:createNewFile	()Z
    //   251: pop
    //   252: goto +258 -> 510
    //   255: sipush 1024
    //   258: newarray byte
    //   260: astore 10
    //   262: ldc_w 515
    //   265: istore_2
    //   266: invokestatic 111	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   269: ifeq +12 -> 281
    //   272: ldc 113
    //   274: iconst_4
    //   275: ldc_w 517
    //   278: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   281: new 50	java/io/FileOutputStream
    //   284: dup
    //   285: aload 8
    //   287: invokespecial 53	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   290: astore 8
    //   292: invokestatic 522	java/lang/System:currentTimeMillis	()J
    //   295: lstore 4
    //   297: iload_2
    //   298: ifle +78 -> 376
    //   301: invokestatic 522	java/lang/System:currentTimeMillis	()J
    //   304: lstore 6
    //   306: lload 6
    //   308: lload 4
    //   310: lsub
    //   311: ldc2_w 523
    //   314: lcmp
    //   315: ifle +77 -> 392
    //   318: invokestatic 111	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   321: ifeq +55 -> 376
    //   324: ldc 113
    //   326: iconst_4
    //   327: new 11	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   334: ldc_w 526
    //   337: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: lload 6
    //   342: invokevirtual 333	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   345: ldc_w 528
    //   348: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: lload 4
    //   353: invokevirtual 333	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   356: ldc_w 530
    //   359: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: lload 6
    //   364: lload 4
    //   366: lsub
    //   367: invokevirtual 333	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   370: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   376: aload 8
    //   378: invokevirtual 531	java/io/FileOutputStream:close	()V
    //   381: aload_0
    //   382: aload_1
    //   383: invokestatic 533	bnkg:d	(Landroid/content/Context;Ljava/lang/String;)V
    //   386: aload 9
    //   388: invokevirtual 102	java/io/InputStream:close	()V
    //   391: return
    //   392: aload 9
    //   394: aload 10
    //   396: iconst_0
    //   397: iload_2
    //   398: aload 10
    //   400: arraylength
    //   401: invokestatic 539	java/lang/Math:min	(II)I
    //   404: invokevirtual 97	java/io/InputStream:read	([BII)I
    //   407: istore_3
    //   408: iload_3
    //   409: iconst_m1
    //   410: if_icmpne +78 -> 488
    //   413: new 541	java/io/EOFException
    //   416: dup
    //   417: ldc_w 543
    //   420: invokespecial 544	java/io/EOFException:<init>	(Ljava/lang/String;)V
    //   423: athrow
    //   424: astore 10
    //   426: aload 8
    //   428: invokevirtual 531	java/io/FileOutputStream:close	()V
    //   431: aload_0
    //   432: aload_1
    //   433: invokestatic 533	bnkg:d	(Landroid/content/Context;Ljava/lang/String;)V
    //   436: aload 10
    //   438: athrow
    //   439: astore_0
    //   440: aload 9
    //   442: invokevirtual 102	java/io/InputStream:close	()V
    //   445: aload_0
    //   446: athrow
    //   447: astore_0
    //   448: aload_0
    //   449: invokevirtual 477	java/io/IOException:printStackTrace	()V
    //   452: invokestatic 111	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   455: ifeq -64 -> 391
    //   458: ldc 113
    //   460: iconst_4
    //   461: new 11	java/lang/StringBuilder
    //   464: dup
    //   465: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   468: ldc_w 546
    //   471: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: aload_0
    //   475: invokevirtual 547	java/io/IOException:toString	()Ljava/lang/String;
    //   478: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   487: return
    //   488: aload 8
    //   490: aload 10
    //   492: iconst_0
    //   493: iload_3
    //   494: invokevirtual 548	java/io/FileOutputStream:write	([BII)V
    //   497: iload_2
    //   498: iload_3
    //   499: isub
    //   500: istore_2
    //   501: goto -204 -> 297
    //   504: aconst_null
    //   505: astore 8
    //   507: goto -252 -> 255
    //   510: goto -255 -> 255
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	513	0	paramContext	Context
    //   0	513	1	paramString	String
    //   265	236	2	i	int
    //   407	93	3	j	int
    //   295	70	4	l1	long
    //   304	59	6	l2	long
    //   79	427	8	localObject	Object
    //   12	429	9	localInputStream	java.io.InputStream
    //   260	139	10	arrayOfByte1	byte[]
    //   424	67	10	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   292	297	424	finally
    //   301	306	424	finally
    //   318	376	424	finally
    //   392	408	424	finally
    //   413	424	424	finally
    //   488	497	424	finally
    //   281	292	439	finally
    //   376	386	439	finally
    //   426	439	439	finally
    //   0	125	447	java/io/IOException
    //   125	131	447	java/io/IOException
    //   131	246	447	java/io/IOException
    //   246	252	447	java/io/IOException
    //   255	262	447	java/io/IOException
    //   266	281	447	java/io/IOException
    //   386	391	447	java/io/IOException
    //   440	447	447	java/io/IOException
  }
  
  public static void d(Context paramContext, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QZoneAppCtrlUploadFileLogic", 4, "uploadLogcat start zip");
    }
    paramContext = new File(bigv.a(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + b + File.separator + "LOGCAT" + File.separator + paramString + "logcatwyx.txt"));
    if (!paramContext.exists()) {
      return;
    }
    Object localObject = bigv.a(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + b + File.separator + "LOGCAT");
    String str = (String)localObject + File.separator + "upload.log.zip";
    localObject = new File((String)localObject);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    a(paramContext, str, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnkg
 * JD-Core Version:    0.7.0.1
 */