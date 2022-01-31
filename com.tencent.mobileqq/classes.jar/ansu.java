import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.QIMCaptureController;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPoiPickerCallback;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;

public class ansu
  implements EditVideoPoiPickerCallback
{
  public ansu(QIMCaptureController paramQIMCaptureController) {}
  
  public void a() {}
  
  public void a(TroopBarPOI paramTroopBarPOI)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CaptureController", 2, "onSelectLocation " + paramTroopBarPOI);
    }
    this.a.a.setLocation(paramTroopBarPOI);
    if (paramTroopBarPOI != null) {}
    for (boolean bool = true;; bool = false)
    {
      dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InfomationFacePackage.b = bool;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ansu
 * JD-Core Version:    0.7.0.1
 */