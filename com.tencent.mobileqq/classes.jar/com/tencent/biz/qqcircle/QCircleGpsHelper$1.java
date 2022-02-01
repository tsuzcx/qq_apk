package com.tencent.biz.qqcircle;

import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class QCircleGpsHelper$1
  extends LbsManagerServiceOnLocationChangeListener
{
  QCircleGpsHelper$1(QCircleGpsHelper paramQCircleGpsHelper, String paramString, boolean paramBoolean)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramInt == 0)
    {
      if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
      {
        QCircleGpsHelper.a(this.a, paramSosoLbsInfo);
        return;
      }
      QLog.d("QCircleGpsHelper", 1, "preGetLocation get GpsInfo from request: location is null");
      return;
    }
    QLog.d("QCircleGpsHelper", 1, "preGetLocation get GpsInfo from request: failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCircleGpsHelper.1
 * JD-Core Version:    0.7.0.1
 */