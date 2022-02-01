package com.tencent.mobileqq.ar.ARPromotion;

import android.content.Context;
import com.tencent.mobileqq.ar.ARRenderModel.SensorTrackManager;
import com.tencent.mobileqq.ar.ARRenderModel.SensorTrackManager.ARSensorTrackCallback;
import com.tencent.qphone.base.util.QLog;

public class ARPhonePoseDetectManager
  implements SensorTrackManager.ARSensorTrackCallback
{
  public static int a = 8;
  private Context b;
  private boolean c = false;
  private SensorTrackManager d;
  private ARPhonePoseDetectManager.PhonePoseDetectListener e;
  private int f = 0;
  private long g = 0L;
  private boolean h = true;
  
  public ARPhonePoseDetectManager(Context paramContext)
  {
    this.b = paramContext;
    this.d = new SensorTrackManager();
  }
  
  private void b(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    if (this.g != 0L)
    {
      long l = System.currentTimeMillis();
      if (l - this.g < 1000L) {
        return;
      }
      this.g = l;
    }
    else
    {
      this.g = System.currentTimeMillis();
    }
    int i;
    if (paramFloat2 > a) {
      i = 1;
    } else {
      i = 2;
    }
    Object localObject;
    if (QLog.isDebugVersion())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ARPhonePoseDetectManager current value:=");
      ((StringBuilder)localObject).append(this.f);
      ((StringBuilder)localObject).append(";nextPhonepose:=");
      ((StringBuilder)localObject).append(i);
      QLog.d("ARPhonePoseDetectManager", 1, ((StringBuilder)localObject).toString());
    }
    if (this.f != i)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("detectPhonePose. data = ");
      ((StringBuilder)localObject).append(paramFloat1);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramFloat2);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramFloat3);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", mPhonePose = ");
      ((StringBuilder)localObject).append(this.f);
      ((StringBuilder)localObject).append(", phonePose = ");
      ((StringBuilder)localObject).append(i);
      QLog.i("ARPhonePoseDetectManager", 1, ((StringBuilder)localObject).toString());
      if ((i == 2) && (this.h)) {
        this.h = false;
      }
      this.f = i;
      localObject = this.e;
      if (localObject != null)
      {
        i = this.f;
        if (i == 1)
        {
          ((ARPhonePoseDetectManager.PhonePoseDetectListener)localObject).a(true);
          return;
        }
        if (i == 2) {
          ((ARPhonePoseDetectManager.PhonePoseDetectListener)localObject).a(false);
        }
      }
    }
  }
  
  public void a()
  {
    if (!this.c)
    {
      this.d.a(this.b, this);
      this.c = true;
      return;
    }
    this.d.c();
    this.f = 0;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    b(paramFloat1, paramFloat2, paramFloat3, paramLong);
  }
  
  public void a(ARPhonePoseDetectManager.PhonePoseDetectListener paramPhonePoseDetectListener)
  {
    this.e = paramPhonePoseDetectListener;
  }
  
  public void a(float[] paramArrayOfFloat) {}
  
  public void b()
  {
    this.d.d();
    this.f = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARPhonePoseDetectManager
 * JD-Core Version:    0.7.0.1
 */