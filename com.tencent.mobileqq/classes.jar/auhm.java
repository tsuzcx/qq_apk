import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;

class auhm
  implements DialogInterface.OnClickListener
{
  auhm(auhk paramauhk) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      auhk.a(this.a).k(true);
      paramDialogInterface = new Intent(auhk.a(this.a), LoginActivity.class);
      paramDialogInterface.putExtra("is_change_account", true);
      paramDialogInterface = afur.a(paramDialogInterface, new int[] { 2 });
      paramDialogInterface.putExtra("key_action", auhk.class.getSimpleName());
      paramDialogInterface.putExtra("uin", auhk.a(this.a).jdField_a_of_type_JavaLangString);
      paramDialogInterface.putExtra("uintype", auhk.a(this.a).jdField_a_of_type_Int);
      paramDialogInterface.putExtra("thridparty_pull_aio", true);
      paramDialogInterface.putExtra("pull_aio_audio", auhk.a(this.a));
      paramDialogInterface.putExtra("pull_aio_video", auhk.b(this.a));
      paramDialogInterface.putExtra("openid", auhk.a(this.a));
      paramDialogInterface.putExtra("appid", auhk.b(this.a));
      paramDialogInterface.putExtra("pull_aio_audio", auhk.a(this.a));
      paramDialogInterface.putExtra("pull_aio_video", auhk.b(this.a));
      paramDialogInterface.putExtra("uinname", auhk.a(this.a).d);
      paramDialogInterface.addFlags(268435456);
      paramDialogInterface.addFlags(67108864);
      auhk.a(this.a).dismiss();
      auhk.a(this.a).startActivity(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auhm
 * JD-Core Version:    0.7.0.1
 */