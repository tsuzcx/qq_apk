package com.tencent.mobileqq.activity.photo;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import bheg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import zdr;

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
    if (this.mHandler != null) {
      this.mHandler.sendEmptyMessage(paramInt);
    }
  }
  
  public void run()
  {
    Object localObject3 = null;
    localObject2 = null;
    boolean bool = false;
    Bitmap localBitmap2;
    try
    {
      localBitmap2 = bheg.a(this.mSrcPath, null);
      if (localBitmap2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoUtils", 2, "decode src is null.");
        }
        sendMsg(1001);
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhotoUtils", 2, "decode src cause oom.");
      }
      sendMsg(1001);
      return;
    }
    int n = localBitmap2.getWidth();
    int m = localBitmap2.getHeight();
    int k = bheg.d(this.mSrcPath);
    if (QLog.isColorLevel()) {
      QLog.d("PhotoUtils", 2, "watermark pic task, w=" + n + ", h=" + m + ", r=" + k);
    }
    Object localObject4 = bheg.a(BaseApplication.getContext().getResources(), 2130845999);
    if (n != 576)
    {
      float f = n / 576.0F;
      localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject4, (int)(((Bitmap)localObject4).getWidth() * f), (int)(f * ((Bitmap)localObject4).getHeight()), true);
      ((Bitmap)localObject4).recycle();
      localObject4 = localObject1;
    }
    while (localObject4 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhotoUtils", 2, "can not load watermark icon.");
      }
      localBitmap2.recycle();
      sendMsg(1001);
      return;
    }
    for (;;)
    {
      try
      {
        localBitmap1 = Bitmap.createBitmap(n, m, Bitmap.Config.ARGB_8888);
        localObject2 = localBitmap1;
        localObject3 = localBitmap1;
        Canvas localCanvas = new Canvas(localBitmap1);
        localObject2 = localBitmap1;
        localObject3 = localBitmap1;
        localCanvas.drawBitmap(localBitmap2, 0.0F, 0.0F, null);
        localObject2 = localBitmap1;
        localObject3 = localBitmap1;
        if ((k / 90 + 1) % 2 != 0) {
          continue;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        localObject2 = localBitmap1;
        localObject3 = localBitmap1;
        j = n - 20 - ((Bitmap)localObject4).getHeight();
        if (i != 0)
        {
          localObject2 = localBitmap1;
          localObject3 = localBitmap1;
          localCanvas.save();
          localObject2 = localBitmap1;
          localObject3 = localBitmap1;
          n /= 2;
          localObject2 = localBitmap1;
          localObject3 = localBitmap1;
          m /= 2;
          localObject2 = localBitmap1;
          localObject3 = localBitmap1;
          localCanvas.rotate(360 - k, n, m);
          localObject2 = localBitmap1;
          localObject3 = localBitmap1;
          localCanvas.translate(n - m, m - n);
        }
        localObject2 = localBitmap1;
        localObject3 = localBitmap1;
        localCanvas.drawBitmap((Bitmap)localObject4, 20.0F, j, null);
        localObject1 = localBitmap1;
        if (i != 0)
        {
          localObject2 = localBitmap1;
          localObject3 = localBitmap1;
          localCanvas.restore();
          localObject1 = localBitmap1;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        Bitmap localBitmap1;
        int j;
        localObject1 = localObject2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("PhotoUtils", 2, localOutOfMemoryError2, new Object[0]);
        localObject1 = localObject2;
        continue;
      }
      catch (Exception localException)
      {
        localObject1 = localOutOfMemoryError2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("PhotoUtils", 2, localException, new Object[0]);
        localObject1 = localOutOfMemoryError2;
        continue;
        int i = 1001;
        continue;
      }
      if (localObject1 != null)
      {
        bool = zdr.a((Bitmap)localObject1, this.mDstPath);
        ((Bitmap)localObject1).recycle();
      }
      localBitmap2.recycle();
      ((Bitmap)localObject4).recycle();
      if (QLog.isColorLevel()) {
        QLog.d("PhotoUtils", 2, "add watermark, result=" + bool);
      }
      if (!bool) {
        continue;
      }
      i = 1000;
      sendMsg(i);
      return;
      i = 0;
      continue;
      localObject2 = localBitmap1;
      localObject3 = localBitmap1;
      j = ((Bitmap)localObject4).getHeight();
      j = m - 20 - j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoUtils.WatermarkPicTask
 * JD-Core Version:    0.7.0.1
 */