import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditPicSave.2.1;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;

public class bmfe
  extends SimpleObserver<bmwn>
{
  bmfe(bmfc parambmfc) {}
  
  public void a(bmwn parambmwn)
  {
    super.onNext(parambmwn);
    this.a.a(40);
    parambmwn = parambmwn.a.b;
    wsv.b("EditPicSave", "picPath = " + parambmwn);
    if (this.a.jdField_a_of_type_Bmkf.getActivity() != null)
    {
      ThreadManager.excute(new EditPicSave.2.1(this, parambmwn), 64, this.a.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener, true);
      this.a.jdField_a_of_type_Int = 40;
      this.a.jdField_a_of_type_Boolean = false;
      this.a.b = 10;
      this.a.c();
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    wsv.d("EditPicSave", "saveVideo cancel !");
    if (!bmfc.a(this.a))
    {
      if (this.a.jdField_a_of_type_Bmix.a.a() == 14) {
        this.a.jdField_a_of_type_Bmix.b = false;
      }
      this.a.jdField_a_of_type_Bmix.a(0);
    }
    this.a.d();
    QQToast.a(this.a.jdField_a_of_type_Bmkf.a(), alpo.a(2131704065), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    wsv.e("EditPicSave", "saveVideo error ：" + paramError);
    if (!bmfc.a(this.a))
    {
      if (this.a.jdField_a_of_type_Bmix.a.a() == 14) {
        this.a.jdField_a_of_type_Bmix.b = false;
      }
      this.a.jdField_a_of_type_Bmix.a(0);
    }
    QQToast.a(this.a.jdField_a_of_type_Bmkf.a(), 1, alpo.a(2131704067) + paramError, 0).a();
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmfe
 * JD-Core Version:    0.7.0.1
 */