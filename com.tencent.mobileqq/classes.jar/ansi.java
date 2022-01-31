import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

final class ansi
  implements DialogInterface.OnClickListener
{
  ansi(QQAppInterface paramQQAppInterface, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    if (paramInt == 1) {
      bbrk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, "mvip.n.a.bqsc_aio", 3, "1450000516", "CJCLUBT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131719975), "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ansi
 * JD-Core Version:    0.7.0.1
 */