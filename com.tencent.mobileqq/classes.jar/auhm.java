import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class auhm
  implements DialogInterface.OnClickListener
{
  auhm(auhk paramauhk) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "onAccoutChangeFailed -> LoginActivity");
    }
    paramDialogInterface = new Intent(auhk.a(this.a), LoginActivity.class);
    paramDialogInterface.putExtra("is_change_account", true);
    paramDialogInterface.putExtra("uin", auhk.a(this.a));
    paramDialogInterface.putExtra("befault_uin", auhk.a(this.a).getCurrentAccountUin());
    auhk.a(this.a).startActivity(paramDialogInterface);
    auhk.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auhm
 * JD-Core Version:    0.7.0.1
 */