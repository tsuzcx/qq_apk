import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;

class bipt
  extends akui
{
  bipt(bips parambips, String paramString, boolean paramBoolean)
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
        bips.a(this.a, paramSosoLbsInfo.a);
        double d1 = localSosoLocation.a;
        double d2 = localSosoLocation.b;
        bips.a(this.a, d1, d2);
        return;
      }
      QLog.i("Q.videostory.capture", 2, "LbsManagerService.startLocation: location is null");
      return;
    }
    QLog.i("Q.videostory.capture", 2, "LbsManagerService.startLocation: failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bipt
 * JD-Core Version:    0.7.0.1
 */