package com.tencent.biz.qcircleshadow.lib;

import com.qflutter.vistaimage.IVistaImage;
import com.qflutter.vistaimage.IVistaImage.LoadBitmapCallback;
import com.tencent.qphone.base.util.QLog;

public class QCircleSchemeHandler
  implements IVistaImage
{
  public static final String TAG = "QCircleSchemeHandler";
  private IVistaImage impl;
  
  public static QCircleSchemeHandler getInstance()
  {
    return QCircleSchemeHandler.SingleHolder.INSTANCE;
  }
  
  public void attachImpl(IVistaImage paramIVistaImage)
  {
    this.impl = paramIVistaImage;
  }
  
  public void clear()
  {
    IVistaImage localIVistaImage = this.impl;
    if (localIVistaImage != null) {
      localIVistaImage.clear();
    }
  }
  
  public void loadBitmap(String paramString, int paramInt1, int paramInt2, int paramInt3, IVistaImage.LoadBitmapCallback paramLoadBitmapCallback)
  {
    IVistaImage localIVistaImage = this.impl;
    if (localIVistaImage != null)
    {
      localIVistaImage.loadBitmap(paramString, paramInt1, paramInt2, paramInt3, paramLoadBitmapCallback);
      return;
    }
    QLog.e("QCircleSchemeHandler", 1, "no VistaImage implementation attached");
    if (paramLoadBitmapCallback != null) {
      paramLoadBitmapCallback.onFailed(paramString, -1, "no VistaImage implementation attached");
    }
  }
  
  public void releaseBitmap(String paramString)
  {
    IVistaImage localIVistaImage = this.impl;
    if (localIVistaImage != null) {
      localIVistaImage.releaseBitmap(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleSchemeHandler
 * JD-Core Version:    0.7.0.1
 */