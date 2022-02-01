package com.tencent.mobileqq.activity;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class TroopInfoActivity$5
  implements URLDrawable.URLDrawableListener
{
  TroopInfoActivity$5(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    TroopInfoActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInfoActivity.5
 * JD-Core Version:    0.7.0.1
 */