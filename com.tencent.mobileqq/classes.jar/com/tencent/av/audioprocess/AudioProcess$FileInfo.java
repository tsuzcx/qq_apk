package com.tencent.av.audioprocess;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import java.io.RandomAccessFile;

public class AudioProcess$FileInfo
  extends AudioProcess.DecodeInfo
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
  
  public AudioProcess$FileInfo()
  {
    super(null);
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
    return "FileInfo{filename = " + this.jdField_a_of_type_JavaLangString + ", fileType = " + this.b + ", volumeScale = " + this.jdField_a_of_type_Float + ", mixCnt = " + this.c + ", channelNum = " + this.jdField_a_of_type_Int + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.audioprocess.AudioProcess.FileInfo
 * JD-Core Version:    0.7.0.1
 */