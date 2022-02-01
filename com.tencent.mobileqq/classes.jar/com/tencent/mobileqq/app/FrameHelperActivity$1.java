package com.tencent.mobileqq.app;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.recent.DrawerFrame.IDrawerCallbacks;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.push.api.IKanDianMergeManager;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.statemachine.api.IStateManager;
import com.tencent.util.DrawerCoverUtil;
import com.tencent.widget.UpSideDownDrawable;

class FrameHelperActivity$1
  implements DrawerFrame.IDrawerCallbacks
{
  FrameHelperActivity$1(FrameHelperActivity paramFrameHelperActivity) {}
  
  public void a(int paramInt)
  {
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onDrawerStartMoving:: side = ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" getActivity = ");
      ((StringBuilder)localObject1).append(this.a.C());
      ((StringBuilder)localObject1).append(" mDrawerBg= ");
      ((StringBuilder)localObject1).append(this.a.ai);
      QLog.i("Q.recent", 4, ((StringBuilder)localObject1).toString());
    }
    if (this.a.C() == null) {
      return;
    }
    Object localObject1 = this.a.ai;
    int i = 0;
    if (localObject1 != null) {
      FrameHelperActivity.a(this.a, false);
    }
    localObject1 = this.a.ak;
    int j = localObject1.length;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (localObject2 != null) {
        localObject2.a(paramInt);
      }
      i += 1;
    }
    this.a.d(true);
  }
  
  @TargetApi(11)
  public void a(int paramInt, float paramFloat)
  {
    boolean bool = QLog.isDevelopLevel();
    int i = 0;
    if ((bool) && (FrameHelperActivity.d(this.a)))
    {
      FrameHelperActivity.b(this.a, false);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onDrawerMoving:: side = ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" getActivity = ");
      ((StringBuilder)localObject1).append(this.a.C());
      QLog.i("Q.recent", 4, ((StringBuilder)localObject1).toString());
    }
    if (this.a.C() == null) {
      return;
    }
    if ((!this.a.C().isFinishing()) && (FrameHelperActivity.a(this.a) != null) && (DrawerCoverUtil.b()))
    {
      localObject1 = FrameHelperActivity.a(this.a).a(DrawerCoverUtil.a);
      if (localObject1 != null) {
        ((UpSideDownDrawable)localObject1).pause();
      }
    }
    int j = Build.VERSION.SDK_INT;
    Object localObject1 = this.a.ak;
    j = localObject1.length;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (localObject2 != null) {
        localObject2.a(paramInt, paramFloat);
      }
      i += 1;
    }
    this.a.d(true);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    FrameHelperActivity.b(this.a, true);
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onDrawerOpened:: side = ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(" getActivity = ");
      ((StringBuilder)localObject1).append(this.a.C());
      QLog.i("Q.recent", 4, ((StringBuilder)localObject1).toString());
    }
    if (this.a.C() == null) {
      return;
    }
    if ((!this.a.C().isFinishing()) && (FrameHelperActivity.a(this.a) != null) && (!this.a.ap))
    {
      QLog.d("Q.recent", 1, "FrameHelperActivity#onDrawerOpened: trigger onResume");
      FrameHelperActivity.a(this.a).a();
    }
    Object localObject1 = this.a;
    ((FrameHelperActivity)localObject1).ap = true;
    ((FrameHelperActivity)localObject1).a(paramInt2, true, FrameHelperActivity.b((FrameHelperActivity)localObject1));
    localObject1 = (QQAppInterface)this.a.C().getAppRuntime();
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "[setDrawerBg(app)]from DrawerOpened");
    }
    this.a.q.sendEmptyMessage(14);
    if ((!this.a.C().isFinishing()) && (FrameHelperActivity.a(this.a) != null) && (DrawerCoverUtil.b()))
    {
      localObject1 = FrameHelperActivity.a(this.a).a(DrawerCoverUtil.a);
      if (localObject1 != null) {
        if (paramInt2 == 1) {
          ((UpSideDownDrawable)localObject1).resume();
        } else {
          ((UpSideDownDrawable)localObject1).start();
        }
      }
    }
    int i = Build.VERSION.SDK_INT;
    localObject1 = this.a.ak;
    int j = localObject1.length;
    i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (localObject2 != null) {
        localObject2.a(paramInt1, paramInt2);
      }
      i += 1;
    }
    FrameHelperActivity.c(this.a);
    this.a.d(true);
    ReadInJoyLogicEngineEventDispatcher.a().l();
    this.a.o();
    ((IStateManager)QRoute.api(IStateManager.class)).onMainDrawerChange(true);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onDrawerStartToggle:: side = ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" open:");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(" getActivity = ");
      ((StringBuilder)localObject1).append(this.a.C());
      QLog.i("Q.recent", 4, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.a.ak;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (localObject2 != null) {
        localObject2.a(paramInt, paramBoolean);
      }
      i += 1;
    }
    if (paramBoolean) {
      ThreadManager.post(new FrameHelperActivity.1.1(this), 5, null, true);
    }
    this.a.d(paramBoolean);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onDrawerClosed:: side = ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(" getActivity = ");
      ((StringBuilder)localObject1).append(this.a.C());
      QLog.i("Q.recent", 4, ((StringBuilder)localObject1).toString());
    }
    if (this.a.C() == null) {
      return;
    }
    QLog.d("Q.recent", 1, "FrameHelperActivity#onDrawerClosed: misDrawerOpened=false");
    Object localObject1 = this.a;
    ((FrameHelperActivity)localObject1).ap = false;
    ((FrameHelperActivity)localObject1).a(paramInt2, false, FrameHelperActivity.b((FrameHelperActivity)localObject1));
    if ((!this.a.C().isFinishing()) && (FrameHelperActivity.a(this.a) != null))
    {
      FrameHelperActivity.a(this.a).b();
      if (DrawerCoverUtil.b())
      {
        localObject1 = FrameHelperActivity.a(this.a).a(DrawerCoverUtil.a);
        if (localObject1 != null) {
          ((UpSideDownDrawable)localObject1).stop();
        }
      }
    }
    if (Build.VERSION.SDK_INT < 11)
    {
      if (this.a.ab != null) {
        this.a.ab.setVisibility(0);
      }
      if (this.a.ad != null) {
        this.a.ad.setVisibility(0);
      }
    }
    if (this.a.ai != null) {
      ((ImageView)this.a.ai.findViewById(2131449131)).setImageResource(0);
    }
    localObject1 = this.a.ak;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (localObject2 != null) {
        localObject2.b(paramInt1, paramInt2);
      }
      i += 1;
    }
    this.a.d(false);
    localObject1 = (QQAppInterface)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime();
    if (localObject1 != null) {
      ((IKanDianMergeManager)((QQAppInterface)localObject1).getRuntimeService(IKanDianMergeManager.class)).tryToShowAppInPush();
    }
    if (this.a.q.hasMessages(17)) {
      this.a.q.removeMessages(17);
    }
    this.a.q.sendEmptyMessageDelayed(17, 100L);
    this.a.a(paramInt1, paramInt2);
    if (QQTheme.isNowSimpleUI())
    {
      if ((this.a.y) && (this.a.s != null)) {
        ((ITabFrameController)QRoute.api(ITabFrameController.class)).updateTabSelectStatusOnTabChange(this.a, ((ITabFrameController)QRoute.api(ITabFrameController.class)).getTabIndexFromName(this.a.z()));
      }
      this.a.y = false;
    }
    ((IStateManager)QRoute.api(IStateManager.class)).onMainDrawerChange(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity.1
 * JD-Core Version:    0.7.0.1
 */