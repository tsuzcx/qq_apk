package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.core.helper.OnFinishListener;
import com.tencent.mobileqq.activity.aio.core.tips.IMsgTipsFilter;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.hiddenchat.HiddenChatFragment;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.statistics.ReportController;

public class HiddenChatHelper
  implements OnFinishListener, IMsgTipsFilter, ILifeCycleHelper
{
  private BaseChatPie a;
  
  public HiddenChatHelper(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
    paramBaseChatPie.bv().d().a(this);
  }
  
  public static boolean a(Activity paramActivity, Class<? extends PublicBaseFragment> paramClass)
  {
    Intent localIntent1 = paramActivity.getIntent();
    if (!localIntent1.getBooleanExtra("back_for_hidden_chat", false)) {
      return false;
    }
    Intent localIntent2 = new Intent();
    localIntent2.putExtra("back_for_hidden_chat", true);
    localIntent2.setFlags(603979776);
    localIntent1.putExtra("should_restore_from_kill", false);
    PublicFragmentActivity.a(paramActivity, localIntent1, paramClass, -1);
    paramActivity.overridePendingTransition(2130772005, 2130772006);
    return true;
  }
  
  public static boolean a(String paramString, int paramInt, AppInterface paramAppInterface)
  {
    if ((paramInt == 1) && (b(paramString, paramAppInterface))) {
      return true;
    }
    return (paramInt == 0) && (a(paramString, paramAppInterface));
  }
  
  public static boolean a(String paramString, AppInterface paramAppInterface)
  {
    ExtensionInfo localExtensionInfo = ((FriendsManager)paramAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).x(String.valueOf(paramString));
    paramAppInterface = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      paramAppInterface = new ExtensionInfo();
      paramAppInterface.uin = String.valueOf(paramString);
    }
    return paramAppInterface.hiddenChatSwitch == 1;
  }
  
  public static boolean b(Activity paramActivity, Class<?> paramClass)
  {
    if (!paramActivity.getIntent().getBooleanExtra("back_for_hidden_chat", false)) {
      return false;
    }
    paramClass = new Intent(paramActivity, paramClass);
    paramClass.putExtra("back_for_hidden_chat", true);
    paramClass.setFlags(603979776);
    paramActivity.startActivity(paramClass);
    paramActivity.overridePendingTransition(2130772005, 2130772006);
    return true;
  }
  
  public static boolean b(String paramString, AppInterface paramAppInterface)
  {
    TroopInfo localTroopInfo = ((TroopManager)paramAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).f(paramString);
    paramAppInterface = localTroopInfo;
    if (localTroopInfo == null)
    {
      paramAppInterface = new TroopInfo();
      paramAppInterface.troopuin = paramString;
    }
    return TroopInfo.isCmdUinFlagEx2Open(paramAppInterface.cmdUinFlagEx2, 512);
  }
  
  public static boolean c(Activity paramActivity, Class<?> paramClass)
  {
    if (!paramActivity.getIntent().getBooleanExtra("back_for_hidden_chat", false)) {
      return false;
    }
    paramClass = new Intent(paramActivity, paramClass);
    paramClass.setFlags(603979776);
    paramClass.putExtra("tab_index", FrameControllerUtil.a);
    paramClass.putExtra("fragment_id", 1);
    paramActivity.startActivity(paramClass);
    paramActivity.overridePendingTransition(2130772005, 2130772006);
    return true;
  }
  
  public CharSequence a(AIOContext paramAIOContext, Intent paramIntent, MessageRecord paramMessageRecord, Message paramMessage)
  {
    return null;
  }
  
  public void a()
  {
    if (a(this.a.ah.b, this.a.ah.a, this.a.d)) {
      ReportController.b(null, "dc00898", "", "", "0X800A34F", "0X800A34F", 0, 0, "0", "0", "", "");
    }
  }
  
  public void a(Intent paramIntent)
  {
    if (a(this.a.ah.b, this.a.ah.a, this.a.d)) {
      paramIntent.putExtra("hidden_aio_msg_source", 3);
    }
  }
  
  public boolean a(Message paramMessage)
  {
    if (a(this.a.ah.b, this.a.ah.a, this.a.d)) {
      return true;
    }
    return a(paramMessage.frienduin, paramMessage.istroop, this.a.d);
  }
  
  public boolean a(AIOContext paramAIOContext, MessageRecord paramMessageRecord, Message paramMessage)
  {
    return a(paramMessage);
  }
  
  public boolean a(boolean paramBoolean)
  {
    return b();
  }
  
  public CharSequence b(AIOContext paramAIOContext, MessageRecord paramMessageRecord, Message paramMessage)
  {
    return null;
  }
  
  public boolean b()
  {
    boolean bool = a(this.a.ah.b, this.a.ah.a, this.a.d);
    if (bool)
    {
      Intent localIntent = this.a.f.getIntent();
      if (localIntent.getIntExtra("entrance", 0) == 2) {
        localIntent.putExtra("FromType", 2);
      }
      localIntent.putExtra("back_for_hidden_chat", true);
      a(this.a.f, HiddenChatFragment.class);
      localIntent.removeExtra("back_for_hidden_chat");
    }
    return bool;
  }
  
  public int bM_()
  {
    return 0;
  }
  
  public boolean d(int paramInt)
  {
    return (paramInt == 0) && (b());
  }
  
  public void e(int paramInt) {}
  
  public String getTag()
  {
    return "HiddenChatHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 10 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt == 10)
    {
      if (a(this.a.ah.b, this.a.ah.a, this.a.d)) {
        ReportController.b(null, "dc00898", "", "", "0X800A34E", "0X800A34E", this.a.f.getIntent().getIntExtra("hidden_aio_msg_source", 999), 0, "0", "0", "", "");
      }
      FrameHelperActivity.c("aio opened");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.HiddenChatHelper
 * JD-Core Version:    0.7.0.1
 */