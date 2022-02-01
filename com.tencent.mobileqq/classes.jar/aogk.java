import android.os.Handler;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.qphone.base.util.QLog;

class aogk
  extends SosoInterface.OnLocationListener
{
  aogk(aogg paramaogg, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    aogg.f(this.a, false);
    if (aogg.a(this.a) != null) {
      aogg.a(this.a).removeMessages(2);
    }
    if (aogg.a(this.a)) {
      return;
    }
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      paramSosoLbsInfo = paramSosoLbsInfo.mLocation;
      paramInt = (int)(paramSosoLbsInfo.mLat02 * 1000000.0D);
      int i = (int)(paramSosoLbsInfo.mLon02 * 1000000.0D);
      QLog.i("AREngine_ARCloudControl", 1, "GetLBSLocation. onLocationFinish. gps info. Lat_02 = " + paramSosoLbsInfo.mLat02 + ", Lon_02 = " + paramSosoLbsInfo.mLon02 + ", latitude = " + paramInt + ", longitude = " + i + ", altitude = " + paramSosoLbsInfo.altitude + ", accuracy = " + paramSosoLbsInfo.accuracy + ", name = " + paramSosoLbsInfo.name + ", address = " + paramSosoLbsInfo.address);
      paramSosoLbsInfo = aohg.a(this.a.a.recognitions, aogg.a(this.a));
      aogg.a(this.a, paramSosoLbsInfo, paramInt, i);
      return;
    }
    QLog.i("AREngine_ARCloudControl", 1, "GetLBSLocation. onLocationFinish. gps info failed. errCode = " + paramInt);
    paramSosoLbsInfo = new aogo();
    paramSosoLbsInfo.a = 2;
    aohg.a(this.a.a.recognitions, aogg.a(this.a), paramSosoLbsInfo);
    if (aogg.a(this.a) != null) {
      aogg.a(this.a).a(0, aogg.a(this.a));
    }
    aogg.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aogk
 * JD-Core Version:    0.7.0.1
 */