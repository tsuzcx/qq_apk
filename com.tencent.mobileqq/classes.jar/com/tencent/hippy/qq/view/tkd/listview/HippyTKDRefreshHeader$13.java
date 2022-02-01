package com.tencent.hippy.qq.view.tkd.listview;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.immersive.ImmersiveUtils;

class HippyTKDRefreshHeader$13
  implements HippyTKDRefreshHeader.ImageRequestListener
{
  HippyTKDRefreshHeader$13(HippyTKDRefreshHeader paramHippyTKDRefreshHeader, int paramInt) {}
  
  public void onRequestFail(Throwable paramThrowable, String paramString) {}
  
  public void onRequestSuccess(Bitmap paramBitmap, String paramString)
  {
    if (paramBitmap != null)
    {
      if (this.val$refreshResult == 2) {
        this.this$0.mPullDownToRefreshSucIcon = new BitmapDrawable(BaseApplicationImpl.getContext().getResources(), Bitmap.createScaledBitmap(paramBitmap, ImmersiveUtils.a(12.0F) * paramBitmap.getWidth() / paramBitmap.getHeight(), ImmersiveUtils.a(12.0F), true));
      }
    }
    else {
      return;
    }
    this.this$0.mPullDownToRefreshFailIcon = new BitmapDrawable(BaseApplicationImpl.getContext().getResources(), Bitmap.createScaledBitmap(paramBitmap, ImmersiveUtils.a(12.0F) * paramBitmap.getWidth() / paramBitmap.getHeight(), ImmersiveUtils.a(12.0F), true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.13
 * JD-Core Version:    0.7.0.1
 */