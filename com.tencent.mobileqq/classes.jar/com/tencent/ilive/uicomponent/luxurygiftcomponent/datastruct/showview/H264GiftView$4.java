package com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import com.tencent.falco.base.libapi.imageloader.ImageLoadingListener;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftAdapter;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.LuxuryGiftInfo;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.showview.LottieGiftInfo;

class H264GiftView$4
  implements ImageLoadingListener
{
  H264GiftView$4(H264GiftView paramH264GiftView, LuxuryGiftInfo paramLuxuryGiftInfo) {}
  
  public void onLoadingCancelled(String paramString, View paramView) {}
  
  public void onLoadingComplete(String paramString, View paramView, Bitmap paramBitmap)
  {
    if (H264GiftView.access$100(this.this$0) == null) {
      return;
    }
    H264GiftView.access$100(this.this$0).getLogger().i("H264GiftShowView|GiftAnimation", "head fetch suc url=" + paramString + "  mCur=" + H264GiftView.access$700(this.this$0).senderHeadUrl, new Object[0]);
    if ((H264GiftView.access$700(this.this$0).senderHeadUrl != null) && (!H264GiftView.access$700(this.this$0).senderHeadUrl.equalsIgnoreCase(paramString))) {
      H264GiftView.access$100(this.this$0).getLogger().w("H264GiftShowView|GiftAnimation", "bug, wrong image url", new Object[0]);
    }
    paramString = paramBitmap;
    if (paramBitmap == null) {
      paramString = BitmapFactory.decodeResource(this.this$0.getResources(), 2130840592);
    }
    H264GiftView.access$900(this.this$0, this.val$giftInfo, paramString);
  }
  
  public void onLoadingFailed(String paramString1, View paramView, String paramString2)
  {
    if (H264GiftView.access$100(this.this$0) == null) {
      return;
    }
    H264GiftView.access$900(this.this$0, this.val$giftInfo, BitmapFactory.decodeResource(this.this$0.getResources(), 2130840592));
    H264GiftView.access$100(this.this$0).getLogger().e("H264GiftShowView|GiftAnimation", "head fetch fail", new Object[0]);
  }
  
  public void onLoadingStarted(String paramString, View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview.H264GiftView.4
 * JD-Core Version:    0.7.0.1
 */