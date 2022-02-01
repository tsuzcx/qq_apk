package com.tencent.mobileqq.activity.framebusiness;

import android.content.res.Resources;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.common.KandianOptUtils;
import com.tencent.biz.pubaccount.readinjoy.common.RIJTabFrameBase;
import com.tencent.biz.pubaccount.readinjoy.common.RIJXTabFrameUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJDtParamBuilder;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.pubaccount.readinjoy.view.RIJXTabFrame;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyTabDragAnimationView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.IFrameBusinessInterface;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.home.impl.FrameInfoBean;
import com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameFragment.DragViewTouchListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.util.QQKRPUtil;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class RIJInjectImpl
  implements IFrameBusinessInterface
{
  public static final String a = FrameControllerUtil.f;
  
  public static void a(TabFrameControllerImpl paramTabFrameControllerImpl, FrameFragment paramFrameFragment)
  {
    int j = -1;
    if (paramTabFrameControllerImpl.updateIsDefaultTheme()) {}
    for (int i = -1;; i = 2130843472)
    {
      View localView = KandianOptUtils.a(i, 2130850820, j, 2130850821, 2131694350, 16, 8);
      if (localView != null)
      {
        localView.setOnClickListener(new RIJInjectImpl.1(paramFrameFragment, paramTabFrameControllerImpl));
        paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[6] = new RedTouch(paramFrameFragment.getActivity(), localView).b(49).e(3).c(5).a();
        VideoReport.setElementId(localView, "tab_button");
        VideoReport.setElementParams(localView, new RIJDtParamBuilder().a("14").a("tab_id", "kandian").b("tab_bar").c("click_tab").a().a());
        paramFrameFragment.jdField_a_of_type_JavaUtilHashMap.put(FrameControllerUtil.f, paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[6]);
        paramFrameFragment.jdField_a_of_type_JavaUtilHashMap.put(FrameControllerUtil.f + "_num", paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[6].findViewById(2131380896));
        localView.setContentDescription(paramFrameFragment.getResources().getString(2131694350));
      }
      return;
      j = 2130843473;
    }
  }
  
  public static void a(TabFrameControllerImpl paramTabFrameControllerImpl, QQAppInterface paramQQAppInterface, HashMap<String, View> paramHashMap)
  {
    if (paramHashMap != null) {}
    label154:
    label162:
    for (;;)
    {
      try
      {
        if (paramHashMap.get(FrameControllerUtil.f) == null) {
          continue;
        }
        paramHashMap = (BusinessInfoCheckUpdate.RedTypeInfo)((RedTouch)paramHashMap.get(FrameControllerUtil.f)).getTag(2131376623);
        if (paramHashMap == null) {
          break label154;
        }
        j = paramTabFrameControllerImpl.getRedTypeByRedTypeInfo(paramHashMap.red_type.get());
        if (j != 1) {
          continue;
        }
        i = Integer.parseInt(paramHashMap.red_content.get());
      }
      catch (Throwable paramTabFrameControllerImpl)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("TabFrameControllerImpl", 2, paramTabFrameControllerImpl, new Object[0]);
        return;
      }
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X80098E1", "0X80098E1", 0, 0, "" + j, "" + i, "", "");
      return;
      int i = 1;
      break label162;
      i = 0;
      int j = 0;
    }
  }
  
  public static void a(FrameFragment paramFrameFragment, int paramInt)
  {
    QLog.d("TabFrameControllerImpl", 2, "update kandian tab, type : " + paramInt);
    if (paramInt == 0) {
      ((ITabFrameController)QRoute.api(ITabFrameController.class)).setFrames(paramFrameFragment, false);
    }
    ReadInjoyTabDragAnimationView localReadInjoyTabDragAnimationView;
    do
    {
      do
      {
        return;
      } while (!(paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.get(FrameControllerUtil.g) instanceof ReadInjoyTabDragAnimationView));
      localReadInjoyTabDragAnimationView = (ReadInjoyTabDragAnimationView)paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.get(FrameControllerUtil.g);
      paramFrameFragment = (TextView)paramFrameFragment.b.get(FrameControllerUtil.g);
      if ((localReadInjoyTabDragAnimationView == null) || (paramFrameFragment == null))
      {
        QLog.d("TabFrameControllerImpl", 2, "iconView is null, give up !");
        return;
      }
      switch (paramInt)
      {
      default: 
        return;
      }
    } while (localReadInjoyTabDragAnimationView.a() == 1);
    localReadInjoyTabDragAnimationView.a(1);
    localReadInjoyTabDragAnimationView.a(true);
    return;
    localReadInjoyTabDragAnimationView.a(false);
    return;
    localReadInjoyTabDragAnimationView.a(0);
    return;
    localReadInjoyTabDragAnimationView.setIsSelect(false);
    return;
    localReadInjoyTabDragAnimationView.setIsSelect(true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, HashMap<String, View> paramHashMap, View[] paramArrayOfView)
  {
    ReadInJoyHelper.c();
    ((KandianMergeManager)paramQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).o();
    if (ReadInJoyHelper.m())
    {
      if ((paramArrayOfView != null) && (paramArrayOfView.length >= 6) && (paramArrayOfView[6] != null)) {
        VideoReport.reportEvent("imp", ((RedTouch)paramArrayOfView[6]).a(), new RIJDtParamBuilder().a("14").a("tab_id", "kandian").b("tab_bar").a().a());
      }
      paramHashMap = (RedTouch)paramHashMap.get(FrameControllerUtil.f);
      if (paramHashMap != null) {
        ReadInJoyUtils.a(paramQQAppInterface, (BusinessInfoCheckUpdate.RedTypeInfo)paramHashMap.getTag(2131376623));
      }
      ThreadManager.executeOnSubThread(new RIJInjectImpl.2());
    }
  }
  
  public static void g(FrameFragment paramFrameFragment)
  {
    boolean bool3 = true;
    Object localObject = (RedTouch)paramFrameFragment.jdField_a_of_type_JavaUtilHashMap.get(FrameControllerUtil.f);
    boolean bool1;
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo;
    boolean bool2;
    if (localObject != null)
    {
      Frame localFrame = paramFrameFragment.a();
      if ((localFrame == null) || (!RIJXTabFrameUtils.a.a(localFrame))) {
        break label283;
      }
      bool1 = true;
      KandianMergeManager localKandianMergeManager = (KandianMergeManager)paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
      localRedTypeInfo = localKandianMergeManager.a();
      if ((localRedTypeInfo == null) || (localRedTypeInfo.red_type.get() != 5)) {
        break label288;
      }
      bool2 = true;
      label87:
      if ((!bool1) || (localRedTypeInfo == null) || (localRedTypeInfo.red_type.get() != 0) || (!((RIJTabFrameBase)localFrame).a(localKandianMergeManager))) {
        break label306;
      }
      localRedTypeInfo = null;
    }
    label283:
    label288:
    label293:
    label298:
    label306:
    for (;;)
    {
      ((RedTouch)localObject).setTag(2131376623, localRedTypeInfo);
      ((ITabFrameController)QRoute.api(ITabFrameController.class)).updateRedTouch(paramFrameFragment, 39, (RedTouch)localObject, localRedTypeInfo);
      if (((BaseActivity.sTopActivity instanceof SplashActivity)) && (paramFrameFragment.isVisible()) && (ReadInJoyUtils.a(null)) && (localRedTypeInfo != null)) {
        ReadInJoyUtils.a((QQAppInterface)paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime, localRedTypeInfo);
      }
      if (QLog.isColorLevel())
      {
        paramFrameFragment = new StringBuilder().append("updateKandianTabRedPoint isInTabFrame : ").append(bool1).append(", isRemoveRedPoint : ");
        if (localRedTypeInfo != null) {
          break label293;
        }
        bool1 = bool3;
        label229:
        localObject = paramFrameFragment.append(bool1).append(", isNumRedPoint : ").append(bool2).append(", cnt : ");
        if (localRedTypeInfo == null) {
          break label298;
        }
      }
      for (paramFrameFragment = localRedTypeInfo.red_content.get();; paramFrameFragment = Integer.valueOf(0))
      {
        QLog.d("Q.readinjoy.4tab", 2, paramFrameFragment);
        return;
        bool1 = false;
        break;
        bool2 = false;
        break label87;
        bool1 = false;
        break label229;
      }
    }
  }
  
  public void a()
  {
    TabFrameControllerImpl.registerFrameInfo(new FrameInfoBean(ReadinjoyTabFrame.class, true, FrameControllerUtil.g, "", 2130850820, 2130850821, 2131694350, 16, 8));
    TabFrameControllerImpl.registerFrameInfo(new FrameInfoBean(RIJXTabFrame.class, true, FrameControllerUtil.g, "", 2130850820, 2130850821, 2131694350, 16, 8));
  }
  
  public void a(FrameFragment paramFrameFragment)
  {
    paramFrameFragment = paramFrameFragment.a(RIJXTabFrameUtils.a.a());
    if (paramFrameFragment != null) {
      ((RIJTabFrameBase)paramFrameFragment).c();
    }
  }
  
  public void a(FrameFragment paramFrameFragment, int paramInt1, Frame paramFrame, int paramInt2)
  {
    RIJTabFrameBase localRIJTabFrameBase;
    if ((RIJXTabFrameUtils.a.a(paramFrame)) || (paramInt2 == FrameControllerUtil.g))
    {
      localRIJTabFrameBase = (RIJTabFrameBase)paramFrameFragment.a(RIJXTabFrameUtils.a.a());
      if (localRIJTabFrameBase != null)
      {
        if (paramInt2 != FrameControllerUtil.g) {
          break label84;
        }
        ReadinjoyReportUtils.a(paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime);
        localRIJTabFrameBase.c(true);
        a(paramFrameFragment, 5);
      }
    }
    for (;;)
    {
      ReadinjoySPEventReport.c(paramInt2);
      QQKRPUtil.a((QQAppInterface)paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime, paramFrameFragment, paramFrame, paramInt2);
      return;
      label84:
      localRIJTabFrameBase.c(false);
      a(paramFrameFragment, 4);
      continue;
      a(paramFrameFragment, 4);
    }
  }
  
  public void a(FrameFragment paramFrameFragment, FrameFragment.DragViewTouchListener paramDragViewTouchListener) {}
  
  public void a(FrameFragment paramFrameFragment, String paramString) {}
  
  public void a(RedTouch paramRedTouch, FrameFragment paramFrameFragment, int paramInt, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, RedTouchManager paramRedTouchManager)
  {
    if (paramInt == 39) {
      g(paramFrameFragment);
    }
  }
  
  public void a(HashMap<String, View> paramHashMap, boolean paramBoolean)
  {
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).setSoundEffectsEnableForTab(paramHashMap, paramBoolean, a);
  }
  
  public void a(AppRuntime paramAppRuntime, SparseArray<TabDragAnimationView> paramSparseArray, int paramInt) {}
  
  public boolean a(FrameFragment paramFrameFragment)
  {
    return false;
  }
  
  public void b()
  {
    FrameInfoBean localFrameInfoBean = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByClazz(ReadinjoyTabFrame.class);
    localFrameInfoBean.a(FrameControllerUtil.g);
    QLog.d("TabFrameControllerImplBusiness", 1, "doOnUpdateFrameInfo className: " + localFrameInfoBean.a().getName() + " tabIndex: " + localFrameInfoBean.a());
    localFrameInfoBean = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByClazz(RIJXTabFrame.class);
    localFrameInfoBean.a(FrameControllerUtil.g);
    QLog.d("TabFrameControllerImplBusiness", 1, "doOnUpdateFrameInfo className: " + localFrameInfoBean.a().getName() + " tabIndex: " + localFrameInfoBean.a());
  }
  
  public void b(FrameFragment paramFrameFragment)
  {
    paramFrameFragment.a(FrameControllerUtil.g, 2130843472, 2130843473);
  }
  
  public void b(FrameFragment paramFrameFragment, String paramString) {}
  
  public void c(FrameFragment paramFrameFragment) {}
  
  public void d(FrameFragment paramFrameFragment) {}
  
  public void e(FrameFragment paramFrameFragment) {}
  
  public void f(FrameFragment paramFrameFragment) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.RIJInjectImpl
 * JD-Core Version:    0.7.0.1
 */