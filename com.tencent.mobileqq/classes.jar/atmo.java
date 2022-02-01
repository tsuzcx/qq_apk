import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.utils.QQCustomDialog;

class atmo
  implements DialogInterface.OnClickListener
{
  atmo(atmm paramatmm) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      atmm.a(this.a).setIsFirstShowOpenIdMsg(true);
      paramDialogInterface = new Intent(atmm.a(this.a), LoginActivity.class);
      paramDialogInterface.putExtra("is_change_account", true);
      paramDialogInterface = AIOUtils.setOpenAIOIntent(paramDialogInterface, new int[] { 2 });
      paramDialogInterface.putExtra("key_action", atmm.class.getSimpleName());
      paramDialogInterface.putExtra("uin", atmm.a(this.a).curFriendUin);
      paramDialogInterface.putExtra("uintype", atmm.a(this.a).curType);
      paramDialogInterface.putExtra("thridparty_pull_aio", true);
      paramDialogInterface.putExtra("pull_aio_audio", atmm.a(this.a));
      paramDialogInterface.putExtra("pull_aio_video", atmm.b(this.a));
      paramDialogInterface.putExtra("openid", atmm.a(this.a));
      paramDialogInterface.putExtra("appid", atmm.b(this.a));
      paramDialogInterface.putExtra("pull_aio_audio", atmm.a(this.a));
      paramDialogInterface.putExtra("pull_aio_video", atmm.b(this.a));
      paramDialogInterface.putExtra("uinname", atmm.a(this.a).curFriendNick);
      paramDialogInterface.addFlags(268435456);
      paramDialogInterface.addFlags(67108864);
      atmm.a(this.a).dismiss();
      atmm.a(this.a).startActivity(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atmo
 * JD-Core Version:    0.7.0.1
 */