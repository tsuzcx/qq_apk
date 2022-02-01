package com.tencent.biz.qcircleshadow.lib;

import android.graphics.Bitmap;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleWXShareListener;
import com.tencent.biz.qcircleshadow.libmanager.QCircleListenerProxyManager;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.wxapi.api.IWXShareHelper;

public class QCircleHostShareInvokeHelper
{
  public static void addWxShareObserver(QCircleWXShareListener paramQCircleWXShareListener)
  {
    QCircleListenerProxyManager.getInstance().addQCircleWXShareListener(paramQCircleWXShareListener);
  }
  
  public static boolean isWXInstalled()
  {
    return QCircleServiceImpl.getWXShareHelper().isWXInstalled();
  }
  
  public static boolean isWXSupportApi()
  {
    return QCircleServiceImpl.getWXShareHelper().isWXsupportApi();
  }
  
  public static void removeWxShareObserver(QCircleWXShareListener paramQCircleWXShareListener)
  {
    QCircleListenerProxyManager.getInstance().removeQCircleWXShareListener(paramQCircleWXShareListener);
  }
  
  public static void shareQCircleToWX(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4, int paramInt)
  {
    QCircleServiceImpl.getWXShareHelper().shareQcircleToWX(paramString1, paramString2, paramBitmap, paramString3, paramString4, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleHostShareInvokeHelper
 * JD-Core Version:    0.7.0.1
 */