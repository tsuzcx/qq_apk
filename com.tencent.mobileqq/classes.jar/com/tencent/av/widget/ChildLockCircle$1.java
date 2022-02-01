package com.tencent.av.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.CountDownTimer;
import com.tencent.qphone.base.util.QLog;

class ChildLockCircle$1
  extends CountDownTimer
{
  int a = 1;
  Bitmap b = null;
  Resources c = this.d.getResources();
  
  ChildLockCircle$1(ChildLockCircle paramChildLockCircle, long paramLong1, long paramLong2, Context paramContext)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    Object localObject = this.e;
    ChildLockCircle.a((ChildLockCircle)localObject, ChildLockCircle.e((ChildLockCircle)localObject));
    ChildLockCircle.a(this.e, 0);
    this.e.postInvalidate();
    ChildLockCircle.i(this.e);
    localObject = this.b;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      this.b.recycle();
      this.b = null;
    }
    if (ChildLockCircle.l(this.e) != null)
    {
      ChildLockCircle.l(this.e).cancel();
      ChildLockCircle.a(this.e, null);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChildLockCircle", 2, "LockAnimation,CountDownTimer finish");
    }
  }
  
  public void onTick(long paramLong)
  {
    if (this.d != null)
    {
      this.b = ChildLockCircle.a(this.e, this.c, this.a);
      Object localObject = this.b;
      if (localObject != null)
      {
        ChildLockCircle.a(this.e, (Bitmap)localObject);
        this.e.postInvalidate();
      }
      this.a += 1;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("LockAnimation, i[");
        ((StringBuilder)localObject).append(this.a);
        ((StringBuilder)localObject).append("]");
        QLog.d("ChildLockCircle", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.widget.ChildLockCircle.1
 * JD-Core Version:    0.7.0.1
 */