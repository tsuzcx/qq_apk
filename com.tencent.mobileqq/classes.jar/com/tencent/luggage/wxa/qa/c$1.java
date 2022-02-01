package com.tencent.luggage.wxa.qa;

import android.graphics.Bitmap;
import com.tencent.luggage.wxa.sj.g;

class c$1
  implements g
{
  c$1(c paramc) {}
  
  public String a()
  {
    return "Base64IconLoader";
  }
  
  public void run()
  {
    try
    {
      Bitmap localBitmap = c.a(this.a, this.a.a);
      this.a.a(localBitmap);
      return;
    }
    catch (Exception localException)
    {
      label24:
      break label24;
    }
    this.a.c.a("Failed to load icon via base64 icon", this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qa.c.1
 * JD-Core Version:    0.7.0.1
 */