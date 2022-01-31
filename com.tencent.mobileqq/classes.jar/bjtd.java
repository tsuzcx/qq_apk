import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditPicSave.2.1;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;

public class bjtd
  extends SimpleObserver<bkkm>
{
  bjtd(bjtb parambjtb) {}
  
  public void a(bkkm parambkkm)
  {
    super.onNext(parambkkm);
    this.a.a(40);
    parambkkm = parambkkm.a.b;
    veg.b("EditPicSave", "picPath = " + parambkkm);
    if (this.a.jdField_a_of_type_Bjye.getActivity() != null)
    {
      ThreadManager.excute(new EditPicSave.2.1(this, parambkkm), 64, this.a.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener, true);
      this.a.jdField_a_of_type_Int = 40;
      this.a.jdField_a_of_type_Boolean = false;
      this.a.b = 10;
      this.a.c();
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    veg.d("EditPicSave", "saveVideo cancel !");
    if (!bjtb.a(this.a))
    {
      if (this.a.jdField_a_of_type_Bjww.a.a() == 14) {
        this.a.jdField_a_of_type_Bjww.b = false;
      }
      this.a.jdField_a_of_type_Bjww.a(0);
    }
    this.a.d();
    bcpw.a(this.a.jdField_a_of_type_Bjye.a(), ajyc.a(2131703682), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    veg.e("EditPicSave", "saveVideo error ：" + paramError);
    if (!bjtb.a(this.a))
    {
      if (this.a.jdField_a_of_type_Bjww.a.a() == 14) {
        this.a.jdField_a_of_type_Bjww.b = false;
      }
      this.a.jdField_a_of_type_Bjww.a(0);
    }
    bcpw.a(this.a.jdField_a_of_type_Bjye.a(), 1, ajyc.a(2131703684) + paramError, 0).a();
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjtd
 * JD-Core Version:    0.7.0.1
 */