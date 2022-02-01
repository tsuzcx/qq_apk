import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qphone.base.util.QLog;

class atkz
  implements DialogInterface.OnClickListener
{
  atkz(atky paramatky) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if (QLog.isColorLevel()) {
        QLog.i("ForwardOption.ForwardBaseOption", 2, "qbShowShareResultDialog back");
      }
      if (!this.a.a.isFinishing()) {
        atky.a(this.a).dismiss();
      }
      this.a.a.finish();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "-->qbShowShareResultDialog--stay");
    }
    this.a.a.finish();
    paramDialogInterface = new Intent(this.a.a, SplashActivity.class);
    paramDialogInterface.addFlags(335544320);
    this.a.a.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atkz
 * JD-Core Version:    0.7.0.1
 */