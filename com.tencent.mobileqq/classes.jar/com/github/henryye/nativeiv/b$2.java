package com.github.henryye.nativeiv;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.c;
import java.io.InputStream;

class b$2
  implements com.github.henryye.nativeiv.bitmap.b<Bitmap>
{
  b$2(b paramb) {}
  
  public IBitmap<Bitmap> a()
  {
    return new LegacyBitmap();
  }
  
  public boolean a(InputStream paramInputStream, Bitmap.Config paramConfig, c paramc)
  {
    return true;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.github.henryye.nativeiv.b.2
 * JD-Core Version:    0.7.0.1
 */