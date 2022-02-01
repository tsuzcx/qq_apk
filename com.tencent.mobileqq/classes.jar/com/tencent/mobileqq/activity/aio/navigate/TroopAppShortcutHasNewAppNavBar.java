package com.tencent.mobileqq.activity.aio.navigate;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.drawer.BaseChatDrawer;
import com.tencent.mobileqq.activity.aio.drawer.TroopAppShortcutDrawer;
import com.tencent.mobileqq.activity.aio.helper.ChatDrawerHelper;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.troopreddot.api.ITroopRedDotHandler;
import com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi;
import com.tencent.qphone.base.util.QLog;

public class TroopAppShortcutHasNewAppNavBar
  extends NavigateBar
  implements Animation.AnimationListener
{
  private ImageView g;
  private Animation h;
  private TextView i;
  private QQAppInterface j;
  private long k = 0L;
  
  public TroopAppShortcutHasNewAppNavBar(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    super(paramBaseChatPie, paramQQAppInterface, paramContext, paramSessionInfo, paramInt1, paramInt2);
    this.j = paramQQAppInterface;
    paramBaseChatPie = (TroopManager)this.a.d.getManager(QQManagerFactory.TROOP_MANAGER);
    if ((paramBaseChatPie != null) && (this.a.ah != null))
    {
      paramBaseChatPie = paramBaseChatPie.g(this.a.ah.b);
      if (paramBaseChatPie != null) {
        this.k = paramBaseChatPie.dwGroupClassExt;
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
  
  public View a()
  {
    View localView = LayoutInflater.from(this.c).inflate(2131627293, null);
    this.g = ((ImageView)localView.findViewById(2131428783));
    this.i = ((TextView)localView.findViewById(2131447416));
    this.i.setText("管理员新增了应用");
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
        ((BaseChatDrawer)localObject).b(false);
        if ((localObject instanceof TroopAppShortcutDrawer)) {
          ((TroopAppShortcutDrawer)localObject).c(4);
        }
      }
    }
    if ((this.a != null) && (this.a.ah != null)) {
      localObject = this.a.ah.c;
    } else {
      localObject = "";
    }
    ReportController.b(null, "dc00898", "", (String)localObject, "0X800AFB9", "0X800AFB9", 0, 0, String.valueOf(this.k), "", "", "");
  }
  
  public boolean c()
  {
    if (this.a == null)
    {
      QLog.d("NavigateBarManager.TroopAppShortcutHasNewAppNavBar", 1, "mChatPie == null");
      return false;
    }
    int m = PreferenceManager.getDefaultSharedPreferences(this.c).getInt(a(this.b), 0);
    if (QLog.isColorLevel()) {
      QLog.d("NavigateBarManager.TroopAppShortcutHasNewAppNavBar", 2, String.format("needShow guide count: %s", new Object[] { Integer.valueOf(m) }));
    }
    return (((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).getTroopHasNewApp(this.a.d, this.a.ag())) && (m >= 3);
  }
  
  public void d()
  {
    ReportController.b(null, "dc00898", "", this.a.ah.c, "0X800AFB8", "0X800AFB8", 0, 0, String.valueOf(this.k), "", "", "");
    if (this.a.ah != null)
    {
      ((ITroopRedDotHandler)this.j.getBusinessHandler(BusinessHandlerFactory.TROOP_RED_DOT_HANDLER)).a(this.a.ah.b, 101872323);
      ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setTroopHasNewApp(this.j, this.a.ah.b, false);
    }
    this.g.postDelayed(new TroopAppShortcutHasNewAppNavBar.1(this), 500L);
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
 * Qualified Name:     com.tencent.mobileqq.activity.aio.navigate.TroopAppShortcutHasNewAppNavBar
 * JD-Core Version:    0.7.0.1
 */