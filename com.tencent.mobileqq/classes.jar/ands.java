import dov.com.tencent.biz.qqstory.takevideo.EditDoodleExport;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoGuide;

public class ands
  implements Runnable
{
  public ands(EditVideoGuide paramEditVideoGuide) {}
  
  public void run()
  {
    EditDoodleExport localEditDoodleExport = (EditDoodleExport)this.a.a(EditDoodleExport.class);
    if (localEditDoodleExport != null) {
      localEditDoodleExport.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ands
 * JD-Core Version:    0.7.0.1
 */