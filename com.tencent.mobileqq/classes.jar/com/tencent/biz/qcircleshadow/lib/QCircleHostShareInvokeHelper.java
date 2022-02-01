package com.tencent.biz.qcircleshadow.lib;

import android.graphics.Bitmap;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleWXShareListener;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import vve;

public class QCircleHostShareInvokeHelper
{
  public static void addWxShareObserver(QCircleWXShareListener paramQCircleWXShareListener)
  {
    vve.a().a(paramQCircleWXShareListener);
  }
  
  public static boolean isWXInstalled()
  {
    return WXShareHelper.a().a();
  }
  
  public static boolean isWXSupportApi()
  {
    return WXShareHelper.a().b();
  }
  
  public static void removeWxShareObserver(QCircleWXShareListener paramQCircleWXShareListener)
  {
    vve.a().b(paramQCircleWXShareListener);
  }
  
  public static void shareQCircleToWX(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4, int paramInt)
  {
    WXShareHelper.a().d(paramString1, paramString2, paramBitmap, paramString3, paramString4, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleHostShareInvokeHelper
 * JD-Core Version:    0.7.0.1
 */