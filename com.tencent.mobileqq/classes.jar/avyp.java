import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class avyp
  implements DialogInterface.OnClickListener
{
  avyp(avyo paramavyo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "onAccoutChangeFailed -> LoginActivity");
    }
    paramDialogInterface = new Intent(avyo.a(this.a), LoginActivity.class);
    paramDialogInterface.putExtra("is_change_account", true);
    paramDialogInterface.putExtra("uin", avyo.a(this.a));
    paramDialogInterface.putExtra("befault_uin", avyo.a(this.a).getCurrentAccountUin());
    avyo.a(this.a).startActivity(paramDialogInterface);
    avyo.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avyp
 * JD-Core Version:    0.7.0.1
 */