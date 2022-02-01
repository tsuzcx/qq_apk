package com.tencent.mobileqq.activity.aio.navigate;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.drawer.BaseChatDrawer;
import com.tencent.mobileqq.activity.aio.helper.ChatDrawerHelper;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class IntimateInfoNavBar
  extends NavigateBar
  implements Animation.AnimationListener
{
  private ImageView g;
  private Animation h;
  
  public IntimateInfoNavBar(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    super(paramBaseChatPie, paramQQAppInterface, paramContext, paramSessionInfo, paramInt1, paramInt2);
  }
  
  public View a()
  {
    View localView = LayoutInflater.from(this.c).inflate(2131627275, null);
    this.g = ((ImageView)localView.findViewById(2131428783));
    TextView localTextView = (TextView)localView.findViewById(2131447416);
    return localView;
  }
  
  public void b()
  {
    if ((this.a != null) && (((ChatDrawerHelper)this.a.q(124)).b != null)) {
      ((ChatDrawerHelper)this.a.q(124)).b.b(true);
    }
    ReportController.b(null, "dc00898", "", "", "0X800A11D", "0X800A11D", 0, 0, "", "", "", "");
  }
  
  public boolean c()
  {
    if ((this.a != null) && (((ChatDrawerHelper)this.a.q(124)).b != null))
    {
      Object localObject = ((FriendsManager)this.b.getManager(QQManagerFactory.FRIENDS_MANAGER)).d(this.a.ah.b, false);
      if ((localObject != null) && (((ExtensionInfo)localObject).intimate_type != 0))
      {
        localObject = this.b.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("IntimateInfo");
        localStringBuilder.append(this.b.getCurrentAccountUin());
        int i = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getInt("key_aio_score_guide_count", 0);
        if (QLog.isColorLevel()) {
          QLog.d("NavigateBarManager.IntimateInfoNavBar", 2, String.format("needShow score guide count: %s", new Object[] { Integer.valueOf(i) }));
        }
        return i < 3;
      }
      return false;
    }
    QLog.d("NavigateBarManager.IntimateInfoNavBar", 1, "mChatPie == null || mChatPie.mChatDrawer == null");
    return false;
  }
  
  public void d()
  {
    this.g.postDelayed(new IntimateInfoNavBar.1(this), 500L);
    ThreadManager.postImmediately(new IntimateInfoNavBar.2(this), null, false);
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
 * Qualified Name:     com.tencent.mobileqq.activity.aio.navigate.IntimateInfoNavBar
 * JD-Core Version:    0.7.0.1
 */