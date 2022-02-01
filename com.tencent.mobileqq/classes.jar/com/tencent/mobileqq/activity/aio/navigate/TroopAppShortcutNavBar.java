package com.tencent.mobileqq.activity.aio.navigate;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.drawer.BaseChatDrawer;
import com.tencent.mobileqq.activity.aio.drawer.TroopAppShortcutDrawer;
import com.tencent.mobileqq.activity.aio.helper.ChatDrawerHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class TroopAppShortcutNavBar
  extends NavigateBar
  implements Animation.AnimationListener
{
  private ImageView g;
  private Animation h;
  private long i = 0L;
  
  public TroopAppShortcutNavBar(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    super(paramBaseChatPie, paramQQAppInterface, paramContext, paramSessionInfo, paramInt1, paramInt2);
    paramBaseChatPie = (TroopManager)this.a.d.getManager(QQManagerFactory.TROOP_MANAGER);
    if (paramBaseChatPie != null)
    {
      paramBaseChatPie = paramBaseChatPie.g(this.a.ah.b);
      if (paramBaseChatPie != null) {
        this.i = paramBaseChatPie.dwGroupClassExt;
      }
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = paramQQAppInterface;
    if (paramQQAppInterface == null)
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface)) {
        paramQQAppInterface = (QQAppInterface)localObject;
      }
      localObject = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        return "troopapp_shortcut_guide_counts";
      }
    }
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("troopapp_shortcut_guide_counts");
    paramQQAppInterface.append(((QQAppInterface)localObject).getCurrentAccountUin());
    return paramQQAppInterface.toString();
  }
  
  public static void h()
  {
    ThreadManager.postImmediately(new TroopAppShortcutNavBar.3(), null, false);
  }
  
  public View a()
  {
    View localView = LayoutInflater.from(this.c).inflate(2131627293, null);
    this.g = ((ImageView)localView.findViewById(2131428783));
    return localView;
  }
  
  public void b()
  {
    Object localObject;
    if (this.a != null)
    {
      localObject = ((ChatDrawerHelper)this.a.q(124)).b;
      if (localObject != null)
      {
        ((BaseChatDrawer)localObject).a();
        ((BaseChatDrawer)localObject).b(true);
        if ((localObject instanceof TroopAppShortcutDrawer)) {
          ((TroopAppShortcutDrawer)localObject).c(4);
        }
      }
    }
    if (this.a == null) {
      localObject = "";
    } else {
      localObject = this.a.ah.b;
    }
    ReportController.b(null, "dc00898", "", (String)localObject, "0X800AD07", "0X800AD07", 0, 0, String.valueOf(this.i), "", "", "");
  }
  
  public boolean c()
  {
    if ((this.a != null) && (((ChatDrawerHelper)this.a.q(124)).b != null))
    {
      int j = PreferenceManager.getDefaultSharedPreferences(this.c).getInt(a(this.b), 0);
      if (QLog.isColorLevel()) {
        QLog.d("NavigateBarManager.TroopAppShortcutNavBar", 2, String.format("needShow guide count: %s", new Object[] { Integer.valueOf(j) }));
      }
      return j < 3;
    }
    QLog.d("NavigateBarManager.TroopAppShortcutNavBar", 1, "mChatPie == null || mChatPie.mChatDrawer == null");
    return false;
  }
  
  public void d()
  {
    ReportController.b(null, "dc00898", "", this.a.ah.b, "0X800AD06", "0X800AD06", 0, 0, String.valueOf(this.i), "", "", "");
    this.g.postDelayed(new TroopAppShortcutNavBar.1(this), 500L);
    ThreadManager.postImmediately(new TroopAppShortcutNavBar.2(this), null, false);
  }
  
  public void e() {}
  
  public void f()
  {
    this.g.clearAnimation();
  }
  
  public long g()
  {
    return 15000L;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.g.clearAnimation();
    this.g.startAnimation(this.h);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.navigate.TroopAppShortcutNavBar
 * JD-Core Version:    0.7.0.1
 */