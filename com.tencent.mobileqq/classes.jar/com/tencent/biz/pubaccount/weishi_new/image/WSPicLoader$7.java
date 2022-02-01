package com.tencent.biz.pubaccount.weishi_new.image;

import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.weishi_new.download.wsapp.WSFallKeyPicMonitor;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

final class WSPicLoader$7
  implements URLDrawable.URLDrawableListener
{
  WSPicLoader$7(String paramString1, ImageView paramImageView, String paramString2) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = new StringBuilder();
    paramURLDrawable.append("onLoadCanceled - ");
    paramURLDrawable.append(this.jdField_a_of_type_JavaLangString);
    WSLog.a("815", paramURLDrawable.toString());
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841770);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramURLDrawable = new StringBuilder();
    paramURLDrawable.append("onLoadFialed - ");
    paramURLDrawable.append(this.jdField_a_of_type_JavaLangString);
    WSLog.a("815", paramURLDrawable.toString());
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841770);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    paramURLDrawable = new StringBuilder();
    paramURLDrawable.append("onLoadProgressed - ");
    paramURLDrawable.append(this.jdField_a_of_type_JavaLangString);
    WSLog.a("815", paramURLDrawable.toString());
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLoadSuccessed - ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    WSLog.a("815", localStringBuilder.toString());
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramURLDrawable);
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, "banner")) {
      WSFallKeyPicMonitor.b(2, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader.7
 * JD-Core Version:    0.7.0.1
 */