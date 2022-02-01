package com.tencent.mobileqq.app;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.CompoundButton.OnCheckedChangeListener;
import androidx.fragment.app.FragmentManager;
import com.dataline.activities.LiteActivity;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatFragment;
import com.tencent.mobileqq.activity.recent.msgbox.FilterMsgBoxFragment;
import com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxFragment;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.notification.TransparentNotificationFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.manager.Manager;
import org.jetbrains.annotations.Nullable;

public class ForegroundNotifyManager
  implements Manager
{
  private final int[] a;
  private final QQAppInterface b;
  private CompoundButton.OnCheckedChangeListener c;
  
  public ForegroundNotifyManager(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
    this.a = new int[] { 0, 1, 10014 };
  }
  
  public static ForegroundNotifyManager a(QQAppInterface paramQQAppInterface)
  {
    return (ForegroundNotifyManager)paramQQAppInterface.getManager(QQManagerFactory.FOREGROUND_NOTIFY_MANAGER);
  }
  
  public static int c(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return -1;
      }
      return 2;
    }
    return 1;
  }
  
  private boolean d(Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.istroop == 10014)) {
      return ((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).judgeIsQQGuildLiveRoomActivity();
    }
    return false;
  }
  
  private boolean h()
  {
    Object localObject = BaseActivity.sTopActivity;
    if ((localObject instanceof PublicFragmentActivity))
    {
      boolean bool = TextUtils.equals(((PublicFragmentActivity)localObject).getIntent().getStringExtra("public_fragment_class"), FilterMsgBoxFragment.class.getName());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isFilterBox() ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("ForegroundNotifyManager", 1, ((StringBuilder)localObject).toString());
      return bool;
    }
    return false;
  }
  
  private boolean i()
  {
    Object localObject = BaseActivity.sTopActivity;
    if ((localObject instanceof PublicFragmentActivity))
    {
      boolean bool = TextUtils.equals(((PublicFragmentActivity)localObject).getIntent().getStringExtra("public_fragment_class"), TempMsgBoxFragment.class.getName());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isMsgBox() ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("ForegroundNotifyManager", 1, ((StringBuilder)localObject).toString());
      return bool;
    }
    return false;
  }
  
  public Intent a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", paramInt1);
    localIntent.putExtra("uinname", paramString2);
    localIntent.putExtra("key_mini_msgtab_businame", paramInt2);
    localIntent.setClass(this.b.getApp(), MiniChatActivity.class);
    localIntent.putExtra("key_mini_from", 2);
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("public_fragment_class", MiniChatFragment.class.getName());
    localIntent.putExtra("key_mini_exit_anim", 1);
    return localIntent;
  }
  
  public CompoundButton.OnCheckedChangeListener a(BaseActivity paramBaseActivity, FormSwitchItem paramFormSwitchItem)
  {
    this.c = new ForegroundNotifyManager.1(this, paramBaseActivity, paramFormSwitchItem);
    return this.c;
  }
  
  @Nullable
  BaseChatPie a(BaseActivity paramBaseActivity)
  {
    paramBaseActivity = paramBaseActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if ((paramBaseActivity instanceof ChatFragment)) {
      return ((ChatFragment)paramBaseActivity).k();
    }
    return null;
  }
  
  public boolean a()
  {
    String str1 = GuardManager.sInstance.getForegroundProcess();
    boolean bool;
    if ((str1 != null) && (!"com.tencent.mobileqq".equals(str1))) {
      bool = false;
    } else {
      bool = true;
    }
    Object localObject = GuardManager.sInstance.realForegroundProcessMap();
    if (bool)
    {
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str2 = (String)((Map.Entry)((Iterator)localObject).next()).getKey();
        QLog.d("ForegroundNotifyManager", 1, new Object[] { "[process] isSubProcessBackgroundStop: invoked. ", " process: ", str2 });
        if (!str2.equals("com.tencent.mobileqq")) {
          return false;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForegroundNotifyManager", 2, new Object[] { "[process] isSubProcessBackgroundStop: invoked. ", " foregroundProcess: ", str1, " isSubProcessBackgroundStop: ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public boolean a(int paramInt)
  {
    int[] arrayOfInt = this.a;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfInt[i] == paramInt) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean a(Message paramMessage)
  {
    int i = paramMessage.istroop;
    String str = paramMessage.frienduin;
    boolean bool4 = b();
    boolean bool5 = a(i);
    boolean bool6 = a(str);
    boolean bool3 = false;
    boolean bool1;
    try
    {
      bool1 = b(paramMessage);
      bool1 ^= true;
    }
    catch (Throwable paramMessage)
    {
      QLog.e("ForegroundNotifyManager", 1, "functionOpen: failed. ", paramMessage);
      bool1 = false;
    }
    boolean bool7 = f() ^ true;
    boolean bool8 = FriendsStatusUtil.a(this.b.getApp()) ^ true;
    if (QLog.isColorLevel()) {
      QLog.d("ForegroundNotifyManager", 2, new Object[] { "functionOpen: invoked. ", " switchEnabled: ", Boolean.valueOf(bool4), " supportedUinType: ", Boolean.valueOf(bool5), " noNeedShield: ", Boolean.valueOf(bool1), " entranceShown: ", Boolean.valueOf(bool7), " canDisturb: ", Boolean.valueOf(bool8), " supportedUin: ", Boolean.valueOf(bool6) });
    }
    boolean bool2 = bool3;
    if (bool4)
    {
      bool2 = bool3;
      if (bool5)
      {
        bool2 = bool3;
        if (bool6)
        {
          bool2 = bool3;
          if (bool1)
          {
            bool2 = bool3;
            if (bool7)
            {
              bool2 = bool3;
              if (bool8) {
                bool2 = true;
              }
            }
          }
        }
      }
    }
    return bool2;
  }
  
  public boolean a(String paramString)
  {
    return Friends.isValidUin(paramString);
  }
  
  public int b(int paramInt)
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
  
  public Intent b(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", paramInt1);
    localIntent.putExtra("uinname", paramString2);
    localIntent.putExtra("key_mini_msgtab_businame", paramInt2);
    localIntent.putExtra("key_mini_from", 2);
    localIntent.setClass(this.b.getApp(), PublicTransFragmentActivity.class);
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("public_fragment_class", TransparentNotificationFragment.class.getName());
    return localIntent;
  }
  
  public boolean b()
  {
    return SettingCloneUtil.readValue(this.b.getApp(), this.b.getCurrentUin(), null, "top_msg_notification_key", true);
  }
  
  public boolean b(Message paramMessage)
  {
    if ((!this.b.isBackgroundStop) && (!this.b.isBackgroundPause))
    {
      if (BaseActivity.sTopActivity == null) {
        return true;
      }
      int i;
      if ((!e()) && (!d(paramMessage))) {
        i = 0;
      } else {
        i = 1;
      }
      if ((i != 0) && (c())) {
        return false;
      }
      if ((i == 0) && (!d()) && (!c(paramMessage)) && (!i()) && (!h())) {
        bool = false;
      } else {
        bool = true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ForegroundNotifyManager", 2, new Object[] { "[process] isNeedShieldPushUi: invoked. main process foreground ", " mainProcessNeedShield: ", Boolean.valueOf(bool) });
      }
      return bool;
    }
    boolean bool = a(this.b).a();
    QLog.d("ForegroundNotifyManager", 1, new Object[] { "[process] isNeedShieldPushUi: invoked. main process background ", " subProcessBackgroundStop: ", Boolean.valueOf(bool) });
    return bool;
  }
  
  public boolean c()
  {
    if ((BaseActivity.sTopActivity instanceof BaseActivity))
    {
      BaseChatPie localBaseChatPie = a(BaseActivity.sTopActivity);
      if (localBaseChatPie == null) {
        return false;
      }
      return ((FullScreenInputHelper)localBaseChatPie.q(24)).e();
    }
    return false;
  }
  
  public boolean c(Message paramMessage)
  {
    boolean bool4 = BaseActivity.sTopActivity instanceof SplashActivity;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (bool4)
    {
      int i = ((SplashActivity)BaseActivity.sTopActivity).getCurrentTab();
      if (paramMessage.istroop == 10014)
      {
        bool1 = bool2;
        if (i == FrameControllerUtil.k) {
          bool1 = true;
        }
        return bool1;
      }
      bool1 = bool3;
      if (i == FrameControllerUtil.a) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean d()
  {
    return (MiniChatActivity.b()) || (MiniChatFragment.a());
  }
  
  public boolean e()
  {
    boolean bool1 = BaseActivity.sTopActivity instanceof SplashActivity;
    boolean bool2 = true;
    int i;
    if ((bool1) && (2 == SplashActivity.currentFragment)) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool3 = BaseActivity.sTopActivity instanceof ChatActivity;
    boolean bool4 = BaseActivity.sTopActivity instanceof LiteActivity;
    bool1 = bool2;
    if (i == 0)
    {
      bool1 = bool2;
      if (!bool3)
      {
        if (bool4) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public boolean f()
  {
    return false;
  }
  
  public void g()
  {
    this.c = null;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ForegroundNotifyManager
 * JD-Core Version:    0.7.0.1
 */