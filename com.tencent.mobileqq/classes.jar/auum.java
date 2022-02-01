import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;

class auum
  implements DialogInterface.OnClickListener
{
  auum(auui paramauui) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      ForwardSdkBaseOption.a(auui.a(this.a), false, "shareToQQ", auui.a(this.a));
      nwo.a(auui.a(this.a), 0, "", "");
      if (auui.a(this.a) != null) {
        auui.a(this.a).finish(1);
      }
      auui.a(this.a).moveTaskToBack(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auum
 * JD-Core Version:    0.7.0.1
 */