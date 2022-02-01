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
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("--------->file have exist");
        Logger.v("Utils", localStringBuilder.toString());
        return true;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("---------->file not exists");
      Logger.v("Utils", localStringBuilder.toString());
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
    //   0: new 28	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: aload_0
    //   10: invokevirtual 62	android/content/Context:getFilesDir	()Ljava/io/File;
    //   13: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload_3
    //   18: ldc 67
    //   20: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload_3
    //   25: aload_1
    //   26: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_3
    //   31: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: astore 5
    //   36: aload 5
    //   38: invokestatic 69	com/tencent/jalpha/common/Utils:fileIsExists	(Ljava/lang/String;)Z
    //   41: ifne +200 -> 241
    //   44: aload_0
    //   45: invokevirtual 73	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   48: astore_3
    //   49: aconst_null
    //   50: astore 4
    //   52: aload_3
    //   53: aload_1
    //   54: invokevirtual 79	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   57: astore_3
    //   58: aload_3
    //   59: invokevirtual 85	java/io/InputStream:available	()I
    //   62: istore_2
    //   63: new 28	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   70: astore 6
    //   72: aload 6
    //   74: ldc 87
    //   76: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload 6
    //   82: iload_2
    //   83: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: ldc 8
    //   89: aload 6
    //   91: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokestatic 45	com/tencent/jalpha/common/Logger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: iload_2
    //   98: newarray byte
    //   100: astore 6
    //   102: aload_3
    //   103: aload 6
    //   105: invokevirtual 94	java/io/InputStream:read	([B)I
    //   108: pop
    //   109: aload_0
    //   110: aload_1
    //   111: iconst_0
    //   112: invokevirtual 98	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   115: astore_0
    //   116: aload_3
    //   117: astore_1
    //   118: aload_0
    //   119: astore 4
    //   121: aload_0
    //   122: aload 6
    //   124: invokevirtual 104	java/io/FileOutputStream:write	([B)V
    //   127: aload_3
    //   128: astore_1
    //   129: aload_0
    //   130: astore 4
    //   132: aload_0
    //   133: invokevirtual 107	java/io/FileOutputStream:flush	()V
    //   136: aload_3
    //   137: ifnull +7 -> 144
    //   140: aload_3
    //   141: invokevirtual 110	java/io/InputStream:close	()V
    //   144: aload_0
    //   145: ifnull +96 -> 241
    //   148: aload_0
    //   149: invokevirtual 111	java/io/FileOutputStream:close	()V
    //   152: aload 5
    //   154: areturn
    //   155: astore 5
    //   157: goto +34 -> 191
    //   160: astore_0
    //   161: aload_3
    //   162: astore_1
    //   163: aload 4
    //   165: astore_3
    //   166: goto +57 -> 223
    //   169: astore 5
    //   171: aconst_null
    //   172: astore_0
    //   173: goto +18 -> 191
    //   176: astore_0
    //   177: aconst_null
    //   178: astore_1
    //   179: aload 4
    //   181: astore_3
    //   182: goto +41 -> 223
    //   185: astore 5
    //   187: aconst_null
    //   188: astore_0
    //   189: aload_0
    //   190: astore_3
    //   191: aload_3
    //   192: astore_1
    //   193: aload_0
    //   194: astore 4
    //   196: aload 5
    //   198: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   201: aload_3
    //   202: ifnull +7 -> 209
    //   205: aload_3
    //   206: invokevirtual 110	java/io/InputStream:close	()V
    //   209: aload_0
    //   210: ifnull +7 -> 217
    //   213: aload_0
    //   214: invokevirtual 111	java/io/FileOutputStream:close	()V
    //   217: aconst_null
    //   218: areturn
    //   219: astore_0
    //   220: aload 4
    //   222: astore_3
    //   223: aload_1
    //   224: ifnull +7 -> 231
    //   227: aload_1
    //   228: invokevirtual 110	java/io/InputStream:close	()V
    //   231: aload_3
    //   232: ifnull +7 -> 239
    //   235: aload_3
    //   236: invokevirtual 111	java/io/FileOutputStream:close	()V
    //   239: aload_0
    //   240: athrow
    //   241: aload 5
    //   243: areturn
    //   244: astore_0
    //   245: aload 5
    //   247: areturn
    //   248: astore_0
    //   249: aconst_null
    //   250: areturn
    //   251: astore_1
    //   252: goto -13 -> 239
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	255	0	paramContext	android.content.Context
    //   0	255	1	paramString	String
    //   62	36	2	i	int
    //   7	229	3	localObject1	Object
    //   50	171	4	localContext	android.content.Context
    //   34	119	5	str	String
    //   155	1	5	localIOException1	java.io.IOException
    //   169	1	5	localIOException2	java.io.IOException
    //   185	61	5	localIOException3	java.io.IOException
    //   70	53	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   121	127	155	java/io/IOException
    //   132	136	155	java/io/IOException
    //   58	116	160	finally
    //   58	116	169	java/io/IOException
    //   52	58	176	finally
    //   52	58	185	java/io/IOException
    //   121	127	219	finally
    //   132	136	219	finally
    //   196	201	219	finally
    //   140	144	244	java/io/IOException
    //   148	152	244	java/io/IOException
    //   205	209	248	java/io/IOException
    //   213	217	248	java/io/IOException
    //   227	231	251	java/io/IOException
    //   235	239	251	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.jalpha.common.Utils
 * JD-Core Version:    0.7.0.1
 */