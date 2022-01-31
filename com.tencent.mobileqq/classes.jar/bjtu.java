import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditPicSave.2.1;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;

public class bjtu
  extends SimpleObserver<bkld>
{
  bjtu(bjts parambjts) {}
  
  public void a(bkld parambkld)
  {
    super.onNext(parambkld);
    this.a.a(40);
    parambkld = parambkld.a.b;
    ved.b("EditPicSave", "picPath = " + parambkld);
    if (this.a.jdField_a_of_type_Bjyv.getActivity() != null)
    {
      ThreadManager.excute(new EditPicSave.2.1(this, parambkld), 64, this.a.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener, true);
      this.a.jdField_a_of_type_Int = 40;
      this.a.jdField_a_of_type_Boolean = false;
      this.a.b = 10;
      this.a.c();
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    ved.d("EditPicSave", "saveVideo cancel !");
    if (!bjts.a(this.a))
    {
      if (this.a.jdField_a_of_type_Bjxn.a.a() == 14) {
        this.a.jdField_a_of_type_Bjxn.b = false;
      }
      this.a.jdField_a_of_type_Bjxn.a(0);
    }
    this.a.d();
    bcql.a(this.a.jdField_a_of_type_Bjyv.a(), ajya.a(2131703693), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    ved.e("EditPicSave", "saveVideo error ：" + paramError);
    if (!bjts.a(this.a))
    {
      if (this.a.jdField_a_of_type_Bjxn.a.a() == 14) {
        this.a.jdField_a_of_type_Bjxn.b = false;
      }
      this.a.jdField_a_of_type_Bjxn.a(0);
    }
    bcql.a(this.a.jdField_a_of_type_Bjyv.a(), 1, ajya.a(2131703695) + paramError, 0).a();
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjtu
 * JD-Core Version:    0.7.0.1
 */