package com.tencent.biz.pubaccount.readinjoyAd.ad.proteus;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.mobileqq.utils.CommonImageCacheHelper;

class AdLiveExpandCardProteusItem$4
  implements Runnable
{
  AdLiveExpandCardProteusItem$4(AdLiveExpandCardProteusItem paramAdLiveExpandCardProteusItem, Bitmap paramBitmap, int paramInt1, int paramInt2, float paramFloat, int paramInt3, String paramString) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = BitmapRegionDecoder.newInstance(AdLiveExpandCardProteusItem.a(this.this$0, this.a), false);
        i = this.b;
        int k = 1;
        if (i != 0) {
          break label210;
        }
        i = 1;
        int j;
        if (i != 0) {
          j = (int)(this.c * this.d);
        } else {
          j = this.c;
        }
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handleBitmap  top :");
        ((StringBuilder)localObject2).append(this.b);
        ((StringBuilder)localObject2).append(":::bottom:");
        ((StringBuilder)localObject2).append(j);
        ReadInJoyAdLog.a("AdLiveExpandCardProteusItem", ((StringBuilder)localObject2).toString());
        localObject2 = new Rect(0, this.b, this.e, j);
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
        localObject1 = ((BitmapRegionDecoder)localObject1).decodeRegion((Rect)localObject2, localOptions);
        if (localObject1 != null)
        {
          CommonImageCacheHelper.a(this.f, (Bitmap)localObject1);
          j = k;
          if (i != 0) {
            j = 2;
          }
          AdLiveExpandCardProteusItem.c(this.this$0).removeMessages(j);
          AdLiveExpandCardProteusItem.c(this.this$0).sendEmptyMessage(j);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return;
      label210:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdLiveExpandCardProteusItem.4
 * JD-Core Version:    0.7.0.1
 */