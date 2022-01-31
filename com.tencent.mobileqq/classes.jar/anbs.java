import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

final class anbs
  implements DialogInterface.OnClickListener
{
  anbs(QQAppInterface paramQQAppInterface, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    if (paramInt == 1) {
      baoz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, "mvip.n.a.bqsc_aio", 3, "1450000516", "CJCLUBT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131654075), "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anbs
 * JD-Core Version:    0.7.0.1
 */