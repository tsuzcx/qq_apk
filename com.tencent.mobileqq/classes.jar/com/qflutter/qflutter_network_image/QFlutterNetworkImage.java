package com.qflutter.qflutter_network_image;

import com.tencent.nativebmp.NativeBitmap;
import io.flutter.plugin.common.MethodChannel.Result;

public class QFlutterNetworkImage
{
  private QFlutterNetworkImageInterface impl;
  
  public static QFlutterNetworkImage g()
  {
    return QFlutterNetworkImage.Singleton._instance;
  }
  
  public void getNetworkImage(String paramString, int paramInt1, int paramInt2, MethodChannel.Result paramResult)
  {
    if (this.impl == null) {
      return;
    }
    this.impl.loadBitmap(paramString, paramInt1, paramInt2, new QFlutterNetworkImage.1(this, paramResult));
  }
  
  public void init(QFlutterNetworkImageInterface paramQFlutterNetworkImageInterface)
  {
    this.impl = paramQFlutterNetworkImageInterface;
    NativeBitmap.init(this.impl.getLibPath());
  }
  
  public void releaseNetworkImage(String paramString, MethodChannel.Result paramResult)
  {
    if (this.impl == null) {
      return;
    }
    this.impl.releaseBitmap(paramString);
    paramResult.success(Boolean.valueOf(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.qflutter_network_image.QFlutterNetworkImage
 * JD-Core Version:    0.7.0.1
 */