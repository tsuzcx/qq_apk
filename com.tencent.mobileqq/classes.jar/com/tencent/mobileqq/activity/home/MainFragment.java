package com.tencent.mobileqq.activity.home;

import acmx;
import aczy;
import afpn;
import afvu;
import ajze;
import ajzf;
import ajzg;
import ajzh;
import ajzi;
import ajzj;
import ajzk;
import ajzl;
import ajzm;
import ajzn;
import ajzo;
import ajzp;
import ajzq;
import ajzr;
import ajzs;
import ajzy;
import akai;
import akam;
import aldh;
import algs;
import alji;
import amwn;
import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.Vibrator;
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
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TabWidget;
import android.widget.TextView;
import anun;
import anvx;
import aoay;
import aoyj;
import aqnd;
import aqwe;
import auht;
import auqo;
import awth;
import awtm;
import awtz;
import ayzg;
import azit;
import bapk;
import bbbq;
import bcrg;
import bcvr;
import bdfk;
import bdku;
import bdkv;
import bdla;
import bdlm;
import bgvx;
import bgyd;
import bheh;
import bhey;
import bhhr;
import bhhy;
import bhql;
import bibt;
import bibu;
import bisq;
import bjna;
import bkyh;
import bkyy;
import bkzi;
import blas;
import bmhv;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyTabDragAnimationView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.Now;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.activity.contacts.base.Contacts;
import com.tencent.mobileqq.activity.fling.ScreenCapture;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchTab;
import com.tencent.mobileqq.startup.step.SetSplash;
import com.tencent.mobileqq.startup.step.StartService;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.mobileqq.widget.QQTabWidget;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import cooperation.qzone.api.QZoneApiProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import mqq.app.Constants.LogoutReason;
import mqq.os.MqqHandler;
import ntj;
import ntq;
import pip;
import pkh;
import protocol.KQQConfig.UpgradeInfo;
import pti;
import pwb;
import tem;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;
import uvs;
import vzh;
import ykv;
import zzd;

public class MainFragment
  extends FrameHelperActivity
{
  public static int a;
  public static final String a;
  private static final Random jdField_a_of_type_JavaUtilRandom = new Random();
  public static boolean a;
  private static final int[] jdField_a_of_type_ArrayOfInt;
  public static int b;
  public static final String b;
  public static boolean b;
  private static final int[] jdField_b_of_type_ArrayOfInt;
  public static int c;
  private static SparseArray<Animation> jdField_c_of_type_AndroidUtilSparseArray;
  public static final String c;
  public static boolean c;
  public static int d;
  public static final String d;
  public static int e;
  public static final String e;
  public static int f;
  public static int g;
  public static int h;
  public static int i;
  public static int j;
  public static int k;
  private static int jdField_m_of_type_Int;
  private static boolean p;
  private static boolean q;
  private static boolean r = true;
  private ajzp jdField_a_of_type_Ajzp = new ajzp(this);
  public akam a;
  private alji jdField_a_of_type_Alji = new alji(null);
  public Dialog a;
  public Intent a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Vibrator jdField_a_of_type_AndroidOsVibrator;
  private SparseArray<TabDragAnimationView> jdField_a_of_type_AndroidUtilSparseArray;
  private bisq jdField_a_of_type_Bisq = new ajzk(this);
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QQBlurView jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new MainFragment.21(this);
  private HashMap<String, View> jdField_a_of_type_JavaUtilHashMap;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private View[] jdField_a_of_type_ArrayOfAndroidViewView;
  private long jdField_b_of_type_Long;
  private Dialog jdField_b_of_type_AndroidAppDialog;
  private Intent jdField_b_of_type_AndroidContentIntent;
  private SparseArray<TextView> jdField_b_of_type_AndroidUtilSparseArray;
  private HashMap<String, Object> jdField_b_of_type_JavaUtilHashMap;
  private long jdField_c_of_type_Long;
  public boolean d;
  boolean e;
  public String f;
  boolean f;
  private String h;
  private String i;
  private String jdField_j_of_type_JavaLangString;
  private boolean jdField_j_of_type_Boolean = true;
  private String jdField_k_of_type_JavaLangString = "";
  private boolean jdField_k_of_type_Boolean;
  private int jdField_l_of_type_Int = -1;
  private String jdField_l_of_type_JavaLangString = "";
  private boolean jdField_l_of_type_Boolean = true;
  private boolean jdField_m_of_type_Boolean;
  private boolean n;
  private boolean o;
  
  static
  {
    jdField_a_of_type_Int = -1;
    jdField_c_of_type_Int = 1;
    jdField_d_of_type_Int = 2;
    jdField_e_of_type_Int = 3;
    jdField_f_of_type_Int = 4;
    jdField_g_of_type_Int = 5;
    jdField_h_of_type_Int = 7;
    jdField_i_of_type_Int = 2;
    jdField_j_of_type_Int = 8;
    jdField_k_of_type_Int = 9;
    jdField_a_of_type_JavaLangString = anvx.a(2131693748);
    jdField_b_of_type_JavaLangString = anvx.a(2131693747);
    jdField_c_of_type_JavaLangString = anvx.a(2131693749);
    jdField_d_of_type_JavaLangString = anvx.a(2131693417);
    jdField_e_of_type_JavaLangString = anvx.a(2131697591);
    jdField_a_of_type_Boolean = true;
    jdField_c_of_type_AndroidUtilSparseArray = new SparseArray(2);
    jdField_a_of_type_ArrayOfInt = new int[] { 2130850412, 2130841329, 2130841330, 2130841331, 2130841332, 2130841333, 2130841335, 2130841334 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130850411, 2130841336, 2130841337, 2130841338 };
  }
  
  public MainFragment()
  {
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
  }
  
  private void A()
  {
    int i2 = -1;
    if (f()) {}
    for (int i1 = -1;; i1 = 2130843303)
    {
      View localView = pip.a(i1, 2130850419, i2, 2130850420, 2131694148, 16, 8);
      if (localView != null)
      {
        localView.setOnClickListener(new ajzj(this));
        this.jdField_a_of_type_ArrayOfAndroidViewView[6] = new RedTouch(getActivity(), localView).b(49).e(3).c(5).a();
        VideoReport.setElementId(localView, "tab_button");
        VideoReport.setElementParams(localView, new pti().a("14").a("tab_id", "kandian").b("tab_bar").c("click_tab").a().a());
        this.jdField_a_of_type_JavaUtilHashMap.put(jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfAndroidViewView[6]);
        this.jdField_a_of_type_JavaUtilHashMap.put(jdField_d_of_type_JavaLangString + "_num", this.jdField_a_of_type_ArrayOfAndroidViewView[6].findViewById(2131380453));
        localView.setContentDescription(getResources().getString(2131694148));
      }
      return;
      i2 = 2130843304;
    }
  }
  
  private void B()
  {
    boolean bool3 = true;
    Object localObject2 = (RedTouch)this.jdField_a_of_type_JavaUtilHashMap.get(jdField_d_of_type_JavaLangString);
    boolean bool1;
    Object localObject1;
    boolean bool2;
    if (localObject2 != null)
    {
      Object localObject3 = c();
      if ((localObject3 == null) || (!(localObject3 instanceof ReadinjoyTabFrame))) {
        break label293;
      }
      bool1 = true;
      KandianMergeManager localKandianMergeManager = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
      localObject1 = localKandianMergeManager.a();
      if ((localObject1 == null) || (((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.get() != 5)) {
        break label298;
      }
      bool2 = true;
      label84:
      if ((!bool1) || (localObject1 == null) || (((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.get() != 0)) {
        break label317;
      }
      localObject3 = (ReadinjoyTabFrame)localObject3;
      if (((((ReadinjoyTabFrame)localObject3).a() == null) || (((ReadinjoyTabFrame)localObject3).a().mChannelCoverId == 0)) && (localKandianMergeManager.f() <= 0)) {
        break label317;
      }
      localObject1 = null;
    }
    label293:
    label298:
    label303:
    label308:
    label317:
    for (;;)
    {
      ((RedTouch)localObject2).setTag(2131376229, localObject1);
      a(39, (RedTouch)localObject2, (BusinessInfoCheckUpdate.RedTypeInfo)localObject1);
      if (((BaseActivity.sTopActivity instanceof SplashActivity)) && (isVisible()) && (pkh.a(null)) && (localObject1 != null)) {
        pkh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BusinessInfoCheckUpdate.RedTypeInfo)localObject1);
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("updateKandianTabRedPoint isInTabFrame : ").append(bool1).append(", isRemoveRedPoint : ");
        if (localObject1 != null) {
          break label303;
        }
        bool1 = bool3;
        label236:
        localObject2 = ((StringBuilder)localObject2).append(bool1).append(", isNumRedPoint : ").append(bool2).append(", cnt : ");
        if (localObject1 == null) {
          break label308;
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
        break label236;
      }
    }
  }
  
  private void C()
  {
    this.jdField_a_of_type_ArrayOfAndroidViewView[4] = null;
    this.jdField_a_of_type_JavaUtilHashMap.remove("NOW");
    this.jdField_a_of_type_JavaUtilHashMap.remove("NOW_num");
    a(Now.class);
  }
  
  private void D()
  {
    bmhv.c();
    ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).o();
    if (bmhv.l())
    {
      if ((this.jdField_a_of_type_ArrayOfAndroidViewView != null) && (this.jdField_a_of_type_ArrayOfAndroidViewView.length >= 6) && (this.jdField_a_of_type_ArrayOfAndroidViewView[6] != null)) {
        VideoReport.reportEvent("imp", ((RedTouch)this.jdField_a_of_type_ArrayOfAndroidViewView[6]).a(), new pti().a("14").a("tab_id", "kandian").b("tab_bar").a().a());
      }
      Object localObject = (RedTouch)this.jdField_a_of_type_JavaUtilHashMap.get(jdField_d_of_type_JavaLangString);
      if (localObject != null)
      {
        localObject = (BusinessInfoCheckUpdate.RedTypeInfo)((RedTouch)localObject).getTag(2131376229);
        pkh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BusinessInfoCheckUpdate.RedTypeInfo)localObject);
      }
      ThreadManager.executeOnSubThread(new MainFragment.19(this));
    }
  }
  
  private void E()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DynimiIcon", 2, "onConversationTabIconDoubleClick mIsDefaultTheme = " + this.jdField_l_of_type_Boolean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendMessage(localMqqHandler.obtainMessage(1071));
      }
      if (this.jdField_l_of_type_Boolean)
      {
        a((TabDragAnimationView)this.jdField_a_of_type_AndroidUtilSparseArray.get(jdField_b_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangRunnable);
        if (!this.jdField_f_of_type_Boolean) {
          this.jdField_f_of_type_Boolean = true;
        }
      }
    }
  }
  
  private void F()
  {
    TabDragAnimationView localTabDragAnimationView = (TabDragAnimationView)this.jdField_a_of_type_AndroidUtilSparseArray.get(jdField_b_of_type_Int);
    Object localObject = (String)localTabDragAnimationView.getTag();
    if (QLog.isColorLevel()) {
      QLog.d("DynimiIcon", 2, "onConversationTabIconMoveResult mIsDefaultTheme = " + this.jdField_l_of_type_Boolean + ", tag = " + (String)localObject);
    }
    if ((this.jdField_l_of_type_Boolean) && (a() == jdField_b_of_type_Int) && (!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(jdField_a_of_type_JavaLangString)))
    {
      localObject = (Conversation)a(Conversation.class);
      if (localObject == null) {
        break label152;
      }
    }
    label152:
    for (int i1 = ((Conversation)localObject).jdField_d_of_type_Int;; i1 = 0)
    {
      if (i1 <= 0)
      {
        a(localTabDragAnimationView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangRunnable);
        if (!this.jdField_f_of_type_Boolean) {
          this.jdField_f_of_type_Boolean = true;
        }
      }
      return;
    }
  }
  
  private static int a(int paramInt)
  {
    switch (paramInt)
    {
    case -1: 
    case 1: 
    case 2: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      return 0;
    case 0: 
      return 2;
    case 3: 
      return 6;
    case 4: 
      return 5;
    case 5: 
      return 1;
    }
    return 4;
  }
  
  public static int a(Bundle paramBundle)
  {
    if ((paramBundle == null) || (!paramBundle.containsKey("main_tab_id"))) {
      return -2147483648;
    }
    switch (paramBundle.getInt("main_tab_id"))
    {
    case 7: 
    case 8: 
    default: 
      return -2147483648;
    case 1: 
      return jdField_b_of_type_Int;
    case 2: 
      return jdField_c_of_type_Int;
    case 3: 
      return jdField_d_of_type_Int;
    case 4: 
      return jdField_e_of_type_Int;
    case 5: 
      return jdField_f_of_type_Int;
    case 6: 
      return jdField_g_of_type_Int;
    case 9: 
      return jdField_j_of_type_Int;
    }
    return jdField_k_of_type_Int;
  }
  
  private int a(String paramString)
  {
    int i1 = jdField_b_of_type_Int;
    if (paramString.equals(Conversation.class.getName())) {
      i1 = jdField_b_of_type_Int;
    }
    do
    {
      return i1;
      if (paramString.equals(Contacts.class.getName())) {
        return jdField_d_of_type_Int;
      }
      if (paramString.equals(Leba.class.getName())) {
        return jdField_e_of_type_Int;
      }
      if (paramString.equals(QzoneFrame.class.getName())) {
        return jdField_j_of_type_Int;
      }
      if (paramString.equals(Now.class.getName())) {
        return jdField_g_of_type_Int;
      }
    } while (!paramString.equals(ReadinjoyTabFrame.class.getName()));
    return jdField_h_of_type_Int;
  }
  
  private static View a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if (BaseApplicationImpl.sApplication == null) {
      return null;
    }
    View localView = View.inflate(BaseApplicationImpl.sApplication, 2131562927, null);
    ((DragTextView)localView.findViewById(2131380453)).setDragViewType(2);
    ((TabDragAnimationView)localView.findViewById(2131378414)).setEmotionDrawable(paramInt1, paramInt2, paramInt3, paramInt4, paramInt6, paramInt7);
    ((TextView)localView.findViewById(2131380194)).setText(paramInt5);
    return localView;
  }
  
  public static MainFragment a()
  {
    MainFragment localMainFragment = new MainFragment();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("should_restore_from_kill", false);
    localMainFragment.setArguments(localBundle);
    return localMainFragment;
  }
  
  private String a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 16: 
      return paramString + "_num";
    case 18: 
      return paramString + "_icon";
    }
    return paramString + "_new";
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == jdField_c_of_type_Int) && (paramInt2 != jdField_c_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      bapk localbapk = (bapk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
      if (localbapk != null) {
        localbapk.a(bcrg.a());
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = -1;
    TabDragAnimationView localTabDragAnimationView = (TabDragAnimationView)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    if (localTabDragAnimationView != null)
    {
      if (this.jdField_l_of_type_Boolean) {
        paramInt2 = -1;
      }
      localTabDragAnimationView.setFaceDrawable(paramInt2);
      if (!this.jdField_l_of_type_Boolean) {
        break label53;
      }
    }
    label53:
    for (paramInt1 = i1;; paramInt1 = paramInt3)
    {
      localTabDragAnimationView.setFacePressedDrawable(paramInt1);
      return;
    }
  }
  
  private void a(int paramInt, ajzs paramajzs)
  {
    if (paramajzs == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("MainFragment", 2, paramajzs.jdField_a_of_type_JavaLangString + " is execute");
          }
          if (paramInt == 2131372345)
          {
            paramajzs = this.jdField_a_of_type_Akam.a();
            if ((paramajzs == null) || (paramajzs.a == null))
            {
              if (QLog.isColorLevel()) {
                QLog.w("MainFragment", 2, "mWrapper is null");
              }
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 0, anvx.a(2131705893), 0).b(getResources().getDimensionPixelSize(2131299080));
            }
            for (;;)
            {
              bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80041C1", "0X80041C1", 0, 0, "", "", "", "");
              return;
              if (paramajzs.a.iUpgradeType == 0) {
                QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 0, anvx.a(2131705889), 0).b(getResources().getDimensionPixelSize(2131299080));
              } else if ((paramajzs != null) && (paramajzs.a != null)) {
                UpgradeDetailActivity.a(getActivity(), bgvx.a().a(), false, false, true);
              }
            }
          }
          if (paramInt != 2131372343) {
            break;
          }
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80041C3", "0X80041C3", 0, 0, "", "", "", "");
        } while (!azit.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity()));
        g();
        return;
        if (paramInt == 2131372342)
        {
          f();
          return;
        }
      } while (paramajzs.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null);
      aqwe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), paramajzs.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo);
    } while (!"com.tencent.Feedback_5_8".equals(paramajzs.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName));
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80041C2", "0X80041C2", 0, 0, "", "", "", "");
  }
  
  private void a(int paramInt, RedTouch paramRedTouch, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    String str3;
    if ((paramRedTouch != null) && (paramRedTypeInfo != null))
    {
      switch (paramRedTypeInfo.red_type.get())
      {
      }
      for (;;)
      {
        a(paramRedTouch, paramRedTypeInfo);
        return;
        paramRedTouch.c(15);
        a(paramInt, anvx.a(2131705890), anvx.a(2131705890));
        continue;
        paramRedTouch.c(5);
        if (paramInt == 39) {
          paramRedTouch.c(15);
        }
        str3 = paramRedTypeInfo.red_content.get() + anvx.a(2131705892);
        String str1 = paramRedTypeInfo.red_content.get();
        try
        {
          if (Integer.parseInt(str1) <= 99) {
            break;
          }
          str1 = "多于99条更新";
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            localNumberFormatException.printStackTrace();
            String str2 = str3;
          }
        }
        a(paramInt, str1, str3);
      }
    }
    a(paramRedTouch, null);
    a(paramInt, "", "");
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt == 33)
    {
      this.jdField_k_of_type_JavaLangString = paramString1;
      return;
    }
    this.jdField_l_of_type_JavaLangString = paramString2;
  }
  
  private void a(Bundle paramBundle, int paramInt)
  {
    Object localObject = (Conversation)a(Conversation.class);
    String str = paramBundle.getString("from");
    if (localObject != null) {
      ((Conversation)localObject).jdField_b_of_type_Boolean = "10003".equals(str);
    }
    if (("smartdevice".equals(str)) && (paramInt == jdField_d_of_type_Int))
    {
      localObject = (Contacts)a(Contacts.class);
      if (localObject != null) {
        ((Contacts)localObject).a(true);
      }
    }
    if ((paramInt == jdField_g_of_type_Int) && (paramInt == a()))
    {
      localObject = (Now)a(Now.class);
      if (localObject != null)
      {
        ((Now)localObject).jdField_b_of_type_Boolean = paramBundle.getBoolean("extra_from_share");
        ((Now)localObject).jdField_a_of_type_JavaLangString = paramBundle.getString("new_video_extra_info");
      }
    }
    if ((paramInt == jdField_e_of_type_Int) && ("campus_notice".equals(str)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CampusNoticeManager", 2, String.format(Locale.getDefault(), "back from campus_notice %d", new Object[] { Integer.valueOf(DrawerFrame.jdField_a_of_type_Int) }));
      }
      if (DrawerFrame.jdField_a_of_type_Int == 0) {
        DrawerFrame.jdField_a_of_type_Int = 3;
      }
    }
  }
  
  private void a(View paramView)
  {
    if (paramView == null)
    {
      QLog.e("MainFragment", 1, "disableBlur: tabWidget == null");
      return;
    }
    paramView.setBackgroundResource(2130850037);
    int i1 = 0;
    label24:
    if (i1 < this.jdField_a_of_type_ArrayOfAndroidViewView.length) {
      if (this.jdField_a_of_type_ArrayOfAndroidViewView[i1] != null) {
        break label49;
      }
    }
    for (;;)
    {
      i1 += 1;
      break label24;
      break;
      label49:
      this.jdField_a_of_type_ArrayOfAndroidViewView[i1].setBackgroundResource(2130850546);
    }
  }
  
  private void a(View paramView1, View paramView2)
  {
    boolean bool = true;
    if (paramView1 == null)
    {
      QLog.e("MainFragment", 1, "enableBlur: tabWidget == null");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(paramView2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c(-1);
    paramView2 = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
    label75:
    int i1;
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramView2.setEnableBlur(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setDisableBlurDrawableRes(2130840673);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(new ajzl(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
      paramView1.setBackgroundColor(0);
      i1 = 0;
      label127:
      if (i1 < this.jdField_a_of_type_ArrayOfAndroidViewView.length) {
        if (this.jdField_a_of_type_ArrayOfAndroidViewView[i1] != null) {
          break label158;
        }
      }
    }
    for (;;)
    {
      i1 += 1;
      break label127;
      break;
      bool = false;
      break label75;
      label158:
      this.jdField_a_of_type_ArrayOfAndroidViewView[i1].setBackgroundColor(0);
    }
  }
  
  private void a(anun paramanun)
  {
    if ((paramanun instanceof Leba)) {
      ((Leba)paramanun).c();
    }
    while (!(paramanun instanceof QzoneFrame)) {
      return;
    }
    ((QzoneFrame)paramanun).d();
  }
  
  private void a(anun paramanun, int paramInt)
  {
    ReadinjoyTabFrame localReadinjoyTabFrame;
    if (((paramanun instanceof ReadinjoyTabFrame)) || (paramInt == jdField_h_of_type_Int))
    {
      localReadinjoyTabFrame = (ReadinjoyTabFrame)a(ReadinjoyTabFrame.class);
      if (localReadinjoyTabFrame != null)
      {
        if (paramInt != jdField_h_of_type_Int) {
          break label68;
        }
        uvs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localReadinjoyTabFrame.f(true);
        e(5);
      }
    }
    for (;;)
    {
      pwb.c(paramInt);
      bkyh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramanun, paramInt);
      return;
      label68:
      localReadinjoyTabFrame.f(false);
      e(4);
      continue;
      e(4);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, HashMap<String, View> paramHashMap)
  {
    if (paramHashMap != null) {}
    label155:
    label162:
    for (;;)
    {
      try
      {
        if (paramHashMap.get(jdField_d_of_type_JavaLangString) == null) {
          continue;
        }
        paramHashMap = (BusinessInfoCheckUpdate.RedTypeInfo)((RedTouch)paramHashMap.get(jdField_d_of_type_JavaLangString)).getTag(2131376229);
        if (paramHashMap == null) {
          break label155;
        }
        i2 = a(paramHashMap.red_type.get());
        if (i2 != 1) {
          continue;
        }
        i1 = Integer.parseInt(paramHashMap.red_content.get());
      }
      catch (Throwable paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MainFragment", 2, paramQQAppInterface, new Object[0]);
        return;
      }
      bdla.b(paramQQAppInterface, "dc00898", "", "", "0X80098E1", "0X80098E1", 0, 0, "" + i2, "" + i1, "", "");
      return;
      int i1 = 1;
      break label162;
      i1 = 0;
      int i2 = 0;
    }
  }
  
  private void a(RedTouch paramRedTouch, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if (paramRedTouch != null)
    {
      paramRedTouch.a();
      paramRedTouch.a(paramRedTypeInfo);
    }
  }
  
  private void a(TabDragAnimationView paramTabDragAnimationView, QQAppInterface paramQQAppInterface, Runnable paramRunnable)
  {
    int i4 = jdField_a_of_type_ArrayOfInt.length - 1;
    int i2 = jdField_a_of_type_ArrayOfInt.length - 1;
    int i3 = jdField_a_of_type_JavaUtilRandom.nextInt(100000) % i4;
    int i1 = i3;
    if (i3 == jdField_m_of_type_Int) {
      i1 = (i3 + 1) % i4;
    }
    jdField_m_of_type_Int = i1;
    int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
    if (g()) {}
    for (;;)
    {
      paramTabDragAnimationView.setBgPressedDrawable(arrayOfInt[i2]);
      if (paramRunnable != null)
      {
        ThreadManager.getSubThreadHandler().removeCallbacks(paramRunnable);
        ThreadManager.getSubThreadHandler().post(paramRunnable);
      }
      if (QLog.isColorLevel()) {
        QLog.d("DynimiIcon", 2, "updateTabFocusIcon currIndex = " + i1);
      }
      bdla.b(paramQQAppInterface, "dc00898", "", "", "0X8009CDD", "0X8009CDD", 0, 0, "", "", "", "");
      if (r)
      {
        r = false;
        bdla.b(paramQQAppInterface, "dc00898", "", "", "0X8009CDB", "0X8009CDB", 0, 0, "", "", "", "");
      }
      return;
      i2 = i1;
    }
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
    int i1;
    Object localObject1;
    if (jdField_a_of_type_JavaLangString.equals(paramString1))
    {
      localStringBuilder.append("消息 ");
      i1 = c(paramString1);
      localObject1 = (TextView)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1 + "_num");
      if (i1 != 2) {
        break label281;
      }
      localStringBuilder.append("有更新");
    }
    for (;;)
    {
      if (jdField_c_of_type_JavaLangString.equals(paramString1)) {
        localStringBuilder.append(this.jdField_l_of_type_JavaLangString);
      }
      localObject1 = (TextView)paramString2.findViewById(2131380194);
      Object localObject2 = paramString2.findViewById(2131378414);
      if (localObject2 != null)
      {
        ((View)localObject2).setContentDescription(paramString1);
        bgyd.a((View)localObject2, false);
      }
      if (localObject1 != null) {
        bgyd.a((View)localObject1, false);
      }
      if (!(paramString2 instanceof RedTouchTab)) {
        break label604;
      }
      ((RedTouchTab)paramString2).a().setContentDescription(localStringBuilder.toString());
      return;
      if (jdField_b_of_type_JavaLangString.equals(paramString1))
      {
        localStringBuilder.append("联系人 ");
        break label52;
      }
      if (jdField_c_of_type_JavaLangString.equals(paramString1))
      {
        localStringBuilder.append("动态 ");
        break label52;
      }
      if (!"NOW".equals(paramString1)) {
        break;
      }
      localStringBuilder.append(vzh.jdField_a_of_type_JavaLangString + " ");
      break label52;
      label281:
      if (i1 == 3)
      {
        if (jdField_a_of_type_JavaLangString.equals(paramString1))
        {
          localObject1 = ((TextView)localObject1).getText().toString();
          if ("".equals(localObject1)) {
            localStringBuilder.append("多于99条未读");
          } else {
            localStringBuilder.append((String)localObject1 + "条未读");
          }
        }
        else if (jdField_b_of_type_JavaLangString.equals(paramString1))
        {
          localObject2 = ((TextView)localObject1).getText().toString();
          if (((TextView)localObject1).getVisibility() == 0)
          {
            if ("99+".equals(localObject2)) {
              localStringBuilder.append("多于99条更新");
            } else {
              localStringBuilder.append((String)localObject2 + "条更新");
            }
          }
          else {
            localStringBuilder.append(this.jdField_k_of_type_JavaLangString);
          }
        }
        else if ("NOW".equals(paramString1))
        {
          localObject2 = ((TextView)localObject1).getText().toString();
          if (((TextView)localObject1).getVisibility() == 0) {
            if ("99+".equals(localObject2)) {
              localStringBuilder.append("多于99个新的" + vzh.jdField_a_of_type_JavaLangString);
            } else {
              localStringBuilder.append((String)localObject2 + "个新的" + vzh.jdField_a_of_type_JavaLangString);
            }
          }
        }
      }
      else if (i1 == 1) {
        localStringBuilder.append("有新消息");
      } else if (jdField_b_of_type_JavaLangString.equals(paramString1)) {
        localStringBuilder.append(this.jdField_k_of_type_JavaLangString);
      }
    }
    label604:
    paramString2.setContentDescription(localStringBuilder.toString());
  }
  
  private static void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    int i1 = 0;
    int i2 = 2;
    int i3 = 1;
    if (paramBoolean1)
    {
      jdField_b_of_type_Int = 0;
      jdField_c_of_type_Int = 1;
      jdField_d_of_type_Int = 2;
      jdField_e_of_type_Int = 3;
      jdField_g_of_type_Int = -100;
      jdField_f_of_type_Int = -100;
      return;
    }
    if (paramInt >= 0)
    {
      if (paramInt <= 0) {
        i1 = 1;
      }
      jdField_b_of_type_Int = i1;
      i1 = i3;
      if (1 >= paramInt) {
        i1 = 2;
      }
      jdField_d_of_type_Int = i1;
      i1 = i2;
      if (2 >= paramInt) {
        i1 = 3;
      }
      jdField_e_of_type_Int = i1;
      jdField_g_of_type_Int = paramInt;
      jdField_c_of_type_Int = -100;
      jdField_f_of_type_Int = -100;
      return;
    }
    jdField_b_of_type_Int = 0;
    jdField_c_of_type_Int = -100;
    jdField_d_of_type_Int = 1;
    jdField_e_of_type_Int = 2;
    if (paramBoolean2)
    {
      jdField_h_of_type_Int = jdField_i_of_type_Int;
      jdField_e_of_type_Int = 3;
    }
    for (;;)
    {
      jdField_g_of_type_Int = -100;
      jdField_c_of_type_Int = -100;
      jdField_f_of_type_Int = -100;
      return;
      jdField_h_of_type_Int = -100;
    }
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.get(paramString) == null)) {
      return;
    }
    ((View)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).setSoundEffectsEnabled(paramBoolean);
  }
  
  private boolean a(int paramInt)
  {
    if ((paramInt == jdField_c_of_type_Int) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isCallTabShow))
    {
      Conversation localConversation = (Conversation)a(Conversation.class);
      if (localConversation != null) {
        localConversation.jdField_a_of_type_Boolean = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setCurrentTab(jdField_b_of_type_Int);
      return true;
    }
    return false;
  }
  
  private boolean a(Bundle paramBundle, int paramInt)
  {
    if (paramInt != jdField_b_of_type_Int) {}
    do
    {
      return false;
      if ((1 == paramBundle.getInt("conversation_index", -1)) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isCallTabShow))
      {
        paramBundle = (Conversation)a(Conversation.class);
        if (paramBundle != null) {
          paramBundle.jdField_a_of_type_Boolean = true;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setCurrentTab(paramInt);
        return true;
      }
    } while (paramInt != a());
    Conversation localConversation = (Conversation)a(Conversation.class);
    String str = paramBundle.getString("from");
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "doOnNewIntent, same tab,from=" + str);
    }
    if (localConversation != null) {
      if ((!"10003".equals(str)) && (!"10004".equals(str))) {
        break label174;
      }
    }
    label174:
    for (boolean bool = true;; bool = false)
    {
      localConversation.jdField_b_of_type_Boolean = bool;
      localConversation.jdField_c_of_type_Boolean = paramBundle.getBoolean("theme_back_to_conversation", false);
      return true;
    }
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    boolean bool = false;
    if (this.o != QZoneApiProxy.isQzoneInstalled()) {}
    for (int i1 = 1;; i1 = 0)
    {
      if ((!paramBoolean1) && ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isCallTabShow) || (this.jdField_a_of_type_ArrayOfAndroidViewView[1] != null)) && ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isCallTabShow) || (this.jdField_a_of_type_ArrayOfAndroidViewView[1] == null)) && (this.jdField_a_of_type_ArrayOfAndroidViewView[4] == null) && (!paramBoolean2) && (!paramBoolean3))
      {
        paramBoolean1 = bool;
        if (i1 == 0) {}
      }
      else
      {
        paramBoolean1 = true;
      }
      return paramBoolean1;
    }
  }
  
  public static View[] a(LayoutInflater paramLayoutInflater)
  {
    boolean bool = f();
    View[] arrayOfView = new View[7];
    arrayOfView[0] = paramLayoutInflater.inflate(2131559382, null);
    arrayOfView[1] = ((DragFrameLayout)arrayOfView[0].findViewById(2131365160));
    int i1 = 2130850540;
    int i2 = 2130850541;
    if (bool)
    {
      i2 = -1;
      i1 = -1;
    }
    arrayOfView[2] = a(i1, 2130850411, i2, 2130850412, 2131693748, 11, 2);
    arrayOfView[2].setOnClickListener(new ajzq(null));
    i1 = 2130850538;
    i2 = 2130850539;
    if (bool)
    {
      i2 = -1;
      i1 = -1;
    }
    View localView1 = a(i1, 2130850409, i2, 2130850410, 2131693747, 12, 3);
    localView1.setOnClickListener(new ajzq(null));
    arrayOfView[3] = new RedTouchTab(paramLayoutInflater.getContext(), localView1).b(49).e(3).a(true).c(5).a();
    i1 = 2130850543;
    if (bool) {
      i1 = -1;
    }
    localView1 = a(-1, 2130850415, i1, 2130850416, 2131693749, 14, 4);
    localView1.setOnClickListener(new ajzo(localView1, "lebaTab"));
    arrayOfView[4] = new RedTouchTab(paramLayoutInflater.getContext(), localView1).b(49).e(3).a(true).c(5).a();
    View localView2 = a(-1, 2130850415, i1, 2130850416, 2131693749, 14, 4);
    localView2.setOnClickListener(new ajzo(localView2, "lebaTabNew"));
    arrayOfView[5] = new RedTouchTab(paramLayoutInflater.getContext(), localView2).b(49).e(3).a(true).c(5).a();
    localView2 = a(-1, 2130850415, i1, 2130850416, 2131693749, 14, 4);
    localView2.setOnClickListener(new ajzo(localView1, "QzoneTab"));
    arrayOfView[6] = new RedTouchTab(paramLayoutInflater.getContext(), localView2).b(49).e(3).a(true).c(5).a();
    return arrayOfView;
  }
  
  private View[] a(View paramView)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(9);
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap(13);
    boolean bool = f();
    Object localObject = ((SplashActivity)getActivity()).jdField_a_of_type_ArrayOfAndroidViewView;
    ((SplashActivity)getActivity()).jdField_a_of_type_ArrayOfAndroidViewView = null;
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = ((DragFrameLayout)localObject[1]);
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[] { localObject[2], null, localObject[3], localObject[4], null, localObject[5], null, localObject[6], null };
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.setOnDragListener(this.jdField_a_of_type_Alji);
      this.jdField_a_of_type_JavaUtilHashMap.put(jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfAndroidViewView[0]);
      this.jdField_a_of_type_JavaUtilHashMap.put(jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfAndroidViewView[2]);
      this.jdField_a_of_type_JavaUtilHashMap.put(jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfAndroidViewView[3]);
      this.jdField_a_of_type_JavaUtilHashMap.put("动态", this.jdField_a_of_type_ArrayOfAndroidViewView[7]);
      this.jdField_a_of_type_JavaUtilHashMap.put(jdField_a_of_type_JavaLangString + "_num", this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131380453));
      this.jdField_a_of_type_JavaUtilHashMap.put(jdField_b_of_type_JavaLangString + "_num", this.jdField_a_of_type_ArrayOfAndroidViewView[2].findViewById(2131380453));
      this.jdField_a_of_type_JavaUtilHashMap.put(jdField_c_of_type_JavaLangString + "_num", this.jdField_a_of_type_ArrayOfAndroidViewView[3].findViewById(2131380453));
      this.jdField_a_of_type_JavaUtilHashMap.put("动态_num", this.jdField_a_of_type_ArrayOfAndroidViewView[7].findViewById(2131380453));
      localObject = (TabDragAnimationView)this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131378414);
      ((TabDragAnimationView)localObject).setTag(jdField_a_of_type_JavaLangString);
      ((TabDragAnimationView)localObject).setOnDragListener(new ajzh(this));
      ((TabDragAnimationView)localObject).setOnLongClickListener(new ajzi(this));
      paramView = (QQTabWidget)paramView.findViewById(16908307);
      if (paramView == null) {
        break label920;
      }
      paramView.setShowDividers(0);
      paramView.setTabWidgetMoveListener(this.jdField_a_of_type_Bisq);
    }
    for (;;)
    {
      return this.jdField_a_of_type_ArrayOfAndroidViewView;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = ((DragFrameLayout)paramView.findViewById(2131365160));
      int i1 = 2130850538;
      int i2 = 2130850538;
      if (bool)
      {
        i1 = -1;
        i2 = -1;
      }
      localObject = a(i1, 2130850409, i2, 2130850410, 2131693747, 12, 3);
      ((View)localObject).setOnClickListener(new ajzq(null));
      i1 = 2130850543;
      if (bool) {
        i1 = -1;
      }
      View localView1 = a(-1, 2130850415, i1, 2130850416, 2131693749, 14, 4);
      localView1.setOnClickListener(new ajzo(localView1, "lebaTab"));
      View localView2 = a(-1, 2130850415, i1, 2130850416, 2131693749, 14, 4);
      localView2.setOnClickListener(new ajzo(localView2, "qzoneTab"));
      View localView3 = a(-1, 2130850415, i1, 2130850416, 2131693749, 14, 4);
      localView3.setOnClickListener(new ajzo(localView3, "lebaTabNew"));
      View localView4 = a(2130846512, 2130850413, 2130846513, 2130850414, 2131699180, 15, 5);
      localView4.setOnClickListener(new ajzq(null));
      i1 = 2130850540;
      i2 = 2130850541;
      if (bool)
      {
        i1 = -1;
        i2 = -1;
      }
      View localView5 = a(i1, 2130850411, i2, 2130850412, 2131693748, 11, 2);
      localView5.setOnClickListener(new ajzq(null));
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[] { localView5, null, new RedTouchTab(getActivity(), (View)localObject).b(49).e(3).a(true).c(5).a(), new RedTouchTab(getActivity(), localView1).b(49).e(3).a(true).c(5).a(), new RedTouchTab(getActivity(), localView4).b(49).e(3).a(true).c(5).a(), new RedTouchTab(getActivity(), localView3).b(49).e(3).a(true).c(5).a(), null, new RedTouchTab(getActivity(), localView2).b(49).e(3).a(true).c(5).a(), null };
      break;
      label920:
      QLog.i("MainFragment", 1, "initTabs tabWidget is null");
    }
  }
  
  private int b(String paramString)
  {
    int i1 = jdField_b_of_type_Int;
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return i1;
      if (paramString.equals(Conversation.class.getName())) {
        return jdField_b_of_type_Int;
      }
      if (paramString.equals(Contacts.class.getName()))
      {
        i1 = jdField_d_of_type_Int;
        e();
        return i1;
      }
      if (paramString.equals(Leba.class.getName())) {
        return jdField_e_of_type_Int;
      }
      if (paramString.equals(Now.class.getName())) {
        return jdField_g_of_type_Int;
      }
      if (paramString.equals(ReadinjoyTabFrame.class.getName())) {
        return jdField_h_of_type_Int;
      }
    } while (!paramString.equals(QzoneFrame.class.getName()));
    return jdField_j_of_type_Int;
  }
  
  private void b(Intent paramIntent)
  {
    try
    {
      i1 = paramIntent.getIntExtra("forward", -1);
      i2 = paramIntent.getIntExtra("uintype", -1);
      if ((i1 > 0) && ((i2 == 1035) || (i2 == 1041) || (i2 == 1042)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isCreateManager(QQManagerFactory.PUSH_NOTICE_MANAGER)))
      {
        ((awtm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUSH_NOTICE_MANAGER)).a(getActivity(), paramIntent);
        return;
      }
      if (i1 != 2) {
        break label156;
      }
      localObject = paramIntent.getParcelableExtra("AllInOne");
      if ((localObject instanceof ProfileActivity.AllInOne))
      {
        localObject = (ProfileActivity.AllInOne)localObject;
        ((ProfileActivity.AllInOne)localObject).jdField_g_of_type_Int = 100;
        ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int = 6;
        ProfileActivity.b(getActivity(), (ProfileActivity.AllInOne)localObject);
      }
    }
    catch (Exception paramIntent)
    {
      int i1;
      int i2;
      Object localObject;
      while (QLog.isColorLevel())
      {
        QLog.e("MainFragment", 2, "", paramIntent);
        return;
        label156:
        if (i1 == 3)
        {
          localObject = paramIntent.getStringExtra("url");
          Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
          if (i2 != -1)
          {
            localIntent.putExtra("uintype", i2);
            if ((i2 == 1030) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isCreateManager(QQManagerFactory.CAMPUS_NOTICE_MANAGER)))
            {
              bdkv localbdkv = new bdkv();
              localbdkv.jdField_e_of_type_JavaLangString = "0X8009241";
              localbdkv.jdField_d_of_type_JavaLangString = "点击业务Push";
              bdku.a((String)localObject, localbdkv);
              bdku.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbdkv);
              ((aqnd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CAMPUS_NOTICE_MANAGER)).a(null);
              if (QLog.isColorLevel()) {
                QLog.d("CampusNoticeManager", 2, "remove campus notice");
              }
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("CampusNoticeManager", 1, "doOnNewIntent : url" + (String)localObject);
          }
          localIntent.putExtra("url", (String)localObject);
          startActivity(localIntent);
        }
      }
    }
    paramIntent.removeExtra("forward");
    return;
  }
  
  private int c(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilHashMap == null) {
      return 0;
    }
    Object localObject = this.jdField_b_of_type_JavaUtilHashMap.get(paramString + "_new");
    int i1;
    if (((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue())) {
      i1 = 2;
    }
    for (;;)
    {
      return i1;
      localObject = this.jdField_b_of_type_JavaUtilHashMap.get(paramString + "_num");
      if (((localObject instanceof Integer)) && (((Integer)localObject).intValue() > 0))
      {
        i1 = 3;
      }
      else
      {
        paramString = this.jdField_b_of_type_JavaUtilHashMap.get(paramString + "_icon");
        if (((paramString instanceof Boolean)) && (((Boolean)paramString).booleanValue())) {
          i1 = 1;
        } else {
          i1 = 0;
        }
      }
    }
  }
  
  private void c(int paramInt)
  {
    int i3 = 0;
    Object localObject = (TabDragAnimationView)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null) {
      ((TabDragAnimationView)localObject).setPressChanged(true);
    }
    localObject = (TextView)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null) {
      ((TextView)localObject).setTextColor(getResources().getColor(2131167226));
    }
    int i1 = 0;
    int i2 = i3;
    if (i1 < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      if (this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i1) == paramInt) {}
      for (;;)
      {
        i1 += 1;
        break;
        ((TabDragAnimationView)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i1)).setPressChanged(false);
      }
    }
    if (i2 < this.jdField_b_of_type_AndroidUtilSparseArray.size())
    {
      if (this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i2) == paramInt) {}
      for (;;)
      {
        i2 += 1;
        break;
        ((TextView)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(i2)).setTextColor(getResources().getColor(2131167225));
      }
    }
  }
  
  private void c(String paramString)
  {
    if (paramString.equals(Contacts.class.getName())) {
      e();
    }
    label91:
    do
    {
      do
      {
        anun localanun;
        do
        {
          return;
          if (!paramString.equals(Leba.class.getName())) {
            break;
          }
          localanun = b();
        } while (!(localanun instanceof Leba));
        paramString = (RedTouch)this.jdField_a_of_type_JavaUtilHashMap.get(jdField_c_of_type_JavaLangString);
        if ((paramString != null) && (paramString.c()))
        {
          bool = true;
          if (paramString != null) {
            break label91;
          }
        }
        for (paramString = null;; paramString = paramString.a())
        {
          ((Leba)localanun).a(bool, paramString);
          return;
          bool = false;
          break;
        }
        if (!paramString.equals(QzoneFrame.class.getName())) {
          break;
        }
        paramString = b();
      } while (!(paramString instanceof QzoneFrame));
      boolean bool = e();
      ((QzoneFrame)paramString).a(bool);
      return;
    } while (!paramString.equals(Now.class.getName()));
    ykv.a("story_tab", "clk", 0, ((ntq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).b(), new String[0]);
  }
  
  private boolean c()
  {
    return this.jdField_l_of_type_Boolean;
  }
  
  private String d()
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
        return jdField_a_of_type_JavaLangString;
      }
      if (str2.equals(Contacts.class.getName())) {
        return jdField_b_of_type_JavaLangString;
      }
      if (str2.equals(Leba.class.getName())) {
        return jdField_c_of_type_JavaLangString;
      }
      if (str2.equals(Now.class.getName())) {
        return "NOW";
      }
      localObject = str1;
    } while (!str2.equals(QzoneFrame.class.getName()));
    return "动态";
  }
  
  private void d(int paramInt)
  {
    DragTextView localDragTextView = (DragTextView)this.jdField_a_of_type_JavaUtilHashMap.get(jdField_a_of_type_JavaLangString + "_num");
    if (paramInt == jdField_b_of_type_Int)
    {
      localDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      localDragTextView.setDragViewType(2);
      TabDragAnimationView localTabDragAnimationView1 = (TabDragAnimationView)this.jdField_a_of_type_AndroidUtilSparseArray.get(jdField_b_of_type_Int);
      this.jdField_a_of_type_Alji.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView = localTabDragAnimationView1;
      if (localTabDragAnimationView1 != null) {
        if (QLog.isColorLevel()) {
          QLog.d("DynimiIcon", 2, "onTabChanged ConversationTab");
        }
      }
      try
      {
        localTabDragAnimationView1.setOnDoubleTapListener(this.jdField_a_of_type_Ajzp);
        this.jdField_a_of_type_Alji.jdField_a_of_type_AndroidViewView = localDragTextView;
        return;
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          QLog.e("DynimiIcon", 2, localThrowable1, new Object[0]);
        }
      }
    }
    try
    {
      TabDragAnimationView localTabDragAnimationView2 = (TabDragAnimationView)this.jdField_a_of_type_AndroidUtilSparseArray.get(jdField_b_of_type_Int);
      if (localTabDragAnimationView2 != null) {
        localTabDragAnimationView2.setOnDoubleTapListener(null);
      }
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        QLog.e("DynimiIcon", 2, localThrowable2, new Object[0]);
      }
    }
    localDragTextView.setOnModeChangeListener(null);
  }
  
  private boolean d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost == null) {
      return false;
    }
    if (a() == jdField_g_of_type_Int) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.redPointclearStoryRedPointIfNeeded", 2, "当前是nowtab的话，清理红点==>isCurrentTabNowTab:" + bool);
      }
      if ((!bool) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
        break;
      }
      oidb_0x791.RedDotInfo localRedDotInfo = ((ntq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).a();
      if ((localRedDotInfo != null) && (localRedDotInfo.uint32_appid.get() == 52)) {
        break;
      }
      a(37, null);
      return true;
    }
  }
  
  private void e(int paramInt)
  {
    QLog.d("MainFragment", 2, "update kandian tab, type : " + paramInt);
    if (paramInt == 0) {
      f(false);
    }
    ReadInjoyTabDragAnimationView localReadInjoyTabDragAnimationView;
    do
    {
      do
      {
        return;
      } while (!(this.jdField_a_of_type_AndroidUtilSparseArray.get(jdField_h_of_type_Int) instanceof ReadInjoyTabDragAnimationView));
      localReadInjoyTabDragAnimationView = (ReadInjoyTabDragAnimationView)this.jdField_a_of_type_AndroidUtilSparseArray.get(jdField_h_of_type_Int);
      TextView localTextView = (TextView)this.jdField_b_of_type_AndroidUtilSparseArray.get(jdField_h_of_type_Int);
      if ((localReadInjoyTabDragAnimationView == null) || (localTextView == null))
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
  
  private boolean e()
  {
    RedTouch localRedTouch = (RedTouch)this.jdField_a_of_type_JavaUtilHashMap.get(jdField_c_of_type_JavaLangString);
    if (localRedTouch == null) {
      return false;
    }
    return localRedTouch.c();
  }
  
  private void f(int paramInt)
  {
    int i1 = 0;
    if ((!this.jdField_l_of_type_Boolean) || (this.jdField_a_of_type_AndroidUtilSparseArray == null))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("mIsDefaultTheme = ").append(this.jdField_l_of_type_Boolean).append(", mTabDragIcon is null ");
        if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
          break label78;
        }
      }
      label78:
      for (boolean bool = true;; bool = false)
      {
        QLog.d("DynimiIcon", 2, bool);
        return;
      }
    }
    Object localObject = (TabDragAnimationView)this.jdField_a_of_type_AndroidUtilSparseArray.get(jdField_b_of_type_Int);
    if (g())
    {
      i1 = jdField_a_of_type_ArrayOfInt.length - 1;
      jdField_m_of_type_Int = i1;
      paramInt = 3;
    }
    for (;;)
    {
      ((TabDragAnimationView)localObject).setBgPressedDrawable(jdField_a_of_type_ArrayOfInt[i1]);
      ((TabDragAnimationView)localObject).setBgDrawable(jdField_b_of_type_ArrayOfInt[paramInt]);
      return;
      if (paramInt >= 30)
      {
        jdField_m_of_type_Int = 5;
        i1 = 5;
        paramInt = 2;
      }
      else
      {
        jdField_m_of_type_Int = 0;
        int i2 = 0;
        paramInt = i1;
        i1 = i2;
      }
    }
  }
  
  private void f(boolean paramBoolean)
  {
    boolean bool3 = bmhv.l();
    boolean bool1;
    if (this.n != bool3)
    {
      bool1 = true;
      if (this.jdField_e_of_type_Boolean == bdfk.a()) {
        break label172;
      }
    }
    int i1;
    label172:
    for (boolean bool2 = true;; bool2 = false)
    {
      this.jdField_e_of_type_Boolean = bdfk.a();
      if (!a(paramBoolean, bool1, bool2)) {
        break label714;
      }
      nyv.jdField_c_of_type_Boolean = false;
      pip.a(true);
      ajzy.jdField_a_of_type_Int |= 0x2;
      if (QLog.isColorLevel()) {
        QLog.i("MainFragment", 2, "setFrames" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isCallTabShow);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.clearAllTabs();
      }
      int i2 = this.jdField_a_of_type_ArrayOfAndroidViewView.length;
      i1 = 0;
      while (i1 < i2)
      {
        localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[i1];
        if (localObject != null)
        {
          ((View)localObject).setSelected(false);
          ((View)localObject).setId(i1 + 16);
        }
        i1 += 1;
      }
      bool1 = false;
      break;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isCallTabShow, -100, bool3);
    z();
    Object localObject = a(Conversation.class);
    if (localObject != null) {
      ((Conversation)localObject).h(true);
    }
    this.jdField_a_of_type_ArrayOfAndroidViewView[1] = null;
    C();
    a(this.jdField_a_of_type_AndroidViewView, Conversation.class, this.jdField_a_of_type_ArrayOfAndroidViewView[0]);
    a(this.jdField_a_of_type_AndroidViewView, Contacts.class, this.jdField_a_of_type_ArrayOfAndroidViewView[2]);
    if (bool3)
    {
      if (this.jdField_a_of_type_ArrayOfAndroidViewView[6] == null) {
        A();
      }
      this.jdField_a_of_type_ArrayOfAndroidViewView[6].setId(22);
      localObject = (TabDragAnimationView)this.jdField_a_of_type_ArrayOfAndroidViewView[6].findViewById(2131378414);
      TextView localTextView = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[6].findViewById(2131380194);
      if ((localTextView != null) && (localObject != null))
      {
        ((TabDragAnimationView)localObject).setOnTouchListener(new ajzr(null));
        ((TabDragAnimationView)localObject).setPressChanged(false);
        localTextView.setTextColor(getResources().getColor(2131167225));
        ((TabDragAnimationView)localObject).a(getResources().getString(2131696135));
        this.jdField_a_of_type_AndroidUtilSparseArray.put(jdField_h_of_type_Int, localObject);
        this.jdField_b_of_type_AndroidUtilSparseArray.put(jdField_h_of_type_Int, localTextView);
        a(this.jdField_a_of_type_AndroidViewView, ReadinjoyTabFrame.class, this.jdField_a_of_type_ArrayOfAndroidViewView[6]);
        this.n = true;
      }
      e(3);
      if (!jdField_a_of_type_Boolean) {
        B();
      }
      if (this.jdField_b_of_type_AndroidContentIntent != null)
      {
        localObject = this.jdField_b_of_type_AndroidContentIntent.getExtras();
        if (localObject != null)
        {
          i1 = ((Bundle)localObject).getInt("tab_index");
          if (i1 == 2) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setCurrentTab(i1);
          }
        }
        this.jdField_b_of_type_AndroidContentIntent = null;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfAndroidViewView[3]);
      this.jdField_a_of_type_JavaUtilHashMap.put(jdField_c_of_type_JavaLangString + "_num", this.jdField_a_of_type_ArrayOfAndroidViewView[3].findViewById(2131380453));
      if (!QZoneApiProxy.needShowQzoneFrame(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label750;
      }
      this.o = true;
      a(Leba.class);
      a(this.jdField_a_of_type_AndroidViewView, QzoneFrame.class, this.jdField_a_of_type_ArrayOfAndroidViewView[7]);
      this.jdField_a_of_type_JavaUtilHashMap.put("动态", this.jdField_a_of_type_ArrayOfAndroidViewView[7]);
      this.jdField_a_of_type_JavaUtilHashMap.put("动态_num", this.jdField_a_of_type_ArrayOfAndroidViewView[7].findViewById(2131380453));
      localObject = (TabDragAnimationView)this.jdField_a_of_type_ArrayOfAndroidViewView[7].findViewById(2131378414);
      localTextView = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[7].findViewById(2131380194);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(jdField_j_of_type_Int, localObject);
      this.jdField_b_of_type_AndroidUtilSparseArray.put(jdField_j_of_type_Int, localTextView);
    }
    for (;;)
    {
      pip.a(false);
      g(false);
      label714:
      return;
      a(ReadinjoyTabFrame.class);
      this.jdField_a_of_type_AndroidUtilSparseArray.remove(jdField_h_of_type_Int);
      this.jdField_b_of_type_AndroidUtilSparseArray.remove(jdField_h_of_type_Int);
      this.n = false;
      break;
      label750:
      if (QZoneApiProxy.isQzoneInstalled()) {
        this.o = true;
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.remove(jdField_j_of_type_Int);
      this.jdField_b_of_type_AndroidUtilSparseArray.remove(jdField_j_of_type_Int);
      a(QzoneFrame.class);
      a(this.jdField_a_of_type_AndroidViewView, Leba.class, this.jdField_a_of_type_ArrayOfAndroidViewView[3]);
    }
  }
  
  private static boolean f()
  {
    String str = ThemeUtil.getCurrentThemeId();
    return ("1000".equals(str)) || ("999".equals(str));
  }
  
  private void g(boolean paramBoolean)
  {
    int i4 = 0;
    this.jdField_l_of_type_Boolean = f();
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "checkEnableTabAnim() called with: onPostThemeChanged = [" + paramBoolean + "], mIsDefaultTheme=[" + this.jdField_l_of_type_Boolean + "]");
    }
    float f1 = getResources().getDisplayMetrics().density;
    int i1;
    int i5;
    Object localObject1;
    int i2;
    if (this.jdField_l_of_type_Boolean)
    {
      i1 = Math.round(54.0F * f1);
      i5 = Math.round(6.0F * f1);
      if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
        break label378;
      }
      if (!this.jdField_l_of_type_Boolean) {
        break label322;
      }
      localObject1 = (Conversation)a(Conversation.class);
      if (localObject1 == null) {
        break label316;
      }
      i2 = ((Conversation)localObject1).jdField_d_of_type_Int;
      label137:
      f(i2);
      label143:
      boolean bool = ThemeUtil.isNowThemeIsAnimate();
      i2 = 0;
      label151:
      if (i2 >= this.jdField_a_of_type_AndroidUtilSparseArray.size()) {
        break label378;
      }
      localObject1 = (TabDragAnimationView)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i2);
      ((TabDragAnimationView)localObject1).jdField_c_of_type_Boolean = bool;
      ((TabDragAnimationView)localObject1).a = null;
      if (!this.jdField_l_of_type_Boolean) {
        break label360;
      }
      i3 = (int)(29.0F * f1 + 0.5F);
      label209:
      ((TabDragAnimationView)localObject1).setIconSize(i3, i3);
      ((TabDragAnimationView)localObject1).setAnimEnable(this.jdField_l_of_type_Boolean);
      if (!this.jdField_l_of_type_Boolean) {
        break label366;
      }
      i3 = 1;
      label237:
      ((TabDragAnimationView)localObject1).setIconGravity(i3);
      if (!this.jdField_l_of_type_Boolean) {
        break label372;
      }
    }
    Object localObject2;
    label316:
    label322:
    label360:
    label366:
    label372:
    for (int i3 = (int)(5.0F * f1 + 0.5F);; i3 = 0)
    {
      ((TabDragAnimationView)localObject1).setPadding(0, i3, 0, i3);
      localObject2 = new RelativeLayout.LayoutParams(((TabDragAnimationView)localObject1).getLayoutParams());
      ((RelativeLayout.LayoutParams)localObject2).height = i1;
      ((TabDragAnimationView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      i2 += 1;
      break label151;
      i1 = -2;
      break;
      i2 = 0;
      break label137;
      localObject1 = (TabDragAnimationView)this.jdField_a_of_type_AndroidUtilSparseArray.get(jdField_b_of_type_Int);
      ((TabDragAnimationView)localObject1).setBgPressedDrawable(jdField_a_of_type_ArrayOfInt[0]);
      ((TabDragAnimationView)localObject1).setBgDrawable(jdField_b_of_type_ArrayOfInt[0]);
      break label143;
      i3 = -1;
      break label209;
      i3 = 0;
      break label237;
    }
    label378:
    if (this.jdField_b_of_type_AndroidUtilSparseArray != null)
    {
      i2 = 0;
      if (i2 < this.jdField_b_of_type_AndroidUtilSparseArray.size())
      {
        localObject1 = (TextView)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(i2);
        if (this.jdField_l_of_type_Boolean)
        {
          ((TextView)localObject1).setVisibility(0);
          localObject2 = (RelativeLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).bottomMargin = i5;
          ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        for (;;)
        {
          i2 += 1;
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
        ((ViewGroup.LayoutParams)localObject2).height = i1;
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      if ((!paramBoolean) && (this.jdField_l_of_type_Boolean))
      {
        long l1 = System.currentTimeMillis();
        localObject2 = this.jdField_a_of_type_AndroidViewView.findViewById(16908305);
        if ((localObject1 != null) && (localObject2 != null))
        {
          i2 = ((View)localObject2).getPaddingBottom();
          if (((i1 <= 0) || (i2 == i1)) || (QLog.isColorLevel())) {
            QLog.d("MainFragment", 2, "checkEnableTabAnim, height=" + i1 + ", padding=" + i2 + ", cost=" + (System.currentTimeMillis() - l1));
          }
        }
      }
      localObject2 = this.jdField_a_of_type_AndroidViewView.findViewById(16908305);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380664));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setDebugTag("TAB");
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c();
      if (c())
      {
        a((View)localObject1, (View)localObject2);
        i1 = i4;
      }
      while (i1 < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        localObject1 = (TabDragAnimationView)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i1);
        ((TabDragAnimationView)localObject1).setEnableClickScaleAnimation(true);
        ((TabDragAnimationView)localObject1).setClickAnimationDrawable(null);
        i1 += 1;
        continue;
        a((View)localObject1);
        i1 = i4;
      }
      a(jdField_b_of_type_Int, 2130850540, 2130850541);
      a(jdField_d_of_type_Int, 2130850538, 2130850539);
      a(jdField_h_of_type_Int, 2130843303, 2130843304);
      a(jdField_e_of_type_Int, -1, 2130850543);
    }
  }
  
  private boolean g()
  {
    acmx localacmx = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    if ((localacmx != null) && (algs.a().a.size() > 0))
    {
      Object localObject = new ArrayList(algs.a().a);
      if (((List)localObject).size() > 0)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          RecentBaseData localRecentBaseData = (RecentBaseData)((Iterator)localObject).next();
          if (localRecentBaseData != null)
          {
            if ((localRecentBaseData.mUnreadFlag == 1) || (localRecentBaseData.mUnreadFlag == 4)) {}
            for (int i1 = 1; (i1 != 0) && (localacmx.a(localRecentBaseData)); i1 = 0) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }
  
  private void w()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new MainFragment.3(this), 1000L);
  }
  
  private void x()
  {
    try
    {
      Intent localIntent = getActivity().getIntent();
      if (localIntent != null) {
        localIntent.putExtra("current_tab_tag", a());
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MainFragment", 1, "setCurrentIntentParams", localException);
    }
  }
  
  private void y()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "showActionSheet");
    }
    f();
    ArrayList localArrayList = new ArrayList();
    Object localObject = new ajzs();
    ((ajzs)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131719904);
    localArrayList.add(new Pair(Integer.valueOf(2131372345), localObject));
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAboutConfig().a("com.tencent.Feedback_5_8");
    if ((localObject != null) && (((ResourcePluginInfo)localObject).cLocalState != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "feedback plugin is add overmenu");
      }
      ajzs localajzs = new ajzs();
      localajzs.jdField_a_of_type_JavaLangString = ((ResourcePluginInfo)localObject).strResName;
      localajzs.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo = ((ResourcePluginInfo)localObject);
      localArrayList.add(new Pair(Integer.valueOf(2131372344), localajzs));
    }
    localObject = new ajzs();
    ((ajzs)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131693776);
    localArrayList.add(new Pair(Integer.valueOf(2131372343), localObject));
    localObject = new ajzs();
    ((ajzs)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131690677);
    localArrayList.add(new Pair(Integer.valueOf(2131372342), localObject));
    localObject = bkzi.c(getActivity());
    int i1 = 0;
    if (i1 < localArrayList.size())
    {
      if (2131372342 == ((Integer)((Pair)localArrayList.get(i1)).first).intValue()) {
        ((bkzi)localObject).d(((ajzs)((Pair)localArrayList.get(i1)).second).jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        i1 += 1;
        break;
        ((bkzi)localObject).c(((ajzs)((Pair)localArrayList.get(i1)).second).jdField_a_of_type_JavaLangString);
      }
    }
    ((bkzi)localObject).a(new ajzm(this, localArrayList, (bkzi)localObject));
    ((bkzi)localObject).setOnDismissListener(new ajzn(this));
    ((bkzi)localObject).setCanceledOnTouchOutside(true);
    this.jdField_b_of_type_AndroidAppDialog = ((Dialog)localObject);
    try
    {
      this.jdField_b_of_type_AndroidAppDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void z()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(3);
    this.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray(3);
    ajzr localajzr = new ajzr(null);
    TabDragAnimationView localTabDragAnimationView = (TabDragAnimationView)this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131378414);
    localTabDragAnimationView.setOnTouchListener(localajzr);
    localTabDragAnimationView.a("消息");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(jdField_b_of_type_Int, localTabDragAnimationView);
    localTabDragAnimationView = (TabDragAnimationView)this.jdField_a_of_type_ArrayOfAndroidViewView[2].findViewById(2131378414);
    localTabDragAnimationView.setOnTouchListener(localajzr);
    localTabDragAnimationView.setExpectedLogoMoveDistance(ViewUtils.dpToPx(2.0F));
    localTabDragAnimationView.a("联系人");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(jdField_d_of_type_Int, localTabDragAnimationView);
    localTabDragAnimationView = (TabDragAnimationView)this.jdField_a_of_type_ArrayOfAndroidViewView[3].findViewById(2131378414);
    localTabDragAnimationView.setOnTouchListener(localajzr);
    localTabDragAnimationView.a("动态");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(jdField_e_of_type_Int, localTabDragAnimationView);
    this.jdField_b_of_type_AndroidUtilSparseArray.put(jdField_b_of_type_Int, (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131380194));
    this.jdField_b_of_type_AndroidUtilSparseArray.put(jdField_d_of_type_Int, (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[2].findViewById(2131380194));
    this.jdField_b_of_type_AndroidUtilSparseArray.put(jdField_e_of_type_Int, (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[3].findViewById(2131380194));
  }
  
  public int a()
  {
    int i1 = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost != null) {
      i1 = this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.getCurrentTab();
    }
    while (!QLog.isColorLevel()) {
      return i1;
    }
    QLog.e("MainFragment", 2, "getCurrentTab");
    return 0;
  }
  
  public Dialog a(String paramString1, String paramString2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    ReportDialog localReportDialog = new ReportDialog(getActivity(), 2131755829);
    localReportDialog.setContentView(2131559182);
    TextView localTextView = (TextView)localReportDialog.findViewById(2131365648);
    if (localTextView != null)
    {
      if (paramString1 == null) {
        localTextView.setVisibility(8);
      }
    }
    else
    {
      paramString1 = (TextView)localReportDialog.findViewById(2131365644);
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
      paramString1 = (TextView)localReportDialog.findViewById(2131365633);
      if (paramString1 != null) {
        paramString1.setText(2131690697);
      }
      paramString1 = (TextView)localReportDialog.findViewById(2131365639);
      if (paramString1 != null) {
        paramString1.setText(2131694399);
      }
      localReportDialog.setOnDismissListener(paramOnDismissListener);
      return localReportDialog;
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
  
  public String a()
  {
    if (b()) {
      return getString(2131690499);
    }
    return super.a();
  }
  
  public HashMap<String, View> a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public void a()
  {
    if (getActivity() != null)
    {
      View localView = getActivity().findViewById(2131377958);
      if (localView != null)
      {
        ViewParent localViewParent = localView.getParent();
        if (localViewParent != null) {
          ((ViewGroup)localViewParent).removeView(localView);
        }
      }
    }
    SetSplash.a();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setCurrentTab(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    if (this.jdField_a_of_type_ArrayOfAndroidViewView == null) {}
    boolean bool;
    String str1;
    Object localObject;
    label56:
    String str2;
    TextView localTextView;
    do
    {
      return;
      bool = false;
      str1 = "";
      switch (paramInt1)
      {
      default: 
        localObject = "";
        str2 = a(paramInt2, (String)localObject);
        localTextView = (TextView)this.jdField_a_of_type_JavaUtilHashMap.get((String)localObject + "_num");
      }
    } while ((localTextView == null) || (str2 == null));
    int i1;
    if ((paramObject instanceof Integer)) {
      i1 = ((Integer)paramObject).intValue();
    }
    for (;;)
    {
      label124:
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
      label210:
      int i3;
      if (str2.equals((String)localObject + "_num"))
      {
        localSharedPreferences.edit().putInt(str2 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), i1).commit();
        this.jdField_b_of_type_JavaUtilHashMap.put(str2, paramObject);
        i3 = c((String)localObject);
        if (i3 != 3) {
          break label706;
        }
        paramObject = this.jdField_b_of_type_JavaUtilHashMap.get((String)localObject + "_num");
        if (!(paramObject instanceof Integer)) {
          break label837;
        }
        i1 = ((Integer)paramObject).intValue();
        paramObject = str1;
      }
      for (;;)
      {
        label283:
        int i4 = 0;
        int i2;
        label332:
        int i6;
        int i5;
        if (paramInt1 == 32) {
          if ((i1 > 99) && (!bdfk.b()))
          {
            i4 = getResources().getDimensionPixelSize(2131297326);
            if (this.jdField_l_of_type_Boolean)
            {
              i2 = ViewUtils.dpToPx(7.0F);
              i6 = 4;
              i3 = 2130850436;
              i5 = i2;
              i2 = i6;
              i6 = i4;
              localObject = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
              if (localObject != null)
              {
                ((RelativeLayout.LayoutParams)localObject).setMargins(i5, i6, 0, 0);
                localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
              }
              if (g()) {
                this.jdField_f_of_type_Boolean = false;
              }
              if (!this.jdField_f_of_type_Boolean) {
                f(i1);
              }
            }
          }
        }
        for (;;)
        {
          if (QLog.isDevelopLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("updateMain, [").append("tabIndex = ").append(paramInt1).append(",").append("type = ").append(paramInt2).append(",").append("style = ").append(i2).append(",").append("num = ").append(i1).append(",").append("isVisable = ").append(bool).append(",").append("tv = ").append(localTextView.toString()).append(" ]");
            QLog.d("MainFragment", 4, ((StringBuilder)localObject).toString());
          }
          blas.a(localTextView, i2, i1, i3, 99, paramObject);
          if (!AppSetting.jdField_c_of_type_Boolean) {
            break;
          }
          a(jdField_a_of_type_JavaLangString, d());
          a(jdField_b_of_type_JavaLangString, d());
          a(jdField_c_of_type_JavaLangString, d());
          a("NOW", d());
          return;
          localObject = jdField_a_of_type_JavaLangString;
          break label56;
          localObject = jdField_b_of_type_JavaLangString;
          break label56;
          e(paramInt2);
          return;
          if (!(paramObject instanceof Boolean)) {
            break label846;
          }
          bool = ((Boolean)paramObject).booleanValue();
          i1 = 0;
          break label124;
          localSharedPreferences.edit().putBoolean(str2 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), bool).commit();
          break label210;
          label706:
          if (i3 != 5) {
            break label837;
          }
          paramObject = this.jdField_b_of_type_JavaUtilHashMap.get((String)localObject + "_text");
          if (!(paramObject instanceof String)) {
            break label837;
          }
          paramObject = (String)paramObject;
          i1 = 0;
          break label283;
          i2 = ViewUtils.dpToPx(5.0F);
          break label332;
          i6 = getResources().getDimensionPixelSize(2131297325);
          if (this.jdField_l_of_type_Boolean) {}
          for (i2 = ViewUtils.dpToPx(7.0F);; i2 = ViewUtils.dpToPx(5.0F))
          {
            i4 = i3;
            i3 = 0;
            i5 = i2;
            i2 = i4;
            break;
          }
          i2 = i3;
          i3 = i4;
        }
        label837:
        i1 = 0;
        paramObject = str1;
      }
      label846:
      i1 = 0;
    }
  }
  
  public void a(int paramInt, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      return;
    }
    bbbq localbbbq = (bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
    switch (paramInt)
    {
    case 36: 
    case 38: 
    default: 
      return;
    case 33: 
      a(paramInt, (RedTouch)this.jdField_a_of_type_JavaUtilHashMap.get(jdField_b_of_type_JavaLangString), paramRedTypeInfo);
      return;
    case 34: 
      a(paramInt, (RedTouch)this.jdField_a_of_type_JavaUtilHashMap.get(jdField_c_of_type_JavaLangString), paramRedTypeInfo);
      localbbbq.b(0, 30);
      return;
    case 37: 
      a(paramInt, (RedTouch)this.jdField_a_of_type_JavaUtilHashMap.get("NOW"), paramRedTypeInfo);
      return;
    case 35: 
      if ((this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) && (this.jdField_a_of_type_AndroidWidgetImageView != null)) {
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(getActivity(), this.jdField_a_of_type_AndroidWidgetImageView).b(53).a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(paramRedTypeInfo);
      }
      localbbbq.b(1, 30);
      return;
    }
    B();
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_b_of_type_AndroidContentIntent = paramIntent;
    Object localObject;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("onNewIntent ");
      if (this.jdField_a_of_type_Akam == null)
      {
        bool = true;
        QLog.d("MainFragment", 2, bool);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("CampusNoticeManager", 1, "doOnNewIntent1 : url" + paramIntent.getStringExtra("url"));
      }
      q = false;
      if (this.jdField_a_of_type_Akam != null) {
        break label107;
      }
    }
    label107:
    int i1;
    do
    {
      do
      {
        return;
        bool = false;
        break;
        aldh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent);
        localObject = paramIntent.getExtras();
      } while (localObject == null);
      if (((Bundle)localObject).getBoolean("EXIT", false))
      {
        getActivity().finish();
        return;
      }
      i1 = -1;
      if (!((Bundle)localObject).containsKey("tab_index")) {
        break label265;
      }
      i1 = ((Bundle)localObject).getInt("tab_index");
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "onNewIntent tabIndex: " + i1);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost == null) || (i1 < 0)) {
        break label305;
      }
    } while ((a((Bundle)localObject, i1)) || (a(i1)));
    if (i1 < this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.getTabWidget().getChildCount())
    {
      a((Bundle)localObject, i1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setCurrentTab(i1);
    }
    for (;;)
    {
      b(paramIntent);
      return;
      label265:
      if (!((Bundle)localObject).containsKey("main_tab_id")) {
        break;
      }
      i1 = a((Bundle)localObject);
      break;
      if (i1 == jdField_j_of_type_Int)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setCurrentTab(jdField_e_of_type_Int);
        continue;
        label305:
        if ((i1 == jdField_i_of_type_Int) && (bmhv.n()))
        {
          this.jdField_a_of_type_AndroidContentIntent = paramIntent;
          QLog.d("MainFragment", 1, "MainActivity:onNewIntent mTabHost, jump kandian tab fail, set pengingIntent");
        }
        if (QLog.isColorLevel()) {
          QLog.d("MainFragment", 2, "MainActivity:onNewIntent mTabHost is null");
        }
      }
    }
  }
  
  public void a(String paramString) {}
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "MainActivity:onLogout");
    }
    bhhr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), "");
    if (awtz.a().d()) {
      awtz.a().a(false);
    }
    awtz.a().d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    awth.a().a(1);
    this.jdField_m_of_type_Boolean = true;
    aoyj.a();
    UserguideActivity.a();
    ThreadManager.getUIHandler().post(new MainFragment.16(this));
    super.a(paramLogoutReason);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    x();
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (paramInt == 82)
    {
      y();
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
      if ((paramKeyEvent != null) && ((paramKeyEvent instanceof PendingIntent)) && (!getActivity().getIntent().getBooleanExtra("share_from_aio", false))) {
        if (QLog.isColorLevel()) {
          QLog.d("MainFragment", 2, "-->finish--send callback using PendingIntent");
        }
      }
      try
      {
        paramKeyEvent.send();
        getActivity().moveTaskToBack(true);
      }
      catch (PendingIntent.CanceledException paramKeyEvent)
      {
        for (;;)
        {
          QLog.e("MainFragment", 2, "failed to send PendingIntent", paramKeyEvent);
        }
      }
      return true;
    }
    catch (Throwable paramKeyEvent)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MainFragment", 2, "", paramKeyEvent);
      }
    }
  }
  
  public String b()
  {
    return this.jdField_h_of_type_JavaLangString;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "onDrawComplete[" + d() + "]");
    }
    super.b();
    Object localObject = b();
    if (localObject != null) {
      ((anun)localObject).p();
    }
    if (jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Akam.c();
      jdField_a_of_type_Boolean = false;
      ThreadManager.getUIHandler().postDelayed(new MainFragment.4(this), 2000L);
    }
    bhhy.a("Main_Start", null);
    localObject = d();
    if (jdField_a_of_type_JavaLangString.equals(localObject)) {}
    try
    {
      amwn.a(getActivity(), (Conversation)a(Conversation.class));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MainFragment", 2, "show cmgame app pop error e=" + localThrowable.toString());
    }
  }
  
  public String c()
  {
    if ((a() == jdField_b_of_type_Int) && ((b() instanceof Conversation)) && (((Conversation)c()).jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.a())) {
      return "QQSettingMe";
    }
    return b();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "onAccountChanged");
    }
    q = false;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    super.c();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    com.tencent.mobileqq.app.FriendListHandler.getSpecialRecommendStat = -1;
    this.jdField_k_of_type_Boolean = false;
    ThreadManager.post(new MainFragment.5(this), 2, null, true);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_Akam != null))
    {
      this.jdField_a_of_type_Akam.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Akam.a();
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "onAccountChange.check.new....");
      }
      if ((!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) && (this.jdField_f_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()))) {}
    }
    try
    {
      QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
      localQQNotificationManager.cancel("MainFragment", 241);
      localQQNotificationManager.cancel("MainFragment", 243);
      bcvr localbcvr = (bcvr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER);
      if (localbcvr != null) {
        localbcvr.a(1, 0);
      }
      localQQNotificationManager.cancel("MainFragment", 265);
      bkyy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
      localQQNotificationManager.cancel("MainFragment", 267);
      localQQNotificationManager.cancel("MainFragment", 274);
      localQQNotificationManager.cancel("MainFragment", 236);
      localQQNotificationManager.cancel("MainFragment", 271);
      localQQNotificationManager.cancel("MainFragment", 273);
      localQQNotificationManager.cancel("MainFragment", 239);
      localQQNotificationManager.cancel("MainFragment", 527);
    }
    catch (Exception localException2)
    {
      label273:
      break label273;
    }
    this.jdField_a_of_type_Akam.h();
    this.jdField_a_of_type_Akam.a(localQQAppInterface);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      ((aoay)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER)).a(this.jdField_a_of_type_Aoba);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Auly);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Azbd);
    }
    if (this.jdField_a_of_type_Ayzg != null) {
      this.jdField_a_of_type_Ayzg.k();
    }
    for (;;)
    {
      if ((this.jdField_m_of_type_Boolean) || ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ArrayOfAndroidViewView != null) && (this.jdField_a_of_type_JavaUtilHashMap != null))) {}
      try
      {
        f(false);
        aoyj.a();
        if (this.jdField_a_of_type_Akam != null) {
          this.jdField_a_of_type_Akam.jdField_d_of_type_Boolean = false;
        }
        getActivity().getIntent().removeExtra("if_check_account_same");
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        }
        UserguideActivity.a();
        bhql.a(true);
        return;
        this.jdField_m_of_type_Boolean = false;
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
  
  public void d()
  {
    if (this.jdField_a_of_type_Ayzg != null) {
      this.jdField_a_of_type_Ayzg.l();
    }
  }
  
  void e()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new MainFragment.6(this), 500L);
  }
  
  public void f()
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
  
  void g()
  {
    h();
    Dialog localDialog = a("你确定退出QQ？", null, new ajze(this));
    Object localObject = (TextView)localDialog.findViewById(2131365639);
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new ajzf(this, localDialog));
    }
    localObject = (TextView)localDialog.findViewById(2131365633);
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new ajzg(this));
    }
    localObject = getString(2131717979);
    boolean bool = SettingCloneUtil.isContainValue(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (String)localObject, "qqsetting_receivemsg_whenexit_key");
    this.jdField_d_of_type_Boolean = SettingCloneUtil.readValue(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (String)localObject, "qqsetting_receivemsg_whenexit_key", true);
    localObject = (CheckBox)localDialog.findViewById(2131364596);
    if ((bool) && (this.jdField_d_of_type_Boolean)) {
      ((CheckBox)localObject).setVisibility(8);
    }
    ((CheckBox)localObject).setChecked(this.jdField_d_of_type_Boolean);
    this.jdField_a_of_type_AndroidAppDialog = localDialog;
    this.jdField_a_of_type_AndroidAppDialog.show();
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
  
  public void i()
  {
    super.i();
    if (this.jdField_e_of_type_Boolean != bdfk.a()) {}
    for (int i1 = 1;; i1 = 0)
    {
      if ((i1 != 0) && (this.jdField_a_of_type_ArrayOfAndroidViewView != null)) {
        f(false);
      }
      anun localanun = a(Conversation.class);
      if (localanun != null) {
        ((Conversation)localanun).c();
      }
      localanun = a(Contacts.class);
      if (localanun != null) {
        ((Contacts)localanun).c();
      }
      localanun = a(Leba.class);
      if (localanun != null) {
        ((Leba)localanun).n();
      }
      localanun = a(Now.class);
      if (localanun != null) {
        ((Now)localanun).c();
      }
      localanun = a(ReadinjoyTabFrame.class);
      if (localanun != null) {
        ((ReadinjoyTabFrame)localanun).d();
      }
      localanun = a(QzoneFrame.class);
      if (localanun != null) {
        ((QzoneFrame)localanun).j();
      }
      g(true);
      return;
    }
  }
  
  public void j()
  {
    Object localObject = a(Conversation.class);
    if ((localObject != null) && (((Conversation)localObject).c()))
    {
      localObject = (bibu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.VIP_GIF_MANAGER);
      if (localObject != null)
      {
        bibt localbibt = ((bibu)localObject).a();
        if ((localbibt != null) && (isResumed()) && (localbibt.d == 2L)) {
          ((bibu)localObject).a(localbibt, getActivity());
        }
      }
    }
  }
  
  public void k()
  {
    anun localanun = b();
    if (localanun != null) {
      localanun.D();
    }
  }
  
  public void l() {}
  
  protected void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DynimiIcon", 2, "revertConversationIconChange mPreResIndex = " + jdField_m_of_type_Int);
    }
    r = true;
    this.jdField_f_of_type_Boolean = false;
    Conversation localConversation = (Conversation)a(Conversation.class);
    if (localConversation != null) {}
    for (int i1 = localConversation.jdField_d_of_type_Int;; i1 = 0)
    {
      f(i1);
      return;
    }
  }
  
  public void n()
  {
    if (a() == jdField_b_of_type_Int)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DynimiIcon", 2, "onFragmentDrawerOpened");
      }
      m();
    }
  }
  
  public void o()
  {
    if (a() == jdField_b_of_type_Int)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DynimiIcon", 2, "onFragmentDrawerOpened");
      }
      m();
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "AutoMonitor_fragment MainFragment onAttach");
    }
    super.onAttach(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    this.jdField_a_of_type_Akam = new akam((SplashActivity)getActivity());
  }
  
  public Animation onCreateAnimation(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramInt2 == 0) {
      return null;
    }
    Object localObject = (Animation)jdField_c_of_type_AndroidUtilSparseArray.get(paramInt2);
    if (localObject == null)
    {
      if (paramInt2 == 2130772053)
      {
        localObject = new afvu();
        ((Animation)localObject).setDuration(getActivity().getResources().getInteger(2131427330));
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
    if (this.jdField_a_of_type_AndroidViewView == null) {
      if (SetSplash.c())
      {
        paramViewGroup.postDelayed(new MainFragment.1(this), 3000L);
        paramViewGroup = (SplashActivity)getActivity();
        if (paramViewGroup.jdField_a_of_type_ArrayOfAndroidViewView == null) {
          break label160;
        }
        this.jdField_a_of_type_AndroidViewView = paramViewGroup.jdField_a_of_type_ArrayOfAndroidViewView[0];
        label90:
        paramLayoutInflater = new MainFragment.2(this);
        if (!StartService.jdField_a_of_type_Boolean) {
          break label204;
        }
        paramLayoutInflater.run();
      }
    }
    for (;;)
    {
      paramLayoutInflater = getActivity().getIntent();
      if (paramLayoutInflater != null) {
        this.jdField_l_of_type_Int = paramLayoutInflater.getIntExtra("current_tab_tag", -1);
      }
      zzd.a().a();
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      a();
      break;
      label160:
      this.jdField_a_of_type_AndroidViewView = super.onCreateView(paramLayoutInflater, null, paramBundle);
      break label90;
      if (this.jdField_a_of_type_AndroidViewView.getParent() == null) {
        break label90;
      }
      ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.jdField_a_of_type_AndroidViewView);
      break label90;
      label204:
      ThreadManager.getSubThreadHandler().postDelayed(paramLayoutInflater, 2000L);
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "AutoMonitor_fragment MainFragment onDestroy");
    }
    super.onDestroy();
    jdField_c_of_type_AndroidUtilSparseArray.clear();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_Akam != null))
    {
      if (!this.jdField_j_of_type_Boolean)
      {
        this.jdField_a_of_type_Akam.b();
        this.jdField_j_of_type_Boolean = true;
      }
      this.jdField_a_of_type_Akam.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      ((aoay)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER)).a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Auly);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Azbd);
    }
    ScreenCapture.clearSnapCacheFile(getActivity());
    if (getActivity().isFinishing()) {}
    try
    {
      auht.a().c();
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "MainActivity.onDestory");
      }
      if (bjna.a()) {
        bjna.a().e();
      }
      TMAssistantDownloadManager.closeAllService(BaseApplication.getContext());
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject;
        localThrowable.printStackTrace();
        continue;
        boolean bool = false;
        continue;
        if (SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, "pcactive_config", false))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startPCActivePolling(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "exitApp");
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.exit(true);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.exit(false);
        }
      }
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
          break label303;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundStop = true;
        localObject = new Intent("mqq.intent.action.EXIT" + getActivity().getPackageName());
        getActivity().sendBroadcast((Intent)localObject);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c();
      }
      localObject = this.jdField_a_of_type_JavaLangRunnable;
      this.jdField_a_of_type_JavaLangRunnable = null;
      ThreadManager.getSubThreadHandler().removeCallbacks((Runnable)localObject);
    }
  }
  
  public void onDestroyView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "AutoMonitor_fragment MainFragment onDestroyView");
    }
    this.jdField_a_of_type_Akam.b();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      ((aoay)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER)).a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Auly);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Azbd);
    }
    this.jdField_j_of_type_Boolean = true;
    super.onDestroyView();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    QLog.d("MainFragment", 1, "onHiddenChanged" + paramBoolean);
    if (paramBoolean)
    {
      this.jdField_g_of_type_Boolean = true;
      onPause();
      onStop();
      this.jdField_g_of_type_Boolean = false;
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
    if ((SplashActivity.jdField_a_of_type_Int != 1) && (!this.jdField_g_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "onPause return");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "AutoMonitor_fragment MainFragment onPause");
    }
    if ((this.jdField_b_of_type_Long != 0L) && (this.jdField_h_of_type_JavaLangString != null) && (UnifiedMonitor.a().whetherReportThisTime(8))) {
      UnifiedMonitor.a().addEvent(8, this.jdField_h_of_type_JavaLangString, (int)(SystemClock.uptimeMillis() - this.jdField_b_of_type_Long), 0, null);
    }
    this.jdField_b_of_type_Long = 0L;
    f();
    alik.jdField_b_of_type_Boolean = false;
    if (DrawerFrame.jdField_a_of_type_Int == 2) {
      u();
    }
    FrameHelperActivity.c(false);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b();
    }
    akai.c();
    if (a() == jdField_b_of_type_Int) {
      m();
    }
    x();
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
    bhhy.a(null, "Main_OnResume");
    this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    FrameHelperActivity.c(true);
    if (DrawerFrame.jdField_a_of_type_Int > 0)
    {
      if ((DrawerFrame.jdField_a_of_type_Int == 3) && (QLog.isColorLevel())) {
        QLog.d("MainFragment", 2, String.format(Locale.getDefault(), "maybe back from campus notice cur tab: %d", new Object[] { Integer.valueOf(a()) }));
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
      if (localObject != null) {
        ((MqqHandler)localObject).removeMessages(1031);
      }
      u();
    }
    f(false);
    if (GuardManager.a != null) {
      GuardManager.a.b(6, null);
    }
    alik.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_AndroidContentIntent != null)
    {
      localObject = this.jdField_a_of_type_AndroidContentIntent;
      this.jdField_a_of_type_AndroidContentIntent = null;
      ((SplashActivity)getActivity()).b((Intent)localObject);
    }
    w();
    this.jdField_a_of_type_Akam.h();
    bhhy.a("Main_OnResume", null);
    Object localObject = (ntj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.GET_RED_POINT_EX_HANDLER);
    if ((localObject != null) && (((ntj)localObject).a()) && (QLog.isColorLevel())) {
      QLog.d("Q.qqstory.redPoint", 2, "MainFragment onResume, getRedPointInfo");
    }
    pwb.j();
    if (SplashActivity.jdField_c_of_type_Int != 0)
    {
      aczy.a().a(SplashActivity.jdField_c_of_type_Int);
      SplashActivity.jdField_c_of_type_Int = 0;
    }
    if (SplashActivity.jdField_a_of_type_Long != 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOExit", 2, "exit aio cost = " + (SystemClock.uptimeMillis() - SplashActivity.jdField_a_of_type_Long));
      }
      SplashActivity.jdField_a_of_type_Long = 0L;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
    }
    if (this.jdField_l_of_type_Int != -1)
    {
      a(this.jdField_l_of_type_Int);
      this.jdField_l_of_type_Int = -1;
    }
    q = false;
    this.jdField_a_of_type_Akam.b(getActivity().getIntent());
    auqo.a(getActivity(), getActivity().getIntent());
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
      if ((this.jdField_i_of_type_JavaLangString != null) && (this.jdField_i_of_type_JavaLangString.length() > 0) && ("pakage_from_h5".equalsIgnoreCase(this.jdField_j_of_type_JavaLangString)))
      {
        bheh localbheh = bhey.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_i_of_type_JavaLangString);
        localbheh.c(this.jdField_j_of_type_JavaLangString);
        localbheh.a();
        this.jdField_i_of_type_JavaLangString = null;
        this.jdField_j_of_type_JavaLangString = null;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mAutomator.b()) {
        D();
      }
      ((afpn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APP_GUIDE_TIPS_MANAGER)).e();
    } while (this.jdField_a_of_type_Akam == null);
    this.jdField_a_of_type_Akam.a(getActivity().getIntent());
  }
  
  public void onStop()
  {
    super.onStop();
    if ((SplashActivity.jdField_a_of_type_Int != 1) && (!this.jdField_g_of_type_Boolean))
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
      u();
    }
    tem.a().a(false);
  }
  
  public void onTabChanged(String paramString)
  {
    if ((this.jdField_b_of_type_Long != 0L) && (this.jdField_h_of_type_JavaLangString != null) && (UnifiedMonitor.a().whetherReportThisTime(8))) {
      UnifiedMonitor.a().addEvent(8, this.jdField_h_of_type_JavaLangString, (int)(SystemClock.uptimeMillis() - this.jdField_b_of_type_Long), 0, null);
    }
    if (this.jdField_h_of_type_JavaLangString != null) {
      bdlm.a().b(this.jdField_h_of_type_JavaLangString);
    }
    String str = this.jdField_h_of_type_JavaLangString;
    this.jdField_h_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    bdlm.a().a(this.jdField_h_of_type_JavaLangString);
    anun localanun = a();
    int i1 = b(str);
    super.onTabChanged(paramString);
    if (i1 == jdField_b_of_type_Int) {
      m();
    }
    alik.jdField_b_of_type_Boolean = true;
    int i2 = a(paramString);
    c(paramString);
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      e(false);
    }
    a(i1, i2);
    a(localanun, i2);
    d(i2);
    this.jdField_l_of_type_Boolean = f();
    c(i2);
    if (this.jdField_a_of_type_MqqOsMqqHandler == null) {
      this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler();
    }
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new MainFragment.7(this, i2), 100L);
    d();
    if ((ReadinjoyTabFrame.class.getName().equals(this.jdField_h_of_type_JavaLangString)) || (QzoneFrame.class.getName().equals(this.jdField_h_of_type_JavaLangString))) {
      b(8);
    }
    for (;;)
    {
      a(localanun);
      return;
      b(0);
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
      f(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setOnDrawCompleteListener(this);
    }
  }
  
  public void p()
  {
    if (a() == jdField_b_of_type_Int)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DynimiIcon", 2, "onFragmentDrawerOpened");
      }
      m();
    }
    ThreadManager.getSubThreadHandler().post(new MainFragment.20(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.MainFragment
 * JD-Core Version:    0.7.0.1
 */