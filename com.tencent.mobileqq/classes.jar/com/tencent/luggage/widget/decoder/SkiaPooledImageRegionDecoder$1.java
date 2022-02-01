package com.tencent.luggage.widget.decoder;

class SkiaPooledImageRegionDecoder$1
  extends Thread
{
  SkiaPooledImageRegionDecoder$1(SkiaPooledImageRegionDecoder paramSkiaPooledImageRegionDecoder) {}
  
  public void run()
  {
    while (SkiaPooledImageRegionDecoder.a(this.a) != null)
    {
      SkiaPooledImageRegionDecoder localSkiaPooledImageRegionDecoder = this.a;
      if (!localSkiaPooledImageRegionDecoder.a(SkiaPooledImageRegionDecoder.b.a(SkiaPooledImageRegionDecoder.a(localSkiaPooledImageRegionDecoder)), SkiaPooledImageRegionDecoder.b(this.a))) {
        break;
      }
      try
      {
        if (SkiaPooledImageRegionDecoder.a(this.a) != null)
        {
          long l1 = System.currentTimeMillis();
          SkiaPooledImageRegionDecoder.a(this.a, "Starting decoder");
          SkiaPooledImageRegionDecoder.c(this.a);
          long l2 = System.currentTimeMillis();
          localSkiaPooledImageRegionDecoder = this.a;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Started decoder, took ");
          ((StringBuilder)localObject).append(l2 - l1);
          ((StringBuilder)localObject).append("ms");
          SkiaPooledImageRegionDecoder.a(localSkiaPooledImageRegionDecoder, ((StringBuilder)localObject).toString());
        }
      }
      catch (Exception localException)
      {
        Object localObject = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to start decoder: ");
        localStringBuilder.append(localException.getMessage());
        SkiaPooledImageRegionDecoder.a((SkiaPooledImageRegionDecoder)localObject, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.widget.decoder.SkiaPooledImageRegionDecoder.1
 * JD-Core Version:    0.7.0.1
 */