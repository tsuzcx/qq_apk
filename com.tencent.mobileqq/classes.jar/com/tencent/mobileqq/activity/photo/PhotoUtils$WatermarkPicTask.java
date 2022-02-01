package com.tencent.mobileqq.activity.photo;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class PhotoUtils$WatermarkPicTask
  implements Runnable
{
  public static final int MSG_DONE = 1000;
  public static final int MSG_FAILED = 1001;
  private final String mDstPath;
  private final MqqHandler mHandler;
  private final String mSrcPath;
  
  public PhotoUtils$WatermarkPicTask(String paramString1, String paramString2, MqqHandler paramMqqHandler)
  {
    this.mSrcPath = paramString1;
    this.mDstPath = paramString2;
    this.mHandler = paramMqqHandler;
  }
  
  private void sendMsg(int paramInt)
  {
    MqqHandler localMqqHandler = this.mHandler;
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(paramInt);
    }
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        localBitmap = ImageUtil.a(this.mSrcPath, null);
        if (localBitmap == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoUtils", 2, "decode src is null.");
          }
          sendMsg(1001);
          return;
        }
        i1 = localBitmap.getWidth();
        n = localBitmap.getHeight();
        m = ImageUtil.j(this.mSrcPath);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("watermark pic task, w=");
          ((StringBuilder)localObject1).append(i1);
          ((StringBuilder)localObject1).append(", h=");
          ((StringBuilder)localObject1).append(n);
          ((StringBuilder)localObject1).append(", r=");
          ((StringBuilder)localObject1).append(m);
          QLog.d("PhotoUtils", 2, ((StringBuilder)localObject1).toString());
        }
        localObject1 = ImageUtil.a(BaseApplication.getContext().getResources(), 2130847663);
        i = 1;
        localObject3 = localObject1;
        if (i1 != 576)
        {
          float f = i1 / 576.0F;
          localObject3 = Bitmap.createScaledBitmap((Bitmap)localObject1, (int)(((Bitmap)localObject1).getWidth() * f), (int)(((Bitmap)localObject1).getHeight() * f), true);
          ((Bitmap)localObject1).recycle();
        }
        if (localObject3 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoUtils", 2, "can not load watermark icon.");
          }
          localBitmap.recycle();
          sendMsg(1001);
          return;
        }
        bool = false;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        Bitmap localBitmap;
        int i1;
        int n;
        int m;
        Object localObject1;
        Object localObject3;
        boolean bool;
        Object localObject2;
        continue;
        int i = 0;
        continue;
      }
      try
      {
        localObject1 = Bitmap.createBitmap(i1, n, Bitmap.Config.ARGB_8888);
        try
        {
          Canvas localCanvas = new Canvas((Bitmap)localObject1);
          localCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, null);
          if ((m / 90 + 1) % 2 != 0) {
            continue;
          }
          int j;
          int k;
          if (i != 0)
          {
            j = i1 - 20;
            k = ((Bitmap)localObject3).getHeight();
          }
          else
          {
            j = n - 20;
            k = ((Bitmap)localObject3).getHeight();
          }
          if (i != 0)
          {
            localCanvas.save();
            i1 /= 2;
            n /= 2;
            localCanvas.rotate(360 - m, i1, n);
            localCanvas.translate(i1 - n, n - i1);
          }
          localCanvas.drawBitmap((Bitmap)localObject3, 20.0F, j - k, null);
          localObject2 = localObject1;
          if (i == 0) {
            continue;
          }
          localCanvas.restore();
          localObject2 = localObject1;
        }
        catch (Exception localException1) {}catch (OutOfMemoryError localOutOfMemoryError2) {}
        localObject2 = localObject1;
      }
      catch (Exception localException2)
      {
        localObject1 = null;
        localObject2 = localObject1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("PhotoUtils", 2, localException2, new Object[0]);
        localObject2 = localObject1;
      }
      catch (OutOfMemoryError localOutOfMemoryError3)
      {
        localObject1 = null;
      }
    }
    if (QLog.isColorLevel())
    {
      QLog.e("PhotoUtils", 2, localOutOfMemoryError3, new Object[0]);
      localObject2 = localObject1;
    }
    if (localObject2 != null)
    {
      bool = BitmapUtils.a(localObject2, this.mDstPath);
      localObject2.recycle();
    }
    localBitmap.recycle();
    ((Bitmap)localObject3).recycle();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("add watermark, result=");
      ((StringBuilder)localObject1).append(bool);
      QLog.d("PhotoUtils", 2, ((StringBuilder)localObject1).toString());
    }
    if (bool) {
      i = 1000;
    } else {
      i = 1001;
    }
    sendMsg(i);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("PhotoUtils", 2, "decode src cause oom.");
    }
    sendMsg(1001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoUtils.WatermarkPicTask
 * JD-Core Version:    0.7.0.1
 */