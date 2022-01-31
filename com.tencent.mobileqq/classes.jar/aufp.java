import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;

class aufp
  implements DialogInterface.OnClickListener
{
  aufp(aufi paramaufi) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    azmj.b(this.a.a, "CliOper", "", "", "0X80067F7", "0X80067F7", 0, 0, "", "", "", "");
    if (this.a.c()) {
      aufi.a(this.a).a(false, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aufp
 * JD-Core Version:    0.7.0.1
 */