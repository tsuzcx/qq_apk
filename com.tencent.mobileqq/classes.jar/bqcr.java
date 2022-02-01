import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditPicSave.2.1;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;

public class bqcr
  extends SimpleObserver<bqua>
{
  bqcr(bqcp parambqcp) {}
  
  public void a(bqua parambqua)
  {
    super.onNext(parambqua);
    this.a.a(40);
    parambqua = parambqua.a.b;
    yuk.b("EditPicSave", "picPath = " + parambqua);
    if (this.a.jdField_a_of_type_Bqhs.getActivity() != null)
    {
      ThreadManager.excute(new EditPicSave.2.1(this, parambqua), 64, this.a.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener, true);
      this.a.jdField_a_of_type_Int = 40;
      this.a.jdField_a_of_type_Boolean = false;
      this.a.b = 10;
      this.a.c();
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    yuk.d("EditPicSave", "saveVideo cancel !");
    if (!bqcp.a(this.a))
    {
      if (this.a.jdField_a_of_type_Bqgk.a.a() == 14) {
        this.a.jdField_a_of_type_Bqgk.b = false;
      }
      this.a.jdField_a_of_type_Bqgk.a(0);
    }
    this.a.d();
    QQToast.a(this.a.jdField_a_of_type_Bqhs.a(), anzj.a(2131702581), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    yuk.e("EditPicSave", "saveVideo error ：" + paramError);
    if (!bqcp.a(this.a))
    {
      if (this.a.jdField_a_of_type_Bqgk.a.a() == 14) {
        this.a.jdField_a_of_type_Bqgk.b = false;
      }
      this.a.jdField_a_of_type_Bqgk.a(0);
    }
    QQToast.a(this.a.jdField_a_of_type_Bqhs.a(), 1, anzj.a(2131702583) + paramError, 0).a();
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqcr
 * JD-Core Version:    0.7.0.1
 */