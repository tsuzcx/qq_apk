import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;

class aqfx
  implements DialogInterface.OnClickListener
{
  aqfx(aqft paramaqft) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      aqeq.a(aqft.a(this.a), false, "shareToQQ", aqft.a(this.a));
      nax.a(aqft.a(this.a), 0, "", "");
      if (aqft.a(this.a) != null) {
        aqft.a(this.a).b(1);
      }
      aqft.a(this.a).moveTaskToBack(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqfx
 * JD-Core Version:    0.7.0.1
 */