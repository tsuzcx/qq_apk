package com.tencent.mobileqq.app;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.recent.DrawerFrame.IDrawerCallbacks;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.push.api.IKanDianMergeManager;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
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
      ((StringBuilder)localObject1).append(this.a.a());
      ((StringBuilder)localObject1).append(" mDrawerBg= ");
      ((StringBuilder)localObject1).append(this.a.jdField_a_of_type_AndroidViewViewGroup);
      QLog.i("Q.recent", 4, ((StringBuilder)localObject1).toString());
    }
    if (this.a.a() == null) {
      return;
    }
    Object localObject1 = this.a.jdField_a_of_type_AndroidViewViewGroup;
    int i = 0;
    if (localObject1 != null) {
      FrameHelperActivity.a(this.a, false);
    }
    localObject1 = this.a.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks;
    int j = localObject1.length;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (localObject2 != null) {
        localObject2.a(paramInt);
      }
      i += 1;
    }
    this.a.c(true);
  }
  
  @TargetApi(11)
  public void a(int paramInt, float paramFloat)
  {
    boolean bool = QLog.isDevelopLevel();
    int i = 0;
    if ((bool) && (FrameHelperActivity.b(this.a)))
    {
      FrameHelperActivity.a(this.a, false);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onDrawerMoving:: side = ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" getActivity = ");
      ((StringBuilder)localObject1).append(this.a.a());
      QLog.i("Q.recent", 4, ((StringBuilder)localObject1).toString());
    }
    if (this.a.a() == null) {
      return;
    }
    if ((!this.a.a().isFinishing()) && (FrameHelperActivity.a(this.a) != null) && (DrawerCoverUtil.a()))
    {
      localObject1 = FrameHelperActivity.a(this.a).a(DrawerCoverUtil.a);
      if (localObject1 != null) {
        ((UpSideDownDrawable)localObject1).pause();
      }
    }
    int j = Build.VERSION.SDK_INT;
    Object localObject1 = this.a.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks;
    j = localObject1.length;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (localObject2 != null) {
        localObject2.a(paramInt, paramFloat);
      }
      i += 1;
    }
    this.a.c(true);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    FrameHelperActivity.a(this.a, true);
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onDrawerOpened:: side = ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(" getActivity = ");
      ((StringBuilder)localObject1).append(this.a.a());
      QLog.i("Q.recent", 4, ((StringBuilder)localObject1).toString());
    }
    if (this.a.a() == null) {
      return;
    }
    if ((!this.a.a().isFinishing()) && (FrameHelperActivity.a(this.a) != null) && (!FrameHelperActivity.a(this.a)))
    {
      QLog.d("Q.recent", 1, "FrameHelperActivity#onDrawerOpened: trigger onResume");
      FrameHelperActivity.a(this.a).a();
    }
    FrameHelperActivity.b(this.a, true);
    Object localObject1 = this.a;
    ((FrameHelperActivity)localObject1).a(paramInt2, true, FrameHelperActivity.a((FrameHelperActivity)localObject1));
    localObject1 = (QQAppInterface)this.a.a().getAppRuntime();
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "[setDrawerBg(app)]from DrawerOpened");
    }
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(14);
    if ((!this.a.a().isFinishing()) && (FrameHelperActivity.a(this.a) != null) && (DrawerCoverUtil.a()))
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
    localObject1 = this.a.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks;
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
    FrameHelperActivity.a(this.a);
    this.a.c(true);
    ReadInJoyLogicEngineEventDispatcher.a().l();
    this.a.k();
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
      ((StringBuilder)localObject1).append(this.a.a());
      QLog.i("Q.recent", 4, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.a.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks;
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
    this.a.c(paramBoolean);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onDrawerClosed:: side = ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(" getActivity = ");
      ((StringBuilder)localObject1).append(this.a.a());
      QLog.i("Q.recent", 4, ((StringBuilder)localObject1).toString());
    }
    if (this.a.a() == null) {
      return;
    }
    QLog.d("Q.recent", 1, "FrameHelperActivity#onDrawerClosed: misDrawerOpened=false");
    FrameHelperActivity.b(this.a, false);
    Object localObject1 = this.a;
    ((FrameHelperActivity)localObject1).a(paramInt2, false, FrameHelperActivity.a((FrameHelperActivity)localObject1));
    if ((!this.a.a().isFinishing()) && (FrameHelperActivity.a(this.a) != null))
    {
      FrameHelperActivity.a(this.a).b();
      if (DrawerCoverUtil.a())
      {
        localObject1 = FrameHelperActivity.a(this.a).a(DrawerCoverUtil.a);
        if (localObject1 != null) {
          ((UpSideDownDrawable)localObject1).stop();
        }
      }
    }
    if (Build.VERSION.SDK_INT < 11)
    {
      if (this.a.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.setVisibility(0);
      }
    }
    if (this.a.jdField_a_of_type_AndroidViewViewGroup != null) {
      ((ImageView)this.a.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380213)).setImageResource(0);
    }
    localObject1 = this.a.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks;
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
    this.a.c(false);
    localObject1 = (QQAppInterface)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime();
    if (localObject1 != null) {
      ((IKanDianMergeManager)((QQAppInterface)localObject1).getRuntimeService(IKanDianMergeManager.class)).tryToShowAppInPush();
    }
    if (this.a.jdField_a_of_type_AndroidOsHandler.hasMessages(17)) {
      this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(17);
    }
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(17, 100L);
    this.a.a(paramInt1, paramInt2);
    ((IStateManager)QRoute.api(IStateManager.class)).onMainDrawerChange(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity.1
 * JD-Core Version:    0.7.0.1
 */