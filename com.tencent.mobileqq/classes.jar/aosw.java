import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aosw
  extends aouc
{
  public aosw(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = f_();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("AssistantSettingAction", 1, "doAction error: " + localException.getMessage());
      a("AssistantSettingAction");
    }
    return false;
  }
  
  public boolean f_()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.a, AssistantSettingActivity.class);
    this.a.startActivity(localIntent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aosw
 * JD-Core Version:    0.7.0.1
 */