import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.utils.QQCustomDialog;

class aurj
  implements DialogInterface.OnClickListener
{
  aurj(aurh paramaurh) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      aurh.a(this.a).setIsFirstShowOpenIdMsg(true);
      paramDialogInterface = new Intent(aurh.a(this.a), LoginActivity.class);
      paramDialogInterface.putExtra("is_change_account", true);
      paramDialogInterface = AIOUtils.setOpenAIOIntent(paramDialogInterface, new int[] { 2 });
      paramDialogInterface.putExtra("key_action", aurh.class.getSimpleName());
      paramDialogInterface.putExtra("uin", aurh.a(this.a).curFriendUin);
      paramDialogInterface.putExtra("uintype", aurh.a(this.a).curType);
      paramDialogInterface.putExtra("thridparty_pull_aio", true);
      paramDialogInterface.putExtra("pull_aio_audio", aurh.a(this.a));
      paramDialogInterface.putExtra("pull_aio_video", aurh.b(this.a));
      paramDialogInterface.putExtra("openid", aurh.a(this.a));
      paramDialogInterface.putExtra("appid", aurh.b(this.a));
      paramDialogInterface.putExtra("pull_aio_audio", aurh.a(this.a));
      paramDialogInterface.putExtra("pull_aio_video", aurh.b(this.a));
      paramDialogInterface.putExtra("uinname", aurh.a(this.a).curFriendNick);
      paramDialogInterface.addFlags(268435456);
      paramDialogInterface.addFlags(67108864);
      aurh.a(this.a).dismiss();
      aurh.a(this.a).startActivity(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aurj
 * JD-Core Version:    0.7.0.1
 */