package com.tencent.mobileqq.ar.arengine;

import android.os.Handler;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;

class ARCloudControl$7
  extends SosoInterfaceOnLocationListener
{
  ARCloudControl$7(ARCloudControl paramARCloudControl, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    ARCloudControl.f(this.a, false);
    if (ARCloudControl.a(this.a) != null) {
      ARCloudControl.a(this.a).removeMessages(2);
    }
    if (ARCloudControl.a(this.a)) {
      return;
    }
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      paramSosoLbsInfo = paramSosoLbsInfo.mLocation;
      paramInt = (int)(paramSosoLbsInfo.mLat02 * 1000000.0D);
      int i = (int)(paramSosoLbsInfo.mLon02 * 1000000.0D);
      QLog.i("AREngine_ARCloudControl", 1, "GetLBSLocation. onLocationFinish. gps info. Lat_02 = " + paramSosoLbsInfo.mLat02 + ", Lon_02 = " + paramSosoLbsInfo.mLon02 + ", latitude = " + paramInt + ", longitude = " + i + ", altitude = " + paramSosoLbsInfo.altitude + ", accuracy = " + paramSosoLbsInfo.accuracy + ", name = " + paramSosoLbsInfo.name + ", address = " + paramSosoLbsInfo.address);
      paramSosoLbsInfo = ARCloudRecogResult.a(this.a.a.recognitions, ARCloudControl.a(this.a));
      ARCloudControl.a(this.a, paramSosoLbsInfo, paramInt, i);
      return;
    }
    QLog.i("AREngine_ARCloudControl", 1, "GetLBSLocation. onLocationFinish. gps info failed. errCode = " + paramInt);
    paramSosoLbsInfo = new ARCloudLBSLocationCheckResult();
    paramSosoLbsInfo.a = 2;
    ARCloudRecogResult.a(this.a.a.recognitions, ARCloudControl.a(this.a), paramSosoLbsInfo);
    if (ARCloudControl.a(this.a) != null) {
      ARCloudControl.a(this.a).a(0, ARCloudControl.a(this.a));
    }
    ARCloudControl.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.7
 * JD-Core Version:    0.7.0.1
 */