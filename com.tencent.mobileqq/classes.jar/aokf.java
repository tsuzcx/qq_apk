import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilesetting.InterestSwitchEditActivity;
import com.tencent.qphone.base.util.QLog;

public class aokf
  extends aojs
{
  public aokf(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = f();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("OpenOnProfileSettingAction", 1, "doAction error: " + localException.getMessage());
      a("OpenOnProfileSettingAction");
    }
    return false;
  }
  
  public boolean f()
  {
    Intent localIntent = new Intent(this.a, InterestSwitchEditActivity.class);
    localIntent.setFlags(67108864);
    this.a.startActivity(localIntent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aokf
 * JD-Core Version:    0.7.0.1
 */