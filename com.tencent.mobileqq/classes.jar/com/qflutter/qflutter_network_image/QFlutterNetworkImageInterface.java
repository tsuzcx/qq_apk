package com.qflutter.qflutter_network_image;

public abstract interface QFlutterNetworkImageInterface
{
  public abstract String getLibPath();
  
  public abstract void loadBitmap(String paramString, int paramInt1, int paramInt2, LoadBitmapCallback paramLoadBitmapCallback);
  
  public abstract void releaseBitmap(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.qflutter_network_image.QFlutterNetworkImageInterface
 * JD-Core Version:    0.7.0.1
 */