import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.GuardProcessExitListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class bdcu
  extends BroadcastReceiver
{
  bdcu(bdcs parambdcs) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {}
    do
    {
      return;
      if ((paramContext.equals("mqq.intent.action.ACCOUNT_CHANGED")) || (paramContext.equals("mqq.intent.action.ACCOUNT_KICKED")) || (paramContext.equals("mqq.intent.action.ACCOUNT_EXPIRED")) || (paramContext.equals("mqq.intent.action.LOGOUT")))
      {
        if (QLog.isColorLevel()) {
          QLog.e("studyroom.StudyRoomManager", 2, "***exitProcexx*** receive broacast action=" + paramIntent.getAction());
        }
        bdcs.a(this.a).a(false);
        return;
      }
    } while (!paramContext.equals("mqq.intent.action.EXIT_" + MobileQQ.getContext().getPackageName()));
    if (QLog.isColorLevel()) {
      QLog.e("studyroom.StudyRoomManager", 2, "***exitProcexx*** receive broacast action=" + paramIntent.getAction());
    }
    bdcs.a(this.a).a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdcu
 * JD-Core Version:    0.7.0.1
 */