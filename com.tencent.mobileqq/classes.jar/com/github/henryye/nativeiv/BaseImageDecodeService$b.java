package com.github.henryye.nativeiv;

import com.github.henryye.nativeiv.api.IImageDecodeService.c;
import com.github.henryye.nativeiv.bitmap.IBitmap;

public class BaseImageDecodeService$b
  implements IImageDecodeService.c
{
  public void a(String paramString, Object paramObject)
  {
    if (paramObject != null) {
      ((IBitmap)paramObject).recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.github.henryye.nativeiv.BaseImageDecodeService.b
 * JD-Core Version:    0.7.0.1
 */