import android.view.View;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import dov.com.tencent.biz.qqstory.takevideo.EditPicSave.1.1;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;

public class bicf
  implements ThreadExcutor.IThreadListener
{
  bicf(bice parambice) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    if ((this.a.jdField_a_of_type_Bihj == null) || (this.a.jdField_a_of_type_Bihj.getActivity() == null)) {
      return;
    }
    this.a.jdField_a_of_type_Bihj.a().postDelayed(new EditPicSave.1.1(this), 500L);
  }
  
  public void onPreRun()
  {
    if (this.a.jdField_a_of_type_Bigb.a.a() == 14) {
      bice.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bicf
 * JD-Core Version:    0.7.0.1
 */