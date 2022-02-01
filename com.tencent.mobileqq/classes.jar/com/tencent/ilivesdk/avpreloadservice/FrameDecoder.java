package com.tencent.ilivesdk.avpreloadservice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.Image;
import android.media.Image.Plane;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.util.Log;
import java.nio.ByteBuffer;

public class FrameDecoder
{
  private static FrameDecoder a = new FrameDecoder();
  
  private Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (paramBitmap == null) {
      localObject = null;
    }
    Bitmap localBitmap;
    do
    {
      return localObject;
      int i = paramBitmap.getHeight();
      int j = paramBitmap.getWidth();
      float f1 = paramInt1 / j;
      float f2 = paramInt2 / i;
      localObject = new Matrix();
      ((Matrix)localObject).postScale(f1, f2);
      localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, j, i, (Matrix)localObject, false);
      localObject = localBitmap;
    } while (paramBitmap.isRecycled());
    paramBitmap.recycle();
    return localBitmap;
  }
  
  private Bitmap a(Image paramImage, Context paramContext)
  {
    Object localObject = paramImage.getPlanes();
    ByteBuffer localByteBuffer1 = localObject[0].getBuffer();
    int i = localObject[0].getPixelStride();
    int j = localObject[0].getRowStride();
    int k = localByteBuffer1.remaining();
    ByteBuffer localByteBuffer2 = localObject[1].getBuffer();
    int i1 = localObject[1].getPixelStride();
    int i2 = localObject[1].getRowStride();
    int m = localByteBuffer2.remaining();
    ByteBuffer localByteBuffer3 = localObject[2].getBuffer();
    int i3 = localObject[2].getPixelStride();
    int i4 = localObject[2].getRowStride();
    int n = localByteBuffer3.remaining();
    Log.i("FrameDecoder", "yBuffer: " + localByteBuffer1.remaining() + " pixelStride: " + i + " rowStride: " + j);
    Log.i("FrameDecoder", "uBuffer: " + localByteBuffer2.remaining() + " pixelStride: " + i1 + " rowStride: " + i2);
    Log.i("FrameDecoder", "vBuffer: " + localByteBuffer3.remaining() + " pixelStride: " + i3 + " rowStride: " + i4);
    Log.i("FrameDecoder", "image format: " + paramImage.getFormat() + "  WxH: " + paramImage.getWidth() + "x" + paramImage.getHeight());
    localObject = new byte[k + n + m];
    localByteBuffer1.get((byte[])localObject, 0, k);
    if (j == i4) {
      localByteBuffer3.get((byte[])localObject, k, n);
    }
    for (;;)
    {
      return NV12ToBitmap.a(paramContext, (byte[])localObject, paramImage.getWidth(), paramImage.getHeight());
      j = 0;
      i = 0;
      while ((i < localObject.length) && (j < m) && (j < n))
      {
        localObject[(k + i)] = localByteBuffer3.get(j);
        localObject[(k + i + 1)] = localByteBuffer2.get(j);
        j += 1;
        i += 2;
      }
    }
  }
  
  private MediaCodec a(int paramInt1, int paramInt2)
  {
    try
    {
      localMediaCodec = MediaCodec.createDecoderByType("video/avc");
      MediaFormat localMediaFormat;
      localException1.printStackTrace();
    }
    catch (Exception localException1)
    {
      try
      {
        localMediaFormat = MediaFormat.createVideoFormat("video/avc", paramInt1, paramInt2);
        localMediaFormat.setString("mime", "video/avc");
        localMediaFormat.setInteger("max-input-size", paramInt1 * paramInt2);
        localMediaCodec.configure(localMediaFormat, null, null, 0);
        localMediaCodec.start();
        return localMediaCodec;
      }
      catch (Exception localException2)
      {
        MediaCodec localMediaCodec;
        break label53;
      }
      localException1 = localException1;
      localMediaCodec = null;
    }
    label53:
    if (localMediaCodec != null) {
      localMediaCodec.release();
    }
    return null;
  }
  
  public static FrameDecoder a()
  {
    return a;
  }
  
  private void a(MediaCodec paramMediaCodec)
  {
    if (paramMediaCodec == null) {
      return;
    }
    try
    {
      paramMediaCodec.stop();
      paramMediaCodec.release();
      return;
    }
    catch (Exception paramMediaCodec)
    {
      paramMediaCodec.printStackTrace();
    }
  }
  
  public Bitmap a(Context paramContext, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0) || (paramInt1 <= 0))
    {
      Log.e("FrameDecoder", "decode frame fail! buffer or bufferSize is error!");
      paramArrayOfByte = null;
      return paramArrayOfByte;
    }
    if ((paramInt2 <= 0) || (paramInt3 <= 0))
    {
      Log.i("FrameDecoder", "openDecoder parse sps is error! width:" + paramInt2 + " height:" + paramInt3);
      return null;
    }
    Log.i("FrameDecoder", "openDecoder sps WxH: " + paramInt2 + "x" + paramInt3);
    MediaCodec localMediaCodec = a(paramInt2, paramInt3);
    if (localMediaCodec == null) {
      return null;
    }
    MediaCodec.BufferInfo localBufferInfo;
    ByteBuffer localByteBuffer;
    try
    {
      localBufferInfo = new MediaCodec.BufferInfo();
      paramInt2 = localMediaCodec.dequeueInputBuffer(30000);
      localByteBuffer = localMediaCodec.getInputBuffer(paramInt2);
      if (localByteBuffer != null) {
        break label203;
      }
      a(localMediaCodec);
      throw new IllegalAccessError("get input buffer fail!");
    }
    catch (Exception paramArrayOfByte)
    {
      paramContext = null;
    }
    label179:
    paramArrayOfByte.printStackTrace();
    for (;;)
    {
      a(localMediaCodec);
      if (paramContext == null)
      {
        Log.i("FrameDecoder", "dec frame fail! outBitmap is null!");
        return null;
        label203:
        if (localByteBuffer.remaining() < paramInt1) {
          localByteBuffer.limit(paramInt1);
        }
        localByteBuffer.position(0);
        localByteBuffer.put(paramArrayOfByte, 0, paramInt1);
        localMediaCodec.queueInputBuffer(paramInt2, 0, paramInt1, 0L, 4);
        paramInt1 = 0;
        label248:
        paramInt3 = localMediaCodec.dequeueOutputBuffer(localBufferInfo, 30000);
        Log.i("FrameDecoder", "dec frame outIndex: " + paramInt3);
        if (paramInt3 >= 0)
        {
          paramArrayOfByte = localMediaCodec.getOutputImage(paramInt3);
          label300:
          if ((paramInt3 < 0) || (paramArrayOfByte == null)) {
            break label402;
          }
          if ((paramArrayOfByte.getFormat() != 35) || (paramArrayOfByte.getPlanes().length < 3)) {
            break label397;
          }
        }
      }
      label397:
      for (paramContext = a(paramArrayOfByte, paramContext);; paramContext = null)
      {
        try
        {
          localMediaCodec.releaseOutputBuffer(paramInt3, false);
          paramArrayOfByte.close();
        }
        catch (Exception paramArrayOfByte) {}
        break label179;
        paramInt2 = paramInt1 + 1;
        paramInt1 = paramInt2;
        if (paramInt2 < 10) {
          break label248;
        }
        paramArrayOfByte = null;
        break label300;
        paramArrayOfByte = paramContext;
        if (paramInt4 == 0) {
          break;
        }
        paramArrayOfByte = paramContext;
        if (paramInt5 == 0) {
          break;
        }
        return a(paramContext, paramInt4, paramInt5);
      }
      label402:
      paramContext = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.FrameDecoder
 * JD-Core Version:    0.7.0.1
 */