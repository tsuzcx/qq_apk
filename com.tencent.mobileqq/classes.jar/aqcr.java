import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;

class aqcr
  implements DialogInterface.OnClickListener
{
  aqcr(aqcp paramaqcp) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      aqcp.a(this.a).k(true);
      paramDialogInterface = new Intent(aqcp.a(this.a), LoginActivity.class);
      paramDialogInterface.putExtra("is_change_account", true);
      paramDialogInterface = actj.a(paramDialogInterface, new int[] { 2 });
      paramDialogInterface.putExtra("key_action", aqcp.class.getSimpleName());
      paramDialogInterface.putExtra("uin", aqcp.a(this.a).jdField_a_of_type_JavaLangString);
      paramDialogInterface.putExtra("uintype", aqcp.a(this.a).jdField_a_of_type_Int);
      paramDialogInterface.putExtra("thridparty_pull_aio", true);
      paramDialogInterface.putExtra("pull_aio_audio", aqcp.a(this.a));
      paramDialogInterface.putExtra("pull_aio_video", aqcp.b(this.a));
      paramDialogInterface.putExtra("openid", aqcp.a(this.a));
      paramDialogInterface.putExtra("appid", aqcp.b(this.a));
      paramDialogInterface.putExtra("pull_aio_audio", aqcp.a(this.a));
      paramDialogInterface.putExtra("pull_aio_video", aqcp.b(this.a));
      paramDialogInterface.putExtra("uinname", aqcp.a(this.a).d);
      paramDialogInterface.addFlags(268435456);
      paramDialogInterface.addFlags(67108864);
      aqcp.a(this.a).dismiss();
      aqcp.a(this.a).startActivity(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqcr
 * JD-Core Version:    0.7.0.1
 */