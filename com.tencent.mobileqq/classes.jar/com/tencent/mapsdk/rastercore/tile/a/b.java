package com.tencent.mapsdk.rastercore.tile.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.mapsdk.rastercore.d.f;

public final class b
{
  private String a = "md5";
  private byte[] b;
  private int c = -1;
  
  public b(byte[] paramArrayOfByte, int paramInt)
  {
    this.b = paramArrayOfByte;
    this.c = paramInt;
  }
  
  public b(byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    this.b = paramArrayOfByte;
    this.c = paramInt;
    this.a = paramString;
  }
  
  public final String a()
  {
    return this.a;
  }
  
  public final Bitmap b()
  {
    Object localObject;
    if (this.b == null) {
      localObject = null;
    }
    Bitmap localBitmap;
    do
    {
      return localObject;
      localBitmap = BitmapFactory.decodeByteArray(this.b, 0, this.b.length);
      localObject = localBitmap;
    } while (localBitmap == null);
    localBitmap.setDensity(f.s());
    return localBitmap;
  }
  
  public final byte[] c()
  {
    return this.b;
  }
  
  public final int d()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.tile.a.b
 * JD-Core Version:    0.7.0.1
 */