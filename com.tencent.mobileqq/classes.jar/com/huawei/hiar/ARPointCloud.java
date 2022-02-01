package com.huawei.hiar;

import com.huawei.hiar.exceptions.ARDeadlineExceededException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class ARPointCloud
{
  static final String TAG = ARPointCloud.class.getSimpleName();
  long mNativeHandle;
  private final ARSession mSession;
  
  protected ARPointCloud()
  {
    this.mSession = null;
    this.mNativeHandle = 0L;
  }
  
  ARPointCloud(long paramLong, ARSession paramARSession)
  {
    this.mNativeHandle = paramLong;
    this.mSession = paramARSession;
  }
  
  private native ByteBuffer nativeGetData(long paramLong1, long paramLong2);
  
  private native long nativeGetTimestamp(long paramLong1, long paramLong2);
  
  private native void nativeReleasePointCloud(long paramLong);
  
  protected void finalize()
  {
    if (this.mNativeHandle != 0L) {
      nativeReleasePointCloud(this.mNativeHandle);
    }
    super.finalize();
  }
  
  public FloatBuffer getPoints()
  {
    if (0L == this.mNativeHandle) {
      throw new ARDeadlineExceededException();
    }
    ByteBuffer localByteBuffer2 = nativeGetData(this.mSession.mNativeHandle, this.mNativeHandle);
    ByteBuffer localByteBuffer1 = localByteBuffer2;
    if (localByteBuffer2 == null) {
      localByteBuffer1 = ByteBuffer.allocateDirect(0);
    }
    return localByteBuffer1.order(ByteOrder.nativeOrder()).asFloatBuffer();
  }
  
  public long getTimestampNs()
  {
    if (0L == this.mNativeHandle) {
      throw new ARDeadlineExceededException();
    }
    return nativeGetTimestamp(this.mSession.mNativeHandle, this.mNativeHandle);
  }
  
  public void release()
  {
    nativeReleasePointCloud(this.mNativeHandle);
    this.mNativeHandle = 0L;
  }
  
  public String toString()
  {
    return String.format("ARPointcloud:{handle=0x%x, timestamp= %d}", new Object[] { Long.valueOf(this.mNativeHandle), Long.valueOf(getTimestampNs()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hiar.ARPointCloud
 * JD-Core Version:    0.7.0.1
 */