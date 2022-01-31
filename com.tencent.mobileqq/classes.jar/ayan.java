import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.LoginPhoneNumActivity;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.music.QQPlayerService;
import cooperation.qwallet.plugin.PatternLockUtils;
import mqq.os.MqqHandler;

public class ayan
{
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.getHandler(SubAccountUgActivity.class);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.sendEmptyMessage(1980);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.getHandler(SubAccountBindActivity.class);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.sendEmptyMessageDelayed(1990, paramLong);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (!paramQQAppInterface.isRunning()) || (paramContext.getApplicationContext() == null)) {
      return;
    }
    paramContext = paramContext.getApplicationContext();
    if (QQPlayerService.a())
    {
      Intent localIntent = new Intent();
      localIntent.setAction("qqplayer_exit_action");
      paramContext.sendBroadcast(localIntent);
    }
    PatternLockUtils.setFirstEnterAfterLoginState(paramContext, paramQQAppInterface.getCurrentAccountUin(), true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = new Intent(paramContext, AssociatedAccountActivity.class);
    paramQQAppInterface.putExtra("subAccount", paramString);
    paramContext.startActivity(paramQQAppInterface);
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.getHandler(SubAccountBindActivity.class);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.sendEmptyMessage(1981);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (!paramQQAppInterface.isRunning()) || (paramContext.getApplicationContext() == null)) {
      return;
    }
    paramContext = paramContext.getApplicationContext();
    LoginActivity.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin());
    balq.a();
    aijb.a(true);
    bcxj.a().a(paramQQAppInterface.getCurrentAccountUin());
    PatternLockUtils.setFirstEnterAfterLoginState(paramContext, paramQQAppInterface.getCurrentAccountUin(), true);
    ands.a(paramQQAppInterface, paramContext.getClass(), System.currentTimeMillis(), false);
  }
  
  public static void c(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.getHandler(SubLoginActivity.class);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.sendEmptyMessage(1982);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (!paramQQAppInterface.isRunning()) || (paramContext.getApplicationContext() == null)) {}
    do
    {
      return;
      paramQQAppInterface = paramContext.getApplicationContext();
    } while (!QQPlayerService.a());
    paramContext = new Intent();
    paramContext.setAction("qqplayer_exit_action");
    paramQQAppInterface.sendBroadcast(paramContext);
  }
  
  public static void d(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.getHandler(LoginPhoneNumActivity.class);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.sendEmptyMessage(2014);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayan
 * JD-Core Version:    0.7.0.1
 */