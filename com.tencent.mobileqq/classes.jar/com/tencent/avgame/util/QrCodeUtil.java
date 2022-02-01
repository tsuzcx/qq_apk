package com.tencent.avgame.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.text.TextUtils;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class QrCodeUtil
{
  private static String a = "QrCodeUtil";
  
  public static Bitmap a(String paramString, int paramInt1, int paramInt2, int paramInt3, Bitmap.Config paramConfig)
  {
    Object localObject;
    int k;
    int m;
    int i;
    int j;
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramInt1 < 0) {
        return null;
      }
      localObject = new HashMap();
      ((Map)localObject).put(EncodeHintType.CHARACTER_SET, "UTF-8");
      ((Map)localObject).put(EncodeHintType.MARGIN, Integer.valueOf(0));
      ((Map)localObject).put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
      try
      {
        paramString = new QRCodeWriter().a(paramString, 0, 0, (Map)localObject);
        if (paramString == null) {
          return null;
        }
        k = paramString.a();
        m = paramString.b();
        localObject = new int[k * m];
        i = 0;
      }
      catch (WriterException paramConfig)
      {
        paramString = null;
        QLog.e(a, 1, "exception when create qr bitmap", paramConfig);
        return paramString;
      }
      catch (OutOfMemoryError paramConfig)
      {
        paramString = null;
      }
      if (j >= k) {
        break label348;
      }
      if (!paramString.a(j, i)) {
        break label327;
      }
      localObject[(i * k + j)] = paramInt2;
      break label339;
    }
    label327:
    label339:
    label348:
    label355:
    for (;;)
    {
      paramString = Bitmap.createBitmap((int[])localObject, k, m, paramConfig);
      paramConfig = paramString;
      if (paramString != null)
      {
        try
        {
          paramConfig = Bitmap.createBitmap(paramInt1, paramInt1, Bitmap.Config.ARGB_8888);
          localObject = new Canvas(paramConfig);
          ((Canvas)localObject).drawBitmap(paramString, new Rect(0, 0, k, m), new Rect(0, 0, paramInt1, paramInt1), null);
          ((Canvas)localObject).setDrawFilter(new PaintFlagsDrawFilter(0, 3));
          return paramConfig;
        }
        catch (WriterException paramConfig) {}catch (OutOfMemoryError paramConfig) {}
        localObject = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("oom when create qr bitmap");
        localStringBuilder.append(paramConfig);
        QLog.e((String)localObject, 1, localStringBuilder.toString());
        paramConfig = paramString;
      }
      return paramConfig;
      return null;
      for (;;)
      {
        if (i >= m) {
          break label355;
        }
        j = 0;
        break;
        localObject[(i * k + j)] = paramInt3;
        j += 1;
        break;
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.util.QrCodeUtil
 * JD-Core Version:    0.7.0.1
 */