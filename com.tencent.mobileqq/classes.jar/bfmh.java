import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

final class bfmh
  implements DialogInterface.OnClickListener
{
  bfmh(QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (aoip)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    if ((bhnv.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext())) && (paramDialogInterface != null))
    {
      paramDialogInterface.l(this.jdField_a_of_type_JavaLangString);
      return;
    }
    if (paramDialogInterface != null)
    {
      QQToast.a(BaseApplication.getContext(), 1, anzj.a(2131694008), 0).a();
      return;
    }
    QQToast.a(BaseApplication.getContext(), 1, anzj.a(2131691899), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfmh
 * JD-Core Version:    0.7.0.1
 */