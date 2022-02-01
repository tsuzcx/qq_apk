package com.tencent.biz.pubaccount.weishi_new.image;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.lang.ref.WeakReference;

class WSPicLoader$1
  implements Runnable
{
  WSPicLoader$1(WSPicLoader paramWSPicLoader, WeakReference paramWeakReference1, String paramString, Drawable paramDrawable, WeakReference paramWeakReference2) {}
  
  public void run()
  {
    if ((ImageView)this.a.get() == null) {
      return;
    }
    if (WeishiUtils.c(this.b) == null) {
      return;
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    Drawable localDrawable = this.c;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localDrawable;
    localObject = URLDrawable.getDrawable(this.b, (URLDrawable.URLDrawableOptions)localObject);
    this.this$0.a(this.a, (Drawable)localObject, this.b, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader.1
 * JD-Core Version:    0.7.0.1
 */