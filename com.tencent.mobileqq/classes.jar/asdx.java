import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;

class asdx
  implements DialogInterface.OnClickListener
{
  asdx(asdt paramasdt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      ascq.a(asdt.a(this.a), false, "shareToQQ", asdt.a(this.a));
      ndq.a(asdt.a(this.a), 0, "", "");
      if (asdt.a(this.a) != null) {
        asdt.a(this.a).b(1);
      }
      asdt.a(this.a).moveTaskToBack(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asdx
 * JD-Core Version:    0.7.0.1
 */