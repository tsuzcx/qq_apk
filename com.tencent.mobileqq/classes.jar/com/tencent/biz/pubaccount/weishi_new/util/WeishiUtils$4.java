package com.tencent.biz.pubaccount.weishi_new.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.lang.ref.WeakReference;

final class WeishiUtils$4
  implements Runnable
{
  WeishiUtils$4(WeakReference paramWeakReference, Context paramContext, String paramString) {}
  
  public void run()
  {
    if ((ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840452);
    if (WeishiUtils.a(this.jdField_a_of_type_JavaLangString) == null)
    {
      WeishiUtils.a(this.jdField_a_of_type_JavaLangRefWeakReference, (Drawable)localObject, this.jdField_a_of_type_JavaLangString);
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
    localObject = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, localURLDrawableOptions);
    WeishiUtils.a(this.jdField_a_of_type_JavaLangRefWeakReference, (Drawable)localObject, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils.4
 * JD-Core Version:    0.7.0.1
 */