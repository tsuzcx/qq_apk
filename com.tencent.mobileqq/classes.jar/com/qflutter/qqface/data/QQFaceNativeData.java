package com.qflutter.qqface.data;

import android.graphics.Bitmap;
import android.text.TextUtils;
import java.io.File;

public class QQFaceNativeData
{
  private Bitmap bitmap;
  public boolean isDefaultFace;
  private String path;
  private byte[] rawData;
  public boolean shareBitmap;
  
  public Bitmap getBitmap()
  {
    return this.bitmap;
  }
  
  public String getPath()
  {
    if ((!TextUtils.isEmpty(this.path)) && (new File(this.path).exists())) {
      return this.path;
    }
    return "";
  }
  
  public byte[] getRawData()
  {
    byte[] arrayOfByte = this.rawData;
    if ((arrayOfByte != null) && (arrayOfByte.length != 0)) {
      return arrayOfByte;
    }
    return null;
  }
  
  public boolean isEmpty()
  {
    return (getBitmap() == null) && (TextUtils.isEmpty(getPath())) && (getRawData() == null);
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    this.bitmap = paramBitmap;
    this.shareBitmap = true;
  }
  
  public void setPath(String paramString)
  {
    this.path = paramString;
  }
  
  public void setRawData(byte[] paramArrayOfByte)
  {
    this.rawData = paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qflutter.qqface.data.QQFaceNativeData
 * JD-Core Version:    0.7.0.1
 */