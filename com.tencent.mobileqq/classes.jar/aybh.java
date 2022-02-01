import android.app.Activity;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.widget.QQToast;

class aybh
  implements aykx
{
  aybh(aybg paramaybg) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      ayks localayks = (ayks)this.a.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER);
      if (localayks != null) {
        localayks.d(paramString);
      }
      ayat.a(this.a.a.a, paramString);
      if ((this.a.a.a.jdField_a_of_type_AndroidViewView.getContext() instanceof Activity)) {
        ((BaseActivity)this.a.a.a.jdField_a_of_type_AndroidViewView.getContext()).finish();
      }
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, anvx.a(2131707714), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aybh
 * JD-Core Version:    0.7.0.1
 */