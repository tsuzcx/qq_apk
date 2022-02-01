package com.tencent.biz.pubaccount.weishi_new.util;

import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.weishi_new.download.wsapp.WSFallKeyPicMonitor;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

final class WeishiUtils$6
  implements URLDrawable.URLDrawableListener
{
  WeishiUtils$6(String paramString1, ImageView paramImageView, String paramString2) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    WSLog.a("815", "onLoadCanceled - " + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841881);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    WSLog.a("815", "onLoadFialed - " + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841881);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    WSLog.a("815", "onLoadProgressed - " + this.jdField_a_of_type_JavaLangString);
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    WSLog.a("815", "onLoadSuccessed - " + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramURLDrawable);
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, "banner")) {
      WSFallKeyPicMonitor.b(2, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils.6
 * JD-Core Version:    0.7.0.1
 */