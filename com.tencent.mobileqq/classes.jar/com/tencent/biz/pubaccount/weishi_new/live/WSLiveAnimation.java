package com.tencent.biz.pubaccount.weishi_new.live;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieCompositionFactory;
import com.tencent.mobileqq.dinifly.LottieTask;

public class WSLiveAnimation
{
  private static String a = "WSLiveAnimation";
  
  /* Error */
  public static Bitmap a(DiniFlyAnimationView paramDiniFlyAnimationView)
  {
    // Byte code:
    //   0: new 25	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 26	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: iconst_1
    //   10: putfield 30	android/graphics/BitmapFactory$Options:inScaled	Z
    //   13: aload_2
    //   14: sipush 320
    //   17: putfield 34	android/graphics/BitmapFactory$Options:inDensity	I
    //   20: aload_2
    //   21: bipush 126
    //   23: putfield 37	android/graphics/BitmapFactory$Options:outWidth	I
    //   26: aload_2
    //   27: bipush 126
    //   29: putfield 40	android/graphics/BitmapFactory$Options:outHeight	I
    //   32: aload_0
    //   33: invokevirtual 46	com/tencent/mobileqq/dinifly/DiniFlyAnimationView:getResources	()Landroid/content/res/Resources;
    //   36: invokevirtual 52	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   39: ldc 54
    //   41: invokevirtual 60	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   44: astore_1
    //   45: aload_1
    //   46: aconst_null
    //   47: aload_2
    //   48: invokestatic 66	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   51: astore_2
    //   52: aload_1
    //   53: invokevirtual 71	java/io/InputStream:close	()V
    //   56: aload_0
    //   57: invokevirtual 75	com/tencent/mobileqq/dinifly/DiniFlyAnimationView:getLottieDrawable	()Lcom/tencent/mobileqq/dinifly/LottieDrawable;
    //   60: ldc 77
    //   62: aload_2
    //   63: invokevirtual 83	com/tencent/mobileqq/dinifly/LottieDrawable:updateBitmap	(Ljava/lang/String;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   66: pop
    //   67: aload_2
    //   68: areturn
    //   69: astore_0
    //   70: getstatic 12	com/tencent/biz/pubaccount/weishi_new/live/WSLiveAnimation:a	Ljava/lang/String;
    //   73: ldc 85
    //   75: invokestatic 91	com/tencent/biz/pubaccount/weishi_new/util/WSLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: aconst_null
    //   79: areturn
    //   80: astore_1
    //   81: getstatic 12	com/tencent/biz/pubaccount/weishi_new/live/WSLiveAnimation:a	Ljava/lang/String;
    //   84: ldc 93
    //   86: invokestatic 91	com/tencent/biz/pubaccount/weishi_new/util/WSLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: aload_1
    //   90: invokevirtual 96	java/io/IOException:printStackTrace	()V
    //   93: goto -37 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	paramDiniFlyAnimationView	DiniFlyAnimationView
    //   44	9	1	localInputStream	java.io.InputStream
    //   80	10	1	localIOException	java.io.IOException
    //   7	61	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   32	45	69	java/io/IOException
    //   52	56	80	java/io/IOException
  }
  
  public static void a(DiniFlyAnimationView paramDiniFlyAnimationView, Bitmap paramBitmap1, Bitmap paramBitmap2, WSLiveAnimationManager.WSLiveAnimationCallback paramWSLiveAnimationCallback)
  {
    LottieCompositionFactory.fromAsset(paramDiniFlyAnimationView.getContext(), "wsfollow/live/data.json").addListener(new WSLiveAnimation.2(paramDiniFlyAnimationView, paramBitmap2, paramBitmap1)).addFailureListener(new WSLiveAnimation.1(paramWSLiveAnimationCallback));
  }
  
  private static Bitmap b(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f1 = paramInt1 / i;
    float f2 = paramInt2 / j;
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(f1, f2);
    return Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
  }
  
  private static void b(LottieComposition paramLottieComposition, DiniFlyAnimationView paramDiniFlyAnimationView, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    paramDiniFlyAnimationView.setComposition(paramLottieComposition);
    paramDiniFlyAnimationView.setRepeatCount(-1);
    paramDiniFlyAnimationView.setImageAssetsFolder("wsfollow/live/images");
    paramDiniFlyAnimationView.setImageAssetDelegate(new WSLiveAnimation.3(paramBitmap1, paramBitmap2));
    paramDiniFlyAnimationView.playAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.live.WSLiveAnimation
 * JD-Core Version:    0.7.0.1
 */