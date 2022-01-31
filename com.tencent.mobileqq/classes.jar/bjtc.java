import android.view.View;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import dov.com.tencent.biz.qqstory.takevideo.EditPicSave.1.1;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;

public class bjtc
  implements ThreadExcutor.IThreadListener
{
  bjtc(bjtb parambjtb) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    if ((this.a.jdField_a_of_type_Bjye == null) || (this.a.jdField_a_of_type_Bjye.getActivity() == null)) {
      return;
    }
    this.a.jdField_a_of_type_Bjye.a().postDelayed(new EditPicSave.1.1(this), 500L);
  }
  
  public void onPreRun()
  {
    if (this.a.jdField_a_of_type_Bjww.a.a() == 14) {
      bjtb.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjtc
 * JD-Core Version:    0.7.0.1
 */