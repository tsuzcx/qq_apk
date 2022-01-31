import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qphone.base.util.QLog;

class arun
  implements DialogInterface.OnClickListener
{
  arun(arum paramarum) {}
  
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
        arum.a(this.a).dismiss();
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
 * Qualified Name:     arun
 * JD-Core Version:    0.7.0.1
 */