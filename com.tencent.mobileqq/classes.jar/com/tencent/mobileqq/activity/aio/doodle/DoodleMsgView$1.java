package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import com.tencent.qphone.base.util.QLog;

class DoodleMsgView$1
  implements DoodleDrawer.DoodleDrawerListener
{
  DoodleMsgView$1(DoodleMsgView paramDoodleMsgView) {}
  
  public void a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDataState:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" - ");
    localStringBuilder.append(paramString);
    QLog.d("DoodleMsgView", 2, localStringBuilder.toString());
    this.a.a(new DoodleMsgView.1.2(this, paramInt));
  }
  
  public void a(String arg1, long paramLong, Bitmap paramBitmap)
  {
    if (DoodleMsgView.a(this.a) == null) {
      return;
    }
    if (paramBitmap != null)
    {
      if (DoodleMsgView.a(this.a, paramBitmap.getWidth(), paramBitmap.getHeight()))
      {
        if (DoodleMsgView.b(this.a) == null)
        {
          DoodleMsgView.a(this.a, new Paint());
          DoodleMsgView.b(this.a).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
          DoodleMsgView.b(this.a).setAntiAlias(true);
        }
        synchronized (this.a)
        {
          DoodleMsgView.d(this.a).drawBitmap(paramBitmap, new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight()), new Rect(0, 0, DoodleMsgView.c(this.a).getWidth(), DoodleMsgView.c(this.a).getHeight()), DoodleMsgView.b(this.a));
        }
      }
      this.a.postInvalidate();
    }
    if ((DoodleMsgView.e(this.a)) && (paramLong >= DoodleMsgView.a(this.a).f()) && (DoodleMsgView.f(this.a) >= DoodleMsgView.a(this.a).f()))
    {
      this.a.d();
      this.a.a(new DoodleMsgView.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleMsgView.1
 * JD-Core Version:    0.7.0.1
 */