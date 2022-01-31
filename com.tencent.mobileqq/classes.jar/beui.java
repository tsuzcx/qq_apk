import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Process;

class beui
  implements DialogInterface.OnClickListener
{
  beui(beuh parambeuh) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beui
 * JD-Core Version:    0.7.0.1
 */