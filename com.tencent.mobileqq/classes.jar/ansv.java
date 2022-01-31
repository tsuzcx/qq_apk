import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoDoodle;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPoiPickerCallback;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;

public class ansv
  implements EditVideoPoiPickerCallback
{
  public ansv(EditVideoDoodle paramEditVideoDoodle) {}
  
  public void a()
  {
    SLog.c("Q.qqstory.publish.edit.StoryDoodle", "onSelectLocationCancel");
  }
  
  public void a(TroopBarPOI paramTroopBarPOI)
  {
    SLog.c("Q.qqstory.publish.edit.StoryDoodle", "onSelectLocation " + paramTroopBarPOI);
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
 * Qualified Name:     ansv
 * JD-Core Version:    0.7.0.1
 */