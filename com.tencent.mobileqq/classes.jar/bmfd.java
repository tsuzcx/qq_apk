import android.view.View;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import dov.com.tencent.biz.qqstory.takevideo.EditPicSave.1.1;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;

public class bmfd
  implements ThreadExcutor.IThreadListener
{
  bmfd(bmfc parambmfc) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    if ((this.a.jdField_a_of_type_Bmkf == null) || (this.a.jdField_a_of_type_Bmkf.getActivity() == null)) {
      return;
    }
    this.a.jdField_a_of_type_Bmkf.a().postDelayed(new EditPicSave.1.1(this), 500L);
  }
  
  public void onPreRun()
  {
    if (this.a.jdField_a_of_type_Bmix.a.a() == 14) {
      bmfc.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmfd
 * JD-Core Version:    0.7.0.1
 */