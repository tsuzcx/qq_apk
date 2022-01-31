import com.tencent.biz.qqstory.support.logging.SLog;
import dov.com.tencent.biz.qqstory.takevideo.EditDoodleExport;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.DoodleInfoLoadObserver;

public class anri
  extends PtvTemplateManager.DoodleInfoLoadObserver
{
  public anri(EditPicActivity paramEditPicActivity) {}
  
  public void a()
  {
    SLog.c("EditPicActivity", "DoodleInfoLoadObserver, onLoadSucc");
    EditDoodleExport localEditDoodleExport = (EditDoodleExport)EditPicActivity.a(this.a).a(EditDoodleExport.class);
    if (localEditDoodleExport != null) {
      localEditDoodleExport.az_();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anri
 * JD-Core Version:    0.7.0.1
 */