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
    //   70: ifeq +11 -> 81
    //   73: aload_1
    //   74: invokestatic 79	io/flutter/view/FlutterMain:getLookupKeyForAsset	(Ljava/lang/String;)Ljava/lang/String;
    //   77: astore_2
    //   78: goto +9 -> 87
    //   81: aload_1
    //   82: aload_2
    //   83: invokestatic 82	io/flutter/view/FlutterMain:getLookupKeyForAsset	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   86: astore_2
    //   87: new 48	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   94: astore 5
    //   96: aload 5
    //   98: ldc 84
    //   100: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload 5
    //   106: aload_2
    //   107: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: ldc 17
    //   113: aload 5
    //   115: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 67	com/peterlmeng/animate_image/support/log/LogUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   121: aload_0
    //   122: invokevirtual 88	android/content/Context:getCacheDir	()Ljava/io/File;
    //   125: astore_0
    //   126: new 48	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   133: astore 5
    //   135: aload 5
    //   137: aload_1
    //   138: invokestatic 91	com/peterlmeng/animate_image/RenderUtils:getFileName	(Ljava/lang/String;)Ljava/lang/String;
    //   141: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload 5
    //   147: aload 4
    //   149: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: new 93	java/io/File
    //   156: dup
    //   157: aload_0
    //   158: aload 5
    //   160: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokespecial 96	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   166: astore_0
    //   167: aload_0
    //   168: invokevirtual 100	java/io/File:exists	()Z
    //   171: ifeq +5 -> 176
    //   174: aload_0
    //   175: areturn
    //   176: aload_0
    //   177: invokevirtual 103	java/io/File:getParentFile	()Ljava/io/File;
    //   180: invokevirtual 100	java/io/File:exists	()Z
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
    //   299: goto +25 -> 324
    //   302: astore_3
    //   303: goto +27 -> 330
    //   306: astore_3
    //   307: ldc 17
    //   309: aload_3
    //   310: invokevirtual 138	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   313: invokestatic 141	com/peterlmeng/animate_image/support/log/LogUtils:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: aload_0
    //   317: invokevirtual 144	java/io/File:delete	()Z
    //   320: pop
    //   321: goto -26 -> 295
    //   324: aload_2
    //   325: invokevirtual 147	java/io/InputStream:close	()V
    //   328: aload_0
    //   329: areturn
    //   330: aload_1
    //   331: invokevirtual 135	java/io/FileOutputStream:close	()V
    //   334: aload_2
    //   335: invokevirtual 147	java/io/InputStream:close	()V
    //   338: aload_3
    //   339: athrow
    //   340: astore_1
    //   341: aload_1
    //   342: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   345: ldc 17
    //   347: aload_1
    //   348: invokevirtual 151	java/io/IOException:getMessage	()Ljava/lang/String;
    //   351: invokestatic 141	com/peterlmeng/animate_image/support/log/LogUtils:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   354: aload_0
    //   355: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	356	0	paramContext	Context
    //   0	356	1	paramString1	String
    //   0	356	2	paramString2	String
    //   16	273	3	localObject1	Object
    //   302	1	3	localObject2	Object
    //   306	33	3	localException	java.lang.Exception
    //   10	138	4	str	String
    //   24	135	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   256	295	302	finally
    //   307	321	302	finally
    //   256	295	306	java/lang/Exception
    //   194	256	340	java/io/IOException
    //   295	299	340	java/io/IOException
    //   324	328	340	java/io/IOException
    //   330	340	340	java/io/IOException
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
    //   18: new 93	java/io/File
    //   21: dup
    //   22: aload 7
    //   24: ldc 165
    //   26: invokespecial 96	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
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
    //   78: goto +72 -> 150
    //   81: astore_3
    //   82: goto +22 -> 104
    //   85: astore_3
    //   86: goto +32 -> 118
    //   89: astore_3
    //   90: goto +42 -> 132
    //   93: astore_3
    //   94: goto +52 -> 146
    //   97: astore 4
    //   99: aload_3
    //   100: astore_0
    //   101: aload 4
    //   103: astore_3
    //   104: aload_3
    //   105: invokevirtual 184	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   108: goto +42 -> 150
    //   111: astore 4
    //   113: aload_3
    //   114: astore_0
    //   115: aload 4
    //   117: astore_3
    //   118: aload_3
    //   119: invokevirtual 185	java/lang/NoSuchMethodException:printStackTrace	()V
    //   122: goto +28 -> 150
    //   125: astore 4
    //   127: aload_3
    //   128: astore_0
    //   129: aload 4
    //   131: astore_3
    //   132: aload_3
    //   133: invokevirtual 186	java/lang/InstantiationException:printStackTrace	()V
    //   136: goto +14 -> 150
    //   139: astore 4
    //   141: aload_3
    //   142: astore_0
    //   143: aload 4
    //   145: astore_3
    //   146: aload_3
    //   147: invokevirtual 187	java/lang/IllegalAccessException:printStackTrace	()V
    //   150: aload_2
    //   151: invokestatic 73	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   154: ifeq +11 -> 165
    //   157: aload_1
    //   158: invokestatic 79	io/flutter/view/FlutterMain:getLookupKeyForAsset	(Ljava/lang/String;)Ljava/lang/String;
    //   161: astore_3
    //   162: goto +9 -> 171
    //   165: aload_1
    //   166: aload_2
    //   167: invokestatic 82	io/flutter/view/FlutterMain:getLookupKeyForAsset	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   170: astore_3
    //   171: new 93	java/io/File
    //   174: dup
    //   175: aload 7
    //   177: ldc 189
    //   179: invokespecial 96	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   182: astore 4
    //   184: aload 4
    //   186: invokevirtual 100	java/io/File:exists	()Z
    //   189: ifne +9 -> 198
    //   192: aload 4
    //   194: invokevirtual 106	java/io/File:mkdirs	()Z
    //   197: pop
    //   198: new 48	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   205: astore 7
    //   207: new 48	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   214: astore 8
    //   216: aload 8
    //   218: aload_2
    //   219: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload 8
    //   225: aload_1
    //   226: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: aload 7
    //   232: aload 8
    //   234: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokestatic 91	com/peterlmeng/animate_image/RenderUtils:getFileName	(Ljava/lang/String;)Ljava/lang/String;
    //   240: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload 7
    //   246: aload 6
    //   248: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: new 93	java/io/File
    //   255: dup
    //   256: aload 4
    //   258: aload 7
    //   260: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: invokespecial 96	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   266: astore_2
    //   267: new 48	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   274: astore 4
    //   276: aload 4
    //   278: ldc 191
    //   280: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload 4
    //   286: aload_3
    //   287: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload 4
    //   293: ldc 193
    //   295: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload 4
    //   301: aload 5
    //   303: invokevirtual 117	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   306: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: aload 4
    //   312: ldc 195
    //   314: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: aload 4
    //   320: aload_2
    //   321: invokevirtual 117	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   324: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: ldc 17
    //   330: aload 4
    //   332: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokestatic 67	com/peterlmeng/animate_image/support/log/LogUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   338: aload_2
    //   339: invokevirtual 100	java/io/File:exists	()Z
    //   342: ifeq +5 -> 347
    //   345: aload_2
    //   346: areturn
    //   347: aload_2
    //   348: invokevirtual 103	java/io/File:getParentFile	()Ljava/io/File;
    //   351: invokevirtual 100	java/io/File:exists	()Z
    //   354: ifne +11 -> 365
    //   357: aload_2
    //   358: invokevirtual 103	java/io/File:getParentFile	()Ljava/io/File;
    //   361: invokevirtual 106	java/io/File:mkdirs	()Z
    //   364: pop
    //   365: aload_0
    //   366: aload_3
    //   367: iconst_3
    //   368: invokevirtual 112	android/content/res/AssetManager:open	(Ljava/lang/String;I)Ljava/io/InputStream;
    //   371: astore_0
    //   372: new 48	java/lang/StringBuilder
    //   375: dup
    //   376: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   379: astore_3
    //   380: aload_3
    //   381: ldc 114
    //   383: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: pop
    //   387: aload_3
    //   388: aload_2
    //   389: invokevirtual 117	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   392: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: pop
    //   396: aload_3
    //   397: ldc 119
    //   399: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: pop
    //   403: aload_3
    //   404: aload_1
    //   405: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: ldc 17
    //   411: aload_3
    //   412: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokestatic 67	com/peterlmeng/animate_image/support/log/LogUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   418: new 121	java/io/FileOutputStream
    //   421: dup
    //   422: aload_2
    //   423: invokespecial 124	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   426: astore_1
    //   427: aload_0
    //   428: aload_1
    //   429: invokestatic 130	com/peterlmeng/animate_image/ByteStreams:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   432: pop2
    //   433: new 48	java/lang/StringBuilder
    //   436: dup
    //   437: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   440: astore_3
    //   441: aload_3
    //   442: ldc 132
    //   444: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: pop
    //   448: aload_3
    //   449: aload_2
    //   450: invokevirtual 117	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   453: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: pop
    //   457: ldc 17
    //   459: aload_3
    //   460: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   463: invokestatic 67	com/peterlmeng/animate_image/support/log/LogUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   466: aload_1
    //   467: invokevirtual 135	java/io/FileOutputStream:close	()V
    //   470: goto +25 -> 495
    //   473: astore_3
    //   474: goto +27 -> 501
    //   477: astore_3
    //   478: ldc 17
    //   480: aload_3
    //   481: invokevirtual 138	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   484: invokestatic 141	com/peterlmeng/animate_image/support/log/LogUtils:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   487: aload_2
    //   488: invokevirtual 144	java/io/File:delete	()Z
    //   491: pop
    //   492: goto -26 -> 466
    //   495: aload_0
    //   496: invokevirtual 147	java/io/InputStream:close	()V
    //   499: aload_2
    //   500: areturn
    //   501: aload_1
    //   502: invokevirtual 135	java/io/FileOutputStream:close	()V
    //   505: aload_0
    //   506: invokevirtual 147	java/io/InputStream:close	()V
    //   509: aload_3
    //   510: athrow
    //   511: astore_0
    //   512: aload_0
    //   513: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   516: ldc 17
    //   518: aload_0
    //   519: invokevirtual 151	java/io/IOException:getMessage	()Ljava/lang/String;
    //   522: invokestatic 141	com/peterlmeng/animate_image/support/log/LogUtils:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   525: aload_2
    //   526: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	527	0	paramContext	Context
    //   0	527	1	paramString1	String
    //   0	527	2	paramString2	String
    //   35	1	3	localAssetManager	android.content.res.AssetManager
    //   81	1	3	localInvocationTargetException1	java.lang.reflect.InvocationTargetException
    //   85	1	3	localNoSuchMethodException1	java.lang.NoSuchMethodException
    //   89	1	3	localInstantiationException1	java.lang.InstantiationException
    //   93	7	3	localIllegalAccessException1	java.lang.IllegalAccessException
    //   103	357	3	localObject1	Object
    //   473	1	3	localObject2	Object
    //   477	33	3	localException	java.lang.Exception
    //   97	5	4	localInvocationTargetException2	java.lang.reflect.InvocationTargetException
    //   111	5	4	localNoSuchMethodException2	java.lang.NoSuchMethodException
    //   125	5	4	localInstantiationException2	java.lang.InstantiationException
    //   139	5	4	localIllegalAccessException2	java.lang.IllegalAccessException
    //   182	149	4	localObject3	Object
    //   29	273	5	localFile	File
    //   10	237	6	str	String
    //   16	243	7	localObject4	Object
    //   214	19	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   45	78	81	java/lang/reflect/InvocationTargetException
    //   45	78	85	java/lang/NoSuchMethodException
    //   45	78	89	java/lang/InstantiationException
    //   45	78	93	java/lang/IllegalAccessException
    //   36	45	97	java/lang/reflect/InvocationTargetException
    //   36	45	111	java/lang/NoSuchMethodException
    //   36	45	125	java/lang/InstantiationException
    //   36	45	139	java/lang/IllegalAccessException
    //   427	466	473	finally
    //   478	492	473	finally
    //   427	466	477	java/lang/Exception
    //   365	427	511	java/io/IOException
    //   466	470	511	java/io/IOException
    //   495	499	511	java/io/IOException
    //   501	511	511	java/io/IOException
  }
  
  public static Bitmap getBitmapFromPath(Context paramContext, String paramString1, String paramString2)
  {
    if ((!paramString1.startsWith("http")) && (!paramString1.startsWith("https")))
    {
      if ((paramString2 != null) && (!"".equals(paramString2))) {
        paramContext = assetToLocalFileqq(paramContext, paramString1, paramString2);
      } else {
        paramContext = localPathToFile(paramString1);
      }
      if (paramContext == null)
      {
        String.format(Locale.getDefault(), "getBitmapFromPath(path=%s, packagePath=%s) error!", new Object[] { paramString1, paramString2 });
        return null;
      }
      return BitmapFactory.decodeFile(paramContext.getPath());
    }
    return getBitmapFromURL(paramString1);
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
      if (i < paramSize1.height)
      {
        localSize.height = i;
        return localSize;
      }
      if (paramSize2.height != 0) {
        localSize.width = (paramSize2.width * paramSize1.height / paramSize2.height);
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.peterlmeng.animate_image.RenderUtils
 * JD-Core Version:    0.7.0.1
 */