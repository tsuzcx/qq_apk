package com.tencent.biz.pubaccount.weishi_new.util;

import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import java.lang.ref.WeakReference;

class WeishiUtils$5$1
  implements URLDrawable.URLDrawableListener
{
  WeishiUtils$5$1(WeishiUtils.5 param5) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    WSLog.d("AvatarImageLog", "WeishiUtils loadAvatarImage onFail url:" + this.a.jdField_a_of_type_JavaLangString);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    ImageView localImageView = (ImageView)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localImageView == null) {
      return;
    }
    WSLog.b("AvatarImageLog", "WeishiUtils loadAvatarImage onSuccess url:" + this.a.jdField_a_of_type_JavaLangString);
    localImageView.setImageDrawable(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils.5.1
 * JD-Core Version:    0.7.0.1
 */