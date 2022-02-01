import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

final class bfcv
  implements DialogInterface.OnClickListener
{
  bfcv(QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    if ((NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext())) && (paramDialogInterface != null))
    {
      paramDialogInterface.k(this.jdField_a_of_type_JavaLangString);
      return;
    }
    if (paramDialogInterface != null)
    {
      QQToast.a(BaseApplication.getContext(), 1, anvx.a(2131694305), 0).a();
      return;
    }
    QQToast.a(BaseApplication.getContext(), 1, anvx.a(2131692035), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfcv
 * JD-Core Version:    0.7.0.1
 */