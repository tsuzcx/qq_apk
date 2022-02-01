package com.tencent.biz.pubaccount.weishi_new.image;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import java.lang.ref.WeakReference;

final class WSPicLoader$5
  implements Runnable
{
  WSPicLoader$5(WeakReference paramWeakReference, Drawable paramDrawable, String paramString) {}
  
  public void run()
  {
    Object localObject = (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {
      return;
    }
    ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (!(localObject instanceof URLDrawable)) {
      return;
    }
    ((URLDrawable)localObject).setURLDrawableListener(new WSPicLoader.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader.5
 * JD-Core Version:    0.7.0.1
 */