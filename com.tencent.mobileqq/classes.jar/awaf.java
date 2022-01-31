import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.BatteryManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime.Status;

public class awaf
{
  private int jdField_a_of_type_Int = aekt.a(12.0F, BaseApplicationImpl.getContext().getResources());
  private bhux jdField_a_of_type_Bhux = new bhux();
  private int b = aekt.a(4.0F, BaseApplicationImpl.getContext().getResources());
  
  public static int a()
  {
    int j;
    if (Build.VERSION.SDK_INT >= 21)
    {
      j = ((BatteryManager)BaseApplication.getContext().getSystemService("batterymanager")).getIntProperty(4);
      i = j;
      if (QLog.isColorLevel()) {
        QLog.d("OnLineStatusHelper", 2, new Object[] { "BatterManager ", Integer.valueOf(j) });
      }
    }
    for (int i = j;; i = 0)
    {
      j = i;
      if (i <= 0) {
        j = bdiv.I(BaseApplicationImpl.sApplication.getApplicationContext());
      }
      return j;
    }
  }
  
  private Drawable a(awam paramawam, Friends paramFriends, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramawam != null)
    {
      if (paramawam.jdField_a_of_type_Int != 2) {
        break label31;
      }
      localObject1 = awai.a(paramawam.jdField_a_of_type_MqqAppAppRuntime$Status);
    }
    label31:
    do
    {
      return localObject1;
      if (!a(paramawam)) {
        break;
      }
      if (a(paramFriends) > 0) {
        return this.jdField_a_of_type_Bhux.a(a(paramFriends), paramInt);
      }
      localObject1 = localObject2;
    } while (paramFriends != null);
    paramawam = URLDrawable.getDrawable(paramawam.b, URLDrawable.URLDrawableOptions.obtain());
    paramawam.setBounds(0, 0, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
    return paramawam;
    paramawam = URLDrawable.getDrawable(paramawam.b, URLDrawable.URLDrawableOptions.obtain());
    paramawam.setBounds(0, 0, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
    return paramawam;
  }
  
  public static awaf a()
  {
    return awah.a();
  }
  
  private String a(Friends paramFriends)
  {
    if ((paramFriends != null) && (!TextUtils.isEmpty(paramFriends.strTermDesc)) && (paramFriends.strTermDesc.contains("在线")))
    {
      paramFriends = paramFriends.strTermDesc.substring(0, paramFriends.strTermDesc.length() - 2);
      if (!TextUtils.isEmpty(paramFriends)) {
        return paramFriends;
      }
    }
    return "手机";
  }
  
  public static int b()
  {
    int i = bdiv.J(BaseApplicationImpl.sApplication.getApplicationContext());
    int j = i;
    BatteryManager localBatteryManager;
    if (i == -1)
    {
      j = i;
      if (Build.VERSION.SDK_INT >= 21)
      {
        localBatteryManager = (BatteryManager)BaseApplication.getContext().getSystemService("batterymanager");
        if (Build.VERSION.SDK_INT < 23) {
          break label129;
        }
      }
    }
    label129:
    for (boolean bool = localBatteryManager.isCharging();; bool = false)
    {
      int k = localBatteryManager.getIntProperty(6);
      if ((k == 2) || (k == 5) || (bool)) {}
      for (i = 1;; i = 0)
      {
        j = i;
        if (QLog.isColorLevel())
        {
          QLog.d("OnLineStatusHelper", 2, new Object[] { "BatterManager isCharging:", Boolean.valueOf(bool), " chargeStatus:", Integer.valueOf(k) });
          j = i;
        }
        return j;
      }
    }
  }
  
  public int a(Friends paramFriends)
  {
    if (paramFriends == null) {
      return a();
    }
    return Math.max(0, Math.min(paramFriends.getBatteryCapacity(), 100));
  }
  
  public long a(QQAppInterface paramQQAppInterface)
  {
    long l2 = paramQQAppInterface.getExtOnlineStatus();
    long l1 = l2;
    if (l2 == -1L)
    {
      l2 = BaseApplicationImpl.getContext().getSharedPreferences("acc_info" + paramQQAppInterface.getCurrentAccountUin(), 0).getLong("getOnlineStatusExt", -1L);
      l1 = l2;
      if (l2 != -1L)
      {
        paramQQAppInterface.setExtOnlineStatus(l2);
        l1 = l2;
      }
    }
    return l1;
  }
  
  public Drawable a(long paramLong, AppRuntime.Status paramStatus, int paramInt)
  {
    if (paramStatus == AppRuntime.Status.online)
    {
      awam localawam = a(AppRuntime.Status.online, paramLong);
      if (localawam != null) {
        return a(localawam, null, paramInt);
      }
    }
    return awai.a(paramStatus);
  }
  
  public Drawable a(awam paramawam, Friends paramFriends)
  {
    return a(paramawam, paramFriends, 0);
  }
  
  public awam a(AppRuntime.Status paramStatus, long paramLong)
  {
    aokn localaokn = (aokn)aogj.a().a(578);
    if (localaokn != null) {
      return localaokn.a(paramStatus, paramLong);
    }
    return new awam(AppRuntime.Status.online);
  }
  
  public String a(long paramLong, AppRuntime.Status paramStatus)
  {
    if (paramStatus == AppRuntime.Status.online)
    {
      if (paramLong == 1000L) {
        return "我的电量";
      }
      awam localawam = a(AppRuntime.Status.online, paramLong);
      if ((localawam != null) && (!TextUtils.isEmpty(localawam.jdField_a_of_type_JavaLangString))) {
        return localawam.jdField_a_of_type_JavaLangString;
      }
    }
    return awai.a(paramStatus);
  }
  
  public String a(QQAppInterface paramQQAppInterface, awam paramawam, AppRuntime.Status paramStatus, Friends paramFriends, TextView paramTextView)
  {
    if ((paramStatus == AppRuntime.Status.online) && (paramawam != null))
    {
      if ((paramawam.jdField_a_of_type_Long == 1000L) && (paramFriends != null))
      {
        if (paramQQAppInterface.getCurrentAccountUin().equals(paramFriends.uin))
        {
          if (paramQQAppInterface.getPowerConnect() == 1) {
            return paramQQAppInterface.getBatteryCapacity() + "% " + a(paramFriends) + "充电中";
          }
          return paramQQAppInterface.getBatteryCapacity() + "% " + a(paramFriends) + "电量";
        }
        if (a(paramFriends) > 0)
        {
          if (paramFriends.isBatteryCharging()) {
            return a(paramFriends) + "% " + a(paramFriends) + "充电中";
          }
          return a(paramFriends) + "% " + a(paramFriends) + "电量";
        }
        return bdbt.b(paramFriends);
      }
      if ((paramawam.jdField_a_of_type_Long == 1028L) && (paramFriends != null)) {
        return awar.a(paramQQAppInterface, paramFriends, paramTextView);
      }
      if (!TextUtils.isEmpty(paramawam.jdField_a_of_type_JavaLangString)) {
        return paramawam.jdField_a_of_type_JavaLangString;
      }
    }
    return awai.a(paramStatus);
  }
  
  public ArrayList<awam> a()
  {
    aokn localaokn = (aokn)aogj.a().a(578);
    if (localaokn != null) {
      return localaokn.a();
    }
    return null;
  }
  
  public AppRuntime.Status a(awam paramawam)
  {
    if (paramawam != null) {
      return paramawam.jdField_a_of_type_MqqAppAppRuntime$Status;
    }
    return null;
  }
  
  public void a(Friends paramFriends, TextView paramTextView, boolean paramBoolean)
  {
    Drawable[] arrayOfDrawable = paramTextView.getCompoundDrawables();
    if (paramFriends == null)
    {
      paramTextView.setCompoundDrawablePadding(0);
      paramTextView.setCompoundDrawables(null, arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
      return;
    }
    int k = bdbt.a(paramFriends.detalStatusFlag, paramFriends.iTermType);
    awam localawam = a(AppRuntime.Status.online, paramFriends.uExtOnlineStatus);
    int i = 0;
    int j = i;
    if (paramBoolean)
    {
      j = i;
      if (k == 4)
      {
        j = i;
        if (paramFriends.uExtOnlineStatus > 0L)
        {
          j = i;
          if (localawam != null) {
            if (a(localawam)) {
              if (a(paramFriends) > 0)
              {
                i = 1;
                j = i;
                if (i == 0) {
                  break label218;
                }
                paramFriends = a(localawam, paramFriends);
                if (paramFriends == null) {
                  break label189;
                }
                i = 1;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        paramTextView.setCompoundDrawablePadding(this.b);
        paramTextView.setCompoundDrawables(paramFriends, arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
        return;
        i = 0;
        break;
        i = 1;
        break;
        label189:
        i = 0;
        continue;
      }
      paramTextView.setCompoundDrawablePadding(0);
      paramTextView.setCompoundDrawables(null, arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
      return;
      label218:
      i = j;
      paramFriends = null;
    }
  }
  
  public boolean a(awam paramawam)
  {
    return (paramawam != null) && (paramawam.jdField_a_of_type_Long == 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awaf
 * JD-Core Version:    0.7.0.1
 */