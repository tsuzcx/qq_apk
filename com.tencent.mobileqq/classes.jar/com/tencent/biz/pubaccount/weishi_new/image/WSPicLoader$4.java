package com.tencent.biz.pubaccount.weishi_new.image;

import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.weishi_new.download.wsapp.WSFallKeyPicMonitor;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class WSPicLoader$4
  implements URLDrawable.URLDrawableListener
{
  WSPicLoader$4(WSPicLoader paramWSPicLoader, String paramString1, ImageView paramImageView, String paramString2) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = new StringBuilder();
    paramURLDrawable.append("onLoadCanceled - ");
    paramURLDrawable.append(this.a);
    WSLog.a("815", paramURLDrawable.toString());
    this.b.setImageResource(2130842687);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramURLDrawable = new StringBuilder();
    paramURLDrawable.append("onLoadFialed - ");
    paramURLDrawable.append(this.a);
    WSLog.a("815", paramURLDrawable.toString());
    this.b.setImageResource(2130842687);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    paramURLDrawable = new StringBuilder();
    paramURLDrawable.append("onLoadProgressed - ");
    paramURLDrawable.append(this.a);
    WSLog.a("815", paramURLDrawable.toString());
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLoadSuccessed - ");
    localStringBuilder.append(this.a);
    WSLog.a("815", localStringBuilder.toString());
    this.b.setImageDrawable(paramURLDrawable);
    if (TextUtils.equals(this.a, "banner")) {
      WSFallKeyPicMonitor.b(2, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader.4
 * JD-Core Version:    0.7.0.1
 */