package com.tencent.mobileqq.activity.emogroupstore;

import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class EmoticonGroupStoreFragment$9
  implements URLDrawable.URLDrawableListener
{
  EmoticonGroupStoreFragment$9(EmoticonGroupStoreFragment paramEmoticonGroupStoreFragment) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    EmoticonGroupStoreFragment.a(this.a).invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment.9
 * JD-Core Version:    0.7.0.1
 */