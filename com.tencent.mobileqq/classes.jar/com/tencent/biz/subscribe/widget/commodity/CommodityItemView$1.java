package com.tencent.biz.subscribe.widget.commodity;

import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.ImageLoader.ImageLoadListener;
import com.tencent.component.media.image.ImageLoader.Options;

class CommodityItemView$1
  implements ImageLoader.ImageLoadListener
{
  CommodityItemView$1(CommodityItemView paramCommodityItemView) {}
  
  public void onImageCanceled(String paramString, ImageLoader.Options paramOptions) {}
  
  public void onImageFailed(String paramString, ImageLoader.Options paramOptions) {}
  
  public void onImageLoaded(String paramString, Drawable paramDrawable, ImageLoader.Options paramOptions)
  {
    if (CommodityItemView.a(this.a) != null) {
      this.a.post(new CommodityItemView.1.1(this, paramDrawable));
    }
  }
  
  public void onImageProgress(String paramString, float paramFloat, ImageLoader.Options paramOptions) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.commodity.CommodityItemView.1
 * JD-Core Version:    0.7.0.1
 */