package com.tencent.mobileqq.activity.framebusiness.controllerinject;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contacts.base.Contacts;
import com.tencent.mobileqq.activity.framebusiness.NowInjectImpl;
import com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl;
import com.tencent.mobileqq.activity.framebusiness.QzoneFrameInjectImpl.ABotDragClickListener;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.IFrameControllerInterface;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.home.framejumpentry.TabJumpHelper;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.home.impl.FrameInfoBean;
import com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.activity.qcircle.QCircleFrame;
import com.tencent.mobileqq.activity.qcircle.QCircleThirdTabConfig;
import com.tencent.mobileqq.activity.recent.bannerprocessor.BBannerHelper;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameFragment.DragViewPunctureClickListener;
import com.tencent.mobileqq.app.FrameFragment.DragViewTouchListener;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.view.api.IKanDianOptUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IRIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.tab.api.IRIJTabInject;
import com.tencent.mobileqq.leba.ILebaFrameApi;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchTab;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.mobileqq.widget.QQTabWidget;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import common.config.service.QzoneConfig;
import cooperation.qzone.api.QZoneApiProxy;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class FrameControllerInjectImpl
  implements IFrameControllerInterface
{
  public int a(int paramInt)
  {
    return FrameControllerUtil.a(paramInt);
  }
  
  public int a(FrameFragment paramFrameFragment)
  {
    paramFrameFragment = (Conversation)paramFrameFragment.a(Conversation.class);
    if (paramFrameFragment != null) {
      return paramFrameFragment.jdField_d_of_type_Int;
    }
    return 0;
  }
  
  public void a(TextView paramTextView, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    CustomWidgetUtil.a(paramTextView, paramInt2, paramInt1, paramInt3, paramInt4, paramString);
  }
  
  public void a(TabFrameControllerImpl paramTabFrameControllerImpl, FrameFragment paramFrameFragment)
  {
    if (FrameFragment.d)
    {
      ((MainFragment)paramFrameFragment).jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.c();
      FrameFragment.d = false;
      ThreadManager.getUIHandler().postDelayed(new FrameControllerInjectImpl.1(this, paramFrameFragment), 2000L);
    }
    StartupTracker.a("Main_Start", null);
  }
  
  public void a(TabFrameControllerImpl paramTabFrameControllerImpl, FrameFragment paramFrameFragment, int paramInt)
  {
    ((IRIJTabInject)QRoute.api(IRIJTabInject.class)).updateKanDianTab(paramFrameFragment, paramInt);
  }
  
  public void a(TabFrameControllerImpl paramTabFrameControllerImpl, FrameFragment paramFrameFragment, boolean paramBoolean)
  {
    boolean bool2 = QCircleThirdTabConfig.a().a();
    Object localObject2 = (IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class);
    Object localObject1 = (MainFragment)paramFrameFragment;
    boolean bool3 = ((IReadInJoyHelper)localObject2).needUpdateKandianFrame(((MainFragment)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoTabKandianFrameStatus, bool2);
    boolean bool1;
    if (paramFrameFragment.g != QQTheme.f()) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramFrameFragment.g = QQTheme.f();
    if (a((QQAppInterface)paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime, paramFrameFragment.m, paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView, paramBoolean, bool3, bool1))
    {
      com.tencent.biz.now.NowLiveManager.c = false;
      ((IKanDianOptUtils)QRoute.api(IKanDianOptUtils.class)).updateMainFrameInitStatus(true);
      localObject2 = (ILebaHelperService)paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ILebaHelperService.class, "all");
      if (localObject2 != null) {
        ((ILebaHelperService)localObject2).setFlagUpdateOnPause();
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("setFrames");
        ((StringBuilder)localObject2).append(((QQAppInterface)paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime).isCallTabShow);
        QLog.i("FrameControllerInjectImpl", 2, ((StringBuilder)localObject2).toString());
      }
      if (paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost != null) {
        paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.clearAllTabs();
      }
      int j = paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView.length;
      int i = 0;
      while (i < j)
      {
        localObject2 = paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[i];
        if (localObject2 != null)
        {
          ((View)localObject2).setSelected(false);
          ((View)localObject2).setId(i + 16);
        }
        i += 1;
      }
      paramTabFrameControllerImpl.initTabIndex(((QQAppInterface)paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime).isCallTabShow, -100, bool2);
      paramTabFrameControllerImpl.initTabDragIconsAbdTextVuews(paramFrameFragment);
      localObject2 = paramFrameFragment.a(Conversation.class);
      if (localObject2 != null) {
        ((Conversation)localObject2).h(true);
      }
      paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[1] = null;
      NowInjectImpl.h(paramFrameFragment);
      paramTabFrameControllerImpl.addFrame(paramFrameFragment, paramFrameFragment.jdField_a_of_type_AndroidViewView, Conversation.class, paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[0]);
      paramTabFrameControllerImpl.addFrame(paramFrameFragment, paramFrameFragment.jdField_a_of_type_AndroidViewView, Contacts.class, paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[2]);
      if (bool2)
      {
        if (paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[6] == null) {
          ((IRIJTabInject)QRoute.api(IRIJTabInject.class)).initKanDianTab(paramFrameFragment);
        }
        paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[6].setId(22);
        localObject2 = (TabDragAnimationView)paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[6].findViewById(2131378232);
        TextView localTextView = (TextView)paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[6].findViewById(2131379917);
        if ((localTextView != null) && (localObject2 != null))
        {
          ((TabDragAnimationView)localObject2).setOnTouchListener(new FrameFragment.DragViewTouchListener());
          ((TabDragAnimationView)localObject2).setPressChanged(false);
          localTextView.setTextColor(paramFrameFragment.getResources().getColor(2131167265));
          ((TabDragAnimationView)localObject2).a(paramFrameFragment.getResources().getString(2131696404));
          paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.put(FrameControllerUtil.g, localObject2);
          paramFrameFragment.jdField_b_of_type_AndroidUtilSparseArray.put(FrameControllerUtil.g, localTextView);
          paramFrameFragment.a(((IRIJXTabFrameUtils)QRoute.api(IRIJXTabFrameUtils.class)).getPreFrameClass(((MainFragment)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoTabKandianFrameStatus));
          paramTabFrameControllerImpl.addFrame(paramFrameFragment, paramFrameFragment.jdField_a_of_type_AndroidViewView, ((IRIJXTabFrameUtils)QRoute.api(IRIJXTabFrameUtils.class)).getTabFrame(), paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[6]);
          ((IRIJXTabFrameUtils)QRoute.api(IRIJXTabFrameUtils.class)).updateFrameStatus(((MainFragment)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoTabKandianFrameStatus, true);
        }
        ((IRIJTabInject)QRoute.api(IRIJTabInject.class)).updateKanDianTab(paramFrameFragment, 3);
        if (!FrameFragment.d) {
          ((IRIJTabInject)QRoute.api(IRIJTabInject.class)).updateKanDianRedTouch(paramFrameFragment);
        }
        if (paramFrameFragment.jdField_b_of_type_AndroidContentIntent != null)
        {
          localObject1 = paramFrameFragment.jdField_b_of_type_AndroidContentIntent.getExtras();
          if (localObject1 != null)
          {
            i = ((Bundle)localObject1).getInt("tab_index");
            if (i == 2) {
              paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setCurrentTab(i);
            }
          }
          paramFrameFragment.jdField_b_of_type_AndroidContentIntent = null;
        }
      }
      else
      {
        paramFrameFragment.a(((IRIJXTabFrameUtils)QRoute.api(IRIJXTabFrameUtils.class)).getPreFrameClass(((MainFragment)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoTabKandianFrameStatus));
        paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.remove(FrameControllerUtil.g);
        paramFrameFragment.jdField_b_of_type_AndroidUtilSparseArray.remove(FrameControllerUtil.g);
        ((IRIJXTabFrameUtils)QRoute.api(IRIJXTabFrameUtils.class)).updateFrameStatus(((MainFragment)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoTabKandianFrameStatus, false);
      }
      QCircleInjectImpl.a(paramTabFrameControllerImpl, paramFrameFragment);
      paramFrameFragment.jdField_a_of_type_JavaUtilHashMap.put(FrameControllerUtil.jdField_d_of_type_JavaLangString, paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[3]);
      localObject1 = paramFrameFragment.jdField_a_of_type_JavaUtilHashMap;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(FrameControllerUtil.jdField_d_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("_num");
      ((HashMap)localObject1).put(((StringBuilder)localObject2).toString(), paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[3].findViewById(2131380161));
      if (QZoneApiProxy.needShowQzoneFrame(paramFrameFragment.a(), (QQAppInterface)paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime))
      {
        paramFrameFragment.m = true;
        paramFrameFragment.a(((ILebaFrameApi)QRoute.api(ILebaFrameApi.class)).getLebaFrameClass());
        paramTabFrameControllerImpl.addFrame(paramFrameFragment, paramFrameFragment.jdField_a_of_type_AndroidViewView, QzoneFrame.class, paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[7]);
        paramFrameFragment.jdField_a_of_type_JavaUtilHashMap.put(FrameControllerUtil.jdField_c_of_type_JavaLangString, paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[7]);
        localObject1 = paramFrameFragment.jdField_a_of_type_JavaUtilHashMap;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(FrameControllerUtil.jdField_c_of_type_JavaLangString);
        ((StringBuilder)localObject2).append("_num");
        ((HashMap)localObject1).put(((StringBuilder)localObject2).toString(), paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[7].findViewById(2131380161));
        localObject1 = (TabDragAnimationView)paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[7].findViewById(2131378232);
        localObject2 = (TextView)paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[7].findViewById(2131379917);
        paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.put(FrameControllerUtil.i, localObject1);
        paramFrameFragment.jdField_b_of_type_AndroidUtilSparseArray.put(FrameControllerUtil.i, localObject2);
      }
      else
      {
        if (QZoneApiProxy.isQzoneInstalled()) {
          paramFrameFragment.m = true;
        }
        paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.remove(FrameControllerUtil.i);
        paramFrameFragment.jdField_b_of_type_AndroidUtilSparseArray.remove(FrameControllerUtil.i);
        paramFrameFragment.a(QzoneFrame.class);
        paramTabFrameControllerImpl.addFrame(paramFrameFragment, paramFrameFragment.jdField_a_of_type_AndroidViewView, ((ILebaFrameApi)QRoute.api(ILebaFrameApi.class)).getLebaFrameClass(), paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[3]);
      }
      ((IKanDianOptUtils)QRoute.api(IKanDianOptUtils.class)).updateMainFrameInitStatus(false);
      paramTabFrameControllerImpl.checkEnableTabAnim(paramFrameFragment, false);
    }
  }
  
  public void a(FrameFragment paramFrameFragment)
  {
    if (!MultiMsgManager.a().a()) {
      MultiMsgManager.a().a((QQAppInterface)paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime);
    }
  }
  
  public void a(FrameFragment paramFrameFragment, int paramInt)
  {
    ((QQAppInterface)paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime).playThemeVoice(paramInt + 1);
  }
  
  public void a(FrameFragment paramFrameFragment, Intent paramIntent)
  {
    BBannerHelper.a((QQAppInterface)paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime, paramIntent);
  }
  
  public void a(FrameFragment paramFrameFragment, Intent paramIntent, Bundle paramBundle, int paramInt)
  {
    TabJumpHelper.a().a(paramFrameFragment, paramIntent, paramBundle, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    FrameHelperActivity.b(paramBoolean);
  }
  
  public boolean a()
  {
    return SplashActivity.currentFragment != 1;
  }
  
  public boolean a(FrameFragment paramFrameFragment)
  {
    return ((MainFragment)paramFrameFragment).jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver == null;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, View[] paramArrayOfView, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    boolean bool2 = QCircleFrame.a;
    boolean bool3 = QzoneConfig.isShowQQCircleMainTabEntrance(StudyModeManager.a());
    boolean bool1 = false;
    int i;
    if (bool2 != bool3) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if ((QQTheme.f()) && (paramBoolean1 != QZoneApiProxy.isQzoneInstalled())) {
      j = 1;
    } else {
      j = 0;
    }
    if ((!paramBoolean2) && ((!paramQQAppInterface.isCallTabShow) || (paramArrayOfView[1] != null)) && ((paramQQAppInterface.isCallTabShow) || (paramArrayOfView[1] == null)) && (paramArrayOfView[4] == null) && (!paramBoolean3) && (!paramBoolean4) && (j == 0))
    {
      paramBoolean1 = bool1;
      if (i == 0) {}
    }
    else
    {
      paramBoolean1 = true;
    }
    return paramBoolean1;
  }
  
  public View[] a(TabFrameControllerImpl paramTabFrameControllerImpl, LayoutInflater paramLayoutInflater)
  {
    boolean bool = FrameControllerUtil.a();
    View[] arrayOfView = new View[7];
    arrayOfView[0] = paramLayoutInflater.inflate(2131559323, null);
    arrayOfView[1] = ((DragFrameLayout)arrayOfView[0].findViewById(2131365172));
    Object localObject = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByIndex(FrameControllerUtil.jdField_a_of_type_Int);
    int k = -1;
    int i;
    int j;
    if (bool)
    {
      i = -1;
      j = -1;
    }
    else
    {
      i = 2130850903;
      j = 2130850904;
    }
    arrayOfView[2] = paramTabFrameControllerImpl.generateTabItem(i, ((FrameInfoBean)localObject).b(), j, ((FrameInfoBean)localObject).c(), ((FrameInfoBean)localObject).d(), ((FrameInfoBean)localObject).e(), ((FrameInfoBean)localObject).f());
    arrayOfView[2].setOnClickListener(new FrameFragment.DragViewPunctureClickListener());
    localObject = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByIndex(FrameControllerUtil.jdField_c_of_type_Int);
    if (bool)
    {
      i = -1;
      j = -1;
    }
    else
    {
      i = 2130850901;
      j = 2130850902;
    }
    localObject = paramTabFrameControllerImpl.generateTabItem(i, ((FrameInfoBean)localObject).b(), j, ((FrameInfoBean)localObject).c(), ((FrameInfoBean)localObject).d(), ((FrameInfoBean)localObject).e(), ((FrameInfoBean)localObject).f());
    ((View)localObject).setOnClickListener(new FrameFragment.DragViewPunctureClickListener());
    arrayOfView[3] = new RedTouchTab(paramLayoutInflater.getContext(), (View)localObject).b(49).e(3).a(true).c(5).a();
    FrameInfoBean localFrameInfoBean = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByIndex(FrameControllerUtil.jdField_d_of_type_Int);
    if (bool) {
      i = k;
    } else {
      i = 2130850906;
    }
    localObject = paramTabFrameControllerImpl.generateTabItem(-1, localFrameInfoBean.b(), i, localFrameInfoBean.c(), localFrameInfoBean.d(), localFrameInfoBean.e(), localFrameInfoBean.f());
    ((View)localObject).setOnClickListener(new QzoneFrameInjectImpl.ABotDragClickListener((View)localObject, "lebaTab"));
    arrayOfView[4] = new RedTouchTab(paramLayoutInflater.getContext(), (View)localObject).b(49).e(3).a(true).c(5).a();
    View localView = paramTabFrameControllerImpl.generateTabItem(-1, localFrameInfoBean.b(), i, localFrameInfoBean.c(), localFrameInfoBean.d(), localFrameInfoBean.e(), localFrameInfoBean.f());
    localView.setOnClickListener(new QzoneFrameInjectImpl.ABotDragClickListener(localView, "lebaTabNew"));
    arrayOfView[5] = new RedTouchTab(paramLayoutInflater.getContext(), localView).b(49).e(3).a(true).c(5).a();
    paramTabFrameControllerImpl = paramTabFrameControllerImpl.generateTabItem(-1, localFrameInfoBean.b(), i, localFrameInfoBean.c(), localFrameInfoBean.d(), localFrameInfoBean.e(), localFrameInfoBean.f());
    paramTabFrameControllerImpl.setOnClickListener(new QzoneFrameInjectImpl.ABotDragClickListener((View)localObject, "QzoneTab"));
    arrayOfView[6] = new RedTouchTab(paramLayoutInflater.getContext(), paramTabFrameControllerImpl).b(49).e(3).a(true).c(5).a();
    return arrayOfView;
  }
  
  public View[] a(TabFrameControllerImpl paramTabFrameControllerImpl, FrameFragment paramFrameFragment, View paramView)
  {
    paramFrameFragment.jdField_a_of_type_JavaUtilHashMap = new HashMap(9);
    paramFrameFragment.jdField_b_of_type_JavaUtilHashMap = new HashMap(13);
    boolean bool = FrameControllerUtil.a();
    Object localObject1 = ((SplashActivity)paramFrameFragment.a()).mPreloadMainViews;
    ((SplashActivity)paramFrameFragment.a()).mPreloadMainViews = null;
    if (localObject1 != null)
    {
      paramFrameFragment.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = ((DragFrameLayout)localObject1[1]);
      paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView = new View[] { localObject1[2], null, localObject1[3], localObject1[4], null, localObject1[5], null, localObject1[6], null };
    }
    else
    {
      paramFrameFragment.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = ((DragFrameLayout)paramView.findViewById(2131365172));
      localObject1 = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByIndex(FrameControllerUtil.jdField_c_of_type_Int);
      int j;
      if (bool)
      {
        i = -1;
        j = -1;
      }
      else
      {
        i = 2130850901;
        j = 2130850901;
      }
      localObject1 = paramTabFrameControllerImpl.generateTabItem(i, ((FrameInfoBean)localObject1).b(), j, ((FrameInfoBean)localObject1).c(), ((FrameInfoBean)localObject1).d(), ((FrameInfoBean)localObject1).e(), ((FrameInfoBean)localObject1).f());
      ((View)localObject1).setOnClickListener(new FrameFragment.DragViewPunctureClickListener());
      Object localObject3 = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByIndex(FrameControllerUtil.jdField_d_of_type_Int);
      int i = 2130850906;
      if (bool) {
        i = -1;
      }
      localObject2 = paramTabFrameControllerImpl.generateTabItem(-1, ((FrameInfoBean)localObject3).b(), i, ((FrameInfoBean)localObject3).c(), ((FrameInfoBean)localObject3).d(), ((FrameInfoBean)localObject3).e(), ((FrameInfoBean)localObject3).f());
      ((View)localObject2).setOnClickListener(new QzoneFrameInjectImpl.ABotDragClickListener((View)localObject2, "lebaTab"));
      View localView1 = paramTabFrameControllerImpl.generateTabItem(-1, ((FrameInfoBean)localObject3).b(), i, ((FrameInfoBean)localObject3).c(), ((FrameInfoBean)localObject3).d(), ((FrameInfoBean)localObject3).e(), ((FrameInfoBean)localObject3).f());
      localView1.setOnClickListener(new QzoneFrameInjectImpl.ABotDragClickListener(localView1, "qzoneTab"));
      localObject3 = paramTabFrameControllerImpl.generateTabItem(-1, ((FrameInfoBean)localObject3).b(), i, ((FrameInfoBean)localObject3).c(), ((FrameInfoBean)localObject3).d(), ((FrameInfoBean)localObject3).e(), ((FrameInfoBean)localObject3).f());
      ((View)localObject3).setOnClickListener(new QzoneFrameInjectImpl.ABotDragClickListener((View)localObject3, "lebaTabNew"));
      ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByIndex(FrameControllerUtil.f);
      View localView2 = paramTabFrameControllerImpl.generateTabItem(2130846735, 2130850752, 2130846736, 2130850753, 2131699899, 15, 5);
      localView2.setOnClickListener(new FrameFragment.DragViewPunctureClickListener());
      FrameInfoBean localFrameInfoBean = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByIndex(FrameControllerUtil.jdField_a_of_type_Int);
      if (bool)
      {
        i = -1;
        j = -1;
      }
      else
      {
        i = 2130850903;
        j = 2130850904;
      }
      paramTabFrameControllerImpl = paramTabFrameControllerImpl.generateTabItem(i, localFrameInfoBean.b(), j, localFrameInfoBean.c(), localFrameInfoBean.d(), localFrameInfoBean.e(), localFrameInfoBean.f());
      paramTabFrameControllerImpl.setOnClickListener(new FrameFragment.DragViewPunctureClickListener());
      paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView = new View[] { paramTabFrameControllerImpl, null, new RedTouchTab(paramFrameFragment.a(), (View)localObject1).b(49).e(3).a(true).c(5).a(), new RedTouchTab(paramFrameFragment.a(), (View)localObject2).b(49).e(3).a(true).c(5).a(), new RedTouchTab(paramFrameFragment.a(), localView2).b(49).e(3).a(true).c(5).a(), new RedTouchTab(paramFrameFragment.a(), (View)localObject3).b(49).e(3).a(true).c(5).a(), null, new RedTouchTab(paramFrameFragment.a(), localView1).b(49).e(3).a(true).c(5).a(), null };
    }
    localObject1 = paramFrameFragment.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
    paramTabFrameControllerImpl = (MainFragment)paramFrameFragment;
    ((DragFrameLayout)localObject1).setOnDragListener(paramTabFrameControllerImpl.jdField_a_of_type_ComTencentMobileqqActivityRecentCurTabDragListener);
    paramFrameFragment.jdField_a_of_type_JavaUtilHashMap.put(FrameControllerUtil.jdField_a_of_type_JavaLangString, paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[0]);
    paramFrameFragment.jdField_a_of_type_JavaUtilHashMap.put(FrameControllerUtil.b, paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[2]);
    paramFrameFragment.jdField_a_of_type_JavaUtilHashMap.put(FrameControllerUtil.jdField_d_of_type_JavaLangString, paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[3]);
    paramFrameFragment.jdField_a_of_type_JavaUtilHashMap.put(FrameControllerUtil.jdField_c_of_type_JavaLangString, paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[7]);
    localObject1 = paramFrameFragment.jdField_a_of_type_JavaUtilHashMap;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(FrameControllerUtil.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject2).append("_num");
    ((HashMap)localObject1).put(((StringBuilder)localObject2).toString(), paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131380161));
    localObject1 = paramFrameFragment.jdField_a_of_type_JavaUtilHashMap;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(FrameControllerUtil.b);
    ((StringBuilder)localObject2).append("_num");
    ((HashMap)localObject1).put(((StringBuilder)localObject2).toString(), paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[2].findViewById(2131380161));
    localObject1 = paramFrameFragment.jdField_a_of_type_JavaUtilHashMap;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(FrameControllerUtil.jdField_d_of_type_JavaLangString);
    ((StringBuilder)localObject2).append("_num");
    ((HashMap)localObject1).put(((StringBuilder)localObject2).toString(), paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[3].findViewById(2131380161));
    localObject1 = paramFrameFragment.jdField_a_of_type_JavaUtilHashMap;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(FrameControllerUtil.jdField_c_of_type_JavaLangString);
    ((StringBuilder)localObject2).append("_num");
    ((HashMap)localObject1).put(((StringBuilder)localObject2).toString(), paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[7].findViewById(2131380161));
    localObject1 = (TabDragAnimationView)paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131378232);
    ((TabDragAnimationView)localObject1).setTag(FrameControllerUtil.jdField_a_of_type_JavaLangString);
    ((TabDragAnimationView)localObject1).setOnDragListener(new FrameControllerInjectImpl.2(this, paramFrameFragment));
    ((TabDragAnimationView)localObject1).setOnLongClickListener(new FrameControllerInjectImpl.3(this, paramFrameFragment));
    paramView = (QQTabWidget)paramView.findViewById(16908307);
    if (paramView != null)
    {
      paramView.setShowDividers(0);
      paramView.setTabWidgetMoveListener(paramTabFrameControllerImpl.jdField_a_of_type_ComTencentMobileqqWidgetQQTabWidget$onTabWidgetTouchMoveListener);
    }
    else
    {
      QLog.i("FrameControllerInjectImpl", 1, "initTabs tabWidget is null");
    }
    return paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.controllerinject.FrameControllerInjectImpl
 * JD-Core Version:    0.7.0.1
 */