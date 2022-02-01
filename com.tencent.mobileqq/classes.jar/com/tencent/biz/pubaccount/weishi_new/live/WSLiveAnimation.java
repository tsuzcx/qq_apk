package com.tencent.biz.pubaccount.weishi_new.live;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieCompositionFactory;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.LottieTask;
import java.io.IOException;
import java.io.InputStream;

public class WSLiveAnimation
{
  private static String a = "WSLiveAnimation";
  
  public static Bitmap a(DiniFlyAnimationView paramDiniFlyAnimationView)
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inScaled = true;
    ((BitmapFactory.Options)localObject).inDensity = 320;
    ((BitmapFactory.Options)localObject).outWidth = 126;
    ((BitmapFactory.Options)localObject).outHeight = 126;
    try
    {
      InputStream localInputStream = paramDiniFlyAnimationView.getResources().getAssets().open("wsfollow/live/images/img_0.png");
      localObject = BitmapFactory.decodeStream(localInputStream, null, (BitmapFactory.Options)localObject);
      try
      {
        localInputStream.close();
      }
      catch (IOException localIOException)
      {
        WSLog.d(a, "[getBitmapFromAsserts] decodeStream IOException");
        localIOException.printStackTrace();
      }
      paramDiniFlyAnimationView.getLottieDrawable().updateBitmap("image_0", (Bitmap)localObject);
      return localObject;
    }
    catch (IOException paramDiniFlyAnimationView)
    {
      label85:
      break label85;
    }
    WSLog.d(a, "[getBitmapFromAsserts] getAssets IOException");
    return null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.live.WSLiveAnimation
 * JD-Core Version:    0.7.0.1
 */