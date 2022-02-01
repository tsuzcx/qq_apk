import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.dataline.activities.LiteActivity;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.notification.TransparentNotificationFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.manager.Manager;
import org.jetbrains.annotations.Nullable;

public class amru
  implements Manager
{
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final int[] jdField_a_of_type_ArrayOfInt;
  
  public amru(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ArrayOfInt = new int[] { 0, 1 };
  }
  
  public static amru a(QQAppInterface paramQQAppInterface)
  {
    return (amru)paramQQAppInterface.getManager(371);
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 0: 
      return 1;
    }
    return 2;
  }
  
  public int a(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    if (paramInt == 1) {
      return 2;
    }
    if (a(paramInt)) {
      return 3;
    }
    return 4;
  }
  
  public Intent a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", paramInt1);
    localIntent.putExtra("uinname", paramString2);
    localIntent.putExtra("key_mini_msgtab_businame", paramInt2);
    localIntent.setClass(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), MiniChatActivity.class);
    localIntent.putExtra("key_mini_from", 2);
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("public_fragment_class", MiniChatFragment.class.getName());
    localIntent.putExtra("key_mini_exit_anim", 1);
    return localIntent;
  }
  
  public CompoundButton.OnCheckedChangeListener a(BaseActivity paramBaseActivity, FormSwitchItem paramFormSwitchItem)
  {
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new amrv(this, paramBaseActivity, paramFormSwitchItem);
    return this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  }
  
  @Nullable
  BaseChatPie a(FragmentActivity paramFragmentActivity)
  {
    paramFragmentActivity = paramFragmentActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if ((paramFragmentActivity instanceof ChatFragment)) {
      return ((ChatFragment)paramFragmentActivity).a();
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = null;
  }
  
  public boolean a()
  {
    String str1 = GuardManager.a.a();
    if ((str1 == null) || ("com.tencent.mobileqq".equals(str1))) {}
    for (boolean bool = true;; bool = false)
    {
      Object localObject = GuardManager.a.a();
      if (!bool) {
        break;
      }
      localObject = ((Map)localObject).entrySet().iterator();
      String str2;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        str2 = (String)((Map.Entry)((Iterator)localObject).next()).getKey();
        QLog.d("ForegroundNotifyManager", 1, new Object[] { "[process] isSubProcessBackgroundStop: invoked. ", " process: ", str2 });
      } while (str2.equals("com.tencent.mobileqq"));
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForegroundNotifyManager", 2, new Object[] { "[process] isSubProcessBackgroundStop: invoked. ", " foregroundProcess: ", str1, " isSubProcessBackgroundStop: ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean a(QQMessageFacade.Message paramMessage)
  {
    int i = paramMessage.istroop;
    paramMessage = paramMessage.frienduin;
    boolean bool4 = b();
    boolean bool5 = a(i);
    boolean bool6 = a(paramMessage);
    for (;;)
    {
      try
      {
        bool1 = c();
        if (bool1) {
          continue;
        }
        bool1 = true;
      }
      catch (Throwable paramMessage)
      {
        QLog.e("ForegroundNotifyManager", 1, "functionOpen: failed. ", paramMessage);
        boolean bool1 = false;
        continue;
        boolean bool2 = false;
        continue;
        boolean bool3 = false;
        continue;
      }
      if (h()) {
        continue;
      }
      bool2 = true;
      if (FriendsStatusUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) {
        continue;
      }
      bool3 = true;
      if (QLog.isColorLevel()) {
        QLog.d("ForegroundNotifyManager", 2, new Object[] { "functionOpen: invoked. ", " switchEnabled: ", Boolean.valueOf(bool4), " supportedUinType: ", Boolean.valueOf(bool5), " noNeedShield: ", Boolean.valueOf(bool1), " entranceShown: ", Boolean.valueOf(bool2), " canDisturb: ", Boolean.valueOf(bool3), " supportedUin: ", Boolean.valueOf(bool6) });
      }
      if ((!bool4) || (!bool5) || (!bool6) || (!bool1) || (!bool2) || (!bool3)) {
        break label236;
      }
      return true;
      bool1 = false;
    }
    label236:
    return false;
  }
  
  public boolean a(String paramString)
  {
    return Friends.isValidUin(paramString);
  }
  
  public Intent b(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", paramInt1);
    localIntent.putExtra("uinname", paramString2);
    localIntent.putExtra("key_mini_msgtab_businame", paramInt2);
    localIntent.putExtra("key_mini_from", 2);
    localIntent.setClass(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), PublicTransFragmentActivity.class);
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("public_fragment_class", TransparentNotificationFragment.class.getName());
    return localIntent;
  }
  
  public boolean b()
  {
    return SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), null, "top_msg_notification_key", true);
  }
  
  public boolean c()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundStop) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundPause))
    {
      bool = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
      QLog.d("ForegroundNotifyManager", 1, new Object[] { "[process] isNeedShieldPushUi: invoked. main process background ", " subProcessBackgroundStop: ", Boolean.valueOf(bool) });
    }
    while (BaseActivity.sTopActivity == null) {
      return bool;
    }
    bool = g();
    if ((bool) && (e())) {
      return false;
    }
    if ((bool) || (f()) || (d())) {}
    for (bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForegroundNotifyManager", 2, new Object[] { "[process] isNeedShieldPushUi: invoked. main process foreground ", " mainProcessNeedShield: ", Boolean.valueOf(bool) });
      }
      return bool;
    }
  }
  
  public boolean d()
  {
    if ((BaseActivity.sTopActivity instanceof SplashActivity)) {
      return ((SplashActivity)BaseActivity.sTopActivity).a() == MainFragment.b;
    }
    return false;
  }
  
  public boolean e()
  {
    if ((BaseActivity.sTopActivity instanceof FragmentActivity))
    {
      BaseChatPie localBaseChatPie = a((FragmentActivity)BaseActivity.sTopActivity);
      if (localBaseChatPie == null) {
        return false;
      }
      return localBaseChatPie.isFullScreenMode();
    }
    return false;
  }
  
  public boolean f()
  {
    return (MiniChatActivity.a()) || (MiniChatFragment.a());
  }
  
  public boolean g()
  {
    boolean bool1 = false;
    if (((BaseActivity.sTopActivity instanceof SplashActivity)) && (2 == SplashActivity.a)) {}
    for (int i = 1;; i = 0)
    {
      boolean bool3 = BaseActivity.sTopActivity instanceof ChatActivity;
      boolean bool2 = BaseActivity.sTopActivity instanceof LiteActivity;
      if ((i != 0) || (bool3) || (bool2)) {
        bool1 = true;
      }
      return bool1;
    }
  }
  
  public boolean h()
  {
    return false;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amru
 * JD-Core Version:    0.7.0.1
 */