import QQService.DeviceItemDes;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.DevlockQuickLoginActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.VerifyDevLockManager;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;

public class aoen
{
  private static aoen jdField_a_of_type_Aoen;
  public static boolean a;
  private static byte[] jdField_b_of_type_ArrayOfByte = new byte[0];
  private int jdField_a_of_type_Int = -1;
  Runnable jdField_a_of_type_JavaLangRunnable = new EquipmentLockImpl.1(this);
  String jdField_a_of_type_JavaLangString = null;
  private ArrayList<airj> jdField_a_of_type_JavaUtilArrayList;
  private Map<Integer, Handler> jdField_a_of_type_JavaUtilMap = new HashMap();
  byte[] jdField_a_of_type_ArrayOfByte = null;
  String jdField_b_of_type_JavaLangString = null;
  private boolean jdField_b_of_type_Boolean = true;
  String jdField_c_of_type_JavaLangString = null;
  private boolean jdField_c_of_type_Boolean = true;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private String e;
  private String f = "Manually";
  
  public static aoen a()
  {
    if (jdField_a_of_type_Aoen == null) {}
    synchronized (jdField_b_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Aoen == null) {
        jdField_a_of_type_Aoen = new aoen();
      }
      return jdField_a_of_type_Aoen;
    }
  }
  
  public int a(AppInterface paramAppInterface, String paramString, WtloginObserver paramWtloginObserver)
  {
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return -1;
    }
    int i = AppSetting.a();
    paramAppInterface = (WtloginManager)paramAppInterface.getManager(1);
    if (paramAppInterface == null) {
      return -1;
    }
    return paramAppInterface.CheckDevLockStatus(paramString, i, paramWtloginObserver);
  }
  
  public int a(AppInterface paramAppInterface, VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver)
  {
    if (paramAppInterface == null) {
      return -1;
    }
    paramAppInterface = (VerifyDevLockManager)paramAppInterface.getManager(7);
    if (paramAppInterface == null) {
      return -1;
    }
    paramAppInterface.cancelVerify(paramVerifyDevLockObserver);
    return 0;
  }
  
  public int a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramContext == null) || (paramQQAppInterface == null)) {}
    do
    {
      do
      {
        return -1;
        paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
      } while (TextUtils.isEmpty(paramQQAppInterface));
      if ((!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (!this.jdField_d_of_type_JavaLangString.equalsIgnoreCase(paramQQAppInterface)))
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_Int = -1;
      }
      if (!this.jdField_b_of_type_Boolean) {
        break;
      }
      this.jdField_b_of_type_Boolean = false;
      paramContext = paramContext.getSharedPreferences("devlock_sharedpref", 0);
    } while (paramContext == null);
    this.jdField_a_of_type_Int = paramContext.getInt("devlock_status" + paramQQAppInterface, -1);
    this.jdField_d_of_type_JavaLangString = paramQQAppInterface;
    return this.jdField_a_of_type_Int;
  }
  
  public int a(QQAppInterface paramQQAppInterface, String paramString, WtloginObserver paramWtloginObserver)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return -1;
    }
    paramQQAppInterface = (WtloginManager)paramQQAppInterface.getManager(1);
    if (paramQQAppInterface == null) {
      return -1;
    }
    return paramQQAppInterface.CloseDevLock(paramString, AppSetting.a(), paramWtloginObserver);
  }
  
  public int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    this.e = paramString;
    return 0;
  }
  
  public int a(AppRuntime paramAppRuntime, Context paramContext, String paramString, boolean paramBoolean)
  {
    if ((paramContext == null) || (paramAppRuntime == null)) {}
    do
    {
      do
      {
        return -1;
      } while (TextUtils.isEmpty(paramString));
      paramContext = paramContext.getSharedPreferences("devlock_sharedpref", 0);
    } while (paramContext == null);
    paramAppRuntime = paramAppRuntime.getAccount();
    if (paramBoolean)
    {
      paramContext.edit().putInt("devlock_status" + paramString, 0).commit();
      if (paramString.equalsIgnoreCase(paramAppRuntime)) {
        this.jdField_a_of_type_Int = 0;
      }
    }
    for (;;)
    {
      return 0;
      paramContext.edit().putInt("devlock_status" + paramString, 1).commit();
      if (paramString.equalsIgnoreCase(paramAppRuntime)) {
        this.jdField_a_of_type_Int = 1;
      }
    }
  }
  
  public int a(AppRuntime paramAppRuntime, String paramString1, String paramString2, byte[] paramArrayOfByte, WtloginObserver paramWtloginObserver)
  {
    if ((paramAppRuntime == null) || (TextUtils.isEmpty(paramString1))) {
      return -1;
    }
    paramAppRuntime = (WtloginManager)paramAppRuntime.getManager(1);
    if (paramAppRuntime == null) {
      return -1;
    }
    return paramAppRuntime.CheckDevLockSms(paramString1, AppSetting.a(), paramString2, paramArrayOfByte, paramWtloginObserver);
  }
  
  public int a(AppRuntime paramAppRuntime, String paramString, WtloginObserver paramWtloginObserver)
  {
    if ((paramAppRuntime == null) || (TextUtils.isEmpty(paramString))) {
      return -1;
    }
    paramAppRuntime = (WtloginManager)paramAppRuntime.getManager(1);
    if (paramAppRuntime == null) {
      return -1;
    }
    return paramAppRuntime.AskDevLockSms(paramString, paramWtloginObserver);
  }
  
  public int a(AppRuntime paramAppRuntime, VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver)
  {
    if (paramAppRuntime == null) {
      return -1;
    }
    paramAppRuntime = (VerifyDevLockManager)paramAppRuntime.getManager(7);
    if (paramAppRuntime == null) {
      return -1;
    }
    paramAppRuntime.refreshDevLockSms(paramVerifyDevLockObserver);
    return 0;
  }
  
  public int a(AppRuntime paramAppRuntime, VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver, String paramString)
  {
    if (paramAppRuntime == null) {
      return -1;
    }
    paramAppRuntime = (VerifyDevLockManager)paramAppRuntime.getManager(7);
    if (paramAppRuntime == null) {
      return -1;
    }
    paramAppRuntime.submitSms(paramVerifyDevLockObserver, paramString);
    return 0;
  }
  
  public String a()
  {
    return this.e;
  }
  
  public ArrayList<airj> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      Intent localIntent = new Intent(BaseApplicationImpl.getContext(), DevlockQuickLoginActivity.class);
      localIntent.addFlags(268435456);
      localIntent.putExtra("qrcode", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("maintip", this.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("smalltip", this.jdField_c_of_type_JavaLangString);
      localIntent.putExtra("loginConfig", this.jdField_a_of_type_ArrayOfByte);
      BaseApplicationImpl.getContext().startActivity(localIntent);
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_c_of_type_JavaLangString = null;
      this.jdField_a_of_type_ArrayOfByte = null;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) && (paramQQAppInterface != null)) {
      paramString = paramQQAppInterface.getCurrentAccountUin();
    }
    for (;;)
    {
      axqw.b(paramQQAppInterface, "P_CliOper", "Safe_DeviceLock", paramString, "UserBehavior", this.f, 0, paramInt, "", "", "", "");
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    boolean bool;
    label22:
    Object localObject2;
    Object localObject1;
    if ((paramQQAppInterface.isBackground_Pause) || (paramQQAppInterface.isBackground_Stop))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("DevLock", 2, "handleQuickloginPush isInBackground=" + bool + " app.isBackground_Pause=" + paramQQAppInterface.isBackground_Pause + " app.isBackground_Stop=" + paramQQAppInterface.isBackground_Stop);
      }
      if (!bool) {
        break label458;
      }
      paramQQAppInterface = BaseApplicationImpl.getContext();
      localObject2 = paramQQAppInterface.getString(2131692158);
      String str1 = paramQQAppInterface.getString(2131692158);
      String str2 = paramString2 + "\n" + paramString3;
      localObject1 = bawu.a(paramQQAppInterface.getResources(), 2130843408);
      localObject2 = new NotificationCompat.Builder(paramQQAppInterface).setContentTitle(str1).setContentText(str2).setAutoCancel(true).setSmallIcon(BaseApplicationImpl.appnewmsgicon).setTicker((CharSequence)localObject2).setWhen(System.currentTimeMillis());
      if (localObject1 == null) {
        break label439;
      }
      ((NotificationCompat.Builder)localObject2).setLargeIcon((Bitmap)localObject1);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT < 11) {
        ((NotificationCompat.Builder)localObject2).setSmallIcon(2130843408);
      }
      localObject1 = new Intent(paramQQAppInterface, DevlockQuickLoginActivity.class);
      ((Intent)localObject1).addFlags(268435456);
      ((Intent)localObject1).putExtra("qrcode", paramString1);
      ((Intent)localObject1).putExtra("maintip", paramString2);
      ((Intent)localObject1).putExtra("smalltip", paramString3);
      ((Intent)localObject1).putExtra("loginConfig", paramArrayOfByte);
      ((Intent)localObject1).putExtra("param_notifyid", 276);
      ((NotificationCompat.Builder)localObject2).setContentIntent(PendingIntent.getActivity(paramQQAppInterface, 0, (Intent)localObject1, 134217728));
      if ((localObject2 != null) && (Build.VERSION.SDK_INT >= 26)) {
        ((NotificationCompat.Builder)localObject2).setChannelId("CHANNEL_ID_SHOW_BADGE");
      }
      paramQQAppInterface = ((NotificationCompat.Builder)localObject2).build();
      localObject1 = QQNotificationManager.getInstance();
      if (localObject1 == null) {
        break;
      }
      ((QQNotificationManager)localObject1).cancel("EquipmentLockImpl", 276);
      jdField_a_of_type_Boolean = true;
      ((QQNotificationManager)localObject1).notify("EquipmentLockImpl", 276, paramQQAppInterface);
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.jdField_b_of_type_JavaLangString = paramString2;
      this.jdField_c_of_type_JavaLangString = paramString3;
      this.jdField_a_of_type_ArrayOfByte = new byte[paramArrayOfByte.length];
      System.arraycopy(paramArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, 0, paramArrayOfByte.length);
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 120000L);
      return;
      bool = false;
      break label22;
      label439:
      ((NotificationCompat.Builder)localObject2).setLargeIcon(bawu.a(paramQQAppInterface.getResources(), 2130843408));
    }
    label458:
    paramQQAppInterface = new Intent(BaseApplicationImpl.getContext(), DevlockQuickLoginActivity.class);
    paramQQAppInterface.addFlags(268435456);
    paramQQAppInterface.putExtra("qrcode", paramString1);
    paramQQAppInterface.putExtra("maintip", paramString2);
    paramQQAppInterface.putExtra("smalltip", paramString3);
    paramQQAppInterface.putExtra("loginConfig", paramArrayOfByte);
    BaseApplicationImpl.getContext().startActivity(paramQQAppInterface);
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
  }
  
  public void a(ArrayList<airj> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void a(AppRuntime paramAppRuntime, int paramInt)
  {
    if (paramAppRuntime != null)
    {
      paramAppRuntime = (WtloginManager)paramAppRuntime.getManager(1);
      if (paramAppRuntime != null) {
        paramAppRuntime.SetDevlockMobileType(paramInt);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    long l = Long.parseLong(paramQQAppInterface.getAccount());
    String str = null;
    int i = AppSetting.a();
    paramQQAppInterface.getApplication();
    BaseApplication localBaseApplication = MobileQQ.getContext();
    if (localBaseApplication != null) {
      str = localBaseApplication.getPackageName();
    }
    if ((str == null) || (str.length() < 1)) {
      str = "com.tencent.mobileqq";
    }
    for (;;)
    {
      paramQQAppInterface = (FriendListHandler)paramQQAppInterface.a(1);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.a(l, str, i);
        return true;
      }
      return false;
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, long paramLong, byte paramByte, byte[] paramArrayOfByte, int paramInt)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return false;
      paramQQAppInterface = (FriendListHandler)paramQQAppInterface.a(1);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.a(paramLong, paramByte, paramArrayOfByte, paramInt);
    return true;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = (FriendListHandler)paramQQAppInterface.a(1);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface.a(paramLong, paramString, 0L);
      return true;
    }
    return false;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString, ArrayList<DeviceItemDes> paramArrayList, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = (FriendListHandler)paramQQAppInterface.a(1);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface.a(paramString, paramArrayList, paramInt);
      return true;
    }
    return false;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString, ArrayList<DeviceItemDes> paramArrayList, int paramInt, boolean paramBoolean, long paramLong)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = (FriendListHandler)paramQQAppInterface.a(1);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface.a(paramString, paramArrayList, paramInt, paramBoolean, paramLong);
      return true;
    }
    return false;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, ArrayList<airj> paramArrayList)
  {
    if ((paramQQAppInterface == null) || (paramArrayList == null)) {
      return false;
    }
    long l = Long.parseLong(paramQQAppInterface.getAccount());
    String str = null;
    int i = AppSetting.a();
    paramQQAppInterface.getApplication();
    Object localObject = MobileQQ.getContext();
    if (localObject != null) {
      str = ((Context)localObject).getPackageName();
    }
    if (str != null)
    {
      localObject = str;
      if (str.length() >= 1) {}
    }
    else
    {
      localObject = "com.tencent.mobileqq";
    }
    paramQQAppInterface = (FriendListHandler)paramQQAppInterface.a(1);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface.a(l, i, (String)localObject, 1000, paramArrayList);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    BaseApplicationImpl.getContext();
    QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
    if (localQQNotificationManager != null) {}
    try
    {
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      localQQNotificationManager.cancel("EquipmentLockImpl", 276);
      jdField_a_of_type_Boolean = false;
      label36:
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_c_of_type_JavaLangString = null;
      this.jdField_a_of_type_ArrayOfByte = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      break label36;
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) && (paramQQAppInterface != null)) {
      paramString = paramQQAppInterface.getCurrentAccountUin();
    }
    for (;;)
    {
      axqw.b(paramQQAppInterface, "dc00899", "Safe_DeviceLock", paramString, "H5UserBehavior", "H5_Manually", 0, paramInt, "", "", "", "");
      return;
    }
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean b(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = (FriendListHandler)paramQQAppInterface.a(1);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface.b(paramLong, paramString, 0L);
      return true;
    }
    return false;
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilArrayList = null;
  }
  
  public boolean c()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public boolean c(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = (FriendListHandler)paramQQAppInterface.a(1);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface.c(paramLong, paramString, 0L);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoen
 * JD-Core Version:    0.7.0.1
 */