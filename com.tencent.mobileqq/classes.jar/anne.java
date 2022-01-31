import com.tencent.biz.qqstory.model.lbs.LbsManager.OnLocationListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import dov.com.qq.im.capture.poi.FacePoiManager;
import dov.com.qq.im.capture.poi.FacePoiManager.FacePoiListener;

public class anne
  extends LbsManager.OnLocationListener
{
  public anne(FacePoiManager paramFacePoiManager, String paramString, boolean paramBoolean)
  {
    super(paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    super.a(paramInt, paramSosoLbsInfo);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      this.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager.jdField_a_of_type_Double = paramSosoLbsInfo.a.jdField_a_of_type_Double;
      this.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager.b = paramSosoLbsInfo.a.b;
      SLog.b("FacePoiManager", "onLocationUpdate() latitude=" + this.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager.jdField_a_of_type_Double + " longitude=" + this.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager.b);
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager.a();
      }
      return;
    }
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager.jdField_a_of_type_Double = 0.0D;
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager.b = 0.0D;
    SLog.b("FacePoiManager", "onLocationUpdate() error");
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager$FacePoiListener.a(false, false, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anne
 * JD-Core Version:    0.7.0.1
 */