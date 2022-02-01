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
import com.tencent.mobileqq.activity.aio.helper.ChatDrawerHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.multicard.manager.TroopMemberRecommendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class TroopDNANavBar
  extends NavigateBar
  implements Animation.AnimationListener
{
  private ImageView g;
  private Animation h;
  
  public TroopDNANavBar(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    super(paramBaseChatPie, paramQQAppInterface, paramContext, paramSessionInfo, paramInt1, paramInt2);
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
        return "troop_dna_aio_guide_counts";
      }
    }
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("troop_dna_aio_guide_counts");
    paramQQAppInterface.append(((QQAppInterface)localObject).getCurrentAccountUin());
    return paramQQAppInterface.toString();
  }
  
  public static void h()
  {
    ThreadManager.postImmediately(new TroopDNANavBar.3(), null, false);
  }
  
  public View a()
  {
    View localView = LayoutInflater.from(this.c).inflate(2131627292, null);
    this.g = ((ImageView)localView.findViewById(2131428783));
    return localView;
  }
  
  public void b()
  {
    if ((this.a != null) && (((ChatDrawerHelper)this.a.q(124)).b != null)) {
      ((ChatDrawerHelper)this.a.q(124)).b.b(true);
    }
    ReportController.b(null, "dc00898", "", "", "0X800A469", "0X800A469", 0, 0, "", "", "", "");
  }
  
  public boolean c()
  {
    boolean bool = TroopMemberRecommendManager.a(this.a.d).a(this.a.ah.c);
    if ((this.a != null) && (((ChatDrawerHelper)this.a.q(124)).b != null))
    {
      int i = PreferenceManager.getDefaultSharedPreferences(this.c).getInt(a(this.b), 0);
      if (QLog.isColorLevel()) {
        QLog.d("NavigateBarManager.TroopDNANavBar", 2, String.format("needShow guide count: %s", new Object[] { Integer.valueOf(i) }));
      }
      return (bool) && (i < 3);
    }
    QLog.d("NavigateBarManager.TroopDNANavBar", 1, "mChatPie == null || mChatPie.mChatDrawer == null");
    return false;
  }
  
  public void d()
  {
    this.g.postDelayed(new TroopDNANavBar.1(this), 500L);
    ThreadManager.postImmediately(new TroopDNANavBar.2(this), null, false);
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
 * Qualified Name:     com.tencent.mobileqq.activity.aio.navigate.TroopDNANavBar
 * JD-Core Version:    0.7.0.1
 */