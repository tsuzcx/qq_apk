import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class awtv
  implements DialogInterface.OnClickListener
{
  awtv(awtu paramawtu) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName("com.tencent.tim", "com.tencent.mobileqq.activity.SplashActivity"));
    localIntent.setFlags(268435456);
    awtu.a(this.a).getApp().startActivity(localIntent);
    paramDialogInterface.dismiss();
    bdla.b(awtu.a(this.a), "dc00898", "", "", "0X80085DA", "0X80085DA", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awtv
 * JD-Core Version:    0.7.0.1
 */