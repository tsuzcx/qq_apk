package com.tencent.biz.qqstory.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore.Video.Media;
import android.text.TextUtils;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.StringUtil;
import java.io.File;
import mqq.os.MqqHandler;
import omn;

public class FileUtils
{
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
      SLog.b("Q.qqstory:Utils", paramString, "", new Object[0]);
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
        ThreadManager.getUIHandler().post(new omn(paramContext));
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
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 272	java/io/FileInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 274	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   13: astore_0
    //   14: new 276	java/io/BufferedOutputStream
    //   17: dup
    //   18: new 278	java/io/FileOutputStream
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 279	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   26: invokespecial 282	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   29: astore_3
    //   30: sipush 4096
    //   33: newarray byte
    //   35: astore_1
    //   36: aload_0
    //   37: aload_1
    //   38: invokevirtual 286	java/io/FileInputStream:read	([B)I
    //   41: istore_2
    //   42: iconst_m1
    //   43: iload_2
    //   44: if_icmpeq +30 -> 74
    //   47: aload_3
    //   48: aload_1
    //   49: iconst_0
    //   50: iload_2
    //   51: invokevirtual 290	java/io/BufferedOutputStream:write	([BII)V
    //   54: goto -18 -> 36
    //   57: astore_1
    //   58: aload_0
    //   59: astore_1
    //   60: aload_3
    //   61: astore_0
    //   62: aload_0
    //   63: invokestatic 295	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   66: pop
    //   67: aload_1
    //   68: invokestatic 295	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   71: pop
    //   72: iconst_0
    //   73: ireturn
    //   74: aload_3
    //   75: invokevirtual 298	java/io/BufferedOutputStream:flush	()V
    //   78: aload_3
    //   79: invokestatic 295	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   82: pop
    //   83: aload_0
    //   84: invokestatic 295	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   87: pop
    //   88: iconst_1
    //   89: ireturn
    //   90: astore_1
    //   91: aconst_null
    //   92: astore_0
    //   93: aload 4
    //   95: astore_3
    //   96: aload_3
    //   97: invokestatic 295	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   100: pop
    //   101: aload_0
    //   102: invokestatic 295	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   105: pop
    //   106: aload_1
    //   107: athrow
    //   108: astore_1
    //   109: aload 4
    //   111: astore_3
    //   112: goto -16 -> 96
    //   115: astore_1
    //   116: goto -20 -> 96
    //   119: astore_0
    //   120: aconst_null
    //   121: astore_0
    //   122: aload_3
    //   123: astore_1
    //   124: goto -62 -> 62
    //   127: astore_1
    //   128: aconst_null
    //   129: astore_3
    //   130: aload_0
    //   131: astore_1
    //   132: aload_3
    //   133: astore_0
    //   134: goto -72 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	paramFile1	File
    //   0	137	1	paramFile2	File
    //   41	10	2	i	int
    //   4	129	3	localObject1	Object
    //   1	109	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   30	36	57	java/io/IOException
    //   36	42	57	java/io/IOException
    //   47	54	57	java/io/IOException
    //   74	78	57	java/io/IOException
    //   5	14	90	finally
    //   14	30	108	finally
    //   30	36	115	finally
    //   36	42	115	finally
    //   47	54	115	finally
    //   74	78	115	finally
    //   5	14	119	java/io/IOException
    //   14	30	127	java/io/IOException
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
    //   1: invokevirtual 90	java/io/File:exists	()Z
    //   4: ifne +31 -> 35
    //   7: new 305	java/lang/RuntimeException
    //   10: dup
    //   11: new 146	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   18: aload_0
    //   19: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   22: ldc_w 307
    //   25: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokespecial 308	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   34: athrow
    //   35: aload_0
    //   36: invokevirtual 165	java/io/File:isFile	()Z
    //   39: ifne +31 -> 70
    //   42: new 305	java/lang/RuntimeException
    //   45: dup
    //   46: new 146	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   53: aload_0
    //   54: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   57: ldc_w 310
    //   60: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokespecial 308	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   69: athrow
    //   70: aload_0
    //   71: invokevirtual 313	java/io/File:canRead	()Z
    //   74: ifne +31 -> 105
    //   77: new 305	java/lang/RuntimeException
    //   80: dup
    //   81: new 146	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   88: aload_0
    //   89: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   92: ldc_w 315
    //   95: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokespecial 308	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   104: athrow
    //   105: aload_0
    //   106: invokevirtual 28	java/io/File:length	()J
    //   109: lstore 4
    //   111: lload 4
    //   113: l2i
    //   114: istore_1
    //   115: iload_1
    //   116: i2l
    //   117: lload 4
    //   119: lcmp
    //   120: ifeq +31 -> 151
    //   123: new 305	java/lang/RuntimeException
    //   126: dup
    //   127: new 146	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   134: aload_0
    //   135: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   138: ldc_w 317
    //   141: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokespecial 308	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   150: athrow
    //   151: iload_1
    //   152: newarray byte
    //   154: astore 8
    //   156: new 272	java/io/FileInputStream
    //   159: dup
    //   160: aload_0
    //   161: invokespecial 274	java/io/FileInputStream:<init>	(Ljava/io/File;)V
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
    //   182: invokevirtual 320	java/io/FileInputStream:read	([BII)I
    //   185: istore_3
    //   186: iload_3
    //   187: iconst_m1
    //   188: if_icmpne +88 -> 276
    //   191: aload 7
    //   193: astore 6
    //   195: new 305	java/lang/RuntimeException
    //   198: dup
    //   199: new 146	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   206: aload_0
    //   207: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   210: ldc_w 322
    //   213: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokespecial 308	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   222: athrow
    //   223: astore 8
    //   225: aload 7
    //   227: astore 6
    //   229: aload 8
    //   231: astore 7
    //   233: new 305	java/lang/RuntimeException
    //   236: dup
    //   237: new 146	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   244: aload_0
    //   245: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   248: ldc_w 324
    //   251: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: aload 7
    //   259: invokespecial 327	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   262: athrow
    //   263: astore_0
    //   264: aload 6
    //   266: ifnull +8 -> 274
    //   269: aload 6
    //   271: invokevirtual 330	java/io/FileInputStream:close	()V
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
    //   294: invokevirtual 330	java/io/FileInputStream:close	()V
    //   297: aload 8
    //   299: areturn
    //   300: astore_0
    //   301: aload_0
    //   302: invokevirtual 333	java/io/IOException:printStackTrace	()V
    //   305: aload 8
    //   307: areturn
    //   308: astore 6
    //   310: aload 6
    //   312: invokevirtual 333	java/io/IOException:printStackTrace	()V
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
    Intent localIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
    localIntent.setData(Uri.fromFile(paramFile));
    paramContext.sendBroadcast(localIntent);
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
    //   1: invokevirtual 28	java/io/File:length	()J
    //   4: lstore 4
    //   6: lload 4
    //   8: l2i
    //   9: istore_1
    //   10: iload_1
    //   11: i2l
    //   12: lload 4
    //   14: lcmp
    //   15: ifeq +36 -> 51
    //   18: new 270	java/io/IOException
    //   21: dup
    //   22: new 146	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   29: aload_0
    //   30: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   33: ldc_w 389
    //   36: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: lload 4
    //   41: invokevirtual 221	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   44: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokespecial 390	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   50: athrow
    //   51: iload_1
    //   52: newarray byte
    //   54: astore 8
    //   56: new 272	java/io/FileInputStream
    //   59: dup
    //   60: aload_0
    //   61: invokespecial 274	java/io/FileInputStream:<init>	(Ljava/io/File;)V
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
    //   82: invokevirtual 320	java/io/FileInputStream:read	([BII)I
    //   85: istore_3
    //   86: iload_3
    //   87: iconst_m1
    //   88: if_icmpne +88 -> 176
    //   91: aload 7
    //   93: astore 6
    //   95: new 270	java/io/IOException
    //   98: dup
    //   99: new 146	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   106: aload_0
    //   107: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   110: ldc_w 392
    //   113: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokespecial 390	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   122: athrow
    //   123: astore 8
    //   125: aload 7
    //   127: astore 6
    //   129: aload 8
    //   131: astore 7
    //   133: new 270	java/io/IOException
    //   136: dup
    //   137: new 146	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   144: aload_0
    //   145: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   148: ldc_w 324
    //   151: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: aload 7
    //   159: invokespecial 393	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   162: athrow
    //   163: astore_0
    //   164: aload 6
    //   166: ifnull +8 -> 174
    //   169: aload 6
    //   171: invokevirtual 330	java/io/FileInputStream:close	()V
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
    //   194: invokevirtual 330	java/io/FileInputStream:close	()V
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
    com.tencent.mobileqq.utils.FileUtils.d(paramString);
    SLog.d("Q.qqstory:Utils", "tryDeleteFile %s", new Object[] { paramString });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */