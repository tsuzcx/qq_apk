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
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
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
import com.tencent.mobileqq.ar.config.WorldCup;
import com.tencent.mobileqq.campuscircle.CampusNoticeManager;
import com.tencent.mobileqq.config.AboutConfig;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.leba.LebaGridManager;
import com.tencent.mobileqq.leba.LebaWithFeeds;
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
import taz;
import tba;
import tbb;
import tbc;
import tbd;
import tbe;
import tbf;
import tbg;
import tbh;
import tbi;
import tbj;
import tbk;
import tbl;
import tbm;
import tbn;
import tbo;
import tbp;
import tbq;
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
  private GetRedPointExObserver jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver = new tbf(this);
  private QQTabWidget.onTabWidgetTouchMoveListener jdField_a_of_type_ComTencentMobileqqWidgetQQTabWidget$onTabWidgetTouchMoveListener = new tbe(this);
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
  private boolean m;
  
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
    int n;
    if (((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue())) {
      n = 2;
    }
    for (;;)
    {
      return n;
      localObject = this.jdField_b_of_type_JavaUtilHashMap.get(paramString + "_num");
      if (((localObject instanceof Integer)) && (((Integer)localObject).intValue() > 0))
      {
        n = 3;
      }
      else
      {
        paramString = this.jdField_b_of_type_JavaUtilHashMap.get(paramString + "_icon");
        if (((paramString instanceof Boolean)) && (((Boolean)paramString).booleanValue())) {
          n = 1;
        } else {
          n = 0;
        }
      }
    }
  }
  
  private static View a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if (BaseApplicationImpl.sApplication == null) {
      return null;
    }
    View localView = View.inflate(BaseApplicationImpl.sApplication, 2130971630, null);
    ((DragTextView)localView.findViewById(2131364939)).setDragViewType(2);
    ((TabDragAnimationView)localView.findViewById(2131364938)).setEmotionDrawable(paramInt1, paramInt2, paramInt3, paramInt4, paramInt6, paramInt7);
    ((TextView)localView.findViewById(2131375217)).setText(paramInt5);
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
      localView = View.inflate(BaseApplicationImpl.sApplication, 2130969063, null);
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
        localObject3 = (ImageView)localView.findViewById(2131364938);
        if (localObject3 == null) {
          localObject1 = "MainFragment--createTabItem|findViewById null";
        }
        localObject2 = localObject1;
        ((ImageView)localObject3).setBackgroundResource(paramInt);
        if (paramDragFrameLayout != null)
        {
          localObject2 = localObject1;
          localObject3 = (DragTextView)localView.findViewById(2131364939);
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
  
  private void a(int paramInt, tbq paramtbq)
  {
    if (paramtbq == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("MainFragment", 2, paramtbq.jdField_a_of_type_JavaLangString + " is execute");
          }
          if (paramInt == 2131362031)
          {
            paramtbq = this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a();
            if ((paramtbq == null) || (paramtbq.a == null))
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
              if (paramtbq.a.iUpgradeType == 0) {
                QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 0, "已是最新版本", 0).b(getResources().getDimensionPixelSize(2131558448));
              } else if ((paramtbq != null) && (paramtbq.a != null)) {
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
      } while (paramtbq.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null);
      AboutConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), paramtbq.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo);
    } while (!"com.tencent.Feedback_5_8".equals(paramtbq.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName));
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
    int n;
    Object localObject;
    if ("消息".equals(paramString1))
    {
      localStringBuilder.append("消息 ");
      n = a(paramString1);
      localObject = (TextView)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1 + "_num");
      if (n != 2) {
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
      paramString1 = (TextView)paramString2.findViewById(2131375217);
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
      if (n == 3)
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
      else if (n == 1) {
        localStringBuilder.append("有新消息");
      } else if ("联系人".equals(paramString1)) {
        localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
      }
    }
  }
  
  private static void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    int n = 0;
    int i1 = 2;
    int i2 = 1;
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
        n = 1;
      }
      jdField_a_of_type_Int = n;
      n = i2;
      if (1 >= paramInt) {
        n = 2;
      }
      jdField_c_of_type_Int = n;
      n = i1;
      if (2 >= paramInt) {
        n = 3;
      }
      jdField_d_of_type_Int = n;
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
    arrayOfView[0] = paramLayoutInflater.inflate(2130969062, null);
    arrayOfView[1] = ((DragFrameLayout)arrayOfView[0].findViewById(2131364934));
    arrayOfView[2] = a(2130846129, 2130846038, 2130846130, 2130846039, 2131433270, 11, 2);
    View localView = a(2130846127, 2130846036, 2130846128, 2130846037, 2131433271, 12, 3);
    localView.setOnClickListener(new tbo(null));
    arrayOfView[3] = new RedTouchTab(paramLayoutInflater.getContext(), localView).a(49).d(3).a(true).b(5).a();
    localView = a(-1, 2130846042, 2130846131, 2130846043, 2131433272, 14, 4);
    localView.setOnClickListener(new tbo(null));
    arrayOfView[4] = new RedTouchTab(paramLayoutInflater.getContext(), localView).a(49).d(3).a(true).b(5).a();
    localView = a(-1, 2130846042, 2130846131, 2130846043, 2131433272, 14, 4);
    localView.setOnClickListener(new tbo(null));
    arrayOfView[5] = new RedTouchTab(paramLayoutInflater.getContext(), localView).a(49).d(3).a(true).b(5).a();
    return arrayOfView;
  }
  
  private View[] a(View paramView)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(8);
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap(12);
    Object localObject = ((SplashActivity)getActivity()).jdField_a_of_type_ArrayOfAndroidViewView;
    ((SplashActivity)getActivity()).jdField_a_of_type_ArrayOfAndroidViewView = null;
    int n;
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = ((DragFrameLayout)localObject[1]);
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[] { localObject[2], null, localObject[3], localObject[4], null, localObject[5], null };
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.setOnDragListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurTabDragListener);
      this.jdField_a_of_type_JavaUtilHashMap.put("消息", this.jdField_a_of_type_ArrayOfAndroidViewView[0]);
      this.jdField_a_of_type_JavaUtilHashMap.put("联系人", this.jdField_a_of_type_ArrayOfAndroidViewView[2]);
      this.jdField_a_of_type_JavaUtilHashMap.put("动态", this.jdField_a_of_type_ArrayOfAndroidViewView[3]);
      this.jdField_a_of_type_JavaUtilHashMap.put("消息_num", this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131364939));
      this.jdField_a_of_type_JavaUtilHashMap.put("联系人_num", this.jdField_a_of_type_ArrayOfAndroidViewView[2].findViewById(2131364939));
      this.jdField_a_of_type_JavaUtilHashMap.put("动态_num", this.jdField_a_of_type_ArrayOfAndroidViewView[3].findViewById(2131364939));
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if ((localObject == null) || (!((NowLiveManager)localObject).jdField_a_of_type_Boolean)) {
        break label797;
      }
      n = 1;
      label257:
      if ((n != 0) && (this.jdField_a_of_type_ArrayOfAndroidViewView[4] != null))
      {
        this.jdField_a_of_type_JavaUtilHashMap.put("NOW", this.jdField_a_of_type_ArrayOfAndroidViewView[4]);
        this.jdField_a_of_type_JavaUtilHashMap.put("NOW_num", this.jdField_a_of_type_ArrayOfAndroidViewView[4].findViewById(2131364939));
      }
      localObject = ReadInJoyUtils.a(2130840922, 2130846044, 2130840923, 2130846045, 2131439066, 16, 8);
      if (localObject != null)
      {
        ((View)localObject).setOnClickListener(new tbd(this));
        this.jdField_a_of_type_ArrayOfAndroidViewView[6] = new RedTouch(getActivity(), (View)localObject).a(49).d(3).b(5).a();
        this.jdField_a_of_type_JavaUtilHashMap.put("看点", this.jdField_a_of_type_ArrayOfAndroidViewView[6]);
        this.jdField_a_of_type_JavaUtilHashMap.put("看点_num", this.jdField_a_of_type_ArrayOfAndroidViewView[6].findViewById(2131364939));
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
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = ((DragFrameLayout)paramView.findViewById(2131364934));
      localObject = a(2130846127, 2130846036, 2130846128, 2130846037, 2131433271, 12, 3);
      ((View)localObject).setOnClickListener(new tbo(null));
      View localView1 = a(-1, 2130846042, 2130846131, 2130846043, 2131433272, 14, 4);
      localView1.setOnClickListener(new tbo(null));
      View localView2 = a(-1, 2130846042, 2130846131, 2130846043, 2131433272, 14, 4);
      localView2.setOnClickListener(new tbo(null));
      View localView3 = a(2130843462, 2130846040, 2130843463, 2130846041, 2131432090, 15, 5);
      localView3.setOnClickListener(new tbo(null));
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[] { a(2130846129, 2130846038, 2130846130, 2130846039, 2131433270, 11, 2), null, new RedTouchTab(getActivity(), (View)localObject).a(49).d(3).a(true).b(5).a(), new RedTouchTab(getActivity(), localView1).a(49).d(3).a(true).b(5).a(), new RedTouchTab(getActivity(), localView3).a(49).d(3).a(true).b(5).a(), new RedTouchTab(getActivity(), localView2).a(49).d(3).a(true).b(5).a(), null };
      break;
      label797:
      n = 0;
      break label257;
      label802:
      QLog.i("MainFragment", 1, "initTabs tabWidget is null");
    }
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
  
  private void c(int paramInt)
  {
    QLog.d("MainFragment", 2, "update kandian tab, type : " + paramInt);
    if (!(this.jdField_a_of_type_AndroidUtilSparseArray.get(jdField_g_of_type_Int) instanceof ReadInjoyTabDragAnimationView)) {}
    ReadInjoyTabDragAnimationView localReadInjoyTabDragAnimationView;
    do
    {
      return;
      localReadInjoyTabDragAnimationView = (ReadInjoyTabDragAnimationView)this.jdField_a_of_type_AndroidUtilSparseArray.get(jdField_g_of_type_Int);
      if (localReadInjoyTabDragAnimationView == null)
      {
        QLog.d("MainFragment", 2, "iconView is null, give up !");
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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    Object localObject2 = (LebaGridManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(211);
    int n;
    int i1;
    label49:
    int i2;
    label62:
    boolean bool;
    if ((localObject1 != null) && (((NowLiveManager)localObject1).jdField_a_of_type_Boolean))
    {
      n = 1;
      if (localObject1 != null) {
        break label307;
      }
      i1 = this.jdField_i_of_type_Int;
      if (this.l == ReadInJoyHelper.f()) {
        break label316;
      }
      i2 = 1;
      if (this.m == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.q) {
        break label322;
      }
      bool = true;
      label79:
      if ((!paramBoolean) && ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.n) || (this.jdField_a_of_type_ArrayOfAndroidViewView[1] != null)) && ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.n) || (this.jdField_a_of_type_ArrayOfAndroidViewView[1] == null)) && (this.jdField_i_of_type_Int == i1) && ((n == 0) || (this.jdField_a_of_type_ArrayOfAndroidViewView[4] != null)) && ((n != 0) || (this.jdField_a_of_type_ArrayOfAndroidViewView[4] == null)) && (i2 == 0) && (!bool)) {
        break label874;
      }
      if (localObject1 != null)
      {
        if (n == 0) {
          break label328;
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
      this.jdField_i_of_type_Int = i1;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.clearAllTabs();
      }
      i2 = this.jdField_a_of_type_ArrayOfAndroidViewView.length;
      i1 = 0;
      while (i1 < i2)
      {
        localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView[i1];
        if (localObject1 != null)
        {
          ((View)localObject1).setSelected(false);
          ((View)localObject1).setId(i1 + 16);
        }
        i1 += 1;
      }
      n = 0;
      break;
      label307:
      i1 = ((NowLiveManager)localObject1).jdField_b_of_type_Int;
      break label49;
      label316:
      i2 = 0;
      break label62;
      label322:
      bool = false;
      break label79;
      label328:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    }
    if (n != 0)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.n, this.jdField_i_of_type_Int, false);
      s();
      localObject1 = a(Conversation.class);
      if (localObject1 != null) {
        ((Conversation)localObject1).f(true);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.n) {
        break label891;
      }
      this.jdField_a_of_type_ArrayOfAndroidViewView[1] = a(2130846124, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("电话", this.jdField_a_of_type_ArrayOfAndroidViewView[1]);
      this.jdField_a_of_type_JavaUtilHashMap.put("电话_num", this.jdField_a_of_type_ArrayOfAndroidViewView[1].findViewById(2131364939));
      this.jdField_a_of_type_ArrayOfAndroidViewView[4] = null;
      this.jdField_a_of_type_JavaUtilHashMap.remove("NOW");
      this.jdField_a_of_type_JavaUtilHashMap.remove("NOW_num");
      a(Now.class);
      label487:
      n = this.jdField_i_of_type_Int;
      if ((n == 0) && (this.jdField_a_of_type_ArrayOfAndroidViewView[4] != null)) {
        a(this.jdField_a_of_type_AndroidViewView, Now.class, this.jdField_a_of_type_ArrayOfAndroidViewView[4]);
      }
      a(this.jdField_a_of_type_AndroidViewView, Conversation.class, this.jdField_a_of_type_ArrayOfAndroidViewView[0]);
      if ((n == 1) && (this.jdField_a_of_type_ArrayOfAndroidViewView[4] != null)) {
        a(this.jdField_a_of_type_AndroidViewView, Now.class, this.jdField_a_of_type_ArrayOfAndroidViewView[4]);
      }
      a(this.jdField_a_of_type_AndroidViewView, Contacts.class, this.jdField_a_of_type_ArrayOfAndroidViewView[2]);
      if (!ReadInJoyHelper.f()) {
        break label1222;
      }
      t();
      a(this.jdField_a_of_type_AndroidViewView, ReadinjoyTabFrame.class, this.jdField_a_of_type_ArrayOfAndroidViewView[6]);
      this.l = true;
      label620:
      if ((n == 2) && (this.jdField_a_of_type_ArrayOfAndroidViewView[4] != null)) {
        a(this.jdField_a_of_type_AndroidViewView, Now.class, this.jdField_a_of_type_ArrayOfAndroidViewView[4]);
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("动态", this.jdField_a_of_type_ArrayOfAndroidViewView[3]);
      this.jdField_a_of_type_JavaUtilHashMap.put("动态_num", this.jdField_a_of_type_ArrayOfAndroidViewView[3].findViewById(2131364939));
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebanew", 2, "previous LebaTab is:" + this.m + ", now LebaTab:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.q + ", isChangeNewLeba: " + bool);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.q) {
        break label1237;
      }
      a(this.jdField_a_of_type_AndroidViewView, LebaWithFeeds.class, this.jdField_a_of_type_ArrayOfAndroidViewView[3]);
      this.m = true;
      label785:
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("addFrame: ");
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.q) {
          break label1262;
        }
      }
    }
    label874:
    label1262:
    for (localObject1 = "LebaWithFeeds";; localObject1 = "Leba")
    {
      QLog.d("Q.lebanew", 2, (String)localObject1);
      if ((n == 3) && (this.jdField_a_of_type_ArrayOfAndroidViewView[4] != null)) {
        a(this.jdField_a_of_type_AndroidViewView, Now.class, this.jdField_a_of_type_ArrayOfAndroidViewView[4]);
      }
      e(false);
      return;
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.n, -100, false);
      break;
      label891:
      if ((n != 0) && (this.jdField_i_of_type_Int < 4) && (this.jdField_i_of_type_Int >= 0) && (QQStoryManager.j()))
      {
        localObject1 = a(2130843462, 2130846040, 2130843463, 2130846041, 2131432090, 15, 5);
        ((View)localObject1).setOnClickListener(new tbo(null));
        this.jdField_a_of_type_ArrayOfAndroidViewView[4] = new RedTouchTab(getActivity(), (View)localObject1).a(49).d(3).a(true).b(5).a();
        this.jdField_a_of_type_JavaUtilHashMap.put("NOW", this.jdField_a_of_type_ArrayOfAndroidViewView[4]);
        this.jdField_a_of_type_JavaUtilHashMap.put("NOW_num", this.jdField_a_of_type_ArrayOfAndroidViewView[4].findViewById(2131364939));
        this.jdField_a_of_type_JavaUtilHashMap.put("NOW_img", this.jdField_a_of_type_ArrayOfAndroidViewView[4].findViewById(2131364940));
        this.jdField_a_of_type_ArrayOfAndroidViewView[1] = null;
        this.jdField_a_of_type_JavaUtilHashMap.remove("电话");
        this.jdField_a_of_type_JavaUtilHashMap.remove("电话_num");
        localObject1 = (TabDragAnimationView)this.jdField_a_of_type_ArrayOfAndroidViewView[4].findViewById(2131364938);
        ((TabDragAnimationView)localObject1).setOnTouchListener(new tbp(null));
        this.jdField_a_of_type_AndroidUtilSparseArray.put(jdField_f_of_type_Int, localObject1);
        this.jdField_b_of_type_AndroidUtilSparseArray.put(jdField_f_of_type_Int, (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[4].findViewById(2131375217));
        u();
        break label487;
      }
      this.jdField_a_of_type_ArrayOfAndroidViewView[1] = null;
      this.jdField_a_of_type_JavaUtilHashMap.remove("电话");
      this.jdField_a_of_type_JavaUtilHashMap.remove("电话_num");
      this.jdField_a_of_type_ArrayOfAndroidViewView[4] = null;
      this.jdField_a_of_type_JavaUtilHashMap.remove("NOW");
      this.jdField_a_of_type_JavaUtilHashMap.remove("NOW_num");
      a(Now.class);
      break label487;
      a(ReadinjoyTabFrame.class);
      this.l = false;
      break label620;
      a(this.jdField_a_of_type_AndroidViewView, Leba.class, this.jdField_a_of_type_ArrayOfAndroidViewView[3]);
      this.m = false;
      break label785;
    }
  }
  
  private void e(boolean paramBoolean)
  {
    Object localObject1 = ThemeUtil.getCurrentThemeId();
    boolean bool;
    float f1;
    int n;
    label63:
    int i3;
    int i1;
    if (("1000".equals(localObject1)) || ("999".equals(localObject1)))
    {
      bool = true;
      this.jdField_i_of_type_Boolean = bool;
      f1 = getResources().getDisplayMetrics().density;
      if (!this.jdField_i_of_type_Boolean) {
        break label253;
      }
      n = Math.round(54.0F * f1);
      i3 = Math.round(6.0F * f1);
      if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
        break label277;
      }
      bool = ThemeUtil.isNowThemeIsAnimate();
      i1 = 0;
      label88:
      if (i1 >= this.jdField_a_of_type_AndroidUtilSparseArray.size()) {
        break label277;
      }
      localObject1 = (TabDragAnimationView)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i1);
      ((TabDragAnimationView)localObject1).jdField_c_of_type_Boolean = bool;
      ((TabDragAnimationView)localObject1).a = null;
      if (!this.jdField_i_of_type_Boolean) {
        break label259;
      }
      i2 = (int)(29.0F * f1 + 0.5F);
      label146:
      ((TabDragAnimationView)localObject1).setIconSize(i2, i2);
      ((TabDragAnimationView)localObject1).setAnimEnable(this.jdField_i_of_type_Boolean);
      if (!this.jdField_i_of_type_Boolean) {
        break label265;
      }
      i2 = 1;
      label174:
      ((TabDragAnimationView)localObject1).setIconGravity(i2);
      if (!this.jdField_i_of_type_Boolean) {
        break label271;
      }
    }
    Object localObject2;
    label259:
    label265:
    label271:
    for (int i2 = (int)(5.0F * f1 + 0.5F);; i2 = 0)
    {
      ((TabDragAnimationView)localObject1).setPadding(0, i2, 0, i2);
      localObject2 = new RelativeLayout.LayoutParams(((TabDragAnimationView)localObject1).getLayoutParams());
      ((RelativeLayout.LayoutParams)localObject2).height = n;
      ((TabDragAnimationView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      i1 += 1;
      break label88;
      bool = false;
      break;
      label253:
      n = -2;
      break label63;
      i2 = -1;
      break label146;
      i2 = 0;
      break label174;
    }
    label277:
    if (this.jdField_b_of_type_AndroidUtilSparseArray != null)
    {
      i1 = 0;
      if (i1 < this.jdField_b_of_type_AndroidUtilSparseArray.size())
      {
        localObject1 = (TextView)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(i1);
        if (this.jdField_i_of_type_Boolean)
        {
          ((TextView)localObject1).setVisibility(0);
          localObject2 = (RelativeLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).bottomMargin = i3;
          ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        for (;;)
        {
          i1 += 1;
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
        ((ViewGroup.LayoutParams)localObject2).height = n;
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      if ((!paramBoolean) && (this.jdField_i_of_type_Boolean))
      {
        long l1 = System.currentTimeMillis();
        localObject2 = this.jdField_a_of_type_AndroidViewView.findViewById(16908305);
        if ((localObject1 != null) && (localObject2 != null))
        {
          i1 = ((View)localObject2).getPaddingBottom();
          if ((n > 0) && (i1 != n)) {
            ((View)localObject2).setPadding(0, 0, 0, n);
          }
          if (QLog.isColorLevel()) {
            QLog.d("MainFragment", 2, "checkEnableTabAnim, height=" + n + ", padding=" + i1 + ", cost=" + (System.currentTimeMillis() - l1));
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
    Object localObject = new tbq();
    ((tbq)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131435377);
    localArrayList.add(new Pair(Integer.valueOf(2131362031), localObject));
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("com.tencent.Feedback_5_8");
    if ((localObject != null) && (((ResourcePluginInfo)localObject).cLocalState != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "feedback plugin is add overmenu");
      }
      tbq localtbq = new tbq();
      localtbq.jdField_a_of_type_JavaLangString = ((ResourcePluginInfo)localObject).strResName;
      localtbq.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo = ((ResourcePluginInfo)localObject);
      localArrayList.add(new Pair(Integer.valueOf(2131362032), localtbq));
    }
    localObject = new tbq();
    ((tbq)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131433520);
    localArrayList.add(new Pair(Integer.valueOf(2131362033), localObject));
    localObject = new tbq();
    ((tbq)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131433699);
    localArrayList.add(new Pair(Integer.valueOf(2131362034), localObject));
    localObject = ActionSheet.c(getActivity());
    int n = 0;
    if (n < localArrayList.size())
    {
      if (2131362034 == ((Integer)((Pair)localArrayList.get(n)).first).intValue()) {
        ((ActionSheet)localObject).d(((tbq)((Pair)localArrayList.get(n)).second).jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        n += 1;
        break;
        ((ActionSheet)localObject).c(((tbq)((Pair)localArrayList.get(n)).second).jdField_a_of_type_JavaLangString);
      }
    }
    ((ActionSheet)localObject).a(new tbm(this, localArrayList, (ActionSheet)localObject));
    ((ActionSheet)localObject).setOnDismissListener(new tbn(this));
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
    tbp localtbp = new tbp(null);
    TabDragAnimationView localTabDragAnimationView = (TabDragAnimationView)this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131364938);
    localTabDragAnimationView.setOnTouchListener(localtbp);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(jdField_a_of_type_Int, localTabDragAnimationView);
    localTabDragAnimationView = (TabDragAnimationView)this.jdField_a_of_type_ArrayOfAndroidViewView[2].findViewById(2131364938);
    localTabDragAnimationView.setOnTouchListener(localtbp);
    localTabDragAnimationView.setExpectedLogoMoveDistance(ViewUtils.b(2.0F));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(jdField_c_of_type_Int, localTabDragAnimationView);
    localTabDragAnimationView = (TabDragAnimationView)this.jdField_a_of_type_ArrayOfAndroidViewView[3].findViewById(2131364938);
    localTabDragAnimationView.setOnTouchListener(localtbp);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(jdField_d_of_type_Int, localTabDragAnimationView);
    if ((ReadInJoyHelper.f()) && (this.jdField_a_of_type_ArrayOfAndroidViewView[6] != null))
    {
      localTabDragAnimationView = (TabDragAnimationView)this.jdField_a_of_type_ArrayOfAndroidViewView[6].findViewById(2131364938);
      localTabDragAnimationView.setOnTouchListener(localtbp);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(jdField_g_of_type_Int, localTabDragAnimationView);
    }
    this.jdField_b_of_type_AndroidUtilSparseArray.put(jdField_a_of_type_Int, (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131375217));
    this.jdField_b_of_type_AndroidUtilSparseArray.put(jdField_c_of_type_Int, (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[2].findViewById(2131375217));
    this.jdField_b_of_type_AndroidUtilSparseArray.put(jdField_d_of_type_Int, (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[3].findViewById(2131375217));
    if ((ReadInJoyHelper.f()) && (this.jdField_a_of_type_ArrayOfAndroidViewView[6] != null)) {
      this.jdField_b_of_type_AndroidUtilSparseArray.put(jdField_g_of_type_Int, (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[6].findViewById(2131375217));
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
      ((RedTouch)localObject2).setTag(2131362413, localObject1);
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
    int n = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost != null) {
      n = this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.getCurrentTab();
    }
    while (!QLog.isColorLevel()) {
      return n;
    }
    QLog.e("MainFragment", 2, "getCurrentTab");
    return 0;
  }
  
  public Dialog a(String paramString1, String paramString2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    Dialog localDialog = new Dialog(getActivity(), 2131624516);
    localDialog.setContentView(2130968978);
    TextView localTextView = (TextView)localDialog.findViewById(2131364034);
    if (localTextView != null)
    {
      if (paramString1 == null) {
        localTextView.setVisibility(8);
      }
    }
    else
    {
      paramString1 = (TextView)localDialog.findViewById(2131362776);
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
      paramString1 = (TextView)localDialog.findViewById(2131364037);
      if (paramString1 != null) {
        paramString1.setText(2131433015);
      }
      paramString1 = (TextView)localDialog.findViewById(2131364038);
      if (paramString1 != null) {
        paramString1.setText(2131433016);
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
      return getString(2131432414);
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
      QLog.d("MainFragment", 2, "onDrawComplete[" + c() + "]");
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
    localObject = c();
    WorldCup.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), getView(), (String)localObject);
    if ("消息".equals(localObject)) {
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
    if ((paramInt1 == 12289) && (paramInt2 == -1))
    {
      paramIntent = c();
      WorldCup.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), getView(), paramIntent);
      if ("消息".equals(paramIntent)) {
        ((VasExtensionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(234)).a.a(getView(), getActivity());
      }
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
    int n;
    if ((paramObject instanceof Integer)) {
      n = ((Integer)paramObject).intValue();
    }
    for (;;)
    {
      label157:
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
      label242:
      int i2;
      int i3;
      label327:
      int i1;
      label370:
      int i5;
      int i4;
      if (str1.equals((String)localObject + "_num"))
      {
        localSharedPreferences.edit().putInt(str1 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), n).commit();
        this.jdField_b_of_type_JavaUtilHashMap.put(str1, paramObject);
        n = 0;
        i2 = a((String)localObject);
        if (i2 != 3) {
          break label916;
        }
        localObject = this.jdField_b_of_type_JavaUtilHashMap.get((String)localObject + "_num");
        i3 = n;
        paramObject = str2;
        if ((localObject instanceof Integer))
        {
          i3 = ((Integer)localObject).intValue();
          paramObject = str2;
        }
        i1 = 0;
        if (paramInt1 != 32) {
          break label1139;
        }
        if (i3 <= 99) {
          break label998;
        }
        i2 = getResources().getDimensionPixelSize(2131558936);
        if (!this.jdField_i_of_type_Boolean) {
          break label987;
        }
        n = ViewUtils.b(7.0F);
        i5 = 4;
        i1 = 2130846058;
        i4 = n;
        n = i5;
        i5 = i2;
        localObject = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
        if (localObject != null)
        {
          ((RelativeLayout.LayoutParams)localObject).setMargins(i4, i5, 0, 0);
          localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      for (;;)
      {
        if (paramInt1 == 36)
        {
          i2 = getResources().getDimensionPixelSize(2131558934);
          i5 = getResources().getDimensionPixelSize(2131558932);
          if (i3 > 99)
          {
            i2 = getResources().getDimensionPixelSize(2131558936);
            i1 = 4;
            n = 2130846058;
            label480:
            localObject = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
            if (localObject != null)
            {
              ((RelativeLayout.LayoutParams)localObject).setMargins(i5, i2, 0, 0);
              localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
            }
            b();
            i2 = n;
            n = i1;
          }
        }
        for (;;)
        {
          if (QLog.isDevelopLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("updateMain, [").append("tabIndex = ").append(paramInt1).append(",").append("type = ").append(paramInt2).append(",").append("style = ").append(n).append(",").append("num = ").append(i3).append(",").append("isVisable = ").append(bool).append(",").append("tv = ").append(localTextView.toString()).append(" ]");
            QLog.d("MainFragment", 4, ((StringBuilder)localObject).toString());
          }
          CustomWidgetUtil.a(localTextView, n, i3, i2, 99, paramObject);
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
          c(paramInt2);
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
          n = 0;
          break label157;
          localSharedPreferences.edit().putBoolean(str1 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), bool).commit();
          break label242;
          label916:
          i3 = n;
          paramObject = str2;
          if (i2 != 5) {
            break label327;
          }
          localObject = this.jdField_b_of_type_JavaUtilHashMap.get((String)localObject + "_text");
          i3 = n;
          paramObject = str2;
          if (!(localObject instanceof String)) {
            break label327;
          }
          paramObject = (String)localObject;
          i3 = n;
          break label327;
          label987:
          n = ViewUtils.b(5.0F);
          break label370;
          label998:
          i5 = getResources().getDimensionPixelSize(2131558934);
          if (this.jdField_i_of_type_Boolean) {}
          for (n = ViewUtils.b(7.0F);; n = ViewUtils.b(5.0F))
          {
            i1 = 0;
            i4 = n;
            n = i2;
            break;
          }
          if (i3 > 0)
          {
            i1 = n;
            n = 0;
            break label480;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MainFragment", 2, "updateMain mIsPstnRedTouchShow  = " + this.j);
          }
          if (this.j)
          {
            i1 = 1;
            n = 0;
            break label480;
          }
          i4 = n;
          n = i1;
          i1 = i4;
          break label480;
          i2 = i1;
        }
        label1139:
        n = i2;
      }
      label1146:
      n = 0;
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
    int n;
    if (((Bundle)localObject1).containsKey("tab_index")) {
      n = ((Bundle)localObject1).getInt("tab_index");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "onNewIntent tabIndex: " + n);
      }
      Object localObject2;
      label396:
      label404:
      Object localObject3;
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost != null) && (n >= 0))
      {
        if (n == jdField_a_of_type_Int)
        {
          int i1 = ((Bundle)localObject1).getInt("conversation_index", -1);
          bool = ((Bundle)localObject1).getBoolean("isOpenSelectMember", false);
          if ((1 == i1) && ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.n))) {}
        }
        else
        {
          if ((n != jdField_a_of_type_Int) || (n != a())) {
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
          n = a((Bundle)localObject1);
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
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setCurrentTab(n);
            return;
          }
          catch (Exception paramIntent)
          {
            return;
          }
        }
        if ((n == jdField_b_of_type_Int) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.n))
        {
          n = jdField_a_of_type_Int;
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
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setCurrentTab(n);
            return;
          }
          catch (Exception paramIntent)
          {
            return;
          }
        }
        if ((n >= 0) && (n < this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.getTabWidget().getChildCount()))
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
            if (("smartdevice".equals(localObject2)) && (n == jdField_c_of_type_Int))
            {
              localObject3 = (Contacts)a(Contacts.class);
              if (localObject3 != null) {
                ((Contacts)localObject3).b(true);
              }
            }
            if ((n == jdField_f_of_type_Int) && (n == a()))
            {
              localObject3 = (Now)a(Now.class);
              if (localObject3 != null)
              {
                ((Now)localObject3).jdField_b_of_type_Boolean = ((Bundle)localObject1).getBoolean("extra_from_share");
                ((Now)localObject3).jdField_a_of_type_JavaLangString = ((Bundle)localObject1).getString("new_video_extra_info");
              }
            }
            if ((n == jdField_d_of_type_Int) && ("campus_notice".equals(localObject2)))
            {
              if (QLog.isColorLevel()) {
                QLog.d("CampusNoticeManager", 2, String.format(Locale.getDefault(), "back from campus_notice %d", new Object[] { Integer.valueOf(DrawerFrame.jdField_a_of_type_Int) }));
              }
              if (DrawerFrame.jdField_a_of_type_Int == 0) {
                DrawerFrame.jdField_a_of_type_Int = 3;
              }
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setCurrentTab(n);
          }
        }
      }
      for (;;)
      {
        try
        {
          n = paramIntent.getIntExtra("forward", -1);
          if (n != 2) {
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
        if ((n >= 0) && (n == jdField_f_of_type_Int) && (n != a()))
        {
          this.jdField_a_of_type_AndroidContentIntent = paramIntent;
          continue;
          if (QLog.isColorLevel())
          {
            QLog.d("MainFragment", 2, "MainActivity:onNewIntent mTabHost is null");
            continue;
            label851:
            if (n == 3)
            {
              localObject1 = paramIntent.getStringExtra("url");
              localObject2 = new Intent(getActivity(), QQBrowserActivity.class);
              if (paramIntent.hasExtra("uintype"))
              {
                n = paramIntent.getIntExtra("uintype", -1);
                ((Intent)localObject2).putExtra("uintype", n);
                if ((n == 1030) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(239)))
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
      n = -1;
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
    ThreadManager.post(new tbh(this), 2, null, true);
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
      QQToast.a(getActivity(), 2, getString(2131436426), 1).a();
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
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        }
        ThreadManager.getUIHandler().postDelayed(new tbi(this), 3000L);
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
    ThreadManager.getSubThreadHandler().postDelayed(new tbj(this), 500L);
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
    Dialog localDialog = a("你确定退出QQ？", null, new tba(this));
    Object localObject = (TextView)localDialog.findViewById(2131364038);
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new tbb(this, localDialog));
    }
    localObject = (TextView)localDialog.findViewById(2131364037);
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new tbc(this));
    }
    localObject = getString(2131435403);
    boolean bool = SettingCloneUtil.isContainValue(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (String)localObject, "qqsetting_receivemsg_whenexit_key");
    this.jdField_d_of_type_Boolean = SettingCloneUtil.readValue(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (String)localObject, "qqsetting_receivemsg_whenexit_key", true);
    localObject = (CheckBox)localDialog.findViewById(2131363685);
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
    localFrame = a(LebaWithFeeds.class);
    if (localFrame != null) {
      ((LebaWithFeeds)localFrame).n();
    }
    localFrame = a(Now.class);
    if (localFrame != null) {
      ((Now)localFrame).b();
    }
    localFrame = a(ReadinjoyTabFrame.class);
    if (localFrame != null) {
      ((ReadinjoyTabFrame)localFrame).D_();
    }
    e(true);
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
      paramViewGroup = getActivity().findViewById(2131364879);
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
        paramLayoutInflater = new taz(this);
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
    WorldCup.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), getView());
  }
  
  public void onResume()
  {
    super.onResume();
    if (SplashActivity.jdField_a_of_type_Int != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "onResume return");
      }
      return;
    }
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
    ThreadManager.getSubThreadHandler().postDelayed(new tbg(this), 1000L);
    this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.h();
    StartupTracker.a("Main_OnResume", null);
    Object localObject = (TroopRedTouchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(43);
    if ((localObject != null) && (((TroopRedTouchHandler)localObject).a()) && (QLog.isColorLevel())) {
      QLog.d("Q.qqstory.redPoint", 2, "MainFragment onResume, getRedPointInfo");
    }
    ReadinjoySPEventReport.j();
  }
  
  public void onStart()
  {
    super.onStart();
    if (SplashActivity.jdField_a_of_type_Int != 1) {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "onStart return");
      }
    }
    do
    {
      return;
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
          localObject = (BusinessInfoCheckUpdate.RedTypeInfo)((RedTouch)localObject).getTag(2131362413);
          ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BusinessInfoCheckUpdate.RedTypeInfo)localObject);
        }
        ThreadManager.executeOnSubThread(new tbl(this));
      }
      ((AppGuideTipsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).e();
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a(getActivity().getIntent());
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
    int i3 = 0;
    if ((this.jdField_b_of_type_Long != 0L) && (this.jdField_c_of_type_JavaLangString != null) && (UnifiedMonitor.a().whetherReportThisTime(8))) {
      UnifiedMonitor.a().addEvent(8, this.jdField_c_of_type_JavaLangString, (int)(SystemClock.uptimeMillis() - this.jdField_b_of_type_Long), 0, null);
    }
    this.jdField_c_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    Frame localFrame1 = a();
    int i1 = jdField_a_of_type_Int;
    super.onTabChanged(paramString);
    com.tencent.mobileqq.activity.recent.RecentUtil.jdField_b_of_type_Boolean = true;
    int n = jdField_a_of_type_Int;
    if (paramString.equals(Conversation.class.getName())) {
      n = jdField_a_of_type_Int;
    }
    label657:
    label830:
    for (;;)
    {
      if ((this.jdField_b_of_type_AndroidViewView != null) && (!paramString.equals(LebaWithFeeds.class.getName()))) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      if ((i1 == jdField_b_of_type_Int) && (n != jdField_b_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
      {
        paramString = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
        if (paramString != null) {
          paramString.b(MessageCache.a());
        }
      }
      if (((localFrame1 instanceof ReadinjoyTabFrame)) || (n == jdField_g_of_type_Int))
      {
        paramString = (ReadinjoyTabFrame)a(ReadinjoyTabFrame.class);
        if (paramString != null)
        {
          if (n == jdField_g_of_type_Int)
          {
            ReadinjoyReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            paramString.b(true);
            c(5);
          }
        }
        else
        {
          label234:
          ReadinjoySPEventReport.c(n);
          paramString = (DragTextView)this.jdField_a_of_type_JavaUtilHashMap.get("消息_num");
          if (n != jdField_a_of_type_Int) {
            break label626;
          }
          paramString.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
          paramString.setDragViewType(2);
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurTabDragListener.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView = ((TabDragAnimationView)this.jdField_a_of_type_AndroidUtilSparseArray.get(jdField_a_of_type_Int));
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurTabDragListener.jdField_a_of_type_AndroidViewView = paramString;
        }
      }
      int i2;
      int i4;
      for (;;)
      {
        paramString = (TabDragAnimationView)this.jdField_a_of_type_AndroidUtilSparseArray.get(n);
        if (paramString != null)
        {
          paramString.b(0.0F, 0.0F);
          paramString.setPressChanged(true);
        }
        paramString = (TextView)this.jdField_b_of_type_AndroidUtilSparseArray.get(n);
        if (paramString != null) {
          paramString.setTextColor(getResources().getColor(2131493364));
        }
        i1 = 0;
        for (;;)
        {
          i2 = i3;
          if (i1 >= this.jdField_a_of_type_AndroidUtilSparseArray.size()) {
            break label724;
          }
          i4 = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i1);
          if (i4 != n) {
            break;
          }
          i1 += 1;
        }
        if (paramString.equals(Contacts.class.getName()))
        {
          n = jdField_c_of_type_Int;
          d();
          break;
        }
        boolean bool;
        if (paramString.equals(Leba.class.getName()))
        {
          n = jdField_d_of_type_Int;
          localFrame2 = b();
          if ((localFrame2 != null) && ((localFrame2 instanceof Leba)))
          {
            bool = c();
            ((Leba)localFrame2).b(bool);
          }
          break;
        }
        if (paramString.equals(Now.class.getName()))
        {
          n = jdField_f_of_type_Int;
          StoryReportor.a("story_tab", "clk", 0, ((TroopRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(69)).b(), new String[0]);
          break;
        }
        if (paramString.equals(ReadinjoyTabFrame.class.getName()))
        {
          n = jdField_g_of_type_Int;
          break;
        }
        if (!paramString.equals(LebaWithFeeds.class.getName())) {
          break label830;
        }
        n = jdField_d_of_type_Int;
        Frame localFrame2 = b();
        if ((localFrame2 != null) && ((localFrame2 instanceof LebaWithFeeds)))
        {
          bool = c();
          ((LebaWithFeeds)localFrame2).b(bool);
        }
        break;
        paramString.b(false);
        c(4);
        break label234;
        c(4);
        break label234;
        label626:
        paramString.setOnModeChangeListener(null);
      }
      paramString = (TabDragAnimationView)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i1);
      if (i4 - n > 0)
      {
        i2 = 1;
        if (i4 != jdField_c_of_type_Int) {
          break label719;
        }
      }
      label719:
      for (float f1 = 0.75F;; f1 = 1.0F)
      {
        if (i4 == jdField_g_of_type_Int) {
          f1 = 0.0F;
        }
        paramString.setPressChanged(false);
        paramString.b(ViewUtils.b(f1) * i2, 0.0F);
        paramString.a(i2 * ViewUtils.b(f1), 0.0F);
        break;
        i2 = -1;
        break label657;
      }
      label724:
      if (i2 < this.jdField_b_of_type_AndroidUtilSparseArray.size())
      {
        if (this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i2) == n) {}
        for (;;)
        {
          i2 += 1;
          break;
          ((TextView)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(i2)).setTextColor(getResources().getColor(2131493363));
        }
      }
      if (this.jdField_a_of_type_MqqOsMqqHandler == null) {
        this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler();
      }
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new tbk(this, n), 100L);
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