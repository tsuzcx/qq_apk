import com.tencent.biz.qqstory.model.lbs.LbsManager.OnLocationListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import dov.com.qq.im.capture.paster.PasterDataManager;

public class anvk
  extends LbsManager.OnLocationListener
{
  public anvk(PasterDataManager paramPasterDataManager, String paramString, boolean paramBoolean)
  {
    super(paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    super.a(paramInt, paramSosoLbsInfo);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      SLog.b("PasterDataManager", "onLocationUpdate() latitude=" + paramSosoLbsInfo.a.a + " longitude=" + paramSosoLbsInfo.a.b);
      this.jdField_a_of_type_DovComQqImCapturePasterPasterDataManager.b(this.jdField_a_of_type_Boolean);
      return;
    }
    SLog.b("PasterDataManager", "onLocationUpdate() error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anvk
 * JD-Core Version:    0.7.0.1
 */