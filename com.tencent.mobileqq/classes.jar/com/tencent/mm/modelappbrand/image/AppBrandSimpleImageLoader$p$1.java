package com.tencent.mm.modelappbrand.image;

import com.tencent.luggage.wxa.pc.i;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URLConnection;
import org.apache.commons.io.IOUtils;

class AppBrandSimpleImageLoader$p$1
  extends BufferedInputStream
{
  AppBrandSimpleImageLoader$p$1(AppBrandSimpleImageLoader.p paramp, InputStream paramInputStream, i parami)
  {
    super(paramInputStream);
  }
  
  public void close()
  {
    try
    {
      super.close();
      return;
    }
    finally
    {
      IOUtils.close((URLConnection)this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.p.1
 * JD-Core Version:    0.7.0.1
 */