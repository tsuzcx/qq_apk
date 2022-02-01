package com.tencent.biz.widgets;

import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IImgProcessApi;
import com.tencent.mobileqq.qrscan.api.IQRCodeApi;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class ScannerView$DecodeHandler
  extends Handler
{
  ScannerView$DecodeHandler(ScannerView paramScannerView, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 5)
    {
      if (i != 6) {
        return;
      }
      if ((paramMessage.obj instanceof Uri)) {
        paramMessage = ((IScanUtilApi)QRoute.api(IScanUtilApi.class)).decodeQRCodeFromFile((Uri)paramMessage.obj, this.a.getContext());
      } else {
        paramMessage = null;
      }
      if (paramMessage != null)
      {
        this.a.u.obtainMessage(3, paramMessage.first).sendToTarget();
        return;
      }
      this.a.u.sendEmptyMessage(4);
      return;
    }
    Object localObject1 = this.a;
    ((ScannerView)localObject1).r += 1L;
    Object localObject3;
    int k;
    int m;
    int j;
    int n;
    label214:
    Object localObject2;
    if ((paramMessage.obj != null) && ((paramMessage.obj instanceof byte[])))
    {
      localObject3 = (byte[])paramMessage.obj;
      i = this.a.p;
      k = 0;
      m = 0;
      j = 0;
      if (i < 3)
      {
        n = localObject3.length;
        i = 0;
        while (i < n)
        {
          if (localObject3[i] != 0)
          {
            i = 1;
            break label214;
          }
          i += 1;
        }
        i = 0;
        if (i != 0)
        {
          this.a.p = 3;
        }
        else
        {
          paramMessage = this.a;
          i = paramMessage.p + 1;
          paramMessage.p = i;
          if (i == 3) {
            this.a.u.sendEmptyMessage(9);
          }
        }
      }
      localObject2 = this.a.e;
      localObject1 = this.a.d;
      paramMessage = (Message)localObject2;
      if (localObject2 == null)
      {
        paramMessage = (Message)localObject1;
        if (localObject1 == null)
        {
          localObject1 = this.a;
          paramMessage = new Rect(0, 0, ((ScannerView)localObject1).k, this.a.l);
          ((ScannerView)localObject1).d = paramMessage;
        }
        float f1;
        float f2;
        if (this.a.m == 90)
        {
          f1 = this.a.g / this.a.l;
          f2 = this.a.h / this.a.k;
          paramMessage = new Rect((int)(paramMessage.top * f1), (int)((this.a.k - paramMessage.right) * f2), (int)(paramMessage.bottom * f1), (int)((this.a.k - paramMessage.left) * f2));
        }
        for (;;)
        {
          break;
          if (this.a.m == 180)
          {
            f1 = this.a.g / this.a.k;
            f2 = this.a.h / this.a.l;
            paramMessage = new Rect((int)((this.a.k - paramMessage.right) * f1), (int)((this.a.l - paramMessage.bottom) * f2), (int)((this.a.k - paramMessage.left) * f1), (int)((this.a.l - paramMessage.top) * f2));
          }
          else if (this.a.m == 270)
          {
            f1 = this.a.g / this.a.l;
            f2 = this.a.h / this.a.k;
            paramMessage = new Rect((int)((this.a.l - paramMessage.bottom) * f1), (int)(paramMessage.left * f2), (int)((this.a.l - paramMessage.top) * f1), (int)(paramMessage.right * f2));
          }
          else
          {
            f1 = this.a.g / this.a.k;
            f2 = this.a.h / this.a.l;
            paramMessage = new Rect((int)(paramMessage.left * f1), (int)(paramMessage.top * f2), (int)(paramMessage.right * f1), (int)(paramMessage.bottom * f2));
          }
        }
        this.a.e = paramMessage;
      }
      try
      {
        l = System.currentTimeMillis();
        localObject2 = new int[2];
        try
        {
          localObject1 = new byte[paramMessage.width() * paramMessage.height() * 3 >> 1];
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          if (!QLog.isColorLevel()) {
            break label1377;
          }
        }
        QLog.w("ScannerView", 2, localOutOfMemoryError.toString());
      }
      catch (UnsatisfiedLinkError paramMessage)
      {
        long l;
        IImgProcessApi localIImgProcessApi;
        int i1;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        j = m;
      }
      if ((localOutOfMemoryError == null) || (this.a.g <= 0) || (this.a.h <= 0) || (paramMessage.left < 0) || (paramMessage.top < 0) || (paramMessage.width() <= 0) || (paramMessage.height() <= 0) || (paramMessage.right > this.a.g) || (paramMessage.bottom > this.a.h) || (localObject3.length != this.a.g * this.a.h * 3 >> 1)) {
        break label1383;
      }
      localIImgProcessApi = (IImgProcessApi)QRoute.api(IImgProcessApi.class);
      n = this.a.g;
      i1 = this.a.h;
      i2 = paramMessage.left;
      i3 = paramMessage.top;
      i4 = paramMessage.width();
      i5 = paramMessage.height();
      i6 = this.a.m;
      i = j;
      j = k;
    }
    for (;;)
    {
      try
      {
        if (localIImgProcessApi.gray_rotate_crop_sub(localOutOfMemoryError, (int[])localObject2, (byte[])localObject3, n, i1, i2, i3, i4, i5, i6, 0) == 0)
        {
          j = k;
          i = ((IQRCodeApi)QRoute.api(IQRCodeApi.class)).scanImageForCamera(localOutOfMemoryError, localObject2[0], localObject2[1]);
        }
        j = i;
        double d = System.currentTimeMillis() - l;
        j = i;
        k = i;
        if (!QLog.isDevelopLevel()) {
          break label1186;
        }
        j = i;
        paramMessage = new StringBuilder();
        j = i;
        paramMessage.append("detect time:");
        j = i;
        paramMessage.append(d);
        j = i;
        QLog.d("ScannerView", 4, paramMessage.toString());
        k = i;
      }
      catch (UnsatisfiedLinkError paramMessage) {}
      k = j;
      if (QLog.isColorLevel())
      {
        QLog.w("ScannerView", 2, paramMessage.toString());
        k = j;
      }
      label1186:
      if (k == 1)
      {
        paramMessage = new StringBuilder();
        localStringBuilder = new StringBuilder();
        ((IQRCodeApi)QRoute.api(IQRCodeApi.class)).getOneResultForCamera(paramMessage, localStringBuilder);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(System.currentTimeMillis() - this.a.q);
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(this.a.r);
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "qrdecode", "decodeSuccess", 0, 0, (String)localObject2, ((StringBuilder)localObject3).toString(), "", "");
        localObject2 = this.a;
        ((ScannerView)localObject2).s = paramMessage;
        ((ScannerView)localObject2).u.obtainMessage(1, localStringBuilder).sendToTarget();
        return;
      }
      this.a.u.sendEmptyMessage(2);
      return;
      this.a.u.sendEmptyMessage(2);
      return;
      label1377:
      StringBuilder localStringBuilder = null;
      break;
      label1383:
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.widgets.ScannerView.DecodeHandler
 * JD-Core Version:    0.7.0.1
 */