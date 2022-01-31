import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;

class bkyu
  extends ampn
{
  bkyu(bkyt parambkyt, String paramString, boolean paramBoolean)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramInt == 0)
    {
      if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
      {
        SosoInterface.SosoLocation localSosoLocation = paramSosoLbsInfo.a;
        bkyt.a(this.a, paramSosoLbsInfo.a);
        double d1 = localSosoLocation.a;
        double d2 = localSosoLocation.b;
        bljn.b(bkyt.a(), "LbsManagerService.startLocation: success");
        bkyt.a(this.a, d1, d2);
        return;
      }
      bljn.b(bkyt.a(), "LbsManagerService.startLocation: location is null");
      QLog.i("Q.videostory.capture", 2, "LbsManagerService.startLocation: location is null");
      return;
    }
    bljn.b(bkyt.a(), "LbsManagerService.startLocation: failed");
    bkyt.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkyu
 * JD-Core Version:    0.7.0.1
 */