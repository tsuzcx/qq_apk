import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class awcy
  implements DialogInterface.OnClickListener
{
  awcy(awcx paramawcx) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "onAccoutChangeFailed -> LoginActivity");
    }
    paramDialogInterface = new Intent(awcx.a(this.a), LoginActivity.class);
    paramDialogInterface.putExtra("is_change_account", true);
    paramDialogInterface.putExtra("uin", awcx.a(this.a));
    paramDialogInterface.putExtra("befault_uin", awcx.a(this.a).getCurrentAccountUin());
    awcx.a(this.a).startActivity(paramDialogInterface);
    awcx.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awcy
 * JD-Core Version:    0.7.0.1
 */