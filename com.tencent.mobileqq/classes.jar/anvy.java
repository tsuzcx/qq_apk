import dov.com.tencent.biz.qqstory.takevideo.EditMusicExport;
import dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer;

public class anvy
  implements Runnable
{
  public anvy(HWEditImportVideoPlayer paramHWEditImportVideoPlayer) {}
  
  public void run()
  {
    EditMusicExport localEditMusicExport = (EditMusicExport)this.a.a(EditMusicExport.class);
    if (localEditMusicExport != null) {
      localEditMusicExport.as_();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anvy
 * JD-Core Version:    0.7.0.1
 */