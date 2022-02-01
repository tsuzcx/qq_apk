import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;

class auje
  implements DialogInterface.OnClickListener
{
  auje(aujb paramaujb) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      ForwardSdkBaseOption.a(aujb.a(this.a), false, "shareToQQ", aujb.a(this.a));
      nmj.a(aujb.a(this.a), 0, "", "");
      if (aujb.a(this.a) != null) {
        aujb.a(this.a).b(1);
      }
      aujb.a(this.a).moveTaskToBack(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auje
 * JD-Core Version:    0.7.0.1
 */