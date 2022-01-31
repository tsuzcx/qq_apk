import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class bgqn
{
  private static bgqn jdField_a_of_type_Bgqn;
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean = BaseApplicationImpl.getApplication().getSharedPreferences("PackageUpdateManager", 4).getBoolean("HAS_PULL", false);
  private boolean b;
  
  private int a()
  {
    if (this.b) {
      return this.jdField_a_of_type_Int;
    }
    this.b = true;
    long l = a(BaseApplicationImpl.getApplication());
    if (b(BaseApplicationImpl.getApplication()) > l) {}
    for (this.jdField_a_of_type_Int = 1;; this.jdField_a_of_type_Int = 0) {
      return this.jdField_a_of_type_Int;
    }
  }
  
  public static long a(Context paramContext)
  {
    String str = paramContext.getPackageName();
    try
    {
      long l = paramContext.getPackageManager().getPackageInfo(str, 0).firstInstallTime;
      return l;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0L;
  }
  
  public static bgqn a()
  {
    if (jdField_a_of_type_Bgqn == null) {}
    try
    {
      if (jdField_a_of_type_Bgqn == null) {
        jdField_a_of_type_Bgqn = new bgqn();
      }
      return jdField_a_of_type_Bgqn;
    }
    finally {}
  }
  
  private void a()
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("PackageUpdateManager", 4).edit();
    localEditor.putBoolean("HAS_PULL", this.jdField_a_of_type_Boolean);
    localEditor.apply();
  }
  
  public static long b(Context paramContext)
  {
    String str = paramContext.getPackageName();
    try
    {
      long l = paramContext.getPackageManager().getPackageInfo(str, 0).lastUpdateTime;
      return l;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0L;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_Boolean) {
      QLog.d("PackageUpdateManager", 1, "checkUpgrade has pulll");
    }
    while (a() != 1) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    QLog.d("PackageUpdateManager", 1, "checkUpgrade need pull friendlist ");
    ((FriendListHandler)paramQQAppInterface.a(1)).a(true);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgqn
 * JD-Core Version:    0.7.0.1
 */