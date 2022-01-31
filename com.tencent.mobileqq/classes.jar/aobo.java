import com.tencent.biz.qqstory.support.logging.SLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoDoodle;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.DoodleInfoLoadObserver;

public class aobo
  extends PtvTemplateManager.DoodleInfoLoadObserver
{
  public aobo(EditVideoDoodle paramEditVideoDoodle) {}
  
  public void a()
  {
    SLog.c("Q.qqstory.publish.edit.StoryDoodle", "DoodleInfoLoadObserver, onLoadSucc");
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aobo
 * JD-Core Version:    0.7.0.1
 */