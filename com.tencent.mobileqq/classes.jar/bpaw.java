import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditPicSave.2.1;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;

public class bpaw
  extends SimpleObserver<bpsf>
{
  bpaw(bpau parambpau) {}
  
  public void a(bpsf parambpsf)
  {
    super.onNext(parambpsf);
    this.a.a(40);
    parambpsf = parambpsf.a.b;
    yqp.b("EditPicSave", "picPath = " + parambpsf);
    if (this.a.jdField_a_of_type_Bpfx.getActivity() != null)
    {
      ThreadManager.excute(new EditPicSave.2.1(this, parambpsf), 64, this.a.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener, true);
      this.a.jdField_a_of_type_Int = 40;
      this.a.jdField_a_of_type_Boolean = false;
      this.a.b = 10;
      this.a.c();
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    yqp.d("EditPicSave", "saveVideo cancel !");
    if (!bpau.a(this.a))
    {
      if (this.a.jdField_a_of_type_Bpep.a.a() == 14) {
        this.a.jdField_a_of_type_Bpep.b = false;
      }
      this.a.jdField_a_of_type_Bpep.a(0);
    }
    this.a.d();
    QQToast.a(this.a.jdField_a_of_type_Bpfx.a(), anni.a(2131702474), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    yqp.e("EditPicSave", "saveVideo error ：" + paramError);
    if (!bpau.a(this.a))
    {
      if (this.a.jdField_a_of_type_Bpep.a.a() == 14) {
        this.a.jdField_a_of_type_Bpep.b = false;
      }
      this.a.jdField_a_of_type_Bpep.a(0);
    }
    QQToast.a(this.a.jdField_a_of_type_Bpfx.a(), 1, anni.a(2131702476) + paramError, 0).a();
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpaw
 * JD-Core Version:    0.7.0.1
 */