package com.tencent.mobileqq.activity.richmedia;

import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;

class NewFlowCameraActivity$26
  extends SosoInterfaceOnLocationListener
{
  NewFlowCameraActivity$26(NewFlowCameraActivity paramNewFlowCameraActivity, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      this.a.a = paramSosoLbsInfo.mLocation.mLat02;
      this.a.b = paramSosoLbsInfo.mLocation.mLon02;
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "onLocationUpdate() latitude=" + this.a.a + " longitude=" + this.a.b);
      }
      if (NewFlowCameraActivity.a(this.a) != null) {
        NewFlowCameraActivity.d(this.a);
      }
    }
    do
    {
      return;
      this.a.a = 0.0D;
      this.a.b = 0.0D;
    } while (!QLog.isColorLevel());
    QLog.d("PTV.NewFlowCameraActivity", 2, "onLocationUpdate() error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.26
 * JD-Core Version:    0.7.0.1
 */