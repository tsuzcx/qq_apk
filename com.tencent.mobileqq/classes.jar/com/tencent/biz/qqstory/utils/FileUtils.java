package com.tencent.biz.qqstory.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.provider.MediaStore.Video.Media;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import java.io.File;

public class FileUtils
{
  public static long a()
  {
    return com.tencent.mobileqq.utils.FileUtils.getAvailableExternalMemorySize();
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
    if (!paramString.exists()) {
      if ((paramString.getParentFile() != null) && (!paramString.getParentFile().exists()))
      {
        if (paramString.getParentFile().mkdirs())
        {
          paramString.createNewFile();
          return paramString;
        }
      }
      else {
        paramString.createNewFile();
      }
    }
    return paramString;
  }
  
  /* Error */
  public static String a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 109	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   4: aload_1
    //   5: invokevirtual 115	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   8: astore 4
    //   10: aload_0
    //   11: aload_1
    //   12: iconst_0
    //   13: invokevirtual 119	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   16: astore 6
    //   18: aload 4
    //   20: astore_3
    //   21: aload 6
    //   23: astore 5
    //   25: ldc 120
    //   27: newarray byte
    //   29: astore 7
    //   31: aload 4
    //   33: astore_3
    //   34: aload 6
    //   36: astore 5
    //   38: aload 4
    //   40: aload 7
    //   42: invokevirtual 126	java/io/InputStream:read	([B)I
    //   45: istore_2
    //   46: iload_2
    //   47: ifle +22 -> 69
    //   50: aload 4
    //   52: astore_3
    //   53: aload 6
    //   55: astore 5
    //   57: aload 6
    //   59: aload 7
    //   61: iconst_0
    //   62: iload_2
    //   63: invokevirtual 132	java/io/FileOutputStream:write	([BII)V
    //   66: goto -35 -> 31
    //   69: aload 4
    //   71: astore_3
    //   72: aload 6
    //   74: astore 5
    //   76: aload 6
    //   78: invokevirtual 135	java/io/FileOutputStream:flush	()V
    //   81: aload 4
    //   83: astore_3
    //   84: aload 6
    //   86: astore 5
    //   88: aload_0
    //   89: aload_1
    //   90: invokevirtual 138	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   93: invokevirtual 83	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   96: astore_0
    //   97: aload 4
    //   99: ifnull +11 -> 110
    //   102: aload 4
    //   104: invokevirtual 141	java/io/InputStream:close	()V
    //   107: goto +3 -> 110
    //   110: aload 6
    //   112: ifnull +8 -> 120
    //   115: aload 6
    //   117: invokevirtual 142	java/io/FileOutputStream:close	()V
    //   120: aload_0
    //   121: areturn
    //   122: astore_1
    //   123: aload 6
    //   125: astore_0
    //   126: goto +35 -> 161
    //   129: astore_0
    //   130: aconst_null
    //   131: astore 5
    //   133: aload 4
    //   135: astore_3
    //   136: goto +59 -> 195
    //   139: astore_1
    //   140: aconst_null
    //   141: astore_0
    //   142: goto +19 -> 161
    //   145: astore_0
    //   146: aconst_null
    //   147: astore_3
    //   148: aload_3
    //   149: astore 5
    //   151: goto +44 -> 195
    //   154: astore_1
    //   155: aconst_null
    //   156: astore 4
    //   158: aload 4
    //   160: astore_0
    //   161: aload 4
    //   163: astore_3
    //   164: aload_0
    //   165: astore 5
    //   167: aload_1
    //   168: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   171: aload 4
    //   173: ifnull +11 -> 184
    //   176: aload 4
    //   178: invokevirtual 141	java/io/InputStream:close	()V
    //   181: goto +3 -> 184
    //   184: aload_0
    //   185: ifnull +7 -> 192
    //   188: aload_0
    //   189: invokevirtual 142	java/io/FileOutputStream:close	()V
    //   192: aconst_null
    //   193: areturn
    //   194: astore_0
    //   195: aload_3
    //   196: ifnull +10 -> 206
    //   199: aload_3
    //   200: invokevirtual 141	java/io/InputStream:close	()V
    //   203: goto +3 -> 206
    //   206: aload 5
    //   208: ifnull +8 -> 216
    //   211: aload 5
    //   213: invokevirtual 142	java/io/FileOutputStream:close	()V
    //   216: goto +5 -> 221
    //   219: aload_0
    //   220: athrow
    //   221: goto -2 -> 219
    //   224: astore_1
    //   225: goto -115 -> 110
    //   228: astore_1
    //   229: aload_0
    //   230: areturn
    //   231: astore_1
    //   232: goto -48 -> 184
    //   235: astore_0
    //   236: aconst_null
    //   237: areturn
    //   238: astore_1
    //   239: goto -33 -> 206
    //   242: astore_1
    //   243: goto -27 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	paramContext	Context
    //   0	246	1	paramString	String
    //   45	18	2	i	int
    //   20	180	3	localInputStream1	java.io.InputStream
    //   8	169	4	localInputStream2	java.io.InputStream
    //   23	189	5	localObject	Object
    //   16	108	6	localFileOutputStream	java.io.FileOutputStream
    //   29	31	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   25	31	122	java/io/IOException
    //   38	46	122	java/io/IOException
    //   57	66	122	java/io/IOException
    //   76	81	122	java/io/IOException
    //   88	97	122	java/io/IOException
    //   10	18	129	finally
    //   10	18	139	java/io/IOException
    //   0	10	145	finally
    //   0	10	154	java/io/IOException
    //   25	31	194	finally
    //   38	46	194	finally
    //   57	66	194	finally
    //   76	81	194	finally
    //   88	97	194	finally
    //   167	171	194	finally
    //   102	107	224	java/io/IOException
    //   115	120	228	java/io/IOException
    //   176	181	231	java/io/IOException
    //   188	192	235	java/io/IOException
    //   199	203	238	java/io/IOException
    //   211	216	242	java/io/IOException
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
    }
    catch (Exception localException)
    {
      SLog.b("Q.qqstory:Utils", "exception", localException);
    }
    b(paramContext, paramFile);
  }
  
  public static void a(File paramFile)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("delete ");
    ((StringBuilder)localObject).append(paramFile);
    SLog.d("Q.qqstory:Utils", ((StringBuilder)localObject).toString());
    if (paramFile.isFile())
    {
      paramFile.delete();
      return;
    }
    if (paramFile.isDirectory())
    {
      localObject = paramFile.listFiles();
      if ((localObject != null) && (localObject.length != 0))
      {
        int i = 0;
        while (i < localObject.length)
        {
          a(localObject[i]);
          i += 1;
        }
        paramFile.delete();
        return;
      }
      paramFile.delete();
    }
  }
  
  public static void a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append("dont_delete.txt");
    localObject = ((StringBuilder)localObject).toString();
    if (!c((String)localObject))
    {
      a(paramString);
      SLog.d("Q.qqstory:Utils", "make flag file %b", new Object[] { Boolean.valueOf(com.tencent.mobileqq.utils.FileUtils.writeFile((String)localObject, String.valueOf(System.currentTimeMillis()))) });
      return;
    }
    SLog.d("Q.qqstory:Utils", "flag file exist");
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    SLog.d("Q.qqstory:Utils", "delete %s", new Object[] { paramString });
    com.tencent.mobileqq.utils.FileUtils.delete(paramString, paramBoolean);
  }
  
  public static boolean a()
  {
    long l = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("free spac:");
    localStringBuilder.append(l / 1024L / 1024L);
    localStringBuilder.append("MB--");
    localStringBuilder.append(l);
    SLog.b("Q.qqstory:Utils", localStringBuilder.toString());
    return l < 52428800L;
  }
  
  public static boolean a(long paramLong)
  {
    long l = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("free spac:");
    localStringBuilder.append(l / 1024L / 1024L);
    localStringBuilder.append("MB--");
    localStringBuilder.append(l);
    SLog.b("Q.qqstory:Utils", localStringBuilder.toString());
    return l < paramLong * 1024L * 1024L;
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
    paramString1 = new StringBuilder();
    paramString1.append("saveVideoToAlbum: ");
    paramString1.append(bool);
    SLog.c("Q.qqstory:Utils", paramString1.toString());
    b(paramContext, paramString2);
    return true;
  }
  
  /* Error */
  public static boolean a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 4
    //   8: new 289	java/io/FileInputStream
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 291	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   16: astore_0
    //   17: new 293	java/io/BufferedOutputStream
    //   20: dup
    //   21: new 128	java/io/FileOutputStream
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 294	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   29: invokespecial 297	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   32: astore_1
    //   33: sipush 4096
    //   36: newarray byte
    //   38: astore 4
    //   40: aload_0
    //   41: aload 4
    //   43: invokevirtual 298	java/io/FileInputStream:read	([B)I
    //   46: istore_2
    //   47: iconst_m1
    //   48: iload_2
    //   49: if_icmpeq +14 -> 63
    //   52: aload_1
    //   53: aload 4
    //   55: iconst_0
    //   56: iload_2
    //   57: invokevirtual 299	java/io/BufferedOutputStream:write	([BII)V
    //   60: goto -20 -> 40
    //   63: aload_1
    //   64: invokevirtual 300	java/io/BufferedOutputStream:flush	()V
    //   67: iconst_1
    //   68: istore_3
    //   69: aload_1
    //   70: invokevirtual 301	java/io/BufferedOutputStream:close	()V
    //   73: goto +8 -> 81
    //   76: astore_1
    //   77: aload_1
    //   78: invokevirtual 302	java/lang/Exception:printStackTrace	()V
    //   81: aload_0
    //   82: invokevirtual 303	java/io/FileInputStream:close	()V
    //   85: iconst_1
    //   86: ireturn
    //   87: astore_0
    //   88: aload_0
    //   89: invokevirtual 302	java/lang/Exception:printStackTrace	()V
    //   92: iload_3
    //   93: ireturn
    //   94: astore 5
    //   96: aload_1
    //   97: astore 4
    //   99: aload_0
    //   100: astore_1
    //   101: aload 5
    //   103: astore_0
    //   104: goto +19 -> 123
    //   107: goto +59 -> 166
    //   110: astore 5
    //   112: aload_0
    //   113: astore_1
    //   114: aload 5
    //   116: astore_0
    //   117: goto +6 -> 123
    //   120: astore_0
    //   121: aconst_null
    //   122: astore_1
    //   123: aload 4
    //   125: ifnull +18 -> 143
    //   128: aload 4
    //   130: invokevirtual 301	java/io/BufferedOutputStream:close	()V
    //   133: goto +10 -> 143
    //   136: astore 4
    //   138: aload 4
    //   140: invokevirtual 302	java/lang/Exception:printStackTrace	()V
    //   143: aload_1
    //   144: ifnull +15 -> 159
    //   147: aload_1
    //   148: invokevirtual 303	java/io/FileInputStream:close	()V
    //   151: goto +8 -> 159
    //   154: astore_1
    //   155: aload_1
    //   156: invokevirtual 302	java/lang/Exception:printStackTrace	()V
    //   159: aload_0
    //   160: athrow
    //   161: aconst_null
    //   162: astore_0
    //   163: aload 5
    //   165: astore_1
    //   166: aload_1
    //   167: ifnull +15 -> 182
    //   170: aload_1
    //   171: invokevirtual 301	java/io/BufferedOutputStream:close	()V
    //   174: goto +8 -> 182
    //   177: astore_1
    //   178: aload_1
    //   179: invokevirtual 302	java/lang/Exception:printStackTrace	()V
    //   182: aload_0
    //   183: ifnull +7 -> 190
    //   186: aload_0
    //   187: invokevirtual 303	java/io/FileInputStream:close	()V
    //   190: iconst_0
    //   191: ireturn
    //   192: astore_0
    //   193: goto -32 -> 161
    //   196: astore_1
    //   197: aload 5
    //   199: astore_1
    //   200: goto -34 -> 166
    //   203: astore 4
    //   205: goto -98 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	paramFile1	File
    //   0	208	1	paramFile2	File
    //   46	11	2	i	int
    //   1	92	3	bool	boolean
    //   6	123	4	localObject1	Object
    //   136	3	4	localException	Exception
    //   203	1	4	localIOException	java.io.IOException
    //   3	1	5	localObject2	Object
    //   94	8	5	localObject3	Object
    //   110	88	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   69	73	76	java/lang/Exception
    //   81	85	87	java/lang/Exception
    //   186	190	87	java/lang/Exception
    //   33	40	94	finally
    //   40	47	94	finally
    //   52	60	94	finally
    //   63	67	94	finally
    //   17	33	110	finally
    //   8	17	120	finally
    //   128	133	136	java/lang/Exception
    //   147	151	154	java/lang/Exception
    //   170	174	177	java/lang/Exception
    //   8	17	192	java/io/IOException
    //   17	33	196	java/io/IOException
    //   33	40	203	java/io/IOException
    //   40	47	203	java/io/IOException
    //   52	60	203	java/io/IOException
    //   63	67	203	java/io/IOException
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
    return com.tencent.mobileqq.utils.FileUtils.rename(paramString1, paramString2);
  }
  
  /* Error */
  public static byte[] a(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 90	java/io/File:exists	()Z
    //   4: ifeq +361 -> 365
    //   7: aload_0
    //   8: invokevirtual 208	java/io/File:isFile	()Z
    //   11: ifeq +316 -> 327
    //   14: aload_0
    //   15: invokevirtual 312	java/io/File:canRead	()Z
    //   18: ifeq +271 -> 289
    //   21: aload_0
    //   22: invokevirtual 28	java/io/File:length	()J
    //   25: lstore 4
    //   27: lload 4
    //   29: l2i
    //   30: istore_1
    //   31: iload_1
    //   32: i2l
    //   33: lload 4
    //   35: lcmp
    //   36: ifne +215 -> 251
    //   39: iload_1
    //   40: newarray byte
    //   42: astore 9
    //   44: aconst_null
    //   45: astore 8
    //   47: aconst_null
    //   48: astore 6
    //   50: new 289	java/io/FileInputStream
    //   53: dup
    //   54: aload_0
    //   55: invokespecial 291	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   58: astore 7
    //   60: iconst_0
    //   61: istore_2
    //   62: iload_1
    //   63: ifle +80 -> 143
    //   66: aload 7
    //   68: aload 9
    //   70: iload_2
    //   71: iload_1
    //   72: invokevirtual 315	java/io/FileInputStream:read	([BII)I
    //   75: istore_3
    //   76: iload_3
    //   77: iconst_m1
    //   78: if_icmpeq +14 -> 92
    //   81: iload_2
    //   82: iload_3
    //   83: iadd
    //   84: istore_2
    //   85: iload_1
    //   86: iload_3
    //   87: isub
    //   88: istore_1
    //   89: goto -27 -> 62
    //   92: new 189	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   99: astore 6
    //   101: aload 6
    //   103: aload_0
    //   104: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 6
    //   110: ldc_w 317
    //   113: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: new 319	java/lang/RuntimeException
    //   120: dup
    //   121: aload 6
    //   123: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokespecial 320	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   129: athrow
    //   130: astore_0
    //   131: aload 7
    //   133: astore 6
    //   135: goto +94 -> 229
    //   138: astore 8
    //   140: goto +33 -> 173
    //   143: aload 7
    //   145: invokevirtual 303	java/io/FileInputStream:close	()V
    //   148: aload 9
    //   150: areturn
    //   151: astore_0
    //   152: aload_0
    //   153: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   156: aload 9
    //   158: areturn
    //   159: astore_0
    //   160: goto +69 -> 229
    //   163: astore 6
    //   165: aload 8
    //   167: astore 7
    //   169: aload 6
    //   171: astore 8
    //   173: aload 7
    //   175: astore 6
    //   177: new 189	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   184: astore 9
    //   186: aload 7
    //   188: astore 6
    //   190: aload 9
    //   192: aload_0
    //   193: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload 7
    //   199: astore 6
    //   201: aload 9
    //   203: ldc_w 322
    //   206: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload 7
    //   212: astore 6
    //   214: new 319	java/lang/RuntimeException
    //   217: dup
    //   218: aload 9
    //   220: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: aload 8
    //   225: invokespecial 325	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   228: athrow
    //   229: aload 6
    //   231: ifnull +18 -> 249
    //   234: aload 6
    //   236: invokevirtual 303	java/io/FileInputStream:close	()V
    //   239: goto +10 -> 249
    //   242: astore 6
    //   244: aload 6
    //   246: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   249: aload_0
    //   250: athrow
    //   251: new 189	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   258: astore 6
    //   260: aload 6
    //   262: aload_0
    //   263: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload 6
    //   269: ldc_w 327
    //   272: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: new 319	java/lang/RuntimeException
    //   279: dup
    //   280: aload 6
    //   282: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokespecial 320	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   288: athrow
    //   289: new 189	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   296: astore 6
    //   298: aload 6
    //   300: aload_0
    //   301: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload 6
    //   307: ldc_w 329
    //   310: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: new 319	java/lang/RuntimeException
    //   317: dup
    //   318: aload 6
    //   320: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokespecial 320	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   326: athrow
    //   327: new 189	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   334: astore 6
    //   336: aload 6
    //   338: aload_0
    //   339: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: aload 6
    //   345: ldc_w 331
    //   348: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: new 319	java/lang/RuntimeException
    //   355: dup
    //   356: aload 6
    //   358: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokespecial 320	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   364: athrow
    //   365: new 189	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   372: astore 6
    //   374: aload 6
    //   376: aload_0
    //   377: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   380: pop
    //   381: aload 6
    //   383: ldc_w 333
    //   386: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: new 319	java/lang/RuntimeException
    //   393: dup
    //   394: aload 6
    //   396: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: invokespecial 320	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   402: astore_0
    //   403: goto +5 -> 408
    //   406: aload_0
    //   407: athrow
    //   408: goto -2 -> 406
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	411	0	paramFile	File
    //   30	59	1	i	int
    //   61	24	2	j	int
    //   75	13	3	k	int
    //   25	9	4	l	long
    //   48	86	6	localObject1	Object
    //   163	7	6	localIOException1	java.io.IOException
    //   175	60	6	localObject2	Object
    //   242	3	6	localIOException2	java.io.IOException
    //   258	137	6	localStringBuilder	StringBuilder
    //   58	153	7	localObject3	Object
    //   45	1	8	localObject4	Object
    //   138	28	8	localIOException3	java.io.IOException
    //   171	53	8	localObject5	Object
    //   42	177	9	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   66	76	130	finally
    //   92	130	130	finally
    //   66	76	138	java/io/IOException
    //   92	130	138	java/io/IOException
    //   143	148	151	java/io/IOException
    //   50	60	159	finally
    //   177	186	159	finally
    //   190	197	159	finally
    //   201	210	159	finally
    //   214	229	159	finally
    //   50	60	163	java/io/IOException
    //   234	239	242	java/io/IOException
  }
  
  /* Error */
  @android.annotation.TargetApi(10)
  public static int[] a(String paramString)
  {
    // Byte code:
    //   0: new 339	android/media/MediaMetadataRetriever
    //   3: dup
    //   4: invokespecial 340	android/media/MediaMetadataRetriever:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_0
    //   10: invokevirtual 343	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   13: aload_2
    //   14: bipush 24
    //   16: invokevirtual 347	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   19: astore_1
    //   20: aload_2
    //   21: bipush 18
    //   23: invokevirtual 347	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   26: astore 4
    //   28: aload_2
    //   29: bipush 19
    //   31: invokevirtual 347	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   34: astore 5
    //   36: iconst_3
    //   37: newarray int
    //   39: astore_3
    //   40: aload_1
    //   41: astore_0
    //   42: aload_1
    //   43: ifnonnull +7 -> 50
    //   46: ldc_w 349
    //   49: astore_0
    //   50: aload_3
    //   51: iconst_0
    //   52: aload_0
    //   53: invokestatic 354	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   56: invokevirtual 358	java/lang/Integer:intValue	()I
    //   59: iastore
    //   60: aload_3
    //   61: iconst_1
    //   62: aload 4
    //   64: invokestatic 354	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   67: invokevirtual 358	java/lang/Integer:intValue	()I
    //   70: iastore
    //   71: aload_3
    //   72: iconst_2
    //   73: aload 5
    //   75: invokestatic 354	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   78: invokevirtual 358	java/lang/Integer:intValue	()I
    //   81: iastore
    //   82: aload_2
    //   83: invokevirtual 361	android/media/MediaMetadataRetriever:release	()V
    //   86: aload_3
    //   87: areturn
    //   88: astore_0
    //   89: new 189	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   96: astore_1
    //   97: aload_1
    //   98: ldc_w 363
    //   101: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload_1
    //   106: aload_0
    //   107: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: ldc 30
    //   113: aload_1
    //   114: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 205	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload_3
    //   121: areturn
    //   122: astore_0
    //   123: goto +52 -> 175
    //   126: astore_0
    //   127: ldc 30
    //   129: ldc 181
    //   131: aload_0
    //   132: invokestatic 184	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   135: aload_2
    //   136: invokevirtual 361	android/media/MediaMetadataRetriever:release	()V
    //   139: aconst_null
    //   140: areturn
    //   141: astore_0
    //   142: new 189	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   149: astore_1
    //   150: aload_1
    //   151: ldc_w 363
    //   154: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload_1
    //   159: aload_0
    //   160: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: ldc 30
    //   166: aload_1
    //   167: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 205	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: aconst_null
    //   174: areturn
    //   175: aload_2
    //   176: invokevirtual 361	android/media/MediaMetadataRetriever:release	()V
    //   179: goto +35 -> 214
    //   182: astore_1
    //   183: new 189	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   190: astore_2
    //   191: aload_2
    //   192: ldc_w 363
    //   195: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload_2
    //   200: aload_1
    //   201: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: ldc 30
    //   207: aload_2
    //   208: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokestatic 205	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   214: aload_0
    //   215: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	paramString	String
    //   19	148	1	localObject1	Object
    //   182	19	1	localRuntimeException	java.lang.RuntimeException
    //   7	201	2	localObject2	Object
    //   39	82	3	arrayOfInt	int[]
    //   26	37	4	str1	String
    //   34	40	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   82	86	88	java/lang/RuntimeException
    //   8	40	122	finally
    //   50	82	122	finally
    //   127	135	122	finally
    //   8	40	126	java/lang/Exception
    //   50	82	126	java/lang/Exception
    //   135	139	141	java/lang/RuntimeException
    //   175	179	182	java/lang/RuntimeException
  }
  
  public static long b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("/");
    localStringBuilder.append("dont_delete.txt");
    paramString = com.tencent.mobileqq.utils.FileUtils.readFile(localStringBuilder.toString());
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
    if (paramString == null) {
      return null;
    }
    int i = paramString.lastIndexOf("/");
    int j = paramString.lastIndexOf("?");
    if (i == -1) {
      return null;
    }
    if (i == paramString.length() - 1) {
      return null;
    }
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
    return com.tencent.mobileqq.utils.FileUtils.fileExists(paramString);
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    return com.tencent.mobileqq.utils.FileUtils.moveFile(paramString1, paramString2);
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
    //   15: ifne +197 -> 212
    //   18: iload_1
    //   19: newarray byte
    //   21: astore 9
    //   23: aconst_null
    //   24: astore 8
    //   26: aconst_null
    //   27: astore 6
    //   29: new 289	java/io/FileInputStream
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 291	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   37: astore 7
    //   39: iconst_0
    //   40: istore_2
    //   41: iload_1
    //   42: ifle +80 -> 122
    //   45: aload 7
    //   47: aload 9
    //   49: iload_2
    //   50: iload_1
    //   51: invokevirtual 315	java/io/FileInputStream:read	([BII)I
    //   54: istore_3
    //   55: iload_3
    //   56: iconst_m1
    //   57: if_icmpeq +14 -> 71
    //   60: iload_2
    //   61: iload_3
    //   62: iadd
    //   63: istore_2
    //   64: iload_1
    //   65: iload_3
    //   66: isub
    //   67: istore_1
    //   68: goto -27 -> 41
    //   71: new 189	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   78: astore 6
    //   80: aload 6
    //   82: aload_0
    //   83: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 6
    //   89: ldc_w 407
    //   92: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: new 103	java/io/IOException
    //   99: dup
    //   100: aload 6
    //   102: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokespecial 408	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   108: athrow
    //   109: astore_0
    //   110: aload 7
    //   112: astore 6
    //   114: goto +86 -> 200
    //   117: astore 8
    //   119: goto +25 -> 144
    //   122: aload 7
    //   124: invokevirtual 303	java/io/FileInputStream:close	()V
    //   127: aload 9
    //   129: areturn
    //   130: astore_0
    //   131: goto +69 -> 200
    //   134: astore 6
    //   136: aload 8
    //   138: astore 7
    //   140: aload 6
    //   142: astore 8
    //   144: aload 7
    //   146: astore 6
    //   148: new 189	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   155: astore 9
    //   157: aload 7
    //   159: astore 6
    //   161: aload 9
    //   163: aload_0
    //   164: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload 7
    //   170: astore 6
    //   172: aload 9
    //   174: ldc_w 322
    //   177: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload 7
    //   183: astore 6
    //   185: new 103	java/io/IOException
    //   188: dup
    //   189: aload 9
    //   191: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: aload 8
    //   196: invokespecial 409	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   199: athrow
    //   200: aload 6
    //   202: ifnull +8 -> 210
    //   205: aload 6
    //   207: invokevirtual 303	java/io/FileInputStream:close	()V
    //   210: aload_0
    //   211: athrow
    //   212: new 189	java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   219: astore 6
    //   221: aload 6
    //   223: aload_0
    //   224: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: aload 6
    //   230: ldc_w 411
    //   233: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: aload 6
    //   239: lload 4
    //   241: invokevirtual 266	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: new 103	java/io/IOException
    //   248: dup
    //   249: aload 6
    //   251: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokespecial 408	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   257: astore_0
    //   258: goto +5 -> 263
    //   261: aload_0
    //   262: athrow
    //   263: goto -2 -> 261
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	paramFile	File
    //   9	59	1	i	int
    //   40	24	2	j	int
    //   54	13	3	k	int
    //   4	236	4	l	long
    //   27	86	6	localObject1	Object
    //   134	7	6	localIOException1	java.io.IOException
    //   146	104	6	localObject2	Object
    //   37	145	7	localObject3	Object
    //   24	1	8	localObject4	Object
    //   117	20	8	localIOException2	java.io.IOException
    //   142	53	8	localObject5	Object
    //   21	169	9	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   45	55	109	finally
    //   71	109	109	finally
    //   45	55	117	java/io/IOException
    //   71	109	117	java/io/IOException
    //   29	39	130	finally
    //   148	157	130	finally
    //   161	168	130	finally
    //   172	181	130	finally
    //   185	200	130	finally
    //   29	39	134	java/io/IOException
  }
  
  public static String c(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i = paramString.lastIndexOf(".");
    int j = paramString.lastIndexOf("?");
    if (i == -1) {
      return null;
    }
    if (i == paramString.length() - 1) {
      return null;
    }
    if (j > i) {
      return paramString.substring(i + 1, j);
    }
    return paramString.substring(i + 1);
  }
  
  public static boolean c(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    paramString = new File(paramString);
    return (paramString.exists()) && (paramString.length() > 0L);
  }
  
  public static boolean c(String paramString1, String paramString2)
  {
    return com.tencent.mobileqq.utils.FileUtils.copyFile(paramString1, paramString2);
  }
  
  public static boolean d(String paramString)
  {
    com.tencent.mobileqq.utils.FileUtils.deleteDirectory(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("removeAllFiles ");
    localStringBuilder.append(paramString);
    SLog.d("Q.qqstory:Utils", localStringBuilder.toString());
    return true;
  }
  
  public static boolean e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return (paramString.indexOf("assets") >= 0) || (new File(paramString).exists());
  }
  
  public static boolean f(String paramString)
  {
    if (StringUtil.a(paramString))
    {
      SLog.d("Q.qqstory:Utils", "save from: delete path null");
      return false;
    }
    com.tencent.mobileqq.utils.FileUtils.deleteFile(paramString);
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
    com.tencent.mobileqq.utils.FileUtils.deleteFile(paramString);
    SLog.d("Q.qqstory:Utils", "tryDeleteFile %s", new Object[] { paramString });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */