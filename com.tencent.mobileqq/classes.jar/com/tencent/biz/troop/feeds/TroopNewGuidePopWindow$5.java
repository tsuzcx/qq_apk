package com.tencent.biz.troop.feeds;

import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.utils.DisplayUtils;

class TroopNewGuidePopWindow$5
  implements URLDrawable.URLDrawableListener
{
  TroopNewGuidePopWindow$5(TroopNewGuidePopWindow paramTroopNewGuidePopWindow, DisplayMetrics paramDisplayMetrics) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    this.b.i.setVisibility(8);
    this.b.v = false;
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.b.i.setVisibility(8);
    this.b.v = false;
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.b.i.setImageDrawable(null);
    this.b.i.setImageDrawable(paramURLDrawable);
    float f1 = paramURLDrawable.getIntrinsicHeight();
    float f2 = paramURLDrawable.getIntrinsicWidth();
    paramURLDrawable = this.b.i.getLayoutParams();
    int i;
    if (f2 != 0.0F)
    {
      if (f1 > DisplayUtils.a(this.b.a, 150.0F)) {
        i = (int)DisplayUtils.a(this.b.a, 150.0F);
      } else {
        i = (int)((this.a.widthPixels - DisplayUtils.a(this.b.a, 60.0F)) * (f1 / f2));
      }
    }
    else {
      i = 0;
    }
    if (i > 0)
    {
      paramURLDrawable.height = i;
      this.b.i.setLayoutParams(paramURLDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.feeds.TroopNewGuidePopWindow.5
 * JD-Core Version:    0.7.0.1
 */