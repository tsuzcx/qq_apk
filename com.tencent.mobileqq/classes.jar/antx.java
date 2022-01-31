import dov.com.tencent.biz.qqstory.takevideo.EditDoodleExport;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoGuide;

public class antx
  implements Runnable
{
  public antx(EditVideoGuide paramEditVideoGuide) {}
  
  public void run()
  {
    EditDoodleExport localEditDoodleExport = (EditDoodleExport)this.a.a(EditDoodleExport.class);
    if (localEditDoodleExport != null) {
      localEditDoodleExport.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     antx
 * JD-Core Version:    0.7.0.1
 */