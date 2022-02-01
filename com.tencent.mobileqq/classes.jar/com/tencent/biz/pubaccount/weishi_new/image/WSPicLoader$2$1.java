package com.tencent.biz.pubaccount.weishi_new.image;

import android.widget.ImageView;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import java.lang.ref.WeakReference;

class WSPicLoader$2$1
  implements URLDrawable.URLDrawableListener
{
  WSPicLoader$2$1(WSPicLoader.2 param2) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    WSDrawableListener localWSDrawableListener = WSPicLoader.a(this.a.this$0, this.a.d);
    if (localWSDrawableListener != null) {
      localWSDrawableListener.b(paramURLDrawable);
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("WeishiUtils loadAvatarImage onFail url:");
    ((StringBuilder)localObject).append(this.a.c);
    WSLog.d("AvatarImageLog", ((StringBuilder)localObject).toString());
    localObject = WSPicLoader.a(this.a.this$0, this.a.d);
    if (localObject != null) {
      ((WSDrawableListener)localObject).a(paramURLDrawable, paramThrowable);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    WSDrawableListener localWSDrawableListener = WSPicLoader.a(this.a.this$0, this.a.d);
    if (localWSDrawableListener != null) {
      localWSDrawableListener.a(paramURLDrawable, paramInt);
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    Object localObject = (ImageView)this.a.a.get();
    if (localObject == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WeishiUtils loadAvatarImage onSuccess url:");
    localStringBuilder.append(this.a.c);
    WSLog.b("AvatarImageLog", localStringBuilder.toString());
    ((ImageView)localObject).setImageDrawable(paramURLDrawable);
    localObject = WSPicLoader.a(this.a.this$0, this.a.d);
    if (localObject != null) {
      ((WSDrawableListener)localObject).a(paramURLDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader.2.1
 * JD-Core Version:    0.7.0.1
 */