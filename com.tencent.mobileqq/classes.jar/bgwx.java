import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Process;
import com.tencent.qqmini.sdk.log.QMLog;

class bgwx
  implements DialogInterface.OnClickListener
{
  bgwx(bgww parambgww) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a("click");
    paramDialogInterface.dismiss();
    try
    {
      Process.killProcess(Process.myPid());
      return;
    }
    catch (Throwable paramDialogInterface)
    {
      QMLog.e("GameGrowthGuardianManager", "getPositiveDialogAction", paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgwx
 * JD-Core Version:    0.7.0.1
 */