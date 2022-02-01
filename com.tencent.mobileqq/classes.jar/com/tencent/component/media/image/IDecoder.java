package com.tencent.component.media.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import java.io.File;
import java.io.FileInputStream;

public abstract interface IDecoder
{
  public abstract Bitmap decodeBitmap(File paramFile, int paramInt1, int paramInt2, Bitmap paramBitmap);
  
  public abstract Bitmap decodeFile(File paramFile, BitmapFactory.Options paramOptions);
  
  public abstract BitmapReference decodeImage(File paramFile, BitmapFactory.Options paramOptions);
  
  public abstract BitmapReference decodeImage(FileInputStream paramFileInputStream, BitmapFactory.Options paramOptions);
  
  public abstract BitmapReference decodeImage(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions, int paramInt3, int paramInt4);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.IDecoder
 * JD-Core Version:    0.7.0.1
 */