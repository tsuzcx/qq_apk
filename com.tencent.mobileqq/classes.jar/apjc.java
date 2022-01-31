import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;

class apjc
  implements DialogInterface.OnClickListener
{
  apjc(apja paramapja) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      apja.a(this.a).k(true);
      paramDialogInterface = new Intent(apja.a(this.a), LoginActivity.class);
      paramDialogInterface.putExtra("is_change_account", true);
      paramDialogInterface = aciy.a(paramDialogInterface, new int[] { 2 });
      paramDialogInterface.putExtra("key_action", apja.class.getSimpleName());
      paramDialogInterface.putExtra("uin", apja.a(this.a).jdField_a_of_type_JavaLangString);
      paramDialogInterface.putExtra("uintype", apja.a(this.a).jdField_a_of_type_Int);
      paramDialogInterface.putExtra("thridparty_pull_aio", true);
      paramDialogInterface.putExtra("pull_aio_audio", apja.a(this.a));
      paramDialogInterface.putExtra("pull_aio_video", apja.b(this.a));
      paramDialogInterface.putExtra("openid", apja.a(this.a));
      paramDialogInterface.putExtra("appid", apja.b(this.a));
      paramDialogInterface.putExtra("pull_aio_audio", apja.a(this.a));
      paramDialogInterface.putExtra("pull_aio_video", apja.b(this.a));
      paramDialogInterface.putExtra("uinname", apja.a(this.a).d);
      paramDialogInterface.addFlags(268435456);
      paramDialogInterface.addFlags(67108864);
      apja.a(this.a).dismiss();
      apja.a(this.a).startActivity(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apjc
 * JD-Core Version:    0.7.0.1
 */