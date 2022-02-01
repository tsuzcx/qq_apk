package com.tencent.biz.pubaccount.readinjoy.drawable;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.support.v4.util.LruCache;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ReadInJoyLottieDrawable$3$1
  implements ImageAssetDelegate
{
  ReadInJoyLottieDrawable$3$1(ReadInJoyLottieDrawable.3 param3) {}
  
  @Nullable
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    Object localObject = paramLottieImageAsset.getFileName();
    paramLottieImageAsset = ReadInJoyLottieDrawable.a(this.a.this$0, this.a.a, "images");
    if (paramLottieImageAsset != null) {}
    for (;;)
    {
      paramLottieImageAsset = paramLottieImageAsset.getAbsolutePath() + "/" + (String)localObject;
      localObject = (Bitmap)ReadInJoyLottieDrawable.b().get(paramLottieImageAsset);
      if (localObject == null) {
        break;
      }
      return localObject;
      paramLottieImageAsset = this.a.a[0];
    }
    ThreadManager.excute(new ReadInJoyLottieDrawable.3.1.1(this, paramLottieImageAsset), 64, null, true);
    try
    {
      localObject = BitmapFactory.decodeFile(paramLottieImageAsset);
      return localObject;
    }
    catch (Exception localException)
    {
      QLog.e("ReadInJoyLottieDrawable", 2, "loadLottieAnimation path: " + paramLottieImageAsset);
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("ReadInJoyLottieDrawable", 2, "loadLottieAnimation oom: " + paramLottieImageAsset);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.drawable.ReadInJoyLottieDrawable.3.1
 * JD-Core Version:    0.7.0.1
 */