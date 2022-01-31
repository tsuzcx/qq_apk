import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;

class apmj
  implements DialogInterface.OnClickListener
{
  apmj(apmf paramapmf) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      apld.a(apmf.a(this.a), false, "shareToQQ", apmf.a(this.a));
      mpw.a(apmf.a(this.a), 0, "", "");
      if (apmf.a(this.a) != null) {
        apmf.a(this.a).b(1);
      }
      apmf.a(this.a).moveTaskToBack(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apmj
 * JD-Core Version:    0.7.0.1
 */