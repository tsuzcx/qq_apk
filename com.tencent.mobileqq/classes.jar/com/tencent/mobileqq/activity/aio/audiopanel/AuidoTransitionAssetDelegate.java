package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;

public class AuidoTransitionAssetDelegate
  implements ImageAssetDelegate
{
  String a;
  private Context b;
  
  public AuidoTransitionAssetDelegate(Context paramContext, String paramString)
  {
    this.b = paramContext;
    paramContext = new StringBuilder();
    paramContext.append(AudioTransitionAnimManager.b);
    paramContext.append(paramString);
    paramContext.append("images/");
    this.a = paramContext.toString();
  }
  
  /* Error */
  @android.support.annotation.Nullable
  public android.graphics.Bitmap fetchBitmap(com.tencent.mobileqq.dinifly.LottieImageAsset paramLottieImageAsset)
  {
    // Byte code:
    //   0: new 19	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_0
    //   10: getfield 36	com/tencent/mobileqq/activity/aio/audiopanel/AuidoTransitionAssetDelegate:a	Ljava/lang/String;
    //   13: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload_2
    //   18: aload_1
    //   19: invokevirtual 47	com/tencent/mobileqq/dinifly/LottieImageAsset:getFileName	()Ljava/lang/String;
    //   22: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: new 49	java/io/FileInputStream
    //   29: dup
    //   30: aload_2
    //   31: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokespecial 52	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   37: astore_2
    //   38: aload_2
    //   39: astore_1
    //   40: new 54	android/graphics/BitmapFactory$Options
    //   43: dup
    //   44: invokespecial 55	android/graphics/BitmapFactory$Options:<init>	()V
    //   47: astore_3
    //   48: aload_2
    //   49: astore_1
    //   50: aload_3
    //   51: iconst_0
    //   52: putfield 59	android/graphics/BitmapFactory$Options:inScaled	Z
    //   55: aload_2
    //   56: astore_1
    //   57: aload_2
    //   58: aconst_null
    //   59: checkcast 61	android/graphics/Rect
    //   62: aload_3
    //   63: invokestatic 67	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   66: astore_3
    //   67: aload_2
    //   68: invokevirtual 72	java/io/InputStream:close	()V
    //   71: aload_3
    //   72: areturn
    //   73: astore_1
    //   74: new 19	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   81: astore_2
    //   82: aload_2
    //   83: ldc 74
    //   85: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload_2
    //   90: aload_1
    //   91: invokevirtual 77	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   94: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: ldc 79
    //   100: iconst_2
    //   101: aload_2
    //   102: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 85	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   108: aload_3
    //   109: areturn
    //   110: astore_3
    //   111: goto +12 -> 123
    //   114: astore_2
    //   115: aconst_null
    //   116: astore_1
    //   117: goto +100 -> 217
    //   120: astore_3
    //   121: aconst_null
    //   122: astore_2
    //   123: aload_2
    //   124: astore_1
    //   125: new 19	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   132: astore 4
    //   134: aload_2
    //   135: astore_1
    //   136: aload 4
    //   138: ldc 87
    //   140: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload_2
    //   145: astore_1
    //   146: aload 4
    //   148: aload_3
    //   149: invokevirtual 77	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   152: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload_2
    //   157: astore_1
    //   158: ldc 79
    //   160: iconst_2
    //   161: aload 4
    //   163: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 85	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   169: aload_2
    //   170: ifnull +44 -> 214
    //   173: aload_2
    //   174: invokevirtual 72	java/io/InputStream:close	()V
    //   177: aconst_null
    //   178: areturn
    //   179: astore_1
    //   180: new 19	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   187: astore_2
    //   188: aload_2
    //   189: ldc 74
    //   191: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload_2
    //   196: aload_1
    //   197: invokevirtual 77	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   200: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: ldc 79
    //   206: iconst_2
    //   207: aload_2
    //   208: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokestatic 85	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: aconst_null
    //   215: areturn
    //   216: astore_2
    //   217: aload_1
    //   218: ifnull +45 -> 263
    //   221: aload_1
    //   222: invokevirtual 72	java/io/InputStream:close	()V
    //   225: goto +38 -> 263
    //   228: astore_1
    //   229: new 19	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   236: astore_3
    //   237: aload_3
    //   238: ldc 74
    //   240: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload_3
    //   245: aload_1
    //   246: invokevirtual 77	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   249: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: ldc 79
    //   255: iconst_2
    //   256: aload_3
    //   257: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 85	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   263: aload_2
    //   264: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	this	AuidoTransitionAssetDelegate
    //   0	265	1	paramLottieImageAsset	com.tencent.mobileqq.dinifly.LottieImageAsset
    //   7	95	2	localObject1	Object
    //   114	1	2	localObject2	Object
    //   122	86	2	localStringBuilder1	StringBuilder
    //   216	48	2	localObject3	Object
    //   47	62	3	localObject4	Object
    //   110	1	3	localThrowable1	java.lang.Throwable
    //   120	29	3	localThrowable2	java.lang.Throwable
    //   236	21	3	localStringBuilder2	StringBuilder
    //   132	30	4	localStringBuilder3	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   67	71	73	java/lang/Throwable
    //   40	48	110	java/lang/Throwable
    //   50	55	110	java/lang/Throwable
    //   57	67	110	java/lang/Throwable
    //   0	38	114	finally
    //   0	38	120	java/lang/Throwable
    //   173	177	179	java/lang/Throwable
    //   40	48	216	finally
    //   50	55	216	finally
    //   57	67	216	finally
    //   125	134	216	finally
    //   136	144	216	finally
    //   146	156	216	finally
    //   158	169	216	finally
    //   221	225	228	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AuidoTransitionAssetDelegate
 * JD-Core Version:    0.7.0.1
 */