package com.tencent.luggage.widget.decoder;

import android.graphics.Bitmap.Config;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;

public class SkiaImageDecoder
  implements c
{
  private final Bitmap.Config a;
  
  @Keep
  public SkiaImageDecoder()
  {
    this(null);
  }
  
  public SkiaImageDecoder(@Nullable Bitmap.Config paramConfig)
  {
    Bitmap.Config localConfig = com.tencent.luggage.widget.c.getPreferredBitmapConfig();
    if (paramConfig != null)
    {
      this.a = paramConfig;
      return;
    }
    if (localConfig != null)
    {
      this.a = localConfig;
      return;
    }
    this.a = Bitmap.Config.RGB_565;
  }
  
  /* Error */
  @androidx.annotation.NonNull
  public android.graphics.Bitmap a(android.content.Context paramContext, @androidx.annotation.NonNull android.net.Uri paramUri)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 45	android/net/Uri:toString	()Ljava/lang/String;
    //   4: astore 9
    //   6: new 47	android/graphics/BitmapFactory$Options
    //   9: dup
    //   10: invokespecial 48	android/graphics/BitmapFactory$Options:<init>	()V
    //   13: astore 8
    //   15: aload 8
    //   17: aload_0
    //   18: getfield 27	com/tencent/luggage/widget/decoder/SkiaImageDecoder:a	Landroid/graphics/Bitmap$Config;
    //   21: putfield 51	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   24: aload 9
    //   26: ldc 53
    //   28: invokevirtual 59	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   31: ifeq +160 -> 191
    //   34: aload_2
    //   35: invokevirtual 62	android/net/Uri:getAuthority	()Ljava/lang/String;
    //   38: astore 9
    //   40: aload_1
    //   41: invokevirtual 67	android/content/Context:getPackageName	()Ljava/lang/String;
    //   44: aload 9
    //   46: invokevirtual 71	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   49: ifeq +12 -> 61
    //   52: aload_1
    //   53: invokevirtual 75	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   56: astore 7
    //   58: goto +14 -> 72
    //   61: aload_1
    //   62: invokevirtual 79	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   65: aload 9
    //   67: invokevirtual 85	android/content/pm/PackageManager:getResourcesForApplication	(Ljava/lang/String;)Landroid/content/res/Resources;
    //   70: astore 7
    //   72: aload_2
    //   73: invokevirtual 89	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   76: astore_2
    //   77: aload_2
    //   78: invokeinterface 95 1 0
    //   83: istore 5
    //   85: iconst_0
    //   86: istore 4
    //   88: iload 5
    //   90: iconst_2
    //   91: if_icmpne +44 -> 135
    //   94: aload_2
    //   95: iconst_0
    //   96: invokeinterface 99 2 0
    //   101: checkcast 55	java/lang/String
    //   104: ldc 101
    //   106: invokevirtual 71	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   109: ifeq +26 -> 135
    //   112: aload 7
    //   114: aload_2
    //   115: iconst_1
    //   116: invokeinterface 99 2 0
    //   121: checkcast 55	java/lang/String
    //   124: ldc 101
    //   126: aload 9
    //   128: invokevirtual 107	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   131: istore_3
    //   132: goto +45 -> 177
    //   135: iload 4
    //   137: istore_3
    //   138: iload 5
    //   140: iconst_1
    //   141: if_icmpne +36 -> 177
    //   144: iload 4
    //   146: istore_3
    //   147: aload_2
    //   148: iconst_0
    //   149: invokeinterface 99 2 0
    //   154: checkcast 109	java/lang/CharSequence
    //   157: invokestatic 115	android/text/TextUtils:isDigitsOnly	(Ljava/lang/CharSequence;)Z
    //   160: ifeq +17 -> 177
    //   163: aload_2
    //   164: iconst_0
    //   165: invokeinterface 99 2 0
    //   170: checkcast 55	java/lang/String
    //   173: invokestatic 121	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   176: istore_3
    //   177: aload_1
    //   178: invokevirtual 75	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   181: iload_3
    //   182: aload 8
    //   184: invokestatic 127	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   187: astore_1
    //   188: goto +97 -> 285
    //   191: aload 9
    //   193: ldc 129
    //   195: invokevirtual 59	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   198: istore 6
    //   200: aconst_null
    //   201: astore 7
    //   203: iload 6
    //   205: ifeq +29 -> 234
    //   208: aload 9
    //   210: bipush 22
    //   212: invokevirtual 133	java/lang/String:substring	(I)Ljava/lang/String;
    //   215: astore_2
    //   216: aload_1
    //   217: invokevirtual 137	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   220: aload_2
    //   221: invokevirtual 143	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   224: aconst_null
    //   225: aload 8
    //   227: invokestatic 147	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   230: astore_1
    //   231: goto +54 -> 285
    //   234: aload 9
    //   236: ldc 149
    //   238: invokevirtual 59	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   241: ifeq +19 -> 260
    //   244: aload 9
    //   246: bipush 7
    //   248: invokevirtual 133	java/lang/String:substring	(I)Ljava/lang/String;
    //   251: aload 8
    //   253: invokestatic 153	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   256: astore_1
    //   257: goto +28 -> 285
    //   260: aload_1
    //   261: invokevirtual 157	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   264: aload_2
    //   265: invokevirtual 163	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   268: astore_2
    //   269: aload_2
    //   270: aconst_null
    //   271: aload 8
    //   273: invokestatic 147	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   276: astore_1
    //   277: aload_2
    //   278: ifnull +7 -> 285
    //   281: aload_2
    //   282: invokevirtual 168	java/io/InputStream:close	()V
    //   285: aload_1
    //   286: ifnull +5 -> 291
    //   289: aload_1
    //   290: areturn
    //   291: new 170	java/lang/RuntimeException
    //   294: dup
    //   295: ldc 172
    //   297: invokespecial 175	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   300: athrow
    //   301: astore_1
    //   302: goto +7 -> 309
    //   305: astore_1
    //   306: aload 7
    //   308: astore_2
    //   309: aload_2
    //   310: ifnull +7 -> 317
    //   313: aload_2
    //   314: invokevirtual 168	java/io/InputStream:close	()V
    //   317: aload_1
    //   318: athrow
    //   319: astore_2
    //   320: iload 4
    //   322: istore_3
    //   323: goto -146 -> 177
    //   326: astore_2
    //   327: goto -42 -> 285
    //   330: astore_2
    //   331: goto -14 -> 317
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	this	SkiaImageDecoder
    //   0	334	1	paramContext	android.content.Context
    //   0	334	2	paramUri	android.net.Uri
    //   131	192	3	i	int
    //   86	235	4	j	int
    //   83	59	5	k	int
    //   198	6	6	bool	boolean
    //   56	251	7	localResources	android.content.res.Resources
    //   13	259	8	localOptions	android.graphics.BitmapFactory.Options
    //   4	241	9	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   269	277	301	finally
    //   260	269	305	finally
    //   163	177	319	java/lang/NumberFormatException
    //   281	285	326	java/lang/Exception
    //   313	317	330	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.widget.decoder.SkiaImageDecoder
 * JD-Core Version:    0.7.0.1
 */