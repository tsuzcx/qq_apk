import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.BatteryManager;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BatteryBroadcastReceiver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.onlinestatus.OnLineStatusPresenter.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;
import mqq.os.MqqHandler;

public class axvb
{
  private int jdField_a_of_type_Int = 0;
  private axvc jdField_a_of_type_Axvc;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private BatteryBroadcastReceiver jdField_a_of_type_ComTencentMobileqqAppBatteryBroadcastReceiver;
  private int b = -2147483548;
  
  public axvb(@NonNull BaseActivity paramBaseActivity, @NonNull axvc paramaxvc)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_Axvc = paramaxvc;
  }
  
  private Friends a(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
    Friends localFriends = ((amsw)localQQAppInterface.getManager(51)).c(localQQAppInterface.getCurrentUin());
    if (QLog.isColorLevel()) {
      if (localFriends != null) {
        break label89;
      }
    }
    label89:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("OnLineStatusPresenter", 2, new Object[] { "updateOnlineStatus friends is empty:", Boolean.valueOf(bool), " friendsEntityNotLoad=", Boolean.valueOf(paramBoolean) });
      if ((localFriends != null) || (paramBoolean)) {
        break;
      }
      a(localQQAppInterface);
      return null;
    }
    if (localFriends == null)
    {
      localFriends = new Friends();
      localFriends.uin = localQQAppInterface.getCurrentUin();
      return localFriends;
    }
    return localFriends;
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    amsw localamsw = (amsw)paramQQAppInterface.getManager(51);
    ThreadManager.getSubThreadHandler().post(new OnLineStatusPresenter.1(this, localamsw, paramQQAppInterface));
  }
  
  private void a(Friends paramFriends, AppRuntime.Status paramStatus, long paramLong)
  {
    paramFriends = axuy.a().a(paramLong, paramStatus, 0, paramFriends);
    String str = amtj.a(2131703987) + axuy.a().a(paramLong, paramStatus);
    this.jdField_a_of_type_Axvc.a(paramFriends, str);
    if (QLog.isColorLevel()) {
      QLog.d("OnLineStatusPresenter", 2, "user head updateOnlineStatus: " + paramStatus);
    }
  }
  
  private void a(Friends paramFriends, AppRuntime.Status paramStatus, long paramLong, axvj paramaxvj)
  {
    Drawable localDrawable = axuy.a().a(paramLong, paramStatus, 0, paramFriends);
    TextView localTextView = this.jdField_a_of_type_Axvc.a();
    if (localTextView == null) {}
    do
    {
      return;
      paramFriends = axuy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, paramaxvj, paramStatus, paramFriends, localTextView, 4);
    } while (TextUtils.isEmpty(paramFriends));
    this.jdField_a_of_type_Axvc.a(paramFriends, localDrawable);
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnLineStatusPresenter", 2, "registerBatteryBroadcastReceiver start");
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppBatteryBroadcastReceiver == null)
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        this.jdField_a_of_type_ComTencentMobileqqAppBatteryBroadcastReceiver = new BatteryBroadcastReceiver(paramQQAppInterface);
        BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_ComTencentMobileqqAppBatteryBroadcastReceiver, localIntentFilter);
        if (QLog.isColorLevel()) {
          QLog.d("OnLineStatusPresenter", 2, "registerBatteryBroadcastReceiver success");
        }
      }
      paramQQAppInterface.registerBatteryBroadcastReceiver();
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      QLog.e("OnLineStatusPresenter", 1, paramQQAppInterface, new Object[] { "registerBatteryBroadcastReceiver fail" });
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface, AppRuntime.Status paramStatus, long paramLong)
  {
    a(paramQQAppInterface, paramStatus, paramLong);
    if ((paramStatus == AppRuntime.Status.online) && (paramLong == 1000L)) {
      paramQQAppInterface.checkBatteryStatus();
    }
  }
  
  public int a()
  {
    if (this.b == -2147483548)
    {
      this.b = -1;
      if (!a()) {}
    }
    try
    {
      this.b = ((BatteryManager)BaseApplication.getContext().getSystemService("batterymanager")).getIntProperty(4);
      if (QLog.isColorLevel()) {
        QLog.d("OnLineStatusPresenter", 2, new Object[] { "BatterManager ", Integer.valueOf(this.b) });
      }
      return this.b;
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      for (;;)
      {
        QLog.e("OnLineStatusPresenter", 1, localNoSuchMethodError, new Object[] { "getLocalBatteryCapacity fail" });
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnLineStatusPresenter", 2, "unRegisterBatteryBroadcastReceiver start");
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppBatteryBroadcastReceiver != null)
      {
        BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqAppBatteryBroadcastReceiver);
        this.jdField_a_of_type_ComTencentMobileqqAppBatteryBroadcastReceiver = null;
        if (QLog.isColorLevel()) {
          QLog.d("OnLineStatusPresenter", 2, "unRegisterBatteryBroadcastReceiver success");
        }
      }
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
      if (localQQAppInterface != null) {
        localQQAppInterface.unRegisterBatteryBroadcastReceiver();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("OnLineStatusPresenter", 1, localThrowable, new Object[] { "unRegisterBatteryBroadcastReceiver fail" });
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt > 0) {}
    for (paramInt = 1;; paramInt = 2)
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, AppRuntime.Status paramStatus, long paramLong)
  {
    if (paramQQAppInterface != null)
    {
      if (a() <= 0) {
        break label52;
      }
      if (QLog.isColorLevel()) {
        QLog.d("OnLineStatusPresenter", 2, "handleBatteryChangeBroadcastReceiver LocalBattery correct");
      }
      if ((paramStatus != AppRuntime.Status.online) || (paramLong != 1000L)) {
        break label47;
      }
      b(paramQQAppInterface);
    }
    label47:
    label52:
    do
    {
      return;
      a();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("OnLineStatusPresenter", 2, "handleBatteryChangeBroadcastReceiver LocalBattery wrong");
      }
      if (this.jdField_a_of_type_Int == 0)
      {
        b(paramQQAppInterface);
        return;
      }
      if (this.jdField_a_of_type_Int == 1)
      {
        if ((paramStatus == AppRuntime.Status.online) && (paramLong == 1000L))
        {
          b(paramQQAppInterface);
          return;
        }
        a();
        return;
      }
    } while (this.jdField_a_of_type_Int != 2);
    a();
  }
  
  public void a(String paramString)
  {
    a(paramString, false);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnLineStatusPresenter", 2, "[status][conversation] updateOnlineStatus from: " + paramString + " friendsEntityNotLoad: " + paramBoolean);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
    paramString = ((QQAppInterface)localObject).getOnlineStatusNonSync();
    long l = axuy.a().a((QQAppInterface)localObject);
    b((QQAppInterface)localObject, paramString, l);
    localObject = a(paramBoolean);
    if (localObject == null) {
      return;
    }
    axvj localaxvj = axuy.a().a(paramString, l);
    if (!axuy.a().a(localaxvj, (Friends)localObject, true))
    {
      l = 0L;
      paramString = AppRuntime.Status.online;
    }
    a((Friends)localObject, paramString, l, localaxvj);
    a((Friends)localObject, paramString, l);
  }
  
  boolean a()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axvb
 * JD-Core Version:    0.7.0.1
 */