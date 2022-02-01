import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;

class aukn
  implements DialogInterface.OnClickListener
{
  aukn(aukj paramaukj) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      ForwardSdkBaseOption.a(aukj.a(this.a), false, "shareToQQ", aukj.a(this.a));
      nmj.a(aukj.a(this.a), 0, "", "");
      if (aukj.a(this.a) != null) {
        aukj.a(this.a).b(1);
      }
      aukj.a(this.a).moveTaskToBack(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aukn
 * JD-Core Version:    0.7.0.1
 */