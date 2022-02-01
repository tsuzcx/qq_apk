package com.tencent.map.sdk.a;

import android.graphics.Bitmap;
import java.util.LinkedHashMap;

public final class fy$a
{
  public fy.a.a<String, Bitmap> a = new fy.a.a();
  
  public final Bitmap a(String paramString)
  {
    return (Bitmap)this.a.a(paramString);
  }
  
  public final void a(String paramString, Bitmap paramBitmap)
  {
    fy.a.a locala = this.a;
    synchronized (locala.c)
    {
      locala.a.put(paramString, paramBitmap);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.fy.a
 * JD-Core Version:    0.7.0.1
 */