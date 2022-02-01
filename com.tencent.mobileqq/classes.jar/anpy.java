import android.content.Context;
import com.tencent.avgame.ui.AVGameRoomCenterFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class anpy
  extends anrh
{
  public anpy(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      PublicFragmentActivity.a(this.a, AVGameRoomCenterFragment.class);
      return true;
    }
    catch (Exception localException)
    {
      QLog.e("AVGameShareEntryLobbyAction", 1, "doAction error: " + localException.getMessage());
      a("AVGameShareEntryLobbyAction");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anpy
 * JD-Core Version:    0.7.0.1
 */