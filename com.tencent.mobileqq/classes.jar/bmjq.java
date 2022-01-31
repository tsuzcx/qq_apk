import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditPicSave.2.1;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;

public class bmjq
  extends SimpleObserver<bnaz>
{
  bmjq(bmjo parambmjo) {}
  
  public void a(bnaz parambnaz)
  {
    super.onNext(parambnaz);
    this.a.a(40);
    parambnaz = parambnaz.a.b;
    wxe.b("EditPicSave", "picPath = " + parambnaz);
    if (this.a.jdField_a_of_type_Bmor.getActivity() != null)
    {
      ThreadManager.excute(new EditPicSave.2.1(this, parambnaz), 64, this.a.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener, true);
      this.a.jdField_a_of_type_Int = 40;
      this.a.jdField_a_of_type_Boolean = false;
      this.a.b = 10;
      this.a.c();
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    wxe.d("EditPicSave", "saveVideo cancel !");
    if (!bmjo.a(this.a))
    {
      if (this.a.jdField_a_of_type_Bmnj.a.a() == 14) {
        this.a.jdField_a_of_type_Bmnj.b = false;
      }
      this.a.jdField_a_of_type_Bmnj.a(0);
    }
    this.a.d();
    QQToast.a(this.a.jdField_a_of_type_Bmor.a(), alud.a(2131704077), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    wxe.e("EditPicSave", "saveVideo error ：" + paramError);
    if (!bmjo.a(this.a))
    {
      if (this.a.jdField_a_of_type_Bmnj.a.a() == 14) {
        this.a.jdField_a_of_type_Bmnj.b = false;
      }
      this.a.jdField_a_of_type_Bmnj.a(0);
    }
    QQToast.a(this.a.jdField_a_of_type_Bmor.a(), 1, alud.a(2131704079) + paramError, 0).a();
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmjq
 * JD-Core Version:    0.7.0.1
 */