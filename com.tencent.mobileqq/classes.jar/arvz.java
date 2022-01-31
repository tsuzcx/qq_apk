import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;

class arvz
  implements DialogInterface.OnClickListener
{
  arvz(arvx paramarvx) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      arvx.a(this.a).k(true);
      paramDialogInterface = new Intent(arvx.a(this.a), LoginActivity.class);
      paramDialogInterface.putExtra("is_change_account", true);
      paramDialogInterface = aekt.a(paramDialogInterface, new int[] { 2 });
      paramDialogInterface.putExtra("key_action", arvx.class.getSimpleName());
      paramDialogInterface.putExtra("uin", arvx.a(this.a).jdField_a_of_type_JavaLangString);
      paramDialogInterface.putExtra("uintype", arvx.a(this.a).jdField_a_of_type_Int);
      paramDialogInterface.putExtra("thridparty_pull_aio", true);
      paramDialogInterface.putExtra("pull_aio_audio", arvx.a(this.a));
      paramDialogInterface.putExtra("pull_aio_video", arvx.b(this.a));
      paramDialogInterface.putExtra("openid", arvx.a(this.a));
      paramDialogInterface.putExtra("appid", arvx.b(this.a));
      paramDialogInterface.putExtra("pull_aio_audio", arvx.a(this.a));
      paramDialogInterface.putExtra("pull_aio_video", arvx.b(this.a));
      paramDialogInterface.putExtra("uinname", arvx.a(this.a).d);
      paramDialogInterface.addFlags(268435456);
      paramDialogInterface.addFlags(67108864);
      arvx.a(this.a).dismiss();
      arvx.a(this.a).startActivity(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arvz
 * JD-Core Version:    0.7.0.1
 */