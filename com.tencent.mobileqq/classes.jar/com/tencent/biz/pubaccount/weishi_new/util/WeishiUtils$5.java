package com.tencent.biz.pubaccount.weishi_new.util;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import java.lang.ref.WeakReference;

final class WeishiUtils$5
  implements Runnable
{
  WeishiUtils$5(WeakReference paramWeakReference, Drawable paramDrawable, String paramString) {}
  
  public void run()
  {
    ImageView localImageView = (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localImageView == null) {}
    do
    {
      return;
      localImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    } while (!(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable));
    ((URLDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).setURLDrawableListener(new WeishiUtils.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils.5
 * JD-Core Version:    0.7.0.1
 */