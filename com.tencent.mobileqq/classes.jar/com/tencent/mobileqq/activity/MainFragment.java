package com.tencent.mobileqq.activity;

import aabg;
import abms;
import abmt;
import abmu;
import abmv;
import abmw;
import abmx;
import abmy;
import abmz;
import abna;
import abnb;
import abnc;
import abnd;
import abne;
import abnf;
import abng;
import acto;
import aczh;
import agby;
import agcf;
import ahkd;
import ahnl;
import ahps;
import ajac;
import ajwk;
import ajya;
import akdq;
import akpc;
import aktp;
import akuz;
import amga;
import amoo;
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
import apdc;
import aqbz;
import asel;
import aseq;
import asfd;
import auhk;
import aumk;
import avet;
import awzy;
import axcj;
import axmv;
import axqs;
import axqt;
import axqy;
import axri;
import baww;
import bbeg;
import bbex;
import bbkb;
import bbkj;
import bbll;
import bbzt;
import bbzu;
import bcqk;
import bcql;
import bdle;
import bfnp;
import bfoi;
import bfpc;
import bfqs;
import bhby;
import bhvy;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyTabDragAnimationView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.fling.ScreenCapture;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchTab;
import com.tencent.mobileqq.startup.step.StartService;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.mobileqq.widget.QQTabWidget;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import mqq.app.Constants.LogoutReason;
import mqq.os.MqqHandler;
import mxn;
import mxu;
import oll;
import onh;
import osx;
import protocol.KQQConfig.UpgradeInfo;
import rig;
import shu;
import ssf;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;
import vei;
import wsu;

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
  private static SparseArray<Animation> c;
  public static final String c;
  public static boolean c;
  public static int d;
  public static final String d;
  public static int e;
  public static int f;
  public static int g;
  public static int h;
  public static int i;
  public static int j;
  private static int jdField_m_of_type_Int;
  private static boolean o;
  private static boolean p;
  private static boolean q = true;
  private abnd jdField_a_of_type_Abnd = new abnd(this);
  public agcf a;
  private ahps jdField_a_of_type_Ahps = new ahps(null);
  public Dialog a;
  public Intent a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Vibrator jdField_a_of_type_AndroidOsVibrator;
  private SparseArray<TabDragAnimationView> jdField_a_of_type_AndroidUtilSparseArray;
  private bcqk jdField_a_of_type_Bcqk = new abmx(this);
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QQBlurView jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new MainFragment.20(this);
  private HashMap<String, View> jdField_a_of_type_JavaUtilHashMap;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private View[] jdField_a_of_type_ArrayOfAndroidViewView;
  private long jdField_b_of_type_Long;
  private Dialog jdField_b_of_type_AndroidAppDialog;
  private SparseArray<TextView> jdField_b_of_type_AndroidUtilSparseArray;
  private HashMap<String, Object> jdField_b_of_type_JavaUtilHashMap;
  public boolean d;
  public String e;
  boolean e;
  boolean f;
  private String g;
  private String h;
  private String i;
  private String jdField_j_of_type_JavaLangString = "";
  private boolean jdField_j_of_type_Boolean = true;
  int jdField_k_of_type_Int = 3;
  private String jdField_k_of_type_JavaLangString = "";
  private boolean jdField_k_of_type_Boolean;
  private int jdField_l_of_type_Int = -1;
  private boolean jdField_l_of_type_Boolean = true;
  private boolean jdField_m_of_type_Boolean;
  private boolean n;
  
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
    jdField_a_of_type_JavaLangString = ajya.a(2131694070);
    jdField_b_of_type_JavaLangString = ajya.a(2131694069);
    jdField_c_of_type_JavaLangString = ajya.a(2131694071);
    jdField_d_of_type_JavaLangString = ajya.a(2131693701);
    jdField_a_of_type_Boolean = true;
    jdField_c_of_type_AndroidUtilSparseArray = new SparseArray(2);
    jdField_a_of_type_ArrayOfInt = new int[] { 2130849285, 2130840908, 2130840909, 2130840910, 2130840911, 2130840912, 2130840914, 2130840913 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130849284, 2130840915, 2130840916, 2130840917 };
  }
  
  public MainFragment()
  {
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
  }
  
  private void A()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(3);
    this.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray(3);
    abnf localabnf = new abnf(null);
    TabDragAnimationView localTabDragAnimationView = (TabDragAnimationView)this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131376810);
    localTabDragAnimationView.setOnTouchListener(localabnf);
    localTabDragAnimationView.a("消息");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(jdField_b_of_type_Int, localTabDragAnimationView);
    localTabDragAnimationView = (TabDragAnimationView)this.jdField_a_of_type_ArrayOfAndroidViewView[2].findViewById(2131376810);
    localTabDragAnimationView.setOnTouchListener(localabnf);
    localTabDragAnimationView.setExpectedLogoMoveDistance(bbll.b(2.0F));
    localTabDragAnimationView.a("联系人");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(jdField_d_of_type_Int, localTabDragAnimationView);
    localTabDragAnimationView = (TabDragAnimationView)this.jdField_a_of_type_ArrayOfAndroidViewView[3].findViewById(2131376810);
    localTabDragAnimationView.setOnTouchListener(localabnf);
    localTabDragAnimationView.a("动态");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(jdField_e_of_type_Int, localTabDragAnimationView);
    this.jdField_b_of_type_AndroidUtilSparseArray.put(jdField_b_of_type_Int, (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131378370));
    this.jdField_b_of_type_AndroidUtilSparseArray.put(jdField_d_of_type_Int, (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[2].findViewById(2131378370));
    this.jdField_b_of_type_AndroidUtilSparseArray.put(jdField_e_of_type_Int, (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[3].findViewById(2131378370));
  }
  
  private void B()
  {
    int i2 = -1;
    if (f()) {}
    for (int i1 = -1;; i1 = 2130842648)
    {
      View localView = oll.a(i1, 2130849290, i2, 2130849291, 2131694418, 16, 8);
      if (localView != null)
      {
        localView.setOnClickListener(new abmw(this));
        this.jdField_a_of_type_ArrayOfAndroidViewView[6] = new RedTouch(getActivity(), localView).a(49).d(3).b(5).a();
        this.jdField_a_of_type_JavaUtilHashMap.put(jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfAndroidViewView[6]);
        this.jdField_a_of_type_JavaUtilHashMap.put(jdField_d_of_type_JavaLangString + "_num", this.jdField_a_of_type_ArrayOfAndroidViewView[6].findViewById(2131378606));
        localView.setContentDescription(getResources().getString(2131694418));
      }
      return;
      i2 = 2130842649;
    }
  }
  
  private void C()
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
      KandianMergeManager localKandianMergeManager = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
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
      ((RedTouch)localObject2).setTag(2131374836, localObject1);
      a(39, (RedTouch)localObject2, (BusinessInfoCheckUpdate.RedTypeInfo)localObject1);
      if (((BaseActivity.sTopActivity instanceof SplashActivity)) && (isVisible()) && (onh.a(null)) && (localObject1 != null)) {
        onh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BusinessInfoCheckUpdate.RedTypeInfo)localObject1);
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
  
  private void D()
  {
    if (d()) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      localObject = (mxu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70);
    } while ((this.jdField_a_of_type_JavaUtilHashMap == null) || (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("NOW_num")));
    oidb_0x791.RedDotInfo localRedDotInfo = ((mxu)localObject).a();
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
        QLog.i("storyRedDotDebug", 2, "更新tab红点:" + mxu.a(localRedDotInfo));
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
  
  private void E()
  {
    bhvy.c();
    ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162)).o();
    if (bhvy.i())
    {
      Object localObject = (RedTouch)this.jdField_a_of_type_JavaUtilHashMap.get(jdField_d_of_type_JavaLangString);
      if (localObject != null)
      {
        localObject = (BusinessInfoCheckUpdate.RedTypeInfo)((RedTouch)localObject).getTag(2131374836);
        onh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BusinessInfoCheckUpdate.RedTypeInfo)localObject);
      }
      ThreadManager.executeOnSubThread(new MainFragment.18(this));
    }
  }
  
  private void F()
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
  
  private void G()
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
    }
    return jdField_j_of_type_Int;
  }
  
  private int a(String paramString)
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
        d();
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
  
  private static View a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if (BaseApplicationImpl.sApplication == null) {
      return null;
    }
    View localView = View.inflate(BaseApplicationImpl.sApplication, 2131562482, null);
    ((DragTextView)localView.findViewById(2131378606)).setDragViewType(2);
    ((TabDragAnimationView)localView.findViewById(2131376810)).setEmotionDrawable(paramInt1, paramInt2, paramInt3, paramInt4, paramInt6, paramInt7);
    ((TextView)localView.findViewById(2131378370)).setText(paramInt5);
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
  
  private void a(int paramInt, abng paramabng)
  {
    if (paramabng == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("MainFragment", 2, paramabng.jdField_a_of_type_JavaLangString + " is execute");
          }
          if (paramInt == 2131371172)
          {
            paramabng = this.jdField_a_of_type_Agcf.a();
            if ((paramabng == null) || (paramabng.a == null))
            {
              if (QLog.isColorLevel()) {
                QLog.w("MainFragment", 2, "mWrapper is null");
              }
              bcql.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 0, ajya.a(2131706430), 0).b(getResources().getDimensionPixelSize(2131298865));
            }
            for (;;)
            {
              axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80041C1", "0X80041C1", 0, 0, "", "", "", "");
              return;
              if (paramabng.a.iUpgradeType == 0) {
                bcql.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 0, ajya.a(2131706426), 0).b(getResources().getDimensionPixelSize(2131298865));
              } else if ((paramabng != null) && (paramabng.a != null)) {
                UpgradeDetailActivity.a(getActivity(), akuz.a().a(), false, false, true);
              }
            }
          }
          if (paramInt != 2131371170) {
            break;
          }
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80041C3", "0X80041C3", 0, 0, "", "", "", "");
        } while (!aumk.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity()));
        f();
        return;
        if (paramInt == 2131371169)
        {
          e();
          return;
        }
      } while (paramabng.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null);
      amoo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), paramabng.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo);
    } while (!"com.tencent.Feedback_5_8".equals(paramabng.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName));
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80041C2", "0X80041C2", 0, 0, "", "", "", "");
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
          this.jdField_j_of_type_JavaLangString = ajya.a(2131706427);
        }
        else
        {
          this.jdField_k_of_type_JavaLangString = ajya.a(2131706425);
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
                break label175;
              }
              this.jdField_j_of_type_JavaLangString = "多于99条更新";
            }
            catch (NumberFormatException localNumberFormatException)
            {
              localNumberFormatException.printStackTrace();
            }
            continue;
            label175:
            this.jdField_j_of_type_JavaLangString = (paramRedTypeInfo.red_content.get() + ajya.a(2131706429));
          }
          else
          {
            this.jdField_k_of_type_JavaLangString = (paramRedTypeInfo.red_content.get() + ajya.a(2131706428));
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
      this.jdField_j_of_type_JavaLangString = "";
      return;
    }
    this.jdField_k_of_type_JavaLangString = "";
  }
  
  private void a(View paramView)
  {
    if (paramView == null)
    {
      QLog.e("MainFragment", 1, "disableBlur: tabWidget == null");
      return;
    }
    paramView.setBackgroundResource(2130848960);
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
      this.jdField_a_of_type_ArrayOfAndroidViewView[i1].setBackgroundResource(2130849398);
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setDisableBlurDrawableRes(2130840299);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(new abmy(this));
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
        paramHashMap = (BusinessInfoCheckUpdate.RedTypeInfo)((RedTouch)paramHashMap.get(jdField_d_of_type_JavaLangString)).getTag(2131374836);
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
      axqy.b(paramQQAppInterface, "dc00898", "", "", "0X80098E1", "0X80098E1", 0, 0, "" + i2, "" + i1, "", "");
      return;
      int i1 = 1;
      break label162;
      i1 = 0;
      int i2 = 0;
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
      axqy.b(paramQQAppInterface, "dc00898", "", "", "0X8009CDD", "0X8009CDD", 0, 0, "", "", "", "");
      if (q)
      {
        q = false;
        axqy.b(paramQQAppInterface, "dc00898", "", "", "0X8009CDB", "0X8009CDB", 0, 0, "", "", "", "");
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
      i1 = b(paramString1);
      localObject1 = (TextView)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1 + "_num");
      if (i1 != 2) {
        break label279;
      }
      localStringBuilder.append("有更新");
    }
    for (;;)
    {
      if (jdField_c_of_type_JavaLangString.equals(paramString1)) {
        localStringBuilder.append(this.jdField_k_of_type_JavaLangString);
      }
      localObject1 = (TextView)paramString2.findViewById(2131378370);
      Object localObject2 = paramString2.findViewById(2131376810);
      if (localObject2 != null)
      {
        ((View)localObject2).setContentDescription(paramString1);
        baww.a((View)localObject2, false);
      }
      if (localObject1 != null) {
        baww.a((View)localObject1, false);
      }
      if (!(paramString2 instanceof RedTouchTab)) {
        break label602;
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
      localStringBuilder.append(ssf.jdField_a_of_type_JavaLangString + " ");
      break label52;
      label279:
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
            localStringBuilder.append(this.jdField_j_of_type_JavaLangString);
          }
        }
        else if ("NOW".equals(paramString1))
        {
          localObject2 = ((TextView)localObject1).getText().toString();
          if (((TextView)localObject1).getVisibility() == 0) {
            if ("99+".equals(localObject2)) {
              localStringBuilder.append("多于99个新的" + ssf.jdField_a_of_type_JavaLangString);
            } else {
              localStringBuilder.append((String)localObject2 + "个新的" + ssf.jdField_a_of_type_JavaLangString);
            }
          }
        }
      }
      else if (i1 == 1) {
        localStringBuilder.append("有新消息");
      } else if (jdField_b_of_type_JavaLangString.equals(paramString1)) {
        localStringBuilder.append(this.jdField_j_of_type_JavaLangString);
      }
    }
    label602:
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
  
  public static View[] a(LayoutInflater paramLayoutInflater)
  {
    boolean bool = f();
    View[] arrayOfView = new View[7];
    arrayOfView[0] = paramLayoutInflater.inflate(2131559203, null);
    arrayOfView[1] = ((DragFrameLayout)arrayOfView[0].findViewById(2131364694));
    int i1 = 2130849392;
    int i2 = 2130849393;
    if (bool)
    {
      i2 = -1;
      i1 = -1;
    }
    arrayOfView[2] = a(i1, 2130849284, i2, 2130849285, 2131694070, 11, 2);
    arrayOfView[2].setOnClickListener(new abne(null));
    i1 = 2130849390;
    i2 = 2130849391;
    if (bool)
    {
      i2 = -1;
      i1 = -1;
    }
    View localView1 = a(i1, 2130849282, i2, 2130849283, 2131694069, 12, 3);
    localView1.setOnClickListener(new abne(null));
    arrayOfView[3] = new RedTouchTab(paramLayoutInflater.getContext(), localView1).a(49).d(3).a(true).b(5).a();
    i1 = 2130849395;
    if (bool) {
      i1 = -1;
    }
    localView1 = a(-1, 2130849288, i1, 2130849289, 2131694071, 14, 4);
    localView1.setOnClickListener(new abnc(localView1, "lebaTab"));
    arrayOfView[4] = new RedTouchTab(paramLayoutInflater.getContext(), localView1).a(49).d(3).a(true).b(5).a();
    View localView2 = a(-1, 2130849288, i1, 2130849289, 2131694071, 14, 4);
    localView2.setOnClickListener(new abnc(localView2, "lebaTabNew"));
    arrayOfView[5] = new RedTouchTab(paramLayoutInflater.getContext(), localView2).a(49).d(3).a(true).b(5).a();
    localView2 = a(-1, 2130849288, i1, 2130849289, 2131694071, 14, 4);
    localView2.setOnClickListener(new abnc(localView1, "QzoneTab"));
    arrayOfView[6] = new RedTouchTab(paramLayoutInflater.getContext(), localView2).a(49).d(3).a(true).b(5).a();
    return arrayOfView;
  }
  
  private View[] a(View paramView)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(8);
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap(12);
    boolean bool = f();
    Object localObject = ((SplashActivity)getActivity()).jdField_a_of_type_ArrayOfAndroidViewView;
    ((SplashActivity)getActivity()).jdField_a_of_type_ArrayOfAndroidViewView = null;
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = ((DragFrameLayout)localObject[1]);
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[] { localObject[2], null, localObject[3], localObject[4], null, localObject[5], null, localObject[6] };
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.setOnDragListener(this.jdField_a_of_type_Ahps);
      this.jdField_a_of_type_JavaUtilHashMap.put(jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfAndroidViewView[0]);
      this.jdField_a_of_type_JavaUtilHashMap.put(jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfAndroidViewView[2]);
      this.jdField_a_of_type_JavaUtilHashMap.put(jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfAndroidViewView[3]);
      this.jdField_a_of_type_JavaUtilHashMap.put("动态", this.jdField_a_of_type_ArrayOfAndroidViewView[7]);
      this.jdField_a_of_type_JavaUtilHashMap.put(jdField_a_of_type_JavaLangString + "_num", this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131378606));
      this.jdField_a_of_type_JavaUtilHashMap.put(jdField_b_of_type_JavaLangString + "_num", this.jdField_a_of_type_ArrayOfAndroidViewView[2].findViewById(2131378606));
      this.jdField_a_of_type_JavaUtilHashMap.put(jdField_c_of_type_JavaLangString + "_num", this.jdField_a_of_type_ArrayOfAndroidViewView[3].findViewById(2131378606));
      this.jdField_a_of_type_JavaUtilHashMap.put("动态_num", this.jdField_a_of_type_ArrayOfAndroidViewView[7].findViewById(2131378606));
      localObject = (TabDragAnimationView)this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131376810);
      ((TabDragAnimationView)localObject).setTag(jdField_a_of_type_JavaLangString);
      ((TabDragAnimationView)localObject).setOnDragListener(new abmu(this));
      ((TabDragAnimationView)localObject).setOnLongClickListener(new abmv(this));
      paramView = (QQTabWidget)paramView.findViewById(16908307);
      if (paramView == null) {
        break label908;
      }
      paramView.setShowDividers(0);
      paramView.setTabWidgetMoveListener(this.jdField_a_of_type_Bcqk);
    }
    for (;;)
    {
      return this.jdField_a_of_type_ArrayOfAndroidViewView;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = ((DragFrameLayout)paramView.findViewById(2131364694));
      int i1 = 2130849390;
      int i2 = 2130849390;
      if (bool)
      {
        i1 = -1;
        i2 = -1;
      }
      localObject = a(i1, 2130849282, i2, 2130849283, 2131694069, 12, 3);
      ((View)localObject).setOnClickListener(new abne(null));
      i1 = 2130849395;
      if (bool) {
        i1 = -1;
      }
      View localView1 = a(-1, 2130849288, i1, 2130849289, 2131694071, 14, 4);
      localView1.setOnClickListener(new abnc(localView1, "lebaTab"));
      View localView2 = a(-1, 2130849288, i1, 2130849289, 2131694071, 14, 4);
      localView2.setOnClickListener(new abnc(localView2, "qzoneTab"));
      View localView3 = a(-1, 2130849288, i1, 2130849289, 2131694071, 14, 4);
      localView3.setOnClickListener(new abnc(localView3, "lebaTabNew"));
      View localView4 = a(2130845600, 2130849286, 2130845601, 2130849287, 2131699681, 15, 5);
      localView4.setOnClickListener(new abne(null));
      i1 = 2130849392;
      i2 = 2130849393;
      if (bool)
      {
        i1 = -1;
        i2 = -1;
      }
      View localView5 = a(i1, 2130849284, i2, 2130849285, 2131694070, 11, 2);
      localView5.setOnClickListener(new abne(null));
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[] { localView5, null, new RedTouchTab(getActivity(), (View)localObject).a(49).d(3).a(true).b(5).a(), new RedTouchTab(getActivity(), localView1).a(49).d(3).a(true).b(5).a(), new RedTouchTab(getActivity(), localView4).a(49).d(3).a(true).b(5).a(), new RedTouchTab(getActivity(), localView3).a(49).d(3).a(true).b(5).a(), null, new RedTouchTab(getActivity(), localView2).a(49).d(3).a(true).b(5).a() };
      break;
      label908:
      QLog.i("MainFragment", 1, "initTabs tabWidget is null");
    }
  }
  
  private int b(String paramString)
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
      oidb_0x791.RedDotInfo localRedDotInfo = ((mxu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70)).a();
      if ((localRedDotInfo != null) && (localRedDotInfo.uint32_appid.get() == 52)) {
        break;
      }
      a(37, null);
      return true;
    }
  }
  
  private boolean e()
  {
    RedTouch localRedTouch = (RedTouch)this.jdField_a_of_type_JavaUtilHashMap.get(jdField_c_of_type_JavaLangString);
    if (localRedTouch == null) {
      return false;
    }
    return localRedTouch.a();
  }
  
  private void f(boolean paramBoolean)
  {
    int i3 = this.jdField_k_of_type_Int;
    boolean bool = bhvy.i();
    if (this.n != bool)
    {
      i1 = 1;
      if (this.jdField_e_of_type_Boolean == axmv.a()) {
        break label237;
      }
    }
    label237:
    for (int i2 = 1;; i2 = 0)
    {
      this.jdField_e_of_type_Boolean = axmv.a();
      if ((!paramBoolean) && ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.n) || (this.jdField_a_of_type_ArrayOfAndroidViewView[1] != null)) && ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.n) || (this.jdField_a_of_type_ArrayOfAndroidViewView[1] == null)) && (this.jdField_k_of_type_Int == i3) && (this.jdField_a_of_type_ArrayOfAndroidViewView[4] == null) && (i1 == 0) && (i2 == 0)) {
        break label880;
      }
      nde.jdField_c_of_type_Boolean = false;
      oll.a(true);
      agby.jdField_a_of_type_Int |= 0x2;
      if (QLog.isColorLevel()) {
        QLog.i("MainFragment", 2, "setFrames" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.n);
      }
      this.jdField_k_of_type_Int = i3;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.clearAllTabs();
      }
      i2 = this.jdField_a_of_type_ArrayOfAndroidViewView.length;
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
      i1 = 0;
      break;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.n, -100, bool);
    A();
    Object localObject = a(Conversation.class);
    if (localObject != null) {
      ((Conversation)localObject).h(true);
    }
    this.jdField_a_of_type_ArrayOfAndroidViewView[1] = null;
    this.jdField_a_of_type_ArrayOfAndroidViewView[4] = null;
    this.jdField_a_of_type_JavaUtilHashMap.remove("NOW");
    this.jdField_a_of_type_JavaUtilHashMap.remove("NOW_num");
    a(Now.class);
    int i1 = this.jdField_k_of_type_Int;
    if ((i1 == 0) && (this.jdField_a_of_type_ArrayOfAndroidViewView[4] != null)) {
      a(this.jdField_a_of_type_AndroidViewView, Now.class, this.jdField_a_of_type_ArrayOfAndroidViewView[4]);
    }
    a(this.jdField_a_of_type_AndroidViewView, Conversation.class, this.jdField_a_of_type_ArrayOfAndroidViewView[0]);
    if ((i1 == 1) && (this.jdField_a_of_type_ArrayOfAndroidViewView[4] != null)) {
      a(this.jdField_a_of_type_AndroidViewView, Now.class, this.jdField_a_of_type_ArrayOfAndroidViewView[4]);
    }
    a(this.jdField_a_of_type_AndroidViewView, Contacts.class, this.jdField_a_of_type_ArrayOfAndroidViewView[2]);
    if (bool)
    {
      if (this.jdField_a_of_type_ArrayOfAndroidViewView[6] == null) {
        B();
      }
      this.jdField_a_of_type_ArrayOfAndroidViewView[6].setId(22);
      localObject = (TabDragAnimationView)this.jdField_a_of_type_ArrayOfAndroidViewView[6].findViewById(2131376810);
      TextView localTextView = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[6].findViewById(2131378370);
      if ((localTextView != null) && (localObject != null))
      {
        ((TabDragAnimationView)localObject).setOnTouchListener(new abnf(null));
        ((TabDragAnimationView)localObject).setPressChanged(false);
        localTextView.setTextColor(getResources().getColor(2131167033));
        ((TabDragAnimationView)localObject).a(getResources().getString(2131696701));
        this.jdField_a_of_type_AndroidUtilSparseArray.put(jdField_h_of_type_Int, localObject);
        this.jdField_b_of_type_AndroidUtilSparseArray.put(jdField_h_of_type_Int, localTextView);
        a(this.jdField_a_of_type_AndroidViewView, ReadinjoyTabFrame.class, this.jdField_a_of_type_ArrayOfAndroidViewView[6]);
        this.n = true;
      }
      c(3);
      if (!jdField_a_of_type_Boolean) {
        C();
      }
      if ((i1 == 2) && (this.jdField_a_of_type_ArrayOfAndroidViewView[4] != null)) {
        a(this.jdField_a_of_type_AndroidViewView, Now.class, this.jdField_a_of_type_ArrayOfAndroidViewView[4]);
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfAndroidViewView[3]);
      this.jdField_a_of_type_JavaUtilHashMap.put(jdField_c_of_type_JavaLangString + "_num", this.jdField_a_of_type_ArrayOfAndroidViewView[3].findViewById(2131378606));
      if (!bhby.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label916;
      }
      a(Leba.class);
      a(this.jdField_a_of_type_AndroidViewView, QzoneFrame.class, this.jdField_a_of_type_ArrayOfAndroidViewView[7]);
      this.jdField_a_of_type_JavaUtilHashMap.put("动态", this.jdField_a_of_type_ArrayOfAndroidViewView[7]);
      this.jdField_a_of_type_JavaUtilHashMap.put("动态_num", this.jdField_a_of_type_ArrayOfAndroidViewView[7].findViewById(2131378606));
      localObject = (TabDragAnimationView)this.jdField_a_of_type_ArrayOfAndroidViewView[7].findViewById(2131376810);
      localTextView = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[7].findViewById(2131378370);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(jdField_j_of_type_Int, localObject);
      this.jdField_b_of_type_AndroidUtilSparseArray.put(jdField_j_of_type_Int, localTextView);
    }
    for (;;)
    {
      if ((i1 == 3) && (this.jdField_a_of_type_ArrayOfAndroidViewView[4] != null)) {
        a(this.jdField_a_of_type_AndroidViewView, Now.class, this.jdField_a_of_type_ArrayOfAndroidViewView[4]);
      }
      oll.a(false);
      g(false);
      label880:
      return;
      a(ReadinjoyTabFrame.class);
      this.jdField_a_of_type_AndroidUtilSparseArray.remove(jdField_h_of_type_Int);
      this.jdField_b_of_type_AndroidUtilSparseArray.remove(jdField_h_of_type_Int);
      this.n = false;
      break;
      label916:
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
      d(i2);
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378810));
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
      a(jdField_b_of_type_Int, 2130849392, 2130849393);
      a(jdField_d_of_type_Int, 2130849390, 2130849391);
      a(jdField_h_of_type_Int, 2130842648, 2130842649);
      a(jdField_e_of_type_Int, -1, 2130849395);
    }
  }
  
  private boolean g()
  {
    akpc localakpc = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    if ((localakpc != null) && (ahnl.a().a.size() > 0))
    {
      Object localObject = new ArrayList(ahnl.a().a);
      if (((List)localObject).size() > 0)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          RecentBaseData localRecentBaseData = (RecentBaseData)((Iterator)localObject).next();
          if (localRecentBaseData != null)
          {
            if ((localRecentBaseData.mUnreadFlag == 1) || (localRecentBaseData.mUnreadFlag == 4)) {}
            for (int i1 = 1; (i1 != 0) && (localakpc.a(localRecentBaseData)); i1 = 0) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }
  
  private void y()
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
  
  private void z()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "showActionSheet");
    }
    e();
    ArrayList localArrayList = new ArrayList();
    Object localObject = new abng();
    ((abng)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131720729);
    localArrayList.add(new Pair(Integer.valueOf(2131371172), localObject));
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("com.tencent.Feedback_5_8");
    if ((localObject != null) && (((ResourcePluginInfo)localObject).cLocalState != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "feedback plugin is add overmenu");
      }
      abng localabng = new abng();
      localabng.jdField_a_of_type_JavaLangString = ((ResourcePluginInfo)localObject).strResName;
      localabng.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo = ((ResourcePluginInfo)localObject);
      localArrayList.add(new Pair(Integer.valueOf(2131371171), localabng));
    }
    localObject = new abng();
    ((abng)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131694107);
    localArrayList.add(new Pair(Integer.valueOf(2131371170), localObject));
    localObject = new abng();
    ((abng)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131690573);
    localArrayList.add(new Pair(Integer.valueOf(2131371169), localObject));
    localObject = bfpc.c(getActivity());
    int i1 = 0;
    if (i1 < localArrayList.size())
    {
      if (2131371169 == ((Integer)((Pair)localArrayList.get(i1)).first).intValue()) {
        ((bfpc)localObject).d(((abng)((Pair)localArrayList.get(i1)).second).jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        i1 += 1;
        break;
        ((bfpc)localObject).c(((abng)((Pair)localArrayList.get(i1)).second).jdField_a_of_type_JavaLangString);
      }
    }
    ((bfpc)localObject).a(new abmz(this, localArrayList, (bfpc)localObject));
    ((bfpc)localObject).setOnDismissListener(new abna(this));
    ((bfpc)localObject).setCanceledOnTouchOutside(true);
    this.jdField_b_of_type_AndroidAppDialog = ((Dialog)localObject);
    try
    {
      this.jdField_b_of_type_AndroidAppDialog.show();
      return;
    }
    catch (Exception localException) {}
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
    Dialog localDialog = new Dialog(getActivity(), 2131755791);
    localDialog.setContentView(2131559037);
    TextView localTextView = (TextView)localDialog.findViewById(2131365150);
    if (localTextView != null)
    {
      if (paramString1 == null) {
        localTextView.setVisibility(8);
      }
    }
    else
    {
      paramString1 = (TextView)localDialog.findViewById(2131365146);
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
      paramString1 = (TextView)localDialog.findViewById(2131365135);
      if (paramString1 != null) {
        paramString1.setText(2131690596);
      }
      paramString1 = (TextView)localDialog.findViewById(2131365141);
      if (paramString1 != null) {
        paramString1.setText(2131694794);
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
  
  public String a()
  {
    if (b()) {
      return getString(2131690331);
    }
    return super.a();
  }
  
  public HashMap<String, View> a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "onDrawComplete[" + d() + "]");
    }
    super.a();
    Object localObject = b();
    if (localObject != null) {
      ((ajwk)localObject).p();
    }
    if (jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Agcf.c();
      jdField_a_of_type_Boolean = false;
      ThreadManager.getUIHandler().postDelayed(new MainFragment.3(this), 2000L);
    }
    bbkj.a("Main_Start", null);
    localObject = d();
    if (jdField_a_of_type_JavaLangString.equals(localObject)) {}
    try
    {
      ajac.a(getActivity(), (Conversation)a(Conversation.class));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MainFragment", 2, "show cmgame app pop error e=" + localThrowable.toString());
    }
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
    String str2;
    String str1;
    label56:
    Object localObject;
    label87:
    TextView localTextView;
    do
    {
      return;
      bool = false;
      str2 = "";
      switch (paramInt1)
      {
      default: 
        str1 = "";
        switch (paramInt2)
        {
        default: 
          localObject = null;
          localTextView = (TextView)this.jdField_a_of_type_JavaUtilHashMap.get(str1 + "_num");
        }
        break;
      }
    } while ((localTextView == null) || (localObject == null));
    int i1;
    if ((paramObject instanceof Integer)) {
      i1 = ((Integer)paramObject).intValue();
    }
    for (;;)
    {
      label146:
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
      label232:
      int i4;
      int i3;
      label318:
      int i2;
      label367:
      int i6;
      int i5;
      if (((String)localObject).equals(str1 + "_num"))
      {
        localSharedPreferences.edit().putInt((String)localObject + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), i1).commit();
        this.jdField_b_of_type_JavaUtilHashMap.put(localObject, paramObject);
        i1 = 0;
        i4 = b(str1);
        if (i4 != 3) {
          break label819;
        }
        localObject = this.jdField_b_of_type_JavaUtilHashMap.get(str1 + "_num");
        i3 = i1;
        paramObject = str2;
        if ((localObject instanceof Integer))
        {
          i3 = ((Integer)localObject).intValue();
          paramObject = str2;
        }
        i2 = 0;
        if (paramInt1 != 32) {
          break label953;
        }
        if ((i3 <= 99) || (axmv.b())) {
          break label901;
        }
        i4 = getResources().getDimensionPixelSize(2131297176);
        if (!this.jdField_l_of_type_Boolean) {
          break label890;
        }
        i1 = bbll.b(7.0F);
        i6 = 4;
        i2 = 2130849306;
        i5 = i1;
        i1 = i6;
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
          d(i3);
        }
      }
      for (;;)
      {
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("updateMain, [").append("tabIndex = ").append(paramInt1).append(",").append("type = ").append(paramInt2).append(",").append("style = ").append(i1).append(",").append("num = ").append(i3).append(",").append("isVisable = ").append(bool).append(",").append("tv = ").append(localTextView.toString()).append(" ]");
          QLog.d("MainFragment", 4, ((StringBuilder)localObject).toString());
        }
        bfqs.a(localTextView, i1, i3, i2, 99, paramObject);
        if (!AppSetting.jdField_d_of_type_Boolean) {
          break;
        }
        a(jdField_a_of_type_JavaLangString, d());
        a(jdField_b_of_type_JavaLangString, d());
        a(jdField_c_of_type_JavaLangString, d());
        a("NOW", d());
        return;
        str1 = jdField_a_of_type_JavaLangString;
        break label56;
        str1 = jdField_b_of_type_JavaLangString;
        break label56;
        c(paramInt2);
        return;
        localObject = str1 + "_num";
        break label87;
        localObject = str1 + "_icon";
        break label87;
        localObject = str1 + "_new";
        break label87;
        if (!(paramObject instanceof Boolean)) {
          break label960;
        }
        bool = ((Boolean)paramObject).booleanValue();
        i1 = 0;
        break label146;
        localSharedPreferences.edit().putBoolean((String)localObject + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), bool).commit();
        break label232;
        label819:
        i3 = i1;
        paramObject = str2;
        if (i4 != 5) {
          break label318;
        }
        localObject = this.jdField_b_of_type_JavaUtilHashMap.get(str1 + "_text");
        i3 = i1;
        paramObject = str2;
        if (!(localObject instanceof String)) {
          break label318;
        }
        paramObject = (String)localObject;
        i3 = i1;
        break label318;
        label890:
        i1 = bbll.b(5.0F);
        break label367;
        label901:
        i6 = getResources().getDimensionPixelSize(2131297175);
        if (this.jdField_l_of_type_Boolean) {}
        for (i1 = bbll.b(7.0F);; i1 = bbll.b(5.0F))
        {
          i2 = 0;
          i5 = i1;
          i1 = i4;
          break;
        }
        label953:
        i1 = i4;
      }
      label960:
      i1 = 0;
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
          case 36: 
          case 38: 
          default: 
            return;
          }
        } while (this.jdField_a_of_type_JavaUtilHashMap == null);
        a(paramInt, (RedTouch)this.jdField_a_of_type_JavaUtilHashMap.get(jdField_b_of_type_JavaLangString), paramRedTypeInfo);
        return;
        a(paramInt, (RedTouch)this.jdField_a_of_type_JavaUtilHashMap.get(jdField_c_of_type_JavaLangString), paramRedTypeInfo);
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
    C();
  }
  
  protected void a(Intent paramIntent)
  {
    Object localObject1;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("onNewIntent ");
      if (this.jdField_a_of_type_Agcf == null)
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
      p = false;
      if (this.jdField_a_of_type_Agcf != null) {
        break label105;
      }
    }
    label105:
    do
    {
      return;
      bool = false;
      break;
      ahkd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent);
      localObject1 = paramIntent.getExtras();
    } while (localObject1 == null);
    if (Boolean.valueOf(((Bundle)localObject1).getBoolean("EXIT", false)).booleanValue())
    {
      getActivity().finish();
      return;
    }
    int i1;
    if (((Bundle)localObject1).containsKey("tab_index")) {
      i1 = ((Bundle)localObject1).getInt("tab_index");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "onNewIntent tabIndex: " + i1);
      }
      int i2;
      Object localObject2;
      label429:
      label437:
      Object localObject3;
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost != null) && (i1 >= 0))
      {
        if (i1 == jdField_b_of_type_Int)
        {
          i2 = ((Bundle)localObject1).getInt("conversation_index", -1);
          ((Bundle)localObject1).getBoolean("isOpenSelectMember", false);
          if ((1 == i2) && ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.n))) {}
        }
        else
        {
          if ((i1 != jdField_b_of_type_Int) || (i1 != a())) {
            break label437;
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
            break label429;
          }
        }
        for (paramIntent.jdField_b_of_type_Boolean = true;; paramIntent.jdField_b_of_type_Boolean = false)
        {
          paramIntent.jdField_c_of_type_Boolean = ((Bundle)localObject1).getBoolean("theme_back_to_conversation", false);
          return;
          if (!((Bundle)localObject1).containsKey("main_tab_id")) {
            break label1190;
          }
          i1 = a((Bundle)localObject1);
          break;
          try
          {
            paramIntent = (Conversation)a(Conversation.class);
            if (paramIntent != null) {
              paramIntent.jdField_a_of_type_Boolean = true;
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setCurrentTab(i1);
            return;
          }
          catch (Exception paramIntent)
          {
            return;
          }
        }
        if ((i1 == jdField_c_of_type_Int) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.n))
        {
          i1 = jdField_b_of_type_Int;
          ((Bundle)localObject1).getBoolean("isOpenSelectMember", false);
          try
          {
            paramIntent = (Conversation)a(Conversation.class);
            if (paramIntent != null) {
              paramIntent.jdField_a_of_type_Boolean = true;
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setCurrentTab(i1);
            return;
          }
          catch (Exception paramIntent)
          {
            return;
          }
        }
        if ((i1 >= 0) && (i1 < this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.getTabWidget().getChildCount()))
        {
          localObject3 = (Conversation)a(Conversation.class);
          localObject2 = ((Bundle)localObject1).getString("from");
          if (localObject3 != null)
          {
            if ("10003".equals(localObject2)) {
              ((Conversation)localObject3).jdField_b_of_type_Boolean = true;
            }
          }
          else
          {
            label561:
            if (("smartdevice".equals(localObject2)) && (i1 == jdField_d_of_type_Int))
            {
              localObject3 = (Contacts)a(Contacts.class);
              if (localObject3 != null) {
                ((Contacts)localObject3).a(true);
              }
            }
            if ((i1 == jdField_g_of_type_Int) && (i1 == a()))
            {
              localObject3 = (Now)a(Now.class);
              if (localObject3 != null)
              {
                ((Now)localObject3).jdField_b_of_type_Boolean = ((Bundle)localObject1).getBoolean("extra_from_share");
                ((Now)localObject3).jdField_a_of_type_JavaLangString = ((Bundle)localObject1).getString("new_video_extra_info");
              }
            }
            if ((i1 == jdField_e_of_type_Int) && ("campus_notice".equals(localObject2)))
            {
              if (QLog.isColorLevel()) {
                QLog.d("CampusNoticeManager", 2, String.format(Locale.getDefault(), "back from campus_notice %d", new Object[] { Integer.valueOf(DrawerFrame.jdField_a_of_type_Int) }));
              }
              if (DrawerFrame.jdField_a_of_type_Int == 0) {
                DrawerFrame.jdField_a_of_type_Int = 3;
              }
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setCurrentTab(i1);
          }
        }
      }
      for (;;)
      {
        try
        {
          i1 = paramIntent.getIntExtra("forward", -1);
          i2 = paramIntent.getIntExtra("uintype", -1);
          if ((i1 <= 0) || ((i2 != 1035) && (i2 != 1041) && (i2 != 1042)) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(284))) {
            break label937;
          }
          ((aseq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(284)).a(getActivity(), paramIntent);
          return;
        }
        catch (Exception paramIntent) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("MainFragment", 2, "", paramIntent);
        return;
        ((Conversation)localObject3).jdField_b_of_type_Boolean = false;
        break label561;
        if (i1 == jdField_j_of_type_Int)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setCurrentTab(jdField_e_of_type_Int);
        }
        else if ((i1 >= 0) && ((i1 == jdField_g_of_type_Int) || (i1 == jdField_i_of_type_Int)) && (i1 != a()))
        {
          this.jdField_a_of_type_AndroidContentIntent = paramIntent;
          continue;
          if ((i1 == jdField_i_of_type_Int) && (bhvy.k()))
          {
            this.jdField_a_of_type_AndroidContentIntent = paramIntent;
            QLog.d("MainFragment", 1, "MainActivity:onNewIntent mTabHost, jump kandian tab fail, set pengingIntent");
          }
          if (QLog.isColorLevel()) {
            QLog.d("MainFragment", 2, "MainActivity:onNewIntent mTabHost is null");
          }
        }
      }
      label937:
      if (i1 == 2)
      {
        localObject1 = paramIntent.getParcelableExtra("AllInOne");
        if ((localObject1 instanceof ProfileActivity.AllInOne))
        {
          localObject1 = (ProfileActivity.AllInOne)localObject1;
          ((ProfileActivity.AllInOne)localObject1).jdField_g_of_type_Int = 100;
          ((ProfileActivity.AllInOne)localObject1).jdField_h_of_type_Int = 6;
          ProfileActivity.b(getActivity(), (ProfileActivity.AllInOne)localObject1);
        }
      }
      for (;;)
      {
        paramIntent.removeExtra("forward");
        return;
        if (i1 == 3)
        {
          localObject1 = paramIntent.getStringExtra("url");
          localObject2 = new Intent(getActivity(), QQBrowserActivity.class);
          if (i2 != -1)
          {
            ((Intent)localObject2).putExtra("uintype", i2);
            if ((i2 == 1030) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(240)))
            {
              localObject3 = new axqt();
              ((axqt)localObject3).jdField_e_of_type_JavaLangString = "0X8009241";
              ((axqt)localObject3).jdField_d_of_type_JavaLangString = "点击业务Push";
              axqs.a((String)localObject1, (axqt)localObject3);
              axqs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (axqt)localObject3);
              ((amga)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(240)).a(null);
              if (QLog.isColorLevel()) {
                QLog.d("CampusNoticeManager", 2, "remove campus notice");
              }
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("CampusNoticeManager", 1, "doOnNewIntent : url" + (String)localObject1);
          }
          ((Intent)localObject2).putExtra("url", (String)localObject1);
          startActivity((Intent)localObject2);
        }
      }
      label1190:
      i1 = -1;
    }
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "MainActivity:onLogout");
    }
    bbkb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), "");
    if (asfd.a().d()) {
      asfd.a().a(false);
    }
    asfd.a().d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    asel.a().a(1);
    this.jdField_m_of_type_Boolean = true;
    aktp.a();
    UserguideActivity.a();
    ThreadManager.getUIHandler().post(new MainFragment.15(this));
    VSNetworkHelper.a().a();
    super.a(paramLogoutReason);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    y();
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (paramInt == 82)
    {
      z();
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
    return this.jdField_g_of_type_JavaLangString;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "onAccountChanged");
    }
    p = false;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    com.tencent.mobileqq.app.FriendListHandler.jdField_a_of_type_Int = -1;
    this.jdField_k_of_type_Boolean = false;
    ThreadManager.post(new MainFragment.4(this), 2, null, true);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_Agcf != null))
    {
      this.jdField_a_of_type_Agcf.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Agcf.a();
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "onAccountChange.check.new....");
      }
      if ((!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (this.jdField_e_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()))) {}
    }
    try
    {
      QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
      localQQNotificationManager.cancel("MainFragment", 241);
      localQQNotificationManager.cancel("MainFragment", 243);
      axcj localaxcj = (axcj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      if (localaxcj != null) {
        localaxcj.a(1, 0);
      }
      localQQNotificationManager.cancel("MainFragment", 265);
      bfoi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
      localQQNotificationManager.cancel("MainFragment", 267);
      localQQNotificationManager.cancel("MainFragment", 274);
      localQQNotificationManager.cancel("MainFragment", 236);
      localQQNotificationManager.cancel("MainFragment", 271);
      localQQNotificationManager.cancel("MainFragment", 273);
      localQQNotificationManager.cancel("MainFragment", 239);
    }
    catch (Exception localException2)
    {
      label262:
      break label262;
    }
    this.jdField_a_of_type_Agcf.h();
    this.jdField_a_of_type_Agcf.a(localQQAppInterface);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      ((akdq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(257)).a(this.jdField_a_of_type_Akds);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Apyt);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Aujb);
    }
    if (this.jdField_a_of_type_Auhk != null) {
      this.jdField_a_of_type_Auhk.f();
    }
    for (;;)
    {
      if ((this.jdField_m_of_type_Boolean) || ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ArrayOfAndroidViewView != null) && (this.jdField_a_of_type_JavaUtilHashMap != null))) {}
      try
      {
        f(false);
        aktp.a();
        if (this.jdField_a_of_type_Agcf != null) {
          this.jdField_a_of_type_Agcf.jdField_d_of_type_Boolean = false;
        }
        getActivity().getIntent().removeExtra("if_check_account_same");
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        }
        UserguideActivity.a();
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
  
  public String c()
  {
    if ((a() == jdField_b_of_type_Int) && ((b() instanceof Conversation)) && (((Conversation)c()).jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.a())) {
      return "QQSettingMe";
    }
    return b();
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Auhk != null) {
      this.jdField_a_of_type_Auhk.g();
    }
  }
  
  void d()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new MainFragment.5(this), 500L);
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
    Dialog localDialog = a("你确定退出QQ？", null, new abnb(this));
    Object localObject = (TextView)localDialog.findViewById(2131365141);
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new abms(this, localDialog));
    }
    localObject = (TextView)localDialog.findViewById(2131365135);
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new abmt(this));
    }
    localObject = getString(2131718636);
    boolean bool = SettingCloneUtil.isContainValue(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (String)localObject, "qqsetting_receivemsg_whenexit_key");
    this.jdField_d_of_type_Boolean = SettingCloneUtil.readValue(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (String)localObject, "qqsetting_receivemsg_whenexit_key", true);
    localObject = (CheckBox)localDialog.findViewById(2131364180);
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
    if (this.jdField_e_of_type_Boolean != axmv.a()) {}
    for (int i1 = 1;; i1 = 0)
    {
      if ((i1 != 0) && (this.jdField_a_of_type_ArrayOfAndroidViewView != null)) {
        f(false);
      }
      ajwk localajwk = a(Conversation.class);
      if (localajwk != null) {
        ((Conversation)localajwk).b();
      }
      localajwk = a(Contacts.class);
      if (localajwk != null) {
        ((Contacts)localajwk).k();
      }
      localajwk = a(Leba.class);
      if (localajwk != null) {
        ((Leba)localajwk).q();
      }
      localajwk = a(Now.class);
      if (localajwk != null) {
        ((Now)localajwk).b();
      }
      localajwk = a(ReadinjoyTabFrame.class);
      if (localajwk != null) {
        ((ReadinjoyTabFrame)localajwk).J_();
      }
      localajwk = a(QzoneFrame.class);
      if (localajwk != null) {
        ((QzoneFrame)localajwk).k();
      }
      g(true);
      return;
    }
  }
  
  public void i()
  {
    Object localObject = a(Conversation.class);
    if ((localObject != null) && (((Conversation)localObject).c()))
    {
      localObject = (bbzu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76);
      if (localObject != null)
      {
        bbzt localbbzt = ((bbzu)localObject).a();
        if ((localbbzt != null) && (isResumed()) && (localbbzt.d == 2L)) {
          ((bbzu)localObject).a(localbbzt, getActivity());
        }
      }
    }
  }
  
  public void j()
  {
    ajwk localajwk = b();
    if (localajwk != null) {
      localajwk.A();
    }
  }
  
  public void k() {}
  
  protected void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DynimiIcon", 2, "revertConversationIconChange mPreResIndex = " + jdField_m_of_type_Int);
    }
    q = true;
    this.jdField_f_of_type_Boolean = false;
    Conversation localConversation = (Conversation)a(Conversation.class);
    if (localConversation != null) {}
    for (int i1 = localConversation.jdField_d_of_type_Int;; i1 = 0)
    {
      d(i1);
      return;
    }
  }
  
  public void m()
  {
    if (a() == jdField_b_of_type_Int)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DynimiIcon", 2, "onFragmentDrawerOpened");
      }
      l();
    }
  }
  
  public void n()
  {
    if (a() == jdField_b_of_type_Int)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DynimiIcon", 2, "onFragmentDrawerOpened");
      }
      l();
    }
  }
  
  public void o()
  {
    if (a() == jdField_b_of_type_Int)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DynimiIcon", 2, "onFragmentDrawerOpened");
      }
      l();
    }
    ThreadManager.getSubThreadHandler().post(new MainFragment.19(this));
  }
  
  public void onAttach(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "AutoMonitor_fragment MainFragment onAttach");
    }
    super.onAttach(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    this.jdField_a_of_type_Agcf = new agcf((SplashActivity)getActivity());
  }
  
  public Animation onCreateAnimation(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramInt2 == 0) {
      return null;
    }
    Object localObject = (Animation)jdField_c_of_type_AndroidUtilSparseArray.get(paramInt2);
    if (localObject == null)
    {
      if (paramInt2 == 2130772050)
      {
        localObject = new aczh();
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
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      paramViewGroup = getActivity().findViewById(2131376397);
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
        paramLayoutInflater = new MainFragment.1(this);
        if (!StartService.jdField_a_of_type_Boolean) {
          break label203;
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
      wsu.a().a();
      return this.jdField_a_of_type_AndroidViewView;
      this.jdField_a_of_type_AndroidViewView = super.onCreateView(paramLayoutInflater, null, paramBundle);
      break;
      if (this.jdField_a_of_type_AndroidViewView.getParent() == null) {
        break;
      }
      ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.jdField_a_of_type_AndroidViewView);
      break;
      label203:
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
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_Agcf != null))
    {
      if (!this.jdField_j_of_type_Boolean)
      {
        this.jdField_a_of_type_Agcf.b();
        this.jdField_j_of_type_Boolean = true;
      }
      this.jdField_a_of_type_Agcf.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      ((akdq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(257)).a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Apyt);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Aujb);
    }
    ScreenCapture.clearSnapCacheFile(getActivity());
    if (getActivity().isFinishing()) {}
    try
    {
      apdc.a().c();
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "MainActivity.onDestory");
      }
      if (bdle.a()) {
        bdle.a().e();
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
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(true);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(false);
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
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop = true;
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
    this.jdField_a_of_type_Agcf.b();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      ((akdq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(257)).a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Apyt);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Aujb);
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
    if ((this.jdField_b_of_type_Long != 0L) && (this.jdField_g_of_type_JavaLangString != null) && (UnifiedMonitor.a().whetherReportThisTime(8))) {
      UnifiedMonitor.a().addEvent(8, this.jdField_g_of_type_JavaLangString, (int)(SystemClock.uptimeMillis() - this.jdField_b_of_type_Long), 0, null);
    }
    this.jdField_b_of_type_Long = 0L;
    e();
    ahpd.jdField_b_of_type_Boolean = false;
    if (DrawerFrame.jdField_a_of_type_Int == 2) {
      t();
    }
    FrameHelperActivity.c(false);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b();
    }
    if (a() == jdField_b_of_type_Int) {
      l();
    }
    y();
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
    bbkj.a(null, "Main_OnResume");
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
      t();
    }
    f(false);
    if (GuardManager.a != null) {
      GuardManager.a.b(6, null);
    }
    ahpd.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_AndroidContentIntent != null)
    {
      localObject = this.jdField_a_of_type_AndroidContentIntent;
      this.jdField_a_of_type_AndroidContentIntent = null;
      ((SplashActivity)getActivity()).b((Intent)localObject);
    }
    ThreadManager.getSubThreadHandler().postDelayed(new MainFragment.2(this), 1000L);
    this.jdField_a_of_type_Agcf.h();
    bbkj.a("Main_OnResume", null);
    Object localObject = (mxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(43);
    if ((localObject != null) && (((mxn)localObject).a()) && (QLog.isColorLevel())) {
      QLog.d("Q.qqstory.redPoint", 2, "MainFragment onResume, getRedPointInfo");
    }
    osx.j();
    if (SplashActivity.jdField_c_of_type_Int != 0)
    {
      aabg.a().a(SplashActivity.jdField_c_of_type_Int);
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
    p = false;
    if (this.jdField_a_of_type_Agcf != null) {
      this.jdField_a_of_type_Agcf.b(getActivity().getIntent());
    }
    aqbz.a(getActivity(), getActivity().getIntent());
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
      if ((this.jdField_h_of_type_JavaLangString != null) && (this.jdField_h_of_type_JavaLangString.length() > 0) && ("pakage_from_h5".equalsIgnoreCase(this.jdField_i_of_type_JavaLangString)))
      {
        bbeg localbbeg = bbex.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_h_of_type_JavaLangString);
        localbbeg.b(this.jdField_i_of_type_JavaLangString);
        localbbeg.c();
        this.jdField_h_of_type_JavaLangString = null;
        this.jdField_i_of_type_JavaLangString = null;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.b()) {
        E();
      }
      ((acto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(218)).e();
    } while (this.jdField_a_of_type_Agcf == null);
    this.jdField_a_of_type_Agcf.a(getActivity().getIntent());
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
      t();
    }
    rig.a().a(false);
  }
  
  public void onTabChanged(String paramString)
  {
    if ((this.jdField_b_of_type_Long != 0L) && (this.jdField_g_of_type_JavaLangString != null) && (UnifiedMonitor.a().whetherReportThisTime(8))) {
      UnifiedMonitor.a().addEvent(8, this.jdField_g_of_type_JavaLangString, (int)(SystemClock.uptimeMillis() - this.jdField_b_of_type_Long), 0, null);
    }
    if (this.jdField_g_of_type_JavaLangString != null) {
      axri.a().b(this.jdField_g_of_type_JavaLangString);
    }
    Object localObject = this.jdField_g_of_type_JavaLangString;
    this.jdField_g_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    axri.a().a(this.jdField_g_of_type_JavaLangString);
    ajwk localajwk = a();
    int i2 = a((String)localObject);
    super.onTabChanged(paramString);
    if (i2 == jdField_b_of_type_Int) {
      l();
    }
    ahpd.jdField_b_of_type_Boolean = true;
    int i1 = jdField_b_of_type_Int;
    if (paramString.equals(Conversation.class.getName()))
    {
      paramString = jdField_a_of_type_JavaLangString;
      i1 = jdField_b_of_type_Int;
    }
    label272:
    label789:
    label1072:
    label1094:
    for (;;)
    {
      if (this.jdField_b_of_type_AndroidViewView != null)
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        e(false);
      }
      if ((i2 == jdField_c_of_type_Int) && (i1 != jdField_c_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
      {
        paramString = (avet)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(38);
        if (paramString != null) {
          paramString.a(awzy.a());
        }
      }
      if (((localajwk instanceof ReadinjoyTabFrame)) || (i1 == jdField_h_of_type_Int))
      {
        paramString = (ReadinjoyTabFrame)a(ReadinjoyTabFrame.class);
        if (paramString != null)
        {
          if (i1 == jdField_h_of_type_Int)
          {
            shu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            paramString.e(true);
            c(5);
          }
        }
        else
        {
          osx.c(i1);
          bfnp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, localajwk, i1);
          paramString = (DragTextView)this.jdField_a_of_type_JavaUtilHashMap.get(jdField_a_of_type_JavaLangString + "_num");
          if (i1 != jdField_b_of_type_Int) {
            break label789;
          }
          paramString.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
          paramString.setDragViewType(2);
          localObject = (TabDragAnimationView)this.jdField_a_of_type_AndroidUtilSparseArray.get(jdField_b_of_type_Int);
          this.jdField_a_of_type_Ahps.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView = ((TabDragAnimationView)localObject);
          if (localObject != null) {
            if (QLog.isColorLevel()) {
              QLog.d("DynimiIcon", 2, "onTabChanged ConversationTab");
            }
          }
        }
      }
      for (;;)
      {
        int i3;
        try
        {
          ((TabDragAnimationView)localObject).setOnDoubleTapListener(this.jdField_a_of_type_Abnd);
          this.jdField_a_of_type_Ahps.jdField_a_of_type_AndroidViewView = paramString;
          this.jdField_l_of_type_Boolean = f();
          paramString = (TabDragAnimationView)this.jdField_a_of_type_AndroidUtilSparseArray.get(i1);
          if (paramString != null) {
            paramString.setPressChanged(true);
          }
          paramString = (TextView)this.jdField_b_of_type_AndroidUtilSparseArray.get(i1);
          if (paramString != null) {
            paramString.setTextColor(getResources().getColor(2131167034));
          }
          i2 = 0;
          if (i2 >= this.jdField_a_of_type_AndroidUtilSparseArray.size()) {
            break label884;
          }
          i3 = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i2);
          if (i3 != i1) {
            break label841;
          }
          i2 += 1;
          continue;
          if (paramString.equals(Contacts.class.getName()))
          {
            paramString = jdField_b_of_type_JavaLangString;
            i1 = jdField_d_of_type_Int;
            d();
            break;
          }
          boolean bool;
          if (paramString.equals(Leba.class.getName()))
          {
            paramString = jdField_c_of_type_JavaLangString;
            i1 = jdField_e_of_type_Int;
            localObject = b();
            if ((localObject != null) && ((localObject instanceof Leba)))
            {
              paramString = (RedTouch)this.jdField_a_of_type_JavaUtilHashMap.get(jdField_c_of_type_JavaLangString);
              if ((paramString != null) && (paramString.a()))
              {
                bool = true;
                if (paramString != null) {
                  continue;
                }
                paramString = null;
                ((Leba)localObject).a(bool, paramString);
              }
            }
            else
            {
              break;
            }
            bool = false;
            continue;
            paramString = paramString.a();
            continue;
          }
          if (paramString.equals(QzoneFrame.class.getName()))
          {
            i1 = jdField_j_of_type_Int;
            paramString = b();
            if ((paramString != null) && ((paramString instanceof QzoneFrame)))
            {
              bool = e();
              ((QzoneFrame)paramString).a(bool);
            }
            break;
          }
          if (paramString.equals(Now.class.getName()))
          {
            i1 = jdField_g_of_type_Int;
            vei.a("story_tab", "clk", 0, ((mxu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70)).b(), new String[0]);
            break;
          }
          if (!paramString.equals(ReadinjoyTabFrame.class.getName())) {
            break label1094;
          }
          paramString = jdField_d_of_type_JavaLangString;
          i1 = jdField_h_of_type_Int;
          break;
          paramString.e(false);
          c(4);
          break label272;
          c(4);
        }
        catch (Throwable localThrowable1)
        {
          QLog.e("DynimiIcon", 2, localThrowable1, new Object[0]);
          continue;
        }
        try
        {
          TabDragAnimationView localTabDragAnimationView = (TabDragAnimationView)this.jdField_a_of_type_AndroidUtilSparseArray.get(jdField_b_of_type_Int);
          if (localTabDragAnimationView != null) {
            localTabDragAnimationView.setOnDoubleTapListener(null);
          }
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            QLog.e("DynimiIcon", 2, localThrowable2, new Object[0]);
          }
        }
        paramString.setOnModeChangeListener(null);
        continue;
        label841:
        paramString = (TabDragAnimationView)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i2);
        if ((i3 - i1 <= 0) || ((i3 != jdField_d_of_type_Int) || (i3 == jdField_h_of_type_Int))) {}
        paramString.setPressChanged(false);
      }
      label884:
      i2 = 0;
      if (i2 < this.jdField_b_of_type_AndroidUtilSparseArray.size())
      {
        if (this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i2) == i1) {}
        for (;;)
        {
          i2 += 1;
          break;
          ((TextView)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(i2)).setTextColor(getResources().getColor(2131167033));
        }
      }
      if (((!this.jdField_l_of_type_Boolean) || (!o)) || (this.jdField_a_of_type_MqqOsMqqHandler == null)) {
        this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler();
      }
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new MainFragment.6(this, i1), 100L);
      d();
      if ((ReadinjoyTabFrame.class.getName().equals(this.jdField_g_of_type_JavaLangString)) || (QzoneFrame.class.getName().equals(this.jdField_g_of_type_JavaLangString)))
      {
        b(8);
        b();
        if ((localajwk == null) || (!(localajwk instanceof Leba))) {
          break label1072;
        }
        ((Leba)localajwk).b();
      }
      while ((localajwk == null) || (!(localajwk instanceof QzoneFrame)))
      {
        return;
        b(0);
        break;
      }
      ((QzoneFrame)localajwk).c();
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
      f(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setOnDrawCompleteListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MainFragment
 * JD-Core Version:    0.7.0.1
 */