package com.tencent.magicbrush;

import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.api.IImageDecodeService.c;

class MBRuntime$5
  implements Runnable
{
  MBRuntime$5(MBRuntime paramMBRuntime, IImageDecodeService.c paramc, String paramString, Object paramObject, ImageDecodeConfig paramImageDecodeConfig) {}
  
  public void run()
  {
    if (this.e.a == 0L)
    {
      this.a.a(this.b, this.c);
      return;
    }
    MBRuntime localMBRuntime = this.e;
    localMBRuntime.nativeNotifyImageDecoded(localMBRuntime.a, this.b, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.MBRuntime.5
 * JD-Core Version:    0.7.0.1
 */