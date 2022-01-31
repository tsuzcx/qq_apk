package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TabWidget;
import android.widget.TextView;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyTabDragAnimationView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.readinjoy.view.appinpush.KandianAppInPush;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AppGuideTipsManager;
import com.tencent.mobileqq.activity.aio.anim.MainEnterOutAni;
import com.tencent.mobileqq.activity.fling.ScreenCapture;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.cur.TabDragListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.QIMNewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.qim.QIMNewFriend;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.campuscircle.CampusNoticeManager;
import com.tencent.mobileqq.config.AboutConfig;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.managers.LoadingStateManager;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.msf.sdk.QNotificationManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.observer.GetRedPointExObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchTab;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.startup.step.StartService;
import com.tencent.mobileqq.statistics.PushReportController;
import com.tencent.mobileqq.statistics.PushReportController.PushReportItem;
import com.tencent.mobileqq.statistics.QQCatchedExceptionReporter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.mobileqq.subaccount.AssociatedAccountOptPopBar;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.FlashCarGameManager;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vipgift.VipGiftDownloadInfo;
import com.tencent.mobileqq.vipgift.VipGiftManager;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.mobileqq.widget.QQTabWidget;
import com.tencent.mobileqq.widget.QQTabWidget.onTabWidgetTouchMoveListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.CustomWidgetUtil;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import mqq.app.Constants.LogoutReason;
import mqq.os.MqqHandler;
import protocol.KQQConfig.UpgradeInfo;
import sya;
import syb;
import syc;
import syd;
import sye;
import syf;
import syg;
import syh;
import syi;
import syj;
import syk;
import syl;
import sym;
import syn;
import syo;
import syp;
import syq;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class MainFragment
  extends FrameHelperActivity
{
  public static int a;
  public static boolean a;
  public static int b;
  public static boolean b;
  public static int c;
  private static SparseArray jdField_c_of_type_AndroidUtilSparseArray = new SparseArray(2);
  public static boolean c;
  public static int d;
  public static int e;
  public static int f;
  public static int g;
  public static int h;
  public Dialog a;
  public Intent a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  public MainAssistObserver a;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private TabDragListener jdField_a_of_type_ComTencentMobileqqActivityRecentCurTabDragListener = new TabDragListener(null);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private GetRedPointExObserver jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver = new syf(this);
  private QQTabWidget.onTabWidgetTouchMoveListener jdField_a_of_type_ComTencentMobileqqWidgetQQTabWidget$onTabWidgetTouchMoveListener = new sye(this);
  public String a;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private View[] jdField_a_of_type_ArrayOfAndroidViewView;
  private long jdField_b_of_type_Long;
  private Dialog jdField_b_of_type_AndroidAppDialog;
  private SparseArray jdField_b_of_type_AndroidUtilSparseArray;
  private HashMap jdField_b_of_type_JavaUtilHashMap;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  public boolean d;
  private String e;
  private String f;
  private String jdField_g_of_type_JavaLangString = "";
  private boolean jdField_g_of_type_Boolean = true;
  private boolean h;
  int jdField_i_of_type_Int = 3;
  private boolean jdField_i_of_type_Boolean = true;
  private boolean j;
  private boolean k;
  private boolean l;
  
  static
  {
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = 2;
    jdField_d_of_type_Int = 3;
    jdField_e_of_type_Int = 4;
    jdField_f_of_type_Int = 5;
    jdField_g_of_type_Int = 7;
    jdField_h_of_type_Int = 2;
    jdField_a_of_type_Boolean = true;
  }
  
  public MainFragment()
  {
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_d_of_type_Boolean = true;
  }
  
  public static int a(Bundle paramBundle)
  {
    if ((paramBundle == null) || (!paramBundle.containsKey("main_tab_id"))) {
      return -2147483648;
    }
    switch (paramBundle.getInt("main_tab_id"))
    {
    default: 
      return -2147483648;
    case 1: 
      return jdField_a_of_type_Int;
    case 2: 
      return jdField_b_of_type_Int;
    case 3: 
      return jdField_c_of_type_Int;
    case 4: 
      return jdField_d_of_type_Int;
    case 5: 
      return jdField_e_of_type_Int;
    }
    return jdField_f_of_type_Int;
  }
  
  private int a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilHashMap == null) {
      return 0;
    }
    Object localObject = this.jdField_b_of_type_JavaUtilHashMap.get(paramString + "_new");
    int m;
    if (((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue())) {
      m = 2;
    }
    for (;;)
    {
      return m;
      localObject = this.jdField_b_of_type_JavaUtilHashMap.get(paramString + "_num");
      if (((localObject instanceof Integer)) && (((Integer)localObject).intValue() > 0))
      {
        m = 3;
      }
      else
      {
        paramString = this.jdField_b_of_type_JavaUtilHashMap.get(paramString + "_icon");
        if (((paramString instanceof Boolean)) && (((Boolean)paramString).booleanValue())) {
          m = 1;
        } else {
          m = 0;
        }
      }
    }
  }
  
  private static View a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if (BaseApplicationImpl.sApplication == null) {
      return null;
    }
    View localView = View.inflate(BaseApplicationImpl.sApplication, 2130971582, null);
    ((DragTextView)localView.findViewById(2131364917)).setDragViewType(2);
    ((TabDragAnimationView)localView.findViewById(2131364916)).setEmotionDrawable(paramInt1, paramInt2, paramInt3, paramInt4, paramInt6, paramInt7);
    ((TextView)localView.findViewById(2131375031)).setText(paramInt5);
    return localView;
  }
  
  public static View a(int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    Object localObject3 = null;
    if (BaseApplicationImpl.sApplication == null) {
      return null;
    }
    Object localObject1 = "MainFragment--createTabItem";
    try
    {
      localView = View.inflate(BaseApplicationImpl.sApplication, 2130969064, null);
      if (localView == null) {
        localObject1 = "MainFragment--createTabItem|inflate null";
      }
      Object localObject2 = localObject1;
      QQCatchedExceptionReporter.reportQQCatchedException((Throwable)localObject1, "MainFragmentCatchedException", localObject2);
    }
    catch (Exception paramDragFrameLayout)
    {
      try
      {
        localObject3 = (ImageView)localView.findViewById(2131364916);
        if (localObject3 == null) {
          localObject1 = "MainFragment--createTabItem|findViewById null";
        }
        localObject2 = localObject1;
        ((ImageView)localObject3).setBackgroundResource(paramInt);
        if (paramDragFrameLayout != null)
        {
          localObject2 = localObject1;
          localObject3 = (DragTextView)localView.findViewById(2131364917);
          localObject2 = localObject1;
          ((DragTextView)localObject3).setOnModeChangeListener(paramDragFrameLayout);
          localObject2 = localObject1;
          ((DragTextView)localObject3).setDragViewType(2);
        }
        return localView;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          View localView;
          paramDragFrameLayout = localView;
        }
      }
      paramDragFrameLayout = paramDragFrameLayout;
      localObject2 = localObject1;
      localObject1 = paramDragFrameLayout;
      paramDragFrameLayout = (DragFrameLayout)localObject3;
    }
    return paramDragFrameLayout;
  }
  
  public static MainFragment a()
  {
    MainFragment localMainFragment = new MainFragment();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("should_restore_from_kill", false);
    localMainFragment.setArguments(localBundle);
    return localMainFragment;
  }
  
  private void a(int paramInt, RedTouch paramRedTouch, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if ((paramRedTouch != null) && (paramRedTypeInfo != null))
    {
      switch (paramRedTypeInfo.red_type.get())
      {
      case 1: 
      case 2: 
      case 3: 
      default: 
        paramRedTouch.a();
      }
      for (;;)
      {
        paramRedTouch.a(paramRedTypeInfo);
        return;
        paramRedTouch.b(15).a();
        if (paramInt == 33)
        {
          this.jdField_f_of_type_JavaLangString = "有更新";
        }
        else
        {
          this.jdField_g_of_type_JavaLangString = "有更新";
          continue;
          paramRedTouch.b(5).a();
          if (paramInt == 39) {
            paramRedTouch.b(15).a();
          }
          if (paramInt == 33)
          {
            String str = paramRedTypeInfo.red_content.get();
            try
            {
              if (Integer.parseInt(str) <= 99) {
                break label169;
              }
              this.jdField_f_of_type_JavaLangString = "多于99条更新";
            }
            catch (NumberFormatException localNumberFormatException)
            {
              localNumberFormatException.printStackTrace();
            }
            continue;
            label169:
            this.jdField_f_of_type_JavaLangString = (paramRedTypeInfo.red_content.get() + "条更新");
          }
          else
          {
            this.jdField_g_of_type_JavaLangString = (paramRedTypeInfo.red_content.get() + "条更新");
          }
        }
      }
    }
    if (paramRedTouch != null)
    {
      paramRedTouch.a();
      paramRedTouch.a(null);
    }
    if (paramInt == 33)
    {
      this.jdField_f_of_type_JavaLangString = "";
      return;
    }
    this.jdField_g_of_type_JavaLangString = "";
  }
  
  private void a(int paramInt, syq paramsyq)
  {
    if (paramsyq == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("MainFragment", 2, paramsyq.jdField_a_of_type_JavaLangString + " is execute");
          }
          if (paramInt == 2131362031)
          {
            paramsyq = this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a();
            if ((paramsyq == null) || (paramsyq.a == null))
            {
              if (QLog.isColorLevel()) {
                QLog.w("MainFragment", 2, "mWrapper is null");
              }
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 0, "已是最新版本", 0).b(getResources().getDimensionPixelSize(2131558448));
            }
            for (;;)
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80041C1", "0X80041C1", 0, 0, "", "", "", "");
              return;
              if (paramsyq.a.iUpgradeType == 0) {
                QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 0, "已是最新版本", 0).b(getResources().getDimensionPixelSize(2131558448));
              } else if ((paramsyq != null) && (paramsyq.a != null)) {
                UpgradeDetailActivity.a(getActivity(), UpgradeController.a().a(), false, false, true);
              }
            }
          }
          if (paramInt != 2131362033) {
            break;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80041C3", "0X80041C3", 0, 0, "", "", "", "");
        } while (!PhoneNumLoginImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity()));
        f();
        return;
        if (paramInt == 2131362034)
        {
          e();
          return;
        }
      } while (paramsyq.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null);
      AboutConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), paramsyq.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo);
    } while (!"com.tencent.Feedback_5_8".equals(paramsyq.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80041C2", "0X80041C2", 0, 0, "", "", "", "");
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      return;
      paramString2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
    } while (paramString2 == null);
    StringBuilder localStringBuilder = new StringBuilder();
    label52:
    int m;
    Object localObject;
    if ("消息".equals(paramString1))
    {
      localStringBuilder.append("消息 ");
      m = a(paramString1);
      localObject = (TextView)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1 + "_num");
      if (m != 2) {
        break label240;
      }
      localStringBuilder.append("有更新");
    }
    for (;;)
    {
      if ("动态".equals(paramString1)) {
        localStringBuilder.append(this.jdField_g_of_type_JavaLangString);
      }
      paramString2.setContentDescription(localStringBuilder.toString());
      paramString1 = (TextView)paramString2.findViewById(2131375031);
      if (paramString1 == null) {
        break;
      }
      AccessibilityUtil.a(paramString1, false);
      return;
      if ("联系人".equals(paramString1))
      {
        localStringBuilder.append("联系人 ");
        break label52;
      }
      if ("动态".equals(paramString1))
      {
        localStringBuilder.append("动态 ");
        break label52;
      }
      if ("电话".equals(paramString1))
      {
        localStringBuilder.append("电话 ");
        break label52;
      }
      if (!"NOW".equals(paramString1)) {
        break;
      }
      localStringBuilder.append("日迹 ");
      break label52;
      label240:
      if (m == 3)
      {
        if ("消息".equals(paramString1))
        {
          localObject = ((TextView)localObject).getText().toString();
          if ("".equals(localObject)) {
            localStringBuilder.append("多于99条未读");
          } else {
            localStringBuilder.append((String)localObject + "条未读");
          }
        }
        else
        {
          String str;
          if ("电话".equals(paramString1))
          {
            str = ((TextView)localObject).getText().toString();
            if (((TextView)localObject).getVisibility() == 0) {
              if ("99+".equals(str)) {
                localStringBuilder.append("多于99个新的未接来电");
              } else {
                localStringBuilder.append(str + "个新的未接来电");
              }
            }
          }
          else if ("联系人".equals(paramString1))
          {
            str = ((TextView)localObject).getText().toString();
            if (((TextView)localObject).getVisibility() == 0)
            {
              if ("99+".equals(str)) {
                localStringBuilder.append("多于99条更新");
              } else {
                localStringBuilder.append(str + "条更新");
              }
            }
            else {
              localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
            }
          }
          else if ("NOW".equals(paramString1))
          {
            str = ((TextView)localObject).getText().toString();
            if (((TextView)localObject).getVisibility() == 0) {
              if ("99+".equals(str)) {
                localStringBuilder.append("多于99个新的日迹");
              } else {
                localStringBuilder.append(str + "个新的" + "日迹");
              }
            }
          }
        }
      }
      else if (m == 1) {
        localStringBuilder.append("有新消息");
      } else if ("联系人".equals(paramString1)) {
        localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
      }
    }
  }
  
  private static void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    int m = 0;
    int n = 2;
    int i1 = 1;
    if (paramBoolean1)
    {
      jdField_a_of_type_Int = 0;
      jdField_b_of_type_Int = 1;
      jdField_c_of_type_Int = 2;
      jdField_d_of_type_Int = 3;
      jdField_f_of_type_Int = -100;
      jdField_e_of_type_Int = -100;
      return;
    }
    if (paramInt >= 0)
    {
      if (paramInt <= 0) {
        m = 1;
      }
      jdField_a_of_type_Int = m;
      m = i1;
      if (1 >= paramInt) {
        m = 2;
      }
      jdField_c_of_type_Int = m;
      m = n;
      if (2 >= paramInt) {
        m = 3;
      }
      jdField_d_of_type_Int = m;
      jdField_f_of_type_Int = paramInt;
      jdField_b_of_type_Int = -100;
      jdField_e_of_type_Int = -100;
      return;
    }
    jdField_a_of_type_Int = 0;
    jdField_b_of_type_Int = -100;
    jdField_c_of_type_Int = 1;
    jdField_d_of_type_Int = 2;
    if (ReadInJoyHelper.f())
    {
      jdField_g_of_type_Int = jdField_h_of_type_Int;
      jdField_d_of_type_Int = 3;
    }
    for (;;)
    {
      jdField_f_of_type_Int = -100;
      jdField_b_of_type_Int = -100;
      jdField_e_of_type_Int = -100;
      return;
      jdField_g_of_type_Int = -100;
    }
  }
  
  public static View[] a(LayoutInflater paramLayoutInflater)
  {
    View[] arrayOfView = new View[6];
    arrayOfView[0] = paramLayoutInflater.inflate(2130969063, null);
    arrayOfView[1] = ((DragFrameLayout)arrayOfView[0].findViewById(2131364912));
    arrayOfView[2] = a(2130846001, 2130845910, 2130846002, 2130845911, 2131433253, 11, 2);
    View localView = a(2130845999, 2130845908, 2130846000, 2130845909, 2131433254, 12, 3);
    localView.setOnClickListener(new syo(null));
    arrayOfView[3] = new RedTouchTab(paramLayoutInflater.getContext(), localView).a(49).d(3).a(true).b(5).a();
    localView = a(-1, 2130845914, 2130846003, 2130845915, 2131433255, 14, 4);
    localView.setOnClickListener(new syo(null));
    arrayOfView[4] = new RedTouchTab(paramLayoutInflater.getContext(), localView).a(49).d(3).a(true).b(5).a();
    localView = a(-1, 2130845914, 2130846003, 2130845915, 2131433255, 14, 4);
    localView.setOnClickListener(new syo(null));
    arrayOfView[5] = new RedTouchTab(paramLayoutInflater.getContext(), localView).a(49).d(3).a(true).b(5).a();
    return arrayOfView;
  }
  
  private View[] a(View paramView)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(8);
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap(12);
    Object localObject = ((SplashActivity)getActivity()).jdField_a_of_type_ArrayOfAndroidViewView;
    ((SplashActivity)getActivity()).jdField_a_of_type_ArrayOfAndroidViewView = null;
    int m;
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = ((DragFrameLayout)localObject[1]);
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[] { localObject[2], null, localObject[3], localObject[4], null, localObject[5], null };
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.setOnDragListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurTabDragListener);
      this.jdField_a_of_type_JavaUtilHashMap.put("消息", this.jdField_a_of_type_ArrayOfAndroidViewView[0]);
      this.jdField_a_of_type_JavaUtilHashMap.put("联系人", this.jdField_a_of_type_ArrayOfAndroidViewView[2]);
      this.jdField_a_of_type_JavaUtilHashMap.put("动态", this.jdField_a_of_type_ArrayOfAndroidViewView[3]);
      this.jdField_a_of_type_JavaUtilHashMap.put("消息_num", this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131364917));
      this.jdField_a_of_type_JavaUtilHashMap.put("联系人_num", this.jdField_a_of_type_ArrayOfAndroidViewView[2].findViewById(2131364917));
      this.jdField_a_of_type_JavaUtilHashMap.put("动态_num", this.jdField_a_of_type_ArrayOfAndroidViewView[3].findViewById(2131364917));
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if ((localObject == null) || (!((NowLiveManager)localObject).jdField_a_of_type_Boolean)) {
        break label797;
      }
      m = 1;
      label257:
      if ((m != 0) && (this.jdField_a_of_type_ArrayOfAndroidViewView[4] != null))
      {
        this.jdField_a_of_type_JavaUtilHashMap.put("NOW", this.jdField_a_of_type_ArrayOfAndroidViewView[4]);
        this.jdField_a_of_type_JavaUtilHashMap.put("NOW_num", this.jdField_a_of_type_ArrayOfAndroidViewView[4].findViewById(2131364917));
      }
      localObject = ReadInJoyUtils.a(2130840885, 2130845916, 2130840886, 2130845917, 2131439038, 16, 8);
      if (localObject != null)
      {
        ((View)localObject).setOnClickListener(new syd(this));
        this.jdField_a_of_type_ArrayOfAndroidViewView[6] = new RedTouch(getActivity(), (View)localObject).a(49).d(3).b(5).a();
        this.jdField_a_of_type_JavaUtilHashMap.put("看点", this.jdField_a_of_type_ArrayOfAndroidViewView[6]);
        this.jdField_a_of_type_JavaUtilHashMap.put("看点_num", this.jdField_a_of_type_ArrayOfAndroidViewView[6].findViewById(2131364917));
      }
      paramView = (QQTabWidget)paramView.findViewById(16908307);
      if (paramView == null) {
        break label802;
      }
      paramView.setShowDividers(0);
      paramView.setTabWidgetMoveListener(this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabWidget$onTabWidgetTouchMoveListener);
    }
    for (;;)
    {
      return this.jdField_a_of_type_ArrayOfAndroidViewView;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = ((DragFrameLayout)paramView.findViewById(2131364912));
      localObject = a(2130845999, 2130845908, 2130846000, 2130845909, 2131433254, 12, 3);
      ((View)localObject).setOnClickListener(new syo(null));
      View localView1 = a(-1, 2130845914, 2130846003, 2130845915, 2131433255, 14, 4);
      localView1.setOnClickListener(new syo(null));
      View localView2 = a(-1, 2130845914, 2130846003, 2130845915, 2131433255, 14, 4);
      localView2.setOnClickListener(new syo(null));
      View localView3 = a(2130843346, 2130845912, 2130843347, 2130845913, 2131432073, 15, 5);
      localView3.setOnClickListener(new syo(null));
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[] { a(2130846001, 2130845910, 2130846002, 2130845911, 2131433253, 11, 2), null, new RedTouchTab(getActivity(), (View)localObject).a(49).d(3).a(true).b(5).a(), new RedTouchTab(getActivity(), localView1).a(49).d(3).a(true).b(5).a(), new RedTouchTab(getActivity(), localView3).a(49).d(3).a(true).b(5).a(), new RedTouchTab(getActivity(), localView2).a(49).d(3).a(true).b(5).a(), null };
      break;
      label797:
      m = 0;
      break label257;
      label802:
      QLog.i("MainFragment", 1, "initTabs tabWidget is null");
    }
  }
  
  private void b(int paramInt)
  {
    QLog.d("MainFragment", 2, "update kandian tab, type : " + paramInt);
    ReadInjoyTabDragAnimationView localReadInjoyTabDragAnimationView = (ReadInjoyTabDragAnimationView)this.jdField_a_of_type_AndroidUtilSparseArray.get(jdField_g_of_type_Int);
    if (localReadInjoyTabDragAnimationView == null) {
      QLog.d("MainFragment", 2, "iconView is null, give up !");
    }
    do
    {
      return;
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
  
  private boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost == null) {
      return false;
    }
    if (a() == jdField_f_of_type_Int) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.redPointclearStoryRedPointIfNeeded", 2, "当前是nowtab的话，清理红点==>isCurrentTabNowTab:" + bool);
      }
      if ((!bool) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
        break;
      }
      oidb_0x791.RedDotInfo localRedDotInfo = ((TroopRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(69)).a();
      if ((localRedDotInfo != null) && ((localRedDotInfo.uint32_appid.get() == 28) || (localRedDotInfo.uint32_appid.get() == 49))) {
        break;
      }
      a(37, null);
      return true;
    }
  }
  
  private String c()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "getCurrentTabTag. mTabHost is null");
      }
      localObject = null;
    }
    String str2;
    do
    {
      String str1;
      do
      {
        return localObject;
        str1 = "";
        str2 = this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.getCurrentTabTag();
        localObject = str1;
      } while (str2 == null);
      if (str2.equals(Conversation.class.getName())) {
        return "消息";
      }
      if (str2.equals(Contacts.class.getName())) {
        return "联系人";
      }
      if (str2.equals(Leba.class.getName())) {
        return "动态";
      }
      localObject = str1;
    } while (!str2.equals(Now.class.getName()));
    return "NOW";
  }
  
  private boolean c()
  {
    RedTouch localRedTouch = (RedTouch)this.jdField_a_of_type_JavaUtilHashMap.get("动态");
    if (localRedTouch == null) {
      return false;
    }
    return localRedTouch.a();
  }
  
  private void d(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    int m;
    int n;
    label34:
    int i1;
    if ((localObject != null) && (((NowLiveManager)localObject).jdField_a_of_type_Boolean))
    {
      m = 1;
      if (localObject != null) {
        break label270;
      }
      n = this.jdField_i_of_type_Int;
      if (this.l == ReadInJoyHelper.f()) {
        break label279;
      }
      i1 = 1;
      label47:
      if ((!paramBoolean) && ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.n) || (this.jdField_a_of_type_ArrayOfAndroidViewView[1] != null)) && ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.n) || (this.jdField_a_of_type_ArrayOfAndroidViewView[1] == null)) && (this.jdField_i_of_type_Int == n) && ((m == 0) || (this.jdField_a_of_type_ArrayOfAndroidViewView[4] != null)) && ((m != 0) || (this.jdField_a_of_type_ArrayOfAndroidViewView[4] == null)) && (i1 == 0)) {
        break label700;
      }
      if (localObject != null)
      {
        if (m == 0) {
          break label285;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      }
    }
    for (NowLiveManager.jdField_c_of_type_Boolean = true;; NowLiveManager.jdField_c_of_type_Boolean = false)
    {
      LebaShowListManager.jdField_a_of_type_Int |= 0x2;
      if (QLog.isColorLevel()) {
        QLog.i("MainFragment", 2, "setFrames" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.n);
      }
      this.jdField_i_of_type_Int = n;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.clearAllTabs();
      }
      i1 = this.jdField_a_of_type_ArrayOfAndroidViewView.length;
      n = 0;
      while (n < i1)
      {
        localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[n];
        if (localObject != null)
        {
          ((View)localObject).setSelected(false);
          ((View)localObject).setId(n + 16);
        }
        n += 1;
      }
      m = 0;
      break;
      label270:
      n = ((NowLiveManager)localObject).jdField_b_of_type_Int;
      break label34;
      label279:
      i1 = 0;
      break label47;
      label285:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    }
    if (m != 0)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.n, this.jdField_i_of_type_Int, false);
      s();
      localObject = a(Conversation.class);
      if (localObject != null) {
        ((Conversation)localObject).f(true);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.n) {
        break label717;
      }
      this.jdField_a_of_type_ArrayOfAndroidViewView[1] = a(2130845996, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("电话", this.jdField_a_of_type_ArrayOfAndroidViewView[1]);
      this.jdField_a_of_type_JavaUtilHashMap.put("电话_num", this.jdField_a_of_type_ArrayOfAndroidViewView[1].findViewById(2131364917));
      this.jdField_a_of_type_ArrayOfAndroidViewView[4] = null;
      this.jdField_a_of_type_JavaUtilHashMap.remove("NOW");
      this.jdField_a_of_type_JavaUtilHashMap.remove("NOW_num");
      a(Now.class);
      label444:
      m = this.jdField_i_of_type_Int;
      if ((m == 0) && (this.jdField_a_of_type_ArrayOfAndroidViewView[4] != null)) {
        a(this.jdField_a_of_type_AndroidViewView, Now.class, this.jdField_a_of_type_ArrayOfAndroidViewView[4]);
      }
      a(this.jdField_a_of_type_AndroidViewView, Conversation.class, this.jdField_a_of_type_ArrayOfAndroidViewView[0]);
      if ((m == 1) && (this.jdField_a_of_type_ArrayOfAndroidViewView[4] != null)) {
        a(this.jdField_a_of_type_AndroidViewView, Now.class, this.jdField_a_of_type_ArrayOfAndroidViewView[4]);
      }
      a(this.jdField_a_of_type_AndroidViewView, Contacts.class, this.jdField_a_of_type_ArrayOfAndroidViewView[2]);
      if (!ReadInJoyHelper.f()) {
        break label1048;
      }
      t();
      a(this.jdField_a_of_type_AndroidViewView, ReadinjoyTabFrame.class, this.jdField_a_of_type_ArrayOfAndroidViewView[6]);
    }
    for (this.l = true;; this.l = false)
    {
      if ((m == 2) && (this.jdField_a_of_type_ArrayOfAndroidViewView[4] != null)) {
        a(this.jdField_a_of_type_AndroidViewView, Now.class, this.jdField_a_of_type_ArrayOfAndroidViewView[4]);
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("动态", this.jdField_a_of_type_ArrayOfAndroidViewView[3]);
      this.jdField_a_of_type_JavaUtilHashMap.put("动态_num", this.jdField_a_of_type_ArrayOfAndroidViewView[3].findViewById(2131364917));
      a(this.jdField_a_of_type_AndroidViewView, Leba.class, this.jdField_a_of_type_ArrayOfAndroidViewView[3]);
      if ((m == 3) && (this.jdField_a_of_type_ArrayOfAndroidViewView[4] != null)) {
        a(this.jdField_a_of_type_AndroidViewView, Now.class, this.jdField_a_of_type_ArrayOfAndroidViewView[4]);
      }
      e(false);
      label700:
      return;
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.n, -100, false);
      break;
      label717:
      if ((m != 0) && (this.jdField_i_of_type_Int < 4) && (this.jdField_i_of_type_Int >= 0) && (QQStoryManager.j()))
      {
        localObject = a(2130843346, 2130845912, 2130843347, 2130845913, 2131432073, 15, 5);
        ((View)localObject).setOnClickListener(new syo(null));
        this.jdField_a_of_type_ArrayOfAndroidViewView[4] = new RedTouchTab(getActivity(), (View)localObject).a(49).d(3).a(true).b(5).a();
        this.jdField_a_of_type_JavaUtilHashMap.put("NOW", this.jdField_a_of_type_ArrayOfAndroidViewView[4]);
        this.jdField_a_of_type_JavaUtilHashMap.put("NOW_num", this.jdField_a_of_type_ArrayOfAndroidViewView[4].findViewById(2131364917));
        this.jdField_a_of_type_JavaUtilHashMap.put("NOW_img", this.jdField_a_of_type_ArrayOfAndroidViewView[4].findViewById(2131364918));
        this.jdField_a_of_type_ArrayOfAndroidViewView[1] = null;
        this.jdField_a_of_type_JavaUtilHashMap.remove("电话");
        this.jdField_a_of_type_JavaUtilHashMap.remove("电话_num");
        localObject = (TabDragAnimationView)this.jdField_a_of_type_ArrayOfAndroidViewView[4].findViewById(2131364916);
        ((TabDragAnimationView)localObject).setOnTouchListener(new syp(null));
        this.jdField_a_of_type_AndroidUtilSparseArray.put(jdField_f_of_type_Int, localObject);
        this.jdField_b_of_type_AndroidUtilSparseArray.put(jdField_f_of_type_Int, (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[4].findViewById(2131375031));
        u();
        break label444;
      }
      this.jdField_a_of_type_ArrayOfAndroidViewView[1] = null;
      this.jdField_a_of_type_JavaUtilHashMap.remove("电话");
      this.jdField_a_of_type_JavaUtilHashMap.remove("电话_num");
      this.jdField_a_of_type_ArrayOfAndroidViewView[4] = null;
      this.jdField_a_of_type_JavaUtilHashMap.remove("NOW");
      this.jdField_a_of_type_JavaUtilHashMap.remove("NOW_num");
      a(Now.class);
      break label444;
      label1048:
      a(ReadinjoyTabFrame.class);
    }
  }
  
  private void e(boolean paramBoolean)
  {
    Object localObject1 = ThemeUtil.getCurrentThemeId();
    boolean bool;
    float f1;
    int m;
    label63:
    int i2;
    int n;
    if (("1000".equals(localObject1)) || ("999".equals(localObject1)))
    {
      bool = true;
      this.jdField_i_of_type_Boolean = bool;
      f1 = getResources().getDisplayMetrics().density;
      if (!this.jdField_i_of_type_Boolean) {
        break label253;
      }
      m = Math.round(54.0F * f1);
      i2 = Math.round(6.0F * f1);
      if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
        break label277;
      }
      bool = ThemeUtil.isNowThemeIsAnimate();
      n = 0;
      label88:
      if (n >= this.jdField_a_of_type_AndroidUtilSparseArray.size()) {
        break label277;
      }
      localObject1 = (TabDragAnimationView)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(n);
      ((TabDragAnimationView)localObject1).jdField_c_of_type_Boolean = bool;
      ((TabDragAnimationView)localObject1).a = null;
      if (!this.jdField_i_of_type_Boolean) {
        break label259;
      }
      i1 = (int)(29.0F * f1 + 0.5F);
      label146:
      ((TabDragAnimationView)localObject1).setIconSize(i1, i1);
      ((TabDragAnimationView)localObject1).setAnimEnable(this.jdField_i_of_type_Boolean);
      if (!this.jdField_i_of_type_Boolean) {
        break label265;
      }
      i1 = 1;
      label174:
      ((TabDragAnimationView)localObject1).setIconGravity(i1);
      if (!this.jdField_i_of_type_Boolean) {
        break label271;
      }
    }
    Object localObject2;
    label259:
    label265:
    label271:
    for (int i1 = (int)(5.0F * f1 + 0.5F);; i1 = 0)
    {
      ((TabDragAnimationView)localObject1).setPadding(0, i1, 0, i1);
      localObject2 = new RelativeLayout.LayoutParams(((TabDragAnimationView)localObject1).getLayoutParams());
      ((RelativeLayout.LayoutParams)localObject2).height = m;
      ((TabDragAnimationView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      n += 1;
      break label88;
      bool = false;
      break;
      label253:
      m = -2;
      break label63;
      i1 = -1;
      break label146;
      i1 = 0;
      break label174;
    }
    label277:
    if (this.jdField_b_of_type_AndroidUtilSparseArray != null)
    {
      n = 0;
      if (n < this.jdField_b_of_type_AndroidUtilSparseArray.size())
      {
        localObject1 = (TextView)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(n);
        if (this.jdField_i_of_type_Boolean)
        {
          ((TextView)localObject1).setVisibility(0);
          localObject2 = (RelativeLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).bottomMargin = i2;
          ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        for (;;)
        {
          n += 1;
          break;
          ((TextView)localObject1).setVisibility(8);
        }
      }
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(16908307);
      if (localObject1 != null)
      {
        localObject2 = ((View)localObject1).getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).height = m;
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      if ((!paramBoolean) && (this.jdField_i_of_type_Boolean))
      {
        long l1 = System.currentTimeMillis();
        localObject2 = this.jdField_a_of_type_AndroidViewView.findViewById(16908305);
        if ((localObject1 != null) && (localObject2 != null))
        {
          n = ((View)localObject2).getPaddingBottom();
          if ((m > 0) && (n != m)) {
            ((View)localObject2).setPadding(0, 0, 0, m);
          }
          if (QLog.isColorLevel()) {
            QLog.d("MainFragment", 2, "checkEnableTabAnim, height=" + m + ", padding=" + n + ", cost=" + (System.currentTimeMillis() - l1));
          }
        }
      }
    }
  }
  
  private void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "showActionSheet");
    }
    e();
    ArrayList localArrayList = new ArrayList();
    Object localObject = new syq();
    ((syq)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131435360);
    localArrayList.add(new Pair(Integer.valueOf(2131362031), localObject));
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("com.tencent.Feedback_5_8");
    if ((localObject != null) && (((ResourcePluginInfo)localObject).cLocalState != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "feedback plugin is add overmenu");
      }
      syq localsyq = new syq();
      localsyq.jdField_a_of_type_JavaLangString = ((ResourcePluginInfo)localObject).strResName;
      localsyq.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo = ((ResourcePluginInfo)localObject);
      localArrayList.add(new Pair(Integer.valueOf(2131362032), localsyq));
    }
    localObject = new syq();
    ((syq)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131433503);
    localArrayList.add(new Pair(Integer.valueOf(2131362033), localObject));
    localObject = new syq();
    ((syq)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131433682);
    localArrayList.add(new Pair(Integer.valueOf(2131362034), localObject));
    localObject = ActionSheet.c(getActivity());
    int m = 0;
    if (m < localArrayList.size())
    {
      if (2131362034 == ((Integer)((Pair)localArrayList.get(m)).first).intValue()) {
        ((ActionSheet)localObject).d(((syq)((Pair)localArrayList.get(m)).second).jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        m += 1;
        break;
        ((ActionSheet)localObject).c(((syq)((Pair)localArrayList.get(m)).second).jdField_a_of_type_JavaLangString);
      }
    }
    ((ActionSheet)localObject).a(new syl(this, localArrayList, (ActionSheet)localObject));
    ((ActionSheet)localObject).setOnDismissListener(new sym(this));
    ((ActionSheet)localObject).setCanceledOnTouchOutside(true);
    this.jdField_b_of_type_AndroidAppDialog = ((Dialog)localObject);
    try
    {
      this.jdField_b_of_type_AndroidAppDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void s()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(3);
    this.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray(3);
    syp localsyp = new syp(null);
    TabDragAnimationView localTabDragAnimationView = (TabDragAnimationView)this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131364916);
    localTabDragAnimationView.setOnTouchListener(localsyp);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(jdField_a_of_type_Int, localTabDragAnimationView);
    localTabDragAnimationView = (TabDragAnimationView)this.jdField_a_of_type_ArrayOfAndroidViewView[2].findViewById(2131364916);
    localTabDragAnimationView.setOnTouchListener(localsyp);
    localTabDragAnimationView.setExpectedLogoMoveDistance(ViewUtils.b(2.0F));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(jdField_c_of_type_Int, localTabDragAnimationView);
    localTabDragAnimationView = (TabDragAnimationView)this.jdField_a_of_type_ArrayOfAndroidViewView[3].findViewById(2131364916);
    localTabDragAnimationView.setOnTouchListener(localsyp);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(jdField_d_of_type_Int, localTabDragAnimationView);
    if ((ReadInJoyHelper.f()) && (this.jdField_a_of_type_ArrayOfAndroidViewView[6] != null))
    {
      localTabDragAnimationView = (TabDragAnimationView)this.jdField_a_of_type_ArrayOfAndroidViewView[6].findViewById(2131364916);
      localTabDragAnimationView.setOnTouchListener(localsyp);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(jdField_g_of_type_Int, localTabDragAnimationView);
    }
    this.jdField_b_of_type_AndroidUtilSparseArray.put(jdField_a_of_type_Int, (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131375031));
    this.jdField_b_of_type_AndroidUtilSparseArray.put(jdField_c_of_type_Int, (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[2].findViewById(2131375031));
    this.jdField_b_of_type_AndroidUtilSparseArray.put(jdField_d_of_type_Int, (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[3].findViewById(2131375031));
    if ((ReadInJoyHelper.f()) && (this.jdField_a_of_type_ArrayOfAndroidViewView[6] != null)) {
      this.jdField_b_of_type_AndroidUtilSparseArray.put(jdField_g_of_type_Int, (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[6].findViewById(2131375031));
    }
  }
  
  private void t()
  {
    boolean bool3 = true;
    Object localObject2 = (RedTouch)this.jdField_a_of_type_JavaUtilHashMap.get("看点");
    boolean bool1;
    Object localObject1;
    boolean bool2;
    if (localObject2 != null)
    {
      Frame localFrame = c();
      if ((localFrame == null) || (!(localFrame instanceof ReadinjoyTabFrame))) {
        break label298;
      }
      bool1 = true;
      KandianMergeManager localKandianMergeManager = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161);
      localObject1 = localKandianMergeManager.a();
      if ((localObject1 == null) || (((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.get() != 5)) {
        break label303;
      }
      bool2 = true;
      label84:
      if ((!bool1) || (localObject1 == null) || (((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.get() != 0) || (((!(localFrame instanceof ReadinjoyTabFrame)) || (((ReadinjoyTabFrame)localFrame).a() == null) || (((ReadinjoyTabFrame)localFrame).a().mChannelCoverId == 0)) && ((localKandianMergeManager.f() == null) || (localKandianMergeManager.f().jdField_a_of_type_Int <= 0)))) {
        break label322;
      }
      localObject1 = null;
    }
    label298:
    label303:
    label313:
    label322:
    for (;;)
    {
      ((RedTouch)localObject2).setTag(2131362410, localObject1);
      a(39, (RedTouch)localObject2, (BusinessInfoCheckUpdate.RedTypeInfo)localObject1);
      if (((BaseActivity.sTopActivity instanceof SplashActivity)) && (isVisible()) && (localObject1 != null)) {
        ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BusinessInfoCheckUpdate.RedTypeInfo)localObject1);
      }
      localObject2 = new StringBuilder().append("updateKandianTabRedPoint isInTabFrame : ").append(bool1).append(", isRemoveRedPoint : ");
      if (localObject1 == null)
      {
        bool1 = bool3;
        label241:
        localObject2 = ((StringBuilder)localObject2).append(bool1).append(", isNumRedPoint : ").append(bool2).append(", cnt : ");
        if (localObject1 == null) {
          break label313;
        }
      }
      for (localObject1 = ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_content.get();; localObject1 = Integer.valueOf(0))
      {
        QLog.d("Q.readinjoy.4tab", 2, localObject1);
        return;
        bool1 = false;
        break;
        bool2 = false;
        break label84;
        bool1 = false;
        break label241;
      }
    }
  }
  
  private void u()
  {
    if (b()) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      localObject = (TroopRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(69);
    } while ((this.jdField_a_of_type_JavaUtilHashMap == null) || (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("NOW_num")));
    oidb_0x791.RedDotInfo localRedDotInfo = ((TroopRedTouchManager)localObject).a();
    if (localRedDotInfo == null)
    {
      a(37, null);
      return;
    }
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    Object localObject = "";
    switch (localRedDotInfo.uint32_appid.get())
    {
    default: 
      return;
    case 8: 
    case 35: 
      localRedTypeInfo.red_type.set(0);
      localRedTypeInfo.red_content.set("");
      localRedTypeInfo.red_desc.set("");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("storyRedDotDebug", 2, "更新tab红点:" + TroopRedTouchManager.a(localRedDotInfo));
      }
      a(37, localRedTypeInfo);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("MainFragmentQ.qqstory.redPoint", 2, "redDotInfo==>style:" + 0 + ", num:" + 0 + ", text:" + (String)localObject);
      return;
      if (localRedDotInfo.uint32_number.get() > 99) {}
      for (localObject = "99+";; localObject = localRedDotInfo.uint32_number.get() + "")
      {
        localRedTypeInfo.red_type.set(4);
        localRedTypeInfo.red_content.set((String)localObject);
        localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
        break;
      }
      localObject = localRedDotInfo.str_custom_buffer.get().toStringUtf8();
      localRedTypeInfo.red_type.set(4);
      localRedTypeInfo.red_content.set((String)localObject);
      localRedTypeInfo.red_desc.set("{'cn':'#FF0000', 'av':1}");
    }
  }
  
  public int a()
  {
    int m = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost != null) {
      m = this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.getCurrentTab();
    }
    while (!QLog.isColorLevel()) {
      return m;
    }
    QLog.e("MainFragment", 2, "getCurrentTab");
    return 0;
  }
  
  public Dialog a(String paramString1, String paramString2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    Dialog localDialog = new Dialog(getActivity(), 2131624515);
    localDialog.setContentView(2130968978);
    TextView localTextView = (TextView)localDialog.findViewById(2131364010);
    if (localTextView != null)
    {
      if (paramString1 == null) {
        localTextView.setVisibility(8);
      }
    }
    else
    {
      paramString1 = (TextView)localDialog.findViewById(2131362758);
      if (paramString1 != null)
      {
        if (paramString2 != null) {
          break label149;
        }
        paramString1.setVisibility(8);
      }
    }
    for (;;)
    {
      paramString1 = (TextView)localDialog.findViewById(2131364013);
      if (paramString1 != null) {
        paramString1.setText(2131432998);
      }
      paramString1 = (TextView)localDialog.findViewById(2131364014);
      if (paramString1 != null) {
        paramString1.setText(2131432999);
      }
      localDialog.setOnDismissListener(paramOnDismissListener);
      return localDialog;
      localTextView.setVisibility(0);
      localTextView.setText(paramString1);
      break;
      label149:
      paramString1.setVisibility(0);
      paramString1.setText(paramString2);
    }
  }
  
  public RedTouch a(String paramString)
  {
    return (RedTouch)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  protected String a()
  {
    if (a()) {
      return getString(2131432397);
    }
    return super.a();
  }
  
  public HashMap a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "onDrawComplete");
    }
    super.a();
    Object localObject = b();
    if (localObject != null) {
      ((Frame)localObject).m();
    }
    if (jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.c();
      jdField_a_of_type_Boolean = false;
    }
    StartupTracker.a("Main_Start", null);
    if ("消息".equals(c()))
    {
      localObject = (VasExtensionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(234);
      if (((VasExtensionManager)localObject).a.a(false)) {
        ((VasExtensionManager)localObject).a.b(getView(), getActivity());
      }
      return;
    }
    FlashCarGameManager.jdField_b_of_type_Boolean = false;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setCurrentTab(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 12289) && (paramInt2 == -1) && ("消息".equals(c()))) {
      ((VasExtensionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(234)).a.a(getView(), getActivity());
    }
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    if (this.jdField_a_of_type_ArrayOfAndroidViewView == null) {}
    boolean bool;
    String str2;
    Object localObject;
    label68:
    String str1;
    label99:
    TextView localTextView;
    do
    {
      return;
      bool = false;
      str2 = "";
      switch (paramInt1)
      {
      case 34: 
      case 35: 
      case 37: 
      case 38: 
      default: 
        localObject = "";
        switch (paramInt2)
        {
        default: 
          str1 = null;
          localTextView = (TextView)this.jdField_a_of_type_JavaUtilHashMap.get((String)localObject + "_num");
        }
        break;
      }
    } while ((localTextView == null) || (str1 == null));
    int m;
    if ((paramObject instanceof Integer)) {
      m = ((Integer)paramObject).intValue();
    }
    for (;;)
    {
      label157:
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
      label242:
      int i1;
      int i2;
      label327:
      int n;
      label370:
      int i4;
      int i3;
      if (str1.equals((String)localObject + "_num"))
      {
        localSharedPreferences.edit().putInt(str1 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), m).commit();
        this.jdField_b_of_type_JavaUtilHashMap.put(str1, paramObject);
        m = 0;
        i1 = a((String)localObject);
        if (i1 != 3) {
          break label916;
        }
        localObject = this.jdField_b_of_type_JavaUtilHashMap.get((String)localObject + "_num");
        i2 = m;
        paramObject = str2;
        if ((localObject instanceof Integer))
        {
          i2 = ((Integer)localObject).intValue();
          paramObject = str2;
        }
        n = 0;
        if (paramInt1 != 32) {
          break label1139;
        }
        if (i2 <= 99) {
          break label998;
        }
        i1 = getResources().getDimensionPixelSize(2131558936);
        if (!this.jdField_i_of_type_Boolean) {
          break label987;
        }
        m = ViewUtils.b(7.0F);
        i4 = 4;
        n = 2130845930;
        i3 = m;
        m = i4;
        i4 = i1;
        localObject = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
        if (localObject != null)
        {
          ((RelativeLayout.LayoutParams)localObject).setMargins(i3, i4, 0, 0);
          localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      for (;;)
      {
        if (paramInt1 == 36)
        {
          i1 = getResources().getDimensionPixelSize(2131558934);
          i4 = getResources().getDimensionPixelSize(2131558932);
          if (i2 > 99)
          {
            i1 = getResources().getDimensionPixelSize(2131558936);
            n = 4;
            m = 2130845930;
            label480:
            localObject = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
            if (localObject != null)
            {
              ((RelativeLayout.LayoutParams)localObject).setMargins(i4, i1, 0, 0);
              localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
            }
            b();
            i1 = m;
            m = n;
          }
        }
        for (;;)
        {
          if (QLog.isDevelopLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("updateMain, [").append("tabIndex = ").append(paramInt1).append(",").append("type = ").append(paramInt2).append(",").append("style = ").append(m).append(",").append("num = ").append(i2).append(",").append("isVisable = ").append(bool).append(",").append("tv = ").append(localTextView.toString()).append(" ]");
            QLog.d("MainFragment", 4, ((StringBuilder)localObject).toString());
          }
          CustomWidgetUtil.a(localTextView, m, i2, i1, 99, paramObject);
          if (!AppSetting.jdField_b_of_type_Boolean) {
            break;
          }
          a("消息", c());
          a("联系人", c());
          a("动态", c());
          a("电话", c());
          a("NOW", c());
          return;
          localObject = "消息";
          break label68;
          localObject = "联系人";
          break label68;
          localObject = "电话";
          break label68;
          b(paramInt2);
          return;
          str1 = (String)localObject + "_num";
          break label99;
          str1 = (String)localObject + "_icon";
          break label99;
          str1 = (String)localObject + "_new";
          break label99;
          if (!(paramObject instanceof Boolean)) {
            break label1146;
          }
          bool = ((Boolean)paramObject).booleanValue();
          m = 0;
          break label157;
          localSharedPreferences.edit().putBoolean(str1 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), bool).commit();
          break label242;
          label916:
          i2 = m;
          paramObject = str2;
          if (i1 != 5) {
            break label327;
          }
          localObject = this.jdField_b_of_type_JavaUtilHashMap.get((String)localObject + "_text");
          i2 = m;
          paramObject = str2;
          if (!(localObject instanceof String)) {
            break label327;
          }
          paramObject = (String)localObject;
          i2 = m;
          break label327;
          label987:
          m = ViewUtils.b(5.0F);
          break label370;
          label998:
          i4 = getResources().getDimensionPixelSize(2131558934);
          if (this.jdField_i_of_type_Boolean) {}
          for (m = ViewUtils.b(7.0F);; m = ViewUtils.b(5.0F))
          {
            n = 0;
            i3 = m;
            m = i1;
            break;
          }
          if (i2 > 0)
          {
            n = m;
            m = 0;
            break label480;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MainFragment", 2, "updateMain mIsPstnRedTouchShow  = " + this.j);
          }
          if (this.j)
          {
            n = 1;
            m = 0;
            break label480;
          }
          i3 = m;
          m = n;
          n = i3;
          break label480;
          i1 = n;
        }
        label1139:
        m = i1;
      }
      label1146:
      m = 0;
    }
  }
  
  public void a(int paramInt, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {}
    do
    {
      do
      {
        do
        {
          return;
          switch (paramInt)
          {
          case 38: 
          default: 
            return;
          }
        } while (this.jdField_a_of_type_JavaUtilHashMap == null);
        a(paramInt, (RedTouch)this.jdField_a_of_type_JavaUtilHashMap.get("联系人"), paramRedTypeInfo);
        return;
        a(paramInt, (RedTouch)this.jdField_a_of_type_JavaUtilHashMap.get("动态"), paramRedTypeInfo);
        return;
      } while (this.jdField_a_of_type_JavaUtilHashMap == null);
      a(paramInt, (RedTouch)this.jdField_a_of_type_JavaUtilHashMap.get("NOW"), paramRedTypeInfo);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) && (this.jdField_a_of_type_AndroidWidgetImageView != null)) {
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(getActivity(), this.jdField_a_of_type_AndroidWidgetImageView).a(53).a();
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(paramRedTypeInfo);
    return;
    this.j = VideoMsgTools.a(paramRedTypeInfo);
    paramRedTypeInfo = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
    if (paramRedTypeInfo != null) {}
    for (paramInt = paramRedTypeInfo.a();; paramInt = 0)
    {
      a(36, 16, Integer.valueOf(paramInt));
      VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      t();
      return;
    }
  }
  
  protected void a(Intent paramIntent)
  {
    Object localObject1;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("onNewIntent ");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver == null)
      {
        bool = true;
        QLog.d("MainFragment", 2, bool);
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver != null) {
        break label62;
      }
    }
    label62:
    do
    {
      return;
      bool = false;
      break;
      BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent);
      localObject1 = paramIntent.getExtras();
    } while (localObject1 == null);
    if (Boolean.valueOf(((Bundle)localObject1).getBoolean("EXIT", false)).booleanValue())
    {
      getActivity().finish();
      return;
    }
    int m;
    if (((Bundle)localObject1).containsKey("tab_index")) {
      m = ((Bundle)localObject1).getInt("tab_index");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "onNewIntent tabIndex: " + m);
      }
      Object localObject2;
      label396:
      label404:
      Object localObject3;
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost != null) && (m >= 0))
      {
        if (m == jdField_a_of_type_Int)
        {
          int n = ((Bundle)localObject1).getInt("conversation_index", -1);
          bool = ((Bundle)localObject1).getBoolean("isOpenSelectMember", false);
          if ((1 == n) && ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.n))) {}
        }
        else
        {
          if ((m != jdField_a_of_type_Int) || (m != a())) {
            break label404;
          }
          paramIntent = (Conversation)a(Conversation.class);
          localObject2 = ((Bundle)localObject1).getString("from");
          if (QLog.isColorLevel()) {
            QLog.d("MainFragment", 2, "doOnNewIntent, same tab,from=" + (String)localObject2);
          }
          if (paramIntent == null) {
            break;
          }
          if ((!"10003".equals(localObject2)) && (!"10004".equals(localObject2))) {
            break label396;
          }
        }
        for (paramIntent.jdField_d_of_type_Boolean = true;; paramIntent.jdField_d_of_type_Boolean = false)
        {
          paramIntent.jdField_e_of_type_Boolean = ((Bundle)localObject1).getBoolean("theme_back_to_conversation", false);
          return;
          if (!((Bundle)localObject1).containsKey("main_tab_id")) {
            break label1024;
          }
          m = a((Bundle)localObject1);
          break;
          try
          {
            paramIntent = (Conversation)a(Conversation.class);
            if (paramIntent != null)
            {
              paramIntent.jdField_a_of_type_Boolean = true;
              if (bool) {
                paramIntent.jdField_b_of_type_Boolean = true;
              }
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setCurrentTab(m);
            return;
          }
          catch (Exception paramIntent)
          {
            return;
          }
        }
        if ((m == jdField_b_of_type_Int) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.n))
        {
          m = jdField_a_of_type_Int;
          bool = ((Bundle)localObject1).getBoolean("isOpenSelectMember", false);
          try
          {
            paramIntent = (Conversation)a(Conversation.class);
            if (paramIntent != null)
            {
              paramIntent.jdField_a_of_type_Boolean = true;
              if (bool) {
                paramIntent.jdField_b_of_type_Boolean = true;
              }
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setCurrentTab(m);
            return;
          }
          catch (Exception paramIntent)
          {
            return;
          }
        }
        if ((m >= 0) && (m < this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.getTabWidget().getChildCount()))
        {
          localObject3 = (Conversation)a(Conversation.class);
          localObject2 = ((Bundle)localObject1).getString("from");
          if (localObject3 != null)
          {
            if ("10003".equals(localObject2)) {
              ((Conversation)localObject3).jdField_d_of_type_Boolean = true;
            }
          }
          else
          {
            label539:
            if (("smartdevice".equals(localObject2)) && (m == jdField_c_of_type_Int))
            {
              localObject3 = (Contacts)a(Contacts.class);
              if (localObject3 != null) {
                ((Contacts)localObject3).b(true);
              }
            }
            if ((m == jdField_f_of_type_Int) && (m == a()))
            {
              localObject3 = (Now)a(Now.class);
              if (localObject3 != null)
              {
                ((Now)localObject3).jdField_b_of_type_Boolean = ((Bundle)localObject1).getBoolean("extra_from_share");
                ((Now)localObject3).jdField_a_of_type_JavaLangString = ((Bundle)localObject1).getString("new_video_extra_info");
              }
            }
            if ((m == jdField_d_of_type_Int) && ("campus_notice".equals(localObject2)))
            {
              if (QLog.isColorLevel()) {
                QLog.d("CampusNoticeManager", 2, String.format(Locale.getDefault(), "back from campus_notice %d", new Object[] { Integer.valueOf(DrawerFrame.jdField_a_of_type_Int) }));
              }
              if (DrawerFrame.jdField_a_of_type_Int == 0) {
                DrawerFrame.jdField_a_of_type_Int = 3;
              }
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setCurrentTab(m);
          }
        }
      }
      for (;;)
      {
        try
        {
          m = paramIntent.getIntExtra("forward", -1);
          if (m != 2) {
            break label851;
          }
          localObject1 = paramIntent.getParcelableExtra("AllInOne");
          if ((localObject1 instanceof ProfileActivity.AllInOne))
          {
            localObject1 = (ProfileActivity.AllInOne)localObject1;
            ((ProfileActivity.AllInOne)localObject1).jdField_g_of_type_Int = 100;
            ((ProfileActivity.AllInOne)localObject1).jdField_h_of_type_Int = 6;
            ProfileActivity.b(getActivity(), (ProfileActivity.AllInOne)localObject1);
          }
          paramIntent.removeExtra("forward");
          return;
        }
        catch (Exception paramIntent) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("MainFragment", 2, "", paramIntent);
        return;
        ((Conversation)localObject3).jdField_d_of_type_Boolean = false;
        break label539;
        if ((m >= 0) && (m == jdField_f_of_type_Int) && (m != a()))
        {
          this.jdField_a_of_type_AndroidContentIntent = paramIntent;
          continue;
          if (QLog.isColorLevel())
          {
            QLog.d("MainFragment", 2, "MainActivity:onNewIntent mTabHost is null");
            continue;
            label851:
            if (m == 3)
            {
              localObject1 = paramIntent.getStringExtra("url");
              localObject2 = new Intent(getActivity(), QQBrowserActivity.class);
              if (paramIntent.hasExtra("uintype"))
              {
                m = paramIntent.getIntExtra("uintype", -1);
                ((Intent)localObject2).putExtra("uintype", m);
                if ((m == 1030) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(239)))
                {
                  localObject3 = new PushReportController.PushReportItem();
                  ((PushReportController.PushReportItem)localObject3).jdField_e_of_type_JavaLangString = "0X8009241";
                  ((PushReportController.PushReportItem)localObject3).jdField_d_of_type_JavaLangString = "点击业务Push";
                  PushReportController.a((String)localObject1, (PushReportController.PushReportItem)localObject3);
                  PushReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (PushReportController.PushReportItem)localObject3);
                  ((CampusNoticeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(239)).a(null);
                  if (QLog.isColorLevel()) {
                    QLog.d("CampusNoticeManager", 2, "remove campus notice");
                  }
                }
              }
              ((Intent)localObject2).putExtra("url", (String)localObject1);
              startActivity((Intent)localObject2);
            }
          }
        }
      }
      label1024:
      m = -1;
    }
  }
  
  protected void a(Constants.LogoutReason paramLogoutReason)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "MainActivity:onLogout");
    }
    SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), "");
    if (TroopAssistantManager.a().d()) {
      TroopAssistantManager.a().a(false);
    }
    TroopAssistantManager.a().d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    LoadingStateManager.a().a(1);
    this.k = true;
    QIMNewFriend.a();
    super.a(paramLogoutReason);
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (paramInt == 82)
    {
      r();
      bool = true;
    }
    while (paramInt != 4) {
      return bool;
    }
    paramKeyEvent = b();
    if ((paramKeyEvent != null) && (paramKeyEvent.a())) {
      return true;
    }
    try
    {
      paramKeyEvent = (PendingIntent)getActivity().getIntent().getParcelableExtra("activity_finish_run_pendingIntent");
      if ((paramKeyEvent != null) && ((paramKeyEvent instanceof PendingIntent)) && (!getActivity().getIntent().getBooleanExtra("share_from_aio", false)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MainFragment", 2, "-->finish--send callback using PendingIntent");
        }
        paramKeyEvent.send();
      }
      getActivity().moveTaskToBack(true);
    }
    catch (Throwable paramKeyEvent)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MainFragment", 2, "", paramKeyEvent);
        }
      }
    }
    return true;
  }
  
  public String b()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "onAccountChanged");
    }
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    com.tencent.mobileqq.app.FriendListHandler.jdField_a_of_type_Int = -1;
    this.jdField_h_of_type_Boolean = false;
    ThreadManager.post(new syh(this), 2, null, true);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a();
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "onAccountChange.check.new....");
      }
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()))) {}
    }
    try
    {
      QNotificationManager localQNotificationManager = new QNotificationManager(getActivity());
      localQNotificationManager.cancel("MainFragment", 120);
      QZoneManagerImp localQZoneManagerImp = (QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(9);
      if (localQZoneManagerImp != null) {
        localQZoneManagerImp.a(1, 0);
      }
      localQNotificationManager.cancel("MainFragment", 121);
      localQNotificationManager.cancel("MainFragment", 122);
      localQNotificationManager.cancel("MainFragment", 123);
      localQNotificationManager.cancel("MainFragment", 129);
      localQNotificationManager.cancel("MainFragment", 144);
      localQNotificationManager.cancel("MainFragment", 193);
      localQNotificationManager.cancel("MainFragment", 211);
    }
    catch (Exception localException2)
    {
      label237:
      break label237;
    }
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.h();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
      ((QIMNewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(256)).a(this.jdField_a_of_type_ComTencentMobileqqAppQIMNewFriendManager$IQIMNotifyNewFriendListener);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSubaccountAssociatedAccountOptPopBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqSubaccountAssociatedAccountOptPopBar.e();
    }
    if (!this.k) {
      QQToast.a(getActivity(), 2, getString(2131436409), 1).a();
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ArrayOfAndroidViewView != null) && (this.jdField_a_of_type_JavaUtilHashMap != null)) {}
      try
      {
        d(false);
        QIMNewFriend.a();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.jdField_d_of_type_Boolean = false;
        }
        getActivity().getIntent().removeExtra("if_check_account_same");
        return;
        this.k = false;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localException1.printStackTrace();
          QLog.d("MainFragment", 2, "onAccountChange setFrame has error : " + localException1);
        }
      }
    }
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSubaccountAssociatedAccountOptPopBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqSubaccountAssociatedAccountOptPopBar.f();
    }
  }
  
  void d()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new syi(this), 500L);
  }
  
  public void e()
  {
    if ((this.jdField_b_of_type_AndroidAppDialog == null) || (this.jdField_b_of_type_AndroidAppDialog.isShowing())) {}
    try
    {
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
      label24:
      this.jdField_b_of_type_AndroidAppDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  void f()
  {
    g();
    Dialog localDialog = a("你确定退出QQ？", null, new syn(this));
    Object localObject = (TextView)localDialog.findViewById(2131364014);
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new syb(this, localDialog));
    }
    localObject = (TextView)localDialog.findViewById(2131364013);
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new syc(this));
    }
    localObject = getString(2131435386);
    boolean bool = SettingCloneUtil.isContainValue(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (String)localObject, "qqsetting_receivemsg_whenexit_key");
    this.jdField_d_of_type_Boolean = SettingCloneUtil.readValue(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (String)localObject, "qqsetting_receivemsg_whenexit_key", true);
    localObject = (CheckBox)localDialog.findViewById(2131363662);
    if ((bool) && (this.jdField_d_of_type_Boolean)) {
      ((CheckBox)localObject).setVisibility(8);
    }
    ((CheckBox)localObject).setChecked(this.jdField_d_of_type_Boolean);
    this.jdField_a_of_type_AndroidAppDialog = localDialog;
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog == null) || (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      label24:
      this.jdField_a_of_type_AndroidAppDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  public String getCIOPageName()
  {
    if (b() != null) {
      return b().getClass().getName();
    }
    return super.getCIOPageName();
  }
  
  public void h()
  {
    super.h();
    Frame localFrame = a(Conversation.class);
    if (localFrame != null) {
      ((Conversation)localFrame).b();
    }
    localFrame = a(Contacts.class);
    if (localFrame != null) {
      ((Contacts)localFrame).l();
    }
    localFrame = a(Leba.class);
    if (localFrame != null) {
      ((Leba)localFrame).p();
    }
    localFrame = a(Now.class);
    if (localFrame != null) {
      ((Now)localFrame).b();
    }
    localFrame = a(ReadinjoyTabFrame.class);
    if (localFrame != null) {
      ((ReadinjoyTabFrame)localFrame).z_();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b()))
    {
      if (!ThemeUtil.isNowThemeIsDefault(getActivity().app, true, null)) {
        break label145;
      }
      a(2131494229, true);
    }
    for (;;)
    {
      e(true);
      return;
      label145:
      a(2131494247, false);
    }
  }
  
  public void i()
  {
    Object localObject = a(Conversation.class);
    if ((localObject != null) && (((Conversation)localObject).c()))
    {
      localObject = (VipGiftManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(75);
      if (localObject != null)
      {
        VipGiftDownloadInfo localVipGiftDownloadInfo = ((VipGiftManager)localObject).a();
        if ((localVipGiftDownloadInfo != null) && (isResumed()) && (localVipGiftDownloadInfo.d == 2L)) {
          ((VipGiftManager)localObject).a(localVipGiftDownloadInfo, getActivity());
        }
      }
    }
  }
  
  public void j()
  {
    Frame localFrame = b();
    if (localFrame != null) {
      localFrame.v();
    }
  }
  
  public void k() {}
  
  public void onAttach(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "AutoMonitor_fragment MainFragment onAttach");
    }
    super.onAttach(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver = new MainAssistObserver((SplashActivity)getActivity());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public Animation onCreateAnimation(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramInt2 == 0) {
      return null;
    }
    Object localObject = (Animation)jdField_c_of_type_AndroidUtilSparseArray.get(paramInt2);
    if (localObject == null)
    {
      if (paramInt2 == 2131034178)
      {
        localObject = new MainEnterOutAni();
        ((Animation)localObject).setDuration(getActivity().getResources().getInteger(2131689481));
        ((Animation)localObject).setInterpolator(getActivity(), 17432580);
      }
      for (;;)
      {
        jdField_c_of_type_AndroidUtilSparseArray.put(paramInt2, localObject);
        return localObject;
        localObject = AnimationUtils.loadAnimation(getActivity(), paramInt2);
      }
    }
    ((Animation)localObject).reset();
    return localObject;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "AutoMonitor_fragment MainFragment onCreateView + rootView =  " + this.jdField_a_of_type_AndroidViewView);
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      paramViewGroup = getActivity().findViewById(2131364857);
      if (paramViewGroup != null)
      {
        ViewParent localViewParent = paramViewGroup.getParent();
        if (localViewParent != null) {
          ((ViewGroup)localViewParent).removeView(paramViewGroup);
        }
      }
      paramViewGroup = (SplashActivity)getActivity();
      if (paramViewGroup.jdField_a_of_type_ArrayOfAndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView = paramViewGroup.jdField_a_of_type_ArrayOfAndroidViewView[0];
        paramLayoutInflater = new sya(this);
        if (!StartService.jdField_a_of_type_Boolean) {
          break label173;
        }
        paramLayoutInflater.run();
      }
    }
    for (;;)
    {
      return this.jdField_a_of_type_AndroidViewView;
      this.jdField_a_of_type_AndroidViewView = super.onCreateView(paramLayoutInflater, null, paramBundle);
      break;
      if (this.jdField_a_of_type_AndroidViewView.getParent() == null) {
        break;
      }
      ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.jdField_a_of_type_AndroidViewView);
      break;
      label173:
      ThreadManager.getSubThreadHandler().postDelayed(paramLayoutInflater, 1000L);
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "AutoMonitor_fragment MainFragment onDestroy");
    }
    super.onDestroy();
    jdField_c_of_type_AndroidUtilSparseArray.clear();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver != null))
    {
      if (!this.jdField_g_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.b();
        this.jdField_g_of_type_Boolean = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
      ((QIMNewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(256)).a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatObserver);
    }
    ScreenCapture.clearSnapCacheFile(getActivity());
    if (getActivity().isFinishing()) {}
    try
    {
      UniformDownloadMgr.a().c();
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "MainActivity.onDestory");
      }
      if (DownloadManager.a()) {
        DownloadManager.a().d();
      }
      TMAssistantDownloadManager.closeAllService(BaseApplication.getContext());
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Intent localIntent;
        localThrowable.printStackTrace();
        continue;
        boolean bool = false;
      }
      label272:
      if (!SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, "pcactive_config", false)) {
        break label323;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startPCActivePolling(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "exitApp");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(true);
      return;
      label323:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(false);
    }
    if (!jdField_c_of_type_Boolean)
    {
      bool = true;
      jdField_b_of_type_Boolean = bool;
      jdField_c_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isClearTaskBySystem = jdField_b_of_type_Boolean;
        if (!jdField_b_of_type_Boolean) {
          break label272;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop = true;
        localIntent = new Intent("mqq.intent.action.EXIT" + getActivity().getPackageName());
        getActivity().sendBroadcast(localIntent);
      }
    }
  }
  
  public void onDestroyView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "AutoMonitor_fragment MainFragment onDestroyView");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.b();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      ((QIMNewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(256)).a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatObserver);
    }
    this.jdField_g_of_type_Boolean = true;
    super.onDestroyView();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    QLog.d("MainFragment", 1, "onHiddenChanged" + paramBoolean);
    if (paramBoolean)
    {
      this.jdField_e_of_type_Boolean = true;
      onPause();
      onStop();
      this.jdField_e_of_type_Boolean = false;
    }
    for (;;)
    {
      super.onHiddenChanged(paramBoolean);
      return;
      if (Build.VERSION.SDK_INT < 18) {
        this.jdField_a_of_type_AndroidViewView.requestFocus();
      }
      if (getActivity().getIntent().getBooleanExtra("isFromAioFragment", false))
      {
        onStart();
        onResume();
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if ((SplashActivity.jdField_a_of_type_Int != 1) && (!this.jdField_e_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "onPause return");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "AutoMonitor_fragment MainFragment onPause");
    }
    if ((this.jdField_b_of_type_Long != 0L) && (this.jdField_c_of_type_JavaLangString != null) && (UnifiedMonitor.a().whetherReportThisTime(8))) {
      UnifiedMonitor.a().addEvent(8, this.jdField_c_of_type_JavaLangString, (int)(SystemClock.uptimeMillis() - this.jdField_b_of_type_Long), 0, null);
    }
    this.jdField_b_of_type_Long = 0L;
    e();
    com.tencent.mobileqq.activity.recent.RecentUtil.jdField_b_of_type_Boolean = false;
    if (DrawerFrame.jdField_a_of_type_Int == 2) {
      p();
    }
    FrameHelperActivity.b(false);
    ((VasExtensionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(234)).a.a();
  }
  
  public void onResume()
  {
    super.onResume();
    if (SplashActivity.jdField_a_of_type_Int != 1) {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "onResume return");
      }
    }
    Object localObject;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "AutoMonitor_fragment MainFragment onResume");
      }
      StartupTracker.a(null, "Main_OnResume");
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      FrameHelperActivity.b(true);
      if (DrawerFrame.jdField_a_of_type_Int > 0)
      {
        if ((DrawerFrame.jdField_a_of_type_Int == 3) && (QLog.isColorLevel())) {
          QLog.d("MainFragment", 2, String.format(Locale.getDefault(), "maybe back from campus notice cur tab: %d", new Object[] { Integer.valueOf(a()) }));
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
        if (localObject != null) {
          ((MqqHandler)localObject).removeMessages(1031);
        }
        p();
      }
      d(false);
      if (GuardManager.a != null) {
        GuardManager.a.b(6, null);
      }
      com.tencent.mobileqq.activity.recent.RecentUtil.jdField_b_of_type_Boolean = true;
      if (this.jdField_a_of_type_AndroidContentIntent != null)
      {
        localObject = this.jdField_a_of_type_AndroidContentIntent;
        this.jdField_a_of_type_AndroidContentIntent = null;
        ((SplashActivity)getActivity()).b((Intent)localObject);
      }
      ThreadManager.getSubThreadHandler().postDelayed(new syg(this), 1000L);
      this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.h();
      StartupTracker.a("Main_OnResume", null);
      localObject = (TroopRedTouchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(43);
    } while ((localObject == null) || (!((TroopRedTouchHandler)localObject).a()) || (!QLog.isColorLevel()));
    QLog.d("Q.qqstory.redPoint", 2, "MainFragment onResume, getRedPointInfo");
  }
  
  public void onStart()
  {
    super.onStart();
    if (SplashActivity.jdField_a_of_type_Int != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "onStart return");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "onStart");
    }
    Object localObject;
    if ((this.jdField_d_of_type_JavaLangString != null) && (this.jdField_d_of_type_JavaLangString.length() > 0) && ("pakage_from_h5".equalsIgnoreCase(this.jdField_e_of_type_JavaLangString)))
    {
      localObject = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_d_of_type_JavaLangString);
      ((JumpAction)localObject).b(this.jdField_e_of_type_JavaLangString);
      ((JumpAction)localObject).b();
      this.jdField_d_of_type_JavaLangString = null;
      this.jdField_e_of_type_JavaLangString = null;
    }
    ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161)).o();
    if (ReadInJoyHelper.f())
    {
      localObject = (RedTouch)this.jdField_a_of_type_JavaUtilHashMap.get("看点");
      if (localObject != null)
      {
        localObject = (BusinessInfoCheckUpdate.RedTypeInfo)((RedTouch)localObject).getTag(2131362410);
        ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BusinessInfoCheckUpdate.RedTypeInfo)localObject);
      }
      ThreadManager.executeOnSubThread(new syk(this));
    }
    ((AppGuideTipsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).e();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a(getActivity().getIntent());
    }
    ReadinjoySPEventReport.m();
  }
  
  public void onStop()
  {
    super.onStop();
    if ((SplashActivity.jdField_a_of_type_Int != 1) && (!this.jdField_e_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "onStop return");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "AutoMonitor_fragment MainFragment onStop");
    }
    if (DrawerFrame.jdField_a_of_type_Int > 0) {
      p();
    }
    KandianAppInPush.a().a(false);
  }
  
  public void onTabChanged(String paramString)
  {
    int i2 = 0;
    if ((this.jdField_b_of_type_Long != 0L) && (this.jdField_c_of_type_JavaLangString != null) && (UnifiedMonitor.a().whetherReportThisTime(8))) {
      UnifiedMonitor.a().addEvent(8, this.jdField_c_of_type_JavaLangString, (int)(SystemClock.uptimeMillis() - this.jdField_b_of_type_Long), 0, null);
    }
    this.jdField_c_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    Frame localFrame = a();
    int n = jdField_a_of_type_Int;
    super.onTabChanged(paramString);
    com.tencent.mobileqq.activity.recent.RecentUtil.jdField_b_of_type_Boolean = true;
    int m = jdField_a_of_type_Int;
    if (paramString.equals(Conversation.class.getName())) {
      m = jdField_a_of_type_Int;
    }
    label199:
    label736:
    for (;;)
    {
      if ((n == jdField_b_of_type_Int) && (m != jdField_b_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
      {
        paramString = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
        if (paramString != null) {
          paramString.b(MessageCache.a());
        }
      }
      if (((localFrame instanceof ReadinjoyTabFrame)) || (m == jdField_g_of_type_Int))
      {
        paramString = (ReadinjoyTabFrame)a(ReadinjoyTabFrame.class);
        if (paramString != null)
        {
          if (m == jdField_g_of_type_Int)
          {
            paramString.b(true);
            b(5);
          }
        }
        else
        {
          ReadinjoySPEventReport.c(m);
          paramString = (DragTextView)this.jdField_a_of_type_JavaUtilHashMap.get("消息_num");
          if (m != jdField_a_of_type_Int) {
            break label532;
          }
          paramString.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
          paramString.setDragViewType(2);
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurTabDragListener.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView = ((TabDragAnimationView)this.jdField_a_of_type_AndroidUtilSparseArray.get(jdField_a_of_type_Int));
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurTabDragListener.jdField_a_of_type_AndroidViewView = paramString;
        }
      }
      int i1;
      int i3;
      for (;;)
      {
        paramString = (TabDragAnimationView)this.jdField_a_of_type_AndroidUtilSparseArray.get(m);
        if (paramString != null)
        {
          paramString.b(0.0F, 0.0F);
          paramString.setPressChanged(true);
        }
        paramString = (TextView)this.jdField_b_of_type_AndroidUtilSparseArray.get(m);
        if (paramString != null) {
          paramString.setTextColor(getResources().getColor(2131493361));
        }
        n = 0;
        for (;;)
        {
          i1 = i2;
          if (n >= this.jdField_a_of_type_AndroidUtilSparseArray.size()) {
            break label630;
          }
          i3 = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(n);
          if (i3 != m) {
            break;
          }
          n += 1;
        }
        if (paramString.equals(Contacts.class.getName()))
        {
          m = jdField_c_of_type_Int;
          d();
          break;
        }
        if (paramString.equals(Leba.class.getName()))
        {
          m = jdField_d_of_type_Int;
          paramString = b();
          if ((paramString != null) && ((paramString instanceof Leba)))
          {
            boolean bool = c();
            ((Leba)paramString).b(bool);
          }
          break;
        }
        if (paramString.equals(Now.class.getName()))
        {
          m = jdField_f_of_type_Int;
          StoryReportor.a("story_tab", "clk", 0, ((TroopRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(69)).b(), new String[0]);
          break;
        }
        if (!paramString.equals(ReadinjoyTabFrame.class.getName())) {
          break label736;
        }
        m = jdField_g_of_type_Int;
        break;
        paramString.b(false);
        b(4);
        break label199;
        b(4);
        break label199;
        paramString.setOnModeChangeListener(null);
      }
      paramString = (TabDragAnimationView)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(n);
      if (i3 - m > 0)
      {
        i1 = 1;
        if (i3 != jdField_c_of_type_Int) {
          break label625;
        }
      }
      label625:
      for (float f1 = 0.75F;; f1 = 1.0F)
      {
        if (i3 == jdField_g_of_type_Int) {
          f1 = 0.0F;
        }
        paramString.setPressChanged(false);
        paramString.b(ViewUtils.b(f1) * i1, 0.0F);
        paramString.a(i1 * ViewUtils.b(f1), 0.0F);
        break;
        i1 = -1;
        break label563;
      }
      label630:
      if (i1 < this.jdField_b_of_type_AndroidUtilSparseArray.size())
      {
        if (this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i1) == m) {}
        for (;;)
        {
          i1 += 1;
          break;
          ((TextView)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(i1)).setTextColor(getResources().getColor(2131493360));
        }
      }
      if (this.jdField_a_of_type_MqqOsMqqHandler == null) {
        this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler();
      }
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new syj(this, m), 100L);
      b();
      return;
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "onViewCreated");
    }
    super.onViewCreated(paramView, paramBundle);
    if (this.jdField_a_of_type_ArrayOfAndroidViewView == null)
    {
      a(this.jdField_a_of_type_AndroidViewView);
      d(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setOnDrawCompleteListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MainFragment
 * JD-Core Version:    0.7.0.1
 */