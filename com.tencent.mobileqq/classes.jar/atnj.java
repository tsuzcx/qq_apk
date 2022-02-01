import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter.1;
import com.tencent.qphone.base.util.QLog;

public class atnj
  extends BroadcastReceiver
{
  public atnj(OnlineFileSessionCenter.1 param1) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if ((paramContext != null) && (paramContext.equals("com.tencent.mobileqq.intent.logout")))
      {
        if (QLog.isColorLevel()) {
          QLog.i("OnlineFileSessionCenter<FileAssistant>", 2, "OLfilesession[] logout.....!");
        }
        this.a.this$0.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atnj
 * JD-Core Version:    0.7.0.1
 */