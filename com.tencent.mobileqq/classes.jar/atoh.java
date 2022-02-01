import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;

class atoh
  implements DialogInterface.OnClickListener
{
  atoh(atoe paramatoe) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      ForwardSdkBaseOption.a(atoe.a(this.a), false, "shareToQQ", atoe.a(this.a));
      npn.a(atoe.a(this.a), 0, "", "");
      if (atoe.a(this.a) != null) {
        atoe.a(this.a).finish(1);
      }
      atoe.a(this.a).moveTaskToBack(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atoh
 * JD-Core Version:    0.7.0.1
 */