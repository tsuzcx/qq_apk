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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("GetLBSLocation. onLocationFinish. gps info. Lat_02 = ");
      localStringBuilder.append(paramSosoLbsInfo.mLat02);
      localStringBuilder.append(", Lon_02 = ");
      localStringBuilder.append(paramSosoLbsInfo.mLon02);
      localStringBuilder.append(", latitude = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", longitude = ");
      localStringBuilder.append(i);
      localStringBuilder.append(", altitude = ");
      localStringBuilder.append(paramSosoLbsInfo.altitude);
      localStringBuilder.append(", accuracy = ");
      localStringBuilder.append(paramSosoLbsInfo.accuracy);
      localStringBuilder.append(", name = ");
      localStringBuilder.append(paramSosoLbsInfo.name);
      localStringBuilder.append(", address = ");
      localStringBuilder.append(paramSosoLbsInfo.address);
      QLog.i("AREngine_ARCloudControl", 1, localStringBuilder.toString());
      paramSosoLbsInfo = ARCloudRecogResult.a(this.a.a.recognitions, ARCloudControl.a(this.a));
      ARCloudControl.a(this.a, paramSosoLbsInfo, paramInt, i);
      return;
    }
    paramSosoLbsInfo = new StringBuilder();
    paramSosoLbsInfo.append("GetLBSLocation. onLocationFinish. gps info failed. errCode = ");
    paramSosoLbsInfo.append(paramInt);
    QLog.i("AREngine_ARCloudControl", 1, paramSosoLbsInfo.toString());
    paramSosoLbsInfo = new ARCloudLBSLocationCheckResult();
    paramSosoLbsInfo.a = 2;
    ARCloudRecogResult.a(this.a.a.recognitions, ARCloudControl.a(this.a), paramSosoLbsInfo);
    if (ARCloudControl.a(this.a) != null) {
      ARCloudControl.a(this.a).a(0, ARCloudControl.a(this.a));
    }
    ARCloudControl.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.7
 * JD-Core Version:    0.7.0.1
 */