import android.app.Activity;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class atmk
  implements atvx
{
  atmk(atmj paramatmj) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      atvs localatvs = (atvs)this.a.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263);
      if (localatvs != null) {
        localatvs.d(paramString);
      }
      atlw.a(this.a.a.a, paramString);
      if ((this.a.a.a.jdField_a_of_type_AndroidViewView.getContext() instanceof Activity)) {
        ((BaseActivity)this.a.a.a.jdField_a_of_type_AndroidViewView.getContext()).finish();
      }
      return;
    }
    bcql.a(BaseApplicationImpl.getContext(), 1, ajya.a(2131708266), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atmk
 * JD-Core Version:    0.7.0.1
 */