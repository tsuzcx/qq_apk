package com.tencent.mobileqq.activity.framebusiness.controllerinject;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.common.KandianOptUtils;
import com.tencent.biz.pubaccount.readinjoy.common.RIJXTabFrameUtils;
import com.tencent.imcore.message.ConversationProxy;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contacts.base.Contacts;
import com.tencent.mobileqq.activity.framebusiness.NowInjectImpl;
import com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl;
import com.tencent.mobileqq.activity.framebusiness.RIJInjectImpl;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.IFrameControllerInterface;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.home.framejumpentry.TabJumpHelper;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.home.impl.FrameInfoBean;
import com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl;
import com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl.ABotDragClickListener;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.activity.qcircle.QCircleFrame;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.bannerprocessor.BBannerHelper;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameFragment.DragViewPunctureClickListener;
import com.tencent.mobileqq.app.FrameFragment.DragViewTouchListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.leba.ILebaFrameApi;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.qqutils.api.IQQUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchTab;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.mobileqq.widget.QQTabWidget;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.widget.CustomWidgetUtil;
import common.config.service.QzoneConfig;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class FrameControllerInjectImpl
  implements IFrameControllerInterface
{
  public int a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 0;
    case 2: 
      return 2;
    case 3: 
      return 3;
    case 1: 
      return 1;
    case 5: 
      return 5;
    case 4: 
      return 4;
    }
    return 99;
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
  
  public void a(TabFrameControllerImpl.ABotDragClickListener paramABotDragClickListener)
  {
    try
    {
      if (QSecFramework.a().a(1001).booleanValue()) {
        if (paramABotDragClickListener.jdField_a_of_type_Boolean)
        {
          View localView = paramABotDragClickListener.jdField_a_of_type_AndroidViewView;
          QSecFramework.a().a(5, 0, 1, new Object[] { Integer.valueOf(80), localView }, null);
          paramABotDragClickListener.jdField_a_of_type_Boolean = false;
          if (QLog.isColorLevel()) {
            QLog.i("FrameControllerInjectImpl", 2, "附近人机上报: lebaView onCreate, from=" + paramABotDragClickListener.jdField_a_of_type_JavaLangString);
          }
        }
        else
        {
          QSecFramework.a().a(5, 0, 2, new Object[] { Integer.valueOf(80), Integer.valueOf(1), Integer.valueOf(6), "lebaClick", null }, null);
          if (QLog.isColorLevel())
          {
            QLog.i("FrameControllerInjectImpl", 2, "附近人机上报: lebaView onClick, from=" + paramABotDragClickListener.jdField_a_of_type_JavaLangString);
            return;
          }
        }
      }
    }
    catch (Exception paramABotDragClickListener)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FrameControllerInjectImpl", 2, "ABotDragClickListener onClick exp=", paramABotDragClickListener);
      }
    }
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
    paramTabFrameControllerImpl = paramTabFrameControllerImpl.getCurrentTabTag(paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost);
    if (FrameControllerUtil.jdField_a_of_type_JavaLangString.equals(paramTabFrameControllerImpl)) {}
    try
    {
      CmGameUtil.a(paramFrameFragment.getActivity(), (Conversation)paramFrameFragment.a(Conversation.class));
      return;
    }
    catch (Throwable paramTabFrameControllerImpl)
    {
      QLog.e("FrameControllerInjectImpl", 2, "show cmgame app pop error e=" + paramTabFrameControllerImpl.toString());
    }
  }
  
  public void a(TabFrameControllerImpl paramTabFrameControllerImpl, FrameFragment paramFrameFragment, int paramInt)
  {
    RIJInjectImpl.a(paramFrameFragment, paramInt);
  }
  
  public void a(TabFrameControllerImpl paramTabFrameControllerImpl, FrameFragment paramFrameFragment, boolean paramBoolean)
  {
    boolean bool1;
    boolean bool3;
    if ((ReadInJoyHelper.m()) && (!QzoneConfig.isShowQQCircleMainTabEntrance(StudyModeManager.a())))
    {
      bool1 = true;
      bool3 = ReadInJoyHelper.a(((MainFragment)paramFrameFragment).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonRIJTabFrameBase$KandianFrameStatus, bool1);
      if (paramFrameFragment.g == ((IQQUtilsApi)QRoute.api(IQQUtilsApi.class)).isNowSimpleUI()) {
        break label251;
      }
    }
    int i;
    label251:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramFrameFragment.g = ((IQQUtilsApi)QRoute.api(IQQUtilsApi.class)).isNowSimpleUI();
      if (!a((QQAppInterface)paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime, paramFrameFragment.m, paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView, paramBoolean, bool3, bool2)) {
        break label871;
      }
      com.tencent.biz.now.NowLiveManager.c = false;
      KandianOptUtils.a(true);
      localObject = (ILebaHelperService)paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ILebaHelperService.class, "all");
      if (localObject != null) {
        ((ILebaHelperService)localObject).setFlagUpdateOnPause();
      }
      if (QLog.isColorLevel()) {
        QLog.i("FrameControllerInjectImpl", 2, "setFrames" + ((QQAppInterface)paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime).isCallTabShow);
      }
      if (paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost != null) {
        paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.clearAllTabs();
      }
      int j = paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView.length;
      i = 0;
      while (i < j)
      {
        localObject = paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[i];
        if (localObject != null)
        {
          ((View)localObject).setSelected(false);
          ((View)localObject).setId(i + 16);
        }
        i += 1;
      }
      bool1 = false;
      break;
    }
    paramTabFrameControllerImpl.initTabIndex(((QQAppInterface)paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime).isCallTabShow, -100, bool1);
    paramTabFrameControllerImpl.initTabDragIconsAbdTextVuews(paramFrameFragment);
    Object localObject = paramFrameFragment.a(Conversation.class);
    if (localObject != null) {
      ((Conversation)localObject).h(true);
    }
    paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[1] = null;
    NowInjectImpl.g(paramFrameFragment);
    paramTabFrameControllerImpl.addFrame(paramFrameFragment, paramFrameFragment.jdField_a_of_type_AndroidViewView, Conversation.class, paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[0]);
    paramTabFrameControllerImpl.addFrame(paramFrameFragment, paramFrameFragment.jdField_a_of_type_AndroidViewView, Contacts.class, paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[2]);
    if (bool1)
    {
      if (paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[6] == null) {
        RIJInjectImpl.a(paramTabFrameControllerImpl, paramFrameFragment);
      }
      paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[6].setId(22);
      localObject = (TabDragAnimationView)paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[6].findViewById(2131378843);
      TextView localTextView = (TextView)paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[6].findViewById(2131380635);
      if ((localTextView != null) && (localObject != null))
      {
        ((TabDragAnimationView)localObject).setOnTouchListener(new FrameFragment.DragViewTouchListener());
        ((TabDragAnimationView)localObject).setPressChanged(false);
        localTextView.setTextColor(paramFrameFragment.getResources().getColor(2131167234));
        ((TabDragAnimationView)localObject).a(paramFrameFragment.getResources().getString(2131696385));
        paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.put(FrameControllerUtil.g, localObject);
        paramFrameFragment.jdField_b_of_type_AndroidUtilSparseArray.put(FrameControllerUtil.g, localTextView);
        paramFrameFragment.a(RIJXTabFrameUtils.a.a(((MainFragment)paramFrameFragment).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonRIJTabFrameBase$KandianFrameStatus));
        paramTabFrameControllerImpl.addFrame(paramFrameFragment, paramFrameFragment.jdField_a_of_type_AndroidViewView, RIJXTabFrameUtils.a.a(), paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[6]);
        RIJXTabFrameUtils.a.a(((MainFragment)paramFrameFragment).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonRIJTabFrameBase$KandianFrameStatus, true);
      }
      RIJInjectImpl.a(paramFrameFragment, 3);
      if (!FrameFragment.d) {
        RIJInjectImpl.g(paramFrameFragment);
      }
      if (paramFrameFragment.jdField_b_of_type_AndroidContentIntent != null)
      {
        localObject = paramFrameFragment.jdField_b_of_type_AndroidContentIntent.getExtras();
        if (localObject != null)
        {
          i = ((Bundle)localObject).getInt("tab_index");
          if (i == 2) {
            paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setCurrentTab(i);
          }
        }
        paramFrameFragment.jdField_b_of_type_AndroidContentIntent = null;
      }
      QCircleInjectImpl.a(paramTabFrameControllerImpl, paramFrameFragment);
      paramFrameFragment.jdField_a_of_type_JavaUtilHashMap.put(FrameControllerUtil.jdField_d_of_type_JavaLangString, paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[3]);
      paramFrameFragment.jdField_a_of_type_JavaUtilHashMap.put(FrameControllerUtil.jdField_d_of_type_JavaLangString + "_num", paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[3].findViewById(2131380896));
      if (!QZoneApiProxy.needShowQzoneFrame(paramFrameFragment.getActivity(), (QQAppInterface)paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime)) {
        break label926;
      }
      paramFrameFragment.m = true;
      paramFrameFragment.a(((ILebaFrameApi)QRoute.api(ILebaFrameApi.class)).getLebaFrameClass());
      paramTabFrameControllerImpl.addFrame(paramFrameFragment, paramFrameFragment.jdField_a_of_type_AndroidViewView, QzoneFrame.class, paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[7]);
      paramFrameFragment.jdField_a_of_type_JavaUtilHashMap.put(FrameControllerUtil.jdField_c_of_type_JavaLangString, paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[7]);
      paramFrameFragment.jdField_a_of_type_JavaUtilHashMap.put(FrameControllerUtil.jdField_c_of_type_JavaLangString + "_num", paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[7].findViewById(2131380896));
      localObject = (TabDragAnimationView)paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[7].findViewById(2131378843);
      localTextView = (TextView)paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[7].findViewById(2131380635);
      paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.put(FrameControllerUtil.i, localObject);
      paramFrameFragment.jdField_b_of_type_AndroidUtilSparseArray.put(FrameControllerUtil.i, localTextView);
    }
    for (;;)
    {
      KandianOptUtils.a(false);
      paramTabFrameControllerImpl.checkEnableTabAnim(paramFrameFragment, false);
      label871:
      return;
      paramFrameFragment.a(RIJXTabFrameUtils.a.a(((MainFragment)paramFrameFragment).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonRIJTabFrameBase$KandianFrameStatus));
      paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.remove(FrameControllerUtil.g);
      paramFrameFragment.jdField_b_of_type_AndroidUtilSparseArray.remove(FrameControllerUtil.g);
      RIJXTabFrameUtils.a.a(((MainFragment)paramFrameFragment).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonRIJTabFrameBase$KandianFrameStatus, false);
      break;
      label926:
      if (QZoneApiProxy.isQzoneInstalled()) {
        paramFrameFragment.m = true;
      }
      paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.remove(FrameControllerUtil.i);
      paramFrameFragment.jdField_b_of_type_AndroidUtilSparseArray.remove(FrameControllerUtil.i);
      paramFrameFragment.a(QzoneFrame.class);
      paramTabFrameControllerImpl.addFrame(paramFrameFragment, paramFrameFragment.jdField_a_of_type_AndroidViewView, ((ILebaFrameApi)QRoute.api(ILebaFrameApi.class)).getLebaFrameClass(), paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[3]);
    }
  }
  
  public void a(FrameFragment paramFrameFragment)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("DynimiIcon", 2, "revertConversationIconChange mPreResIndex = " + FrameFragment.jdField_a_of_type_Int);
    }
    FrameFragment.f = true;
    paramFrameFragment.j = false;
    Conversation localConversation = (Conversation)paramFrameFragment.a(Conversation.class);
    if (localConversation != null) {
      i = localConversation.jdField_d_of_type_Int;
    }
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).updateTabDefaultFocusIcon(paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime, paramFrameFragment.h, paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray, i);
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
    boolean bool = false;
    int i;
    if (QCircleFrame.jdField_a_of_type_Boolean != QzoneConfig.isShowQQCircleMainTabEntrance(StudyModeManager.a()))
    {
      i = 1;
      if ((!((IQQUtilsApi)QRoute.api(IQQUtilsApi.class)).isNowSimpleUI()) || (paramBoolean1 == QZoneApiProxy.isQzoneInstalled())) {
        break label114;
      }
    }
    label114:
    for (int j = 1;; j = 0)
    {
      if ((!paramBoolean2) && ((!paramQQAppInterface.isCallTabShow) || (paramArrayOfView[1] != null)) && ((paramQQAppInterface.isCallTabShow) || (paramArrayOfView[1] == null)) && (paramArrayOfView[4] == null) && (!paramBoolean3) && (!paramBoolean4) && (j == 0))
      {
        paramBoolean1 = bool;
        if (i == 0) {}
      }
      else
      {
        paramBoolean1 = true;
      }
      return paramBoolean1;
      i = 0;
      break;
    }
  }
  
  public boolean a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = ((QQAppInterface)paramAppRuntime).getProxyManager().a();
    if ((paramAppRuntime != null) && (RecentDataListManager.a().a.size() > 0))
    {
      Object localObject = new ArrayList(RecentDataListManager.a().a);
      if (((List)localObject).size() > 0)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          RecentBaseData localRecentBaseData = (RecentBaseData)((Iterator)localObject).next();
          if (localRecentBaseData != null)
          {
            if ((localRecentBaseData.mUnreadFlag == 1) || (localRecentBaseData.mUnreadFlag == 4)) {}
            for (int i = 1; (i != 0) && (paramAppRuntime.a(localRecentBaseData)); i = 0) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }
  
  public View[] a(TabFrameControllerImpl paramTabFrameControllerImpl, LayoutInflater paramLayoutInflater)
  {
    boolean bool = paramTabFrameControllerImpl.updateIsDefaultTheme();
    View[] arrayOfView = new View[7];
    arrayOfView[0] = paramLayoutInflater.inflate(2131559449, null);
    arrayOfView[1] = ((DragFrameLayout)arrayOfView[0].findViewById(2131365297));
    Object localObject = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByIndex(FrameControllerUtil.jdField_a_of_type_Int);
    int i = 2130850963;
    int j = 2130850964;
    if (bool)
    {
      i = -1;
      j = -1;
    }
    arrayOfView[2] = paramTabFrameControllerImpl.generateTabItem(i, ((FrameInfoBean)localObject).b(), j, ((FrameInfoBean)localObject).c(), ((FrameInfoBean)localObject).d(), ((FrameInfoBean)localObject).e(), ((FrameInfoBean)localObject).f());
    arrayOfView[2].setOnClickListener(new FrameFragment.DragViewPunctureClickListener());
    localObject = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByIndex(FrameControllerUtil.jdField_c_of_type_Int);
    i = 2130850961;
    j = 2130850962;
    if (bool)
    {
      i = -1;
      j = -1;
    }
    localObject = paramTabFrameControllerImpl.generateTabItem(i, ((FrameInfoBean)localObject).b(), j, ((FrameInfoBean)localObject).c(), ((FrameInfoBean)localObject).d(), ((FrameInfoBean)localObject).e(), ((FrameInfoBean)localObject).f());
    ((View)localObject).setOnClickListener(new FrameFragment.DragViewPunctureClickListener());
    arrayOfView[3] = new RedTouchTab(paramLayoutInflater.getContext(), (View)localObject).b(49).e(3).a(true).c(5).a();
    FrameInfoBean localFrameInfoBean = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByIndex(FrameControllerUtil.jdField_d_of_type_Int);
    i = 2130850966;
    if (bool) {
      i = -1;
    }
    localObject = paramTabFrameControllerImpl.generateTabItem(-1, localFrameInfoBean.b(), i, localFrameInfoBean.c(), localFrameInfoBean.d(), localFrameInfoBean.e(), localFrameInfoBean.f());
    ((View)localObject).setOnClickListener(new TabFrameControllerImpl.ABotDragClickListener((View)localObject, "lebaTab"));
    arrayOfView[4] = new RedTouchTab(paramLayoutInflater.getContext(), (View)localObject).b(49).e(3).a(true).c(5).a();
    View localView = paramTabFrameControllerImpl.generateTabItem(-1, localFrameInfoBean.b(), i, localFrameInfoBean.c(), localFrameInfoBean.d(), localFrameInfoBean.e(), localFrameInfoBean.f());
    localView.setOnClickListener(new TabFrameControllerImpl.ABotDragClickListener(localView, "lebaTabNew"));
    arrayOfView[5] = new RedTouchTab(paramLayoutInflater.getContext(), localView).b(49).e(3).a(true).c(5).a();
    paramTabFrameControllerImpl = paramTabFrameControllerImpl.generateTabItem(-1, localFrameInfoBean.b(), i, localFrameInfoBean.c(), localFrameInfoBean.d(), localFrameInfoBean.e(), localFrameInfoBean.f());
    paramTabFrameControllerImpl.setOnClickListener(new TabFrameControllerImpl.ABotDragClickListener((View)localObject, "QzoneTab"));
    arrayOfView[6] = new RedTouchTab(paramLayoutInflater.getContext(), paramTabFrameControllerImpl).b(49).e(3).a(true).c(5).a();
    return arrayOfView;
  }
  
  public View[] a(TabFrameControllerImpl paramTabFrameControllerImpl, FrameFragment paramFrameFragment, View paramView)
  {
    paramFrameFragment.jdField_a_of_type_JavaUtilHashMap = new HashMap(9);
    paramFrameFragment.jdField_b_of_type_JavaUtilHashMap = new HashMap(13);
    boolean bool = paramTabFrameControllerImpl.updateIsDefaultTheme();
    Object localObject1 = ((SplashActivity)paramFrameFragment.getActivity()).mPreloadMainViews;
    ((SplashActivity)paramFrameFragment.getActivity()).mPreloadMainViews = null;
    if (localObject1 != null)
    {
      paramFrameFragment.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = ((DragFrameLayout)localObject1[1]);
      paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView = new View[] { localObject1[2], null, localObject1[3], localObject1[4], null, localObject1[5], null, localObject1[6], null };
      paramFrameFragment.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.setOnDragListener(((MainFragment)paramFrameFragment).jdField_a_of_type_ComTencentMobileqqActivityRecentCurTabDragListener);
      paramFrameFragment.jdField_a_of_type_JavaUtilHashMap.put(FrameControllerUtil.jdField_a_of_type_JavaLangString, paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[0]);
      paramFrameFragment.jdField_a_of_type_JavaUtilHashMap.put(FrameControllerUtil.b, paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[2]);
      paramFrameFragment.jdField_a_of_type_JavaUtilHashMap.put(FrameControllerUtil.jdField_d_of_type_JavaLangString, paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[3]);
      paramFrameFragment.jdField_a_of_type_JavaUtilHashMap.put(FrameControllerUtil.jdField_c_of_type_JavaLangString, paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[7]);
      paramFrameFragment.jdField_a_of_type_JavaUtilHashMap.put(FrameControllerUtil.jdField_a_of_type_JavaLangString + "_num", paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131380896));
      paramFrameFragment.jdField_a_of_type_JavaUtilHashMap.put(FrameControllerUtil.b + "_num", paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[2].findViewById(2131380896));
      paramFrameFragment.jdField_a_of_type_JavaUtilHashMap.put(FrameControllerUtil.jdField_d_of_type_JavaLangString + "_num", paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[3].findViewById(2131380896));
      paramFrameFragment.jdField_a_of_type_JavaUtilHashMap.put(FrameControllerUtil.jdField_c_of_type_JavaLangString + "_num", paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[7].findViewById(2131380896));
      paramTabFrameControllerImpl = (TabDragAnimationView)paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131378843);
      paramTabFrameControllerImpl.setTag(FrameControllerUtil.jdField_a_of_type_JavaLangString);
      paramTabFrameControllerImpl.setOnDragListener(new FrameControllerInjectImpl.2(this, paramFrameFragment));
      paramTabFrameControllerImpl.setOnLongClickListener(new FrameControllerInjectImpl.3(this, paramFrameFragment));
      paramTabFrameControllerImpl = (QQTabWidget)paramView.findViewById(16908307);
      if (paramTabFrameControllerImpl == null) {
        break label1108;
      }
      paramTabFrameControllerImpl.setShowDividers(0);
      paramTabFrameControllerImpl.setTabWidgetMoveListener(((MainFragment)paramFrameFragment).jdField_a_of_type_ComTencentMobileqqWidgetQQTabWidget$onTabWidgetTouchMoveListener);
    }
    for (;;)
    {
      return paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView;
      paramFrameFragment.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = ((DragFrameLayout)paramView.findViewById(2131365297));
      localObject1 = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByIndex(FrameControllerUtil.jdField_c_of_type_Int);
      int i = 2130850961;
      int j = 2130850961;
      if (bool)
      {
        i = -1;
        j = -1;
      }
      localObject1 = paramTabFrameControllerImpl.generateTabItem(i, ((FrameInfoBean)localObject1).b(), j, ((FrameInfoBean)localObject1).c(), ((FrameInfoBean)localObject1).d(), ((FrameInfoBean)localObject1).e(), ((FrameInfoBean)localObject1).f());
      ((View)localObject1).setOnClickListener(new FrameFragment.DragViewPunctureClickListener());
      Object localObject2 = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByIndex(FrameControllerUtil.jdField_d_of_type_Int);
      i = 2130850966;
      if (bool) {
        i = -1;
      }
      View localView1 = paramTabFrameControllerImpl.generateTabItem(-1, ((FrameInfoBean)localObject2).b(), i, ((FrameInfoBean)localObject2).c(), ((FrameInfoBean)localObject2).d(), ((FrameInfoBean)localObject2).e(), ((FrameInfoBean)localObject2).f());
      localView1.setOnClickListener(new TabFrameControllerImpl.ABotDragClickListener(localView1, "lebaTab"));
      View localView2 = paramTabFrameControllerImpl.generateTabItem(-1, ((FrameInfoBean)localObject2).b(), i, ((FrameInfoBean)localObject2).c(), ((FrameInfoBean)localObject2).d(), ((FrameInfoBean)localObject2).e(), ((FrameInfoBean)localObject2).f());
      localView2.setOnClickListener(new TabFrameControllerImpl.ABotDragClickListener(localView2, "qzoneTab"));
      localObject2 = paramTabFrameControllerImpl.generateTabItem(-1, ((FrameInfoBean)localObject2).b(), i, ((FrameInfoBean)localObject2).c(), ((FrameInfoBean)localObject2).d(), ((FrameInfoBean)localObject2).e(), ((FrameInfoBean)localObject2).f());
      ((View)localObject2).setOnClickListener(new TabFrameControllerImpl.ABotDragClickListener((View)localObject2, "lebaTabNew"));
      ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByIndex(FrameControllerUtil.f);
      View localView3 = paramTabFrameControllerImpl.generateTabItem(2130846855, 2130850816, 2130846856, 2130850817, 2131699758, 15, 5);
      localView3.setOnClickListener(new FrameFragment.DragViewPunctureClickListener());
      FrameInfoBean localFrameInfoBean = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByIndex(FrameControllerUtil.jdField_a_of_type_Int);
      i = 2130850963;
      j = 2130850964;
      if (bool)
      {
        i = -1;
        j = -1;
      }
      paramTabFrameControllerImpl = paramTabFrameControllerImpl.generateTabItem(i, localFrameInfoBean.b(), j, localFrameInfoBean.c(), localFrameInfoBean.d(), localFrameInfoBean.e(), localFrameInfoBean.f());
      paramTabFrameControllerImpl.setOnClickListener(new FrameFragment.DragViewPunctureClickListener());
      paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView = new View[] { paramTabFrameControllerImpl, null, new RedTouchTab(paramFrameFragment.getActivity(), (View)localObject1).b(49).e(3).a(true).c(5).a(), new RedTouchTab(paramFrameFragment.getActivity(), localView1).b(49).e(3).a(true).c(5).a(), new RedTouchTab(paramFrameFragment.getActivity(), localView3).b(49).e(3).a(true).c(5).a(), new RedTouchTab(paramFrameFragment.getActivity(), (View)localObject2).b(49).e(3).a(true).c(5).a(), null, new RedTouchTab(paramFrameFragment.getActivity(), localView2).b(49).e(3).a(true).c(5).a(), null };
      break;
      label1108:
      QLog.i("FrameControllerInjectImpl", 1, "initTabs tabWidget is null");
    }
  }
  
  public void b(FrameFragment paramFrameFragment)
  {
    if (!MultiMsgManager.a().a()) {
      MultiMsgManager.a().a((QQAppInterface)paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.controllerinject.FrameControllerInjectImpl
 * JD-Core Version:    0.7.0.1
 */