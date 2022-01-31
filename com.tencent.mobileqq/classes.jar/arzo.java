import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;

class arzo
  implements DialogInterface.OnClickListener
{
  arzo(arzk paramarzk) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      aryh.a(arzk.a(this.a), false, "shareToQQ", arzk.a(this.a));
      ndq.a(arzk.a(this.a), 0, "", "");
      if (arzk.a(this.a) != null) {
        arzk.a(this.a).b(1);
      }
      arzk.a(this.a).moveTaskToBack(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arzo
 * JD-Core Version:    0.7.0.1
 */