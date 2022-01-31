import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;

class aqcp
  implements DialogInterface.OnClickListener
{
  aqcp(aqcn paramaqcn) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      aqcn.a(this.a).k(true);
      paramDialogInterface = new Intent(aqcn.a(this.a), LoginActivity.class);
      paramDialogInterface.putExtra("is_change_account", true);
      paramDialogInterface = actn.a(paramDialogInterface, new int[] { 2 });
      paramDialogInterface.putExtra("key_action", aqcn.class.getSimpleName());
      paramDialogInterface.putExtra("uin", aqcn.a(this.a).jdField_a_of_type_JavaLangString);
      paramDialogInterface.putExtra("uintype", aqcn.a(this.a).jdField_a_of_type_Int);
      paramDialogInterface.putExtra("thridparty_pull_aio", true);
      paramDialogInterface.putExtra("pull_aio_audio", aqcn.a(this.a));
      paramDialogInterface.putExtra("pull_aio_video", aqcn.b(this.a));
      paramDialogInterface.putExtra("openid", aqcn.a(this.a));
      paramDialogInterface.putExtra("appid", aqcn.b(this.a));
      paramDialogInterface.putExtra("pull_aio_audio", aqcn.a(this.a));
      paramDialogInterface.putExtra("pull_aio_video", aqcn.b(this.a));
      paramDialogInterface.putExtra("uinname", aqcn.a(this.a).d);
      paramDialogInterface.addFlags(268435456);
      paramDialogInterface.addFlags(67108864);
      aqcn.a(this.a).dismiss();
      aqcn.a(this.a).startActivity(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqcp
 * JD-Core Version:    0.7.0.1
 */