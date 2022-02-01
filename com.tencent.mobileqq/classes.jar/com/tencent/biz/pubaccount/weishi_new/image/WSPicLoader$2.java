package com.tencent.biz.pubaccount.weishi_new.image;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import java.lang.ref.WeakReference;

class WSPicLoader$2
  implements Runnable
{
  WSPicLoader$2(WSPicLoader paramWSPicLoader, WeakReference paramWeakReference1, Drawable paramDrawable, String paramString, WeakReference paramWeakReference2) {}
  
  public void run()
  {
    Object localObject = (ImageView)this.a.get();
    if (localObject == null) {
      return;
    }
    ((ImageView)localObject).setImageDrawable(this.b);
    localObject = this.b;
    if (!(localObject instanceof URLDrawable)) {
      return;
    }
    ((URLDrawable)localObject).setURLDrawableListener(new WSPicLoader.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader.2
 * JD-Core Version:    0.7.0.1
 */