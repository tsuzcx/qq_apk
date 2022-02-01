package com.tencent.jalpha.common;

import java.io.File;

public class Utils
{
  private static final String TAG = "Utils";
  
  public static boolean fileIsExists(String paramString)
  {
    try
    {
      if (new File(paramString).exists())
      {
        Logger.v("Utils", paramString + "--------->file have exist");
        return true;
      }
      Logger.v("Utils", paramString + "---------->file not exists");
      return false;
    }
    catch (Exception paramString)
    {
      Logger.v("Utils", "--------->fileIsExists exception");
      paramString.printStackTrace();
    }
    return false;
  }
  
  /* Error */
  public static String getAssetsFiles(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 28	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   10: aload_0
    //   11: invokevirtual 62	android/content/Context:getFilesDir	()Ljava/io/File;
    //   14: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   17: ldc 67
    //   19: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: astore 5
    //   31: aload 5
    //   33: invokestatic 69	com/tencent/jalpha/common/Utils:fileIsExists	(Ljava/lang/String;)Z
    //   36: ifne +98 -> 134
    //   39: aload_0
    //   40: invokevirtual 73	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   43: astore_3
    //   44: aload_3
    //   45: aload_1
    //   46: invokevirtual 79	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   49: astore_3
    //   50: aload_3
    //   51: invokevirtual 85	java/io/InputStream:available	()I
    //   54: istore_2
    //   55: ldc 8
    //   57: new 28	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   64: ldc 87
    //   66: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: iload_2
    //   70: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   73: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 45	com/tencent/jalpha/common/Logger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: iload_2
    //   80: newarray byte
    //   82: astore 7
    //   84: aload_3
    //   85: aload 7
    //   87: invokevirtual 94	java/io/InputStream:read	([B)I
    //   90: pop
    //   91: aload_0
    //   92: aload_1
    //   93: iconst_0
    //   94: invokevirtual 98	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   97: astore_0
    //   98: aload_0
    //   99: astore 4
    //   101: aload_3
    //   102: astore_1
    //   103: aload_0
    //   104: aload 7
    //   106: invokevirtual 104	java/io/FileOutputStream:write	([B)V
    //   109: aload_0
    //   110: astore 4
    //   112: aload_3
    //   113: astore_1
    //   114: aload_0
    //   115: invokevirtual 107	java/io/FileOutputStream:flush	()V
    //   118: aload_3
    //   119: ifnull +7 -> 126
    //   122: aload_3
    //   123: invokevirtual 110	java/io/InputStream:close	()V
    //   126: aload_0
    //   127: ifnull +7 -> 134
    //   130: aload_0
    //   131: invokevirtual 111	java/io/FileOutputStream:close	()V
    //   134: aload 5
    //   136: astore_1
    //   137: aload_1
    //   138: areturn
    //   139: astore 5
    //   141: aconst_null
    //   142: astore_0
    //   143: aconst_null
    //   144: astore_3
    //   145: aload_0
    //   146: astore 4
    //   148: aload_3
    //   149: astore_1
    //   150: aload 5
    //   152: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   155: aload_3
    //   156: ifnull +7 -> 163
    //   159: aload_3
    //   160: invokevirtual 110	java/io/InputStream:close	()V
    //   163: aload 6
    //   165: astore_1
    //   166: aload_0
    //   167: ifnull -30 -> 137
    //   170: aload_0
    //   171: invokevirtual 111	java/io/FileOutputStream:close	()V
    //   174: aconst_null
    //   175: areturn
    //   176: astore_0
    //   177: aconst_null
    //   178: areturn
    //   179: astore_0
    //   180: aconst_null
    //   181: astore 4
    //   183: aconst_null
    //   184: astore_1
    //   185: aload_1
    //   186: ifnull +7 -> 193
    //   189: aload_1
    //   190: invokevirtual 110	java/io/InputStream:close	()V
    //   193: aload 4
    //   195: ifnull +8 -> 203
    //   198: aload 4
    //   200: invokevirtual 111	java/io/FileOutputStream:close	()V
    //   203: aload_0
    //   204: athrow
    //   205: astore_1
    //   206: goto -3 -> 203
    //   209: astore_0
    //   210: aconst_null
    //   211: astore 4
    //   213: aload_3
    //   214: astore_1
    //   215: goto -30 -> 185
    //   218: astore_0
    //   219: goto -34 -> 185
    //   222: astore 5
    //   224: aconst_null
    //   225: astore_0
    //   226: goto -81 -> 145
    //   229: astore 5
    //   231: goto -86 -> 145
    //   234: astore_0
    //   235: goto -101 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	paramContext	android.content.Context
    //   0	238	1	paramString	String
    //   54	26	2	i	int
    //   43	171	3	localObject1	Object
    //   99	113	4	localContext	android.content.Context
    //   29	106	5	str	String
    //   139	12	5	localIOException1	java.io.IOException
    //   222	1	5	localIOException2	java.io.IOException
    //   229	1	5	localIOException3	java.io.IOException
    //   1	163	6	localObject2	Object
    //   82	23	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   44	50	139	java/io/IOException
    //   159	163	176	java/io/IOException
    //   170	174	176	java/io/IOException
    //   44	50	179	finally
    //   189	193	205	java/io/IOException
    //   198	203	205	java/io/IOException
    //   50	98	209	finally
    //   103	109	218	finally
    //   114	118	218	finally
    //   150	155	218	finally
    //   50	98	222	java/io/IOException
    //   103	109	229	java/io/IOException
    //   114	118	229	java/io/IOException
    //   122	126	234	java/io/IOException
    //   130	134	234	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.jalpha.common.Utils
 * JD-Core Version:    0.7.0.1
 */