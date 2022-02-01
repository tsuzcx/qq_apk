import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

final class bdvr
  implements DialogInterface.OnClickListener
{
  bdvr(QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (anca)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(20);
    if ((NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext())) && (paramDialogInterface != null))
    {
      paramDialogInterface.l(this.jdField_a_of_type_JavaLangString);
      return;
    }
    if (paramDialogInterface != null)
    {
      QQToast.a(BaseApplication.getContext(), 1, amtj.a(2131694108), 0).a();
      return;
    }
    QQToast.a(BaseApplication.getContext(), 1, amtj.a(2131691945), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdvr
 * JD-Core Version:    0.7.0.1
 */