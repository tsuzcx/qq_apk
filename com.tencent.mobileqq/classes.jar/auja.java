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

public class auja
{
  private int jdField_a_of_type_Int = actn.a(12.0F, BaseApplicationImpl.getContext().getResources());
  private bftj jdField_a_of_type_Bftj = new bftj();
  private int b = actn.a(4.0F, BaseApplicationImpl.getContext().getResources());
  
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
        j = bbjn.H(BaseApplicationImpl.sApplication.getApplicationContext());
      }
      return j;
    }
  }
  
  private Drawable a(aujh paramaujh, Friends paramFriends, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramaujh != null)
    {
      if (paramaujh.jdField_a_of_type_Int != 2) {
        break label31;
      }
      localObject1 = aujd.a(paramaujh.jdField_a_of_type_MqqAppAppRuntime$Status);
    }
    label31:
    do
    {
      return localObject1;
      if (!a(paramaujh)) {
        break;
      }
      if (a(paramFriends) > 0) {
        return this.jdField_a_of_type_Bftj.a(a(paramFriends), paramInt);
      }
      localObject1 = localObject2;
    } while (paramFriends != null);
    paramaujh = URLDrawable.getDrawable(paramaujh.b, URLDrawable.URLDrawableOptions.obtain());
    paramaujh.setBounds(0, 0, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
    return paramaujh;
    paramaujh = URLDrawable.getDrawable(paramaujh.b, URLDrawable.URLDrawableOptions.obtain());
    paramaujh.setBounds(0, 0, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
    return paramaujh;
  }
  
  public static auja a()
  {
    return aujc.a();
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
    int i = bbjn.I(BaseApplicationImpl.sApplication.getApplicationContext());
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
      aujh localaujh = a(AppRuntime.Status.online, paramLong);
      if (localaujh != null) {
        return a(localaujh, null, paramInt);
      }
    }
    return aujd.a(paramStatus);
  }
  
  public Drawable a(aujh paramaujh, Friends paramFriends)
  {
    return a(paramaujh, paramFriends, 0);
  }
  
  public aujh a(AppRuntime.Status paramStatus, long paramLong)
  {
    amtm localamtm = (amtm)ampm.a().a(578);
    if (localamtm != null) {
      return localamtm.a(paramStatus, paramLong);
    }
    return new aujh(AppRuntime.Status.online);
  }
  
  public String a(long paramLong, AppRuntime.Status paramStatus)
  {
    if (paramStatus == AppRuntime.Status.online)
    {
      if (paramLong == 1000L) {
        return "我的电量";
      }
      aujh localaujh = a(AppRuntime.Status.online, paramLong);
      if ((localaujh != null) && (!TextUtils.isEmpty(localaujh.jdField_a_of_type_JavaLangString))) {
        return localaujh.jdField_a_of_type_JavaLangString;
      }
    }
    return aujd.a(paramStatus);
  }
  
  public String a(QQAppInterface paramQQAppInterface, aujh paramaujh, AppRuntime.Status paramStatus, Friends paramFriends)
  {
    if ((paramStatus == AppRuntime.Status.online) && (paramaujh != null))
    {
      if ((paramaujh.jdField_a_of_type_Long == 1000L) && (paramFriends != null))
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
        return bbcl.b(paramFriends);
      }
      if (!TextUtils.isEmpty(paramaujh.jdField_a_of_type_JavaLangString)) {
        return paramaujh.jdField_a_of_type_JavaLangString;
      }
    }
    return aujd.a(paramStatus);
  }
  
  public ArrayList<aujh> a()
  {
    amtm localamtm = (amtm)ampm.a().a(578);
    if (localamtm != null) {
      return localamtm.a();
    }
    return null;
  }
  
  public AppRuntime.Status a(aujh paramaujh)
  {
    if (paramaujh != null) {
      return paramaujh.jdField_a_of_type_MqqAppAppRuntime$Status;
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
    int k = bbcl.a(paramFriends.detalStatusFlag, paramFriends.iTermType);
    aujh localaujh = a(AppRuntime.Status.online, paramFriends.uExtOnlineStatus);
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
          if (localaujh != null) {
            if (a(localaujh)) {
              if (a(paramFriends) > 0)
              {
                i = 1;
                j = i;
                if (i == 0) {
                  break label218;
                }
                paramFriends = a(localaujh, paramFriends);
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
  
  public boolean a(aujh paramaujh)
  {
    return (paramaujh != null) && (paramaujh.jdField_a_of_type_Long == 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auja
 * JD-Core Version:    0.7.0.1
 */