import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;

class auzk
  implements DialogInterface.OnClickListener
{
  auzk(auzi paramauzi) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      auzi.a(this.a).k(true);
      paramDialogInterface = new Intent(auzi.a(this.a), LoginActivity.class);
      paramDialogInterface.putExtra("is_change_account", true);
      paramDialogInterface = agej.a(paramDialogInterface, new int[] { 2 });
      paramDialogInterface.putExtra("key_action", auzi.class.getSimpleName());
      paramDialogInterface.putExtra("uin", auzi.a(this.a).jdField_a_of_type_JavaLangString);
      paramDialogInterface.putExtra("uintype", auzi.a(this.a).jdField_a_of_type_Int);
      paramDialogInterface.putExtra("thridparty_pull_aio", true);
      paramDialogInterface.putExtra("pull_aio_audio", auzi.a(this.a));
      paramDialogInterface.putExtra("pull_aio_video", auzi.b(this.a));
      paramDialogInterface.putExtra("openid", auzi.a(this.a));
      paramDialogInterface.putExtra("appid", auzi.b(this.a));
      paramDialogInterface.putExtra("pull_aio_audio", auzi.a(this.a));
      paramDialogInterface.putExtra("pull_aio_video", auzi.b(this.a));
      paramDialogInterface.putExtra("uinname", auzi.a(this.a).d);
      paramDialogInterface.addFlags(268435456);
      paramDialogInterface.addFlags(67108864);
      auzi.a(this.a).dismiss();
      auzi.a(this.a).startActivity(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auzk
 * JD-Core Version:    0.7.0.1
 */