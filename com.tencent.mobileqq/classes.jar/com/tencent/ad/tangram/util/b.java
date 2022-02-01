package com.tencent.ad.tangram.util;

import android.content.Context;
import android.os.Environment;
import java.io.File;

public final class b
{
  private static final String APP_PRE_ORDER_DIR = "app_preorder";
  private static final String GDT_DIR = "gdt";
  private static final String TAG = "AdFileUtils";
  
  public static File fetchFileInDataDir(Context paramContext, String paramString)
  {
    paramContext = paramContext.getApplicationContext().getDir("gdt", 0);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext.getAbsolutePath());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("app_preorder");
    paramContext = ((StringBuilder)localObject).toString();
    localObject = new File(paramContext);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(paramString);
    return new File(((StringBuilder)localObject).toString());
  }
  
  public static String fetchFilePathInSDCard(String paramString)
  {
    String str;
    if (Environment.getExternalStorageState().equals("mounted")) {
      str = Environment.getExternalStorageDirectory().getAbsolutePath();
    } else {
      str = null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static File getParentDirectory(Context paramContext)
  {
    if ((paramContext != null) && (paramContext.getApplicationContext() != null)) {
      return paramContext.getApplicationContext().getDir("gdt", 0);
    }
    return null;
  }
  
  /* Error */
  public static String read(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +170 -> 171
    //   4: aload_0
    //   5: invokevirtual 57	java/io/File:exists	()Z
    //   8: ifeq +163 -> 171
    //   11: new 89	java/io/FileInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 92	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   19: astore_1
    //   20: aload_1
    //   21: astore_0
    //   22: aload_1
    //   23: invokevirtual 96	java/io/FileInputStream:available	()I
    //   26: newarray byte
    //   28: astore_2
    //   29: aload_1
    //   30: astore_0
    //   31: aload_1
    //   32: aload_2
    //   33: invokevirtual 99	java/io/FileInputStream:read	([B)I
    //   36: pop
    //   37: aload_1
    //   38: astore_0
    //   39: aload_1
    //   40: invokevirtual 102	java/io/FileInputStream:close	()V
    //   43: aload_1
    //   44: astore_0
    //   45: new 71	java/lang/String
    //   48: dup
    //   49: aload_2
    //   50: ldc 104
    //   52: invokespecial 107	java/lang/String:<init>	([BLjava/lang/String;)V
    //   55: astore_2
    //   56: aload_1
    //   57: invokevirtual 102	java/io/FileInputStream:close	()V
    //   60: goto +12 -> 72
    //   63: astore_0
    //   64: ldc 14
    //   66: ldc 109
    //   68: aload_0
    //   69: invokestatic 115	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   72: aload_2
    //   73: areturn
    //   74: astore_1
    //   75: goto +74 -> 149
    //   78: astore_2
    //   79: goto +16 -> 95
    //   82: astore_2
    //   83: goto +35 -> 118
    //   86: astore_1
    //   87: aconst_null
    //   88: astore_0
    //   89: goto +60 -> 149
    //   92: astore_2
    //   93: aconst_null
    //   94: astore_1
    //   95: aload_1
    //   96: astore_0
    //   97: ldc 14
    //   99: ldc 109
    //   101: aload_2
    //   102: invokestatic 115	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   105: aload_1
    //   106: ifnull +65 -> 171
    //   109: aload_1
    //   110: invokevirtual 102	java/io/FileInputStream:close	()V
    //   113: aconst_null
    //   114: areturn
    //   115: astore_2
    //   116: aconst_null
    //   117: astore_1
    //   118: aload_1
    //   119: astore_0
    //   120: ldc 14
    //   122: ldc 109
    //   124: aload_2
    //   125: invokestatic 115	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   128: aload_1
    //   129: ifnull +42 -> 171
    //   132: aload_1
    //   133: invokevirtual 102	java/io/FileInputStream:close	()V
    //   136: aconst_null
    //   137: areturn
    //   138: astore_0
    //   139: ldc 14
    //   141: ldc 109
    //   143: aload_0
    //   144: invokestatic 115	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   147: aconst_null
    //   148: areturn
    //   149: aload_0
    //   150: ifnull +19 -> 169
    //   153: aload_0
    //   154: invokevirtual 102	java/io/FileInputStream:close	()V
    //   157: goto +12 -> 169
    //   160: astore_0
    //   161: ldc 14
    //   163: ldc 109
    //   165: aload_0
    //   166: invokestatic 115	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   169: aload_1
    //   170: athrow
    //   171: aconst_null
    //   172: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	paramFile	File
    //   19	38	1	localFileInputStream	java.io.FileInputStream
    //   74	1	1	localObject1	Object
    //   86	1	1	localObject2	Object
    //   94	76	1	localObject3	Object
    //   28	45	2	localObject4	Object
    //   78	1	2	localIOException1	java.io.IOException
    //   82	1	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   92	10	2	localIOException2	java.io.IOException
    //   115	10	2	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   56	60	63	java/io/IOException
    //   22	29	74	finally
    //   31	37	74	finally
    //   39	43	74	finally
    //   45	56	74	finally
    //   97	105	74	finally
    //   120	128	74	finally
    //   22	29	78	java/io/IOException
    //   31	37	78	java/io/IOException
    //   39	43	78	java/io/IOException
    //   45	56	78	java/io/IOException
    //   22	29	82	java/io/FileNotFoundException
    //   31	37	82	java/io/FileNotFoundException
    //   39	43	82	java/io/FileNotFoundException
    //   45	56	82	java/io/FileNotFoundException
    //   11	20	86	finally
    //   11	20	92	java/io/IOException
    //   11	20	115	java/io/FileNotFoundException
    //   109	113	138	java/io/IOException
    //   132	136	138	java/io/IOException
    //   153	157	160	java/io/IOException
  }
  
  /* Error */
  public static void write(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +144 -> 145
    //   4: aload_1
    //   5: invokestatic 123	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifne +137 -> 145
    //   11: aconst_null
    //   12: astore_3
    //   13: aconst_null
    //   14: astore 4
    //   16: aconst_null
    //   17: astore_2
    //   18: new 125	java/io/FileOutputStream
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 126	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   26: astore_0
    //   27: aload_0
    //   28: aload_1
    //   29: ldc 128
    //   31: invokevirtual 132	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   34: invokevirtual 135	java/io/FileOutputStream:write	([B)V
    //   37: aload_0
    //   38: invokevirtual 138	java/io/FileOutputStream:flush	()V
    //   41: aload_0
    //   42: invokevirtual 139	java/io/FileOutputStream:close	()V
    //   45: aload_0
    //   46: invokevirtual 139	java/io/FileOutputStream:close	()V
    //   49: return
    //   50: astore_1
    //   51: goto +72 -> 123
    //   54: astore_1
    //   55: goto +16 -> 71
    //   58: astore_1
    //   59: goto +35 -> 94
    //   62: astore_1
    //   63: aload_2
    //   64: astore_0
    //   65: goto +58 -> 123
    //   68: astore_1
    //   69: aload_3
    //   70: astore_0
    //   71: aload_0
    //   72: astore_2
    //   73: ldc 14
    //   75: ldc 141
    //   77: aload_1
    //   78: invokestatic 115	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   81: aload_0
    //   82: ifnull +63 -> 145
    //   85: aload_0
    //   86: invokevirtual 139	java/io/FileOutputStream:close	()V
    //   89: return
    //   90: astore_1
    //   91: aload 4
    //   93: astore_0
    //   94: aload_0
    //   95: astore_2
    //   96: ldc 14
    //   98: ldc 141
    //   100: aload_1
    //   101: invokestatic 115	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   104: aload_0
    //   105: ifnull +40 -> 145
    //   108: aload_0
    //   109: invokevirtual 139	java/io/FileOutputStream:close	()V
    //   112: return
    //   113: astore_0
    //   114: ldc 14
    //   116: ldc 141
    //   118: aload_0
    //   119: invokestatic 115	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   122: return
    //   123: aload_0
    //   124: ifnull +19 -> 143
    //   127: aload_0
    //   128: invokevirtual 139	java/io/FileOutputStream:close	()V
    //   131: goto +12 -> 143
    //   134: astore_0
    //   135: ldc 14
    //   137: ldc 141
    //   139: aload_0
    //   140: invokestatic 115	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   143: aload_1
    //   144: athrow
    //   145: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	paramFile	File
    //   0	146	1	paramString	String
    //   17	79	2	localFile	File
    //   12	58	3	localObject1	Object
    //   14	78	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   27	45	50	finally
    //   27	45	54	java/io/IOException
    //   27	45	58	java/io/FileNotFoundException
    //   18	27	62	finally
    //   73	81	62	finally
    //   96	104	62	finally
    //   18	27	68	java/io/IOException
    //   18	27	90	java/io/FileNotFoundException
    //   45	49	113	java/io/IOException
    //   85	89	113	java/io/IOException
    //   108	112	113	java/io/IOException
    //   127	131	134	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.util.b
 * JD-Core Version:    0.7.0.1
 */