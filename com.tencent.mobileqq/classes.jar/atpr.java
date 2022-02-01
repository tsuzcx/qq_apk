import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;

class atpr
  implements DialogInterface.OnClickListener
{
  atpr(atpn paramatpn) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      ForwardSdkBaseOption.a(atpn.a(this.a), false, "shareToQQ", atpn.a(this.a));
      npn.a(atpn.a(this.a), 0, "", "");
      if (atpn.a(this.a) != null) {
        atpn.a(this.a).finish(1);
      }
      atpn.a(this.a).moveTaskToBack(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atpr
 * JD-Core Version:    0.7.0.1
 */