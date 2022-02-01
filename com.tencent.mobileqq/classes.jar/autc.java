import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;

class autc
  implements DialogInterface.OnClickListener
{
  autc(ausz paramausz) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      ForwardSdkBaseOption.a(ausz.a(this.a), false, "shareToQQ", ausz.a(this.a));
      nwo.a(ausz.a(this.a), 0, "", "");
      if (ausz.a(this.a) != null) {
        ausz.a(this.a).finish(1);
      }
      ausz.a(this.a).moveTaskToBack(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     autc
 * JD-Core Version:    0.7.0.1
 */