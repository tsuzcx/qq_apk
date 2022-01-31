import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;

public class bbqo
{
  private static int a;
  
  @Deprecated
  public static void a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatingScreenUtils", 2, "sendWindowClosedBroadcast");
    }
    Intent localIntent = new Intent("tencent.mobileqq.floatingscreen.statuschange");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra("param_curr_window_status", 104);
    paramContext.sendBroadcast(localIntent);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatingScreenUtils", 2, "sendWindowClosedBroadcast");
    }
    Intent localIntent = new Intent("tencent.mobileqq.floatingscreen.statuschange");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra("param_curr_window_status", 104);
    localIntent.putExtra("param_busitype", paramInt);
    paramContext.sendBroadcast(localIntent);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatingScreenUtils", 2, "sendWindowClosedBroadcast");
    }
    Intent localIntent = new Intent("tencent.mobileqq.floatingscreen.statuschange");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra("param_concern_floating_type", paramInt2);
    localIntent.putExtra("param_curr_window_status", 104);
    localIntent.putExtra("param_busitype", paramInt1);
    paramContext.sendBroadcast(localIntent);
  }
  
  @Deprecated
  public static void a(Context paramContext, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatingScreenUtils", 2, new Object[] { "sendWindowVisibleBroadcast:", Boolean.valueOf(paramBoolean) });
    }
    Intent localIntent = new Intent("tencent.mobileqq.floatingscreen.statuschange");
    localIntent.setPackage(paramContext.getPackageName());
    if (paramBoolean) {}
    for (int i = 103;; i = 102)
    {
      localIntent.putExtra("param_curr_window_status", i);
      paramContext.sendBroadcast(localIntent);
      return;
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatingScreenUtils", 2, new Object[] { "sendWindowVisibleBroadcast:", Boolean.valueOf(paramBoolean), " ,busiType:", Integer.valueOf(paramInt) });
    }
    Intent localIntent = new Intent("tencent.mobileqq.floatingscreen.statuschange");
    localIntent.setPackage(paramContext.getPackageName());
    if (paramBoolean) {}
    for (int i = 103;; i = 102)
    {
      localIntent.putExtra("param_curr_window_status", i);
      localIntent.putExtra("param_busitype", paramInt);
      paramContext.sendBroadcast(localIntent);
      return;
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatingScreenUtils", 2, new Object[] { "sendWindowVisibleBroadcast:", Boolean.valueOf(paramBoolean), " ,busiType:", Integer.valueOf(paramInt1) });
    }
    Intent localIntent = new Intent("tencent.mobileqq.floatingscreen.statuschange");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra("param_concern_floating_type", paramInt2);
    if (paramBoolean) {}
    for (paramInt2 = 103;; paramInt2 = 102)
    {
      localIntent.putExtra("param_curr_window_status", paramInt2);
      localIntent.putExtra("param_busitype", paramInt1);
      paramContext.sendBroadcast(localIntent);
      return;
    }
  }
  
  public static boolean a(Context paramContext)
  {
    if (a == 0)
    {
      if ((Build.VERSION.SDK_INT < 26) || (Build.VERSION.SDK_INT >= 28) || (!bjeh.b(paramContext))) {
        break label56;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FloatingScreenUtils", 2, "AndroidO With Notch in Screen.");
      }
    }
    label56:
    for (a = 1; a == 1; a = 2) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbqo
 * JD-Core Version:    0.7.0.1
 */