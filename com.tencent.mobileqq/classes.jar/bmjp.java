import android.view.View;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import dov.com.tencent.biz.qqstory.takevideo.EditPicSave.1.1;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;

public class bmjp
  implements ThreadExcutor.IThreadListener
{
  bmjp(bmjo parambmjo) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    if ((this.a.jdField_a_of_type_Bmor == null) || (this.a.jdField_a_of_type_Bmor.getActivity() == null)) {
      return;
    }
    this.a.jdField_a_of_type_Bmor.a().postDelayed(new EditPicSave.1.1(this), 500L);
  }
  
  public void onPreRun()
  {
    if (this.a.jdField_a_of_type_Bmnj.a.a() == 14) {
      bmjo.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmjp
 * JD-Core Version:    0.7.0.1
 */