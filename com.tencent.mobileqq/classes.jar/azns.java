import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Process;
import com.tencent.mobileqq.startup.step.CheckPermission;
import mqq.app.AppActivity;

public class azns
  implements DialogInterface.OnClickListener
{
  public azns(CheckPermission paramCheckPermission) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if (this.a.checkPermission(CheckPermission.access$000(this.a)))
      {
        CheckPermission.access$002(this.a, null);
        this.a.mDirector.b();
      }
      return;
    }
    CheckPermission.access$000(this.a).superFinish();
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     azns
 * JD-Core Version:    0.7.0.1
 */