import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditPicSave.2.1;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;

public class bncv
  extends SimpleObserver<bnot>
{
  bncv(bnct parambnct) {}
  
  public void a(bnot parambnot)
  {
    super.onNext(parambnot);
    this.a.a(40);
    parambnot = parambnot.a.b;
    xvv.b("EditPicSave", "picPath = " + parambnot);
    if (this.a.jdField_a_of_type_Bnew.getActivity() != null)
    {
      ThreadManager.excute(new EditPicSave.2.1(this, parambnot), 64, this.a.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener, true);
      this.a.jdField_a_of_type_Int = 40;
      this.a.jdField_a_of_type_Boolean = false;
      this.a.b = 10;
      this.a.b();
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    xvv.d("EditPicSave", "saveVideo cancel !");
    if (!bnct.a(this.a))
    {
      if (this.a.jdField_a_of_type_Bnee.a.a() == 14) {
        this.a.jdField_a_of_type_Bnee.b = false;
      }
      this.a.jdField_a_of_type_Bnee.a(0);
    }
    this.a.c();
    QQToast.a(this.a.jdField_a_of_type_Bnew.a(), amtj.a(2131702816), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    xvv.e("EditPicSave", "saveVideo error ：" + paramError);
    if (!bnct.a(this.a))
    {
      if (this.a.jdField_a_of_type_Bnee.a.a() == 14) {
        this.a.jdField_a_of_type_Bnee.b = false;
      }
      this.a.jdField_a_of_type_Bnee.a(0);
    }
    QQToast.a(this.a.jdField_a_of_type_Bnew.a(), 1, amtj.a(2131702818) + paramError, 0).a();
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bncv
 * JD-Core Version:    0.7.0.1
 */