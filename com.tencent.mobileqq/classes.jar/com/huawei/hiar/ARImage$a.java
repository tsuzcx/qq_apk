package com.huawei.hiar;

import android.media.PlaneAdapter;
import com.huawei.hiar.exceptions.ARFatalException;
import java.nio.ByteBuffer;

class ARImage$a
  extends PlaneAdapter
{
  private final long b;
  private final int c;
  
  public ARImage$a(ARImage paramARImage, long paramLong, int paramInt)
  {
    this.b = paramLong;
    this.c = paramInt;
  }
  
  public final ByteBuffer getBuffer()
  {
    return ARImage.access$200(this.a, this.b, this.c).asReadOnlyBuffer();
  }
  
  public final int getPixelStride()
  {
    int i = ARImage.access$100(this.a, this.b, this.c);
    if (i == -1) {
      throw new ARFatalException("Unknown error in ArImage.Plane.getPixelStride().");
    }
    return i;
  }
  
  public final int getRowStride()
  {
    int i = ARImage.access$000(this.a, this.b, this.c);
    if (i == -1) {
      throw new ARFatalException("Unknown error in ArImage.Plane.getRowStride().");
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.huawei.hiar.ARImage.a
 * JD-Core Version:    0.7.0.1
 */