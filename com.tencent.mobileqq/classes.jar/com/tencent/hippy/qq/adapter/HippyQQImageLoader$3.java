package com.tencent.hippy.qq.adapter;

import android.os.Handler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mtt.hippy.adapter.image.HippyDrawable;
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader.Callback;
import java.io.File;
import java.util.Set;
import java.util.Timer;

class HippyQQImageLoader$3
  implements URLDrawable.URLDrawableListener
{
  HippyQQImageLoader$3(HippyQQImageLoader paramHippyQQImageLoader, String paramString1, HippyDrawable paramHippyDrawable, String paramString2, HippyImageLoader.Callback paramCallback, boolean paramBoolean) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    HippyQQImageLoader.access$300(this.this$0).remove(paramURLDrawable);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    HippyQQImageLoader.access$400(this.this$0, paramURLDrawable, paramThrowable, this.val$requestCallback);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (HippyQQImageLoader.access$100(this.this$0, this.val$imageType))
    {
      this.val$hippyTarget.setDrawable(paramURLDrawable);
      HippyQQImageLoader.access$000(this.this$0).post(new HippyQQImageLoader.3.1(this, paramURLDrawable));
    }
    for (;;)
    {
      HippyQQImageLoader.access$300(this.this$0).remove(paramURLDrawable);
      File localFile;
      do
      {
        return;
        localFile = paramURLDrawable.getFileInLocal();
      } while ((localFile == null) || (!localFile.exists()));
      HippyQQImageLoader.access$200(this.this$0).schedule(new HippyQQImageLoader.3.2(this, localFile), 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.adapter.HippyQQImageLoader.3
 * JD-Core Version:    0.7.0.1
 */