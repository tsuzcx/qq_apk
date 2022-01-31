import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import mqq.app.AppRuntime.Status;

public class atlb
{
  private int jdField_a_of_type_Int = aciy.a(12.0F, BaseApplicationImpl.getContext().getResources());
  private atld jdField_a_of_type_Atld;
  private belp jdField_a_of_type_Belp = new belp(0);
  private int b = aciy.a(4.0F, BaseApplicationImpl.getContext().getResources());
  
  public static atlb a()
  {
    return atle.a();
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
  
  public int a(Friends paramFriends)
  {
    if (paramFriends == null) {
      return MsfSdkUtils.getBatteryStatus();
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
  
  public Drawable a(long paramLong, AppRuntime.Status paramStatus)
  {
    if (paramStatus == AppRuntime.Status.online)
    {
      atlj localatlj = a(AppRuntime.Status.online, paramLong);
      if (localatlj != null) {
        return a(localatlj, null);
      }
    }
    return atlf.a(paramStatus);
  }
  
  public Drawable a(atlj paramatlj, Friends paramFriends)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramatlj != null)
    {
      if (paramatlj.jdField_a_of_type_Int != 2) {
        break label28;
      }
      localObject1 = atlf.a(paramatlj.jdField_a_of_type_MqqAppAppRuntime$Status);
    }
    label28:
    do
    {
      return localObject1;
      if (!a(paramatlj)) {
        break;
      }
      if (a(paramFriends) > 0) {
        return this.jdField_a_of_type_Belp.a(a(paramFriends));
      }
      localObject1 = localObject2;
    } while (paramFriends != null);
    paramatlj = URLDrawable.getDrawable(paramatlj.b, URLDrawable.URLDrawableOptions.obtain());
    paramatlj.setBounds(0, 0, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
    return paramatlj;
    paramatlj = URLDrawable.getDrawable(paramatlj.b, URLDrawable.URLDrawableOptions.obtain());
    paramatlj.setBounds(0, 0, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
    return paramatlj;
  }
  
  public atlj a(AppRuntime.Status paramStatus, long paramLong)
  {
    return ((amdi)alzw.a().a(578)).a(paramStatus, paramLong);
  }
  
  public String a(long paramLong, AppRuntime.Status paramStatus)
  {
    if (paramStatus == AppRuntime.Status.online)
    {
      if (paramLong == 1000L) {
        return "我的电量";
      }
      return a(AppRuntime.Status.online, paramLong).jdField_a_of_type_JavaLangString;
    }
    return atlf.a(paramStatus);
  }
  
  public String a(atlj paramatlj, AppRuntime.Status paramStatus, Friends paramFriends)
  {
    if ((paramStatus == AppRuntime.Status.online) && (paramatlj != null)) {
      if (paramatlj.jdField_a_of_type_Long == 1000L)
      {
        if (a(paramFriends) > 0)
        {
          if (paramFriends.isBatteryCharging()) {
            return a(paramFriends) + "% " + a(paramFriends) + "充电中";
          }
          return a(paramFriends) + "% " + a(paramFriends) + "电量";
        }
        if (paramFriends != null) {
          return babh.b(paramFriends);
        }
      }
      else if (!TextUtils.isEmpty(paramatlj.jdField_a_of_type_JavaLangString))
      {
        return paramatlj.jdField_a_of_type_JavaLangString;
      }
    }
    return atlf.a(paramStatus);
  }
  
  public ArrayList<atlj> a()
  {
    amdi localamdi = (amdi)alzw.a().a(578);
    if (localamdi != null) {
      return localamdi.a();
    }
    return null;
  }
  
  public AppRuntime.Status a(atlj paramatlj)
  {
    if (paramatlj != null) {
      return paramatlj.jdField_a_of_type_MqqAppAppRuntime$Status;
    }
    return null;
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_Atld != null)
      {
        BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_Atld);
        this.jdField_a_of_type_Atld = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    try
    {
      b(paramQQAppInterface);
      if (this.jdField_a_of_type_Atld == null)
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        localIntentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        localIntentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        this.jdField_a_of_type_Atld = new atld(paramQQAppInterface, null);
        BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_Atld, localIntentFilter);
      }
      return;
    }
    finally
    {
      paramQQAppInterface = finally;
      throw paramQQAppInterface;
    }
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
    int k = babh.a(paramFriends.detalStatusFlag, paramFriends.iTermType);
    atlj localatlj = a(AppRuntime.Status.online, paramFriends.uExtOnlineStatus);
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
          if (localatlj != null) {
            if (a(localatlj)) {
              if (a(paramFriends) > 0)
              {
                i = 1;
                j = i;
                if (i == 0) {
                  break label218;
                }
                paramFriends = a(localatlj, paramFriends);
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
  
  public boolean a(atlj paramatlj)
  {
    return (paramatlj != null) && (paramatlj.jdField_a_of_type_Long == 1000L);
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null) {}
    try
    {
      IntentFilter localIntentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
      if ((BaseApplicationImpl.getContext().registerReceiver(null, localIntentFilter) != null) && (paramQQAppInterface.getOnlineStatus() == AppRuntime.Status.online) && (a(paramQQAppInterface) == 1000L)) {
        paramQQAppInterface.a(AppRuntime.Status.online, 1000L);
      }
      return;
    }
    finally
    {
      paramQQAppInterface = finally;
      throw paramQQAppInterface;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     atlb
 * JD-Core Version:    0.7.0.1
 */