package com.github.henryye.nativeiv;

import androidx.annotation.Nullable;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.c;
import java.io.IOException;
import java.io.InputStream;

class c$a
  implements IBitmap<Object>
{
  public void decodeInputStream(InputStream paramInputStream, ImageDecodeConfig paramImageDecodeConfig, c paramc)
  {
    throw new IOException("Stub");
  }
  
  public long getDecodeTime()
  {
    return 0L;
  }
  
  public BitmapType getType()
  {
    return BitmapType.Undefined;
  }
  
  @Nullable
  public Object provide()
  {
    return null;
  }
  
  public void recycle() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.github.henryye.nativeiv.c.a
 * JD-Core Version:    0.7.0.1
 */