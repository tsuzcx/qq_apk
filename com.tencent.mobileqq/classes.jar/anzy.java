import android.view.View;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import dov.com.tencent.biz.qqstory.takevideo.EditPicSave;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoUi;

public class anzy
  implements ThreadExcutor.IThreadListener
{
  public anzy(EditPicSave paramEditPicSave) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    this.a.a.a().postDelayed(new anzz(this), 500L);
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anzy
 * JD-Core Version:    0.7.0.1
 */