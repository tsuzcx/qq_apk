package com.tencent.luggage.wxa.mx;

import com.tencent.xweb.skia_canvas.resource_loader.IResourceLoader.ResourceLoadCallback;

class b$1$1
  implements Runnable
{
  b$1$1(b.1 param1, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (this.b.a != null) {
      this.b.a.onResourceLoaded(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mx.b.1.1
 * JD-Core Version:    0.7.0.1
 */