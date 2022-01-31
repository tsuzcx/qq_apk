import android.app.Activity;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class asqe
  implements aszr
{
  asqe(asqd paramasqd) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      aszm localaszm = (aszm)this.a.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263);
      if (localaszm != null) {
        localaszm.d(paramString);
      }
      aspq.a(this.a.a.a, paramString);
      if ((this.a.a.a.jdField_a_of_type_AndroidViewView.getContext() instanceof Activity)) {
        ((BaseActivity)this.a.a.a.jdField_a_of_type_AndroidViewView.getContext()).finish();
      }
      return;
    }
    bbmy.a(BaseApplicationImpl.getContext(), 1, ajjy.a(2131642470), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     asqe
 * JD-Core Version:    0.7.0.1
 */