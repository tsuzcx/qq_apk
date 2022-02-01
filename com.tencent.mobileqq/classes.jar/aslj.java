import android.content.DialogInterface.OnDismissListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.math.BigDecimal;
import mqq.app.QQPermissionCallback;

public class aslj
{
  public static String a(int paramInt)
  {
    if (paramInt < 1000) {
      return paramInt + "m";
    }
    float f = new BigDecimal(paramInt / 1000.0F).setScale(1, 1).floatValue();
    return f + "km";
  }
  
  public static void a(BaseActivity paramBaseActivity, QQPermissionCallback paramQQPermissionCallback, int paramInt)
  {
    if ((paramBaseActivity != null) && (paramQQPermissionCallback != null)) {
      paramBaseActivity.requestPermissions(paramQQPermissionCallback, paramInt, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramQQAppInterface != null) {
      bgsg.a(paramQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").edit().putBoolean("sp_extend_friend_signal_guide", paramBoolean).commit();
    }
  }
  
  public static boolean a()
  {
    if ((Build.VERSION.SDK_INT >= 23) && (BaseApplicationImpl.getApplication().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SignalBombHelper", 2, "hasLocationPermission no permission " + Build.VERSION.SDK_INT);
      }
      return false;
    }
    return true;
  }
  
  public static boolean a(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if ((paramBaseActivity != null) && (paramQQAppInterface != null) && (!paramBaseActivity.isFinishing()))
    {
      paramQQAppInterface = (asfu)paramQQAppInterface.getManager(264);
      if (!paramQQAppInterface.j()) {
        break label49;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SignalBombHelper", 2, "checkAndShowSignalBombCardDialogIfNeed waiting");
      }
    }
    label49:
    do
    {
      return false;
      paramQQAppInterface = paramQQAppInterface.a();
    } while (paramQQAppInterface == null);
    if (QLog.isColorLevel()) {
      QLog.d("SignalBombHelper", 2, "checkAndShowSignalBombCardDialogIfNeed show dialog");
    }
    asnv.a(paramBaseActivity, paramQQAppInterface, paramOnDismissListener);
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool = false;
    if (paramQQAppInterface != null) {
      bool = bgsg.a(paramQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").getBoolean("sp_extend_friend_signal_guide", false);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aslj
 * JD-Core Version:    0.7.0.1
 */