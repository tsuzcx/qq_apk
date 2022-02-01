import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;

class avcn
  implements DialogInterface.OnClickListener
{
  avcn(avcj paramavcj) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      ForwardSdkBaseOption.a(avcj.a(this.a), false, "shareToQQ", avcj.a(this.a));
      noe.a(avcj.a(this.a), 0, "", "");
      if (avcj.a(this.a) != null) {
        avcj.a(this.a).b(1);
      }
      avcj.a(this.a).moveTaskToBack(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avcn
 * JD-Core Version:    0.7.0.1
 */