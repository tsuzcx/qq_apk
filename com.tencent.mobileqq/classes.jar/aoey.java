import dov.com.tencent.biz.qqstory.takevideo.EditMusicExport;
import dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer;

public class aoey
  implements Runnable
{
  public aoey(HWEditLocalVideoPlayer paramHWEditLocalVideoPlayer) {}
  
  public void run()
  {
    EditMusicExport localEditMusicExport = (EditMusicExport)this.a.a(EditMusicExport.class);
    if (localEditMusicExport != null) {
      localEditMusicExport.au_();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoey
 * JD-Core Version:    0.7.0.1
 */