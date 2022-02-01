package com.tencent.hippy.qq.view.tkd.listview;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

class HippyTKDRefreshHeader$7
  implements HippyTKDRefreshHeader.ImageRequestListener
{
  HippyTKDRefreshHeader$7(HippyTKDRefreshHeader paramHippyTKDRefreshHeader, int paramInt) {}
  
  public void onRequestFail(Throwable paramThrowable, String paramString) {}
  
  public void onRequestSuccess(Bitmap paramBitmap, String paramString)
  {
    if (paramBitmap != null) {
      this.this$0.mPullDownToRefreshDesIcon = new BitmapDrawable(paramBitmap);
    }
    paramBitmap = this.this$0;
    paramBitmap.mRefreshOffset = (paramBitmap.mContentheight + this.val$imgDisplayOffset);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.7
 * JD-Core Version:    0.7.0.1
 */