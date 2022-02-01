package com.mojitox.mxflutter.framework.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.mojitox.mxflutter.framework.constants.MxConfig;
import com.mojitox.mxflutter.framework.js.JsEngineLoader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileUtils
{
  public static String a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getAssets().open(paramString);
    }
    catch (IOException paramContext)
    {
      MxLog.b("FileUtils", "", paramContext);
      paramContext = null;
    }
    return a(paramContext);
  }
  
  /* Error */
  @androidx.annotation.Nullable
  private static String a(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: ifnonnull +5 -> 8
    //   6: aconst_null
    //   7: areturn
    //   8: new 41	java/io/ByteArrayOutputStream
    //   11: dup
    //   12: invokespecial 42	java/io/ByteArrayOutputStream:<init>	()V
    //   15: astore_3
    //   16: aload_3
    //   17: astore_2
    //   18: sipush 4096
    //   21: newarray byte
    //   23: astore 4
    //   25: aload_3
    //   26: astore_2
    //   27: aload_0
    //   28: aload 4
    //   30: invokevirtual 48	java/io/InputStream:read	([B)I
    //   33: istore_1
    //   34: iload_1
    //   35: iconst_m1
    //   36: if_icmpeq +16 -> 52
    //   39: aload_3
    //   40: astore_2
    //   41: aload_3
    //   42: aload 4
    //   44: iconst_0
    //   45: iload_1
    //   46: invokevirtual 52	java/io/ByteArrayOutputStream:write	([BII)V
    //   49: goto -24 -> 25
    //   52: aload_3
    //   53: astore_2
    //   54: aload_3
    //   55: invokevirtual 55	java/io/ByteArrayOutputStream:flush	()V
    //   58: aload_3
    //   59: astore_2
    //   60: aload_3
    //   61: invokevirtual 59	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   64: astore 4
    //   66: aload_3
    //   67: invokevirtual 62	java/io/ByteArrayOutputStream:close	()V
    //   70: aload_0
    //   71: ifnull +19 -> 90
    //   74: aload_0
    //   75: invokevirtual 63	java/io/InputStream:close	()V
    //   78: aload 4
    //   80: areturn
    //   81: astore_0
    //   82: ldc 27
    //   84: ldc 29
    //   86: aload_0
    //   87: invokestatic 35	com/mojitox/mxflutter/framework/utils/MxLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   90: aload 4
    //   92: areturn
    //   93: astore_3
    //   94: goto +58 -> 152
    //   97: astore 4
    //   99: goto +11 -> 110
    //   102: astore_3
    //   103: goto +49 -> 152
    //   106: astore 4
    //   108: aconst_null
    //   109: astore_3
    //   110: aload_3
    //   111: astore_2
    //   112: ldc 27
    //   114: ldc 29
    //   116: aload 4
    //   118: invokestatic 35	com/mojitox/mxflutter/framework/utils/MxLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   121: aload_3
    //   122: ifnull +10 -> 132
    //   125: aload_3
    //   126: invokevirtual 62	java/io/ByteArrayOutputStream:close	()V
    //   129: goto +3 -> 132
    //   132: aload_0
    //   133: ifnull +17 -> 150
    //   136: aload_0
    //   137: invokevirtual 63	java/io/InputStream:close	()V
    //   140: aconst_null
    //   141: areturn
    //   142: ldc 27
    //   144: ldc 29
    //   146: aload_0
    //   147: invokestatic 35	com/mojitox/mxflutter/framework/utils/MxLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   150: aconst_null
    //   151: areturn
    //   152: aload_2
    //   153: ifnull +10 -> 163
    //   156: aload_2
    //   157: invokevirtual 62	java/io/ByteArrayOutputStream:close	()V
    //   160: goto +3 -> 163
    //   163: aload_0
    //   164: ifnull +18 -> 182
    //   167: aload_0
    //   168: invokevirtual 63	java/io/InputStream:close	()V
    //   171: goto +11 -> 182
    //   174: ldc 27
    //   176: ldc 29
    //   178: aload_0
    //   179: invokestatic 35	com/mojitox/mxflutter/framework/utils/MxLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   182: goto +5 -> 187
    //   185: aload_3
    //   186: athrow
    //   187: goto -2 -> 185
    //   190: astore_0
    //   191: goto -49 -> 142
    //   194: astore_0
    //   195: goto -21 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	paramInputStream	java.io.InputStream
    //   33	13	1	i	int
    //   1	156	2	localObject1	Object
    //   15	52	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   93	1	3	localObject2	Object
    //   102	1	3	localObject3	Object
    //   109	77	3	localObject4	Object
    //   23	68	4	localObject5	Object
    //   97	1	4	localIOException1	IOException
    //   106	11	4	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   66	70	81	java/io/IOException
    //   74	78	81	java/io/IOException
    //   18	25	93	finally
    //   27	34	93	finally
    //   41	49	93	finally
    //   54	58	93	finally
    //   60	66	93	finally
    //   112	121	93	finally
    //   18	25	97	java/io/IOException
    //   27	34	97	java/io/IOException
    //   41	49	97	java/io/IOException
    //   54	58	97	java/io/IOException
    //   60	66	97	java/io/IOException
    //   8	16	102	finally
    //   8	16	106	java/io/IOException
    //   125	129	190	java/io/IOException
    //   136	140	190	java/io/IOException
    //   156	160	194	java/io/IOException
    //   167	171	194	java/io/IOException
  }
  
  public static String a(String paramString)
  {
    Object localObject = paramString;
    if (paramString.startsWith("./")) {
      localObject = paramString.substring(2);
    }
    paramString = (String)localObject;
    if (!((String)localObject).endsWith(".js"))
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject);
      paramString.append(".js");
      paramString = paramString.toString();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(MxConfig.a());
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(paramString);
    return ((StringBuilder)localObject).toString();
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
  
  /* Error */
  public static boolean a(java.io.InputStream paramInputStream, File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore_3
    //   11: new 103	java/io/BufferedOutputStream
    //   14: dup
    //   15: new 105	java/io/FileOutputStream
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 108	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   23: invokespecial 111	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   26: astore_1
    //   27: sipush 256
    //   30: newarray byte
    //   32: astore_3
    //   33: aload_0
    //   34: aload_3
    //   35: invokevirtual 48	java/io/InputStream:read	([B)I
    //   38: istore_2
    //   39: iload_2
    //   40: iconst_m1
    //   41: if_icmpeq +13 -> 54
    //   44: aload_1
    //   45: aload_3
    //   46: iconst_0
    //   47: iload_2
    //   48: invokevirtual 114	java/io/OutputStream:write	([BII)V
    //   51: goto -18 -> 33
    //   54: aload_1
    //   55: invokevirtual 115	java/io/OutputStream:flush	()V
    //   58: aload_1
    //   59: invokevirtual 116	java/io/OutputStream:close	()V
    //   62: aload_0
    //   63: ifnull +7 -> 70
    //   66: aload_0
    //   67: invokevirtual 63	java/io/InputStream:close	()V
    //   70: iconst_1
    //   71: ireturn
    //   72: astore_3
    //   73: goto +67 -> 140
    //   76: astore 4
    //   78: goto +18 -> 96
    //   81: astore 4
    //   83: aload_3
    //   84: astore_1
    //   85: aload 4
    //   87: astore_3
    //   88: goto +52 -> 140
    //   91: astore 4
    //   93: aload 5
    //   95: astore_1
    //   96: aload_1
    //   97: astore_3
    //   98: ldc 27
    //   100: aload 4
    //   102: invokevirtual 117	java/io/IOException:toString	()Ljava/lang/String;
    //   105: invokestatic 120	com/mojitox/mxflutter/framework/utils/MxLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: aload_1
    //   109: ifnull +10 -> 119
    //   112: aload_1
    //   113: invokevirtual 116	java/io/OutputStream:close	()V
    //   116: goto +3 -> 119
    //   119: aload_0
    //   120: ifnull +18 -> 138
    //   123: aload_0
    //   124: invokevirtual 63	java/io/InputStream:close	()V
    //   127: iconst_0
    //   128: ireturn
    //   129: ldc 27
    //   131: aload_0
    //   132: invokevirtual 117	java/io/IOException:toString	()Ljava/lang/String;
    //   135: invokestatic 120	com/mojitox/mxflutter/framework/utils/MxLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: iconst_0
    //   139: ireturn
    //   140: aload_1
    //   141: ifnull +10 -> 151
    //   144: aload_1
    //   145: invokevirtual 116	java/io/OutputStream:close	()V
    //   148: goto +3 -> 151
    //   151: aload_0
    //   152: ifnull +19 -> 171
    //   155: aload_0
    //   156: invokevirtual 63	java/io/InputStream:close	()V
    //   159: goto +12 -> 171
    //   162: ldc 27
    //   164: aload_0
    //   165: invokevirtual 117	java/io/IOException:toString	()Ljava/lang/String;
    //   168: invokestatic 120	com/mojitox/mxflutter/framework/utils/MxLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: goto +5 -> 176
    //   174: aload_3
    //   175: athrow
    //   176: goto -2 -> 174
    //   179: astore_0
    //   180: goto -51 -> 129
    //   183: astore_0
    //   184: goto -22 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	paramInputStream	java.io.InputStream
    //   0	187	1	paramFile	File
    //   38	10	2	i	int
    //   10	36	3	arrayOfByte	byte[]
    //   72	12	3	localObject1	Object
    //   87	88	3	localObject2	Object
    //   76	1	4	localIOException1	IOException
    //   81	5	4	localObject3	Object
    //   91	10	4	localIOException2	IOException
    //   7	87	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   27	33	72	finally
    //   33	39	72	finally
    //   44	51	72	finally
    //   54	58	72	finally
    //   27	33	76	java/io/IOException
    //   33	39	76	java/io/IOException
    //   44	51	76	java/io/IOException
    //   54	58	76	java/io/IOException
    //   11	27	81	finally
    //   98	108	81	finally
    //   11	27	91	java/io/IOException
    //   58	62	179	java/io/IOException
    //   66	70	179	java/io/IOException
    //   112	116	179	java/io/IOException
    //   123	127	179	java/io/IOException
    //   144	148	183	java/io/IOException
    //   155	159	183	java/io/IOException
  }
  
  public static String b(String paramString)
  {
    try
    {
      paramString = new FileInputStream(new File(paramString));
    }
    catch (FileNotFoundException paramString)
    {
      MxLog.b("FileUtils", "", paramString);
      paramString = null;
    }
    return a(paramString);
  }
  
  public static String c(String paramString)
  {
    if (paramString.startsWith("file:///android_asset/")) {
      return a(JsEngineLoader.a().a(), paramString.replace("file:///android_asset/", ""));
    }
    return b(paramString);
  }
  
  public static String d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = paramString.substring(paramString.lastIndexOf("/"));
        return paramString;
      }
      catch (Exception paramString)
      {
        MxLog.b("FileUtils", paramString.toString());
      }
    }
    return "no name";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */