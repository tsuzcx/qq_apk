package com.tencent.mobileqq.activity.aio.helper;

import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class AIOLongShotHelper$MergeBitmapTask
  implements Runnable
{
  private AIOLongShotHelper a;
  private final AtomicBoolean b = new AtomicBoolean();
  
  public AIOLongShotHelper$MergeBitmapTask(AIOLongShotHelper paramAIOLongShotHelper)
  {
    this.a = paramAIOLongShotHelper;
  }
  
  public void a()
  {
    this.b.set(true);
  }
  
  public boolean b()
  {
    return this.b.get();
  }
  
  public void run()
  {
    if (b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOLongShotHelper", 2, "run() isCanceled before mergeBitmaps");
      }
      AIOLongShotHelper.e(this.a);
      AIOLongShotHelper.a(this.a, true, false, null);
      return;
    }
    Bitmap localBitmap = AIOLongShotHelper.f(this.a);
    AIOLongShotHelper.e(this.a);
    if (b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOLongShotHelper", 2, "run() isCanceled before encodeAndWritePNG");
      }
      AIOLongShotHelper.a(this.a, true, false, null);
      return;
    }
    AIOLongShotHelper.a(this.a, localBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper.MergeBitmapTask
 * JD-Core Version:    0.7.0.1
 */