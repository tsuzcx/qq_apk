import android.content.Context;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class apad
  extends aoxg
{
  public apad(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private void d()
  {
    String str = b("buddyuin");
    if (!str.isEmpty())
    {
      long l = Long.parseLong(str);
      if (QLog.isColorLevel()) {
        QLog.d("TroopOneWayAction", 2, "grayTip,openTroopWithCommonFriendsFragment:" + l);
      }
      TroopWithCommonFriendsFragment.a(str);
      TroopWithCommonFriendsFragment.a(this.a, 1);
      bdll.b(null, "dc00898", "", "", "0X800AD20", "0X800AD20", 0, 0, "0", "0", "", "");
    }
  }
  
  public boolean a()
  {
    try
    {
      d();
      return true;
    }
    catch (Exception localException)
    {
      QLog.e("TroopOneWayAction", 1, "doAction error: " + localException.getMessage());
      a("TroopOneWayAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apad
 * JD-Core Version:    0.7.0.1
 */