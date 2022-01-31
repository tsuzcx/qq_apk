import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;

class asai
  implements DialogInterface.OnClickListener
{
  asai(asag paramasag) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      asag.a(this.a).k(true);
      paramDialogInterface = new Intent(asag.a(this.a), LoginActivity.class);
      paramDialogInterface.putExtra("is_change_account", true);
      paramDialogInterface = aepi.a(paramDialogInterface, new int[] { 2 });
      paramDialogInterface.putExtra("key_action", asag.class.getSimpleName());
      paramDialogInterface.putExtra("uin", asag.a(this.a).jdField_a_of_type_JavaLangString);
      paramDialogInterface.putExtra("uintype", asag.a(this.a).jdField_a_of_type_Int);
      paramDialogInterface.putExtra("thridparty_pull_aio", true);
      paramDialogInterface.putExtra("pull_aio_audio", asag.a(this.a));
      paramDialogInterface.putExtra("pull_aio_video", asag.b(this.a));
      paramDialogInterface.putExtra("openid", asag.a(this.a));
      paramDialogInterface.putExtra("appid", asag.b(this.a));
      paramDialogInterface.putExtra("pull_aio_audio", asag.a(this.a));
      paramDialogInterface.putExtra("pull_aio_video", asag.b(this.a));
      paramDialogInterface.putExtra("uinname", asag.a(this.a).d);
      paramDialogInterface.addFlags(268435456);
      paramDialogInterface.addFlags(67108864);
      asag.a(this.a).dismiss();
      asag.a(this.a).startActivity(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asai
 * JD-Core Version:    0.7.0.1
 */