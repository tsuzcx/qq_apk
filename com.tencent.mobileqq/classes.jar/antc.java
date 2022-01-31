import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.model.lbs.LbsManager;
import com.tencent.biz.qqstory.model.lbs.LbsManager.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoDoodle;

public class antc
  extends LbsManager.OnLocationListener
{
  public antc(EditVideoDoodle paramEditVideoDoodle, String paramString)
  {
    super(paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    super.a(paramInt, paramSosoLbsInfo);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.StoryDoodle", 2, "onLocationUpdate() latitude=" + paramSosoLbsInfo.a.a + " longitude=" + paramSosoLbsInfo.a.b);
      }
      paramSosoLbsInfo = new BasicLocation((int)(paramSosoLbsInfo.a.a * 1000000.0D), (int)(paramSosoLbsInfo.a.b * 1000000.0D));
      ((LbsManager)SuperManager.a(9)).a(paramSosoLbsInfo, null, this.a);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("Q.qqstory.publish.edit.StoryDoodle", 2, "onLocationUpdate() error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     antc
 * JD-Core Version:    0.7.0.1
 */