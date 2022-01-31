import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Process;
import com.tencent.qqmini.sdk.log.QMLog;

class bgsv
  implements DialogInterface.OnClickListener
{
  bgsv(bgsu parambgsu) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a("off_click");
    paramDialogInterface.dismiss();
    try
    {
      Process.killProcess(Process.myPid());
      return;
    }
    catch (Throwable paramDialogInterface)
    {
      QMLog.e("GameGrowthGuardianManager", "getNegativeDialogAction", paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgsv
 * JD-Core Version:    0.7.0.1
 */