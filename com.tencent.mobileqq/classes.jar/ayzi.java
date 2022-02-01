import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class ayzi
  implements DialogInterface.OnClickListener
{
  ayzi(ayzg paramayzg) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "onAccoutChangeFailed -> LoginActivity");
    }
    paramDialogInterface = new Intent(ayzg.a(this.a), LoginActivity.class);
    paramDialogInterface.putExtra("is_change_account", true);
    paramDialogInterface.putExtra("uin", ayzg.a(this.a));
    paramDialogInterface.putExtra("befault_uin", ayzg.a(this.a).getCurrentAccountUin());
    ayzg.a(this.a).startActivity(paramDialogInterface);
    ayzg.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayzi
 * JD-Core Version:    0.7.0.1
 */