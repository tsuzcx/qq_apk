import com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

public class bage
  implements QQPermissionCallback
{
  public bage(ProfileCardMoreActivity paramProfileCardMoreActivity1, ProfileCardMoreActivity paramProfileCardMoreActivity2) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("IphoneTitleBarActivity", 1, "User requestPermissions denied...");
    bhdj.a(this.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("IphoneTitleBarActivity", 1, "User requestPermissions grant...");
    this.b.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bage
 * JD-Core Version:    0.7.0.1
 */