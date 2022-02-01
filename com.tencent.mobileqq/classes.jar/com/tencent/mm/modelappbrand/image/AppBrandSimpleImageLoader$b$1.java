package com.tencent.mm.modelappbrand.image;

import com.tencent.luggage.wxa.rt.k;
import java.io.BufferedOutputStream;
import java.io.OutputStream;

class AppBrandSimpleImageLoader$b$1
  extends BufferedOutputStream
{
  AppBrandSimpleImageLoader$b$1(AppBrandSimpleImageLoader.b paramb, OutputStream paramOutputStream, String paramString)
  {
    super(paramOutputStream);
  }
  
  public void flush()
  {
    try
    {
      super.flush();
      k.i(this.a);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.b.1
 * JD-Core Version:    0.7.0.1
 */