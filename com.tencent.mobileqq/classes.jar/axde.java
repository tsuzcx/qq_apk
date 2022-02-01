import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;

class axde
  implements DialogInterface.OnClickListener
{
  axde(axcx paramaxcx) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    bdla.b(this.a.a, "CliOper", "", "", "0X80067F7", "0X80067F7", 0, 0, "", "", "", "");
    if (this.a.c()) {
      axcx.a(this.a).setLeftCheckBoxVisible(false, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axde
 * JD-Core Version:    0.7.0.1
 */