import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;

class aqfz
  implements DialogInterface.OnClickListener
{
  aqfz(aqfv paramaqfv) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      aqes.a(aqfv.a(this.a), false, "shareToQQ", aqfv.a(this.a));
      nau.a(aqfv.a(this.a), 0, "", "");
      if (aqfv.a(this.a) != null) {
        aqfv.a(this.a).b(1);
      }
      aqfv.a(this.a).moveTaskToBack(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqfz
 * JD-Core Version:    0.7.0.1
 */