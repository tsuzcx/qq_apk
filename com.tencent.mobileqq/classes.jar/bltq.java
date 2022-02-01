import com.tencent.mobileqq.app.soso.LbsManagerService.OnLocationChangeListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;

class bltq
  extends LbsManagerService.OnLocationChangeListener
{
  bltq(bltp parambltp, String paramString, boolean paramBoolean)
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
        bltp.a(this.a, paramSosoLbsInfo.mLocation);
        double d1 = localSosoLocation.mLat02;
        double d2 = localSosoLocation.mLon02;
        bmbx.b(bltp.a(), "LbsManagerService.startLocation: success");
        bltp.a(this.a, d1, d2);
        return;
      }
      bmbx.b(bltp.a(), "LbsManagerService.startLocation: location is null");
      QLog.i("Q.videostory.capture", 2, "LbsManagerService.startLocation: location is null");
      return;
    }
    bmbx.b(bltp.a(), "LbsManagerService.startLocation: failed");
    bltp.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bltq
 * JD-Core Version:    0.7.0.1
 */