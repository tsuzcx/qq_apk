import android.app.Activity;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class atmi
  implements atvv
{
  atmi(atmh paramatmh) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      atvq localatvq = (atvq)this.a.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263);
      if (localatvq != null) {
        localatvq.d(paramString);
      }
      atlu.a(this.a.a.a, paramString);
      if ((this.a.a.a.jdField_a_of_type_AndroidViewView.getContext() instanceof Activity)) {
        ((BaseActivity)this.a.a.a.jdField_a_of_type_AndroidViewView.getContext()).finish();
      }
      return;
    }
    bcpw.a(BaseApplicationImpl.getContext(), 1, ajyc.a(2131708255), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atmi
 * JD-Core Version:    0.7.0.1
 */