import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditPicSave.2.1;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;

public class bicg
  extends SimpleObserver<bitz>
{
  bicg(bice parambice) {}
  
  public void a(bitz parambitz)
  {
    super.onNext(parambitz);
    this.a.a(40);
    parambitz = parambitz.a.b;
    urk.b("EditPicSave", "picPath = " + parambitz);
    if (this.a.jdField_a_of_type_Bihj.getActivity() != null)
    {
      ThreadManager.excute(new EditPicSave.2.1(this, parambitz), 64, this.a.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener, true);
      this.a.jdField_a_of_type_Int = 40;
      this.a.jdField_a_of_type_Boolean = false;
      this.a.b = 10;
      this.a.c();
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    urk.d("EditPicSave", "saveVideo cancel !");
    if (!bice.a(this.a))
    {
      if (this.a.jdField_a_of_type_Bigb.a.a() == 14) {
        this.a.jdField_a_of_type_Bigb.b = false;
      }
      this.a.jdField_a_of_type_Bigb.a(0);
    }
    this.a.d();
    bbmy.a(this.a.jdField_a_of_type_Bihj.a(), ajjy.a(2131637897), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    urk.e("EditPicSave", "saveVideo error ：" + paramError);
    if (!bice.a(this.a))
    {
      if (this.a.jdField_a_of_type_Bigb.a.a() == 14) {
        this.a.jdField_a_of_type_Bigb.b = false;
      }
      this.a.jdField_a_of_type_Bigb.a(0);
    }
    bbmy.a(this.a.jdField_a_of_type_Bihj.a(), 1, ajjy.a(2131637899) + paramError, 0).a();
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bicg
 * JD-Core Version:    0.7.0.1
 */