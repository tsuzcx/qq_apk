package com.tencent.biz.pubaccount.weishi_new.image;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.lang.ref.WeakReference;

final class WSPicLoader$4
  implements Runnable
{
  WSPicLoader$4(WeakReference paramWeakReference, String paramString, Drawable paramDrawable) {}
  
  public void run()
  {
    if ((ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return;
    }
    if (WeishiUtils.a(this.jdField_a_of_type_JavaLangString) == null) {
      return;
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localDrawable;
    localObject = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
    WSPicLoader.a(this.jdField_a_of_type_JavaLangRefWeakReference, (Drawable)localObject, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader.4
 * JD-Core Version:    0.7.0.1
 */