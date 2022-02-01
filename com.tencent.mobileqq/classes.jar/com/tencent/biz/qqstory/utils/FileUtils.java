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
  
  /* Error */
  public static String a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 43	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   4: aload_1
    //   5: invokevirtual 49	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   8: astore 4
    //   10: aload_0
    //   11: aload_1
    //   12: iconst_0
    //   13: invokevirtual 53	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   16: astore 6
    //   18: aload 4
    //   20: astore_3
    //   21: aload 6
    //   23: astore 5
    //   25: ldc 54
    //   27: newarray byte
    //   29: astore 7
    //   31: aload 4
    //   33: astore_3
    //   34: aload 6
    //   36: astore 5
    //   38: aload 4
    //   40: aload 7
    //   42: invokevirtual 60	java/io/InputStream:read	([B)I
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
    //   63: invokevirtual 66	java/io/FileOutputStream:write	([BII)V
    //   66: goto -35 -> 31
    //   69: aload 4
    //   71: astore_3
    //   72: aload 6
    //   74: astore 5
    //   76: aload 6
    //   78: invokevirtual 69	java/io/FileOutputStream:flush	()V
    //   81: aload 4
    //   83: astore_3
    //   84: aload 6
    //   86: astore 5
    //   88: aload_0
    //   89: aload_1
    //   90: invokevirtual 73	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   93: invokevirtual 77	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   96: astore_0
    //   97: aload 4
    //   99: ifnull +11 -> 110
    //   102: aload 4
    //   104: invokevirtual 80	java/io/InputStream:close	()V
    //   107: goto +3 -> 110
    //   110: aload 6
    //   112: ifnull +8 -> 120
    //   115: aload 6
    //   117: invokevirtual 81	java/io/FileOutputStream:close	()V
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
    //   168: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   171: aload 4
    //   173: ifnull +11 -> 184
    //   176: aload 4
    //   178: invokevirtual 80	java/io/InputStream:close	()V
    //   181: goto +3 -> 184
    //   184: aload_0
    //   185: ifnull +7 -> 192
    //   188: aload_0
    //   189: invokevirtual 81	java/io/FileOutputStream:close	()V
    //   192: aconst_null
    //   193: areturn
    //   194: astore_0
    //   195: aload_3
    //   196: ifnull +10 -> 206
    //   199: aload_3
    //   200: invokevirtual 80	java/io/InputStream:close	()V
    //   203: goto +3 -> 206
    //   206: aload 5
    //   208: ifnull +8 -> 216
    //   211: aload 5
    //   213: invokevirtual 81	java/io/FileOutputStream:close	()V
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
  
  public static void a(Context paramContext, File paramFile)
  {
    ContentResolver localContentResolver = paramContext.getContentResolver();
    ContentValues localContentValues = c(paramContext, paramFile);
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
  
  public static void a(String paramString, boolean paramBoolean)
  {
    SLog.d("Q.qqstory:Utils", "delete %s", new Object[] { paramString });
    com.tencent.mobileqq.utils.FileUtils.delete(paramString, paramBoolean);
  }
  
  public static boolean a()
  {
    long l = b();
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
    long l = b();
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
      b(str);
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
    //   8: new 174	java/io/FileInputStream
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 177	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   16: astore_0
    //   17: new 179	java/io/BufferedOutputStream
    //   20: dup
    //   21: new 62	java/io/FileOutputStream
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 180	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   29: invokespecial 183	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   32: astore_1
    //   33: sipush 4096
    //   36: newarray byte
    //   38: astore 4
    //   40: aload_0
    //   41: aload 4
    //   43: invokevirtual 184	java/io/FileInputStream:read	([B)I
    //   46: istore_2
    //   47: iconst_m1
    //   48: iload_2
    //   49: if_icmpeq +14 -> 63
    //   52: aload_1
    //   53: aload 4
    //   55: iconst_0
    //   56: iload_2
    //   57: invokevirtual 185	java/io/BufferedOutputStream:write	([BII)V
    //   60: goto -20 -> 40
    //   63: aload_1
    //   64: invokevirtual 186	java/io/BufferedOutputStream:flush	()V
    //   67: iconst_1
    //   68: istore_3
    //   69: aload_1
    //   70: invokevirtual 187	java/io/BufferedOutputStream:close	()V
    //   73: goto +8 -> 81
    //   76: astore_1
    //   77: aload_1
    //   78: invokevirtual 188	java/lang/Exception:printStackTrace	()V
    //   81: aload_0
    //   82: invokevirtual 189	java/io/FileInputStream:close	()V
    //   85: iconst_1
    //   86: ireturn
    //   87: astore_0
    //   88: aload_0
    //   89: invokevirtual 188	java/lang/Exception:printStackTrace	()V
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
    //   130: invokevirtual 187	java/io/BufferedOutputStream:close	()V
    //   133: goto +10 -> 143
    //   136: astore 4
    //   138: aload 4
    //   140: invokevirtual 188	java/lang/Exception:printStackTrace	()V
    //   143: aload_1
    //   144: ifnull +15 -> 159
    //   147: aload_1
    //   148: invokevirtual 189	java/io/FileInputStream:close	()V
    //   151: goto +8 -> 159
    //   154: astore_1
    //   155: aload_1
    //   156: invokevirtual 188	java/lang/Exception:printStackTrace	()V
    //   159: aload_0
    //   160: athrow
    //   161: aconst_null
    //   162: astore_0
    //   163: aload 5
    //   165: astore_1
    //   166: aload_1
    //   167: ifnull +15 -> 182
    //   170: aload_1
    //   171: invokevirtual 187	java/io/BufferedOutputStream:close	()V
    //   174: goto +8 -> 182
    //   177: astore_1
    //   178: aload_1
    //   179: invokevirtual 188	java/lang/Exception:printStackTrace	()V
    //   182: aload_0
    //   183: ifnull +7 -> 190
    //   186: aload_0
    //   187: invokevirtual 189	java/io/FileInputStream:close	()V
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
  
  public static boolean a(String paramString1, String paramString2)
  {
    return com.tencent.mobileqq.utils.FileUtils.rename(paramString1, paramString2);
  }
  
  /* Error */
  public static byte[] a(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 156	java/io/File:exists	()Z
    //   4: ifeq +356 -> 360
    //   7: aload_0
    //   8: invokevirtual 197	java/io/File:isFile	()Z
    //   11: ifeq +312 -> 323
    //   14: aload_0
    //   15: invokevirtual 200	java/io/File:canRead	()Z
    //   18: ifeq +268 -> 286
    //   21: aload_0
    //   22: invokevirtual 22	java/io/File:length	()J
    //   25: lstore 4
    //   27: lload 4
    //   29: l2i
    //   30: istore_1
    //   31: iload_1
    //   32: i2l
    //   33: lload 4
    //   35: lcmp
    //   36: ifne +213 -> 249
    //   39: iload_1
    //   40: newarray byte
    //   42: astore 9
    //   44: aconst_null
    //   45: astore 8
    //   47: aconst_null
    //   48: astore 6
    //   50: new 174	java/io/FileInputStream
    //   53: dup
    //   54: aload_0
    //   55: invokespecial 177	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   58: astore 7
    //   60: iconst_0
    //   61: istore_2
    //   62: iload_1
    //   63: ifle +79 -> 142
    //   66: aload 7
    //   68: aload 9
    //   70: iload_2
    //   71: iload_1
    //   72: invokevirtual 203	java/io/FileInputStream:read	([BII)I
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
    //   92: new 129	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   99: astore 6
    //   101: aload 6
    //   103: aload_0
    //   104: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 6
    //   110: ldc 208
    //   112: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: new 210	java/lang/RuntimeException
    //   119: dup
    //   120: aload 6
    //   122: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokespecial 211	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   128: athrow
    //   129: astore_0
    //   130: aload 7
    //   132: astore 6
    //   134: goto +93 -> 227
    //   137: astore 8
    //   139: goto +33 -> 172
    //   142: aload 7
    //   144: invokevirtual 189	java/io/FileInputStream:close	()V
    //   147: aload 9
    //   149: areturn
    //   150: astore_0
    //   151: aload_0
    //   152: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   155: aload 9
    //   157: areturn
    //   158: astore_0
    //   159: goto +68 -> 227
    //   162: astore 6
    //   164: aload 8
    //   166: astore 7
    //   168: aload 6
    //   170: astore 8
    //   172: aload 7
    //   174: astore 6
    //   176: new 129	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   183: astore 9
    //   185: aload 7
    //   187: astore 6
    //   189: aload 9
    //   191: aload_0
    //   192: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload 7
    //   198: astore 6
    //   200: aload 9
    //   202: ldc 213
    //   204: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 7
    //   210: astore 6
    //   212: new 210	java/lang/RuntimeException
    //   215: dup
    //   216: aload 9
    //   218: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: aload 8
    //   223: invokespecial 216	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   226: athrow
    //   227: aload 6
    //   229: ifnull +18 -> 247
    //   232: aload 6
    //   234: invokevirtual 189	java/io/FileInputStream:close	()V
    //   237: goto +10 -> 247
    //   240: astore 6
    //   242: aload 6
    //   244: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   247: aload_0
    //   248: athrow
    //   249: new 129	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   256: astore 6
    //   258: aload 6
    //   260: aload_0
    //   261: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload 6
    //   267: ldc 218
    //   269: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: new 210	java/lang/RuntimeException
    //   276: dup
    //   277: aload 6
    //   279: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokespecial 211	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   285: athrow
    //   286: new 129	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   293: astore 6
    //   295: aload 6
    //   297: aload_0
    //   298: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload 6
    //   304: ldc 220
    //   306: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: new 210	java/lang/RuntimeException
    //   313: dup
    //   314: aload 6
    //   316: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: invokespecial 211	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   322: athrow
    //   323: new 129	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   330: astore 6
    //   332: aload 6
    //   334: aload_0
    //   335: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: aload 6
    //   341: ldc 222
    //   343: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: new 210	java/lang/RuntimeException
    //   350: dup
    //   351: aload 6
    //   353: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: invokespecial 211	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   359: athrow
    //   360: new 129	java/lang/StringBuilder
    //   363: dup
    //   364: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   367: astore 6
    //   369: aload 6
    //   371: aload_0
    //   372: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload 6
    //   378: ldc 224
    //   380: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: new 210	java/lang/RuntimeException
    //   387: dup
    //   388: aload 6
    //   390: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: invokespecial 211	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   396: astore_0
    //   397: goto +5 -> 402
    //   400: aload_0
    //   401: athrow
    //   402: goto -2 -> 400
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	405	0	paramFile	File
    //   30	59	1	i	int
    //   61	24	2	j	int
    //   75	13	3	k	int
    //   25	9	4	l	long
    //   48	85	6	localObject1	Object
    //   162	7	6	localIOException1	java.io.IOException
    //   174	59	6	localObject2	Object
    //   240	3	6	localIOException2	java.io.IOException
    //   256	133	6	localStringBuilder	StringBuilder
    //   58	151	7	localObject3	Object
    //   45	1	8	localObject4	Object
    //   137	28	8	localIOException3	java.io.IOException
    //   170	52	8	localObject5	Object
    //   42	175	9	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   66	76	129	finally
    //   92	129	129	finally
    //   66	76	137	java/io/IOException
    //   92	129	137	java/io/IOException
    //   142	147	150	java/io/IOException
    //   50	60	158	finally
    //   176	185	158	finally
    //   189	196	158	finally
    //   200	208	158	finally
    //   212	227	158	finally
    //   50	60	162	java/io/IOException
    //   232	237	240	java/io/IOException
  }
  
  public static long b()
  {
    return com.tencent.mobileqq.utils.FileUtils.getAvailableExternalMemorySize();
  }
  
  public static void b(Context paramContext, File paramFile)
  {
    FileProvider7Helper.savePhotoToSysAlbum(paramContext, paramFile);
  }
  
  public static boolean b(String paramString)
  {
    File localFile = new File(paramString);
    if ((!localFile.exists()) && (!localFile.mkdirs()))
    {
      SLog.d("Q.qqstory:Utils", "mkdirs failed, path:%s", new Object[] { paramString });
      return false;
    }
    return true;
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
    //   1: invokevirtual 22	java/io/File:length	()J
    //   4: lstore 4
    //   6: lload 4
    //   8: l2i
    //   9: istore_1
    //   10: iload_1
    //   11: i2l
    //   12: lload 4
    //   14: lcmp
    //   15: ifne +195 -> 210
    //   18: iload_1
    //   19: newarray byte
    //   21: astore 9
    //   23: aconst_null
    //   24: astore 8
    //   26: aconst_null
    //   27: astore 6
    //   29: new 174	java/io/FileInputStream
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 177	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   37: astore 7
    //   39: iconst_0
    //   40: istore_2
    //   41: iload_1
    //   42: ifle +79 -> 121
    //   45: aload 7
    //   47: aload 9
    //   49: iload_2
    //   50: iload_1
    //   51: invokevirtual 203	java/io/FileInputStream:read	([BII)I
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
    //   71: new 129	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   78: astore 6
    //   80: aload 6
    //   82: aload_0
    //   83: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 6
    //   89: ldc 247
    //   91: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: new 37	java/io/IOException
    //   98: dup
    //   99: aload 6
    //   101: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokespecial 248	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   107: athrow
    //   108: astore_0
    //   109: aload 7
    //   111: astore 6
    //   113: goto +85 -> 198
    //   116: astore 8
    //   118: goto +25 -> 143
    //   121: aload 7
    //   123: invokevirtual 189	java/io/FileInputStream:close	()V
    //   126: aload 9
    //   128: areturn
    //   129: astore_0
    //   130: goto +68 -> 198
    //   133: astore 6
    //   135: aload 8
    //   137: astore 7
    //   139: aload 6
    //   141: astore 8
    //   143: aload 7
    //   145: astore 6
    //   147: new 129	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   154: astore 9
    //   156: aload 7
    //   158: astore 6
    //   160: aload 9
    //   162: aload_0
    //   163: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload 7
    //   169: astore 6
    //   171: aload 9
    //   173: ldc 213
    //   175: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload 7
    //   181: astore 6
    //   183: new 37	java/io/IOException
    //   186: dup
    //   187: aload 9
    //   189: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: aload 8
    //   194: invokespecial 249	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   197: athrow
    //   198: aload 6
    //   200: ifnull +8 -> 208
    //   203: aload 6
    //   205: invokevirtual 189	java/io/FileInputStream:close	()V
    //   208: aload_0
    //   209: athrow
    //   210: new 129	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   217: astore 6
    //   219: aload 6
    //   221: aload_0
    //   222: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload 6
    //   228: ldc 251
    //   230: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload 6
    //   236: lload 4
    //   238: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: new 37	java/io/IOException
    //   245: dup
    //   246: aload 6
    //   248: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokespecial 248	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   254: astore_0
    //   255: goto +5 -> 260
    //   258: aload_0
    //   259: athrow
    //   260: goto -2 -> 258
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	paramFile	File
    //   9	59	1	i	int
    //   40	24	2	j	int
    //   54	13	3	k	int
    //   4	233	4	l	long
    //   27	85	6	localObject1	Object
    //   133	7	6	localIOException1	java.io.IOException
    //   145	102	6	localObject2	Object
    //   37	143	7	localObject3	Object
    //   24	1	8	localObject4	Object
    //   116	20	8	localIOException2	java.io.IOException
    //   141	52	8	localObject5	Object
    //   21	167	9	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   45	55	108	finally
    //   71	108	108	finally
    //   45	55	116	java/io/IOException
    //   71	108	116	java/io/IOException
    //   29	39	129	finally
    //   147	156	129	finally
    //   160	167	129	finally
    //   171	179	129	finally
    //   183	198	129	finally
    //   29	39	133	java/io/IOException
  }
  
  public static ContentValues c(Context paramContext, File paramFile)
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
  
  public static void c(File paramFile)
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
          c(localObject[i]);
          i += 1;
        }
        paramFile.delete();
        return;
      }
      paramFile.delete();
    }
  }
  
  public static boolean c(String paramString)
  {
    return com.tencent.mobileqq.utils.FileUtils.fileExists(paramString);
  }
  
  public static boolean c(String paramString1, String paramString2)
  {
    return com.tencent.mobileqq.utils.FileUtils.copyFile(paramString1, paramString2);
  }
  
  public static boolean d(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    paramString = new File(paramString);
    return (paramString.exists()) && (paramString.length() > 0L);
  }
  
  public static boolean e(String paramString)
  {
    com.tencent.mobileqq.utils.FileUtils.deleteDirectory(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("removeAllFiles ");
    localStringBuilder.append(paramString);
    SLog.d("Q.qqstory:Utils", localStringBuilder.toString());
    return true;
  }
  
  public static String f(String paramString)
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
  
  public static void g(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append("dont_delete.txt");
    localObject = ((StringBuilder)localObject).toString();
    if (!d((String)localObject))
    {
      b(paramString);
      SLog.d("Q.qqstory:Utils", "make flag file %b", new Object[] { Boolean.valueOf(com.tencent.mobileqq.utils.FileUtils.writeFile((String)localObject, String.valueOf(System.currentTimeMillis()))) });
      return;
    }
    SLog.d("Q.qqstory:Utils", "flag file exist");
  }
  
  public static long h(String paramString)
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
  
  public static boolean i(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return (paramString.indexOf("assets") >= 0) || (new File(paramString).exists());
  }
  
  public static boolean j(String paramString)
  {
    if (StringUtil.isEmpty(paramString))
    {
      SLog.d("Q.qqstory:Utils", "save from: delete path null");
      return false;
    }
    com.tencent.mobileqq.utils.FileUtils.deleteFile(paramString);
    SLog.d("Q.qqstory:Utils", "deleteFile %s", new Object[] { paramString });
    return true;
  }
  
  public static boolean k(String paramString)
  {
    if (StringUtil.isEmpty(paramString))
    {
      SLog.d("Q.qqstory:Utils", "save from: delete path null");
      return false;
    }
    com.tencent.mobileqq.utils.FileUtils.deleteFile(paramString);
    SLog.d("Q.qqstory:Utils", "tryDeleteFile %s", new Object[] { paramString });
    return true;
  }
  
  public static String l(String paramString)
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
  
  public static String m(String paramString)
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
  
  public static File n(String paramString)
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
  @android.annotation.TargetApi(10)
  public static int[] o(String paramString)
  {
    // Byte code:
    //   0: new 432	android/media/MediaMetadataRetriever
    //   3: dup
    //   4: invokespecial 433	android/media/MediaMetadataRetriever:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_0
    //   10: invokevirtual 436	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   13: aload_2
    //   14: bipush 24
    //   16: invokevirtual 439	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   19: astore_1
    //   20: aload_2
    //   21: bipush 18
    //   23: invokevirtual 439	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   26: astore 4
    //   28: aload_2
    //   29: bipush 19
    //   31: invokevirtual 439	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   34: astore 5
    //   36: iconst_3
    //   37: newarray int
    //   39: astore_3
    //   40: aload_1
    //   41: astore_0
    //   42: aload_1
    //   43: ifnonnull +7 -> 50
    //   46: ldc_w 441
    //   49: astore_0
    //   50: aload_3
    //   51: iconst_0
    //   52: aload_0
    //   53: invokestatic 446	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   56: invokevirtual 449	java/lang/Integer:intValue	()I
    //   59: iastore
    //   60: aload_3
    //   61: iconst_1
    //   62: aload 4
    //   64: invokestatic 446	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   67: invokevirtual 449	java/lang/Integer:intValue	()I
    //   70: iastore
    //   71: aload_3
    //   72: iconst_2
    //   73: aload 5
    //   75: invokestatic 446	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   78: invokevirtual 449	java/lang/Integer:intValue	()I
    //   81: iastore
    //   82: aload_2
    //   83: invokevirtual 452	android/media/MediaMetadataRetriever:release	()V
    //   86: aload_3
    //   87: areturn
    //   88: astore_0
    //   89: new 129	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   96: astore_1
    //   97: aload_1
    //   98: ldc_w 454
    //   101: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload_1
    //   106: aload_0
    //   107: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: ldc 24
    //   113: aload_1
    //   114: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 295	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload_3
    //   121: areturn
    //   122: astore_0
    //   123: goto +52 -> 175
    //   126: astore_0
    //   127: ldc 24
    //   129: ldc 107
    //   131: aload_0
    //   132: invokestatic 110	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   135: aload_2
    //   136: invokevirtual 452	android/media/MediaMetadataRetriever:release	()V
    //   139: aconst_null
    //   140: areturn
    //   141: astore_0
    //   142: new 129	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   149: astore_1
    //   150: aload_1
    //   151: ldc_w 454
    //   154: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload_1
    //   159: aload_0
    //   160: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: ldc 24
    //   166: aload_1
    //   167: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 295	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: aconst_null
    //   174: areturn
    //   175: aload_2
    //   176: invokevirtual 452	android/media/MediaMetadataRetriever:release	()V
    //   179: goto +35 -> 214
    //   182: astore_1
    //   183: new 129	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   190: astore_2
    //   191: aload_2
    //   192: ldc_w 454
    //   195: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload_2
    //   200: aload_1
    //   201: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: ldc 24
    //   207: aload_2
    //   208: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokestatic 295	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */