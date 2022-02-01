package com.tencent.biz.qcircleshadow.lib;

import android.graphics.Bitmap;
import com.tencent.mobileqq.wxapi.WXShareHelper;

public class QCircleHostShareInvokeHelper
{
  public static void shareQCircleToWX(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4, int paramInt)
  {
    WXShareHelper.getInstance().shareQcircleToWX(paramString1, paramString2, paramBitmap, paramString3, paramString4, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleHostShareInvokeHelper
 * JD-Core Version:    0.7.0.1
 */