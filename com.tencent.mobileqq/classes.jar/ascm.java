import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;

class ascm
  implements DialogInterface.OnClickListener
{
  ascm(ascj paramascj) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      ascq.a(ascj.a(this.a), false, "shareToQQ", ascj.a(this.a));
      ndq.a(ascj.a(this.a), 0, "", "");
      if (ascj.a(this.a) != null) {
        ascj.a(this.a).b(1);
      }
      ascj.a(this.a).moveTaskToBack(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ascm
 * JD-Core Version:    0.7.0.1
 */