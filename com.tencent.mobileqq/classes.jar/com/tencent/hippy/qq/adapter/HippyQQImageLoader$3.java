package com.tencent.hippy.qq.adapter;

import android.os.Handler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mtt.hippy.adapter.image.HippyDrawable;
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader.Callback;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Set;

class HippyQQImageLoader$3
  implements URLDrawable.URLDrawableListener
{
  HippyQQImageLoader$3(HippyQQImageLoader paramHippyQQImageLoader, String paramString1, String paramString2, HippyDrawable paramHippyDrawable, String paramString3, HippyImageLoader.Callback paramCallback, boolean paramBoolean) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HippyImageAdapter", 2, "internalRequestImage url:" + this.val$realUrl + " onLoadCanceled");
    }
    HippyQQImageLoader.access$200(this.this$0).remove(paramURLDrawable);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("HippyImageAdapter", 2, "internalRequestImage url:" + this.val$realUrl + " onLoadFialed");
    }
    HippyQQImageLoader.access$300(this.this$0, paramURLDrawable, paramThrowable, this.val$requestCallback);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HippyImageAdapter", 2, "internalRequestImage url:" + this.val$realUrl + " onLoadProgressed:" + paramInt);
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HippyImageAdapter", 2, "internalRequestImage url:" + this.val$realUrl + " onLoadSuccessed");
    }
    if (HippyQQImageLoader.access$100(this.this$0, this.val$imageType))
    {
      this.val$hippyTarget.setDrawable(paramURLDrawable);
      HippyQQImageLoader.access$000(this.this$0).post(new HippyQQImageLoader.3.1(this, paramURLDrawable));
    }
    for (;;)
    {
      HippyQQImageLoader.access$200(this.this$0).remove(paramURLDrawable);
      File localFile;
      do
      {
        return;
        localFile = paramURLDrawable.getFileInLocal();
        if ((localFile != null) && (localFile.exists())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("HippyImageAdapter", 2, "internalRequestImage url:" + this.val$realUrl + " onLoadSuccessed notExists");
      return;
      ThreadManager.post(new HippyQQImageLoader.3.2(this, localFile), 8, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.adapter.HippyQQImageLoader.3
 * JD-Core Version:    0.7.0.1
 */