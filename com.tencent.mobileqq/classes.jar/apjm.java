import android.os.Handler;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.qphone.base.util.QLog;

class apjm
  extends SosoInterface.OnLocationListener
{
  apjm(apji paramapji, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    apji.f(this.a, false);
    if (apji.a(this.a) != null) {
      apji.a(this.a).removeMessages(2);
    }
    if (apji.a(this.a)) {
      return;
    }
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      paramSosoLbsInfo = paramSosoLbsInfo.mLocation;
      paramInt = (int)(paramSosoLbsInfo.mLat02 * 1000000.0D);
      int i = (int)(paramSosoLbsInfo.mLon02 * 1000000.0D);
      QLog.i("AREngine_ARCloudControl", 1, "GetLBSLocation. onLocationFinish. gps info. Lat_02 = " + paramSosoLbsInfo.mLat02 + ", Lon_02 = " + paramSosoLbsInfo.mLon02 + ", latitude = " + paramInt + ", longitude = " + i + ", altitude = " + paramSosoLbsInfo.altitude + ", accuracy = " + paramSosoLbsInfo.accuracy + ", name = " + paramSosoLbsInfo.name + ", address = " + paramSosoLbsInfo.address);
      paramSosoLbsInfo = apki.a(this.a.a.recognitions, apji.a(this.a));
      apji.a(this.a, paramSosoLbsInfo, paramInt, i);
      return;
    }
    QLog.i("AREngine_ARCloudControl", 1, "GetLBSLocation. onLocationFinish. gps info failed. errCode = " + paramInt);
    paramSosoLbsInfo = new apjq();
    paramSosoLbsInfo.a = 2;
    apki.a(this.a.a.recognitions, apji.a(this.a), paramSosoLbsInfo);
    if (apji.a(this.a) != null) {
      apji.a(this.a).a(0, apji.a(this.a));
    }
    apji.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apjm
 * JD-Core Version:    0.7.0.1
 */