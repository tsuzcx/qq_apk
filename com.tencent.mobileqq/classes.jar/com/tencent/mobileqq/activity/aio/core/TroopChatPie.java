package com.tencent.mobileqq.activity.aio.core;

import abwp;
import abwz;
import acvv;
import aewx;
import aewy;
import aezn;
import afdm;
import afii;
import afjp;
import afjq;
import afjr;
import afjs;
import afjt;
import afju;
import afjv;
import afjw;
import afjx;
import afjy;
import afka;
import afkb;
import afkc;
import afkd;
import afke;
import afkf;
import afkg;
import afkh;
import afki;
import afkj;
import afkk;
import afkl;
import afkm;
import afkn;
import afko;
import afkp;
import afkq;
import afkr;
import afks;
import afoh;
import afpr;
import afpz;
import afqa;
import afqg;
import afqw;
import afsd;
import afss;
import afsw;
import aftj;
import agrx;
import agrz;
import agsn;
import agxe;
import ahpd;
import ahpo;
import ahpt;
import ahpv;
import ahql;
import ahqs;
import ahqw;
import ahqx;
import ahra;
import ahrf;
import alyf;
import amat;
import amlu;
import amoo;
import amop;
import amsu;
import amtj;
import amwl;
import anaj;
import anam;
import anca;
import andd;
import andl;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.LruCache;
import android.text.Editable;
import android.text.SpannableString;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import apsa;
import apsz;
import apub;
import aqdf;
import aqgr;
import aubl;
import avca;
import avcl;
import avnu;
import azbu;
import bbyp;
import bcef;
import bcek;
import bcgn;
import bcvj;
import bduz;
import bdyo;
import bdyt;
import bdzb;
import bdzi;
import bedi;
import bedr;
import bedt;
import beht;
import behu;
import bena;
import bepv;
import beqp;
import bequ;
import beri;
import betn;
import bevq;
import beyh;
import bfas;
import bfaw;
import bfba;
import bfcf;
import bfcv;
import bfdb;
import bfdg;
import bfdm;
import bfhm;
import bfhs;
import bfip;
import bfjm;
import bfkh;
import bfkq;
import bfks;
import bftc;
import bftf;
import bftk;
import bftt;
import bfur;
import bfwk;
import bfyz;
import bfzg;
import bgny;
import bhht;
import bhvd;
import bkjp;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.confess.ConfessPanel;
import com.tencent.mobileqq.activity.aio.helper.TroopAddFriendTipsHelper;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForTroopEffectPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.troop.utils.GetOnlineMemberTipsRunnable;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr.CheckHighFreqInteractionRunnable;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.widget.FloatView;
import com.tencent.mobileqq.troop.widget.TroopAIORobotLayout;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import lms;
import mqq.os.MqqHandler;
import nmy;
import nna;
import nnc;
import nnd;
import org.json.JSONArray;
import org.json.JSONException;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import vuu;
import vux;
import vvj;
import ynq;
import zqq;
import zsi;
import zsj;

public class TroopChatPie
  extends afii
{
  protected int a;
  aewy jdField_a_of_type_Aewy = new afkm(this);
  public ahpd a;
  public ahpo a;
  ahpt jdField_a_of_type_Ahpt;
  public ahpv a;
  ahqw jdField_a_of_type_Ahqw;
  ahqx jdField_a_of_type_Ahqx;
  ahra jdField_a_of_type_Ahra;
  amop jdField_a_of_type_Amop = new afjy(this);
  private final amsu jdField_a_of_type_Amsu = new afjp(this);
  protected amwl a;
  anam jdField_a_of_type_Anam = new afjr(this);
  andd jdField_a_of_type_Andd = new afjq(this);
  andl jdField_a_of_type_Andl = new afka(this);
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  Handler jdField_a_of_type_AndroidOsHandler;
  public View a;
  public LinearLayout a;
  public ScrollView a;
  Toast jdField_a_of_type_AndroidWidgetToast = null;
  bcvj jdField_a_of_type_Bcvj = new afkl(this);
  private bduz jdField_a_of_type_Bduz;
  protected bedi a;
  private behu jdField_a_of_type_Behu;
  bfba jdField_a_of_type_Bfba;
  protected bfhs a;
  protected bfjm a;
  public bfkh a;
  protected bfks a;
  protected ConfessPanel a;
  TroopBatchAddFriendMgr.CheckHighFreqInteractionRunnable jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable;
  FloatView jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView;
  protected QQCustomDialog a;
  Runnable jdField_a_of_type_JavaLangRunnable;
  protected List<afkr> a;
  private Map<Long, Long> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Observer jdField_a_of_type_JavaUtilObserver = new afkh(this);
  private Set<Long> jdField_a_of_type_JavaUtilSet = new HashSet();
  nnc jdField_a_of_type_Nnc;
  public nnd a;
  zqq jdField_a_of_type_Zqq = null;
  public int b;
  public volatile long b;
  BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver;
  public Handler b;
  View jdField_b_of_type_AndroidViewView;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener;
  public QQCustomDialog b;
  Runnable jdField_b_of_type_JavaLangRunnable = new TroopChatPie.2(this);
  private Set<Long> jdField_b_of_type_JavaUtilSet = new HashSet();
  public int c;
  private long jdField_c_of_type_Long;
  public View c;
  Runnable jdField_c_of_type_JavaLangRunnable = new TroopChatPie.35(this);
  private Set<Long> jdField_c_of_type_JavaUtilSet = new HashSet();
  protected int d;
  private long jdField_d_of_type_Long;
  public View d;
  private Runnable jdField_d_of_type_JavaLangRunnable = new GetOnlineMemberTipsRunnable(this);
  public String d;
  int jdField_e_of_type_Int = 0;
  String jdField_e_of_type_JavaLangString;
  boolean i = false;
  public boolean j;
  boolean k;
  public boolean l;
  boolean m = false;
  public boolean n = false;
  protected boolean o;
  boolean p = false;
  boolean q = true;
  boolean r = false;
  boolean s = false;
  boolean t = false;
  public boolean u;
  private boolean v;
  private boolean w;
  private boolean x;
  private boolean y;
  
  public TroopChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_b_of_type_Int = 2;
    this.jdField_d_of_type_Int = 0;
    this.jdField_b_of_type_AndroidOsHandler = new afjs(this, Looper.getMainLooper());
    this.jdField_a_of_type_Amwl = new afkg(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList(5);
  }
  
  private void A()
  {
    if (this.jdField_a_of_type_Bfkh != null)
    {
      this.jdField_a_of_type_Bfkh.a();
      this.jdField_a_of_type_Bfkh = null;
    }
  }
  
  private void B()
  {
    agrz.a(this.app);
    if (this.jdField_a_of_type_Zqq != null)
    {
      this.jdField_a_of_type_Zqq.dismiss();
      this.jdField_a_of_type_Zqq = null;
    }
    if (this.mAIOGiftPanelContainer != null) {
      this.mAIOGiftPanelContainer = null;
    }
  }
  
  private void C()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.a();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView = null;
    }
  }
  
  private void D()
  {
    if (this.jdField_a_of_type_Nnd != null)
    {
      this.jdField_a_of_type_Nnd.dismiss();
      this.jdField_a_of_type_Nnd = null;
    }
    nmy.a().b();
    if (this.jdField_d_of_type_Boolean) {
      setSystemBarColor(this.mActivity.getResources().getColor(2131167070), true);
    }
  }
  
  private void E()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
      {
        this.mContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      }
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          if (this.jdField_b_of_type_AndroidContentBroadcastReceiver != null)
          {
            this.mContext.unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
            this.jdField_b_of_type_AndroidContentBroadcastReceiver = null;
          }
          return;
          localException1 = localException1;
          if (QLog.isColorLevel()) {
            QLog.e(this.tag, 2, "doOnDestroy unregisterReceiver, e:" + localException1.getMessage());
          }
        }
      }
      catch (Exception localException2)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e(this.tag, 2, "doOnDestroy mConfessReceiver unregisterReceiver, e:" + localException2.getMessage());
      }
    }
  }
  
  private void F()
  {
    if ((this.input != null) && (this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener != null))
    {
      if (Build.VERSION.SDK_INT >= 16) {
        break label42;
      }
      this.input.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = null;
      return;
      label42:
      this.input.getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
  }
  
  private void G()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
  }
  
  private void H()
  {
    if (this.root != null)
    {
      if (Build.VERSION.SDK_INT < 21) {
        break label33;
      }
      this.root.a(8);
    }
    for (;;)
    {
      apsz.a(this.app, false);
      return;
      label33:
      this.root.a();
    }
  }
  
  private void I()
  {
    TroopInfo localTroopInfo = ((TroopManager)this.app.getManager(52)).b(this.sessionInfo.curFriendUin);
    int i1;
    if (localTroopInfo != null)
    {
      if (!localTroopInfo.isTroopOwner(this.app.getCurrentAccountUin())) {
        break label101;
      }
      i1 = 0;
    }
    for (;;)
    {
      bcef.b(this.app, "P_CliOper", "Grp_flower", "", "mber", "un", 0, 0, this.sessionInfo.curFriendUin, i1 + "", "", "");
      return;
      label101:
      if (localTroopInfo.isAdmin()) {
        i1 = 1;
      } else {
        i1 = 2;
      }
    }
  }
  
  private void J()
  {
    if (TroopInfo.isHomeworkTroop(this.app, this.sessionInfo.curFriendUin))
    {
      new bena(this.mContext, "3171", "libWXVoice.so", "WXVoice").a();
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = new afkn(this);
      }
    }
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      this.mContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
      beqp.a(this.app, this.sessionInfo.curFriendUin);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e(this.tag, 1, "register homework receiver exception.");
      }
    }
  }
  
  private void K()
  {
    if ((apsz.a(this.app, this.sessionInfo.curFriendUin)) && (this.jdField_b_of_type_AndroidContentBroadcastReceiver == null)) {
      this.jdField_b_of_type_AndroidContentBroadcastReceiver = new afko(this);
    }
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_CONFESS_START_EVENT");
      this.mContext.registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      QLog.e(this.tag, 1, "register mConfessReceiver receiver exception.");
    }
  }
  
  private void L()
  {
    ThreadManager.post(new TroopChatPie.6(this), 5, null, true);
  }
  
  private void M()
  {
    if ((this.sessionInfo == null) || (android.text.TextUtils.isEmpty(this.sessionInfo.curFriendUin))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, String.format("updateTroopHonorInteractiveIcon, troopUin: %s", new Object[] { this.sessionInfo.curFriendUin }));
    }
    bepv.a(this.app, this.mActivity, this.sessionInfo.curFriendUin, this.mCustomTitleView, this.mTitleIcon, this.mTitleIcon2, this.isJubaoMode);
  }
  
  private void N()
  {
    Object localObject;
    if (this.jdField_d_of_type_Int == 2)
    {
      localObject = (AnimationDrawable)this.mContext.getResources().getDrawable(2130843908);
      ((AnimationDrawable)localObject).setOneShot(true);
      ((AnimationDrawable)localObject).setBounds(0, 0, UIUtils.dip2px(this.mContext, 10.0F), UIUtils.dip2px(this.mContext, 10.0F));
      this.mSubTitleLeftImageView.setImageDrawable((Drawable)localObject);
      ((AnimationDrawable)localObject).start();
      this.w = true;
      return;
    }
    if (this.jdField_d_of_type_Int == 3)
    {
      localObject = this.mContext.getResources().getDrawable(2130843909);
      ((Drawable)localObject).setBounds(0, 0, UIUtils.dip2px(this.mContext, 10.0F), UIUtils.dip2px(this.mContext, 10.0F));
      this.mSubTitleLeftImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    if (this.jdField_d_of_type_Int == 4)
    {
      localObject = this.mContext.getResources().getDrawable(2130843909);
      ((Drawable)localObject).setBounds(0, 0, UIUtils.dip2px(this.mContext, 10.0F), UIUtils.dip2px(this.mContext, 10.0F));
      boolean bool = ((afsw)getHelper(43)).d();
      this.mSubTitleLeftImageView.setImageDrawable((Drawable)localObject);
      if (bool)
      {
        this.mSubTitleLeftImageView.setVisibility(8);
        return;
      }
      this.mSubTitleLeftImageView.setVisibility(0);
      return;
    }
    if (this.jdField_d_of_type_Int == 5)
    {
      localObject = this.mContext.getResources().getDrawable(2130843909);
      ((Drawable)localObject).setBounds(0, 0, UIUtils.dip2px(this.mContext, 10.0F), UIUtils.dip2px(this.mContext, 10.0F));
      this.mSubTitleLeftImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    this.helperProvider.a(3, new Object[] { Integer.valueOf(this.jdField_d_of_type_Int) });
  }
  
  private void O()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(this.mContext, 230).setTitle(this.mActivity.getString(2131718947)).setMessage(2131697026);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131697024, new afjv(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton("", null);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private void P()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(this.mContext, 230).setTitle(this.mActivity.getString(2131718947)).setMessage(2131697027);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(this.mActivity.getString(2131691122), new afjw(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(amtj.a(2131714288), new afjx(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButtonContentDescription(this.mActivity.getString(2131691122));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButtonContentDescription(amtj.a(2131714286));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private void Q()
  {
    this.jdField_a_of_type_Bduz = new afkb(this);
    this.app.registObserver(this.jdField_a_of_type_Bduz);
  }
  
  private void R()
  {
    if (!afpz.a(this)) {
      a(1);
    }
    this.titleBgView.setVisibility(8);
    if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.c()))
    {
      ImmersiveUtils.a(false, this.mActivity.getWindow());
      setSystemBarColor(-16777216, false);
      this.mInputBar.getBackground().setVisible(true, false);
      this.mInputBar.findViewById(2131377546).setVisibility(8);
      AIOUtils.setViewDrawalbe(this.mInputBar, 2130843675);
      this.mTitleText.setTextColor(nmy.jdField_c_of_type_Int);
      this.mTitleCount.setTextColor(nmy.jdField_c_of_type_Int);
      if (this.mTitleBtnLeft.getVisibility() != 0) {
        break label455;
      }
      this.mTitleBtnLeft.setBackgroundResource(2130843695);
      this.mTitleBtnLeft.setTextColor(nmy.jdField_c_of_type_Int);
      this.mTitleBubbleLeft.setTextColor(nmy.jdField_c_of_type_Int);
    }
    for (;;)
    {
      if (this.mSubTilteText.getVisibility() == 0) {
        this.oldSubTitleText = this.mSubTilteText.getText();
      }
      U();
      this.mTitleLayout.setOnClickListener(null);
      this.mSubTitleLayout.setOnClickListener(null);
      this.mSubTilteText.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.mSubTilteText.setText(this.mActivity.getResources().getString(2131690015) + nmy.a().a(this.sessionInfo.curFriendUin).jdField_a_of_type_JavaLangString);
      this.mSubTilteText.setTextColor(nmy.jdField_c_of_type_Int);
      AIOUtils.setViewDrawable(this.mTitleBtnRight, null);
      setSubTitleVisable(true);
      PlusPanel localPlusPanel = (PlusPanel)this.panelManager.a(8);
      if (localPlusPanel != null) {
        localPlusPanel.a(true);
      }
      if (this.mEmoPanel != null) {
        this.mEmoPanel.switchToAnonymous(true);
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_Nnc = new afkc(this);
      nmy.a().a(this.jdField_a_of_type_Nnc);
      this.mTipsMgr.a();
      if (this.input != null)
      {
        this.input.setHint(2131695537);
        this.input.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      }
      if (this.panelicons != null)
      {
        AIOUtils.setViewDrawalbe(this.panelicons, 2130843675);
        if (this.root.a() == 8) {
          this.panelicons.setSelected(8);
        }
      }
      ((afsw)getHelper(43)).f();
      ((afqa)getHelper(85)).a(false);
      return;
      setSystemBarColor(-16777216, false);
      break;
      label455:
      if (this.mDefaultLeftBack.getVisibility() == 0)
      {
        this.mDefaultLeftBack.setBackgroundResource(2130850594);
        this.mDefaultLeftBack.setPadding(0, 0, 0, 0);
        this.mDefautlBtnLeft.setTextColor(nmy.jdField_c_of_type_Int);
        this.mDefautlBtnLeft.setBackgroundResource(2130838008);
      }
    }
  }
  
  private void S()
  {
    if (ThemeUtil.isDefaultOrDIYTheme(false)) {
      setSystemBarDrawable(this.mActivity.getResources().getDrawable(2130846068));
    }
    for (;;)
    {
      bbyp.a(this.mActivity.mSystemBarComp, this.mActivity.getWindow());
      return;
      setSystemBarColor(this.mActivity.getResources().getColor(2131167070), true);
    }
  }
  
  private void T()
  {
    if ((bftf.b(this.sessionInfo.curFriendUin)) && (bftf.a(this.mContext))) {}
    TroopManager localTroopManager;
    Intent localIntent;
    do
    {
      return;
      localTroopManager = (TroopManager)this.app.getManager(52);
      localIntent = new Intent();
      localIntent.putExtra("troop_code", this.sessionInfo.troopUin);
      localIntent.putExtra("troop_uin", this.sessionInfo.curFriendUin);
    } while ((localTroopManager != null) && (localTroopManager.h(this.sessionInfo.troopUin)));
    TroopUtils.openTroopInfoActivityForResult(this.mActivity, localIntent.getExtras(), 1, 2000);
  }
  
  private void U()
  {
    if ((this.jdField_a_of_type_Bfkh != null) && (this.jdField_a_of_type_Bfkh.a()))
    {
      if (this.jdField_a_of_type_Bfkh.a() == 2)
      {
        setSubTitleVisable(false);
        a(0);
      }
    }
    else {
      return;
    }
    a(false);
  }
  
  private void V()
  {
    if (isFullScreenMode()) {
      return;
    }
    if (this.jdField_a_of_type_Ahpt == null) {
      this.jdField_a_of_type_Ahpt = new ahpt(this.app, this.mActivity, this.sessionInfo, this.app.getCurrentAccountUin());
    }
    this.jdField_a_of_type_Ahpt.a(this.mTipsMgr);
  }
  
  private void W()
  {
    if (this.y) {
      return;
    }
    ((apsa)this.app.getManager(269)).b(this.sessionInfo.curFriendUin);
    this.y = true;
  }
  
  private void X()
  {
    ThreadManager.post(new TroopChatPie.36(this), 8, null, true);
  }
  
  private void Y()
  {
    TroopChatPie.37 local37 = new TroopChatPie.37(this);
    ThreadManager.getSubThreadHandler().post(local37);
  }
  
  private void Z()
  {
    boolean bool3 = false;
    if ((!this.p) && (this.sessionInfo.curType == 1)) {}
    for (boolean bool1 = d();; bool1 = false)
    {
      if (!bool1) {
        if ((this.jdField_a_of_type_Zqq != null) && (this.jdField_a_of_type_Zqq.isShowing())) {
          bool1 = true;
        }
      }
      for (;;)
      {
        Object localObject = (beyh)this.app.getManager(223);
        if (localObject != null) {}
        for (boolean bool2 = ((beyh)localObject).a(this.sessionInfo.curFriendUin);; bool2 = false)
        {
          if ((localObject != null) && (bool2) && (bool1)) {
            ((beyh)localObject).b = false;
          }
          if ((!bool1) && (bool2))
          {
            beyh.jdField_a_of_type_Boolean = true;
            playGiftAnimationPlayList(true);
          }
          localObject = avcl.a(this);
          if (localObject != null)
          {
            if (!bool1)
            {
              bool1 = bool3;
              if (!bool2) {}
            }
            else
            {
              bool1 = true;
            }
            ((avcl)localObject).a(bool1);
          }
          return;
          bool1 = false;
          break;
        }
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 1) {
      switch (paramInt2)
      {
      }
    }
    do
    {
      return;
      paramString = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(5, 1, 0, this.mActivity.getString(2131689995));
      this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramString);
      return;
      paramString = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(5, 1, 0, this.mActivity.getString(2131689989));
      this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramString);
      return;
      Object localObject = paramString;
      if (android.text.TextUtils.isEmpty(paramString)) {
        localObject = this.mActivity.getResources().getString(2131695542);
      }
      paramString = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(5, 1, 0, localObject);
      this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramString);
      return;
      localObject = paramString;
      if (android.text.TextUtils.isEmpty(paramString)) {
        localObject = this.mActivity.getResources().getString(2131695534);
      }
      paramString = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(5, 1, 0, localObject);
      this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramString);
      return;
      localObject = (TroopManager)this.app.getManager(52);
      if ((localObject != null) && (((TroopManager)localObject).h(this.sessionInfo.troopUin)))
      {
        ((TroopManager)localObject).j(this.sessionInfo.troopUin);
        return;
      }
    } while (android.text.TextUtils.isEmpty(paramString));
    paramString = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(5, 1, 0, paramString);
    this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramString);
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            int i1;
            do
            {
              do
              {
                return;
                localObject = AIOUtils.setOpenAIOIntent(new Intent(this.mActivity, SplashActivity.class), null);
                ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
                this.mActivity.startActivity((Intent)localObject);
                return;
                a(paramIntent);
                return;
                bfcv.a(this.mActivity, paramIntent, this.app);
                return;
                hidePanel();
                paramInt = this.input.getSelectionStart();
              } while (paramInt <= 0);
              i1 = this.input.getText().charAt(paramInt - 1);
            } while ((i1 != 36) && (i1 != 65509) && (i1 != 165) && (i1 != 65284));
            this.input.removeTextChangedListener(this);
            this.input.setText(this.input.getText().delete(paramInt - 1, paramInt));
            this.input.addTextChangedListener(this);
            this.input.setSelection(paramInt - 1);
            return;
          } while (this.mAIOGiftPanelContainer == null);
          localObject = this.mAIOGiftPanelContainer.a();
        } while (localObject == null);
        ((TroopGiftPanel)localObject).a(paramIntent.getStringExtra("member_uin"), paramIntent.getStringExtra("member_display_name"));
        return;
        paramIntent = paramIntent.getStringExtra("result");
        localObject = ((TroopManager)this.app.getManager(52)).c(this.sessionInfo.curFriendUin);
      } while ((android.text.TextUtils.isEmpty(paramIntent)) || (localObject == null) || (paramIntent.equals(((TroopInfo)localObject).troopname)));
      ((amoo)this.app.getBusinessHandler(22)).a(this.sessionInfo.curFriendUin, paramIntent, false);
      this.sessionInfo.curFriendNick = paramIntent;
      Object localObject = this.mActivity.getIntent();
      ((Intent)localObject).putExtra("uinname", paramIntent);
      updateSession_updateTitle((Intent)localObject);
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel.a(paramInt, paramIntent);
  }
  
  private void a(Intent paramIntent)
  {
    Object localObject = paramIntent.getExtras().getString("troop_uin");
    if ((!android.text.TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equalsIgnoreCase(this.sessionInfo.curFriendUin))) {}
    String str2;
    String str1;
    do
    {
      return;
      str2 = paramIntent.getExtras().getString("member_uin");
      str1 = paramIntent.getExtras().getString("member_display_name");
      if ((!paramIntent.getExtras().getBoolean("isApollo")) || (this.mApolloInfo == null)) {
        break;
      }
    } while ("0".equals(str2));
    paramIntent = null;
    if (!b()) {
      paramIntent = ContactUtils.getTroopMemberNameWithoutRemark(this.app, this.sessionInfo.curFriendUin, str2);
    }
    localObject = paramIntent;
    if (android.text.TextUtils.isEmpty(paramIntent)) {
      localObject = str1;
    }
    paramIntent = new StringBuilder("@").append((String)localObject);
    this.mApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.peerUin = str2;
    this.mApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.atNickName = paramIntent.toString();
    this.mApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText = com.tencent.mobileqq.text.TextUtils.emoticonToText(this.input.getText().toString());
    this.input.getText().clear();
    send(this.mApolloInfo);
    int i1 = 0;
    int i2;
    String str3;
    if (android.text.TextUtils.isEmpty(this.mApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText))
    {
      i2 = 2;
      i1 = i2;
      if (!android.text.TextUtils.isEmpty(this.mApolloInfo.jdField_b_of_type_JavaLangString))
      {
        if (this.mApolloInfo.jdField_d_of_type_Int == 0) {
          i1 = 6;
        }
      }
      else
      {
        localObject = this.app;
        str1 = this.sessionInfo.curFriendUin;
        i2 = ApolloUtil.b(this.sessionInfo.curType);
        str2 = "" + this.mApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId;
        str3 = "655_" + this.mApolloInfo.jdField_a_of_type_Int;
        if (!android.text.TextUtils.isEmpty(this.mApolloInfo.jdField_b_of_type_JavaLangString)) {
          break label497;
        }
      }
    }
    label497:
    for (paramIntent = "0";; paramIntent = this.mApolloInfo.jdField_b_of_type_JavaLangString)
    {
      VipUtils.a((AppInterface)localObject, "cmshow", "Apollo", "g_action_double_sent", str1, i1, i2, new String[] { str2, str3, paramIntent, this.mApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.peerUin, String.valueOf(System.currentTimeMillis() / 1000L) });
      return;
      i1 = i2;
      if (this.mApolloInfo.jdField_d_of_type_Int != 1) {
        break;
      }
      i1 = 7;
      break;
      if (android.text.TextUtils.isEmpty(this.mApolloInfo.jdField_b_of_type_JavaLangString))
      {
        i1 = 3;
        break;
      }
      if (this.mApolloInfo.jdField_d_of_type_Int == 0)
      {
        i1 = 4;
        break;
      }
      if (this.mApolloInfo.jdField_d_of_type_Int != 1) {
        break;
      }
      i1 = 5;
      break;
    }
    a(str2, str1, true, 4);
  }
  
  private void a(bkjp parambkjp, boolean paramBoolean)
  {
    a(6);
    setSubTitleVisable(true);
    boolean bool = parambkjp.a();
    this.mSubTilteText.setText(parambkjp.a(bool));
    this.mSubTilteText.setTextColor(this.mActivity.getResources().getColor(2131167009));
    a(bool);
    int i1 = AIOUtils.dp2px(8.0F, this.mSubTilteText.getResources());
    avca.a(this.mSubTitleLayout, 0, i1, 0, 0, this.mAIORootView.getRootView());
    if (QLog.isColorLevel()) {
      QLog.d("IliveGroupTipsBarHelper", 2, "onSubTitleChanged. isIliveTime=" + paramBoolean + ",isTipsShow=" + bool);
    }
  }
  
  private void a(TroopManager paramTroopManager, TroopInfo paramTroopInfo)
  {
    if ((!this.t) && (paramTroopManager.a.jdField_a_of_type_Boolean) && (paramTroopInfo != null) && (paramTroopInfo.isTroopOwner(this.app.getCurrentAccountUin())))
    {
      int i1 = paramTroopManager.b(this.sessionInfo.curFriendUin);
      if ((i1 < 3) && (paramTroopInfo.wMemberMax < 2000) && (paramTroopInfo.wMemberNum >= 500))
      {
        if (this.jdField_a_of_type_Ahra == null)
        {
          this.jdField_a_of_type_Ahra = new ahra(this.app, this.mActivity, this.mTipsMgr);
          this.mTipsMgr.a(this.jdField_a_of_type_Ahra);
        }
        this.jdField_a_of_type_Ahra.a(this.sessionInfo.curFriendUin);
        if (this.mTipsMgr.a(this.jdField_a_of_type_Ahra, new Object[0]))
        {
          this.t = true;
          paramTroopManager.b(this.sessionInfo.curFriendUin, i1 + 1);
          bcef.b(this.app, "dc00899", "Grp_up", "", "Grp_AIO", "exp", 0, 0, this.sessionInfo.curFriendUin, "", "", "");
        }
      }
    }
  }
  
  private void a(TroopInfo paramTroopInfo)
  {
    int i1;
    if ((paramTroopInfo != null) && (TroopInfo.hasPayPrivilege(paramTroopInfo.troopPrivilegeFlag, 32)))
    {
      if (!paramTroopInfo.isTroopOwner(this.app.getCurrentAccountUin())) {
        break label124;
      }
      i1 = 0;
    }
    for (;;)
    {
      bcef.b(this.app, "P_CliOper", "Grp_flower", "", "grp_aio", "sign", 0, 0, paramTroopInfo.troopuin + "", i1 + "", "", "");
      bfcv.a(this.mActivity, paramTroopInfo.troopuin, "input", this.app);
      return;
      label124:
      if (paramTroopInfo.isAdmin()) {
        i1 = 1;
      } else {
        i1 = 2;
      }
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "clearBAFGrayTipSP troopUin=" + paramString1);
    }
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.app.getApp());
    paramString1 = String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag_members", paramString2, paramString1 });
    localSharedPreferences.edit().putLong(paramString1, 0L).apply();
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {}
    label172:
    label236:
    do
    {
      return;
      bfkq localbfkq = (bfkq)this.app.getManager(234);
      String str = localbfkq.a(paramString);
      ((avcl)getHelper(33)).c();
      if ((!this.jdField_d_of_type_Boolean) && (!android.text.TextUtils.isEmpty(str)) && (!afpz.a(this)))
      {
        if (this.jdField_d_of_type_Int != 2)
        {
          a(2);
          if (paramBoolean)
          {
            if (localbfkq.a(paramString) != 3) {
              break label172;
            }
            bftc.a("Grp_idol", "Grp_AIO", "exp_renshu", 0, 0, new String[] { paramString });
          }
        }
        for (;;)
        {
          setSubTitleVisable(true);
          this.mSubTilteText.setText(str);
          this.mSubTitleLeftImageView.setVisibility(0);
          if (this.jdField_a_of_type_Bfkh == null) {
            break label236;
          }
          this.jdField_a_of_type_Bfkh.a(paramString);
          if (!this.jdField_a_of_type_Bfkh.a()) {
            break;
          }
          this.jdField_a_of_type_Bfkh.d();
          c(true);
          return;
          new bcek(this.app).a("dc00899").b("Grp_online").c("Grp_AIO").d("exp_onlineEntry").a(new String[] { getSessionInfo().curFriendUin }).a();
        }
        c(false);
        return;
        c(false);
        return;
      }
    } while ((this.jdField_d_of_type_Boolean) || (afpz.a(this)));
    setSubTitleVisable(false);
    this.mSubTilteText.setText("");
    this.mSubTitleLeftImageView.setVisibility(8);
  }
  
  private void a(List<oidb_0x899.memberlist> paramList)
  {
    ThreadManager.post(new TroopChatPie.13(this, paramList), 8, null, true);
  }
  
  private boolean a(bfdb parambfdb)
  {
    if (parambfdb.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_JavaUtilSet.remove(Long.valueOf(parambfdb.jdField_b_of_type_Long));
      this.jdField_b_of_type_JavaUtilSet.remove(Long.valueOf(parambfdb.jdField_a_of_type_Long));
      this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(parambfdb.jdField_a_of_type_Long));
      this.jdField_c_of_type_JavaUtilSet.add(Long.valueOf(parambfdb.jdField_b_of_type_Long));
      setScrollToMsgseq(parambfdb.jdField_a_of_type_Long);
      refresh(131089);
      return true;
    }
    if (parambfdb.jdField_a_of_type_Int == 2)
    {
      this.jdField_a_of_type_JavaUtilSet.add(Long.valueOf(parambfdb.jdField_b_of_type_Long));
      this.jdField_b_of_type_JavaUtilSet.add(Long.valueOf(parambfdb.jdField_a_of_type_Long));
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(parambfdb.jdField_a_of_type_Long), Long.valueOf(parambfdb.jdField_b_of_type_Long));
      this.jdField_c_of_type_JavaUtilSet.remove(Long.valueOf(parambfdb.jdField_b_of_type_Long));
      setScrollToMsgseq(parambfdb.jdField_a_of_type_Long);
      refresh(131089);
      return true;
    }
    return false;
  }
  
  private boolean a(CharSequence paramCharSequence, int paramInt)
  {
    return (paramCharSequence.charAt(paramInt) == '$') || (paramCharSequence.charAt(paramInt) == 65509) || (paramCharSequence.charAt(paramInt) == '¥') || (paramCharSequence.charAt(paramInt) == 65284);
  }
  
  private boolean a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    return (paramInt2 == 1) && (a(paramCharSequence, paramInt1)) && (!this.isBeingInputDraft) && (!((afsd)getHelper(27)).jdField_a_of_type_Boolean);
  }
  
  private boolean a(List<ChatMessage> paramList, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    return (paramBoolean1) && (!this.isJubaoMode) && (!paramBoolean2) && (paramInt > 1) && (paramList.size() >= paramInt);
  }
  
  private long[] a(Set<Long> paramSet)
  {
    long[] arrayOfLong = null;
    int i1 = bfwk.a(paramSet);
    if (i1 > 0)
    {
      arrayOfLong = new long[i1];
      paramSet = paramSet.iterator();
      i1 = 0;
      while (paramSet.hasNext())
      {
        arrayOfLong[i1] = ((Long)paramSet.next()).longValue();
        i1 += 1;
      }
    }
    return arrayOfLong;
  }
  
  private void aa()
  {
    this.x = false;
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_b_of_type_JavaUtilSet.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_c_of_type_JavaUtilSet.clear();
    this.jdField_d_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
  }
  
  private void b(Intent paramIntent)
  {
    if ((this.jdField_a_of_type_Ahqx != null) && (this.jdField_a_of_type_Ahqx.a()) && (avnu.a().b(this.app, this.sessionInfo.curFriendUin))) {
      this.mTipsMgr.a();
    }
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("KEY_SHOULD_SHOW_KEYBOARD", false))) {
      getActivity().getIntent().putExtra("KEY_SHOULD_SHOW_KEYBOARD", true);
    }
  }
  
  private void b(TroopInfo paramTroopInfo)
  {
    String str2 = "2";
    try
    {
      String str3 = this.app.getCurrentAccountUin();
      String str1;
      if ((paramTroopInfo.troopowneruin != null) && (paramTroopInfo.troopowneruin.equals(str3))) {
        str1 = "0";
      }
      for (;;)
      {
        bcef.b(this.app, "P_CliOper", "Grp_mber", "", "mber_list", "Clk_mberlist", 0, 0, paramTroopInfo.troopuin, "2", str1, "");
        return;
        str1 = str2;
        if (paramTroopInfo.Administrator != null)
        {
          str1 = str2;
          if (paramTroopInfo.Administrator.contains(str3)) {
            str1 = "1";
          }
        }
      }
      return;
    }
    catch (Exception paramTroopInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "onTextChanged() has an exception.", paramTroopInfo);
      }
    }
  }
  
  private void b(Object paramObject)
  {
    MessageRecord localMessageRecord;
    if ((paramObject instanceof ChatMessage))
    {
      localMessageRecord = (MessageRecord)paramObject;
      this.jdField_b_of_type_Long = localMessageRecord.shmsgseq;
      if (localMessageRecord.isSendFromLocal()) {
        break label123;
      }
      if ((this.sessionInfo.curFriendUin.equals(localMessageRecord.frienduin)) && ((this.sessionInfo.curType == localMessageRecord.istroop) || ((abwz.d(this.sessionInfo.curType)) && (abwz.d(localMessageRecord.istroop)))) && (this.mActivity.isResume()) && ((paramObject instanceof MessageForTroopEffectPic))) {
        playGiftAnimationPlayList(false);
      }
    }
    for (;;)
    {
      paramObject = (TroopAddFriendTipsHelper)getHelper(28);
      if (paramObject != null) {
        paramObject.a(localMessageRecord);
      }
      return;
      label123:
      if ((((anca)this.app.getBusinessHandler(20)).a().b("highFreqInteract")) && (!this.k))
      {
        this.k = true;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable == null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable = new TroopBatchAddFriendMgr.CheckHighFreqInteractionRunnable(this, this.app);
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable.a(false);
        ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable);
      }
    }
  }
  
  private void b(String paramString)
  {
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    this.jdField_e_of_type_JavaLangString = paramString;
    ThreadManager.getSubThreadHandler().post(this.jdField_c_of_type_JavaLangRunnable);
  }
  
  private void c(Intent paramIntent)
  {
    this.y = false;
    String str = paramIntent.getStringExtra("uin");
    this.m = ((apsa)this.app.getManager(269)).b(str, paramIntent);
  }
  
  private void c(boolean paramBoolean)
  {
    if ((!this.w) && (!paramBoolean) && (this.jdField_d_of_type_Int == 2)) {
      a(false);
    }
  }
  
  private void d(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 12006: 
    case 6001: 
      do
      {
        return;
        if (nmy.a().a(this.sessionInfo.curFriendUin)) {}
        for (paramInt = 2;; paramInt = 1)
        {
          bcef.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_choosecancel", paramInt, 0, this.sessionInfo.curFriendUin, "", "", "");
          return;
        }
      } while (!this.sessionInfo.debugFilterMemberMsgCommand);
      BaseChatpieHelper.a(this.sessionInfo, this.input, this.mFunBtn, false);
      return;
    }
    H();
  }
  
  private void d(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  private void e(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "inputing @ in TroopChatPie.");
    }
    TroopInfo localTroopInfo = ((TroopManager)this.app.getManager(52)).b(this.sessionInfo.curFriendUin);
    if (localTroopInfo != null)
    {
      localIntent = TroopMemberListActivity.a(this.mActivity, localTroopInfo.troopuin, 3);
      localIntent.putExtra("param_is_pop_up_style", true);
      localIntent.setFlags(603979776);
      if (this.jdField_d_of_type_Boolean)
      {
        localIntent.putExtra("param_chat_mode", 1);
        bool = e();
        if (QLog.isColorLevel()) {
          QLog.d(this.tag, 2, "open TroopMemberListActivity, needfilterrobot:" + bool);
        }
        if (bool) {
          localIntent.putExtra("param_filter_robot", true);
        }
        if (super.getCurrentPanel() == 21) {
          localIntent.putExtra("param_troop_send_apollo_msg", true);
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.tag, 2, "open TroopMemberListActivity to choose @ user target.");
        }
        this.mActivity.startActivityForResult(localIntent, 6001);
        if (paramInt != 1) {
          break label214;
        }
      }
    }
    label214:
    while (!QLog.isColorLevel())
    {
      for (;;)
      {
        Intent localIntent;
        boolean bool;
        return;
        localIntent.putExtra("param_chat_mode", 0);
      }
      b(localTroopInfo);
      return;
    }
    QLog.d(this.tag, 2, "onTextChanged(). troopInfo is null. while inputing @.  troopUin is " + this.sessionInfo.curFriendUin);
  }
  
  private boolean e()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    bfdm localbfdm = (bfdm)this.app.getManager(203);
    Object localObject = null;
    if (this.input != null) {
      localObject = this.input.getEditableText();
    }
    if (localObject == null)
    {
      bool2 = bool1;
      return bool2;
    }
    localObject = (bevq[])((Editable)localObject).getSpans(0, localObject.toString().length(), bevq.class);
    int i1 = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i1 < localObject.length)
      {
        if (localbfdm.b(localObject[i1].a())) {
          bool1 = true;
        }
      }
      else
      {
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(this.tag, 2, "needFilterRobot : " + bool1);
        return bool1;
      }
      i1 += 1;
    }
  }
  
  private void t()
  {
    bfdm localbfdm = (bfdm)this.app.getManager(203);
    localbfdm.a(this.sessionInfo.curFriendUin, this.jdField_b_of_type_JavaLangString, "off");
    localbfdm.a(null);
  }
  
  private void u()
  {
    ((vuu)vux.a(5)).c();
    ((vvj)vux.a(2)).d();
    ((ynq)this.app.getManager(208)).a();
  }
  
  private void v()
  {
    bfas localbfas = (bfas)this.app.getManager(132);
    localbfas.e("");
    if (localbfas.b(this.sessionInfo.curFriendUin)) {
      localbfas.b(this.sessionInfo.curFriendUin);
    }
  }
  
  private void w()
  {
    if (this.mCustomTitleView != null)
    {
      this.mCustomTitleView.c(false);
      this.mCustomTitleView.b(false);
    }
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_Bedi != null) {
      this.jdField_a_of_type_Bedi.e();
    }
  }
  
  private void y()
  {
    if (this.jdField_a_of_type_Behu != null) {
      this.jdField_a_of_type_Behu.b();
    }
  }
  
  private void z()
  {
    if (this.jdField_a_of_type_Bfks != null)
    {
      this.jdField_a_of_type_Bfks.b();
      this.jdField_a_of_type_Bfks = null;
    }
  }
  
  public ahqs a()
  {
    return this.mTipsMgr;
  }
  
  public ahqw a()
  {
    return this.jdField_a_of_type_Ahqw;
  }
  
  public ViewGroup a()
  {
    return this.mTitleLayout;
  }
  
  public ImageView a()
  {
    return this.mSubTitleLeftImageView;
  }
  
  public RelativeLayout a()
  {
    return this.mTitleBtnRightLayout;
  }
  
  public bedi a()
  {
    if (this.jdField_a_of_type_Bedi == null) {
      this.jdField_a_of_type_Bedi = new bedi(this.app, (RelativeLayout)this.mAIORootView.findViewById(2131364407));
    }
    return this.jdField_a_of_type_Bedi;
  }
  
  public bfjm a()
  {
    if (this.jdField_a_of_type_Bfjm == null)
    {
      this.jdField_a_of_type_Bfjm = new bfjm();
      this.jdField_a_of_type_Bfjm.a(this);
    }
    return this.jdField_a_of_type_Bfjm;
  }
  
  public bfks a()
  {
    if (this.jdField_a_of_type_Bfks == null) {
      this.jdField_a_of_type_Bfks = new bfks(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    }
    return this.jdField_a_of_type_Bfks;
  }
  
  public PanelIconLinearLayout a()
  {
    return this.panelicons;
  }
  
  String a(TroopMemberInfo paramTroopMemberInfo)
  {
    int i1 = (int)(paramTroopMemberInfo.mUniqueTitleExpire - NetConnInfoCenter.getServerTime()) / 86400;
    return String.format("<{\"text\":\"%1$s\", \"cmd\": \"5\", \"data\":\"%2$s\"}>专属头衔\"%3$s\"将在%4$d天后到期，<{\"text\":\"点击续期\", \"cmd\": \"3\", \"data_a\":\"mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.troop.EditUniqueTitleActivity&troopUin=%5$s&memberUin=%2$s&uniqueTitle=%6$s&uniqueTitleExpire=%7$d&from=2\"}>", new Object[] { paramTroopMemberInfo.friendnick, paramTroopMemberInfo.memberuin, paramTroopMemberInfo.mUniqueTitle, Integer.valueOf(i1 + 1), this.sessionInfo.curFriendUin, paramTroopMemberInfo.mUniqueTitle, Integer.valueOf(paramTroopMemberInfo.mUniqueTitleExpire) });
  }
  
  public void a()
  {
    super.a();
    if ((this.mTroopTips != null) && (!a())) {
      this.mTroopTips.a().e();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    if ((this.mSubTitleLeftImageView == null) || (this.mTitleLayout == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.tag, 2, "changeSubTitleType, not init ui");
      }
      return;
    }
    if (paramInt == 3)
    {
      this.mSubTitleLeftImageView.setVisibility(0);
      this.mTitleLayout.setOnClickListener(this);
      this.mSubTitleLayout.setOnClickListener(this);
    }
    for (;;)
    {
      this.helperProvider.a(2, new Object[] { Integer.valueOf(paramInt) });
      return;
      if (paramInt == 4)
      {
        if (((afsw)getHelper(43)).d()) {
          this.mSubTitleLeftImageView.setVisibility(8);
        }
        for (;;)
        {
          this.mTitleLayout.setOnClickListener(this);
          this.mSubTitleLayout.setOnClickListener(this);
          break;
          this.mSubTitleLeftImageView.setVisibility(0);
        }
      }
      if (paramInt == 2)
      {
        this.mSubTitleLeftImageView.setVisibility(0);
        this.mTitleLayout.setOnClickListener(this);
        this.mSubTitleLayout.setOnClickListener(this);
      }
      else if (paramInt == 5)
      {
        this.mSubTitleLeftImageView.setVisibility(0);
        this.mTitleLayout.setOnClickListener(this);
        this.mSubTitleLayout.setOnClickListener(this);
      }
      else
      {
        this.mSubTitleLeftImageView.setVisibility(8);
        this.mTitleLayout.setOnClickListener(this);
        this.mSubTitleLayout.setOnClickListener(null);
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Nnd == null) {
      this.jdField_a_of_type_Nnd = new nnd(this.mActivity);
    }
    this.jdField_a_of_type_Nnd.a(paramInt, paramString);
    this.jdField_a_of_type_Nnd.show();
    TroopChatPie.29 local29;
    if ((paramInt == 1) || (paramInt == 3))
    {
      paramString = this.uiHandler;
      local29 = new TroopChatPie.29(this);
      if (!AppSetting.jdField_c_of_type_Boolean) {
        break label82;
      }
    }
    label82:
    for (long l1 = 3000L;; l1 = 1000L)
    {
      paramString.postDelayed(local29, l1);
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    TroopManager.a(this.app, this.sessionInfo.curFriendUin, paramLong1, paramLong2, new afkp(this, false));
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("troop.credit.act", 2, "showLowCreditLevelDialog:" + this.sessionInfo.curFriendUin + "," + paramLong + "," + paramBoolean);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      if ((paramLong == 1L) || (paramLong == 2L)) {
        if (QLog.isColorLevel()) {
          QLog.i("troop.credit.act", 2, "showLowCreditLevelDialog, CreditLevelTipDialog isShowing:" + this.sessionInfo.curFriendUin + "," + paramLong + "," + paramBoolean);
        }
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      if (paramLong == 1L)
      {
        P();
        new bcek(this.app).a("dc00899").b("Grp_banned").c("Grp_AIO").d("exp_msgbox").a(new String[] { this.sessionInfo.curFriendUin }).a();
        return;
      }
      if ((paramLong == 2L) && (!paramBoolean))
      {
        O();
        return;
      }
    } while ((paramLong != 2L) || (!paramBoolean));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(this.mContext, 230).setTitle(this.mActivity.getString(2131718947)).setMessage(2131697025);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131697024, new afjt(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131697023, new afju(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void a(afkr paramafkr)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramafkr);
  }
  
  public void a(bfcf parambfcf)
  {
    afqg localafqg = (afqg)getHelper(83);
    if (parambfcf.jdField_a_of_type_Boolean) {
      if ((1 != this.root.a()) && (3 != this.root.a()) && (8 != this.root.a()) && ((this.mInputStat != 1) || (this.fateOfRecorder != 0)))
      {
        doDisableInputStat();
        if (this.mGagInputBtn != null)
        {
          QLog.d("troop_gag", 1, "fightgag.updateGagStatus_UI:" + parambfcf.jdField_b_of_type_JavaLangString);
          this.mGagInputBtn.setText(parambfcf.jdField_b_of_type_JavaLangString);
        }
        if (QLog.isColorLevel()) {
          QLog.d("troop_gag", 2, "updateGagStatus_UI, sendEmptyMessageDelayed-TIMER_ID:" + parambfcf.jdField_a_of_type_Long + ", hasDestory=" + this.hasDestory);
        }
        if (!this.hasDestory)
        {
          this.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
          this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, parambfcf.jdField_a_of_type_Long * 1000L);
        }
        localafqg.a(false);
        if (QLog.isColorLevel()) {
          QLog.d("fastimage", 2, "updateGagStatus disable fastimage,  mAllowFastImage = " + localafqg.a());
        }
      }
    }
    do
    {
      return;
      this.o = true;
      break;
      this.o = false;
      b();
      localafqg.a();
    } while (!QLog.isColorLevel());
    QLog.d("fastimage", 2, "updateGagStatus enable fastimage,  mAllowFastImage = " + localafqg.a());
  }
  
  public void a(bfcf parambfcf, boolean paramBoolean)
  {
    if (this.sessionInfo.curType == 1)
    {
      if (parambfcf == null) {
        ThreadManager.post(new TroopChatPie.16(this, paramBoolean), 8, null, true);
      }
    }
    else {
      return;
    }
    a(parambfcf);
  }
  
  public void a(String paramString)
  {
    if (getActivity().isFinishing()) {}
    do
    {
      return;
      if (this.mProgressDialog == null) {
        this.mProgressDialog = new bhht(getActivity(), getActivity().getTitleBarHeight());
      }
      this.mProgressDialog.a(paramString);
    } while ((getActivity().isFinishing()) || (this.mProgressDialog.isShowing()));
    this.mProgressDialog.show();
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    bfdm localbfdm = (bfdm)this.app.getManager(203);
    if ((localbfdm.a(this.sessionInfo.curFriendUin)) && (localbfdm.b(paramString1)))
    {
      if (e()) {
        return;
      }
      this.jdField_b_of_type_JavaLangString = paramString1;
      localbfdm.jdField_e_of_type_JavaLangString = paramString1;
      this.jdField_c_of_type_JavaLangString = paramString2;
    }
    super.a(paramString1, paramString2, paramBoolean, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = (LinearLayout.LayoutParams)this.mSubTitleLeftImageView.getLayoutParams();
    this.mSubTitleLeftImageView.setScaleType(ImageView.ScaleType.CENTER);
    ((LinearLayout.LayoutParams)localObject).width = UIUtils.dip2px(this.mContext, 15.0F);
    ((LinearLayout.LayoutParams)localObject).height = UIUtils.dip2px(this.mContext, 15.0F);
    ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
    try
    {
      localObject = this.mContext.getResources();
      int i1;
      if (paramBoolean)
      {
        i1 = 2130843902;
        localObject = ((Resources)localObject).getDrawable(i1);
        if ((!bbyp.b()) && (!"2105".equals(ThemeUtil.curThemeId))) {
          break label185;
        }
        ((Drawable)localObject).setColorFilter(this.mActivity.getResources().getColor(2131167009), PorterDuff.Mode.MULTIPLY);
      }
      for (;;)
      {
        if (!paramBoolean) {
          break label217;
        }
        Drawable localDrawable = this.mSubTitleLeftImageView.getDrawable();
        if ((localDrawable instanceof AnimationDrawable)) {
          ((AnimationDrawable)localDrawable).stop();
        }
        ((Drawable)localObject).setBounds(0, 0, UIUtils.dip2px(this.mContext, 10.0F), UIUtils.dip2px(this.mContext, 10.0F));
        this.mSubTitleLeftImageView.setImageDrawable((Drawable)localObject);
        return;
        i1 = 2130843909;
        break;
        label185:
        if (!ThemeUtil.isNowThemeIsNight(this.app, false, null)) {
          ((Drawable)localObject).clearColorFilter();
        } else {
          ((Drawable)localObject).setColorFilter(-9136456, PorterDuff.Mode.MULTIPLY);
        }
      }
      label217:
      if ((Build.VERSION.SDK_INT < 21) || (this.w))
      {
        ((Drawable)localObject).setBounds(0, 0, UIUtils.dip2px(this.mContext, 10.0F), UIUtils.dip2px(this.mContext, 10.0F));
        this.mSubTitleLeftImageView.setImageDrawable((Drawable)localObject);
        return;
      }
      N();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = getSessionInfo();
    } while ((android.text.TextUtils.isEmpty(((SessionInfo)localObject1).curFriendUin)) || (paramObject == null));
    for (;;)
    {
      int i1;
      try
      {
        paramObject = (Object[])paramObject;
        long l1 = ((Long)paramObject[0]).longValue();
        if (Long.parseLong(((SessionInfo)localObject1).curFriendUin) != l1) {
          break;
        }
        localObject1 = (TroopMemberCard)paramObject[2];
        i1 = this.listView.getFirstVisiblePosition();
        int i2 = this.listView.getLastVisiblePosition();
        if (i1 > i2) {
          break label425;
        }
        Object localObject2 = this.listView.getAdapter().getItem(i1);
        if (!(localObject2 instanceof MessageForQQWalletTips)) {
          break label549;
        }
        localObject2 = (MessageForQQWalletTips)localObject2;
        if ((((MessageForQQWalletTips)localObject2).istroop != 1) || (localObject1 == null) || (!((MessageForQQWalletTips)localObject2).memberUin.equals(String.valueOf(((TroopMemberCard)localObject1).memberUin))) || (!((MessageForQQWalletTips)localObject2).frienduin.equals(String.valueOf(l1))) || ((TroopManager)this.app.getManager(52) == null)) {
          break label549;
        }
        Object localObject3 = ((TroopMemberCard)localObject1).nick;
        if (QLog.isColorLevel()) {
          QLog.d(this.tag, 2, "handGetTroopMemberCard troopUin=" + ((MessageForQQWalletTips)localObject2).frienduin + ", memberUin=" + ((MessageForQQWalletTips)localObject2).memberUin + ",card=" + ((TroopMemberCard)localObject1).card + ",remark=" + ((TroopMemberCard)localObject1).remark + ",nick=" + ((TroopMemberCard)localObject1).nick + ",saveTroopMemberEx succ=" + true);
        }
        localObject3 = AIOUtils.getViewByPostion(this.listView, i1);
        if (QLog.isColorLevel()) {
          QLog.d(this.tag, 2, "handGetTroopMemberCard ref itemView=" + localObject3 + ",index=" + i1);
        }
        if (localObject3 == null) {
          break label549;
        }
        localObject3 = (TextView)((View)localObject3).findViewById(2131367701);
        ((MessageForQQWalletTips)localObject2).buildQQWalletTips(this.app, this.mContext, (TextView)localObject3);
      }
      catch (Throwable paramObject) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w(this.tag, 2, "handGetTroopMemberCard e=" + paramObject);
      return;
      label425:
      if ((localObject1 == null) || (!android.text.TextUtils.equals(this.app.getCurrentAccountUin(), String.valueOf(((TroopMemberCard)localObject1).memberUin)))) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, new Object[] { "handleGetTroopMemberCard. memberUin = ", this.app.getCurrentAccountUin() });
      }
      if ((this.jdField_a_of_type_Behu != null) && ((this.jdField_a_of_type_Behu.a instanceof beqp)))
      {
        localObject1 = (beqp)this.jdField_a_of_type_Behu.a;
        if (((Boolean)paramObject[3]).booleanValue()) {
          break label544;
        }
      }
      label544:
      for (paramBoolean = true;; paramBoolean = false)
      {
        ((beqp)localObject1).a(paramBoolean, null, this);
        V();
        return;
      }
      label549:
      i1 += 1;
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (!this.u)
    {
      int i1 = this.listView.getFirstVisiblePosition();
      int i3 = this.listView.getLastVisiblePosition();
      int i2 = this.listView.getHeaderViewsCount();
      if (i1 > i2) {}
      for (;;)
      {
        bool2 = bool1;
        if (i1 < i2) {
          break label197;
        }
        bool2 = bool1;
        if (i1 > i3) {
          break label197;
        }
        try
        {
          Object localObject = (ChatMessage)this.listView.getAdapter().getItem(i1);
          if ((localObject == null) || (((ChatMessage)localObject).msgtype != -1012)) {
            break;
          }
          localObject = ((ChatMessage)localObject).getExtInfoFromExtStr("troop_new_member_uin");
          if (QLog.isColorLevel()) {
            QLog.d(this.tag, 2, "isNewMemberGrayTipVisible newMemberUin = " + (String)localObject + ",detect memberUin = " + paramString);
          }
          if (android.text.TextUtils.isEmpty((CharSequence)localObject)) {
            break;
          }
          bool2 = ((String)localObject).equals(paramString);
          if (!bool2) {
            break;
          }
          bool1 = true;
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
        {
          for (;;)
          {
            localIndexOutOfBoundsException.printStackTrace();
          }
        }
        i1 += 1;
        continue;
        i1 = i2;
      }
    }
    label197:
    return bool2;
  }
  
  public boolean a(boolean paramBoolean)
  {
    boolean bool = false;
    if (this.o)
    {
      this.root.a();
      if (paramBoolean) {
        QQToast.a(this.app.getApp(), 2131696866, 0).b(this.mActivity.getTitleBarHeight());
      }
      doDisableInputStat();
      bool = true;
    }
    return bool;
  }
  
  public void addBusinessObservers()
  {
    super.addBusinessObservers();
    this.app.addDefaultObservers(this.jdField_a_of_type_Amwl);
    this.app.addObserver(this.jdField_a_of_type_Andd);
    this.app.addObserver(this.jdField_a_of_type_Amsu);
    this.app.addObserver(this.jdField_a_of_type_Amop);
    this.app.addObserver(this.jdField_a_of_type_Anam);
    this.app.addObserver(this.jdField_a_of_type_Andl);
    this.app.addObserver(this.jdField_a_of_type_Bcvj);
    if (this.app.getProxyManager() != null) {
      this.app.getProxyManager().addProxyObserver(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    Q();
    ((aubl)this.app.getManager(156)).a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  public void adjustTitleDimension()
  {
    this.mCustomTitleView.c();
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    super.afterTextChanged(paramEditable);
    paramEditable = (afsd)getHelper(27);
    if (paramEditable != null) {
      paramEditable.b();
    }
  }
  
  public ViewGroup b()
  {
    return this.mSubTitleLayout;
  }
  
  public ImageView b()
  {
    return this.mTitleBtnCall;
  }
  
  void b(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    switch (paramInt)
    {
    default: 
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (localObject1 != null) {
        bcef.b(this.app, "P_CliOper", "Grp_AIO", "", "AIOshortcut", "Clk_shortcut", 0, 0, this.sessionInfo.curFriendUin, (String)localObject1, "", "");
      }
      return;
      localObject1 = "1";
      continue;
      localObject1 = "2";
      continue;
      localObject1 = "3";
      continue;
      localObject1 = "4";
      continue;
      localObject1 = "5";
      continue;
      localObject1 = "7";
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.panelicons != null) {
      this.panelicons.a(this.app, paramBoolean, this);
    }
    ((afss)getHelper(29)).c(paramBoolean);
    this.jdField_d_of_type_Boolean = paramBoolean;
    nmy.a().a(paramBoolean, this.sessionInfo.curFriendUin);
    if ((paramBoolean) || (amat.a(this.app))) {
      amat.a(this.app, "troop_anonyous", paramBoolean);
    }
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = new View(this.mActivity);
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.rgb(19, 19, 21));
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, 1);
      localLayoutParams.addRule(12, -1);
      this.mCustomTitleView.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
    }
    if (this.jdField_d_of_type_AndroidViewView == null)
    {
      this.jdField_d_of_type_AndroidViewView = new View(this.mActivity);
      this.jdField_d_of_type_AndroidViewView.setBackgroundResource(2130843675);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_d_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      this.mCustomTitleView.addView(this.jdField_d_of_type_AndroidViewView, 0);
    }
    if (this.jdField_c_of_type_AndroidViewView == null)
    {
      this.jdField_c_of_type_AndroidViewView = new View(this.mActivity);
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130843675);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_c_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      this.mContent.addView(this.jdField_c_of_type_AndroidViewView, 0);
    }
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      this.jdField_b_of_type_AndroidViewView = new View(this.mActivity);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(Color.rgb(19, 19, 21));
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, 1);
      localLayoutParams.addRule(2, 2131368751);
      this.mContent.addView(this.jdField_b_of_type_AndroidViewView, localLayoutParams);
    }
    if (this.jdField_a_of_type_Bequ != null) {
      this.jdField_a_of_type_Bequ.a(paramBoolean);
    }
    if (paramBoolean) {
      R();
    }
    for (;;)
    {
      updateSession_updateTitleRightView();
      updateSession_updateTitleBtnCall();
      this.listAdapter.notifyDataSetChanged();
      return;
      l();
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.beforeTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    ((afoh)getHelper(34)).a(paramCharSequence, paramInt1, paramInt2, paramInt3);
  }
  
  public void c()
  {
    boolean bool = false;
    super.c();
    if (this.jdField_a_of_type_Bfba == null)
    {
      afks localafks = new afks(this.sessionInfo.curFriendUin);
      this.jdField_a_of_type_Bfba = new bfba(this.mActivity, localafks, this.app);
    }
    bfaw.a(this.app, this.jdField_a_of_type_Bfba);
    a(false);
    if (this.jdField_d_of_type_Boolean != nmy.a().a(this.sessionInfo.curFriendUin))
    {
      if (!this.jdField_d_of_type_Boolean) {
        bool = true;
      }
      this.jdField_d_of_type_Boolean = bool;
      b(this.jdField_d_of_type_Boolean);
    }
    ((bfas)this.app.getManager(132)).e(this.sessionInfo.curFriendUin);
  }
  
  public void c(int paramInt)
  {
    if ((this.sessionInfo.curType == 1) && (this.app.getTroopMask(this.sessionInfo.curFriendUin) == 3)) {
      ((anca)this.app.getBusinessHandler(20)).a(this.sessionInfo.curFriendUin, this.app.getCurrentAccountUin(), paramInt, 0);
    }
  }
  
  public void clickSendTextButton()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "clickSendTextButton. isSending:" + this.h);
    }
    if (!this.h) {
      this.h = true;
    }
    for (int i1 = 1;; i1 = 0)
    {
      super.clickSendTextButton();
      if (i1 == 0) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "clickSendTextButton process talking state");
      }
      bfdm localbfdm = (bfdm)this.app.getManager(203);
      boolean bool2 = localbfdm.a();
      Object localObject = localbfdm.jdField_b_of_type_JavaLangString;
      String str1 = localbfdm.jdField_c_of_type_JavaLangString;
      ArrayList localArrayList = new ArrayList();
      String str2 = bevq.a(this.input.getEditableText(), localArrayList);
      i1 = 0;
      label261:
      boolean bool3;
      if (i1 < localArrayList.size())
      {
        MessageForText.AtTroopMemberInfo localAtTroopMemberInfo = (MessageForText.AtTroopMemberInfo)localArrayList.get(i1);
        if (localbfdm.a(localAtTroopMemberInfo.uin))
        {
          localObject = "" + localAtTroopMemberInfo.uin;
          str1 = ContactUtils.getTroopMemberName(this.app, this.sessionInfo.curFriendUin, (String)localObject);
          if ((bool2) || (localbfdm.a(str2, "" + localAtTroopMemberInfo.uin, this.sessionInfo.curFriendUin)))
          {
            bool1 = true;
            bool3 = localbfdm.b(str2, "" + localAtTroopMemberInfo.uin, this.sessionInfo.curFriendUin);
            bool2 = bool1;
          }
        }
      }
      for (boolean bool1 = bool3;; bool1 = false)
      {
        if ((bool2) && (!bool1))
        {
          localObject = bevq.a(this.app, this.mContext, this.sessionInfo.curFriendUin, (String)localObject, str1, false, this.input, true);
          this.input.setText((CharSequence)localObject);
          this.input.append(" ");
          this.input.setSelection(this.input.getText().length());
          a(localbfdm.jdField_b_of_type_JavaLangString, localbfdm.jdField_c_of_type_JavaLangString, true, 0);
        }
        for (;;)
        {
          this.h = false;
          return;
          bool1 = false;
          break label261;
          i1 += 1;
          break;
          agsn.a(this.app, str2, localArrayList, this.sessionInfo.curFriendUin);
          if ((str2 == null) || (str2.length() <= 3478)) {
            this.input.setText("");
          }
          if (this.f)
          {
            d(false);
            localObject = (aftj)getHelper(23);
            if (localObject != null) {
              ((aftj)localObject).a(false);
            }
          }
          this.g = false;
          localbfdm.a();
        }
      }
    }
  }
  
  public EntryModel createMiniAppEntryModel()
  {
    return TroopUtils.createEntryModel(((TroopManager)this.app.getManager(52)).b(this.sessionInfo.curFriendUin), this.sessionInfo.curFriendUin);
  }
  
  public void d()
  {
    super.d();
    this.jdField_e_of_type_Int = this.app.getConversationFacade().a(this.sessionInfo.curFriendUin, this.sessionInfo.curType);
    X();
    j();
    Y();
    Object localObject = this.mActivity.getIntent();
    if (localObject != null)
    {
      String str1 = ((Intent)localObject).getStringExtra("at_member_name");
      String str2 = ((Intent)localObject).getStringExtra("at_member_uin");
      int i1 = ((Intent)localObject).getIntExtra("at_member_source", 0);
      if ((!android.text.TextUtils.isEmpty(str1)) && (!android.text.TextUtils.isEmpty(str2))) {
        a(str2, str1, false, i1);
      }
    }
    Z();
    this.q = false;
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    ThreadManager.getSubThreadHandler().postDelayed(this.jdField_d_of_type_JavaLangRunnable, 500L);
    r();
    this.p = true;
    if ((this.l) && (this.jdField_a_of_type_Behu != null))
    {
      this.jdField_a_of_type_Behu.a(true);
      this.l = false;
    }
    localObject = (bedt)this.app.getManager(231);
    if ((((bedt)localObject).jdField_a_of_type_Int != 0) && (!nmy.a().a(this.sessionInfo.curFriendUin)) && (!bbyp.b()))
    {
      ((bedt)localObject).a(new bedr(((bedt)localObject).jdField_e_of_type_Int, this.app.getCurrentAccountUin(), this.sessionInfo.curFriendUin, ((bedt)localObject).jdField_b_of_type_Int, ((bedt)localObject).jdField_c_of_type_Int, ((bedt)localObject).jdField_d_of_type_Int, ((bedt)localObject).jdField_a_of_type_Int));
      localObject = a();
      ((bedi)localObject).a(this.sessionInfo.curFriendUin);
      ((bedi)localObject).a();
    }
  }
  
  boolean d()
  {
    if (this.jdField_a_of_type_Bequ == null) {}
    boolean bool = bfdg.c(this.sessionInfo.curFriendUin);
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "handleTroopNotificationMsg. hasNewGuide = " + bool);
    }
    if ((this.sessionInfo.curType == 1) && (!bool))
    {
      ThreadManager.post(new TroopChatPie.24(this), 8, null, true);
      return true;
    }
    return false;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 2000) {
      b(paramIntent);
    }
    if ((paramInt1 != 5) && (paramInt1 != 2000) && (a(true))) {
      return;
    }
    if (paramInt2 == -1) {
      a(paramInt1, paramIntent);
    }
    for (;;)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      if (paramInt2 == 8001)
      {
        if (this.root != null) {
          this.root.a();
        }
      }
      else if (paramInt1 == 12005) {
        I();
      } else if (paramInt2 == 0) {
        d(paramInt1);
      }
    }
  }
  
  public boolean doOnCreate(boolean paramBoolean)
  {
    if (this.mAIORootView == null)
    {
      QLog.e(this.tag, 2, "mAIORootView == null");
      ChatFragment localChatFragment = this.mActivity.getChatFragment();
      if (localChatFragment != null) {
        this.mAIORootView = localChatFragment.a;
      }
    }
    super.doOnCreate(paramBoolean);
    c(1);
    betn.a().a(this);
    this.jdField_a_of_type_Bfhs = new bfhs(this.app, this.sessionInfo.curFriendUin, "Grp_time", "Grp_AIO", "visit_time");
    bhvd.a(this.mActivity, this.mActivity.getIntent(), true);
    return true;
  }
  
  public void doOnCreate_initData()
  {
    super.doOnCreate_initData();
    if (this.mActivity.getIntent().getBooleanExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", false)) {
      acvv.a(this.app, this.sessionInfo, this.mActivity.getIntent());
    }
    this.i = true;
    ((TroopManager)this.app.getManager(52)).i(this.sessionInfo.curFriendUin);
    Object localObject = this.mActivity.getIntent().getStringExtra("uin");
    avnu.a().b(this.app, (String)localObject);
    if (this.aioTipsController != null) {
      this.aioTipsController.a(this.jdField_a_of_type_Aewy);
    }
    ThreadManager.post(new TroopChatPie.CheckGlamourPicturesRunnable(this.mActivity), 2, null, true);
    int i1;
    if (TroopInfo.isQidianPrivateTroop(this.app, this.sessionInfo.curFriendUin))
    {
      localObject = ((TroopManager)this.app.getManager(52)).b(this.sessionInfo.curFriendUin);
      if (localObject != null)
      {
        if (!((TroopInfo)localObject).isTroopOwner(this.app.getCurrentAccountUin())) {
          break label311;
        }
        i1 = 1;
      }
    }
    for (;;)
    {
      new bcek(this.app).a("dc00899").b("Grp_private").c("Grp_AIO").d("exp").a(new String[] { this.sessionInfo.curFriendUin, String.valueOf(i1) }).a();
      if (this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener == null)
      {
        this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new afkq(this, null);
        this.input.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      }
      this.v = false;
      ((aftj)getHelper(23)).a(this.sessionInfo.curFriendUin);
      aa();
      return;
      label311:
      if (((TroopInfo)localObject).isTroopAdmin(this.app.getCurrentAccountUin())) {
        i1 = 2;
      } else {
        i1 = 3;
      }
    }
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable.a(true);
    }
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    this.k = false;
    this.j = false;
    x();
    if (this.hasDestory)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "hasDestory = true return");
      }
      return;
    }
    if (this.m) {
      W();
    }
    ((afoh)getHelper(34)).a();
    C();
    D();
    B();
    v();
    c(0);
    this.jdField_b_of_type_Int = 0;
    this.p = false;
    this.r = false;
    this.t = false;
    this.s = false;
    t();
    u();
    if (!android.text.TextUtils.isEmpty(this.sessionInfo.curFriendUin)) {
      abwz.b(this.app, this.sessionInfo.curFriendUin, this.sessionInfo.curType, -4021);
    }
    A();
    a(0);
    if (this.jdField_a_of_type_Bfhs != null) {
      this.jdField_a_of_type_Bfhs.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel = null;
    }
    aa();
    super.doOnDestroy();
    if (this.jdField_b_of_type_AndroidOsHandler != null)
    {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      if (QLog.isColorLevel()) {
        QLog.d("troop_gag", 2, "doOnDestroy, timerHandler->removeCallbacksAndMessages");
      }
    }
    betn.a().a();
    z();
    this.jdField_a_of_type_JavaUtilList.clear();
    if (this.mTitleCount != null) {
      this.mTitleCount.setVisibility(8);
    }
    G();
    y();
    E();
    agrx.jdField_a_of_type_JavaUtilHashMap.clear();
    agrx.jdField_a_of_type_AndroidSupportV4UtilLruCache.evictAll();
    apsz.b(this.app, false);
    Intent localIntent = new Intent("com.tencent.mobileqq.action.ACTION_CONFESS_FINISH_EVENT");
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
    this.w = false;
    if (this.aioTipsController != null) {
      this.aioTipsController.a(null);
    }
    w();
    F();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    bhvd.a(this.mActivity, paramIntent, true);
  }
  
  public void doOnNewIntent_clearBusinessData()
  {
    super.doOnNewIntent_clearBusinessData();
    Intent localIntent = this.mActivity.getIntent();
    if (localIntent == null) {
      return;
    }
    String str = localIntent.getStringExtra("uin");
    int i1 = localIntent.getIntExtra("uintype", -1);
    if ((this.sessionInfo.curFriendUin != null) && ((!this.sessionInfo.curFriendUin.equals(str)) || (this.sessionInfo.curType != i1))) {}
    for (i1 = 1;; i1 = 0)
    {
      if ((i1 != 0) && (this.jdField_a_of_type_Bequ != null))
      {
        this.jdField_a_of_type_Bequ.b();
        this.jdField_a_of_type_Bequ = null;
      }
      if ((i1 != 0) && (this.jdField_a_of_type_Behu != null) && (this.jdField_a_of_type_Behu.a != null))
      {
        this.jdField_a_of_type_Behu.a.b();
        this.jdField_a_of_type_Behu.a = null;
      }
      if (this.jdField_a_of_type_Bfba != null)
      {
        bfaw.b(this.app, this.jdField_a_of_type_Bfba);
        this.jdField_a_of_type_Bfba = null;
      }
      aa();
      return;
    }
  }
  
  protected void doOnNewIntent_updateBusinessData(Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getExtras();
    String str = paramIntent.getStringExtra("uin");
    int i1 = paramIntent.getIntExtra("uintype", -1);
    boolean bool1 = paramIntent.getBooleanExtra("searched_update_session", false);
    boolean bool2 = paramIntent.getBooleanExtra("isNeedUpdate", false);
    if ((!this.sessionInfo.curFriendUin.equals(str)) || (this.sessionInfo.curType != i1))
    {
      this.mIsCurrentSession = false;
      if ((this.mIsCurrentSession) && (!localBundle.containsKey("forward_type")) && (!bool1)) {
        break label110;
      }
      updateSession(paramIntent);
    }
    label110:
    do
    {
      return;
      this.mIsCurrentSession = true;
      break;
      if ((this.dirty != 0) || (bool2))
      {
        instantUpdate(true, false);
        return;
      }
    } while (localBundle.getLong("res_share_id", 0L) <= 0L);
    ForwardUtils.handleAppShareAction(this.app, this.mActivity, this.sessionInfo, paramIntent);
  }
  
  protected void doOnNewIntent_updateData(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", false)) {
      acvv.a(this.app, this.sessionInfo, paramIntent);
    }
    super.doOnNewIntent_updateData(paramIntent);
    if (this.jdField_a_of_type_Bfba != null)
    {
      bfaw.b(this.app, this.jdField_a_of_type_Bfba);
      this.jdField_a_of_type_Bfba = null;
    }
    paramIntent = new afks(this.sessionInfo.curFriendUin);
    this.jdField_a_of_type_Bfba = new bfba(this.mActivity, paramIntent, this.app);
    bfaw.a(this.app, this.jdField_a_of_type_Bfba);
  }
  
  public void doOnPause()
  {
    if (this.jdField_a_of_type_Bfks != null) {
      this.jdField_a_of_type_Bfks.a();
    }
    if (this.jdField_a_of_type_Bedi != null) {
      this.jdField_a_of_type_Bedi.d();
    }
    if (this.jdField_a_of_type_AndroidWidgetToast != null) {
      this.jdField_a_of_type_AndroidWidgetToast.cancel();
    }
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.setVisibility(8);
    }
    if ((this.jdField_a_of_type_Zqq == null) || (!this.jdField_a_of_type_Zqq.isShowing()))
    {
      localObject = (beyh)this.app.getManager(223);
      if (localObject != null) {
        ((beyh)localObject).c();
      }
    }
    if (betn.a().a()) {
      betn.a().b();
    }
    Object localObject = (bedt)this.app.getManager(231);
    ((bedt)localObject).jdField_a_of_type_Int = 0;
    ((bedt)localObject).jdField_b_of_type_Int = 0;
    ((bedt)localObject).jdField_c_of_type_Int = 0;
    ((bedt)localObject).jdField_d_of_type_Int = 0;
    if (QLog.isColorLevel()) {
      QLog.i(this.tag, 2, "doOnPause, isTroopOwner =" + this.n);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.app.getTroopMask(this.sessionInfo.curFriendUin) == 2)
    {
      this.jdField_c_of_type_Boolean = this.app.getMessageFacade().getAIOBreak(this.sessionInfo.curFriendUin, this.sessionInfo.curType);
      if (this.jdField_c_of_type_Boolean) {
        g();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.setVisibility(0);
    }
    this.jdField_a_of_type_Bedi = a();
    this.jdField_a_of_type_Bedi.c();
    this.jdField_a_of_type_Bedi.a(this.sessionInfo.curFriendUin);
    apsz.b(this.app, true);
    a(this.sessionInfo.curFriendUin, true);
    this.jdField_a_of_type_Bfhs.a();
    this.panelicons.c();
  }
  
  protected void doOnResume_updateUI()
  {
    super.doOnResume_updateUI();
    if (this.jdField_d_of_type_Boolean)
    {
      this.afRoot.setBackgroundResource(2130843669);
      nmy.a().a(this.jdField_a_of_type_Nnc);
      setSystemBarColor(-16777216, false);
    }
  }
  
  public void doOnStop()
  {
    if (this.jdField_d_of_type_Boolean) {
      S();
    }
    if (this.jdField_a_of_type_Bfba != null)
    {
      bfaw.b(this.app, this.jdField_a_of_type_Bfba);
      this.jdField_a_of_type_Bfba = null;
    }
    if ((this.jdField_a_of_type_Zqq == null) || (!this.jdField_a_of_type_Zqq.isShowing()))
    {
      beyh localbeyh = (beyh)this.app.getManager(223);
      if (localbeyh != null) {
        localbeyh.c();
      }
    }
    if (this.jdField_a_of_type_AndroidWidgetToast != null) {
      this.jdField_a_of_type_AndroidWidgetToast.cancel();
    }
    if (this.jdField_a_of_type_Bfjm != null) {
      this.jdField_a_of_type_Bfjm.a();
    }
    if (betn.a().a()) {
      betn.a().b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable.a(true);
    }
    super.doOnStop();
  }
  
  protected void doPanelChanged(int paramInt1, int paramInt2)
  {
    super.doPanelChanged(paramInt1, paramInt2);
    if (paramInt2 == 8) {
      if (!this.jdField_d_of_type_Boolean) {}
    }
    for (;;)
    {
      if ((paramInt2 == 2) && (this.jdField_d_of_type_Boolean)) {
        this.mAudioPanel.a(0);
      }
      return;
      if (!this.jdField_d_of_type_Boolean) {}
    }
  }
  
  protected void g()
  {
    setOverScrollHandleVisable(true);
    TroopChatPie.1 local1 = new TroopChatPie.1(this);
    this.mScrollerRunnable.a(0, -1, local1, 9);
  }
  
  protected List<ChatMessage> getAIOList(boolean paramBoolean)
  {
    List localList2 = super.getAIOList(paramBoolean);
    boolean bool2 = ahrf.a();
    int i2 = ahrf.a();
    int i3 = ahrf.b();
    paramBoolean = false;
    if (!this.x)
    {
      if (localList2.size() > 0)
      {
        this.jdField_c_of_type_Long = ((ChatMessage)localList2.get(localList2.size() - 1)).shmsgseq;
        this.jdField_d_of_type_Long = ((ChatMessage)localList2.get(0)).shmsgseq;
      }
      paramBoolean = true;
      this.x = true;
    }
    boolean bool1;
    long[] arrayOfLong1;
    long[] arrayOfLong2;
    if ((this.jdField_d_of_type_Long == 0L) && (this.jdField_c_of_type_Long == 0L))
    {
      bool1 = true;
      if (!a(localList2, bool2, i2, bool1)) {
        break label430;
      }
      arrayOfLong1 = a(this.jdField_a_of_type_JavaUtilSet);
      arrayOfLong2 = a(this.jdField_c_of_type_JavaUtilSet);
    }
    for (;;)
    {
      List localList3;
      try
      {
        localList3 = ahrf.a(this.app, localList2, i2, this.jdField_d_of_type_Long, this.jdField_c_of_type_Long, arrayOfLong1, this.jdField_b_of_type_JavaUtilSet, this.jdField_a_of_type_JavaUtilMap, arrayOfLong2, paramBoolean);
        if ((!paramBoolean) || (i3 <= 15) || (localList3.size() <= 1)) {
          break label456;
        }
        localObject = null;
        i1 = 1;
        if (i1 < localList3.size())
        {
          localObject = (ChatMessage)localList3.get(i1);
          if (ahrf.d((ChatMessage)localObject)) {
            continue;
          }
        }
        if ((!ahrf.b((ChatMessage)localObject)) || (localList3.size() >= 15)) {
          break label456;
        }
        ahrf.a("find first msg is fold msg,then get more msg ", new Object[0]);
        localObject = this.app.getMessageFacade().getAIOList(this.sessionInfo.curFriendUin, this.sessionInfo.curType, this.jdField_c_of_type_Long - i3 - 1L);
        if (((List)localObject).size() > 0)
        {
          this.jdField_d_of_type_Long = ((ChatMessage)((List)localObject).get(0)).shmsgseq;
          this.jdField_c_of_type_Long = ((ChatMessage)((List)localObject).get(((List)localObject).size() - 1)).shmsgseq;
        }
        localObject = ahrf.a(this.app, (List)localObject, i2, this.jdField_d_of_type_Long, this.jdField_c_of_type_Long, arrayOfLong1, this.jdField_b_of_type_JavaUtilSet, this.jdField_a_of_type_JavaUtilMap, arrayOfLong2, false);
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        int i1;
        QLog.e(this.tag, 1, localThrowable, new Object[0]);
        localList1 = localList2;
        continue;
      }
      return localObject;
      bool1 = false;
      break;
      i1 += 1;
      continue;
      label430:
      List localList1 = localList2;
      if (localList2.size() == 0)
      {
        aa();
        this.x = true;
        return localList2;
        label456:
        localList1 = localList3;
      }
    }
  }
  
  protected Boolean getStatusTxtDartElseLight()
  {
    if (this.jdField_d_of_type_Boolean) {
      return new Boolean(false);
    }
    return null;
  }
  
  public void h()
  {
    if (((TroopManager)this.app.getManager(52)).a(this.sessionInfo.curFriendUin) - NetConnInfoCenter.getServerTime() < 259200L) {
      ThreadManager.post(this.jdField_b_of_type_JavaLangRunnable, 8, null, true);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    Object localObject;
    int i1;
    label280:
    label307:
    long l1;
    long l2;
    long l3;
    while ((paramMessage.what == 60) && (this.jdField_d_of_type_Boolean))
    {
      this.afRoot.setBackgroundResource(2130843669);
      return true;
      if ((this.jdField_a_of_type_Zqq != null) && (this.jdField_a_of_type_Zqq.isShowing())) {
        this.jdField_a_of_type_Zqq.dismiss();
      }
      this.jdField_a_of_type_Zqq = new zqq(this.app, this.mActivity, this.jdField_a_of_type_Bequ, this.sessionInfo.curFriendUin);
      localObject = new int[2];
      this.mTitleLayout.getLocationOnScreen((int[])localObject);
      i1 = getTitleBarHeight();
      int[] arrayOfInt = new int[2];
      this.input.getLocationInWindow(arrayOfInt);
      int i2 = arrayOfInt[1];
      int i3 = localObject[1];
      this.jdField_a_of_type_Zqq.a(i1, i2 - i3);
      this.jdField_a_of_type_Zqq.a(paramMessage.arg1);
      continue;
      if ((this.mTroopTips != null) && (this.mTroopTips.b()))
      {
        localObject = this.mTroopTips.a();
        if (((beri)localObject).a.get())
        {
          ((beri)localObject).a.set(false);
          continue;
          if (bfhm.a(this.mRightButtonRedDot).a(this.app, this.sessionInfo))
          {
            i1 = 1;
            localObject = this.mRightButtonRedDot;
            if (i1 != 0) {
              break label307;
            }
          }
          for (i1 = 8;; i1 = 0)
          {
            ((ImageView)localObject).setVisibility(i1);
            break;
            i1 = 0;
            break label280;
          }
          localObject = (List)paramMessage.obj;
          if (localObject != null)
          {
            l1 = ((Long)((List)localObject).get(0)).longValue();
            l2 = ((Long)((List)localObject).get(1)).longValue();
            l3 = ((Long)((List)localObject).get(2)).longValue();
          }
        }
      }
    }
    for (;;)
    {
      long l4;
      long l5;
      try
      {
        l4 = Long.parseLong(this.sessionInfo.curFriendUin);
        l5 = Long.parseLong(this.app.getCurrentUin());
        if (l4 != l1) {
          break label504;
        }
        if (l2 == l5) {
          break label644;
        }
        if (l3 != l5) {
          break label504;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.e(".troop.chat_pie_msg", 1, "MSG_TROOP_ADMIN_OPERATION_NOTIFY: groupUin error", localNumberFormatException);
      }
      if (i1 != 0)
      {
        localObject = (PlusPanel)this.panelManager.a(8);
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(".troop.chat_pie_msg", 2, new Object[] { "MSG_TROOP_ADMIN_OPERATION_NOTIFY: condition match: will reload plusPanel, groupUin:", Long.valueOf(l1) });
          }
          ((PlusPanel)localObject).c();
          break;
          break;
          label504:
          i1 = 0;
          continue;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(".troop.chat_pie_msg", 2, new Object[] { "MSG_TROOP_ADMIN_OPERATION_NOTIFY: condition match: should reload plusPanel, but mPlusPanel == null, groupUin:", Long.valueOf(l1) });
        break;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(".troop.chat_pie_msg", 2, new Object[] { "MSG_TROOP_ADMIN_OPERATION_NOTIFY: condition not match: group:", Long.valueOf(l1), "/", Long.valueOf(l4), " uin1/uin2/current: ", Long.valueOf(l2), "/", Long.valueOf(l3), "/", Long.valueOf(l5) });
      break;
      return super.handleMessage(paramMessage);
      label644:
      i1 = 1;
    }
  }
  
  protected void handleRequest(Intent paramIntent, int paramInt)
  {
    int i1 = paramIntent.getIntExtra(bftk.h, -1);
    if (((i1 == 2) || (i1 == 1)) && (a(true))) {
      return;
    }
    super.handleRequest(paramIntent, paramInt);
  }
  
  public void i()
  {
    boolean bool3 = false;
    TroopManager localTroopManager = (TroopManager)this.app.getManager(52);
    Object localObject = null;
    if (localTroopManager != null) {
      localObject = localTroopManager.b(this.sessionInfo.curFriendUin);
    }
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.i("troop.credit.act", 2, "checkTroopCreditLevel, troopInfo==null:" + this.sessionInfo.curFriendUin);
      }
    }
    long l1;
    do
    {
      return;
      l1 = ((TroopInfo)localObject).troopCreditLevel;
      if ((l1 == 1L) || (l1 == 2L)) {
        break;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      }
    } while (!QLog.isColorLevel());
    QLog.i("troop.credit.act", 2, "checkTroopCreditLevel, normal:" + this.sessionInfo.curFriendUin + "," + l1);
    return;
    boolean bool1;
    if ((((TroopInfo)localObject).dwAdditionalFlag & 1L) == 1L)
    {
      bool1 = true;
      if ((((TroopInfo)localObject).dwCmdUinUinFlag & 1L) != 1L) {
        break label362;
      }
    }
    label362:
    for (boolean bool2 = true;; bool2 = false)
    {
      if ((bool1) || (bool2)) {
        bool3 = true;
      }
      if (QLog.isColorLevel()) {
        QLog.i("troop.credit.act", 2, "checkTroopCreditLevel:" + this.sessionInfo.curFriendUin + "," + bool1 + ", " + bool2);
      }
      localObject = (anca)this.app.getBusinessHandler(20);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("troop.credit.act", 2, "checkTroopCreditLevel, getTroopCreditInfo:" + this.sessionInfo.curFriendUin);
        }
        ((anca)localObject).d(this.sessionInfo.curFriendUin, true);
      }
      a(l1, bool3);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void initHelper()
  {
    super.initHelper();
    this.helperProvider.a(this);
  }
  
  protected void initTipsTaskList()
  {
    super.initTipsTaskList();
    if ((this.mTroopTips.d()) && ((this.mTroopTips.b() == 17) || (this.mTroopTips.b() == 100) || (this.mTroopTips.b() == 11))) {
      return;
    }
    this.jdField_a_of_type_Ahqx = new ahqx(this.app, this.mTipsMgr, this.mActivity, this.sessionInfo, this.mTroopTips, this.jdField_a_of_type_AndroidWidgetToast);
    this.mTipsMgr.a(this.jdField_a_of_type_Ahqx);
    this.jdField_a_of_type_Ahpo = new ahpo(this.app, this.mTipsMgr, this.mActivity, this.sessionInfo);
    this.mTipsMgr.a(this.jdField_a_of_type_Ahpo);
    this.jdField_a_of_type_Ahqw = new ahqw(this.app, this.sessionInfo, this.mTipsMgr, this.mActivity);
    this.mTipsMgr.a(this.jdField_a_of_type_Ahqw);
    afpr localafpr = (afpr)getHelper(71);
    if (localafpr != null) {
      localafpr.a(this.mTipsMgr);
    }
    ((ahql)getHelper(75)).a();
  }
  
  void j()
  {
    Object localObject;
    if (this.sessionInfo.curType == 1)
    {
      localObject = (TroopManager)this.app.getManager(52);
      if (localObject != null) {
        break label29;
      }
    }
    label29:
    do
    {
      for (;;)
      {
        return;
        localObject = ((TroopManager)localObject).b(this.sessionInfo.curFriendUin);
        if ((localObject != null) && ((((TroopInfo)localObject).wMemberNum == 0) || (android.text.TextUtils.isEmpty(((TroopInfo)localObject).troopowneruin)))) {
          try
          {
            long l1 = Long.parseLong(this.sessionInfo.curFriendUin);
            localObject = new ArrayList();
            ((ArrayList)localObject).add(Long.valueOf(l1));
            ((anca)this.app.getBusinessHandler(20)).a((ArrayList)localObject);
            if (QLog.isColorLevel())
            {
              QLog.d(this.tag, 2, "getTroopInfoIfNeed, sessionInfo.curFriendUin = " + this.sessionInfo.curFriendUin);
              return;
            }
          }
          catch (Exception localException) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.tag, 2, "getTroopInfoIfNeed failed");
  }
  
  public void k()
  {
    anca localanca = (anca)this.app.getBusinessHandler(20);
    if (localanca != null) {}
    try
    {
      localanca.a(Long.parseLong(this.sessionInfo.curFriendUin), 0L, 2, 0, 0);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i(this.tag, 2, localException.toString());
    }
  }
  
  void l()
  {
    if (this.mInputBar.getBackground() != null) {
      updateInputBarBg();
    }
    S();
    this.titleBgView.setVisibility(8);
    this.mTitleText.setTextColor(this.mActivity.getResources().getColor(2131167009));
    this.mTitleCount.setTextColor(this.mActivity.getResources().getColor(2131167009));
    Object localObject;
    if (this.mTitleBtnLeft.getVisibility() == 0)
    {
      this.mTitleBtnLeft.setBackgroundResource(2130850593);
      this.mTitleBtnLeft.setTextColor(this.mActivity.getResources().getColor(2131167006));
      this.mTitleBubbleLeft.setTextColor(this.mActivity.getResources().getColor(2131167006));
      AIOUtils.setViewDrawalbe(this.mTitleBtnRight, 2130850602);
      if ((this.mSubTilteText.getVisibility() == 0) && (this.mSubTilteText.getText() != null) && (this.mSubTilteText.getText().toString().startsWith(this.mActivity.getResources().getString(2131690015))))
      {
        this.mSubTilteText.setText("");
        this.mSubTilteText.setTextColor(this.mActivity.getResources().getColor(2131167009));
        setSubTitleVisable(false);
      }
      localObject = (bfkq)this.app.getManager(234);
      String str = ((bfkq)localObject).a(getSessionInfo().curFriendUin);
      if (android.text.TextUtils.isEmpty(str)) {
        break label622;
      }
      a(2);
      if (((bfkq)localObject).a(getSessionInfo().curFriendUin) != 3) {
        break label564;
      }
      bftc.a("Grp_idol", "Grp_AIO", "exp_renshu", 0, 0, new String[] { getSessionInfo().curFriendUin });
      label304:
      setSubTitleVisable(true);
      this.mSubTilteText.setText(str);
      this.mSubTilteText.setTextColor(this.mActivity.getResources().getColor(2131167009));
      this.mSubTitleLeftImageView.setVisibility(0);
      c(false);
    }
    for (;;)
    {
      localObject = (PlusPanel)this.panelManager.a(8);
      if (localObject != null) {
        ((PlusPanel)localObject).a(false);
      }
      if (this.mEmoPanel != null) {
        this.mEmoPanel.switchToAnonymous(false);
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      nmy.a().b();
      o();
      if (this.input != null)
      {
        this.input.setShadowLayer(1.0F, 0.0F, 1.0F, this.mActivity.getResources().getColor(2131165414));
        this.input.setHint("");
      }
      if (this.panelicons != null) {
        AIOUtils.setViewDrawalbe(this.panelicons, 2130849809);
      }
      m();
      this.root.a(1);
      ((afsw)getHelper(43)).f();
      ((afqa)getHelper(85)).a(false);
      return;
      if (this.mDefaultLeftBack.getVisibility() != 0) {
        break;
      }
      this.mDefaultLeftBack.setBackgroundResource(2130850594);
      this.mDefaultLeftBack.setPadding(0, 0, 0, 0);
      this.mDefautlBtnLeft.setTextColor(this.mActivity.getResources().getColor(2131167006));
      break;
      label564:
      new bcek(this.app).a("dc00899").b("Grp_online").c("Grp_AIO").d("exp_onlineEntry").a(new String[] { getSessionInfo().curFriendUin }).a();
      break label304;
      label622:
      a(0);
    }
  }
  
  public void leftBackEvent(boolean paramBoolean)
  {
    if (betn.a().a()) {
      betn.a().b();
    }
    if (this.m) {
      W();
    }
    super.leftBackEvent(paramBoolean);
  }
  
  public void m()
  {
    if (this.mTipsMgr != null)
    {
      alyf localalyf = alyf.a();
      if (localalyf != null) {
        localalyf.f();
      }
    }
  }
  
  public void n()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setAnimationListener(new afkd(this));
    if ((this.jdField_d_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView != null))
    {
      this.jdField_d_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
      this.jdField_c_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
    }
  }
  
  public void o()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setAnimationListener(new afke(this));
    this.jdField_d_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
    this.jdField_c_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
  }
  
  public boolean onBackEvent()
  {
    if (((afoh)getHelper(34)).a()) {
      return true;
    }
    if (((afsw)getHelper(43)).f()) {
      return true;
    }
    if (this.mTroopTips != null) {
      this.mTroopTips.a();
    }
    if (betn.a().a()) {
      betn.a().b();
    }
    if (this.jdField_a_of_type_Ahqx != null) {
      this.jdField_a_of_type_Ahqx.a();
    }
    if (this.jdField_a_of_type_Behu != null) {
      this.jdField_a_of_type_Behu.c();
    }
    if (this.m) {
      W();
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131367352) && (a(true))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      super.onClick(paramView);
      if (paramView.getId() == 2131371468)
      {
        if ((this.jdField_a_of_type_Ahqx != null) && (this.jdField_a_of_type_Ahqx.a())) {
          this.mTipsMgr.a();
        }
      }
      else if (paramView.getId() == 2131371466) {
        U();
      } else if ((paramView.getId() == 2131369082) && (this.mRightButtonRedDot != null) && (this.mRightButtonRedDot.getVisibility() == 0)) {
        bfhm.a(this.mRightButtonRedDot).a(this.app, this.sessionInfo);
      }
    }
  }
  
  public void onClickTitleLayout(View paramView)
  {
    if (paramView.getId() == 2131377934)
    {
      if (this.jdField_d_of_type_Int == 2)
      {
        if (this.jdField_a_of_type_Bfkh == null) {
          this.jdField_a_of_type_Bfkh = new bfkh(this.app, this.mContext, this.mContent, this.mCustomTitleView, this.mTroopTips);
        }
        this.jdField_a_of_type_Bfkh.a(getSessionInfo().curFriendUin);
        if (this.jdField_a_of_type_Bfkh.b()) {}
        do
        {
          return;
          if (!this.jdField_a_of_type_Bfkh.a()) {
            break;
          }
          U();
        } while (this.jdField_a_of_type_Bfkh.jdField_b_of_type_Int == 2);
        new bcek(this.app).a("dc00899").b("Grp_online").c("Grp_AIO").d("clk_EntryClose").a(new String[] { getSessionInfo().curFriendUin }).a();
        return;
        this.jdField_a_of_type_Bfkh.a(1);
        paramView = (anca)this.app.getBusinessHandler(20);
        if (paramView != null) {
          paramView.u(getSessionInfo().curFriendUin);
        }
        a(true);
        if (this.jdField_a_of_type_Bfkh.jdField_b_of_type_Int == 2)
        {
          bftc.a("Grp_idol", "Grp_AIO", "clk_renshu", 0, 0, new String[] { getSessionInfo().curFriendUin });
          return;
        }
        new bcek(this.app).a("dc00899").b("Grp_online").c("Grp_AIO").d("clk_EntryOpen").a(new String[] { getSessionInfo().curFriendUin }).a();
        return;
      }
      if (this.jdField_d_of_type_Int == 3)
      {
        ((avcl)getHelper(33)).b();
        return;
      }
      if (this.jdField_d_of_type_Int == 4)
      {
        ((afsw)getHelper(43)).a(this.sessionInfo.curFriendUin);
        return;
      }
      if (this.jdField_d_of_type_Int == 5)
      {
        ((ahql)getHelper(75)).b();
        return;
      }
      this.helperProvider.a(1, new Object[] { Integer.valueOf(this.jdField_d_of_type_Int) });
      return;
    }
    T();
  }
  
  public View onCreatePanel(int paramInt)
  {
    if (paramInt == 35)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel = ((ConfessPanel)View.inflate(this.mContext, 2131558595, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel.a(this.app, this.mContext, this);
    }
    for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel;; localObject = super.onCreatePanel(paramInt))
    {
      if ((localObject instanceof PlusPanel)) {
        ((PlusPanel)localObject).setPagerChangedListener(new afki(this));
      }
      return localObject;
    }
  }
  
  protected void onEnterReceiptMode()
  {
    super.onEnterReceiptMode();
    U();
  }
  
  public void onHideAllPanel()
  {
    super.onHideAllPanel();
    apsz.a(this.app, false);
  }
  
  public void onHideFullScreen()
  {
    super.onHideFullScreen();
    V();
  }
  
  public void onPanelChanged(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, new Object[] { "onPanelChanged updateAIOPanelTip. oldPanel=", Integer.valueOf(paramInt1), ", newPanel=", Integer.valueOf(paramInt2) });
    }
    a(false);
    if ((paramInt1 == 0) && (paramInt2 != 0)) {
      U();
    }
    if (this.jdField_a_of_type_Behu != null) {
      this.jdField_a_of_type_Behu.a();
    }
    if (paramInt1 == 35) {
      if (paramInt2 != 1) {
        break label117;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel.a(bool);
      if (paramInt2 == 35) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel.b();
      }
      super.onPanelChanged(paramInt1, paramInt2);
      return;
      label117:
      bool = false;
    }
  }
  
  public void onPanelIconClick(Object paramObject)
  {
    AIOUtils.isUserOperatedInAIO = true;
    if ((paramObject == null) || (!(paramObject instanceof Integer))) {
      return;
    }
    int i1 = ((Integer)paramObject).intValue();
    if (i1 == this.root.a())
    {
      this.root.a();
      return;
    }
    switch (i1)
    {
    }
    for (;;)
    {
      b(i1);
      super.onPanelIconClick(paramObject);
      return;
      if (this.jdField_d_of_type_Boolean)
      {
        bcef.b(this.app, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_face", 0, 0, this.sessionInfo.curFriendUin, "", "", "");
        continue;
        if (this.jdField_d_of_type_Boolean) {
          bcef.b(this.app, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_PTT", 0, 0, this.sessionInfo.curFriendUin, "", "", "");
        }
        if (this.f)
        {
          new bcek(this.app).a("dc00899").b("Grp_robot").c("send_msg").d("voice_icon_clk").a(0).a(new String[] { this.sessionInfo.curFriendUin, this.jdField_b_of_type_JavaLangString }).a();
          continue;
          if (this.jdField_d_of_type_Boolean)
          {
            bcef.b(this.app, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_pic", 0, 0, this.sessionInfo.curFriendUin, "", "", "");
            continue;
            if (this.jdField_d_of_type_Boolean) {
              bcef.b(this.app, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_shoot", 0, 0, this.sessionInfo.curFriendUin, "", "", "");
            }
          }
        }
      }
    }
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    ((afsw)getHelper(43)).g();
    ((afqa)getHelper(85)).a(false);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (this.mTroopTips != null) {
      this.mTroopTips.a().a(paramInt, 500L);
    }
    if (paramInt == 2) {
      U();
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "scrollState = " + paramInt);
    }
    if (paramInt != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.u = bool;
      paramAbsListView = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramAbsListView.hasNext()) {
        ((afkr)paramAbsListView.next()).a(this.u);
      }
    }
    if ((paramInt == 0) && (this.jdField_d_of_type_JavaLangString != null))
    {
      paramAbsListView = ((anca)this.app.getBusinessHandler(20)).a();
      this.jdField_d_of_type_JavaLangString = null;
      paramAbsListView.a(this.sessionInfo.curFriendUin, 1);
    }
  }
  
  protected void onShow()
  {
    d();
    TroopManager localTroopManager = (TroopManager)this.app.getManager(52);
    TroopInfo localTroopInfo = localTroopManager.b(this.sessionInfo.curFriendUin);
    if ((localTroopInfo != null) && (localTroopInfo.isTroopOwner(this.app.getCurrentAccountUin())))
    {
      if (localTroopManager.a(this.sessionInfo.curFriendUin) - NetConnInfoCenter.getServerTime() < 259200L) {
        a(0L, 0L);
      }
      if (aqgr.c().mIsEnable)
      {
        localObject = (anaj)this.app.getBusinessHandler(13);
        if (!localTroopManager.i(this.sessionInfo.curFriendUin)) {
          break label331;
        }
        ((anaj)localObject).a(Long.parseLong(this.sessionInfo.curFriendUin));
        QLog.e("vip_pretty.", 1, "get the troop expired info from server");
      }
    }
    if ((localTroopInfo != null) && (QLog.isColorLevel())) {
      QLog.d("Q.getTroopMemberLevelInfo", 2, "aio onShow:" + localTroopInfo.troopuin + ", sysFlag=" + localTroopInfo.cGroupRankSysFlag + ", userFlag=" + localTroopInfo.cGroupRankUserFlag + ",newUserFlag=" + localTroopInfo.cNewGroupRankUserFlag);
    }
    super.onShow();
    if (this.i == true)
    {
      ThreadManager.post(new TroopChatPie.7(this), 1, null, true);
      this.i = false;
    }
    Object localObject = this.mActivity.getIntent().getExtras();
    if ((localObject != null) && (((Bundle)localObject).containsKey("forward_type")) && (this.sessionInfo.curFriendUin != null) && (this.sessionInfo.curFriendUin.equals(((Bundle)localObject).getString("uin")))) {}
    for (boolean bool = true;; bool = false)
    {
      ThreadManager.post(new TroopChatPie.8(this, bool), 8, null, true);
      a(localTroopManager, localTroopInfo);
      return;
      label331:
      if (QLog.isColorLevel()) {
        QLog.d("vip_pretty.", 1, "get the troop expired info from local");
      }
      TroopManager.a(localTroopManager.a(this.sessionInfo.curFriendUin), this.app, this.sessionInfo.curFriendUin, this.mContext, this, this.mTipsMgr);
      break;
    }
  }
  
  public void onShowFirst(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "troopUin : " + this.sessionInfo.curFriendUin);
    }
    Object localObject3 = null;
    try
    {
      Object localObject1 = this.app.getAVNotifyCenter().a(Long.valueOf(this.sessionInfo.curFriendUin).longValue(), 1);
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.tag, 2, "avType : " + ((lms)localObject1).jdField_a_of_type_Int);
        }
        if (((lms)localObject1).jdField_a_of_type_Int != 2) {
          break label731;
        }
        if (((lms)localObject1).jdField_a_of_type_Boolean)
        {
          bcef.b(null, "CliOper", "", "", "0X80066C2", "0X80066C2", 0, 0, "", "", "", "");
          this.app.getAVNotifyCenter().a(Long.valueOf(this.sessionInfo.curFriendUin).longValue(), 1);
        }
      }
      else
      {
        L();
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
          break label843;
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.mContext);
        this.jdField_a_of_type_AndroidWidgetScrollView = new afkf(this, this.mContext);
        this.jdField_a_of_type_AndroidWidgetScrollView.setVerticalFadingEdgeEnabled(false);
        this.jdField_a_of_type_AndroidWidgetScrollView.setScrollbarFadingEnabled(false);
        this.jdField_a_of_type_AndroidWidgetScrollView.setVerticalScrollBarEnabled(false);
        this.jdField_c_of_type_Int = (this.mContent.getHeight() - this.mCustomTitleView.getHeight() - this.mInputBar.getHeight() - this.panelicons.getHeight());
        localObject1 = new RelativeLayout.LayoutParams(-1, this.jdField_c_of_type_Int);
        ((RelativeLayout.LayoutParams)localObject1).topMargin = DisplayUtil.dip2px(this.mContext, 50.0F);
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = (this.mInputBar.getHeight() + this.panelicons.getHeight());
        this.mContent.addView(this.jdField_a_of_type_AndroidWidgetScrollView, 0, (ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_AndroidWidgetScrollView.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, -1, this.jdField_c_of_type_Int);
        localObject1 = (bedt)this.app.getManager(231);
        this.jdField_a_of_type_Bedi = a();
        ((bedt)localObject1).jdField_a_of_type_Int = 0;
        ((bedt)localObject1).jdField_b_of_type_Int = 0;
        ((bedt)localObject1).jdField_c_of_type_Int = 0;
        ((bedt)localObject1).jdField_d_of_type_Int = 0;
        if (!bbyp.b()) {
          ((bedt)localObject1).c(this.sessionInfo.curFriendUin);
        }
        localObject1 = ((TroopManager)this.app.getManager(52)).b(this.sessionInfo.curFriendUin);
        if (this.jdField_a_of_type_Behu == null) {
          this.jdField_a_of_type_Behu = ((behu)this.app.getManager(289));
        }
        if (localObject1 != null)
        {
          this.jdField_a_of_type_Behu.a(((TroopInfo)localObject1).dwGroupClassExt, true, this, this.sessionInfo.curFriendUin);
          this.n = this.app.getCurrentAccountUin().equalsIgnoreCase(((TroopInfo)localObject1).troopowneruin);
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.tag, 2, "doOnPause, isTroopOwner =" + this.n + ",troopInfo = " + localObject1);
        }
        K();
        J();
        localObject1 = (aqdf)apub.a().a(553);
        if ((localObject1 != null) && (!((aqdf)localObject1).jdField_a_of_type_Boolean))
        {
          this.mTitleBtnCall.setVisibility(8);
          this.mTitleBtnCall.setOnClickListener(null);
        }
        V();
        localObject1 = this.mActivity.getIntent();
        this.m = ((Intent)localObject1).getBooleanExtra("open_chat_from_group_rec_confess", false);
        if (this.m)
        {
          c((Intent)localObject1);
          b(this.sessionInfo.curFriendUin);
        }
        this.sessionInfo.isFromGroupRecConfess = this.m;
        c(false);
        super.onShowFirst(paramInt);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
        label843:
        if (QLog.isColorLevel())
        {
          QLog.d(this.tag, 2, "onShowFirst : invalid uin!");
          localObject2 = localObject3;
          continue;
          bcef.b(null, "CliOper", "", "", "0X80066BF", "0X80066BF", 0, 0, "", "", "", "");
          continue;
          label731:
          if (((lms)localObject2).jdField_a_of_type_Int == 10)
          {
            if (((lms)localObject2).jdField_a_of_type_Boolean) {
              bcef.b(null, "CliOper", "", "", "0X80066C1", "0X80066C1", 0, 0, "", "", "", "");
            }
            for (;;)
            {
              this.app.getAVNotifyCenter().a(Long.valueOf(this.sessionInfo.curFriendUin).longValue(), 1);
              break;
              bcef.b(null, "CliOper", "", "", "0X80066BE", "0X80066BE", 0, 0, "", "", "", "");
            }
            this.jdField_c_of_type_Int = (this.mContent.getHeight() - this.mCustomTitleView.getHeight() - this.mInputBar.getHeight() - this.panelicons.getHeight());
            localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetScrollView.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject2).height = this.jdField_c_of_type_Int;
            ((RelativeLayout.LayoutParams)localObject2).bottomMargin = (this.mInputBar.getHeight() + this.panelicons.getHeight());
            this.jdField_a_of_type_AndroidWidgetScrollView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            this.jdField_a_of_type_AndroidWidgetScrollView.removeAllViews();
            this.jdField_a_of_type_AndroidWidgetScrollView.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, -1, this.jdField_c_of_type_Int);
          }
        }
      }
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (BaseChatpieHelper.a(this.mFunBtn, paramCharSequence, this.sessionInfo.curType))
    {
      this.sessionInfo.debugFilterMemberMsgCommand = true;
      e(1);
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d(this.tag, 2, " onTextChanged:  start=" + paramInt1 + " before=" + paramInt2 + " count=" + paramInt3);
        }
      } while ((this.sessionInfo.curType != 1) || (this.sessionInfo.curFriendUin == null) || (this.sessionInfo.curFriendUin.length() == 0));
      if (!a(paramCharSequence, paramInt1, paramInt3)) {
        break;
      }
    } while (TroopInfo.isQidianPrivateTroop(this.app, this.sessionInfo.curFriendUin));
    paramInt2 = 0;
    for (;;)
    {
      if (paramInt2 >= paramCharSequence.length()) {
        break label182;
      }
      if ((paramInt2 != paramInt1) && (a(paramCharSequence, paramInt2))) {
        break;
      }
      paramInt2 += 1;
    }
    label182:
    a(((TroopManager)this.app.getManager(52)).b(this.sessionInfo.curFriendUin));
    return;
    if ((!this.isBeingInputDraft) && (!((afsd)getHelper(27)).jdField_a_of_type_Boolean)) {
      ((afoh)getHelper(34)).b(paramCharSequence, paramInt1, paramInt2, paramInt3);
    }
    q();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.mAIOGiftPanelContainer != null) && (this.mAIOGiftPanelContainer.a()))
    {
      this.mAIOGiftPanelContainer.a();
      amat.a(this.app, "troop_gift_panel", false);
    }
    if ((paramView.getId() == 2131370017) && (this.mScrollerRunnable != null)) {
      this.mScrollerRunnable.b();
    }
    return super.onTouch(paramView, paramMotionEvent);
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    ((TroopManager)this.app.getManager(52)).h(this.sessionInfo.curFriendUin);
    return super.onViewCompleteVisableAndReleased(paramInt, paramView, paramListView);
  }
  
  public void openOptionActivity()
  {
    Object localObject1;
    Object localObject2;
    int i1;
    if ((this.mTitleBtnRightRedTip != null) && (this.mTitleBtnRightRedTip.getVisibility() == 0))
    {
      localObject1 = (TroopManager)this.app.getManager(52);
      if (localObject1 == null) {
        break label195;
      }
      localObject1 = ((TroopManager)localObject1).b(this.sessionInfo.curFriendUin);
      if (localObject1 == null) {
        break label195;
      }
      localObject2 = this.app.getCurrentAccountUin();
      if ((android.text.TextUtils.isEmpty((CharSequence)localObject2)) || (android.text.TextUtils.isEmpty(((TroopInfo)localObject1).Administrator))) {
        break label195;
      }
      if ((!((String)localObject2).equals(((TroopInfo)localObject1).Administrator)) && (!((TroopInfo)localObject1).Administrator.contains((CharSequence)localObject2))) {
        break label183;
      }
      i1 = 1;
    }
    for (;;)
    {
      localObject2 = this.app;
      String str = this.sessionInfo.curFriendUin;
      if (i1 != 0) {}
      for (localObject1 = "0";; localObject1 = "1")
      {
        bcef.b((QQAppInterface)localObject2, "P_CliOper", "Grp_set", "", "AIOchat", "Clk_dataEntry_new", 0, 0, str, (String)localObject1, "", "");
        VasWebviewUtil.reportCommercialDrainage("", "style", "0X8008E61", "", 1, 0, 0, "", "", "");
        T();
        return;
        label183:
        i1 = 0;
        break;
      }
      label195:
      i1 = 0;
    }
  }
  
  public void p()
  {
    if ((this.mProgressDialog != null) && (this.mProgressDialog.isShowing()) && (!getActivity().isFinishing())) {
      this.mProgressDialog.dismiss();
    }
  }
  
  protected void q()
  {
    Object localObject1 = (bfdm)this.app.getManager(203);
    Object localObject2;
    String str1;
    int i1;
    boolean bool;
    if (((bfdm)localObject1).a(this.sessionInfo.curFriendUin)) {
      if (!this.h)
      {
        localObject2 = (bevq[])this.input.getEditableText().getSpans(0, this.input.getEditableText().toString().length(), bevq.class);
        str1 = this.sessionInfo.curFriendUin;
        i1 = 0;
        if (i1 >= localObject2.length) {
          break label439;
        }
        if (!((bfdm)localObject1).b(localObject2[i1].a())) {
          break label247;
        }
        String str2 = localObject2[i1].a();
        this.jdField_b_of_type_JavaLangString = str2;
        ((bfdm)localObject1).jdField_e_of_type_JavaLangString = str2;
        this.jdField_c_of_type_JavaLangString = localObject2[i1].b();
        if (!this.jdField_c_of_type_JavaLangString.startsWith("@")) {
          break label434;
        }
        this.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString.substring(1);
        bool = true;
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a() != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a().equals(this.jdField_b_of_type_JavaLangString))) {
        bool = false;
      }
      for (;;)
      {
        ((afss)getHelper(29)).d(bool);
        if (this.g == bool) {
          if (bool)
          {
            localObject1 = (aftj)getHelper(23);
            if (localObject1 != null) {
              ((aftj)localObject1).b(this.input.getLineCount());
            }
          }
        }
        label247:
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                i1 += 1;
                break;
                this.g = bool;
                if (bool) {
                  break label364;
                }
                d(false);
                localObject2 = (aftj)getHelper(23);
                if (localObject2 != null) {
                  ((aftj)localObject2).a(false);
                }
              } while (!((bfdm)localObject1).a());
              ((bfdm)localObject1).a();
              bfdm.a("panel", "talk_out", this.sessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a(), "2", "");
              ((bfdm)localObject1).b(Long.parseLong(this.sessionInfo.curFriendUin), Long.parseLong(this.jdField_b_of_type_JavaLangString), "off", new afkj(this));
              return;
            } while (this.f);
            this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a(str1, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this, new afkk(this));
            return;
          } while (!this.f);
          d(false);
          localObject1 = (aftj)getHelper(23);
        } while (localObject1 == null);
        label364:
        ((aftj)localObject1).a(false);
        return;
      }
      label434:
      bool = true;
      continue;
      label439:
      bool = false;
    }
  }
  
  public void r()
  {
    if (this.mTitleCount == null) {
      this.mTitleCount = ((TextView)this.mTitleLayout.findViewById(2131365635));
    }
    Object localObject = ((TroopManager)this.app.getManager(52)).c(this.sessionInfo.curFriendUin);
    if ((localObject == null) || (((TroopInfo)localObject).wMemberNumClient <= 0))
    {
      this.mTitleCount.setVisibility(8);
      if (QLog.isColorLevel())
      {
        if (localObject != null) {
          QLog.d(this.tag, 2, "showNewTroopMemberCount count smaller than 0" + ((TroopInfo)localObject).wMemberNumClient);
        }
      }
      else {
        return;
      }
      QLog.d(this.tag, 2, "showNewTroopMemberCount info is null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "showNewTroopMemberCount wMemberNumClient:" + ((TroopInfo)localObject).wMemberNumClient + "  wMemberNum:" + ((TroopInfo)localObject).wMemberNum + " troopUin:" + ((TroopInfo)localObject).troopuin);
    }
    this.mTitleCount.setText(String.format("(%d)", new Object[] { Integer.valueOf(((TroopInfo)localObject).wMemberNumClient) }));
    if (this.mTitleCount.getVisibility() != 0)
    {
      this.mTitleCount.setVisibility(0);
      this.mTitleCount.setGravity(16);
      if (this.mCustomTitleView != null)
      {
        localObject = this.mCustomTitleView;
        if (this.speakerPhoneOn) {
          break label284;
        }
      }
    }
    label284:
    for (boolean bool = true;; bool = false)
    {
      ((NavBarAIO)localObject).a(bool, this.sessionInfo.curType);
      a(this.sessionInfo.curFriendUin, false);
      return;
    }
  }
  
  public void removeBusinessObservers()
  {
    super.removeBusinessObservers();
    this.app.removeObserver(this.jdField_a_of_type_Amwl);
    this.app.removeObserver(this.jdField_a_of_type_Andd);
    this.app.removeObserver(this.jdField_a_of_type_Amsu);
    this.app.removeObserver(this.jdField_a_of_type_Amop);
    this.app.removeObserver(this.jdField_a_of_type_Anam);
    this.app.removeObserver(this.jdField_a_of_type_Andl);
    this.app.removeObserver(this.jdField_a_of_type_Bcvj);
    this.app.unRegistObserver(this.jdField_a_of_type_Bduz);
    if (this.app.getProxyManager() != null) {
      this.app.getProxyManager().removeProxyObserver(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    ((aubl)this.app.getManager(156)).a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  public void returnMainFragment()
  {
    if (((this.mActivity instanceof SplashActivity)) && (this.mGiftAnimationController != null)) {
      this.mGiftAnimationController.c();
    }
    super.returnMainFragment();
  }
  
  public void s()
  {
    if ((this.mSubTitleLeftImageView == null) || (this.mSubTilteText == null) || (this.mSubTitleLayout == null) || (this.mTitleText == null)) {
      return;
    }
    Object localObject = (avcl)getHelper(33);
    boolean bool1 = ((avcl)localObject).c();
    boolean bool2 = ((avcl)localObject).d();
    afsw localafsw = (afsw)getHelper(43);
    boolean bool4 = localafsw.c();
    ahql localahql = (ahql)getHelper(75);
    boolean bool3 = localahql.d();
    bkjp localbkjp = (bkjp)getHelper(81);
    boolean bool5 = localbkjp.d();
    int i1;
    if (bool1)
    {
      a(3);
      setSubTitleVisable(true);
      this.mSubTilteText.setText(((avcl)localObject).a(bool2));
      this.mSubTilteText.setTextColor(this.mActivity.getResources().getColor(2131167009));
      a(bool2);
      i1 = AIOUtils.dp2px(8.0F, this.mSubTilteText.getResources());
      avca.a(this.mSubTitleLayout, 0, i1, 0, 0, this.mAIORootView.getRootView());
    }
    for (;;)
    {
      localbkjp.b();
      if ((!QLog.isColorLevel()) || (!QLog.isColorLevel())) {
        break;
      }
      QLog.d("BaseListenTogetherPanel_Troop", 2, "togetherTime=" + bool1 + ",hasPannelShow" + bool2);
      return;
      if (bool4)
      {
        bool3 = localafsw.a();
        a(4);
        setSubTitleVisable(true);
        this.mSubTilteText.setText(localafsw.a());
        this.mSubTilteText.setTextColor(this.mActivity.getResources().getColor(2131167009));
        a(bool3);
        i1 = AIOUtils.dp2px(8.0F, this.mSubTilteText.getResources());
        avca.a(this.mSubTitleLayout, 0, i1, 0, 0, this.mAIORootView.getRootView());
      }
      else if (bool3)
      {
        a(5);
        setSubTitleVisable(true);
        bool4 = localahql.a();
        this.mSubTilteText.setText(localahql.a(bool4));
        this.mSubTilteText.setTextColor(this.mActivity.getResources().getColor(2131167009));
        a(bool4);
        i1 = AIOUtils.dp2px(8.0F, this.mSubTilteText.getResources());
        avca.a(this.mSubTitleLayout, 0, i1, 0, 0, this.mAIORootView.getRootView());
        if (QLog.isColorLevel()) {
          QLog.d("StudyRoomTipBarHelper", 2, "onSubTitleChanged. showStudyRoomTime=" + bool3 + ",isTipsShow=" + bool4);
        }
      }
      else
      {
        if (!bool5) {
          break label498;
        }
        a(localbkjp, bool5);
      }
    }
    label498:
    localObject = ((bfkq)this.app.getManager(234)).a(getSessionInfo().curFriendUin);
    if (!android.text.TextUtils.isEmpty((CharSequence)localObject))
    {
      a(2);
      setSubTitleVisable(true);
      this.mSubTilteText.setText((CharSequence)localObject);
      this.mSubTilteText.setTextColor(this.mActivity.getResources().getColor(2131167009));
      this.mSubTitleLeftImageView.setVisibility(0);
      c(false);
    }
    for (;;)
    {
      avca.a(this.mSubTitleLayout, this.mAIORootView.getRootView());
      break;
      this.mSubTilteText.setText("");
      a(0);
    }
  }
  
  public void send()
  {
    if (a(true)) {
      return;
    }
    bfdm localbfdm = (bfdm)this.app.getManager(203);
    boolean bool2 = localbfdm.a();
    Object localObject = localbfdm.jdField_b_of_type_JavaLangString;
    String str1 = localbfdm.jdField_c_of_type_JavaLangString;
    this.h = true;
    ArrayList localArrayList = new ArrayList();
    String str2 = bevq.a(this.input.getEditableText(), localArrayList);
    int i1 = 0;
    label198:
    boolean bool3;
    if (i1 < localArrayList.size())
    {
      MessageForText.AtTroopMemberInfo localAtTroopMemberInfo = (MessageForText.AtTroopMemberInfo)localArrayList.get(i1);
      if (localbfdm.a(localAtTroopMemberInfo.uin))
      {
        localObject = "" + localAtTroopMemberInfo.uin;
        str1 = ContactUtils.getTroopMemberName(this.app, this.sessionInfo.curFriendUin, (String)localObject);
        if ((bool2) || (localbfdm.a(str2, "" + localAtTroopMemberInfo.uin, this.sessionInfo.curFriendUin)))
        {
          bool1 = true;
          bool3 = localbfdm.b(str2, "" + localAtTroopMemberInfo.uin, this.sessionInfo.curFriendUin);
          bool2 = bool1;
        }
      }
    }
    for (boolean bool1 = bool3;; bool1 = false)
    {
      super.send();
      if ((bool2) && (!bool1))
      {
        localObject = bevq.a(this.app, this.mContext, this.sessionInfo.curFriendUin, (String)localObject, str1, false, this.input, true);
        this.input.setText((CharSequence)localObject);
        this.input.append(" ");
        this.input.setSelection(this.input.getText().length());
        a(localbfdm.jdField_b_of_type_JavaLangString, localbfdm.jdField_c_of_type_JavaLangString, true, 0);
      }
      for (;;)
      {
        this.h = false;
        return;
        bool1 = false;
        break label198;
        i1 += 1;
        break;
        agsn.a(this.app, str2, localArrayList, this.sessionInfo.curFriendUin);
        if ((str2 == null) || (str2.length() <= 3478)) {
          this.input.setText("");
        }
        if (this.f)
        {
          d(false);
          localObject = (aftj)getHelper(23);
          if (localObject != null) {
            ((aftj)localObject).a(false);
          }
        }
        this.g = false;
        localbfdm.a();
      }
    }
  }
  
  protected void sendPttInner(String paramString, long paramLong, int paramInt1, int paramInt2, QQRecorder.RecorderParam paramRecorderParam, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    if ((paramInt1 == 2) || (paramInt1 == 1))
    {
      i1 = 1;
      if (paramRecorderParam.jdField_a_of_type_JavaLangObject != null) {
        break label130;
      }
    }
    long l2;
    int i2;
    String str1;
    Object localObject;
    label130:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "sendPttInner(),recordingUniseq is:" + paramLong + ",path is:" + paramString);
      }
      l2 = SystemClock.uptimeMillis();
      i2 = this.sessionInfo.curType;
      str1 = this.sessionInfo.curFriendUin;
      if (i1 != 0) {
        break label482;
      }
      localObject = acvv.a(this.app, paramString, this.sessionInfo, -2, paramRecorderParam.jdField_c_of_type_Int);
      if (localObject != null) {
        break label136;
      }
      return;
      i1 = 0;
      break;
    }
    label136:
    ((MessageForPtt)localObject).c2cViaOffline = bool1;
    if (!StringUtil.isEmpty(paramRecorderParam.jdField_a_of_type_JavaLangString)) {
      ((MessageForPtt)localObject).sttText = paramRecorderParam.jdField_a_of_type_JavaLangString;
    }
    long l1 = ((MessageRecord)localObject).uniseq;
    PttInfoCollector.sPttSendCostRecorder.put(paramString, Long.valueOf(l2));
    if (!bool1)
    {
      bcgn.a(paramString, false);
      bcgn.a(paramString);
      label204:
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "recordingUniseq is:" + l1);
      }
      localObject = this.app;
      if (!isStraightPtt) {
        break label567;
      }
    }
    label567:
    for (int i1 = 1;; i1 = 2)
    {
      bcef.b((QQAppInterface)localObject, "CliOper", "", "", "0X8005B57", "0X8005B57", i1, 0, "", "", "", "8.4.8");
      isStraightPtt = true;
      i1 = getAudioPanelType(paramInt1);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("DiyTextId", paramRecorderParam.jdField_e_of_type_Int);
      ArrayList localArrayList = new ArrayList();
      String str2 = bevq.a(this.input.getEditableText(), localArrayList);
      bfdm localbfdm = (bfdm)this.app.getManager(203);
      boolean bool3 = false;
      boolean bool2 = bool3;
      if (this.f)
      {
        Iterator localIterator = localArrayList.iterator();
        do
        {
          bool2 = bool3;
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!localbfdm.a(((MessageForText.AtTroopMemberInfo)localIterator.next()).uin));
        bool2 = true;
      }
      acvv.a(this.app, i2, str1, paramString, l1, false, paramInt2, paramRecorderParam.jdField_c_of_type_Int, bool1, paramInt3, i1, paramBoolean, paramRecorderParam.jdField_d_of_type_Int, (Bundle)localObject, localArrayList, str2, bool2, paramInt4);
      reportSendPttEvent(paramInt1, paramInt2);
      checkOrUpdatePttRecord(0, paramString, l1);
      return;
      label482:
      localObject = this.app.getMessageFacade().getMsgItemByUniseq(str1, 0, paramLong);
      l1 = paramLong;
      if (!MessageForPtt.class.isInstance(localObject)) {
        break;
      }
      ((MessageForPtt)localObject).voiceLength = QQRecorder.a(paramInt2);
      l1 = paramLong;
      if (StringUtil.isEmpty(paramRecorderParam.jdField_a_of_type_JavaLangString)) {
        break;
      }
      ((MessageForPtt)localObject).sttText = paramRecorderParam.jdField_a_of_type_JavaLangString;
      l1 = paramLong;
      break;
      azbu.b(paramString);
      break label204;
    }
  }
  
  protected void setLastAudioPanelType(int paramInt)
  {
    if (!this.jdField_d_of_type_Boolean) {
      super.setLastAudioPanelType(paramInt);
    }
  }
  
  public void setLeftTitleToCancle(ChatMessage paramChatMessage)
  {
    super.setLeftTitleToCancle(paramChatMessage);
    adjustTitleDimension();
    this.mTitleBtnRightSearch.setVisibility(0);
  }
  
  protected void setList(List<ChatMessage> paramList, CharSequence paramCharSequence, int paramInt)
  {
    TroopUtils.insertHistoryGrayTips(this.app, this.sessionInfo.curFriendUin, paramList);
    this.helperProvider.a(1, this, paramList);
    super.setList(paramList, paramCharSequence, paramInt);
    if ((0xFFFF & paramInt) == 4)
    {
      ((bdzb)this.app.getManager(225)).a(paramList);
      if (this.mTroopTips != null) {
        this.mTroopTips.a().f();
      }
    }
  }
  
  public void setTag()
  {
    this.tag = "TroopChatPie";
  }
  
  public void showGiftPanel(boolean paramBoolean)
  {
    if (bfyz.m(this.mContext, this.app.getCurrentAccountUin()))
    {
      showGiftPanel(paramBoolean, TroopGiftPanel.f);
      bfyz.k(this.mContext, this.app.getCurrentAccountUin(), false);
      return;
    }
    showGiftPanel(paramBoolean, TroopGiftPanel.jdField_e_of_type_Int);
  }
  
  protected void showZhituAfterDraft()
  {
    showZhituIcon();
  }
  
  public void stopAudioRecord(int paramInt)
  {
    if ((this.recorder != null) && (!this.recorder.b()) && (!this.uiHandler.hasMessages(16711686)))
    {
      this.uiHandler.removeMessages(16711688);
      this.uiHandler.removeMessages(16711686);
      this.uiHandler.removeMessages(16711687);
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "stopRecord() is called,time is:" + System.currentTimeMillis());
      }
      this.fateOfRecorder = paramInt;
      if (!this.o) {
        break label135;
      }
      this.recorder.c();
      bftt.a(this.mActivity.getApplicationContext(), false);
      a(true);
    }
    label135:
    while (this.recorder == null) {
      return;
    }
    Message localMessage = this.uiHandler.obtainMessage(16711686);
    this.uiHandler.sendMessageDelayed(localMessage, 200L);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (QLog.isColorLevel()) {
      QLog.i(this.tag, 2, "update");
    }
    if (paramObject == null) {
      break label27;
    }
    label27:
    label233:
    for (;;)
    {
      return;
      if ((!(paramObject instanceof bfdb)) || (!a((bfdb)paramObject)))
      {
        if ((paramObject instanceof MessageRecord)) {
          b(paramObject);
        }
        for (;;)
        {
          if (!(paramObject instanceof MessageForText)) {
            break label233;
          }
          paramObservable = (MessageForText)paramObject;
          if (!paramObservable.frienduin.equals(this.sessionInfo.curFriendUin)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("AioVipKeywordHelper", 4, "detectKeyword in TroopChatPie.update()");
          }
          bgny.a().a(this.app, this.sessionInfo, paramObservable, paramObservable.msg, this.mContext, paramObservable.isSend());
          return;
          if ((paramObject instanceof bdyo)) {
            a(paramObject);
          } else if ((paramObject instanceof Integer)) {
            switch (((Integer)paramObject).intValue())
            {
            case 123321: 
            default: 
              break;
            case 123322: 
              if ((this.jdField_a_of_type_Bequ != null) && (this.jdField_a_of_type_Bequ.a())) {
                this.mScrollerRunnable.a(1, this.jdField_a_of_type_Bequ.a() / 2);
              } else {
                this.mScrollerRunnable.a(1);
              }
              break;
            }
          }
        }
      }
    }
  }
  
  protected void updateSession_business(Intent paramIntent)
  {
    super.updateSession_business(paramIntent);
    bfzg.a(null, "AIO_updateSession_business");
    if ((this.sessionInfo.troopUin == null) || (this.sessionInfo.troopUin.length() == 0))
    {
      paramIntent = ((TroopManager)this.app.getManager(52)).b(this.sessionInfo.curFriendUin);
      if (paramIntent != null) {
        this.sessionInfo.troopUin = paramIntent.troopcode;
      }
    }
    this.jdField_b_of_type_Int = 2;
    bfzg.a("AIO_updateSession_business", null);
  }
  
  public void updateSession_updateTitle(Intent paramIntent)
  {
    super.updateSession_updateTitle(paramIntent);
    M();
  }
  
  public void updateSession_updateTitleBtnCall()
  {
    adjustTitleDimension();
    ((afsw)getHelper(43)).g();
    ((afqa)getHelper(85)).a(false);
  }
  
  protected void updateSession_updateTitleLeftView(Intent paramIntent)
  {
    super.updateSession_updateTitleLeftView(paramIntent);
    if (this.jdField_d_of_type_Boolean) {
      if (this.mTitleBtnLeft.getVisibility() == 0)
      {
        this.mTitleBtnLeft.setBackgroundResource(2130843695);
        this.mTitleBtnLeft.setTextColor(nmy.jdField_c_of_type_Int);
        this.mTitleBubbleLeft.setTextColor(nmy.jdField_c_of_type_Int);
      }
    }
    do
    {
      do
      {
        return;
      } while (this.mDefaultLeftBack.getVisibility() != 0);
      this.mDefaultLeftBack.setBackgroundResource(2130850594);
      this.mDefautlBtnLeft.setTextColor(nmy.jdField_c_of_type_Int);
      return;
      if (this.mTitleBtnLeft.getVisibility() == 0)
      {
        this.mTitleBtnLeft.setBackgroundResource(2130850593);
        this.mTitleBtnLeft.setTextColor(this.mActivity.getResources().getColor(2131167006));
        this.mTitleBubbleLeft.setTextColor(this.mActivity.getResources().getColor(2131167006));
        return;
      }
    } while (this.mDefaultLeftBack.getVisibility() != 0);
    this.mDefaultLeftBack.setBackgroundResource(2130850594);
    this.mDefaultLeftBack.setPadding(0, 0, 0, 0);
    this.mDefautlBtnLeft.setTextColor(this.mActivity.getResources().getColor(2131167006));
  }
  
  public void updateSession_updateTitleRightView()
  {
    TroopManager localTroopManager = (TroopManager)this.app.getManager(52);
    if ((localTroopManager != null) && (localTroopManager.h(this.sessionInfo.curFriendUin)))
    {
      this.mTitleBtnRight.setVisibility(8);
      return;
    }
    if ((this.jdField_d_of_type_Boolean) || (this.jdField_e_of_type_Boolean)) {
      this.mTitleBtnRight.setImageResource(2130843691);
    }
    for (;;)
    {
      this.mTitleBtnRight.setVisibility(0);
      return;
      updateViewForTheme(this.mTitleBtnRight, 2130850050, 2130850051);
    }
  }
  
  public void updateSession_updateUI(Intent paramIntent)
  {
    a(0);
    if ((this.jdField_d_of_type_Boolean) && (!nmy.a().a(this.sessionInfo.curFriendUin)))
    {
      b(false);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    String str1;
    String str2;
    int i1;
    for (;;)
    {
      if ((this.jdField_d_of_type_Boolean) && (nmy.a().a(this.sessionInfo.curFriendUin))) {
        this.mSubTilteText.setText(this.mActivity.getResources().getString(2131690015) + nmy.a().a(this.sessionInfo.curFriendUin).jdField_a_of_type_JavaLangString);
      }
      super.updateSession_updateUI(paramIntent);
      str1 = paramIntent.getStringExtra("greetingsTitle");
      str2 = paramIntent.getStringExtra("greetingsContent");
      i1 = paramIntent.getIntExtra("types", 0);
      if (i1 == 1)
      {
        Object localObject1 = paramIntent.getStringExtra("greetingsMembers");
        if (localObject1 != null) {
          try
          {
            localObject1 = new JSONArray((String)localObject1);
            i1 = 0;
            for (;;)
            {
              if (i1 < ((JSONArray)localObject1).length())
              {
                Object localObject3 = ((JSONArray)localObject1).getString(i1);
                String str3 = ContactUtils.getTroopMemberNameWithoutRemark(this.app, this.sessionInfo.curFriendUin, (String)localObject3);
                localObject3 = bevq.a(this.app, this.mContext, this.sessionInfo.curFriendUin, (String)localObject3, str3, false, this.input, true);
                if ((localObject3 != null) && (((SpannableString)localObject3).length() != 0)) {
                  this.input.getEditableText().insert(0, (CharSequence)localObject3);
                }
                i1 += 1;
                continue;
                if (!nmy.a().a(this.sessionInfo.curFriendUin)) {
                  break;
                }
                b(true);
                this.afRoot.setBackgroundResource(2130843669);
                this.mCustomTitleView.setBackgroundResource(2130843675);
                this.jdField_a_of_type_AndroidViewView.setVisibility(0);
              }
            }
          }
          catch (JSONException localJSONException)
          {
            if (QLog.isColorLevel()) {
              QLog.e(this.tag, 2, "TroopChatPie send greetings.get members failed.");
            }
          }
        }
      }
    }
    for (;;)
    {
      Object localObject2;
      if (!android.text.TextUtils.isEmpty(str1))
      {
        localObject2 = (afsd)getHelper(27);
        if (localObject2 != null) {
          ((afsd)localObject2).a("0", str2, str1);
        }
      }
      if (paramIntent.getBooleanExtra("sendGift", false)) {
        showGiftPanel(true, TroopGiftPanel.f);
      }
      if ((this.sessionInfo.curType == 1) && (TroopInfo.isQidianPrivateTroop(this.app, this.sessionInfo.curFriendUin)) && (this.businessFooterDetector != null)) {
        this.businessFooterDetector.a();
      }
      this.mTitleBtnCall.setVisibility(8);
      ((afsw)getHelper(43)).g();
      ((afqa)getHelper(85)).a(false);
      return;
      if (i1 == 2)
      {
        localObject2 = paramIntent.getStringExtra("greetingsName");
        this.input.getEditableText().insert(0, "@" + (String)localObject2 + " ");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie
 * JD-Core Version:    0.7.0.1
 */