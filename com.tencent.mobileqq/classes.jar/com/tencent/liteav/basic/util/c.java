package com.tencent.liteav.basic.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class c
{
  public static long a(File paramFile)
  {
    return a(paramFile, 5);
  }
  
  public static long a(File paramFile, int paramInt)
  {
    long l1 = 0L;
    if (paramInt <= 0) {
      return 0L;
    }
    l2 = l1;
    try
    {
      paramFile = paramFile.listFiles();
      l2 = l1;
      int j = paramFile.length;
      int i = 0;
      Object localObject;
      for (;;)
      {
        l2 = l1;
        if (i >= j) {
          break;
        }
        localObject = paramFile[i];
        l2 = l1;
        long l3;
        if (((File)localObject).isDirectory())
        {
          l2 = l1;
          l3 = a((File)localObject, paramInt - 1);
          l2 = l3;
        }
        else
        {
          l2 = l1;
          l3 = ((File)localObject).length();
          l2 = l3;
        }
        l1 += l2;
        i += 1;
      }
      return l2;
    }
    catch (Exception paramFile)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getFolderSize exception ");
      ((StringBuilder)localObject).append(paramFile.toString());
      TXCLog.i("FileUtil", ((StringBuilder)localObject).toString());
    }
  }
  
  /* Error */
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 60	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   4: astore 4
    //   6: aconst_null
    //   7: astore_0
    //   8: aconst_null
    //   9: astore_3
    //   10: aload 4
    //   12: aload_1
    //   13: invokevirtual 66	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   16: astore_1
    //   17: new 68	java/io/FileOutputStream
    //   20: dup
    //   21: aload_2
    //   22: invokespecial 71	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   25: astore_0
    //   26: aload_1
    //   27: aload_0
    //   28: invokestatic 74	com/tencent/liteav/basic/util/c:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   31: aload_1
    //   32: invokestatic 77	com/tencent/liteav/basic/util/c:a	(Ljava/io/Closeable;)V
    //   35: aload_0
    //   36: invokevirtual 82	java/io/OutputStream:flush	()V
    //   39: aload_0
    //   40: invokevirtual 85	java/io/OutputStream:close	()V
    //   43: return
    //   44: astore_3
    //   45: aload_0
    //   46: astore_2
    //   47: aload_3
    //   48: astore_0
    //   49: goto +10 -> 59
    //   52: astore_2
    //   53: goto +14 -> 67
    //   56: astore_0
    //   57: aconst_null
    //   58: astore_2
    //   59: aload_0
    //   60: astore_3
    //   61: goto +45 -> 106
    //   64: astore_2
    //   65: aconst_null
    //   66: astore_0
    //   67: goto +16 -> 83
    //   70: astore_3
    //   71: aconst_null
    //   72: astore_2
    //   73: aload_0
    //   74: astore_1
    //   75: goto +31 -> 106
    //   78: astore_2
    //   79: aconst_null
    //   80: astore_0
    //   81: aload_3
    //   82: astore_1
    //   83: ldc 44
    //   85: ldc 87
    //   87: aload_2
    //   88: invokestatic 91	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   91: aload_1
    //   92: invokestatic 77	com/tencent/liteav/basic/util/c:a	(Ljava/io/Closeable;)V
    //   95: aload_0
    //   96: ifnull +6 -> 102
    //   99: goto -64 -> 35
    //   102: return
    //   103: astore_3
    //   104: aload_0
    //   105: astore_2
    //   106: aload_1
    //   107: invokestatic 77	com/tencent/liteav/basic/util/c:a	(Ljava/io/Closeable;)V
    //   110: aload_2
    //   111: ifnull +11 -> 122
    //   114: aload_2
    //   115: invokevirtual 82	java/io/OutputStream:flush	()V
    //   118: aload_2
    //   119: invokevirtual 85	java/io/OutputStream:close	()V
    //   122: goto +5 -> 127
    //   125: aload_3
    //   126: athrow
    //   127: goto -2 -> 125
    //   130: astore_0
    //   131: return
    //   132: astore_0
    //   133: goto -11 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramContext	Context
    //   0	136	1	paramString1	String
    //   0	136	2	paramString2	String
    //   9	1	3	localObject1	Object
    //   44	4	3	localObject2	Object
    //   60	1	3	localContext	Context
    //   70	12	3	localObject3	Object
    //   103	23	3	localObject4	Object
    //   4	7	4	localAssetManager	AssetManager
    // Exception table:
    //   from	to	target	type
    //   26	31	44	finally
    //   26	31	52	java/io/IOException
    //   17	26	56	finally
    //   17	26	64	java/io/IOException
    //   10	17	70	finally
    //   10	17	78	java/io/IOException
    //   83	91	103	finally
    //   35	43	130	java/io/IOException
    //   114	122	132	java/io/IOException
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  public static void a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  /* Error */
  public static void a(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aconst_null
    //   5: astore 5
    //   7: new 68	java/io/FileOutputStream
    //   10: dup
    //   11: new 14	java/io/File
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 106	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: invokespecial 109	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   22: astore_0
    //   23: aload_3
    //   24: astore_2
    //   25: aload_0
    //   26: astore_3
    //   27: new 111	java/io/BufferedOutputStream
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 114	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   35: astore 4
    //   37: aload 4
    //   39: aload_1
    //   40: invokevirtual 117	java/io/BufferedOutputStream:write	([B)V
    //   43: aload 4
    //   45: invokevirtual 118	java/io/BufferedOutputStream:close	()V
    //   48: aload_0
    //   49: invokevirtual 119	java/io/FileOutputStream:close	()V
    //   52: return
    //   53: astore_1
    //   54: aload 4
    //   56: astore_2
    //   57: goto +66 -> 123
    //   60: astore_2
    //   61: aload 4
    //   63: astore_1
    //   64: aload_2
    //   65: astore 4
    //   67: goto +24 -> 91
    //   70: astore 4
    //   72: aload 5
    //   74: astore_1
    //   75: goto +16 -> 91
    //   78: astore_1
    //   79: aconst_null
    //   80: astore_0
    //   81: goto +42 -> 123
    //   84: astore 4
    //   86: aconst_null
    //   87: astore_0
    //   88: aload 5
    //   90: astore_1
    //   91: aload_1
    //   92: astore_2
    //   93: aload_0
    //   94: astore_3
    //   95: ldc 44
    //   97: ldc 121
    //   99: aload 4
    //   101: invokestatic 91	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   104: aload_1
    //   105: ifnull +7 -> 112
    //   108: aload_1
    //   109: invokevirtual 118	java/io/BufferedOutputStream:close	()V
    //   112: aload_0
    //   113: ifnull +6 -> 119
    //   116: goto -68 -> 48
    //   119: return
    //   120: astore_1
    //   121: aload_3
    //   122: astore_0
    //   123: aload_2
    //   124: ifnull +7 -> 131
    //   127: aload_2
    //   128: invokevirtual 118	java/io/BufferedOutputStream:close	()V
    //   131: aload_0
    //   132: ifnull +7 -> 139
    //   135: aload_0
    //   136: invokevirtual 119	java/io/FileOutputStream:close	()V
    //   139: goto +5 -> 144
    //   142: aload_1
    //   143: athrow
    //   144: goto -2 -> 142
    //   147: astore_0
    //   148: return
    //   149: astore_0
    //   150: goto -11 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramString	String
    //   0	153	1	paramArrayOfByte	byte[]
    //   3	54	2	localObject1	Object
    //   60	5	2	localException1	Exception
    //   92	36	2	arrayOfByte	byte[]
    //   1	121	3	str	String
    //   35	31	4	localObject2	Object
    //   70	1	4	localException2	Exception
    //   84	16	4	localException3	Exception
    //   5	84	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   37	43	53	finally
    //   37	43	60	java/lang/Exception
    //   27	37	70	java/lang/Exception
    //   7	23	78	finally
    //   7	23	84	java/lang/Exception
    //   27	37	120	finally
    //   95	104	120	finally
    //   43	48	147	java/lang/Exception
    //   48	52	147	java/lang/Exception
    //   108	112	147	java/lang/Exception
    //   127	131	149	java/lang/Exception
    //   135	139	149	java/lang/Exception
  }
  
  public static boolean a(long paramLong)
  {
    return true;
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    boolean bool2 = false;
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (paramContext.isConnectedOrConnecting()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getAssets();
    try
    {
      paramContext = paramContext.list("");
      int i = 0;
      while (i < paramContext.length)
      {
        if (paramContext[i].equals(paramString.trim()))
        {
          paramContext = new StringBuilder();
          paramContext.append(paramString);
          paramContext.append(" exist");
          TXCLog.i("isAssetFileExists", paramContext.toString());
          return true;
        }
        i += 1;
      }
      paramContext = new StringBuilder();
      paramContext.append(paramString);
      paramContext.append(" not exist");
      TXCLog.i("isAssetFileExists", paramContext.toString());
      return false;
    }
    catch (IOException paramContext)
    {
      label104:
      break label104;
    }
    paramContext = new StringBuilder();
    paramContext.append(paramString);
    paramContext.append(" not exist");
    TXCLog.i("isAssetFileExists", paramContext.toString());
    return false;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    paramString = new File(paramString);
    bool1 = bool2;
    if (paramString.exists())
    {
      bool1 = bool2;
      if (paramString.isFile()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  /* Error */
  public static String b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_0
    //   6: invokevirtual 60	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   9: aload_1
    //   10: invokevirtual 66	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   13: astore_0
    //   14: aload_0
    //   15: astore_3
    //   16: aload_0
    //   17: astore 4
    //   19: aload_0
    //   20: invokevirtual 181	java/io/InputStream:available	()I
    //   23: newarray byte
    //   25: astore_1
    //   26: aload_0
    //   27: astore_3
    //   28: aload_0
    //   29: astore 4
    //   31: aload_0
    //   32: aload_1
    //   33: invokevirtual 100	java/io/InputStream:read	([B)I
    //   36: istore_2
    //   37: iload_2
    //   38: ifgt +14 -> 52
    //   41: aload_0
    //   42: ifnull +7 -> 49
    //   45: aload_0
    //   46: invokevirtual 182	java/io/InputStream:close	()V
    //   49: ldc 143
    //   51: areturn
    //   52: aload_0
    //   53: astore_3
    //   54: aload_0
    //   55: astore 4
    //   57: aload_0
    //   58: invokevirtual 182	java/io/InputStream:close	()V
    //   61: aload_0
    //   62: astore_3
    //   63: aload_0
    //   64: astore 4
    //   66: new 149	java/lang/String
    //   69: dup
    //   70: aload_1
    //   71: ldc 184
    //   73: invokespecial 187	java/lang/String:<init>	([BLjava/lang/String;)V
    //   76: astore_1
    //   77: aload_0
    //   78: ifnull +7 -> 85
    //   81: aload_0
    //   82: invokevirtual 182	java/io/InputStream:close	()V
    //   85: aload_1
    //   86: areturn
    //   87: astore_0
    //   88: goto +28 -> 116
    //   91: astore_0
    //   92: aload 4
    //   94: astore_3
    //   95: ldc 44
    //   97: ldc 189
    //   99: aload_0
    //   100: invokestatic 91	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   103: aload 4
    //   105: ifnull +8 -> 113
    //   108: aload 4
    //   110: invokevirtual 182	java/io/InputStream:close	()V
    //   113: ldc 143
    //   115: areturn
    //   116: aload_3
    //   117: ifnull +7 -> 124
    //   120: aload_3
    //   121: invokevirtual 182	java/io/InputStream:close	()V
    //   124: aload_0
    //   125: athrow
    //   126: astore_0
    //   127: ldc 143
    //   129: areturn
    //   130: astore_0
    //   131: aload_1
    //   132: areturn
    //   133: astore_0
    //   134: ldc 143
    //   136: areturn
    //   137: astore_1
    //   138: goto -14 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramContext	Context
    //   0	141	1	paramString	String
    //   36	2	2	i	int
    //   4	117	3	localContext1	Context
    //   1	108	4	localContext2	Context
    // Exception table:
    //   from	to	target	type
    //   5	14	87	finally
    //   19	26	87	finally
    //   31	37	87	finally
    //   57	61	87	finally
    //   66	77	87	finally
    //   95	103	87	finally
    //   5	14	91	java/io/IOException
    //   19	26	91	java/io/IOException
    //   31	37	91	java/io/IOException
    //   57	61	91	java/io/IOException
    //   66	77	91	java/io/IOException
    //   45	49	126	java/io/IOException
    //   81	85	130	java/io/IOException
    //   108	113	133	java/io/IOException
    //   120	124	137	java/io/IOException
  }
  
  /* Error */
  public static String b(String paramString)
  {
    // Byte code:
    //   0: new 14	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 106	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: new 28	java/lang/StringBuilder
    //   12: dup
    //   13: ldc 143
    //   15: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: astore 4
    //   20: aload_2
    //   21: invokevirtual 175	java/io/File:isFile	()Z
    //   24: istore_1
    //   25: aconst_null
    //   26: astore_3
    //   27: aconst_null
    //   28: astore_0
    //   29: iload_1
    //   30: ifne +5 -> 35
    //   33: aconst_null
    //   34: areturn
    //   35: new 193	java/io/BufferedReader
    //   38: dup
    //   39: new 195	java/io/InputStreamReader
    //   42: dup
    //   43: new 197	java/io/FileInputStream
    //   46: dup
    //   47: aload_2
    //   48: invokespecial 198	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   51: invokespecial 201	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   54: invokespecial 204	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   57: astore_2
    //   58: aload_2
    //   59: invokevirtual 207	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   62: astore_0
    //   63: aload_0
    //   64: ifnull +13 -> 77
    //   67: aload 4
    //   69: aload_0
    //   70: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: goto -16 -> 58
    //   77: aload_2
    //   78: invokevirtual 208	java/io/BufferedReader:close	()V
    //   81: aload 4
    //   83: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: astore_0
    //   87: aload_2
    //   88: invokevirtual 208	java/io/BufferedReader:close	()V
    //   91: aload_0
    //   92: areturn
    //   93: astore_0
    //   94: new 210	java/lang/RuntimeException
    //   97: dup
    //   98: ldc 212
    //   100: aload_0
    //   101: invokespecial 215	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   104: athrow
    //   105: astore_3
    //   106: aload_2
    //   107: astore_0
    //   108: aload_3
    //   109: astore_2
    //   110: goto +29 -> 139
    //   113: astore_3
    //   114: aload_2
    //   115: astore_0
    //   116: aload_3
    //   117: astore_2
    //   118: goto +10 -> 128
    //   121: astore_2
    //   122: goto +17 -> 139
    //   125: astore_2
    //   126: aload_3
    //   127: astore_0
    //   128: new 210	java/lang/RuntimeException
    //   131: dup
    //   132: ldc 212
    //   134: aload_2
    //   135: invokespecial 215	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   138: athrow
    //   139: aload_0
    //   140: ifnull +22 -> 162
    //   143: aload_0
    //   144: invokevirtual 208	java/io/BufferedReader:close	()V
    //   147: goto +15 -> 162
    //   150: astore_0
    //   151: new 210	java/lang/RuntimeException
    //   154: dup
    //   155: ldc 212
    //   157: aload_0
    //   158: invokespecial 215	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   161: athrow
    //   162: goto +5 -> 167
    //   165: aload_2
    //   166: athrow
    //   167: goto -2 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	paramString	String
    //   24	6	1	bool	boolean
    //   8	110	2	localObject1	Object
    //   121	1	2	localObject2	Object
    //   125	41	2	localIOException1	IOException
    //   26	1	3	localObject3	Object
    //   105	4	3	localObject4	Object
    //   113	14	3	localIOException2	IOException
    //   18	64	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   87	91	93	java/io/IOException
    //   58	63	105	finally
    //   67	74	105	finally
    //   77	87	105	finally
    //   58	63	113	java/io/IOException
    //   67	74	113	java/io/IOException
    //   77	87	113	java/io/IOException
    //   35	58	121	finally
    //   128	139	121	finally
    //   35	58	125	java/io/IOException
    //   143	147	150	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.basic.util.c
 * JD-Core Version:    0.7.0.1
 */