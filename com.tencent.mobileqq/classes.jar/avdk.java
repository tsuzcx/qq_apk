import android.app.Activity;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

class avdk
  implements avmx
{
  avdk(avdj paramavdj) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      avms localavms = (avms)this.a.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263);
      if (localavms != null) {
        localavms.d(paramString);
      }
      avcw.a(this.a.a.a, paramString);
      if ((this.a.a.a.jdField_a_of_type_AndroidViewView.getContext() instanceof Activity)) {
        ((BaseActivity)this.a.a.a.jdField_a_of_type_AndroidViewView.getContext()).finish();
      }
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, alpo.a(2131708638), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avdk
 * JD-Core Version:    0.7.0.1
 */