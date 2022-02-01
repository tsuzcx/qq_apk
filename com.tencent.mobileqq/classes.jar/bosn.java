import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditPicSave.2.1;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;

public class bosn
  extends SimpleObserver<bpel>
{
  bosn(bosl parambosl) {}
  
  public void a(bpel parambpel)
  {
    super.onNext(parambpel);
    this.a.a(40);
    parambpel = parambpel.a.b;
    ykq.b("EditPicSave", "picPath = " + parambpel);
    if (this.a.jdField_a_of_type_Bouo.getActivity() != null)
    {
      ThreadManager.excute(new EditPicSave.2.1(this, parambpel), 64, this.a.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener, true);
      this.a.jdField_a_of_type_Int = 40;
      this.a.jdField_a_of_type_Boolean = false;
      this.a.b = 10;
      this.a.b();
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    ykq.d("EditPicSave", "saveVideo cancel !");
    if (!bosl.a(this.a))
    {
      if (this.a.jdField_a_of_type_Botw.a.a() == 14) {
        this.a.jdField_a_of_type_Botw.b = false;
      }
      this.a.jdField_a_of_type_Botw.a(0);
    }
    this.a.c();
    QQToast.a(this.a.jdField_a_of_type_Bouo.a(), anvx.a(2131703167), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    ykq.e("EditPicSave", "saveVideo error ：" + paramError);
    if (!bosl.a(this.a))
    {
      if (this.a.jdField_a_of_type_Botw.a.a() == 14) {
        this.a.jdField_a_of_type_Botw.b = false;
      }
      this.a.jdField_a_of_type_Botw.a(0);
    }
    QQToast.a(this.a.jdField_a_of_type_Bouo.a(), 1, anvx.a(2131703169) + paramError, 0).a();
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bosn
 * JD-Core Version:    0.7.0.1
 */