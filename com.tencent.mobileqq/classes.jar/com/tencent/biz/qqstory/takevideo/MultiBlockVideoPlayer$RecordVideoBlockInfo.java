package com.tencent.biz.qqstory.takevideo;

import android.graphics.Bitmap;

public class MultiBlockVideoPlayer$RecordVideoBlockInfo
  extends VideoFragmentInfo
{
  public final long a;
  public final long b;
  public final long c;
  public final long d;
  
  public MultiBlockVideoPlayer$RecordVideoBlockInfo(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4, Bitmap paramBitmap)
  {
    super(paramInt, paramBitmap);
    this.a = paramLong1;
    this.b = paramLong2;
    this.jdField_c_of_type_Long = paramLong3;
    this.d = paramLong4;
  }
  
  public RecordVideoBlockInfo a(Bitmap paramBitmap)
  {
    return new RecordVideoBlockInfo(this.jdField_c_of_type_Int, this.a, this.b, this.jdField_c_of_type_Long, this.d, paramBitmap);
  }
  
  public String toString()
  {
    return "RecordVideoBlockInfo{index:" + this.jdField_c_of_type_Int + ", vfFrame: " + this.a + " ~ " + this.b + ", afTime: " + this.jdField_c_of_type_Long + " ~ " + this.d + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.MultiBlockVideoPlayer.RecordVideoBlockInfo
 * JD-Core Version:    0.7.0.1
 */