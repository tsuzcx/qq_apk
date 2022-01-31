package com.tencent.biz.pubaccount;

import android.graphics.Bitmap;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import lbx;

public class VideoShareUtils
{
  private static Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    try
    {
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      localBitmap = paramBitmap;
      if (i * j > 8000)
      {
        double d = Math.sqrt(8000.0D / (i * j));
        localBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(i * d), (int)(j * d), true);
      }
    }
    catch (OutOfMemoryError paramBitmap)
    {
      for (;;)
      {
        System.gc();
        paramBitmap.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("VideoShareUtils", 2, "scaleBitmapForWeChat ERROR OutOfMemoryError");
        }
        localBitmap = null;
      }
    }
    catch (Exception paramBitmap)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoShareUtils", 2, "scaleBitmapForWeChat ERROR e=" + paramBitmap.getMessage());
        }
        Bitmap localBitmap = null;
      }
    }
    return localBitmap;
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, int paramInt)
  {
    int k = 0;
    int j = 0;
    if (paramString1 == null) {}
    for (paramBaseActivity = "";; paramBaseActivity = paramString1)
    {
      if (paramString2 == null) {}
      for (paramString1 = "";; paramString1 = paramString2)
      {
        int i;
        if (!WXShareHelper.a().a()) {
          i = 2131435335;
        }
        for (;;)
        {
          if (i != -1)
          {
            QRUtils.a(0, i);
            if (QLog.isColorLevel()) {
              QLog.d("VideoShareUtils", 2, "title=" + paramBaseActivity + ", description=" + paramString1 + ", shareUrl=" + paramString3 + ", action=" + paramInt);
            }
            return;
            if (!WXShareHelper.a().b()) {
              i = 2131435336;
            }
          }
          else
          {
            paramString2 = String.valueOf(System.currentTimeMillis());
            Object localObject = new lbx(paramString2);
            WXShareHelper.a().a((WXShareHelper.WXShareListener)localObject);
            if (ReadInJoyHelper.u(ReadInJoyUtils.a()) == 1)
            {
              localObject = WXShareHelper.a();
              paramBitmap = a(paramBitmap);
              if (paramInt == 9) {}
              for (i = j;; i = 1)
              {
                ((WXShareHelper)localObject).c(paramString2, paramBaseActivity, paramBitmap, paramString1, paramString3, i);
                break;
              }
            }
            localObject = WxShareHelperFromReadInjoy.a();
            paramBitmap = a(paramBitmap);
            if (paramInt == 9) {}
            for (i = k;; i = 1)
            {
              ((WxShareHelperFromReadInjoy)localObject).b(paramString2, paramBaseActivity, paramBitmap, paramString1, paramString3, i);
              break;
            }
          }
          i = -1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoShareUtils
 * JD-Core Version:    0.7.0.1
 */