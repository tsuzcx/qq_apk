package com.tencent.biz.qqcircle;

import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class QCircleGpsHelper$2
  extends LbsManagerServiceOnLocationChangeListener
{
  QCircleGpsHelper$2(QCircleGpsHelper paramQCircleGpsHelper, String paramString, boolean paramBoolean, WeakReference paramWeakReference)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramInt == 0)
    {
      if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
      {
        QCircleGpsHelper.a(this.b, paramSosoLbsInfo);
        if (this.a.get() != null) {
          ((QCircleGpsHelper.IGetGpsInfoListener)this.a.get()).a(QCircleGpsHelper.a(this.b));
        }
      }
      else
      {
        if (this.a.get() != null) {
          ((QCircleGpsHelper.IGetGpsInfoListener)this.a.get()).bj_();
        }
        QLog.d("QCircleGpsHelper", 1, "getLocationNow get GpsInfo from request: location is null");
      }
    }
    else
    {
      QLog.d("QCircleGpsHelper", 1, "getLocationNow get GpsInfo from request: failed");
      if (this.a.get() != null) {
        ((QCircleGpsHelper.IGetGpsInfoListener)this.a.get()).bj_();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCircleGpsHelper.2
 * JD-Core Version:    0.7.0.1
 */