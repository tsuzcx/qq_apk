package com.google.android.exoplayer2.ext.vp9;

import com.google.android.exoplayer2.decoder.OutputBuffer;
import com.google.android.exoplayer2.video.ColorInfo;
import java.nio.ByteBuffer;

final class VpxOutputBuffer
  extends OutputBuffer
{
  public static final int COLORSPACE_BT2020 = 3;
  public static final int COLORSPACE_BT601 = 1;
  public static final int COLORSPACE_BT709 = 2;
  public static final int COLORSPACE_UNKNOWN = 0;
  public ColorInfo colorInfo;
  public int colorspace;
  public ByteBuffer data;
  public int height;
  public int mode;
  private final VpxDecoder owner;
  public int width;
  public ByteBuffer[] yuvPlanes;
  public int[] yuvStrides;
  
  public VpxOutputBuffer(VpxDecoder paramVpxDecoder)
  {
    this.owner = paramVpxDecoder;
  }
  
  private void initData(int paramInt)
  {
    if ((this.data == null) || (this.data.capacity() < paramInt))
    {
      this.data = ByteBuffer.allocateDirect(paramInt);
      return;
    }
    this.data.position(0);
    this.data.limit(paramInt);
  }
  
  private boolean isSafeToMultiply(int paramInt1, int paramInt2)
  {
    return (paramInt1 >= 0) && (paramInt2 >= 0) && ((paramInt2 <= 0) || (paramInt1 < 2147483647 / paramInt2));
  }
  
  public void init(long paramLong, int paramInt)
  {
    this.timeUs = paramLong;
    this.mode = paramInt;
  }
  
  public boolean initForRgbFrame(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.yuvPlanes = null;
    if ((!isSafeToMultiply(paramInt1, paramInt2)) || (!isSafeToMultiply(paramInt1 * paramInt2, 2))) {
      return false;
    }
    initData(paramInt1 * paramInt2 * 2);
    return true;
  }
  
  public boolean initForYuvFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.colorspace = paramInt5;
    paramInt5 = (int)((paramInt2 + 1L) / 2L);
    if ((!isSafeToMultiply(paramInt3, paramInt2)) || (!isSafeToMultiply(paramInt4, paramInt5))) {
      return false;
    }
    paramInt1 = paramInt3 * paramInt2;
    paramInt2 = paramInt5 * paramInt4;
    paramInt5 = paramInt2 * 2 + paramInt1;
    if ((!isSafeToMultiply(paramInt2, 2)) || (paramInt5 < paramInt1)) {
      return false;
    }
    initData(paramInt5);
    if (this.yuvPlanes == null) {
      this.yuvPlanes = new ByteBuffer[3];
    }
    this.yuvPlanes[0] = this.data.slice();
    this.yuvPlanes[0].limit(paramInt1);
    this.data.position(paramInt1);
    this.yuvPlanes[1] = this.data.slice();
    this.yuvPlanes[1].limit(paramInt2);
    this.data.position(paramInt1 + paramInt2);
    this.yuvPlanes[2] = this.data.slice();
    this.yuvPlanes[2].limit(paramInt2);
    if (this.yuvStrides == null) {
      this.yuvStrides = new int[3];
    }
    this.yuvStrides[0] = paramInt3;
    this.yuvStrides[1] = paramInt4;
    this.yuvStrides[2] = paramInt4;
    return true;
  }
  
  public void release()
  {
    this.owner.releaseOutputBuffer(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.vp9.VpxOutputBuffer
 * JD-Core Version:    0.7.0.1
 */