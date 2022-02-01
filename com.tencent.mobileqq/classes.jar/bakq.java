import com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

public class bakq
  implements QQPermissionCallback
{
  public bakq(ProfileCardMoreActivity paramProfileCardMoreActivity1, ProfileCardMoreActivity paramProfileCardMoreActivity2) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("IphoneTitleBarActivity", 1, "User requestPermissions denied...");
    bhlq.a(this.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("IphoneTitleBarActivity", 1, "User requestPermissions grant...");
    this.b.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bakq
 * JD-Core Version:    0.7.0.1
 */