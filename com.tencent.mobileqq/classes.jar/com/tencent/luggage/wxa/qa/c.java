package com.tencent.luggage.wxa.qa;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;

public class c
  extends e
{
  public c(String paramString, d paramd)
  {
    super(paramString, paramd);
  }
  
  private Bitmap a(String paramString)
  {
    paramString = Base64.decode(paramString, 0);
    paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length);
    if (paramString == null) {
      this.c.a("Failed to load icon via base64 icon", this);
    }
    return paramString;
  }
  
  public void a()
  {
    if (this.a != null)
    {
      f.a.c(new c.1(this));
      return;
    }
    this.c.a("Failed to load icon via base64 icon", this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qa.c
 * JD-Core Version:    0.7.0.1
 */