package com.github.henryye.nativeiv;

import androidx.annotation.NonNull;
import com.github.henryye.nativeiv.api.IImageDecodeService.b;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import java.lang.ref.WeakReference;

class BaseImageDecodeService$c
  implements Runnable
{
  private Object a;
  private ImageDecodeConfig b;
  private volatile boolean c = false;
  private WeakReference<BaseImageDecodeService> d;
  private final BaseImageDecodeService.b e = new BaseImageDecodeService.b();
  
  BaseImageDecodeService$c(BaseImageDecodeService paramBaseImageDecodeService, @NonNull Object paramObject, ImageDecodeConfig paramImageDecodeConfig)
  {
    this.a = paramObject;
    this.b = paramImageDecodeConfig;
    this.d = new WeakReference(paramBaseImageDecodeService);
  }
  
  public void run()
  {
    if (this.c) {
      return;
    }
    if (this.d.get() == null) {
      return;
    }
    IBitmap localIBitmap = ((BaseImageDecodeService)this.d.get()).loadBitmapSync(this.a, this.b);
    if (this.c)
    {
      if (localIBitmap != null) {
        localIBitmap.recycle();
      }
      return;
    }
    BaseImageDecodeService.access$100((BaseImageDecodeService)this.d.get()).a(this.a.toString(), localIBitmap, this.e, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.github.henryye.nativeiv.BaseImageDecodeService.c
 * JD-Core Version:    0.7.0.1
 */