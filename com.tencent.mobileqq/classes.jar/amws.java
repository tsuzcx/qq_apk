import com.tencent.biz.qqstory.model.lbs.LbsManager.OnLocationListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import dov.com.qq.im.capture.paster.PasterDataManager;

public class amws
  extends LbsManager.OnLocationListener
{
  public amws(PasterDataManager paramPasterDataManager, String paramString)
  {
    super(paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    super.a(paramInt, paramSosoLbsInfo);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      SLog.b("PasterDataManager", "onLocationUpdate() latitude=" + paramSosoLbsInfo.a.a + " longitude=" + paramSosoLbsInfo.a.b);
      this.a.e();
      return;
    }
    SLog.b("PasterDataManager", "onLocationUpdate() error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     amws
 * JD-Core Version:    0.7.0.1
 */