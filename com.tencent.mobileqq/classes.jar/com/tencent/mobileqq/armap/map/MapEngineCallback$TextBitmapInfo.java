package com.tencent.mobileqq.armap.map;

import com.tencent.mobileqq.armap.utils.MySerialize;
import java.util.Arrays;

class MapEngineCallback$TextBitmapInfo
{
  public boolean bold;
  public float density;
  public int height;
  byte[] mData = new byte[4];
  public int pitch;
  public int width;
  
  public void fill(byte[] paramArrayOfByte)
  {
    Arrays.fill(this.mData, (byte)0);
    System.arraycopy(paramArrayOfByte, 0, this.mData, 0, 4);
    this.density = MySerialize.a(this.mData);
    System.arraycopy(paramArrayOfByte, 4, this.mData, 0, 4);
    this.width = MySerialize.a(this.mData);
    System.arraycopy(paramArrayOfByte, 8, this.mData, 0, 4);
    this.height = MySerialize.a(this.mData);
    System.arraycopy(paramArrayOfByte, 12, this.mData, 0, 4);
    this.pitch = MySerialize.a(this.mData);
    System.arraycopy(paramArrayOfByte, 16, this.mData, 0, 1);
    this.bold = MySerialize.a(this.mData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.map.MapEngineCallback.TextBitmapInfo
 * JD-Core Version:    0.7.0.1
 */