package com.github.henryye.nativeiv;

import androidx.annotation.Nullable;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.github.henryye.nativeiv.bitmap.c;
import java.io.IOException;
import java.io.InputStream;

class c$b
  implements IBitmap<NativeBitmapStruct>
{
  private void a(InputStream paramInputStream)
  {
    if (paramInputStream != null) {
      return;
    }
    throw new IOException("Null input stream");
  }
  
  @Nullable
  public NativeBitmapStruct a()
  {
    return null;
  }
  
  public void decodeInputStream(InputStream paramInputStream, ImageDecodeConfig paramImageDecodeConfig, c paramc)
  {
    a(paramInputStream);
  }
  
  public long getDecodeTime()
  {
    return 0L;
  }
  
  public BitmapType getType()
  {
    return BitmapType.Native;
  }
  
  public void recycle() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.github.henryye.nativeiv.c.b
 * JD-Core Version:    0.7.0.1
 */