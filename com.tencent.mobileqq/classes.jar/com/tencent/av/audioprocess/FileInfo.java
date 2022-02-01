package com.tencent.av.audioprocess;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import java.io.RandomAccessFile;

public class FileInfo
  extends DecodeInfo
{
  public float a;
  public long a;
  public MediaCodec.BufferInfo a;
  public MediaExtractor a;
  public RandomAccessFile a;
  public String a;
  public byte[] a;
  public int b = 0;
  public int c = 2147483647;
  public int d = 0;
  public int e = 0;
  
  public FileInfo()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_JavaIoRandomAccessFile = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidMediaMediaExtractor = null;
    this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo = null;
    this.jdField_a_of_type_ArrayOfByte = null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FileInfo{filename = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", fileType = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", volumeScale = ");
    localStringBuilder.append(this.jdField_a_of_type_Float);
    localStringBuilder.append(", mixCnt = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", channelNum = ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.audioprocess.FileInfo
 * JD-Core Version:    0.7.0.1
 */