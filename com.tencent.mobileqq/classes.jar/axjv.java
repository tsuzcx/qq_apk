import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;

class axjv
  implements DialogInterface.OnClickListener
{
  axjv(axjo paramaxjo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    bdll.b(this.a.a, "CliOper", "", "", "0X80067F7", "0X80067F7", 0, 0, "", "", "", "");
    if (this.a.c()) {
      axjo.a(this.a).a(false, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axjv
 * JD-Core Version:    0.7.0.1
 */