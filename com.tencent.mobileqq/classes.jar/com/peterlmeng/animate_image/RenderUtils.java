package com.peterlmeng.animate_image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.peterlmeng.animate_image.support.log.LogUtils;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;

public class RenderUtils
{
  public static final int PLAY_STATUS_PAUSED = 2;
  public static final int PLAY_STATUS_REPLAY = 3;
  public static final int PLAY_STATUS_STARTED = 1;
  public static final int PLAY_STATUS_STOPPED = 4;
  private static final String TAG = "RenderUtils";
  
  /* Error */
  public static File assetTOLocalFile(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_1
    //   2: ldc 30
    //   4: invokevirtual 36	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   7: invokevirtual 40	java/lang/String:substring	(I)Ljava/lang/String;
    //   10: astore 4
    //   12: aload_0
    //   13: invokevirtual 46	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   16: astore_3
    //   17: new 48	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   24: astore 5
    //   26: aload 5
    //   28: ldc 51
    //   30: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload 5
    //   36: aload_2
    //   37: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload 5
    //   43: ldc 57
    //   45: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload 5
    //   51: aload_1
    //   52: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: ldc 17
    //   58: aload 5
    //   60: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 67	com/peterlmeng/animate_image/support/log/LogUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: aload_2
    //   67: invokestatic 73	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   70: ifeq +97 -> 167
    //   73: aload_1
    //   74: invokestatic 79	io/flutter/view/FlutterMain:getLookupKeyForAsset	(Ljava/lang/String;)Ljava/lang/String;
    //   77: astore_2
    //   78: new 48	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   85: astore 5
    //   87: aload 5
    //   89: ldc 81
    //   91: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload 5
    //   97: aload_2
    //   98: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: ldc 17
    //   104: aload 5
    //   106: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 67	com/peterlmeng/animate_image/support/log/LogUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: aload_0
    //   113: invokevirtual 85	android/content/Context:getCacheDir	()Ljava/io/File;
    //   116: astore_0
    //   117: new 48	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   124: astore 5
    //   126: aload 5
    //   128: aload_1
    //   129: invokestatic 88	com/peterlmeng/animate_image/RenderUtils:getFileName	(Ljava/lang/String;)Ljava/lang/String;
    //   132: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload 5
    //   138: aload 4
    //   140: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: new 90	java/io/File
    //   147: dup
    //   148: aload_0
    //   149: aload 5
    //   151: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokespecial 93	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   157: astore_0
    //   158: aload_0
    //   159: invokevirtual 97	java/io/File:exists	()Z
    //   162: ifeq +14 -> 176
    //   165: aload_0
    //   166: areturn
    //   167: aload_1
    //   168: aload_2
    //   169: invokestatic 100	io/flutter/view/FlutterMain:getLookupKeyForAsset	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   172: astore_2
    //   173: goto -95 -> 78
    //   176: aload_0
    //   177: invokevirtual 103	java/io/File:getParentFile	()Ljava/io/File;
    //   180: invokevirtual 97	java/io/File:exists	()Z
    //   183: ifne +11 -> 194
    //   186: aload_0
    //   187: invokevirtual 103	java/io/File:getParentFile	()Ljava/io/File;
    //   190: invokevirtual 106	java/io/File:mkdirs	()Z
    //   193: pop
    //   194: aload_3
    //   195: aload_2
    //   196: iconst_3
    //   197: invokevirtual 112	android/content/res/AssetManager:open	(Ljava/lang/String;I)Ljava/io/InputStream;
    //   200: astore_2
    //   201: new 48	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   208: astore_3
    //   209: aload_3
    //   210: ldc 114
    //   212: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload_3
    //   217: aload_0
    //   218: invokevirtual 117	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   221: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload_3
    //   226: ldc 119
    //   228: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload_3
    //   233: aload_1
    //   234: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: ldc 17
    //   240: aload_3
    //   241: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokestatic 67	com/peterlmeng/animate_image/support/log/LogUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   247: new 121	java/io/FileOutputStream
    //   250: dup
    //   251: aload_0
    //   252: invokespecial 124	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   255: astore_1
    //   256: aload_2
    //   257: aload_1
    //   258: invokestatic 130	com/peterlmeng/animate_image/ByteStreams:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   261: pop2
    //   262: new 48	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   269: astore_3
    //   270: aload_3
    //   271: ldc 132
    //   273: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload_3
    //   278: aload_0
    //   279: invokevirtual 117	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   282: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: ldc 17
    //   288: aload_3
    //   289: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokestatic 67	com/peterlmeng/animate_image/support/log/LogUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   295: aload_1
    //   296: invokevirtual 135	java/io/FileOutputStream:close	()V
    //   299: aload_2
    //   300: invokevirtual 138	java/io/InputStream:close	()V
    //   303: aload_0
    //   304: areturn
    //   305: astore_3
    //   306: ldc 17
    //   308: aload_3
    //   309: invokevirtual 141	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   312: invokestatic 144	com/peterlmeng/animate_image/support/log/LogUtils:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   315: aload_0
    //   316: invokevirtual 147	java/io/File:delete	()Z
    //   319: pop
    //   320: aload_1
    //   321: invokevirtual 135	java/io/FileOutputStream:close	()V
    //   324: goto -25 -> 299
    //   327: astore_1
    //   328: aload_1
    //   329: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   332: ldc 17
    //   334: aload_1
    //   335: invokevirtual 151	java/io/IOException:getMessage	()Ljava/lang/String;
    //   338: invokestatic 144	com/peterlmeng/animate_image/support/log/LogUtils:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   341: goto -38 -> 303
    //   344: astore_3
    //   345: aload_1
    //   346: invokevirtual 135	java/io/FileOutputStream:close	()V
    //   349: aload_2
    //   350: invokevirtual 138	java/io/InputStream:close	()V
    //   353: aload_3
    //   354: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	355	0	paramContext	Context
    //   0	355	1	paramString1	String
    //   0	355	2	paramString2	String
    //   16	273	3	localObject1	Object
    //   305	4	3	localException	java.lang.Exception
    //   344	10	3	localObject2	Object
    //   10	129	4	str	String
    //   24	126	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   256	295	305	java/lang/Exception
    //   194	256	327	java/io/IOException
    //   295	299	327	java/io/IOException
    //   299	303	327	java/io/IOException
    //   320	324	327	java/io/IOException
    //   345	355	327	java/io/IOException
    //   256	295	344	finally
    //   306	320	344	finally
  }
  
  /* Error */
  public static File assetToLocalFileqq(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_1
    //   2: ldc 30
    //   4: invokevirtual 36	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   7: invokevirtual 40	java/lang/String:substring	(I)Ljava/lang/String;
    //   10: astore 6
    //   12: aload_0
    //   13: invokevirtual 163	android/content/Context:getFilesDir	()Ljava/io/File;
    //   16: astore 7
    //   18: new 90	java/io/File
    //   21: dup
    //   22: aload 7
    //   24: ldc 165
    //   26: invokespecial 93	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   29: astore 5
    //   31: aload_0
    //   32: invokevirtual 46	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   35: astore_3
    //   36: ldc 108
    //   38: invokevirtual 171	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   41: checkcast 108	android/content/res/AssetManager
    //   44: astore_0
    //   45: ldc 108
    //   47: ldc 173
    //   49: iconst_1
    //   50: anewarray 167	java/lang/Class
    //   53: dup
    //   54: iconst_0
    //   55: ldc 32
    //   57: aastore
    //   58: invokevirtual 177	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   61: aload_0
    //   62: iconst_1
    //   63: anewarray 4	java/lang/Object
    //   66: dup
    //   67: iconst_0
    //   68: aload 5
    //   70: invokevirtual 117	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   73: aastore
    //   74: invokevirtual 183	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   77: pop
    //   78: aload_2
    //   79: invokestatic 73	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   82: ifeq +232 -> 314
    //   85: aload_1
    //   86: invokestatic 79	io/flutter/view/FlutterMain:getLookupKeyForAsset	(Ljava/lang/String;)Ljava/lang/String;
    //   89: astore_3
    //   90: new 90	java/io/File
    //   93: dup
    //   94: aload 7
    //   96: ldc 185
    //   98: invokespecial 93	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   101: astore 4
    //   103: aload 4
    //   105: invokevirtual 97	java/io/File:exists	()Z
    //   108: ifne +9 -> 117
    //   111: aload 4
    //   113: invokevirtual 106	java/io/File:mkdirs	()Z
    //   116: pop
    //   117: new 48	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   124: astore 7
    //   126: new 48	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   133: astore 8
    //   135: aload 8
    //   137: aload_2
    //   138: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload 8
    //   144: aload_1
    //   145: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload 7
    //   151: aload 8
    //   153: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 88	com/peterlmeng/animate_image/RenderUtils:getFileName	(Ljava/lang/String;)Ljava/lang/String;
    //   159: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload 7
    //   165: aload 6
    //   167: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: new 90	java/io/File
    //   174: dup
    //   175: aload 4
    //   177: aload 7
    //   179: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokespecial 93	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   185: astore_2
    //   186: new 48	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   193: astore 4
    //   195: aload 4
    //   197: ldc 187
    //   199: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload 4
    //   205: aload_3
    //   206: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload 4
    //   212: ldc 189
    //   214: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload 4
    //   220: aload 5
    //   222: invokevirtual 117	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   225: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: aload 4
    //   231: ldc 191
    //   233: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: aload 4
    //   239: aload_2
    //   240: invokevirtual 117	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   243: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: ldc 17
    //   249: aload 4
    //   251: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 67	com/peterlmeng/animate_image/support/log/LogUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: aload_2
    //   258: invokevirtual 97	java/io/File:exists	()Z
    //   261: ifeq +62 -> 323
    //   264: aload_2
    //   265: areturn
    //   266: astore_3
    //   267: aload_3
    //   268: astore 4
    //   270: aload 4
    //   272: invokevirtual 192	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   275: goto -197 -> 78
    //   278: astore_3
    //   279: aload_3
    //   280: astore 4
    //   282: aload 4
    //   284: invokevirtual 193	java/lang/NoSuchMethodException:printStackTrace	()V
    //   287: goto -209 -> 78
    //   290: astore_3
    //   291: aload_3
    //   292: astore 4
    //   294: aload 4
    //   296: invokevirtual 194	java/lang/InstantiationException:printStackTrace	()V
    //   299: goto -221 -> 78
    //   302: astore_3
    //   303: aload_3
    //   304: astore 4
    //   306: aload 4
    //   308: invokevirtual 195	java/lang/IllegalAccessException:printStackTrace	()V
    //   311: goto -233 -> 78
    //   314: aload_1
    //   315: aload_2
    //   316: invokestatic 100	io/flutter/view/FlutterMain:getLookupKeyForAsset	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   319: astore_3
    //   320: goto -230 -> 90
    //   323: aload_2
    //   324: invokevirtual 103	java/io/File:getParentFile	()Ljava/io/File;
    //   327: invokevirtual 97	java/io/File:exists	()Z
    //   330: ifne +11 -> 341
    //   333: aload_2
    //   334: invokevirtual 103	java/io/File:getParentFile	()Ljava/io/File;
    //   337: invokevirtual 106	java/io/File:mkdirs	()Z
    //   340: pop
    //   341: aload_0
    //   342: aload_3
    //   343: iconst_3
    //   344: invokevirtual 112	android/content/res/AssetManager:open	(Ljava/lang/String;I)Ljava/io/InputStream;
    //   347: astore_0
    //   348: new 48	java/lang/StringBuilder
    //   351: dup
    //   352: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   355: astore_3
    //   356: aload_3
    //   357: ldc 114
    //   359: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: pop
    //   363: aload_3
    //   364: aload_2
    //   365: invokevirtual 117	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   368: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: aload_3
    //   373: ldc 119
    //   375: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: aload_3
    //   380: aload_1
    //   381: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: ldc 17
    //   387: aload_3
    //   388: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokestatic 67	com/peterlmeng/animate_image/support/log/LogUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   394: new 121	java/io/FileOutputStream
    //   397: dup
    //   398: aload_2
    //   399: invokespecial 124	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   402: astore_1
    //   403: aload_0
    //   404: aload_1
    //   405: invokestatic 130	com/peterlmeng/animate_image/ByteStreams:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   408: pop2
    //   409: new 48	java/lang/StringBuilder
    //   412: dup
    //   413: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   416: astore_3
    //   417: aload_3
    //   418: ldc 132
    //   420: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: pop
    //   424: aload_3
    //   425: aload_2
    //   426: invokevirtual 117	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   429: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: pop
    //   433: ldc 17
    //   435: aload_3
    //   436: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   439: invokestatic 67	com/peterlmeng/animate_image/support/log/LogUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   442: aload_1
    //   443: invokevirtual 135	java/io/FileOutputStream:close	()V
    //   446: aload_0
    //   447: invokevirtual 138	java/io/InputStream:close	()V
    //   450: aload_2
    //   451: areturn
    //   452: astore_3
    //   453: ldc 17
    //   455: aload_3
    //   456: invokevirtual 141	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   459: invokestatic 144	com/peterlmeng/animate_image/support/log/LogUtils:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   462: aload_2
    //   463: invokevirtual 147	java/io/File:delete	()Z
    //   466: pop
    //   467: aload_1
    //   468: invokevirtual 135	java/io/FileOutputStream:close	()V
    //   471: goto -25 -> 446
    //   474: astore_0
    //   475: aload_0
    //   476: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   479: ldc 17
    //   481: aload_0
    //   482: invokevirtual 151	java/io/IOException:getMessage	()Ljava/lang/String;
    //   485: invokestatic 144	com/peterlmeng/animate_image/support/log/LogUtils:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   488: goto -38 -> 450
    //   491: astore_3
    //   492: aload_1
    //   493: invokevirtual 135	java/io/FileOutputStream:close	()V
    //   496: aload_0
    //   497: invokevirtual 138	java/io/InputStream:close	()V
    //   500: aload_3
    //   501: athrow
    //   502: astore 4
    //   504: aload_3
    //   505: astore_0
    //   506: goto -200 -> 306
    //   509: astore 4
    //   511: aload_3
    //   512: astore_0
    //   513: goto -219 -> 294
    //   516: astore 4
    //   518: aload_3
    //   519: astore_0
    //   520: goto -238 -> 282
    //   523: astore 4
    //   525: aload_3
    //   526: astore_0
    //   527: goto -257 -> 270
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	530	0	paramContext	Context
    //   0	530	1	paramString1	String
    //   0	530	2	paramString2	String
    //   35	171	3	localObject1	Object
    //   266	2	3	localInvocationTargetException1	java.lang.reflect.InvocationTargetException
    //   278	2	3	localNoSuchMethodException1	java.lang.NoSuchMethodException
    //   290	2	3	localInstantiationException1	java.lang.InstantiationException
    //   302	2	3	localIllegalAccessException1	java.lang.IllegalAccessException
    //   319	117	3	localObject2	Object
    //   452	4	3	localException	java.lang.Exception
    //   491	35	3	localObject3	Object
    //   101	206	4	localObject4	Object
    //   502	1	4	localIllegalAccessException2	java.lang.IllegalAccessException
    //   509	1	4	localInstantiationException2	java.lang.InstantiationException
    //   516	1	4	localNoSuchMethodException2	java.lang.NoSuchMethodException
    //   523	1	4	localInvocationTargetException2	java.lang.reflect.InvocationTargetException
    //   29	192	5	localFile	File
    //   10	156	6	str	String
    //   16	162	7	localObject5	Object
    //   133	19	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   45	78	266	java/lang/reflect/InvocationTargetException
    //   45	78	278	java/lang/NoSuchMethodException
    //   45	78	290	java/lang/InstantiationException
    //   45	78	302	java/lang/IllegalAccessException
    //   403	442	452	java/lang/Exception
    //   341	403	474	java/io/IOException
    //   442	446	474	java/io/IOException
    //   446	450	474	java/io/IOException
    //   467	471	474	java/io/IOException
    //   492	502	474	java/io/IOException
    //   403	442	491	finally
    //   453	467	491	finally
    //   36	45	502	java/lang/IllegalAccessException
    //   36	45	509	java/lang/InstantiationException
    //   36	45	516	java/lang/NoSuchMethodException
    //   36	45	523	java/lang/reflect/InvocationTargetException
  }
  
  public static Bitmap getBitmapFromPath(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramString1.startsWith("http")) || (paramString1.startsWith("https"))) {
      return getBitmapFromURL(paramString1);
    }
    if ((paramString2 == null) || ("".equals(paramString2))) {}
    for (paramContext = localPathToFile(paramString1); paramContext == null; paramContext = assetToLocalFileqq(paramContext, paramString1, paramString2))
    {
      String.format(Locale.getDefault(), "getBitmapFromPath(path=%s, packagePath=%s) error!", new Object[] { paramString1, paramString2 });
      return null;
    }
    return BitmapFactory.decodeFile(paramContext.getPath());
  }
  
  public static Bitmap getBitmapFromURL(String paramString)
  {
    try
    {
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      paramString.setDoInput(true);
      paramString.connect();
      paramString = BitmapFactory.decodeStream(paramString.getInputStream());
      return paramString;
    }
    catch (IOException paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getBitmapFromURL error:");
      localStringBuilder.append(paramString.getMessage());
      LogUtils.b("RenderUtils", localStringBuilder.toString());
    }
    return null;
  }
  
  public static String getFileName(String paramString)
  {
    return paramString.substring(paramString.lastIndexOf("/") + 1, paramString.lastIndexOf("."));
  }
  
  public static Size getScaledImgSize(Size paramSize1, Size paramSize2)
  {
    Size localSize = new Size(paramSize1.width, paramSize1.height);
    int i = paramSize1.width;
    i = paramSize1.height;
    if (paramSize2.width != 0)
    {
      i = paramSize2.height * paramSize1.width / paramSize2.width;
      if (i >= paramSize1.height) {
        break label63;
      }
      localSize.height = i;
    }
    label63:
    while (paramSize2.height == 0) {
      return localSize;
    }
    localSize.width = (paramSize2.width * paramSize1.height / paramSize2.height);
    return localSize;
  }
  
  public static File localPathToFile(String paramString)
  {
    Object localObject = new File(paramString);
    if (((File)localObject).exists())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" exist");
      LogUtils.a("RenderUtils", localStringBuilder.toString());
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" not exist");
    LogUtils.b("RenderUtils", ((StringBuilder)localObject).toString());
    return null;
  }
  
  public static File pathToFile(Context paramContext, String paramString1, String paramString2)
  {
    if (paramString1.startsWith("/")) {
      return localPathToFile(paramString1);
    }
    return assetToLocalFileqq(paramContext, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.peterlmeng.animate_image.RenderUtils
 * JD-Core Version:    0.7.0.1
 */