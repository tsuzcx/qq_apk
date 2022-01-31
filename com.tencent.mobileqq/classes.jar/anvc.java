import com.tencent.mobileqq.statistics.QIMReportController;
import com.tencent.mobileqq.statistics.reportitem.QIMReadWriteReportItem;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import dov.com.tencent.mobileqq.richmedia.capture.activity.EditWebDanceMachineVideoActivity;

public class anvc
  extends EditVideoPartManager
{
  public anvc(EditWebDanceMachineVideoActivity paramEditWebDanceMachineVideoActivity) {}
  
  protected void b()
  {
    super.b();
    if ((EditWebDanceMachineVideoActivity.a(this.a)) || (EditWebDanceMachineVideoActivity.b(this.a)))
    {
      QIMReadWriteReportItem localQIMReadWriteReportItem = new QIMReadWriteReportItem();
      localQIMReadWriteReportItem.d = "0X800903D";
      QIMReportController.b(null, localQIMReadWriteReportItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anvc
 * JD-Core Version:    0.7.0.1
 */