package com.github.henryye.nativeiv;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.github.henryye.nativeiv.api.IImageDecodeService.b;
import com.github.henryye.nativeiv.api.IImageDecodeService.b.a;
import com.github.henryye.nativeiv.api.IImageDecodeService.c;
import com.github.henryye.nativeiv.api.a;
import java.util.Iterator;
import java.util.List;

class BaseImageDecodeService$a
  implements IImageDecodeService.b
{
  private BaseImageDecodeService$a(BaseImageDecodeService paramBaseImageDecodeService) {}
  
  public void a(String paramString, IImageDecodeService.b.a parama, a parama1)
  {
    Iterator localIterator = BaseImageDecodeService.access$200(this.a).iterator();
    while (localIterator.hasNext()) {
      ((IImageDecodeService.b)localIterator.next()).a(paramString, parama, parama1);
    }
  }
  
  public void a(@NonNull String paramString, @Nullable Object paramObject, @NonNull IImageDecodeService.c paramc, ImageDecodeConfig paramImageDecodeConfig)
  {
    Iterator localIterator = BaseImageDecodeService.access$200(this.a).iterator();
    while (localIterator.hasNext()) {
      ((IImageDecodeService.b)localIterator.next()).a(paramString, paramObject, paramc, paramImageDecodeConfig);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.github.henryye.nativeiv.BaseImageDecodeService.a
 * JD-Core Version:    0.7.0.1
 */