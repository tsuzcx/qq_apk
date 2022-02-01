package com.tencent.liteav.basic.module;

import com.tencent.liteav.basic.log.TXCLog;

public class StatusBucket
{
  private static final String TAG = "com.tencent.liteav.basic.module.StatusBucket";
  private long mBucketObj = 0L;
  
  public StatusBucket()
  {
    this.mBucketObj = nativeCreateStatusBucket();
  }
  
  public StatusBucket(long paramLong)
  {
    this.mBucketObj = paramLong;
  }
  
  private static native long nativeCreateStatusBucket();
  
  private static native void nativeDestroyStatusBucket(long paramLong);
  
  private static native boolean nativeGetBooleanStatus(long paramLong, String paramString, int paramInt);
  
  private static native int nativeGetIntStatus(long paramLong, String paramString, int paramInt);
  
  private static native long nativeGetLongStatus(long paramLong, String paramString, int paramInt);
  
  private static native void nativeMerge(long paramLong1, long paramLong2);
  
  private static native void nativeSetBooleanStatus(long paramLong, String paramString, int paramInt, boolean paramBoolean);
  
  private static native void nativeSetIntStatus(long paramLong, String paramString, int paramInt1, int paramInt2);
  
  private static native void nativeSetLongStatus(long paramLong1, String paramString, int paramInt, long paramLong2);
  
  public static void testStatusBucket()
  {
    StatusBucket localStatusBucket = new StatusBucket();
    Object localObject = new StatusBucket();
    localStatusBucket.setBooleanStatus("1", 1, true);
    localStatusBucket.setIntStatus("2", 2, 2);
    localStatusBucket.setLongStatus("3", 3, 3L);
    ((StatusBucket)localObject).setIntStatus("1", 4, 4);
    ((StatusBucket)localObject).setBooleanStatus("5", 5, true);
    ((StatusBucket)localObject).setLongStatus("6", 6, 6L);
    localStatusBucket.merge((StatusBucket)localObject);
    localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("test_status_bucket: id:1, key:1, value:");
    localStringBuilder.append(localStatusBucket.getBooleanStatus("1", 1));
    TXCLog.e((String)localObject, localStringBuilder.toString());
    localObject = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("test_status_bucket: id:1, key:4, value:");
    localStringBuilder.append(localStatusBucket.getIntStatus("1", 4));
    TXCLog.e((String)localObject, localStringBuilder.toString());
    localObject = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("test_status_bucket: id:2, key:2, value:");
    localStringBuilder.append(localStatusBucket.getIntStatus("2", 2));
    TXCLog.e((String)localObject, localStringBuilder.toString());
    localObject = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("test_status_bucket: id:3, key:3, value:");
    localStringBuilder.append(localStatusBucket.getLongStatus("3", 3));
    TXCLog.e((String)localObject, localStringBuilder.toString());
    localObject = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("test_status_bucket: id:5, key:5, value:");
    localStringBuilder.append(localStatusBucket.getBooleanStatus("5", 5));
    TXCLog.e((String)localObject, localStringBuilder.toString());
    localObject = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("test_status_bucket: id:6, key:6, value:");
    localStringBuilder.append(localStatusBucket.getLongStatus("6", 6));
    TXCLog.e((String)localObject, localStringBuilder.toString());
  }
  
  protected void finalize()
  {
    super.finalize();
    long l = this.mBucketObj;
    this.mBucketObj = 0L;
    nativeDestroyStatusBucket(l);
  }
  
  public boolean getBooleanStatus(String paramString, int paramInt)
  {
    return nativeGetBooleanStatus(this.mBucketObj, paramString, paramInt);
  }
  
  public int getIntStatus(String paramString, int paramInt)
  {
    return nativeGetIntStatus(this.mBucketObj, paramString, paramInt);
  }
  
  public long getLongStatus(String paramString, int paramInt)
  {
    return nativeGetLongStatus(this.mBucketObj, paramString, paramInt);
  }
  
  public void merge(StatusBucket paramStatusBucket)
  {
    nativeMerge(this.mBucketObj, paramStatusBucket.mBucketObj);
  }
  
  public void setBooleanStatus(String paramString, int paramInt, boolean paramBoolean)
  {
    nativeSetBooleanStatus(this.mBucketObj, paramString, paramInt, paramBoolean);
  }
  
  public void setIntStatus(String paramString, int paramInt1, int paramInt2)
  {
    nativeSetIntStatus(this.mBucketObj, paramString, paramInt1, paramInt2);
  }
  
  public void setLongStatus(String paramString, int paramInt, long paramLong)
  {
    nativeSetLongStatus(this.mBucketObj, paramString, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.basic.module.StatusBucket
 * JD-Core Version:    0.7.0.1
 */