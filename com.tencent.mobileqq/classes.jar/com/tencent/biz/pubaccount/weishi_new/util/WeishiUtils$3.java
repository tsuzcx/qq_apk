package com.tencent.biz.pubaccount.weishi_new.util;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.lang.ref.WeakReference;

final class WeishiUtils$3
  implements Runnable
{
  public void run()
  {
    if ((ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {}
    while (WeishiUtils.a(this.jdField_a_of_type_JavaLangString) == null) {
      return;
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    localObject = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
    WeishiUtils.a(this.jdField_a_of_type_JavaLangRefWeakReference, (Drawable)localObject, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils.3
 * JD-Core Version:    0.7.0.1
 */