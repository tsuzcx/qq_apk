import com.tencent.mobileqq.app.soso.LbsManagerService.OnLocationChangeListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;

class bnht
  extends LbsManagerService.OnLocationChangeListener
{
  bnht(bnhs parambnhs, String paramString, boolean paramBoolean)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramInt == 0)
    {
      if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
      {
        SosoInterface.SosoLocation localSosoLocation = paramSosoLbsInfo.mLocation;
        bnhs.a(this.a, paramSosoLbsInfo.mLocation);
        double d1 = localSosoLocation.mLat02;
        double d2 = localSosoLocation.mLon02;
        bnrh.b(bnhs.a(), "LbsManagerService.startLocation: success");
        bnhs.a(this.a, d1, d2);
        return;
      }
      bnrh.b(bnhs.a(), "LbsManagerService.startLocation: location is null");
      QLog.i("Q.videostory.capture", 2, "LbsManagerService.startLocation: location is null");
      return;
    }
    bnrh.b(bnhs.a(), "LbsManagerService.startLocation: failed");
    bnhs.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnht
 * JD-Core Version:    0.7.0.1
 */