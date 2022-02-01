package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.os.Handler;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;

class LBSDetetor$LBSLocationListener
  extends SosoInterfaceOnLocationListener
{
  private int b = -1;
  
  public LBSDetetor$LBSLocationListener(LBSDetetor paramLBSDetetor, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString, int paramInt2)
  {
    super(paramInt1, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
    this.b = paramInt2;
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      double d1 = paramSosoLbsInfo.mLocation.mLat02;
      double d2 = paramSosoLbsInfo.mLocation.mLon02;
      if (QLog.isColorLevel())
      {
        paramSosoLbsInfo = new StringBuilder();
        paramSosoLbsInfo.append("onLocationUpdate() latitude=");
        paramSosoLbsInfo.append(d1);
        paramSosoLbsInfo.append(" longitude=");
        paramSosoLbsInfo.append(d2);
        QLog.d("LBSDetetor", 2, paramSosoLbsInfo.toString());
      }
      LBSDetetor.a(this.a, d1, d2, this.b);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LBSDetetor", 2, "onLocationUpdate() error");
    }
    if ((LBSDetetor.a(this.a) != null) && (LBSDetetor.a(this.a).hasMessages(this.b))) {
      LBSDetetor.a(this.a, false, null, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.LBSDetetor.LBSLocationListener
 * JD-Core Version:    0.7.0.1
 */