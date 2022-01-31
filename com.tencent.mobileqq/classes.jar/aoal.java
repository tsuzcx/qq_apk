import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditProviderPart;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPoiPickerCallback;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;

public class aoal
  implements EditVideoPoiPickerCallback
{
  public aoal(EditProviderPart paramEditProviderPart) {}
  
  public void a() {}
  
  public void a(TroopBarPOI paramTroopBarPOI)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditProviderPart", 2, "onSelectLocation " + paramTroopBarPOI);
    }
    EditProviderPart.a(this.a).setLocation(paramTroopBarPOI);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoal
 * JD-Core Version:    0.7.0.1
 */