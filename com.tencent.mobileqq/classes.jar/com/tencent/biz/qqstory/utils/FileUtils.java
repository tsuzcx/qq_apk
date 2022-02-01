package com.tencent.biz.qqstory.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.provider.MediaStore.Video.Media;
import android.text.TextUtils;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import java.io.File;
import mqq.os.MqqHandler;

public class FileUtils
{
  private static String a = null;
  
  public static long a()
  {
    return com.tencent.mobileqq.utils.FileUtils.c();
  }
  
  public static long a(String paramString)
  {
    try
    {
      long l = new File(paramString).length();
      return l;
    }
    catch (Exception paramString)
    {
      SLog.c("Q.qqstory:Utils", paramString, "", new Object[0]);
    }
    return -1L;
  }
  
  public static ContentValues a(Context paramContext, File paramFile)
  {
    paramContext = new ContentValues();
    paramContext.put("title", paramFile.getName());
    paramContext.put("_display_name", paramFile.getName());
    paramContext.put("mime_type", "video/mp4");
    paramContext.put("datetaken", Long.valueOf(paramFile.lastModified()));
    paramContext.put("date_modified", Long.valueOf(paramFile.lastModified()));
    paramContext.put("date_added", Long.valueOf(paramFile.lastModified()));
    paramContext.put("_data", paramFile.getAbsolutePath());
    paramContext.put("_size", Long.valueOf(paramFile.length()));
    return paramContext;
  }
  
  public static File a(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      if ((paramString.getParentFile() == null) || (paramString.getParentFile().exists())) {
        break label50;
      }
      if (paramString.getParentFile().mkdirs()) {
        paramString.createNewFile();
      }
    }
    return paramString;
    label50:
    paramString.createNewFile();
    return paramString;
  }
  
  /* Error */
  public static String a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_0
    //   4: invokevirtual 112	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   7: aload_1
    //   8: invokevirtual 118	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   11: astore_3
    //   12: aload_0
    //   13: aload_1
    //   14: iconst_0
    //   15: invokevirtual 122	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   18: astore 5
    //   20: aload 5
    //   22: astore 6
    //   24: aload_3
    //   25: astore 4
    //   27: ldc 123
    //   29: newarray byte
    //   31: astore 8
    //   33: aload 5
    //   35: astore 6
    //   37: aload_3
    //   38: astore 4
    //   40: aload_3
    //   41: aload 8
    //   43: invokevirtual 129	java/io/InputStream:read	([B)I
    //   46: istore_2
    //   47: iload_2
    //   48: ifle +60 -> 108
    //   51: aload 5
    //   53: astore 6
    //   55: aload_3
    //   56: astore 4
    //   58: aload 5
    //   60: aload 8
    //   62: iconst_0
    //   63: iload_2
    //   64: invokevirtual 135	java/io/FileOutputStream:write	([BII)V
    //   67: goto -34 -> 33
    //   70: astore_1
    //   71: aload 5
    //   73: astore_0
    //   74: aload_0
    //   75: astore 6
    //   77: aload_3
    //   78: astore 4
    //   80: aload_1
    //   81: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   84: aload_3
    //   85: ifnull +7 -> 92
    //   88: aload_3
    //   89: invokevirtual 141	java/io/InputStream:close	()V
    //   92: aload 7
    //   94: astore_1
    //   95: aload_0
    //   96: ifnull +10 -> 106
    //   99: aload_0
    //   100: invokevirtual 142	java/io/FileOutputStream:close	()V
    //   103: aload 7
    //   105: astore_1
    //   106: aload_1
    //   107: areturn
    //   108: aload 5
    //   110: astore 6
    //   112: aload_3
    //   113: astore 4
    //   115: aload 5
    //   117: invokevirtual 145	java/io/FileOutputStream:flush	()V
    //   120: aload 5
    //   122: astore 6
    //   124: aload_3
    //   125: astore 4
    //   127: aload_0
    //   128: aload_1
    //   129: invokevirtual 148	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   132: invokevirtual 86	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   135: astore_0
    //   136: aload_3
    //   137: ifnull +7 -> 144
    //   140: aload_3
    //   141: invokevirtual 141	java/io/InputStream:close	()V
    //   144: aload_0
    //   145: astore_1
    //   146: aload 5
    //   148: ifnull -42 -> 106
    //   151: aload 5
    //   153: invokevirtual 142	java/io/FileOutputStream:close	()V
    //   156: aload_0
    //   157: areturn
    //   158: astore_1
    //   159: aload_0
    //   160: areturn
    //   161: astore_0
    //   162: aconst_null
    //   163: astore 6
    //   165: aconst_null
    //   166: astore_3
    //   167: aload_3
    //   168: ifnull +7 -> 175
    //   171: aload_3
    //   172: invokevirtual 141	java/io/InputStream:close	()V
    //   175: aload 6
    //   177: ifnull +8 -> 185
    //   180: aload 6
    //   182: invokevirtual 142	java/io/FileOutputStream:close	()V
    //   185: aload_0
    //   186: athrow
    //   187: astore_1
    //   188: goto -44 -> 144
    //   191: astore_1
    //   192: goto -100 -> 92
    //   195: astore_0
    //   196: aconst_null
    //   197: areturn
    //   198: astore_1
    //   199: goto -24 -> 175
    //   202: astore_1
    //   203: goto -18 -> 185
    //   206: astore_0
    //   207: aconst_null
    //   208: astore 6
    //   210: goto -43 -> 167
    //   213: astore_0
    //   214: aload 4
    //   216: astore_3
    //   217: goto -50 -> 167
    //   220: astore_1
    //   221: aconst_null
    //   222: astore_0
    //   223: aconst_null
    //   224: astore_3
    //   225: goto -151 -> 74
    //   228: astore_1
    //   229: aconst_null
    //   230: astore_0
    //   231: goto -157 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	paramContext	Context
    //   0	234	1	paramString	String
    //   46	18	2	i	int
    //   11	214	3	localObject1	Object
    //   25	190	4	localObject2	Object
    //   18	134	5	localFileOutputStream	java.io.FileOutputStream
    //   22	187	6	localObject3	Object
    //   1	103	7	localObject4	Object
    //   31	30	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   27	33	70	java/io/IOException
    //   40	47	70	java/io/IOException
    //   58	67	70	java/io/IOException
    //   115	120	70	java/io/IOException
    //   127	136	70	java/io/IOException
    //   151	156	158	java/io/IOException
    //   3	12	161	finally
    //   140	144	187	java/io/IOException
    //   88	92	191	java/io/IOException
    //   99	103	195	java/io/IOException
    //   171	175	198	java/io/IOException
    //   180	185	202	java/io/IOException
    //   12	20	206	finally
    //   27	33	213	finally
    //   40	47	213	finally
    //   58	67	213	finally
    //   80	84	213	finally
    //   115	120	213	finally
    //   127	136	213	finally
    //   3	12	220	java/io/IOException
    //   12	20	228	java/io/IOException
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    int i = paramString.lastIndexOf("/");
    int j = paramString.lastIndexOf(".");
    if ((i > 0) && (j > i)) {
      return paramString.substring(i + 1, j);
    }
    return "";
  }
  
  public static void a(Context paramContext, File paramFile)
  {
    ContentResolver localContentResolver = paramContext.getContentResolver();
    ContentValues localContentValues = a(paramContext, paramFile);
    try
    {
      localContentResolver.insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, localContentValues);
      b(paramContext, paramFile);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        SLog.b("Q.qqstory:Utils", "exception", localException);
      }
    }
  }
  
  public static void a(File paramFile)
  {
    SLog.d("Q.qqstory:Utils", "delete " + paramFile);
    if (paramFile.isFile()) {
      paramFile.delete();
    }
    while (!paramFile.isDirectory()) {
      return;
    }
    File[] arrayOfFile = paramFile.listFiles();
    if ((arrayOfFile == null) || (arrayOfFile.length == 0))
    {
      paramFile.delete();
      return;
    }
    int i = 0;
    while (i < arrayOfFile.length)
    {
      a(arrayOfFile[i]);
      i += 1;
    }
    paramFile.delete();
  }
  
  public static void a(String paramString)
  {
    String str = paramString + "/" + "dont_delete.txt";
    if (!c(str))
    {
      a(paramString);
      SLog.d("Q.qqstory:Utils", "make flag file %b", new Object[] { Boolean.valueOf(com.tencent.mobileqq.utils.FileUtils.a(str, String.valueOf(System.currentTimeMillis()))) });
      return;
    }
    SLog.d("Q.qqstory:Utils", "flag file exist");
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    SLog.d("Q.qqstory:Utils", "delete %s", new Object[] { paramString });
    com.tencent.mobileqq.utils.FileUtils.a(paramString, paramBoolean);
  }
  
  public static boolean a()
  {
    long l = a();
    SLog.b("Q.qqstory:Utils", "free spac:" + l / 1024L / 1024L + "MB--" + l);
    return l < 52428800L;
  }
  
  public static boolean a(long paramLong)
  {
    long l = a();
    SLog.b("Q.qqstory:Utils", "free spac:" + l / 1024L / 1024L + "MB--" + l);
    return l < paramLong * 1024L * 1024L;
  }
  
  public static boolean a(Context paramContext)
  {
    if (!a()) {
      return false;
    }
    SLog.d("Q.qqstory:Utils", "low capacity!");
    if ((paramContext instanceof QQStoryBaseActivity)) {}
    for (boolean bool = ((QQStoryBaseActivity)paramContext).isValidate();; bool = true)
    {
      if (bool) {
        ThreadManager.getUIHandler().post(new FileUtils.1(paramContext));
      }
      return true;
    }
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    if (!paramString1.exists()) {
      return false;
    }
    paramString2 = new File(paramString2);
    String str = paramString2.getParent();
    if (str != null) {
      a(str);
    }
    boolean bool = a(paramString1, paramString2);
    SLog.c("Q.qqstory:Utils", "saveVideoToAlbum: " + bool);
    b(paramContext, paramString2);
    return true;
  }
  
  /* Error */
  public static boolean a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: new 318	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 320	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_3
    //   9: new 322	java/io/BufferedOutputStream
    //   12: dup
    //   13: new 131	java/io/FileOutputStream
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 323	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   21: invokespecial 326	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   24: astore_1
    //   25: sipush 4096
    //   28: newarray byte
    //   30: astore_0
    //   31: aload_3
    //   32: aload_0
    //   33: invokevirtual 327	java/io/FileInputStream:read	([B)I
    //   36: istore_2
    //   37: iconst_m1
    //   38: iload_2
    //   39: if_icmpeq +50 -> 89
    //   42: aload_1
    //   43: aload_0
    //   44: iconst_0
    //   45: iload_2
    //   46: invokevirtual 328	java/io/BufferedOutputStream:write	([BII)V
    //   49: goto -18 -> 31
    //   52: astore_0
    //   53: aload_1
    //   54: astore_0
    //   55: ldc_w 330
    //   58: invokestatic 336	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   61: checkcast 330	com/tencent/qzonehub/api/IDataUtils
    //   64: aload_0
    //   65: invokeinterface 340 2 0
    //   70: pop
    //   71: ldc_w 330
    //   74: invokestatic 336	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   77: checkcast 330	com/tencent/qzonehub/api/IDataUtils
    //   80: aload_3
    //   81: invokeinterface 340 2 0
    //   86: pop
    //   87: iconst_0
    //   88: ireturn
    //   89: aload_1
    //   90: invokevirtual 341	java/io/BufferedOutputStream:flush	()V
    //   93: ldc_w 330
    //   96: invokestatic 336	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   99: checkcast 330	com/tencent/qzonehub/api/IDataUtils
    //   102: aload_1
    //   103: invokeinterface 340 2 0
    //   108: pop
    //   109: ldc_w 330
    //   112: invokestatic 336	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   115: checkcast 330	com/tencent/qzonehub/api/IDataUtils
    //   118: aload_3
    //   119: invokeinterface 340 2 0
    //   124: pop
    //   125: iconst_1
    //   126: ireturn
    //   127: astore_0
    //   128: aconst_null
    //   129: astore_1
    //   130: aconst_null
    //   131: astore_3
    //   132: ldc_w 330
    //   135: invokestatic 336	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   138: checkcast 330	com/tencent/qzonehub/api/IDataUtils
    //   141: aload_1
    //   142: invokeinterface 340 2 0
    //   147: pop
    //   148: ldc_w 330
    //   151: invokestatic 336	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   154: checkcast 330	com/tencent/qzonehub/api/IDataUtils
    //   157: aload_3
    //   158: invokeinterface 340 2 0
    //   163: pop
    //   164: aload_0
    //   165: athrow
    //   166: astore_0
    //   167: aconst_null
    //   168: astore_1
    //   169: goto -37 -> 132
    //   172: astore_0
    //   173: goto -41 -> 132
    //   176: astore_0
    //   177: aconst_null
    //   178: astore_0
    //   179: aconst_null
    //   180: astore_3
    //   181: goto -126 -> 55
    //   184: astore_0
    //   185: aconst_null
    //   186: astore_0
    //   187: goto -132 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	paramFile1	File
    //   0	190	1	paramFile2	File
    //   36	10	2	i	int
    //   8	173	3	localFileInputStream	java.io.FileInputStream
    // Exception table:
    //   from	to	target	type
    //   25	31	52	java/io/IOException
    //   31	37	52	java/io/IOException
    //   42	49	52	java/io/IOException
    //   89	93	52	java/io/IOException
    //   0	9	127	finally
    //   9	25	166	finally
    //   25	31	172	finally
    //   31	37	172	finally
    //   42	49	172	finally
    //   89	93	172	finally
    //   0	9	176	java/io/IOException
    //   9	25	184	java/io/IOException
  }
  
  public static boolean a(String paramString)
  {
    File localFile = new File(paramString);
    if ((!localFile.exists()) && (!localFile.mkdirs()))
    {
      SLog.d("Q.qqstory:Utils", "mkdirs failed, path:%s", new Object[] { paramString });
      return false;
    }
    return true;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    return com.tencent.mobileqq.utils.FileUtils.c(paramString1, paramString2);
  }
  
  /* Error */
  public static byte[] a(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 93	java/io/File:exists	()Z
    //   4: ifne +31 -> 35
    //   7: new 348	java/lang/RuntimeException
    //   10: dup
    //   11: new 193	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   18: aload_0
    //   19: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   22: ldc_w 350
    //   25: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokespecial 351	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   34: athrow
    //   35: aload_0
    //   36: invokevirtual 212	java/io/File:isFile	()Z
    //   39: ifne +31 -> 70
    //   42: new 348	java/lang/RuntimeException
    //   45: dup
    //   46: new 193	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   53: aload_0
    //   54: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   57: ldc_w 353
    //   60: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokespecial 351	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   69: athrow
    //   70: aload_0
    //   71: invokevirtual 356	java/io/File:canRead	()Z
    //   74: ifne +31 -> 105
    //   77: new 348	java/lang/RuntimeException
    //   80: dup
    //   81: new 193	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   88: aload_0
    //   89: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   92: ldc_w 358
    //   95: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokespecial 351	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   104: athrow
    //   105: aload_0
    //   106: invokevirtual 32	java/io/File:length	()J
    //   109: lstore 4
    //   111: lload 4
    //   113: l2i
    //   114: istore_1
    //   115: iload_1
    //   116: i2l
    //   117: lload 4
    //   119: lcmp
    //   120: ifeq +31 -> 151
    //   123: new 348	java/lang/RuntimeException
    //   126: dup
    //   127: new 193	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   134: aload_0
    //   135: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   138: ldc_w 360
    //   141: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokespecial 351	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   150: athrow
    //   151: iload_1
    //   152: newarray byte
    //   154: astore 8
    //   156: new 318	java/io/FileInputStream
    //   159: dup
    //   160: aload_0
    //   161: invokespecial 320	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   164: astore 7
    //   166: iconst_0
    //   167: istore_2
    //   168: iload_1
    //   169: ifle +118 -> 287
    //   172: aload 7
    //   174: astore 6
    //   176: aload 7
    //   178: aload 8
    //   180: iload_2
    //   181: iload_1
    //   182: invokevirtual 363	java/io/FileInputStream:read	([BII)I
    //   185: istore_3
    //   186: iload_3
    //   187: iconst_m1
    //   188: if_icmpne +88 -> 276
    //   191: aload 7
    //   193: astore 6
    //   195: new 348	java/lang/RuntimeException
    //   198: dup
    //   199: new 193	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   206: aload_0
    //   207: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   210: ldc_w 365
    //   213: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokespecial 351	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   222: athrow
    //   223: astore 8
    //   225: aload 7
    //   227: astore 6
    //   229: aload 8
    //   231: astore 7
    //   233: new 348	java/lang/RuntimeException
    //   236: dup
    //   237: new 193	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   244: aload_0
    //   245: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   248: ldc_w 367
    //   251: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: aload 7
    //   259: invokespecial 370	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   262: athrow
    //   263: astore_0
    //   264: aload 6
    //   266: ifnull +8 -> 274
    //   269: aload 6
    //   271: invokevirtual 371	java/io/FileInputStream:close	()V
    //   274: aload_0
    //   275: athrow
    //   276: iload_2
    //   277: iload_3
    //   278: iadd
    //   279: istore_2
    //   280: iload_1
    //   281: iload_3
    //   282: isub
    //   283: istore_1
    //   284: goto -116 -> 168
    //   287: aload 7
    //   289: ifnull +8 -> 297
    //   292: aload 7
    //   294: invokevirtual 371	java/io/FileInputStream:close	()V
    //   297: aload 8
    //   299: areturn
    //   300: astore_0
    //   301: aload_0
    //   302: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   305: aload 8
    //   307: areturn
    //   308: astore 6
    //   310: aload 6
    //   312: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   315: goto -41 -> 274
    //   318: astore_0
    //   319: aconst_null
    //   320: astore 6
    //   322: goto -58 -> 264
    //   325: astore 7
    //   327: aconst_null
    //   328: astore 6
    //   330: goto -97 -> 233
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	333	0	paramFile	File
    //   114	170	1	i	int
    //   167	113	2	j	int
    //   185	98	3	k	int
    //   109	9	4	l	long
    //   174	96	6	localObject1	Object
    //   308	3	6	localIOException1	java.io.IOException
    //   320	9	6	localObject2	Object
    //   164	129	7	localObject3	Object
    //   325	1	7	localIOException2	java.io.IOException
    //   154	25	8	arrayOfByte	byte[]
    //   223	83	8	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   176	186	223	java/io/IOException
    //   195	223	223	java/io/IOException
    //   176	186	263	finally
    //   195	223	263	finally
    //   233	263	263	finally
    //   292	297	300	java/io/IOException
    //   269	274	308	java/io/IOException
    //   156	166	318	finally
    //   156	166	325	java/io/IOException
  }
  
  public static long b(String paramString)
  {
    paramString = com.tencent.mobileqq.utils.FileUtils.a(paramString + "/" + "dont_delete.txt");
    if (paramString == null) {
      return 0L;
    }
    try
    {
      long l = Long.valueOf(new String(paramString).trim().replaceAll("[\n\r]", "")).longValue();
      return l;
    }
    catch (Exception paramString)
    {
      SLog.b("Q.qqstory:Utils", "exception", paramString);
    }
    return 0L;
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {}
    int i;
    int j;
    do
    {
      return null;
      i = paramString.lastIndexOf("/");
      j = paramString.lastIndexOf("?");
    } while ((i == -1) || (i == paramString.length() - 1));
    if (j > i) {
      return paramString.substring(i + 1, j);
    }
    return paramString.substring(i + 1);
  }
  
  public static void b(Context paramContext, File paramFile)
  {
    FileProvider7Helper.savePhotoToSysAlbum(paramContext, paramFile);
  }
  
  public static boolean b(String paramString)
  {
    return com.tencent.mobileqq.utils.FileUtils.a(paramString);
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    return com.tencent.mobileqq.utils.FileUtils.b(paramString1, paramString2);
  }
  
  /* Error */
  @android.annotation.TargetApi(9)
  public static byte[] b(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 32	java/io/File:length	()J
    //   4: lstore 4
    //   6: lload 4
    //   8: l2i
    //   9: istore_1
    //   10: iload_1
    //   11: i2l
    //   12: lload 4
    //   14: lcmp
    //   15: ifeq +36 -> 51
    //   18: new 106	java/io/IOException
    //   21: dup
    //   22: new 193	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   29: aload_0
    //   30: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   33: ldc_w 414
    //   36: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: lload 4
    //   41: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   44: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokespecial 415	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   50: athrow
    //   51: iload_1
    //   52: newarray byte
    //   54: astore 8
    //   56: new 318	java/io/FileInputStream
    //   59: dup
    //   60: aload_0
    //   61: invokespecial 320	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   64: astore 7
    //   66: iconst_0
    //   67: istore_2
    //   68: iload_1
    //   69: ifle +118 -> 187
    //   72: aload 7
    //   74: astore 6
    //   76: aload 7
    //   78: aload 8
    //   80: iload_2
    //   81: iload_1
    //   82: invokevirtual 363	java/io/FileInputStream:read	([BII)I
    //   85: istore_3
    //   86: iload_3
    //   87: iconst_m1
    //   88: if_icmpne +88 -> 176
    //   91: aload 7
    //   93: astore 6
    //   95: new 106	java/io/IOException
    //   98: dup
    //   99: new 193	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   106: aload_0
    //   107: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   110: ldc_w 417
    //   113: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokespecial 415	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   122: athrow
    //   123: astore 8
    //   125: aload 7
    //   127: astore 6
    //   129: aload 8
    //   131: astore 7
    //   133: new 106	java/io/IOException
    //   136: dup
    //   137: new 193	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   144: aload_0
    //   145: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   148: ldc_w 367
    //   151: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: aload 7
    //   159: invokespecial 418	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   162: athrow
    //   163: astore_0
    //   164: aload 6
    //   166: ifnull +8 -> 174
    //   169: aload 6
    //   171: invokevirtual 371	java/io/FileInputStream:close	()V
    //   174: aload_0
    //   175: athrow
    //   176: iload_2
    //   177: iload_3
    //   178: iadd
    //   179: istore_2
    //   180: iload_1
    //   181: iload_3
    //   182: isub
    //   183: istore_1
    //   184: goto -116 -> 68
    //   187: aload 7
    //   189: ifnull +8 -> 197
    //   192: aload 7
    //   194: invokevirtual 371	java/io/FileInputStream:close	()V
    //   197: aload 8
    //   199: areturn
    //   200: astore_0
    //   201: aconst_null
    //   202: astore 6
    //   204: goto -40 -> 164
    //   207: astore 7
    //   209: aconst_null
    //   210: astore 6
    //   212: goto -79 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	paramFile	File
    //   9	175	1	i	int
    //   67	113	2	j	int
    //   85	98	3	k	int
    //   4	36	4	l	long
    //   74	137	6	localObject1	Object
    //   64	129	7	localObject2	Object
    //   207	1	7	localIOException1	java.io.IOException
    //   54	25	8	arrayOfByte	byte[]
    //   123	75	8	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   76	86	123	java/io/IOException
    //   95	123	123	java/io/IOException
    //   76	86	163	finally
    //   95	123	163	finally
    //   133	163	163	finally
    //   56	66	200	finally
    //   56	66	207	java/io/IOException
  }
  
  public static long c(String paramString)
  {
    return com.tencent.mobileqq.utils.FileUtils.a(paramString);
  }
  
  public static String c(String paramString)
  {
    if (paramString == null) {}
    int i;
    int j;
    do
    {
      return null;
      i = paramString.lastIndexOf(".");
      j = paramString.lastIndexOf("?");
    } while ((i == -1) || (i == paramString.length() - 1));
    if (j > i) {
      return paramString.substring(i + 1, j);
    }
    return paramString.substring(i + 1);
  }
  
  public static boolean c(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((!paramString.exists()) || (paramString.length() <= 0L));
    return true;
  }
  
  public static boolean c(String paramString1, String paramString2)
  {
    return com.tencent.mobileqq.utils.FileUtils.d(paramString1, paramString2);
  }
  
  public static boolean d(String paramString)
  {
    com.tencent.mobileqq.utils.FileUtils.a(paramString);
    SLog.d("Q.qqstory:Utils", "removeAllFiles " + paramString);
    return true;
  }
  
  public static boolean e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((paramString.indexOf("assets") < 0) && (!new File(paramString).exists())) {
      return false;
    }
    return true;
  }
  
  public static boolean f(String paramString)
  {
    if (StringUtil.a(paramString))
    {
      SLog.d("Q.qqstory:Utils", "save from: delete path null");
      return false;
    }
    com.tencent.mobileqq.utils.FileUtils.e(paramString);
    SLog.d("Q.qqstory:Utils", "deleteFile %s", new Object[] { paramString });
    return true;
  }
  
  public static boolean g(String paramString)
  {
    if (StringUtil.a(paramString))
    {
      SLog.d("Q.qqstory:Utils", "save from: delete path null");
      return false;
    }
    com.tencent.mobileqq.utils.FileUtils.e(paramString);
    SLog.d("Q.qqstory:Utils", "tryDeleteFile %s", new Object[] { paramString });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */