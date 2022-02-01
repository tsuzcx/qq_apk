package com.tencent.biz.pubaccount.weishi_new.image;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.lang.ref.WeakReference;

class WSPicLoader$3
  implements Runnable
{
  WSPicLoader$3(WSPicLoader paramWSPicLoader, WeakReference paramWeakReference, Context paramContext, String paramString) {}
  
  public void run()
  {
    if ((ImageView)this.a.get() == null) {
      return;
    }
    Object localObject = this.b.getResources().getDrawable(2130841060);
    if (WeishiUtils.c(this.c) == null)
    {
      this.this$0.a(this.a, (Drawable)localObject, this.c);
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
    localObject = URLDrawable.getDrawable(this.c, localURLDrawableOptions);
    this.this$0.a(this.a, (Drawable)localObject, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader.3
 * JD-Core Version:    0.7.0.1
 */