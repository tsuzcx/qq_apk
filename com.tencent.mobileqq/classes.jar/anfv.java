import android.os.Message;
import dov.com.tencent.biz.qqstory.takevideo.EditMusicExport;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer;

public class anfv
  implements Runnable
{
  public anfv(HWEditImportVideoPlayer paramHWEditImportVideoPlayer) {}
  
  public void run()
  {
    EditMusicExport localEditMusicExport = (EditMusicExport)this.a.a(EditMusicExport.class);
    if (localEditMusicExport != null) {
      localEditMusicExport.aq_();
    }
    this.a.a.a(Message.obtain(null, 14));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anfv
 * JD-Core Version:    0.7.0.1
 */